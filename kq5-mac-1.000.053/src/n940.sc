;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 940)
(include sci.sh)
(use Main)
(use Interface)

(public
	PrintD 0
)

(procedure (PrintD args &tmp arg theDialog theItem right bottom top left ret type theObj xDialog yDialog theTitle firstItem firstItemNum)
	(= xDialog (= yDialog -1))
	(= right (= bottom (= top (= left 0))))
	(= theTitle 0)
	(= firstItemNum 0)
	((= theDialog (Dialog new:)) window: gSystemWindow)
	(for ((= arg 0)) (< arg argc) ((++ arg))
		(switch (= type [args arg])
			(106
				(= top (theItem nsBottom:)) ; UNINIT
				(= right 0)
			)
			(67
				(= xDialog [args (++ arg)])
				(= yDialog [args (++ arg)])
			)
			(80
				(= theTitle [args (++ arg)])
			)
			(121
				(= firstItemNum [args (++ arg)])
			)
			(else
				(++ arg)
				(switch type
					(26
						((= theItem (DText new:)) text: [args arg])
					)
					(81
						((= theItem (DButton new:))
							text: [args arg]
							value: [args (++ arg)]
						)
					)
					(82
						((= theItem (DIcon new:))
							view: [args arg]
							loop: [args (++ arg)]
							cel: [args (++ arg)]
						)
					)
					(41
						((= theItem (DEdit new:))
							text: [args arg]
							max: [args (++ arg)]
						)
					)
					(else
						((= theItem (DText new:)) text: [args (-- arg)])
					)
				)
				(if (and (< (+ arg 1) argc) (== [args (+ arg 1)] 4))
					(++ arg)
					(+= right [args (++ arg)])
				)
				(if (and (< (+ arg 1) argc) (== [args (+ arg 1)] 3))
					(++ arg)
					(+= top [args (++ arg)])
				)
				(theItem setSize: moveTo: (+ right 4) (+ top 4))
				(theDialog add: theItem)
				(= right (theItem nsRight:))
			)
		)
	)
	(theDialog setSize: center:)
	(theDialog
		moveTo:
			(if (== -1 xDialog)
				(theDialog nsLeft:)
			else
				xDialog
			)
			(if (== -1 yDialog)
				(theDialog nsTop:)
			else
				yDialog
			)
	)
	(if theTitle
		(theDialog text: theTitle)
	)
	(= firstItem (theDialog at: firstItemNum))
	(if (not (& $0001 (firstItem state:)))
		(= firstItem 0)
	)
	(= ret (theDialog open: (if theTitle 4 else 0) -1 doit: firstItem))
	(if (IsObject ret)
		(if (ret isKindOf: DButton)
			(= ret (ret value:))
		else
			(= ret 1)
		)
	)
	(theDialog dispose:)
	(return ret)
)

