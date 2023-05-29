import styled from 'styled-components';

export const Conteiner = styled.div`
    width: 100%;
    height: 100vh;
    background-color: #2b2b2b;

    display: flex;
    align-items: center;
    justify-content: center;
`

export const Content = styled.div`
    background-color: #3b3b3b;
    width: fit-content;
    padding: 12px;
    border-radius: 8px;
`

export const Row = styled.div`
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    margin: -3px;
`

export const Column = styled.div`
    width: 100%;
    display: flex;
    flex-direction: Column;
    justify-content: space-between;
    align-items: center;
    margin: 3px;
`