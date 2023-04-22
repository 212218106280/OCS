import React, { useState } from "react";
import "./RegisterProfile.css"
import axios from 'axios'
const RegisterProfile = () => {
  const [userID, setuserID] = useState();
  const [firstName, setfirstName] = useState('');
  const [lastName, setlastName] = useState('');
  const [dateofBrith, setDateofBrith] = useState('');
  const [gender, setGender] = useState('');
  const [street, setStreet] = useState('');
  const [location, setLocation] = useState('');
  const [city, setCity] = useState('');
  const [pincode, setPincode] = useState('');
  const [mobileNo, setmobileNo] = useState('');
  const [emailID, setEmailID] = useState('');
  const [state,setState]=useState('')
    
 
  const handleSubmit=(e)=>{
       e.preventDefault();
      console.log(userID+""+firstName+" "+ lastName+" "+dateofBrith+" "+gender+street+""+location+""+city+""+state+""+pincode+""+mobileNo+""+emailID);
      const obj={userID:userID,firstName:firstName,lastName:lastName,dateofBrith:dateofBrith,gender:gender,street:street,location:location,city:city,state:state,pincode:pincode,mobileNo:mobileNo,emailID:emailID}
     console.log(obj)
      axios.post('http://localhost:8555/profile/addProfile',obj).then(
          alert('Profile added successfully')
      ).catch((e)=>console.log(e))
  } 
  return (
    <div className="img5">
    <div classid="ss">
    <div className="add-doctor">
      <h1>RegisterProfile </h1>
      <br></br>

      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="userID">UserID:</label>
          <input
            type="text"
            name="userID"
            value={userID}
            onChange={(e)=>{setuserID(e.target.value)}}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="firstName">FirstName:</label>
          <input
            type="text"
            name="firstName"
            value={firstName}
            onChange={(e)=>{setfirstName(e.target.value)}}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="lastName">lastName:</label>
          <input
            type="text"
            name="lastName"
            value={lastName}
            onChange={(e)=>{setlastName(e.target.value)}}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="dateofBrith">Date of Brith:</label>
          <input
            type="text"
            name="dateofBrith"
            value={dateofBrith}
            onChange={(e)=>{setDateofBrith(e.target.value)}}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="gender">Gender:</label>
          <select
            name="gender"
            value={gender}
            onChange={(e)=>{setGender(e.target.value)}}
            required
          >
            <option value="">--Select Gender--</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
          </select>
        </div>
        <div className="form-group">
          <label htmlFor="street">Street:</label>
          <input
            type="text"
            name="street"
            value={street}
            onChange={(e)=>{setStreet(e.target.value)}}
            requried
           />
           </div>
          <div className="form-group">
          <label htmlFor="location">location:</label>
          <input
            type="text"
            name="location"
            value={location}
            onChange={(e)=>{setLocation(e.target.value)}}
            requried
           />
           </div>

           <div className="form-group">
          <label htmlFor="city">city:</label>
          <input
            type="text"
            name="city"
            value={city}
            onChange={(e)=>{setCity(e.target.value)}}
            requried
           />
           </div>

           <div className="form-group">
          <label htmlFor="city">State</label>
          <input
            type="text"
            name="state"
            value={state}
            onChange={(e)=>{setState(e.target.value)}}
            requried
           />
           </div>

           

           <div className="form-group">
          <label htmlFor="pincode">PinCode:</label>
          <input
            type="number"
            name="pincode"
            value={pincode}
            onChange={(e)=>{setPincode(e.target.value)}}
            requried
           />
           </div>

           <div className="form-group">
          <label htmlFor="contactNumber">MobileNo:</label>
          <input
            type="number"
            name="mobileNo"
            value={mobileNo}
            onChange={(e)=>{setmobileNo(e.target.value)}}
            requried
           />
           </div>

           <div className="form-group">
          <label htmlFor="email">Email:</label>
          <input
            type="text"
            name="emailID"
            value={emailID}
            onChange={(e)=>{setEmailID(e.target.value)}}
          
            requried
           />
           </div>
         <div>
           <button type="submit">Submit</button>
           </div>
           
           </form>
           </div>
           </div>
           </div>
  )};

export default RegisterProfile;