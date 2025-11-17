package it.dalpra.acme.suiteapp.logis.repository;

import it.dalpra.acme.suiteapp.logis.entity.ComodityGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ComodityGroupRepository extends JpaRepository<ComodityGroup, UUID> {
}
