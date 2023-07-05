;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4028)
(include sci.sh)
(use Main)
(use Location)
(use RobotPlayer)
(use Feature)
(use Sound)

(public
	bk1MusNWCU1 0
)

(instance bk1MusNWCU1 of CloseupLocation
	(properties
		heading 315
	)

	(method (init)
		(super init: 4034)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit13Butn init: global117)
		(MAN_315 init:)
	)
)

(instance exhibit13Butn of ExhibitButton
	(properties
		x 282
		y 238
		view 4057
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				0
				(manSnd play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance manSnd of Sound
	(properties
		flags 5
		number 4035
	)
)

(instance MAN_315 of Feature
	(properties
		noun 10
		nsLeft 270
		nsTop 72
		nsRight 337
		nsBottom 239
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

