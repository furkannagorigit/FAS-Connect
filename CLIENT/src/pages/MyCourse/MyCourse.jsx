import React from 'react';
import { useEffect, useState } from 'react';
import CourseCard from './CourseCard';
import './Styles.css'; // Import the custom CSS
import { getAllMarks } from '../../Services/CourseService';
import { toast } from 'react-toastify';
import {Bar, PieChart} from 'react-google-charts';
import { Chart } from "react-google-charts";
import CourseTimeline from './CourseCalender';



function MyCourse() {

  const [modules, setModules] = useState([]);

  //Load list of modules
  const loadModules = async (studentId=1) =>{
    const response = await getAllMarks(studentId)
      if (response['status'] == 200) {
        setModules(response.data)
      } else if(response == "null")
      {
        toast.error('Could not fetch list of marks')
      }
  }

  //Load modules at component loading time
  useEffect(()=>{
    loadModules()
  },[])

  useEffect(()=>{
    console.log("set modules: ",modules)
  },modules)


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
              <th>
                Module Name
              </th>
              <th>
                Obtained Marks
              </th>
              <th>
                Total Marks
              </th>
              <th>
                Percentage
              </th>
            </thead>
            <tbody>
            {
              modules.map((module) => {
                var moduleName = "null";

                if(module.moduleId==1)
                moduleName = "OOPS with Java"
                else if(module.moduleId==2)
                moduleName = "Algorithms and Data Structures"
                else if(module.moduleId==3)
                moduleName = "Operating Systems"
                else if(module.moduleId==4)
                moduleName = "Advance Java"
                else if(module.moduleId==5)
                moduleName = "MS .Net"

                return  (<tr key={module.moduleId}>
                  <td style={{ fontWeight: 'bold' }}>{moduleName}</td>
                  <td>{module.obtainedMarks}</td>
                  <td>{module.totalMarks}</td>
                  <td>{(module.obtainedMarks / module.totalMarks) * 100}%</td>
                </tr>)
            })
            }
            <tr>
              <td style={{ fontWeight: 'bold' }}>Total</td>
              <td style={{ fontWeight: 'bold' }}>
                {modules.reduce((total, module) => total + module.obtainedMarks, 0)}
              </td>
              <td style={{ fontWeight: 'bold' }}>
                {modules.reduce((total, module) => total + module.totalMarks, 0)}
              </td>
              <td style={{ fontWeight: 'bold' }}>
                {(
                  (modules.reduce((total, module) => total + module.obtainedMarks, 0) /
                    modules.reduce((total, module) => total + module.totalMarks, 0)) *
                  100
                ).toFixed(2)}
                %
              </td>
          </tr>
            </tbody>
          </table>
          <hr></hr>
        </div>
          <div className="col-md-12" style={{ marginTop: 70 }}>
            <div className="row">
                <div className="col-md-6">
                  {/* Pie Chart */}
                  <Chart
                    width={'100%'}
                    height={'300px'}
                    chartType="PieChart"
                    data={[
                      ['Module', 'Marks'],
                      ...modules.map((module) => {
                        let moduleName = '';
                        switch (module.moduleId) {
                          case 1:
                            moduleName = 'OOPS with Java';
                            break;
                          case 2:
                            moduleName = 'ADS';
                            break;
                          case 3:
                            moduleName = 'Operating Systems';
                            break;
                          case 4:
                            moduleName = 'Advance Java';
                            break;
                          case 5:
                            moduleName = 'MS .Net';
                            break;
                          default:
                            moduleName = 'Unknown';
                            break;
                        }
                        return [moduleName, module.obtainedMarks];
                      }),
                    ]}
                    options={{
                      title: 'Modulewise Obtained Marks Distribution',
                    }}
                  />
                </div>
                <div className="col-md-6">
                  {/* Bar Chart  Starts here*/}
                  <Chart
                    chartType="Bar"
                    width="100%"
                    height="300px"
                    data={[
                      ['Module', 'Obtained Marks', 'Total Marks'],
                      ...modules.map((module) => {
                        let moduleName = '';
                        switch (module.moduleId) {
                          case 1:
                            moduleName = 'OOPS with Java';
                            break;
                          case 2:
                            moduleName = 'ADS';
                            break;
                          case 3:
                            moduleName = 'Operating Systems';
                            break;
                          case 4:
                            moduleName = 'Advance Java';
                            break;
                          case 5:
                            moduleName = 'MS .Net';
                            break;
                          default:
                            moduleName = 'Unknown';
                            break;
                        }
                        return [moduleName, module.obtainedMarks, module.totalMarks];
                      }),
                    ]}
                    options={{
                      chart: {
                        title: "Obtained Marks v/s obtained Marks"
                      }
                    }}
                  />
                  {/* Bar Chart  Ends here*/}
                </div>
              </div>
          </div>
        </>

          ;
      case 'link2':
        return <><CourseTimeline/></>          ;
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
