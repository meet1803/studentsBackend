package in.ac.charusat.studentmgmtsystem.repository;

import in.ac.charusat.studentmgmtsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
