;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15012)
(include sci.sh)
(use Main)
(use n011)
(use BaseRoom)
(use BaseRegion)
(use Polygon)
(use Feature)
(use Sound)

(public
	rm15012 0
)

(instance rm15012 of BaseRoom
	(properties
		BAD_SELECTOR 12
		BAD_SELECTOR 15046
		BAD_SELECTOR 15045
		BAD_SELECTOR 15048
		BAD_SELECTOR 15047
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(15008
				(= BAD_SELECTOR 2)
			)
			(15011
				(= BAD_SELECTOR 1)
			)
			(else
				(= BAD_SELECTOR 0)
			)
		)
		(if ((BaseRegion BAD_SELECTOR:) at: 13)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion BAD_SELECTOR:) at: 16)
			(+= BAD_SELECTOR 100)
		)
		(Load 140 15012) ; WAVE
		(super init:)
		(cond
			((and (== BAD_SELECTOR 0) (not ((BaseRegion BAD_SELECTOR:) at: 13)))
				(exitNDoor init:)
				(doorLatchN init:)
			)
			((and (== BAD_SELECTOR 3) (not ((BaseRegion BAD_SELECTOR:) at: 16)))
				(exitWDoor init:)
				(doorLatchW init:)
			)
			((or (== BAD_SELECTOR 1) (== BAD_SELECTOR 2))
				(exitDoor init:)
			)
		)
	)

	(method (cue)
		(cond
			((or (== BAD_SELECTOR 1) (== BAD_SELECTOR 2))
				(exitDoor init:)
				(if (gFeatures contains: exitNDoor)
					(exitNDoor dispose:)
					(doorLatchN dispose:)
				)
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
					(doorLatchW dispose:)
				)
			)
			((and (== BAD_SELECTOR 0) (not ((BaseRegion BAD_SELECTOR:) at: 13)))
				(exitNDoor init:)
				(doorLatchN init:)
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
					(doorLatchW dispose:)
				)
				(if (gFeatures contains: exitDoor)
					(exitDoor dispose:)
				)
			)
			((and (== BAD_SELECTOR 3) (not ((BaseRegion BAD_SELECTOR:) at: 16)))
				(exitWDoor init:)
				(doorLatchW init:)
				(if (gFeatures contains: exitNDoor)
					(exitNDoor dispose:)
					(doorLatchN dispose:)
				)
				(if (gFeatures contains: exitDoor)
					(exitDoor dispose:)
				)
			)
			(else
				(if (gFeatures contains: exitDoor)
					(exitDoor dispose:)
				)
				(if (gFeatures contains: exitNDoor)
					(exitNDoor dispose:)
					(doorLatchN dispose:)
				)
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
					(doorLatchW dispose:)
				)
			)
		)
	)
)

(instance exitDoor of ExitFeature
	(properties
		x 926
		y 131
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 868 23 985 23 985 240 868 240
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(switch (gCurRoom BAD_SELECTOR:)
					(1
						(sfxWolfWhine play:)
					)
					(2
						(if (== (Wolf BAD_SELECTOR:) 13)
							(BaseRegion keep: 0)
							(gGame changeScore: 1169)
							(gCurRoom
								BAD_SELECTOR:
									(gCurRoom BAD_SELECTOR:)
									(gCurRoom BAD_SELECTOR:)
							)
						else
							(sfxWolfWhine play:)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitWDoor of ExitFeature
	(properties
		x 933
		y 124
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 882 9 985 9 985 240 882 240
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom
					BAD_SELECTOR:
						(gCurRoom BAD_SELECTOR:)
						(gCurRoom BAD_SELECTOR:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorLatchW of GKFeature
	(properties
		x 812
		y 219
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 783 255 783 184 841 184 841 255
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(((BaseRegion BAD_SELECTOR:) at: (- (gCurRoom BAD_SELECTOR:) 1))
					BAD_SELECTOR:
						(gCurRoom BAD_SELECTOR:)
						(gCurRoom BAD_SELECTOR:)
				)
				(gCurRoom BAD_SELECTOR: (+ (gCurRoom BAD_SELECTOR:) 100))
				(PlayScene 915 gCurRoom)
				(gCurRoom BAD_SELECTOR:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitNDoor of ExitFeature
	(properties
		x 932
		y 119
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 879 0 985 0 985 238 879 238
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom
					BAD_SELECTOR:
						(gCurRoom BAD_SELECTOR:)
						(gCurRoom BAD_SELECTOR:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorLatchN of GKFeature
	(properties
		x 859
		y 213
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 840 252 840 175 878 175 878 252
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(((BaseRegion BAD_SELECTOR:) at: (- (gCurRoom BAD_SELECTOR:) 1))
					BAD_SELECTOR:
						(gCurRoom BAD_SELECTOR:)
						(gCurRoom BAD_SELECTOR:)
				)
				(gCurRoom BAD_SELECTOR: (+ (gCurRoom BAD_SELECTOR:) 100))
				(PlayScene 915 gCurRoom)
				(gCurRoom BAD_SELECTOR:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sfxWolfWhine of Sound
	(properties
		number 15012
	)
)

