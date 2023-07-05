;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 550)
(include sci.sh)
(use Main)
(use Interface)
(use Print)
(use Dialog)
(use System)

(public
	Teller 0
)

(procedure (localproc_0 param1 param2 param3)
	(Memory memPOKE (+ param1 (* 2 param2)) param3)
)

(class Teller of Obj
	(properties
		query 0
		curArray 0
		arrays 0
		keys 0
		client 0
	)

	(method (init param1 param2 param3 param4)
		(= client param1)
		(= curArray param2)
		(= arrays param3)
		(if (> argc 3)
			(= keys param4)
		)
		(client actions: self)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(while 1
				(if (self respond:)
					(break)
				)
			)
		else
			(client doVerb: theVerb)
		)
	)

	(method (respond)
		(= query (self showDialog:))
		(cond
			((== query -999)
				(Platform 0 4 2 -1)
				(return 1)
			)
			((== query 999)
				(self doParent:)
				(return 0)
			)
			((and (< query 0) (not (self doChild: query)))
				(return 1)
			)
		)
		(if (< query 0)
			(= query (- query))
		)
		(if (not (client noun:))
			(Prints {You forgot to assign a noun property to your actor.})
		)
		(gMessager say: (client noun:) 5 query 0)
		(return 1)
	)

	(method (showDialog)
		(Platform 0 4 3 -1)
		(self doDialog: (if (== (WordAt arrays 0) curArray) 1 else 0) &rest)
	)

	(method (doDialog param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 [temp10 10] [temp20 10] [temp30 10] [temp40 10] [temp50 10] [temp60 10] [temp70 10] [temp80 10])
		(= temp0 [param1 (= temp2 0)])
		(= temp6 0)
		(= temp9 1)
		((= temp4 (Dialog new:)) window: gSystemWindow)
		((= temp5 (DText new:))
			text: {Ask about:}
			font: gUserFont
			setSize:
			moveTo: 4 (+ temp6 4)
		)
		(temp4 add: temp5)
		(= temp6 (temp5 nsBottom:))
		(for ((= temp1 1)) (!= (WordAt curArray temp1) 999) ((++ temp1))
			(= temp7 1)
			(for ((= temp2 1)) (and temp7 (< temp2 argc)) ((+= temp2 2))
				(if
					(and
						(== (WordAt curArray temp1) [param1 temp2])
						(not [param1 (+ temp2 1)])
					)
					(= temp7 0)
				)
			)
			(if temp7
				(if (IsObject temp5)
					(= temp6 (temp5 nsBottom:))
				)
				(= temp8 (WordAt curArray temp1))
				(Message
					msgGET
					gCurRoomNum
					(client noun:)
					2
					(if (< temp8 0)
						(- temp8)
					else
						temp8
					)
					1
					(switch temp9
						(0
							@temp10
						)
						(1
							@temp20
						)
						(2
							@temp30
						)
						(3
							@temp40
						)
						(4
							@temp50
						)
						(5
							@temp60
						)
						(6
							@temp70
						)
						(7
							@temp80
						)
					)
				)
				((= temp5 (DButton new:))
					text:
						(switch temp9
							(0
								@temp10
							)
							(1
								@temp20
							)
							(2
								@temp30
							)
							(3
								@temp40
							)
							(4
								@temp50
							)
							(5
								@temp60
							)
							(6
								@temp70
							)
							(7
								@temp80
							)
						)
					value: temp8
					font: gUserFont
					setSize:
					moveTo: 4 (+ temp6 4)
				)
				(temp4 add: temp5)
				(++ temp9)
			)
		)
		(= temp6 (temp5 nsBottom:))
		(= temp5 (DButton new:))
		(if (not temp0)
			(temp5 text: {something else} value: 999)
		else
			(temp5 text: {enough already} value: -999)
		)
		(temp5 setSize: moveTo: 4 (+ temp6 4))
		(temp4 add: temp5)
		(= temp3 (temp4 setSize: center: open: 0 -1 doit: 0))
		(cond
			((IsObject temp3)
				(if (temp3 isKindOf: DButton)
					(= temp3 (temp3 value:))
				)
			)
			(temp0
				(temp4 dispose:)
				(Platform 0 4 2 -1)
				(return -999)
			)
			(else
				(= temp3 999)
			)
		)
		(temp4 eachElementDo: #dispose 1 dispose:)
		(return temp3)
	)

	(method (doChild param1 &tmp temp0)
		(= temp0 0)
		(while (++ temp0)
			(if (== (WordAt keys temp0) param1)
				(self stuffArray: (WordAt arrays temp0) 1)
				(return 1)
			)
			(< (WordAt keys temp0) 999)
		)
		(return 1)
	)

	(method (doParent)
		(self stuffArray: (WordAt curArray 0) 0)
	)

	(method (stuffArray param1 param2)
		(if param2
			(localproc_0 param1 0 curArray)
		)
		(= curArray param1)
		(return param2)
	)
)

