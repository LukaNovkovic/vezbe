import React from 'react';
import { Form, Row, Col, Button} from 'react-bootstrap';
import Axios from '../../apis/Axios';

class Odsustvo extends React.Component {

    constructor(props){
        super(props);

    
        const odsustvo = {
            radnikId: this.props.match.params.id,
          datumPocetka: '',
          radnihDana: 0,
          }

          const radnik = {
            jmbg: '',
            imePrezime: '',
            email: '',
            godinaStaza: 0,
            slobodnihDana: 0,
            odeljenjeId: -1,
          }

        this.state = {odsustvo: odsustvo, radnik: radnik};
    }

    componentDidMount(){
        this.getRadnikById(this.props.match.params.id);
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


      async edit(){
        const odsustvoDTO = this.state.odsustvo
        console.log(odsustvoDTO)
        try {
          let result = await Axios.post("/odsustva/", odsustvoDTO);
          console.log(result)
          alert('uspesno dodato')
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
    
        let odsustvo = this.state.odsustvo;
        odsustvo[name] = value
        this.setState(odsustvo)
      }

    // TODO: Rukovati prihvatom vrednosti na promenu


    // TODO: Omogućiti odabir filma za projekciju
    render(){
        return (
            <>
            {this.state.radnik.slobodnihDana === 0 ? <h1 >Nemate raspolozivih slobodnih dana za odsustvo!</h1> :null }
       <Row className="justify-content-md-left">
          <Col xs="12" md="8" sm="10" >
              <h2>Zahtev za odsustvom</h2>
              <Form>
                <Form.Group>
                <Form.Label >Datum pocetka</Form.Label>
                <Form.Control  name="datumPocetka"  type="text" min="1"  onChange={(e)=>this.valueInputChanged(e)}/> <br/>
                </Form.Group>
                <Form.Group>
                <Form.Label >Radnih dana</Form.Label>
                <Form.Control type="number"  name="radnihDana" onChange={(e)=>this.valueInputChanged(e)}/> <br/>
                </Form.Group>

                  <Button 
                    disabled={this.state.odsustvo.radnihDana > this.state.radnik.slobodnihDana || this.state.odsustvo.datumPocetka==='' || this.state.odsustvo.radnihDana<=0 }
                    onClick={(event)=>{this.edit(event);}}>Podnesi zahtev</Button>
            </Form>
        </Col>
        </Row>
            </>
        )
    }
}

export default Odsustvo;