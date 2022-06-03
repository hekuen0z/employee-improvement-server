package bsuir.diplom.serverapplication.entities.enums;

public enum Role {
    UNDEFINED(0),
    CHIEF(1),
    USER(2),
    OFFICER(3),
    UNREGISTERED(4);

    private final int id;

    Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
