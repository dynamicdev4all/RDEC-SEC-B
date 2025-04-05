const express = require('express');
const appRouter = express.Router();
const path = require('path');
appRouter.get("/", (request, response) => {
    response.sendFile(path.join(__dirname, "../public", "homepage.html"));
  });
appRouter.get("/*", (request, response) => {
    response.sendFile(path.join(__dirname, "../public", "fourOfour.html"));
  });

  module.exports = appRouter;