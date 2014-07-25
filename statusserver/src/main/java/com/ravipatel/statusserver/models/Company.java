package com.ravipatel.statusserver.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "company", catalog = "status")
public class Company implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7674162647922395343L;
	private Integer id;
	private String name;
	private int licensesPurchased;
	private Set<User> users = new HashSet<User>(0);
	private Set<LicenseUserCompany> licenseUserCompanies = new HashSet<LicenseUserCompany>(0);

	public Company() {
	}

	public Company(String name, int licensesPurchased) {
		this.name = name;
		this.licensesPurchased = licensesPurchased;
	}

	public Company(String name, int licensesPurchased, Set<User> users,
			Set<LicenseUserCompany> licenseUserCompanies) {
		this.name = name;
		this.licensesPurchased = licensesPurchased;
		this.users = users;
		this.licenseUserCompanies = licenseUserCompanies;
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

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "licenses_purchased", nullable = false)
	public int getLicensesPurchased() {
		return this.licensesPurchased;
	}

	public void setLicensesPurchased(int licensesPurchased) {
		this.licensesPurchased = licensesPurchased;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<LicenseUserCompany> getLicenseUserCompanies() {
		return this.licenseUserCompanies;
	}

	public void setLicenseUserCompanies(Set<LicenseUserCompany> licenseUserCompanies) {
		this.licenseUserCompanies = licenseUserCompanies;
	}

}
