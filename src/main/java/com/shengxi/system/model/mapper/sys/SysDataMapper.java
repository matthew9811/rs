package com.shengxi.system.model.mapper.sys;

import com.shengxi.system.entites.sys.SysData;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 字典数据mapper
 *
 * @author matthew
 */
@Repository
@Mapper
public interface SysDataMapper {

    /**
     * 通过dictData获取对应的dictData详情信息
     *
     * @param sysData dictData
     * @return list
     */
    List<SysData> selectDictDataListByDictId(SysData sysData);

    /**
     * 根据对应的字典类型和值获取对应的对应数据
     *
     * @param typeNo 对应的字典分类
     * @return List<SysData>
     */
    List<SysData> getValue(@Param("typeNo") String typeNo);

    /**
     * 当前有效数据
     *
     * @return count。
     */
    String getNum();


    /**
     * 插入数据
     *
     * @param record obj
     * @return status
     */
    int insert(SysData record);

    /**
     * 动态插入数据
     *
     * @param record obj
     * @return status
     */
    int insertSelective(SysData record);


    /**
     * 动态update
     *
     * @param record record
     * @return status
     */
    int updateByTypeCodeSelective(SysData record);

    /**
     * update
     *
     * @param record record
     * @return status
     */
    int updateByTypeCode(SysData record);

    /**
     * 删除数据
     *
     * @param typeCode typeCode
     * @param updateBy userNo
     * @return status
     */
    int deleteByTypeCode(@Param("typeCode") String typeCode, @Param("updateBy") String updateBy);
}