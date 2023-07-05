;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1029)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Noah 0
)

(instance Noah of Eco2Talker
	(properties
		x 5
		y 5
		view 1029
		loop 3
		talkWidth 150
		back 13
		textX 115
		textY 12
		dftBack 13
	)

	(method (init)
		(= font gUserFont)
		(super init: noahBust noahEyes noahMouth &rest)
	)
)

(instance noahMouth of Prop
	(properties
		nsTop 45
		nsLeft 15
		view 1029
	)
)

(instance noahBust of Prop
	(properties
		view 1029
		loop 1
	)
)

(instance noahEyes of Prop
	(properties
		nsTop 22
		nsLeft 14
		view 1029
		loop 2
	)
)

