;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 754)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	CPCheck 0
)

(local
	[local0 20]
	[local20 130]
	[local150 5]
	local155
	local156
	local157
	local158
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(^= [local20 (+ param1 4)] $0001)
	(= temp4 (if (& [local20 (+ param1 4)] $0001) local156 else local157))
	(= temp0 (- [local20 (+ param1 0)] 3))
	(= temp1 (- [local20 (+ param1 1)] 2))
	(= temp2 (+ [local20 (+ param1 2)] 1))
	(= temp3 (+ [local20 (+ param1 3)] 2))
	(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
	(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
	(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
	(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
	(Graph grUPDATE_BOX temp0 temp1 (+ temp2 1) (+ temp3 1) 1)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(if (& [local20 (+ param1 4)] $0002)
		(= temp6 local156)
		(= temp5 local157)
		(-- local155)
	else
		(= temp6 local157)
		(= temp5 local156)
		(++ local155)
	)
	(if (< local155 5)
		(^= [local20 (+ param1 4)] $0002)
		(= temp1 [local20 (+ param1 0)])
		(= temp2 [local20 (+ param1 1)])
		(= temp3 [local20 (+ param1 2)])
		(= temp4 (+ [local20 (+ param1 3)] 1))
		(Graph grFILL_BOX (- temp1 1) temp2 temp3 temp4 1 temp5)
		(Graph grUPDATE_BOX (- temp1 1) temp2 (+ temp3 1) (+ temp4 1) 1)
		(StrCpy @temp0 {A})
		(StrAt @temp0 0 (+ 65 (/ param1 5)))
		(Display @temp0 dsCOORD temp2 temp1 dsWIDTH 10 dsFONT 0 dsCOLOR temp6)
	else
		(-- local155)
	)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp2 (param1 x:))
	(= temp3 (param1 y:))
	(= temp4 -1)
	(for ((= temp0 0)) (< temp0 27) ((++ temp0))
		(= temp1 (* temp0 5))
		(cond
			(
				(and
					(>= temp2 [local20 (+ temp1 1)])
					(>= temp3 [local20 (+ temp1 0)])
					(< temp2 [local20 (+ temp1 3)])
					(< temp3 [local20 (+ temp1 2)])
				)
				(= temp4 temp1)
				(if (not (& [local20 (+ temp1 4)] $0001))
					(localproc_0 temp1)
				)
			)
			((& [local20 (+ temp1 4)] $0001)
				(= local158 temp1)
				(localproc_0 temp1)
			)
		)
	)
	(return temp4)
)

(procedure (localproc_3 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 [temp19 2] [temp21 504])
	(gGame setCursor: (if (HaveMouse) 999 else 5) 1)
	(= local155 (= temp9 (= temp13 (= temp2 (= temp3 0)))))
	((= temp0 (Dialog new:)) window: gSystemWindow name: {PrintD})
	(= local156 (gSystemWindow color:))
	(= local157 (gSystemWindow back:))
	(= temp1 (DText new:))
	(cond
		((u< [param2 0] 1000)
			(GetFarText [param2 0] [param2 1] @temp21)
		)
		([param2 0]
			(StrCpy @temp21 [param2 0])
		)
		(else
			(= temp21 0)
		)
	)
	(temp1 text: @temp21 font: gUserFont setSize:)
	(temp0 add: temp1)
	(temp1 moveTo: 4 4)
	(temp0 setSize:)
	(for ((= temp4 0)) (< temp4 20) ((+= temp4 5))
		(repeat
			(= [local0 (+ temp4 4)] (/ (Random 99 2599) 100))
			(for ((= temp5 0)) (< temp5 (* temp4 5)) ((+= temp5 5))
				(breakif (== [local0 (+ temp5 4)] [local0 (+ temp4 4)]))
			)
			(breakif (== temp5 temp4))
		)
	)
	(for ((= temp4 0)) (< temp4 20) ((+= temp4 5))
		(= [local0 (+ temp4 0)] (/ (= temp15 [local0 (+ temp4 4)]) 16))
		(= [local0 (+ temp4 1)] (mod temp15 16))
		(+=
			temp13
			(+
				(= [local0 (+ temp4 3)]
					(CelWide 940 [local0 (+ temp4 0)] [local0 (+ temp4 1)])
				)
				12
			)
		)
		(if
			(>
				(= temp12
					(CelHigh 940 [local0 (+ temp4 0)] [local0 (+ temp4 1)])
				)
				temp9
			)
			(= temp9 temp12)
		)
		(= [local0 (+ temp4 2)] temp12)
	)
	(-= temp13 12)
	(StrCpy @temp19 {A})
	(for ((= temp4 (= temp16 (= temp17 0)))) (< temp4 26) ((++ temp4))
		(= temp14 (* temp4 5))
		(TextSize @[local20 temp14] @temp19 0)
		(= [local20 (+ temp14 4)] 0)
		(StrAt @temp19 0 66)
		(if (< temp4 13)
			(+= temp16 (+ [local20 (+ temp14 3)] 6))
		else
			(+= temp17 (+ [local20 (+ temp14 3)] 6))
		)
	)
	(if (= temp4 (mod (= temp10 (if (< temp16 temp17) temp17 else temp16)) 13))
		(+= temp10 (- 13 temp4))
	)
	(if
		(>
			(= temp11 (if (< temp13 temp10) temp10 else temp13))
			(temp0 nsRight:)
		)
		(temp0 nsRight: temp11)
	)
	(= temp12
		(+ (temp0 nsBottom:) 16 temp9 (* (+ [local20 3] 3) 2) (CelHigh 940 2 0))
	)
	(temp0 nsBottom: temp12)
	(temp0
		nsRight: (+ 4 (temp0 nsRight:))
		nsBottom: (+ 4 (temp0 nsBottom:))
		center:
	)
	(temp0 moveTo: (temp0 nsLeft:) (temp0 nsTop:))
	(temp0 open: 0 -1)
	(= [local150 0]
		(= temp12
			(-
				(= temp12 (- (temp0 nsBottom:) (temp0 nsTop:)))
				(+ (= [local150 2] (CelHigh 940 2 0)) 3)
			)
		)
	)
	(= [local150 1]
		(-
			(- (temp0 nsRight:) (temp0 nsLeft:))
			(+ (= [local150 3] (CelWide 940 2 0)) 10)
		)
	)
	(+= [local150 2] (+ [local150 0] 1))
	(+= [local150 3] (- [local150 1] 1))
	(= [local150 4] 0)
	(DrawCel 940 2 0 [local150 1] [local150 0] -1)
	(-= temp12 24)
	(= temp11 (/ (- (- (temp0 nsRight:) (temp0 nsLeft:)) temp10) 2))
	(/= temp10 13)
	(StrCpy @temp19 {A})
	(= temp4 1)
	(= temp5 temp11)
	(while (< temp4 27)
		(if (== temp4 14)
			(= temp11 temp5)
			(+= temp12 13)
		)
		(Display @temp19 dsCOORD temp11 temp12 dsWIDTH 10 dsFONT 0 dsCOLOR local156)
		(StrAt @temp19 0 (+ 65 temp4))
		(= temp14 (* (- temp4 1) 5))
		(= [local20 (+ temp14 0)] temp12)
		(= [local20 (+ temp14 1)] temp11)
		(+= [local20 (+ temp14 2)] temp12)
		(+= [local20 (+ temp14 3)] temp11)
		(++ temp4)
		(+= temp11 temp10)
	)
	(-= temp12 (+ 21 temp9))
	(= temp11 (/ (- (- (temp0 nsRight:) (temp0 nsLeft:)) temp13) 2))
	(for ((= temp4 0)) (< temp4 20) ((+= temp4 5))
		(DrawCel 940 [local0 (+ temp4 0)] [local0 (+ temp4 1)] temp11 temp12 -1)
		(= temp5 [local0 (+ temp4 3)])
		(= [local0 (+ temp4 0)] temp12)
		(= [local0 (+ temp4 1)] temp11)
		(= [local0 (+ temp4 2)] (+ temp12 [local0 (+ temp4 2)]))
		(= [local0 (+ temp4 3)] (+ temp11 temp5))
		(+= temp11 (+ temp5 12))
	)
	(localproc_0 (= temp14 0))
	(repeat
		(= temp18 -1)
		(while
			(and
				(not (& (= temp7 ((= temp6 (Event new:)) type:)) $0101)) ; evJOYDOWN | evMOUSEBUTTON
				(!= (= temp8 (temp6 message:)) KEY_RETURN)
			)
			(MapKeyToDir temp6)
			(= temp7 (temp6 type:))
			(= temp8 (temp6 message:))
			(if (not (& temp7 $0040)) ; direction
				(cond
					((== temp8 KEY_TAB)
						(= temp7 $0040) ; direction
						(= temp8 3)
					)
					((== temp8 KEY_SHIFTTAB)
						(= temp7 $0040) ; direction
						(= temp8 7)
					)
					((and (>= temp8 KEY_a) (<= temp8 KEY_z))
						(= temp18 (- temp8 97))
					)
					((and (>= temp8 KEY_A) (<= temp8 KEY_Z))
						(= temp18 (- temp8 65))
					)
				)
			)
			(cond
				((!= -1 temp18)
					(if (>= temp14 0)
						(localproc_0 temp14)
						(= local158 temp14)
					else
						(= temp14 local158)
					)
					(= temp14 (* temp18 5))
					(localproc_0 temp14)
					(= temp18 -1)
					(localproc_1 temp14)
				)
				((and (& temp7 $0040) (OneOf temp8 1 5 3 8 7 6)) ; direction
					(if (>= temp14 0)
						(localproc_0 temp14)
						(= local158 temp14)
					else
						(= temp14 local158)
					)
					(switch temp8
						(1
							(cond
								((== temp14 130)
									(= temp14 125)
								)
								((> temp14 60)
									(-= temp14 65)
								)
								(else
									(= temp14 130)
								)
							)
						)
						(5
							(cond
								((== temp14 130)
									(= temp14 0)
								)
								((< temp14 65)
									(+= temp14 65)
								)
								(else
									(= temp14 130)
								)
							)
						)
						(3
							(if (== temp14 130)
								(= temp14 0)
							else
								(+= temp14 5)
							)
						)
						(8
							(= temp14 0)
						)
						(7
							(cond
								((== temp14 0)
									(= temp14 130)
								)
								((== temp14 130)
									(= temp14 125)
								)
								(else
									(-= temp14 5)
								)
							)
						)
						(6
							(= temp14 130)
						)
					)
					(localproc_0 temp14)
				)
			)
			(temp6 dispose:)
		)
		(if (& temp7 evMOUSEBUTTON)
			(temp6 localize:)
			(= temp14 (localproc_2 temp6))
		)
		(temp6 dispose:)
		(breakif (and (== local155 4) (== temp14 130)))
		(if
			(or
				(and (!= temp14 -1) (!= temp14 130))
				(and (& temp7 evJOYDOWN) (!= temp14 -1) (!= temp14 130))
			)
			(localproc_1 temp14)
		)
	)
	(for ((= temp4 0)) (< temp4 20) ((+= temp4 5))
		(for ((= temp14 0)) (< temp14 130) ((+= temp14 5))
			(if
				(and
					(& [local20 (+ temp14 4)] $0002)
					(== [local0 (+ temp4 4)] (/ temp14 5))
				)
				(-- local155)
				(break)
			)
		)
	)
	(if (and local155 param1)
		(Print 754 0) ; "Incorrect, please try again."
	)
	(temp0 dispose:)
	(return (== local155 0))
)

(instance CPCheck of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 [temp1 250])
		(if (u< param1 1000)
			(GetFarText param1 param2 @temp1)
		else
			(StrCpy @temp1 param1)
		)
		(for ((= temp0 3)) temp0 ((-- temp0))
			(breakif (localproc_3 (- temp0 1) @temp1))
		)
		(return temp0)
	)
)

