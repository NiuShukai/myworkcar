package com.easycar.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easycar.entity.enums.PageSize;
import com.easycar.entity.querybean.AppUserInfoQuery;
import com.easycar.entity.bean.AppUserInfo;
import com.easycar.entity.vo.PaginationResultVO;
import com.easycar.entity.querybean.SimplePage;
import com.easycar.mappers.AppUserInfoMapper;
import com.easycar.service.AppUserInfoService;
import com.easycar.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("appUserInfoService")
public class AppUserInfoServiceImpl implements AppUserInfoService {

	@Resource
	private AppUserInfoMapper<AppUserInfo, AppUserInfoQuery> appUserInfoMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<AppUserInfo> findListByParam(AppUserInfoQuery param) {
		return this.appUserInfoMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(AppUserInfoQuery param) {
		return this.appUserInfoMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<AppUserInfo> findListByPage(AppUserInfoQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<AppUserInfo> list = this.findListByParam(param);
		PaginationResultVO<AppUserInfo> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(AppUserInfo bean) {
		return this.appUserInfoMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<AppUserInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.appUserInfoMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<AppUserInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.appUserInfoMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(AppUserInfo bean, AppUserInfoQuery param) {
		StringTools.checkParam(param);
		return this.appUserInfoMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(AppUserInfoQuery param) {
		StringTools.checkParam(param);
		return this.appUserInfoMapper.deleteByParam(param);
	}

	/**
	 * 根据UserId获取对象
	 */
	@Override
	public AppUserInfo getAppUserInfoByUserId(String userId) {
		return this.appUserInfoMapper.selectByUserId(userId);
	}

	/**
	 * 根据UserId修改
	 */
	@Override
	public Integer updateAppUserInfoByUserId(AppUserInfo bean, String userId) {
		return this.appUserInfoMapper.updateByUserId(bean, userId);
	}

	/**
	 * 根据UserId删除
	 */
	@Override
	public Integer deleteAppUserInfoByUserId(String userId) {
		return this.appUserInfoMapper.deleteByUserId(userId);
	}

	/**
	 * 根据Email获取对象
	 */
	@Override
	public AppUserInfo getAppUserInfoByEmail(String email) {
		return this.appUserInfoMapper.selectByEmail(email);
	}

	/**
	 * 根据Email修改
	 */
	@Override
	public Integer updateAppUserInfoByEmail(AppUserInfo bean, String email) {
		return this.appUserInfoMapper.updateByEmail(bean, email);
	}

	/**
	 * 根据Email删除
	 */
	@Override
	public Integer deleteAppUserInfoByEmail(String email) {
		return this.appUserInfoMapper.deleteByEmail(email);
	}
}