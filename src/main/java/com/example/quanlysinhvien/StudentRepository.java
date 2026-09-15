package com.example.quanlysinhvien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    @Query("SELECT s FROM Student s WHERE " +
            ":kw IS NULL OR :kw = '' OR " +
            "LOWER(s.studentCode) LIKE LOWER(CONCAT('%', :kw, '%')) OR " +
            "LOWER(s.fullName) LIKE LOWER(CONCAT('%', :kw, '%')) OR " +
            "LOWER(s.email) LIKE LOWER(CONCAT('%', :kw, '%')) OR " +
            "LOWER(s.phone) LIKE LOWER(CONCAT('%', :kw, '%'))")
    List<Student> searchStudents(@Param("kw") String keyword);
}