package com.business.service;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class OrderPricingRule {
  public BigDecimal shippingFor(BigDecimal subtotal) {
    if (subtotal == null) return BigDecimal.ZERO;
    return subtotal.compareTo(new BigDecimal("500000")) >= 0 ? BigDecimal.ZERO : new BigDecimal("30000");
  }
}
