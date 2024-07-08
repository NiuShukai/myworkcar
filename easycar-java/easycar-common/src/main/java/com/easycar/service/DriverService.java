package com.easycar.service;

import java.util.List;

import com.easycar.entity.querybean.DriverQuery;
import com.easycar.entity.bean.Driver;
import com.easycar.entity.vo.PaginationResultVO;


/**
 * 司机管理表 业务接口
 */
public interface DriverService {

	/**
	 * 根据条件查询列表
	 */
	List<Driver> findListByParam(DriverQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(DriverQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Driver> findListByPage(DriverQuery param);

	/**
	 * 新增
	 */
	Integer add(Driver bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Driver> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Driver> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Driver bean,DriverQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(DriverQuery param);

	/**
	 * 根据DriverId查询对象
	 */
	Driver getDriverByDriverId(Integer driverId);


	/**
	 * 根据DriverId修改
	 */
	Integer updateDriverByDriverId(Driver bean,Integer driverId);


	/**
	 * 根据DriverId删除
	 */
	Integer deleteDriverByDriverId(Integer driverId);

}