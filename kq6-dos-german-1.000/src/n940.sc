;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 940)
(include sci.sh)
(use Main)
(use Interface)
(use Dialog)

(public
	PrintD 0
)

(procedure (PrintD args &tmp arg theDialog theItem right bottom top left ret type theObj xDialog yDialog theTitle firstItem firstItemNum) ; UNUSED
	(= xDialog (= yDialog -1))
	(= right (= bottom (= top (= left 0))))
	(= theTitle 0)
	(= firstItemNum 0)
	((= theDialog (Dialog new:)) window: gSystemWindow)
	(for ((= arg 0)) (< arg argc) ((++ arg))
		(switch (= type [args arg])
			(109
				(= top (theItem nsBottom:)) ; UNINIT
				(= right 0)
			)
			(64
				(= xDialog [args (++ arg)])
				(= yDialog [args (++ arg)])
			)
			(77
				(= theTitle [args (++ arg)])
			)
			(124
				(= firstItemNum [args (++ arg)])
			)
			(else
				(++ arg)
				(switch type
					(23
						((= theItem (DText new:)) text: [args arg])
					)
					(78
						((= theItem (DButton new:))
							text: [args arg]
							value: [args (++ arg)]
						)
					)
					(79
						((= theItem (DIcon new:))
							view: [args arg]
							loop: [args (++ arg)]
							cel: [args (++ arg)]
						)
					)
					(38
						((= theItem (DEdit new:))
							text: [args arg]
							max: [args (++ arg)]
						)
					)
					(else
						((= theItem (DText new:)) text: [args (-- arg)])
					)
				)
				(if (and (< (+ arg 1) argc) (== [args (+ arg 1)] 1))
					(++ arg)
					(+= right [args (++ arg)])
				)
				(if (and (< (+ arg 1) argc) (== [args (+ arg 1)] 0))
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

