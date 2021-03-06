package com.mssoftech.springreact.domain;
// Generated 2015/8/3 下午 02:20:55 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Session generated by hbm2java
 */
@Entity
@Table(name = "session", uniqueConstraints = @UniqueConstraint(columnNames = "uuid") )
public class Session implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2656700464566442638L;
	private Integer id;
	private Login login;
	private String uuid;
	private String role;
	private String data;
	private int versionNo;
	private int delFlag;
	private Date registerDatetime;
	private String registerUser;
	private String registerProcess;
	private Date updateDatetime;
	private String updateUser;
	private String updateProcess;

	public Session() {
	}

	public Session(String uuid, int versionNo, int delFlag, Date registerDatetime, String registerUser,
			String registerProcess, Date updateDatetime, String updateUser, String updateProcess) {
		this.uuid = uuid;
		this.versionNo = versionNo;
		this.delFlag = delFlag;
		this.registerDatetime = registerDatetime;
		this.registerUser = registerUser;
		this.registerProcess = registerProcess;
		this.updateDatetime = updateDatetime;
		this.updateUser = updateUser;
		this.updateProcess = updateProcess;
	}

	public Session(Login login, String uuid, String role, String data, int versionNo, int delFlag,
			Date registerDatetime, String registerUser, String registerProcess, Date updateDatetime, String updateUser,
			String updateProcess) {
		this.login = login;
		this.uuid = uuid;
		this.role = role;
		this.data = data;
		this.versionNo = versionNo;
		this.delFlag = delFlag;
		this.registerDatetime = registerDatetime;
		this.registerUser = registerUser;
		this.registerProcess = registerProcess;
		this.updateDatetime = updateDatetime;
		this.updateUser = updateUser;
		this.updateProcess = updateProcess;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "login_id")
	public Login getLogin() {
		return this.login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Column(name = "uuid", unique = true, nullable = false, length = 50)
	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Column(name = "role", length = 5)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "data")
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Column(name = "version_no", nullable = false)
	public int getVersionNo() {
		return this.versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

	@Column(name = "del_flag", nullable = false)
	public int getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "register_datetime", nullable = false, length = 19)
	public Date getRegisterDatetime() {
		return this.registerDatetime;
	}

	public void setRegisterDatetime(Date registerDatetime) {
		this.registerDatetime = registerDatetime;
	}

	@Column(name = "register_user", nullable = false, length = 30)
	public String getRegisterUser() {
		return this.registerUser;
	}

	public void setRegisterUser(String registerUser) {
		this.registerUser = registerUser;
	}

	@Column(name = "register_process", nullable = false, length = 30)
	public String getRegisterProcess() {
		return this.registerProcess;
	}

	public void setRegisterProcess(String registerProcess) {
		this.registerProcess = registerProcess;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_datetime", nullable = false, length = 19)
	public Date getUpdateDatetime() {
		return this.updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	@Column(name = "update_user", nullable = false, length = 30)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "update_process", nullable = false, length = 30)
	public String getUpdateProcess() {
		return this.updateProcess;
	}

	public void setUpdateProcess(String updateProcess) {
		this.updateProcess = updateProcess;
	}

}
