import { useEffect,useState } from "react";
import { useHistory } from "react-router-dom/cjs/react-router-dom";
import CourseCard from "./CourseCard";
import { getAllCourses } from "../../Services/CourseService";
import { toast } from "react-toastify";

function AddStudent() {

  const [courses, setCourses] = useState([])

  const history = useHistory();

  //Load list of courses
  const loadCourses = async ()=> {
    const response = await getAllCourses()
    if(response['status'] = 200){
      (setCourses(response.data));
    }
    else{
      toast.error("Error while calling GET /courses api")
    }
  }

  //View list of users on loading component
  useEffect(() => {
    console.log("Inside COmponent Did Mount")
    loadCourses()
    console.log("courses:",courses)
  }, [])

    return (
        <div className="col-md-7 scrollable" style={{ flex: '1' }}>
          
            <h1>Add Students Coursewise</h1>
            <hr></hr>

            {courses.map((course)=>{
                return <CourseCard
                          key={course.id}
                          course = {course}
                />
            })}
            </div>
    );
}

export default AddStudent;