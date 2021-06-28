package com.haiya.user.service;

import java.util.List;
import java.util.Map;

import com.haiya.common.model.PageResult;
import com.haiya.common.model.Result;
import com.haiya.common.model.SysRole;
import com.haiya.common.service.ISuperService;

/**
 * @author qiaoguoqiang
 */
public interface ISysRoleService extends ISuperService<SysRole> {
	void saveRole(SysRole sysRole) throws Exception;

	void deleteRole(Long id);

	/**
	 * 角色列表
	 * @param params
	 * @return
	 */
	PageResult<SysRole> findRoles(Map<String, Object> params);

	/**
	 * 新增或更新角色
	 * @param sysRole
	 * @return Result
	 */
	Result saveOrUpdateRole(SysRole sysRole) throws Exception;

	/**
	 * 查询所有角色
	 * @return
	 */
	List<SysRole> findAll();
}
