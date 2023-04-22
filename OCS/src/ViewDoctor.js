import React, {  useState } from 'react'
import "./ViewDoctor.css"
import axios from 'axios';
function ViewDoctor() {
    const [data, setData] = useState([]);

    axios.get('http://localhost:8555/admin/selectAll').then(res=>{
        setData(res.data)
        
    })

    console.log(data)
        
    return (
      <div className='img1'>
      <div>
     
        <div className='c'>
          <div className='s'>
      <table border="4">
        <thead>
          <tr>
            <th>doctorID</th>
            <th>doctorName</th>
            <th>dateOfBirth</th>
            <th>dateOfJoining</th>
            <th> gender</th>
            <th>qualification</th>
            <th>specialization</th>
            <th>yearsOfExperience</th>
            <th>location</th>
            <th>city</th>
            <th>state</th>
            <th>pincode</th>
            <th>contactNumber</th>
            <th>email</th>

          </tr>
        </thead>
        <tbody>
          {data.map(item => (
            <tr key={item.doctorID}>
                <td>{item.doctorID}</td>
              <td>{item.doctorName}</td>
              <td>{item.dateOfBirth}</td>
              <td>{item.dateOfJoining}</td>
              <td>{item.gender}</td>
              <td>{item.qualification}</td>
              <td>{item.specialization}</td>
              <td>{item.yearsOfExperience}</td>
              <td>{item.location}</td>
              <td>{item.city}</td>
              <td>{item.state}</td>
              <td>{item.pincode}</td>
              <td>{item.contactNumber}</td>
              <td>{item.email}</td>
            </tr>
          ))}
        </tbody>

      </table>
      </div>
      </div>
      </div>


      </div>
)}


export default ViewDoctor;