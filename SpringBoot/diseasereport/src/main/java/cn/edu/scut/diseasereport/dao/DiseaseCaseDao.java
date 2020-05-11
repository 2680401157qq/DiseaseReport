package cn.edu.scut.diseasereport.dao;

import cn.edu.scut.diseasereport.entity.DiseaseCase;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: giahao
 * @date: 2020/5/11 11:58
 * @description:
 */
@Mapper
@Repository
public interface DiseaseCaseDao {
    /**
     * 查询案例
     * @param params 查询案例时使用的条件信息
     * @return 返回筛选到的案例信息
     */
    List<DiseaseCase> selectDiseaseCase(Map<String, Object> params);

    /**
     * 编辑案例
     * @param diseaseCase 需要更新的案例的信息
     * @return 返回是否更新成功
     */
    int updateDiseaseCase(DiseaseCase diseaseCase);

    /**
     * 新增案例
     * @param diseaseCase 需要插入的案例的信息
     * @return 返回是否新增成功
     */
    int insertDiseaseCase(DiseaseCase diseaseCase);

    /**
     * 删除案例
     * @param id 需要删除的案例的id
     * @return 返回是否删除成功
     */
    int deleteDiseaseCase(Integer id);
}
