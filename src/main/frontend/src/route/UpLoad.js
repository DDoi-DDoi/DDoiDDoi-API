import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../css/UpLoad.css';

const Uploader = () => {
    const [image, setImage] = useState({
        image_file: '',
        preview_URL: 'img/default_image.png',
    });
    const [isButtonDisabled, setButtonDisabled] = useState(true);

    let inputRef;

    const saveImage = (e) => {
        e.preventDefault();
        if (e.target.files[0]) {
            URL.revokeObjectURL(image.preview_URL);
            const preview_URL = URL.createObjectURL(e.target.files[0]);
            setImage({
                image_file: e.target.files[0],
                preview_URL: preview_URL,
            });
            setButtonDisabled(false);
        }
    };

    const deleteImage = () => {
        URL.revokeObjectURL(image.preview_URL);
        setImage({
            image_file: '',
            preview_URL: 'img/default_image.png',
        });
        setButtonDisabled(true);
    };

    useEffect(() => {
        return () => {
            URL.revokeObjectURL(image.preview_URL);
        };
    }, []);


    const springUrl = 'http://localhost:8080';
    const sendApi = '/upload/send';

    const sendImageToServer = async () => {
        if (image.image_file) {
            const formData = new FormData();
            formData.append('file', image.image_file);

            const testRe = await axios.get("https://port-0-aiserver-20zynm2mljxybsqy.sel4.cloudtype.app/check");
            console.log(testRe);

            try {
                console.log("asd");
                const response = await axios.post(`${springUrl}${sendApi}`, formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data',
                    },
                    mode: 'cors',
                });
                alert(response.data);
                setImage({
                    image_file: '',
                    preview_URL: 'img/default_image.png',
                });
                setButtonDisabled(true);
            } catch (error) {
                console.error(error);
            }
        } else {
            alert('사진을 등록하세요!');
        }
    };


    return (
        <div className="uploader-wrapper">
            <header>
                <h2>이미지 업로드!</h2>
            </header>
            <input
                type="file"
                accept="image/*"
                onChange={saveImage}
                onClick={(e) => (e.target.value = null)}
                ref={(refParam) => (inputRef = refParam)}
                style={{ display: 'none' }}
            />
            <div className="img-wrapper">
                <img src={image.preview_URL} alt="Preview" />
            </div>

            <div className="upload-button">
                <button
                    type="button"
                    className="primary-button"
                    onClick={() => inputRef.click()}
                >
                    Preview
                </button>
                <button
                    type="button"
                    className="delete-button"
                    onClick={deleteImage}
                    disabled={isButtonDisabled}
                >
                    Delete
                </button>
                <button
                    type="button"
                    className="upload-button"
                    onClick={sendImageToServer}
                    disabled={isButtonDisabled}
                >
                    Upload
                </button>
            </div>
        </div>
    );
};

export default Uploader;
