package com.citywheels;

import com.citywheels.repository.BookingRepository;
import com.citywheels.repository.PolicyRepository;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

       BookingRepository repository = new BookingRepository(
               Path.of("data/help-desk-agent/data", "bookings.json")
       );

       try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Enter booking ID: ");

            String bookingId = scanner.nextLine().trim();

           Optional<Booking> booking = repository.findById(bookingId);

           if (booking.isPresent()){
               System.out.println("Booking ID: " + booking.get().id());
               System.out.println("Status: " + booking.get().status());

           }else{
               System.out.println("No such booking: " + bookingId);
           }

       }

        PolicyRepository policyRepository = new PolicyRepository(
                Path.of("data/help-desk-agent/data/policies")
        );

       String faq = policyRepository.readPolicy("faq.md");

       System.out.println(faq);


    }
}
