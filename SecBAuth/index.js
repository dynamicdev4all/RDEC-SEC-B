const e = require("express");

const mongoose = require("mongoose");

const server = e();

server.use(e.urlencoded({ extended: true }));

const path = require("path");

mongoose
  .connect("path to database")
  .then(() => {
    console.log("connection success");
  })
  .catch(() => {
    console.log("Some error occured");
  });

server.get("/", (request, response) => {
  response.sendFile(path.join(__dirname, "public", "index.html"));
  //   C:\Users\ACER\Documents\SecBAuth\public\index.html
});
server.get("/login", (request, response) => {
  response.sendFile(path.join(__dirname, "public", "login.html"));
});
server.get("/logout", (request, response) => {});
server.get("/register", (request, response) => {
  response.sendFile(path.join(__dirname, "public", "register.html"));
});
server.post("/create_new_user", (request, response) => {
  console.log(request.body);
});
server.get("/reset_password", (request, response) => {});

server.listen(5252, () => {
  console.log("Server Started ");
});
