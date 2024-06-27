<?php
session_start();

if (!isset($_SESSION['loggedin']) || $_SESSION['loggedin'] !== true) {
    header("Location: /templates/website.html");
    exit();
}
?>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <link rel="stylesheet" href="/statci/global.css" />
  <link rel="stylesheet" href="/static/index.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500;600;700&display=swap" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Merriweather+Sans:wght@700&display=swap" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Merriweather:wght@700&display=swap" />
  <style>
    body {
      font-family: 'Montserrat', sans-serif;
      margin: 0;
      display: flex;
    }

    .sidebar {
      width: 250px;
      background-color: #4a5f50;
      height: 100vh;
      padding-top: 20px;
      display: flex;
      flex-direction: column;
      align-items: center;
      color: white;
    }

    .sidebar a {
      text-decoration: none;
      color: white;
      width: 100%;
      text-align: center;
      padding: 15px 0;
      transition: background-color 0.3s;
    }

    .sidebar a:hover {
      background-color: #3a4f40;
    }

    .sidebar a.active {
      background-color: #3a4f40;
    }

    .notification-bar {
      width: 300px;
      background-color: #4a5f50;
      height: 100vh;
      padding-top: 20px;
      position: fixed;
      left: -300px;
      transition: left 0.3s;
      color: white;
    }

    .notification-bar .close-btn {
      text-align: right;
      padding: 0 20px;
    }

    .notification-bar .close-btn button {
      background: none;
      border: none;
      color: white;
      font-size: 20px;
      cursor: pointer;
    }

    .notification-bar h2 {
      text-align: center;
    }

    .notification-bar ul {
      padding: 0 20px;
    }

    .content {
      flex-grow: 1;
      padding: 20px;
      background-color: #f5f5f5;
    }

    .header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-bottom: 20px;
    }

    .header h1 {
      margin: 0;
    }

    .header button {
      padding: 10px 20px;
      background-color: #4a5f50;
      color: white;
      border: none;
      cursor: pointer;
    }

    .widgets {
      display: flex;
      flex-wrap: wrap;
      gap: 20px;
    }

    .widget {
      background-color: white;
      border-radius: 8px;
      padding: 20px;
      flex: 1;
      min-width: 250px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .widget h2 {
      margin-top: 0;
    }

    /* Additional styling for the notifications */
    .notification-bar ul {
      list-style-type: none;
      padding: 0 20px;
    }

    .notification-bar ul li {
      background-color: #4a5f50;
      margin-bottom: 10px;
      padding: 10px;
      border-radius: 5px;
      color: white;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
    }

    .notification-bar ul li:last-child {
      margin-bottom: 0;
    }
  </style>
</head>

<body>
  <div class="sidebar">
    <a href="#home" class="active">Home</a>
    <a href="#" id="notificationsButton">Notifications</a>
    <a href="#transactions">Transactions</a>
    <a href="#budget">Budget</a>
  </div>
  <div class="notification-bar" id="notificationBar">
    <div class="close-btn">
      <button id="closeNotificationsButton">&times;</button>
    </div>
    <h2>Notifications</h2>
    <br>
    <ul id="notificationList">
      <!-- Notifications will be dynamically added here -->
    </ul>
  </div>
  <div class="content">
    <div class="header">
      <h1>Dashboard</h1>
      <a href="../logout.php" id="logoutButton">Logout</a>
    </div>
    <div class="widgets">
      <div class="widget">
        <h2>Recent Transactions</h2>
        <ul>
          <li>Transaction 1: $50 on Groceries</li>
          <li>Transaction 2: $20 on Entertainment</li>
          <li>Transaction 3: $100 on Rent</li>
          
        </ul>
      </div>
      <div class="widget">
        <h2>Budget Status</h2>
        <p>Groceries: $200 spent of $500</p>
        <p>Entertainment: $50 spent of $100</p>
      </div>
    </div>
  </div>
  <script>
    // document.getElementById("logoutButton").addEventListener("click", function () {
    //   window.location.href = "./website.html";
    // });

    document.getElementById("notificationsButton").addEventListener("click", function () {
      document.getElementById("notificationBar").style.left = "0";
    });

    document.getElementById("closeNotificationsButton").addEventListener("click", function () {
      document.getElementById("notificationBar").style.left = "-300px";
    });

    // Add sample notifications dynamically (replace with actual notifications fetch logic)
    const notifications = [
      "You have spent 80% of your entertainment budget",
      "Your savings goal is 25% complete"
    ];
    const notificationList = document.getElementById("notificationList");
    notifications.forEach(notification => {
      const li = document.createElement("li");
      li.textContent = notification;
      notificationList.appendChild(li);
    });
  </script>
</body>

</html>