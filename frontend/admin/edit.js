function editUser(id){
    window.location.href = "editform.html?id=" + id;
}

const parameter = new URLSearchParams(window.location.search);
const id = parameter.get("id");

console.log(id);

if(id){

fetch("http://localhost:8080/users/userbyid/" + id)
.then(res => res.json())
.then(data => {

 document.getElementById("name").value = data.name;
 document.getElementById("email").value = data.email;

});

}

document.getElementById("editform").addEventListener("submit", function(e){
    e.preventDefault(); // prevents page reload
    updateuser();
});

function updateuser(){

  const userss = {
    name: document.getElementById("name").value,
    email: document.getElementById("email").value
  };

  fetch("http://localhost:8080/users/updateuser/" + id,{
    method: "PUT",
    headers:{
      "Content-Type":"application/json"
    },
    body: JSON.stringify(userss)
  })
  .then(() => {
      alert("Data updated successfully");
      window.location.href="index.html";
  })
  .catch(error => {
      console.error("Error:", error);
  });

}