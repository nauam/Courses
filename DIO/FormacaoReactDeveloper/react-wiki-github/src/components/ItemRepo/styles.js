import styled from "styled-components";

export const ItemRepoConteiner = styled.div`
  width: 80%;
  margin: 20px 0 0 0;

  h3 {
    font-size: 32px;
    color: #FAFAFA;
  }

  p {
    font-size: 16px;
    color: #FAFAFA60;
  }

  .btn-danger {
    background-color: #FF5555 !important;
  }

  .btn-success {
    background-color: #00FF99 !important;
  }

  .btn {
    display: inline-block;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    background-color: #ff0000;
    color: #ffffff;
    text-align: center;
    text-decoration: none;
    font-size: 12px;
    font-weight: bold;
  }

  .btn:hover {
    opacity: 0.8;
  }

  hr {
    color: #FAFAFA60;
    margin: 20px 0;
  }

  .row {
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  .col {
    display: flex;
    flex-direction: column;
  }

  .ml-50 {
    margin-left: 7px;
  }

  .mr-50 {
    margin-rigth: 7px;
  }
`