package Test;

import Entities.Offres;
import Entities.Reservation;
import Services.ServiceReservation;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {
        ServiceReservation serviceReservation = new ServiceReservation();

//        // Test add method
//        Reservation reservationToAdd = new Reservation(Date.valueOf("2023-12-05"), Date.valueOf("2023-12-12"), 5, null);
//        try {
//            serviceReservation.add(reservationToAdd);
//            System.out.println("Reservation added successfully");
//        } catch (SQLException ex) {
//            System.out.println("Error adding reservation: " + ex.getMessage());
//        }

        // Test readAll method
        ArrayList<Reservation> allReservations = null;
        try {
            allReservations = serviceReservation.readAll();
            System.out.println("All Reservations:");
            allReservations.forEach(System.out::println);
        } catch (SQLException ex) {
            System.out.println("Error reading all reservations: " + ex.getMessage());
        }

////        // Test readAllById method
//        int memberIdToSearch = 0; // Replace with an actual member ID
//        ArrayList<Reservation> reservationsById = null;
//        try {
//            reservationsById = serviceReservation.readAllById(memberIdToSearch);
//            System.out.println("Reservations for Member ID " + memberIdToSearch + ":");
//            reservationsById.forEach(System.out::println);
//        } catch (SQLException ex) {
//            System.out.println("Error reading reservations by member ID: " + ex.getMessage());
//        }

//        // Test get method
//        int reservationIdToGet = 2; // Replace with an actual reservation ID
//        try {
//            Reservation retrievedReservation = serviceReservation.get(reservationIdToGet);
//            System.out.println("Reservation with ID " + reservationIdToGet + ":");
//            System.out.println(retrievedReservation);
//        } catch (SQLException ex) {
//            System.out.println("Error getting reservation: " + ex.getMessage());
//        }

//       // Test update method
//        Reservation reservationToUpdate = new Reservation(2,Date.valueOf("2023-12-01"), Date.valueOf("2023-12-10"), 3, new Offres(1,"","","","",0));
//        try {
//            serviceReservation.update(reservationToUpdate);
//            System.out.println("Reservation updated successfully");
//        } catch (SQLException ex) {
//            System.out.println("Error updating reservation: " + ex.getMessage());
//        }

//        // Test delete method
//        int reservationIdToDelete = 2; // Replace with an actual reservation ID
//        try {
//            serviceReservation.delete(reservationIdToDelete);
//            System.out.println("Reservation deleted successfully");
//        } catch (SQLException ex) {
//            System.out.println("Error deleting reservation: " + ex.getMessage());
//        }
    }
}
