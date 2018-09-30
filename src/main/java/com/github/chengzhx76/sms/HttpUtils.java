package com.github.chengzhx76.sms;

import com.alibaba.fastjson.JSON;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @desc:
 * @author: hp
 * @date: 2018/9/30
 */
public class HttpUtils {

    final static String FORM_TYPE = "FORM";
    final static String JSON_TYPE = "JSON";
    final static String UTF_8 = "UTF-8";

    public void post(String url, Map<String, String> headers, Map<String, String> params, String reqType) {
        try {
            String content = Request
                .Post(url)
                .setHeaders(getHeaders(headers))
                .body(getEntity(params, reqType))
                .execute()
                .returnContent()
                .asString(Charset.forName(UTF_8));
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Header[] getHeaders(Map<String, String> map) {
        Header[] headers = new Header[map.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            headers[i] = new BasicHeader(entry.getKey(), entry.getValue());
            i++;
        }
        return headers;
    }

    private HttpEntity getEntity(Map<String, String> params, String reqType) {
        HttpEntity entity = null;
        if (FORM_TYPE.equals(reqType)) {
            List<NameValuePair> formParams = new ArrayList<>();
            for (Map.Entry<String, String> param : params.entrySet()) {
                formParams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
            }
            try {
                entity = new UrlEncodedFormEntity(formParams, UTF_8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else if (JSON_TYPE.equals(reqType)) {
            entity = new StringEntity(JSON.toJSONString(params), UTF_8);
        }
        return entity;
    }
}
