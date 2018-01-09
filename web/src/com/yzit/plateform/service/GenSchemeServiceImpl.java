package com.yzit.plateform.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yzit.plateform.entity.GenScheme;
import com.yzit.plateform.dao.GenSchemeDao;

import com.yzit.core.base.BaseDao;
import com.yzit.core.base.BaseServiceImpl;
/**
 * <b>功能:</b>数据库业务服务类<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:30 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
@Service("genSchemeService")
public class GenSchemeServiceImpl extends BaseServiceImpl<GenScheme>  implements GenSchemeService {
	private final static Logger log= Logger.getLogger(GenSchemeService.class);
	
	@Autowired
	private GenSchemeDao  genSchemeDao;
	@Override
	public BaseDao<GenScheme> getDao() {
		return genSchemeDao;
	}
	//基础的添加、修改、删除、查询、分页查询都已经完成，以下代码是自己的了特有方法
	
	
}

