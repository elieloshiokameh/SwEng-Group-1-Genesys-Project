import React from 'react';
import Navbar from './Navbar';
import Shaurya from '../Assets/shaurya.png';
import Adriana from '../Assets/adriana.png';
import Dana from '../Assets/dana.png';
import Greg from '../Assets/greg.png';
import Eliel from '../Assets/eliel.png';
import David from '../Assets/david.png';
import Eoghan from '../Assets/eoghan.png';
import Adam from '../Assets/adam.png';
import BannerBackground from "../Assets/home-banner-background.png";
import BannerImage from "../Assets/discount-code.png";
import { FiArrowRight } from "react-icons/fi";
import './Contact.css'; // Import your CSS file for styling

const Contact = () => {
  return (
    <div className="home-container">
      <Navbar />
      <div className="home-banner-container">
        <div className="home-bannerImage-container">
          <img src={BannerBackground} alt="" />
        </div>
      
        <div className="contact-photos">
          {/* Display contact photos */}
          <img src={Shaurya} alt="" />
          <img src={Eliel} alt="" />
          <img src={Dana} alt="" />
          <img src={Adriana} alt="" />
          <img src={Greg} alt="" />
          <img src={David} alt="" />
          <img src={Eoghan} alt="" />
          <img src={Adam} alt="" />
        </div>
      </div>
    </div>
  );
}

export default Contact;
