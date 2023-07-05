;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3029)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use Actor)

(public
	london_WildCard 0
)

(instance london_WildCard of CloseupLocation
	(properties
		noun 15
		heading 0
	)

	(method (init)
		(self edgeW: 0 edgeE: 0)
		(super init: 3219)
		(= plane global116)
		(mystery_Box init:)
	)
)

(instance mystery_Box of View
	(properties
		x 51
		y 211
		view 3200
		loop 1
	)

	(method (init)
		(if (== (proc70_9 48) 3004)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 48)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

