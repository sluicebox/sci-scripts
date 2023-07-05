;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11101)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)

(public
	rm11101 0
)

(instance rm11101 of ExitRoom ; "Wittelsbacher Theater: Auditorium"
	(properties
		modNum 1110
		noun 7
		picture 11101
	)

	(method (init)
		(if (IsFlag 735)
			(self setRegions: 1101) ; resRegion
		)
		(if (== gPrevRoomNum 11301)
			(gEgo
				posn: 48 178
				BAD_SELECTOR: 135
				setScale:
				scaleX: 20
				scaleY: 20
				init:
			)
		else
			(gEgo
				posn: 165 100
				BAD_SELECTOR: 135
				setScale:
				scaleX: 20
				scaleY: 20
				init:
			)
		)
		(super init: &rest)
		(if (not (IsFlag 755))
			(SetFlag 755)
			(PlayScene 831)
		)
		(if (== gPrevRoomNum 11301)
			(botWestExit init:)
		else
			(topWestExit init:)
		)
		(seats init:)
		(vGeorg init:)
		(vForeman init:)
		(stage init:)
	)
)

(instance vGeorg of Prop
	(properties
		modNum 1110
		sightAngle 360
		x 314
		y 217
		view 21832
	)

	(method (init)
		(super init: &rest)
		(self setScript: FidgetScript)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 1 62 0 0 0 1110) ; "(THEATER AUDITORIUM. CLICK ON SECOND LEVEL DOORS)There's no easy way to get there from inside the auditorium."
			)
			(131 ; invToDoList
				(gMessager say: 1 62 0 0 0 1110) ; "(THEATER AUDITORIUM. CLICK ON SECOND LEVEL DOORS)There's no easy way to get there from inside the auditorium."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vForeman of Prop
	(properties
		modNum 1110
		sightAngle 360
		x 101
		y 48
		view 23832
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 1 62 0 0 0 1110) ; "(THEATER AUDITORIUM. CLICK ON SECOND LEVEL DOORS)There's no easy way to get there from inside the auditorium."
			)
			(131 ; invToDoList
				(gMessager say: 1 62 0 0 0 1110) ; "(THEATER AUDITORIUM. CLICK ON SECOND LEVEL DOORS)There's no easy way to get there from inside the auditorium."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stage of GKFeature
	(properties
		modNum 1110
		sightAngle 360
		x 371
		y 91
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 225 183 226 0 510 0 517 183
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 2 62 0 0 0 1110) ; "(TRY TO GET GRACE ON STAGE)I'm nervous enough. Thank God it's not ME on that stage tonight."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance seats of GKFeature
	(properties
		noun 1
		modNum 1110
		sightAngle 360
		x 257
		y 265
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 222 196 197 486 198 514 211 490 333 0 333
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance botWestExit of ExitFeature
	(properties
		x 63
		y 146
		BAD_SELECTOR 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 116 89 116 89 176 37 176
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

(instance topWestExit of ExitFeature
	(properties
		x 165
		y 66
		BAD_SELECTOR 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 134 33 196 33 196 99 134 99
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

