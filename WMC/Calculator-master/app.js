const display = document.querySelector(".display")
const tasten = document.querySelectorAll("button")
const symbole = ["%", "*", "/", "-", "+", "="]
let output = ""

const calculate = (btnValue) => {
   display.focus();
   if (btnValue === "=" && output !== "") {
     //Prozentrechner
     output = eval(output.replace("%", "/100"))
   } else if (btnValue === "AC") {
     output = "";
   } else if (btnValue === "DEL") {
     
     output = output.toString().slice(0, -1)
   } else {
     
     if (output === "" && symbole.includes(btnValue)) return
     output += btnValue
   }
   display.value = output
 }


tasten.forEach((button) => {
    button.addEventListener("click", (e) => calculate(e.target.dataset.value));
})

