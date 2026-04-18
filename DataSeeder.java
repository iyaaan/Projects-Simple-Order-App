/**
 * Kelas pembantu untuk mengisi data awal ke repositori.
 * Memisahkan logika pembuatan data dari kelas utama (Main).
 */
public class DataSeeder {

    /**
     * Mengisi repositori makanan dengan data sampel.
     *
     * @param repo Repositori bertipe Order<Integer, Double>
     */
    public static void seedMakanan(OrderRepository<Integer, Double> repo) {
        System.out.println("\n▶ Mengisi data: " + repo.getRepoName());
        repo.add(new Order<>(101, "Nasi Goreng Spesial",   "Makanan",    45_000.0));
        repo.add(new Order<>(102, "Mie Ayam Bakso",        "Makanan",    32_000.0));
        repo.add(new Order<>(103, "Es Teh Manis",          "Makanan",     8_000.0));
        repo.add(new Order<>(104, "Ayam Bakar Komplit",    "Makanan",    65_000.0));
        repo.add(new Order<>(105, "Soto Ayam",             "Makanan",    28_000.0));
    }

    /**
     * Mengisi repositori elektronik dengan data sampel.
     *
     * @param repo Repositori bertipe Order<String, Integer>
     */
    public static void seedElektronik(OrderRepository<String, Integer> repo) {
        System.out.println("\n▶ Mengisi data: " + repo.getRepoName());
        repo.add(new Order<>("ELEC-A1", "Laptop Gaming ASUS ROG",    "Elektronik", 15_000_000));
        repo.add(new Order<>("ELEC-B2", "Smartphone Samsung S25",    "Elektronik", 12_500_000));
        repo.add(new Order<>("ELEC-C3", "Headphone Sony WH-1000XM5", "Elektronik",  3_200_000));
        repo.add(new Order<>("ELEC-D4", "Monitor 4K LG 27\"",        "Elektronik",  6_800_000));
        repo.add(new Order<>("ELEC-E5", "SSD NVMe 2TB Samsung",      "Elektronik",  1_500_000));
    }

    /**
     * Mengisi repositori jasa dengan data sampel.
     *
     * @param repo Repositori bertipe Order<String, Double>
     */
    public static void seedJasa(OrderRepository<String, Double> repo) {
        System.out.println("\n▶ Mengisi data: " + repo.getRepoName());
        repo.add(new Order<>("SVC-001", "Desain Logo Perusahaan",  "Jasa",   750_000.0));
        repo.add(new Order<>("SVC-002", "Pembuatan Website",       "Jasa", 5_000_000.0));
        repo.add(new Order<>("SVC-003", "Konsultasi IT (per jam)", "Jasa",   350_000.0));
        repo.add(new Order<>("SVC-004", "Instalasi Jaringan",      "Jasa", 1_200_000.0));
        repo.add(new Order<>("SVC-005", "Pelatihan Karyawan",      "Jasa", 2_500_000.0));
    }
}