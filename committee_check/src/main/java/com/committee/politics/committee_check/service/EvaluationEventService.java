package com.committee.politics.committee_check.service;


import com.committee.politics.committee_check.vo.FunctionalUser;

import java.util.List;

/**
 *
 *
 * @author yaojunyi
 * @email yao_junyi@qq.com
 * @date 2021-06-14 15:07:44
 * 华数对应接口提供
 */
public interface EvaluationEventService {
    String  getUserByOrgid(String orgid);
    String getEventReportCount(String orgid, String month);

    String getEventDealCountUrl(String orgId, String month);

    String getUserYawpCountUrl(String orgId, String month);

    String getUserDealCountUrl(String orgId, String month);
}
