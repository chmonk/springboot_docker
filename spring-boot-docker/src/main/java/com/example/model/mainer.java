package com.example.model;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class mainer<T extends ancient> {

	String ancient = "1";
	T mclass;
	public String getAncient() {
		return ancient;
	}
	public void setAncient(String ancient) {
		this.ancient = ancient;
	}
	public T getMclass() {
		return mclass;
	}
	public void setMclass(T mclass) {
		this.mclass = mclass;
	}

	
}
