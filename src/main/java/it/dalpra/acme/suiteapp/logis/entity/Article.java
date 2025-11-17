package it.dalpra.acme.suiteapp.logis.entity;

import it.dalpra.acme.suiteapp.common.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "articles")
@Data
public class Article extends BaseEntity{
    @Column(name = "code_article", nullable = false, unique = true)
    private String codeArticle;

    @Column(nullable = false)
    private String description;
    
    @Column(name="description_supl")
    private String descriptionSupl;
    
    @ManyToOne
    @JoinColumn(name="um_id")
    private UnitOfMeasurement um;
    
    @ManyToOne
    @JoinColumn(name="family_id")
    private Family family;
    
    @ManyToOne
    @JoinColumn(name="subfamily_id")
    private SubFamily subFamily;
    
    @ManyToOne
    @JoinColumn(name="comodity_groupid")   
    private ComodityGroup commodityGroup;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticleUnit> articleUnits;
}