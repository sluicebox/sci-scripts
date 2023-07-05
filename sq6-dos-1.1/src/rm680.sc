;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 680)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm680 0
)

(local
	local0
	local1 = 3
	local2
	local3
	local4 = 1
	local5 = 9
)

(instance rm680 of SQRoom
	(properties
		noun 1
		picture 680
	)

	(method (init)
		(if (== gPrevRoomNum 690)
			(gGSound1 number: 640 setLoop: -1 play: setVol: 127)
		)
		(gEgo
			init:
			normalize:
			setPri: 80
			setScaler: Scaler 100 100 150 10
			code: scrollCode
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 105 38 111 92 111 177 97 248 91 377 100 377 96 248 89 169 96 97 109 38 109 0 104
					yourself:
				)
		)
		(switch gPrevRoomNum
			(690
				((gCurRoom plane:) setRect: -320 0 320 138)
				(gEgo setScript: sCrawlWest)
			)
			(else
				((gCurRoom plane:) setRect: 0 0 640 138)
				(gEgo enterRoom: -10 103 10 105 self)
			)
		)
		(UpdatePlane plane)
		(alveoli init: hide:)
		(if (IsFlag 113)
			(opening init:)
		)
		(if (IsFlag 119)
			(alveoli init: show:)
		)
		(exit700 init: gTheExitWCursor approachVerbs: 8) ; ExitLeft
		(exit690 init:)
		(leftSide init:)
		(Load 140 681) ; WAVE
		(Load 140 682) ; WAVE
		(gWalkHandler addToFront: gCurRoom)
		(gWalkHandler addToFront: exit690)
		(gWalkHandler addToFront: leftSide)
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if local0
					(gEgo setScript: sCrawlBack)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (== gNewRoomNum 690)
			(gGSound1 fade: 0 3 1 1)
		)
		((gCurRoom plane:) setRect: 0 0 319 138)
		(gEgo setScale: 0 normalize:)
		(super dispose:)
	)
)

(instance scrollCode of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 ((gCurRoom plane:) left:))
		(= temp2 ((gCurRoom plane:) top:))
		(= temp3 ((gCurRoom plane:) right:))
		(= temp4 ((gCurRoom plane:) bottom:))
		(= temp0 (gEgo xStep:))
		(cond
			(
				(and
					local4
					(> (+ (gEgo x:) temp1) 170)
					(> temp3 319)
					(gEgo mover:)
					(> (gEgo x:) ((gEgo mover:) xLast:))
				)
				((gCurRoom plane:)
					setRect: (- temp1 temp0) temp2 (- temp3 temp0) temp4
				)
				(UpdatePlane (gCurRoom plane:))
			)
			(
				(and
					local4
					(< (+ (gEgo x:) temp1) 100)
					(< temp1 0)
					(gEgo mover:)
					(< (gEgo x:) ((gEgo mover:) xLast:))
				)
				((gCurRoom plane:)
					setRect: (+ temp1 temp0) temp2 (+ temp3 temp0) temp4
				)
				(UpdatePlane (gCurRoom plane:))
			)
		)
	)
)

(instance sGoto700 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -10 105 self)
			)
			(1
				(gCurRoom newRoom: 700)
			)
		)
	)
)

(instance sScrollRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 1)
				((gCurRoom plane:)
					setRect:
						(+ ((gCurRoom plane:) left:) local1)
						((gCurRoom plane:) top:)
						(+ ((gCurRoom plane:) right:) local1)
						((gCurRoom plane:) bottom:)
				)
				(UpdatePlane (gCurRoom plane:))
				(= cycles 1)
			)
			(1
				(if (< ((gCurRoom plane:) left:) local2)
					(self changeState: 0)
				else
					(= ticks 1)
				)
			)
			(2
				(= local3 0)
				(self dispose:)
			)
		)
	)
)

(instance sScrollLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 1)
				(= local2 ((gCurRoom plane:) left:))
				(= ticks 1)
			)
			(1
				((gCurRoom plane:)
					setRect:
						(- ((gCurRoom plane:) left:) local1)
						((gCurRoom plane:) top:)
						(- ((gCurRoom plane:) right:) local1)
						((gCurRoom plane:) bottom:)
				)
				(UpdatePlane (gCurRoom plane:))
				(= cycles 1)
			)
			(2
				(if (> ((gCurRoom plane:) left:) (- local2 120))
					(self changeState: 1)
				else
					(= ticks 1)
				)
			)
			(3
				(= local3 0)
				(self dispose:)
			)
		)
	)
)

(instance sCrawlBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 202)
					(gCurRoom setScript: sScrollRight)
				)
				(gEgo
					view: 684
					setLoop: 0
					setCel: 16
					posn: 496 76
					setCycle: End self
				)
			)
			(1
				(gEgo
					posn: 385 97
					view: 680
					setLoop: 1
					cel: 100
					setCycle: Beg self
				)
			)
			(2
				(gEgo normalize:)
				(gEgo setMotion: MoveTo 365 99 self)
			)
			(3
				(= ticks 5)
			)
			(4
				(if local3
					(self changeState: (- state 1))
				else
					(= ticks 1)
				)
			)
			(5
				(gGame handsOn:)
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance sCrawlWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 (+ ((gCurRoom plane:) left:) 105))
				(gEgo
					view: 684
					setLoop: 0
					setCel: 0
					posn: 496 77
					cycleSpeed: local5
					setCycle: CT 15 1 self
				)
			)
			(1
				(gEgo setScript: sCrawlBack)
			)
		)
	)
)

(instance sCrawlEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self changeState: 1)
				else
					(gEgo setScript: sCrawlUp self)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo
					view: 683
					setLoop: 0
					setCel: 0
					posn: 571 77
					cycleSpeed: local5
					setCycle: End self
				)
			)
			(2
				(= local4 0)
				(gEgo
					view: 681
					setLoop: 0 1
					setCel: 0
					posn: 618 100
					setSpeed: local5
					setCycle: Walk
					setMotion: MoveTo 640 100 self
				)
			)
			(3
				(= local0 0)
				(gGame handsOn:)
				(gWalkHandler delete: gCurRoom exit690 leftSide)
				(gCurRoom newRoom: 690)
				(self dispose:)
			)
		)
	)
)

(instance sCrawlUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 368 97 self)
			)
			(1
				(if (IsFlag 202)
					(gCurRoom setScript: sScrollLeft)
				else
					((gCurRoom plane:) setRect: -319 0 319 138)
					(UpdatePlane (gCurRoom plane:))
				)
				(gEgo view: 680 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(2
				(gEgo
					posn: 470 79
					view: 6810
					setLoop: 0
					setCel: 0
					setCycle: CT 27 1 self
				)
			)
			(3
				(= ticks 5)
			)
			(4
				(if local3
					(self changeState: (- state 1))
				else
					(= ticks 1)
				)
			)
			(5
				(gGame handsOn:)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance sTryAndFail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCel: 27 cycleSpeed: local5 setCycle: End self)
			)
			(1
				(gMessager say: 0 0 1 0 self) ; "(TO HIMSELF) Yeow. This is way too snug. This blockage needs to be cleared. Stellar's going to have to change her diet."
			)
			(2
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance sInflate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(alveoli hide:)
				(gEgo
					view: 6820
					setLoop: 0
					setCel: 0
					posn: 501 77
					cycleSpeed: local5
					setCycle: CT 2 1 self
				)
			)
			(1
				(gGSound2 number: 681 setLoop: 0 play:)
				(gEgo cycleSpeed: local5 setCycle: CT 6 1 self)
			)
			(2
				(gGSound2 stop:)
				(gEgo cycleSpeed: local5 setCycle: CT 9 1 self)
			)
			(3
				(gGSound2 setLoop: 0 play:)
				(gEgo cycleSpeed: local5 setCycle: CT 13 1 self)
			)
			(4
				(gGSound2 stop:)
				(gEgo cycleSpeed: local5 setCycle: CT 16 1 self)
			)
			(5
				(gGSound2 setLoop: 0 play:)
				(gEgo cycleSpeed: local5 setCycle: CT 19 1 self)
			)
			(6
				(gGSound2 stop:)
				(gEgo cycleSpeed: local5 setCycle: CT 21 1 self)
			)
			(7
				(gGSound2 setLoop: 0 play:)
				(gEgo cycleSpeed: local5 setCycle: CT 27 1 self)
			)
			(8
				(gGSound2 number: 682 setLoop: 0 play:)
				(gEgo cycleSpeed: local5 setCycle: End self)
			)
			(9
				(opening init:)
				(gGame handsOn: points: 3)
				(SetFlag 113)
				(ClearFlag 119)
				(self dispose:)
			)
		)
	)
)

(instance sPlaceAlveoli of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 682
					setLoop: 0
					setCel: 0
					posn: 501 77
					cycleSpeed: local5
					setCycle: CT 13 1 self
				)
			)
			(1
				(alveoli show:)
				(gEgo setCycle: End self)
			)
			(2
				(gGame handsOn: points: 3)
				(gEgo put: 3) ; Alveoli
				(SetFlag 119)
				(self dispose:)
			)
		)
	)
)

(instance alveoli of View
	(properties
		noun 3
		view 686
	)

	(method (init)
		(super init:)
		(self posn: 501 77 hide:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (IsFlag 119)
					(gEgo setScript: sInflate)
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(if (IsFlag 119)
					(gMessager say: noun theVerb) ; "Don't take it back out. It's all fine where it is."
				else
					(super doVerb: theVerb)
				)
			)
			(1 ; Look
				(if (IsFlag 119)
					(gMessager say: noun theVerb) ; "The alveoli are well placed in the blockage."
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance opening of View
	(properties
		x 544
		y 50
		view 685
	)
)

(instance exit700 of ExitFeature
	(properties
		approachX 5
		approachY 94
		x 4
		y 94
		nextRoom 700
		message 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 37 15 38 15 110 0 109 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 5 7 8 9 10) ; Exit, ExitRight, ExitLeft, ExitUp, ExitDown
			(gWalkHandler delete: gCurRoom exit690 leftSide)
			(gEgo setScript: sGoto700)
		)
	)
)

(instance leftSide of Feature
	(properties
		noun 2
		sightAngle 40
		x 420
		y 63
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 503 26 372 33 372 101 503 97
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (== local0 1)
					(gEgo setScript: sCrawlBack)
				else
					(gEgo setScript: sCrawlUp)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exit690 of Feature
	(properties
		x 524
		y 77
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 504 27 680 27 680 99 504 99
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(cond
					((IsFlag 113)
						(gEgo setScript: sCrawlEast)
					)
					((IsFlag 119)
						(gMessager say: 0 0 2) ; "You can't pass through with the alveoli in the way."
					)
					((== local0 0)
						(gEgo setScript: sCrawlUp)
					)
					(else
						(gEgo setScript: sTryAndFail)
					)
				)
			)
			(136 ; Alveoli
				(if local0
					(gEgo setScript: sPlaceAlveoli)
				else
					(gEgo setScript: sCrawlUp)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

