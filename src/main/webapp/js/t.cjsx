# tutorial1.cjsx
CommentBox = React.createClass
  render: ->
    <div className="commentBox">
      Hello, world! I am a CommentBox. dayo
    </div>

window.onload = ->
  React.render(
    <CommentBox />,
    document.getElementById('content')
  );