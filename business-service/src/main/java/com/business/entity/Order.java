package com.business.entity;

import com.business.constant.OrderStatus;
import com.business.entity.audit.AuditMetadata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Lob;
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
        name = "orders",
        indexes = {
                @Index(name = "idx_orders_user", columnList = "user_id"),
                @Index(name = "idx_orders_status", columnList = "status"),
                @Index(name = "idx_orders_created", columnList = "created_at")
        })
@SQLDelete(sql = "UPDATE orders SET deleted_by = ?, deleted_at = now() WHERE order_id = ?")
@Where(clause = "deleted_at IS NULL")
public class Order extends AuditMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id", length = 36)
    String id;

    @Column(name = "user_id", length = 36, nullable = false)
    String userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    OrderStatus status = OrderStatus.pending;

    @Column(precision = 10, scale = 2, nullable = false)
    BigDecimal subtotal;

    @Column(name = "shipping_fee", precision = 10, scale = 2, nullable = false)
    BigDecimal shippingFee = BigDecimal.ZERO;

    @Column(name = "discount_amount", precision = 10, scale = 2, nullable = false)
    BigDecimal discountAmount = BigDecimal.ZERO;

    @Column(name = "total_amount", precision = 10, scale = 2, nullable = false)
    BigDecimal totalAmount;

    @Lob
    @Column(name = "shipping_address", nullable = false, columnDefinition = "text")
    String shippingAddress;

    @Lob
    @Column(name = "billing_address", columnDefinition = "text")
    String billingAddress;

    @Column(name = "payment_method_name", length = 100)
    String paymentMethodName;

    @Column(name = "shipping_method_name", length = 100)
    String shippingMethodName;

    @Column(name = "discount_code", length = 50)
    String discountCode;
}