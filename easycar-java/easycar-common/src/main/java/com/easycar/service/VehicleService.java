package com.easycar.service;

import java.util.List;

import com.easycar.entity.querybean.VehicleQuery;
import com.easycar.entity.bean.Vehicle;
import com.easycar.entity.vo.PaginationResultVO;


/**
 * 车辆管理表 业务接口
 */
public interface VehicleService {

	/**
	 * 根据条件查询列表
	 */
	List<Vehicle> findListByParam(VehicleQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(VehicleQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Vehicle> findListByPage(VehicleQuery param);

	/**
	 * 新增
	 */
	Integer add(Vehicle bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Vehicle> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Vehicle> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Vehicle bean,VehicleQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(VehicleQuery param);

	/**
	 * 根据VehicleId查询对象
	 */
	Vehicle getVehicleByVehicleId(Integer vehicleId);


	/**
	 * 根据VehicleId修改
	 */
	Integer updateVehicleByVehicleId(Vehicle bean,Integer vehicleId);


	/**
	 * 根据VehicleId删除
	 */
	Integer deleteVehicleByVehicleId(Integer vehicleId);

}