package com.easycar.controller;

import java.util.List;

import com.easycar.entity.querybean.DriverQuery;
import com.easycar.entity.bean.Driver;
import com.easycar.entity.vo.ResponseVO;
import com.easycar.service.DriverService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 司机管理表 Controller
 */
@RestController("driverController")
@RequestMapping("/driver")
public class DriverController extends ABaseController{

	@Resource
	private DriverService driverService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(DriverQuery query){
		// 设置排序条件
		query.setOrderBy("driver_id asc");
		return getSuccessResponseVO(driverService.findListByPage(query));
	}
	@RequestMapping("/loadDriverfree")
	public ResponseVO loadDriverfree(DriverQuery query){
		// 设置排序条件
		query.setStatus(0);
		query.setOrderBy("driver_id asc");
		return getSuccessResponseVO(driverService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(Driver bean) {
		driverService.add(bean);
		bean.setStatus(0);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Driver> listBean) {
		driverService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Driver> listBean) {
		driverService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据DriverId查询对象
	 */
	@RequestMapping("/getDriverByDriverId")
	public ResponseVO getDriverByDriverId(Integer driverId) {
		return getSuccessResponseVO(driverService.getDriverByDriverId(driverId));
	}

	/**
	 * 根据DriverId修改对象
	 */
	@RequestMapping("/updateDriverByDriverId")
	public ResponseVO updateDriverByDriverId(Driver bean) {
		driverService.updateDriverByDriverId(bean,bean.getDriverId());
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据DriverId删除
	 */
	@RequestMapping("/deleteDriverByDriverId")
	public ResponseVO deleteDriverByDriverId(Integer driverId) {
		driverService.deleteDriverByDriverId(driverId);
		return getSuccessResponseVO(null);
	}
}