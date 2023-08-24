import React from 'react';
import { useState } from 'react';
import CourseCard from './CourseCard';
import './Styles.css'; // Import the custom CSS


const data = [
  { subject: 'Java', performance: 85 },
  { subject: '.Net', performance: 78 },
  { subject: 'DSA', performance: 92 },
  { subject: 'WPT', performance: 65 },
  { subject: 'C', performance: 75 },
  { subject: 'C++', performance: 75 },

];

function MyCourse() {
  const maxValue = Math.max(...data.map(item => item.performance));


  const [activeLink, setActiveLink] = useState('link1'); // Set the initial active link

  const courses = [
    {
      subject: 'Java',
      description: 'This course covers basic arithmetic and algebra.',
      downloadLink: '/path/to/your/math_course_material.pdf',
    },
    {
      subject: 'Data structure',
      description: 'Explore the fascinating world of physics and chemistry.',
      downloadLink: '/path/to/your/science_course_material.pdf',
    },
    {
      subject: 'Web technologies',
      description: 'Explore the fascinating world of physics and chemistry.',
      downloadLink: '/path/to/your/science_course_material.pdf',
    },
    {
      subject: 'C',
      description: 'Explore the fascinating world of physics and chemistry.',
      downloadLink: '/path/to/your/science_course_material.pdf',
    },
    {
      subject: 'CPP',
      description: 'Explore the fascinating world of physics and chemistry.',
      downloadLink: '/path/to/your/science_course_material.pdf',
    },
    // Add more courses as needed
  ];

  const handleLinkClick = (link) => {
    setActiveLink(link);
  };

  const getContentForLink = () => {
    // Customize the content for each link
    switch (activeLink) {
      //my performance
      case 'link1':
        return <> <div className="col-md-12">
          <table class="table table-hover ">
            <thead>
              <tr>
                <th></th>

                {data.map(item => (
                  <th>{item.subject}</th>

                ))}
              </tr>
            </thead>
            <tbody>
              <tr>
                <td style={{ fontWeight: 'bold' }}>internal exams</td>
                <td>17/20</td>
                <td>15/20</td>
                <td>10/20</td>
                <td>11/20</td>
                <td>16/20</td>
                <td>13/20</td>
              </tr>
              <tr>
                <td style={{ fontWeight: 'bold' }}>lab exams</td>
                <td>36/40</td>
                <td>27/40</td>
                <td>30/40</td>
                <td>28/40</td>
                <td>33/40</td>
                <td>34/40</td>
              </tr>
              <tr>
                <td style={{ fontWeight: 'bold' }}>Attendance rate</td>
                <td>40/50</td>
                <td>45/50</td>
                <td>47/50</td>
                <td>43/50</td>
                <td>36/50</td>
                <td>37/50</td>
              </tr>
              <tr>
                <td style={{ fontWeight: 'bold' }}>final exam</td>
                <td>70/100</td>
                <td>50/100</td>
                <td>40/100</td>
                <td>70/100</td>
                <td>80/100</td>
                <td>90/100</td>
              </tr>
              <tr>
                <td style={{ fontWeight: 'bold' }}>assignments</td>
                <td>17/20</td>
                <td>15/20</td>
                <td>10/20</td>
                <td>11/20</td>
                <td>16/20</td>
                <td>13/20</td>
              </tr>
              <tr>
                <td style={{ fontWeight: 'bold' }}>Total</td>
                <td style={{ fontWeight: 'bold' }}>170/250</td>
                <td style={{ fontWeight: 'bold' }}>150/250</td>
                <td style={{ fontWeight: 'bold' }}>160/250</td>
                <td style={{ fontWeight: 'bold' }}>167/250</td>
                <td style={{ fontWeight: 'bold' }}>174/250</td>
                <td style={{ fontWeight: 'bold' }}>134/250</td>
              </tr>
            </tbody>
          </table>
          <hr></hr>
        </div>
          <div className="col-md-12" style={{ marginTop: 70 }}>

            <div style={{ width: '100%', display: 'flex', justifyContent: 'space-between', flexWrap: 'wrap' }}>
              {data.map(item => (
                <div key={item.subject} style={{ textAlign: 'center', flexBasis: '20%', marginBottom: '20px' }}>
                  <div
                    style={{
                      display: 'inline-block',
                      width: '20%',
                      maxWidth: '100px', /* Maximum width of the bars */
                      height: `${(item.performance / maxValue) * 100}px`,
                      backgroundColor: 'steelblue',
                      marginBottom: '5px', /* Added margin to create space between bar and label */
                    }}
                  />
                  <div>{item.subject}</div>
                </div>
              ))}
            </div>

          </div>
        </>

          ;
      case 'link2':
        return
          ;
      case 'link3':
        return <div className="container col-md-12">
          <h1>Course Materials</h1>
          <div className="row">
            {courses.map((course, index) => (
              <div key={index} className="col-lg-4 col-md-6 col-sm-12">
                <CourseCard
                  subject={course.subject}
                  description={course.description}
                  downloadLink={course.downloadLink}
                />
              </div>
            ))}
          </div>
        </div>;
      case 'link4':
        return <div>Content for Link 4</div>;
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
                  <a href="#!">My performance</a>
                </li>
                <li className={activeLink === 'link2' ? 'active' : ''} onClick={() => handleLinkClick('link2')}>
                  <a href="#!">Course Journey</a>
                </li>
                <li className={activeLink === 'link3' ? 'active' : ''} onClick={() => handleLinkClick('link3')}>
                  <a href="#!">Course material</a>
                </li>
                <li className={activeLink === 'link4' ? 'active' : ''} onClick={() => handleLinkClick('link4')}>
                  <a href="#!">Calender</a>
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

export default MyCourse;
