import React from 'react';
import '../index.css';
import $ from 'jquery';
import { Redirect } from 'react-router';
import { Link } from 'react-router-dom'
class Test1 extends React.Component{
  constructor(props){
    super(props);
    this.state={"data":[]};
  }
  componentDidMount() {
    fetch('/api/v1/test1s')
        .then(response => response.text())
        .then(message => {
          var messageObj=JSON.parse(message);
          if(messageObj.success){
            this.setState({"data":messageObj.data});
          }else{
             alert(messageObj.info);
             if(messageObj.errorCode==1){
               this.props.history.push("/login");
             }
          }
        });
  }
  addOrUpdate(prop,e){
     this.props.history.push("/add")
  }
  dataDelete(prop,index,e){
    var that=this;
    $.ajax({
      url:'/api/v1/test1s'+"/"+prop,
      type:"DELETE",
      dataType:"json",
      success:function(data){
        if(data.success){
          that.state.data.splice(index,1);
          alert("delete success");
          that.forceUpdate();
        }else{
          alert(data.info);
          if(data.errorCode==1){
            this.props.history.push("/login");
          }
        }
      }
    });
    alert(prop);
  }
  render() {
    return <div><h1>Hello Test1</h1>
      <button onClick={this.addOrUpdate.bind(this)}>添加</button>
      <table>
        <thead>
          <tr>
            <th>id</th>
            <th>name</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
          {this.state.data.map((value,index) =>
            <tr key={value.id}>
              <td>{value.id}</td>
              <td>{value.name}</td>
              <td>
                <a href="#" onClick={this.dataDelete.bind(this,value.id,index)}>删除</a>
                <Link to={'/update/'+value.id}>更新</Link>
              </td>
            </tr>
           )}
         </tbody>
      </table>
    </div>;
  }
}
export default Test1;
