let items = document.querySelectorAll('.item');
console.log(items);

let item_b_1 = document.querySelectorAll('.item-back-1');
let item_b_2 = document.querySelectorAll('.item-back-2');

for(let i = 0; i < items.length; i++){
    items[i].addEventListener("mouseover", function(){
        item_b_1[i].classList.add("item-back-1-h");
        item_b_2[i].classList.add("item-back-2-h");
        items[i].style.zIndex = "2000";
    });
    items[i].addEventListener("mouseout", function(){
        item_b_1[i].classList.remove("item-back-1-h");
        item_b_2[i].classList.remove("item-back-2-h");
        items[i].style.zIndex = "1000";
    });
}

