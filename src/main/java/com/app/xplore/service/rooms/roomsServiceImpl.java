package com.app.xplore.service.rooms;

import com.app.xplore.models.User;
import com.app.xplore.models.rooms.Room;
import com.app.xplore.models.rooms.RoomType;
import com.app.xplore.repository.rooms.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class roomsServiceImpl implements roomsInterface {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room createRoom(Room room) {
        room.setRoomCreatedDate(LocalDateTime.now());
        return roomRepository.save(room);
    }

    @Override
    public Optional<Room> getRoomById(String roomId) {
        return roomRepository.findById(roomId);
    }

    @Override
    public Page<Room> getAllRooms(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }

    @Override
    public List<Room> getRoomsByType(String roomType) {
        return roomRepository.findByRoomType(RoomType.valueOf(roomType));
    }

    @Override
    public List<Room> getRoomsByEvent(String eventId) {
        return roomRepository.findByEventId(eventId);
    }

    @Override
    public List<Room> getActiveRooms() {
        return roomRepository.findByActiveTrue();
    }

    @Override
    public List<Room> getPrivateRooms() {
        return roomRepository.findByIsPrivateTrue();
    }

    @Override
    public List<Room> getPublicRooms() {
        return roomRepository.findByIsPrivateFalse();
    }

    @Override
    public List<Room> getRoomsByCreator(String creatorId) {
        return roomRepository.findByRoomCreatedBy(creatorId);
    }

    @Override
    public List<User> getAllUsersInRoom(String roomId) {
        // TODO: Implement user-room relationship and user retrieval
        return null;
    }

    @Override
    public Room updateRoom(String roomId, Room room) {
        Optional<Room> existingRoom = roomRepository.findById(roomId);
        if (existingRoom.isPresent()) {
            Room updatedRoom = existingRoom.get();
            updatedRoom.setRoomName(room.getRoomName());
            updatedRoom.setRoomDescription(room.getRoomDescription());
            updatedRoom.setRoomType(room.getRoomType());
            updatedRoom.setRoomIconUrl(room.getRoomIconUrl());
            updatedRoom.setRoomMinimumAge(room.getRoomMinimumAge());
            updatedRoom.setRoomGender(room.getRoomGender());
            updatedRoom.setActive(room.isActive());
            updatedRoom.setCapacity(room.getCapacity());
            updatedRoom.setMembers(room.getMembers());
//            updatedRoom.setRoomMetadata(room.getRoomMetadata());
            updatedRoom.setRoomCreatedBy(room.getRoomCreatedBy());
            updatedRoom.setEventId(room.getEventId());
            updatedRoom.setPrivate(room.isPrivate());
            return roomRepository.save(updatedRoom);
        }
        return null;
    }

    @Override
    public Room updateRoomStatus(String roomId, boolean isActive) {
        Optional<Room> existingRoom = roomRepository.findById(roomId);
        if (existingRoom.isPresent()) {
            Room updatedRoom = existingRoom.get();
            updatedRoom.setActive(isActive);
            return roomRepository.save(updatedRoom);
        }
        return null;
    }

    @Override
    public Room updateRoomPrivacy(String roomId, boolean isPrivate) {
        Optional<Room> existingRoom = roomRepository.findById(roomId);
        if (existingRoom.isPresent()) {
            Room updatedRoom = existingRoom.get();
            updatedRoom.setPrivate(isPrivate);
            return roomRepository.save(updatedRoom);
        }
        return null;
    }

    @Override
    public Room updateRoomCapacity(String roomId, Integer newCapacity) {
        Optional<Room> existingRoom = roomRepository.findById(roomId);
        if (existingRoom.isPresent()) {
            Room updatedRoom = existingRoom.get();
            updatedRoom.setCapacity(newCapacity);
            return roomRepository.save(updatedRoom);
        }
        return null;
    }

    @Override
    public Room updateRoomMembers(String roomId, Integer newMemberCount) {
        Optional<Room> existingRoom = roomRepository.findById(roomId);
        if (existingRoom.isPresent()) {
            Room updatedRoom = existingRoom.get();
            updatedRoom.setMembers(newMemberCount);
            return roomRepository.save(updatedRoom);
        }
        return null;
    }

    @Override
    public Room updateRoomExpiry(String roomId, LocalDateTime newExpiryDate) {
        Optional<Room> existingRoom = roomRepository.findById(roomId);
        if (existingRoom.isPresent()) {
            Room updatedRoom = existingRoom.get();
            updatedRoom.setRoomExpiryDate(newExpiryDate);
            return roomRepository.save(updatedRoom);
        }
        return null;
    }

    @Override
    public Room updateRoomIcon(String roomId, String newIconUrl) {
        Optional<Room> existingRoom = roomRepository.findById(roomId);
        if (existingRoom.isPresent()) {
            Room updatedRoom = existingRoom.get();
            updatedRoom.setRoomIconUrl(newIconUrl);
            return roomRepository.save(updatedRoom);
        }
        return null;
    }

    @Override
    public void deleteRoom(String roomId) {
        roomRepository.deleteById(roomId);
    }

    @Override
    public void deleteAllRooms() {
        roomRepository.deleteAll();
    }

    @Override
    public void deleteRoomsByEvent(String eventId) {
        List<Room> rooms = roomRepository.findByEventId(eventId);
        roomRepository.deleteAll(rooms);
    }

    @Override
    public void deleteExpiredRooms() {
        List<Room> expiredRooms = roomRepository.findByRoomExpiryDateBefore(LocalDateTime.now());
        roomRepository.deleteAll(expiredRooms);
    }
}