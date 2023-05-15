import styled from "styled-components";

export const Container = styled.div`
    width: 100%;
    max-width: 80%;
    height: 47px;

    display: flex;
    justify-content: space-between;
    align-items: center;

    margin: 0 auto;
`;

export const Row = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
`;

export const Column = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
`;

export const Wrapper = styled.div`
    background-color: #151515;
    width: 100%;
    height: 47px;
    display: flex;
    justify-content: center;
    align-items: center;
`;

export const InputContainer = styled.div`
    width: 175px;
    height: 30px;
    background-color: #2D2D37;
    border-radius: 8px;
    padding: 2px 5px;
    margin: 0 12px;

    display: flex;
    align-items: center;
    justify-content: center;
`;

export const Menu = styled.a`
    fonte-style: normal;
    font-size: 12px;
    line-height: 25px;
    color: #fff;
    margin-right: 12px;
    text-decoration: none;
`

export const MenuRight = styled.a`
    fonte-style: normal;
    font-size: 12px;
    line-height: 25px;
    color: #fff;
    margin-right: 12px;
    text-decoration: none;
`

export const Logo = styled.img`
    width: 100%;
    max-width: 200px;
`;

export const Avatar = styled.img`
    width: 32px;
    height: 32px;
    border-radius: 50%;
    border: 2px solid #fff;
`;

export const Input = styled.input`
    background-color: transparent;
    flex: 1;
    border: none;
    color: #fff;
    
    height: 30px;

    &:focus {
        outline: none;
    }
`;



