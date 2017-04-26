package imaxct.handler

import imaxct.bean.Msg
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

import java.sql.SQLException

/**
 * Created by imaxct on 17-4-25.
 * student
 */
@ControllerAdvice
class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception::class)
    fun handleAllException(e: Exception): Msg<*> = Msg<Int>("Access Denied.")

    @ResponseBody
    @ExceptionHandler(SQLException::class)
    fun handleSQLException(): Msg<*> = Msg<Int>("系统错误, 请求失败.")

}