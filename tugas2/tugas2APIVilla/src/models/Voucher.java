package models;

public class Voucher {
    private int id;
    private String code;
    private double discount;
    private String description;
    private String start_date;
    private String end_date;


    public Voucher() {}

    public Voucher(int id, String code, double discount, String description, String startDate, String endDate) {
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.description = description;
        this.start_date = startDate;
        this.end_date = endDate;
    }


    public int getId() { return id;}
    public void setId(int id) {this.id = id;}

    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}

    public double getDiscount() {return discount;}
    public void setDiscount(double discount) {this.discount = discount;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getStart_date() {return start_date;}
    public void setStart_date(String start_date) {this.start_date = start_date;}

    public String getEnd_date() {return end_date;}
    public void setEnd_date(String end_date) {this.end_date = end_date;}}
