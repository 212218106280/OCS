import React, { useState } from "react";
import "./DeleteDoctor.css";
import axios from "axios";
function DeleteDoctor() {
  const [doctorID, setDoctorId] = useState("");

    
    const handleDelete=(e)=>{
        e.preventDefault();
              axios.delete(`http://localhost:8555/admin/deleteDoctor/`+doctorID).then(res=>alert("Data is Deleted"))
        console.log('Doctor Deleted successfully...'+doctorID)
    }
  

  return (
    <div className="img4">
    <div className="sundar">
    <div className="delete-doctor-container">
      <h2>DeleteDoctor</h2>
      <label>
        Enter Doctor ID:
        <input
          type="text"
          value={doctorID}
          onChange={(e) => setDoctorId(e.target.value)}
        />
      </label>
      <button onClick={handleDelete}>Delete</button>
    </div>
    </div>
    </div>
  );
}

export default DeleteDoctor;