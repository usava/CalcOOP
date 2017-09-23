package model;

import java.util.Arrays;

public class Calculator {

    private String[] operands;
    private String[] digits;
    private String result;
    private String first;
    private String second;
    private String operator;
    private boolean is_first;
    private boolean is_point;

    public Calculator() {
        this.operands = new String[]{"+","-","*","/"};
        this.digits = new String[]{"0","1","2","3","4","5","6","7","8","9", ".", "+/-"};
        this.result = "";
        this.first = "";
        this.second = "";
        this.is_first = true;
        this.is_point = false;
    }

    private void calc() throws Exception {
        Double dfirst = Double.parseDouble(first);
        Double dsecond = Double.parseDouble(second);
        Double dresult = null;

        this.validate(dfirst, dsecond, this.operator);

        switch(operator){
           case "+":
               dresult = dfirst + dsecond;
               break;
           case "-":
               dresult = dfirst - dsecond;
               break;
           case "*":
               dresult = dfirst * dsecond;
               break;
           case "/":
               dresult = dfirst / dsecond;
               break;
        }

        this.result = Double.toString(dresult);
    }

    public String eventAction(String str) throws Exception
    {

        if( this.useList(digits, str) ){
            if(!is_point || str != "."){
                if(str == ".") {
                    if(this.first.length() == 0){
                        this.first = "0";
                    }else if(!this.is_first && this.second.length() == 0) {
                        this.second = "0";
                    }
                    is_point = true;
                }
                if(str == "+/-" && (this.first.length()>0 || this.second.length()>0)){
                    if(this.is_first){
                        if(this.first.charAt(0) == '-'){
                            this.first = this.first.substring(1);
                        }else{
                            this.first = "-" + this.first;
                        }
                        result = this.first;
                    }else{
                        if(this.second.charAt(0) == '-'){
                            this.second = this.second.substring(1);
                        }else{
                            this.second = "-" + this.second;
                        }
                    }
                }else{
                    if(this.is_first){
                        this.first += str;
                        this.result = this.first;
                    }else{
                        this.second += str;
                        this.result = this.second;
                    }
                }
            }
        }else if(this.useList(operands, str)){
            this.is_first = false;
            this.is_point = false;

            if(this.first.length()>0 && this.second.length()>0) {
                this.calc();
                this.clean();
                this.first = this.result;
            }
            this.operator = str;
        }else{
            if(str.charAt(0) == 61){
                this.calc();
                this.clean();
                this.first = this.result;
            }else{
                this.clear();
            }
        }
        return this.result;
    }

    private boolean useList(String[] arr, String targetValue) {
        return Arrays.asList(arr).contains(targetValue);
    }

    private void validate(Double first, Double second, String operator) throws Exception{
        if(second == 0.0 && this.operator == "/") {
            throw new Exception();
        }
    }

    private void clear(){
        this.result = "";
        this.first = "";
        this.second = "";
        this.is_first = true;
        this.is_point = false;
    }

    private void clean(){
        this.first = "";
        this.second = "";
        this.is_first = true;
        this.is_point = false;
    }



}
