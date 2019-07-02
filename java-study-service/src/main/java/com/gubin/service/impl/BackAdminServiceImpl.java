package com.gubin.service.impl;

import com.gubin.common.domain.BackAdmin;
import com.gubin.common.util.Convert;
import com.gubin.mapper.BackAdminMapper;
import com.gubin.service.BackAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台用户 服务层实现
 * 
 * @author ruoyi
 * @date 2019-07-02
 */
@Service
public class BackAdminServiceImpl implements BackAdminService
{
	@Autowired
	private BackAdminMapper backAdminMapper;

	/**
     * 查询后台用户信息
     * 
     * @param id 后台用户ID
     * @return 后台用户信息
     */
    @Override
	public BackAdmin selectBackAdminById(Integer id)
	{
	    return backAdminMapper.selectBackAdminById(id);
	}
	
	/**
     * 查询后台用户列表
     * 
     * @param backAdmin 后台用户信息
     * @return 后台用户集合
     */
	@Override
	public List<BackAdmin> selectBackAdminList(BackAdmin backAdmin)
	{
	    return backAdminMapper.selectBackAdminList(backAdmin);
	}
	
    /**
     * 新增后台用户
     * 
     * @param backAdmin 后台用户信息
     * @return 结果
     */
	@Override
	public int insertBackAdmin(BackAdmin backAdmin)
	{
	    return backAdminMapper.insertBackAdmin(backAdmin);
	}
	
	/**
     * 修改后台用户
     * 
     * @param backAdmin 后台用户信息
     * @return 结果
     */
	@Override
	public int updateBackAdmin(BackAdmin backAdmin)
	{
	    return backAdminMapper.updateBackAdmin(backAdmin);
	}

	/**
     * 删除后台用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBackAdminByIds(String ids)
	{
		return backAdminMapper.deleteBackAdminByIds(Convert.toStrArray(ids));
	}
	
}
