;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9510)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	neuLRChair 0
)

(instance neuLRChair of ExitRoom
	(properties
		picture 9510
		south 950 ; rm950
	)

	(method (init)
		(super init: &rest)
		(deskTop init:)
		(chair init:)
		(door init:)
	)
)

(instance deskTop of Feature
	(properties
		noun 16
		modNum 950
		x 88
		y 257
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 43 204 111 199 179 215 75 223
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance chair of Feature
	(properties
		modNum 950
		x 232
		y 194
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 220 128 209 200 180 217 180 277 268 281 280 262 285 133 251 107
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 787)
						(= noun 20)
						(super doVerb: theVerb)
					)
					((IsFlag 734)
						(= noun 19)
						(super doVerb: theVerb)
					)
					(else
						(if (== gChapter 6)
							(SetFlag 734)
						)
						(if (== gChapter 4)
							(gMessager say: 18 62 0 1 0 modNum) ; "(LOOK AT CHAIR BEFORE PUTTING WATER ON CHAIR)I'm surprised people don't sit in these chairs when the guard's not looking."
						else
							(gMessager say: 18 62 0 0 0 modNum) ; "(LOOK AT CHAIR BEFORE PUTTING WATER ON CHAIR)I'm surprised people don't sit in these chairs when the guard's not looking."
						)
					)
				)
			)
			(100 ; invBottleOfWater
				(cond
					((not (IsFlag 731))
						(super doVerb: theVerb)
					)
					((IsFlag 786)
						(= noun 21)
						(super doVerb: theVerb)
					)
					(else
						(SetFlag 787)
						(gEgo put: 62) ; invBottleOfWater
						(PlayScene 779 0 950) ; rm950
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of ExitFeature
	(properties
		x 148
		y 107
		nextRoomNum 920 ; rm920
		exitDir 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 133 4 103 25 103 198 167 211 185 196 182 115 194 113 194 46 172 14
					yourself:
				)
		)
		(super init: &rest)
	)
)

