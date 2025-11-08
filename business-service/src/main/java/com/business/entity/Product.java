package com.business.entity;

import com.business.constant.ProductStatus;
import com.business.entity.audit.AuditMetadata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
        name = "products",
        indexes = {
                @Index(name = "idx_products_name", columnList = "name"),
                @Index(name = "idx_products_slug", columnList = "slug"),
                @Index(name = "idx_products_brand", columnList = "brand_id"),
                @Index(name = "idx_products_status", columnList = "status")
        })
@SQLDelete(sql = "UPDATE products SET deleted_by = ?, deleted_at = now() WHERE product_id = ?")
@Where(clause = "deleted_at IS NULL")
public class Product extends AuditMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id", length = 36)
    String id;

    @Column(length = 255, nullable = false)
    String name;

    @Lob
    @Column(columnDefinition = "text")
    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    Brand brand;

    @Column(length = 255, nullable = false, unique = true)
    String slug;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    ProductStatus status = ProductStatus.DRAFT;
}
