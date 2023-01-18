<?php include 'inc/header.php'; ?>
<?php include 'inc/sidebar.php'; ?>
<?php include '../classes/category.php' ?>
<?php include '../classes/brand.php' ?>
<?php include '../classes/product.php' ?>
<?php include '../classes/warehouse.php' ?>
<?php
include_once('../classes/discount.php');
$cat = new category();
$brand = new brand();
$product = new product();

?>
<style>

.formSelect{
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    margin-top: 10px;
    
}
.formSelect div{
    padding-right: 10px;
}

.formSelect label{
    padding-left: 10px;
}
.formSelect button{
    background-color: rgba(3, 6, 86, 1);
    color: white;
    border: 1px solid white;
    border-radius: 5%;
    padding: .1rem .75rem;
    line-height: 1.5;
}
.formSelect button:hover{
    background-color: rgba(64,179,245);
}
.form-control-date {
    font-size: .9rem;
    font-weight: 400;
    color: #495057;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #ced4da;
    border-radius: .25rem;
}
.titleStat{
    text-align: center;
    margin-top: 20px;
    font-size: 16px;
    color: rgba(3, 6, 86, 1);
    font-weight: bold;
}
</style>

<div class="grid_10">

    <div class="box round first grid">
        <h2>WareHouse List</h2>
        
        <form  action="" method="get" onsubmit="return checkDate();">
            <div class="formSelect">
                
                <!-- <div>Category</div>
                <select name="theloai" style="margin-right: 10px" class="form-control-date">
                <?php 
                    $sql="SELECT * FROM tbl_category";
                    if($result=$product->select($sql)){
                        while($row=$result->fetch_array()){
                ?>
                
                <option value="<?php echo $row[0] ?>"<?php if($row[0]==17) echo "selected" ?>><?php echo $row[1] ?></option>
                
                <?php }} ?>
                </select> -->
                
                <div>
                    <label for="dateFrom">From</label>
                    <input type="date" name="dateFrom" id="dateFrom" class="form-control-date">
                </div>
                <div>
                    <label for="dateTo">To</label>
                    <input type="date" name="dateTo" id="dateTo" class="form-control-date">
                </div>
                <button style="padding-left: 10px" type="submit">Confirm</button>
            </div>
        </form>
        <?php 
            if(isset($_GET['dateFrom'])&&isset($_GET['dateTo'])){
                $dateFrom=$_GET['dateFrom'];
                $dateTo=$_GET['dateTo'];
                $dateFormatFrom=date("d-m-Y", strtotime($dateFrom));  
                $dateFormatTo=date("d-m-Y", strtotime($dateTo));  
                
        ?>
        
        <div class="block">

            <div class="titleStat"> 
                    <p><?php echo "Thống kê đơn hàng đã nhập"?></p>
                    <p><?php echo "Từ ".$dateFormatFrom." đến ".$dateFormatTo ?></p>
            </div>
            <table class="data display datatable" id="example">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Product Name</th>
                        <th>Product Old</th>
                        <th>Product New</th>
                        <th>Quatity</th>
                        <th>Sum</th>
                        <th>Ncc</th>
                        <th>Date</th>
                        <!-- <th>Action</th> -->
                    </tr>
                </thead>
                <tbody>
                    <?php
                    $product = new product();
                    $warehouse = new warehouse();
                    $total = 0;
					$listProduct = $warehouse->show_warehouse1($dateFrom,$dateTo);
					if ($listProduct) {
						$i=0;
						while ($result = $listProduct->fetch_assoc()) {
							$i++;
					?>
                    <tr class="odd gradeX">
                        <td><?php echo $i; $total+= $result['qty'] * $result['priceOld']; ?></td>
                        <td><?php echo $result['productName'] ?></td>
                        <td><?php echo number_format($result['priceOld']) ?></td>
                        <td><?php echo number_format($result['priceNew']) ?></td>
                        <td><?php echo $result['qty'] ?></td>
                        <td><?php echo number_format($result['qty'] * $result['priceOld'], 0, ',', '.')  ?></td>
                        <td><?php echo $result['name'] ?></td>
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
            <div class="titleStat"> 
                    <p><?php echo "Tổng tiền đã nhập hàng:  ". number_format($total)?></p>
                    <?php 
                        echo "<a href='pdf.php?from=$dateFrom&to=$dateTo' style='text-decoration: none;
                        color: white; background-color: orange;
                        font-weight: 500; padding: 5px;'>In PDF</a>"
                    ?>
            </div>
        </div>
        
        <?php } 
        
        if(isset($productArr)){
        ?>
        
        
            
        <div class="block" id="content" style="margin-top: 40px">
            <div class="titleStat"> 
                    <p><?php echo "Top sản phẩm bán chạy thuộc ".$nameTL?></p>
                    <p><?php echo "Từ ".$dateFormatFrom." đến ".$dateFormatTo ?></p>
                    
            </div>
            <?php 
                
                array_multisort(array_column($productArr, 'productQty'), SORT_DESC,$productArr);
                
                //print_r($productArr)
            ?>
            
            <table class="data display datatable"  id="toptable">
                <thead>
                    <tr>

                        <th>Top</th>
                        <th>Tên Sản Phẩm</th>
                        <th>Số Lượng</th>
                        
                    </tr>
                </thead>
                <tbody>
                    
                <?php
                    $i=1;
                    foreach($productArr as $row){
                        
                        
                ?>
                    <tr class="odd gradeX">
                        <td><?php echo $i ?></td>
                        <td><?php echo $row['productName']?></td>
                        <td><?php echo $row['productQty']?></td>

                        
                    </tr>
                <?php 
                $i++;
                    }
                ?>
                </tbody>
            </table>
            
        </div>
            
        <?php
        }
        ?>
        </div>

    </div>


<script>

$(document).ready(function() {
    setupLeftMenu();
    $('.datatable').dataTable();
    setSidebarHeight();
});

function checkDate(){
    var from=document.getElementById("dateFrom");
    var to=document.getElementById("dateTo");
    
    if(from.value==""&&to.value==""){
        alert("Xin hãy nhập chọn khoảng thời gian");
        
        return false;
    }
    if(to.value<from.value){
        alert("Bạn nhập khoảng thời gian không hợp lệ")
        return false;
    }
    return true;
    
}

</script>

<?php include 'inc/footer.php'; ?>

