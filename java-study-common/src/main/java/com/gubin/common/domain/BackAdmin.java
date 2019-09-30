package com.gubin.common.domain;

import lombok.Data;

/**
 * 后台用户表 back_admin
 * 
 * @author ruoyi
 * @date 2019-07-02
 */
@Data
public class BackAdmin{
	/**  */
	private Integer id;
	/** 管理员id */
	private String adminCode;
	/** 密码 */
	private String password;
	/** 管理员姓名 */
	private String adminName;
	/** 角色id */
	private Integer roleId;
	/** 管理员角色名称 */
	private String roleName;
	/** 创建时间 */
	private String createTime;

	private Integer pageNum=1;
	private Integer pageSize=10;
}
