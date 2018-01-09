package com.yzit.core.base;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yzit.core.vo.PageModel;

/**
 * 基础的service实现类
 * @author 康维
 * @使用要求：
 * 	 自己的业务service集成baseserviceimpl类
 * 	实现getDao();方法
 *
 */
@Transactional(readOnly = true)
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {
	public abstract BaseDao<T> getDao();

	@Transactional(readOnly = false)
	public void save(T t) throws Exception {
		//设置主键.字符类型采用UUID,数字类型采用自增
//		ClassReflectUtil.setIdKeyValue(t,"id",UUID.randomUUID().toString());
		getDao().save(t);
	}

	@Transactional(readOnly = false)
	public void delById(Integer id) throws Exception{
		
		getDao().delById(id);
	}

	/**
	 * 根据条件进行修改
	 */
	@Transactional(readOnly = false)
	public void update(T t) throws Exception{
		getDao().updateBySelective(t);
	}

	public List<T> findAll() throws Exception{
		
		return getDao().findAll();
	}

	public List<T> findByList(T t) throws Exception{
		
		return getDao().findByList(t);
	}

	public T findById(Integer id) throws Exception{
		
		return getDao().findById(id);
	}

	public Integer findByCount(T t) throws Exception{
		
		return getDao().findByCount(t);
	}
	
	/**
	 * 分页获取数据
	 * @param areaView
	 * @return
	 * @throws Exception
	 */
	public PageModel<T> findByPage(T t) throws Exception{
		List<T> dataList= getDao().findByList(t);
		int totalCount = getDao().findByCount(t);
		
		PageModel<T> pm = new PageModel<T>();
		pm.setPageNo(t.getPageNo());
		pm.setPageSize(t.getPageSize());
		pm.setDataList(dataList);
		pm.setTotalCount(totalCount);
		return pm;
	}
}
