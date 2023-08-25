import { useEffect, useState } from "react";
import "../QnA/QnA.css"
import QnACard from "./QnACard";
import CreateQnA from "./CreateQnA"
import { getAllQnAs } from "../../Services/QnAService";
import { log } from "../../Utils/utils";
import { toast } from "react-toastify";

function QnA() {

  const [qnas, setQnas] = useState([])

  //Load list of QnAs
  const loadQnas = async () =>{
    const response = await getAllQnAs()
    if (response['status'] == 200) {
      log(response.data)
      setQnas(response.data)
    } else if(response == "null")
    {
      toast.error('Could not fetch list of qnas')
    }
  }

  //View list of users on loading component
  useEffect(() => {
    log(qnas)
    loadQnas()
}, [])

  const [isCreateQnAOpen, setCreateQnAOpen] = useState(false); // Add this state

  const handleButtonClick = () => {
    // Your button click functionality goes here
    setCreateQnAOpen(true);
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
          {
            qnas.map((qna)=>{
              return <QnACard
                        qna={qna}
                    />
            })
          }
        <button className="floating-button" onClick={handleButtonClick}>
        Ask a Question
      </button>
      </div>
    </div>

    {/* Show the CreateFeed popup when isCreateFeedOpen is true */}
  {isCreateQnAOpen && (
        <div className="popup-overlay">
          <div className="popup">
            <CreateQnA />
            <button
              className="close-popup-button"
              onClick={() => setCreateQnAOpen(false)}
            >
              &times; {/* Use the &times; HTML entity for the "x" symbol */}
            </button>
          </div>
        </div>
  )}
  </>);
}

export default QnA;