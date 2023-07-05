;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 315)
(include sci.sh)
(use Main)
(use Interface)

(public
	proc315_0 0
)

(procedure (proc315_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 [temp15 8] temp23 temp24 temp25 temp26 [temp27 800])
	(= temp9 (= temp10 -1))
	(= temp12 (= temp11 (= temp23 (= temp24 (= temp2 (= temp3 (= temp25 0)))))))
	((= temp0 (Dialog new:)) window: gIceWindow name: {PrintD})
	(= temp1 (DText new:))
	(cond
		((u< [param1 0] 1000)
			(GetFarText [param1 0] [param1 1] @temp27)
			(= temp8 2)
		)
		([param1 0]
			(StrCpy @temp27 [param1 0])
			(= temp8 1)
		)
		(else
			(= temp27 0)
			(= temp8 0)
		)
	)
	(temp1 text: @temp27 moveTo: 4 4 font: gUserFont setSize:)
	(temp0 add: temp1)
	(for ((= temp8 temp8)) (< temp8 argc) ((++ temp8))
		(switch [param1 temp8]
			(30
				(++ temp8)
				(temp1 mode: [param1 temp8])
			)
			(33
				(++ temp8)
				(temp1 font: [param1 temp8] setSize: temp11)
			)
			(70
				(= temp11 [param1 (++ temp8)])
				(temp1 setSize: temp11)
			)
			(25
				(++ temp8)
				(temp0 time: [param1 temp8])
			)
			(80
				(++ temp8)
				(temp0 text: [param1 temp8])
			)
			(67
				(= temp9 [param1 (++ temp8)])
				(= temp10 [param1 (++ temp8)])
			)
			(83
				(Animate (gCast elements:) 0)
			)
			(41
				(++ temp8)
				((= temp3 (DEdit new:)) text: [param1 temp8])
				(++ temp8)
				(temp3 max: [param1 temp8] setSize:)
			)
			(81
				((= [temp15 temp25] (DButton new:))
					text: [param1 (++ temp8)]
					value: [param1 (++ temp8)]
					setSize:
				)
				(+= temp23 (+ ([temp15 temp25] nsRight:) 4))
				(++ temp25)
			)
			(150
				((= [temp15 temp25] (DButton new:))
					text: [param1 (++ temp8)]
					value: [param1 (++ temp8)]
					setSize:
				)
				(+= temp24 (+ ([temp15 temp25] nsBottom:) 4))
				(++ temp25)
			)
			(82
				(if (not temp2)
					(= temp2 (DIcon new:))
				)
				(temp2
					view: [param1 (+ temp8 1)]
					loop: [param1 (+ temp8 2)]
					cel: [param1 (+ temp8 3)]
					setSize:
				)
				(+= temp8 3)
			)
			(88
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= temp12 temp0)
			)
			(35
				(++ temp8)
				(temp0 window: [param1 temp8])
			)
		)
	)
	(if temp2
		(temp2 moveTo: 4 4)
		(temp1 moveTo: (+ 4 (temp2 nsRight:)) (temp1 nsTop:))
		(temp0 add: temp2)
	)
	(temp0 setSize:)
	(if temp3
		(temp3 moveTo: (temp1 nsLeft:) (+ 4 (temp1 nsBottom:)))
		(temp0 add: temp3 setSize:)
	)
	(cond
		(temp23
			(= temp26
				(if (> temp23 (temp0 nsRight:))
					4
				else
					(- (temp0 nsRight:) temp23)
				)
			)
			(for ((= temp8 0)) (< temp8 temp25) ((++ temp8))
				([temp15 temp8] moveTo: temp26 (temp0 nsBottom:))
				(temp0 add: [temp15 temp8])
				(= temp26 (+ 4 ([temp15 temp8] nsRight:)))
			)
		)
		(temp24
			(= temp26 (+ (temp0 nsTop:) 4))
			(for ((= temp8 0)) (< temp8 temp25) ((++ temp8))
				([temp15 temp8] moveTo: (temp0 nsRight:) temp26)
				(temp0 add: [temp15 temp8])
				(= temp26 (+ 4 ([temp15 temp8] nsBottom:)))
			)
		)
	)
	(temp0 setSize: center:)
	(if (and temp2 (not (StrLen @temp27)))
		(temp2
			moveTo:
				(/
					(-
						(- (temp0 nsRight:) (temp0 nsLeft:))
						(- (temp2 nsRight:) (temp2 nsLeft:))
					)
					2
				)
				4
		)
	)
	(= temp5 (if (== temp10 -1) 0 else temp10))
	(= temp6 (- (temp0 nsBottom:) (temp0 nsTop:)))
	(if (> (+ temp5 temp6) 180)
		(-= temp5 (- (+ temp5 temp6) 180))
	)
	(if (< (+ temp5 (temp0 nsTop:)) 10)
		(+= temp5 (- (temp0 nsTop:) 10))
	)
	(temp0
		moveTo:
			(if (== -1 temp9)
				(temp0 nsLeft:)
			else
				temp9
			)
			(if temp5
				temp5
			else
				(temp0 nsTop:)
			)
	)
	(= temp14 (GetPort))
	(temp0 open: (if (temp0 text:) 4 else 0) (if temp12 15 else -1))
	(if temp12
		(= global62 (GetPort))
		(SetPort temp14)
		(return (= gModelessDialog temp12))
		(DisposeScript 315)
	)
	(if
		(and
			(= temp13 (temp0 firstTrue: #checkState 1))
			(not (temp0 firstTrue: #checkState 2))
		)
		(temp13 state: (| (temp13 state:) $0002))
	)
	(if (== (= temp7 (temp0 doit: temp13)) -1)
		(= temp7 0)
	)
	(for ((= temp8 0)) (< temp8 temp25) ((++ temp8))
		(if (== temp7 [temp15 temp8])
			(= temp7 (temp7 value:))
			(break)
		)
	)
	(if (not (temp0 theItem:))
		(= temp7 1)
	)
	(temp0 dispose:)
	(return temp7)
)

(procedure (localproc_0) ; UNUSED
	(DisposeScript 315)
)

