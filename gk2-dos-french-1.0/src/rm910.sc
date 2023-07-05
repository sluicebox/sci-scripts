;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 910)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm910 0
)

(instance rm910 of ExitRoom ; "Neuschwanstein: Entry Hall"
	(properties
		noun 22
		picture 9101
		south 900 ; rm900
	)

	(method (newRoom newRoomNumber)
		(if (and (== gChapter 6) (== newRoomNumber 900))
			(gGk2Music fade:)
			(Lock rsAUDIO 910 0)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(if (== gChapter 4)
			(gEgo get: 39) ; invTourTapeDeck
			(tourTapeButton init:)
		)
		(if
			(and
				(== gChapter 6)
				(or (not (gGk2Music handle:)) (!= 910 (gGk2Music number:)))
			)
			(Lock rsAUDIO 910 1)
			(gGk2Music number: 910 setLoop: -1 play: 0 0 fade: 63 10 10 0)
		)
		(super init: &rest)
		(if (or (== gPrevRoomNum 900) (IsFlag 729))
			(SetFlag 729)
			(guard1 init: setScript: FidgetScript)
		)
		(if (OneOf gPrevRoomNum 9110 920 921) ; neuEntryRm3, bed2
			(gEgo
				posn: 333 335
				heading: 225
				normalize:
				setScaler: Scaler 70 26 401 303
				init:
			)
		else
			(gEgo
				posn: 187 373
				heading: 45
				normalize:
				setScaler: Scaler 70 26 401 303
				init:
			)
		)
		(self setScript: guardControl)
		(if (and (== gChapter 6) (not (IsFlag 645)))
			(SetFlag 645)
			(PlayScene 774)
		)
		(towerDoor init:)
		(bedDoor init:)
		(leftPic init:)
		(rightPic init:)
	)
)

(instance guardControl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(= seconds (Random 40 50))
			)
			(1
				(cond
					((= register (gCast contains: guard1))
						(gGame handsOff:)
						(ClearFlag 729)
						(guard1 setScript: 0 setCycle: Beg self)
					)
					((not (DoAudio audWPLAY))
						(gGame handsOff:)
						(SetFlag 729)
						(PlayRobot 10910 317 193 self)
					)
					(else
						(= state -1)
						(self cue:)
					)
				)
			)
			(2
				(= state -1)
				(gGame handsOff:)
				(if register
					(if (not (DoAudio audWPLAY))
						(guard1 dispose:)
						(PlayRobot 12910 317 193 self)
					else
						(= state 1)
						(= seconds 2)
					)
				else
					(= seconds (Random 2 4))
					(guard1 init: setScript: FidgetScript)
				)
			)
		)
	)
)

(instance towerDoor of GKFeature
	(properties
		approachX 261
		approachY 321
		nextRoomNum 9110 ; neuEntryRm3
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 233 225 261 206 288 225 288 316 233 312
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bedDoor of ExitFeature
	(properties
		x 400
		y 270
		nextRoomNum 920 ; rm920
		exitDir 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 348 202 440 201 437 336 348 319
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftPic of GKFeature
	(properties
		approachX 76
		approachY 368
		x 68
		y 157
		nextRoomNum 9140 ; neuEntryRm1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 56 0 252 136 258 135 171 119 96 103 60
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightPic of GKFeature
	(properties
		approachX 208
		approachY 322
		x 198
		y 182
		nextRoomNum 9141 ; neuEntryRm2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 207 108 178 139 165 189 166 257 232 257 232 197 231 172 227 132
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance guard1 of Prop
	(properties
		x 404
		y 333
		view 11910
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(= noun
			(cond
				((== gChapter 4)
					(if (== theVerb 62) ; Do
						1
					else
						(= theVerb 0)
						2
					)
				)
				((== theVerb 31) 19) ; invDove
				(else
					(= theVerb 62) ; Do
					18
				)
			)
		)
		(super doVerb: theVerb)
	)
)

(instance tourTapeButton of Prop
	(properties
		noun 5
		modNum 910
		sightAngle 360
		x 10
		y 290
		view 141
	)

	(method (cue)
		(gGame changeScore: 988)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 579)
			(gMessager say: noun 62 0 0 self modNum) ; "Our tour begins in the Entry Hall. Ludwig II lived from 1845 to 1886. He assumed the Bavarian throne at the age of 18, when his father died."
		else
			(super doVerb: theVerb)
		)
	)
)

