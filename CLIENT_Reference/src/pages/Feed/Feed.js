import { useHistory } from "react-router-dom/cjs/react-router-dom.min";
import "../Feed/Feed.css"
import FeedCard from "../Feed/FeedCard";
import { useState } from "react";
import CreateFeed from "./CreateFeed";

function Feed(){

  const history = useHistory();

  // const handleButtonClick = () => {
  //   // Your button click functionality goes here
  //   console.log('Button clicked!');
  //   history.push('/Feed/CreateFeed')

  // };

  const [isCreateFeedOpen, setCreateFeedOpen] = useState(false); // Add this state

  const handleButtonClick = () => {
    setCreateFeedOpen(true); // Open the CreateFeed popup
  };

    return (<>
    <div className="col-md-7" style={{ flex: '1' }}>
    
    <div className="main">
  
    <div className="input-group">
    <input type="text" class="form-control" placeholder="Search this blog"/>
    <span className="input-group-addon">
      <button className="btn btn-default" type="button" style={{height:"20px", border:"0", }}>
        <i className="glyphicon glyphicon-search" style={{padding:"0"}}></i>
      </button>
    </span>
  </div>
</div>    

  <div className="scrollable">
  <FeedCard/>
  <FeedCard/>
  <FeedCard/>
  <FeedCard/>
  <FeedCard/>

  <button className="floating-button" onClick={handleButtonClick}>
        Post your thoughts
      </button>
  </div>
  </div>

  {/* Show the CreateFeed popup when isCreateFeedOpen is true */}
  {isCreateFeedOpen && (
        <div className="popup-overlay">
          <div className="popup">
            <CreateFeed />
            <button
              className="close-popup-button"
              onClick={() => setCreateFeedOpen(false)}
            >
              &times; {/* Use the &times; HTML entity for the "x" symbol */}
            </button>
          </div>
        </div>
  )}
  </>);
}

export default Feed;