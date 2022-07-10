
/*
 Assignment 1 - Income Tax
 Class ID       : SE1607
 Student ID     : HE151216
 Student Name   : To Quang Huy
 Due Date       : 30 October 2021
 I declare that this assignment is my own work
 in accordance with FPT Policy.
 */
package incometax;

/**
 *
 * @author HuyTQ
 */
public class TaxPayer {

    String code, name;
    double income, deduct, tax;

    public TaxPayer() {
    }

    public TaxPayer(String xCode, String xName, double xIncome, double xDeduct, double xTax) {
        code = xCode;
        name = xName;
        income = xIncome;
        deduct = xDeduct;
        tax = xTax;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getDeduct() {
        return deduct;
    }

    public void setDeduct(double deduct) {
        this.deduct = deduct;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return String.format("%-10s|%-25s|%-15.1f|%-15.1f|%-15.1f", code, name, income, deduct, tax);
    }

}
