/*global requirejs */

// Ensure any com.spring.mvc.request for this webjar brings in jQuery.
requirejs.config({
  paths: { 
    "bootstrap": webjars.path("bootstrap", "js/bootstrap"),
    "bootstrap-css": webjars.path("bootstrap", "css/bootstrap")  
  },
  shim: { "bootstrap": [ "jquery" ] }
});

