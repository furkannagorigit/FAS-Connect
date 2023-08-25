import { useHistory } from "react-router-dom/cjs/react-router-dom.min";
import "../Feed/Feed.css"
import FeedCard from "../Feed/FeedCard";
import CreateFeed from "./CreateFeed";
import { useEffect, useState, useRef } from "react";
import { toast } from 'react-toastify';
import { getFeeds } from "../../Services/feedService";

function Feed() {

  const history = useHistory();

  const [feeds, setFeeds] = useState([])
  const [currentPage, setCurrentPage] = useState(0); // Track the current page
  const [hasMoreFeeds, setHasMoreFeeds] = useState(true); // Indicate if more feeds can be loaded

  const pageSize = 2;
  const containerRef = useRef(null); // Create a ref for the scrollable container

  const [commentBoxVisible, setCommentBoxVisible] = useState(false);
  const toggleCommentBox = () => {
    setCommentBoxVisible(!commentBoxVisible);
  };

  useEffect(() => {
    loadFeeds()
  }, [currentPage])

  const loadFeeds = async () => {
    if (!hasMoreFeeds) return;

    const response = await getFeeds(currentPage, pageSize)
    if (response['status'] === 200) {
      const newFeeds = response.data.content;
      if (!Array.isArray(newFeeds)) {
        setHasMoreFeeds(false);
        return;
      }

      if (newFeeds.length === 0) {
        setHasMoreFeeds(false); // No more feeds to load
      } else {
        setFeeds(prevFeeds => [...prevFeeds, ...newFeeds]);
        setCurrentPage(prevPage => prevPage + 1);
      }
    } else {
      toast.warning("you have reached to last post");
    }
  }
  const handleScroll = () => {
    const container = containerRef.current;
    if (container.scrollTop + container.clientHeight >= container.scrollHeight) {
      loadFeeds();
    }
  };


  const [isCreateFeedOpen, setCreateFeedOpen] = useState(false); // Add this state

  const handleButtonClick = () => {
    setCreateFeedOpen(true); // Open the CreateFeed popup
  };

  return (<>
    <div className="col-md-7" style={{ flex: '1' }}>

      <div className="main">

        <div className="input-group">
          <input type="text" class="form-control" placeholder="Search this blog" />
          <span className="input-group-addon">
            <button className="btn btn-default" type="button" style={{ height: "20px", border: "0", }}>
              <i className="glyphicon glyphicon-search" style={{ padding: "0" }}></i>
            </button>
          </span>
        </div>
      </div>

      <div className="scrollable" ref={containerRef} onScroll={handleScroll}>
      {feeds.map((feedItem, index) => (
    <FeedCard key={index} props={feedItem} />
  ))}
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