package cn.edu.scut.diseasereport.repository;

import cn.edu.scut.diseasereport.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: giahao
 * @date: 2020/5/8 22:36
 * @description:
 */
public interface CaseRepository extends JpaRepository<Case, Integer> {
}
