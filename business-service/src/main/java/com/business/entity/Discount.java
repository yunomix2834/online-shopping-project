package com.business.entity;

import com.business.constant.DiscountType;
import com.business.entity.audit.AuditMetadata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
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

import java.math.BigDecimal;
import java.time.Instant;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(
        name = "discounts",
        indexes = {
                @Index(name = "idx_discounts_code", columnList = "code"),
                @Index(name = "idx_discounts_active", columnList = "is_active"),
                @Index(name = "idx_discounts_window", columnList = "start_date,end_date")
        })
@SQLDelete(sql = "UPDATE discounts SET deleted_by = ?, deleted_at = now() WHERE discount_id = ?")
@Where(clause = "deleted_at IS NULL")
public class Discount extends AuditMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "discount_id", length = 36)
    String id;

    @Column(length = 50, nullable = false, unique = true)
    String code;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    DiscountType type;

    @Column(precision = 10, scale = 2, nullable = false)
    BigDecimal value;

    @Column(name = "start_date")
    Instant startDate;

    @Column(name = "end_date")
    Instant endDate;

    @Column(name = "min_order_value", precision = 10, scale = 2)
    BigDecimal minOrderValue = BigDecimal.ZERO;

    @Column(name = "is_active", nullable = false)
    Boolean active = true;
}