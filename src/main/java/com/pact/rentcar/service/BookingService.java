package com.pact.rentcar.service;

import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.model.Booking;
import com.pact.rentcar.model.Vehicle;
import com.pact.rentcar.model.dto.request.AddBookingRequest;
import com.pact.rentcar.repository.BookingRepository;
import com.pact.rentcar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Optional<Booking> addBooking(AddBookingRequest addBookingRequest) {
        Optional<Booking> optionalBooking = bookingRepository.findByVehicle(addBookingRequest.getVehicle());// FIXME
        if (!optionalBooking.isPresent()) {
            Booking booking = new Booking();

            booking.setRecipeDate(addBookingRequest.getRecipeDate());
            booking.setReturnDate(addBookingRequest.getReturnDate());
            booking.setTotalCost(addBookingRequest.getTotalCost());
            booking.setAppUser(addBookingRequest.getAppUser());
            booking.setLocation(addBookingRequest.getLocation());
            booking.setVehicle(addBookingRequest.getVehicle());

            return Optional.of(bookingRepository.save(booking));
        }
        return Optional.empty();
    }

    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }


    public List<Booking> findAllByAppUserId(Long AppUserID) { // FIXME to moze nie zadziałać
        List<Booking> getAllBookings = bookingRepository.findAll();
        List<Booking> usersBookings = new ArrayList<>();

        for (Booking p : getAllBookings) {
            if (p.getAppUser().getId().equals(AppUserID)) {
                usersBookings.add(p);
//                break;
            }
        }

        return usersBookings;
    }












//    public Optional<UserCart> addPizzaToCart(Long pizzaId) {
//        Optional<AppUser> loggedInUser = appUserAuthenticationService.getLoggedInUser();
//        if (!loggedInUser.isPresent()) {
//            return Optional.empty();
//        }
//        Optional<Pizza> optionalPizza = pizzaService.getPizzaWithId(pizzaId);
//        if (!optionalPizza.isPresent()) {
//            return Optional.empty();
//        }
//
//        AppUser appUser = loggedInUser.get();
//        Pizza pizza = optionalPizza.get();
//
//        UserCart cart = appUser.getUserCart();
//        CartOrder order = new CartOrder();
//        order.setPizza(pizza);
//        order.setQuantity(1);
//
//        order = cartOrderRepository.save(order);
//
//        cart.getOrders().add(order);
//
//        cart = userCartRepository.save(cart);
//
//        return Optional.of(cart);
//    }


}
