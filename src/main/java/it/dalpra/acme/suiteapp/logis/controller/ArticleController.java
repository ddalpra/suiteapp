package it.dalpra.acme.suiteapp.logis.controller;

import it.dalpra.acme.suiteapp.common.entity.ActiveStatus;
import it.dalpra.acme.suiteapp.logis.entity.Article;
import it.dalpra.acme.suiteapp.logis.entity.ArticleUnit;
import it.dalpra.acme.suiteapp.logis.service.ArticleService;
import it.dalpra.acme.suiteapp.logis.service.ArticleUnitService;
import it.dalpra.acme.suiteapp.logis.service.ComodityGroupService;
import it.dalpra.acme.suiteapp.logis.service.FamilyService;
import it.dalpra.acme.suiteapp.logis.service.SubFamilyService;
import it.dalpra.acme.suiteapp.logis.service.UnitOfMeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/logis/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleUnitService articleUnitService;
    private final UnitOfMeasurementService unitOfMeasurementService;
    private final FamilyService familyService;
    private final SubFamilyService subFamilyService;
    private final ComodityGroupService comodityGroupService;

    @GetMapping
    public String listArticles(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "logis/articles/articles";
    }

    @GetMapping("/new")
    public String showNewArticleForm(Model model) {
        model.addAttribute("article", new Article());
        model.addAttribute("unitsOfMeasurement", unitOfMeasurementService.findAll());
        model.addAttribute("families", familyService.findAll());
        model.addAttribute("subFamilies", subFamilyService.findAll());
        model.addAttribute("comodityGroups", comodityGroupService.findAll());
        return "logis/articles/article-form";
    }

    @PostMapping("/save")
    public String saveArticle(@ModelAttribute("article") Article article) {
        articleService.save(article);
        return "redirect:/logis/articles";
    }

    @GetMapping("/edit/{id}")
    public String showEditArticleForm(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("article", articleService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid article Id:" + id)));
        model.addAttribute("unitsOfMeasurement", unitOfMeasurementService.findAll());
        model.addAttribute("families", familyService.findAll());
        model.addAttribute("subFamilies", subFamilyService.findAll());
        model.addAttribute("comodityGroups", comodityGroupService.findAll());
        return "logis/articles/article-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable("id") UUID id) {
        articleService.deleteById(id);
        return "redirect:/logis/articles";
    }

    @GetMapping("/{articleId}/units/new")
    public String showNewArticleUnitForm(@PathVariable("articleId") UUID articleId, Model model) {
        Article article = articleService.findById(articleId).orElseThrow(() -> new IllegalArgumentException("Invalid article Id:" + articleId));
        ArticleUnit articleUnit = new ArticleUnit();
        articleUnit.setArticle(article);
        articleUnit.setStatus(ActiveStatus.ENABLE);
        model.addAttribute("articleUnit", articleUnit);
        model.addAttribute("unitsOfMeasurement", unitOfMeasurementService.findAll());
        return "logis/articles/article-unit-form";
    }

    @PostMapping("/{articleId}/units/save")
    public String saveArticleUnit(@PathVariable("articleId") UUID articleId, @ModelAttribute("articleUnit") ArticleUnit articleUnit) {
        Article article = articleService.findById(articleId).orElseThrow(() -> new IllegalArgumentException("Invalid article Id:" + articleId));
        articleUnit.setArticle(article);
        articleUnitService.save(articleUnit);
        return "redirect:/logis/articles";
    }

    @GetMapping("/units/delete/{id}")
    public String deleteArticleUnit(@PathVariable("id") UUID id) {
        articleUnitService.deleteById(id);
        return "redirect:/logis/articles";
    }
}
