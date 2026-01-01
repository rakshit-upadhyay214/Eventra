package com.project.eventra.domain;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import org.springframework.data.annotation.*;

import java.time.*;
import java.util.*;

@Entity
@Table(name = "users")
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.Builder
public class User {
    @Id
    @Column(name = "id", updatable=false, nullable = false)
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email", nullable=false)
    private String email;

    @CreatedDate
    @Column(name="created_at", nullable=false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at", nullable=false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy="organizer", cascade = CascadeType.ALL)
    private List<Event> organizedEvent = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="user_attending_event",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="event_id")
    )
    private List<Event> attendingEvent = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="user_staffing_event",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="event_id")
    )
    private List<Event> staffingEvent = new ArrayList<>();
    
}
