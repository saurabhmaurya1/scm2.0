console.log("Script loaded");

let currentTheme=getTheme();


document.addEventListener('DOMContentLoaded',()=>{
    changeTheme(currentTheme);
});
// initia--->



// to do function

function changeTheme(currentTheme){

    // set to web page 
    document.querySelector('html').classList.add(currentTheme);

    // set the listner
    const changeThemeButton=document.querySelector("#theme_change_button");

    // change the text of button
    changeThemeButton.querySelector('span').textContent=currentTheme ==="light" ? "Dark":"Light";

    changeThemeButton.addEventListener("click",(event)=>{
        console.log("change theme button clicked");

        const oldTheme = currentTheme;

        if (currentTheme === "dark"){
            currentTheme="light";
        }
        else{
            currentTheme="dark";
        }

        //local storage mein update
        setTheme(currentTheme);

        // remove the current theme 
        document.querySelector('html').classList.remove(oldTheme);

        //set the current theme
        document.querySelector('html').classList.add(currentTheme);

         // change the text of button
    changeThemeButton.querySelector('span').textContent=currentTheme ==="light" ? "Dark":"Light";

    });
    

   
}




// set theme to local storage
function setTheme(theme){
    localStorage.setItem("theme",theme);
}




// get theme for local storage

function getTheme(){
    let theme = localStorage.getItem("theme");
    return theme ? theme:"light";
}
