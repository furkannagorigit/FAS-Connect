import axios from 'axios';
import { createUrl } from '../Utils/utils';
import { log } from '../Utils/utils';

export async function getAllFeed(){
    const url = createUrl('/feed')

    try{
        const response = await axios.get(url)
        console.log(response.data)
        return response.data
    }catch (ex){
        console.log(ex)
        return null
    }
}