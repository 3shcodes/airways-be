package str.project.airwaysbe.utils;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response<T> {
    T data;
    String msg;
    HttpStatus stat;
    boolean ok;

    public Response(T data, String msg, HttpStatus stat, boolean ok) {
        this.data=data;
        this.msg=msg;
        this.stat=stat;
        this.ok=ok;
    }

    public ResponseEntity<Object> send() {

        HashMap<String,Object> resp = new HashMap<String,Object>();
        resp.put("data", this.data);
        resp.put("msg", this.msg);
        resp.put("status", this.stat);
        resp.put("ok", this.ok);

        return new ResponseEntity<Object>(resp, stat);
    }


    public static ResponseEntity<Object> send(Object data, String msg, HttpStatus stat, boolean ok) {
        HashMap<String,Object> resp = new HashMap<String,Object>();
        resp.put("data", data);
        resp.put("msg", msg);
        resp.put("status", stat);
        resp.put("ok", ok);

        return new ResponseEntity<Object>(resp, stat);
    }
}
