;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1880)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	tkrRoger 19
)

(instance tkrRoger of Talker
	(properties
		x 10
		y 25
		view 1000
		loop 5
		talkWidth 150
		textX 120
		textY 2
	)

	(method (init)
		(= font gUserFont)
		(rogEyes setLoop: (Random 2 3))
		(super init: rogBust rogEyes rogMouth &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance rogBust of Prop
	(properties
		view 1000
	)
)

(instance rogEyes of Prop
	(properties
		nsTop 21
		nsLeft 47
		view 1000
		loop 2
	)
)

(instance rogMouth of Prop
	(properties
		nsTop 35
		nsLeft 44
		view 1000
		loop 1
	)
)

