import { useHistory } from "react-router-dom/cjs/react-router-dom.min";

function UserCard(props) {
    var history = useHistory();
    
    const {onDelete} = props.onDelete;

    return <>

        <tr>
            <td>
                {props.user.id}
            </td>
            <td>
                {props.user.firstName} {props.user.lastName}
            </td>
            <td>
                {props.user.role}
            </td>
            <td>
            <button type="button" onClick={()=>props.onDelete(props.user.id, props.user.role)} className="btn btn-primary">Delete</button>
            </td>
        </tr>
    </>
}
export default UserCard;