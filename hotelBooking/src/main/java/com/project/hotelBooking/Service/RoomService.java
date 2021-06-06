package com.project.hotelBooking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotelBooking.Repository.RoomRepository;
import com.project.hotelBooking.model.Room;

@Service
public class RoomService {
	
	@Autowired
	private  RoomRepository roomRepository;

	public List<Room> findAll() {
		return roomRepository.findAll();
	}
	
	public Room saveRoom(Room room) {
		return roomRepository.save(room);
	}

	
}
