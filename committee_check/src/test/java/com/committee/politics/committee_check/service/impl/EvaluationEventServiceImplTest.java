package com.committee.politics.committee_check.service.impl;

import com.committee.politics.committee_check.service.EvaluationEventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest()
class EvaluationEventServiceImplTest {
    @Autowired
    private EvaluationEventService evaluationEventService;
    @Test
    public void getUserByOrgid() throws Exception {
        System.out.println(evaluationEventService.getUserByOrgid("lp1"));
    }
}