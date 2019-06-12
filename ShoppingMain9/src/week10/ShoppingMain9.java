package week10;

import java.util.Scanner;

/**
 * Session 10: Make following changes in code of week9
 * 1. Create a class Item
 * 2. Add required attributes to class e.g. name, price, quantity, coupon
 * 3. Create an Array for Item instead of separate arrays for itemNames, prices, quantities, coupon
 * 4. Inside the loop create instance of Item and populate all attributes with user input
 * 5. Add each item to Array of items
 * 6. Modify rest of the code to use Array of items
 **/
public class ShoppingMain9 {
    private static Scanner input;

    public static void main(String[] args) {

        input = new Scanner(System.in);

        System.out.println("Please enter number of items : ");
        int numberOfItems = input.nextInt();
        double finalCost = 0;

        Item[] items = new Item[numberOfItems];

        //System.out.println(items[0].getName());

        for (int i = 0; i < numberOfItems; i++) {
            int itemCount = i + 1;
            System.out.println("Item number : " + itemCount);
            String item_name=input.next();
            items[i]=new Item(item_name);

            System.out.println("Enter quantity of item" + itemCount + " : ");
            items[i].setQuantity(input.nextInt());

            System.out.println("Enter price for item" + itemCount + " : ");
            items[i].setPrice(input.nextInt());

            System.out.println("Enter coupon for item" + itemCount + " : ");
            items[i].setCoupon(input.nextInt());

            int item_1_totalCost = calculateTotalCost(items[i].getPrice(), items[i].getQuantity());

            printTotalCost(items[i].getName(), item_1_totalCost);
            printCouponRate(items[i].getName(), items[i].getCoupon());
            double item_1_finalCost = calculateFinalCost(item_1_totalCost, items[i].getCoupon());
            printFinalCost(items[i].getName(), item_1_finalCost);
            items[i].setFinalCost(item_1_finalCost);

            finalCost = finalCost + item_1_finalCost;
        }

        for (int i = 0; i < items.length; i++) {
            System.out.print("Item" + (i + 1) + " :" + items[i].getName());
            System.out.print(" Price" + (i + 1) + " :" + items[i].getPrice());
            System.out.print(" Quantity" + (i + 1) + " :" + items[i].getQuantity());
            System.out.print(" Coupon" + (i + 1) + " :" + items[i].getCoupon());
            System.out.println(" Cost " + (i + 1) + " :" + items[i].getFinalCost());
        }

        System.out.println("Final cost of all items : " + finalCost);

        String couponCode;
        while (true) {
            System.out.println("Enter coupon code : ");
            couponCode = input.next();
            if (couponCode.equals("A") || couponCode.equals("B") || couponCode.equals("C")) {
                break;
            } else {
                System.out.println("Coupon Code is invalid !");
            }
        }

        printCostStatistics(items);
        printCouponStatistics(items);

        double couponDiscount = calculateCouponDiscount(couponCode, finalCost);
        double costAfterCoupon = finalCost - couponDiscount;

        System.out.println("Cost after apply coupon on shopping cart : " + costAfterCoupon);
    }

    private static void printTotalCost(String itemName, int totalCost) {
        System.out.println("Total cost of " + itemName + " is " + totalCost);
    }

    private static void printCouponRate(String itemName, int coupon) {
        System.out.println("Coupon rate of " + itemName + " is " + coupon);
    }

    private static void printFinalCost(String itemName, double finalCost) {
        System.out.println("Final cost of " + itemName + " is " + finalCost);
    }

    private static void printCostStatistics(Item[] itemcosts) {
        System.out.println("****** Cost statistics ******");

        double maxCost = 0;
        double minCost = Integer.MAX_VALUE;
        String maxCostItemName = "";
        String minCostItemName = "";

        for (int i = 0; i < itemcosts.length; i++) {
            if (itemcosts[i].getFinalCost() > maxCost) {
                maxCost = itemcosts[i].getFinalCost();
                maxCostItemName = itemcosts[i].getName();
            }
            if (itemcosts[i].getFinalCost() < minCost) {
                minCost = itemcosts[i].getFinalCost();
                minCostItemName = itemcosts[i].getName();
            }
        }

        System.out.println("Most expensive item costs : " + maxCost);
        System.out.println("Cheapest item costs : " + minCost);
        System.out.println("Most expensive item name : " + maxCostItemName);
        System.out.println("Cheapest item name : " + minCostItemName);
    }

    private static void printCouponStatistics(Item [] coupons) {
        System.out.println("****** Coupon statistics ******");
        double maxCoupon = 0;
        for (int i = 0; i < coupons.length; i++) {
            if (coupons[i].getCoupon() > maxCoupon) {
                maxCoupon = coupons[i].getCoupon();
            }
        }
        System.out.println(maxCoupon + " percent off is awesome !!");
    }

    private static void printMostExpensive() {

    }

    private static int calculateTotalCost(int price, int quantity) {
        int totalCost = price * quantity;
        return totalCost;
    }

    private static int calculateFinalCost(int totalCost, int coupon) {
        int finalCost = totalCost - (totalCost * coupon / 100);
        return finalCost;
    }

    private static double calculateCouponDiscount(String couponCode, double finalCost) {
        double couponDiscount = 0;
        if (couponCode.equals("A")) {
            couponDiscount = finalCost * 5 / 100;
        } else if (couponCode.equals("B")) {
            couponDiscount = finalCost * 10 / 100;
        } else if (couponCode.equals("C")) {
            couponDiscount = finalCost * 20 / 100;
        }

        return couponDiscount;

   }
}

