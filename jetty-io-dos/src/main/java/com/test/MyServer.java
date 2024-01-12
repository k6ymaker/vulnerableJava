package com.test;

import org.eclipse.jetty.util.ssl.SslContextFactory;

public class MyServer {
    public static void startServer() throws Exception {
        SslContextFactory sslContextFactory = new SslContextFactory.Server();
        HttpConnectionFactory httpFactory = new HttpConnectionFactory();
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server,null,null,null,1,-1,AbstractConnectionFactory.getFactories(sslContextFactory ,httpFactory));
        connector.setPort(9988);
        connector.setHost("localhost");
        server.setConnectors(new Connector[]{connector});
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        HandlerCollection handlerCollection= new HandlerCollection();
        handlerCollection.setHandlers(new Handler[]{context,new DefaultHandler()});
        server.setHandler(handlerCollection);
        server.start();
        server.join();

    }


    public static void main(String[] args) throws Exception {
        startServer();
    }

}