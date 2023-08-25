import React from 'react';
import './InfrastructurePage.css'; // Import your custom CSS for styling

const InfrastructurePage = () => {
  const facilities = [
    {
        title: "Overview :",
        description: `

        The Sunbeam campus at Rajiv Gandhi Infotech Park, Hinjawadi is spread over an area of 1 Acre which includes 70,000 sq feet of built-up area and 5-floor building for C-DAC courses.
        
        The teaching-learning process is facilitated in 3 lecture halls, 5 computer labs with high-speed Internet connectivity, a seminar room, conference room, library. The entire sunbeam campus is Wi-Fi enabled. Sunbeam also provides hostel facility to girls. The construction of a Hinjewadi branch has been completed and the AUG 2019 batches have started in a new building.
        `
     },
    {
      title: "Modern Classrooms",
      description: "Our institute boasts state-of-the-art classrooms equipped with multimedia facilities to enhance the learning experience.",
    },
    {
      title: "Advanced Laboratories",
      description: "We offer specialized laboratories for practical training in various subjects, fostering hands-on learning.",
    }
  ];

  return (
    <div className="infrastructure-container">
      
      <h1 className="title">Infrastructure</h1>
      <div className="intro">
        <img src="/data/images/Institute.jpg" alt="Institute" />
        <img src="/data/images/Lobby.jpg" alt="Lobby" />
        <img src="/data/images/Classroom.jpg" alt="Classroom" />
      </div>
      {facilities.map((facility, index) => (
        <div key={index} className="facility">
          <h2>{facility.title}</h2>
          <p>{facility.description}</p>
        </div>
      ))}
    </div>
  );
};

export default InfrastructurePage;