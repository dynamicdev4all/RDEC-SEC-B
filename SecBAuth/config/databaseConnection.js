const mongoose = require("mongoose");

const dbConn = mongoose
  .connect(
    "mongodb+srv://piebytwo014:piebytwo014@cluster0.sy8lt.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
  )
  .then(() => {
    console.log("Database Connection Success");
  })
  .catch((err) => {
    console.log(`Some Error in database ${err}`);
  });


  module.exports= dbConn;