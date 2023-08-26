// CourseCard.js
import React from 'react';

const CourseCard = ({ subject, description, downloadLink }) => {
  return (
    <div className="card mb-3">
      <div className="card-body">
        <h5 className="card-title">{subject}</h5>
        <p className="card-text">{description}</p>
        <a href={downloadLink} className="btn btn-primary" download>
          Download Course Material
        </a>
      </div>
    </div>
  );
};

export default CourseCard;
