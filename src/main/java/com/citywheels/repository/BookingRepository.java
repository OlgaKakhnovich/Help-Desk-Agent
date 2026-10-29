package com.citywheels.repository;

import com.citywheels.Booking;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class BookingRepository {

    private final List<Booking> bookings;

    public BookingRepository(Path path) throws IOException{

        ObjectMapper mapper = new ObjectMapper();

        this.bookings = mapper.readValue(
                path.toFile(),
                new TypeReference<List<Booking>>() {}
        );
    }

    public Optional<Booking> findById(String bookingId){

        for(Booking booking: bookings){
            if (booking.id().equals(bookingId)){
                return Optional.of(booking);
            }
        }
        return Optional.empty();
    }
}
