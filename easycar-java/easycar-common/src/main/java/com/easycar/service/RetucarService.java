package com.easycar.service;

import java.util.List;

import com.easycar.entity.querybean.RetucarQuery;
import com.easycar.entity.bean.Retucar;
import com.easycar.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface RetucarService {

	/**
	 * 根据条件查询列表
	 */
	List<Retucar> findListByParam(RetucarQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(RetucarQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Retucar> findListByPage(RetucarQuery param);

	/**
	 * 新增
	 */
	Integer add(Retucar bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Retucar> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Retucar> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Retucar bean,RetucarQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(RetucarQuery param);

	/**
	 * 根据ReturnId查询对象
	 */
	Retucar getRetucarByReturnId(Integer returnId);


	/**
	 * 根据ReturnId修改
	 */
	Integer updateRetucarByReturnId(Retucar bean,Integer returnId);


	/**
	 * 根据ReturnId删除
	 */
	Integer deleteRetucarByReturnId(Integer returnId);

}