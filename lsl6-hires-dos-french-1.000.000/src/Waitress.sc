;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1242)
(include sci.sh)
(use Main)
(use LarryTalker)
(use Actor)

(public
	Waitress 20
)

(instance Waitress of LarryTalker
	(properties
		showTitle 1
		back 45
		view 98
		cel 1
		winPosn 2
	)

	(method (init)
		(= name
			(switch (gGame printLang:)
				(49 {Kellnerin})
				(33 {Serveuse})
				(else {Waitress})
			)
		)
		(super init: tMouth tBust tEyes)
	)
)

(instance tBust of Prop
	(properties
		x 2
		view 1242
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		x 10
		y 18
		view 1242
	)
)

(instance tEyes of Prop
	(properties
		x 9
		y 15
		view 1242
		loop 2
	)
)

