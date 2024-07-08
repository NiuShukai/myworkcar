package com.easycar.controller;

import java.util.Date;
import java.util.List;

import com.easycar.entity.bean.Driver;
import com.easycar.entity.bean.Retucar;
import com.easycar.entity.querybean.OrdersQuery;
import com.easycar.entity.bean.Orders;
import com.easycar.entity.querybean.RetucarQuery;
import com.easycar.entity.vo.ResponseVO;
import com.easycar.service.DriverService;
import com.easycar.service.OrdersService;
import com.easycar.service.RetucarService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("ordersController")
@RequestMapping("/orders")
public class OrdersController extends ABaseController{

	@Resource
	private OrdersService ordersService;
	@Resource
	private DriverService driverService;
	@Resource
	private RetucarService retucarService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(OrdersQuery query){
		return getSuccessResponseVO(ordersService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(Orders bean) {
		ordersService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Orders> listBean) {
		ordersService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Orders> listBean) {
		ordersService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据OrdersId查询对象
	 */
	@RequestMapping("/getOrdersByOrdersId")
	public ResponseVO getOrdersByOrdersId(Integer ordersId) {
		return getSuccessResponseVO(ordersService.getOrdersByOrdersId(ordersId));
	}

	/**
	 * 根据OrdersId修改对象
	 */
	@RequestMapping("/updateOrdersByOrdersId")
	public ResponseVO updateOrdersByOrdersId(Orders bean,Integer ordersId) {
		ordersService.updateOrdersByOrdersId(bean,ordersId);
		return getSuccessResponseVO(null);
	}
	@RequestMapping("/adddriverbyorderid")
	public ResponseVO adddriverbyorderid(Orders bean,Integer ordersId) {
		bean.setStatus(2);//订单状态接受
		Date now = new Date();
		bean.setStarttime(now);
		ordersService.updateOrdersByOrdersId(bean,ordersId);
		RetucarQuery  retucarQuery=new RetucarQuery();
		retucarQuery.setVehicleId(bean.getVehicleId());

		Retucar retucar = retucarService.findListByParam(retucarQuery).get(0);
		retucar.setDriverId(bean.getDriverId());
		retucarService.updateRetucarByReturnId(retucar,retucar.getReturnId());
		Driver driverByDriverId = driverService.getDriverByDriverId(bean.getDriverId());
		driverByDriverId.setStatus(1);
		driverService.updateDriverByDriverId(driverByDriverId,bean.getDriverId());
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据OrdersId删除
	 */
	@RequestMapping("/deleteOrdersByOrdersId")
	public ResponseVO deleteOrdersByOrdersId(Integer ordersId) {
		ordersService.deleteOrdersByOrdersId(ordersId);
		return getSuccessResponseVO(null);
	}
}