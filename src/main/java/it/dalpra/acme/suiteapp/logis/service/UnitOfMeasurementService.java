package it.dalpra.acme.suiteapp.logis.service;

import it.dalpra.acme.suiteapp.logis.entity.UnitOfMeasurement;
import it.dalpra.acme.suiteapp.logis.repository.UnitOfMeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UnitOfMeasurementService {

    private final UnitOfMeasurementRepository unitOfMeasurementRepository;

    public List<UnitOfMeasurement> findAll() {
        return unitOfMeasurementRepository.findAll();
    }
}
