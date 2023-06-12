import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { EditData, FindData } from '../services/api';
import { BackBtn } from '../Componentes/Buttons';
import VerifyCheck from './Auth/VerifyCheck';

export default function EditCourse() {
    const { productId } = useParams();
    const navigate = useNavigate();
    const [product, setProduct] = useState({
        course: '',
        mentor: '',
        courseprice: '',
        courserating: '',
        countryimg: '',
    });

    useEffect(() => {
        fetchProduct();
    }, []);

    const fetchProduct = async () => {
        try {
            const response = await FindData(productId);
            setProduct(response.data);
            console.log(response.data);
        } catch (error) {
            console.error(error);
        }
    };

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
            await EditData(productId, product);
            alert('Course Updated !');
            navigate('/dashboard');
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div className='dashboard-content'>
            <VerifyCheck/>
            <div className='cardx form-data-align'>
                <form onSubmit={handleSubmit} className='form-data-card'>
                    <label>Course Name</label>
                    <input type='text' placeholder='Course Name' name='course' value={product.course} onChange={handleInputChange} className='product-input' required />
                    <label>Mentor</label>
                    <input type='text' placeholder='Mentor' name='mentor' value={product.mentor} onChange={handleInputChange} className='product-input' required />
                    <label>Course Price</label>
                    <input type='number' placeholder='Course Price' name='courseprice' value={product.courseprice} onChange={handleInputChange} className='product-input' required />
                    <label>Course Rating</label>
                    <input type='number' placeholder='Rating' name='courserating' value={product.courserating} onChange={handleInputChange} className='product-input' required />
                    <label>Country Image URL</label>
                    <input type='text' placeholder='Country img URL' name='countryimg' value={product.countryimg} onChange={handleInputChange} className='product-input' required />
                    <button type='submit' className='button2'>Update Course</button>
                </form>
            </div>
            <BackBtn />
        </div>
    );
}
