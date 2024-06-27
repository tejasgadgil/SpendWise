<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Sign Up Successful</title>
</head>
<body>
  <div>
    <?php
    // Get the first_name parameter from the URL
    $first_name = isset($_GET["first_name"]) ? $_GET["first_name"] : "User";
    ?>
    <p>Sign up successful. Welcome to your new account <?php echo $first_name; ?>!</p>
    <a href="/templates/website.html"><button>Log In</button></a>
  </div>
</body>
</html>
