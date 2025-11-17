package it.dalpra.acme.suiteapp.logis.service;

import it.dalpra.acme.suiteapp.logis.entity.Family;
import it.dalpra.acme.suiteapp.logis.repository.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FamilyService {

    private final FamilyRepository familyRepository;

    public List<Family> findAll() {
        return familyRepository.findAll();
    }
}
