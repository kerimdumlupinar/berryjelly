package com.berryjelly.ticket_service.repository;

import com.berryjelly.ticket_service.model.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM TICKET t WHERE t.RESOURCE_ID = ?1")
    Optional<TicketEntity> findByResourceId(String resourceId);
}
