package com.app.xplore.repository.rooms;

import com.app.xplore.models.rooms.Room;
import com.app.xplore.models.rooms.RoomType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    List<Room> findByRoomType(RoomType roomType);

    List<Room> findByEventId(String eventId);

    List<Room> findByActiveTrue();

    List<Room> findByIsPrivateTrue();

    List<Room> findByIsPrivateFalse();

    List<Room> findByRoomCreatedBy(String creatorId);

    List<Room> findByRoomExpiryDateBefore(LocalDateTime date);
}