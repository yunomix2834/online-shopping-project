package com.business.entity;

import com.business.entity.audit.AuditMetadata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(
        name = "carts",
        indexes = {@Index(name = "idx_carts_user", columnList = "user_id")}
)
@SQLDelete(sql = "UPDATE carts SET deleted_by = ?, deleted_at = now() WHERE user_id = ?")
@Where(clause = "deleted_at IS NULL")
public class Cart extends AuditMetadata {

    @Id
    @Column(name = "user_id", length = 36)
    String userId; // PK = user_id (1-1)
}