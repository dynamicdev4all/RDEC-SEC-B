const express = require('express');
const userRouter = express.Router();
const path = require('path');
const { userRegister, userLogin, userVerification } = require('../controllers/userController');
userRouter.get("/login", (request, response) => {
  response.sendFile(path.join(__dirname, "../public", "login.html"));
});
userRouter.get("/register", (request, response) => {
  response.sendFile(path.join(__dirname, "../public", "register.html"));
});
userRouter.get("/verify-email", (request, response) => {
  userVerification(request.query.token)
});
userRouter.post("/create-new-user", userRegister);
userRouter.post("/login-user", userLogin);
module.exports = userRouter;
