function checkass() {
	frm.action = "../setassistant"
}
function checkstu() {
	frm.action = "../setstudent"
}

function gorow() {
	var aa = document.getElementsByName('aa')[0].value;
	if (aa != "") {
		for (i = 0; i < t1.rows.length; i++) {
			t1.rows[i].bgColor = '';
		}
		var tr;
		tr = document.getElementById(aa).parentElement;// 返回该列的所在行tr
		tr.bgColor = "#428BCA";

		window.location.href = "#" + aa;
	}
}

function agree(){
	
}
