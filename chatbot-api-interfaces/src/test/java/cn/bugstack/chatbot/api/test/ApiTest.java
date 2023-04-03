package cn.bugstack.chatbot.api.test;



import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;


import java.io.IOException;

/**
 * ApiTest
 *
 * @author 22855
 * @description 单元测试
 * @date 2023/4/3 14:01
 */
public class ApiTest {
    @Test
    public void query_unanswered_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/51112154452484/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie","zsxqsessionid=ea1000a63fc590485d0bbbba34108715; UM_distinctid=18745caf5c68f8-05662d73aef7d3-7a545474-1bcab9-18745caf5c71683; sensorsdata2015jssdkcross={\"distinct_id\":\"215258141422281\",\"first_id\":\"1873fd228cc10ee-001fab7986638c-7a545471-1821369-1873fd228cd1caa\",\"props\":{},\"$device_id\":\"1873fd228cc10ee-001fab7986638c-7a545471-1821369-1873fd228cd1caa\",\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3M2ZlMzI4MDkxYTAzLTBmYWM0Y2IxZDQ5ODhjLTdhNTQ1NDcxLTE4MjEzNjktMTg3M2ZlMzI4MGExYzIwIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiMjE1MjU4MTQxNDIyMjgxIn0=\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"215258141422281\"}}; abtest_env=product; __cuid=6c0c7c483a1d428180c998948dfcf27f; amp_fef1e8=66c80638-dce6-4cc2-9856-f2597d313361R...1gt2smsnq.1gt2smsnu.1.1.2; zsxq_access_token=F80CC261-0DD4-AB0B-59DE-9CD74D0E5E51_3BE7F845CC8C1753");
        get.addHeader("Content-Type","application/json;charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void answer_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/412585428422128/comments");
        post.addHeader("cookie","zsxqsessionid=ea1000a63fc590485d0bbbba34108715; UM_distinctid=18745caf5c68f8-05662d73aef7d3-7a545474-1bcab9-18745caf5c71683; sensorsdata2015jssdkcross={\"distinct_id\":\"215258141422281\",\"first_id\":\"1873fd228cc10ee-001fab7986638c-7a545471-1821369-1873fd228cd1caa\",\"props\":{},\"$device_id\":\"1873fd228cc10ee-001fab7986638c-7a545471-1821369-1873fd228cd1caa\",\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3M2ZlMzI4MDkxYTAzLTBmYWM0Y2IxZDQ5ODhjLTdhNTQ1NDcxLTE4MjEzNjktMTg3M2ZlMzI4MGExYzIwIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiMjE1MjU4MTQxNDIyMjgxIn0=\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"215258141422281\"}}; abtest_env=product; __cuid=6c0c7c483a1d428180c998948dfcf27f; amp_fef1e8=66c80638-dce6-4cc2-9856-f2597d313361R...1gt2smsnq.1gt2smsnu.1.1.2; zsxq_access_token=F80CC261-0DD4-AB0B-59DE-9CD74D0E5E51_3BE7F845CC8C1753");
        post.addHeader("Content-Type","application/json;charset=UTF-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我也不会\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("application/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
