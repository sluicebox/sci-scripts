;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11752)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm11752 0
)

(local
	local0
)

(instance rm11752 of ExitRoom
	(properties
		picture 11752
	)

	(method (init)
		(if (not (IsFlag 735))
			(= picture 11753)
			(logeDudes init: setScript: FidgetScript)
		else
			(otherSeats1 init:)
			(otherSeats2 init:)
			(otherSeats3 init:)
			(otherSeats4 init:)
			(otherSeats5 init:)
		)
		(super init: &rest)
		(if (IsFlag 770)
			(spotlight init:)
			(RemapColors 2 236 200) ; ByPercent
		)
		(if (== gPrevRoomNum 11710)
			(= local0 1)
			((gUser sel_715:)
				sel_717: 1 1 622 348
				posn: global139 global140
				hide:
			)
		)
		(if (or (not (IsFlag 770)) (and (IsFlag 770) (!= gPrevRoomNum 11710)))
			(if (IsFlag 735)
				(eastExit init:)
			)
			(mittleLoge init:)
			(southExit1 init:)
			(southExit2 init:)
		)
		(if (IsFlag 770)
			(UpdateScreenItem spotlight)
		)
	)

	(method (newRoom)
		(if (IsFlag 770)
			(RemapColors 0) ; Off
			(FrameOut)
		)
		((gUser sel_715:) sel_717: 0)
		(super newRoom: &rest)
	)
)

(instance sActOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 763)
				(SetFlag 737)
				(ClearFlag 736)
				(= cycles 1)
			)
			(1
				(gCast eachElementDo: #dispose)
				(PlayScene 872 self -1)
			)
			(2
				(gGk2Music fade: 0 20 10 1 self)
			)
			(3
				(gGame handsOff:)
				(= ticks 180)
			)
			(4
				(gGame handsOff:)
				(pActOne init: setCycle: End self)
			)
			(5
				(= ticks 180)
			)
			(6
				(pActOne setCycle: Beg self)
			)
			(7
				(pActOne dispose:)
				(= ticks 60)
			)
			(8
				(Lock rsAUDIO 1103 1)
				(gGk2Music setLoop: -1 number: 1103 play:)
				(gCurRoom newRoom: 1170) ; spotRm
				(self dispose:)
			)
		)
	)
)

(instance sStopSpotlight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (< 169 (spotlight x:) 234) (< 157 (spotlight y:) 224))
					(spotlight setMotion: MoveTo 204 185 self)
					(SetFlag 747)
				else
					(= cycles 1)
				)
			)
			(1
				(= ticks 60)
			)
			(2
				((gUser sel_715:) show:)
				(if (IsFlag 747)
					(SetFlag 771)
					(ClearFlag 770)
					(PlayScene 870 0 11304) ; rm11304
				else
					(= global139 (spotlight x:))
					(= global140 (spotlight y:))
					(PlayScene 869 0 1170) ; spotRm
				)
				(self dispose:)
			)
		)
	)
)

(instance pActOne of Prop
	(properties
		x 165
		y 120
		view 106
		loop 2
	)
)

(instance spotlight of Actor
	(properties
		modNum 1170
		view 11752
		yStep 1
		signal 24577
		xStep 1
	)

	(method (init)
		(= x global139)
		(= y global140)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if local0
			(= x gMouseX)
			(= y gMouseY)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (!= gPrevRoomNum 11710)
					(gMessager say: 19 theVerb 0 0 0 modNum) ; "(THOUGHTFUL)I could shine the spotlight just about anywhere, if I wanted to."
				else
					(= local0 0)
					(gCurRoom setScript: sStopSpotlight)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance logeDudes of Prop
	(properties
		modNum 1170
		sightAngle 360
		x 152
		y 224
		view 11753
	)

	(method (doVerb theVerb)
		(mittleLoge doVerb: theVerb)
	)
)

(instance mittleLoge of GKFeature
	(properties
		modNum 1170
		x 207
		y 145
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 140 57 192 30 234 32 275 70 274 250 139 261
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 737)
						(gMessager say: 16 62 0 0 0 modNum) ; "(LOOKING AT VON GLOWER THROUGH OPERA GLASSES)Von Glower seems to be settled in."
					)
					((IsFlag 736)
						(gMessager say: 15 62 0 0 0 modNum) ; "(CLICK ON MITTLE LOGE WITHOUT USING OPERA GLASSES, WORRIED)Von Glower should be in there by now, but I can't see much from here."
					)
					((IsFlag 741)
						(gMessager say: 14 62 0 0 0 modNum) ; "(LOOK AT MITTLE LOGE FROM SPOTLIGHT ROOM AFTER DECIDING TO SEAT VON GLOWER THERE, DEVIOUS)There's the hot seat."
					)
					((IsFlag 1124)
						(gMessager say: 13 62 0 0 0 modNum) ; "(THOUGHTFUL)I believe that's the Mittel Loge box over there."
					)
					(else
						(gMessager say: 12 62 0 0 0 modNum) ; "(LOOK AT MITTLE LOGE FROM SPOTLIGHT ROOM, BEFORE DECIDING TO SEAT VON GLOWER THERE, MILDLY INTERESTED)That's a nice box over there."
					)
				)
			)
			(34 ; invOperaGlasses
				(cond
					((IsFlag 763)
						(gMessager say: 18 theVerb 0 0 0 modNum) ; "(TRY TO USE OPERA GLASSES ON MITTLE LOGE AFTER SEEING VON GLOWER ONCE ALREADY, WORRIED)I already know he's there! Now I need to make sure he doesn't get out!"
					)
					((IsFlag 736)
						(gCurRoom setScript: sActOne)
					)
					((IsFlag 735)
						(gMessager say: 17 theVerb 0 0 0 modNum) ; "(TRY TO USE GLASSES BEFORE OPERA STARTS)There's nothing much to look at yet."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance otherSeats1 of GKFeature
	(properties
		modNum 1170
		x 65
		y 227
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 8 267 9 132 122 134 123 261
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 19 theVerb 0 0 0 modNum) ; "(THOUGHTFUL)I could shine the spotlight just about anywhere, if I wanted to."
			)
			(34 ; invOperaGlasses
				(if (IsFlag 735)
					(gMessager say: 10 theVerb 0 0 0 modNum) ; "(USE OPERA GLASSES ON STAGE BEFORE OVERTURE)There's nothing to see out there."
				else
					(gMessager say: 20 theVerb 0 0 0 modNum) ; "(PENSIVE)I don't have time to people watch."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance otherSeats2 of GKFeature
	(properties
		modNum 1170
		x 319
		y 212
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 285 248 283 152 447 138 615 110 615 251 428 245
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(otherSeats1 doVerb: theVerb)
	)
)

(instance otherSeats3 of GKFeature
	(properties
		modNum 1170
		x 363
		y 306
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 280 333 280 286 360 280 445 296 446 333
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(otherSeats1 doVerb: theVerb)
	)
)

(instance otherSeats4 of GKFeature
	(properties
		modNum 1170
		x 64
		y 42
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 3 70 4 1 126 4 116 84 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(otherSeats1 doVerb: theVerb)
	)
)

(instance otherSeats5 of GKFeature
	(properties
		modNum 1170
		x 430
		y 56
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 283 108 281 7 426 18 497 0 579 0 579 73 452 105 449 61 421 39 403 58 402 112 384 112 368 84 354 84 349 111
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(otherSeats1 doVerb: theVerb)
	)
)

(instance southExit1 of ExitFeature
	(properties
		x 139
		y 314
		BAD_SELECTOR 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 297 278 297 278 332 0 332
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 1170) ; spotRm
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExit2 of ExitFeature
	(properties
		x 527
		y 316
		BAD_SELECTOR 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 446 300 609 300 609 333 447 333
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 1170) ; spotRm
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 546
		nsTop 15
		nsRight 640
		nsBottom 334
		x 2000
		y 250
	)

	(method (setCursor param1)
		(param1 view: 999 loop: 5 cel: 0)
	)

	(method (doVerb)
		(gCurRoom newRoom: 11750)
	)
)

