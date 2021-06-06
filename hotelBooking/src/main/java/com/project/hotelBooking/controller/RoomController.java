package com.project.hotelBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotelBooking.Service.RoomService;
import com.project.hotelBooking.model.Room;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/roomList")
	@ApiResponses(value= {@ApiResponse (message = "Room retrived Successfull", code =200),
			@ApiResponse(message = "Service not found ", code =404)})
	public List<Room> gethotelList() {

		List<Room> hotel = roomService.findAll();
		return hotel;
	}
	
	@PostMapping("/create")
	@ApiResponses(value= {@ApiResponse (message = "Room added Successfull", code =200),
			@ApiResponse(message = "Service not found ", code =404)})
	public Room createRoom(@RequestBody Room room) {
		
		return roomService.saveRoom(room);
	}

}
