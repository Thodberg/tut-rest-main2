package akademikerne.controller.view;

import akademikerne.AkademikerneApplication;
import akademikerne.controller.UtilController;
import akademikerne.domain.view.Rollebrugersystemrettighedview;
import akademikerne.repository.view.RollebrugersystemrettighedviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;


@CrossOrigin(origins = UtilController.KLIENT_URL)
@RestController
public class RollebrugersystemrettighedviewController {

    @Autowired
    private EntityManager entityManager;

    private final RollebrugersystemrettighedviewRepository rollebrugersystemrettighedviewRepository;

    RollebrugersystemrettighedviewController(RollebrugersystemrettighedviewRepository repository) {
        this.rollebrugersystemrettighedviewRepository = repository;
    }

    @GetMapping("/rollebrugersystemrettighedview")
    List<Rollebrugersystemrettighedview> all() {

        return rollebrugersystemrettighedviewRepository.findAll();
    }

    @GetMapping("/rollebrugersystemrettighedview/afdelingsleder")
    List<Rollebrugersystemrettighedview> allSystems() {
        entityManager.createNativeQuery("");

        List<Rollebrugersystemrettighedview> list =
               rollebrugersystemrettighedviewRepository.
                       findAllByRollenavnEqualsOrderBySystemnavn(UtilController.SYSTEM_EJER);


        return list;
    }



    @GetMapping("/rollebrugersystemrettighedview/systemejer")
    List<Rollebrugersystemrettighedview> allsystemsAsSystemEjer() {
        Integer  rolleindehaverid = AkademikerneApplication.getPrincipalUser().getBrugerid();

        List<Rollebrugersystemrettighedview> list1 =
                rollebrugersystemrettighedviewRepository.findAllByRolleindehaveridEqualsAndRollenavnEquals
                        ( rolleindehaverid, UtilController.SYSTEM_EJER);
                /**rollebrugersystemrettighedviewRepository.
                        findAllByRollenavnEqualsAndRolleindehaveridEqualsAndRettighedsnavnEquals
                                (UtilController.SYSTEM_EJER, rolleindehaverid, "skrive");**/
  /**              rollebrugersystemrettighedviewRepository.
                        findAllByRollenavnEqualsAndRolleindehaveridEquals
                                (UtilController.SYSTEM_EJER, rolleindehaverid);**/
        return list1;

    }




}
