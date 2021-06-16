package com.committee.politics.committee_check.service.impl;

import com.committee.politics.committee_check.service.EvaluationEventService;
import com.committee.politics.committee_check.vo.FunctionalUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest()
class EvaluationEventServiceImplTest {
    @Autowired
    private EvaluationEventService evaluationEventService;
    @Test
    public void getUserByOrgid() {
        System.out.println(evaluationEventService.getUserByOrgid("lp0"));
    }
    @Test
    public void getEventReportCount() {
        System.out.println(evaluationEventService.getEventReportCount("lp0","202106"));
    }
    @Test
    public void getEventDealCountUrl() {
        System.out.println(evaluationEventService.getEventDealCountUrl("lp0","202106"));
    }
    @Test
    public void getUserDealCountUrl() {
        System.out.println(evaluationEventService.getUserDealCountUrl("lp0","202106"));
    }
    @Test
    public void getUserYawpCountUrl() {
        System.out.println(evaluationEventService.getUserYawpCountUrl("lp0","202106"));
    }

}