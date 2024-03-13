import React from 'react';
import { Link } from 'react-router-dom'; // assuming you are using react-router for navigation

const Navbar = () => {
  return (
    <nav className="navbar">
      {/* logo or brand name */}
      <div className="navbar-brand">
        <Link to="/" classname="navbar-logo">DiscountBot
        Jack
        </Link >
      </div>

      {/* navigation links */}
      <div className="navbar-menu">
        <Link to="/about">About</Link>
        <Link to="/services">Services</Link>
        <Link to="/contact">Contact</Link>
        {/* Add additional links or components here */}
      </div>
    </nav>
  );
};

export default Navbar;
