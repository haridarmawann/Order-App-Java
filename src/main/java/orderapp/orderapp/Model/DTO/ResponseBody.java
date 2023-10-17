package orderapp.orderapp.Model.DTO;


public class ResponseBody {
    private Integer code;
    private Boolean error;
    private String message;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseBody(Integer code, Boolean error, String message, Object data) {
        this.code = code;
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public ResponseBody(Integer code, Boolean error, String message) {
        this.code = code;
        this.error = error;
        this.message = message;
    }
}
