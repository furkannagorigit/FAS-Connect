import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFacebookF, faTwitter, faInstagram, faPinterest } from '@fortawesome/free-brands-svg-icons';

function RightContainer(){
    return (<>
        <div className="col-md-3" style={{ flex: '0 0 auto', borderLeft: "1px solid mediumpurple", height: "90vh" , backgroundColor:"#f5f5ff"}}>
            <br/>
            <div className="panel panel-default">
              <div className="panel-body">
                <div className="ad-card" style={{height:"350px"}}>
                  
                  <div id="carousel-id" class="carousel slide" data-ride="carousel">
                      <ol class="carousel-indicators">
                          <li data-target="#carousel-id" data-slide-to="0" class=""></li>
                          <li data-target="#carousel-id" data-slide-to="1" class=""></li>
                          <li data-target="#carousel-id" data-slide-to="2" class="active"></li>
                      </ol>
                      <div class="carousel-inner">
                          <div class="item">
                              <img src="./data/images/ad1.jpg"/>
                          </div>
                          <div class="item">
                          <img src="./data/images/ad1.jpg"/>
                          <div class="container">
                                  <div class="carousel-caption">
                                      <h3>Another example headline.</h3>
                                      <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                      <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
                                  </div>
                              </div>
                          </div>
                          <div class="item active">
                          <img src="./data/images/ad1.jpg"/>
                          <div class="container">
                                  <div class="carousel-caption">
                                      <h3>One more for good measure.</h3>
                                      <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                      <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <a class="left carousel-control" href="#carousel-id" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
                      <a class="right carousel-control" href="#carousel-id" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                  </div>
                </div>
              </div>
            </div>
            <br/>
            <div className='social_media_icons' style={{width:"100%"}}>
            <center>
            <ul class="list-inline">
                <li ><a href="#" ><FontAwesomeIcon icon={faFacebookF} style={{width:"30px", height:"30px", margin:"10px"}}/></a></li>
                <li ><a href="#"><FontAwesomeIcon icon={faTwitter}  style={{width:"30px", height:"30px", margin:"10px"}}/></a></li>
                <li ><a href="#"><FontAwesomeIcon icon={faInstagram} style={{width:"30px", height:"30px", margin:"10px"}}/></a></li>
                <li ><a href="#"><FontAwesomeIcon icon={faPinterest} style={{width:"30px", height:"30px", margin:"10px"}}/></a></li>
            </ul>
            </center>
          </div>
          </div>
    </>);
}

export default RightContainer;