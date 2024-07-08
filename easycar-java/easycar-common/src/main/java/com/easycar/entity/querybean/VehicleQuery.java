package com.easycar.entity.querybean;



/**
 * 车辆管理表参数
 */
public class VehicleQuery extends BaseParam {


	/**
	 * 车辆ID
	 */
	private Integer vehicleId;

	/**
	 * 车牌号
	 */
	private String licensePlate;

	private String licensePlateFuzzy;

	/**
	 * 车辆型号
	 */
	private String vehicleModel;

	private String vehicleModelFuzzy;

	/**
	 * 车辆状态（1可用、0维修中、1已派出等
	 */
	private Integer vehicleStatus;

	/**
	 * 车辆图片
	 */
	private String vehiclePhoto;

	private String vehiclePhotoFuzzy;

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

	public void setLicensePlateFuzzy(String licensePlateFuzzy){
		this.licensePlateFuzzy = licensePlateFuzzy;
	}

	public String getLicensePlateFuzzy(){
		return this.licensePlateFuzzy;
	}

	public void setVehicleModel(String vehicleModel){
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleModel(){
		return this.vehicleModel;
	}

	public void setVehicleModelFuzzy(String vehicleModelFuzzy){
		this.vehicleModelFuzzy = vehicleModelFuzzy;
	}

	public String getVehicleModelFuzzy(){
		return this.vehicleModelFuzzy;
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

	public void setVehiclePhotoFuzzy(String vehiclePhotoFuzzy){
		this.vehiclePhotoFuzzy = vehiclePhotoFuzzy;
	}

	public String getVehiclePhotoFuzzy(){
		return this.vehiclePhotoFuzzy;
	}

	public void setVehicleSeat(Integer vehicleSeat){
		this.vehicleSeat = vehicleSeat;
	}

	public Integer getVehicleSeat(){
		return this.vehicleSeat;
	}

}
