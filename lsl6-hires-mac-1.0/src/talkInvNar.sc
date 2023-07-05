;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1826)
(include sci.sh)
(use Main)
(use LarryTalker)
(use Print)

(public
	talkInvNar 98
)

(instance talkInvNar of LarryTalker
	(properties)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0 temp1)
		(if (> (+ x talkWidth) 318)
			(= temp0 (- 318 x))
		else
			(= temp0 talkWidth)
		)
		((= temp1 (Print new:))
			addTitle: (global186 data:)
			fore: fore
			back: back
			posn: x y
			font: font
			width: temp0
			addText: param1
			modeless: 2
			init:
		)
		(gPrints delete: temp1)
		(= dialog (temp1 dialog:))
	)

	(method (dispose)
		(Print title: 0)
		(super dispose: &rest)
	)
)

