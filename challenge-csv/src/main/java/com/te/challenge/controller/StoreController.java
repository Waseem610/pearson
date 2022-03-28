package com.te.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.challenge.model.Stores;
import com.te.challenge.response.StoreResponse;
import com.te.challenge.response.StoresResponse;
import com.te.challenge.service.StoreSeviceImplementation;

@RestController
@RequestMapping("/stores/")
public class StoreController {
	@Autowired
	StoreSeviceImplementation seviceImplementation;

	@GetMapping("getAll")
	public ResponseEntity<StoresResponse> getAll() {
		StoresResponse storesResponse = new StoresResponse("Stores", seviceImplementation.getAll());
		return new ResponseEntity<StoresResponse>(storesResponse, HttpStatus.OK);
	}

	@GetMapping("getByStoreId")
	public ResponseEntity<StoreResponse> getByStoreId(@RequestParam String storeId) {
		Stores storeById = seviceImplementation.getStoreById(storeId);
		StoreResponse storeResponse = new StoreResponse();
		if (storeById == null) {
			storeResponse.setMessage("Invalid Store Id");
			storeResponse.setObject(null);
			return new ResponseEntity<StoreResponse>(storeResponse, HttpStatus.BAD_REQUEST);
		}
		storeResponse.setMessage("The Store Data Is");
		storeResponse.setObject(storeById);
		return new ResponseEntity<StoreResponse>(storeResponse, HttpStatus.OK);
	}

	@GetMapping("orederedByCities")
	public ResponseEntity<StoresResponse> orderedByCity() {
		return new ResponseEntity<StoresResponse>(
				new StoresResponse("Sorted By Cities", seviceImplementation.getStoresOrderesByCity()), HttpStatus.OK);
	}
	
	@GetMapping("orederedByOpeningDate")
	public ResponseEntity<StoresResponse> orderedByOpeningDate() {
		return new ResponseEntity<StoresResponse>(
				new StoresResponse("Sorted By Cities", seviceImplementation.getStoresOrderesByDate()), HttpStatus.OK);
	}
}
