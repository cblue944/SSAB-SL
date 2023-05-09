package ax.lindblom.ssab.model;

public record Stop(int id, String name) {
    public Stop {
        if (id <= 0) {
            throw new IllegalArgumentException("A stops ID have to be a positive integer");
        }
    }
}
