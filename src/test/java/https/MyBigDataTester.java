package https;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.app.demo.testsuite.https.common.utils.ParamsUtils;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

public class MyBigDataTester {

    private static final Logger logger = LoggerFactory.getLogger(MyBigDataTester.class);
    private JSONObject testData;
    private MyHttpTester httpTester;

    public void runTest(String jsonFilePath){

        try {
            // 1.解析测试用例数据Json文件
            this.parseJsonFile(jsonFilePath);
            // 2.循环发起HTTP请求，check Http 返回结果
            httpTester.httpAccess();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    private void parseJsonFile(String jsonFilePath){
        if (jsonFilePath ==null){
            throw new RuntimeException("test file " + jsonFilePath + "is not exits");
        }
        try {
            String fileContent = IOUtils.toString(new ClassPathResource(jsonFilePath).getInputStream(),"utf-8");
//            String jsonString = JsonUtil.removeComment(fileContent);
//            String jsonString = ParamsUtils.dealParams(jsonString);
            String jsonString = fileContent;
            LinkedHashMap<String ,String> jsonMap = JSON.parseObject(jsonString,new TypeReference<LinkedHashMap<String,String>>(){});
            this.httpTester = new MyHttpTester(jsonMap);
        }catch (FileNotFoundException e) {
            logger.error("文件不存在",e);
            throw new RuntimeException();
        } catch (IOException e) {
            logger.error("文件解析异常",e);
            throw new RuntimeException();
        }
    }
}
