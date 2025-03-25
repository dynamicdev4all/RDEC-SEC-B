const e = require("express");

const mongoose = require("mongoose");

const server = e();

server.use(e.urlencoded({ extended: true }));

const path = require("path");

mongoose
  .connect(
    "mongodb+srv://piebytwo014:piebytwo014@cluster0.sy8lt.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
  )
  .then(() => {
    console.log("Database Connection Success");
  })
  .catch((err) => {
    console.log(`Some Error in database ${err}`);
  });

const userSchema = mongoose.Schema({
  username: String,
  email: String,
  password: String,
  isActive: Boolean,
});

const userModel = mongoose.model("user", userSchema);

server.get("/", (request, response) => {
  response.sendFile(path.join(__dirname, "public", "homepage.html"));
});
server.get("/login", (request, response) => {
  response.sendFile(path.join(__dirname, "public", "login.html"));
});
server.get("/register", (request, response) => {
  response.sendFile(path.join(__dirname, "public", "register.html"));
});
server.post("/create-new-user", async (request, response) => {
  try {
    const { username, email, password } = request.body;

    const exist = await userModel.findOne({ email: email });
    if (exist) {
      console.log("This email is associated with another account");
    } else {
      const newUser = await userModel({
        username: username,
        email: email,
        password: password,
        isActive: false,
      });
      await newUser.save();
      console.log("Registration Success");
    }
  } catch (error) {
    console.log("Registration Failed");
  }
});
server.get("/*", (request, response) => {
  response.sendFile(path.join(__dirname, "public", "fourOfour.html"));
});

server.listen(5252, () => {
  console.log("Server Started ");
});
