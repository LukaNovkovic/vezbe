import React from 'react';
import { Form, Row, Col, Button} from 'react-bootstrap';
import Axios from '../../apis/Axios';

class EditRadnik extends React.Component {

    constructor(props){
        super(props);

    
        const radnik = {
          id: -1,
          imePrezime: '',
          email: '',
          godinaStaza: 0,
          slobodnihDana: 0,
          odeljenjeId: -1,
          odeljenjeIme: ''
          }

        this.state = {radnik: radnik, odeljenja: []};
    }

    componentDidMount(){
        this.getRadnikById(this.props.match.params.id);
        this.getOdeljenja();
    }

    // TODO: Dobaviti task
    async getRadnikById(id){
        Axios.get('/radnici/' + id)
       
        .then(res => {
            // handle success
            console.log(res);
            const radnik = res.data
            this.setState({radnik: radnik})
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Error occured please try again!');
         });
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

      async edit(){
        const radnikDTO = this.state.radnik
        console.log(radnikDTO)
        try {
          let result = await Axios.put("/radnici/" + this.state.radnik.id, radnikDTO);
          console.log(result)
          alert('uspesno izmenjen')
          this.props.history.push("/radnici");
        //   window.location.reload()
        }catch (error) {
          console.log(error);
          alert("Couldn't edit the task");
        }
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

    // TODO: Rukovati prihvatom vrednosti na promenu


    // TODO: Omogućiti odabir filma za projekciju
    render(){
        return (
            <>
       <Row className="justify-content-md-left">
          <Col xs="12" md="8" sm="10" >
              <h2>Edit Radnik</h2>
              <Form>
                <Form.Group>
                <Form.Label >Ime i prezime</Form.Label>
                <Form.Control  name="imePrezime"  type="text" min="1" value={this.state.radnik.imePrezime} onChange={(e)=>this.valueInputChanged(e)}/> <br/>
                </Form.Group>
                <Form.Group>
                <Form.Label >Email</Form.Label>
                <Form.Control type="email"  name="email" value={this.state.radnik.email} onChange={(e)=>this.valueInputChanged(e)}/> <br/>
                </Form.Group>
                <Form.Group>
                <Form.Label >Godine radnog staza</Form.Label>
                <Form.Control type="number"  name="godinaStaza" value={this.state.radnik.godinaStaza} onChange={(e)=>this.valueInputChanged(e)}/> <br/>
                </Form.Group>
               


                <Form.Group>
                <Form.Label >Odeljenje</Form.Label>
                <Form.Control as="select" name="odeljenjeId"  onChange={event => this.valueInputChanged(event)}>
                    <option value={-1}></option>
                        {
                            this.state.odeljenja.map((odeljenje) => {
                                return (
                                    <option key={odeljenje.id} value={odeljenje.id}>{odeljenje.ime}</option>
                                )
                            })
                        }
                </Form.Control><br/>
                </Form.Group>

                  <Button 
                    disabled={this.state.radnik.imePrezime ==='' || this.state.radnik.email==='' || this.state.radnik.godinaStaza<0 
                    || this.state.radnik.odeljenjeId<=-1 }
                    onClick={(event)=>{this.edit(event);}}>Edit</Button>
            </Form>
        </Col>
        </Row>
            </>
        )
    }
}

export default EditRadnik;