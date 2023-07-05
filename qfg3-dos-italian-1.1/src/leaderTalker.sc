;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	leaderTalker 0
)

(instance leaderTalker of GloryTalker
	(properties
		x 5
		y 2
		view 606
		loop 1
		talkWidth 260
		back 57
		textX 20
		textY 150
		frame 0
		backColor 10
	)

	(method (init)
		(super init: leaderBust leaderEyes leaderMouth &rest)
	)
)

(instance leaderMouth of Prop
	(properties
		nsTop 44
		nsLeft 42
		view 606
	)
)

(instance leaderEyes of Prop
	(properties
		nsTop 38
		nsLeft 44
		view 606
		loop 2
	)
)

(instance leaderBust of View
	(properties
		nsTop 25
		nsLeft 38
		view 606
		loop 3
	)
)

