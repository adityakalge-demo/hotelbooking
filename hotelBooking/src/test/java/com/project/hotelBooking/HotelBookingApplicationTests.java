package com.project.hotelBooking.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotelBooking.Repository.BookingRepository;
import com.project.hotelBooking.Repository.RoomRepository;
import com.project.hotelBooking.Repository.UserRepository;
import com.project.hotelBooking.model.Booking;
import com.project.hotelBooking.model.Room;
import com.project.hotelBooking.model.User;

@Service
public class BookingService {
	
	@Autowired
	private UserService userService;
	@Autowired
	private  RoomRepository hotelRepository;
	@Autowired
	private  BookingRepository bookingRepository;
	
	public String getBookingRoomStatus(long userId, long hotelId) {
		User user =new User();
		Room room = new Room();
		Booking bookingObj = new Booking();
		bookingObj.setUserId(userId);
		bookingObj.setHotelId(hotelId);
		Optional<User> userData = userService.findUserById(bookingObj.getUserId());
		if(userData.isPresent()) {
			user = userData.get();
		}else {
			return "User with provided ID not Present";
		}
		Optional<Room> hotelData = hotelRepository.findById(bookingObj.getHotelId());
		if(hotelData.isPresent()) {
			room = hotelData.get();
			if(room.getRoomStatus().equals("Booked") || room.getRoomStatus().equals("Approval Pending")) {
				return "Room already Booked or approval Pending";
			}
		}else {
			return "Room with provided ID not Present";
		}
		return bookRoom(user, room, bookingObj);
		
	}

	private String bookRoom(User user, Room hotel, Booking bookingObj) {
		if(user.getBonusPoints() >= hotel.getRoomRate()) {
			bookingObj.setStatus("Booked");
			user.setPreviousBonusPoints(user.getBonusPoints());
			user.setBonusPoints(user.getBonusPoints() - hotel.getRoomRate());
			userService.saveUser(user);
			bookingObj.setUserName(user.getUserName());
			hotel.setRoomStatus("Booked");
			Booking booking = bookingRepository.save(bookingObj);
			return "Room Booked with booking ID: " + booking.getBookingId() + " Booking Status:" + booking.getStatus();
		}else {
			bookingObj.setStatus("Approval Pending");
			user.setPreviousBonusPoints(user.getBonusPoints());
			user.setBonusPoints(user.getBonusPoints() - hotel.getRoomRate());
			userService.saveUser(user);
			bookingObj.setUserName(user.getUserName());
			hotel.setRoomStatus("Approval Pending");
			Booking booking = bookingRepository.save(bookingObj);
			return "Room Booked with booking ID: " + booking.getBookingId() + " Booking Status:" + booking.getStatus();
		}
	}
}
