import React from 'react';
import './AnnouncementsCard.css';

const AnnouncementsCard = ({ props }) => {

    
    return (<>
        <hr />
        <div className="post">
            <div className="post-top" style={{background: "-webkit-linear-gradient(lavender ,white, lavender)", borderRadius:"5px"}}>
                <div className="post-top-left">
                    <img className="post-profile-img" src={"./data/images/teacher_male.png"} alt="" />
                    <span className="post-username"> {props.createdByName}</span>
                    <span className="post-date">{props.createdAt}</span>
                </div>
                <div className="post-top-right">
                    <button className="post-menu-btn">
                        <i className="glyphicon glyphicon-option-vertical"></i>
                    </button>
                </div>
            </div>
            <hr />
            <div className="post-middle">
                <p className="post-text" style={{ fontWeight: "bolder", fontSize: "18px" }}>{props.text}
                </p>
            </div>
            <div className="announcements-icon" >
          <i className="glyphicon glyphicon-bullhorn"></i>
            </div>
            <hr></hr>
        </div>
        
    </>);
};

export default AnnouncementsCard;