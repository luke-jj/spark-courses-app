# Web Development with Spark

## Add Spark As A Dependency For The Current Project
```
dependencies {
    // add the spark micro framework
    compile "com.sparkjava:spark-core:2.7.2"
}
```

## Web Server
Frameworks either embed or integrate with a specific Web Server. This is what
handles the actual communication over HTTP. It makes sure it can handle many
requests at once and serve multiple clients.

    Spark uses the Jetty webserver

## Routing
An HTTP request specifies the resource it wants through headers. A framework
allows developers to define what code gets run based on the resource requested.
They usually allow you to partially match the URI, to keep things dynamic.

## Request and Response Objects
Frameworks usually give you very rich request and response objects that are
representations of the HTTP requests and responses. These objects make it very
easy for you to check if a header exists, or handle normal HTTP status codes.

## Templating
Most pages have a surrounding style and only little bits of dynamic data.
Instead of writing all those bits in a string, the idea of templaing is used.
Most frameworks allow you to snap in different templating languages to build
pages and push in just the dynamic bits into the surrounding HTML.

    // use the handlebars templating engine
    compile "com.sparkjava:spark-template-handlebars:2.7.1"

    // the standard path for templates is src/main/resources/templates/

    main/resources/templates/            holds the template files

### Serving Static Files (html, css, assets)
Set `staticFileLocation("/public");` in the main() method before the app has
started. Static files will then be served from `main/resources/public/`. This
Url is then the base url for accessing static resources.

## Sending Responses

    Spark.get(resourcePath, function(req, res))
    static method handles get requests


## Cookies
Cookies are part of HTTP and when set, they will be present on every request
to the domain.

    Response.cookie(String name, String value)  - set new cookie
    Request.cookie(String name)                 - retrieve cookie


## Data Model
DAO - Data Access Object - is a design pattern that is used to decouple the in-
memory data model from the data persistence method. Data can then be stored in
files, or different databases without changing the code.

