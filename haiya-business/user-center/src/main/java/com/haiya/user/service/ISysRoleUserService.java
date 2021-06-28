package com.haiya.user.service;

import com.haiya.common.model.SysRole;
import com.haiya.common.service.ISuperService;
import com.haiya.user.model.SysRoleUser;

import java.util.List;

/**
 * @author qiaoguoqiang
 */
public interface ISysRoleUserService extends ISuperService<SysRoleUser> {
	int deleteUserRole(Long userId, Long roleId);

	int saveUserRoles(Long userId, Long roleId);

	/**
	 * 根据用户id获取角色
	 *
	 * @param userId
	 * @return
	 */
	List<SysRole> findRolesByUserId(Long userId);

	/**
	 * 根据用户ids 获取
	 *
	 * @param userIds
	 * @return
	 */
	List<SysRole> findRolesByUserIds(List<Long> userIds);
}
