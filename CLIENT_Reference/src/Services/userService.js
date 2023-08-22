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