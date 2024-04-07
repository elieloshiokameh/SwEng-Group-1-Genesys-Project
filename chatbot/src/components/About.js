import React from 'react'
import Navbar from './Navbar'
import BannerBackground from "../Assets/home-banner-background.png";
import { FiArrowRight } from "react-icons/fi";


const About = () => {
  return (
    <div classname="home-container">
      <Navbar/>
      <div className="home-banner-container">
         <div className="home-bannerImage-container">
           <img src={BannerBackground} alt="" />
         </div>
         <div className="home-text-section">
           <h1 className="primary-heading">
            Hello ! We are Group 1 of Software Engineering Project 2024
           </h1>
             <p className="primary-text">
             We are working with Genesys to create a Virtual Assistant Chatbot 
             </p>
             <p className="primary-text">
             Our bot will help students of Trinity College Dublin avail and explore discounts, deals and offers that in different categories a student might need support in. 
             </p>
             <p className="primary-text">
             These include technology, restaurants, stationery etc. Our bot currently lets students choose the category they want to find discounts in and displays the link to the code
             </p>
           
         </div>
         
       </div>
    </div>
  );

}

export default About