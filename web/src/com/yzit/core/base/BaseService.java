package com.yzit.core.base;
import java.util.List;

import com.yzit.core.vo.PageModel;

public interface BaseService<T extends BaseEntity> {
	/**
	 * 保持对象
	 * 
	 * @param obj
	 */
	public void save(T  t)throws Exception;

	/**
	 * 根据id删除对象
	 * 
	 * @param id
	 */
	public void delById(Integer id)throws Exception;

	/**
	 * 修改对象
	 * 
	 * @param obj
	 */
	public void update(T  t)throws Exception;

	/**
	 * 检索所有的对象
	 * 
	 * @return
	 */
	public List<T> findAll()throws Exception;

	/**
	 * 根据条件检索对象
	 * 
	 * @param areaPage前台页面对象
	 * @return
	 */
	public List<T> findByList(T  t)throws Exception;

	/**
	 * 根据id检索对象
	 * 
	 * @param id
	 * @return
	 */
	public T  findById(Integer id)throws Exception;

	/**
	 * 检索总记录数
	 * 
	 * @param areaPage前台页面对象
	 * @return
	 */
	public Integer findByCount(T  t)throws Exception;
	/**
	 * 分页获取数据
	 * @param areaView
	 * @return
	 * @throws Exception
	 */
	public PageModel<T> findByPage(T  t) throws Exception;
}
