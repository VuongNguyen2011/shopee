<?php include 'inc/header.php'; ?>
<?php include 'inc/sidebar.php'; ?>
<?php include '../classes/category.php' ?>
<?php include '../classes/brand.php' ?>
<?php include '../classes/cart.php' ?>
<?php
// $cat = new category();
$cart = new cart();
// $cart = new cart();
if(isset($_GET['confirmID']) && $_GET['confirmID'] != null){
    $idConfirm = $_GET['confirmID'];
    $cart->updateStatus0($idConfirm);
    echo "<script> document.location='oderlist.php' </script>";
}
if(isset($_GET['delidOder'])){
    $idConfirm = $_GET['delidOder'];
    $cart->deleteOder($idConfirm);

    // header("Location: oderlist.php?delidOder=$idConfirm");
}
?>
<div class="grid_10">
    <div class="box round first grid">
        <h2>Oder List</h2>
        <?php
            if(isset($result)){
                echo $result;
            }
        ?>
        <div class="block">
            <table class="data display datatable" id="example">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tên sản phẩm</th>
                        <th>Tên khách hàng</th>
                        <th>Màu Sắc</th>
                        <th>Price</th>
                        <th>Quatity</th>
                     
                        <th>Status</th>
                       
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <?php
					$listcart = $cart->show_oder();
					if ($listcart) {
						$i=0;
						while ($result = $listcart->fetch_assoc()) {
							$i++;
					?>
                    <tr class="odd gradeX">
                        <td><?php echo $i ?></td>
                        <td><?php echo $result['productName'] ?></td>
                        <td>Nguyên Đẹp Trai</td>
                        <td><?php echo $result['colorID'] ?></td>
                        <td><?php echo $result['price'] ?></td>
                        <td><?php echo $result['quatity'] ?></td>
                        <td><?php  switch($result['status']){
                        case 0:
                            echo "Đang Xử Lí";
                        break;
                        case 1:
                            echo "Đang Vận Chuyển";
                        break;
                            case 2:
                                echo "Đã Nhận";
                            break;
                        } ?></td>
                        
                        <td><?php 
                        $idCart = $result['cartDetaiID'];
							 switch($result['status']){
                                case 0:
                                    
                            echo "<a href='?confirmID=$idCart' style='text-decoration: none;
                            color: red;
                            font-weight: 500;'>Confirm</a>";
                                break;
                                case 1:
                                    echo "Đang Vận Chuyển";
                                break;
                                    case 2:
                                        echo "<a href='?delidOder=$idCart' style='text-decoration: none;
                                        color: blue;
                                        font-weight: 500;'>Xóa</a>";
                                    break;
                                }
							?></a></td>
                    </tr>
                    <?php

						}
					}
					?>
                </tbody>
            </table>

        </div>
    </div>
</div>

<script type="text/javascript">
$(document).ready(function() {
    setupLeftMenu();
    $('.datatable').dataTable();
    setSidebarHeight();
});
</script>
<?php include 'inc/footer.php'; ?>