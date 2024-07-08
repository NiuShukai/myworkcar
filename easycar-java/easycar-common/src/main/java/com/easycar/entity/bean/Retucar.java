package com.easycar.entity.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import com.easycar.entity.enums.DateTimePatternEnum;
import com.easycar.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * 
 */
public class Retucar implements Serializable {


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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date returnTime;

	/**
	 * 
	 */
	private String carCondition;

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

	public void setCreatedTime(Date createdTime){
		this.createdTime = createdTime;
	}

	public Date getCreatedTime(){
		return this.createdTime;
	}

	public void setReturnTime(Date returnTime){
		this.returnTime = returnTime;
	}

	public Date getReturnTime(){
		return this.returnTime;
	}

	public void setCarCondition(String carCondition){
		this.carCondition = carCondition;
	}

	public String getCarCondition(){
		return this.carCondition;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	@Override
	public String toString (){
		return "returnId:"+(returnId == null ? "空" : returnId)+"，vehicleId:"+(vehicleId == null ? "空" : vehicleId)+"，driverId:"+(driverId == null ? "空" : driverId)+"，createdTime:"+(createdTime == null ? "空" : DateUtil.format(createdTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，returnTime:"+(returnTime == null ? "空" : DateUtil.format(returnTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，carCondition:"+(carCondition == null ? "空" : carCondition)+"，status:"+(status == null ? "空" : status);
	}
}
