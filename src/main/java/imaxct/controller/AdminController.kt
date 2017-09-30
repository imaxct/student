package imaxct.controller

import imaxct.bean.Msg
import imaxct.dao.ISettingDao
import imaxct.domain.Course
import imaxct.domain.Setting
import imaxct.domain.User
import imaxct.service.IAdminService
import imaxct.service.ICourseService
import imaxct.util.AppConst
import net.sf.json.JSONArray
import net.sf.json.JSONObject
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.ModelAndView
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.Callable
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

/**
 * Created by imaxct on 17-4-30.
 * student
 */
@Controller
@RequestMapping("/A")
class AdminController {

    @Autowired
    private lateinit var adminService: IAdminService

    @Autowired
    private lateinit var settingDao: ISettingDao

    @Autowired
    private lateinit var courseService: ICourseService

    @GetMapping(value = "/main")
    fun main(): String = "A/main"

    @PostMapping(value = "/login")
    fun login(u: String, p: String, session: HttpSession): ModelAndView {
        val mav = ModelAndView("A/msg")
        val admin = adminService.login(u, p)
        if (admin != null) {
            mav.viewName = "redirect:main"
            session.setAttribute("admin", admin)
            mav.addObject("admin", admin)
            return mav
        }
        mav.addObject("msg", "登录失败")
        return mav
    }

    @GetMapping(value = "/logout")
    fun logout(req: HttpServletRequest): String {
        req.getSession(false)?.invalidate()
        return "redirect:/admin.jsp"
    }

    @GetMapping(value = "/upload")
    fun uploadFront(): String = "A/upload"

    @ResponseBody
    @PostMapping(value = "/upload")
    fun upload(file: MultipartFile, session: HttpSession): Map<String, JSONArray> {
        val dir = File("upload")
        if (!dir.exists()) {
            dir.mkdir()
        }
        val arr = JSONArray()
        println(file.originalFilename)
        val fName = UUID.randomUUID().toString()
        val nName = fName + file.originalFilename.substring(file.originalFilename.lastIndexOf('.'))
        val fullFile = File(dir, nName)
        file.transferTo(fullFile)
        val obj = JSONObject()
        obj.put("name", nName)
        arr.add(obj)
        session.setAttribute(AppConst.FILE_TOKEN, "${dir.absolutePath}/$nName")
        println(dir.absolutePath + nName)
        return mapOf("files" to arr)
    }

    @GetMapping(value = "/selectHead")
    fun selectHead(session: HttpSession): ModelAndView {
        val fileName: String = session.getAttribute(AppConst.FILE_TOKEN) as String?
            ?: return ModelAndView("A/msg", mapOf("msg" to "未发现上传文件"))
        val file = File(fileName)
        val mav = ModelAndView("A/import")
        val w: Workbook = WorkbookFactory.create(file)
        val sheet = w.getSheetAt(0)
        val row = sheet.getRow(0)
        val st = row.firstCellNum
        val ed = row.lastCellNum
        val map = hashMapOf<Int, String>()
        for (x in st until ed) {
            map[x] = row.getCell(x).toString()
        }
        mav.addObject("list", map)
        return mav
    }

    @ResponseBody
    @PostMapping(value = "/doIn")
    fun doImport(stuNo: Int, idNo: Int, sex: Int, grade: Int, name: Int, college: Int,
                 session: HttpSession): Callable<Msg<*>> {
        return Callable({
            val fileName = session.getAttribute(AppConst.FILE_TOKEN) as String
            session.removeAttribute(AppConst.FILE_TOKEN)
            if (fileName.isEmpty())
                Msg(-1, "未找到文件", null)
            val f = File(fileName)
            if (!f.exists() || f.canRead())
                Msg(-1, "文件不存在或无法读取", null)
            val workbook: Workbook = WorkbookFactory.create(f)
            val sheet: Sheet = workbook.getSheetAt(0)
            val list: MutableList<User> = mutableListOf()
            val startNum = sheet.firstRowNum + 1
            val endNum = sheet.lastRowNum
            for (x in startNum until endNum) {
                val row = sheet.getRow(x)
                val stn = row.getCell(stuNo).stringCellValue
                val idn = row.getCell(idNo).stringCellValue
                val se = row.getCell(sex).stringCellValue
                val grd = row.getCell(grade).stringCellValue
                val nm = row.getCell(name).stringCellValue
                val col = row.getCell(college).stringCellValue
                val u = User(stuNo = stn, idNo = idn, sex = se, grade = grd, name = nm, poor = true, college = col)
                list.add(u)
            }
            val msg = adminService.clearAllRecord()
            if (adminService.addUsers(list))
                Msg(0, "导入成功, ${msg.msg}", null)
            else
                Msg(-1, "导入失败, ${msg.msg}", null)
        })
    }

    @GetMapping(value = "/list")
    fun getCourseList(session: HttpSession): ModelAndView {
        val list = adminService.getCourses()
        val mav = ModelAndView("A/courseList")
        mav.addObject("list", list)
        return mav
    }

    @GetMapping(value = "/setting")
    fun setting(): ModelAndView {
        val mav = ModelAndView("A/setting")
        val list = settingDao.listSetting()
        for (l in list) mav.addObject(l.key, l.value)
        return mav
    }

    @ResponseBody
    @PostMapping(value = "/setting")
    fun updateSetting(key: String, value: String): Msg<*> {
        val s = Setting(key, value)
        if (settingDao.createOrUpdate(s))
            return Msg(0, "ok", null)
        return Msg(-1, "更新失败", null)
    }

    @GetMapping(value = "/exp")
    fun export(id: Int): ModelAndView {
        val mav = ModelAndView("A/exp")
        val course = courseService.getCourseById(id) ?: return ModelAndView("A/msg", mapOf("msg" to "错误"))
        val list = adminService.getUserByCourse(course)
        mav.addObject("list", list)
        return mav
    }

    @GetMapping(value = "/editor")
    fun editCourse(@RequestParam(required = false) id: String?): ModelAndView {
        val mav = ModelAndView("A/courseEditor")
        if (!id.isNullOrEmpty()) {
            val cid = Integer.parseInt(id)
            val c = courseService.getCourseById(cid)
            c?.description = c?.description?.replace("\n", "\\\n")
            mav.addObject("course", c)
        }
        return mav
    }

    @ResponseBody
    @PostMapping(value = "/editor")
    fun addOrEditCourse(endDate: String?, course: Course): Msg<*> {
        if (!endDate.isNullOrEmpty()) {
            val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
            course.endDate = sdf.parse(endDate)
        }
        return if (course.id != 0) {
            val oCourse = courseService.getCourseById(course.id)
            if (oCourse != null && oCourse.occupied > 0) {
                course.occupied = oCourse.occupied
            }
            if (courseService.updateCourse(course)) Msg(0, "ok", null)
            else Msg(-1, "更新失败", null)
        } else {
            courseService.addCourse(course)
        }
    }
}