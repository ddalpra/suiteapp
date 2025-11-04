package it.dalpra.acme.suiteapp.externalservice.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.dalpra.acme.suiteapp.externalservice.entity.ExternalEndpoint;

@Repository
public interface ExternalEndpointRepository extends JpaRepository<ExternalEndpoint,UUID>{
    Optional<ExternalEndpoint> findByServiceNameAndEnable(String serviceName, boolean enable);
}
