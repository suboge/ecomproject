package com.popo.springecom.model.dto;

public record OrderItemRequest(
        int productId,
        int quantity
) {}
