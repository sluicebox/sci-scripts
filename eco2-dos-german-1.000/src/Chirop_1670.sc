;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1670)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Chirop 0
)

(instance Chirop of Eco2Talker
	(properties
		x 5
		y 5
		view 1670
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
		(super init: chiroxBust chiroxEyes chiroxMouth &rest)
	)
)

(instance chiroxMouth of Prop
	(properties
		nsTop 1
		nsLeft 29
		view 1670
	)
)

(instance chiroxBust of Prop
	(properties
		view 1670
		loop 1
	)
)

(instance chiroxEyes of Prop
	(properties
		nsTop 32
		nsLeft 36
		view 1670
		loop 2
	)
)

