package it.dalpra.acme.suiteapp.logis.service;

import it.dalpra.acme.suiteapp.logis.entity.ArticleUnit;
import it.dalpra.acme.suiteapp.logis.repository.ArticleUnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleUnitService {

    private final ArticleUnitRepository articleUnitRepository;

    public List<ArticleUnit> findAll() {
        return articleUnitRepository.findAll();
    }

    public Optional<ArticleUnit> findById(UUID id) {
        return articleUnitRepository.findById(id);
    }

    public ArticleUnit save(ArticleUnit articleUnit) {
        return articleUnitRepository.save(articleUnit);
    }

    public void deleteById(UUID id) {
        articleUnitRepository.deleteById(id);
    }
}
