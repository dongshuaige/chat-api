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
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @description: 单元测试
 * @author：hgd
 * @date: 2023-01-31
 */

public class ApiTest {
    @Test
    public void base64(){
        String cronExpression = new String(Base64.getDecoder().decode("MC8zMCAqICogKiAqID8="), StandardCharsets.UTF_8);
        System.out.println(cronExpression);
    }
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/15552288548212/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie", "sensorsdata2015jssdkcross={\"distinct_id\":\"15541454251442\",\"first_id\":\"182bb5bc4bece7-050dc4055675024-26021a51-1638720-182bb5bc4bf1920\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgyYmI1YmM0YmVjZTctMDUwZGM0MDU1Njc1MDI0LTI2MDIxYTUxLTE2Mzg3MjAtMTgyYmI1YmM0YmYxOTIwIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiMTU1NDE0NTQyNTE0NDIifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"15541454251442\"},\"$device_id\":\"182bb5bc4bece7-050dc4055675024-26021a51-1638720-182bb5bc4bf1920\"}; zsxq_access_token=28B93430-6397-3609-5BC9-1066AAA90CAC_6235B9BD29A8F210; zsxqsessionid=bf02f4b09dab62af310181de7ae9ce13; abtest_env=product; __cuid=eb11fc0fbac64c09899039b228c43b2b; amp_fef1e8=f791e824-3b46-475e-8ccc-8aa3e2bec1b0R...1go37tmb9.1go37tmbd.1.1.2; UM_distinctid=18606f4a3dfe03-05c6cd83cb5cab-26021051-190140-18606f4a3e01843");
        get.addHeader("Content-Type", "application/json; charset=UTF-8");
        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/584115114445824/answer");
        post.addHeader("cookie", "sensorsdata2015jssdkcross={\"distinct_id\":\"15541454251442\",\"first_id\":\"182bb5bc4bece7-050dc4055675024-26021a51-1638720-182bb5bc4bf1920\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgyYmI1YmM0YmVjZTctMDUwZGM0MDU1Njc1MDI0LTI2MDIxYTUxLTE2Mzg3MjAtMTgyYmI1YmM0YmYxOTIwIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiMTU1NDE0NTQyNTE0NDIifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"15541454251442\"},\"$device_id\":\"182bb5bc4bece7-050dc4055675024-26021a51-1638720-182bb5bc4bf1920\"}; zsxq_access_token=28B93430-6397-3609-5BC9-1066AAA90CAC_6235B9BD29A8F210; zsxqsessionid=bf02f4b09dab62af310181de7ae9ce13; abtest_env=product; __cuid=eb11fc0fbac64c09899039b228c43b2b; amp_fef1e8=f791e824-3b46-475e-8ccc-8aa3e2bec1b0R...1go37tmb9.1go37tmbd.1.1.2; UM_distinctid=18606f4a3dfe03-05c6cd83cb5cab-26021051-190140-18606f4a3e01843");
        post.addHeader("Content-Type", "application/json; charset=UTF-8");
        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我不会\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": true\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void test_chatGPT() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.openai.com/v1/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer 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");

        String paramJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"使用Java实现冒泡排序\", \"temperature\": 0, \"max_tokens\": 1024}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}
