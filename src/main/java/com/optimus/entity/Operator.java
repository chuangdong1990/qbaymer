package com.optimus.entity;


public class Operator {
	
	public String getUseruuid() {
		return useruuid;
	}
	public void setUseruuid(String useruuid) {
		this.useruuid = useruuid;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getMsgcode() {
		return msgcode;
	}
	public void setMsgcode(String msgcode) {
		this.msgcode = msgcode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBankcard() {
		return bankcard;
	}
	public void setBankcard(String bankcard) {
		this.bankcard = bankcard;
	}
	public String getIdcardmask() {
		return idcardmask;
	}
	public void setIdcardmask(String idcardmask) {
		this.idcardmask = idcardmask;
	}
	public String getBankcardmask() {
		return bankcardmask;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setBankcardmask(String bankcardmask) {
		this.bankcardmask = bankcardmask;
	}
	public String getMerchantno() {
		return merchantno;
	}
	public void setMerchantno(String merchantno) {
		this.merchantno = merchantno;
	}
	public String getMername() {
		return mername;
	}
	public void setMername(String mername) {
		this.mername = mername;
	}
	public float getDaprate() {
		return daprate;
	}
	public void setDaprate(float daprate) {
		this.daprate = daprate;
	}
	public String getCreate() {
		return create;
	}
	public void setCreate(String create) {
		this.create = create;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	private String useruuid;
	private String userphone;
	private String passwd;
	private String msgcode;
	private String username;
	private String idcard;
	private String bankname;
	private String bankcard;
	private String idcardmask;
	private String bankcardmask;
	private String merchantno;
	private String mername;
	private float daprate;
	private String create;
	private String status;
	private String type;
	private String roleType;//角色

}
