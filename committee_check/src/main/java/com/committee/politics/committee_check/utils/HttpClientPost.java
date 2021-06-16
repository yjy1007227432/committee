package com.committee.politics.committee_check.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;



@Slf4j
@Component
@PropertySource({"classpath:application.yml"})
@ConfigurationProperties(prefix="call-parameters")
public class HttpClientPost {
    /**
     * 本平台提供给外部系统的API版本
     */
    public static String loadJson(String url) throws Exception {
        //读取url,返回json串
        StringBuilder json = new StringBuilder();
        URL oracle = new URL(url);
        log.info("调用接口"+url);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine = null;
        while((inputLine = in.readLine()) != null){
            json.append(inputLine);
        }
        in.close();

        return json.toString();
    }
}
