package imaxct.handler;

import imaxct.bean.Msg;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

/**
 * Created by imaxct on 17-4-25.
 * student
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Msg handleAllException(Exception e){
        System.out.println(e.getClass());
        e.printStackTrace();
        return new Msg("Access Denied.");
    }

    @ResponseBody
    @ExceptionHandler(SQLException.class)
    public Msg handleSQLException(){
        return new Msg("系统错误, 请求失败.");
    }

}