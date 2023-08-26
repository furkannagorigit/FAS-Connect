import axios from 'axios';
import { createUrl } from '../Utils/utils';
import { log } from '../Utils/utils';
const bearerToken = sessionStorage.getItem("jwt");

export async function getAllCourses(){
    const url = createUrl('/course/allCourse')
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

export async function getAllMarks(studentId){
    const url = createUrl(`/users/marks/getMarks/${studentId}`)
    const headers = {
        "userId": studentId
    }
    try{
        const response = await axios.get(url, headers)
        log(response)
        return response
    }catch (ex){
        log(ex)
        return "null"
    }
}