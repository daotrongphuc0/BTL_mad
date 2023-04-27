<?php
include "connect.php";
$query = "SELECT * FROM donhang ";
$mangdonhang = array();
$data = mysqli_query($conn,$query);
while($row = mysqli_fetch_assoc($data)){
    array_push($mangdonhang,new Hoadon(
        $row['id'],
        $row['tenkhachhang'],
        $row['sodienthoai'],
        $row['email'],
        $row['diachi']
    ));
}
echo json_encode($mangdonhang);
class Hoadon{
    public function __construct($id,$tenkhachhang,$sodienthoai,$email,$diachi){
        $this->id= $id;
        $this->tenkhachhang= $tenkhachhang;
        $this->sodienthoai= $sodienthoai;
        $this->email= $email;
        $this->diachi= $diachi;
    }
}

?>