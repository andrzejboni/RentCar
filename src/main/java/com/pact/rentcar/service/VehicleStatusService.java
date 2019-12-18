package com.pact.rentcar.service;

import com.pact.rentcar.model.Vehicle;
import com.pact.rentcar.model.VehicleStatus;
import com.pact.rentcar.repository.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {

    @Autowired
    VehicleService vehicleService;
    @Autowired
    VehicleStatusRepository vehicleStatusRepository;

    public void updateVehicleStatus(Long vehicleID, Boolean available) {
        Vehicle vehicle = vehicleService.getVehicleByID(vehicleID); // FIXME UWAGA NA NULLA @@@@@@@@@@@@@@@@@@@

        List<VehicleStatus> vehicleStatusList = vehicleStatusRepository.findAll();

        if (available) {
            vehicle.setVehicleStatus(vehicleStatusList.get(0)); // First element of the list is AVI
        } else {
            vehicle.setVehicleStatus(vehicleStatusList.get(1)); // Second element of the list is UAV
        }


        // Po ustawieniu statusu, trzeba jeszcze wysłać update do bazy .

    }

}
