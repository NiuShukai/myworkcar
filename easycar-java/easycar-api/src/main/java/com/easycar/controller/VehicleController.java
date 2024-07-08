package com.easycar.controller;

import com.easycar.entity.bean.Vehicle;
import com.easycar.entity.querybean.VehicleQuery;
import com.easycar.entity.vo.PaginationResultVO;
import com.easycar.entity.vo.ResponseVO;
import com.easycar.service.VehicleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
	@RequestMapping("/loadveData")
	public ResponseVO loadveData(VehicleQuery query){
		query.setVehicleStatus(1);//设置查询条件，可用车辆
		List<Vehicle> listByParam = vehicleService.findListByParam(query);
		for (int i = 0; i < listByParam.size() ; i++) {
			String address="http://10.4.203.200:9091/api/file/getImage/"+listByParam.get(i).getVehiclePhoto();
			listByParam.get(i).setVehiclePhoto(address);
		}
		return getSuccessResponseVO(listByParam);
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(Vehicle bean) {
		vehicleService.add(bean);
		bean.setVehicleStatus(1);//设置为可用
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