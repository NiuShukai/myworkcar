package com.easycar.entity.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.Date;
import com.easycar.entity.enums.DateTimePatternEnum;
import com.easycar.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * 
 */
public class Orders implements Serializable {


	/**
	 * 
	 */
	private Integer ordersId;

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
	private String startlocation;

	/**
	 * 
	 */
	private String endlocation;

	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date starttime;

	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endtime;

	/**
	 * 
	 */
	private Integer status;

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
	private Date overTime;

	/**
	 * 
	 */
	private BigDecimal price;

	/**
	 * 
	 */
	private Integer duration;

	/**
	 * 
	 */
	private String startlatitude;

	/**
	 * 
	 */
	private String startlongtitude;

	/**
	 * 
	 */
	private String endlatitude;

	/**
	 * 
	 */
	private String endlongtitude;

	/**
	 * 
	 */
	private Integer appuserId;


	public void setOrdersId(Integer ordersId){
		this.ordersId = ordersId;
	}

	public Integer getOrdersId(){
		return this.ordersId;
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

	public void setStartlocation(String startlocation){
		this.startlocation = startlocation;
	}

	public String getStartlocation(){
		return this.startlocation;
	}

	public void setEndlocation(String endlocation){
		this.endlocation = endlocation;
	}

	public String getEndlocation(){
		return this.endlocation;
	}

	public void setStarttime(Date starttime){
		this.starttime = starttime;
	}

	public Date getStarttime(){
		return this.starttime;
	}

	public void setEndtime(Date endtime){
		this.endtime = endtime;
	}

	public Date getEndtime(){
		return this.endtime;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setCreatedTime(Date createdTime){
		this.createdTime = createdTime;
	}

	public Date getCreatedTime(){
		return this.createdTime;
	}

	public void setOverTime(Date overTime){
		this.overTime = overTime;
	}

	public Date getOverTime(){
		return this.overTime;
	}

	public void setPrice(BigDecimal price){
		this.price = price;
	}

	public BigDecimal getPrice(){
		return this.price;
	}

	public void setDuration(Integer duration){
		this.duration = duration;
	}

	public Integer getDuration(){
		return this.duration;
	}

	public void setStartlatitude(String startlatitude){
		this.startlatitude = startlatitude;
	}

	public String getStartlatitude(){
		return this.startlatitude;
	}

	public void setStartlongtitude(String startlongtitude){
		this.startlongtitude = startlongtitude;
	}

	public String getStartlongtitude(){
		return this.startlongtitude;
	}

	public void setEndlatitude(String endlatitude){
		this.endlatitude = endlatitude;
	}

	public String getEndlatitude(){
		return this.endlatitude;
	}

	public void setEndlongtitude(String endlongtitude){
		this.endlongtitude = endlongtitude;
	}

	public String getEndlongtitude(){
		return this.endlongtitude;
	}

	public void setAppuserId(Integer appuserId){
		this.appuserId = appuserId;
	}

	public Integer getAppuserId(){
		return this.appuserId;
	}

	@Override
	public String toString (){
		return "ordersId:"+(ordersId == null ? "空" : ordersId)+"，vehicleId:"+(vehicleId == null ? "空" : vehicleId)+"，driverId:"+(driverId == null ? "空" : driverId)+"，startlocation:"+(startlocation == null ? "空" : startlocation)+"，endlocation:"+(endlocation == null ? "空" : endlocation)+"，starttime:"+(starttime == null ? "空" : DateUtil.format(starttime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，endtime:"+(endtime == null ? "空" : DateUtil.format(endtime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，status:"+(status == null ? "空" : status)+"，createdTime:"+(createdTime == null ? "空" : DateUtil.format(createdTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，overTime:"+(overTime == null ? "空" : DateUtil.format(overTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，price:"+(price == null ? "空" : price)+"，duration:"+(duration == null ? "空" : duration)+"，startlatitude:"+(startlatitude == null ? "空" : startlatitude)+"，startlongtitude:"+(startlongtitude == null ? "空" : startlongtitude)+"，endlatitude:"+(endlatitude == null ? "空" : endlatitude)+"，endlongtitude:"+(endlongtitude == null ? "空" : endlongtitude)+"，appuserId:"+(appuserId == null ? "空" : appuserId);
	}
}
