package com.easycar.entity.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;


/**
 * 司机管理表
 */
public class Driver implements Serializable {


	/**
	 * 司机ID
	 */
	private Integer driverId;

	/**
	 * 司机姓名
	 */
	private String driverName;

	/**
	 * 联系电话
	 */
	private String phone;

	/**
	 * 驾照号码
	 */
	private String licenseNumber;

	/**
	 * 司机状态（0空闲、1驾驶中、2休息中等）
	 */
	private Integer status;

	/**
	 * 家庭住址
	 */
	private String address;


	public void setDriverId(Integer driverId){
		this.driverId = driverId;
	}

	public Integer getDriverId(){
		return this.driverId;
	}

	public void setDriverName(String driverName){
		this.driverName = driverName;
	}

	public String getDriverName(){
		return this.driverName;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return this.phone;
	}

	public void setLicenseNumber(String licenseNumber){
		this.licenseNumber = licenseNumber;
	}

	public String getLicenseNumber(){
		return this.licenseNumber;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return this.address;
	}

	@Override
	public String toString (){
		return "司机ID:"+(driverId == null ? "空" : driverId)+"，司机姓名:"+(driverName == null ? "空" : driverName)+"，联系电话:"+(phone == null ? "空" : phone)+"，驾照号码:"+(licenseNumber == null ? "空" : licenseNumber)+"，司机状态（0空闲、1驾驶中、2休息中等）:"+(status == null ? "空" : status)+"，家庭住址:"+(address == null ? "空" : address);
	}
}
