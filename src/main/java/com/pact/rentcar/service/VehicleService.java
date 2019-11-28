package com.pact.rentcar.service;

import com.pact.rentcar.model.Vehicle;
import com.pact.rentcar.model.VehicleParameters;
import com.pact.rentcar.model.VehicleStatus;
import com.pact.rentcar.model.dto.request.AddVehicleParametersRequest;
import com.pact.rentcar.model.dto.request.AddVehicleRequest;
import com.pact.rentcar.repository.VehicleParametersRepository;
import com.pact.rentcar.repository.VehicleRepository;
import com.pact.rentcar.repository.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleParametersRepository vehicleParametersRepository;



    public Optional<Vehicle> addVehicle(AddVehicleRequest addVehicleRequest) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByRegistration(addVehicleRequest.getRegistration());
        if (!optionalVehicle.isPresent()) {
            Vehicle vehicle = new Vehicle();

            vehicle.setRegistration(addVehicleRequest.getRegistration());
            vehicle.setBrand(addVehicleRequest.getBrand());
            vehicle.setModel(addVehicleRequest.getModel());
            vehicle.setDailyFee(addVehicleRequest.getDailyFee());
            // Brak location i vehicle status!!

            return Optional.of(vehicleRepository.save(vehicle));
        }
        return Optional.empty();
    }

//    public Optional<VehicleParameters> addVehicleParameters(AddVehicleParametersRequest addVehicleParametersRequest) {
//        Optional<VehicleParameters> optionalVehicleParameters = vehicleParametersRepository.findById(addVehicleParametersRequest.(); // uwaga może coś nie pytknąc
//        if (!optionalVehicleParameters.isPresent()) {
//
//            VehicleParameters vehicleParameters = new VehicleParameters();
//
//            vehicleParameters.setBodytype(addVehicleParametersRequest.getBodytype());
//            vehicleParameters.setProductionYear(addVehicleParametersRequest.getProductionYear());
//            vehicleParameters.setFuelType(addVehicleParametersRequest.getFuelType());
//            vehicleParameters.setPower(addVehicleParametersRequest.getPower());
//            vehicleParameters.setGearbox(addVehicleParametersRequest.getGearbox());
//            vehicleParameters.setFrontWheelDrive(addVehicleParametersRequest.getFrontWheelDrive());
//            vehicleParameters.setDoorsNumber(addVehicleParametersRequest.getDoorsNumber());
//            vehicleParameters.setSeatsNumber(addVehicleParametersRequest.getSeatsNumber());
//            vehicleParameters.setColor(addVehicleParametersRequest.getColor());
//            vehicleParameters.setMetallic(addVehicleParametersRequest.getMetallic());
//            vehicleParameters.setPhotoName(addVehicleParametersRequest.getPhotoName());
//            vehicleParameters.setDescription(addVehicleParametersRequest.getDescription());
//
//            return Optional.of(vehicleParametersRepository.save(vehicleParameters));
//        }
//        return Optional.empty();
//    }


    public Vehicle getVehicleByID(Long id) {
        return vehicleRepository.getOne(id);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

}
