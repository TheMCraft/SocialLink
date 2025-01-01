<?php
session_start();
require_once 'sociallink/mysql.php';

$token = $_GET['token'];
$uuid = $_GET['uuid'];

if (isset($token)) {
    $stmt = $mysql->prepare("SELECT COUNT(*) as count FROM sociallink_users WHERE minecraft_token = ?");
    $stmt->execute([$token]);
    $rowCount = $stmt->fetch()['count'];
    if ($rowCount > 0) {
        echo "success";
        $stmt = $mysql->prepare("UPDATE sociallink_users SET minecraft_uuid = ?, minecraft_token = NULL WHERE minecraft_token = ?");
        $stmt->execute([$uuid, $token]);
        exit();
    } else {
        echo "error: token invalid";
    }
} else {
    echo "error: no token input";
    exit();
}
?>
