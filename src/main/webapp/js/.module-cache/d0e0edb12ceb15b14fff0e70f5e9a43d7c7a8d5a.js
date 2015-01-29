$c.Alert = React.createClass({
  mixins: [b.OverlayMixin],


  render: function () {
    return (
      <span/>
    );
  },
  renderOverlay: function () {
    if (!this.props.isShow) {
      return <span/>;
    }

    return (
        <b.Modal onRequestHide={function(){}}  className="alert">
          <div className="modal-body">this.props.message
 
          </div>
          <div className="modal-footer">
            <b.Button onClick={this.props.onClick} name="loginForm#CloseBtn">了解</b.Button>
          </div>
        </b.Modal>
      );
  }
});  