package com.example.text;

import java.io.Serializable;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/11/2011:32
 * desc   :
 * package: Text:
 */
public class AdverReturn implements Serializable {

    private String RespCode;
    private String RespDesc;

    public String getRespCode() {
        return RespCode;
    }

    public void setRespCode(String respCode) {
        RespCode = respCode;
    }

    public String getRespDesc() {
        return RespDesc;
    }

    public void setRespDesc(String respDesc) {
        RespDesc = respDesc;
    }
}
