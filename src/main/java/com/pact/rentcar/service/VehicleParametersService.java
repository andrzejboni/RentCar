package com.pact.rentcar.service;

import com.pact.rentcar.model.Vehicle;
import com.pact.rentcar.model.VehicleParameters;
import com.pact.rentcar.repository.VehicleParametersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleParametersService {
    @Autowired
    private VehicleParametersRepository vehicleParametersRepository;


    public VehicleParameters getVehicleParametersByID(Long id) {
        return vehicleParametersRepository.getOne(id);
    }
}
