;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1627)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Punkbat 0
)

(instance Punkbat of Eco2Talker
	(properties
		x 5
		y 5
		view 1627
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
		(super init: punkbatBust punkbatEyes punkbatMouth &rest)
	)
)

(instance punkbatMouth of Prop
	(properties
		nsTop 71
		nsLeft 10
		view 1627
	)
)

(instance punkbatBust of Prop
	(properties
		view 1627
		loop 1
	)
)

(instance punkbatEyes of Prop
	(properties
		nsTop 44
		nsLeft 16
		view 1627
		loop 2
	)
)

