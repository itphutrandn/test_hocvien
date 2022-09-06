package model;

public class WorldCupModel {

    private String maDB;

    private String tenDoiBong;

    private String hlvTruong;

    private int soLanVoDich;

    public String getMaDB() {
        return maDB;
    }

    public void setMaDB(String maDB) {
        this.maDB = maDB;
    }

    public String getTenDoiBong() {
        return tenDoiBong;
    }

    public void setTenDoiBong(String tenDoiBong) {
        this.tenDoiBong = tenDoiBong;
    }

    public String getHlvTruong() {
        return hlvTruong;
    }

    public void setHlvTruong(String hlvTruong) {
        this.hlvTruong = hlvTruong;
    }

    public int getSoLanVoDich() {
        return soLanVoDich;
    }

    public void setSoLanVoDich(int soLanVoDich) {
        this.soLanVoDich = soLanVoDich;
    }

    public WorldCupModel(String maDB, String tenDoiBong, String hlvTruong, int soLanVoDich) {
        this.maDB = maDB;
        this.tenDoiBong = tenDoiBong;
        this.hlvTruong = hlvTruong;
        this.soLanVoDich = soLanVoDich;
    }

    public WorldCupModel() {
    }

    @Override
    public String toString() {
        return "WorldCupModel{" +
                "maDB='" + maDB + '\'' +
                ", tenDoiBong='" + tenDoiBong + '\'' +
                ", hlvTruong='" + hlvTruong + '\'' +
                ", soLanVoDich=" + soLanVoDich +
                '}';
    }
}
