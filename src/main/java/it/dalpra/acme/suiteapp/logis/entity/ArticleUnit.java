package it.dalpra.acme.suiteapp.logis.entity;

import it.dalpra.acme.suiteapp.common.entity.DatetimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "article_unit")
@Data
public class ArticleUnit extends DatetimeEntity{
    @Id
    @ManyToOne
    @JoinColumn(name="article_id", nullable=false)
    private Article article;

    @Id
    @ManyToOne
    @JoinColumn(name="um_id", nullable=false)
    private unitOfMeasurement um;

    @Column(name = "conversion_factor", nullable = false)
    private Double conversionFactor;

    @Column(nullable = false)
    private boolean sale = false;

    @Column(nullable = false)
    private boolean purchase = false;

    @Column(nullable = false)
    private boolean production = false;

}