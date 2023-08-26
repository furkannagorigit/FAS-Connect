import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';
// import '/home/sunbeam/Downloads/CLIENT(1)/CLIENT/src/pages/Profile/Profile.css';
import "./Profile.css"
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import FeedCard from '../Feed/FeedCard';
import QnACard from '../QnA/QnACard';

const MyProfile = () => {
  const history = useHistory();

  // Example session data
  var sessionRole = sessionStorage.getItem("userRole"); // Replace with your session role logic
  var sessionGender = sessionStorage.getItem("userGender"); // Replace with your session gender logic

  var profileImage = "./data/photos/" + sessionStorage.getItem("profileImg").split('/').pop().trim();
  
  console.log((profileImage))

  var sessionRole = sessionStorage.getItem("role"); // Replace with your session role logic
  var sessionGender = sessionStorage.getItem("gender"); // Replace with your session gender logic


  sessionRole = "FACULTY"
  sessionGender = "FEMALE"

  // Function to determine the avatar based on role and gender
  const getAvatarSource = () => {
    if (sessionRole === "STUDENT" && sessionGender === "MALE") {
      return process.env.PUBLIC_URL + "/data/images/male-student-avatar.png";
    } else if (sessionRole === "STUDENT" && sessionGender === "FEMALE") {
      return process.env.PUBLIC_URL + "/data/images/female-student-avatar.png";
    } else if (sessionRole === "FACULTY" && sessionGender === "MALE") {
      console.log("getA----------")
      return process.env.PUBLIC_URL + "/data/images/male-faculty-avatar.png";
    } else if (sessionRole === "FACULTY" && sessionGender === "FEMALE") {
      return process.env.PUBLIC_URL + "/data/images/female-faculty-avatar.png";
    } else {
      return profileImage;
    }
  };

  const [showPosts, setShowPosts] = useState(true);

  const handlePostsClick = () => {
    setShowPosts(true);
  };

  const handleAboutClick = () => {
    setShowPosts(false);
  };

  return (
    <div className="col-md-7" style={{ flex: '1' }}>
      <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
      <div className="container col-md-12" style={{ flex: '1' }}>
        <div className="row">
          <div id="content">
            <div className="profile">
              <div className="profile-header">
                <div className="profile-header-cover"></div>
                <div className="profile-header-content">
                  <div className="profile-header-img">
                    <img src={profileImage === "./data/photos/null" || !profileImage ? getAvatarSource() : profileImage} alt="" />
                  </div>
                  <div className="profile-header-info">
                    <h4 className="m-t-10 m-b-5">Sean Ngu</h4>
                    <p className="m-b-10">UXUI + Frontend Developer</p>
                    <a className="btn btn-sm btn-info mb-2" onClick={()=>history.push('/EditProfile')}>Edit Profile</a>
                  </div>
                </div>
                <ul className="profile-header-tab nav nav-tabs">
                  <li className="nav-item">
                    <a href="#" target="__blank" className={showPosts ? "nav-link active" : "nav-link"} onClick={handlePostsClick}>POSTS</a>
                  </li>
                  <li className="nav-item">
                    <a href="#" target="__blank" className={!showPosts ? "nav-link active" : "nav-link"} onClick={handleAboutClick}>ABOUT</a>
                  </li>
                </ul>
              </div>
              <div className="profile-content">
                {showPosts ? (
                  <div className="col-md-12" style={{ flex: '1' }}>

                    <div className="scrollable">
                      {/* <FeedCard />
                      <QnACard />
                      <FeedCard />
                      <FeedCard /> */}
                    </div>
                  </div>
                ) : (
                  <div className="tab-content p-0">
                    <div className="tab-pane fade in active show" id="profile-about">
                      <div className="table-responsive">
                        <table className="table table-profile">

                          <tbody>
                            <tr>
                              <td className="field">DOB</td>
                              <td>15/12/1996</td>
                            </tr>
                            <tr>
                              <td className="field">Gender</td>
                              <td>Female</td>
                            </tr>
                            <tr>
                              <td className="field">Roll Number</td>
                              <td>75522</td>
                            </tr>
                            <tr>
                              <td className="field">Course ID</td>
                              <td>DAC-2023</td>
                            </tr>

                            <tr>
                              <td className="field">Email</td>
                              <td>micheal@example.com</td>
                            </tr>
                            <tr>
                              <td className="field">Website</td>
                              <td><a href="#">www.example.com</a></td>
                            </tr>
                            <tr>
                              <td className="field">Phone</td>
                              <td>(123) 456-7890</td>
                            </tr>
                            <tr>
                              <td className="field">Address</td>
                              <td>Pune</td>
                            </tr>
                            <tr>
                              <td className="field">Joined</td>
                              <td>January 01, 2023</td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                )}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default MyProfile;
