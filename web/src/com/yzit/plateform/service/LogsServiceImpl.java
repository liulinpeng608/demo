package com.yzit.plateform.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yzit.plateform.entity.Logs;
import com.yzit.plateform.dao.LogsDao;

import com.yzit.core.base.BaseDao;
import com.yzit.core.base.BaseServiceImpl;
/**
 * <b>功能:</b>操作日志业务服务类<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:30 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
@Service("logsService")
public class LogsServiceImpl extends BaseServiceImpl<Logs>  implements LogsService {
	private final static Logger log= Logger.getLogger(LogsService.class);
	
	@Autowired
	private LogsDao  logsDao;
	@Override
	public BaseDao<Logs> getDao() {
		return logsDao;
	}
	//基础的添加、修改、删除、查询、分页查询都已经完成，以下代码是自己的了特有方法
	
	
}

