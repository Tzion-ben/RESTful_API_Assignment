package com.Tzion.Assignment.DataModels;

/**
 * Represents the customers credit card information
 * @author Tzion Beniaminov
 */
import java.time.LocalDate;

public class CreditCardInformation {

    private Long cardNum;
    private int cvv;
    private LocalDate validThru;

    public CreditCardInformation() {}

    public CreditCardInformation(Long cardNum,
                                 int cvv,
                                 LocalDate validThru) {
        this.cardNum = cardNum;
        this.cvv = cvv;
        this.validThru = validThru;
    }

    public Long getCardNum() {
        return cardNum;
    }

    public int getCvv() {
        return cvv;
    }

    public LocalDate getValidThru() {
        return validThru;
    }

    public void setCardNum(Long cardNum) {
        this.cardNum = cardNum;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setValidThru(LocalDate validThru) {
        this.validThru = validThru;
    }

    @Override
    public String toString() {
        return "CreditCardInformation{" +
                "cardNum=" + cardNum +
                ", cvv=" + cvv +
                ", validThru=" + validThru +
                '}';
    }
}
