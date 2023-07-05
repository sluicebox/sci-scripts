;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 544)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	vgRm 0
)

(instance vgRm of ExitRoom ; "Hunting Lodge: Von Glower's Bedroom"
	(properties
		modNum 544
		noun 3
		picture 55501
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 658)
			(gSoundManager stop:)
			(PlayScene 648 0 631) ; hwoods7Rm
		else
			(gEgo
				posn: 351 256
				heading: 135
				BAD_SELECTOR:
				setScaler: Scaler 86 71 289 257
				init:
			)
			(if (not (IsFlag 673))
				(PlayScene 647)
				(SetFlag 673)
			)
			(fDoor init:)
			(fBed init:)
			(fShrank init:)
			(fBathroom init:)
			(pVonGlower init: setScript: sVonGlowerFidget)
			(gGame handsOn:)
		)
	)
)

(instance fWindow of ExitFeature ; UNUSED
	(properties
		sightAngle 360
		BAD_SELECTOR 6
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 0 53 0 53 254 0 226)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 1 62) ; "(LODGE VON GLOWER'S BEDROOM, CLICK ON BATHROOM, SHRANK, ETC.)Friedrick wouldn't appreciate me messin' around in here."
		else
			(super doVerb: &rest)
		)
	)
)

(instance fDoor of ExitFeature
	(properties
		sightAngle 360
		approachX 313
		approachY 225
		BAD_SELECTOR 6
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 304 223 371 218 371 73 304 77)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 530) ; hallRm
		else
			(super doVerb: &rest)
		)
	)
)

(instance fBed of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				1
				230
				71
				194
				83
				228
				97
				226
				94
				235
				270
				219
				304
				227
				323
				214
				356
				218
				383
				243
				447
				295
				453
				273
				465
				276
				470
				331
				0
				332
		)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 1 62) ; "(LODGE VON GLOWER'S BEDROOM, CLICK ON BATHROOM, SHRANK, ETC.)Friedrick wouldn't appreciate me messin' around in here."
		else
			(super doVerb: &rest)
		)
	)
)

(instance fShrank of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 195 228 196 55 218 47 309 57 302 70 304 219)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 1 62) ; "(LODGE VON GLOWER'S BEDROOM, CLICK ON BATHROOM, SHRANK, ETC.)Friedrick wouldn't appreciate me messin' around in here."
		else
			(super doVerb: &rest)
		)
	)
)

(instance fBathroom of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 105 236 104 52 187 59 190 226)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 1 62) ; "(LODGE VON GLOWER'S BEDROOM, CLICK ON BATHROOM, SHRANK, ETC.)Friedrick wouldn't appreciate me messin' around in here."
		else
			(super doVerb: &rest)
		)
	)
)

(instance pVonGlower of Prop
	(properties
		x 573
		y 122
		view 20649
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 2 62) ; "(TRY TO TALK TO VON GLOWER IN HIS BEDROOM)He's busy."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sVonGlowerFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 10))
			)
			(1
				(pVonGlower cel: 0 setCycle: End self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

