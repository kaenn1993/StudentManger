package com.school.bean;

public class School {
	 int id;
	 String schoolname;
	 String address;
	 String buildtime;
	 String countryname;
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return schoolname
	 */
	public String getSchoolname() {
		return schoolname;
	}
	/**
	 * @param schoolname セットする schoolname
	 */
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return buildtime
	 */
	public String getBuildtime() {
		return buildtime;
	}
	/**
	 * @param buildtime セットする buildtime
	 */
	public void setBuildtime(String buildtime) {
		this.buildtime = buildtime;
	}
	/**
	 * @return countryname
	 */
	public String getCountryname() {
		return countryname;
	}
	/**
	 * @param countryname セットする countryname
	 */
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((buildtime == null) ? 0 : buildtime.hashCode());
		result = prime * result + ((countryname == null) ? 0 : countryname.hashCode());
		result = prime * result + id;
		result = prime * result + ((schoolname == null) ? 0 : schoolname.hashCode());
		return result;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		School other = (School) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (buildtime == null) {
			if (other.buildtime != null)
				return false;
		} else if (!buildtime.equals(other.buildtime))
			return false;
		if (countryname == null) {
			if (other.countryname != null)
				return false;
		} else if (!countryname.equals(other.countryname))
			return false;
		if (id != other.id)
			return false;
		if (schoolname == null) {
			if (other.schoolname != null)
				return false;
		} else if (!schoolname.equals(other.schoolname))
			return false;
		return true;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "School [id=" + id + ", schoolname=" + schoolname + ", address=" + address + ", buildtime=" + buildtime
				+ ", countryname=" + countryname + "]";
	}
	/**
	 * @param id
	 * @param schoolname
	 * @param address
	 * @param buildtime
	 * @param countryname
	 */
	public School(int id, String schoolname, String address, String buildtime, String countryname) {
		super();
		this.id = id;
		this.schoolname = schoolname;
		this.address = address;
		this.buildtime = buildtime;
		this.countryname = countryname;
	}
	/**
	 *
	 */
	public School() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}


}
