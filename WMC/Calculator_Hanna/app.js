const display = document.querySelector(".display")
const tasten = document.querySelectorAll("button")
const symbole = ["%", "*", "/", "-", "+", "="]
let output = ""

// operators / funktion 

const calculate = (btnValue) => {
   display.focus();
   if (btnValue === "=" && output !== "") {
     //wenn der output ein '%' hat, ersetzen wir es mit '/100' vor dem bewerten.
     output = eval(output.replace("%", "/100"))
   } else if (btnValue === "AC") {
     output = "";
   } else if (btnValue === "DEL") {
     //wenn die DEL taste gedrückt  wird, entfernen wir den letzen character von dem output.
     output = output.toString().slice(0, -1)
   } else {
     //wenn der output lehr ist und die taste ist ein symbol dann return
     if (output === "" && symbole.includes(btnValue)) return
     output += btnValue
   }
   display.value = output
 }

// Event Listener 
tasten.forEach((button) => {
    // Click Event Listener rechnet mit den dataset value als argument
    button.addEventListener("click", (e) => calculate(e.target.dataset.value));
})

