;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 755)
(include sci.sh)
(use Main)
(use Window)
(use Menu)
(use System)

(public
	setControls 0
)

(local
	local0
	local1
	[local2 16]
	[local18 3]
	local21
	local22
)

(procedure (localproc_0 param1 param2 param3 param4 param5 &tmp temp0)
	(TextSize @[local2 param5] param1 param4)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(+= [local2 (+ temp0 param5)] (if (& temp0 $0001) param2 else param3))
	)
)

(procedure (localproc_1 param1 param2 param3)
	(= [local2 (+ param1 0)] (+ 50 (* (- 15 param3) 2)))
	(= [local2 (+ param1 1)] param2)
	(= [local2 (+ param1 2)] (+ [local2 (+ param1 0)] 6))
	(= [local2 (+ param1 3)] (+ [local2 (+ param1 1)] 13))
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1 temp2)
	(if (!= param1 12)
		(cond
			((< (= temp0 (/ (- 80 param2) 2)) 0)
				(= temp0 0)
			)
			((> temp0 15)
				(= temp0 15)
			)
		)
		(= temp2 (/ param1 4))
		(if (!= temp0 [local18 temp2])
			(if (& global71 $0002)
				(= temp1 [local2 (+ param1 1)])
				(localproc_1 param1 temp1 temp0)
			else
				(= temp1
					(switch temp2
						(0 23)
						(1 86)
						(2 147)
					)
				)
			)
			(DrawCel 946 0 temp0 temp1 47 -1)
			(= [local18 temp2] temp0)
			(gEgo moveSpeed: (= global289 (- 15 [local18 0])))
			(DoSound sndMASTER_VOLUME (= global319 [local18 1]))
			(if (< (= global81 (/ [local18 2] 5)) 3)
				(++ global81)
			)
		)
	)
)

(procedure (localproc_3 param1 param2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 16) ((+= temp0 4))
		(breakif
			(and
				(<= [local2 temp0] param2)
				(<= [local2 (+ temp0 1)] param1)
				(>= [local2 (+ temp0 2)] param2)
				(>= [local2 (+ temp0 3)] param1)
			)
		)
	)
	(return temp0)
)

(procedure (localproc_4 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (- (+ [local2 param1] param3) 3))
	(= temp1 (- (+ [local2 (++ param1)] param3) 2))
	(= temp2 (+ (- [local2 (++ param1)] param3) 1))
	(= temp3 (+ (- [local2 (++ param1)] param3) 2))
	(Graph grDRAW_LINE temp0 temp1 temp0 temp3 param2 -1 -1)
	(Graph grDRAW_LINE temp0 temp3 temp2 temp3 param2 -1 -1)
	(Graph grDRAW_LINE temp2 temp3 temp2 temp1 param2 -1 -1)
	(Graph grDRAW_LINE temp2 temp1 temp0 temp1 param2 -1 -1)
	(Graph grUPDATE_BOX temp0 temp1 (+ temp2 1) (+ temp3 1) 1)
)

(instance setControls of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(TheIconBar state: (& (= local0 (TheIconBar state:)) $fffe))
		(= temp0 (GetPort))
		(= temp1 (myWindow new:))
		(= local21 (gMyWindow color:))
		(= local22 (gMyWindow back:))
		(temp1 top: 46 left: 54 bottom: 155 right: 266 open:)
		(= [local18 0] (- 15 global289))
		(= [local18 1] global319)
		(= [local18 2]
			(switch global81
				(1 0)
				(2 7)
				(3 15)
			)
		)
		(DrawCel 946 0 [local18 0] 23 47 -1)
		(DrawCel 946 1 0 40 56 -1)
		(DrawCel 946 0 [local18 1] 86 47 -1)
		(DrawCel 946 1 0 103 56 -1)
		(DrawCel 946 0 [local18 2] 147 47 -1)
		(DrawCel 946 1 0 164 56 -1)
		(Display {CONTROLS} dsCOORD 74 10 dsWIDTH 75 dsFONT 0 dsCOLOR local21)
		(Display {Speed} dsCOORD 13 30 dsWIDTH 75 dsFONT 0 dsCOLOR local21)
		(Display {Volume} dsCOORD 74 30 dsWIDTH 75 dsFONT 0 dsCOLOR local21)
		(Display {Detail} dsCOORD 135 30 dsWIDTH 75 dsFONT 0 dsCOLOR local21)
		(Display {Fast} dsCOORD 38 47 dsWIDTH 75 dsFONT 4 dsCOLOR local21)
		(Display {Loud} dsCOORD 102 47 dsWIDTH 75 dsFONT 4 dsCOLOR local21)
		(Display {Normal} dsCOORD 163 47 dsWIDTH 75 dsFONT 4 dsCOLOR local21)
		(Display {Slow} dsCOORD 38 83 dsWIDTH 75 dsFONT 4 dsCOLOR local21)
		(Display {Soft} dsCOORD 102 83 dsWIDTH 75 dsFONT 4 dsCOLOR local21)
		(Display {Minimum} dsCOORD 163 83 dsWIDTH 75 dsFONT 4 dsCOLOR local21)
		(Display {OK} dsCOORD 180 97 dsWIDTH 25 dsFONT 0 dsCOLOR local21)
		(if (& global71 $0002)
			(localproc_1 0 23 [local18 0])
			(localproc_1 4 86 [local18 1])
			(localproc_1 8 147 [local18 2])
		else
			(localproc_0 {Speed} 13 30 0 0)
			(localproc_0 {Volume} 74 30 0 4)
			(localproc_0 {Detail} 135 30 0 8)
		)
		(localproc_0 {OK} 180 97 0 12)
		(repeat
			(if (& global71 $0002)
				(= local1 -1)
				(while (!= (= temp3 ((= temp2 (Event new:)) type:)) evMOUSEBUTTON)
					(temp2 dispose:)
					(= temp2 (Event new: $ffff)) ; evPEEK | evALL_EVENTS
					(temp2 localize:)
					(= temp5 (temp2 x:))
					(= temp6 (temp2 y:))
					(temp2 dispose:)
					(cond
						((== (= temp7 (localproc_3 temp5 temp6)) 12)
							(if (!= local1 12)
								(localproc_4 12 local21 0)
								(= local1 12)
							)
						)
						((proc0_15 temp7 0 4 8)
							(if (!= local1 temp7)
								(= temp9
									(+
										(= temp9 (+ [local2 (+ temp7 1)] 1))
										(/
											(+
												(-
													[local2 (+ temp7 3)]
													[local2 (+ temp7 1)]
												)
												1
											)
											2
										)
									)
								)
								(= temp10
									(+
										(= temp10 [local2 (+ temp7 0)])
										(/
											(+
												(-
													[local2 (+ temp7 2)]
													[local2 (+ temp7 0)]
												)
												1
											)
											2
										)
									)
								)
								(gGame setCursor: (= temp11 8) 1 temp9 temp10)
								(= local1 temp7)
							)
						)
						((== local1 12)
							(localproc_4 12 local22 0)
							(= local1 -1)
						)
						((proc0_15 local1 0 4 8)
							(gGame setCursor: 999 1)
							(= local1 -1)
						)
					)
				)
				(if (== local1 12)
					(temp2 dispose:)
					(break)
				)
				(temp2 localize:)
				(= temp5 (temp2 x:))
				(= temp6 (temp2 y:))
				(temp2 dispose:)
				(if (proc0_15 (= temp7 (localproc_3 temp5 temp6)) 0 4 8)
					(while (!= (= temp3 ((= temp2 (Event new:)) type:)) evMOUSERELEASE)
						(temp2 dispose:)
						(= temp2 (Event new: $ffff)) ; evPEEK | evALL_EVENTS
						(temp2 localize:)
						(= temp5 (temp2 x:))
						(= temp6 (temp2 y:))
						(temp2 dispose:)
						(if (!= temp11 999)
							(localproc_2
								temp7
								(-
									temp6
									(/
										(+
											(-
												[local2 (+ temp7 2)]
												[local2 (+ temp7 0)]
											)
											1
										)
										2
									)
								)
							)
						)
						(if
							(and
								(!= temp7 (localproc_3 temp5 temp6))
								(!= temp11 999)
							)
							(gGame setCursor: (= temp11 999) 1)
							(continue)
						)
						(if
							(and
								(== temp7 (localproc_3 temp5 temp6))
								(== temp11 999)
							)
							(gGame setCursor: (= temp11 8) 1)
						)
					)
					(temp2 dispose:)
					(gGame setCursor: 999 1)
				else
					(while (!= (= temp3 ((= temp2 (Event new:)) type:)) evMOUSERELEASE)
						(temp2 dispose:)
					)
					(temp2 dispose:)
				)
			else
				(gGame setCursor: 5 1)
				(for ((= temp8 0)) (< temp8 16) ((+= temp8 4))
					(localproc_4 temp8 local21 0)
				)
				(localproc_4 0 local21 1)
				(= local1 0)
				(repeat
					(if
						(or
							(not
								(proc0_15
									(= temp3 ((= temp2 (Event new:)) type:))
									4
									64
								)
							)
							(!= (= temp4 (temp2 message:)) KEY_ESCAPE)
						)
						(MapKeyToDir temp2)
						(= temp3 (temp2 type:))
						(or
							(and
								(== (= temp4 (temp2 message:)) KEY_RETURN)
								(== local1 12)
							)
							(
								(temp2 dispose:)
								(if (!= temp3 $0040) ; direction
									(switch temp4
										(KEY_TAB
											(= temp3 $0040) ; direction
											(= temp4 3)
										)
										(KEY_SHIFTTAB
											(= temp3 $0040) ; direction
											(= temp4 7)
										)
										(KEY_SUBTRACT
											(= temp3 $0040) ; direction
											(= temp4 5)
										)
										(KEY_ADD
											(= temp3 $0040) ; direction
											(= temp4 1)
										)
										($003d ; =
											(= temp3 $0040) ; direction
											(= temp4 1)
										)
									)
								)
								(if (== temp3 $0040) ; direction
									(switch temp4
										(3
											(localproc_4 local1 local22 1)
											(= local1 (& (+ local1 4) $000f))
											(localproc_4 local1 local21 1)
										)
										(7
											(localproc_4 local1 local22 1)
											(if (< (-= local1 4) 0)
												(= local1 12)
											)
											(localproc_4 local1 local21 1)
										)
										(1
											(localproc_2
												local1
												(-
													(-
														80
														(*
															[local18
																(/ local1 4)
															]
															2
														)
													)
													2
												)
											)
										)
										(5
											(localproc_2
												local1
												(+
													(-
														80
														(*
															[local18
																(/ local1 4)
															]
															2
														)
													)
													2
												)
											)
										)
										(8
											(localproc_4 local1 local22 1)
											(= local1 0)
											(localproc_4 0 local21 1)
										)
										(6
											(localproc_4 local1 local22 1)
											(= local1 12)
											(localproc_4 12 local21 1)
										)
									)
								)
								(continue)
							)
						)
					)
					(temp2 dispose:)
					(breakif
						(or (and (== temp4 KEY_RETURN) (== local1 12)) (== temp4 KEY_ESCAPE))
					)
				)
				(break)
			)
		)
		(temp1 dispose:)
		(SetPort temp0)
		(TheIconBar state: local0)
		(DisposeScript 755)
	)
)

