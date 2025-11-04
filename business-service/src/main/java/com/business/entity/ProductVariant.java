package com.business.entity;

import com.business.entity.audit.AuditMetadata;
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

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(
        name = "product_variants",
        indexes = {
                @Index(name = "idx_variants_product", columnList = "product_id"),
                @Index(name = "idx_variants_sku", columnList = "sku"),
                @Index(name = "idx_variants_price", columnList = "price")
        })
@SQLDelete(sql = "UPDATE product_variants SET deleted_by = ?, deleted_at = now() WHERE variant_id = ?")
@Where(clause = "deleted_at IS NULL")
public class ProductVariant extends AuditMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "variant_id", length = 36)
    String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    Product product;

    @Column(length = 100, nullable = false, unique = true)
    String sku;

    @Column(precision = 10, scale = 2, nullable = false)
    BigDecimal price;

    @Column(name = "original_price", precision = 10, scale = 2)
    BigDecimal originalPrice;
}