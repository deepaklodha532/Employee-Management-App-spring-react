import React, { useEffect, useState } from 'react'
import { deleteEmployee, listEmployees } from '../services/EmployeeService';
import { useNavigate} from 'react-router-dom';
import { Button } from 'react-bootstrap';
import { toast } from 'react-toastify';

function ListEmployeeComponent() {

  const [employees, setEmployees]=useState([]) ; 
  const [change , setChange] =useState(false) ;
  const navigator = useNavigate() ; 
  useEffect(()=>{
   if(change ==true){
    getAllEmployees(); 
    setChange(!change) ;
   }
  },[change]) ; 

  const getAllEmployees=()=>{
    listEmployees().then((response)=>{
        setEmployees(response.data) ; 
    })
    .catch((error)=>{
        console.error(error)
    })
  }

  useEffect(()=>{
     getAllEmployees() ; 
  }, [])

  


  function addNewEmployee(){
    navigator('/add-employee');
  }


  const updateEmployee=(id)=>{
     navigator(`/update-employee/${id}`);

  }
  


  const removeEmployee=(id)=>{
    //   confirm("are you sure")
      
 
        
        deleteEmployee(id).then((response)=>{
            console.log(response.data) ; 
            setChange(true); 
            toast.success("successfully removed employee")
          }
         ).catch((error)=>{
    
            console.error(error);
            toast.error("employee removing time error")
    
         })

  }

  return (
    <div className='container '>
        <h2 className='text-center'>List of Employees</h2>
        <button type="button" className="my-3 btn btn-primary"  onClick={addNewEmployee}>add employees</button>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>Employee First Name</th>
                    <th>Employee Last Name</th>
                    <th>Employee Email Id</th>
                </tr>
            </thead>
            <tbody>
                {
                    employees.map(employee=>
                           <tr key={employee.id}>
                               <td>{employee.id}</td>
                               <td>{employee.firstName}</td>
                               <td>{employee.lastName}</td>
                               <td>{employee.email}</td>
                               <td>
                               <Button className='btn btn-info m-1' onClick={()=> updateEmployee(employee.id)}>Update</Button>
                               <Button className='btn btn-danger m-1' onClick={()=> removeEmployee(employee.id)}>Remove</Button>
                               </td>
                           </tr>
                     )
                }
            </tbody>
        </table>
        <p className='mb-5'>. </p>
      
    </div>
  )
}

export default ListEmployeeComponent