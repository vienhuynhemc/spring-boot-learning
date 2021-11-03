package com.axomactive.demo.repository;

import com.axomactive.demo.entity.Department;
import com.axomactive.demo.entity.LocationEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByLocation(LocationEnum locationEnum);

    @Query("select d from Department d where d.name like %?1")
    List<Department> findByDepartmentName(String name);

    @Query(value = "SELECT * FROM Department WHERE name = ?1", nativeQuery = true)
    List<Department> findByDepartmentNameV2(String name);


}
