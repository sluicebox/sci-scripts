;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1621)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Fishbat 0
)

(instance Fishbat of Eco2Talker
	(properties
		x 5
		y 5
		view 1621
		loop 3
		talkWidth 150
		back 5
		textX 115
		textY 12
		dftBack 5
	)

	(method (init)
		(= font gUserFont)
		(self setupTalker: 2)
		(super init: fishbatBust fishbatEyes fishbatMouth &rest)
	)
)

(instance fishbatMouth of Prop
	(properties
		nsTop 58
		nsLeft 7
		view 1621
	)
)

(instance fishbatBust of View
	(properties
		view 1621
		loop 1
	)
)

(instance fishbatEyes of Prop
	(properties
		nsTop 39
		nsLeft 30
		view 1621
		loop 2
	)
)

