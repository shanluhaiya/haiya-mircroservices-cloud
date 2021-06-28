package com.haiya.user.service;

import com.haiya.common.model.SysMenu;
import com.haiya.common.service.ISuperService;
import com.haiya.user.model.SysRoleMenu;

import java.util.List;
import java.util.Set;

/**
 * @author qiaoguoqiang
 */
public interface ISysRoleMenuService extends ISuperService<SysRoleMenu> {
	int save(Long roleId, Long menuId);

	int delete(Long roleId, Long menuId);

	List<SysMenu> findMenusByRoleIds(Set<Long> roleIds, Integer type);

	List<SysMenu> findMenusByRoleCodes(Set<String> roleCodes, Integer type);
}
