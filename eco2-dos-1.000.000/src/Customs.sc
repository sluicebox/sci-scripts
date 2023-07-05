;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1109)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Customs 0
)

(instance Customs of Eco2Talker
	(properties
		x 5
		y 5
		view 1109
		loop 3
		talkWidth 150
		back 90
		textX 115
		textY 12
		dftBack 90
	)

	(method (init)
		(= font gUserFont)
		(super init: customsBust customsEyes customsMouth &rest)
	)
)

(instance customsMouth of Prop
	(properties
		nsTop 54
		nsLeft 22
		view 1109
	)
)

(instance customsBust of Prop
	(properties
		view 1109
		loop 1
	)
)

(instance customsEyes of Prop
	(properties
		nsTop 38
		nsLeft 36
		view 1109
		loop 2
	)
)

