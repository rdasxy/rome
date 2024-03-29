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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "state", catalog = "status")
public class State implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -581718542218171797L;
	private Integer id;
	private String name;
	private byte isInterruptible;
	private Set<UserState> userStates = new HashSet<UserState>(0);

	public State() {
	}

	public State(String name, byte isInterruptible) {
		this.name = name;
		this.isInterruptible = isInterruptible;
	}

	public State(String name, byte isInterruptible, Set<UserState> userStates) {
		this.name = name;
		this.isInterruptible = isInterruptible;
		this.userStates = userStates;
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

	@JsonProperty(value="is_interruptible")
	@Column(name = "is_interruptible", nullable = false)
	public byte getIsInterruptible() {
		return this.isInterruptible;
	}

	public void setIsInterruptible(byte isInterruptible) {
		this.isInterruptible = isInterruptible;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
	public Set<UserState> getUserStates() {
		return this.userStates;
	}

	public void setUserStates(Set<UserState> userStates) {
		this.userStates = userStates;
	}

}
