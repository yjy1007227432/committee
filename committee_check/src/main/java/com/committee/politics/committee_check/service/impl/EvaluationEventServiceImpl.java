package com.committee.politics.committee_check.service.impl;

import com.alibaba.fastjson.JSON;
import com.committee.politics.committee_check.service.EvaluationEventService;
import com.committee.politics.committee_check.utils.CALLR;
import com.committee.politics.committee_check.utils.HttpClientPost;
import com.committee.politics.committee_check.vo.FunctionalUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
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


    /**
     * 4.1查询职能部门用户信息
     * @param orgid
     * @return
     */
    @Override
    public List<FunctionalUser> getUserByOrgid(String orgid){
        String url = "http://" + baseUrl + getUserByOrgIdUrl + "?orgid=" + orgid;
        String result = "";
        try {
            result = HttpClientPost.loadJson(url);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof FileNotFoundException){
                log.error("调用接口路径错误");
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
     * 4.2按镇街职能部门统计本月上报的事件数
     * @param orgId
     * @param month
     * @return
     */

    @Override
    public List<FunctionalUser> getEventReportCount(String orgId, String month){
        String url = "http://" + baseUrl + getEventReportCountUrl + "?orgid=" + orgId + "&month="+month;
        String result = "";
        try {
            result = HttpClientPost.loadJson(url);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof FileNotFoundException){
                log.error("调用接口路径错误");
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
     * 4.3按镇街职能部门统计本月处理的事件数
     * @param orgId
     * @param month
     * @return
     */
    @Override
    public List<FunctionalUser> getEventDealCountUrl(String orgId, String month){
        String url = "http://" + baseUrl + getEventDealCountUrl + "?orgid=" + orgId + "&month="+month;
        String result = "";
        try {
            result = HttpClientPost.loadJson(url);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof FileNotFoundException){
                log.error("调用接口路径错误");
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
     * 4.4按镇街职能部门人员统计本月事件处理总数
     * @param orgId
     * @param month
     * @return
     */

    @Override
    public List<FunctionalUser> getUserYawpCountUrl(String orgId, String month){
        String url = "http://" + baseUrl + getUserYawpCountUrl + "?orgid=" + orgId + "&month="+month;
        String result = "";
        try {
            result = HttpClientPost.loadJson(url);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof FileNotFoundException){
                log.error("调用接口路径错误");
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
     * 4.5按镇街职能部门人员统计本月事件处理总数及评价不满意事件数
     * @param orgId
     * @param month
     * @return
     */
    @Override
    public List<FunctionalUser> getUserDealCountUrl(String orgId, String month){
        String url = "http://" + baseUrl + getUserDealCountUrl + "?orgid=" + orgId + "&month="+month;
        String result = "";
        try {
            result = HttpClientPost.loadJson(url);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof FileNotFoundException){
                log.error("调用接口路径错误");
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
