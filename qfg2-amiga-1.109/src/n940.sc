;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 940)
(include sci.sh)
(use Main)
(use Interface)

(public
	PrintD 0
)

(procedure (PrintD args &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15)
	(= temp11 (= temp12 -1))
	(= temp3 (= temp4 (= temp5 (= temp6 0))))
	(= temp7 1)
	(= temp13 0)
	(= temp15 0)
	((= temp1 (Dialog new:)) window: gSfWin)
	(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
		(switch (= temp9 [args temp0])
			(101
				(= temp5 (temp2 nsBottom:)) ; UNINIT
				(= temp3 0)
			)
			(67
				(= temp11 [args (++ temp0)])
				(= temp12 [args (++ temp0)])
			)
			(80
				(= temp13 [args (++ temp0)])
			)
			(116
				(= temp15 [args (++ temp0)])
			)
			(else
				(++ temp0)
				(switch temp9
					(26
						((= temp2 (DText new:)) text: [args temp0])
					)
					(81
						((= temp2 (DButton new:))
							text: [args temp0]
							value: (++ temp7)
						)
					)
					(41
						((= temp2 (DEdit new:))
							text: [args temp0]
							max: [args (++ temp0)]
						)
					)
					(else
						((= temp2 (DText new:)) text: [args (-- temp0)])
					)
				)
				(if (and (< (+ temp0 1) argc) (== [args (+ temp0 1)] 4))
					(++ temp0)
					(+= temp3 [args (++ temp0)])
				)
				(if (and (< (+ temp0 1) argc) (== [args (+ temp0 1)] 3))
					(++ temp0)
					(+= temp5 [args (++ temp0)])
				)
				(temp2 setSize: moveTo: (+ temp3 4) (+ temp5 4))
				(temp1 add: temp2)
				(= temp3 (temp2 nsRight:))
			)
		)
	)
	(temp1 setSize: center:)
	(temp1
		moveTo:
			(if (== -1 temp11)
				(temp1 nsLeft:)
			else
				temp11
			)
			(if (== -1 temp12)
				(temp1 nsTop:)
			else
				temp12
			)
	)
	(if temp13
		(temp1 text: temp13)
	)
	(= temp14 (temp1 at: temp15))
	(if (not (& $0001 (temp14 state:)))
		(= temp14 0)
	)
	(= temp8 (temp1 open: (if temp13 4 else 0) -1 doit: temp14))
	(if (IsObject temp8)
		(if (temp8 isKindOf: DButton)
			(= temp8 (temp8 value:))
		else
			(= temp8 1)
		)
	)
	(temp1 dispose:)
	(return temp8)
)

