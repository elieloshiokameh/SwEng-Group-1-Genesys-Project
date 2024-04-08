import React from 'react'
import Navbar from './Navbar'
import BannerImage from "../Assets/discount-code.png";
import { FiArrowRight } from "react-icons/fi";
import BannerBackground from "../Assets/home-banner-background.png"; 
const Discounts = () => {
  return (
    <div className="home-container">
      <Navbar />
      <div className="home-banner-container">
        <div className="home-bannerImage-container">
          <img src={BannerBackground} alt="" />
        </div>

      
    </div>
    </div>
  );

}

export default Discounts