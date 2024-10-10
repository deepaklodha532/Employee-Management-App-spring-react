
import './App.css'
import EmployeeComponent from './components/EmployeeComponent'
import HeaderComponent from './components/HeaderComponent'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import { BrowserRouter, Routes,Route } from 'react-router-dom'
import { ToastContainer } from 'react-toastify';
import "react-toastify/dist/ReactToastify.css";
import 'bootstrap/dist/css/bootstrap.min.css';
import FooterComponent from './components/FooterComponent'



function App() {

  return (
    <>
     <BrowserRouter>
       <HeaderComponent/>
        <ToastContainer  
               
              />
        <Routes>
            <Route  path="/" element={<ListEmployeeComponent/>} />
            <Route  path="/employees" element={<ListEmployeeComponent/>} />
            {/* <Route   /> */}
            <Route  path="/add-employee" element={<EmployeeComponent/>} />
            <Route  path="/update-employee/:id" element={<EmployeeComponent/>} />


        </Routes>
      

     </BrowserRouter>
    </>
  )
}

export default App
