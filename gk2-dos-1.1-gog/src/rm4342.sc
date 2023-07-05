;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4342)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Cursor)
(use Actor)
(use System)

(public
	rm4342 0
)

(local
	local0
)

(instance rm4342 of ExitRoom ; "Hunt Club: Front Hall"
	(properties
		modNum 430
		noun 16
		picture 4342
		south 4341 ; rm4341
	)

	(method (init)
		(self setRegions: 4599) ; clubRegion
		(super init: &rest)
		(if (gEgo has: 33) ; invXaverKeys
			(if (IsFlag 542)
				(self setScript: sPutKeysBack)
			)
		else
			(theKeys init:)
			(if (IsFlag 527)
				(GKHotCursor delete: theKeys)
			)
		)
		(fDeskDrawer init:)
		(gGame handsOn:)
	)

	(method (dispose)
		(cond
			(local0)
			((gEgo has: 33) ; invXaverKeys
				(PlayScene 3259 0 4341) ; rm4341
			)
			(else
				(PlayScene 1259 0 4341) ; rm4341
			)
		)
		(super dispose:)
	)

	(method (cue)
		((ScriptID 4599 2) dispose: delete:) ; xGoneTimer
		(= local0 1)
		(if (gEgo has: 33) ; invXaverKeys
			(PlayScene 3259 0 -1)
		else
			(PlayScene 1259 0 -1)
		)
		(PlayScene 256 0 -1)
		(PlayScene 254 0 430) ; clubFrontRm
	)
)

(instance sPutKeysBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(fDeskDrawer doVerb: 39)
			)
		)
	)
)

(instance theKeys of View
	(properties
		x 316
		y 162
		view 30259
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(= local0 1)
				(gEgo get: 33) ; invXaverKeys
				(SetFlag 544)
				(PlayScene 2259 0 430) ; clubFrontRm
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fDeskDrawer of GKFeature
	(properties
		modNum 430
	)

	(method (init)
		(self createPoly: 217 17 -3 179 -1 334 546 335 616 194 616 105)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 7 62 0 0 0 430) ; "(CLICK SOMEWHERE OTHER THAN KEYS IN XAVERS DRAWER)Nothin' there I need."
			)
			(39 ; invXaverKeys
				(= local0 1)
				(SetFlag 543)
				(gEgo put: 33) ; invXaverKeys
				(PlayScene 6259 0 430) ; clubFrontRm
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

