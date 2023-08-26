import React from 'react';
import './GalleryPage.css'; // Import your custom CSS for styling

const GalleryPage = () => {
  const images = [
    "/data/images/Institute.jpg",
    "/data/images/Gallery1.jpg",
    "/data/images/Gallery2.jpg",
    "/data/images/Gallery3.jpg",
    "/data/images/Gallery4.jpg",
    "/data/images/Gallery5.jpg",
    "/data/images/Gallery6.jpg",
    "/data/images/Gallery7.jpg",
  ];

  return (
    <div className="gallery-container">
      <h1 className="title">Photo Gallery</h1>
      <div className="image-grid">
        {images.map((image, index) => (
          <div key={index} className="image-container">
            <img src={image} alt={`Image ${index + 1}`} />
          </div>
        ))}
      </div>
    </div>
  );
};
export default GalleryPage;
