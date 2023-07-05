;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11002)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Polygon)
(use Feature)
(use Cursor)
(use Motion)
(use Actor)
(use System)

(public
	rm11002 0
)

(local
	local0
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 100) ((+= temp0 1))
		(Palette 2 16 256 temp0) ; PalIntensity
		(FrameOut)
	)
)

(instance rm11002 of ExitRoom ; "Wittelsbacher Theater: Foyer"
	(properties
		modNum 1100
		noun 7
		picture 11002
		south 1100 ; foyerRm
	)

	(method (newRoom newRoomNumber)
		(if (and (IsFlag 735) (OneOf newRoomNumber 11812))
			(gGk2Music fade: 0 10 10 1)
			(Lock rsAUDIO 11002 0)
			((ScriptID 1101 0) keep: 0) ; resRegion
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(if
			(and
				(IsFlag 735)
				(or (not (gGk2Music handle:)) (!= 11002 (gGk2Music number:)))
			)
			(Lock rsAUDIO 11002 1)
			(gGk2Music number: 11002 setLoop: -1 play: 0 0 fade: 63 10 10 0)
		)
		(if (IsFlag 735)
			(self setRegions: 1101) ; resRegion
		)
		(cond
			((OneOf gPrevRoomNum 1100 11302) ; foyerRm
				(gEgo
					posn: 350 364
					heading: 315
					normalize:
					setScaler: Scaler 82 37 383 271
					init:
				)
			)
			(1110
				(gEgo
					posn: 450 297
					heading: 225
					normalize:
					setScaler: Scaler 82 37 383 271
					init:
				)
			)
			(1120
				(gEgo
					posn: 220 297
					heading: 135
					normalize:
					setScaler: Scaler 82 37 383 271
					init:
				)
			)
			(else
				(gEgo
					posn: 342 297
					heading: 135
					normalize:
					setScaler: Scaler 82 37 383 271
					init:
				)
			)
		)
		(if (IsFlag 739)
			(Palette 1 (= global249 251)) ; PalLoad
		else
			(Palette 1 (= global249 252)) ; PalLoad
		)
		(super init: &rest)
		(eastExit init:)
		(westExit init:)
		(if (IsFlag 735)
			(audExit init:)
		else
			(closedDoors init:)
		)
		(hallExit init:)
		(basement init:)
		(cond
			(
				(and
					(IsFlag 735)
					(IsFlag 744)
					(IsFlag 745)
					(IsFlag 746)
					(IsFlag 747)
					(IsFlag 748)
					(IsFlag 749)
					(IsFlag 750)
					(IsFlag 751)
					(IsFlag 752)
					(not (IsFlag 743))
				)
				(SetFlag 743)
				(= local0 1)
				(PlayScene 823)
			)
			((IsFlag 736)
				(if (== gPrevRoomNum 1120) ; resOfficeRm
					(gCurRoom setScript: sOvertureTime)
				else
					(pFidgetOne init: setScript: FidgetScript)
					(GKHotCursor delete: pFidgetOne)
				)
			)
			((IsFlag 737)
				(pFidgetTwo init: setScript: FidgetScript)
				(GKHotCursor delete: pFidgetOne)
			)
		)
	)
)

(instance sOvertureTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PlayScene 824 self -1)
			)
			(1
				(gGame handsOff:)
				(Palette 2 16 256 0) ; PalIntensity
				(gCurRoom drawPic: 11002)
				(if (IsFlag 739)
					(Palette 1 (= global249 251)) ; PalLoad
				else
					(Palette 1 (= global249 252)) ; PalLoad
				)
				(= cycles 1)
			)
			(2
				(pOverture init: setCycle: End self)
			)
			(3
				(= ticks 180)
			)
			(4
				(pOverture setCycle: Beg self)
			)
			(5
				(pOverture dispose:)
				(= ticks 60)
			)
			(6
				(gCast eachElementDo: #show)
				(pFidgetOne init: setScript: FidgetScript)
				(GKHotCursor delete: pFidgetOne)
				(= cycles 10)
			)
			(7
				(localproc_0)
				(= cycles 1)
			)
			(8
				(gGk2Music number: 1100 setLoop: -1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pFidgetOne of Prop
	(properties
		x 189
		y 325
		view 21820
	)
)

(instance pFidgetTwo of Prop
	(properties
		x 484
		y 304
		view 22820
	)
)

(instance pOverture of Prop
	(properties
		x 165
		y 120
		view 106
		loop 5
	)
)

(instance closedDoors of View
	(properties
		noun 2
		modNum 1100
		sightAngle 360
		x 383
		y 284
		priority 100
		fixPriority 1
		view 31100
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 739)
			(= noun 1)
		)
	)
)

(instance eastExit of ExitFeature
	(properties
		sightAngle 40
		x 579
		y 208
		exitDir 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 544 332 544 90 614 84 614 332
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11302)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance audExit of ExitFeature
	(properties
		sightAngle 40
		x 452
		y 208
		exitDir 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 390 268 389 146 513 139 515 278
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(cond
			((not (self onMe: event)))
			((IsFlag 735))
			(else
				(= global141 self)
			)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 739)
						(gMessager say: 1 62 0 0 0 1100) ; "(THEATER FOYER, TRY TO ENTER AUDITORIUM AFTER OPERA STARTS)I don't need to go through the auditorium. I'd disrupt the performance."
					)
					((IsFlag 736)
						(gMessager say: 2 62 0 0 0 1100) ; "(EMBARRASSED)I can't go wandering all over the theater dressed like this! People are being seated!"
					)
					(else
						(gCurRoom newRoom: 1110) ; audRm
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hallExit of ExitFeature
	(properties
		sightAngle 40
		x 281
		y 210
		exitDir 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 262 261 260 161 300 157 302 264
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11301)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance basement of ExitFeature
	(properties
		sightAngle 40
		x 200
		y 214
		exitDir 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 178 273 178 163 190 155 211 156 219 171 222 266
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(cond
			((not (self onMe: event)))
			((or (not (IsFlag 753)) (IsFlag 735)))
			(else
				(= global141 self)
			)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((and (IsFlag 735) (not (IsFlag 753)))
						(SetFlag 753)
						(PlayScene 828 0 11812) ; rm11812
					)
					((IsFlag 735)
						(gCurRoom newRoom: 11812)
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

(instance westExit of ExitFeature
	(properties
		sightAngle 10
		x 32
		y 265
		exitDir 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 226 65 198 65 333 0 333
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: (gCurRoom south:))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

