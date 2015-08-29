## Express, an easy way to write APIs

* Simple framework
* Easy way to handle routes
* Uses Same Nodejs conventions
* Middlewares


## Listen Server!

The server should "listen" on a specific port for a connection.

```
var http = require('http');

server = http.createServer();

server.listen(1337);
console.log("Server is listening on 1337");

```
Now we have a running server


## Detect a connection event

Nodejs is built around events. 

Let's listen to the connection event on the server

```
var http = require('http');

server = http.createServer();

server.on('connection',function(req,res){
    res.end("hello world");
});

server.listen(1337, '127.0.0.1');

```


