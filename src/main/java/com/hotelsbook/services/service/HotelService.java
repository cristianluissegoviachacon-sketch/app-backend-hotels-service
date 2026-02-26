package com.hotelsbook.services.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelsbook.services.dto.HotelServicesDTO;
import com.hotelsbook.services.model.ServiceResponse;
import com.hotelsbook.services.repository.HotelServiceRepository;

@Service
public class HotelService {
	
	private static final Logger logger = LoggerFactory.getLogger(HotelService.class);

    @Autowired
    private HotelServiceRepository repository;

    public List<HotelServicesDTO> getServicesByHotels(String hotelIds) {
        
    	logger.info(hotelIds);
        
        List<Object[]> results = repository.getServicesByHotels(hotelIds);

        Map<Long, HotelServicesDTO> hotelServicesMap = new LinkedHashMap<>();
        
        for (Object[] row : results) {
            Long hotelId = ((Number) row[0]).longValue();
            String hotelName = (String) row[1];
            String serviceName = (String) row[2];
            Long serviceId = ((Number) row[3]).longValue();

            HotelServicesDTO hotelServices = hotelServicesMap.getOrDefault(hotelId, 
                new HotelServicesDTO(hotelId, hotelName, new ArrayList<>()));

            hotelServices.getServices().add(new ServiceResponse(serviceId, serviceName));
            hotelServicesMap.put(hotelId, hotelServices);
        }

        return new ArrayList<>(hotelServicesMap.values());
    }
}

