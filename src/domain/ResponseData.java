package domain;

import org.json.JSONObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseData extends JSONObject{
	@SerializedName("code")
    @Expose
    int code;

    @SerializedName("data")
    @Expose
    String data;

    public ResponseData(int code, String data) {
        this.code = code;
        this.data = data;
    }

    public ResponseData() {
	}

	public int getCode() {
        return code;
    }

    public String getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(String data) {
        this.data = data;
    }
}
