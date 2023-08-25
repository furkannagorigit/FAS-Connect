import React, { useState } from "react";
import "../Feed/CreateFeed.css"
import { AddQnA } from "../../Services/QnAService";
import { toast } from "react-toastify";

function CreateFeed() {
  const [text, setText] = useState("");

  const handleTextChange = (event) => {
    setText(event.target.value);
  };


  const handleSubmit = async (event) => {
    event.preventDefault();
    // Here you can handle the submission of the text and image

    const updatedData ={
      "text": text,
      "type": "QNA"
    }

    const response = AddQnA(sessionStorage.getItem("userId"), updatedData)
    if (response['status'] == 200) {
      toast.success('Annoncement added successfully !')
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
