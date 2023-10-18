package orderapp.orderapp.tools;

import orderapp.orderapp.Model.DTO.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseWriter {
    public static ResponseEntity<ResponseBody> write(Integer code, Boolean error, String message, Object data) {
        return new ResponseEntity<>(new ResponseBody(code, error, message, data), HttpStatus.valueOf(code));
    }

    public static ResponseEntity<ResponseBody> success(String message, Object data) {
        return write(200, false, message, data);
    }

    public static ResponseEntity<ResponseBody> created(String message, Object data) {
        return write(201, false, message, data);
    }

    public static ResponseEntity<ResponseBody> found(Object data) {
        return write(200, false, "Berhasil mendapatkan data", data);
    }
    public static ResponseEntity<ResponseBody> empty(Object data) {
        return write(404, true, "Data tidak ditemukan", data);
    }
    public static ResponseEntity<ResponseBody> fail(String message, Object data) {
        return write(500, true, message, data);
    }
    public static ResponseEntity<ResponseBody> invalid(String message, Object data) {
        return write(403, true, message, data);
    }
}
