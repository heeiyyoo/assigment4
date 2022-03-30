public class Orders{
    private int id;
    private java.sql.Date order_date;
    private java.sql.Date shipped_date;
    private String status;
    private String comments;
    private int customer_id;

    public Orders(int id, java.sql.Date order_date, java.sql.Date shipped_date, String status, String comments, int customer_id) {
        this.id = id;
        this.order_date = order_date;
        this.shipped_date = shipped_date;
        this.status = status;
        this.comments = comments;
        this.customer_id = customer_id;
    }

    public int getId() {
        return id;
    }

    public java.sql.Date getOrder_date() {
        return order_date;
    }

    public java.sql.Date getShipped_date() {
        return shipped_date;
    }

    public String getStatus() {
        return status;
    }

    public String getComments() {
        return comments;
    }

    public int getCustomer_id() {
        return customer_id;
    }
}
