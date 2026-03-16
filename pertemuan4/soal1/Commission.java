public class Commission extends Hourly{
    private double totalSales;
    private double commissionRate;

    public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate, double commissionRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        
        this.commissionRate = commissionRate;
    }

    public void addSales (double totalSales){
        this.totalSales += totalSales;
    }

    public double pay(){
        double pembayaran = super.pay() + (totalSales * commissionRate);
        totalSales = 0.0;
        return pembayaran;
    }

    public String toString(){
        String hasil = super.toString();
        hasil += "\nTotal Sales: $" + totalSales;
        return hasil;
    }
}
