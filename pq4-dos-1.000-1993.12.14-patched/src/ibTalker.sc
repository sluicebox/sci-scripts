;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Plane)
(use Print)
(use Talker)

(public
	ibTalker 0
)

(instance ibTalker of Narrator
	(properties
		y 153
		talkWidth 316
		modeless 2
		fore 17
		back 0
	)

	(method (display param1 &tmp temp0 temp1)
		(= temp1 (Print new:))
		(temp1
			shadowText: 0
			fore: fore
			back: back
			plane: myPlane
			posn: x y
			font: font
			width: talkWidth
			addText: param1
			modeless: 2
			init:
		)
		(gPrints delete: temp1)
		(= dialog (temp1 dialog:))
	)
)

(instance myPlane of Plane
	(properties
		picture -2
	)

	(method (init)
		(= picture -2)
		(super init: &rest)
		(FrameOut)
	)
)

