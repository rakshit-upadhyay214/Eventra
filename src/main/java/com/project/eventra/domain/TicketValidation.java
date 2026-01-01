package com.project.eventra.domain;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="ticket_validation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TicketValidation {

    @Id
    @Column(name="ticket_validation_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="ticket_validation_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketValidationEnum status;

    @Column(name="ticket_validation_method", nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketValidationMethodEnum validationMethod;

    @CreatedDate
    @Column(name="created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

}
