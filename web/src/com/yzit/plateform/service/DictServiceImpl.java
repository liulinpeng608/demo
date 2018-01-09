package com.yzit.plateform.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yzit.plateform.entity.Dict;
import com.yzit.plateform.dao.DictDao;

import com.yzit.core.base.BaseDao;
import com.yzit.core.base.BaseServiceImpl;
/**
 * <b>功能:</b>字典业务服务类<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:30 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
@Service("dictService")
public class DictServiceImpl extends BaseServiceImpl<Dict>  implements DictService {
	private final static Logger log= Logger.getLogger(DictService.class);
	
	@Autowired
	private DictDao  dictDao;
	@Override
	public BaseDao<Dict> getDao() {
		return dictDao;
	}
	//基础的添加、修改、删除、查询、分页查询都已经完成，以下代码是自己的了特有方法
	
	
}

