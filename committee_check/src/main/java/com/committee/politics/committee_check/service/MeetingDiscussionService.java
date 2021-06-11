package com.committee.politics.committee_check.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.committee.politics.committee_check.entity.MeetingDiscussionEntity;
import com.committee.politics.committee_check.utils.PageUtils;

import java.util.Map;

/**
 * 会商研讨录入
 *
 * @author yaojunyi
 * @email yao_junyi@qq.com
 * @date 2021-06-11 16:55:08
 */
public interface MeetingDiscussionService extends IService<MeetingDiscussionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

