package com.project.hotelBooking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.hotelBooking.Repository.RoomRepository;
import com.project.hotelBooking.model.Room;

@Component
public class CommandLineAppStartRunner implements CommandLineRunner {

    @Autowired
	private RoomRepository hotelRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		addHotel();
	}
	
	public  void addHotel() {
		List<Room> hotel = new ArrayList<>();
		hotel.add(new Room( "AC", 1000000,"UnBooked"));
		hotel.add(new Room( "Non-AC", 2000000,"UnBooked"));
		hotel.add(new Room( "AC", 3000000,"UnBooked"));
		hotel.add(new Room( "Non-AC", 1000000,"UnBooked"));
		for (Room h : hotel) {
		hotelRepository.save(h);
		}
	}


}
