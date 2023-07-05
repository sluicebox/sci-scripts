;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1319)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Potter 0
)

(instance Potter of Eco2Talker
	(properties
		x 5
		y 5
		view 1319
		loop 3
		talkWidth 150
		back 62
		textX 115
		textY 12
		dftBack 62
	)

	(method (init)
		(= font gUserFont)
		(super init: potterBust potterEyes potterMouth &rest)
	)
)

(instance potterMouth of Prop
	(properties
		nsTop 47
		nsLeft 24
		view 1319
	)
)

(instance potterBust of Prop
	(properties
		view 1319
		loop 1
	)
)

(instance potterEyes of Prop
	(properties
		nsTop 27
		nsLeft 18
		view 1319
		loop 2
	)
)

