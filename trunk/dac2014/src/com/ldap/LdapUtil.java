package com.ldap;

import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class LdapUtil {
	private static final String ldapAdServer = "ldap://localhost:1389";
	private static final String ldapSearchBase = "dc=affixus,dc=com";
	private static final String ldapUsername = "cn=Directory Manager";
	private static final String ldapPassword = "rediff";
	private static final Hashtable<String, String> env = new Hashtable<String, String>();
	
	static {
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapAdServer);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, ldapUsername);
        env.put(Context.SECURITY_CREDENTIALS, ldapPassword);
	}
	
	public static void main(String[] args) throws Exception {
		connectionTest();
		ldapSearchDemo();
	}   
	
	public static void connectionTest() {
		try {
		    DirContext ctx = new InitialDirContext(env);
		    System.out.println("connected");
		    System.out.println(ctx.getEnvironment());

		    ctx.close();
		 
		} catch (AuthenticationNotSupportedException ex) {
		    System.out.println("The authentication is not supported by the server");
		} catch (AuthenticationException ex) {
		    System.out.println("incorrect password or username");
		} catch (NamingException ex) {
		    System.out.println("error when trying to create the context");
		}
	}
	
	public static void ldapSearchDemo() throws Exception{
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
