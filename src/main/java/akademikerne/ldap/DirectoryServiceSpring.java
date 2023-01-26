package akademikerne.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryServiceSpring {

    /**public static void main(String[] args) {
        TestLdapSpring  ttt= new TestLdapSpring();
        LdapTemplate ldapTemplate = ttt.ldapTemplate();
        DirectoryServiceSpring dirsev =  new DirectoryServiceSpring();
        dirsev.search("Jens Jakob Thodberg");
    }*/

    @Autowired
    private LdapTemplate ldapTemplate;

    @Value("${ldap.base}")
    private String BASE_DN;

    @Autowired
    public DirectoryServiceSpring(LdapTemplate ldapTemplate) { this.ldapTemplate = ldapTemplate; }

    public List<String> search(String username) {
        return ldapTemplate
                .search(
                        "ou=bal",
                        "cn=" + username,
                        (AttributesMapper<String>) attrs -> (String) attrs.get("cn").get());
    }
}
