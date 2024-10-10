import React, { useEffect, useState } from 'react'
import { createEmployee, getEmployee, updateEmployee } from '../services/EmployeeService';
import { toast } from 'react-toastify';
import { useNavigate, useParams} from 'react-router-dom';

function EmployeeComponent() {
    // const [firstName , setFirstName]= useState('');
    // const [lastName , setLastName] = useState('') ; 
    // const [email, setEmail] = useState('') ;
    
    const {id} =  useParams();

    const [employee , setEmployee] =useState({
        firstName:"",
        lastName:"" ,
        email:""
    })

    const handleChange  = (e)=>{
        setEmployee(
            {
                ...employee, 
                [e.target.name]: e.target.value
            }
        )
    }

    

    // const handleFirstName = (e) => {
    //     setFirstName(e.target.value)
    // }

    // const handleLastName = (e) => {
    //     setLastName(e.target.value)
    // }

    // const handleEmail = (e) => {
    //     setEmail(e.target.value)
    // }

    const navigator = useNavigate() ; 

    useEffect(()=>{
        if(id){
           
            console.log(id)
            getEmployee(id).then((response)=>{
                setEmployee(response.data)
                // console.log('response: ', response.data);
            }).catch((error)=>{
                toast.error("Employee not found")
                console.error(error);
            }
            )
        }
    },[id])
    const saveEmployee = (e) => {
        e.preventDefault();

        if(employee.firstName===undefined || employee.firstName.trim()==''){
            toast.info("First Name is required")
            return ; 
        }

        if(employee.lastName===undefined || employee.lastName.trim()==''){
            toast.info("Last Name is required")
            return ;
        }

        if(employee.email===undefined || employee.email.trim()==''){
            toast.info("email  is required")
            return ; 
        }

        //  const employee= [firstName, lastName , email]
        console.log('Employee Details: ', employee)
       if(id){

        updateEmployee(id , employee).then((response)=>{
            toast.info(id+" : id Employee update") ; 
            navigator("/employees")

        }).catch((error)=>{
            toast.error("Error , updating employee")
            console.error(error) ;
        })
       }
       else{
        createEmployee(employee).then((response)=>{
            toast.success("successfully  added employee")
            console.log('response: ', response.data);
            navigator("/employees")
        })
        .catch((error)=>{
            toast.error("This employee already  have")
            console.log("error:" ,error) ; 
        })
       }
     
    }

    function pageTitle(){
       if(id){
        return <h2 className='text-center'>Update Employee</h2>

       }
       else{
        return <h2 className='text-center'>Add Employee</h2>
       }
    }
  return (


    <div className='container'>
        <div className='row'>
            <div className='mt-3 card col-md-6 offset-md-3 shadow'>
                 {
                    pageTitle() 
                 }
                <div className='card-body'>
                <form action="">
                     
                     <div className='form-group mb-2'>
                        <label className="form-label"> First Name: </label>
                        <input 
                        type="text"
                        placeholder='Enter First Employee Name '
                        name='firstName'
                        className='form-control'
                        value={employee.firstName}
                        onChange={handleChange}
                         />
                     </div>

                        
                     <div className='form-group mb-2'>
                        <label className="form-label"> Last Name: </label>
                        <input 
                        type="text"
                        placeholder='Enter Last Employee Name '
                        name='lastName'
                        className='form-control'
                        value={employee.lastName}
                        onChange={handleChange}
                         />
                     </div>

                        
                     <div className='form-group mb-2'>
                        <label className="form-label"> Email : </label>
                        <input 
                        type="email"
                        placeholder='Enter  Employee Email '
                        name='email'
                        className='form-control'
                        value={employee.email}
                        onChange={handleChange}
                         />
                     </div>

                     <button type="submit" className="my-3 btn btn-primary" onClick={saveEmployee} >submit</button>

                </form>
              </div>

            </div>
        </div>
    </div>
  )
}

export default EmployeeComponent