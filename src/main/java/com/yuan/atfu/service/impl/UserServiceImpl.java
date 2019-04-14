package com.yuan.atfu.service.impl;

import com.yuan.atfu.domain.entity.User;
import com.yuan.atfu.mapper.UserMapper;
import com.yuan.atfu.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author David
 * @since 2019-04-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
