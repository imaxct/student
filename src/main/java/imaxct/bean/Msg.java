package imaxct.bean;

import java.io.Serializable;

/***
 * Created by imaxct on 17-4-15.
 */
public class Msg<T> implements Serializable{
    private int code = -1;

    private String msg = "";

    private T obj = null;

    public Msg(){}

    public Msg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Msg(String msg){
        this.msg = msg;
    }

    public Msg(int code, String msg, T obj){
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "[code="+code+", msg="+msg+", obj="+obj+"]";
    }
}
