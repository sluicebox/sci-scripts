;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 759)
(include sci.sh)
(use Main)
(use Interface)

(public
	PrintDC 0
)

(procedure (PrintDC param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 400] [temp405 400])
	(if (> argc 2)
		(Print param1 param2 &rest)
	else
		(if (u< param1 1000)
			(GetFarText param1 param2 @temp5)
		else
			(StrCpy @temp5 param1)
		)
		(= temp1 (StrAt @temp5 0))
		(= temp2 (StrAt @temp5 1))
		(if (<= 65 temp1 90)
			(StrAt @temp5 0 32)
			(if (== temp2 32)
				(Format @temp405 {___})
			else
				(Format @temp405 {__})
			)
			(StrCat @temp405 @temp5)
			(= temp3 (+ 0 (/ (- temp1 65) 13)))
			(= temp4 (mod (- temp1 65) 13))
			(localproc_0 @temp405 &rest 82 945 temp3 temp4 1)
		else
			(Print @temp5 &rest)
		)
	)
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 [temp12 6] temp18 temp19 temp20 [temp21 500])
	(= temp11 (GetPort))
	(= temp6 (= temp7 -1))
	(= temp9 (= temp8 (= temp18 (= temp2 (= temp3 (= temp19 0))))))
	((= temp0 (Dialog new:)) window: gSystemWindow name: {GothicD})
	(= temp1 (DText new:))
	(cond
		((u< [param1 0] 1000)
			(GetFarText [param1 0] [param1 1] @temp21)
			(= temp5 2)
		)
		([param1 0]
			(StrCpy @temp21 [param1 0])
			(= temp5 1)
		)
		(else
			(= temp21 0)
			(= temp5 0)
		)
	)
	(temp1 text: @temp21 font: gUserFont setSize:)
	(temp0 add: temp1)
	((= temp2 (DLetter new:))
		view: [param1 (++ temp5)]
		loop: [param1 (++ temp5)]
		cel: [param1 (++ temp5)]
		letter: [param1 (++ temp5)]
		setSize:
	)
	(if temp19
		(gGame setCursor: (= global106 999) (HaveMouse))
	)
	(temp1 moveTo: 4 4)
	(temp2 moveTo: 4 4)
	(temp1 moveTo: (+ 4 (temp2 nsLeft:)) (- (temp2 nsBottom:) 7))
	(temp0 add: temp2)
	(temp0 setSize:)
	(= temp20
		(if (> temp18 (temp0 nsRight:))
			4
		else
			(- (temp0 nsRight:) temp18)
		)
	)
	(for ((= temp5 0)) (< temp5 temp19) ((++ temp5))
		([temp12 temp5] moveTo: temp20 (+ 4 (temp0 nsBottom:)))
		(temp0 add: [temp12 temp5])
		(= temp20 (+ 4 ([temp12 temp5] nsRight:)))
	)
	(temp0 setSize:)
	(temp0
		nsRight: (+ 4 (temp0 nsRight:))
		nsBottom: (+ (temp0 nsBottom:) 4)
		center:
	)
	(temp0
		moveTo:
			(if (== -1 temp6)
				(temp0 nsLeft:)
			else
				temp6
			)
			(if (== -1 temp7)
				(temp0 nsTop:)
			else
				temp7
			)
	)
	(temp0 open: (if (temp0 text:) 4 else 0) (if temp9 15 else -1))
	(if temp9
		(= gModelessPort (GetPort))
		(SetPort temp11)
		(return (= gModelessDialog temp9))
	)
	(if
		(and
			(= temp10 (temp0 firstTrue: #checkState 1))
			(not (temp0 firstTrue: #checkState 2))
		)
		(temp10 state: (| (temp10 state:) $0002))
	)
	(if (== (= temp4 (temp0 doit: temp10)) -1)
		(= temp4 0)
	)
	(for ((= temp5 0)) (< temp5 temp19) ((++ temp5))
		(if (== temp4 [temp12 temp5])
			(= temp4 (temp4 value:))
			(break)
		)
	)
	(if (not (temp0 theItem:))
		(= temp4 1)
	)
	(temp0 dispose:)
	(return temp4)
)

(class DLetter of DIcon
	(properties
		letter 0
		priority -1
	)
)

