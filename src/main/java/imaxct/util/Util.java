package imaxct.util;

import imaxct.bean.Msg;
import imaxct.domain.User;
import net.sf.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by imaxct on 17-4-25.
 * student
 */
public class Util {

    public static Msg<User> verify(String username, String password){
        try {
            Connection.Response response = Jsoup.connect("http://bkjws.sdu.edu.cn/b/ajaxLogin")
                    .data("j_username", username)
                    .data("j_password", password)
                    .cookie("j_username", username)
                    .cookie("j_password", password)
                    .method(Connection.Method.POST)
                    .timeout(0)
                    .ignoreContentType(true)
                    .validateTLSCertificates(false)
                    .execute();
            if (response.body().contains("success")){
                Map<String, String>cookies = response.cookies();
                response = Jsoup.connect("http://bkjws.sdu.edu.cn/b/grxx/xs/xjxx/detail")
                        .method(Connection.Method.POST)
                        .ignoreContentType(true)
                        .validateTLSCertificates(false)
                        .cookies(cookies)
                        .timeout(0)
                        .execute();
                if (!StringUtils.isEmpty(response.body())) {
                    JSONObject object = JSONObject.fromObject(response.body());
                    if ("success".equals(object.getString("result"))){
                        JSONObject obj = object.getJSONObject("object");
                        String name = obj.getString("xm");
                        String stuNo = obj.getString("xh");
                        String idNo = obj.getString("sfzh");
                        String sex = obj.getString("xb");
                        String grade = obj.getString("ssnj");
                        String phone = obj.getString("lxdh");
                        User user = new User();
                        user.setName(name); user.setStuNo(stuNo); user.setSex(sex);
                        user.setIdNo(idNo); user.setGrade(grade); user.setPhone(phone);
                        return new Msg<User>(0, null, user);
                    }
                }
                return new Msg<User>(null);
            }else {
                return new Msg<User>(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new Msg<User>(null);
        }
    }
}
