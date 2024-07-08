package com.easycar.service;

import com.easycar.entity.querybean.BaseParam;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 参数
 */
public class OrdersQuery extends BaseParam {


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

	private String startlocationFuzzy;

	/**
	 * 
	 */
	private String endlocation;

	private String endlocationFuzzy;

	/**
	 * 
	 */
	private String starttime;

	private String starttimeStart;

	private String starttimeEnd;

	/**
	 * 
	 */
	private String endtime;

	private String endtimeStart;

	private String endtimeEnd;

	/**
	 * 
	 */
	private Integer status;

	/**
	 * 
	 */
	private String createdTime;

	private String createdTimeStart;

	private String createdTimeEnd;

	/**
	 * 
	 */
	private String overTime;

	private String overTimeStart;

	private String overTimeEnd;

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

	private String startlatitudeFuzzy;

	/**
	 * 
	 */
	private String startlongtitude;

	private String startlongtitudeFuzzy;

	/**
	 * 
	 */
	private String endlatitude;

	private String endlatitudeFuzzy;

	/**
	 * 
	 */
	private String endlongtitude;

	private String endlongtitudeFuzzy;


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

	public void setStartlocationFuzzy(String startlocationFuzzy){
		this.startlocationFuzzy = startlocationFuzzy;
	}

	public String getStartlocationFuzzy(){
		return this.startlocationFuzzy;
	}

	public void setEndlocation(String endlocation){
		this.endlocation = endlocation;
	}

	public String getEndlocation(){
		return this.endlocation;
	}

	public void setEndlocationFuzzy(String endlocationFuzzy){
		this.endlocationFuzzy = endlocationFuzzy;
	}

	public String getEndlocationFuzzy(){
		return this.endlocationFuzzy;
	}

	public void setStarttime(String starttime){
		this.starttime = starttime;
	}

	public String getStarttime(){
		return this.starttime;
	}

	public void setStarttimeStart(String starttimeStart){
		this.starttimeStart = starttimeStart;
	}

	public String getStarttimeStart(){
		return this.starttimeStart;
	}
	public void setStarttimeEnd(String starttimeEnd){
		this.starttimeEnd = starttimeEnd;
	}

	public String getStarttimeEnd(){
		return this.starttimeEnd;
	}

	public void setEndtime(String endtime){
		this.endtime = endtime;
	}

	public String getEndtime(){
		return this.endtime;
	}

	public void setEndtimeStart(String endtimeStart){
		this.endtimeStart = endtimeStart;
	}

	public String getEndtimeStart(){
		return this.endtimeStart;
	}
	public void setEndtimeEnd(String endtimeEnd){
		this.endtimeEnd = endtimeEnd;
	}

	public String getEndtimeEnd(){
		return this.endtimeEnd;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
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

	public void setOverTime(String overTime){
		this.overTime = overTime;
	}

	public String getOverTime(){
		return this.overTime;
	}

	public void setOverTimeStart(String overTimeStart){
		this.overTimeStart = overTimeStart;
	}

	public String getOverTimeStart(){
		return this.overTimeStart;
	}
	public void setOverTimeEnd(String overTimeEnd){
		this.overTimeEnd = overTimeEnd;
	}

	public String getOverTimeEnd(){
		return this.overTimeEnd;
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

	public void setStartlatitudeFuzzy(String startlatitudeFuzzy){
		this.startlatitudeFuzzy = startlatitudeFuzzy;
	}

	public String getStartlatitudeFuzzy(){
		return this.startlatitudeFuzzy;
	}

	public void setStartlongtitude(String startlongtitude){
		this.startlongtitude = startlongtitude;
	}

	public String getStartlongtitude(){
		return this.startlongtitude;
	}

	public void setStartlongtitudeFuzzy(String startlongtitudeFuzzy){
		this.startlongtitudeFuzzy = startlongtitudeFuzzy;
	}

	public String getStartlongtitudeFuzzy(){
		return this.startlongtitudeFuzzy;
	}

	public void setEndlatitude(String endlatitude){
		this.endlatitude = endlatitude;
	}

	public String getEndlatitude(){
		return this.endlatitude;
	}

	public void setEndlatitudeFuzzy(String endlatitudeFuzzy){
		this.endlatitudeFuzzy = endlatitudeFuzzy;
	}

	public String getEndlatitudeFuzzy(){
		return this.endlatitudeFuzzy;
	}

	public void setEndlongtitude(String endlongtitude){
		this.endlongtitude = endlongtitude;
	}

	public String getEndlongtitude(){
		return this.endlongtitude;
	}

	public void setEndlongtitudeFuzzy(String endlongtitudeFuzzy){
		this.endlongtitudeFuzzy = endlongtitudeFuzzy;
	}

	public String getEndlongtitudeFuzzy(){
		return this.endlongtitudeFuzzy;
	}

}
