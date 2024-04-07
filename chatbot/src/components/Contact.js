import React from 'react'
import Navbar from './Navbar'
import Shaurya from '../Assets/shaurya.png'
import Adriana from  '../Assets/adriana.png'
import Dana from '../Assets/dana.png'
import Greg from '../Assets/greg.png'
import Eliel from '../Assets/eliel.png'
import David from '../Assets/david.png'
import Eoghan from '../Assets/eoghan.png'
import Adam from '../Assets/adam.png'
import BannerBackground from "../Assets/home-banner-background.png";
import BannerImage from "../Assets/discount-code.png";
import { FiArrowRight } from "react-icons/fi";


const Contact = () => {
  return (
    <div classname="home-container">
      <Navbar/>
      <div className="home-banner-container">
         <div className="home-bannerImage-container">
           <img src={BannerBackground} alt="" />
         </div>
         <div className="home-text-section">
          
            
         </div>
         <div >
           <img src={Shaurya} alt="" style={{ width: '170px', height: '170px' }} />
           <img src={Eliel} alt="" style={{ width: '170px', height: '170px' }}/>
           <img src={Dana} alt="" style={{ width: '170px', height: '170px' }} />
           <img src={Adriana} alt="" style={{ width: '170px', height: '170px' }}/>
           <img src={Greg} alt="" style={{ width: '170px', height: '170px' }}/>
           <img src={David} alt="" style={{ width: '170px', height: '170px' }}/>
           <img src={Eoghan} alt="" style={{ width: '170px', height: '170px' }} />
          <img src={Adam} alt="" style={{ width: '170px', height: '170px' }} />
         </div>
       </div>
    </div>
  );

}

export default Contact