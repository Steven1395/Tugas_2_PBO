package models;

public class Booking {
    private int id;
    private int customer;
    private int roomType;
    private String checkinDate;
    private String checkoutDate;
    private int price;
    private String voucher;
    private int finalPrice;
    private String paymentStatus;
    private boolean hasCheckedin;
    private boolean hasCheckedout;

    public Booking() {}

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCustomer() { return customer; }
    public void setCustomer(int customer) { this.customer = customer; }

    public int getRoomType() { return roomType; }
    public void setRoomType(int roomType) { this.roomType = roomType; }

    public String getCheckinDate() { return checkinDate; }
    public void setCheckinDate(String checkinDate) { this.checkinDate = checkinDate; }

    public String getCheckoutDate() { return checkoutDate; }
    public void setCheckoutDate(String checkoutDate) { this.checkoutDate = checkoutDate; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public String getVoucher() { return voucher; }
    public void setVoucher(String voucher) { this.voucher = voucher; }

    public int getFinalPrice() { return finalPrice; }
    public void setFinalPrice(int finalPrice) { this.finalPrice = finalPrice; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public boolean isHasCheckedin() { return hasCheckedin; }
    public void setHasCheckedin(boolean hasCheckedin) { this.hasCheckedin = hasCheckedin; }

    public boolean isHasCheckedout() { return hasCheckedout; }
    public void setHasCheckedout(boolean hasCheckedout) { this.hasCheckedout = hasCheckedout; }
}
