import { BrowserRouter as Router, Route,Redirect} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from "../NavBar/NavBar";

import LeftContainer from "../pages/LeftContainer/LeftContainer";
import RightContainer from "../pages/RightContainer/RightContainer";

function isTokenValid() {
    const token = sessionStorage.getItem("jwt");
    // You should also validate the token's expiration and integrity
    return token !== null;
  }
  function ProtectedRoute(props) {
    if (isTokenValid()) {
      return (
        <>
          <Navbar />
          <LeftContainer />
          <Route exact path={props.path} component={props.component} />
          <RightContainer />
        </>
      );
    } else {
        console.log("came to redirect");
      return <Redirect to="/LoginSignup" />;
    }
  }
  

export default ProtectedRoute;