## Nodejs is Non-Blocking

What are the things that block?

* Reads/Writes on the Database
* Calls to other web services

* In other web frameworks, we create a separate thread for each request.
* Nodejs uses only one thread!


## Events
    
An event can be, for example:

* Incoming Connection from the client
* Incoming Data from the client
* Server close event.
* event event event.


## Events (Continue)

Let's look at our server, what are the events our server can have?

* request
* connection
* close

https://nodejs.org/api/http.html#http_event_request


## Block Node

The only way you can block your application is that you don't end the event callback.

```
var http = require('http');

server = http.createServer();

server.on('connection',function(req,res){

    res.writeHead("hello");
    res.write("hi there");
    console.log("If you don't call res.end node will stop the whole application");
    console.log("This is a very common mistake");
    
});

server.listen(1337, '127.0.0.1');
```
