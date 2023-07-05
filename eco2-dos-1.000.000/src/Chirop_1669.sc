;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1669)
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
		view 1669
		loop 3
		talkWidth 150
		back 5
		textX 115
		textY 12
		dftBack 5
	)

	(method (init)
		(= font gUserFont)
		(super init: chiropBust chiropEyes chiropMouth &rest)
	)
)

(instance chiropMouth of Prop
	(properties
		nsTop 57
		nsLeft 29
		view 1669
	)
)

(instance chiropBust of Prop
	(properties
		view 1669
		loop 1
	)
)

(instance chiropEyes of Prop
	(properties
		nsTop 35
		nsLeft 36
		view 1669
		loop 2
	)
)

