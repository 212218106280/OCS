import React, { useState } from 'react';
import './Reporter.css'; 
import axios from 'axios';

function Reporter() {
  const [leaveID, setLeaveID] = useState('');
  const [reporterID, setReporterID] = useState('');
  const [reporterName, setReporterName] = useState('');
  const [leave_From, setLeaveFrom] = useState('');
  const [leave_To, setLeaveTo] = useState('');
  const [reason, setReason] = useState('');
  const [status, setStatus] = useState('');

  const handleSubmit=(e)=>{
    e.preventDefault();
   console.log( leaveID+"" +reporterID+" "+reporterName+" "+leave_From+""+leave_To+""+reason+""+status);
   const obj={leaveID:leaveID,reporterName:reporterName,leave_From:leave_From,leave_To:leave_To,reason:reason,status:status}
  console.log(obj)
   axios.post('http://localhost:8555/reporter/addReporter',obj).then(
       alert('Reporter added successfully')
   ).catch((e)=>console.log(e))
} 

  return (
  <div className="img7">
    <div className="reporter-page">
      <b><h1>Reporter Page</h1></b>
      <br></br>
      <form onSubmit={handleSubmit}>
        <div className="form-field">
          <label htmlFor="leaveID">Leave ID</label>
          <input type="text" id="leaveID" value={leaveID} onChange={(event) => setLeaveID(event.target.value)} />
        </div>

        <div className="form-field">
          <label htmlFor="reporterID">Reporter ID</label>
          <input type="text" id="reporterID" value={reporterID} onChange={(event) => setReporterID(event.target.value)} />
        </div>

        <div className="form-field">
          <label htmlFor="reporterName">Reporter Name</label>
          <input type="text" id="reporterName" value={reporterName} onChange={(event) => setReporterName(event.target.value)} />
        </div>

        <div className="form-field">
          <label htmlFor="leaveFrom">Leave From</label>
          <input type="date" id="leave_From" value={leave_From} onChange={(event) => setLeaveFrom(event.target.value)} />
        </div>

        <div className="form-field">
          <label htmlFor="leaveTo">Leave To</label>
          <input type="date" id="leave_To" value={leave_To} onChange={(event) => setLeaveTo(event.target.value)} />
        </div>

        <div className="form-field">
          <label htmlFor="reason">Reason</label>
          <textarea id="reason" value={reason} onChange={(event) => setReason(event.target.value)}></textarea>
        </div>

        <div className="form-field">
          <label htmlFor="status">Status</label>
          <input type="text" id="status" value={status} onChange={(event) => setStatus(event.target.value)} />
        </div>

        <button type="submit" style={{height: "50px" ,marginTop:"31px"}}>Submit</button>
      </form>
      {/* <button className="view-all-btn"></button> */}
      <div className="reporter-page 1">

  <br></br>

  <button className="view-all-btn">IntimateAdmin</button>
</div>

    </div>
    </div>
   
  );
}

export default Reporter;