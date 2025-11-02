package it.dalpra.acme.erpapp.externalservice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import it.dalpra.acme.erpapp.externalservice.entity.ExternalEndpoint;
import it.dalpra.acme.erpapp.externalservice.repository.ExternalEndpointRepository;

@Service
public class ExternalEndpointService {
    private final ExternalEndpointRepository repository;

    public ExternalEndpointService(ExternalEndpointRepository repository){
        this.repository = repository;
    }

      @Cacheable("endpoints")
    public String getBaseUrl(String serviceName) {
        return repository.findByServiceNameAndEnable(serviceName, true)
                .map(ExternalEndpoint::getUri)
                .orElseThrow(() -> new IllegalStateException("No enabled endpoint configuration found for service: " + serviceName));
    }

    public List<ExternalEndpoint> getAllEndpoints() {
        return repository.findAll();
    }

    public Optional<ExternalEndpoint> getEndpointById(UUID id) {
        return repository.findById(id);
    }

    @CacheEvict(value = "endpoints", allEntries = true)
    public ExternalEndpoint saveEndpoint(ExternalEndpoint endpoint) {
        return repository.save(endpoint);
    }

    @CacheEvict(value = "endpoints", allEntries = true)
    public void deleteEndpoint(UUID id) {
        repository.deleteById(id);
    }
}
