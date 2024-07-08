package com.easycar.entity.querybean;



/**
 * 司机管理表参数
 */
public class DriverQuery extends BaseParam {


	/**
	 * 司机ID
	 */
	private Integer driverId;

	/**
	 * 司机姓名
	 */
	private String driverName;

	private String driverNameFuzzy;

	/**
	 * 联系电话
	 */
	private String phone;

	private String phoneFuzzy;

	/**
	 * 驾照号码
	 */
	private String licenseNumber;

	private String licenseNumberFuzzy;

	/**
	 * 司机状态（0空闲、1驾驶中、2休息中等）
	 */
	private Integer status;

	/**
	 * 家庭住址
	 */
	private String address;

	private String addressFuzzy;


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

	public void setDriverNameFuzzy(String driverNameFuzzy){
		this.driverNameFuzzy = driverNameFuzzy;
	}

	public String getDriverNameFuzzy(){
		return this.driverNameFuzzy;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return this.phone;
	}

	public void setPhoneFuzzy(String phoneFuzzy){
		this.phoneFuzzy = phoneFuzzy;
	}

	public String getPhoneFuzzy(){
		return this.phoneFuzzy;
	}

	public void setLicenseNumber(String licenseNumber){
		this.licenseNumber = licenseNumber;
	}

	public String getLicenseNumber(){
		return this.licenseNumber;
	}

	public void setLicenseNumberFuzzy(String licenseNumberFuzzy){
		this.licenseNumberFuzzy = licenseNumberFuzzy;
	}

	public String getLicenseNumberFuzzy(){
		return this.licenseNumberFuzzy;
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

	public void setAddressFuzzy(String addressFuzzy){
		this.addressFuzzy = addressFuzzy;
	}

	public String getAddressFuzzy(){
		return this.addressFuzzy;
	}

}
