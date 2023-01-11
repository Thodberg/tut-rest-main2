package akademikerne.controller.table;


import akademikerne.controller.UtilController;
import akademikerne.domain.table.Brugere;
import akademikerne.exception.NotFoundException;
import akademikerne.repository.table.BrugereRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = UtilController.KLIENT_URL)
@RestController
class BrugereController {

    private final BrugereRepository brugereRepository;

    BrugereController(BrugereRepository brugereRepository) {
        this.brugereRepository = brugereRepository;
    }

    /**@RequestMapping("/resource")
    public Map<String,Object> home() {
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }**/

    /**@RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }**/

   /** @RequestMapping("/login")
    public boolean login(@RequestBody SecurityProperties.User user) {

        //return user.getUserName().equals("user") && user.getPassword().equals("password");

        String name = user.getName(); // changed from userName to Name
        String password = user.getPassword();
        List<Brugere> brugere =
                brugereRepository.findAllByLoginbrugernavnEqualsAndPasswordEquals(name, password);
        if(brugere.size() == 0) {
            System.out.println("User authentication failed brugernavn and password could not be matched");
            return false;
        } else if (brugere.size() > 0) {
            Brugere bruger = brugere.get(0);
            AkademikerneApplication.setPrincipalUser(bruger);
            System.out.println("User authentication was successfully");
            return true;
        } else {
            System.out.println("User authentication failed");
            return false;
        }

    }**/

    /**@RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }**/


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/brugere")
    List<Brugere> all() {
        //System.out.println("hallo hallo ");
        return brugereRepository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/brugere")
    Brugere newBrugere(@RequestBody Brugere newBrugere) {
        return brugereRepository.save(newBrugere);
    }

    // Single item

    @GetMapping("/brugere/{id}")
    Brugere one(@PathVariable Integer id) {

        return brugereRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Brugere"));
    }



    @DeleteMapping("/brugere/{id}")
    void deleteBrugere(@PathVariable Integer id) {
        brugereRepository.deleteById(id);
    }


}


