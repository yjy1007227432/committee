package com.committee.politics.committee_check.service.impl;

import com.committee.politics.committee_check.utils.Query;
import com.committee.politics.committee_check.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.committee.politics.committee_check.dao.MeetingDiscussionDao;
import com.committee.politics.committee_check.entity.MeetingDiscussionEntity;
import com.committee.politics.committee_check.service.MeetingDiscussionService;


@Service("meetingDiscussionService")
public class MeetingDiscussionServiceImpl extends ServiceImpl<MeetingDiscussionDao, MeetingDiscussionEntity> implements MeetingDiscussionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MeetingDiscussionEntity> page = this.page(
                new Query<MeetingDiscussionEntity>().getPage(params),
                new QueryWrapper<MeetingDiscussionEntity>()
        );

        return new PageUtils(page);
    }

}