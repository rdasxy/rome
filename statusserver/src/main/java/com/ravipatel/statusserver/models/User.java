package com.ravipatel.statusserver.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user", catalog = "status", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8512854518513931599L;
	private Integer id;
	private Company company;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String lastLoginDate;
	private Set<UserState> userStates = new HashSet<UserState>(0);
	private Set<LicenseUserCompany> licenseUserCompanies = new HashSet<LicenseUserCompany>(0);
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	public User() {
	}

	public User(Company company, String password, String email,
			String firstName, String lastName, String lastLoginDate) {
		this.company = company;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastLoginDate = lastLoginDate;
	}

	public User(Company company, String password, String email,
			String firstName, String lastName, String lastLoginDate,
			Set<UserState> userStates, Set<LicenseUserCompany> licenseUserCompanies, Set<UserRole> userRoles) {
		this.company = company;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastLoginDate = lastLoginDate;
		this.userStates = userStates;
		this.licenseUserCompanies = licenseUserCompanies;
		this.userRoles = userRoles;
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

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id", nullable = false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@JsonIgnore
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", unique = true, nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty(value="first_name")
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty(value="last_name")
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty(value="last_login_date")
	@Column(name = "last_login_date", nullable = false, length = 16777215)
	public String getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserState> getUserStates() {
		return this.userStates;
	}

	public void setUserStates(Set<UserState> userStates) {
		this.userStates = userStates;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<LicenseUserCompany> getLicenseUserCompanies() {
		return this.licenseUserCompanies;
	}

	public void setLicenseUserCompanies(Set<LicenseUserCompany> licenseUserCompanies) {
		this.licenseUserCompanies = licenseUserCompanies;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}
