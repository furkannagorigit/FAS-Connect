import { getAnnouncements } from '../../Services/announcementService';
import '../Announcements/Announcements.css';
import AnnouncementsCard from '../Announcements/AnnouncementsCard';
import CreateAnnouncement from "./CreateAnnouncement";
import { useEffect, useState } from "react";

import { toast } from 'react-toastify';


function Announcements() {

  const role = sessionStorage.getItem("role")
  const [isCreateAnnouncementOpen, setCreateAnnouncementOpen] = useState(false); // Add this state

  const [announcements, setAnnoncements] = useState([])

  useEffect(() => {
    loadAnnouncements()
  }, [])

  const loadAnnouncements = async () => {
    const response = await getAnnouncements()
    if (response['status'] === 200) {
      setAnnoncements(response['data'])
    } else {
      toast.error('Error while calling get /annoncements api')
    }
  }


  const handleButtonClick = () => {
    setCreateAnnouncementOpen(true); // Open the CreateFeed popup
  };

  return (<>
    <div className="col-md-7" style={{ flex: '1' }}>

      <div class="main">

        <div class="input-group">
          <input type="text" class="form-control" placeholder="Search Announcements" />
          <span class="input-group-addon">
            <button class="btn btn-default" type="button" style={{ height: "20px", border: "0", }}>
              <i class="glyphicon glyphicon-search" style={{ padding: "0" }}></i>
            </button>
          </span>
        </div>
      </div>

      <div className="scrollable">
        {announcements.map((announcement, index) => (
          <AnnouncementsCard key={index} props={announcement} />
        ))}
        {role=="FACULTY"&&
         <button className="floating-button" onClick={handleButtonClick}>
         Add Announcement
       </button> 
        }

      </div>
    </div>
    {/* Show the CreateFeed popup when isCreateFeedOpen is true */}
    {isCreateAnnouncementOpen && (
      <div className="popup-overlay">
        <div className="popup">
          <CreateAnnouncement />
          <button
            className="close-popup-button"
            onClick={() => setCreateAnnouncementOpen(false)}
          >
            &times; {/* Use the &times; HTML entity for the "x" symbol */}
          </button>
        </div>
      </div>
    )}
  </>);
}

export default Announcements;