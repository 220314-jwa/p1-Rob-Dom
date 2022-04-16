let loggedInEmployee;
// checkLogin();
let loginButton = document.getElementById("login");
loginButton.addEventListener('click',employeeLogin);

async function employeeLogin(){
    let credentials = {
        username: document.getElementById('username').value,
        password:document.getElementById('password').value,
    };
    console.log(credentials);
    let credentialJSON=JSON.stringify(credentials);
    
    let httpResp = await fetch('http://localhost:5432/employed',
    {method:'POST', body:credentialJSON});
if (httpResp && httpResp.status === 200) {
    loggedInEmployee = await httpResp.json();
    sessionStorage.setItem('Auth-Token', employee.employeeId);
    console.log("Status"+ httpResp.status);
    // await checkLogin();
  
    location.replace('RequestForm.html');
}
}