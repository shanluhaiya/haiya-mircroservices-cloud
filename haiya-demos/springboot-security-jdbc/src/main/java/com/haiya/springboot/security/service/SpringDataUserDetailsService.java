package com.haiya.springboot.security.service;

import com.haiya.springboot.security.dao.UserDao;
import com.haiya.springboot.security.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /**
         *  根据账号去数据库查询...
         */
        System.out.println("username=" + username);
        UserDto user = userDao.getUserByUsername(username);
        /**
         * 根据认证流程
         * UserDetailsService会将结果给到Provider， 由Provider抛异常，没有查找到用户，这里只需要返回null即可
         */
        if(user == null){
            return null;
        }
        /**
         * 根据用户id查询用户权限
         */
        List<String> permissions = userDao.findPermissionsByUserId(user.getId());

        /**
         * 将权限转成数组
         */
        String[] permArray = new String[permissions.size()];
        permissions.toArray(permArray);

        /**
         * 这里暂时使用静态数据
         */
        UserDetails userDetails =
                User.withUsername(user.getFullname())
                        .password(user.getPassword())
                        .authorities(permArray)
                        .build();
        return userDetails;
    }
}
