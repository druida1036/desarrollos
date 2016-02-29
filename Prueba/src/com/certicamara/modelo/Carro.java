package com.certicamara.modelo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("auto")
@Qualifier("auto")
public class Carro {
	private Integer xPos;
	private Integer yPos;
	
	public Integer getxPos() {
		return xPos;
	}
	public void setxPos(Integer xPos) {
		this.xPos = xPos;
	}
	public Integer getyPos() {
		return yPos;
	}
	public void setyPos(Integer yPos) {
		this.yPos = yPos;
	}
	
	

}
