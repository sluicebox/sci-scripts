;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1229)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Sloth 0
)

(instance Sloth of Eco2Talker
	(properties
		x 5
		y 5
		view 1229
		loop 3
		talkWidth 150
		back 90
		textX 115
		textY 12
		dftBack 90
	)

	(method (init)
		(= font gUserFont)
		(self setupTalker: 2)
		(super init: slothBust slothEyes slothMouth &rest)
	)
)

(instance slothMouth of Prop
	(properties
		nsTop 38
		nsLeft 22
		view 1229
	)
)

(instance slothBust of Prop
	(properties
		view 1229
		loop 1
	)
)

(instance slothEyes of Prop
	(properties
		nsTop 25
		nsLeft 21
		view 1229
		loop 2
	)
)

