import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faEnvelope } from '@fortawesome/free-solid-svg-icons';
import { faGithub} from '@fortawesome/free-brands-svg-icons';
function RightContainer() {
  return (
    <div className="col-md-3" style={{ flex: '0 0 auto', borderLeft: "1px solid mediumpurple", height: "90vh", backgroundColor: "#f5f5ff" }}>
      <br />
      <div className="panel panel-default">
        <div className="panel-body">
          <div className="ad-card" style={{ height: "350px" }}>
          <div id="carousel-id" className="carousel slide" data-ride="carousel">
              <ol className="carousel-indicators">
                <li data-target="#carousel-id" data-slide-to="0" className="active"></li>
                <li data-target="#carousel-id" data-slide-to="1" className=""></li>
                <li data-target="#carousel-id" data-slide-to="2" className=""></li>
              </ol>
              <div className="carousel-inner">
                <div className="item active">
                  <img src="./data/images/Gallery1.jpg" alt="Slide 1" />
                </div>
                <div className="item">
                  <img src="./data/images/Gallery2.jpg" alt="Slide 2" />
                </div>
                <div className="item">
                  <img src="./data/images/Gallery3.jpg" alt="Slide 3" />
                </div>
              </div>
              <a className="left carousel-control" href="#carousel-id" data-slide="prev"><span className="glyphicon glyphicon-chevron-left"></span></a>
              <a className="right carousel-control" href="#carousel-id" data-slide="next"><span className="glyphicon glyphicon-chevron-right"></span></a>
            </div>
          </div>
        </div>
      </div>
      <br />
      <div className='social_media_icons' style={{ width: "100%" }}>
        <center>
          <ul className="list-inline">
            <li><a href="mailto:fas.connect3.email@gmail.com"><FontAwesomeIcon icon={faEnvelope} style={{ width: "30px", height: "30px", margin: "10px" }} /></a></li>
            <li><a href="https://github.com/FAS-Connect/FAS-Connect"><FontAwesomeIcon icon={faGithub} style={{ width: "30px", height: "30px", margin: "10px" }} /></a></li>
          </ul>
        </center>
      </div>
    </div>
  );
}

export default RightContainer;