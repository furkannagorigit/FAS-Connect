// CreatePostPopup.js
import React from 'react';

const CreatePostPopup = ({ show, handleClose }) => {
  return (
    <div className={`modal ${show ? 'show' : ''}`} style={{ display: show ? 'block' : 'none' }}>
      <div className="modal-dialog">
        <div className="modal-content">
          <div className="modal-header">
            <h5 className="modal-title">Create Post</h5>
            <button type="button" className="close" onClick={handleClose}>
              <span>&times;</span>
            </button>
          </div>
          <div className="modal-body">
            {/* Add your form or content for creating the post here */}
            <p>Form content or input fields go here...</p>
          </div>
          <div className="modal-footer">
            <button type="button" className="btn btn-secondary" onClick={handleClose}>
              Close
            </button>
            <button type="button" className="btn btn-primary">
              Create Post
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CreatePostPopup;
