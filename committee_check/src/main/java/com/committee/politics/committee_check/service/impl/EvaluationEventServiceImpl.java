package com.committee.politics.committee_check.service.impl;

import com.alibaba.fastjson.JSON;
import com.committee.politics.committee_check.service.EvaluationEventService;
import com.committee.politics.committee_check.utils.CALLR;
import com.committee.politics.committee_check.utils.HttpClientPost;
import com.committee.politics.committee_check.utils.MD5;
import com.committee.politics.committee_check.vo.FunctionalUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service("EvaluationEventService")
@Slf4j
public class EvaluationEventServiceImpl implements EvaluationEventService {

    @Value("${call-URL.baseUrl}")
    private String baseUrl;

    @Value("${call-URL.getUserByOrgIdUrl}")
    private String getUserByOrgIdUrl;

    @Value("${call-URL.getEventReportCountUrl}")
    private String getEventReportCountUrl;

    @Value("${call-URL.getEventDealCountUrl}")
    private String getEventDealCountUrl;

    @Value("${call-URL.getUserDealCountUrl}")
    private String getUserDealCountUrl;

    @Value("${call-URL.getUserYawpCountUrl}")
    private String getUserYawpCountUrl;

    @Value(value="call-parameters.version")
    private  String version;

    @Value(value="call-parameters.systemCode")
    private  String systemCode;

    @Value(value="${call-parameters.key}")
    private  String key;

    private String appendUrl() {
      String requestTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String sign = null;
        try {
            sign = MD5.encode(key+requestTime+version+systemCode);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        String url = "&sign="+sign+"&requestTime="+requestTime+"&systemCode="+systemCode+"&version="+version;
        return url;
    }


    /**
     * 4.1??????????????????????????????
     * @param orgid
     * @return
     */
    @Override
    public List<FunctionalUser> getUserByOrgid(String orgid){
        String url = "http://" + baseUrl + getUserByOrgIdUrl + "?orgid=" + orgid + this.appendUrl();
        String result = "";
        try {
            result = HttpClientPost.loadJson(url);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof FileNotFoundException){
                log.error("????????????????????????");
            }
            if(e instanceof UnknownHostException){
                log.error("??????IP??????????????????????????????ip??????");
            }
        }
        CALLR<FunctionalUser> R = JSON.parseObject(result,CALLR.class);
        if (!R.isResult()){
            log.error(R.getMessage());
            return null;
        }else {
            return R.getData();
        }
    }

    /**
     * 4.2???????????????????????????????????????????????????
     * @param orgId
     * @param month
     * @return
     */

    @Override
    public List<FunctionalUser> getEventReportCount(String orgId, String month){
        String url = "http://" + baseUrl + getEventReportCountUrl + "?orgid=" + orgId + "&month="+month + this.appendUrl();
        String result = "";
        try {
            result = HttpClientPost.loadJson(url);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof FileNotFoundException){
                log.error("????????????????????????");
            }
            if(e instanceof UnknownHostException){
                log.error("??????IP??????????????????????????????ip??????");
            }
        }
        CALLR<FunctionalUser> R = JSON.parseObject(result,CALLR.class);
        if (!R.isResult()){
            log.error(R.getMessage());
            return null;
        }else {
            return R.getData();
        }
    }

    /**
     * 4.3???????????????????????????????????????????????????
     * @param orgId
     * @param month
     * @return
     */
    @Override
    public List<FunctionalUser> getEventDealCountUrl(String orgId, String month){
        String url = "http://" + baseUrl + getEventDealCountUrl + "?orgid=" + orgId + "&month="+month + this.appendUrl();
        String result = "";
        try {
            result = HttpClientPost.loadJson(url);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof FileNotFoundException){
                log.error("????????????????????????");
            }
            if(e instanceof UnknownHostException){
                log.error("??????IP??????????????????????????????ip??????");
            }
        }
        CALLR<FunctionalUser> R = JSON.parseObject(result,CALLR.class);
        if (!R.isResult()){
            log.error(R.getMessage());
            return null;
        }else {
            return R.getData();
        }
    }

    /**
     * 4.4?????????????????????????????????????????????????????????
     * @param orgId
     * @param month
     * @return
     */

    @Override
    public List<FunctionalUser> getUserYawpCountUrl(String orgId, String month){
        String url = "http://" + baseUrl + getUserYawpCountUrl + "?orgid=" + orgId + "&month="+month + this.appendUrl();
        String result = "";
        try {
            result = HttpClientPost.loadJson(url);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof FileNotFoundException){
                log.error("????????????????????????");
            }
            if(e instanceof UnknownHostException){
                log.error("??????IP??????????????????????????????ip??????");
            }
        }
        CALLR<FunctionalUser> R = JSON.parseObject(result,CALLR.class);
        if (!R.isResult()){
            log.error(R.getMessage());
            return null;
        }else {
            return R.getData();
        }
    }

    /**
     * 4.5????????????????????????????????????????????????????????????????????????????????????
     * @param orgId
     * @param month
     * @return
     */
    @Override
    public List<FunctionalUser> getUserDealCountUrl(String orgId, String month){
        String url = "http://" + baseUrl + getUserDealCountUrl + "?orgid=" + orgId + "&month="+month + this.appendUrl();
        String result = "";
        try {
            result = HttpClientPost.loadJson(url);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof FileNotFoundException){
                log.error("????????????????????????");
            }
            if(e instanceof UnknownHostException){
                log.error("??????IP??????????????????????????????ip??????");
            }
        }
        CALLR<FunctionalUser> R = JSON.parseObject(result,CALLR.class);
        if (!R.isResult()){
            log.error(R.getMessage());
            return null;
        }else {
            return R.getData();
        }
    }

}
