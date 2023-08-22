import React, { useState } from "react";
import "../Feed/CreateFeed.css"

function CreateFeed() {
  const [text, setText] = useState("");
  const [image, setImage] = useState(null);

  const handleTextChange = (event) => {
    setText(event.target.value);
  };

  const handleImageChange = (event) => {
    const selectedImage = event.target.files[0];
    setImage(selectedImage);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // Here you can handle the submission of the text and image
    console.log("Submitted text:", text);
    console.log("Selected image:", image);

    // Clear the input fields
    setText("");
    setImage(null);
  };

  return (
    <div className="col-md-7" style={{ flex: "1" }}>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="imageInput">Select a picture</label>
          <div className="custom-file">
            <input
              type="file"
              className="custom-file-input"
              id="imageInput"
              accept="image/*"
              onChange={handleImageChange}
            />
          </div>
        </div>
        <div className="form-group">
          <label htmlFor="feedInput">What's on your mind?</label>
          <textarea
            rows="4"
            className="form-control"
            id="feedInput"
            value={text}
            onChange={handleTextChange}
          />
        </div>
        <button type="submit" className="btn btn-primary">
          Post
        </button>
      </form>
    </div>
  );
}

export default CreateFeed;
