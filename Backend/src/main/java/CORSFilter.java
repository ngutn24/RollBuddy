/*
 * Copyright (C) 2021 Kevin Zatloukal.  All rights reserved.  Permission is
 * hereby granted to students registered for University of Washington
 * CSE 331 for use solely during Spring Quarter 2021 for purposes of
 * the course.  No other use, copying, distribution, or modification
 * is permitted without prior written consent. Copyrights for
 * third-party components of this work must be honored.  Instructors
 * interested in reusing these course materials should contact the
 * author.
 */

package main.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Spark;

import java.util.HashMap;

// Based on code from
// https://stackoverflow.com/questions/45295530/spark-cors-access-control-allow-origin-error

/**
 * The CORSFilter disables browser-side Cross-Origin Request security features,
 * to allow the React application (with origin localhost:3000) to make requests
 * of the Spark server (with origin localhost:4567) without them being rejected.
 * <p>
 * Note that this is generally a security vulnerability for production applications
 * (see "Cross-Site Scripting" or "XSS"), but it isn't a problem for our specific
 * application.
 */
public class CORSFilter {

    // ===============
    // You don't need to understand how this works at all, but it's something that's necessary
    // for our two-server system to work nicely together. If you're curious, read the comments
    // in this class and do some searching for "CORS", "Cross-Site Scripting", and "XSS" online.
    // ===============

    /**
     * Contains all the headers that need to be added
     */
    private final HashMap<String, String> corsHeaders = new HashMap<>();

    /**
     * Prepares the filter to be applied to the Spark system by initialized the headers
     * that need to be used.
     */
    public CORSFilter() {
        corsHeaders.put("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        corsHeaders.put("Access-Control-Allow-Origin", "http://localhost:3000");
        corsHeaders.put("Access-Control-Allow-Headers",
                "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
        corsHeaders.put("Access-Control-Allow-Credentials", "true");
    }

    /**
     * Applies the filter globally to all Spark responses. Anytime this Spark server responds
     * to a request following the invocation of this method, completely-permissive CORS headers
     * will be added to the response headers.
     */
    public void apply() {
        Filter filter = new Filter() {
            @Override
            public void handle(Request request, Response response) {
                corsHeaders.forEach(response::header);
            }
        };
        Spark.afterAfter(filter); // Applies this filter even if there's a halt() or exception.
        //
        Logger logger = LoggerFactory.getLogger("CampusPaths Server");
        logger.info("Listening on: http://localhost:" + Spark.port());
    }
}
