function AddUser() {
    return (
        <div className="col-md-7" style={{ flex: '1' }}>

            {/* <div className="col-md-6" style={{ flex: '1' }}>

                <h1>Add Students file</h1>
                <input type="file" accept=".ods" onChange={handleFileChange} />
               
            </div> */}
            <div className="col-md-6" style={{ flex: '1' }}>                    
                    <button type="button" class="btn btn-primary">Add Student</button>
                    </div>
            <div className="col-md-6" style={{ flex: '1' }}>                    
                    <button type="button" class="btn btn-primary">Add Faculty</button>
            </div>
            <hr></hr><hr></hr><hr></hr>


            <div className='col-md-4'>
              <div className='card'>
                <img
                  style={{ height: 100 }}
                  alt=''
                />
                <div className='card-body'>
                  <h5 className='card-title'>DAC</h5>
                  <div className='card-text'>
                    <div>Add students to Course 1</div>
                  </div>
                </div>
              </div>
            </div>

            <div className='col-md-4'>
              <div className='card'>
                <img
                  style={{ height: 100 }}
                  alt=''
                />
                <div className='card-body'>
                  <h5 className='card-title'>DMC</h5>
                  <div className='card-text'>
                    <div>Add students to Course 1</div>
                  </div>
                </div>
              </div>
            </div>

            <div className='col-md-4'>
              <div className='card'>
                <img
                  style={{ height: 100 }}
                  alt=''
                />
                <div className='card-body'>
                  <h5 className='card-title'>DBDA</h5>
                  <div className='card-text'>
                    <div>Add students to Course 1</div>
                  </div>
                </div>
              </div>
            </div>

            <div className='col-md-4'>
              <div className='card'>
                <img
                  style={{ height: 100 }}
                  alt=''
                />
                <div className='card-body'>
                  <h5 className='card-title'>DESD</h5>
                  <div className='card-text'>
                    <div>Add students to Course 1</div>
                  </div>
                </div>
              </div>
            </div>

            <div className='col-md-4'>
              <div className='card'>
                <img
                  style={{ height: 100 }}
                  alt=''
                />
                <div className='card-body'>
                  <h5 className='card-title'>DITISS</h5>
                  <div className='card-text'>
                    <div>Add students to Course 1</div>
                  </div>
                </div>
              </div>
            </div>

            <div className='col-md-4'>
              <div className='card'>
                <img
                  style={{ height: 100 }}
                  alt=''
                />
                <div className='card-body'>
                  <h5 className='card-title'>DAI</h5>
                  <div className='card-text'>
                    <div>Add students to Course 1</div>
                  </div>
                </div>
              </div>
            </div>


            </div>

            
    );
}

export default AddUser;