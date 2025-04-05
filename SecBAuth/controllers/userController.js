const userModel = require("../models/userModel");
const jwt = require('jsonwebtoken');
const sendMail = require("../service/sendEmail");
const JWT_SECRET= "this_is_top_secret"

const userRegister =async (request, response)=>{
  const {username, email, password}= request.body;
    try {    
        const exist = await userModel.findOne({ email: email });
        // if (exist) {
        //   console.log("This email is associated with another account");
        // } 
        // else {
          const newUser = await userModel({
            username: username,
            email: email,
            password: password,
            isActive: false,
          });
          await newUser.save();
          sendMail(email, username)
          console.log("Registration Success");
        // }
      } catch (error) {
        console.log("Registration Failed ", error);
      }
}

const userLogin = async (request, response)=>{
  const {email, password}=request.body;
    try {    
        const loginUser = await userModel.findOne({ email: email });
        if (loginUser) {
          if (loginUser.password == password && loginUser.isActive) {
            console.log("Login Success");
          } else if (loginUser.password == password && !loginUser.isActive) {
            console.log("Please Activate your Account");
          } else if (loginUser.password != password) {
            console.log("Invaild Password");
          }
        } else {
          console.log("User does not exist, please try registration");
        }
      } catch (error) {
        console.log("Registration Failed");
      }
}

const userLogout = ()=>{
    
}

const userVerification = (recToken)=>{
  try {
    const decodedToken = jwt.verify(recToken, JWT_SECRET);
    const userEmail = decodedToken.email;
    console.log("Verification Success ",userEmail)
  } catch (error) {
    if(jwt.TokenExpiredError){
      console.log("The token is expired")
    }else{
      console.log("Some error occured ",error)
    }
  }
 
}

const userAccountPasswordReset = ()=>{
    
}

module.exports = {userRegister, userLogin, userVerification}