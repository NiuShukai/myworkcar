package com.easycar.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easycar.entity.enums.PageSize;
import com.easycar.entity.querybean.OrdersQuery;
import com.easycar.entity.bean.Orders;
import com.easycar.entity.vo.PaginationResultVO;
import com.easycar.entity.querybean.SimplePage;
import com.easycar.mappers.OrdersMapper;
import com.easycar.service.OrdersService;
import com.easycar.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

	@Resource
	private OrdersMapper<Orders, OrdersQuery> ordersMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Orders> findListByParam(OrdersQuery param) {
		return this.ordersMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(OrdersQuery param) {
		return this.ordersMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Orders> findListByPage(OrdersQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Orders> list = this.findListByParam(param);
		PaginationResultVO<Orders> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Orders bean) {
		return this.ordersMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Orders> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.ordersMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Orders> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.ordersMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Orders bean, OrdersQuery param) {
		StringTools.checkParam(param);
		return this.ordersMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(OrdersQuery param) {
		StringTools.checkParam(param);
		return this.ordersMapper.deleteByParam(param);
	}

	/**
	 * 根据OrdersId获取对象
	 */
	@Override
	public Orders getOrdersByOrdersId(Integer ordersId) {
		return this.ordersMapper.selectByOrdersId(ordersId);
	}

	/**
	 * 根据OrdersId修改
	 */
	@Override
	public Integer updateOrdersByOrdersId(Orders bean, Integer ordersId) {
		return this.ordersMapper.updateByOrdersId(bean, ordersId);
	}

	/**
	 * 根据OrdersId删除
	 */
	@Override
	public Integer deleteOrdersByOrdersId(Integer ordersId) {
		return this.ordersMapper.deleteByOrdersId(ordersId);
	}
}