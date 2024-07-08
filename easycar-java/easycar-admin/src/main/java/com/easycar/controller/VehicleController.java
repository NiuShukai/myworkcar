package com.easycar.controller;

import java.util.List;

import com.easycar.entity.querybean.VehicleQuery;
import com.easycar.entity.bean.Vehicle;
import com.easycar.entity.vo.ResponseVO;
import com.easycar.service.VehicleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 车辆管理表 Controller
 */
@RestController("vehicleController")
@RequestMapping("/vehicle")
public class VehicleController extends ABaseController{

	@Resource
	private VehicleService vehicleService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(VehicleQuery query){
		return getSuccessResponseVO(vehicleService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(Vehicle bean) {
		vehicleService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Vehicle> listBean) {
		vehicleService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Vehicle> listBean) {
		vehicleService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据VehicleId查询对象
	 */
	@RequestMapping("/getVehicleByVehicleId")
	public ResponseVO getVehicleByVehicleId(Integer vehicleId) {
		return getSuccessResponseVO(vehicleService.getVehicleByVehicleId(vehicleId));
	}

	/**
	 * 根据VehicleId修改对象
	 */
	@RequestMapping("/updateVehicleByVehicleId")
	public ResponseVO updateVehicleByVehicleId(Vehicle bean,Integer vehicleId) {
		vehicleService.updateVehicleByVehicleId(bean,vehicleId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据VehicleId删除
	 */
	@RequestMapping("/deleteVehicleByVehicleId")
	public ResponseVO deleteVehicleByVehicleId(Integer vehicleId) {
		vehicleService.deleteVehicleByVehicleId(vehicleId);
		return getSuccessResponseVO(null);
	}
}