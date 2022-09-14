package https;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;

public class MyHttpTester {
    private LinkedHashMap<String,String> https;
    private static String Cookies = "";
    private static String ctoken = null;
    private static final Logger logger = LoggerFactory.getLogger(MyHttpTester.class);
    private static String endPoint = "";

    public static void setCookie(String cookie){

    }

    public MyHttpTester(LinkedHashMap<String,String> https){
        this.https = https;
    }

    public MyHttpTester(){

    }

    public void httpAccess(){}
}
