package akademikerne.ldap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.HasControls;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
//import oracle.aurora.jdni.sess_iiop.ServiceCtx;

public class TestLDapSearch {

    public static void main(String[] argv) throws Exception {
        String url = "ldap://ITR-DC03.itr.lan:389";
        //String url = "ldap://ITR-DC03.itr.lan:3268";
        //String url = "ldap://ITR-DC03.itr.lan:636";
        //String username = "ITR\\jejth";
        String username = "CN=Jens Jakob Thodberg,OU=BAL,OU=Users,OU=Miracle42,OU=Companies,DC=itr,DC=lan";
        System.out.println("Password: " + username);
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);
        //env.put(Context.SECURITY_AUTHENTICATION, "sasl_mech");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        //env.put(Context.REFERRAL,"ignore");
        //env.put(Context.SECURITY_PROTOCOL,"ssl");

        //env.put(Context.SECURITY_AUTHENTICATION, ServiceCtx.SSL_LOGIN);
        env.put(Context.SECURITY_PRINCIPAL, username);
        env.put(Context.SECURITY_CREDENTIALS, "BassemandKat123!");

        LdapContext ctx = new InitialLdapContext(env, null);

        System.out.println("LDAP Connection Successful");

        NamingEnumeration answer = ctx.search("OU=BAL,OU=Users,OU=Miracle42,OU=Companies,DC=itr,DC=lan", "(cn=*)", null);

        System.out.println(ctx.getResponseControls());

        while (answer.hasMore()) {
            SearchResult si = (SearchResult) answer.next();
            if (si instanceof HasControls) {
                System.out.println(((HasControls) si).getControls());
            }/*w  w   w .    de  m   o   2s    . c  o m  */
        }
        System.out.println(ctx.getResponseControls());
    }


}