import { useHistory } from 'react-router-dom/cjs/react-router-dom.min';

function Navbar() {
        const history = useHistory();
        const handleLogout = () => {
     sessionStorage.removeItem('jwt');
        sessionStorage.removeItem('userId');
        sessionStorage.removeItem('firstName');
        sessionStorage.removeItem('lastName');
        sessionStorage.removeItem('dateOfBirth');
        sessionStorage.removeItem('gender');
        sessionStorage.removeItem('role');
        sessionStorage.removeItem('mobile');
        sessionStorage.removeItem('email');
        sessionStorage.removeItem('profileImg');
        history.push("/")
        };
    return (<>
        {/* Navbar */}
        <nav className="navbar navbar-default" style={{ backgroundColor: '#e6e6fa' }}>
            <div className="container-fluid">
                <div className="navbar-header">
                    <button
                        type="button"
                        className="navbar-toggle collapsed"
                        data-toggle="collapse"
                        data-target="#navbar-collapse"
                        aria-expanded="false"
                        style={{ border: 'none', backgroundColor: '#e6e6fa' }}
                    >
                        <span className="sr-only">Toggle navigation</span>
                        <span className="icon-bar" style={{ backgroundColor: '#9370db' }}></span>
                        <span className="icon-bar" style={{ backgroundColor: '#9370db' }}></span>
                        <span className="icon-bar" style={{ backgroundColor: '#9370db' }}></span>
                    </button>
                    <a className="navbar-brand" href="/Announcements" style={{ color: '#9370db' }}>
                        <img
                            src="./data/images/Logo.png"
                            alt="Logo"
                            style={{ height: '40px', marginTop: '-6%', mixBlendMode: 'multiply' }}
                        />
                    </a>
                </div>
                <div className="collapse navbar-collapse" id="navbar-collapse">
                    <ul className="nav navbar-nav navbar-right">
                        <li>
                            <a href="/Announcements" style={{ color: '#9370db' }}>
                                <span className="glyphicon glyphicon-link"></span> Home
                            </a>
                        </li>
                       
                        <li className="dropdown">
                            <a href="#" className="dropdown-toggle" data-toggle="dropdown">
                                <img src="./data/images/read_male.png" alt="Profile" className="img-circle"
                                    style={{ height: "5vh", border: "solid", color: "#9370db", marginTop: "-30%", marginBottom: "-30%" }} />
                            </a>
                            <ul className="dropdown-menu">
                                <li>
                                    <a href="MyProfile" style={{ color: '#9370db' }}>
                                        View Profile
                                    </a>
                                </li>
                                <li>
                                    <a href="FAQ" style={{ color: '#9370db' }}>
                                        FaQ
                                    </a>
                                </li>
                                
                                <li>
                                    <a href="/" style={{ color: '#9370db' }} onClick={handleLogout}>
                                        Log Out
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </>);
}

export default Navbar;