package com.committee.politics.committee_check.service.impl;

import com.committee.politics.committee_check.utils.Query;
import com.committee.politics.committee_check.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.committee.politics.committee_check.dao.CheckdepartmentParameterDao;
import com.committee.politics.committee_check.entity.CheckdepartmentParameterEntity;
import com.committee.politics.committee_check.service.CheckdepartmentParameterService;


@Service("checkdepartmentParameterService")
public class CheckdepartmentParameterServiceImpl extends ServiceImpl<CheckdepartmentParameterDao, CheckdepartmentParameterEntity> implements CheckdepartmentParameterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CheckdepartmentParameterEntity> page = this.page(
                new Query<CheckdepartmentParameterEntity>().getPage(params),
                new QueryWrapper<CheckdepartmentParameterEntity>()
        );

        return new PageUtils(page);
    }

}