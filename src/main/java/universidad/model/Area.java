
package universidad.model;

public enum Area {

    Sistemas(1),
    Civil(2),
    Medicina(3),
    Biologia(4);

    private final byte id;

    Area(int id) {
        this.id = (byte) id;
    }

    public byte getId() {
        return id;
    }

    public static Area buscarPorId(byte id) {

        for (Area area : values()) {
            if (area.id == id) {
                return area;
            }
        }
        throw new IllegalArgumentException(
                "No existe un área con ID: " + id
        );
    }
}
