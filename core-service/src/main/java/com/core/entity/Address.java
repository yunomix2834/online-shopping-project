package com.core.entity;

import com.core.entity.audit.AuditMetadata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(
        name = "addresses",
        indexes = {
                @Index(name = "idx_addresses_user", columnList = "user_id"),
                @Index(name = "idx_addresses_def_ship", columnList = "is_default_shipping"),
                @Index(name = "idx_addresses_def_bill", columnList = "is_default_billing")
        })
@SQLDelete(sql = "UPDATE addresses SET deleted_by = ?, deleted_at = now() WHERE id = ?")
@Where(clause = "deleted_at IS NULL")
public class Address extends AuditMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Column(name = "contact_name", length = 100, nullable = false)
    String contactName;

    @Column(name = "contact_phone", length = 15, nullable = false)
    String contactPhone;

    @Column(name = "address_line1", length = 255, nullable = false)
    String addressLine1;

    @Column(name = "address_line2", length = 255)
    String addressLine2;

    @Column(length = 100, nullable = false)
    String district;

    @Column(length = 100, nullable = false)
    String city;

    @Column(length = 50, nullable = false)
    String country = "Vietnam";

    @Column(name = "postal_code", length = 10)
    String postalCode;

    @Column(name = "is_default_shipping", nullable = false)
    Boolean isDefaultShipping = false;

    @Column(name = "is_default_billing", nullable = false)
    Boolean isDefaultBilling = false;
}