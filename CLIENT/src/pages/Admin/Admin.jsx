import { toast } from 'react-toastify';
import { useEffect, useState} from 'react';
import './styles.css';
import UserCard from './UserCard';
import { getAllUsers, deleteStudent, deleteFaculty} from '../../Services/userService';
import { Link, useHistory } from 'react-router-dom'
import { log } from '../../Utils/utils';

function Admin() {

    const [users, setUsers] = useState([])
    
    const history = useHistory();

    const onDelete = async (id, role)=>{
        console.log("onDelete called: ",id, role);
        if(role=="FACULTY"){
            log("deleteFaculty")
            const response = await deleteFaculty(id)
            if (response['status'] == 200) {
                log(response)
              } else {
                toast.error('Error while calling DELETE: /deleteFaculty api')
              }
        }
        else{
            log("deleteStudent")
            log("deleteFaculty")
            const response = await deleteStudent(id)
            if (response['status'] == 200) {
                log(response)
              } else {
                toast.error('Error while calling get DELETE: /deleteStudent api')
              }
        }
        loadUsers()
    }
    const loadUsers = async () =>{
      const response = await getAllUsers()
      if (response['status'] == 200) {
        setUsers(response.data)
      } else {
        toast.error('Error while calling get /users api')
      }
    }

    const [searchText, setSearchText] = useState("");

    useEffect(() => {
        console.log("Inside COmponent Did Mount")
        loadUsers()
        console.log("Users:",users)
    }, [])

    const [role, setRole] = useState('student');

    const onSearch = (args) => {
        setSearchText(args.target.value);
    }


    const handleRoleChange = (event) => {
        setRole(event.target.value);
        if(role==="student")
        {
            console.log(role);
            setSearchText("student")
        }
        else if(role==="faculty")
        {
            console.log(role);
            setSearchText("faculty")
        }
        else
        {
          setSearchText("u")
        }
    };
  
    return (<>
        <div className="col-md-7 " style={{ flex: '1' }}>
            <h2 >Admin Manager</h2>
            <input type="search" name="" id="input" class="form-control"
                required="required" placeholder="search.." style={{ width: "20%" }}
                onChange={onSearch} />

            <div className="radio">
                <label>
                    <input
                        type="radio"
                        name="role"
                        value="student"
                        checked={role === 'student'}
                        onChange={handleRoleChange}
                    />
                    Faculty
                </label>
            </div>
            <div className="radio">
                <label>
                    <input
                        type="radio"
                        name="role"
                        value="faculty"
                        checked={role === 'faculty'}
                        onChange={handleRoleChange}
                    />
                    Student
                </label>
            </div>

            <button type="button" class="btn btn-primary" onClick={()=>history.push('/Admin/AddUsers')}>Add Users</button>
           
            <div className="scrollable" style={{height:"60%"}}>
            <table className="table table-hover table-responsive" style={{ margin: 50 }}>
                <thead>
                    <tr>
                        <th>user Id</th>
                        <th>User Name</th>
                        <th>Student/Faculty</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map((user) => {
                        console.log("user")
                        {
                            if (searchText != "") {
                                if (user.firstName.toLowerCase().includes(searchText.toLowerCase())
                                    || user.lastName.toLowerCase().includes(searchText.toLowerCase())
                                    || user.role.toLowerCase().includes(searchText.toLowerCase())){
                                    return <UserCard
                                        key={user.id} 
                                        user={user}
                                        onDelete={onDelete}
                                    />
                                }
                                else {
                                    return;
                                }
                            }
                            else {
                                return <UserCard
                                    key={user.id}
                                    user={user}
                                    onDelete={onDelete}
                                />;
                            }
                        }
                    }
                    )}
                </tbody>
            </table>
            </div>
        </div>
    </>);
}

export default Admin;