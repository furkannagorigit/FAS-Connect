import React, { useState } from 'react';
import './FeedCard.css';
import { commentFeed, likeFeed, unlikeFeed } from '../../Services/feedService';
import { toast } from 'react-toastify';

const FeedCard = ({ props }) => {
  const [commentBoxVisible, setCommentBoxVisible] = useState(false);
  const toggleCommentBox = () => {
    setCommentBoxVisible(!commentBoxVisible);
  };
  const postImage = "./data/photos/" + props.feed.feedImg.split('/').pop().trim();

  console.log(postImage)
  console.log(postImage.length)
  const [likes, setLikes] = useState(props.likes);
  const [liked, setLiked] = useState(false);
  const [comment, setComment] = useState('');
  const [comments, setComments] = useState(props.comments);

  
  const handleComment = async (event) => {
    event.preventDefault(); // Prevent form submission
    const requestData = {
      "postId": props.id,
      "userId": sessionStorage.getItem("userId"),
      "text": comment
    }
    const response = await commentFeed(requestData)
    if (response['status'] === 201) {

      const newComment = {
        user: { firstName: sessionStorage.getItem("firstName") },
        text: comment,
      };
      setComments([...comments, newComment]);

      // Clear the input field
      setComment('');

    } else {
      toast.error('Error while commenting on the post')
    }
  };
  
  const handleLike = async () => {
    const requestData = {
      "postId": props.id,
      "userId": sessionStorage.getItem("userId")
    }
    if (liked) {
      const response = await unlikeFeed(requestData)
      if (response['status'] === 200) {
        setLikes(likes - 1);
        setLiked(false);
      } else {
        toast.error('Error while unliking the post')
      }
      // Unlike
      setLikes(likes - 1);
      setLiked(false);
      // Make an axios request to unlike
    } else {

      const response = await likeFeed(requestData)
      console.log(response)
      if (response['status'] === 201) {
        setLikes(likes + 1);
        setLiked(true);
      } else {
        toast.error('Error while liking the post')
      }
      // Like


    }

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
            <span className="post-username">{props.createdByName}</span>
            <span className="post-date">{props.feed.createdAt}</span>
          </div>
          <div className="post-top-right">
            <button className="post-menu-btn">
              <i className="glyphicon glyphicon-option-vertical"></i>
            </button>
          </div>
        </div>
        <hr />
        <div className="post-middle">
          {/* New squared image section */}
          {postImage &&
            <center>
              <div className="post-image-section">
                <div>
                  <img
                    className="post-image"
                    src={postImage}
                    alt="Post Image"
                  />
                </div>
              </div>
            </center>
          }
          <p className="post-text">
            {props.feed.text}
          </p>
        </div>
        <hr />
        <div className="post-bottom">
          <div className="post-actions-left">
            <button className="btn btn-default post-action-btn" onClick={handleLike}>
              {liked ? (
                <>
                  <i className="glyphicon glyphicon-thumbs-up liked" style={{ color: 'blue' }}></i> {likes}
                </>
              ) : (
                <>
                  <i className="glyphicon glyphicon-thumbs-up"></i> {likes}
                </>
              )}
            </button>
            <button className="btn btn-default post-action-btn" onClick={toggleCommentBox}>
              <i className="glyphicon glyphicon-comment"></i> {props.comments.length}
            </button>
            <button className="btn btn-default post-action-btn">
              <i className="glyphicon glyphicon-share"></i> 3
            </button>
          </div>
        </div>
        {commentBoxVisible && (
          <div className='scrollable' style={{ height: "100px" }}>
            {props.comments.map((comment) => (
              <p className="comment">
                <strong>{comment.user.firstName}:</strong>{comment.text}
              </p>
            ))}

            <center>
              <form onSubmit={handleComment}>
                <input
                  type="text"
                  placeholder="Add your thoughts.."
                  className="comment-input"
                  value={comment}
                  onChange={(event) => setComment(event.target.value)}
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