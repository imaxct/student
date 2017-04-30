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
    fun handleAllException(e: Exception): Msg<*> {
        e.printStackTrace()
        return Msg<Int>("系统忙, 请稍候")
    }

    @ResponseBody
    @ExceptionHandler(SQLException::class)
    fun handleSQLException(): Msg<*> = Msg<Int>("系统错误, 请求失败.")

}