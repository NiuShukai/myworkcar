package com.easycar.mappers;

import org.apache.ibatis.annotations.Param;

/**
 * 车辆管理表 数据库操作接口
 */
public interface VehicleMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据VehicleId更新
	 */
	 Integer updateByVehicleId(@Param("bean") T t,@Param("vehicleId") Integer vehicleId);


	/**
	 * 根据VehicleId删除
	 */
	 Integer deleteByVehicleId(@Param("vehicleId") Integer vehicleId);


	/**
	 * 根据VehicleId获取对象
	 */
	 T selectByVehicleId(@Param("vehicleId") Integer vehicleId);


}
