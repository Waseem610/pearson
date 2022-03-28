package com.te.challenge.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.te.challenge.model.Stores;

@Service
public class StoreSeviceImplementation implements StoreSevice {

	public List<Stores> getAll() {
		String line = "";
		BufferedReader bufferedReader = null;
		List<Stores> storesList = new ArrayList<>();
		try {

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			bufferedReader = new BufferedReader(new FileReader("src/main/resources/stores.csv"));
			while ((line = bufferedReader.readLine()) != null) {
				Stores stores = new Stores();
				String[] split = line.split(",");
				stores.setStoreId(split[0]);
				stores.setPostCode(split[1]);
				stores.setCity(split[2]);
				stores.setAddress(split[3]);
				stores.setDate(simpleDateFormat	.parse(split[4]));
				storesList.add(stores);
			}
			return storesList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Stores getStoreById(String storeId) {
		return getAll().stream().filter(Stores -> Stores.getStoreId().equals(storeId)).findAny().orElse(null);
	}

	@Override
	public List<Stores> getStoresOrderesByCity() {
		return getAll().stream().sorted((store1, store2) -> store1.getCity().compareTo(store2.getCity()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Stores> getStoresOrderesByDate() {
		return getAll().stream().sorted((store1, store2) -> store1.getDate().compareTo(store2.getDate()))
				.collect(Collectors.toList());

	}

}
