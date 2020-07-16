package com.fnet.common.config;

public class Config {
    /**
     * The port is used for monitor browser
     */
    public static final int DEFAULT_OUTER_REMOTE_PORT = 8081;
    /**
     * The port is used for inner server
     */
    public static final int DEFAULT_OUTER_SERVER_PORT = 9091;
    public static final String DEFAULT_OUTER_SERVER_ADDRESS = "127.0.0.1";
    public static final String DEFAULT_PASSWORD = "12345678";
    public static final int DEFAULT_REAL_SERVER_PORT = 8080;
    public static final String DEFAULT_REAL_SERVER_ADDRESS = "127.0.0.1";

    public static int OUTER_REMOTE_PORT;
    public static int OUTER_SERVER_PORT;
    public static String OUTER_SERVER_ADDRESS;
    public static String PASSWORD;
    public static int REAL_SERVER_PORT;
    public static String REAL_SERVER_ADDRESS = "127.0.0.1";
}