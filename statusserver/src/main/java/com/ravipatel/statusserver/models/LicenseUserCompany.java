package com.ravipatel.statusserver.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "license_user_company", catalog = "status")
public class LicenseUserCompany implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -920690667194725200L;
	private Integer id;
	private User user;
	private Company company;
	private byte isActive;
	private String expirationDate;

	public LicenseUserCompany() {
	}

	public LicenseUserCompany(User user, Company company, byte isActive,
			String expirationDate) {
		this.user = user;
		this.company = company;
		this.isActive = isActive;
		this.expirationDate = expirationDate;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id", nullable = false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Column(name = "is_active", nullable = false)
	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	@Column(name = "expiration_date", nullable = false, length = 16777215)
	public String getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

}
