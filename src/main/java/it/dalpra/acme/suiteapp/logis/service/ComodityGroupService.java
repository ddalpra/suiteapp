package it.dalpra.acme.suiteapp.logis.service;

import it.dalpra.acme.suiteapp.logis.entity.ComodityGroup;
import it.dalpra.acme.suiteapp.logis.repository.ComodityGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ComodityGroupService {

    private final ComodityGroupRepository comodityGroupRepository;

    public List<ComodityGroup> findAll() {
        return comodityGroupRepository.findAll();
    }
}
