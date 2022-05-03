import React from "react";
import styled from "styled-components";
export const CircleCheckBox1 = ({}) => {
    return (
        <CircleCheckBoxRoot>
            <SelectedFalse
                src={"https://file.rendit.io/n/LWQ5eQgcaRfy1lVOFzbh.svg"}
            />
            <SelectedFalse
                src={"https://file.rendit.io/n/6R9ujdzFDu0s6zs6jnoR.svg"}
            />
        </CircleCheckBoxRoot>
    );
};
const CircleCheckBoxRoot = styled.div`
  border-width: 1px;
  border-color: #7b61ff;
  border-style: solid;
  width: 20px;
  display: flex;
  overflow: hidden;
  flex-direction: column;
  gap: 16px;
  margin: auto;
  align-items: center;
  border-radius: 5px;
  padding: 15px 15px 19px 19px;
`;
const SelectedFalse = styled.img`
  width: 16px;
  height: 12px;
`;
