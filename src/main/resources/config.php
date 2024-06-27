<?php
define('DBSERVER', 'localhost'); // Database server
define('DBUSERNAME', 'root'); // Database username
define('DBPASSWORD', 'tiger'); // Database password
define('DBNAME', 'db'); // Database name

// Connect to MySQL database
$db = mysqli_connect(DBSERVER, DBUSERNAME, DBPASSWORD, DBNAME);

// Check db connection
if ($db === false) {
    die("Error: Connection error. " . mysqli_connect_error());
}
?>
