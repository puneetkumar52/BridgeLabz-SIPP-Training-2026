/*
2. Online Coupon Validator
An e-commerce website validates discount coupons.
● Create an interface CouponValidator containing:
    ○ abstract method validateCoupon(String code)
    ○ static method isLengthValid(String code)
● Store coupon codes in a String[].
● Implement the interface in a class ShoppingCart.
Task: Check each coupon from the array and print whether it is valid or
invalid.
 */

interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code.length() == 8; yy2
        
    }
}

class ShoppingCart implements CouponValidator {
    private String[] coupons;

    public ShoppingCart(String[] coupons) {
        this.coupons = coupons;
    }

    @Override
    public boolean validateCoupon(String code) {
        return isLengthValid(code); 
    }

    public static void main(String[] args) {
        String[] couponCodes = {"ABC12345", "XYZ67890", "DEF45678", "GHI90123"};
        ShoppingCart cart = new ShoppingCart(couponCodes);

        for (String code : couponCodes) {
            if (cart.validateCoupon(code)) {
                System.out.println("Coupon '" + code + "' is valid.");
            } else {
                System.out.println("Coupon '" + code + "' is invalid.");
            }
        }
    }
}
