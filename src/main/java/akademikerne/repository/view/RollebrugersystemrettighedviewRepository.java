package akademikerne.repository.view;

import akademikerne.domain.view.Rollebrugersystemrettighedview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RollebrugersystemrettighedviewRepository extends JpaRepository<Rollebrugersystemrettighedview, Integer>,
        PagingAndSortingRepository<Rollebrugersystemrettighedview, Integer>{

    @Query(value = "select * " +
            "from rollebrugersystemrettighedview where rollenavn ='Systemejer'" , nativeQuery = true)
    List<Rollebrugersystemrettighedview> findBySystermEjer33();


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

    public List<Rollebrugersystemrettighedview>
    findAllByRollenavnEqualsAndRettighedsnavnEquals
            (String rollenavn,  String rettighedsnavn);

}
