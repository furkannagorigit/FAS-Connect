import React from 'react';
import { useState } from 'react';
import ExcelTable from './PlacementRecord';
import CourseOffered from './CourseOffered';
import InfrastructurePage from './Infrastructure';
import GalleryPage from './Gallery';
import './Styles.css'; // Import the custom CSS

function MyInstitute() {

  const [activeLink, setActiveLink] = useState('link1'); // Set the initial active link

 
  const handleLinkClick = (link) => {
    setActiveLink(link);
  };

  const getContentForLink = () => {
    // Customize the content for each link
    switch (activeLink) {
      //my performance
      case 'link1':
        return <>
        <p>

At SunBeam, the mission is not only to deliver the course effectively but also to shape our trainees into software professionals readily deployable in the industry. We see our responsibility as that of facilitates and guides, guiding the student through the prequalifying exam, the actual DAC course and also in the industry.

Keeping in mind the industry expectations, we supplement the technical contents of the course with many extra curricular activities like workshop, regular aptitude tests etc. Our placement cell works around the year to arrange for placement interviews and job opportunities for our students.

Many leading industries have visited our campus in the past and the list is ever increasing. The dedicated work of our placement teams provides a platform for our student to showcase their skills and the efforts they have put in during the course to secure for themselves a bright future in the software industry.
</p>
<br></br>
<br></br>
<ExcelTable/>
        </> ;
      case 'link2':
        return<><CourseOffered/></>;
      case 'link3':
        return <><InfrastructurePage/></>;
      case 'link4':
        return <><GalleryPage/></>;
      default:
        return <div>Default Content</div>;
    }
  };

  return (<>
   
      <div>
        <div className="col-md-7">
          <nav className="navbar navbar-default">
            <div className="container">
              <div className="navbar-header">
                <button
                  type="button"
                  className="navbar-toggle collapsed"
                  data-toggle="collapse"
                  data-target="#navbar-collapse"
                  aria-expanded="false"
                >
                  <span className="sr-only">Toggle navigation</span>
                  <span className="icon-bar"></span>
                  <span className="icon-bar"></span>
                  <span className="icon-bar"></span>
                </button>
              </div>
              <div className="collapse navbar-collapse" id="navbar-collapse">
                <ul className="nav navbar-nav">
                  <li className={activeLink === 'link1' ? 'active' : ''} onClick={() => handleLinkClick('link1')}>
                    <a href="#!">Placement Stats</a>
                  </li>
                  <li className={activeLink === 'link2' ? 'active' : ''} onClick={() => handleLinkClick('link2')}>
                    <a href="#!">Courses</a>
                  </li>
                  <li className={activeLink === 'link3' ? 'active' : ''} onClick={() => handleLinkClick('link3')}>
                    <a href="#!">Infrastructure</a>
                  </li>
                  <li className={activeLink === 'link4' ? 'active' : ''} onClick={() => handleLinkClick('link4')}>
                    <a href="#!">Gallery</a>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
          <div className="content-container">
            {getContentForLink()} {/* Render the content based on the active link */}
          </div>
        </div>
      </div>
  </>);
}

export default MyInstitute;