package co.edu.unisabana.usuario.service.library.model;

public enum CategoryBook {

    EBOOK, SOFT_COVER, HARD_COVER;


    public static CategoryBook fromString(String data) {
        switch (data) {
            case "suave":
                return SOFT_COVER;
            case "duro":
                return HARD_COVER;
            case "digital":
                return EBOOK;
            default:
                throw new IllegalArgumentException("Tipo de libro no permitido");
        }
    }
}
