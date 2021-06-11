package com.committee.politics.committee_check.service.impl;

import com.committee.politics.committee_check.utils.PageUtils;
import com.committee.politics.committee_check.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.committee.politics.committee_check.dao.BusinessTrainingDao;
import com.committee.politics.committee_check.entity.BusinessTrainingEntity;
import com.committee.politics.committee_check.service.BusinessTrainingService;


@Service("businessTrainingService")
public class BusinessTrainingServiceImpl extends ServiceImpl<BusinessTrainingDao, BusinessTrainingEntity> implements BusinessTrainingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BusinessTrainingEntity> page = this.page(
                new Query<BusinessTrainingEntity>().getPage(params),
                new QueryWrapper<BusinessTrainingEntity>()
        );

        return new PageUtils(page);
    }

}