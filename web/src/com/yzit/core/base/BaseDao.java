package com.yzit.core.base;


import java.util.List;



public interface BaseDao<T extends BaseEntity> {
	/**
	 * 保持对象
	 * 
	 * @param obj
	 */
	public void save(T  t);

	/**
	 * 根据id删除对象
	 * 
	 * @param id
	 */
	public void delById(Integer id);

	/**
	 * 修改对象
	 * 
	 * @param obj
	 */
	public void update(T  t);
	
	/**
	 * 根据条件进行修改
	 * @param t
	 */
	public void updateBySelective(T t);

	/**
	 * 检索所有的对象
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * 根据条件检索对象
	 * 
	 * @param areaPage前台页面对象
	 * @return
	 */
	public List<T> findByList(T  t);

	/**
	 * 根据id检索对象
	 * 
	 * @param id
	 * @return
	 */
	public T  findById(Integer id);

	/**
	 * 检索总记录数
	 * 
	 * @param areaPage前台页面对象
	 * @return
	 */
	public Integer findByCount(T  t);
}
