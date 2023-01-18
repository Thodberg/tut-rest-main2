package akademikerne.repository.view;

import akademikerne.domain.view.Brugereview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrugereviewRepository extends JpaRepository<Brugereview, Integer> {

    List<Brugereview>
    findAllByAfdelingslederid(Integer id);

    List<Brugereview>
    findAllByAfdelingslederidOrderByBrugernavn(Integer id);

    List<Brugereview>
    findAllByOrderByBrugernavn();

}
