
import { useState } from "react";
import "./styles.scss";
import api from "../../utils/api";
import ReactInputMask from "react-input-mask";

const Register: React.FC = () => {
  const [formData, setFormData] = useState({
    manufacturerName: '',
    manufacturerCNPJ: '',
    manufacturerFantasyName: '',
    manufacturerSocialName: '',
    manufacturerActive: false,
    manufacturerSite: '',
    manufacturerCountry: '',
    manufacturerCity: '',
    manufactureNeighbourhood: ''
  });

  const handleChangeCnpj = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData(prevState => ({
      ...prevState,
      manufacturerCNPJ: e.target.value
    }));
  };

  const handleChangeRazaoSocial = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData(prevState => ({
      ...prevState,
      manufacturerName: e.target.value
    }));
  };

  const handleChangeEmpresaAtiva = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData(prevState => ({
      ...prevState,
      manufacturerActive: e.target.checked
    }));
  };

  const handleChangeNomeFantasia = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData(prevState => ({
      ...prevState,
      manufacturerFantasyName: e.target.value
    }));
  };

  const handleChangeNomeSocial = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData(prevState => ({
      ...prevState,
      manufacturerSocialName: e.target.value
    }));
  };

  const handleChangeSite = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData(prevState => ({
      ...prevState,
      manufacturerSite: e.target.value
    }));
  };

  const handleChangePais = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData(prevState => ({
      ...prevState,
      manufacturerCountry: e.target.value
    }));
  };

  const handleChangeCidade = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData(prevState => ({
      ...prevState,
      manufacturerCity: e.target.value
    }));
  };

  const handleChangeBairro = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData(prevState => ({
      ...prevState,
      manufactureNeighbourhood: e.target.value
    }));
  };
 
  
  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await api.post('/create', formData);
      
      setFormData({
        manufacturerName: '',
        manufacturerCNPJ: '',
        manufacturerFantasyName: '',
        manufacturerSocialName: '',
        manufacturerActive: false,
        manufacturerSite: '',
        manufacturerCountry: '',
        manufacturerCity: '',
        manufactureNeighbourhood: ''
      });
      alert('Dados enviados com sucesso!');
    } catch (error) {
      console.error('Erro ao enviar dados:', error);
      alert('Ocorreu um erro ao enviar os dados.');
    }
  };

  return (
  <div className="container box-shadow-light">
    <div className="title-register padding-left-15">
      Novo Cadastro de Empresa
    </div>

    <div className="padding-left-15">
      <form onSubmit={handleSubmit}>
        <label htmlFor="CNPJ">CNPJ</label>
        <ReactInputMask
          mask="99.999.999/9999-99"
          className="form-layout width-200"
          id="cnpj"
          tabIndex={1}
          value={formData.manufacturerCNPJ}
          onChange={handleChangeCnpj}
        />

        <label htmlFor="razaoSocial">Razão Social</label>
        <input
          type="text"
          className="form-layout width-400"
          id="razaosocial"
          tabIndex={2}
          value={formData.manufacturerName}
          onChange={handleChangeRazaoSocial}
        />
        <label htmlFor="ativa">Empresa Ativa:</label>
        <input className="form-check-input form-layout" 
            type="checkbox" 
            id="empresaAtiva" 
            tabIndex={3}
            checked={formData.manufacturerActive}
            onChange={handleChangeEmpresaAtiva}
          />
        <p />
        <br />

        <label htmlFor="nomefantasia">Nome Fantasia</label>
        <input
          type="text"
          className="form-layout width-400"
          id="nomefantasia"
          tabIndex={4}
          value={formData.manufacturerFantasyName}
          onChange={handleChangeNomeFantasia}
        />

        <label htmlFor="nomesocial">Nome Social</label>
        <input
          type="text"
          className="form-layout width-400"
          id="nomesocial"
          tabIndex={5}
          value={formData.manufacturerSocialName}
          onChange={handleChangeNomeSocial}
        />
        <p />
        <br />

        <label htmlFor="nomefantasia">Site</label>
        <input
          type="text"
          className="form-layout width-200"
          id="site"
          tabIndex={6}
          value={formData.manufacturerSite}
          onChange={handleChangeSite}
        />

        <label htmlFor="pais">País</label>
        <input
          type="text"
          className="form-layout width-200"
          id="pais"
          tabIndex={7}
          value={formData.manufacturerCountry}
          onChange={handleChangePais}
        />
        <label htmlFor="cidade">Cidade</label>
        <input
          type="text"
          className="form-layout width-200"
          id="cidade"
          tabIndex={8}
          value={formData.manufacturerCity}
          onChange={handleChangeCidade}
        />
        <label htmlFor="bairro">Bairro</label>
        <input
          type="text"
          className="form-layout width-200"
          id="Bairro"
          tabIndex={9}
          value={formData.manufactureNeighbourhood}
          onChange={handleChangeBairro}
        />
        <p />
        <br />
        <div className="buttons-register">
          <button className="btn btn-primary me-md-2" 
            tabIndex={10}
            type="submit">
            Salvar
          </button>
        </div>
      </form>
    </div>
  </div>
);
}

export default Register;
