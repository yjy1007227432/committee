package com.committee.politics.committee_check.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 会商研讨录入
 * 
 * @author yaojunyi
 * @email yao_junyi@qq.com
 * @date 2021-06-11 16:55:08
 */
@Data
@TableName("committee_meeting_discussion")
public class MeetingDiscussionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 会议主题
	 */
	private String theme;
	/**
	 * 会议开始时间
	 */
	private Date startTime;
	/**
	 * 会议结束时间
	 */
	private Date endTime;
	/**
	 * 参会人员
	 */
	private Long number;
	/**
	 * 组织者
	 */
	private String organizer;
	/**
	 * 组织机构
	 */
	private String institution;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updatedTime;

}
