import React, { useState } from "react";
import "../Feed/CreateFeed.css"
import { AddFeed } from "../../Services/feedService";
import { toast } from 'react-toastify';
import { useHistory, Link } from 'react-router-dom/cjs/react-router-dom.min';

function CreateFeed() {
  const [text, setText] = useState("");
  const [image, setImage] = useState(null);
	var history = useHistory();

  const handleTextChange = (event) => {
    setText(event.target.value);
  };

  const handleImageChange = (event) => {
    
    setImage(event.target.files[0]);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    // Here you can handle the submission of the text and image
   
    const updatedData ={
      "text": text,
      "type": "FEED"
    }
    const formData = new FormData();

     if (image) {
            formData.append('imageFile', image);
     }
     formData.append('feed', JSON.stringify(updatedData));

    const response = await AddFeed(sessionStorage.getItem("userId"),formData)
    console.log(response['status'])
    if (response['status'] == 201) {
      toast.success('Feed added successfully !')
      history.push('/Feed');

    } else if (response == "null") {
      toast.error("Feed not added")
    }
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
