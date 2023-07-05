;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1269)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Hoatzin 0
)

(instance Hoatzin of Eco2Talker
	(properties
		x 5
		y 5
		view 1269
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
		(super init: hoatzinBust hoatzinEyes hoatzinMouth &rest)
	)
)

(instance hoatzinMouth of Prop
	(properties
		nsTop 40
		nsLeft 40
		view 1269
	)
)

(instance hoatzinBust of Prop
	(properties
		view 1269
		loop 1
	)
)

(instance hoatzinEyes of Prop
	(properties
		nsTop 32
		nsLeft 32
		view 1269
		loop 2
	)
)

