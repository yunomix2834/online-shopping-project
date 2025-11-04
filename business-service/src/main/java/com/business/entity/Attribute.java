package com.business.entity;

import com.business.entity.audit.AuditMetadata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(
        name = "attributes",
        indexes = {@Index(name = "idx_attr_name", columnList = "name")}
)
@SQLDelete(sql = "UPDATE attributes SET deleted_by = ?, deleted_at = now() WHERE attribute_id = ?")
@Where(clause = "deleted_at IS NULL")
public class Attribute extends AuditMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "attribute_id", length = 36)
    String id;

    @Column(length = 100, nullable = false, unique = true)
    String name;

    @Column(length = 100, nullable = false)
    String value;
}