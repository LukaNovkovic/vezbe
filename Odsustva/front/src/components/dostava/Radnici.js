import React from "react";
import Axios from "../../apis/Axios";
import {Button, ButtonGroup, Table, Form, Col, Row} from 'react-bootstrap';

class Radnici extends React.Component {
  constructor(props) {
    super(props);

    const search = {
      odeljenjeId: -1,
      jmbg: '',

    }
    const radnik = {
      jmbg: '',
      imePrezime: '',
      email: '',
      godinaStaza: 0,
      slobodnihDana: 0,
      odeljenjeId: -1,
    }

    this.state = { 
      radnici: [],
      odeljenja: [],
      pageNo: 0,
      totalPages: 1,
      search: search,
      toggle: false,
      radnik: radnik

    }
  }

  componentDidMount() {
    this.getRadnici(0);
    this.getOdeljenja();

  }

  async getOdeljenja(){
    try{
      const result = await Axios.get("/odeljenja");
      this.setState(
        {
          odeljenja: result.data
        }
      )
    }catch(error){
      console.log(error);
    }
  }

  //TODO prokomentarisati sto sam promenio da se radi sa pageNo, a ne changeDir!!
  async getRadnici(newPageNo) {
   
    const config = {
      params: {
        pageNo: newPageNo
      }
    }

    if(this.state.search.odeljenjeId!=-1){
      config.params['odeljenjeId'] = this.state.search.odeljenjeId
    }

    if(this.state.search.jmbg!=""){
      config.params['jmbg'] = this.state.search.jmbg
    }


    try {
      let result = await Axios.get("/radnici", config);
      console.log(result)
     
      this.setState({
        radnici: result.data,
        pageNo: newPageNo,
        totalPages: result.headers['total-pages'],
        // ukupnoBodova: result.headers['ukupno-bodova']
        });
    }catch (error) {
      console.log(error);
    }
  }

  searchValueInputChange(event){
    const name = event.target.name;
    const value = event.target.value;

    let search = this.state.search;
    search[name] = value
    this.setState(search)
    this.getRadnici(0)
  }

  valueInputChanged(event){
    const name = event.target.name;
    const value = event.target.value;
    // if(name == 'imeZadatka' && value.length > 40){
    //   alert('Ime zadatka mora biti manje od 40 karaktera!')
    //   return
    // }

    let radnik = this.state.radnik;
    radnik[name] = value
    this.setState(radnik)
  }

  async create(){
    const radnikDTO = this.state.radnik
    console.log(radnikDTO)
    try {
      let result = await Axios.post("/radnici", radnikDTO);
      console.log(result)
      alert('uspesno dodat')
      // this.props.history.push("/tasks");
      window.location.reload()
    }catch (error) {
      console.log(error);
      alert("Couldn't save the task");
    }
  }

  goToEdit(id){
    this.props.history.push('/radnici/edit/' + id)
  }

  deleteFromState(id) {
    var tasks = this.state.radnici;
    tasks.forEach((element, index) => {
        if (element.id === id) {
            tasks.splice(index, 1);
            this.setState({tasks: tasks});
        }
    });
  }
  
  delete(id){
    Axios.delete('/radnici/' + id)
    .then(res => {
        // handle success
        console.log(res);
        alert('Deleted successfully!');
        // this.deleteFromState(taskId); // ili refresh page-a window.location.reload();
        window.location.reload()
    })
    .catch(error => {
        // handle error
        console.log(error);
        alert('Error occured please try again!');
     });
  }
  
  odsustvo(id){
    this.props.history.push('/radnici/odsustvo/' + id)

  }


  render() {
    return (
      <div>
        {window.localStorage['role']=="ROLE_ADMIN"?
        <Row className="justify-content-md-left">
          <Col xs="12" md="8" sm="10" >
              <h2>Add Radnik</h2>
              <Form>
                <Form.Group>
                <Form.Label >JMBG</Form.Label>
                <Form.Control  name="jmbg" type="text" min="13" max="13" onChange={(e)=>this.valueInputChanged(e)}/> <br/>
                </Form.Group>
                <Form.Group>
                <Form.Label >Ime i prezime</Form.Label>
                <Form.Control  name="imePrezime"  type="text" min="1" onChange={(e)=>this.valueInputChanged(e)}/> <br/>
                </Form.Group>
                <Form.Group>
                <Form.Label >Email</Form.Label>
                <Form.Control type="email"  name="email" onChange={(e)=>this.valueInputChanged(e)}/> <br/>
                </Form.Group>
                <Form.Group>
                <Form.Label id="pgodinaStaza">Godine radnog staza</Form.Label>
                <Form.Control type="number"  name="godinaStaza" onChange={(e)=>this.valueInputChanged(e)}/> <br/>
                </Form.Group>
  

                <Form.Group>
                <Form.Label >Odeljenje</Form.Label>
                <Form.Control as="select"  name="odeljenjeId" onChange={event => this.valueInputChanged(event)}>
                    <option value={-1}></option>
                        {
                            this.state.odeljenja.map((odeljenja) => {
                                return (
                                    <option key={odeljenja.id} value={odeljenja.id}>{odeljenja.ime}</option>
                                )
                            })
                        }
                </Form.Control><br/>
                </Form.Group>
                  
                <Button disabled={this.state.radnik.email === '' || this.state.radnik.godinaStaza<0 } onClick={(event)=>{this.create(event);}}>Add</Button>

                </Form>
                </Col>
            </Row>
            :null}
        <br/><br/>

        <Row>
          <Col>
            <input type="checkbox" onClick={()=>{this.setState({toggle:!this.state.toggle})}}></input>&nbsp;
            <label>Prikaži formu za pretragu</label>
            {
              this.state.toggle ? 
              <div>
              
                <Form style={{marginTop:35}}>

                  <Row>
                    <Col md={6}>
                    <Form.Group>
                      <Form.Label>Odeljenje</Form.Label>
                      <Form.Control
                        onChange={(event) => this.searchValueInputChange(event)}
                        name="odeljenjeId"
                        value={this.state.search.odeljenjeIme}
                        as="select">
                        <option value={-1}></option>
                        {this.state.odeljenja.map((odeljenje) => {
                          return (
                            <option key={odeljenje.id} value={odeljenje.id}>
                              {odeljenje.ime}
                            </option>
                          );
                        })}
                      </Form.Control>
                    </Form.Group>
                    </Col>
                  </Row>

                  <Row>
                    <Col md={6}>
                      <Form.Group>
                      <Form.Label>JMBG</Form.Label>
                      <Form.Control
                        value={this.state.search.jmbg}
                        name="jmbg"
                        as="input"
                        type="text"
                        onChange={(e) => this.searchValueInputChange(e)}
                      ></Form.Control>
                      </Form.Group>
                    </Col>
                  </Row>

                  {/* <Button onClick={() => this.getTasks(0)}>Search</Button> */}
                </Form>
              </div> : null
            }
          </Col>
        </Row>
        <br/><br/>

        <div>
          
          <h1>Radnici</h1>

          <br/>
          
          <Table id="movies-table" striped hover>
           
              <thead className="table-dark" >
                <tr >
                  <th>JMBG</th>
                  <th>Ime i prezime</th>
                  <th>Email</th>
                  <th>Slobodni dani</th>
                  <th>Odeljenje</th>
                  <th>Akcije</th>


                </tr>
              </thead>
           
            <tbody >
              {this.state.radnici.map((radnik) => {
                return (
                  <tr key={radnik.id} >
                    <td>{radnik.jmbg}</td>
                    <td>{radnik.imePrezime}</td>
                    <td>{radnik.email}</td>
                    <td>{radnik.slobodnihDana}</td>
                    <td>{radnik.odeljenjeIme}</td>
                    <td>
                    <ButtonGroup>

                      {window.localStorage['role']=="ROLE_ADMIN"?
                      [
                        <Button variant="warning" onClick={() => this.goToEdit(radnik.id)}>Edit</Button>,

                        <Button variant="danger" onClick={() => this.delete(radnik.id)}>Delete</Button>
                      ]
                      :null}

                      {window.localStorage['role']=="ROLE_KORISNIK"?
                          <Button disabled={radnik.brojRezervacija >= radnik.brojMesta} variant="primary" onClick={() => this.odsustvo(radnik.id)}>Odsustvo</Button>

                      :null}
                      </ButtonGroup>

                    </td>
                  </tr>
                );
              })}
            </tbody>
          </Table>
          <ButtonGroup>
            <Button disabled={this.state.pageNo===0} onClick={()=> this.getRadnici(this.state.pageNo-1)}>Prev</Button>
            <Button disabled={this.state.pageNo===this.state.totalPages-1 || this.state.totalPages ==0} onClick={()=> this.getRadnici(this.state.pageNo+1)}>Next</Button>
          </ButtonGroup>
         
        </div>
      </div>
    );
  }
}

export default Radnici;