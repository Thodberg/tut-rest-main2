package akademikerne.repository.view;

import akademikerne.domain.view.Rollebrugersystemrettighedview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RollebrugersystemrettighedviewRepository extends JpaRepository<Rollebrugersystemrettighedview, Integer> {

    public List<Rollebrugersystemrettighedview>
    findAllByRollenavnAndRettighedstypesystemidEqualsAndRolleindehaveridEquals
            (String rollenavn, Integer rettighedtypesystemid, Integer rolleindehaveid);
    public List<Rollebrugersystemrettighedview>
    findAllByRollenavnAndRettighedstypesystemid
            (String rollenavn, Integer rettighedtypesystemid);

    public List<Rollebrugersystemrettighedview>
    findAllByRollenavnEqualsAndRolleindehaveridEquals
            (String rollenavn, Integer rolleindehaveid);
    public List<Rollebrugersystemrettighedview>
    findAllByRolleindehaveridEqualsAndRollenavnEquals
            (Integer rolleindehaveid,String rollenavn);

    public List<Rollebrugersystemrettighedview>
    findAllByRollenavnAndRettighedstypesystemidEquals
            (String rollenavn,  Integer systemid);


    public List<Rollebrugersystemrettighedview>
    findAllByRollenavnEqualsAndRolleindehaveridEqualsAndRettighedsnavnEquals
            (String rollenavn, Integer rolleindehaveid, String rettighedsnavn);



    public List<Rollebrugersystemrettighedview>
    findAllByRollenavnEquals
            (String rollenavn);

    public List<Rollebrugersystemrettighedview>
    findAllByRollenavnEqualsAndRolleindehaveridEqualsOrderBySystemnavn
            (String rollenavn, Integer rolleindehaveid);

    public List<Rollebrugersystemrettighedview>
    findAllByRollenavnEqualsOrderBySystemnavn
            (String rollenavn);



}
