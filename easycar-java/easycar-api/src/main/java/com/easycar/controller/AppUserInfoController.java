package com.easycar.controller;

import java.util.Date;
import java.util.List;

import com.easycar.entity.enums.ResponseCodeEnum;
import com.easycar.entity.querybean.AppUserInfoQuery;
import com.easycar.entity.bean.AppUserInfo;
import com.easycar.entity.vo.ResponseVO;
import com.easycar.service.AppUserInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 *  Controller
 */
@RestController("appUserInfoController")
@RequestMapping("/appUserInfo")
public class AppUserInfoController extends ABaseController{

	@Resource
	private AppUserInfoService appUserInfoService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(AppUserInfoQuery query){
		return getSuccessResponseVO(appUserInfoService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/register")
	public ResponseVO register(@RequestBody AppUserInfo userInfo) {
		Date currentTime = new Date();
		userInfo.setJoinTime(currentTime);
		appUserInfoService.add(userInfo);
		return getSuccessResponseVO(null);
	}
	@RequestMapping("/login")
	public ResponseVO login(@RequestBody AppUserInfo userInfo, HttpServletRequest request) {
		Date currentTime = new Date();
		//拿到用户输入账号密码
		String inputemail=userInfo.getEmail();
		String inputpassword=userInfo.getPassword();
		//根据账号查询数据库
		AppUserInfo user=appUserInfoService.getAppUserInfoByEmail(inputemail);
		//
		if(user==null){
			return getErrorResponseVO(ResponseCodeEnum.CODE_602,null);
		}
		if(!userInfo.getPassword().equals(user.getPassword())){
			return  getErrorResponseVO(ResponseCodeEnum.CODE_602,null);
		}
		String remoteAddr = request.getRemoteAddr();
		user.setLastLoginIp(remoteAddr);
		user.setLastLoginTime(currentTime);
		appUserInfoService.updateAppUserInfoByUserId(user, String.valueOf(user.getUserId()));
		return getSuccessResponseVO(user);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<AppUserInfo> listBean) {
		appUserInfoService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<AppUserInfo> listBean) {
		appUserInfoService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据UserId查询对象
	 */
	@RequestMapping("/getAppUserInfoByUserId")
	public ResponseVO getAppUserInfoByUserId(String userId) {
		return getSuccessResponseVO(appUserInfoService.getAppUserInfoByUserId(userId));
	}

	/**
	 * 根据UserId修改对象
	 */
	@RequestMapping("/updateAppUserInfoByUserId")
	public ResponseVO updateAppUserInfoByUserId(@RequestBody AppUserInfo bean) {
		appUserInfoService.updateAppUserInfoByUserId(bean, String.valueOf(bean.getUserId()));
		return getSuccessResponseVO(bean);
	}

	/**
	 * 根据UserId删除
	 */
	@RequestMapping("/deleteAppUserInfoByUserId")
	public ResponseVO deleteAppUserInfoByUserId(String userId) {
		appUserInfoService.deleteAppUserInfoByUserId(userId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Email查询对象
	 */
	@RequestMapping("/getAppUserInfoByEmail")
	public ResponseVO getAppUserInfoByEmail(String email) {
		return getSuccessResponseVO(appUserInfoService.getAppUserInfoByEmail(email));
	}

	/**
	 * 根据Email修改对象
	 */
	@RequestMapping("/updateAppUserInfoByEmail")
	public ResponseVO updateAppUserInfoByEmail(AppUserInfo bean,String email) {
		appUserInfoService.updateAppUserInfoByEmail(bean,email);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Email删除
	 */
	@RequestMapping("/deleteAppUserInfoByEmail")
	public ResponseVO deleteAppUserInfoByEmail(String email) {
		appUserInfoService.deleteAppUserInfoByEmail(email);
		return getSuccessResponseVO(null);
	}
}