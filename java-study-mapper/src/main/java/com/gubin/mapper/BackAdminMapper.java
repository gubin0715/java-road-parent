package com.gubin.mapper;

import com.gubin.common.domain.BackAdmin;
import org.springframework.stereotype.Repository;

import java.util.List;	

/**
 * 后台用户 数据层
 * 
 * @author ruoyi
 * @date 2019-07-02
 */
@Repository
public interface BackAdminMapper 
{
	/**
     * 查询后台用户信息
     * 
     * @param id 后台用户ID
     * @return 后台用户信息
     */
	public BackAdmin selectBackAdminById(Integer id);
	
	/**
     * 查询后台用户列表
     * 
     * @param backAdmin 后台用户信息
     * @return 后台用户集合
     */
	public List<BackAdmin> selectBackAdminList(BackAdmin backAdmin);
	
	/**
     * 新增后台用户
     * 
     * @param backAdmin 后台用户信息
     * @return 结果
     */
	public int insertBackAdmin(BackAdmin backAdmin);
	
	/**
     * 修改后台用户
     * 
     * @param backAdmin 后台用户信息
     * @return 结果
     */
	public int updateBackAdmin(BackAdmin backAdmin);
	
	/**
     * 删除后台用户
     * 
     * @param id 后台用户ID
     * @return 结果
     */
	public int deleteBackAdminById(Integer id);
	
	/**
     * 批量删除后台用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBackAdminByIds(String[] ids);
	
}