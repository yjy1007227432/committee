package com.committee.politics.committee_check.service.impl;

import com.committee.politics.committee_check.service.EvaluationEventService;
import com.committee.politics.committee_check.utils.HttpClientPost;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;

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
    public String getUserByOrgid(String orgid){
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
        return result;
    }

    /**
     * 4.2按镇街职能部门统计本月上报的事件数
     * @param orgId
     * @param month
     * @return
     */

    @Override
    public String getEventReportCount(String orgId, String month){
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
        return result;
    }

    /**
     * 4.3按镇街职能部门统计本月处理的事件数
     * @param orgId
     * @param month
     * @return
     */
    @Override
    public String getEventDealCountUrl(String orgId, String month){
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
        return result;
    }

    /**
     * 4.4按镇街职能部门人员统计本月事件处理总数
     * @param orgId
     * @param month
     * @return
     */

    @Override
    public String getUserYawpCountUrl(String orgId, String month){
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
        return result;
    }

    /**
     * 4.5按镇街职能部门人员统计本月事件处理总数及评价不满意事件数
     * @param orgId
     * @param month
     * @return
     */
    @Override
    public String getUserDealCountUrl(String orgId, String month){
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
        return result;
    }

}
