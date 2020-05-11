package cn.edu.scut.diseasereport.service.impl;

import cn.edu.scut.diseasereport.dao.DiseaseCaseDao;
import cn.edu.scut.diseasereport.entity.DiseaseCase;
import cn.edu.scut.diseasereport.service.DiseaseCaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author: giahao
 * @date: 2020/5/11 11:59
 * @description:
 */
@Service
public class DiseaseCaseServiceImpl implements DiseaseCaseService {
    @Autowired
    private DiseaseCaseDao diseaseCaseDao;

    @Override
    public PageInfo<DiseaseCase> selectDiseaseCase(Map<String, Object> params, int pageNo, int pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 1 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<DiseaseCase> diseaseCaseList = diseaseCaseDao.selectDiseaseCase(params);
        return new PageInfo<>(diseaseCaseList);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int updateDiseaseCase(DiseaseCase diseaseCase) {
        if (diseaseCase == null || diseaseCase.getId() == null || diseaseCase.getUser().getId() == null) {
            return 0;
        }
        int result = diseaseCaseDao.updateDiseaseCase(diseaseCase);
        if (result == 0) {
            throw new RuntimeException();
        }
        return result;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int insertDiseaseCase(DiseaseCase diseaseCase) {
        if (diseaseCase == null || diseaseCase.getUser().getId() == null) {
            return 0;
        }
        int result = diseaseCaseDao.insertDiseaseCase(diseaseCase);
        if (result == 0) {
            throw new RuntimeException();
        }
        return result;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int deleteDiseaseCase(Integer id) {
        int result = diseaseCaseDao.deleteDiseaseCase(id);
        if (result == 0) {
            throw new RuntimeException();
        }
        return result;
    }
}
