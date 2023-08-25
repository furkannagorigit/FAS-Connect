import React from 'react';
import './CourseTimeline.css'; // Import your custom CSS for styling

const CourseTimeline = () => {
  const timelineData = [
    { date: '2023-09-01', subject: 'Introduction to Course', faculty: 'Prof. Smith' },
    { date: '2023-09-15', subject: 'Module 1: Fundamentals', faculty: 'Dr. Johnson' },
    { date: '2023-10-01', subject: 'Module 2: Advanced Topics', faculty: 'Prof. Brown' },
    { date: '2023-10-15', subject: 'Module 3: Practical Applications', faculty: 'Dr. Davis' },
    { date: '2023-11-01', subject: 'Module 4: Case Studies', faculty: 'Prof. Wilson' },
    { date: '2023-11-15', subject: 'Module 5: Final Project', faculty: 'Dr. Miller' },
  ];

  return (
    <div className="container mt-5 mb-5">
      <div className="row">
        <div className="col-md-8 offset-md-2">
          <h4>Course Journey</h4>
          <ul className="timeline">
            {timelineData.map((item, index) => (
              <li key={index}>
                <div className="timeline-badge">{item.date}</div>
                <div className="timeline-panel">
                  <div className="timeline-heading">
                    <div className="course-info-container">
                      <p className="course-title">{item.subject}</p>
                      <p className="faculty">{item.faculty}</p>
                    </div>
                    <h2 className="timeline-title">{item.subject}</h2>
                  </div>
                </div>
              </li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default CourseTimeline;
