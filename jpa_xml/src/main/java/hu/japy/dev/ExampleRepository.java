package hu.japy.dev;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * A basic Spring Data JPA repository
 *
 * @author GHajba
 *
 */
public interface ExampleRepository extends JpaRepository<ExampleEntity, Long> {

    /**
     * The example query which starts in the repository interface Java file and will be extracted to an XML file.
     *
     * @param createdBy
     *            the parameter which is used for the filter
     * @return a list of found entries or an empty list if nothing found
     */
    // @Query(nativeQuery = true, value = "SELECT id, createdBy FROM ExampleEntity where createdBy LIKE %:createdBy%")
    @Query(name = "ExampleRepository.findInformationBasedOnCreator")
    List<Object[]> findInformationBasedOnCreator(@Param("createdBy") String createdBy);
}
