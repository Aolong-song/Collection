package com.example.collect.service.impl;

import com.example.collect.domain.CollectItemPo;
import com.example.collect.domain.CollectItem;
import com.example.collect.mapper.CollectionMapper;
import com.example.collect.service.CollectionService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

/**
 * @author 宋澳龙
 * @time 2019/12/11 12:00
 */
@Service
public class CollectionServiceImpl implements CollectionService {
    @Resource
    private CollectionMapper collectionMapper;

    @Override
    public List<CollectItem> list(Integer userId){
        return collectionMapper.list(userId);
    }

    @Override
    public CollectItemPo add(CollectItemPo collectItemPo) {
        if(collectionMapper.add(collectItemPo)==0){
               collectItemPo.setId(-1);
        }
        return collectItemPo;
    }

    @Override
    public CollectItemPo select(Integer id){
        return collectionMapper.select(id);
    }

    @Override
    public int delete(Integer id){
        return collectionMapper.delete(id);
    }

    @Override
    public boolean beExist(CollectItemPo collectItemPo){
        CollectItemPo collectItemPo1 = collectionMapper.beExist(collectItemPo);
        if(collectItemPo1!=null&&collectItemPo1.getUserId().equals(collectItemPo.getUserId())&&collectItemPo1.getGoodsId().equals(collectItemPo.getGoodsId())){
            return false;
        }else{
            return true;
        }
    }
}
