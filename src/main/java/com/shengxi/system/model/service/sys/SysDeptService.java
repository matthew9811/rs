package com.shengxi.system.model.service.sys;

import com.shengxi.system.entites.sys.SysDeptEntity;
import java.sql.SQLException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 * 部门服务层接口
 * @author matthew
 */
public interface SysDeptService {


    Integer insertSysDeptEntity(SysDeptEntity sysDeptEntity);

    List<SysDeptEntity> selectList(SysDeptEntity sysDeptEntity);
}
