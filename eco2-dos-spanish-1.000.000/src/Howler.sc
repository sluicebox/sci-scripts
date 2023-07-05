;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1089)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Howler 0
)

(instance Howler of Eco2Talker
	(properties
		x 5
		y 5
		view 1089
		loop 3
		talkWidth 150
		back 14
		textX 115
		textY 12
		dftBack 14
	)

	(method (init)
		(= font gUserFont)
		(self setupTalker: 2)
		(super init: howlerBust howlerEyes howlerMouth &rest)
	)
)

(instance howlerMouth of Prop
	(properties
		nsTop 38
		nsLeft 38
		view 1089
	)
)

(instance howlerBust of Prop
	(properties
		view 1089
		loop 1
	)
)

(instance howlerEyes of Prop
	(properties
		nsTop 21
		nsLeft 35
		view 1089
		loop 2
	)
)

