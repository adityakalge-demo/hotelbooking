package com.project.hotelBooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.hotelBooking.Repository.BookingRepository;
import com.project.hotelBooking.Repository.RoomRepository;
import com.project.hotelBooking.Repository.UserRepository;
import com.project.hotelBooking.Service.BookingService;
import com.project.hotelBooking.model.Booking;
import com.project.hotelBooking.model.Room;
import com.project.hotelBooking.model.User;

@SpringBootTest
class HotelBookingApplicationTests {
	
	@MockBean
	private UserRepository userRepository;
	
	@MockBean
	private RoomRepository roomRepository;
	
	@MockBean
	private  BookingRepository bookingRepository;
	
	@Autowired
	private BookingService bookingService;

	@Test
	void testBookingRoomWhenRoomNotPresent() {
		Optional<User> optional= Optional.of(new User("Test",1000,200));
		Optional<Room> room= Optional.empty();
		when(userRepository.findById((long) 1)).thenReturn(optional);
		when(roomRepository.findById((long) 1)).thenReturn(room);
		
		assertEquals("Room with provided ID not Present", bookingService.getBookingRoomStatus(1, 1));
		
	   
	}
	
	@Test
	void testBookingRoomWhenRoomAlreadyBooked() {
		Optional<User> optional= Optional.of(new User("Test",1000,200));
		Optional<Room> room= Optional.of(new Room("AC", 100, "Booked"));
		when(userRepository.findById((long) 2)).thenReturn(optional);
		when(roomRepository.findById((long) 2)).thenReturn(room);
		
		assertEquals("Room already Booked or approval Pending", bookingService.getBookingRoomStatus(2, 2));
		
	   
	}
	
	@Test
	void testBookingRoomWhenUserNotPresent() {
		Optional<User> optional= Optional.empty();
		Optional<Room> room= Optional.of(new Room("AC", 100, "Booked"));
		when(userRepository.findById((long) 3)).thenReturn(optional);
		when(roomRepository.findById((long) 3)).thenReturn(room);
		
		assertEquals("User with provided ID not Present", bookingService.getBookingRoomStatus(3, 3));
		
	   
	}
	
	@Test
	void testBookingWhenBonusPointsareMore() {
		Optional<User> optional= Optional.of(new User("Test",1000,200));
		Optional<Room> room= Optional.of(new Room("AC", 100, "UnBooked"));
		Booking booking = new Booking();
		booking.setBookingId(1);
		booking.setStatus("Booked");
		when(userRepository.findById((long) 4)).thenReturn(optional);
		when(roomRepository.findById((long) 4)).thenReturn(room);
		when(bookingRepository.save(Mockito.any())).thenReturn(booking);
		String actual="Room Booked with booking ID: " + booking.getBookingId() + " Booking Status:" + booking.getStatus();
		assertEquals(actual, bookingService.getBookingRoomStatus(4, 4));
		
	}
}
