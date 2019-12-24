package com.example.collect;

import com.example.collect.domain.CollectItem;
import com.example.collect.utils.JacksonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author 宋澳龙
 * @date 2019/12/18 11:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class getCollections {
    @Value("http://${host}:${port}/collectionService/collections")
    String url;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void listRight() throws Exception {

        /* 设置请求头部*/
        URI uri = new URI(url.replace("collections","collections?id=2"));
        HttpHeaders httpHeaders = testRestTemplate.headForHeaders(uri);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        /*exchange方法模拟HTTP请求*/
        ResponseEntity<String> response = testRestTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        /*取得响应体*/
        String body = response.getBody();
        Integer errno = JacksonUtil.parseInteger(body, "errno");
        Integer status = JacksonUtil.parseInteger(body, "status");
        assertEquals(200, errno);
        assertNotEquals(500, status);

    }

}
