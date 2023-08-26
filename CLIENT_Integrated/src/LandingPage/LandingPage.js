import React from 'react';
import { useHistory } from 'react-router-dom/cjs/react-router-dom.min';

const LandingPage = () => {
  const history = useHistory();

  const scrollToSection = (id, event) => {
    event.preventDefault();
    const element = document.getElementById(id);
    if (element) {
      element.scrollIntoView({ behavior: 'smooth' });
    }
  };

  return (
    <div>
      {/* Navbar */}
      <nav className="navbar navbar-default" style={{ backgroundColor: '#e6e6fa', position: 'sticky', top: 0, zIndex: 100 }}>
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
              <li><a href="#home" style={{ color: '#9370db' }}>Home</a></li>
              <li><a href="#about" style={{ color: '#9370db' }} onClick={(e) => scrollToSection('about', e)}>About us</a></li>
              <li><a href="#contact" style={{ color: '#9370db' }} onClick={(e) => scrollToSection('contact', e)}>Contact us</a></li>
              <li><button className="btn btn-primary navbar-btn" style={{ backgroundColor: "#9370db" }}
                onClick={() => { history.push("/LoginSignup") }}>Sign In</button></li>
            </ul>
          </div>
        </div>
      </nav>

      {/* Main content */}
      <center>
        {/* Home section */}
        <div id="home" className="content">
          <div className="container">
            <div className="info">
              <h1>Welcome to FAS Connect: Your Gateway to Meaningful Connections!</h1>
              <p>We see you've stumbled upon our platform.</p>
            </div>
            <div className="image">
              <img src="https://i.postimg.cc/65QxYYzh/001234.png" alt="Home" />
            </div>
          </div>
        </div>

        {/* About section */}
        /* About section */
        <div id="about" className="content about-section">
          <div className="container">
            <div className="about-content">
              <h1 className="about-title">Discover FAS-Connect</h1>
              <p className="about-description">
                Join a vibrant academic community that bridges students and faculty. Explore our key features:
              </p>
            </div>

            {/* Feature Points */}
            <div className="feature-points">
              <div className="point">
                <i className="fas fa-comments"></i>
                <h3>Seamless Communication</h3>
                <p>Connect with peers and faculty members effortlessly, fostering meaningful discussions.</p>
              </div>
              <div className="point">
                <i className="fas fa-users"></i>
                <h3>Collaborative Environment</h3>
                <p>Engage in group projects, knowledge exchange, and collaborative learning experiences.</p>
              </div>
              <div className="point">
                <i className="fas fa-lightbulb"></i>
                <h3>Idea Sharing and Exploration</h3>
                <p>Spark creativity and explore new ideas by connecting with a diverse community.</p>
              </div>
            </div>

            {/* Call-to-Action */}
            <div className="cta">
              <h2>Ready to Join?</h2>
              <button className="btn btn-primary">Sign Up Now</button>
            </div>
          </div>
        </div>


        <center>
        {/* Contact section */}
        <div id="contact" className="content contact-section">
  <div className="container">
    <div className="contact-content">
      <h1>Contact Us</h1>
      <p>Feel free to get in touch with us...</p>
    </div>
    <div className="contact-details">
      <div className="contact-detail">
        <i className="fas fa-user"></i>
        
        <div className="contact-info">
          <span className="contact-label">Name:</span>
          <span>Furkan Nagori</span>
        </div>
        <div className="contact-info">
          <span className="contact-label">Email:</span>
          <a href="mailto:FurkanNagori05@example.com">FurkanNagori05@example.com</a>
        </div>
        <div className="contact-info">
          <span className="contact-label">Phone:</span>
          <span>+91-7089777343</span>
        </div>
        <div className="contact-info">
          <span className="contact-label">LinkedIn:</span>
          <a href="https://www.linkedin.com/in/furkan-nagori-39a963194/">LinkedIn Profile</a>
        </div>
        <div className="contact-info">
          <span className="contact-label">GitHub:</span>
          <a href="https://github.com/furkannagorigit">GitHub Profile</a>
        </div>
      </div>
      <div className="contact-detail">
        <i className="fas fa-user"></i>
        <div className="contact-info">
          <span className="contact-label">Name:</span>
          <span>Aditi Agrawal</span>
        </div>
        <div className="contact-info">
          <span className="contact-label">Email:</span>
          <a href="mailto:aditiagrawal10000@gmail.com">aditiagrawal10000@gmail.com</a>
        </div>
        <div className="contact-info">
          <span className="contact-label">Phone:</span>
          <span>+91-9011477866</span>
        </div>
        <div className="contact-info">
          <span className="contact-label">LinkedIn:</span>
          <a href="https://www.linkedin.com/in/aditiagrawal10000/">LinkedIn Profile</a>
        </div>
        <div className="contact-info">
          <span className="contact-label">GitHub:</span>
          <a href="https://github.com/AditiAgrawal1">GitHub Profile</a>
        </div>
      </div>
      <div className="contact-detail">
        <i className="fas fa-user"></i>
        
        <div className="contact-info">
          <span className="contact-label">Name:</span>
          <span>Shadab Shaikh</span>
        </div>
        <div className="contact-info">
          <span className="contact-label">Email:</span>
          <a href="mailto:shadabs9599@gmail.com">shadabs9599@gmail.com</a>
        </div>
        <div className="contact-info">
          <span className="contact-label">Phone:</span>
          <span>+91-9082287736</span>
        </div>
        <div className="contact-info">
          <span className="contact-label">LinkedIn:</span>
          <a href="https://www.linkedin.com/in/shadabslink/">LinkedIn Profile</a>
        </div>
        <div className="contact-info">
          <span className="contact-label">GitHub:</span>
          <a href="https://github.com/Shadabsgit">GitHub Profile</a>
        </div>
      </div>
      
    </div>
  </div>
</div>
</center>



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
                  <a href="#" style={{ color: 'grey' }}>contact@fasconnect.com</a>
                </li>
                <li>
                  <a href="#" style={{ color: 'grey' }}>+91-0000000000</a>
                </li>
              </ul>
            </div>
            <div className="col-md-4">
              Policies
              <ul className="list-unstyled">
                <li>
                  <a href="#" style={{ color: 'grey' }}>Privacy Statement</a>
                </li>
                <li>
                  <a href="#" style={{ color: 'grey' }}>Terms of use</a>
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
        body, h1, h2, h3, h4, h5, h6, p, ul, ol, li {
          margin: 0;
          padding: 0;
        }
        
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
        /* About section styles */
        .about-section {
          background-color: #f0f3f5;
          padding: 50px 0; /* Adjust vertical spacing */
          overflow: hidden;
        }
        .about-section {
          background-color: #f0f3f5;
          padding: 100px 0; /* Adjust vertical spacing */
          overflow: hidden;
        }
        .about-content {
          text-align: center;
          margin-bottom: 30px;
        }

        .about-title {
          font-size: 3.5rem;
          color: #605ca8;
          margin-bottom: 15px;
          font-weight: bold;
        }

        .about-description {
          font-size: 2rem;
          color: #666;
          line-height: 1.6;
          margin-bottom: 30px;
        }
        /* AboutPoints styles */
        .point {
          padding: 15px;
          border-radius: 8px;
          background-color: #ffffff;
          box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
          transition: transform 0.3s ease-in-out;
          margin-bottom: 20px;
        }

        .point:hover {
          transform: translateY(-5px);
        }
        /* Contact section styles */
        .contact-section {
          background-color: #f0f3f5;
          padding: 100px 0;
          overflow: hidden;
          text-align: center;
        }
        
        .contact-content {
          text-align: center;
          margin-bottom: 30px;
        }
        
        .contact-details {
          display: flex;
          justify-content: space-between;
          margin-top: 50px;
          flex-wrap: wrap;
        }
        
        .contact-detail {
          flex: 0 0 calc(33.33% - 20px);
          padding: 20px;
          background-color: white;
          border-radius: 10px;
          box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
          text-align: left;
          margin-bottom: 30px;
          max-width: 400px;
        }
        
        .contact-detail h3 {
          font-size: 1.8rem;
          margin-bottom: 10px;
        }
        
        .contact-label {
          font-size: 1.3rem;
          font-weight: bold;
          margin-bottom: 6px;
          display: block;
        }
        
        .contact-info {
          font-size: 1.3rem;
          display: flex;
          align-items: center;
        }
        
        .contact-info a {
          color: #605ca8;
          text-decoration: none;
          margin-left: 6px;
        }
        
        .contact-info i {
          font-size: 1.5rem;
          color: #605ca8;
          margin-right: 8px;
        }
        
        

        `}
      </style>
    </div >
  );
};

export default LandingPage;