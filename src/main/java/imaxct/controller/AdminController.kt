package imaxct.controller

import imaxct.bean.Msg
import imaxct.domain.User
import imaxct.service.IAdminService
import imaxct.util.AppConst
import net.sf.json.JSONArray
import net.sf.json.JSONObject
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.SessionAttributes
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.servlet.ModelAndView
import java.io.File
import java.util.*
import java.util.concurrent.Callable
import javax.annotation.Resource
import javax.servlet.http.HttpSession

/**
 * Created by imaxct on 17-4-30.
 * student
 */
@Controller
@RequestMapping("/A")
@SessionAttributes("admin")
class AdminController {

    @Resource
    var adminService: IAdminService? = null

    @RequestMapping(value = "/main")
    fun main(): String{
        return "A/main"
    }

    @RequestMapping(value = "/login", method = arrayOf(RequestMethod.POST))
    fun login(u: String, p: String, session: HttpSession): ModelAndView{
        val mav = ModelAndView("A/msg")
        val admin = adminService!!.login(u, p)
        if (admin != null){
            mav.viewName = "redirect:main"
            session.setAttribute("admin", admin)
            mav.addObject("admin", admin)
            return mav
        }
        mav.addObject("msg", "登录失败")
        return mav
    }

    @RequestMapping(value = "/upload")
    fun uploadFront(): String{
        return "A/upload"
    }

    /*@RequestMapping(value = "/upload", method = arrayOf(RequestMethod.POST))
    fun upload(req: MultipartHttpServletRequest, session: HttpSession): Map<String, JSONArray> {
        val it: Iterator<String> = req.fileNames
        var file: MultipartFile
        val arr: JSONArray = JSONArray()
        while (it.hasNext()){
            file = req.getFile(it.next())
            println(file.originalFilename)
            val fName = UUID.randomUUID().toString()
            val nName = fName + file.originalFilename.substring(file.originalFilename.lastIndexOf('.'))
            file.transferTo(File(nName))
            val obj: JSONObject = JSONObject()
            obj.put("name", nName)
            arr.add(obj)
            println(nName)
        }
        return mapOf("files" to arr)
    }*/

    @ResponseBody
    @RequestMapping(value = "/upload", method = arrayOf(RequestMethod.POST))
    fun upload(file: MultipartFile, session: HttpSession): Map<String, JSONArray> {
        val dir: File = File("upload")
        if (!dir.exists()){
            dir.createNewFile()
        }
        val arr: JSONArray = JSONArray()
        println(file.originalFilename)
        val fName = UUID.randomUUID().toString()
        val nName = fName + file.originalFilename.substring(file.originalFilename.lastIndexOf('.'))
        file.transferTo(File("${dir.name}/$nName"))
        val obj: JSONObject = JSONObject()
        obj.put("name", nName)
        arr.add(obj)
        session.setAttribute(AppConst.FILE_TOKEN, "${dir.absolutePath}/$nName")
        println(dir.absolutePath + nName)
        return mapOf("files" to arr)
    }

    @RequestMapping(value = "/selectHead")
    fun selectHead(session: HttpSession): ModelAndView{
        val fileName: String = session.getAttribute(AppConst.FILE_TOKEN) as String?
                ?: return ModelAndView("A/msg", mapOf("msg" to "未发现上传文件"))
        val file: File = File(fileName)
        val mav = ModelAndView("A/import")
        val w: Workbook = WorkbookFactory.create(file)
        val sheet = w.getSheetAt(0)
        val row = sheet.getRow(0)
        val st = row.firstCellNum
        val ed = row.lastCellNum
        val map = hashMapOf<Int, String>()
        for (x in st until ed){
            map[x] = row.getCell(x).toString()
        }
        mav.addObject("list", map)
        return mav
    }

    @ResponseBody
    @RequestMapping(value = "/doIn", method = arrayOf(RequestMethod.POST))
    fun doImport(stuNo: Int, idNo: Int, sex: Int, grade: Int, name: Int,
            session: HttpSession): Callable<Msg<*>>{
        return Callable({
            val fileName = session.getAttribute(AppConst.FILE_TOKEN) as String
            if (fileName.isNullOrEmpty())
                Msg(-1, "未找到文件", null)
            val f: File = File(fileName)
            if (!f.exists() || f.canRead())
                Msg(-1, "文件不存在或无法读取", null)
            val workbook: Workbook = WorkbookFactory.create(f)
            val sheet: Sheet = workbook.getSheetAt(0)
            val list: MutableList<User> = mutableListOf()
            val startNum = sheet.firstRowNum + 1
            val endNum = sheet.lastRowNum
            for (x in startNum until endNum){
                val row = sheet.getRow(x)
                val stn: String? = row.getCell(stuNo).stringCellValue
                val idn: String? = row.getCell(idNo).stringCellValue
                val se: String? = row.getCell(sex).stringCellValue
                val grd: String? = row.getCell(grade).stringCellValue
                val nm: String? = row.getCell(name).stringCellValue
                val u: User = User(stuNo = stn, idNo = idn, sex = se, grade = grd, name = nm)
                list.add(u)
            }

            Msg(0, "ok", null)
        })
    }

}