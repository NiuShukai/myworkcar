package com.easycar.service;

import java.util.List;

import com.easycar.entity.querybean.OrdersQuery;
import com.easycar.entity.bean.Orders;
import com.easycar.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface OrdersService {

	/**
	 * 根据条件查询列表
	 */
	List<Orders> findListByParam(OrdersQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(OrdersQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Orders> findListByPage(OrdersQuery param);

	/**
	 * 新增
	 */
	Integer add(Orders bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Orders> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Orders> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Orders bean,OrdersQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(OrdersQuery param);

	/**
	 * 根据OrdersId查询对象
	 */
	Orders getOrdersByOrdersId(Integer ordersId);


	/**
	 * 根据OrdersId修改
	 */
	Integer updateOrdersByOrdersId(Orders bean,Integer ordersId);


	/**
	 * 根据OrdersId删除
	 */
	Integer deleteOrdersByOrdersId(Integer ordersId);

}