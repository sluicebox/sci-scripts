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
	((= theDialog (Dialog sel_109:)) sel_32: gSystemWindow)
	(for ((= arg 0)) (< arg argc) ((++ arg))
		(switch (= type [args arg])
			(109
				(= top (theItem sel_8:)) ; UNINIT
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
						((= theItem (DText sel_109:)) sel_23: [args arg])
					)
					(78
						((= theItem (DButton sel_109:))
							sel_23: [args arg]
							sel_74: [args (++ arg)]
						)
					)
					(79
						((= theItem (DIcon sel_109:))
							sel_2: [args arg]
							sel_3: [args (++ arg)]
							sel_4: [args (++ arg)]
						)
					)
					(38
						((= theItem (DEdit sel_109:))
							sel_23: [args arg]
							sel_34: [args (++ arg)]
						)
					)
					(else
						((= theItem (DText sel_109:)) sel_23: [args (-- arg)])
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
				(theItem sel_173: sel_175: (+ right 4) (+ top 4))
				(theDialog sel_118: theItem)
				(= right (theItem sel_9:))
			)
		)
	)
	(theDialog sel_173: sel_186:)
	(theDialog
		sel_175:
			(if (== -1 xDialog)
				(theDialog sel_7:)
			else
				xDialog
			)
			(if (== -1 yDialog)
				(theDialog sel_6:)
			else
				yDialog
			)
	)
	(if theTitle
		(theDialog sel_23: theTitle)
	)
	(= firstItem (theDialog sel_64: firstItemNum))
	(if (not (& $0001 (firstItem sel_29:)))
		(= firstItem 0)
	)
	(= ret (theDialog sel_183: (if theTitle 4 else 0) -1 sel_57: firstItem))
	(if (IsObject ret)
		(if (ret sel_114: DButton)
			(= ret (ret sel_74:))
		else
			(= ret 1)
		)
	)
	(theDialog sel_111:)
	(return ret)
)

