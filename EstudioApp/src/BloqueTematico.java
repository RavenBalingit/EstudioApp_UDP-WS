public enum BloqueTematico {
    UDP("UDP"),
    WEB_SOCKETS("WebSockets"),
    AMBOS("Ambos");

    private final String displayName;

    BloqueTematico(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}