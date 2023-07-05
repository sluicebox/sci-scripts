;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2009)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use Actor)

(public
	baseCampTable 0
)

(instance baseCampTable of CloseupLocation
	(properties)

	(method (init)
		(self heading: 270)
		(super init: 2024)
	)
)

(instance data_Cube_15 of View ; UNUSED
	(properties
		x 190
		y 279
		view 2110
		loop 2
	)

	(method (init)
		(if (== (proc70_9 28) 2009)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 28)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance note_From_Nicole of View ; UNUSED
	(properties
		x 191
		y 244
		view 2110
		loop 1
	)

	(method (init)
		(if (== (proc70_9 82) 2009)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 82)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

