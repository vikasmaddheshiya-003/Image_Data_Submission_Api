/*
 * package com.bank.server;
 * 
 * import com.bank.rest.ChequeSubmissionHandler; import io.undertow.Undertow;
 * import io.undertow.server.RoutingHandler;
 * 
 * public class UndertowServer {
 * 
 * public static void main(String[] args) {
 * 
 * RoutingHandler routes = new RoutingHandler()
 * .post("/expressClear_API/apis/cheque_submission", new
 * ChequeSubmissionHandler());
 * 
 * Undertow.builder() .addHttpListener(8547, "127.0.0.0") .setHandler(routes)
 * .build() .start();
 * 
 * System.out.println("Cheque Submission API started on port 8547"); } }
 */



package com.bank.server;

import com.bank.rest.ChequeSubmissionHandler;
import io.undertow.Undertow;
import io.undertow.server.RoutingHandler;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.security.KeyStore;

public class UndertowServer {

    public static void main(String[] args) throws Exception {

        RoutingHandler routes = new RoutingHandler()
                .post("/expressClear_API/apis/cheque_submission",
                        new ChequeSubmissionHandler());

        Undertow.builder()
                .addHttpsListener(8547, "0.0.0.0", createSSLContext())
                .setHandler(routes)
                .build()
                .start();
        
        System.out.println("Cheque Submission API started on HTTPS port 8547");
    }

    
    
    private static SSLContext createSSLContext() throws Exception {

        String keystorePath = "/home/administrator/mykeystore.jks";
        char[] password = "Vikas12345".toCharArray();

        KeyStore keyStore = KeyStore.getInstance("PKCS12");  // FIXED
        keyStore.load(new FileInputStream(keystorePath), password);

        KeyManagerFactory kmf =
                KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, password);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), null, null);

        return sslContext;
    }

}
