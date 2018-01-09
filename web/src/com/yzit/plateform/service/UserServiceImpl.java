package com.yzit.plateform.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yzit.plateform.entity.User;
import com.yzit.plateform.dao.UserDao;

import com.yzit.core.base.BaseDao;
import com.yzit.core.base.BaseServiceImpl;
/**
 * <b>功能:</b>登录用户业务服务类<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:30 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User>  implements UserService {
	private final static Logger log= Logger.getLogger(UserService.class);
	
	@Autowired
	private UserDao  userDao;
	@Override
	public BaseDao<User> getDao() {
		return userDao;
	}
	//基础的添加、修改、删除、查询、分页查询都已经完成，以下代码是自己的了特有方法
	public User login(User user) {
		return userDao.login(user);
	}
	
	
}

