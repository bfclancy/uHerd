/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntities;

import IBusinessEntities.IBeefPrice;

/**
 *
 * @author asus
 */
public class BeefPrice implements IBeefPrice {
    private String cattleType;
    private String cattleGrade;
    private String pricePerKiloLastYear;
    private String pricePerKilo;
    private String percentageChangeOnPreviousYear;
    private String averagePriceLastYear;
    private String averagePriceThisYear;
    private String percentageChangeOnAverageOnPreviousYear;

    public BeefPrice(String cattleType, String cattleGrade, String pricePerKiloLastYear, String pricePerKilo, String percentageChangeOnPreviousYear, String averagePriceLastYear, String averagePriceThisYear, String percentageChangeOnAverageOnPreviousYear) {
        this.cattleType = cattleType;
        this.cattleGrade = cattleGrade;
        this.pricePerKiloLastYear = pricePerKiloLastYear;
        this.pricePerKilo = pricePerKilo;
        this.percentageChangeOnPreviousYear = percentageChangeOnPreviousYear;
        this.averagePriceLastYear = averagePriceLastYear;
        this.averagePriceThisYear = averagePriceThisYear;
        this.percentageChangeOnAverageOnPreviousYear = percentageChangeOnAverageOnPreviousYear;
    }

    /**
     * @return the cattleType
     */
    @Override
    public String getCattleType() {
        return cattleType;
    }

    /**
     * @param cattleType the cattleType to set
     */
    @Override
    public void setCattleType(String cattleType) {
        this.cattleType = cattleType;
    }

    /**
     * @return the cattleGrade
     */
    @Override
    public String getCattleGrade() {
        return cattleGrade;
    }

    /**
     * @param cattleGrade the cattleGrade to set
     */
    @Override
    public void setCattleGrade(String cattleGrade) {
        this.cattleGrade = cattleGrade;
    }

    /**
     * @return the pricePerKiloLastYear
     */
    @Override
    public String getPricePerKiloLastYear() {
        return pricePerKiloLastYear;
    }

    /**
     * @param pricePerKiloLastYear the pricePerKiloLastYear to set
     */
    @Override
    public void setPricePerKiloLastYear(String pricePerKiloLastYear) {
        this.pricePerKiloLastYear = pricePerKiloLastYear;
    }

    /**
     * @return the pricePerKilo
     */
    @Override
    public String getPricePerKilo() {
        return pricePerKilo;
    }

    /**
     * @param pricePerKilo the pricePerKilo to set
     */
    @Override
    public void setPricePerKilo(String pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }

    /**
     * @return the percentageChangeOnPreviousYear
     */
    @Override
    public String getPercentageChangeOnPreviousYear() {
        return percentageChangeOnPreviousYear;
    }

    /**
     * @param percentageChangeOnPreviousYear the percentageChangeOnPreviousYear to set
     */
    @Override
    public void setPercentageChangeOnPreviousYear(String percentageChangeOnPreviousYear) {
        this.percentageChangeOnPreviousYear = percentageChangeOnPreviousYear;
    }

    /**
     * @return the averagePriceLastYear
     */
    @Override
    public String getAveragePriceLastYear() {
        return averagePriceLastYear;
    }

    /**
     * @param averagePriceLastYear the averagePriceLastYear to set
     */
    @Override
    public void setAveragePriceLastYear(String averagePriceLastYear) {
        this.averagePriceLastYear = averagePriceLastYear;
    }

    /**
     * @return the averagePriceThisYear
     */
    @Override
    public String getAveragePriceThisYear() {
        return averagePriceThisYear;
    }

    /**
     * @param averagePriceThisYear the averagePriceThisYear to set
     */
    @Override
    public void setAveragePriceThisYear(String averagePriceThisYear) {
        this.averagePriceThisYear = averagePriceThisYear;
    }

    /**
     * @return the percentageChangeOnAverageOnPreviousYear
     */
    @Override
    public String getPercentageChangeOnAverageOnPreviousYear() {
        return percentageChangeOnAverageOnPreviousYear;
    }

    /**
     * @param percentageChangeOnAverageOnPreviousYear the percentageChangeOnAverageOnPreviousYear to set
     */
    @Override
    public void setPercentageChangeOnAverageOnPreviousYear(String percentageChangeOnAverageOnPreviousYear) {
        this.percentageChangeOnAverageOnPreviousYear = percentageChangeOnAverageOnPreviousYear;
    }

    
    
    
    
}
