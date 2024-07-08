package com.easycar.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easycar.entity.enums.PageSize;
import com.easycar.entity.querybean.DriverQuery;
import com.easycar.entity.bean.Driver;
import com.easycar.entity.vo.PaginationResultVO;
import com.easycar.entity.querybean.SimplePage;
import com.easycar.mappers.DriverMapper;
import com.easycar.service.DriverService;
import com.easycar.utils.StringTools;


/**
 * 司机管理表 业务接口实现
 */
@Service("driverService")
public class DriverServiceImpl implements DriverService {

	@Resource
	private DriverMapper<Driver, DriverQuery> driverMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Driver> findListByParam(DriverQuery param) {
		return this.driverMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(DriverQuery param) {
		return this.driverMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Driver> findListByPage(DriverQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Driver> list = this.findListByParam(param);
		PaginationResultVO<Driver> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Driver bean) {
		return this.driverMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Driver> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.driverMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Driver> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.driverMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Driver bean, DriverQuery param) {
		StringTools.checkParam(param);
		return this.driverMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(DriverQuery param) {
		StringTools.checkParam(param);
		return this.driverMapper.deleteByParam(param);
	}

	/**
	 * 根据DriverId获取对象
	 */
	@Override
	public Driver getDriverByDriverId(Integer driverId) {
		return this.driverMapper.selectByDriverId(driverId);
	}

	/**
	 * 根据DriverId修改
	 */
	@Override
	public Integer updateDriverByDriverId(Driver bean, Integer driverId) {
		return this.driverMapper.updateByDriverId(bean, driverId);
	}

	/**
	 * 根据DriverId删除
	 */
	@Override
	public Integer deleteDriverByDriverId(Integer driverId) {
		return this.driverMapper.deleteByDriverId(driverId);
	}
}