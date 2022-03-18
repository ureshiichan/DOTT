package com.dott;


public class Convert {
    public static String cidrToMask(String x) {
        return x;
    }

    public static String maskToCidr(String x) {
        return x;
    }

    public static Boolean ipv4Validation(String x) {
        String[] ipSplit = x.split("\\.");
      
       if(ipSplit.length!=4){
            return false;
        }
        
        boolean isValid=true;
        
        for(int i=0;i<ipSplit.length;i++){
             int ipNum=-1;
             try{
                ipNum= Integer.parseInt(ipSplit[i]);
            }catch(Exception e ){
                isValid= false;
            }
            if(ipNum<0 || ipNum>255){
                isValid = false;
             }
        }
        return isValid;
    }
}