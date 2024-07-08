package com.easycar.mappers;

import org.apache.ibatis.annotations.Param;

/**
 * 司机管理表 数据库操作接口
 */
public interface DriverMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据DriverId更新
	 */
	 Integer updateByDriverId(@Param("bean") T t,@Param("driverId") Integer driverId);


	/**
	 * 根据DriverId删除
	 */
	 Integer deleteByDriverId(@Param("driverId") Integer driverId);


	/**
	 * 根据DriverId获取对象
	 */
	 T selectByDriverId(@Param("driverId") Integer driverId);


}
