<?php

$servername = "localhost";
$username = "root";
$password = "";
$db = "datadb";

$conn = new mysqli($servername,$username,$password,$db);

if($conn->connect_error){
	die("connection failed: ".$conn->connect_error);
}


$NAME = $_POST['user_name'];
$EMAIL = $_POST['emails'];
$POSTS = $_POST['posts'];


$query = "INSERT INTO users(name,email,post)VALUES('$NAME','$EMAIL','$POSTS')";

$result = $conn->query($query);

if($result==1){
	$response = array("status"=>"1","message"=>"Posts Successfully inserted");
}
else{
	$response = array("status"=>"0","message"=>"Posts Failed to inserted");
}

echo json_encode($response);












?>