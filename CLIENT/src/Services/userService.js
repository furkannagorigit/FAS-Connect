import axios from 'axios';
import { createUrl } from '../Utils/utils';
import { log } from '../Utils/utils';

export async function getAllUsers(){
    const url = createUrl('/users')
    try{
        const response = await axios.get(url)
        log(response)
        return response
    }catch (ex){
        log(ex)
        return null
    }
}

export async function deleteStudent(userId){
    const url = createUrl('/deleteStudent')
    const headers = {
                        "userId": userId
                    }
    try{
        const response = await axios.delete(url, headers)
        log(response)
        return response
    }catch (ex){
        log(ex)
        return null
    }
}

export async function deleteFaculty(userId){
    const url = createUrl('/deleteFaculty')
    const headers = {
                        "userId": userId
                    }
    try{
        const response = await axios.delete(url, headers)
        log(response)
        return response
    }catch (ex){
        log(ex)
        return null
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
