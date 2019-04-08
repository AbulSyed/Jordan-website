var price = {
    price: 165
}



function updatePrice(){
    var multiplier = document.getElementById("multiplier").value;
    for(var key in price){
        document.getElementById(key).innerHTML = (price[key]*multiplier);
    }
}



function press() {
    alert("Your purchase is complete");
}
