package com.easycar.entity.querybean;

import java.util.Date;


/**
 * 参数
 */
public class RetucarQuery extends BaseParam {


	/**
	 * 
	 */
	private Integer returnId;

	/**
	 * 
	 */
	private Integer vehicleId;

	/**
	 * 
	 */
	private Integer driverId;

	/**
	 * 
	 */
	private String createdTime;

	private String createdTimeStart;

	private String createdTimeEnd;

	/**
	 * 
	 */
	private String returnTime;

	private String returnTimeStart;

	private String returnTimeEnd;

	/**
	 * 
	 */
	private String carCondition;

	private String carConditionFuzzy;

	/**
	 * 
	 */
	private Integer status;


	public void setReturnId(Integer returnId){
		this.returnId = returnId;
	}

	public Integer getReturnId(){
		return this.returnId;
	}

	public void setVehicleId(Integer vehicleId){
		this.vehicleId = vehicleId;
	}

	public Integer getVehicleId(){
		return this.vehicleId;
	}

	public void setDriverId(Integer driverId){
		this.driverId = driverId;
	}

	public Integer getDriverId(){
		return this.driverId;
	}

	public void setCreatedTime(String createdTime){
		this.createdTime = createdTime;
	}

	public String getCreatedTime(){
		return this.createdTime;
	}

	public void setCreatedTimeStart(String createdTimeStart){
		this.createdTimeStart = createdTimeStart;
	}

	public String getCreatedTimeStart(){
		return this.createdTimeStart;
	}
	public void setCreatedTimeEnd(String createdTimeEnd){
		this.createdTimeEnd = createdTimeEnd;
	}

	public String getCreatedTimeEnd(){
		return this.createdTimeEnd;
	}

	public void setReturnTime(String returnTime){
		this.returnTime = returnTime;
	}

	public String getReturnTime(){
		return this.returnTime;
	}

	public void setReturnTimeStart(String returnTimeStart){
		this.returnTimeStart = returnTimeStart;
	}

	public String getReturnTimeStart(){
		return this.returnTimeStart;
	}
	public void setReturnTimeEnd(String returnTimeEnd){
		this.returnTimeEnd = returnTimeEnd;
	}

	public String getReturnTimeEnd(){
		return this.returnTimeEnd;
	}

	public void setCarCondition(String carCondition){
		this.carCondition = carCondition;
	}

	public String getCarCondition(){
		return this.carCondition;
	}

	public void setCarConditionFuzzy(String carConditionFuzzy){
		this.carConditionFuzzy = carConditionFuzzy;
	}

	public String getCarConditionFuzzy(){
		return this.carConditionFuzzy;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

}
