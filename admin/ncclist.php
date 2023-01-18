<?php include 'inc/header.php';?>
<?php include 'inc/sidebar.php';?>
<?php include '../classes/ncc.php' ?>
<?php
	$ncc = new ncc();
	if(isset($_GET['delidncc'])){
		$id = $_GET['delidncc'];
		$delncc = $ncc->delete_ncc($id);
	}
?>
        <div class="grid_10">
            <div class="box round first grid">
                <h2>Ncc List</h2>
                <div class="block">      
					<?php
						if(isset($delncc)){
							echo $delncc;
						}
					?>  
                    <table class="data display datatable" id="example">
					<thead>
						<tr>
							<th>Serial No.</th>
							<th>Ncc Name</th>
							<th>Phone</th>
							<th>Email</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<?php
							$show_ncc = $ncc->show_ncc();
							if($show_ncc){
								$i = 0;
								while($result = $show_ncc->fetch_assoc()){
									$i++;
							
						?>
						<tr class="odd gradeX">
							<td><?php echo $i; ?></td>
							<td><?php echo $result['name'] ?></td>
							<td><?php echo $result['phone'] ?></td>
							<td><?php echo $result['email'] ?></td>
							<td><?php 
							$nccID = $result['id'];
							if(checkprivilege("nccedit.php?nccid=")){
								echo "<a href='nccedit.php?nccid=$nccID'>Edit</a>";
							}
							?>
								
							<a onclick="return confirm('Are you want to delete ?')" href='?delidncc=<?php echo $nccID ?>'><?php
						
							if(!checkprivilege("nccedit.php?nccid=") && checkprivilege("?delidncc=")){
								echo "Delete";
							}else{
								if(checkprivilege("?delidncc=")){
									echo "|| Delete";
								} 	
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
	$(document).ready(function () {
	    setupLeftMenu();

	    $('.datatable').dataTable();
	    setSidebarHeight();
	});
</script>
<?php include 'inc/footer.php';?>
