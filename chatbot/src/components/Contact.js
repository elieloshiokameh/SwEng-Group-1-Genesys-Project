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
import Jack from '../Assets/jack.png';
import Brian from '../Assets/brian.png';
import BannerBackground from "../Assets/home-banner-background.png";
import BannerImage from "../Assets/discount-code.png";
import { FiArrowRight } from "react-icons/fi";
import './Contact.css'; // Import your CSS file for styling

const Contact = () => {
  const email1 = 'varmas@tcd.ie';
  const email2 = 'oshiokae@tcd.ie';
  const email3 = 'pivecd@tcd.ie';
  const email4 = 'giurgiua@tcd.ie';
  const email5 = 'manitarg@tcd.ie';
  const email6 = 'olowookd@tcd.ie';
  const email7 = 'murphe83@tcd.ie';
  const email8 = 'kearnej8@tcd.ie';
  const email9 = 'acunnae@tcd.ie';
  const email10 = 'farrelb8@tcd.ie';


  return (
    <div className="home-container">
      <Navbar />
      <div className="home-banner-container">
        <div className="home-bannerImage-container">
          <img src={BannerBackground} alt="" />
        </div>
      
        <div className="contact-photos">
          {/* Display contact photos */}
          <div className="contact-item">
            <img src={Shaurya} alt="" />
            <p>Shaurya Varma</p>
            <p>3rd Year, Team Lead</p>
            <a href={`mailto:${email1}`}>Contact via Email</a>
          </div>
          <div className="contact-item">
            <img src={Eliel} alt="" />
            <p>Eliel Oshiokameh</p>
            <p>3rd Year, GitHub Manager</p>
            <a href={`mailto:${email2}`}>Contact via Email</a>
          </div>
          <div className="contact-item">
            <img src={Dana} alt="" />
            <p>Dana Pivec</p>
            <p>2nd Year, Bot Team Co-Leader</p>
            <a href={`mailto:${email3}`}>Contact via Email</a>
          </div>
          <div className="contact-item">
            <img src={Adriana} alt="" />
            <p>Adriana Giurgiu</p>
            <p>2nd Year, Bot Team Co-Leader</p>
            <a href={`mailto:${email4}`}>Contact via Email</a>
          </div>
          <div className="contact-item">
            <img src={Greg} alt="" />
            <p>Grigoris Manitaras</p>
            <p>2nd Year, Backend Leader</p>
            <a href={`mailto:${email5}`}>Contact via Email</a>
          </div>
          <div className="contact-item">
            <img src={David} alt="" />
            <p>David Olowookere</p>
            <p>2nd Year, Scrum Master</p>
            <a href={`mailto:${email6}`}>Contact via Email</a>
          </div>
          <div className="contact-item">
            <img src={Eoghan} alt="" />
            <p>Eoghan Murphy</p>
            <p>2nd Year, Backend Team</p>
            <a href={`mailto:${email7}`}>Contact via Email</a>
          </div>
          <div className="contact-item">
            <img src={Jack} alt="" />
            <p>Jack Kearney</p>
            <p>3rd Year, Fronend Lead</p>
            <a href={`mailto:${email8}`}>Contact via Email</a>
          </div>
          <div className="contact-item">
            <img src={Adam} alt="" />
            <p>Adam Cunnane</p>
            <p>2nd Year, Fronend Team</p>
            <a href={`mailto:${email9}`}>Contact via Email</a>
          </div>
          
          <div className="contact-item">
            <img src={Brian} alt="" />
            <p>Brian Farrell</p>
            <p>2nd Year, Backend Team</p>
            <a href={`mailto:${email10 }`}>Contact via Email</a>
          </div>
         
        </div>
      </div>
    </div>
  );
}

export default Contact;
