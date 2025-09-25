package ch.roones.uebungen._05fifthday.java.repository;

import ch.roones.uebungen._05fifthday.java.repository.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
