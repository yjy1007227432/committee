package com.committee.politics.committee_check.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 业务培训录入
 * 
 * @author yaojunyi
 * @email yao_junyi@qq.com
 * @date 2021-06-11 16:55:08
 */
@Data
@TableName("committee_business_training")
public class BusinessTrainingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 主题
	 */
	private String theme;
	/**
	 * 日期
	 */
	private Date datetime;
	/**
	 * 任务状态  0：未举办  1：已举办
	 */
	private Integer status;
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
