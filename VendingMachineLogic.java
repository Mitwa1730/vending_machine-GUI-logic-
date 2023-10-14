
package Assignment5_000905034;

/** This class represents different processes of vending machine that sells particular item.
 *  I submitted this program as my Assignment 2 and again implementing it to represent
 *  a vending machine GUI using different event handlers for GUI components.
 *  @author Mitwa Patel, 000905034
 */
public class VendingMachineLogic {
    private double availableCredit;
    private double spending;
    private double itemPrice;
    private int quantity;
    private String productName;
    private String message="";

    /**
     * it constructs VendingMachine object that provides particular product info, initial quantity and price.
     * @param productName
     * @param quantity the initial quantity of product
     * @param price the price of the product
     *
     */
    public VendingMachineLogic(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        itemPrice = price;
    }

    /**
     * It returns the credit that is available in the vending Machine
     * @return the Available Credit
     */
    public double getAvailableCredit() {
        message = "Please collect $"+ String.format("%.2f", availableCredit);
        availableCredit = 0;
        return availableCredit;
    }

    /**
     * It returns the total spending from machine
     * @return the total spending
     */
    public double getSpending() {
        return spending;
    }

    public String getMessage(){
        return message;
    }

    /**
     * It returns the product name in the machine
     * @return the product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * It returns price of the item in the machine
     * @return the item price
     */
    public double getItemPrice() {
        return itemPrice;
    }

    /**
     * It returns the product quantity in the machine
     * @return the product quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Validate if there is enough credit and enough quantity available in vending machine and vends the item.
     * It updates the value of quantity, available credit and spending accordingly.
     * And also displays success or error message
     */
    public void vendItem() {
        if(itemPrice < availableCredit) {
            if(quantity > 0 ) {
                quantity --;
                availableCredit = (availableCredit - itemPrice);
                spending =spending + itemPrice;
                //System.out.println(productName + "Vended successfully.");
                message = productName + "Vended successfully.";
            }
            else {
                message = "Item is out of Stock";
            }
        }
        else {
            message = "VEND FAILED: Not Enough Credit";
        }
    }

    /**
     * Validates coin amount and adds it in to available credit.
     * Also displays message depending upon the coin amount validity
     * @param coinAmount
     */
    public void insertCoin(double coinAmount) {
        if(coinAmount == 0.1 || coinAmount == 0.05 || coinAmount == 0.25 ||coinAmount == 1 ||coinAmount == 2) {
            availableCredit = availableCredit + coinAmount;
            message="$"+coinAmount+" inserted";
        }
        else {
            message = "Invalid coin amount";
        }
    }

    /**
     * Generates full report of the vending machine
     * @return a string for full report of the vending machine
     */
    @Override
    public String toString() {
        return "Item: "+ productName +"\n\nQuantity: " +quantity + "\n\nPrice: $" + itemPrice +" each\n\n"+ "Credit: $"+ String.format("%.2f",availableCredit) + "\n\nTotal Collection: $" + spending;
    }
}
