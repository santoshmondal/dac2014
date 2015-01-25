package com.ldap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

@SuppressWarnings("unchecked")
public class LdapUtil {
	private static final String ldapAdServer = "ldap://localhost:1389";
	private static final String ldapSearchBase = "dc=affixus,dc=com";
	private static final String ldapUsername = "cn=Directory Manager";
	private static final String ldapPassword = "rediff";
	
	public static void main(String[] args) throws Exception {
		ldapDemo();
	}   
	
	public static void ldapDemo() throws Exception{
		@SuppressWarnings("rawtypes")
		Hashtable  env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapAdServer);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, ldapUsername);
        env.put(Context.SECURITY_CREDENTIALS, ldapPassword);
        
        InitialDirContext ctx =  new InitialDirContext(env);
        
        String searchFilter = "(&(objectClass=person)(cn=sant*))";

        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        NamingEnumeration<SearchResult> results = ctx.search(ldapSearchBase, searchFilter, searchControls);

        while(results.hasMore()) {
        	SearchResult searchResult = (SearchResult) results.next();
            Attributes attributes = searchResult.getAttributes();
            
            NamingEnumeration<String> iDs = attributes.getIDs();
            while(iDs.hasMore()) {
            	String next = iDs.next();
            	Attribute attribute = attributes.get(next);
            	System.out.println(attribute);
            }
            
            System.out.println("\n");
        }
	}
}
