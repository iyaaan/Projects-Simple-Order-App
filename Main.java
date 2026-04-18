import java.util.ArrayList;
import java.util.List;

/**
 * Kelas utama – demonstrasi sistem manajemen pesanan dengan Java Generics.
 *
 * Struktur file:
 *   Order.java           – kelas generik pesanan
 *   OrderRepository.java – repositori generik
 *   OrderUtils.java      – metode-metode utilitas generik
 *   DataSeeder.java      – pengisi data sampel
 *   Main.java            – titik masuk program (file ini)
 */
public class Main {

    public static void main(String[] args) {

        header("SISTEM MANAJEMEN PESANAN – Java Generics");

        // ── 1. Buat repositori dengan tipe berbeda ─────────────────────────
        OrderRepository<Integer, Double> makananRepo    = new OrderRepository<>("Pesanan Makanan");
        OrderRepository<String, Integer> elektronikRepo = new OrderRepository<>("Pesanan Elektronik");
        OrderRepository<String, Double>  jasaRepo       = new OrderRepository<>("Pesanan Jasa");

        // ── 2. Isi data via DataSeeder ─────────────────────────────────────
        DataSeeder.seedMakanan(makananRepo);
        DataSeeder.seedElektronik(elektronikRepo);
        DataSeeder.seedJasa(jasaRepo);

        // ── 3. Tampilkan semua pesanan per repositori ──────────────────────
        section("DAFTAR PESANAN PER KATEGORI");
        makananRepo.displayAll();
        elektronikRepo.displayAll();
        jasaRepo.displayAll();

        // ── 4. Ringkasan statistik per repositori (via OrderUtils) ─────────
        section("STATISTIK PER KATEGORI");
        OrderUtils.tampilkanRingkasan(makananRepo);
        OrderUtils.tampilkanRingkasan(elektronikRepo);
        OrderUtils.tampilkanRingkasan(jasaRepo);

        // ── 5. Demo: findById & remove ─────────────────────────────────────
        section("OPERASI FINDBYID & REMOVE");

        Order<Integer, Double> ditemukan = makananRepo.findById(103);
        System.out.println("  findById(103) → " + (ditemukan != null ? ditemukan : "Tidak ditemukan"));

        boolean dihapus = makananRepo.remove(103);
        System.out.println("  remove(103)   → " + (dihapus ? "Berhasil dihapus" : "ID tidak ditemukan"));
        System.out.printf ("  Sisa pesanan makanan: %d item%n", makananRepo.size());

        // ── 6. Ringkasan global (wildcard lintas tipe) ─────────────────────
        section("RINGKASAN GLOBAL (LINTAS KATEGORI)");

        List<Order<?, ? extends Number>> semua = new ArrayList<>();
        semua.addAll(makananRepo.getAll());
        semua.addAll(elektronikRepo.getAll());
        semua.addAll(jasaRepo.getAll());

        System.out.printf("  Total seluruh pesanan  : %d item%n",      semua.size());
        System.out.printf("  Total nilai keseluruhan: Rp %,.0f%n",     OrderUtils.totalHarga(semua));
        System.out.printf("  Rata-rata harga global : Rp %,.0f%n",     OrderUtils.rataRataHarga(semua));
        System.out.println("  Pesanan termahal global:");
        System.out.println("    → " + OrderUtils.pesananTermahal(semua));
        System.out.println("  Pesanan termurah global:");
        System.out.println("    → " + OrderUtils.pesananTermurah(semua));

        footer();
    }

    // ── Helper tampilan ────────────────────────────────────────────────────
    private static void header(String title) {
        String bar = "═".repeat(64);
        System.out.println("\n╔" + bar + "╗");
        System.out.printf ("║  %-62s  ║%n", title);
        System.out.println("╚" + bar + "╝");
    }

    private static void section(String title) {
        System.out.println("\n┄┄ " + title + " " + "┄".repeat(Math.max(0, 55 - title.length())));
    }

    private static void footer() {
        System.out.println("\n" + "═".repeat(66));
        System.out.println("  Selesai. Semua operasi menggunakan logika generik yang sama.");
        System.out.println("═".repeat(66));
    }
}