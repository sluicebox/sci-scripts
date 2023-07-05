;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1625)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Tentbat 0
)

(instance Tentbat of Eco2Talker
	(properties
		x 5
		y 5
		view 1625
		loop 3
		talkWidth 150
		back 5
		textX 115
		textY 22
		dftBack 5
	)

	(method (init)
		(= font gUserFont)
		(self setupTalker: 2)
		(super init: tentbatBust tentbatEyes tentbatMouth &rest)
	)
)

(instance tentbatMouth of Prop
	(properties
		nsTop 66
		nsLeft 25
		view 1625
	)
)

(instance tentbatBust of View
	(properties
		view 1625
		loop 1
	)
)

(instance tentbatEyes of Prop
	(properties
		nsTop 41
		nsLeft 24
		view 1625
		loop 2
	)
)

