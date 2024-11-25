;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 995)
(include sci.sh)
(use Main)
(use Interface)
(use User)
(use Menu)
(use System)

(public
	proc995_0 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
)

(procedure (proc995_0 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 [temp24 4] [temp28 25] [temp53 25])
	(if local1
		(Graph grRESTORE_BOX local1)
		(Graph grREDRAW_BOX local11 local10 (+ local13 2) (+ local12 2) 1)
	)
	(= local14 (gMyWindow back:))
	(= local15 (gMyWindow color:))
	(= local16 (Inv textColor:))
	(= local17 (Inv lineColor:))
	(= temp20 (= temp19 (= temp1 (= temp0 0))))
	(= local2 -1)
	(= local4 (= local5 0))
	(for
		((= temp11 (gInventory first:)))
		temp11
		((= temp11 (gInventory next: temp11)))
		
		(if ((= temp2 (NodeValue temp11)) ownedBy: param1)
			(if (== (++ local2) 1)
				(= local4 temp11)
			)
			(if (> local2 0)
				(= local5 temp11)
			)
			(temp2
				state: (| (temp2 state:) $0001)
				nsRight:
					(= temp14
						(CelWide (temp2 view:) (temp2 loop:) (temp2 cel:))
					)
				nsBottom:
					(= temp15
						(CelHigh (temp2 view:) (temp2 loop:) (temp2 cel:))
					)
			)
			(if (not (& (temp2 state:) $0008))
				(if (> temp14 temp0)
					(= temp0 temp14)
				)
				(if (> temp15 temp1)
					(= temp1 temp15)
				)
			)
		else
			(temp2 state: (& (temp2 state:) $fffe))
		)
	)
	(+= temp0 4)
	(+= temp1 4)
	(StrCpy @temp28 (gInventory heading:))
	(if (not local2)
		(StrAt @temp28 (- (StrLen @temp28) 1) 32)
		(StrCat @temp28 (gInventory empty:))
	)
	(TextSize @temp24 @temp28 0 -1)
	(= temp17 (= temp7 [temp24 2]))
	(= temp16 [temp24 3])
	(if (gInventory showScore:)
		(Format @temp53 (gInventory curScore:) gScore gPossibleScore)
		(TextSize @temp24 @temp53 0 -1)
		(+= temp7 (= temp20 [temp24 2]))
		(= temp19 [temp24 3])
	)
	(+= temp7 (+ (CelHigh 941 0 0) 8))
	(= temp18 (if (< temp19 temp16) temp16 else temp19))
	(= temp13
		(= local3
			(if local2
				(/ 295 temp0)
			else
				1
			)
		)
	)
	(if (and (> local3 local2) (> local3 1))
		(= local3 local2)
	)
	(= temp12 (/ local2 local3))
	(if (or (> (- local2 (* temp12 local3)) 0) (== temp12 0))
		(++ temp12)
	)
	(if (== temp12 1)
		(if (> local2 4)
			(/= local3 2)
			(++ temp12)
			(if (& local2 $0001)
				(++ local3)
			)
		)
	else
		(= local3 (/ local2 temp12))
		(if (> (= temp6 (- local2 (* temp12 local3))) 0)
			(++ temp12)
			(repeat
				(breakif (== local3 temp13))
				(++ local3)
				(if (<= (- temp6 temp12) 0)
					(-- temp12)
					(break)
				)
			)
		)
	)
	(= temp21 (= temp8 (* temp0 local3)))
	(if (< temp8 temp18)
		(= temp8 temp18)
	)
	(+= temp7 (= temp22 (* temp1 temp12)))
	(= temp15 (CelHigh 944 0 0))
	(= temp14 (CelWide 944 0 0))
	(= local11 (/ (- 190 (+ temp7 (* temp15 2))) 2))
	(= local10 (/ (- 320 (+ temp8 (* temp14 2))) 2))
	(= local13 (+ local11 temp7 (* temp15 2)))
	(= local12 (+ local10 temp8 (* temp14 2)))
	(= local1 (Graph grSAVE_BOX local11 local10 (+ local13 2) (+ local12 2) 1))
	(Graph grFILL_BOX (+ local11 2) (+ local10 2) (+ local13 2) (+ local12 2) 1 0)
	(Graph grFILL_BOX local11 local10 local13 local12 1 local14)
	(DrawCel 944 0 0 local10 local11 -1)
	(DrawCel 944 0 1 local10 (- local13 temp15) -1)
	(DrawCel 944 0 2 (- local12 temp15) local11 -1)
	(DrawCel 944 0 3 (- local12 temp15) (- local13 temp15) -1)
	(Graph
		grDRAW_LINE
		local11
		(+ local10 temp14)
		local11
		(- local12 temp14)
		local17
		-1
		-1
	)
	(Graph
		grDRAW_LINE
		(+ local11 2)
		(+ local10 temp14)
		(+ local11 2)
		(- local12 temp14)
		local17
		-1
		-1
	)
	(Graph
		grDRAW_LINE
		(- local13 1)
		(+ local10 temp14)
		(- local13 1)
		(- local12 temp14)
		local17
		-1
		-1
	)
	(Graph
		grDRAW_LINE
		(- local13 3)
		(+ local10 temp14)
		(- local13 3)
		(- local12 temp14)
		local17
		-1
		-1
	)
	(Graph
		grDRAW_LINE
		(+ local11 temp15)
		local10
		(- local13 temp15)
		local10
		local17
		-1
		-1
	)
	(Graph
		grDRAW_LINE
		(+ local11 temp15)
		(+ local10 2)
		(- local13 temp15)
		(+ local10 2)
		local17
		-1
		-1
	)
	(Graph
		grDRAW_LINE
		(+ local11 temp15)
		(- local12 1)
		(- local13 temp15)
		(- local12 1)
		local17
		-1
		-1
	)
	(Graph
		grDRAW_LINE
		(+ local11 temp15)
		(- local12 3)
		(- local13 temp15)
		(- local12 3)
		local17
		-1
		-1
	)
	(Graph grUPDATE_BOX local11 local10 (+ local13 2) (+ local12 2) 1)
	(TextSize @temp24 @temp28 0 -1)
	(Display
		@temp28
		dsCOORD
		(/ (- 320 temp16) 2)
		(+ local11 temp15 2)
		dsWIDTH
		[temp24 3]
		dsCOLOR
		local16
		dsBACKGROUND
		-1
		dsFONT
		0
	)
	(if (gInventory showScore:)
		(TextSize @temp24 @temp53 0 -1)
		(Display
			@temp53
			dsCOORD
			(/ (- 320 temp19) 2)
			(- local13 (+ temp20 temp15))
			dsWIDTH
			[temp24 3]
			dsCOLOR
			local16
			dsBACKGROUND
			-1
			dsFONT
			0
		)
	)
	(= temp2 (gInventory at: 0)) ; Ok
	(= temp9 (- (- local12 temp14) (temp2 nsRight:)))
	(= temp10 (- (- local13 (+ temp20 temp15 4)) (temp2 nsBottom:)))
	(temp2 nsLeft: temp9 nsTop: temp10)
	(if local2
		(= temp10 (+ local11 temp17 temp15 2))
		(= temp23 (= temp9 (+ local10 temp14 2 (/ (- temp8 temp21) 2))))
		(= temp3 local3)
	)
	(for
		((= temp11 (gInventory first:)))
		temp11
		((= temp11 (gInventory next: temp11)))
		
		(if (& ((= temp2 (NodeValue temp11)) state:) $0001)
			(if (not (& (temp2 state:) $0008))
				(= temp4 (- (+ temp9 (/ temp0 2)) (/ (temp2 nsRight:) 2)))
				(= temp5 (- (+ temp10 (/ temp1 2)) (/ (temp2 nsBottom:) 2)))
				(temp2 nsLeft: temp4 nsTop: temp5)
				(if (not (-- temp3))
					(= temp3 local3)
					(= temp9 temp23)
					(+= temp10 temp1)
				else
					(+= temp9 temp0)
				)
			else
				(= temp4 (temp2 nsLeft:))
				(= temp5 (temp2 nsTop:))
			)
			(temp2
				state: (& (temp2 state:) $fffd)
				nsRight: (+ temp4 (- (temp2 nsRight:) 1))
				nsBottom: (+ temp5 (- (temp2 nsBottom:) 1))
				drawSelf:
			)
			(if (and (== temp2 param2) (& global71 $0020))
				(gGame setCursor: 5 1)
				((= local6 temp2) selector:)
				(= local7 temp11)
			)
		)
	)
)

(procedure (localproc_0 param1 param2 param3)
	(while param1
		(switch param2
			(5
				(if (== (= param3 (gInventory next: param3)) 0)
					(= param3 (gInventory first:))
					(break)
				)
			)
			(1
				(if
					(and
						(== (= param3 (gInventory prev: param3)) local4)
						(> param1 1)
					)
					(= param3 (gInventory first:))
					(break)
				)
			)
		)
		(if (& ((NodeValue param3) state:) $0001)
			(-- param1)
		)
	)
	(return param3)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(gGame setCursor: 5 1)
	(= temp0
		(+
			(= temp0 (global67 nsLeft:))
			(/ (+ (- (global67 nsRight:) temp0) 1) 2)
		)
	)
	(= temp1
		(+
			(= temp1 (global67 nsTop:))
			(/ (+ (- (global67 nsBottom:) temp1) 1) 2)
		)
	)
	(= temp5 (CelWide param1 param2 param3))
	(-= temp0 (/ temp5 2))
	(= temp4 (CelHigh param1 param2 param3))
	(-= temp1 (/ temp4 2))
	(= temp6
		(Graph
			grSAVE_BOX
			temp1
			temp0
			(= temp3 (+ temp1 temp4))
			(= temp2 (+ temp0 temp5))
			1
		)
	)
	(DrawCel param1 param2 param3 temp0 temp1 -1)
	(Graph grUPDATE_BOX temp1 temp0 temp3 temp2 1)
	(proc0_23)
	(Graph grRESTORE_BOX temp6)
	(Graph grUPDATE_BOX temp1 temp0 temp3 temp2 1)
	(gGame setCursor: global119 1)
	(return 0)
)

(class InvI of Obj
	(properties
		description 0
		owner 0
		view 0
		loop 0
		cel 0
		nsLeft 0
		nsTop 0
		nsRight 0
		nsBottom 0
		state 0
		cursor -1
		script 0
	)

	(method (check param1 param2)
		(if (self ownedBy: param2)
			(cond
				(
					(and
						(>= (param1 x:) nsLeft)
						(>= (param1 y:) nsTop)
						(<= (param1 x:) nsRight)
						(<= (param1 y:) nsBottom)
					)
					(if (not (& state $0002))
						(self selector:)
					)
				)
				((& state $0002)
					(self selector:)
				)
			)
		)
	)

	(method (selector &tmp temp0)
		(if (& state $0002)
			(= temp0 local14)
		else
			(= temp0 local15)
		)
		(^= state $0002)
		(Graph grDRAW_LINE (- nsTop 2) (- nsLeft 2) (- nsTop 2) (+ nsRight 2) temp0 -1 -1)
		(Graph
			grDRAW_LINE
			(- nsTop 2)
			(+ nsRight 2)
			(+ nsBottom 2)
			(+ nsRight 2)
			temp0
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ nsBottom 2)
			(+ nsRight 2)
			(+ nsBottom 2)
			(- nsLeft 2)
			temp0
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ nsBottom 2)
			(- nsLeft 2)
			(- nsTop 2)
			(- nsLeft 2)
			temp0
			-1
			-1
		)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) (+ nsBottom 3) (+ nsRight 3) 1)
		(if (& global71 $0020)
			(gGame
				setCursor:
					global106
					1
					(= global124 (+ nsLeft (/ (- (+ nsRight 1) nsLeft) 2)))
					(= global125 nsBottom)
			)
		)
	)

	(method (doSelection)
		(if (& state $0002)
			(if (or (== global65 (gUIcons at: 6)) (== (gInventory at: 0) self)) ; Ok
				(self selector:)
			)
			(= global67 self)
			(|= global71 $0001)
		)
	)

	(method (ownedBy id)
		(return (== owner id))
	)

	(method (moveTo id &tmp temp0)
		(if (and (== global68 self) (== owner gEgo) (!= id gEgo))
			(if (== ((gUIcons at: 5) cursor:) global119)
				(global70 state: (| (global70 state:) $0002) doSelection: 13)
				(if (!= (global70 eMessage:) 0)
					(|= global71 $0004)
				else
					(&= global71 $fffb)
				)
			)
			(= temp0 (gUIcons at: 5))
			(temp0 state: (& (temp0 state:) $fffa))
			(= global68 0)
			(= global69 -1)
		)
		(= owner id)
		(return self)
	)

	(method (showSelf)
		(PrintDC description)
	)

	(method (drawSelf)
		(DrawCel view loop cel nsLeft nsTop -1)
	)

	(method (doit)
		(localproc_1 941 0 1)
	)

	(method (useit)
		(localproc_1 941 0 1)
	)

	(method (changeState newState)
		(if script
			(script changeState: newState)
		)
	)
)

(class Inv of Set
	(properties
		normalHeading {Graham is carrying:}
		altHeading {Select the spell to cast}
		heading 0
		empty {nothing!}
		curScore {Score: %d out of %d}
		showScore 1
		mustSelect 0
		color 0
		back 7
		lineColor 0
		textColor 0
	)

	(method (init)
		(= gInventory self)
		(= heading normalHeading)
	)

	(method (ownedBy whom)
		(self firstTrue: #ownedBy whom)
	)

	(method (showSelf whom &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp0 global65)
		(= temp1 global66)
		(= temp2 global67)
		(= temp3 global68)
		(= temp6 global70)
		(= temp4 global119)
		(= global65 (= global66 (= global70 (gUIcons at: 6))))
		(= global106 (= global119 999))
		(gUIcons eachElementDo: #swapEnableBits)
		(if (not (invW doit: whom))
			(= global65 temp0)
			(= global66 temp1)
			(= global67 temp2)
			(= global68 temp3)
			(= global119 temp4)
			(= global70 temp6)
			(gGame
				setCursor:
					(= global106 global119)
					(|
						(& global71 $0004)
						(| (HaveMouse) (!= global70 (gUIcons at: 0)))
					)
			)
		else
			(= global69 (gInventory indexOf: global68))
			(= global66 temp1)
			(proc997_1 (= global67 global65) 13)
			(|= global71 $0004)
		)
		(= global70 temp6)
		(gUIcons eachElementDo: #swapEnableBits)
	)
)

(instance invW of Code
	(properties)

	(method (init param1 &tmp temp0)
		(= local8 (gMyWindow eraseOnly:))
		(gMyWindow eraseOnly: 1)
		(global70 state: (& (global70 state:) $ffef))
		(if (not (& global71 $0002))
			(|= global71 $0020)
			(gGame setCursor: global106 0)
		)
		((= local6 (gInventory at: 0)) moveTo: (User alterEgo:)) ; Ok
		(proc995_0 param1 local6 1)
	)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 [temp4 3] temp7 [temp8 2] temp10 temp11 temp12 temp13)
		(= temp13 (User controls:))
		(User controls: 0)
		(self init: param1)
		(= temp10 (gInventory first:))
		(= temp7 (= temp3 0))
		(repeat
			(if (& (&= global71 $fffe) $0002)
				(while (!= (= temp2 ((= temp0 (Event new:)) type:)) evMOUSEBUTTON)
					(temp0 dispose:)
					(= temp0 (Event new: $ffff)) ; evPEEK | evALL_EVENTS
					(temp0 localize:)
					(= global122 (temp0 x:))
					(if (< (= global123 (temp0 y:)) 0)
						(if (and local2 (& global71 $0008))
							(if (!= global106 999)
								(gGame setCursor: (= global106 999) 1)
							)
							(temp0 type: evVERB message: KEY_d)
							(proc997_0 temp0)
							(&= global71 $fffe)
						)
					else
						(|= global71 $0008)
						(if (and (== global106 999) (!= global119 global106))
							(gGame setCursor: (= global106 global119) 1)
						)
						(gInventory eachElementDo: #check temp0 param1)
					)
					(temp0 dispose:)
				)
			else
				(= temp10 local7)
				(if (not temp3)
					(= global67 (gUIcons at: 6))
				)
				(if (and (!= temp3 global67) (> global67 0))
					(= temp3 global67)
				)
				(while
					(or
						(!= (= temp2 ((= temp0 (Event new:)) type:)) evKEYBOARD)
						(not
							(proc0_15
								(= temp1 (temp0 message:))
								27
								21248
								13
								20992
								19456
							)
						)
					)
					(if (proc0_15 temp2 4 64)
						(MapKeyToDir temp0)
						(= temp2 (temp0 type:))
						(= temp1 (temp0 message:))
						(if (!= temp2 $0040) ; direction
							(switch temp1
								(KEY_TAB
									(= temp2 $0040) ; direction
									(= temp1 3)
								)
								(KEY_SHIFTTAB
									(= temp2 $0040) ; direction
									(= temp1 7)
								)
							)
						)
						(if (and (== temp2 $0040) (proc0_15 temp1 1 5 3 8 7 6)) ; direction
							(repeat
								(cond
									(
										(or
											(== local4 0)
											(and
												(== temp1 3)
												(==
													(= temp10
														(gInventory next: temp10)
													)
													0
												)
											)
											(and
												(== temp10 local4)
												(or (== temp1 7) (== temp1 1))
											)
											(and (== temp1 8) (not local3))
											(== temp1 6)
										)
										(= temp10 (gInventory first:))
									)
									(
										(or
											(== temp1 8)
											(and
												(== temp1 5)
												(== temp10 (gInventory first:))
											)
										)
										(= temp10 local4)
									)
									(
										(and
											(== temp10 (gInventory first:))
											(or (== temp1 1) (== temp1 7))
										)
										(= temp10 local5)
									)
									((== temp1 7)
										(= temp10 (gInventory prev: temp10))
									)
									((or (== temp1 1) (== temp1 5))
										(= temp10
											(localproc_0 local3 temp1 temp10)
										)
									)
								)
								(if
									(&
										((= temp11 (NodeValue temp10)) state:)
										$0001
									)
									(if (!= local6 temp11)
										(local6 selector:)
										(temp11 selector:)
										(= local6 temp11)
										(= local7 temp10)
									)
									(break)
								)
							)
						)
					)
					(temp0 dispose:)
				)
			)
			(if
				(or
					(and (== temp2 evMOUSEBUTTON) (& (temp0 modifiers:) $0007)) ; emCTRL | emSHIFT
					(and (== temp2 evKEYBOARD) (proc0_15 temp1 27 21248 20992 19456))
				)
				(proc997_0 temp0)
				(if (temp0 claimed:)
					(gGame setCursor: global119 1)
				)
				(temp0 dispose:)
			else
				(temp0 dispose:)
				(= temp12 0)
				(gInventory eachElementDo: #doSelection)
				(if (& global71 $0001)
					(if (== (gInventory indexOf: global67) 0)
						(breakif temp7)
						(&= global71 $fffe)
						(breakif (not (gInventory mustSelect:)))
						((gInventory at: 0) selector:) ; Ok
						(continue)
					)
					(switch (global65 eMessage:)
						(2
							(global67 showSelf:)
						)
						(3
							(&= global71 $fffe)
							(breakif (global67 doit:))
						)
						(5
							(&= global71 $fffe)
							(breakif (global68 useit:))
						)
						(else
							(= temp12 1)
							(= global68 (= global65 global67))
							(= temp7 (gUIcons at: 5))
							(temp7
								state: (| (temp7 state:) $0005)
								cursor: (global67 cursor:)
							)
							(if (& global71 $0020)
								(global67
									state: (& (global67 state:) $fffd)
									selector:
								)
							)
							(proc997_1 temp7 13)
							(if (& global71 $0020)
								(global68
									state: (& (global68 state:) $fffd)
									selector:
								)
							)
						)
					)
					(= global67 global65)
					(if temp12
						(= global65 temp7)
					)
				)
			)
		)
		(if (and temp7 (& global71 $0001))
			(= global65 temp7)
		)
		(Graph grRESTORE_BOX local1)
		(Graph grREDRAW_BOX local11 local10 (+ local13 2) (+ local12 2) 1)
		(= local1 0)
		(User controls: temp13)
		(global70 state: (| (global70 state:) $0010))
		(gMyWindow eraseOnly: local8)
		(return (& (&= global71 $ffdf) $0001))
	)
)

