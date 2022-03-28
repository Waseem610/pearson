package com.te.challenge.response;

import java.util.List;

import com.te.challenge.model.Stores;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoresResponse {
	private String message;
	private List<Stores> stores;
}
