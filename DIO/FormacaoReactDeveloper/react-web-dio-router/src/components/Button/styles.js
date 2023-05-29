import styled from "styled-components";

export const ButtonContainer = styled.button`
    background-color: #565656;
    color: #fff;
    border-radius: 22px;

    position: relative;
    padding: 2px 12px;
    min-width: 120px;
    width: 100%;

    &:hover {
        opacity: 0.8;
        cursor: pointer;
    }

    ${ ({ variant }) => variant !== "primary" && `
        min-width: 167px;
        height: 33px;

        background-color: #E4105D;
        &:after {
            content: "";
            position: absolute;
            border: 1px solid #E4105D;
            top: -5px;
            left: -6px;
            width: calc(100% + 12px);
            height: calc(100% + 10px);
            border-radius: 22px;
        }
    ` }


`;