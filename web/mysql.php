<?php
$host = "localhost";
$dbname = "SocialLink";
$user = "";
$password = "";

try {
    $dsn = "mysql:host=$host;dbname=$dbname;charset=utf8";
    $options = [
        PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES => false,
    ];

    $mysql = new PDO($dsn, $user, $password, $options);
} catch (PDOException $e) {
    echo "SQL Error: " . $e->getMessage();
}
?>
