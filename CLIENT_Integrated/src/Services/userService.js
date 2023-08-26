import axios from 'axios';
import { createUrl } from '../Utils/utils';
import { log } from '../Utils/utils';
const bearerToken = sessionStorage.getItem("jwt");

export async function getAllUsers(){
    const url = createUrl('/users')
    try{
        const response = await axios.get(url,
            {
            headers: {
              Authorization: `Bearer ${bearerToken}`
            }})
        log(response)
        return response
    }catch (ex){
        log(ex)
        return "null"
    }
}

export async function deleteStudent(userId){
    const url = createUrl(`/users/deleteStudent/${userId}`)
    try {
        const response = await axios.delete(url, {
            headers: {
                Authorization: `Bearer ${bearerToken}`
            },
            
        });
        log(response)
        return response
    }catch (ex){
        log(ex)
        return "null"
    }
}

export async function deleteFaculty(userId){
    const url = createUrl(`/users/deleteFaculty/${userId}`)
    try {
        const response = await axios.delete(url, {
            headers: {
                Authorization: `Bearer ${bearerToken}`
            },
          
        });
        log(response)
        return response
    }catch (ex){
        log(ex)
        return "null"
    }
}

export async function editFaculty(updatedData) {
    const url = createUrl('/faculty/profile'); 

    try {
        const response = await axios.put(url, updatedData);
        log(response.data);
        return response;
    } catch (ex) {
        log(ex)
        return "null";
    }
}

export async function editStudent(updatedData) {
    const url = createUrl('/student/profile/editStudent'); 
    try {
        const response = await axios.put(url, updatedData);
        log(response.data);
        return response;
    } catch (ex) {
        log(ex)
        return "null";
    }
}

export async function loginUser(updatedData) {
    const url = createUrl('/users/signin'); 

    try {
        const response = await axios.post(url, updatedData);
        log(response.data);
        return response;
    } catch (ex) {
        log(ex)
        return "null";
    }
}


export async function updateStudentPhoto(userId, studentPhoto){
    const url = createUrl(`/student/profile/image/${userId}`)
    console.log("studentPhoto",studentPhoto);
    try{
        const headers = {
            "userId" : userId,
            Authorization: `Bearer ${bearerToken}`
        }
        const body = studentPhoto 
        const response = await axios.post(url, body, { headers });
        log(response)
        return response
    }catch (ex){
        log(ex)
        return "null"
    }
}

export async function updateFacultyPhoto(userId, facultyPhoto){
    const url = createUrl(`/faculty/profile/image/${userId}`)
    try{
        const headers = {
            "userId" : userId,
            Authorization: `Bearer ${bearerToken}`
        }
        const body = facultyPhoto
        const response = await axios.post(url, body, { headers });
        log(response)
        return response
    }catch (ex){
        log(ex)
        return "null"
    }
}