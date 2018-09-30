package com.github.chengzhx76.sms;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: hp
 * @date: 2018/9/30
 */
public class Task {

//    private static String url = "https://www.newup.net.cn/index/register/validate?u_asec=099%23KAFEwYEjEiIEhGTLEEEEEpEQz0yFD6DcSuiED6VEScv7W6AESr%2FFG6NJDZITEEySt3dEOyf%2BE7Eht3BlE6IPfYFE19inA3t9%2F3B96vMTEEvStZwlcyaDnntZE7EKt32EEJxdt3o%2BVEFETE1EbOKXE7EFEE1Cb4MTEEySl3llsyaUE7TxTJgOEFyU0HUAqm9pyUQA6NGbvFdlVaIaRJ9yk8lDqwP%2BM6A0pu7Gcv64JmDVrCT4kLNBC%2BwVoaSZ6baqKW6r2h5YwqVUPJK4IwHqLv8GfBjaydMTEHSEhsKW%2FqYWcR4f9BZLDRbB6sp3wWxp6sIWHQz6uVInqOId95WADOxVcOKc92iHbsp9rU4pU64QbzQMaquYSR4fNVX3LWc66spsrbQtrPdWHsFn97uvGL8BPw9R1WabE7EUt3ilfjKww4LStTwbsyaDBliSh3nP%2F3wIt37MlXZddqLStTEmsyanyXQTEEyZtY7EZQmoE7EIt37ENokPZE%2FuE7EFNIaHFf7TEEiStEE7uYFEw3iZIGwZ%2F3iStoUrlDQTEE7EERpC&u_atype=2";
    private static String url2 = "https://www.chenxunyun.com/user/live.asp";

    private static Map<String, String> headers = new HashMap<>();
    static {
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("Connection", "keep-alive");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    }

    public static void main(String[] args) {
        HttpUtils http = new HttpUtils();

        Map<String, String> params = new HashMap<>();
//        params.put("phone", "18600536683");
//        params.put("SendNum", "18600536683");


        http.post(url2, headers, params, HttpUtils.FORM_TYPE);

    }

}
