package imaxct.util;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Created by imaxct on 17-4-25.
 * student
 */
public class Util {

    public static boolean verify(String username, String password){
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
            return response.body().contains("success");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
