/**
 * Kelas generik untuk merepresentasikan sebuah pesanan.
 *
 * @param <T> Tipe data ID pesanan (misal: Integer, String)
 * @param <P> Tipe data harga pesanan, dibatasi hanya turunan Number (misal: Double, Integer)
 */
public class Order<T, P extends Number> {

    private T id;
    private String name;
    private String category;
    private P price;

    public Order(T id, String name, String category, P price) {
        this.id       = id;
        this.name     = name;
        this.category = category;
        this.price    = price;
    }

    // ── Getter ──────────────────────────────────────────────
    public T      getId()       { return id; }
    public String getName()     { return name; }
    public String getCategory() { return category; }
    public P      getPrice()    { return price; }

    @Override
    public String toString() {
        return String.format("[%-11s] ID=%-8s | %-25s | Harga: %s",
                category, id, name, price);
    }
}