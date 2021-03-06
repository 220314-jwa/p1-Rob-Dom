async function addRequest(reimbursement) {
       
    url = "http://localhost:5432/reimbursement"

    const options = {
      method: 'POST',
      body: JSON.stringify(reimbursement),
      headers: new Headers({
        'Content-Type': 'application/json'
      })
    }

    let httpResponse = await fetch(url, options);
    // The new request is here if I need it
    let body = await httpResponse.json();

    console.log(body);

    if(body != null) {
      
      alert("You have succesfully created a new request");
      window.location.replace("index.html");
     
    } else {
      alert("Sorry. A request could not be created at this time")
      console.log("body is null");
    }
  }