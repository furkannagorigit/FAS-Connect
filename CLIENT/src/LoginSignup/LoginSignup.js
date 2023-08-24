import React, { useState } from 'react';
import '../LoginSignup/styles.css'; // Import custom CSS file
import { useHistory, Link } from 'react-router-dom/cjs/react-router-dom.min';
import { editFaculty, editStudent,loginUser } from '../Services/userService';
import { toast } from 'react-toastify';
import { log } from '../Utils/utils';

const LoginSignup = () => {

	const [isLogin, setIsLogin] = useState(true);
	const [email, setEmail] = useState('');
	const [password, setPassword] = useState('');
	const [confirmPassword, setConfirmPassword] = useState('');
	const [isStudent, setIsStudent] = useState(true);
	const [isFaculty, setIsFaculty] = useState(false);
	const [rollNumber, setRollNumber] = useState('');
	const [dateOfBirth, setDateOfBirth] = useState('');
	const [gender, setGender] = useState('');
	const [mobile, setMobile] = useState('');
	const [firstName, setFirstName] = useState('');
	const [lastName, setLastName] = useState('');
	const [facultyId, setFacultyId] = useState(''); // Add state for facultyId

	var history = useHistory();


	const handleStudentCheckboxChange = () => {
		setIsStudent(!isStudent);
		if (isFaculty) setIsFaculty(false);
	};

	const handleFacultyCheckboxChange = () => {
		setIsFaculty(!isFaculty);
		if (isStudent) setIsStudent(false);

	};


	const handleSubmit = async (e) => {
		e.preventDefault();
		// Handle login or signup logic based on the value of isLogin
		if (isLogin) {
			console.log('Login button clicked.');
			if (isStudent) {
				const updatedData = {
					email: email,
					password: password
				}
				const response = await loginUser(updatedData)
				if (response['status'] == 200) {
					toast.success('Login successfully !')
					const {jwt,user } = response['data']
					sessionStorage['jwt'] =jwt
					sessionStorage['userId'] =user.id
					sessionStorage['firstName'] = user.firstName
					sessionStorage['lastName'] = user.lastName
					sessionStorage['dateOfBirth'] = user.dateOfBirth
					sessionStorage['gender'] = user.gender
					sessionStorage['role'] = user.role
					sessionStorage['mobile'] = user.mobile
					sessionStorage['email'] = user.email
					sessionStorage['profileImg'] = user.profileImg

					console.log(jwt)
					history.push('/Announcements');
	
				} else if (response == "null") {
					toast.error("Login failed ! check your email/Password")
				}
			}else
			{
				const updatedData = {
					email: email,
					password: password
				}
				const response = await loginUser(updatedData)
				if (response['status'] == 200) {
					toast.success('Login successfully !')
					const {jwt,user} = response['data']
					sessionStorage['jwt'] =jwt
					sessionStorage['userId'] =user.id
					sessionStorage['firstName'] = user.firstName
					sessionStorage['lastName'] = user.lastName
					sessionStorage['dateOfBirth'] = user.dateOfBirth
					sessionStorage['gender'] = user.gender
					sessionStorage['role'] = user.role
					sessionStorage['mobile'] = user.mobile
					sessionStorage['email'] = user.email
					sessionStorage['profileImg'] = user.profileImg
					history.push('/Announcements');
	
				} else if (response == "null") {
					toast.error("Login failed ! check your email/Password")
				}
			}
			
			/*Have to update with userid */
		} else {
			console.log('Signup button clicked.');
			if (isStudent) {
				const updatedData = {
					rollNo: rollNumber,
					user: {
						firstName: firstName,
						lastName: lastName,
						dateOfBirth: dateOfBirth,
						gender: gender,
						role: "STUDENT",
						mobile: mobile,
						email: email,
						password: password,

					}
				};
				const response = await editStudent(updatedData)
				if (response['status'] == 200) {
					toast.success('Registration Done !')

				} else if (response == "null") {
					toast.error("Registration failed ! check your roll number/email")
				}
			} else {
				const updatedData = {
					facultyId: facultyId,
					user: {
						firstName: firstName,
						lastName: lastName,
						dateOfBirth: dateOfBirth,
						gender: gender,
						role: "FACULTY",
						mobile: mobile,
						email: email,
						password: password,

					}
				};
				const response = await editFaculty(updatedData)
				if (response['status'] == 200) {
					toast.success('Registration Done !')
					window.location.reload();

				} else if (response == "null") {
					toast.error("Registration failed ! check your roll number/email")
				}
			}

		}
	};
	// Password Validation Functions
	const isPasswordValid = (password) => {
		const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
		return passwordRegex.test(password);
	};
	const isPasswordConfirmed = () => {
		return password === confirmPassword;
	};



	return (
		<div className="centered-container">
			<div className="row justify-content-center">
				<div className="col-md-6 col-sm-8 col-xs-12">
					<div className="login-signup-form">
						<h2 className="text-center mb-4">{isLogin ? 'Login' : 'Signup'}</h2>
						<div className="form-group">
							<div className="form-check">
								<input
									type="checkbox"
									className="form-check-input"
									id="studentCheckbox"
									checked={isStudent}
									onChange={handleStudentCheckboxChange}
								/>
								<label className="form-check-label" htmlFor="studentCheckbox">
									student
								</label>
							</div>
							<div className="form-check">
								<input
									type="checkbox"
									className="form-check-input"
									id="facultyCheckbox"
									checked={isFaculty}
									onChange={handleFacultyCheckboxChange}
								/>
								<label className="form-check-label" htmlFor="facultyCheckbox">
									faculty
								</label>
							</div>
						</div>

						{isLogin ? (
							// Login Form
							<form onSubmit={handleSubmit}>
								{/* Render the appropriate input fields based on the checkbox selection */}
								{isStudent && (
									<div className="form-group">
										<label htmlFor="email">Email</label>
										<input
											type="text"
											className="form-control"
											id="email"
											value={email}
											onChange={(e) => setEmail(e.target.value)}
											placeholder="Enter Email"
										/>
										<small className="form-text text-muted">
											Enter the valid Email you received in the mail from our side.
										</small>
									</div>
								)}

								{isFaculty && (
										<div className="form-group">
										<label htmlFor="email">Email</label>
										<input
											type="text"
											className="form-control"
											id="email"
											value={email}
											onChange={(e) => setEmail(e.target.value)}
											placeholder="Enter Email"
										/>
										<small className="form-text text-muted">
											Enter the valid Email you received in the mail from our side.
										</small>
									</div>
									)
								}

							</form>
						) : (
							// Signup Form
							<form onSubmit={handleSubmit}>
								{isStudent && (
									<div>
										{/* Student Signup Fields */}
										<div className="form-group">
											<label htmlFor="rollNumber">Roll Number</label>
											<input
												type="text"
												className="form-control"
												id="rollNumber"
												value={rollNumber}
												onChange={(e) => setRollNumber(e.target.value)}
												placeholder="Enter Roll Number"
											/>
											<small className="form-text text-muted">
												Enter the valid Roll Number you received in the mail from our side.
											</small>
										</div>


									</div>
								)}

								{isFaculty && (
									<div>
										{/* Faculty Signup Fields */}
										<div className="form-group">
											<label htmlFor="facultyId">Faculty ID</label>
											<input
												type="text"
												className="form-control"
												id="facultyId"
												value={facultyId}
												onChange={(e) => setFacultyId(e.target.value)}
												placeholder="Enter Faculty ID"
											/>
										</div>

									</div>
								)}


								<div className="form-group">
									<label htmlFor="firstName">First Name</label>
									<input
										type="text"
										className="form-control"
										id="firstName"
										value={firstName}
										onChange={(e) => setFirstName(e.target.value)}
										placeholder="Enter First Name"
									/>
								</div>
								<div className="form-group">
									<label htmlFor="lastName">Last Name</label>
									<input
										type="text"
										className="form-control"
										id="lastName"
										value={lastName}
										onChange={(e) => setLastName(e.target.value)}
										placeholder="Enter Last Name"
									/>
								</div>

								<div className="form-group">
									<label htmlFor="dateOfBirth">Date of Birth</label>
									<input
										type="text"
										className="form-control"
										id="dateOfBirth"
										value={dateOfBirth}
										onChange={(e) => setDateOfBirth(e.target.value)}
										placeholder="YYYY-MM-DD"
									/>
									<small className="form-text text-muted">
										Enter your date of birth in the format YYYY-MM-DD.
									</small>
								</div>

								<div className="form-group">
									<label>Gender</label>
									<div className="form-check">
										<input
											type="radio"
											className="form-check-input"
											id="male"
											name="gender"
											value="MALE"
											checked={gender === "MALE"}
											onChange={(e) => setGender(e.target.value)}
										/>
										<label className="form-check-label" htmlFor="male">Male</label>
									</div>
									<div className="form-check">
										<input
											type="radio"
											className="form-check-input"
											id="female"
											name="gender"
											value="FEMALE"
											checked={gender === "FEMALE"}
											onChange={(e) => setGender(e.target.value)}
										/>
										<label className="form-check-label" htmlFor="female">Female</label>
									</div>
								</div>

								<div className="form-group">
									<label htmlFor="mobile">Mobile Number</label>
									<input
										type="tel"
										className="form-control"
										id="mobile"
										value={mobile}
										onChange={(e) => setMobile(e.target.value)}
										placeholder="Enter Mobile Number"
									/>
								</div>


								<div className="form-group">
									<label htmlFor="email">Email</label>
									<input
										type="text"
										className="form-control"
										id="email"
										value={email}
										onChange={(e) => setEmail(e.target.value)}
										placeholder="Enter Email"
									/>
									<small className="form-text text-muted">
										Enter the valid email address received in the mail from our side.
									</small>
								</div>


								{/* ... (rest of the code) */}
							</form>
						)}
						<div className="form-group">
							<label htmlFor="password">Password</label>
							<input
								type="password"
								className="form-control"
								id="password"
								value={password}
								onChange={(e) => setPassword(e.target.value)}
								required
								placeholder='Enter password'
							/>
							<small className={`form-text ${isPasswordValid(password) ? 'text-muted' : 'text-danger'}`}>
								Password must be at least 8 characters long and should contain at least one uppercase letter, one lowercase letter, one digit, and one special character.
							</small>
						</div>

						{!isLogin && (
							<div className="form-group">
								<label htmlFor="confirmPassword">Confirm Password</label>
								<input
									type="password"
									className="form-control"
									id="confirmPassword"
									value={confirmPassword}
									onChange={(e) => setConfirmPassword(e.target.value)}
									placeholder="Confirm Password"
								/>

								{!isPasswordConfirmed() && (
									<small className="form-text text-danger">Passwords do not match.</small>
								)}
							</div>
						)}






						<button
							type="button"
							className="btn btn-primary btn-block mt-3"
							onClick={handleSubmit}
						>
							{isLogin ? 'Login' : 'Signup'}
						</button>




						<p className="text-center mt-3">
							{isLogin
								? "Don't have an account? "
								: 'Already have an account? '}
							<button
								type="button"
								className="btn btn-link btn-sm"
								onClick={() => setIsLogin(!isLogin)}
							>
								{isLogin ? 'Signup here' : 'Login here'}
							</button>
						</p>
















					</div>
				</div>
			</div>
		</div>
	);


}

export default LoginSignup;