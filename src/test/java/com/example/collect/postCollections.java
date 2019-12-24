package com.example.collect;

import com.example.collect.domain.CollectItem;
import com.example.collect.domain.CollectItemPo;
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
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author 宋澳龙
 * @date 2019/12/18 11:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class postCollections {
    @Value("http://${host}:${port}/collectionService/collections")
    String url;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void addRight() throws Exception {

        /* 设置请求头部*/
        URI uri = new URI(url);
        HttpHeaders httpHeaders = testRestTemplate.headForHeaders(uri);
        CollectItemPo collectItemPo = new CollectItemPo();
        collectItemPo.setUserId(10);
        collectItemPo.setGoodsId(280);
        HttpEntity httpEntity = new HttpEntity(collectItemPo,httpHeaders);

        /*exchange方法模拟HTTP请求*/
        ResponseEntity<String> response = testRestTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        /*取得响应体*/
        String body = response.getBody();
        Integer errno = JacksonUtil.parseInteger(body, "errno");
        Integer status = JacksonUtil.parseInteger(body, "status");
        assertEquals(200, errno);
        assertNotEquals(500, status);

    }

    @Test
    public void addNull() throws Exception {

        /* 设置请求头部*/
        URI uri = new URI(url);
        HttpHeaders httpHeaders = testRestTemplate.headForHeaders(uri);
        CollectItemPo collectItemPo = new CollectItemPo();
        collectItemPo.setUserId(null);
        collectItemPo.setGoodsId(null);
        HttpEntity httpEntity = new HttpEntity(collectItemPo,httpHeaders);

        /*exchange方法模拟HTTP请求*/
        ResponseEntity<String> response = testRestTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        /*取得响应体*/
        String body = response.getBody();
        Integer errno = JacksonUtil.parseInteger(body, "errno");
        Integer status = JacksonUtil.parseInteger(body, "status");
        assertEquals(711, errno);
        assertNotEquals(500, status);
    }

    @Test
    public void addExist() throws Exception {

        /* 设置请求头部*/
        URI uri = new URI(url);
        HttpHeaders httpHeaders = testRestTemplate.headForHeaders(uri);
        CollectItemPo collectItemPo = new CollectItemPo();
        collectItemPo.setUserId(10);
        collectItemPo.setGoodsId(280);
        HttpEntity httpEntity = new HttpEntity(collectItemPo, httpHeaders);

        /*exchange方法模拟HTTP请求*/
        ResponseEntity<String> response = testRestTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        /*取得响应体*/
        String body = response.getBody();
        Integer errno = JacksonUtil.parseInteger(body, "errno");
        Integer status = JacksonUtil.parseInteger(body, "status");
        assertEquals(711, errno);
        assertNotEquals(500, status);
    }
}
