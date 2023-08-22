import React, { useState } from 'react';
import './FeedCard.css';

const FeedCard = ({ feedData }) => {
  const [commentBoxVisible, setCommentBoxVisible] = useState(false);

  const toggleCommentBox = () => {
    setCommentBoxVisible(!commentBoxVisible);
  };

  return (
    <>
      <hr />
      <div className="post">
        <div
          className="post-top"
          style={{
            background: '-webkit-linear-gradient(lavender ,white, lavender)',
            borderRadius: '5px',
          }}
        >
          <div className="post-top-left">
            <img className="post-profile-img" src="./data/images/write_male.png" alt="" />
            <span className="post-username">user</span>
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
          <p className="post-text">
            This is a sample post blah blah blah blah blah blah blah blah blah blah blah
          </p>
        </div>
        <hr />
        <div className="post-bottom">
          <div className="post-actions-left">
            <button className="btn btn-default post-action-btn">
              <i className="glyphicon glyphicon-thumbs-up"></i> 10
            </button>
            <button className="btn btn-default post-action-btn" onClick={toggleCommentBox}>
              <i className="glyphicon glyphicon-comment"></i> 12
            </button>
            <button className="btn btn-default post-action-btn">
              <i className="glyphicon glyphicon-share"></i> 3
            </button>
          </div>
        </div>
        {commentBoxVisible && (
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
        <hr />
        <div className="announcements-icon">
          <i className="glyphicon glyphicon-list-alt"></i>
        </div>
      </div>
    </>
  );
};

export default FeedCard;
