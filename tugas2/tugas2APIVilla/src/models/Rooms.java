package model;

public class Rooms {
    public int id;
    public int villaId;
    public String tipe;
    public int harga;

    public Rooms(int id, int villaId, String tipe, int harga) {
        this.id = id;
        this.villaId = villaId;
        this.tipe = tipe;
        this.harga = harga;
    }
}
