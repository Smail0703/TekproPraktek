package pertemuan2;

public class Restaurant {
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        if (stok < 0) { 
            System.out.println("Stok " + nama + " tidak boleh negatif!");
        } else {
            this.nama_makanan[id] = nama;
            this.harga_makanan[id] = harga;
            this.stok[id] = stok;
            id++; 
        }
    }

    public void pesanMenu(String namaPesanan, int jumlahPesan) {
        boolean menuDitemukan = false;

        for (int i = 0; i < id; i++) {
            if (nama_makanan[i] != null && nama_makanan[i].equalsIgnoreCase(namaPesanan)) {
                menuDitemukan = true;

                if (stok[i] == 0) {
                    System.out.println("pesanan ditolak Stok " + namaPesanan + " sudah habis.");
                } else if (stok[i] >= jumlahPesan) {
                    int sisaStok = stok[i] - jumlahPesan;
                    setStok(i, sisaStok); 
                    System.out.println("Berhasil memesan " + jumlahPesan + " porsi " + namaPesanan + ".");
                } else {
                    System.out.println("Pesanan Ditolak! Stok " + namaPesanan + " tidak cukup. (Sisa: " + stok[i] + ")");
                }
                break; 
            }
        }
        if (!menuDitemukan) {
            System.out.println("Menu " + namaPesanan + " tidak ditemukan.");
        }
    } 

    public void tampilMenuMakanan() {
        for (int i = 0; i < id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(nama_makanan[i] + "[" + stok[i] + "]\tRp. " + harga_makanan[i]);
            }
        }
    }

    public boolean isOutOfStock(int index) {
        return stok[index] == 0; 
    }

    // Getter
    public String getNamaMakanan(int index) { 
        return nama_makanan[index]; 
    }

    public double getHargaMakanan(int index) { 
        return harga_makanan[index]; 
    }

    public int getStok(int index) { 
        return stok[index]; 
    }

    public void setStok(int index, int stokBaru) {
        if (stokBaru < 0) { 
            System.out.println("Gagal: Stok tidak boleh kurang dari 0!");
        } else {
            this.stok[index] = stokBaru;
        }
    }
}