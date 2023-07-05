;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1885)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Droole 21
)

(instance Droole of Talker
	(properties
		x 10
		y 25
		view 1004
		loop 4
		talkWidth 150
		textX 120
		textY 10
	)

	(method (init)
		(= font gUserFont)
		(drooleEyes setLoop: (Random 2 3))
		(super init: drooleBust drooleEyes drooleMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance drooleBust of Prop
	(properties
		view 1004
	)
)

(instance drooleEyes of Prop
	(properties
		nsTop 12
		nsLeft 50
		view 1004
		loop 2
	)
)

(instance drooleMouth of Prop
	(properties
		nsTop 32
		nsLeft 47
		view 1004
		loop 1
	)
)

