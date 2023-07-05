;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1248)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	paBird 0
)

(instance paBird of Eco2Talker
	(properties
		x 192
		y 107
		view 1248
		loop 3
		talkWidth 150
		back 90
		textX -175
		textY 10
		dftBack 90
		textSpacer 20
	)

	(method (init)
		(= font gUserFont)
		(self setupTalker: 4)
		(super init: paBirdBust paBirdEyes paBirdMouth &rest)
	)
)

(instance paBirdMouth of Prop
	(properties
		nsTop 31
		nsLeft 47
		view 1248
		loop 4
	)
)

(instance paBirdBust of Prop
	(properties
		view 1248
		loop 1
	)
)

(instance paBirdEyes of Prop
	(properties
		nsTop 10
		nsLeft 75
		view 1248
		loop 5
	)
)

