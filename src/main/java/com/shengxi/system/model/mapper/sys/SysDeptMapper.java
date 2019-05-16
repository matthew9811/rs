package com.shengxi.system.model.mapper.sys;

import com.shengxi.system.entites.subEntity.SubReplaceEntity;
import com.shengxi.system.entites.sys.SysDeptEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author : 郑杰
 * @Date: 2019/5/15 14:30
 * 部门数据接口
 */
@Component
@Mapper
public interface SysDeptMapper {
    /**
     *插入部门信息
     *@param sysDeptEntity 实体
     * @return Integer
     */
    Integer insertSysDeptEntity(SysDeptEntity sysDeptEntity);

    /**
     * 获取部门信息
     * @return list
     */
    List<SysDeptEntity> selectSysDeptEntityList(SysDeptEntity sysDeptEntity);
}
