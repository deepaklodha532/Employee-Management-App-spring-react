import React from 'react'
import FooterComponent from './FooterComponent'
import { NavLink } from 'react-router-dom'
import { Container } from 'react-bootstrap'

function HeaderComponent() {

  let styleLogo  = {
    backgroundColor:"White",
  
  }
  return (
    <div>
      <header className="navbar navbar-dark bg-dark">
           <nav> 
               <Container>
                <img  src="https://static.thenounproject.com/png/78950-200.png" alt="emp" width="20px" className="bg-white me-2 " />
                <NavLink to="/" className="text-decoration-none text-white " >Empployee Management</NavLink>

               </Container>
           </nav>
      </header>
      <FooterComponent/>
    </div>
  )
}

export default HeaderComponent