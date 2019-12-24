package com.example.collect.feign;

import com.example.collect.domain.GoodsPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 宋澳龙
 * @date 2019/12/14 22:58
 */
@Service
@FeignClient(name = "goodsInfoService",url = "http://112.124.5.232:8027")
public interface GoodsInfoServiceApi {
    /**
     * 通过商品ID获取商品模块中商品详细信息的接口
     * @param id
     * @return GoodsPo
     */
    @GetMapping("/inner/goods/{id}")
    GoodsPo getGoodsByIdIn(@PathVariable(value = "id") Integer id);
}
