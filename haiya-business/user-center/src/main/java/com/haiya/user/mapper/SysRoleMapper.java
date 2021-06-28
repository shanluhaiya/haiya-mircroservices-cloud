package com.haiya.user.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haiya.db.mapper.SuperMapper;

import com.haiya.common.model.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author qiaoguoqiang
 * 角色
 */
@Mapper
public interface SysRoleMapper extends SuperMapper<SysRole> {
	List<SysRole> findList(Page<SysRole> page, @Param("r") Map<String, Object> params);

	List<SysRole> findAll();
}
