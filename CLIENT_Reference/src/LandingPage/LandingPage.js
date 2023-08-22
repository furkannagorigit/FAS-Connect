import React from 'react';
import { useHistory } from 'react-router-dom/cjs/react-router-dom.min';

const LandingPage = () => {
  const history = useHistory();
  return (
    <div>
      {/* Navbar */}
      <nav className="navbar navbar-default" style={{ backgroundColor: '#e6e6fa' }}>
        <div className="container-fluid">
          <div className="navbar-header">
            <button
              type="button"
              className="navbar-toggle collapsed"
              data-toggle="collapse"
              data-target="#navbar-collapse"
              aria-expanded="false"
              style={{ border: 'none', backgroundColor: '#e6e6fa' }}
            >
              <span className="sr-only">Toggle navigation</span>
              <span className="icon-bar" style={{ backgroundColor: '#9370db' }}></span>
              <span className="icon-bar" style={{ backgroundColor: '#9370db' }}></span>
              <span className="icon-bar" style={{ backgroundColor: '#9370db' }}></span>
            </button>
            <a className="navbar-brand" href="#" style={{ color: '#9370db' }}>
              <img src="./data/images/Logo.png" class="img-responsive" alt="Image"
                style={{ height: "40px", marginTop: "-6%", mixBlendMode: "multiply" }} />
            </a>
          </div>
          <div className="collapse navbar-collapse" id="navbar-collapse">
            <ul className="nav navbar-nav navbar-right">
              <li><a href="#" style={{ color: '#9370db' }}>Home</a></li>
              <li><a href="#" style={{ color: '#9370db' }}>About us</a></li>
              <li><a href="#" style={{ color: '#9370db' }}>Contact us</a></li>
              <li><button className="btn btn-primary navbar-btn" style={{ backgroundColor: "#9370db" }}
                onClick={() => { history.push("/LoginSignup") }}>Sign In</button></li>
            </ul>
          </div>
        </div>
      </nav>

      {/* Main content */}
      <center>
      <div class="content">
          <div class="container">
            <div class="info">
              <h1>Welcome to FAS Connect: Your Gateway to Meaningful Connections!</h1>
              <p>We see you've stumbled upon our platform.</p>
            </div>
            <div class="image">
              <img src="https://i.postimg.cc/65QxYYzh/001234.png"/>
            </div>
          </div>
        </div>
      </center>


      {/* Footer */}
      <footer className="footer" style={{ backgroundColor: 'black', color: 'white' }}>
        <div className="container-fluid">
          <div className="row">
            <div className="col-md-4">
              <img
                src="./data/images/Logo_Dark.png"
                alt="Logo"
              />
            </div>
            <div className="col-md-4">
                About Us
              <ul className="list-unstyled">
              </ul>
            </div>
            <div className="col-md-4">
                Contact Us
              <ul className="list-unstyled">
              <li>
                  <a href="#" style={{color:'grey'}}>contact@fasconnect.com</a>
                </li>
                <li>
                  <a href="#" style={{color:'grey'}}>+91-0000000000</a>
                </li>
              </ul>
            </div>
            <div className="col-md-4">
                Policies
              <ul className="list-unstyled">
              <li>
                  <a href="#" style={{color:'grey'}}>Privacy Statement</a>
                </li>
                <li>
                  <a href="#" style={{color:'grey'}}>Terms of use</a>
                </li>
              </ul>
            </div>
            <div className="col-md-4">
                FAQs
            </div>
          </div>
        </div>
        <center>
              <p>© 2023 FAS Connect. All rights reserved.</p>
        </center>
      </footer>

      {/* CSS */}
      <style>
        {`
        html,
        body {
          height: 100%;
          margin: 0;
          padding: 0;
        }
        #root {
          display: flex;
          flex-direction: column;
          min-height: 100vh;
        }
        .footer {
          margin-top: auto;
          padding-top: 10px;
          padding-bottom: 10px;
        }
        `}
      </style>

    </div>
  );
};

export default LandingPage;