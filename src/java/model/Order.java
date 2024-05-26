package model;

public class Order extends Product{
	private int id;
	private int user_id;
        private String address;
	private double total;
	private int quantity;
        private String date;

    public Order(int id, int user_id, String address, double total, int quantity, String date) {
        this.id = id;
        this.user_id = user_id;
        this.address = address;
        this.total = total;
        this.quantity = quantity;
        this.date = date;
    }

    public Order(int user_id, String address, double total, int quantity, String date) {
        this.user_id = user_id;
        this.address = address;
        this.total = total;
        this.quantity = quantity;
        this.date = date;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", user_id=" + user_id + ", address=" + address + ", total=" + total + ", quantity=" + quantity + ", date=" + date + '}';
    }
	
	
}
