<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/list.css">
  <style>
    body {
      margin: 0;
      padding: 0;
      background: url('/resources/images/banner.jpeg') no-repeat center center fixed;
      background-size: cover;
      font-family: Arial, sans-serif;
      color: white;
    }

    .navbar {
      background: rgba(0, 0, 0, 0.5); /* Background color with transparency */
      padding: 15px;
    }

    /* Add any additional styles for the navbar, logo, and links here */

    .footer {
      text-align: center;
      padding: 10px;
      background: rgba(0, 0, 0, 0.5);
    }
  </style>
  <title>EasyBank</title>
</head>
<body>
<nav class="navbar">
  <div class="container2">
    <div class="navbar-brand">
      <span class="navbar-logo">
        <a href="https://mobiri.se">
          <img src="${pageContext.request.contextPath}/resources/images/E-removebg-preview.png" style="height: 4.3rem;">
        </a>
      </span>
      <span class="navbar-caption-wrap">
        <a class="text-logo" href="https://mobiri.se">EasyBank</a>
      </span>
    </div>
    <button class="navbar-toggler">
      <div class="hamburger">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
      </div>
    </button>
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link link text-black display-4" href="#">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link link text-black display-4" href="${pageContext.request.contextPath}../../client">Clients</a>
      </li>
      <li class="nav-item">
        <a class="nav-link link text-black display-4" href="${pageContext.request.contextPath}../../employe">Employees</a>
      </li>
    </ul>
    <div class="navbar-buttons mbr-section-btn right-phase">
      <a class="text-logo" href="https://mobiri.se">Home Page</a>
    </div>
  </div>
</nav>
<footer class="footer">
  <div>
    <p>&copy; 2023 EasyBank. All rights reserved.</p>
  </div>
</footer>
</body>
</html>
