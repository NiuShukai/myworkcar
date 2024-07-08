package com.easycar.controller;

import java.util.Date;
import java.util.List;

import com.easycar.entity.bean.Driver;
import com.easycar.entity.bean.Retucar;
import com.easycar.entity.bean.Vehicle;
import com.easycar.entity.enums.DateTimePatternEnum;
import com.easycar.entity.enums.ResponseCodeEnum;
import com.easycar.entity.querybean.OrdersQuery;
import com.easycar.entity.bean.Orders;
import com.easycar.entity.querybean.RetucarQuery;
import com.easycar.entity.vo.ResponseVO;
import com.easycar.service.DriverService;
import com.easycar.service.OrdersService;
import com.easycar.service.RetucarService;
import com.easycar.service.VehicleService;
import com.easycar.utils.DateUtil;
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
	private RetucarService retucarService;
	@Resource
	private VehicleService vehicleService;
	@Resource
	private DriverService driverService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(OrdersQuery query){
		return getSuccessResponseVO(ordersService.findListByPage(query));
	}
	@RequestMapping("/loading")
	public Integer loading(@RequestBody Orders query){
		System.out.println(query.toString());
		OrdersQuery query1=new OrdersQuery();
		query1.setVehicleId(query.getVehicleId());
		query1.setStartlatitude(query.getStartlatitude());
		query1.setStartlocation(query.getStartlocation());
		      query1.setStartlongtitude(query.getStartlongtitude());
		      query1.setEndlatitude(query.getEndlatitude());
		      query1.setEndlocation(query.getEndlocation());
		      query1.setEndlongtitude(query.getEndlongtitude());
		Orders orders = ordersService.findListByParam(query1).get(0);

		if(orders.getStatus()!=null){
			if (orders.getStatus()==2){
				return 1;
			}
			else return 1;
		}
		else return 3;
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(@RequestBody Orders bean) {
		Date currtime=new Date();

		bean.setCreatedTime(currtime);
		System.out.println(bean);
		//拿到订单了，订单中包含汽车的id
		//更新汽车状态
		if(bean.getVehicleId()==null){
			return  getErrorResponseVO(ResponseCodeEnum.CODE_600,null);
		}
		Vehicle vehicleByVehicleId = vehicleService.getVehicleByVehicleId(bean.getVehicleId());
		vehicleByVehicleId.setVehicleStatus(2);//汽车状态为派出
		//更新汽车表与归还表
		vehicleService.updateVehicleByVehicleId(vehicleByVehicleId,bean.getVehicleId());
		Retucar  retucar = new Retucar();
		retucar.setCreatedTime(currtime);
		retucar.setStatus(1);//订单创建状态,租借
		retucar.setVehicleId(bean.getVehicleId());
		retucarService.add(retucar);
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

	/**
	 * 根据OrdersId删除
	 */
	@RequestMapping("/deleteOrdersByOrdersId")
	public ResponseVO deleteOrdersByOrdersId(Integer ordersId) {
		Date  currtime = new Date();
		ordersService.deleteOrdersByOrdersId(ordersId);
		Orders ordersByOrdersId = ordersService.getOrdersByOrdersId(ordersId);
		Vehicle vehicleByVehicleId = vehicleService.getVehicleByVehicleId(ordersByOrdersId.getVehicleId());
		vehicleByVehicleId.setVehicleStatus(1);//汽车状态设置为可用
		RetucarQuery req=new RetucarQuery();
		req.setVehicleId(ordersByOrdersId.getVehicleId());
		Retucar recar=retucarService.findListByParam(req).get(0);
		recar.setReturnTime(currtime);
		recar.setStatus(0);//归还
		Driver driverByDriverId = driverService.getDriverByDriverId(ordersByOrdersId.getDriverId());
		driverByDriverId.setStatus(0);//司机状态设置为空闲
		driverService.updateDriverByDriverId(driverByDriverId,ordersByOrdersId.getDriverId());
		retucarService.updateRetucarByReturnId(recar,recar.getReturnId());
		vehicleService.updateVehicleByVehicleId(vehicleByVehicleId,ordersByOrdersId.getVehicleId());
		return getSuccessResponseVO(null);
	}
	@RequestMapping("/quxiaoByOrdersId")
	public ResponseVO quxaioOrdersByOrdersId(@RequestBody OrdersQuery query) {
		Date currtime=new Date();//取消时间
		System.out.println(query.getOrdersId());

		Orders ordersByOrdersId = ordersService.getOrdersByOrdersId(query.getOrdersId());
		ordersByOrdersId.setStatus(0);//订单状态为取消
		      ordersByOrdersId.setEndtime(currtime);//设置取消时间
			  ordersByOrdersId.setOverTime(currtime);//设置结束时间1
		Vehicle vehicleByVehicleId = vehicleService.getVehicleByVehicleId(ordersByOrdersId.getVehicleId());
		vehicleByVehicleId.setVehicleStatus(1);//汽车状态设置为可用
		RetucarQuery req=new RetucarQuery();
		req.setVehicleId(ordersByOrdersId.getVehicleId());
		Retucar recar=retucarService.findListByParam(req).get(0);
		recar.setReturnTime(currtime);
		recar.setStatus(0);//归还
		Driver driverByDriverId = driverService.getDriverByDriverId(ordersByOrdersId.getDriverId());
		driverByDriverId.setStatus(0);//司机状态设置为空闲
		driverService.updateDriverByDriverId(driverByDriverId,ordersByOrdersId.getDriverId());
		retucarService.updateRetucarByReturnId(recar,recar.getReturnId());
		vehicleService.updateVehicleByVehicleId(vehicleByVehicleId,ordersByOrdersId.getVehicleId());
		ordersService.updateOrdersByOrdersId(ordersByOrdersId,query.getOrdersId());
		return getSuccessResponseVO(null);
	}
	@RequestMapping("/jieshuByOrdersId")
	public ResponseVO jieshuOrdersByOrdersId(@RequestBody OrdersQuery query) {
		Date currtime=new Date();//结束时间
		System.out.println(query.getOrdersId());
		Orders ordersByOrdersId = ordersService.getOrdersByOrdersId(query.getOrdersId());
		ordersByOrdersId.setStatus(3);
		ordersByOrdersId.setEndtime(currtime);
		ordersByOrdersId.setOverTime(currtime);
		Vehicle vehicleByVehicleId = vehicleService.getVehicleByVehicleId(ordersByOrdersId.getVehicleId());
		vehicleByVehicleId.setVehicleStatus(1);
		RetucarQuery req=new RetucarQuery();
		req.setVehicleId(ordersByOrdersId.getVehicleId());
		Retucar recar=retucarService.findListByParam(req).get(0);
		recar.setReturnTime(currtime);
		recar.setStatus(0);
		Driver driverByDriverId = driverService.getDriverByDriverId(ordersByOrdersId.getDriverId());
		driverByDriverId.setStatus(0);//司机状态设置为空闲
		driverService.updateDriverByDriverId(driverByDriverId,ordersByOrdersId.getDriverId());
		vehicleService.updateVehicleByVehicleId(vehicleByVehicleId,ordersByOrdersId.getVehicleId());
		ordersService.updateOrdersByOrdersId(ordersByOrdersId,query.getOrdersId());
		retucarService.updateRetucarByReturnId(recar,recar.getReturnId());
		return getSuccessResponseVO(null);
	}

}