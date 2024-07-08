package com.easycar.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easycar.entity.enums.PageSize;
import com.easycar.entity.querybean.VehicleQuery;
import com.easycar.entity.bean.Vehicle;
import com.easycar.entity.vo.PaginationResultVO;
import com.easycar.entity.querybean.SimplePage;
import com.easycar.mappers.VehicleMapper;
import com.easycar.service.VehicleService;
import com.easycar.utils.StringTools;


/**
 * 车辆管理表 业务接口实现
 */
@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {

	@Resource
	private VehicleMapper<Vehicle, VehicleQuery> vehicleMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Vehicle> findListByParam(VehicleQuery param) {
		return this.vehicleMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(VehicleQuery param) {
		return this.vehicleMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Vehicle> findListByPage(VehicleQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Vehicle> list = this.findListByParam(param);
		PaginationResultVO<Vehicle> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Vehicle bean) {
		return this.vehicleMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Vehicle> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.vehicleMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Vehicle> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.vehicleMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Vehicle bean, VehicleQuery param) {
		StringTools.checkParam(param);
		return this.vehicleMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(VehicleQuery param) {
		StringTools.checkParam(param);
		return this.vehicleMapper.deleteByParam(param);
	}

	/**
	 * 根据VehicleId获取对象
	 */
	@Override
	public Vehicle getVehicleByVehicleId(Integer vehicleId) {
		return this.vehicleMapper.selectByVehicleId(vehicleId);
	}

	/**
	 * 根据VehicleId修改
	 */
	@Override
	public Integer updateVehicleByVehicleId(Vehicle bean, Integer vehicleId) {
		return this.vehicleMapper.updateByVehicleId(bean, vehicleId);
	}

	/**
	 * 根据VehicleId删除
	 */
	@Override
	public Integer deleteVehicleByVehicleId(Integer vehicleId) {
		return this.vehicleMapper.deleteByVehicleId(vehicleId);
	}
}