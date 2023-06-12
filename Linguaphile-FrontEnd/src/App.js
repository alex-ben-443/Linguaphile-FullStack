import {Routes,Route} from 'react-router-dom'
import Home from './Pages/Home';
import Signup from './Admin/Signup';
import Signin from './Admin/Signin';
import Dashboard from './Admin/Dashboard';
import EditCourse from './Admin/EditCourse';
import AddCourse from './Admin/AddCourse';
import ViewCourse from './Pages/ViewCourse';

function App() {
  return (
      <Routes>
        <Route exact path='/' element={<Home/>}/>
        <Route exact path='/Signup' element={<Signup/>}/>
        <Route exact path='/Signin' element={<Signin/>}/>
        <Route exact path='/Dashboard' element={<Dashboard/>}/>
        <Route exact path='/Dashboard/edit/:productId' element={<EditCourse/>}/>
        <Route exact path='/Dashboard/add' element={< AddCourse/>}/>
        <Route exact path='/View/:productId' element={<ViewCourse/>}/>
      </Routes>
  );
}

export default App;
