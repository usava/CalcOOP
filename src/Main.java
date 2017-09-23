import model.Calculator;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String result = "";
        try{
            result = calculator.eventAction("1");
            result = calculator.eventAction(".");
            result = calculator.eventAction("+/-");
            result = calculator.eventAction("+/-");
            result = calculator.eventAction("+/-");
            result = calculator.eventAction("2");
            result = calculator.eventAction("+");
            result = calculator.eventAction(".");
            result = calculator.eventAction(".");
            result = calculator.eventAction("3");
            result = calculator.eventAction("*");
            result = calculator.eventAction("/");
            result = calculator.eventAction("0");
            result = calculator.eventAction("=");

        }catch (Exception e) {
            e.getStackTrace();
            result = "Error";
        }

        System.out.println(result);
    }
}
