import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { AddData } from '../services/api';
import { BackBtn } from '../Componentes/Buttons';
import VerifyCheck from './Auth/VerifyCheck';

export default function AddCourse() {
    const navigate = useNavigate();
    const [product, setProduct] = useState({
        course: '',
        mentor: '',
        courseprice: '',
        courserating: '',
        countryimg: '',
    });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setProduct((prevState) => ({
            ...prevState,
            [name]: value,
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            await AddData(product);
            alert('Course added!');
            navigate('/dashboard');
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div className='dashboard-content'>
            <VerifyCheck/>
            <div className='cardx form-data-align'>
                <form onSubmit={handleSubmit} className='form-data-card '>
                    <input type='text' placeholder='Course' name='course' value={product.course} onChange={handleInputChange} className='product-input' required/>
                    <input type='text' placeholder='Mentor' name='mentor' value={product.mentor} onChange={handleInputChange} className='product-input' required />
                    <input type='number' placeholder='Price' name='courseprice' value={product.courseprice} onChange={handleInputChange} className='product-input' required />
                    <input type='number' placeholder='Rating' name='courserating' value={product.courserating} onChange={handleInputChange} className='product-input' required />
                    <input type='text' placeholder='Country img URL' name='countryimg' value={product.countryimg} onChange={handleInputChange} className='product-input' required />
                    <button type='submit' className='button2'>Add Course</button>
                </form>
            </div>
            <BackBtn />
        </div>
    );
}
