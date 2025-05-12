package com.programacionparaaprender.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public class DataServicio {
	public Map<Integer, Double> getLineChartData() {
	      Map<Integer, Double> map = new LinkedHashMap<>();
	      map.put(1, 5.20);
	      map.put(2, 19.63);
	      map.put(3, 59.01);
	      map.put(4, 139.76);
	      map.put(5, 300.4);
	      map.put(6, 630.0);
	     return map;
	  }
}
