package com.citywheels;

import com.citywheels.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookingRepositoryTest {
    @TempDir
    Path tempDir;

    @Test
    void findExistingBookings() throws IOException{
        Path file = tempDir.resolve("bookings.json");

        Files.writeString(file, """
                [
                  {
                    "id": "CW-TEST-1",
                    "status": "confirmed",
                    "rental_price_eur": 40.00
                  },
                  {
                    "id": "CW-TEST-2",
                    "status": "confirmed",
                    "rental_price_eur": 60.00
                  }
                ]
                """);

        BookingRepository repository = new BookingRepository(file);

        Optional<Booking> result = repository.findById("CW-TEST-1");

        assertTrue(result.isPresent());
        assertEquals("CW-TEST-1", result.get().id());
    }

    @Test
    void returnsEmptyForUnknownBooking() throws IOException {
        Path file = tempDir.resolve("bookings.json");

        Files.writeString(file, """
                [
                  {
                    "id": "CW-TEST-1",
                    "status": "confirmed",
                    "rental_price_eur": 40.00
                  }
                ]
                """);

        BookingRepository repository = new BookingRepository(file);

        Optional<Booking> result = repository.findById("CW-UNKNOWN");

        assertTrue(result.isEmpty());
    }

}
