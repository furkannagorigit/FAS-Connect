import { toast } from 'react-toastify';
import { useEffect, useState} from 'react';
import './styles.css';
import UserCard from './UserCard';
import { getAllUsers, deleteStudent, deleteFaculty} from '../../Services/userService';
import { useHistory } from 'react-router-dom'
import { log } from '../../Utils/utils';

function Admin() {

    const [users, setUsers] = useState([])
    
    const history = useHistory();

    //Load list of users
    const loadUsers = async () =>{
      const response = await getAllUsers()
      if (response['status'] == 200) {
        log(response.data)
        setUsers(response.data)
      } else if(response == "null")
      {
        toast.error('Could not fetch list of users')
      }
    }

    //View list of users on loading component
    useEffect(() => {
        loadUsers()
    }, [])

    const deleteUser = async (id, role)=>{
        console.log("onDelete called: ",id, role);
        if(role=="FACULTY"){
            log("deleteFaculty")
            const response = await deleteFaculty(id);
            if (response['status'] == 200) {
                log(response)
                toast.success('Student deleted successfully')
              } 
            else if(response == "null")
            {
                toast.error('Something went wrong')
            }
        }
        else{
            log("deleteStudent")
            const response = await deleteStudent(id);
            if (response['status'] == 200) {
                log(response)
                toast.success('Student deleted successfully')
              }
            else if(response == "null")
            {
                toast.error('Something went wrong')
            }
        }
        loadUsers()
    }

    //Search and filter

    const [searchText, setSearchText] = useState("");

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

            <button type="button" class="btn btn-primary" onClick={()=>history.push('/Admin/AddStudent')}>Add Students</button>
           
            <button type="button" class="btn btn-primary" onClick={()=>history.push('/Admin/AddFaculty')}>Add Faculty</button>
           
            <div className="col-md-12" style={{ flex: '1' }}>
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
                        {
                            if (searchText != "") {
                                if (user.firstName.toLowerCase().includes(searchText.toLowerCase())
                                    || user.lastName.toLowerCase().includes(searchText.toLowerCase())
                                    || user.role.toLowerCase().includes(searchText.toLowerCase())){
                                    return <UserCard
                                        key={user.id} 
                                        user={user}
                                        onDelete={deleteUser}
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
                                    onDelete={deleteUser}
                                />;
                            }
                        }
                    }
                    )}
                </tbody>
            </table>
            </div>
            </div>
        </div>
    </>);
}

export default Admin;