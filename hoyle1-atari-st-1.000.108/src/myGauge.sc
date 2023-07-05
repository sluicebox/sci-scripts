;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 897)
(include sci.sh)
(use Main)
(use CursorCoords)
(use Actor)
(use System)

(public
	myGauge 0
)

(instance myGauge of Obj
	(properties)

	(method (init param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		((= temp0 (View new:))
			posn: 110 70
			view: 700
			setLoop: param3
			setPri: 15
			init:
		)
		((= temp1 (View new:))
			posn: (+ 110 (* (- param2 1) 11)) 100
			view: 700
			setCel: 1
			setPri: 15
			init:
		)
		((= temp2 (View new:))
			posn: 103 75
			setLoop: param1
			view: 700
			setPri: 15
			init:
		)
		(proc0_5)
		(gGame setCursor: 999)
		(self doit: param2)
		(= temp3 gTheCursor)
		(gGame setCursor: 996)
		(temp1 posn: (+ 110 (* (- global429 1) 11)) 100)
		(proc0_5)
		(proc0_1 15)
		(gGame setCursor: temp3)
		(temp0 dispose:)
		(temp1 dispose:)
		(temp2 dispose:)
	)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12)
		(= temp3 global517)
		(= global517 (InputList new:))
		((= temp4 (CursorCoords new:)) cursorX: 116 cursorY: 108)
		((= temp5 (CursorCoords new:)) cursorX: 127 cursorY: 108)
		((= temp6 (CursorCoords new:)) cursorX: 138 cursorY: 108)
		((= temp7 (CursorCoords new:)) cursorX: 149 cursorY: 108)
		((= temp8 (CursorCoords new:)) cursorX: 160 cursorY: 108)
		((= temp9 (CursorCoords new:)) cursorX: 171 cursorY: 108)
		((= temp10 (CursorCoords new:)) cursorX: 182 cursorY: 108)
		((= temp11 (CursorCoords new:)) cursorX: 193 cursorY: 108)
		((= temp12 (CursorCoords new:)) cursorX: 204 cursorY: 108)
		(global517
			add: temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12
		)
		(= temp0 (Event new:))
		(while (not (temp0 claimed:))
			(= temp1 (temp0 type:))
			(MapKeyToDir temp0)
			(= temp2 (temp0 message:))
			(if (or (== temp1 evMOUSERELEASE) (== temp2 KEY_RETURN) (== temp2 KEY_INSERT))
				(temp0 claimed: 1)
				(if
					(and
						(>= (temp0 y:) 110)
						(<= (temp0 y:) 120)
						(>= (temp0 x:) 110)
						(<= (temp0 x:) 206)
					)
					(= global429 (+ (/ (- (temp0 x:) 110) 11) 1))
					(continue)
				)
				(= global429 param1)
			else
				(if (and (== temp1 evKEYBOARD) (<= JOY_NULL temp2 JOY_UPLEFT) (global517 size:))
					(global517 handleEvent: temp0)
				)
				(temp0 dispose:)
				(= temp0 (Event new:))
			)
		)
		(temp0 dispose:)
		(global517
			eachElementDo: #dispose
			delete: temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12
			dispose:
		)
		(= global517 temp3)
	)
)

