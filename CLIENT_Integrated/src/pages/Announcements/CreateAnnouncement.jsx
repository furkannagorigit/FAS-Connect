import React, { useState } from "react";
import "../Feed/CreateFeed.css"
import { AddAnnouncement } from "../../Services/announcementService";
import { toast } from 'react-toastify';
import { useHistory, Link } from 'react-router-dom/cjs/react-router-dom.min';


function CreateFeed() {
  const [text, setText] = useState("");
	var history = useHistory();


  const handleTextChange = (event) => {
    setText(event.target.value);
  };


  const handleSubmit = async (event) => {
    event.preventDefault();
    // Here you can handle the submission of the text and image
    const updatedData ={
      "text": text,
      "type": "ANNOUNCEMENT"
    }
    const response = await AddAnnouncement(sessionStorage.getItem("userId"),updatedData)
    console.log(response['status'])
    if (response['status'] == 200) {
      toast.success('Annoncement added successfully !')
      history.push('/Announcements');

    } else if (response == "null") {
      toast.error("Annoncement not added")
    }
    // Clear the input fields
    setText("");
  };

  return (
    <div className="col-md-7" style={{ flex: "1" }}>
      <form onSubmit={handleSubmit}>
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
