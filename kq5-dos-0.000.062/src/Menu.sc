;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use User)
(use System)

(public
	proc997_0 0
	proc997_1 1
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp2 (+ (global68 view:) 1))
	(= temp3 (global68 loop:))
	(= temp4 (global68 cel:))
	(= temp0
		(-
			(= temp0 (+ (param1 nsLeft:) (/ param3 2)))
			(/ (CelWide temp2 temp3 temp4) 2)
		)
	)
	(= temp1
		(-
			(= temp1 (+ (param1 nsTop:) (/ param2 2)))
			(/ (CelHigh temp2 temp3 temp4) 2)
		)
	)
	(DrawCel temp2 temp3 temp4 temp0 temp1 -1)
)

(procedure (proc997_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
	(&= global71 $fffe)
	(cond
		((TheIconBar iBActivateChk: param1)
			(TheIconBar state: (| (TheIconBar state:) $0002))
			(= global67 -1)
			(if (not (& global71 $0002))
				(= temp8 0)
				(for
					((= temp3 (gUIcons first:)))
					temp3
					((= temp3 (gUIcons next: temp3)))
					
					(if (& ((= temp4 (NodeValue temp3)) state:) $0001)
						(cond
							((== global65 temp4)
								(= temp8 global65)
								(break)
							)
							((not temp8)
								(= temp8 temp4)
								(break)
							)
						)
					)
				)
				(temp8 selector:)
				(repeat
					(if (proc0_15 ((= temp0 (Event new:)) type:) 4 64)
						(if (not (proc0_15 (temp0 message:) 19456 20992))
							(MapKeyToDir temp0)
						)
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
						(breakif
							(and (!= temp2 $0040) (proc0_15 temp1 27 13 21248)) ; direction
						)
						(if
							(and
								temp3
								(== temp2 $0040) ; direction
								(or (== temp1 7) (== temp1 3))
							)
							(repeat
								(cond
									(
										(and
											(== temp1 3)
											(==
												(= temp3 (gUIcons next: temp3))
												0
											)
										)
										(= temp3 (gUIcons first:))
									)
									(
										(and
											(== temp1 7)
											(==
												(= temp3 (gUIcons prev: temp3))
												0
											)
										)
										(= temp3 (gUIcons last:))
									)
								)
								(= temp5 (NodeValue temp3))
								(if (& (temp5 state:) $0001)
									(if (!= temp4 temp5)
										(temp4 selector:)
										(temp5 selector:)
										(= temp4 temp5)
									)
									(break)
								)
							)
						)
					)
					(temp0 dispose:)
				)
			else
				(= global67 0)
				(while (or (!= evMOUSEBUTTON ((= temp0 (Event new:)) type:)) (not global67))
					(gUIcons eachElementDo: #check temp0)
					(breakif (>= (temp0 y:) 27))
					(temp0 dispose:)
				)
				(= temp1 KEY_RETURN)
			)
			(TheIconBar hide: state: (& (TheIconBar state:) $fffd))
			(if (proc0_15 temp1 27 21248)
				(|= global71 $0010)
			)
			(&= global71 $fffe)
			(gUIcons eachElementDo: #doSelection temp1)
			(if (proc0_15 temp1 27 21248)
				(&= global71 $ffef)
			)
			(temp0 dispose:)
		)
		(
			(or
				(and (== (param1 type:) 4) (== (param1 message:) 20992))
				(and (== (param1 type:) 1) (& (param1 modifiers:) $0004))
			)
			(|= global71 $0010)
			(param1 claimed: 1)
			(= global67 0)
			(cond
				(
					(and
						(== global65 global70)
						(!= global66 global65)
						(!= (global66 eMessage:) 0)
						(not (& (global66 state:) $0010))
						(& (global66 state:) $0001)
					)
					(= global67 global66)
				)
				((and (!= global65 global70) (& (global70 state:) $0001))
					(= global67 global70)
				)
			)
			(if global67
				(global67 state: (| (global67 state:) $0002) doSelection: 13)
			)
		)
		(
			(or
				(and (== (param1 type:) 4) (== (param1 message:) 19456))
				(and (== (param1 type:) 1) (& (param1 modifiers:) $0003))
			)
			(|= global71 $0010)
			(param1 claimed: 1)
			(repeat
				(for
					((= temp3 (gUIcons first:)))
					temp3
					((= temp3 (gUIcons next: temp3)))
					
					(breakif (== global65 (NodeValue temp3)))
				)
				(repeat
					(if (== (= temp3 (gUIcons next: temp3)) 0)
						(= temp3 (gUIcons first:))
					)
					(breakif (== (= global67 (NodeValue temp3)) global65))
					(if
						(and
							(not (& (global67 state:) $0010))
							(& (global67 state:) $0001)
							(or
								(!= (global67 eMessage:) 0)
								(== global67 global70)
							)
						)
						(global67
							state: (| (global67 state:) $0002)
							doSelection: 13
						)
						(break)
					)
				)
				(breakif (== (param1 type:) 4))
				(= temp7 (GetTime))
				(= temp6 1)
				(while temp6
					(= temp6 (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE))
					(temp0 dispose:)
					(breakif (> (Abs (- (GetTime) temp7)) 20))
				)
				(breakif (not temp6))
			)
		)
	)
	(if (and (param1 claimed:) (not (& global71 $0011)))
		(if (& (global65 state:) $0010)
			(= global67 global66)
		else
			(= global67 global65)
		)
		(global67 state: (| (global67 state:) $0002) doSelection: 13)
	)
	(&= global71 $ffef)
)

(procedure (proc997_1 param1 param2 &tmp temp0 temp1 temp2)
	(param1 state: (& (param1 state:) $fffd))
	(if (== param2 13)
		(= temp0 (Event new: -1))
		(temp0 localize:)
		(= temp1 (temp0 x:))
		(if (< (= temp2 (temp0 y:)) 0)
			(= temp2 0)
		)
		(if (& (param1 state:) $0010)
			(gGame setCursor: global106 0 temp1 temp2)
		else
			(= global106
				(if
					(and
						(== (= global119 (param1 cursor:)) 996)
						(not (HaveMouse))
					)
					5
				else
					global119
				)
			)
			(if (& global71 $0010)
				(gGame setCursor: global106 (not (& global71 $0020)))
			else
				(if (not (& global71 $0002))
					(= temp1 global124)
					(= temp2 global125)
				)
				(gGame
					setCursor: global106 (not (& global71 $0020)) temp1 temp2
				)
			)
			(if (and (!= global65 param1) (gUIcons contains: global65))
				(cond
					((!= (global65 eMessage:) 0)
						(= global66 global65)
					)
					((!= (param1 eMessage:) 0)
						(= global66 param1)
					)
				)
				(= global65 param1)
				(if (== (param1 eMessage:) 0)
					(= global70 param1)
					(= global72 (== param1 (gUIcons at: 1)))
				)
			)
		)
		(= global67 param1)
		(|= global71 $0001)
		(temp0 dispose:)
	)
)

(class Class_997_0 of Obj
	(properties
		state 0
		underBits 0
		port 0
		height 0
		barColor 0
		shadowColor 0
		selBoxColor 7
	)

	(method (draw)
		(cls)
		(= port (GetPort))
		(SetPort -10 0 190 320 0 0)
		(= underBits (Graph grSAVE_BOX 10 0 height 320 1))
	)

	(method (hide)
		(Graph grFILL_BOX 0 0 10 320 1 shadowColor)
		(Graph grRESTORE_BOX underBits)
		(Graph grUPDATE_BOX 0 0 height 320 1)
		(SetPort port)
		(SetPort 0 0 190 320 10 0)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (event type:))
		(= temp1 (event message:))
		(if
			(or
				(and (== temp0 evVERB) (== temp1 KEY_d))
				(and (== temp0 evKEYBOARD) (proc0_15 temp1 27 21248))
			)
			(event claimed: 1)
			(if (& state $0001)
				(self draw:)
				(= temp5 (PicNotValid))
				(PicNotValid 1)
				(= temp2 (gUIcons first:))
				(= temp4 0)
				(while temp2
					((= temp3 (NodeValue temp2)) draw: temp4)
					(= temp4 (+ (temp3 nsRight:) 1))
					(= temp2 (gUIcons next: temp2))
				)
				(PicNotValid temp5)
				(Graph grUPDATE_BOX 0 0 height 320 1)
				(if (!= (event type:) evVERB)
					(&= global71 $fffd)
				else
					(|= global71 $0002)
				)
				(if (not (& global71 $0002))
					(gGame setCursor: 5 1)
				)
			else
				(return 0)
			)
		)
		(event claimed:)
	)
)

(class TheIconBar of Class_997_0
	(properties)

	(method (iBActivateChk param1)
		(super handleEvent: param1)
	)

	(method (handleEvent event)
		(if (and (not (event claimed:)) (User canInput:) (& state $0001))
			(proc997_0 event)
			(if (event claimed:)
				(if (and (IsObject global67) (!= (global67 eMessage:) 0))
					(if (& (global67 state:) $0010)
						(gGame setCursor: (= global106 999) (HaveMouse))
						(event
							type: (global67 eType:)
							message: (global67 eMessage:)
							modifiers: (global67 eModifiers:)
							claimed: 0
						)
					else
						(|= global71 $0004)
					)
				else
					(&= global71 $fffb)
				)
			)
		)
	)
)

(class UIcons of Set
	(properties)

	(method (init)
		(= gUIcons self)
	)
)

(class IconI of Obj
	(properties
		view -1
		loop -1
		cel -1
		nsLeft 0
		nsTop -1
		nsRight 0
		nsBottom 0
		state 1
		cursor -1
		eType 16384
		eMessage -1
		eModifiers 0
	)

	(method (draw param1 &tmp temp0 [temp1 4] temp5)
		(= temp0 (gUIcons indexOf: self))
		(if (or (== nsTop -1) (not (& state $0001)))
			(= temp5 (CelWide view loop cel))
		)
		(if (== nsTop -1)
			(= nsTop 0)
			(= nsLeft param1)
			(= nsBottom (- (+ nsTop (TheIconBar height:)) 1))
			(= nsRight (- (+ nsLeft temp5) 1))
		)
		(DrawCel view loop cel nsLeft nsTop -1)
		(if (and (== temp0 5) global68)
			(localproc_0 self (CelHigh view loop cel) (CelWide view loop cel))
		)
		(if (not (& state $0001))
			(DrawCel 942 3 11 param1 nsTop -1)
			(= param1 (- (- nsRight (CelWide 942 3 11)) 0))
			(DrawCel 942 3 11 param1 nsTop -1)
		)
		(&= state $fffd)
	)

	(method (check param1)
		(if (& state $0001)
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

	(method (selector &tmp temp0 temp1)
		(= temp1 (<< $0001 (gUIcons indexOf: self)))
		(if (& state $0002)
			(= temp0 (TheIconBar barColor:))
			(&= global67 (~ temp1))
		else
			(= temp0 (TheIconBar selBoxColor:))
			(|= global67 temp1)
		)
		(^= state $0002)
		(Graph grDRAW_LINE (+ nsTop 1) (+ nsLeft 1) (+ nsTop 1) (- nsRight 1) temp0 -1 -1)
		(Graph
			grDRAW_LINE
			(+ nsTop 2)
			(- nsRight 1)
			(- nsBottom 2)
			(- nsRight 1)
			temp0
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- nsBottom 2)
			(- nsRight 2)
			(- nsBottom 2)
			(+ nsLeft 1)
			temp0
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- nsBottom 3)
			(+ nsLeft 1)
			(+ nsTop 2)
			(+ nsLeft 1)
			temp0
			-1
			-1
		)
		(Graph grUPDATE_BOX (+ nsTop 1) (+ nsLeft 1) (- nsBottom 1) nsRight 1)
		(if (not (& global71 $0002))
			(gGame
				setCursor:
					999
					1
					(+ nsLeft (/ (- (+ nsRight 1) nsLeft) 2))
					(- nsBottom 2)
			)
		)
	)

	(method (doSelection param1)
		(if (& state $0002)
			(proc997_1 self param1)
		)
	)

	(method (swapEnableBits &tmp temp0)
		(= temp0 state)
		(&= state $fffa)
		(if (& temp0 $0001)
			(|= state $0004)
		)
		(if (& temp0 $0004)
			(|= state $0001)
		)
	)
)

