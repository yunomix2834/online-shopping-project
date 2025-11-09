package com.gatewayserver.dto.response.order;

import java.util.List;

public record PageOrderView(
    int page,
    int size,
    long total,
    int totalPages,
    List<OrderView> docs
) {}
