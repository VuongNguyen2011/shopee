<?php include './fpdf.php' ?>
<?php include '../classes/warehouse.php' ?>
<?php 
$warehouse = new warehouse();
$total = 0;
if(isset($_GET['from'])){
    $from = $_GET['from'];
    $to = $_GET['to'];
}
$pdf = new FPDF();

$pdf->AddPage();
$pdf->SetFont("Arial","",12);
$pdf->Cell(190,10,"Report Entry Form",1,1,'C');

$listProduct = $warehouse->show_warehouse1($from,$to);
if ($listProduct) {
    $i=0;
    $pdf->Cell(10,10,"STT",1,0);
    $pdf->Cell(65,10,"Name",1,0);
    $pdf->Cell(40,10,"Price",1,0);
    $pdf->Cell(30,10,"Qty",1,0);
    $pdf->Cell(45,10,"sum",1,0);
    $pdf->Ln(10);//Line break

    while ($result = $listProduct->fetch_assoc()) {
        $i++;
        $pdf->Cell(10,10,$i,1,0);
        $pdf->Cell(65,10,$result['productName'],1,0);
        $pdf->Cell(40,10,number_format($result['priceOld']),1,0);
        $pdf->Cell(30,10,$result['qty'],1,0);
        $pdf->Cell(45,10,number_format($result['qty'] * $result['priceOld']),1,0);
        $pdf->Ln(10);//Line break
        $total += ($result['qty'] * $result['priceOld']);
    }
    $pdf->Ln(2);//Line break
    $pdf->Line(10, 30, 200, 30);
    $pdf->Cell(160, 5, 'Total : ', 0, 0,'R');
    $pdf->Cell(30, 5, $total, 0, 1, 'L');
}


$name = "pdf/report_".$from."_".$to.".PDF";


$pdf->Output('F', $name);
echo "<script>window.location = './oderlist.php'</script>"
?>