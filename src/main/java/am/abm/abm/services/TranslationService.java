package am.abm.abm.services;

import am.abm.abm.exceptions.EntityNotFoundException;
import am.abm.abm.models.dtos.translation.TranslationCreateDTO;
import am.abm.abm.models.dtos.translation.TranslationDetailsDTO;
import am.abm.abm.models.dtos.translation.TranslationPreviewDTO;
import am.abm.abm.models.enities.Translation;
import am.abm.abm.repositories.TranslationRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TranslationService {
    private final TranslationRepository translationRepository;

    public TranslationService(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    public TranslationDetailsDTO getTranslationDetails(Long id) {
        Optional<Translation> optionalTranslation = translationRepository.findById(id);
        if (optionalTranslation.isPresent()) {
            Translation translation = optionalTranslation.get();
            return new TranslationDetailsDTO(translation); //mi ban en chi
        }
        return null;
    }

    public List<Translation> getAll() {
        List<Translation> translations = translationRepository.findAll();
        return translations.stream().map(TranslationPreviewDTO::new).collect(Collectors.toList());
    }

    public TranslationPreviewDTO saveTranslation(TranslationCreateDTO translationCreateDTO) {
        Translation translation = new Translation();
        translation.setRu(translationCreateDTO.getLanguageName());
        translation.setEn(translationCreateDTO.getLanguageName());
        translation.setArm(translationCreateDTO.getLanguageName());
        //id petqa te che?
        return new TranslationPreviewDTO(translationRepository.save(translation));
    }

    public TranslationPreviewDTO uploadTranslationAvatar(MultipartFile translationAvatar, Long translationId) throws EntityNotFoundException, IOException {
        Optional<Translation> optionalTranslation = translationRepository.findById(translationId);
        if (optionalTranslation.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Translation translation = optionalTranslation.get();
        translation.setRu(write(translationAvatar));
        return new TranslationPreviewDTO(translationRepository.save(translation));
    }

    public String write(MultipartFile file) throws IOException {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
        String fileName = date + file.getOriginalFilename();
        String filePath = "src/main/resources/media/" + fileName;
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }

    public void deleteTranslation(Long id) {
        translationRepository.deleteById(id);
    }
    public boolean editTranslation (TranslationCreateDTO translation, Long id) {
        Optional<Translation> optionalTranslation = translationRepository.findById(id);
        if (optionalTranslation.isPresent()) {
            Translation oldTranslation = optionalTranslation.get();
            oldTranslation.setRu(translation.getLanguageName()); //chem havatum
            oldTranslation.setEn(translation.getLanguageName());
            oldTranslation.setArm(translation.getLanguageName());
            translationRepository.save(oldTranslation);
            return true;
        }
        return false;
    }
}
