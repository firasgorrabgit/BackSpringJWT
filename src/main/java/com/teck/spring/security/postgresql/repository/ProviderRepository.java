package com.teck.spring.security.postgresql.repository;

import com.teck.spring.security.postgresql.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
