import '../Announcements/Announcements.css';
import AnnouncementsCard from '../Announcements/AnnouncementsCard';

function Announcements(){
  const handleButtonClick = () => {
    // Your button click functionality goes here
    console.log('Button clicked!');
  };

    return (<>    
    <div className="col-md-7" style={{ flex: '1' }}>
    
    <div class="main">
  
    <div class="input-group">
    <input type="text" class="form-control" placeholder="Search Announcements"/>
    <span class="input-group-addon">
      <button class="btn btn-default" type="button" style={{height:"20px", border:"0", }}>
        <i class="glyphicon glyphicon-search" style={{padding:"0"}}></i>
      </button>
    </span>
  </div>
</div>
    

  <div className="scrollable">
  <AnnouncementsCard/>
  <AnnouncementsCard/>
  <AnnouncementsCard/>
  <AnnouncementsCard/>
  <AnnouncementsCard/>
  <AnnouncementsCard/>

  <button className="floating-button" onClick={handleButtonClick}>
        Add Announcement
      </button>

  </div>
  </div>
  </>);
}

export default Announcements;