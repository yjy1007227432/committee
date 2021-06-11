package com.committee.politics.committee_check.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.committee.common.utils.PageUtils;
import com.committee.common.utils.Query;

import com.committee.politics.committee_check.dao.CheckpersonParameterDao;
import com.committee.politics.committee_check.entity.CheckpersonParameterEntity;
import com.committee.politics.committee_check.service.CheckpersonParameterService;


@Service("checkpersonParameterService")
public class CheckpersonParameterServiceImpl extends ServiceImpl<CheckpersonParameterDao, CheckpersonParameterEntity> implements CheckpersonParameterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CheckpersonParameterEntity> page = this.page(
                new Query<CheckpersonParameterEntity>().getPage(params),
                new QueryWrapper<CheckpersonParameterEntity>()
        );

        return new PageUtils(page);
    }

}