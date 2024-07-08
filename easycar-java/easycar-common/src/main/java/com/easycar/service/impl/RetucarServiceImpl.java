package com.easycar.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easycar.entity.enums.PageSize;
import com.easycar.entity.querybean.RetucarQuery;
import com.easycar.entity.bean.Retucar;
import com.easycar.entity.vo.PaginationResultVO;
import com.easycar.entity.querybean.SimplePage;
import com.easycar.mappers.RetucarMapper;
import com.easycar.service.RetucarService;
import com.easycar.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("retucarService")
public class RetucarServiceImpl implements RetucarService {

	@Resource
	private RetucarMapper<Retucar, RetucarQuery> retucarMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Retucar> findListByParam(RetucarQuery param) {
		return this.retucarMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(RetucarQuery param) {
		return this.retucarMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Retucar> findListByPage(RetucarQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Retucar> list = this.findListByParam(param);
		PaginationResultVO<Retucar> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Retucar bean) {
		return this.retucarMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Retucar> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.retucarMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Retucar> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.retucarMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Retucar bean, RetucarQuery param) {
		StringTools.checkParam(param);
		return this.retucarMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(RetucarQuery param) {
		StringTools.checkParam(param);
		return this.retucarMapper.deleteByParam(param);
	}

	/**
	 * 根据ReturnId获取对象
	 */
	@Override
	public Retucar getRetucarByReturnId(Integer returnId) {
		return this.retucarMapper.selectByReturnId(returnId);
	}

	/**
	 * 根据ReturnId修改
	 */
	@Override
	public Integer updateRetucarByReturnId(Retucar bean, Integer returnId) {
		return this.retucarMapper.updateByReturnId(bean, returnId);
	}

	/**
	 * 根据ReturnId删除
	 */
	@Override
	public Integer deleteRetucarByReturnId(Integer returnId) {
		return this.retucarMapper.deleteByReturnId(returnId);
	}
}