package com.example.ecommercial.infra.repository;

import com.example.ecommercial.infra.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository  extends JpaRepository<Cart,Long> {
}
