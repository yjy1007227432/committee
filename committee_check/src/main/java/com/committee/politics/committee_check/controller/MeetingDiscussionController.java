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

import com.committee.politics.committee_check.entity.MeetingDiscussionEntity;
import com.committee.politics.committee_check.service.MeetingDiscussionService;



/**
 * 会商研讨录入
 *
 * @author yaojunyi
 * @email yao_junyi@qq.com
 * @date 2021-06-11 16:55:08
 */
@RestController
@RequestMapping("committee_check/meetingdiscussion")
public class MeetingDiscussionController {
    @Autowired
    private MeetingDiscussionService meetingDiscussionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("committee_check:meetingdiscussion:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = meetingDiscussionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("committee_check:meetingdiscussion:info")
    public R info(@PathVariable("id") Long id){
		MeetingDiscussionEntity meetingDiscussion = meetingDiscussionService.getById(id);

        return R.ok().put("meetingDiscussion", meetingDiscussion);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("committee_check:meetingdiscussion:save")
    public R save(@RequestBody MeetingDiscussionEntity meetingDiscussion){
		meetingDiscussionService.save(meetingDiscussion);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("committee_check:meetingdiscussion:update")
    public R update(@RequestBody MeetingDiscussionEntity meetingDiscussion){
		meetingDiscussionService.updateById(meetingDiscussion);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("committee_check:meetingdiscussion:delete")
    public R delete(@RequestBody Long[] ids){
		meetingDiscussionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
