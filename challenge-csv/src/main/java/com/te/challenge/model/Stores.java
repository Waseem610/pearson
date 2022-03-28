package com.te.challenge.model;

import java.util.Date;

import lombok.Data;

@Data
public class Stores {

	private String storeId;
	private String postCode;
	private String city;
	private String address;
	private Date date;
}
