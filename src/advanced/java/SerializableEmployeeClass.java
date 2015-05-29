package advanced.java;

import java.io.Serializable;

public class SerializableEmployeeClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String department;
	private transient int ssn;//declare as transient if you dont want this field to be serialized also int primitive type is nt serializable
	private Long id;
	
	public SerializableEmployeeClass(String name, String department, int ssn,
			Long id) {
		super();
		this.name = name;
		this.department = department;
		this.ssn = ssn;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
