;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1399)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Colby 0
	Simms 1
)

(instance Colby of Talker
	(properties
		x 20
		y 15
		view 1399
		cel 1
		talkWidth 150
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 0 cMouth &rest)
	)
)

(instance cMouth of Prop
	(properties
		nsTop 44
		nsLeft 33
		view 1399
		loop 1
	)
)

(instance Simms of Talker
	(properties
		x 200
		y 80
		view 1400
		cel 1
		talkWidth 150
		textX -185
		textY 30
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 0 sMouth &rest)
	)
)

(instance sMouth of Prop
	(properties
		nsTop 47
		nsLeft 36
		view 1400
		loop 1
	)
)

