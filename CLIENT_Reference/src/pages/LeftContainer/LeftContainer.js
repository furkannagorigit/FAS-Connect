import React, { useState, useEffect } from "react";
import { Link, useLocation } from "react-router-dom";
import "../LeftContainer/LeftContainer.css"

function LeftContainer() {
  const location = useLocation();
  const [activeSection, setActiveSection] = useState("");

  useEffect(() => {
    const pathname = location.pathname;
    const section = pathname.substring(1); // Remove the leading '/'
    setActiveSection(section);
  }, [location]);

  return (
    <>
      <div className="col-md-2" style={{ borderRight: "1px solid mediumpurple", height: "90vh", backgroundColor: "#f5f5ff" }}>
        <br />
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        {/* <!------ Include the above in your HEAD tag ----------> */}

        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />

        <div class="profile-block" >
          <div class="panel text-center">
            <div class="user-heading">
              <a href="#">
                <img src="./data/images/furkan.jpg" alt="" title="" className="img-responsive img-circle" />
              </a>
              <br>
              </br>
              <strong>Elias Miah</strong>
              <p>eliasmia1988@gmail.com</p>

            </div>
          </div>
        </div>
        <br />
        <div className="panel panel-default" style={{ border: "none" }}>
          <div className="panel-body">
            <ul className="nav nav-pills nav-stacked">
              <li>
                <Link
                  to="/Announcements"
                  style={{
                    textDecoration: activeSection === "Announcements" ? "underline" : "",
                    color: "mediumpurple"
                  }}
                >
                  <span className="glyphicon glyphicon-bullhorn"></span> Announcements
                </Link>
              </li>
              <li>
                <Link
                  to="/Feed"
                  style={{
                    textDecoration: activeSection === "Feed" ? "underline" : "",
                    color: "mediumpurple"
                  }}
                >
                  <span className="glyphicon glyphicon-list-alt"></span> Feed
                </Link>
              </li>
              <li>
                <Link
                  to="/QnA"
                  style={{
                    textDecoration: activeSection === "QnA" ? "underline" : "",
                    color: "mediumpurple"
                  }}
                >
                  <span className="glyphicon glyphicon-question-sign"></span> Q&A
                </Link>
              </li>
              <li>
                <Link
                  to="/MyCourse"
                  style={{
                    textDecoration: activeSection === "MyCourse" ? "underline" : "",
                    color: "mediumpurple"
                  }}
                >
                  <span className="glyphicon glyphicon-education"></span> My Course
                </Link>
              </li>
              <li>
                <Link
                  to="/MyInstitute"
                  style={{
                    textDecoration: activeSection === "MyInstitute" ? "underline" : "",
                    color: "mediumpurple"
                  }}
                >
                  <span className="glyphicon glyphicon-home"></span> My Institute
                </Link>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </>
  );
}

export default LeftContainer;
