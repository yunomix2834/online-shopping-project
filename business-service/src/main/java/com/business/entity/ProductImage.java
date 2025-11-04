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

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(
        name = "product_images",
        indexes = {
                @Index(name = "idx_images_product", columnList = "product_id"),
                @Index(name = "idx_images_variant", columnList = "variant_id"),
                @Index(name = "idx_images_thumbnail", columnList = "is_thumbnail")
        })
@SQLDelete(sql = "UPDATE product_images SET deleted_by = ?, deleted_at = now() WHERE image_id = ?")
@Where(clause = "deleted_at IS NULL")
public class ProductImage extends AuditMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "image_id", length = 36)
    String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id")
    ProductVariant variant;

    @Column(name = "image_url", length = 255, nullable = false)
    String imageUrl;

    @Column(name = "is_thumbnail", nullable = false)
    Boolean thumbnail = false;
}