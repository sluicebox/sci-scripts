;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1150)
(include sci.sh)
(use Main)
(use GK2Ego)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	backStageRm 0
)

(instance backStageRm of ExitRoom ; "Wittelsbacher Theater: Backstage"
	(properties
		noun 13
		picture 11501
	)

	(method (init &tmp temp0)
		(cond
			(
				(and
					(IsFlag 735)
					(or
						(not (gGk2Music handle:))
						(!= 11002 (gGk2Music number:))
					)
				)
				(Lock rsAUDIO 11002 1)
				(gGk2Music number: 11002 setLoop: -1 play: 0 0 fade: 63 10 10 0)
			)
			((and (IsFlag 738) (== gPrevRoomNum 1180)) ; basementHallRm
				(Lock rsAUDIO 1104 1)
				(gGk2Music number: 1104 setLoop: -1 play: 0 0 fade: 63 10 10 0)
			)
		)
		(if (IsFlag 735)
			(self setRegions: 1101) ; resRegion
		)
		(if (OneOf gPrevRoomNum 11301 11511)
			(gEgo
				posn: 88 308
				heading: 135
				sel_737:
				setScaler: Scaler 53 31 352 278
				init:
			)
		else
			(gEgo
				posn: 526 330
				heading: 315
				sel_737:
				setScaler: Scaler 53 31 352 278
				init:
			)
		)
		(cond
			((== gEgo GabeEgo)
				(= temp0 212)
			)
			((and (== gEgo GraceEgo) (IsFlag 739))
				(= temp0 214)
			)
			(else
				(= temp0 213)
			)
		)
		(Palette 1 (= global249 temp0)) ; PalLoad
		(super init: &rest)
		(if (IsFlag 735)
			(backWorkers1 init:)
			(if (not (OneOf gPrevRoomNum 11301 11511))
				(backWorker2 init:)
			)
		)
		(stageExit init:)
		(basementExit init:)
		(pulley init:)
		(hallExit init:)
		(dressingExit init:)
	)

	(method (newRoom newRoomNumber)
		(cond
			((and (IsFlag 735) (== newRoomNumber 1180)) ; basementHallRm
				(gGk2Music fade: 0 10 10 1)
				(Lock rsAUDIO 11002 0)
				((ScriptID 1101 0) keep: 0) ; resRegion
			)
			((and (IsFlag 738) (== newRoomNumber 1180)) ; basementHallRm
				(gGk2Music fade: 0 10 10 1)
				(Lock rsAUDIO 1104 0)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance backWorkers1 of Prop
	(properties
		x 166
		y 333
		view 20115
	)

	(method (init)
		(super init: &rest)
		((gUser sel_715:) delete: self)
		(self setScript: sFidget)
	)
)

(instance backWorker2 of Prop
	(properties
		y 333
		view 21115
	)

	(method (init)
		(super init: &rest)
		((gUser sel_715:) delete: self)
		(self setScript: sDoYourThing)
	)
)

(instance sFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 120 600))
			)
			(1
				(client cel: 0 setLoop: (Random 0 1) setCycle: End self)
			)
			(2
				(client cel: 0 show:)
				(self changeState: 0)
			)
		)
	)
)

(instance sDoYourThing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 300)
			)
			(1
				(client cel: 0 setLoop: 0 setCycle: End self)
			)
			(2
				(= ticks 2400)
			)
			(3
				(client cel: 0 show:)
				(self changeState: 1)
			)
		)
	)
)

(instance stageExit of ExitFeature
	(properties
		modNum 1150
		sightAngle 360
		x 302
		y 322
		BAD_SELECTOR 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 313 553 313 585 332 0 332
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (== gEgo GraceEgo)
					(gMessager say: 2 62 0 0 0 1150) ; "(THEATER BACKSTAGE, DRY)I have NO desire to go out on stage."
				else
					(gMessager say: 3 62 0 0 0 1150) ; "(DARK BUT THOUGHTFUL)I'm not quite ready for my big debut."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance basementExit of ExitFeature
	(properties
		modNum 1150
		x 465
		y 293
		BAD_SELECTOR 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 456 313 404 288 404 239 467 239 517 255 517 313
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (== gEgo GraceEgo) (not (IsFlag 735)))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((and (== gEgo GraceEgo) (IsFlag 735))
						(PlayScene 875 0 1180) ; basementHallRm
					)
					((== gEgo GabeEgo)
						(PlayScene 876 0 1180) ; basementHallRm
					)
					(else
						(gMessager say: 3 62 0 0 0 1100) ; "(DETERMINED NOT TO GO SEE GABRIEL)I don't have any more time to fool around with Mr. Mouth. He'll be all right down there by himself."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dressingExit of ExitFeature
	(properties
		modNum 1150
		x 596
		y 331
		BAD_SELECTOR 2
	)

	(method (init)
		(if (== gEgo GraceEgo)
			(= sightAngle 360)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 564 196 612 193 612 330 585 330 561 316
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (== gEgo GraceEgo)
					(gMessager say: 4 theVerb 0 0 0 modNum) ; "(LOOK TOWARDS DRESSING ROOMS)The dressing rooms are back there. They're probably a mad house right now."
				else
					(gCurRoom newRoom: 1160) ; dressingRm
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pulley of GKFeature
	(properties
		modNum 1150
		x 140
		y 210
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 104 167 176 167 176 254 104 254
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11511)
			)
			(22 ; invRope
				(gMessager say: 5 22 0 0 0 modNum) ; "(TRY TO RETURN ROPE TO PULLEY)It wouldn't do much good to put it back now."
			)
			(35 ; invRollOfTape
				(gMessager say: 6 35 0 0 0 modNum) ; "(TRY TO RETURN TAPE TO PULLEY)Nah. They'll find something else."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hallExit of ExitFeature
	(properties
		modNum 1150
		x 59
		y 227
		BAD_SELECTOR 6
	)

	(method (init)
		(if (!= gEgo GraceEgo)
			(= sightAngle 360)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 289 37 166 81 172 81 276
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (== gEgo GraceEgo)
					(gCurRoom newRoom: 11301)
				else
					(gMessager say: 1 62 0 0 0 1150) ; "(THEATER BACKSTAGE, IRRITATED)I can't go out into the main hall."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

