<?php
// Start the session
session_start();

// if the user is already logged in then redirect user to welcome page
if (isset($_SESSION["userid"]) && $_SESSION["userid"] === true) {
    header("location: welcome.php");
    exit; // Exit the script to prevent further execution
}
?>
