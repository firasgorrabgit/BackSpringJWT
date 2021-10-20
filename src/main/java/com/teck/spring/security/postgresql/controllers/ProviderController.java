package com.teck.spring.security.postgresql.controllers;


import com.teck.spring.security.postgresql.models.Provider;
import com.teck.spring.security.postgresql.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({ "/providers", "/hom*" })
@CrossOrigin(origins = "*")
public class ProviderController {
    @Autowired
    private ProviderRepository providerRepository;

    @GetMapping("/list")
    public List<Provider> getAllProviders() {
        return (List<Provider>) providerRepository.findAll();
    }

    @PostMapping("/add")
    public Provider createProvider(@Valid @RequestBody Provider provider) {
        return providerRepository.save(provider);
    }

    @PutMapping("/{providerId}")
    public Provider updateProvider(@PathVariable Long providerId, @Valid @RequestBody Provider providerRequest) {
        return providerRepository.findById(providerId).map(provider -> {
            provider.setName(providerRequest.getName());
            provider.setEmail(providerRequest.getEmail());
            provider.setAddress(providerRequest.getAddress());
            provider.setLogo(providerRequest.getLogo());
            return providerRepository.save(provider);
        }).orElseThrow(() -> new IllegalArgumentException("ProviderId " + providerId + " not found"));
    }

    @DeleteMapping("/{providerId}")
    public ResponseEntity<?> deleteProvider(@PathVariable Long providerId) {
        return providerRepository.findById(providerId).map(provider -> {
            providerRepository.delete(provider);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new IllegalArgumentException("ProviderId " + providerId + " not found"));
    }

    @GetMapping("/{providerId}")
    public Provider getProvider(@PathVariable Long providerId) {

        Optional<Provider> p = providerRepository.findById(providerId);

        return p.get();

    }



}
