<?php include 'inc/header.php'; ?>
<?php include 'inc/sidebar.php'; ?>
<?php include '../classes/dashbord.php' ?>
<div class="grid_10">
  <div class="box round first grid">
    <h2> Dashbord - Danh sách sản phẩm đã cháy hàng</h2>
    <div class="block">
      <table class="data display datatable" id="example">
        <thead>
          <tr>
            <th>ID</th>
            <th>Product Name</th>
            <th>Product Price</th>
            <th>Product Image</th>
            <th>Qty</th>
            <th>Description</th>
            <th>Interest</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <?php
          $product = new dashbord();
          $listProduct = $product->show_qtyLost();
          if ($listProduct) {
            $i = 0;
            while ($result = $listProduct->fetch_assoc()) {
              $i++;
          ?>
              <tr class="odd gradeX">
                <td><?php echo $i ?></td>
                <td><?php echo $result['productName'] ?></td>
                <td><?php echo $result['price'] ?></td>
                <td><img src="uploads/<?php echo $result['img'] ?>" alt="avt" width="100px"></td>

                <td><?php echo $result['qty'] ?></td>
                <td><?php echo $result['description'] ?></td>

                <td><?php echo $result['interest'] ?></td>
                <!-- <td><a href="productedit.php?productid=<?php echo $result['productID'] ?>">Edit</a> || <a href="productUpdate.php?productid=<?php echo $result['productID'] ?>">upd</a> || <a onclick="return confirm('You want to delete ?')" href="?delid=<?php echo $result['productID'] ?>">Del</a></td> -->
                <td>
                <a href='productWare.php?productid=<?php echo $result['productID'] ?>'>Nhập Hàng</a>
                </td>
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