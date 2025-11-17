package it.dalpra.acme.suiteapp.logis.service;

import it.dalpra.acme.suiteapp.logis.entity.SubFamily;
import it.dalpra.acme.suiteapp.logis.repository.SubFamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SubFamilyService {

    private final SubFamilyRepository subFamilyRepository;

    public List<SubFamily> findAll() {
        return subFamilyRepository.findAll();
    }
}
