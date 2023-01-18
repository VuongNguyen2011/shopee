<?php include 'inc/header.php'; ?>
<?php include 'inc/sidebar.php'; ?>
<?php include '../classes/category.php' ?>
<?php include '../classes/brand.php' ?>
<?php include '../classes/product.php' ?>
<?php include '../classes/warehouse.php' ?>
<?php include '../classes/ncc.php' ?>
<?php
$cat = new category();
$ncc = new ncc();
$brand = new brand();
$product = new product();
$warehouse = new warehouse();
if(isset($_GET['delidProduct'])){
    $id = $_GET['delidProduct'];
    $result = $product->delete_product($id);
}
?>
<div class="grid_10">
    <div class="box round first grid">
        <div class="" style="display: flex; ">
            <h2 style="width: 50%;">Warehouse List</h2>
            <h2 style="width: 50%; text-align: right;"><a href='reportsWare.php' style='text-decoration: none;
                            color: red;
                            font-weight: 500;'>Thống kê</a></h2>
            <!-- <a href='reportsWare.php' style='text-decoration: none;
                            color: red;
                            font-weight: 500;'>Thống kê</a> -->
        </div>
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
                        <th>Product Name</th>
                        <th>Product Old</th>
                        <th>Product New</th>
                        <th>Quatity</th>
                        <th>Ncc</th>
                        <th>Date</th>
                        <!-- <th>Action</th> -->
                    </tr>
                </thead>
                <tbody>
                    <?php
					$listProduct = $warehouse->show_warehouse();
					if ($listProduct) {
						$i=0;
						while ($result = $listProduct->fetch_assoc()) {
							$i++;
					?>
                    <tr class="odd gradeX">
                        <td><?php echo $i ?></td>
                        <td><?php echo $result['productName'] ?></td>
                        <td><?php echo $result['priceOld'] ?></td>
                        <td><?php echo $result['priceNew'] ?></td>
                        <td><?php echo $result['qty'] ?></td>
                        <td><?php echo $result['nccID'] ?></td>
                        <td><?php echo $result['date'] ?></td>
                        
                        <!-- <td><a href="productedit.php?productid=<?php echo $result['productID'] ?>">Edit</a> || <a href="productUpdate.php?productid=<?php echo $result['productID'] ?>">upd</a> || <a onclick="return confirm('You want to delete ?')" href="?delid=<?php echo $result['productID'] ?>">Del</a></td> -->
                        <!-- <td><?php 
							$productID = $result['productID'];
							if(checkprivilege("productedit.php?productid=")){
								echo "<a href='productedit.php?productid=$productID'>Edit</a>";
							}
							?>
								
                            <a onclick="return confirm('Are you want to delete ?')" href='?delidProduct=<?php echo $productID ?>'>
                            
                            <?php 
							if(!checkprivilege("productedit.php?productid=") && checkprivilege("productUpdate.php?productid=")){
								echo "<a href='productUpdate.php?productid=$productID'>Udp</a>";
							}else{
                                echo "<a href='productUpdate.php?productid=$productID'>|| Udp</a>";
                            }
							?>
								
                            <a onclick="return confirm('Are you want to delete ?')" href='?delidProduct=<?php echo $productID ?>'>
                            <?php
						
							if(!checkprivilege("productedit.php?productid=") && checkprivilege("?delidProduct=")){
								echo "Delete";
							}else{
								if(checkprivilege("?delidProduct=")){
									echo "|| Delete";
								} 	
							}
							?></a></td> -->
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