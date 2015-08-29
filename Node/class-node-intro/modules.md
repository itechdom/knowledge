## Module
Organize our code into files that can be included into each other
We use "require" to load our module
we have seen it in:
```
var http = require('http');
```


## Our first module
Let's create a module that:
 
* take the request object
* get the headers
* return the connection header


## Module exports
```
var requestConnection = function(request){

    console.log(request.headers.connection);

}
module.exports = requestFormatter;
```