package model;

public class Bookings {
    public int id;
    public int customer;
    public int roomType;
    public String checkinDate;
    public String checkoutDate;
    public int price;
    public int voucher;
    public int finalPrice;
    public String paymentStatus;
    public boolean hasCheckedin;
    public boolean hasCheckedout;

    public Bookings(
            int id, int customer, int roomType,
            String checkinDate, String checkoutDate,
            int price, int voucher, int finalPrice,
            String paymentStatus, boolean hasCheckedin, boolean hasCheckedout
    ) {
        this.id = id;
        this.customer = customer;
        this.roomType = roomType;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.price = price;
        this.voucher = voucher;
        this.finalPrice = finalPrice;
        this.paymentStatus = paymentStatus;
        this.hasCheckedin = hasCheckedin;
        this.hasCheckedout = hasCheckedout;
    }

}
