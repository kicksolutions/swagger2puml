/**
 * 
 */
package com.kicksolutions.swagger.plantuml.vo;

/**
 * @author MSANTOSH
 *
 */
public class ClassRelation {

	private String targetClass;
	private boolean isExtension;
	private boolean isComposition;
	private String cardinality;
	private String sourceClass;
	
	public ClassRelation() {
		super();
	}
	
	public ClassRelation(String targetClass, boolean isExtension, boolean isComposition,String cardinality,String sourceClass) {
		super();
		this.targetClass = targetClass;
		this.isExtension = isExtension;
		this.isComposition = isComposition;
		this.cardinality = cardinality;
		this.sourceClass = sourceClass;
	}

	public String getTargetClass() {
		return targetClass;
	}

	public void setTargetClass(String targetClass) {
		this.targetClass = targetClass;
	}

	public boolean isExtension() {
		return isExtension;
	}

	public void setExtension(boolean isExtension) {
		this.isExtension = isExtension;
	}

	public boolean isComposition() {
		return isComposition;
	}

	public void setComposition(boolean isComposition) {
		this.isComposition = isComposition;
	}

	public String getCardinality() {
		return cardinality;
	}

	public void setCardinality(String cardinality) {
		this.cardinality = cardinality;
	}

	public String getSourceClass() {
		return sourceClass;
	}

	public void setSourceClass(String sourceClass) {
		this.sourceClass = sourceClass;
	}

	@Override
	public String toString() {
		return "ClassRelation [targetClass=" + targetClass + ", isExtension=" + isExtension + ", isComposition="
				+ isComposition + ", cardinality=" + cardinality + ", sourceClass=" + sourceClass + "]";
	}
}
