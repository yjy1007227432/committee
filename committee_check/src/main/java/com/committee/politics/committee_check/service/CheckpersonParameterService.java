package com.committee.politics.committee_check.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.committee.politics.committee_check.entity.CheckpersonParameterEntity;
import com.committee.politics.committee_check.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author yaojunyi
 * @email yao_junyi@qq.com
 * @date 2021-06-11 15:07:44
 */
public interface CheckpersonParameterService extends IService<CheckpersonParameterEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

