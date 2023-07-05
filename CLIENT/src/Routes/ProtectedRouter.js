import { BrowserRouter as Router, Route} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from "../pages/NavBar/NavBar";
import LeftContainer from "../pages/LeftContainer/LeftContainer";
import RightContainer from "../pages/RightContainer/RightContainer";

function ProtectedRoute(props) {
    return (<>
                <Navbar/>
                <LeftContainer/>
                <Route exact path = {props.path} component = {props.component}/>
                <RightContainer/>
            </>);
}

export default ProtectedRoute;