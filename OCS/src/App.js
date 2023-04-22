import './App.css';


import LoginPage from './LoginPage';
import { Route } from 'react-router-dom';
import AddDoctor from './AddDoctor';
import ViewDoctor from './ViewDoctor';

import ModifyDocotor from './ModifyDoctor';
import DeleteDoctor from './DeleteDoctor';
import Reporter from './Reporter';
import RegisterProfile from './RegisterProfile';

import { Routes } from 'react-router-dom';



function App() {
  return (
    <div className="App">   
    {/* <RegisterProfile/> */}
      {/* <LoginPage/> */}
      {/* <AddDoctor/> */}
      {/* <ModifyDocotor/> */}
      {/* <DeleteDoctor/> */}
      {/* <ViewDoctor/> */}
      {/* <ReporterPage/> */}
      {
  <Routes>
    <Route path='/' element= {<LoginPage/>}/>
    <Route path="/AddDoctor" element={<AddDoctor/>} /> 
    <Route path='/ViewDoctor' element={<ViewDoctor/>}/>
    <Route path="/modifyDoctor" element={<ModifyDocotor/>} /> 
    <Route path='/DeleteDoctor' element={<DeleteDoctor/>}/>
    <Route path='/Reporter' element={<Reporter/>}/>
    <Route path='/RegisterProfile' element={<RegisterProfile/>}/>
    
    


  </Routes>
  
}
    </div>
  );
}

export default App;