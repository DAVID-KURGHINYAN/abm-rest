package am.abm.abm.models.dtos.translation;

import am.abm.abm.models.enities.Translation;

public class TranslationPreviewDTO {
    private String languageName1;
    private String languageName2;
    private String languageName3;
    private Long languageID;

    public String getLanguageName1() {
        return languageName1;
    }

    public void setLanguageName1(String languageName1) {
        this.languageName1 = languageName1;
    }

    public String getLanguageName2() {
        return languageName2;
    }

    public void setLanguageName2(String languageName2) {
        this.languageName2 = languageName2;
    }

    public String getLanguageName3() {
        return languageName3;
    }

    public void setLanguageName3(String languageName3) {
        this.languageName3 = languageName3;
    }

    public Long getLanguageID() {
        return languageID;
    }

    public void setLanguageID(Long languageID) {
        this.languageID = languageID;
    }

    public TranslationPreviewDTO(Translation translation) {
        this.setLanguageName1(translation.getRu());
        this.setLanguageName2(translation.getEn());
        this.setLanguageName3(translation.getArm());
        this.setLanguageID(translation.getId());
    }
}
