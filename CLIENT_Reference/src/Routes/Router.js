import { BrowserRouter as Router, Route } from "react-router-dom";
import { Switch } from "react-router-dom/cjs/react-router-dom.min";
import LandingPage from "../LandingPage/LandingPage";
import LoginSignup from "../LoginSignup/LoginSignup";
import ProtectedRoute from "./ProtectedRouter";
import Feed from "../pages/Feed/Feed";
import Announcements from "../pages/Announcements/Announcements";
import QnA from "../pages/QnA/QnA";
import MyCourse from "../pages/MyCourse/MyCourse";
import MyInstitute from "../pages/MyInstitute/MyInstitute";
import Admin from "../pages/Admin/Admin";
import MyProfile from "../pages/Profile/Profile";
import EditProfile from "../pages/Profile/EditProfile";
import CreateFeed from "../pages/Feed/CreateFeed"
import AddUsers from "../pages/Admin/AddUser";

function PageController() {
    return (

        <Router>
            <Route exact path="/" component={LandingPage} />
            <Route exact path="/LoginSignup" component={LoginSignup} />
            <Switch>
                <ProtectedRoute exact path="/Admin" component={Admin} />
                <ProtectedRoute exact path="/Admin/AddUsers" component={AddUsers} />
                <ProtectedRoute exact path="/Announcements" component={Announcements} />
                <ProtectedRoute exact path="/Feed" component={Feed} />
                <ProtectedRoute exact path="/Feed/CreateFeed" component={CreateFeed} />
                <ProtectedRoute exact path="/QnA" component={QnA} />
                <ProtectedRoute exact path="/MyCourse" component={MyCourse} />
                <ProtectedRoute exact path="/MyInstitute" component={MyInstitute} />
                <ProtectedRoute exact path="/MyProfile" component={MyProfile}/>
                <ProtectedRoute exact path="/EditProfile" component={EditProfile}/>
            </Switch>
        </Router>
    );
}

export default PageController;