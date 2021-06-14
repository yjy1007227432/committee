package com.committee.politics.committee_check.service.impl;

import com.committee.politics.committee_check.service.EvaluationEventService;
import com.committee.politics.committee_check.utils.HttpClientPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("EvaluationEventService")
public class EvaluationEventServiceImpl implements EvaluationEventService {

    @Value("${call-URL.baseUrl}")
    private String baseUrl;

    @Value("${call-URL.getUserByOrgIdUrl}")
    private String getUserByOrgIdUrl;

    @Override
    public String getUserByOrgid(String orgid) throws Exception {
        String url ="http://"+ baseUrl+getUserByOrgIdUrl + "?orgid=" + orgid;
        return HttpClientPost.loadJson(url);
    }
}
