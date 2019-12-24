package com.example.collect.service;

import com.example.collect.domain.CollectItem;
import com.example.collect.domain.CollectItemPo;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author 宋澳龙
 * @time 2019/12/11 12:00
 */
@Service
public interface CollectionService {

    /**
     * 列出该用户的所有收藏项
     * @param userId 用户ID
     * @return
     */
    List<CollectItem> list(Integer userId);

    /**
     * 添加收藏
     * @param collectItemPo 收藏项
     * @return
     */
    CollectItemPo add(CollectItemPo collectItemPo);

    /**
     * 根据收藏ID查找收藏
     * @param id 收藏ID
     * @return
     */
    CollectItemPo select(Integer id);

    /**
     * 删除收藏
     * @param id
     * @return 删除收藏状态 0-数据库操作失败 1-数据库操作成功
     */
    int delete(Integer id);

    /**
     * 查重 判断是否有重复的收藏
     * @param collectItemPo
     * @return true表示无重复收藏 false表示有重复收藏
     */
    boolean beExist(CollectItemPo collectItemPo);
}
