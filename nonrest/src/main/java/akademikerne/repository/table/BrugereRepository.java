package akademikerne.repository.table;

import akademikerne.domain.table.Brugere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BrugereRepository extends JpaRepository<Brugere, Integer> {
    /*public List<Brugere>
    findAllByBrugernavnIsContainingIgnoreCaseAndRettetafIsContainingIgnoreCaseAndOprettetafIsContainingIgnoreCaseAndAfsluttetafIsContainingIgnoreCase(
            String brugernavn, String oprettetaf, String rettetaf, String afsluttetaf);*/


    List<Brugere> findAllByLoginbrugernavnEqualsAndPasswordEquals(String loginbrugernavn, String password);
}
