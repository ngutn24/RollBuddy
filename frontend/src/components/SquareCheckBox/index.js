import React from "react";
import styled from "styled-components";
export const SquareCheckBox1 = ({}) => {
    return (
        <SquareCheckBoxRoot>
            <SelectedFalse
                src={"https://file.rendit.io/n/S9QP1DU5TWueyXqWgeHY.svg"}
            />
            <SelectedFalse
                src={"https://file.rendit.io/n/U8IbQKhM2xx8z23y6Osf.svg"}
            />
        </SquareCheckBoxRoot>
    );
};
const SquareCheckBoxRoot = styled.div`
  border-width: 1px;
  border-color: #7b61ff;
  border-style: solid;
  width: 44px;
  display: flex;
  overflow: hidden;
  flex-direction: column;
  gap: 8px;
  margin: auto;
  align-items: center;
  border-radius: 5px;
  padding: 11px 23px 13px 28px;
`;
const SelectedFalse = styled.img`
  width: 40px;
  height: 36px;
`;
