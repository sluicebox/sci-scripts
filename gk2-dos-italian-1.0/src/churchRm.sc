;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 730)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	churchRm 0
)

(local
	local0
)

(instance churchRm of ExitRoom ; "St. Georg Church: Interior"
	(properties
		noun 19
		picture 7302
		south 7012 ; rm7012
	)

	(method (cue)
		(= local0 1)
		(gSoundManager stop:)
		(self newRoom: 7012)
	)

	(method (newRoom newRoomNumber)
		(if (and (not local0) (== newRoomNumber 7012))
			(gSoundManager fade: 0 10 10 1 self)
		else
			(super newRoom: newRoomNumber &rest)
		)
	)

	(method (init)
		(= local0 0)
		(if
			(or
				(not (gGk2Music handle:))
				(not (OneOf (gGk2Music number:) 730 731 732))
			)
			(gSoundManager play: 0 730 731 732)
		)
		(stMary init:)
		(upFront init:)
		(stGeorge init:)
		(if (OneOf gPrevRoomNum 7312 7340 7341)
			(gEgo
				posn: 299 280
				heading: 180
				sel_737:
				init:
				heading: 170
				setScaler: Scaler 100 30 438 272
			)
		else
			(gEgo
				posn: 42 392
				heading: 0
				sel_737:
				init:
				setScaler: Scaler 100 30 438 272
			)
		)
		(if (== gChapter 2)
			(priest init: setScript: priestFidget)
		)
		(if (Random 0 1)
			(penny init: setScript: FidgetScript)
		)
		(super init: &rest)
	)
)

(instance stMary of GKFeature
	(properties
		nsLeft 124
		nsTop 132
		nsRight 150
		nsBottom 204
		sightAngle 40
		approachX 146
		approachY 218
		x 136
		y 242
		BAD_SELECTOR 7340
	)
)

(instance stGeorge of GKFeature
	(properties
		nsLeft 442
		nsTop 122
		nsRight 468
		nsBottom 206
		sightAngle 40
		approachX 450
		approachY 213
		x 454
		y 163
		BAD_SELECTOR 7341
	)
)

(instance upFront of ExitFeature
	(properties
		nsLeft 178
		nsTop 111
		nsRight 275
		nsBottom 240
		sightAngle 0
		approachX 206
		approachY 228
		x 200
		y 187
		BAD_SELECTOR 7312
		BAD_SELECTOR 7
	)
)

(instance penny of Prop
	(properties
		noun 22
		sightAngle 360
		x 502
		y 229
		view 20216
	)
)

(instance pennyFidget of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: End self)
			)
			(1
				(= seconds (Random 8 14))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance priest of Prop
	(properties
		sightAngle 360
		x 166
		y 221
		view 20215
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((gEgo has: 29) ; invChurchFile
						(gMessager say: 7 62 0 1 0 730) ; "I wouldn't mind speaking with Father Getz, but we have a serious communication problem."
					)
					((not (IsFlag 472))
						(if (IsFlag 488)
							(gMessager say: 6 62 0 1 0 730) ; "(TRY TO TALK TO FATHER GETZ, FRUSTRATED)It's no use. He doesn't speak English, and I can't communicate well enough in German."
						else
							(SetFlag 488)
							(PlayScene 217)
						)
					)
					((not (IsFlag 489))
						(SetFlag 489)
						(PlayScene 218)
					)
					(else
						(gMessager say: 6 62 0 1 0 730) ; "(TRY TO TALK TO FATHER GETZ, FRUSTRATED)It's no use. He doesn't speak English, and I can't communicate well enough in German."
					)
				)
			)
			(108 ; invMayorNote
				(PlayScene 219)
				(gEgo get: 29) ; invChurchFile
				(gEgo put: 28) ; invMayorNote
			)
			(else
				(proc11_17)
			)
		)
	)
)

(instance priestFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: (Random 0 1) cel: 0 setCycle: End self)
			)
			(1
				(= state -1)
				(= seconds (Random 8 14))
			)
		)
	)
)

