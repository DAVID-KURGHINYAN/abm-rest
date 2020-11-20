package am.abm.abm.controllers;

import am.abm.abm.exceptions.EntityNotFoundException;
import am.abm.abm.models.ResponseModel;
import am.abm.abm.models.dtos.product.ProductPreviewDTO;
import am.abm.abm.models.dtos.translation.TranslationCreateDTO;
import am.abm.abm.models.dtos.translation.TranslationPreviewDTO;
import am.abm.abm.models.enities.Translation;
import am.abm.abm.services.TranslationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("translation/")
public class TranslationController extends BaseController {
    private final TranslationService translationService;

    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }
    @GetMapping("list")
    public List<Translation> translationList() {return translationService.getAll();
    }
    @PostMapping("add")
    public TranslationPreviewDTO addTranslation(@RequestBody TranslationCreateDTO translation) {
        return translationService.saveTranslation(translation);
    }
    @PutMapping("edit/{id}")
    public boolean editTranslation (@RequestBody TranslationCreateDTO translation, @PathVariable Long id) {
        return translationService.editTranslation(translation, id);
    }
    @PutMapping("upload/{translationId}")
    public TranslationPreviewDTO uploadTranslationAvatar(@RequestBody TranslationCreateDTO translationAvatar, @PathVariable Long translationId) {
        return translationService.uploadTranslationAvatar(translationAvatar,translationId);
    }

    @DeleteMapping("delete/{id}")
    public void deleteTranslation(@PathVariable Long id) {
        translationService.deleteTranslation(id);
    }
}
