package com.pact.rentcar.model.dto.request;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddVehicleRequest {
    private String registration;
    private String brand;
    private String model;
    private Double dailyFee;


}
