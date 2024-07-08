package com.easycar.controller;

import java.util.List;

import com.easycar.entity.querybean.RetucarQuery;
import com.easycar.entity.bean.Retucar;
import com.easycar.entity.vo.ResponseVO;
import com.easycar.service.RetucarService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("retucarController")
@RequestMapping("/retucar")
public class RetucarController extends ABaseController{

	@Resource
	private RetucarService retucarService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(RetucarQuery query){
		return getSuccessResponseVO(retucarService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(Retucar bean) {
		retucarService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Retucar> listBean) {
		retucarService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Retucar> listBean) {
		retucarService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据ReturnId查询对象
	 */
	@RequestMapping("/getRetucarByReturnId")
	public ResponseVO getRetucarByReturnId(Integer returnId) {
		return getSuccessResponseVO(retucarService.getRetucarByReturnId(returnId));
	}

	/**
	 * 根据ReturnId修改对象
	 */
	@RequestMapping("/updateRetucarByReturnId")
	public ResponseVO updateRetucarByReturnId(Retucar bean,Integer returnId) {
		retucarService.updateRetucarByReturnId(bean,returnId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据ReturnId删除
	 */
	@RequestMapping("/deleteRetucarByReturnId")
	public ResponseVO deleteRetucarByReturnId(Integer returnId) {
		retucarService.deleteRetucarByReturnId(returnId);
		return getSuccessResponseVO(null);
	}
}