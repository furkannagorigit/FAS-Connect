import React, { useState } from 'react';
import './QnACard.css';

const QnACard = ({ post }) => {
  const [expanded, setExpanded] = useState(false);

  const toggleExpandComments = () => {
    setExpanded(!expanded);
  };

  return (
    <>
      <hr />
      <div className="post">
        <div className="post-top" style={{background: "-webkit-linear-gradient(lavender ,white, lavender)", borderRadius:"5px"}}>
          <div className="post-top-left">
            <img className="post-profile-img" src={"./data/images/laptop_female.png"} alt="" />
            <span className="post-username">Student</span>
            <span className="post-date">dd/mm hh:mm</span>
          </div>
          <div className="post-top-right">
            <button className="post-menu-btn">
              <i className="glyphicon glyphicon-option-vertical"></i>
              
            </button>
          </div>
        </div>
        <hr />
        <div className="post-middle">
          <p className="post-text" style={{ fontWeight: "bolder", fontSize: "18px" }}>This is a sample Question
            blah blah blah blah blah blah blah blah
            blah blah blah blah blah blah blah blah
            blah blah blah blah blah blah blah blah
            blah blah blah blah blah blah blah blah
            blah blah blah blah blah blah blah blah
          </p>
        </div>
        <hr />
        <div>
          <span className="post-username">Faculty: </span>
          <p className="post-text" style={{ display: "inline", fontSize: "16px" }}>
            this is a sample answer
          </p>
        </div>
        <hr />

        {/* Comments Section */}
        <div>
          <a className="expand-comments" onClick={toggleExpandComments}>
            {expanded ? "Click to collapse" : "Click to join the discussion.."}
          </a>
          {expanded && (
            <div className='scrollable' style={{height:"100px"}}>
              <p className="comment">
                <strong>User1:</strong> this is my comment
              </p>
              <p className="comment">
                <strong>User2:</strong> another comment here
              </p>
              <p className="comment">
                <strong>User3:</strong> a third comment goes here
              </p>
              <p className="comment">
                <strong>User4:</strong> a fourth comment example
              </p>
              <center>
              <form>
                <input
                  type="text"
                  placeholder="Add your thoughts.."
                  className="comment-input"
                />
                <button type="submit" className="comment-submit-btn">
                  <i className="glyphicon glyphicon-send"></i>
                </button>
              </form>
              </center>
            </div>
          )}
        </div>
          <div className="question-icon" >
          <i className="glyphicon glyphicon-question-sign"></i>
        </div>
        <hr />
      </div>
    </>
  );
};

export default QnACard;
