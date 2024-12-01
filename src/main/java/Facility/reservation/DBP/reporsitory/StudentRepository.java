package Facility.reservation.DBP.reporsitory;

import Facility.reservation.DBP.entity.Student; // Student 엔티티 클래스 임포트
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByNameAndStudentId(String name, Long studentId);
}

