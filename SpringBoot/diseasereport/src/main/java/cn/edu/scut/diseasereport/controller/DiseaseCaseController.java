package cn.edu.scut.diseasereport.controller;

import cn.edu.scut.diseasereport.entity.DiseaseCase;
import cn.edu.scut.diseasereport.service.DiseaseCaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: giahao
 * @date: 2020/5/11 11:58
 * @description:
 */
@RestController
@RequestMapping("/case")
public class DiseaseCaseController {
    @Autowired
    private DiseaseCaseService diseaseCaseService;

    @RequestMapping(value = "/list/get", method = RequestMethod.POST)
    public PageInfo<DiseaseCase> selectDiseaseCase(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        // 获取参数
        params.put("disease_level", request.getParameter("disease_level"));
        params.put("grade", request.getParameter("grade"));
        params.put("institute", request.getParameter("institute"));
        params.put("major", request.getParameter("major"));
        params.put("clazz", request.getParameter("clazz"));
        params.put("dormitory", request.getParameter("dormitory"));
        // 获取分页信息
        int pageNo = Integer.parseInt(request.getParameter("page_no"));
        int pageSize = Integer.parseInt(request.getParameter("page_size"));
        PageInfo<DiseaseCase> page = diseaseCaseService.selectDiseaseCase(params, pageNo, pageSize);
        return page;
    }

    @RequestMapping(value = "/add/request", method = RequestMethod.POST)
    public int insertDiseaseCase(@RequestBody DiseaseCase diseaseCase) {
        try {
            return diseaseCaseService.insertDiseaseCase(diseaseCase);
        } catch (Exception e) {
            return 0;
        }
    }

    @RequestMapping(value = "/edit/request", method = RequestMethod.POST)
    public int updateDiseaseCase(@RequestBody DiseaseCase diseaseCase) {
        try {
            return diseaseCaseService.updateDiseaseCase(diseaseCase);
        } catch (Exception e) {
            return 0;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public int deleteDiseaseCase(Integer id) {
        try {
            return diseaseCaseService.deleteDiseaseCase(id);
        } catch (Exception e) {
            return 0;
        }
    }
}
