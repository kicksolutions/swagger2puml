/**
 * 
 */
package com.kicksolutions.swagger.plantuml.vo;

/**
 * @author MSANTOSH
 *
 */
public class ClassMembers {

	private String dataType;
	private String name;
	private String className;
	private String cardinality;
	
	public ClassMembers() {
		super();
	}

	public ClassMembers(String dataType, String name, String className, String cardinality) {
		super();
		this.dataType = dataType;
		this.name = name;
		this.className = className;
		this.cardinality = cardinality;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCardinality() {
		return cardinality;
	}

	public void setCardinality(String cardinality) {
		this.cardinality = cardinality;
	}

	@Override
	public String toString() {
		return "ClassMembers [dataType=" + dataType + ", name=" + name + ", className=" + className + ", cardinality="
				+ cardinality + "]";
	}	
}
