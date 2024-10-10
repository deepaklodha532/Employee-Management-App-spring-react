import React from 'react'
import { Card, CardFooter, Container } from 'react-bootstrap'

function FooterComponent() {
  return (
   <Container fluid className='bg-dark ' style={{
            position: "fixed",
            left: "0",
            right: "0",
            background: "rgba(0, 0, 0, 0.5)",
            padding: "10px",
            bottom: "0",
            width: "100%",
            height:"50px",
            color:"white"

  }}  
   >

          <p className='text-center'><span>deepaklodha532@gmail.com</span> <span className='ms-3'></span> </p>
    
   </Container>
  )
}

export default FooterComponent