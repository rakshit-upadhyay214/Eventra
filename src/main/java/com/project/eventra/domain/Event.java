package com.project.eventra.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name="event")
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", updatable=false, nullable = false)
    private UUID id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="venue", nullable = false)
    private String venue;

    @Column(name="event_start")
    private LocalDateTime eventStart;

    @Column(name="event_end")
    private LocalDateTime eventEnd;

    @Column(name="sales_start")
    private LocalDateTime salesStart;

    @Column(name="sales_end")
    private LocalDateTime salesEnd;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventStatusEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="organizer_id")
    private User organizer;

    @ManyToMany(mappedBy = "attendingEvent")
    private List<User> attendee = new ArrayList<>();

    @ManyToMany(mappedBy = "staffingEvent")
    private List<User> staff = new ArrayList<>();

    @OneToMany(mappedBy="event", cascade = CascadeType.ALL)
    private List<TicketType> ticketTypes = new ArrayList<>();

    
}
