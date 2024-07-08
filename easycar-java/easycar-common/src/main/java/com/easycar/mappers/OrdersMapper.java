package com.easycar.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *  数据库操作接口
 */
public interface OrdersMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据OrdersId更新
	 */
	 Integer updateByOrdersId(@Param("bean") T t,@Param("ordersId") Integer ordersId);


	/**
	 * 根据OrdersId删除
	 */
	 Integer deleteByOrdersId(@Param("ordersId") Integer ordersId);


	/**
	 * 根据OrdersId获取对象
	 */
	 T selectByOrdersId(@Param("ordersId") Integer ordersId);


}
