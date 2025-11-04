package com.core.entity;

import com.core.entity.audit.AuditMetadata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "roles")
@SQLDelete(sql = "UPDATE roles SET deleted_by = ?, deleted_at = now() WHERE name = ?")
@Where(clause = "deleted_at IS NULL")
public class Role extends AuditMetadata {

    @Id
    @Column(name = "name", length = 50)  // PK = name
    String name;
}