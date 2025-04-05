const e = require("express");
const server = e();
const PORT = 5252;
server.use(e.urlencoded({ extended: true }));
const dbConn = require("./config/databaseConnection");
const appRouter = require("./routes/appRoutes");
const userRouter = require("./routes/userRoutes");

server.use("/api", appRouter);
server.use("/user",userRouter)

server.listen(PORT, () => {
  console.log(`Server started on Port ${PORT}`);
});
