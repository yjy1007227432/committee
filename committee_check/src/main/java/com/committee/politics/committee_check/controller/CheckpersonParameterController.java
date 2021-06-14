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

import com.committee.politics.committee_check.entity.CheckpersonParameterEntity;
import com.committee.politics.committee_check.service.CheckpersonParameterService;



/**
 * 
 *
 * @author yaojunyi
 * @email yao_junyi@qq.com
 * @date 2021-06-11 15:07:44
 */
@RestController
@RequestMapping("committee_check/checkpersonparameter")
public class CheckpersonParameterController {
    @Autowired
    private CheckpersonParameterService checkpersonParameterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("committee_check:checkpersonparameter:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = checkpersonParameterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("committee_check:checkpersonparameter:info")
    public R info(@PathVariable("id") Long id){
		CheckpersonParameterEntity checkpersonParameter = checkpersonParameterService.getById(id);

        return R.ok().put("checkpersonParameter", checkpersonParameter);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("committee_check:checkpersonparameter:save")
    public R save(@RequestBody CheckpersonParameterEntity checkpersonParameter){
		checkpersonParameterService.save(checkpersonParameter);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("committee_check:checkpersonparameter:update")
    public R update(@RequestBody CheckpersonParameterEntity checkpersonParameter){
		checkpersonParameterService.updateById(checkpersonParameter);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("committee_check:checkpersonparameter:delete")
    public R delete(@RequestBody Long[] ids){
		checkpersonParameterService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
