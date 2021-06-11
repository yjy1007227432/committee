package com.committee.politics.committee_check.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author yaojunyi
 * @email yao_junyi@qq.com
 * @date 2021-06-11 15:07:44
 */
@Data
@TableName("committee_checkPerson_parameter")
public class CheckpersonParameterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 未处置完毕事件
	 */
	private Double receiveUnfinished;
	/**
	 * 未处置即关闭事件，无跟进措施
	 */
	private Double receiveNotFollow;
	/**
	 * 未处置即关闭事件，造成影响的
	 */
	private Double receiveEffect;
	/**
	 * 平安考核扣分事项的事件
	 */
	private Double receiveDeduct;
	/**
	 * 交办处置事件
	 */
	private Double receivePut;
	/**
	 * 排查走访
	 */
	private Double drivingVisit;
	/**
	 * 主动牵头开展行业内专项整治
	 */
	private Double drivingManage;
	/**
	 * 开展跨领域，跨部门联合整治的牵头部门
	 */
	private Double drivingUnion;
	/**
	 * 不满意的事件
	 */
	private Double notSatisfied;

}
