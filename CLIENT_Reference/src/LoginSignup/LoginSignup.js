import React, { useState } from 'react';
import '../LoginSignup/styles.css'; // Import custom CSS file
import { useHistory } from 'react-router-dom/cjs/react-router-dom.min';

const LoginSignup = () => {

	const [isLogin, setIsLogin] = useState(true);
	const [email, setEmail] = useState('');
	const [password, setPassword] = useState('');
	const [confirmPassword, setConfirmPassword] = useState('');
	const [isStudent, setIsStudent] = useState(true);
	const [isFaculty, setIsFaculty] = useState(false);
	const [rollNumber, setRollNumber] = useState('');
	const [firstName, setFirstName] = useState('');
	const [lastName, setLastName] = useState('');
	const [course, setCourse] = useState('');
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


	const handleSubmit = (e) => {
		e.preventDefault();
		// Handle login or signup logic based on the value of isLogin
		if (isLogin) {
			console.log('Login button clicked.');
			// Handle login logic here
			history.push('/Announcements');
			/*Have to update with userid */
		} else {
			console.log('Signup button clicked.');
			// Handle signup logic here
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
								)}

								{isFaculty && (
									<div className="form-group">
										<label htmlFor="facultyId">Faculty ID</label>
										<input
											type="text"
											className="form-control"
											id="facultyId"
											value={email}
											onChange={(e) => setFacultyId(e.target.value)}
											placeholder="Enter Faculty ID"
										/>
										<small className="form-text text-muted">
											Enter the valid Faculty ID you received in the mail from our side.
										</small>
									</div>
								)}

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

										<div className="form-group">
											<label htmlFor="course">Course</label>
											<select
												className="form-control"
												id="course"
												value={course}
												onChange={(e) => setCourse(e.target.value)}
											>
												<option value="">Select Course</option>
												<option value="PG-DAC">PG-DAC</option>
												<option value="PG-DMC">PG-DMC</option>
												<option value="PG-DBDA">PG-DBDA</option>
												<option value="PG-DITISS">PG-DITISS</option>
											</select>
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
									<label htmlFor="rollNumber">Email</label>
									<input
										type="text"
										className="form-control"
										id="rollNumber"
										value={email}
										onChange={(e) => setEmail(e.target.value)}
										placeholder="Enter Email"
									/>
									<small className="form-text text-muted">
										Enter the valid email address.
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







						<button type="submit" className="btn btn-primary btn-block mt-3">
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