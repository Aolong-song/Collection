package com.example.collect.mapper;

import com.example.collect.domain.CollectItem;
import com.example.collect.domain.CollectItemPo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author 宋澳龙
 * @time 2019/12/11 12:00
 */
@Mapper
public interface CollectionMapper {

    /**
     * 查找该用户的所有收藏
     * @param userId 用户ID
     * @return List<CollectItem> userCollectItem
     */
    List<CollectItem> list(@Param(value = "userId") Integer userId);

    /**
     * 查询数据库中是否有该条收藏
     * @param id
     * @return collectItem
     */
    CollectItem select(Integer id);

    /**
     * 删除收藏
     * @param id 收藏id
     * @return 收藏删除状态 0-数据库操作失败 1-数据库操作成功
     */
    int delete(Integer id);

    /**
     * 添加收藏
     * @param collectItemPo 收藏项
     * @return 收藏插入状态 0-数据库操作失败 1-数据库操作成功
     */
    int add(CollectItemPo collectItemPo);

    /**
     * 查重 判断是否有重复的收藏
     * @param collectItemPo
     * @return collectItemPo
     */
    CollectItemPo beExist(CollectItemPo collectItemPo);
}
