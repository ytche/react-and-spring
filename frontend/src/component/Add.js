import React from 'react';
import '../index.css';
import $ from 'jquery';
class Add extends React.Component{
  constructor(props){
    super(props);
    this.state={};
    if(props.match.params){
      let id=this.props.match.params.id
      fetch('/api/v1/test1s/'+id)
          .then(response => response.text())
          .then(message => {
            var data=JSON.parse(message);
            if(data.success){
              this.setState(data.data);
            }else{
              alert(data.info);
              if(data.errorCode==1){
                this.props.history.push("/login");
              }
            }
          });
    }
  }
  handleChange(e){
    let name=e.target.name;
    let value=e.target.value;
    this.setState({[name]:value});
  }
  save(e){
    var that=this;
    $.post("/api/v1/test1s",{name:this.state.name},function(data){
        if(data.success){
          alert("保存成功");
          that.props.history.push("/test1");
        }else{
          alert(data.info);
          if(data.errorCode==1){
            that.props.history.push("/login");
          }
        }
    },"json");
  }
  render() {
    return <div>
      <h1>Hello Add</h1>
      <input type="text" name="name" value={this.state.name} onChange={this.handleChange.bind(this)} />
      <button type="button" onClick={this.save.bind(this)}>提交</button>
    </div>;
  }
}
export default Add;
