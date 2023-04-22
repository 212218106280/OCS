import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import React, { }  from 'react';
import { CSSTransition } from 'react-transition-group';
import "./Loginpage.css"
function LoginPage({ history }) {
  const [Type, setType] = useState('');
  const[cid,setUsername]=useState('');
  const[password,setPassword]=useState('');

  let cb={};
  const[error,setError]=useState("");
  const navigate  = useNavigate();
  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.get(`http://localhost:8555/admin/selectUser/${cid}/${password}`); 
      if (response.status === 200) {
        switch (Type) {
          case 'admin':
            if (cid === 'AD001' && password === 'AD001') {
              navigate('/AddDoctor');
            } else if (cid === 'AD002' && password === 'AD002') {
              navigate('/ViewDoctor');
            } else if (cid === 'AD003' && password === 'AD003') {
              navigate('/ModifyDoctor');
            } 
            else if (cid === 'AD004' && password === 'AD004') {
              navigate('/deleteDoctor');
            } 
            else {
              alert('Incorrect username or password');
            }
            break;
          case 'reporter':
            if (cid === 'RE01' && password === 'RE01') {
              navigate('/reporter');
            } else {
              alert('Incorrect username or password');
            }
            break;
          case 'patient':
            if (cid === 'RE02' && password === 'RE02') {
              navigate('/RegisterProfile');
            } else {
              alert('Incorrect username or password');
            }
            break;
          default:
            alert('Please select a user type');
        }
      } else {
        alert('Authentication failed');
      }
    } catch (error) {
      console.error(error);
      setError('Authentication failed');
    }
  };
  return (
    <>
    <header>
      <h1 className='os'>Online Clinic System</h1>
    </header>
    <div className="login-page">
    <div className="login-f-container">
      <form onSubmit={handleSubmit}>
        <div className="vehicle-type-container">
          <div>
            <input type="radio" id="bus" name="Type" value="admin" checked={Type === 'admin'} onChange={() => setType('admin')} />
            <label>Admin</label>
          </div>
          <div>
            <input type="radio" id="patient" name="Type" value="patient" checked={Type === 'patient'} onChange={() => setType('patient')} />
            <label htmlFor="patient">patient</label>
          </div>
          <div>
            <input type="radio" id="reporter" name="Type" value="reporter" checked={Type === 'reporter'} onChange={() => setType('reporter')} />
            <label htmlFor="repoter">Reporter</label>
          </div>
        </div>
        <CSSTransition classNames="input-container" timeout={500}>
          <div className="input-container">
            <label htmlFor="username">Username:</label>
            <input type="text" id="username" name="username" value={cid} onChange={(event) => setUsername(event.target.value)} />
          </div>
        </CSSTransition>
        <br></br>
        <CSSTransition classNames="input-container" timeout={900}>
          <div className="input-container">
            <label htmlFor="password">Password:</label>
            <input type="password" id="password" name="password" value={password} onChange={(event) => setPassword(event.target.value)} />
          </div>
        </CSSTransition>
        <br></br>
        <button className="login-button" type="submit">Login</button>
        <br/>
        <button className="login-button" type="button" onClick={() => window.location.href='/register'}>New Registration</button>
      </form>
    </div>
  </div>
  </>
  );}
 export default LoginPage;