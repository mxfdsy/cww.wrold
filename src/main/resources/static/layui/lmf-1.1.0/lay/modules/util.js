/** layui-v2.3.0-rc1-lmf-1.1.0 MIT License By https://www.layui.com */
 ;layui.define("jquery",function(e){"use strict";var t=layui.$,i={fixbar:function(e){var i,a,o="layui-fixbar",r="layui-fixbar-top",l=t(document),n=t("body");e=t.extend({showHeight:200},e),e.bar1=e.bar1===!0?"&#xe606;":e.bar1,e.bar2=e.bar2===!0?"&#xe607;":e.bar2,e.bgcolor=e.bgcolor?"background-color:"+e.bgcolor:"";var c=[e.bar1,e.bar2,"&#xe604;"],g=t(['<ul class="'+o+'">',e.bar1?'<li class="layui-icon" lay-type="bar1" style="'+e.bgcolor+'">'+c[0]+"</li>":"",e.bar2?'<li class="layui-icon" lay-type="bar2" style="'+e.bgcolor+'">'+c[1]+"</li>":"",'<li class="layui-icon '+r+'" lay-type="top" style="'+e.bgcolor+'">'+c[2]+"</li>","</ul>"].join("")),u=g.find("."+r),s=function(){var t=l.scrollTop();t>=e.showHeight?i||(u.show(),i=1):i&&(u.hide(),i=0)};t("."+o)[0]||("object"==typeof e.css&&g.css(e.css),n.append(g),s(),g.find("li").on("click",function(){var i=t(this),a=i.attr("lay-type");"top"===a&&t("html,body").animate({scrollTop:0},200),e.click&&e.click.call(this,a)}),l.on("scroll",function(){clearTimeout(a),a=setTimeout(function(){s()},100)}))},countdown:function(e,t,i){var a=this,o="function"==typeof t,r=new Date(e).getTime(),l=new Date(!t||o?(new Date).getTime():t).getTime(),n=r-l,c=[Math.floor(n/864e5),Math.floor(n/36e5)%24,Math.floor(n/6e4)%60,Math.floor(n/1e3)%60];o&&(i=t);var g=setTimeout(function(){a.countdown(e,l+1e3,i)},1e3);return i&&i(n>0?c:[0,0,0,0],t,g),n<=0&&clearTimeout(g),g},timeAgo:function(e,t){var i=this,a=[[],[]],o=(new Date).getTime()-new Date(e).getTime();return o>6912e5?(o=new Date(e),a[0][0]=i.digit(o.getFullYear(),4),a[0][1]=i.digit(o.getMonth()+1),a[0][2]=i.digit(o.getDate()),t||(a[1][0]=i.digit(o.getHours()),a[1][1]=i.digit(o.getMinutes()),a[1][2]=i.digit(o.getSeconds())),a[0].join("-")+" "+a[1].join(":")):o>=864e5?(o/1e3/60/60/24|0)+"天前":o>=36e5?(o/1e3/60/60|0)+"小时前":o>=12e4?(o/1e3/60|0)+"分钟前":o<0?"未来":"刚刚"},digit:function(e,t){var i="";e=String(e),t=t||2;for(var a=e.length;a<t;a++)i+="0";return e<Math.pow(10,t)?i+(0|e):e},toDateString:function(e,t){var i=this,e="string"==typeof e?e.replace(/-/g,"/"):e,a=new Date(e||new Date),o=[i.digit(a.getFullYear(),4),i.digit(a.getMonth()+1),i.digit(a.getDate())],r=[i.digit(a.getHours()),i.digit(a.getMinutes()),i.digit(a.getSeconds())];return t=t||"yyyy-MM-dd HH:mm:ss",t.replace(/yyyy/g,o[0]).replace(/MM/g,o[1]).replace(/dd/g,o[2]).replace(/HH/g,r[0]).replace(/mm/g,r[1]).replace(/ss/g,r[2])},escape:function(e){return String(e||"").replace(/&(?!#?[a-zA-Z0-9]+;)/g,"&amp;").replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/'/g,"&#39;").replace(/"/g,"&quot;")}};e("util",i)});
//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImxheS9tb2R1bGVzL3V0aWwuanMiXSwibmFtZXMiOlsibGF5dWkiLCJkZWZpbmUiLCJleHBvcnRzIiwiJCIsInV0aWwiLCJmaXhiYXIiLCJvcHRpb25zIiwiaXMiLCJ0aW1lciIsIkVMRU0iLCJUT1BfQkFSIiwiZG9tIiwiZG9jdW1lbnQiLCJib2R5IiwiZXh0ZW5kIiwic2hvd0hlaWdodCIsImJhcjEiLCJiYXIyIiwiYmdjb2xvciIsImljb24iLCJlbGVtIiwiam9pbiIsInRvcEJhciIsImZpbmQiLCJzY3JvbGwiLCJzdG9wIiwic2Nyb2xsVG9wIiwic2hvdyIsImhpZGUiLCJjc3MiLCJhcHBlbmQiLCJvbiIsIm90aGlzIiwidGhpcyIsInR5cGUiLCJhdHRyIiwiYW5pbWF0ZSIsImNsaWNrIiwiY2FsbCIsImNsZWFyVGltZW91dCIsInNldFRpbWVvdXQiLCJjb3VudGRvd24iLCJlbmRUaW1lIiwic2VydmVyVGltZSIsImNhbGxiYWNrIiwidGhhdCIsImVuZCIsIkRhdGUiLCJnZXRUaW1lIiwibm93IiwiY291bnQiLCJ0aW1lIiwiTWF0aCIsImZsb29yIiwidGltZUFnbyIsIm9ubHlEYXRlIiwiYXJyIiwic3RhbXAiLCJkaWdpdCIsImdldEZ1bGxZZWFyIiwiZ2V0TW9udGgiLCJnZXREYXRlIiwiZ2V0SG91cnMiLCJnZXRNaW51dGVzIiwiZ2V0U2Vjb25kcyIsIm51bSIsImxlbmd0aCIsInN0ciIsIlN0cmluZyIsImkiLCJwb3ciLCJ0b0RhdGVTdHJpbmciLCJmb3JtYXQiLCJyZXBsYWNlIiwiZGF0ZSIsInltZCIsImhtcyIsImVzY2FwZSIsImh0bWwiXSwibWFwcGluZ3MiOiI7RUFRQUEsTUFBTUMsT0FBTyxTQUFVLFNBQVNDLEdBQzlCLFlBRUEsSUFBSUMsR0FBSUgsTUFBTUcsRUFHYkMsR0FFQ0MsT0FBUSxTQUFTQyxHQUNmLEdBRUNDLEdBQUlDLEVBRkRDLEVBQU8sZUFBZ0JDLEVBQVUsbUJBQ3BDQyxFQUFNUixFQUFFUyxVQUFXQyxFQUFPVixFQUFF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QixNQUFPVixRQUFPVSxHQUFRLElBQUlMLFFBQVEsd0JBQXlCLFNBQzFEQSxRQUFRLEtBQU0sUUFBUUEsUUFBUSxLQUFNLFFBQ3BDQSxRQUFRLEtBQU0sU0FBU0EsUUFBUSxLQUFNLFdBSTFDdkUsR0FBUSxPQUFRRSIsImZpbGUiOiJsYXkvbW9kdWxlcy91dGlsLmpzIiwic291cmNlc0NvbnRlbnQiOlsiLyoqXG5cbiBATmFtZe+8mmxheXVpLnV0aWwg5bel5YW36ZuGXG4gQEF1dGhvcu+8mui0pOW/g1xuIEBMaWNlbnNl77yaTUlUXG4gICAgXG4qL1xuXG5sYXl1aS5kZWZpbmUoJ2pxdWVyeScsIGZ1bmN0aW9uKGV4cG9ydHMpe1xuICBcInVzZSBzdHJpY3RcIjtcbiAgXG4gIHZhciAkID0gbGF5dWkuJFxuICBcbiAgLy/lpJbpg6jmjqXlj6NcbiAgLHV0aWwgPSB7XG4gICAgLy/lm7rlrprlnZdcbiAgICBmaXhiYXI6IGZ1bmN0aW9uKG9wdGlvbnMpe1xuICAgICAgdmFyIEVMRU0gPSAnbGF5dWktZml4YmFyJywgVE9QX0JBUiA9ICdsYXl1aS1maXhiYXItdG9wJ1xuICAgICAgLGRvbSA9ICQoZG9jdW1lbnQpLCBib2R5ID0gJCgnYm9keScpXG4gICAgICAsaXMsIHRpbWVyO1xuXG4gICAgICBvcHRpb25zID0gJC5leHRlbmQoe1xuICAgICAgICBzaG93SGVpZ2h0OiAyMDAgLy/lh7rnjrBUT1DnmoTmu5rliqjmnaHpq5jluqbkuLTnlYzlgLxcbiAgICAgIH0sIG9wdGlvbnMpO1xuICAgICAgXG4gICAgICBvcHRpb25zLmJhcjEgPSBvcHRpb25zLmJhcjEgPT09IHRydWUgPyAnJiN4ZTYwNjsnIDogb3B0aW9ucy5iYXIxO1xuICAgICAgb3B0aW9ucy5iYXIyID0gb3B0aW9ucy5iYXIyID09PSB0cnVlID8gJyYjeGU2MDc7JyA6IG9wdGlvbnMuYmFyMjtcbiAgICAgIG9wdGlvbnMuYmdjb2xvciA9IG9wdGlvbnMuYmdjb2xvciA/ICgnYmFja2dyb3VuZC1jb2xvcjonICsgb3B0aW9ucy5iZ2NvbG9yKSA6ICcnO1xuICAgICAgXG4gICAgICB2YXIgaWNvbiA9IFtvcHRpb25zLmJhcjEsIG9wdGlvbnMuYmFyMiwgJyYjeGU2MDQ7J10gLy/lm77moIfvvJrkv6Hmga/jgIHpl67lj7fjgIFUT1BcbiAgICAgICxlbGVtID0gJChbJzx1bCBjbGFzcz1cIicrIEVMRU0gKydcIj4nXG4gICAgICAgICxvcHRpb25zLmJhcjEgPyAnPGxpIGNsYXNzPVwibGF5dWktaWNvblwiIGxheS10eXBlPVwiYmFyMVwiIHN0eWxlPVwiJysgb3B0aW9ucy5iZ2NvbG9yICsnXCI+JysgaWNvblswXSArJzwvbGk+JyA6ICcnXG4gICAgICAgICxvcHRpb25zLmJhcjIgPyAnPGxpIGNsYXNzPVwibGF5dWktaWNvblwiIGxheS10eXBlPVwiYmFyMlwiIHN0eWxlPVwiJysgb3B0aW9ucy5iZ2NvbG9yICsnXCI+JysgaWNvblsxXSArJzwvbGk+JyA6ICcnXG4gICAgICAgICwnPGxpIGNsYXNzPVwibGF5dWktaWNvbiAnKyBUT1BfQkFSICsnXCIgbGF5LXR5cGU9XCJ0b3BcIiBzdHlsZT1cIicrIG9wdGlvbnMuYmdjb2xvciArJ1wiPicrIGljb25bMl0gKyc8L2xpPidcbiAgICAgICwnPC91bD4nXS5qb2luKCcnKSlcbiAgICAgICx0b3BCYXIgPSBlbGVtLmZpbmQoJy4nK1RPUF9CQVIpXG4gICAgICAsc2Nyb2xsID0gZnVuY3Rpb24oKXtcbiAgICAgICAgdmFyIHN0b3AgPSBkb20uc2Nyb2xsVG9wKCk7XG4gICAgICAgIGlmKHN0b3AgPj0gKG9wdGlvbnMuc2hvd0hlaWdodCkpe1xuICAgICAgICAgIGlzIHx8ICh0b3BCYXIuc2hvdygpLCBpcyA9IDEpO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgIGlzICYmICh0b3BCYXIuaGlkZSgpLCBpcyA9IDApO1xuICAgICAgICB9XG4gICAgICB9O1xuICAgICAgaWYoJCgnLicrIEVMRU0pWzBdKSByZXR1cm47XG4gICAgICBcbiAgICAgIHR5cGVvZiBvcHRpb25zLmNzcyA9PT0gJ29iamVjdCcgJiYgZWxlbS5jc3Mob3B0aW9ucy5jc3MpO1xuICAgICAgYm9keS5hcHBlbmQoZWxlbSksIHNjcm9sbCgpO1xuICAgICAgXG4gICAgICAvL2JhcueCueWHu+S6i+S7tlxuICAgICAgZWxlbS5maW5kKCdsaScpLm9uKCdjbGljaycsIGZ1bmN0aW9uKCl7XG4gICAgICAgIHZhciBvdGhpcyA9ICQodGhpcyksIHR5cGUgPSBvdGhpcy5hdHRyKCdsYXktdHlwZScpO1xuICAgICAgICBpZih0eXBlID09PSAndG9wJyl7XG4gICAgICAgICAgJCgnaHRtbCxib2R5JykuYW5pbWF0ZSh7XG4gICAgICAgICAgICBzY3JvbGxUb3AgOiAwXG4gICAgICAgICAgfSwgMjAwKTtcbiAgICAgICAgfVxuICAgICAgICBvcHRpb25zLmNsaWNrICYmIG9wdGlvbnMuY2xpY2suY2FsbCh0aGlzLCB0eXBlKTtcbiAgICAgIH0pO1xuICAgICAgXG4gICAgICAvL1RvcOaYvuekuuaOp+WItlxuICAgICAgZG9tLm9uKCdzY3JvbGwnLCBmdW5jdGlvbigpe1xuICAgICAgICBjbGVhclRpbWVvdXQodGltZXIpO1xuICAgICAgICB0aW1lciA9IHNldFRpbWVvdXQoZnVuY3Rpb24oKXtcbiAgICAgICAgICBzY3JvbGwoKTtcbiAgICAgICAgfSwgMTAwKTtcbiAgICAgIH0pOyBcbiAgICB9XG4gICAgXG4gICAgLy/lgJLorqHml7ZcbiAgICAsY291bnRkb3duOiBmdW5jdGlvbihlbmRUaW1lLCBzZXJ2ZXJUaW1lLCBjYWxsYmFjayl7XG4gICAgICB2YXIgdGhhdCA9IHRoaXNcbiAgICAgICx0eXBlID0gdHlwZW9mIHNlcnZlclRpbWUgPT09ICdmdW5jdGlvbidcbiAgICAgICxlbmQgPSBuZXcgRGF0ZShlbmRUaW1lKS5nZXRUaW1lKClcbiAgICAgICxub3cgPSBuZXcgRGF0ZSgoIXNlcnZlclRpbWUgfHwgdHlwZSkgPyBuZXcgRGF0ZSgpLmdldFRpbWUoKSA6IHNlcnZlclRpbWUpLmdldFRpbWUoKVxuICAgICAgLGNvdW50ID0gZW5kIC0gbm93XG4gICAgICAsdGltZSA9IFtcbiAgICAgICAgTWF0aC5mbG9vcihjb3VudC8oMTAwMCo2MCo2MCoyNCkpIC8v5aSpXG4gICAgICAgICxNYXRoLmZsb29yKGNvdW50LygxMDAwKjYwKjYwKSkgJSAyNCAvL+aXtlxuICAgICAgICAsTWF0aC5mbG9vcihjb3VudC8oMTAwMCo2MCkpICUgNjAgLy/liIZcbiAgICAgICAgLE1hdGguZmxvb3IoY291bnQvMTAwMCkgJSA2MCAvL+enklxuICAgICAgXTtcbiAgICAgIFxuICAgICAgaWYodHlwZSkgY2FsbGJhY2sgPSBzZXJ2ZXJUaW1lO1xuICAgICAgIFxuICAgICAgdmFyIHRpbWVyID0gc2V0VGltZW91dChmdW5jdGlvbigpe1xuICAgICAgICB0aGF0LmNvdW50ZG93bihlbmRUaW1lLCBub3cgKyAxMDAwLCBjYWxsYmFjayk7XG4gICAgICB9LCAxMDAwKTtcbiAgICAgIFxuICAgICAgY2FsbGJhY2sgJiYgY2FsbGJhY2soY291bnQgPiAwID8gdGltZSA6IFswLDAsMCwwXSwgc2VydmVyVGltZSwgdGltZXIpO1xuICAgICAgXG4gICAgICBpZihjb3VudCA8PSAwKSBjbGVhclRpbWVvdXQodGltZXIpO1xuICAgICAgcmV0dXJuIHRpbWVyO1xuICAgIH1cbiAgICBcbiAgICAvL+afkOS4quaXtumXtOWcqOW9k+WJjeaXtumXtOeahOWkmuS5heWJjVxuICAgICx0aW1lQWdvOiBmdW5jdGlvbih0aW1lLCBvbmx5RGF0ZSl7XG4gICAgICB2YXIgdGhhdCA9IHRoaXNcbiAgICAgICxhcnIgPSBbW10sIFtdXVxuICAgICAgLHN0YW1wID0gbmV3IERhdGUoKS5nZXRUaW1lKCkgLSBuZXcgRGF0ZSh0aW1lKS5nZXRUaW1lKCk7XG4gICAgICBcbiAgICAgIC8v6L+U5Zue5YW35L2T5pel5pyfXG4gICAgICBpZihzdGFtcCA+IDEwMDAqNjAqNjAqMjQqOCl7XG4gICAgICAgIHN0YW1wID0gIG5ldyBEYXRlKHRpbWUpO1xuICAgICAgICBhcnJbMF1bMF0gPSB0aGF0LmRpZ2l0KHN0YW1wLmdldEZ1bGxZZWFyKCksIDQpO1xuICAgICAgICBhcnJbMF1bMV0gPSB0aGF0LmRpZ2l0KHN0YW1wLmdldE1vbnRoKCkgKyAxKTtcbiAgICAgICAgYXJyWzBdWzJdID0gdGhhdC5kaWdpdChzdGFtcC5nZXREYXRlKCkpO1xuICAgICAgICBcbiAgICAgICAgLy/mmK/lkKbovpPlh7rml7bpl7RcbiAgICAgICAgaWYoIW9ubHlEYXRlKXtcbiAgICAgICAgICBhcnJbMV1bMF0gPSB0aGF0LmRpZ2l0KHN0YW1wLmdldEhvdXJzKCkpO1xuICAgICAgICAgIGFyclsxXVsxXSA9IHRoYXQuZGlnaXQoc3RhbXAuZ2V0TWludXRlcygpKTtcbiAgICAgICAgICBhcnJbMV1bMl0gPSB0aGF0LmRpZ2l0KHN0YW1wLmdldFNlY29uZHMoKSk7XG4gICAgICAgIH1cbiAgICAgICAgcmV0dXJuIGFyclswXS5qb2luKCctJykgKyAnICcgKyBhcnJbMV0uam9pbignOicpO1xuICAgICAgfVxuICAgICAgXG4gICAgICAvLzMw5aSp5Lul5YaF77yM6L+U5Zue4oCc5aSa5LmF5YmN4oCdXG4gICAgICBpZihzdGFtcCA+PSAxMDAwKjYwKjYwKjI0KXtcbiAgICAgICAgcmV0dXJuICgoc3RhbXAvMTAwMC82MC82MC8yNCl8MCkgKyAn5aSp5YmNJztcbiAgICAgIH0gZWxzZSBpZihzdGFtcCA+PSAxMDAwKjYwKjYwKXtcbiAgICAgICAgcmV0dXJuICgoc3RhbXAvMTAwMC82MC82MCl8MCkgKyAn5bCP5pe25YmNJztcbiAgICAgIH0gZWxzZSBpZihzdGFtcCA+PSAxMDAwKjYwKjIpeyAvLzLliIbpkp/ku6XlhoXkuLrvvJrliJrliJpcbiAgICAgICAgcmV0dXJuICgoc3RhbXAvMTAwMC82MCl8MCkgKyAn5YiG6ZKf5YmNJztcbiAgICAgIH0gZWxzZSBpZihzdGFtcCA8IDApe1xuICAgICAgICByZXR1cm4gJ+acquadpSc7XG4gICAgICB9IGVsc2Uge1xuICAgICAgICByZXR1cm4gJ+WImuWImic7XG4gICAgICB9XG4gICAgfVxuICAgIFxuICAgIC8v5pWw5a2X5YmN572u6KGl6Zu2XG4gICAgLGRpZ2l0OiBmdW5jdGlvbihudW0sIGxlbmd0aCl7XG4gICAgICB2YXIgc3RyID0gJyc7XG4gICAgICBudW0gPSBTdHJpbmcobnVtKTtcbiAgICAgIGxlbmd0aCA9IGxlbmd0aCB8fCAyO1xuICAgICAgZm9yKHZhciBpID0gbnVtLmxlbmd0aDsgaSA8IGxlbmd0aDsgaSsrKXtcbiAgICAgICAgc3RyICs9ICcwJztcbiAgICAgIH1cbiAgICAgIHJldHVybiBudW0gPCBNYXRoLnBvdygxMCwgbGVuZ3RoKSA/IHN0ciArIChudW18MCkgOiBudW07XG4gICAgfVxuICAgIFxuICAgIC8v6L2s5YyW5Li65pel5pyf5qC85byP5a2X56ymXG4gICAgLHRvRGF0ZVN0cmluZzogZnVuY3Rpb24odGltZSwgZm9ybWF0KXtcbiAgICAgIHZhciB0aGF0ID0gdGhpc1xuICAgICAgLHRpbWUgPSB0eXBlb2YgdGltZSA9PT0gJ3N0cmluZyc/IHRpbWUucmVwbGFjZSgvLS9nLCAnLycpOnRpbWVcbiAgICAgICxkYXRlID0gbmV3IERhdGUodGltZSB8fCBuZXcgRGF0ZSgpKVxuICAgICAgLHltZCA9IFtcbiAgICAgICAgdGhhdC5kaWdpdChkYXRlLmdldEZ1bGxZZWFyKCksIDQpXG4gICAgICAgICx0aGF0LmRpZ2l0KGRhdGUuZ2V0TW9udGgoKSArIDEpXG4gICAgICAgICx0aGF0LmRpZ2l0KGRhdGUuZ2V0RGF0ZSgpKVxuICAgICAgXVxuICAgICAgLGhtcyA9IFtcbiAgICAgICAgdGhhdC5kaWdpdChkYXRlLmdldEhvdXJzKCkpXG4gICAgICAgICx0aGF0LmRpZ2l0KGRhdGUuZ2V0TWludXRlcygpKVxuICAgICAgICAsdGhhdC5kaWdpdChkYXRlLmdldFNlY29uZHMoKSlcbiAgICAgIF07XG5cbiAgICAgIGZvcm1hdCA9IGZvcm1hdCB8fCAneXl5eS1NTS1kZCBISDptbTpzcyc7XG5cbiAgICAgIHJldHVybiBmb3JtYXQucmVwbGFjZSgveXl5eS9nLCB5bWRbMF0pXG4gICAgICAucmVwbGFjZSgvTU0vZywgeW1kWzFdKVxuICAgICAgLnJlcGxhY2UoL2RkL2csIHltZFsyXSlcbiAgICAgIC5yZXBsYWNlKC9ISC9nLCBobXNbMF0pXG4gICAgICAucmVwbGFjZSgvbW0vZywgaG1zWzFdKVxuICAgICAgLnJlcGxhY2UoL3NzL2csIGhtc1syXSk7XG4gICAgfVxuICAgIFxuICAgIC8v6ZiyIHhzcyDmlLvlh7tcbiAgICAsZXNjYXBlOiBmdW5jdGlvbihodG1sKXtcbiAgICAgIHJldHVybiBTdHJpbmcoaHRtbCB8fCAnJykucmVwbGFjZSgvJig/ISM/W2EtekEtWjAtOV0rOykvZywgJyZhbXA7JylcbiAgICAgIC5yZXBsYWNlKC88L2csICcmbHQ7JykucmVwbGFjZSgvPi9nLCAnJmd0OycpXG4gICAgICAucmVwbGFjZSgvJy9nLCAnJiMzOTsnKS5yZXBsYWNlKC9cIi9nLCAnJnF1b3Q7Jyk7XG4gICAgfVxuICB9O1xuICBcbiAgZXhwb3J0cygndXRpbCcsIHV0aWwpO1xufSk7Il19
