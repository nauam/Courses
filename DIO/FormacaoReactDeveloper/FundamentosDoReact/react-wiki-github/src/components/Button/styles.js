import styled from "styled-components";

export const ButtonConteiner = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  color: #000000;
  background-color: #FAFAFA;
  border-radius: 20px;
  border: 1px solid #FAFAFA;

  width: 80%;
  height: 62px;

  margin: 20px;

  &:hover {
    background-color: #F0F0F040;
  }
`