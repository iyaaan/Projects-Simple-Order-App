import java.util.List;

/**
 * Utilitas generik untuk operasi perhitungan pada kumpulan pesanan.
 * Menggunakan bounded wildcard agar kompatibel dengan semua tipe Order.
 */
public class OrderUtils {

    // Konstruktor private – kelas ini hanya berisi metode statis
    private OrderUtils() {}

    /**
     * Menghitung total harga dari daftar pesanan.
     *
     * @param orders Daftar pesanan (tipe apapun yang merupakan subtype Order)
     * @return Total harga dalam bentuk double
     */
    public static double totalHarga(List<? extends Order<?, ? extends Number>> orders) {
        double total = 0;
        for (Order<?, ? extends Number> o : orders) {
            total += o.getPrice().doubleValue();
        }
        return total;
    }

    /**
     * Menemukan pesanan dengan harga tertinggi.
     *
     * @param orders Daftar pesanan
     * @return Pesanan dengan harga maksimum, atau null jika daftar kosong
     */
    public static Order<?, ? extends Number> pesananTermahal(
            List<? extends Order<?, ? extends Number>> orders) {

        if (orders == null || orders.isEmpty()) return null;

        Order<?, ? extends Number> maks = orders.get(0);
        for (Order<?, ? extends Number> o : orders) {
            if (o.getPrice().doubleValue() > maks.getPrice().doubleValue()) {
                maks = o;
            }
        }
        return maks;
    }

    /**
     * Menemukan pesanan dengan harga terendah.
     *
     * @param orders Daftar pesanan
     * @return Pesanan dengan harga minimum, atau null jika daftar kosong
     */
    public static Order<?, ? extends Number> pesananTermurah(
            List<? extends Order<?, ? extends Number>> orders) {

        if (orders == null || orders.isEmpty()) return null;

        Order<?, ? extends Number> min = orders.get(0);
        for (Order<?, ? extends Number> o : orders) {
            if (o.getPrice().doubleValue() < min.getPrice().doubleValue()) {
                min = o;
            }
        }
        return min;
    }

    /**
     * Menghitung rata-rata harga dari daftar pesanan.
     *
     * @param orders Daftar pesanan
     * @return Rata-rata harga dalam bentuk double, atau 0 jika daftar kosong
     */
    public static double rataRataHarga(List<? extends Order<?, ? extends Number>> orders) {
        if (orders == null || orders.isEmpty()) return 0;
        return totalHarga(orders) / orders.size();
    }

    /**
     * Menampilkan ringkasan statistik dari sebuah repositori.
     *
     * @param repo Repositori yang akan diringkas
     */
    public static void tampilkanRingkasan(OrderRepository<?, ? extends Number> repo) {
        List<? extends Order<?, ? extends Number>> list = repo.getAll();

        System.out.println("\n  ── Ringkasan: " + repo.getRepoName() + " ──────────────────────────────");
        System.out.printf ("  │  Jumlah pesanan  : %d%n",          list.size());
        System.out.printf ("  │  Total harga     : Rp %,.0f%n",    totalHarga(list));
        System.out.printf ("  │  Rata-rata harga : Rp %,.0f%n",    rataRataHarga(list));
        System.out.printf ("  │  Pesanan termahal: %s%n",          pesananTermahal(list));
        System.out.printf ("  │  Pesanan termurah: %s%n",          pesananTermurah(list));
        System.out.println("  └──────────────────────────────────────────────────────────────");
    }
}