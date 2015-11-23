var http = require("http");
var url = require("url");


function start() {
   function onRequest(request, response) {
      console.log("Request received.");
      response.writeHead(200, {"Content-Type": "text/plain"});
      response.write("Hello World test.js");
      response.end();
   }
 
   http.createServer(onRequest).listen(3333);
   console.log("Server has started.");
}

start();
