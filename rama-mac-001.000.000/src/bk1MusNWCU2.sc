;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4029)
(include sci.sh)
(use Main)
(use Location)
(use RobotPlayer)
(use Feature)
(use Sound)

(public
	bk1MusNWCU2 0
)

(instance bk1MusNWCU2 of CloseupLocation
	(properties
		heading 315
	)

	(method (init)
		(super init: 4036)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit14Butn init: global117)
		(woman_315 init:)
	)
)

(instance exhibit14Butn of ExhibitButton
	(properties
		x 287
		y 238
		view 4058
	)

	(method (init)
		(super init: global117 &rest)
		(self createPoly: 282 237 319 237 282 280 319 280)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				0
				(womanSnd play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance womanSnd of Sound
	(properties
		flags 5
		number 4036
	)
)

(instance woman_315 of Feature
	(properties
		noun 11
		nsLeft 274
		nsTop 64
		nsRight 320
		nsBottom 234
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

