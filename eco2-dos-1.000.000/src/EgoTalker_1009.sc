;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1009)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	EgoTalker 0
)

(instance EgoTalker of Eco2Talker
	(properties
		x 5
		y 5
		view 1009
		loop 3
		talkWidth 150
		back 67
		textX 115
		textY 12
		dftBack 67
	)

	(method (init)
		(= font gUserFont)
		(super init: egoBust egoEyes egoMouth &rest)
	)
)

(instance egoMouth of Prop
	(properties
		nsTop 44
		nsLeft 22
		view 1009
	)
)

(instance egoBust of Prop
	(properties
		view 1009
		loop 1
	)
)

(instance egoEyes of Prop
	(properties
		nsTop 34
		nsLeft 31
		view 1009
		loop 2
	)
)

