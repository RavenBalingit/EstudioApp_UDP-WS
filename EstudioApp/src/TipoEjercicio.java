public enum TipoEjercicio {
    TEST("Preguntas Test"),
    RELLENAR_CODIGO("Rellenar Código");

    private final String displayName;

    TipoEjercicio(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}