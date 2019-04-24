package com.teacher.bean;

public class Teacher {
	int id;
	String teachername;
	String course;
	String birthday;

	/**
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday セットする birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
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
	 * @return teachername
	 */
	public String getTeachername() {
		return teachername;
	}
	/**
	 * @param teachername セットする teachername
	 */
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	/**
	 * @return course
	 */
	public String getCourse() {
		return course;
	}
	/**
	 * @param course セットする course
	 */
	public void setCourse(String course) {
		this.course = course;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + id;
		result = prime * result + ((teachername == null) ? 0 : teachername.hashCode());
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
		Teacher other = (Teacher) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (id != other.id)
			return false;
		if (teachername == null) {
			if (other.teachername != null)
				return false;
		} else if (!teachername.equals(other.teachername))
			return false;
		return true;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teachername=" + teachername + ", course=" + course + "]";
	}
	/**
	 * @param id
	 * @param teachername
	 * @param course
	 */
	public Teacher(int id, String teachername, String course) {
		super();
		this.id = id;
		this.teachername = teachername;
		this.course = course;
	}
	/**
	 *
	 */
	public Teacher() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}


}
