//package com.fas.connect.exception_handler;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class GlobalErrorController implements ErrorController {
//    private final Logger logger = LoggerFactory.getLogger(GlobalErrorController.class);
//
//    @RequestMapping("/error")
//    public String handleError(HttpServletRequest request) {
//    	// Get the exception from the request attributes
//        Throwable ex = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
//
//        // Default error message
//
//        String errorMessage = "An error occurred in the application.";
//        
////        // Log only the first line of the error message
////        if (ex != null) {
////            String[] lines = ex.getMessage().split("\n");
////            errorMessage = lines[0];
////        }
//        
//        logger.error(errorMessage);
//        
//        return "error"; // Return the name of the error view
//    }
//
//    public String getErrorPath() {
//        return "/error";
//    }
//}
