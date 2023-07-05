;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8122)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Polygon)
(use Feature)
(use Actor)

(public
	rm8122 0
)

(instance rm8122 of ExitRoom
	(properties
		picture 8122
		south 810 ; rm810
		west 820 ; rm820
	)

	(method (init)
		(super init: &rest)
		(exitDisplay1 init:)
		(exitDisplay2 init:)
		(lizPic init:)
		(ludPic init:)
		(frau init: setScript: FidgetScript)
	)
)

(instance exitDisplay1 of ExitFeature
	(properties
		nsLeft 160
		nsTop 19
		nsRight 212
		nsBottom 264
		nextRoomNum 820 ; rm820
		exitDir 6
	)
)

(instance exitDisplay2 of ExitFeature
	(properties
		nsLeft 212
		nsTop 19
		nsRight 298
		nsBottom 201
		nextRoomNum 830 ; rm830
		exitDir 2
	)
)

(instance lizPic of GKFeature
	(properties
		x 113
		y 89
		nextRoomNum 8140 ; rm8140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 84 38 83 141 144 134 144 41
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ludPic of GKFeature
	(properties
		x 528
		y 76
		nextRoomNum 8147 ; rm8147
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 484 27 570 19 572 134 484 132
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance frau of Prop
	(properties
		sightAngle 360
		x 519
		y 127
		priority 400
		fixPriority 1
		view 21488
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (proc11_15 8110)
					(gCurRoom newRoom: 8110) ; topic810
				else
					(gMessager say: 32 62 0 1 0 810) ; "(CLICK ON FRAU MILLER - NO DIALOGUE CURRENTLY AVAILABLE)I don't have anything to say to her at the moment."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance grace of View ; UNUSED
	(properties
		sightAngle 360
		x 62
		y 333
		view 10488
	)
)

