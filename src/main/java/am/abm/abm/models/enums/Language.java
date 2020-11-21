package am.abm.abm.models.enums;

public enum Language {
    EN(1),
    RU(2),
    HY(3);

    private final int number;

    private Language(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
