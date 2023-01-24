package akademikerne.ldap;

import javax.naming.*;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.HasControls;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;

public class TestLdapsearch2 {

    public static void main(String[] argv) throws Exception {
        String url = "ldap://ITR-DC03.itr.lan:389";
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        //env.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
        //env.put(Context.SECURITY_CREDENTIALS, "secret");

        try {
            DirContext ctx = new InitialDirContext(env);
            System.out.println("connected");
            System.out.println(ctx.getEnvironment());
            ctx.getAttributes("CN=Jens Jakob Thodberg");


            // do something useful with the context...

            ctx.close();

        } catch (AuthenticationNotSupportedException ex) {
            System.out.println("The authentication is not supported by the server");
        } catch (AuthenticationException ex) {
            System.out.println("incorrect password or username");
        } catch (NamingException ex) {
            System.out.println("error when trying to create the context");
        }
    }

}
