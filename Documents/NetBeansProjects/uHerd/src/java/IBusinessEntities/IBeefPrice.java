/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IBusinessEntities;

/**
 *
 * @author asus
 */
public interface IBeefPrice {

    /**
     * @return the averagePriceLastYear
     */
    String getAveragePriceLastYear();

    /**
     * @return the averagePriceThisYear
     */
    String getAveragePriceThisYear();

    /**
     * @return the cattleGrade
     */
    String getCattleGrade();

    /**
     * @return the cattleType
     */
    String getCattleType();

    /**
     * @return the percentageChangeOnAverageOnPreviousYear
     */
    String getPercentageChangeOnAverageOnPreviousYear();

    /**
     * @return the percentageChangeOnPreviousYear
     */
    String getPercentageChangeOnPreviousYear();

    /**
     * @return the pricePerKilo
     */
    String getPricePerKilo();

    /**
     * @return the pricePerKiloLastYear
     */
    String getPricePerKiloLastYear();

    /**
     * @param averagePriceLastYear the averagePriceLastYear to set
     */
    void setAveragePriceLastYear(String averagePriceLastYear);

    /**
     * @param averagePriceThisYear the averagePriceThisYear to set
     */
    void setAveragePriceThisYear(String averagePriceThisYear);

    /**
     * @param cattleGrade the cattleGrade to set
     */
    void setCattleGrade(String cattleGrade);

    /**
     * @param cattleType the cattleType to set
     */
    void setCattleType(String cattleType);

    /**
     * @param percentageChangeOnAverageOnPreviousYear the percentageChangeOnAverageOnPreviousYear to set
     */
    void setPercentageChangeOnAverageOnPreviousYear(String percentageChangeOnAverageOnPreviousYear);

    /**
     * @param percentageChangeOnPreviousYear the percentageChangeOnPreviousYear to set
     */
    void setPercentageChangeOnPreviousYear(String percentageChangeOnPreviousYear);

    /**
     * @param pricePerKilo the pricePerKilo to set
     */
    void setPricePerKilo(String pricePerKilo);

    /**
     * @param pricePerKiloLastYear the pricePerKiloLastYear to set
     */
    void setPricePerKiloLastYear(String pricePerKiloLastYear);
    
}
