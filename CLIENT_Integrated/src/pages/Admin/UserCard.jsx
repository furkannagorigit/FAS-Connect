function UserCard(props) {

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