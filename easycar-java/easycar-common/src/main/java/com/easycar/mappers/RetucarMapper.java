package com.easycar.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *  数据库操作接口
 */
public interface RetucarMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据ReturnId更新
	 */
	 Integer updateByReturnId(@Param("bean") T t,@Param("returnId") Integer returnId);


	/**
	 * 根据ReturnId删除
	 */
	 Integer deleteByReturnId(@Param("returnId") Integer returnId);


	/**
	 * 根据ReturnId获取对象
	 */
	 T selectByReturnId(@Param("returnId") Integer returnId);


}
