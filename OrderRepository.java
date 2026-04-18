import java.util.ArrayList;
import java.util.List;

/**
 * Repositori generik untuk menyimpan dan mengelola kumpulan pesanan.
 *
 * @param <T> Tipe data ID pesanan
 * @param <P> Tipe data harga pesanan (turunan Number)
 */
public class OrderRepository<T, P extends Number> {

    private final List<Order<T, P>> orders = new ArrayList<>();
    private final String            repoName;

    public OrderRepository(String repoName) {
        this.repoName = repoName;
    }

    // ── CRUD dasar ───────────────────────────────────────────
    public void add(Order<T, P> order) {
        orders.add(order);
        System.out.println("  ✔ Ditambahkan : " + order);
    }

    public boolean remove(T id) {
        return orders.removeIf(o -> o.getId().equals(id));
    }

    public Order<T, P> findById(T id) {
        return orders.stream()
                     .filter(o -> o.getId().equals(id))
                     .findFirst()
                     .orElse(null);
    }

    // ── Tampilan ─────────────────────────────────────────────
    public void displayAll() {
        System.out.println("\n  ┌─ " + repoName + " (" + orders.size() + " pesanan) ───────────────────────────────────");
        for (Order<T, P> o : orders) {
            System.out.println("  │  " + o);
        }
        System.out.println("  └──────────────────────────────────────────────────────────────");
    }

    // ── Getter ───────────────────────────────────────────────
    public List<Order<T, P>> getAll()     { return orders; }
    public String            getRepoName(){ return repoName; }
    public int               size()       { return orders.size(); }
}