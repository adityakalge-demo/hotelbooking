package com.project.hotelBooking.serviceTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.hotelBooking.Service.BookingService;
import com.project.hotelBooking.Service.RoomService;
import com.project.hotelBooking.Service.UserService;
import com.project.hotelBooking.model.Room;
import com.project.hotelBooking.model.User;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceClassTest {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoomService roomService;
	
	   @Test
	   public void whenRoomAddedStatusUnbooked() {
	       Room saveRoom = roomService.saveRoom(new Room("AC", 1000,"UnBooked"));
	       assertEquals(saveRoom.getRoomStatus(), "UnBooked");
	   }
	   
	   @Test
	   public void whenUserAddedUserIsnotNull() {
		   User user= new User();
		   user.setBonusPoints(1000);
		   user.setUserName("Test");
	       User saveUser = userService.saveUser(user);
	       Optional<User> findUserById = userService.findUserById(saveUser.getId());
	       assertNotNull(findUserById.get());
	   }
	   
	   @Test
	   public void getUserReturnsNull() {
		 
	       Optional<User> findUserById = userService.findUserById(1000);
	       assertTrue(findUserById.isEmpty());
	   }

}
