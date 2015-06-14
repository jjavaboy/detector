package com.lam.alarm.structure;

import java.io.File;
import java.util.Set;

/**
 *@Title:WDFile.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-3-29 ÉÏÎç01:27:07
 *@Version:1.0
 */
public class WDFile {
	
	private String name;
	
	private WDFile parent;
	
	private Set<WDFile> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WDFile getParent() {
		return parent;
	}

	public void setParent(WDFile parent) {
		this.parent = parent;
	}

	public Set<WDFile> getChildren() {
		return children;
	}

	public void setChildren(Set<WDFile> children) {
		this.children = children; File f = null; 
	}
	
	
	

}

