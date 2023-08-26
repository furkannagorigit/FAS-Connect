import React, { useState } from 'react';
import './QnACard.css';
import { toast } from 'react-toastify';
import { log } from '../../Utils/utils';
import { addAnswer, commentQnA } from '../../Services/QnAService';

const QnACard = ( props ) => {
  debugger
  console.log("props: ",props)
  const [answerText, setAnswerText] = useState('');
  const [comment, setComment] = useState('');
  const [comments, setComments] = useState(props.comments);

  const handleComment = async (event) => {
    event.preventDefault(); // Prevent form submission
    const requestData = {
      "postId": props.qna.id,
      "userId": sessionStorage.getItem("userId"),
      "text": comment
    }
    const response = await commentQnA(requestData)
    if (response['status'] === 201) {

      const newComment = {
        user: { firstName: sessionStorage.getItem("firstName") },
        text: comment,
      };
      // setComments([...comments, newComment]);

      // // Clear the input field
      // setComment('');

    } else {
      toast.error('Error while commenting on the post')
    }
  };

  const handleAnswerSubmit = async (event) => {
    event.preventDefault();

    const qnaId = props.qna.id
    const answerdById = sessionStorage.getItem('userId')

    const ansData = {
      "answeredById": answerdById,
      "answer": answerText
    }

    const response = await addAnswer(qnaId, ansData)
    if (response['status'] == 200) {
      log(response)
      toast.success('Answer Added successfully')
    } 
    else if(response == "null")
    {
        toast.error('Something went wrong')
    }
  };

  const [expanded, setExpanded] = useState(false);
  
  const toggleExpandComments = () => {
    setExpanded(!expanded);
  };

  var ans = ''
  var ansBy = 'fac1'

  return (
    <>
      <hr />
      <div className="post">
        <div className="post-top" style={{background: "-webkit-linear-gradient(lavender ,white, lavender)", borderRadius:"5px"}}>
          <div className="post-top-left">
            <img className="post-profile-img" src={"./data/images/laptop_female.png"} alt="" />
            <span className="post-username">{props.qna.createdByName}</span>
            <span className="post-date">{props.qna.createdAt}</span>
          </div>
          <div className="post-top-right">
            <button className="post-menu-btn">
              <i className="glyphicon glyphicon-option-vertical"></i>
              
            </button>
          </div>
        </div>
        <hr />
        <div className="post-middle">
          <p className="post-text" style={{ fontWeight: "bolder", fontSize: "18px" }}>
            {props.qna.text}
          </p>
        </div>
        <hr />
        <div>
        {props.qna.answer ? (
          <>
            <span className="post-username">{props.qna.answeredByName}: </span>
            <p className="post-text" style={{ display: "inline", fontSize: "16px" }}>
              {props.qna.answer}
            </p>
          </>
        ) : sessionStorage.getItem('role') === "FACULTY" ? (
          <form onSubmit={handleAnswerSubmit}>
            <input
              type="text"
              placeholder="Question not answered yet..."
              value={answerText}
              onChange={(e) => setAnswerText(e.target.value)}
              className="comment-input"
            />
            <button type="submit" className="comment-submit-btn">
              <i className="glyphicon glyphicon-send"></i>
            </button>
          </form>
        ) : null}
      </div>

        <hr />

        {/* Comments Section */}
        <div>
          <a className="expand-comments" onClick={toggleExpandComments}>
            {expanded ? "Click to collapse" : "Click to join the discussion.."}
          </a>
          {expanded && (
            <div className='scrollable' style={{height:"100px"}}>
              {comments && 
              props.comments.map((comment) => (
              <p className="comment" key={comment.id}>
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
