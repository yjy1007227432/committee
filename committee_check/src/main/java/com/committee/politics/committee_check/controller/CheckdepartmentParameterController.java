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
import com.committee.politics.committee_check.entity.CheckdepartmentParameterEntity;
import com.committee.politics.committee_check.service.CheckdepartmentParameterService;
/**
 * 
 *
 * @author yaojunyi
 * @email yao_junyi@qq.com
 * @date 2021-06-11 15:07:44
 */
@RestController
@RequestMapping("committee_check/checkdepartmentparameter")
public class CheckdepartmentParameterController {
    @Autowired
    private CheckdepartmentParameterService checkdepartmentParameterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("committee_check:checkdepartmentparameter:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = checkdepartmentParameterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("committee_check:checkdepartmentparameter:info")
    public R info(@PathVariable("id") Long id){
		CheckdepartmentParameterEntity checkdepartmentParameter = checkdepartmentParameterService.getById(id);

        return R.ok().put("checkdepartmentParameter", checkdepartmentParameter);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("committee_check:checkdepartmentparameter:save")
    public R save(@RequestBody CheckdepartmentParameterEntity checkdepartmentParameter){
		checkdepartmentParameterService.save(checkdepartmentParameter);
        return R.ok();
    }
    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("committee_check:checkdepartmentparameter:update")
    public R update(@RequestBody CheckdepartmentParameterEntity checkdepartmentParameter){
		checkdepartmentParameterService.updateById(checkdepartmentParameter);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("committee_check:checkdepartmentparameter:delete")
    public R delete(@RequestBody Long[] ids){
		checkdepartmentParameterService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
