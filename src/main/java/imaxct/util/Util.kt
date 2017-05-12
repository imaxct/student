package imaxct.util

import imaxct.bean.Msg
import imaxct.domain.User
import net.sf.json.JSONObject
import org.apache.poi.xssf.binary.XSSFBUtils
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.springframework.util.StringUtils

import java.io.IOException

/**
 * Created by imaxct on 17-4-25.
 * student
 */
object Util {

    /**
     * 通过教务系统验证并获取用户信息
     * */
    fun verify(username: String, password: String): Msg<User> {
        try {
            var response: Connection.Response = Jsoup.connect("http://bkjws.sdu.edu.cn/b/ajaxLogin")
                    .data("j_username", username)
                    .data("j_password", password)
                    .cookie("j_username", username)
                    .cookie("j_password", password)
                    .method(Connection.Method.POST)
                    .timeout(0)
                    .ignoreContentType(true)
                    .validateTLSCertificates(false)
                    .execute()
            if (response.body().contains("success")) {
                val cookies = response.cookies()
                response = Jsoup.connect("http://bkjws.sdu.edu.cn/b/grxx/xs/xjxx/detail")
                        .method(Connection.Method.POST)
                        .ignoreContentType(true)
                        .validateTLSCertificates(false)
                        .cookies(cookies)
                        .timeout(0)
                        .execute()
                if (!StringUtils.isEmpty(response.body())) {
                    val o = JSONObject.fromObject(response.body())
                    if ("success" == o.getString("result")) {
                        val obj = o.getJSONObject("object")
                        val name = obj.getString("xm")
                        val stuNo = obj.getString("xh")
                        val idNo = obj.getString("sfzh")
                        val sex = obj.getString("xb")
                        val grade = obj.getString("ssnj")
                        val phone = obj.getString("lxdh")
                        val user = User()
                        user.name = name
                        user.stuNo = stuNo
                        user.sex = sex
                        user.idNo = idNo
                        user.grade = grade
                        user.phone = phone
                        return Msg(0, user)
                    }
                }
                return Msg("fail")
            } else {
                return Msg("fail")
            }
        } catch (e: IOException) {
            e.printStackTrace()
            return Msg("fail")
        }
    }
}
