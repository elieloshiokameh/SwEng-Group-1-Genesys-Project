import React from 'react';
import { Helmet } from 'react-helmet';
import Navbar from './Navbar';

const Discounts = () => {
  return (
    <div className="home-container">
      <Helmet>
        <script src="https://apps.mypurecloud.ie/genesys-bootstrap/genesys.min.js" type="text/javascript" />
        <script type="text/javascript">
          {`
            window.Genesys = window.Genesys || function () {
              (window.Genesys.q = window.Genesys.q || []).push(arguments);
            };
            window.Genesys.t = 1 * new Date();
            window.Genesys.c = {
              environment: 'prod-euw1',
              deploymentId: 'e0f29402-6636-4e90-98e1-a1c15e5d6663'
            };
          `}
        </script>
      </Helmet>
      <Navbar />
      {/* Your JSX content here */}
    </div>
  );
};

export default Discounts;
