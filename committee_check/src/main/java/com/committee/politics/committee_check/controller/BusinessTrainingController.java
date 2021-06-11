package com.committee.politics.committee_check.controller;

import java.util.Arrays;
import java.util.Map;

import com.committee.politics.committee_check.utils.PageUtils;
import com.committee.politics.committee_check.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.committee.politics.committee_check.entity.BusinessTrainingEntity;
import com.committee.politics.committee_check.service.BusinessTrainingService;




/**
 * 业务培训录入
 *
 * @author yaojunyi
 * @email yao_junyi@qq.com
 * @date 2021-06-11 16:55:08
 */
@RestController
@RequestMapping("committee_check/businesstraining")
public class BusinessTrainingController {
    @Autowired
    private BusinessTrainingService businessTrainingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("committee_check:businesstraining:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = businessTrainingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("committee_check:businesstraining:info")
    public R info(@PathVariable("id") Long id){
		BusinessTrainingEntity businessTraining = businessTrainingService.getById(id);

        return R.ok().put("businessTraining", businessTraining);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("committee_check:businesstraining:save")
    public R save(@RequestBody BusinessTrainingEntity businessTraining){
		businessTrainingService.save(businessTraining);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("committee_check:businesstraining:update")
    public R update(@RequestBody BusinessTrainingEntity businessTraining){
		businessTrainingService.updateById(businessTraining);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("committee_check:businesstraining:delete")
    public R delete(@RequestBody Long[] ids){
		businessTrainingService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
