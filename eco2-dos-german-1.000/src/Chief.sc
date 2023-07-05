;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1329)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Chief 0
)

(instance Chief of Eco2Talker
	(properties
		x 5
		y 5
		view 1329
		loop 3
		talkWidth 150
		back 62
		textX 115
		textY 12
		dftBack 62
	)

	(method (init)
		(= font gUserFont)
		(super init: chiefBust chiefEyes chiefMouth &rest)
	)
)

(instance chiefMouth of Prop
	(properties
		nsTop 46
		nsLeft 24
		view 1329
	)
)

(instance chiefBust of Prop
	(properties
		view 1329
		loop 1
	)
)

(instance chiefEyes of Prop
	(properties
		nsTop 27
		nsLeft 23
		view 1329
		loop 2
	)
)

