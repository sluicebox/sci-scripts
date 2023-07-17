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
		(if ((BaseRegion sel_890:) at: 13)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion sel_890:) at: 16)
			(+= BAD_SELECTOR 100)
		)
		(Load 140 15012) ; WAVE
		(super init:)
		(cond
			((and (== BAD_SELECTOR 0) (not ((BaseRegion sel_890:) at: 13)))
				(exitNDoor init:)
				(doorLatchN init:)
			)
			((and (== BAD_SELECTOR 3) (not ((BaseRegion sel_890:) at: 16)))
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
			((and (== BAD_SELECTOR 0) (not ((BaseRegion sel_890:) at: 13)))
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
			((and (== BAD_SELECTOR 3) (not ((BaseRegion sel_890:) at: 16)))
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
				(switch (gCurRoom sel_879:)
					(1
						(sfxWolfWhine play:)
					)
					(2
						(if (== (Wolf sel_880:) 13)
							(BaseRegion keep: 0)
							(gGame changeScore: 1169)
							(gCurRoom
								sel_916: (gCurRoom sel_880:) (gCurRoom sel_879:)
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
				(gCurRoom sel_916: (gCurRoom sel_880:) (gCurRoom sel_879:))
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
				(((BaseRegion sel_891:) at: (- (gCurRoom sel_880:) 1))
					sel_905: (gCurRoom sel_880:) (gCurRoom sel_879:)
				)
				(gCurRoom sel_909: (+ (gCurRoom sel_909:) 100))
				(PlayScene 915 gCurRoom)
				(gCurRoom sel_878:)
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
				(gCurRoom sel_916: (gCurRoom sel_880:) (gCurRoom sel_879:))
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
				(((BaseRegion sel_891:) at: (- (gCurRoom sel_880:) 1))
					sel_905: (gCurRoom sel_880:) (gCurRoom sel_879:)
				)
				(gCurRoom sel_906: (+ (gCurRoom sel_906:) 100))
				(PlayScene 915 gCurRoom)
				(gCurRoom sel_878:)
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

