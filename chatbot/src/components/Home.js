import React from 'react'
import Navbar from './Navbar'
import BannerBackground from "../Assets/home-banner-background.png";
import BannerImage from "../Assets/discount-code.png";
import { FiArrowRight } from "react-icons/fi";

const Home = () => {
 return (
     <div className="home-container">
       <Navbar />
       <div className="home-banner-container">
         <div className="home-bannerImage-container">
           <img src={BannerBackground} alt="" />
         </div>
         <div className="home-text-section">
           <h1 className="primary-heading">
             Access your favorite student discounts!
           </h1>
             <p className="primary-text">
             Find discounts for food, entertainment, sports, nightlife and  many more!
             </p>
           <button className="secondary-button">
             Apply discounts now <FiArrowRight />{" "}
           </button>
         </div>
         <div className="home-image-section">
           <img src={BannerImage} alt="" />
         </div>
       </div>
     </div>
   );

}

export default Home