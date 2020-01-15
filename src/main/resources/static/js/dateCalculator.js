
function calculateDate() {

    dailyFee = parseFloat(document.getElementById("vehicleDailyFee").innerHTML);

    recipeDate = new Date(document.getElementById("recipeDate").value + "Z");
    returnDate = new Date(document.getElementById("returnDate").value + "Z");

    var Difference_In_Time = returnDate.getTime() - recipeDate.getTime();
    var Difference_In_Days = Difference_In_Time / (1000 * 3600 * 24);

    // var totalCost = Difference_In_Days *
    //
    // document.getElementById("sr").innerHTML="+Difference_In_Days+";
    // document.write("Total number of days between dates" + Difference_In_Days);


    document.getElementById("totalCost").value = Math.floor(Difference_In_Days) * dailyFee;
}


