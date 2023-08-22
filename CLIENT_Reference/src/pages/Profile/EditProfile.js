
import React from 'react';
import { useHistory } from 'react-router-dom/cjs/react-router-dom.min';
// import '/home/sunbeam/Downloads/CLIENT(1)/CLIENT/src/pages/Profile/Profile.css';
import "./Profile.css"
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css'
const EditProfile = () => {
    const history = useHistory();
    return (
        <div className="col-md-7 scrollable" style={{ flex: '1'}}>
            <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
            <div class="container bootstrap snippets bootdeys col-md-12">
                <div class="row col-md-12">
                    <div class="col-md-12">
                        <form class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-body text-center">
                                    <img src="./data/images/write_male.png" class="img-circle profile-avatar" alt="User avatar" />
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">User info</h4>
                                </div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">First Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Last Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">DOB</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Gender</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Roll Number</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Course ID</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">Contact info</h4>
                                </div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Mobile number</label>
                                        <div class="col-sm-10">
                                            <input type="tel" class="form-control" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">E-mail address</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Home address</label>
                                        <div class="col-sm-10">
                                            <textarea rows="3" class="form-control"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">Security</h4>
                                </div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Current password</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">New password</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-10 col-sm-offset-2">
                                            <div class="checkbox">
                                                <input type="checkbox" id="checkbox_1" />
                                                <label for="checkbox_1">Make this account public</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-10 col-sm-offset-2">
                                            <button type="submit" class="btn btn-primary">Submit</button>
                                            <button type="reset" class="btn btn-default">Cancel</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            
            <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
            <script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
            <script type="text/javascript">

            </script>
        </div>
    );
}

export default EditProfile;