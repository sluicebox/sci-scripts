;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2342)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm2342 0
)

(local
	local0 = 1
)

(instance rm2342 of ExitRoom ; "Zoologischer Garten M\81nchen: Kennels"
	(properties
		modNum 230
		noun 17
		picture 2342
	)

	(method (init)
		(super init: &rest)
		(PlayScene 28)
		(SetFlag 437)
		(fMargarite init:)
		(pTags init:)
		(gGame handsOn: 0)
	)
)

(instance fMargarite of GKFeature
	(properties
		modNum 230
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				186
				237
				222
				117
				212
				91
				186
				77
				172
				1
				614
				-1
				616
				263
				588
				247
				582
				275
				584
				333
				484
				333
				484
				289
				458
				253
				442
				223
				378
				211
				306
				259
				258
				285
				230
				275
				184
				237
		)
		(pEyes init: setScript: sBlink)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (not (IsFlag 839))
				(gMessager say: 6 62 0 0 pTags 230) ; "(O.S. TO THOMAS, WITH WOLF MARGARITE)She's wearing a tag."
			else
				(PlayScene 30)
				(gEgo get: 12) ; invZooHair
				(gGame changeScore: 860)
				(SetFlag 435)
				(gCurRoom newRoom: 230) ; hellZooRm
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pTags of Prop
	(properties
		x 441
		y 247
		view 20030
		loop 1
	)

	(method (cue)
		(gGame changeScore: 839)
	)

	(method (doVerb)
		(gMessager say: 6 62 0 0 self 230) ; "(O.S. TO THOMAS, WITH WOLF MARGARITE)She's wearing a tag."
	)
)

(instance pEyes of Prop
	(properties
		x 206
		y 113
		view 20030
	)

	(method (doVerb)
		(fMargarite doVerb: &rest)
	)
)

(instance sBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pEyes cel: 3 setCycle: Beg self)
			)
			(1
				(= seconds (Random 3 10))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

