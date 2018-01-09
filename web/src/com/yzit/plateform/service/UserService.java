package com.yzit.plateform.service;
import com.yzit.core.base.BaseService;
import com.yzit.plateform.entity.User;
/**
 * <b>功能:</b>登录用户业务服务类<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b> Tue Jan 02 10:21:30 CST 2018 <br>
 * <b>版权所有: 云优众<br>
 */
public interface UserService extends BaseService<User>{
	public User login(User user);
}