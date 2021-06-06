package com.project.hotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotelBooking.Service.BookingService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	
	@PostMapping("/book")
	@ApiResponses(value= {@ApiResponse (message = "Room booked Successfull", code =200),
			@ApiResponse(message = "Service not found ", code =404)})
	public String bookHotelRoom(@RequestParam long userId,@RequestParam long hotelId) {
		
		return bookingService.getBookingRoomStatus(userId, hotelId);
	}
}
