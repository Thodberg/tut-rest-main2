package akademikerne.ldap;

import java.util.Hashtable;

import javax.naming.*;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.Control;
import javax.naming.ldap.HasControls;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
public class TestLdapConnection {
    public static void main(String[] args) {

        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://ITR-DC03.itr.lan:3268");

        try {
            //bind to the domain controller
            //LdapContext ctx = new InitialLdapContext(env, null);
            //DirContext ctx = new InitialDirContext(env);
            //ctx = new InitialLdapContext(env, null);
            //System.out.println("LDAP Connection Successful");

            // CN=Kasper Overgaard Dahl,OU=BAL,OU=Users,OU=Miracle42,OU=Companies,DC=itr,DC=lan
            //String searchString1 = "OU=BAL,OU=Users,OU=Miracle42,OU=Companies,DC=itr,DC=lan";
            //String searchString2 = "CN=Claus Lehmann Munch,OU=BAL,OU=Users,OU=Miracle42,OU=Companies,DC=itr,DC=lan";
            //String searchString3 = "OU=BAL,OU=Users,OU=Miracle42,OU=Companies,DC=itr,DC=lan";
           // Control[] controls = ctx.getRequestControls();
            //System.out.println("Controls: " + controls);

            //NamingEnumeration answer = ctx.search(searchString3, "(cn=*)", null);
            //SearchControls eee = controls


            //bind to the domain controller
            LdapContext ctx = new InitialLdapContext(env,null);
            ctx = new InitialLdapContext(env, null);
            System.out.println("LDAP Connection Successful");
            System.exit(0);
        } catch (NamingException e) {
            System.err.println("LDAP Notifications failure. " + e);
            System.exit(1);
        }

    }

}
