package com.hotelsbook.services.dto;

import java.util.List;

import com.hotelsbook.services.model.ServiceResponse;

public class HotelServicesDTO {
	
	private Long hotelId;
    private String hotelName;
    private List<ServiceResponse> services;

    public HotelServicesDTO(Long hotelId, String hotelName, List<ServiceResponse> services) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.services = services;
    }

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public List<ServiceResponse> getServices() {
		return services;
	}

	public void setServices(List<ServiceResponse> services) {
		this.services = services;
	}
    
    

}
