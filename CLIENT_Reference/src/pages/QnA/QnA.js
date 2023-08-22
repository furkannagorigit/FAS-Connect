import "../QnA/QnA.css"
import QnACard from "../QnA/QnACard";

function QnA() {

  const handleButtonClick = () => {
    // Your button click functionality goes here
    console.log('Button clicked!');
  };

  return (<>
    <div className="col-md-7" style={{ flex: '1' }}>

      <div class="main">

        <div class="input-group">
          <input type="text" class="form-control" placeholder="Search Questions and answers" />
          <span class="input-group-addon">
            <button class="btn btn-default" type="button" style={{ height: "20px", border: "0", }}>
              <i class="glyphicon glyphicon-search" style={{ padding: "0" }}></i>
            </button>
          </span>
        </div>
      </div>

      <div className="scrollable">
        <QnACard/>
        <QnACard/>
        <QnACard/>
        <QnACard/>
        <QnACard/>
        <QnACard/>

        <button className="floating-button" onClick={handleButtonClick}>
        Ask a Question
      </button>

      </div>
    </div>
  </>);
}

export default QnA;