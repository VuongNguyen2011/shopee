<?php include 'inc/header.php'; ?>
<?php include 'inc/sidebar.php'; ?>
<?php include '../classes/ncc.php'; ?>
<?php
$ncc = new ncc();
if (!isset($_GET['nccid']) || $_GET['nccid'] == NULL) {
    echo "<script>window.location = 'ncclist.php'</script>";
} else {
    $id = $_GET['nccid'];
}

if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['submit'])) {
    $updatencc = $ncc->update_ncc($_POST, $id);
}
?>



<div class="grid_10">
    <div class="box round first grid">
        <h2>Edit New Ncc</h2>

        <div class="block">
            <?php
            if (isset($updatencc)) {
                echo $updatencc;
            }
            $user = $ncc->getnccbyId($id);
            if ($user) {
                while ($result = $user->fetch_assoc()) {

            ?>
                    <!-- enctype="multipart/form-data" dung de post hinh anh len khong co thi se bi loi -->
                    <form id="RegForm" action="" method="POST" enctype="multipart/form-data">
                        <table class="form" style="width: 56%;">

                            <tr>
                                <td>
                                    <label>Full Name</label>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <input id="name" type="text" value="<?php echo $result['name'] ?>" name="name" placeholder="Enter Full Name..." class="medium" />
                                        <p class="form-message"></p>
                                    </div>
                                </td>
                            </tr>
                            
                            <tr>
                                <td>
                                    <label>Email</label>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <input id="email" type="text" value="<?php echo $result['email'] ?>" name="email" placeholder="Email VD: nguyendz1@gmail.com" class="medium" />
                                        <p class="form-message"></p>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Phone</label>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <input id="phone" type="text" name="phone" value="<?php echo $result['phone'] ?>" placeholder="Enter Phone VD: 0853633360" class="medium" />
                                        <p class="form-message"></p>
                                    </div>
                                </td>
                            </tr>
                            </tr>
                            <tr>
                                <td>
                                    <label>Address</label>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <input id="address" type="text" name="address" value="<?php echo $result['address'] ?>" placeholder="Enter Adress" class="medium" />
                                        <p class="form-message"></p>
                                    </div>
                                </td>
                            </tr>
                            </tr>
                            
                            
                            <tr>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <input type="submit" name="submit" Value="Uploads" />
                                </td>
                            </tr>
                        </table>
                    </form>
            <?php

                }
            }
            ?>
        </div>
    </div>
</div>
<!-- Load TinyMCE -->
<script src="js/tiny-mce/jquery.tinymce.js" type="text/javascript"></script>
<script src="js/invalid.js" type="text/javascript"></script>
<script>
    invalid({
        form: '#RegForm',
        errorSelector: '.form-message',
        rules: [
            invalid.isRequired('#phone'),
            invalid.isMinLength('#phone', 10),
            invalid.isPhone('#phone', 'Số điện thoại không hợp lệ'),
            invalid.isRequired('#name'),
            invalid.isRequired('#user'),
            invalid.isRequired('#pass'),
            invalid.isMinLength('#pass', 8),
            invalid.isRequired('#passAgain'),
            invalid.isConfrimValue('#passAgain', function() {
                return document.querySelector('#RegForm #pass').value;
            }),

            invalid.isRequired('#address'),
            invalid.isRequired('#email'),
            invalid.isEmail('#email'),
        ]
    });
</script>
<script type="text/javascript">
    $(document).ready(function() {
        setupTinyMCE();
        setDatePicker('date-picker');
        $('input[type="checkbox"]').fancybutton();
        $('input[type="radio"]').fancybutton();
    });
</script>
<!-- Load TinyMCE -->
<?php include 'inc/footer.php'; ?>