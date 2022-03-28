package com.te.challenge.service;

import java.util.List;

import com.te.challenge.model.Stores;

public interface StoreSevice {
	
	public Stores getStoreById(String storeId);

	public List<Stores> getStoresOrderesByCity();

	public List<Stores> getStoresOrderesByDate();
}
