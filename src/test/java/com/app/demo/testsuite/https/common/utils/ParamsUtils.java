package com.app.demo.testsuite.https.common.utils;

public class ParamsUtils {
    /**
     * 替换脚本中的变量
     */
    public static String dealParams(String jsonString){
        if (jsonString.contains("#String#")){
            jsonString = jsonString.replaceAll("#String#","啦啦啦");
        }if (true){

        }
        return jsonString;
    }
}
