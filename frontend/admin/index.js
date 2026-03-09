async function allusers() {
    

    const response=await fetch("http://localhost:8080/users")
    const data=await response.json();

    const container=document.getElementById("div2");
    container.innerHTML="";

    data.forEach((user) => {
         container.innerHTML+=
         `
         <div class="card">
         <p> name = ${user.name} </p>
         <p> email = ${user.email} </p>
        
         <div class="buttonss">
           <button onclick="deleteUser('${user.id}')">Delete</button>
           <button onclick="editUser('${user.id}')">Edit</button>
           </div>
         
         </div>

         `

        
    });

    
}

 function add(){
            window.location.href="addform.html"
        }

function menu(){
  window.location.href="index.html"
}

async function deleteUser(id) {

  console.log(id)
  const response=await fetch(`http://localhost:8080/users/${id}`,{
    method:"DELETE"
  });
  if(response.ok){
   location.reload();
  }

 

  
}
allusers();


document.getElementById("userform").addEventListener("submit",async function(e) {

  e.preventDefault();

  const name=document.getElementById("name").value;
  const email=document.getElementById("email").value;

const user={
  "name":name,
  "email":email
}

  const response=await fetch("http://localhost:8080/users",{
    method:"POST",
    headers:{
      "Content-Type":"application/json"
    },
    body:JSON.stringify(user)
  });


  if(response.ok){
    alert("user "+name +"added successfully")
            document.getElementById("userform").reset();    

   
    
  }


})




