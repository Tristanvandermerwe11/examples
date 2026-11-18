/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exampleproject;

/**
 *
 * @author Trist
 */
public class ProductSales implements IProductSales 
{
    // Product sales data
    private int[][] arrSales = {
        {300, 150, 700},
        {250, 200, 600}
    };

    // Sales limit
    private int intSalesLimit = 500;

    // Number of years processed
    private int intYearsProcessed = 2;

    @Override
    public int[][] GetProductSales() {
        return arrSales;
    }

    @Override
    public int GetTotalSales() {
        int intTotalSales = 0;

        for (int intRow = 0; intRow < arrSales.length; intRow++) {
            for (int intCol = 0; intCol < arrSales[intRow].length; intCol++) {
                intTotalSales += arrSales[intRow][intCol];
            }
        }

        return intTotalSales;
    }

    @Override
    public int GetSalesOverLimit() {
        int intSalesOverLimit = 0;

        for (int intRow = 0; intRow < arrSales.length; intRow++) {
            for (int intCol = 0; intCol < arrSales[intRow].length; intCol++) {
                if (arrSales[intRow][intCol] > intSalesLimit) {
                    intSalesOverLimit++;
                }
            }
        }

        return intSalesOverLimit;
    }

    @Override
public int GetSalesUnderLimit() {

    int intSalesUnderLimit = 0;

    for (int intRow = 0; intRow < arrSales.length; intRow++) {

        for (int intCol = 0; intCol < arrSales[intRow].length; intCol++) {

            if (arrSales[intRow][intCol] < intSalesLimit) {
                intSalesUnderLimit++;
            }

        }
    }

    return intSalesUnderLimit;
}

    @Override
    public int GetProductsProcessed() {
        return intYearsProcessed;
    }

    @Override
    public double GetAverageSales() {
        int intTotalSales = GetTotalSales();
        int intTotalProducts = arrSales.length * arrSales[0].length;

        return (double) intTotalSales / intTotalProducts;
    }
}
