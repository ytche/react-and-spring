import React from 'react';
import '../index.css';
import $ from 'jquery';
class Login extends React.Component{
  constructor(props){
    super(props);
    this.state={};
  }
  handleChange(e){
    let name=e.target.name;
    let value=e.target.value;
    this.setState({[name]:value});
  }
  login(e){
    var that=this;
    console.log(this.state);
    let value=JSON.stringify({
      name:this.state.name,
      password:this.state.password,
    });
    console.log(value);
    $.ajax({
           url:"/api/v1/users/actions/login",
           type:"POST",
           contentType:"application/json",
           dataType:"json",
           data:value,
           success:function (data) {
             if(data.success){
               alert("登录成功")
               that.props.history.push("/test1")
             }else{
               alert("登录失败")
             }
           }
       });
  }
  render() {
    return <div>
      <h1>Hello Add</h1>
      <form>
      <input type="text" name="name" onChange={this.handleChange.bind(this)} />
      <input type="password" name="password" onChange={this.handleChange.bind(this)} />
      <button type="button" onClick={this.login.bind(this)}>登陆</button>
      </form>
    </div>;
  }
}
export default Login;
