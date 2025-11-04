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
import jakarta.persistence.OneToMany;
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

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(
        name = "categories",
        indexes = {
                @Index(name = "idx_categories_name", columnList = "name"),
                @Index(name = "idx_categories_slug", columnList = "slug"),
                @Index(name = "idx_categories_parent", columnList = "parent_id")
        })
@SQLDelete(sql = "UPDATE categories SET deleted_by = ?, deleted_at = now() WHERE category_id = ?")
@Where(clause = "deleted_at IS NULL")
public class Category extends AuditMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "category_id", length = 36)
    String id;

    @Column(length = 100, nullable = false)
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    Category parent;

    @OneToMany(mappedBy = "parent")
    Set<Category> children = new HashSet<>();

    @Column(length = 110, nullable = false, unique = true)
    String slug;
}