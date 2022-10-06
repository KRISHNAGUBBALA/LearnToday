package com.dxc.learntoday.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LTAErrorResponce {
	
	public int status;
	public String message;
	
	public LTAErrorResponce() {
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
