;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	srHallRoom 0
)

(instance srHallRoom of ExitRoom ; "Schloss Ritter: Main Hall"
	(properties
		noun 12
	)

	(method (init)
		(if (== gPrevRoomNum 140) ; srGabeRoom
			(= picture -1)
			(gCurRoom setScript: sWalkDownTheStairs)
		else
			(= picture 1201)
		)
		(if (OneOf gPrevRoomNum 100 24) ; srExtRoom, whereTo
			(gSoundManager play: 0 121 122 123)
		)
		(stairs init:)
		(door init:)
		(chairs init:)
		(if (!= gChapter 6)
			(lion init:)
		)
		(art init:)
		(gEgo
			posn: 223 261
			heading: 135
			sel_737:
			setScaler: Scaler 76 45 328 257
			init:
		)
		(super init: &rest)
		(if (or (!= gChapter 4) (IsFlag 615))
			(gerda init: setPri: 350)
			(cond
				((and (== gChapter 6) (not (IsFlag 716)))
					(gSoundManager sel_702: 1)
					(PlayScene 758)
					(SetFlag 716)
				)
				(
					(and
						(not (IsFlag 618))
						(IsFlag 617)
						(IsFlag 619)
						(IsFlag 300)
						(not (gEgo has: 44)) ; invDiaryTranslation
					)
					(SetFlag 618)
					(PlayScene 415)
				)
				((and (not (IsFlag 616)) (IsFlag 624) (IsFlag 622))
					(SetFlag 616)
					(PlayScene 414)
				)
				(
					(and
						(!= gChapter 6)
						(IsFlag 409)
						(not (OneOf gPrevRoomNum 140 1220 1222 1223)) ; srGabeRoom, srHallTopicRm, srHallCh4, srHallTopicRmCh6
					)
					(ClearFlag 409)
					(PlayScene 416)
				)
			)
		)
		(if (not (gCast contains: gerda))
			(desk init:)
			(theChair init:)
		)
	)
)

(instance sWalkDownTheStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gCurRoom picture: 1201)
				(PlayScene 1133 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stairs of ExitFeature
	(properties
		nsLeft 24
		nsTop 96
		nsRight 142
		nsBottom 232
		approachX -100
		BAD_SELECTOR 140
		BAD_SELECTOR 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(PlayScene 133 0 140) ; srGabeRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 400
		nsTop 120
		nsRight 450
		nsBottom 235
		approachX 640
		approachY 160
		BAD_SELECTOR 1211
		BAD_SELECTOR 0
	)
)

(instance chairs of GKFeature
	(properties
		noun 2
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 492 219 544 230 521 270 616 289 617 202 499 195
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 0 282 120 291 146 333 0 333
					yourself:
				)
		)
		(super init: &rest)
		(if (!= gChapter 2)
			(= noun 1)
		)
	)
)

(instance lion of GKFeature
	(properties
		noun 14
		nsLeft 74
		nsTop 24
		nsRight 100
		nsBottom 72
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)
)

(instance desk of GKFeature
	(properties
		noun 23
		sightAngle 360
		x 418
		y 247
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 293 234 486 218 544 230 531 250 346 276 298 255
					yourself:
				)
		)
		(if (and (== gChapter 4) (IsFlag 607))
			(= noun 24)
		)
		(super init: &rest)
	)
)

(instance art of GKFeature
	(properties
		noun 15
		nsLeft 470
		nsTop 2
		nsRight 600
		nsBottom 84
		sightAngle 360
	)
)

(instance gerda of Prop
	(properties
		sightAngle 0
		approachX 640
		approachY 300
		x 451
		y 186
		view 20131
	)

	(method (init)
		(super init: &rest)
		(|= signal $1000)
		(self setScript: sFidget)
	)

	(method (handleEvent event)
		(cond
			((not (self onMe: event)))
			((and (== gChapter 2) (not (proc11_15 1220)))
				(= global141 self)
			)
			((and (== gChapter 4) (not (proc11_15 1222)))
				(= global141 self)
			)
			((and (== gChapter 6) (not (proc11_15 1223)))
				(= global141 self)
			)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (and (OneOf theVerb 63 64) (IsFlag 891)) ; invGabeLetter1, invGabeLetter2
			(gMessager say: 18 44 0 1) ; "(CLICK ADDRESSED PACKAGE ON GERDE)I already have the address."
			(return 1)
		)
		(return
			(switch theVerb
				(62 ; Do
					(cond
						((== gChapter 2)
							(if (proc11_15 1220)
								(gCurRoom newRoom: 1220) ; srHallTopicRm
							else
								(gMessager say: 17 62 0 1) ; "(TRY TO TALK TO GERDE--DIALOGUE DONE, STIFF)I don't have anything to say to her right now."
							)
						)
						((== gChapter 4)
							(if (proc11_15 1222)
								(gCurRoom newRoom: 1222) ; srHallCh4
							else
								(gMessager say: 13 62 0 1) ; "(CLICK ON GERDE--DIALOGUE DONE, CH 4 & 6, FRIENDLY)I don't have anything to ask Gerde right now."
							)
						)
						((proc11_15 1223)
							(gCurRoom newRoom: 1223) ; srHallTopicRmCh6
						)
						(else
							(gMessager say: 25 62 0 1) ; "(PICKUP, CLICK ON GERDE--DIALOGUE DONE, CH 6, ANXIOUS)Gerde's offered to help, but I can't think of anything she can do at the moment."
						)
					)
				)
				(9 ; invGracePackage1
					(if (IsFlag 474)
						(PlayScene 135)
						(gUser sel_712: 62)
						((gUser sel_715:) sel_737:)
						(gEgo put: 27) ; invGracePackage1
						(gEgo get: 80) ; invAddressedPackage
						(gCurInvView select: 80)
						(SetFlag 469)
					else
						(super doVerb: theVerb)
					)
				)
				(44 ; invAddressedPackage
					(gMessager say: 18 theVerb 0 1) ; "(CLICK ADDRESSED PACKAGE ON GERDE)I already have the address."
				)
				(else
					(proc11_18)
				)
			)
		)
	)
)

(instance theChair of View
	(properties
		sightAngle 360
		x 413
		y 333
		view 30121
	)

	(method (doVerb)
		(desk doVerb: &rest)
	)
)

(instance sFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gerda cel: 0 setCycle: End self)
			)
			(1
				(= seconds (Random 3 6))
			)
			(2
				(gerda setCycle: Beg self)
			)
			(3
				(= seconds (Random 3 6))
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

