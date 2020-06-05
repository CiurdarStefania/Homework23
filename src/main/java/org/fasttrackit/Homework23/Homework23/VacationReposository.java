package org.fasttrackit.Homework23.Homework23;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface VacationReposository  extends JpaRepository<Vacation, Integer>{

    List<Vacation> findById(int id);
    @Query(value = "SELECT TOP 1 * FROM location ", nativeQuery = true)
    Vacation myQuery();
    @Query(value = "SELECT Max(TOP 1) * FROM price WHERE price ", nativeQuery = true)
    Vacation myQuery();


}
