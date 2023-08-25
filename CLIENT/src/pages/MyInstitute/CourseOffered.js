import React, { useState } from 'react';
import './CourseOffered.css'; // Import your custom CSS for styling

const CourseOffered = () => {
  const courseOfferings = [
    {
      name: "DAC",
      description: "PG-DAC is the most popular PG Diploma course of C-DAC. The course is targeted towards Engineering Graduates and MCA/MSc who wish to venture into the domain of advanced computing. The course aims to groom the students to enable them to work on current technology scenarios as well as prepare them to keep pace with the changing face of technology and the requirements of the growing IT industry. The entire course syllabus, courseware, teaching methodology and the course delivery have been derived from the rich research and development background of C-DAC. Running successfully for 30 years, the PG-DAC course has produced thousands of professionals, who are well positioned in the industry today.",
    },
    {
      name: "DMC",
      description: "The Post-Graduate Diploma in Mobile Computing (PG-DMC) is one of the pioneering programs of ACTS. The main focus of this course is to enable the candidates fulfilling the eligibility criteria, to develop their skill set mainly in areas like Native and Hybrid Mobile Application Development. The course also focuses on Java Programming, as part of the industry requirement. This course incorporates  Mobility and Analytics keeping in view the emerging trends in mobile technology as well as contemporary and futuristic human resource requirements of the Mobile Industry. The depth and width of the course is unique in the industry covering a wide spectrum of the ICT industry.",
    },
    {
      name: "DESD",
      description: "Realizing the growth of embedded systems in day-to-day life and the need for trained manpower in this promising area, C-DAC has launched a Post Graduate Diploma in Embedded Systems Design (PG-DESD) for Engineers in computers, electronics and IT. Embedded Systems is a unique field, where engineers need to have sound knowledge in hardware and software design. Keeping this aspect in view, C-DAC has designed the diploma giving equal emphasis to hardware and software, enabling engineers to face challenges in the design and development of state of the art embedded systems. The latest curriculum includes a module on Internet of Things (IoT), specifically focusing on IoT architectures, applications, standards and protocols.",
    },
    {
      name: "DBDA",
      description: `The theoretical and practical mix of the Post Graduate Diploma in Big Data Analytics (PG-DBDA) programme has the following focus:

      To explore the fundamental concepts of big data analytics with in-depth knowledge and understanding of the big data analytics domain
      To understand the various search methods and visualization techniques and to use various techniques for mining data stream
      To analyze and solve problems conceptually and practically from diverse industries, such as government manufacturing, retail, education, banking/ finance, healthcare and pharmaceutical
      To undertake consulting and industrial projects with significant data analysis component for better understanding of the theoretical concepts from statistics, economics and building future solutions data analytics to make an impact in the technological advancement
      To use advanced analytical tools/ decision-making tools/ operation research techniques to analyze the complex problems and get ready to develop such new techniques for the future
      To learn Cloud Computing, accessing resources and services needed to perform functions with dynamically changing needs
  `,
    },
    {
      name: "DITIIS",
      description: `The theoretical and practical mix of the Post Graduate Diploma in IT Infrastructure, Systems and Security (PG-DITISS) programme has the following focus:

      To understand the Concepts of Data Centre Management, applications security implementation and use various techniques for Ethical Hacking and Cyber Forensics
      To analyze the Threats Detection Techniques, Intrusion Detection and Prevention measures
      To use advanced tools/ decision-making tools/ techniques to analyze the complex problems and get ready to develop such new techniques for the future
      To learn cloud computing, accessing resources and services needed to perform functions with dynamically changing needs thereby implementing cloud privacy and security concepts on cloud platforms to create secure cloud environment
      To analyze and solve problems conceptually and practically from diverse industries, such as government manufacturing, retail, education, banking/ finance, healthcare and pharmaceutical
      To undertake industrial research projects for the development of future solutions in the domain of Information Security to make an impact in the technological advancement
  
  PG-DITISS is targeted towards grooming students in the arena of human-computer interaction and cyber and network security. The objective of this course is to enable the students to understand the concepts of network security and learn the techniques of detecting the attacks and securing a network from internal and external attacks. At the end of the course, the student will be able to recognise a variety of generic security threats and vulnerabilities, understand the principles and practices of cryptographic techniques, identify and analyze particular security problems for a given application and apply appropriate security techniques to solve the security issues.
  `,
    }
  ];
    const [selectedCourse, setSelectedCourse] = useState(0);
  
    const handleCourseSelection = (courseIndex) => {
      setSelectedCourse(courseIndex);
    };
  
    return (
      <div className="course-offered-container">
        <h1>Course Offered</h1>
        <div className="button-container">
          {courseOfferings.map((course, index) => (
            <button
              key={index}
              className={`course-button ${selectedCourse === index ? 'active' : ''}`}
              onClick={() => handleCourseSelection(index)}
            >
              {course.name}
            </button>
          ))}
        </div>
        <div className="course-summary">
          <h2>Course Description</h2>
          <p className="course-description">{courseOfferings[selectedCourse].description}</p>
        </div>
      </div>
    );
  };
  
  export default CourseOffered;
  
  
