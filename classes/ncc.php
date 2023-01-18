<?php
$filepath = realpath(dirname(__FILE__));
// include_once ($filepath.'/../lib/session.php');
include_once ($filepath.'/../lib/database.php');
include_once ($filepath.'/../helpers/format.php');
?>

<?php
class ncc
{
    private $db;
    private $fm;

    public function __construct()
    {
        $this->db = new Database();
        $this->fm = new Format();
    }
    public function insert_ncc($data)
    {
        $nccName = mysqli_real_escape_string($this->db->link, $data['name']);
        $email = mysqli_real_escape_string($this->db->link, $data['email']);
        $phone = mysqli_real_escape_string($this->db->link, $data['phone']);
        $address = mysqli_real_escape_string($this->db->link, $data['address']);
    

        if ($nccName == "" || $email == ""|| $phone == "" || $address == "") {
            $alert = "<span class='error'>Field can not empty</span>";
            return $alert;
        } else {
            // move_uploaded_file($file_temp,$uploaded_image);
            $query = "INSERT INTO tbl_ncc(`name`, `phone`, `email`, `address`) VALUES('$nccName','$phone','$email','$address')";
            
            $result = $this->db->insert($query);

            if ($result) {
                $alert = "<span class='success'>Create ncc Successfully </span>";
                return $alert;
            } else {
                $alert = "<span class='error'>Create ncc Not Success</span>";
                return $alert;
            }
        }
    }
    
    public function show_ncc(){
        $query = "CALL `getNcc`()";
        $result = $this->db->select($query);
        return $result;
    }

    public function getnccbyId($id){
        $query = "SELECT * FROM tbl_ncc WHERE id ='$id'";
        $result = $this->db->select($query);
        return $result;
    }

    
    public function update_ncc($data,$id){
        $nccName = mysqli_real_escape_string($this->db->link, $data['name']);
        $email = mysqli_real_escape_string($this->db->link, $data['email']);
        $phone = mysqli_real_escape_string($this->db->link, $data['phone']);
        $address = mysqli_real_escape_string($this->db->link, $data['address']);

        

        $id = mysqli_real_escape_string($this->db->link, $id);

        if ($nccName == "" || $email == ""|| $phone == "") {
            $alert = "<span class='error'>Field can not empty</span>";
            return $alert;
        } else {
                 $query = "UPDATE `tbl_ncc` SET `name`='$nccName',`email`='$email',`phone`='$phone',`address`='$address' WHERE id = '$id'";
            
            $result = $this->db->update($query);

            if ($result) {
                $alert = "<span class='success'>Updated ncc Successfully</span>";
                return $alert;
            } else {
                $alert = "<span class='error'>Updated ncc Not Success</span>";
                return $alert;
            }
        }
    }
    public function delete_ncc($id){
       $query = "DELETE FROM tbl_ncc WHERE id = '$id'";
       $result = $this->db->delete($query);
       if($result){
           return "<span class='success'>Delete ncc Successfully</span>";
       }else{
            return "<span class='error'>Delete ncc Not Success</span>";
       }
    }


    

}

?>