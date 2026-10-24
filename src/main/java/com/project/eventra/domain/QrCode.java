package com.project.eventra.domain;

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
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="qr_code")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class QrCode {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        QrCode qrCode = (QrCode) o;
        return Objects.equals(id, qrCode.id) && status == qrCode.status && Objects.equals(ticket, qrCode.ticket) && Objects.equals(createdAt, qrCode.createdAt) && Objects.equals(updatedAt, qrCode.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, ticket, createdAt, updatedAt);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="qr_code_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name="qr_code_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private QrCodeStatusEnum status;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ticket_id")
    private Ticket ticket;

    @CreatedDate
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

}
