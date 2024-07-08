package com.easycar.entity.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;


/**
 * 车辆管理表
 */
public class Vehicle implements Serializable {


	/**
	 * 车辆ID
	 */
	private Integer vehicleId;

	/**
	 * 车牌号
	 */
	private String licensePlate;

	/**
	 * 车辆型号
	 */
	private String vehicleModel;

	/**
	 * 车辆状态（1可用、0维修中、1已派出等
	 */
	private Integer vehicleStatus;

	/**
	 * 车辆图片
	 */
	private String vehiclePhoto;

	/**
	 * 车辆座位数
	 */
	private Integer vehicleSeat;


	public void setVehicleId(Integer vehicleId){
		this.vehicleId = vehicleId;
	}

	public Integer getVehicleId(){
		return this.vehicleId;
	}

	public void setLicensePlate(String licensePlate){
		this.licensePlate = licensePlate;
	}

	public String getLicensePlate(){
		return this.licensePlate;
	}

	public void setVehicleModel(String vehicleModel){
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleModel(){
		return this.vehicleModel;
	}

	public void setVehicleStatus(Integer vehicleStatus){
		this.vehicleStatus = vehicleStatus;
	}

	public Integer getVehicleStatus(){
		return this.vehicleStatus;
	}

	public void setVehiclePhoto(String vehiclePhoto){
		this.vehiclePhoto = vehiclePhoto;
	}

	public String getVehiclePhoto(){
		return this.vehiclePhoto;
	}

	public void setVehicleSeat(Integer vehicleSeat){
		this.vehicleSeat = vehicleSeat;
	}

	public Integer getVehicleSeat(){
		return this.vehicleSeat;
	}

	@Override
	public String toString (){
		return "车辆ID:"+(vehicleId == null ? "空" : vehicleId)+"，车牌号:"+(licensePlate == null ? "空" : licensePlate)+"，车辆型号:"+(vehicleModel == null ? "空" : vehicleModel)+"，车辆状态（1可用、0维修中、1已派出等:"+(vehicleStatus == null ? "空" : vehicleStatus)+"，车辆图片:"+(vehiclePhoto == null ? "空" : vehiclePhoto)+"，车辆座位数:"+(vehicleSeat == null ? "空" : vehicleSeat);
	}
}
