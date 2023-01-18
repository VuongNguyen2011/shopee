<?php
$filepath = realpath(dirname(__FILE__));
include_once ($filepath.'/../lib/database.php');
include_once ($filepath.'/../helpers/format.php');

?>

<?php
class dashbord
{
    private $db;
    private $fm;

    public function __construct()
    {
        $this->db = new Database();
        $this->fm = new Format();
    }
    
    public function show_qtyLost(){
        $query = "SELECT * FROM `tbl_product` WHERE qty = 0";
        $result = $this->db->select($query);
        return $result;
    }
    public function getcolorbyId($id){
        $query = "SELECT DISTINCT c.colorName,c.colorID
        FROM tbl_pro_color_details as pc, tbl_product_color as c
        WHERE pc.productID ='$id' AND pc.colorID=c.colorID";
        $result = $this->db->select($query);
        return $result;
    }
    
}

?>