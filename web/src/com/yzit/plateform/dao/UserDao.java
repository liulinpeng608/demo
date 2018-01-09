package com.yzit.plateform.dao;

import com.yzit.core.base.BaseDao;
import com.yzit.plateform.entity.User;
/**
 * <b>功能:</b>登录用户持久类<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b> Tue Jan 02 10:21:30 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
public interface UserDao  extends BaseDao<User>{

	public User login(User user);

	
}
