package com.app.xplore.service.rooms;

import com.app.xplore.models.rooms.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface roomsInterface {
    // Create
    Room createRoom(Room room);

    // Read
    Optional<Room> getRoomById(String roomId);

    Page<Room> getAllRooms(Pageable pageable);

    List<Room> getRoomsByType(String roomType);

    List<Room> getRoomsByEvent(String eventId);

    List<Room> getActiveRooms();

    List<Room> getPrivateRooms();

    List<Room> getPublicRooms();

    List<Room> getRoomsByCreator(String creatorId);

    // Update
    Room updateRoom(String roomId, Room room);

    Room updateRoomStatus(String roomId, boolean isActive);

    Room updateRoomPrivacy(String roomId, boolean isPrivate);

    Room updateRoomCapacity(String roomId, Integer newCapacity);

    Room updateRoomMembers(String roomId, Integer newMemberCount);

    Room updateRoomExpiry(String roomId, LocalDateTime newExpiryDate);

    Room updateRoomIcon(String roomId, String newIconUrl);

    // Delete
    void deleteRoom(String roomId);

    void deleteAllRooms();

    void deleteRoomsByEvent(String eventId);

    void deleteExpiredRooms();
}