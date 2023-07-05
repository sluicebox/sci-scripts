;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1035)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm1035 0
)

(local
	[local0 4] = [123 131 99 123]
	[local4 4] = [114 116 155 162]
	local8
	local9
	local10
)

(procedure (localproc_0)
	(= global144 (= global143 (Random 0 3)))
	(doortop setCel: (doortop lastCel:))
	(gCurRoom setScript: sExitSubfloor 0 0)
)

(procedure (localproc_1)
	(= global144 (= global143 (* 2 (Random 0 1))))
	(doorbtm setCel: (doorbtm lastCel:))
	(gCurRoom setScript: sExitSubfloor 0 1)
)

(instance rm1035 of Rm
	(properties
		noun 5
		picture 125
		style -32758
	)

	(method (init)
		(LoadMany rsVIEW 670)
		(gEgo y: 189)
		(switch global133
			(1
				(= local8 1)
				(= local9 2)
			)
			(2
				(= local8 1)
				(= local9 2)
			)
			(3
				(= local8 1)
				(= local9 2)
			)
			(4
				(if (== global134 3)
					(= local8 1)
					(= local9 2)
				else
					(= local8 4)
					(= local9 5)
				)
			)
			(5
				(= local8 4)
				(= local9 5)
			)
			(6
				(if (== global134 2)
					(= local8 4)
					(= local9 5)
				else
					(= local8 6)
					(= local9 7)
				)
			)
			(7
				(cond
					((== global134 3)
						(= local8 0)
						(= local9 0)
					)
					((== global134 2)
						(= local8 4)
						(= local9 5)
					)
					(else
						(= local8 6)
						(= local9 7)
					)
				)
			)
			(8
				(if (== global134 3)
					(= local8 0)
					(= local9 0)
				else
					(= local8 6)
					(= local9 7)
				)
			)
			(9
				(= local8 6)
				(= local9 7)
			)
		)
		(switch gPrevRoomNum
			(1020
				(if (or (== global133 1) (== global133 4) (== global133 6))
					(localproc_0)
				else
					(localproc_1)
				)
			)
			(else
				(gEgo
					view: 670
					setLoop: -1
					setLoop: 1
					cel: 0
					x: 94
					y: 165
					init:
					setScale: Scaler 111 26 158 96
					setCycle: Walk
				)
			)
		)
		(doortop init:)
		(doorbtm init:)
		(turbtop init:)
		(turboDoors init: setOnMeCheck: 1 16384)
		(ladder init: setOnMeCheck: 1 64)
		(switch global143
			(3
				(liftBtm scaleX: 90 scaleY: 90 init: setScript: sLift)
			)
			(2
				(liftBtm scaleX: 160 scaleY: 160 init: setScript: sLift)
			)
			(else
				(liftBtm scaleX: 320 scaleY: 320 init: hide: setScript: sLift)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 88 180 133 100 129 102 86 173
					yourself:
				)
		)
		(super init:)
		(gDirectionHandler addToFront: doorbtm)
	)

	(method (doit)
		(super doit: &rest)
		(Palette palANIMATE 78 82 1 231 235 1)
		(cond
			((and (!= global144 global143) (== local10 0))
				(theMusic3 number: 128 setLoop: -1 play:)
				(= local10 1)
			)
			((and (== global144 global143) (== local10 1))
				(theMusic3 stop:)
				(= local10 0)
			)
		)
		(if (and (> (gEgo y:) 166) (not (gCurRoom script:)))
			(gCurRoom newRoom: 1030)
		)
	)

	(method (dispose)
		(theMusic3 dispose:)
		(gDirectionHandler delete: doorbtm)
		(if (!= global144 global143)
			(= global144 3)
			(= global143 3)
		)
		(super dispose: &rest)
	)
)

(instance sEnterSubfloor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						PolyPath
						[local0 (* register 2)]
						[local4 (* register 2)]
						self
				)
			)
			(1
				(gEgo
					setLoop: 3
					cel: 0
					x: [local0 (+ (* register 2) 1)]
					y: [local4 (+ (* register 2) 1)]
					setCycle: CT 3 1 self
				)
			)
			(2
				(if (== register 0)
					(doortop setCycle: End self)
				else
					(doorbtm setCycle: End self)
				)
				(gSq5Music2 number: 103 setLoop: 1 play:)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gGame handsOn:)
				(if (== register 0)
					(= global133 local8)
				else
					(= global133 local9)
				)
				(gCurRoom newRoom: 1020)
				(self dispose:)
			)
		)
	)
)

(instance sExitSubfloor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 670
					setLoop: -1
					setLoop: 3
					setCel: (gEgo lastCel:)
					setScale: Scaler 111 26 158 96
					x: [local0 (+ (* register 2) 1)]
					y: [local4 (+ (* register 2) 1)]
					init:
					setCycle: CT 3 -1 self
				)
			)
			(1
				(if (== register 0)
					(doortop setCycle: Beg self)
				else
					(doorbtm setCycle: Beg self)
				)
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo
					view: 670
					setLoop: -1
					setLoop: 1
					setCycle: Walk
					x: [local0 (* register 2)]
					y: [local4 (* register 2)]
					cel: 0
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLift of Script
	(properties)

	(method (doit)
		(if
			(and
				(> (liftBtm nsBottom:) (- (gEgo y:) 5))
				(not (gEgo script:))
			)
			(if (== global144 global143)
				(= global144 0)
				(= seconds 0)
				(= state 1)
				(self cue:)
			)
			(gEgo setScript: sSquishRog)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo script:)
					(self dispose:)
				else
					(= seconds 15)
				)
			)
			(1
				(switch global143
					(3
						(= global144 (Random 0 2))
					)
					(2
						(if (Random 0 1)
							(= state 8)
							(= global144 3)
						else
							(= state 3)
							(= global144 (Random 0 1))
						)
					)
					(else
						(= state 5)
						(= global144 (Random 2 3))
					)
				)
				(= ticks 1)
			)
			(2
				(if (< (liftBtm scaleX:) 160)
					(liftBtm scaleX: (+ (liftBtm scaleX:) 10))
					(liftBtm scaleY: (+ (liftBtm scaleY:) 10))
					(-- state)
				)
				(= ticks 10)
			)
			(3
				(if (== (= global143 2) global144)
					(= state -1)
				)
				(= cycles 1)
			)
			(4
				(if (< (liftBtm scaleX:) 320)
					(liftBtm scaleX: (+ (liftBtm scaleX:) 10))
					(liftBtm scaleY: (+ (liftBtm scaleY:) 10))
					(-- state)
				)
				(= ticks 10)
			)
			(5
				(= global143 global144)
				(liftBtm hide:)
				(= state -1)
				(= cycles 1)
			)
			(6
				(liftBtm show: scaleX: 320 scaleY: 320)
				(= cycles 1)
			)
			(7
				(if (> (liftBtm scaleX:) 160)
					(liftBtm scaleX: (- (liftBtm scaleX:) 10))
					(liftBtm scaleY: (- (liftBtm scaleY:) 10))
					(-- state)
				)
				(= ticks 10)
			)
			(8
				(if (== (= global143 2) global144)
					(= state -1)
				)
				(= cycles 1)
			)
			(9
				(if (> (liftBtm scaleX:) 90)
					(liftBtm scaleX: (- (liftBtm scaleX:) 10))
					(liftBtm scaleY: (- (liftBtm scaleY:) 10))
					(-- state)
				)
				(= ticks 10)
			)
			(10
				(= global143 3)
				(= state -1)
				(= cycles 1)
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance sSquishRog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> global143 global144)
					(= global144 0)
				else
					(= global144 3)
					(= state 1)
				)
				(= cycles 1)
			)
			(1
				(if (< (liftBtm nsBottom:) (gEgo y:))
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(gEgo view: 671 setLoop: -1 setLoop: 1 cel: 0 setCycle: 0)
				(= ticks 1)
			)
			(3
				(if (liftBtm script:)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(EgoDead 34) ; "Looks like you came up a bit thin that time..."
				(self dispose:)
			)
		)
	)
)

(instance liftBtm of Actor
	(properties
		x 138
		y 72
		noun 6
		view 670
		loop 6
		scaleSignal 1
		scaleX 90
		scaleY 90
	)

	(method (doit)
		(super doit: &rest)
		(if (gEgo script:)
			(self setPri: 14)
		else
			(self setPri: (CoordPri nsBottom))
		)
	)
)

(instance doortop of Actor
	(properties
		x 154
		y 106
		noun 7
		view 670
		loop 10
		priority 1
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sEnterSubfloor 0 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorbtm of Actor
	(properties
		x 161
		y 134
		noun 7
		view 670
		loop 8
		priority 1
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sEnterSubfloor 0 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(gUser canControl:)
				(& (event type:) $0040) ; direction
				(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
			)
			(switch (event message:)
				(JOY_NULL
					(gEgo setMotion: 0)
				)
				(JOY_UP
					(if (gEgo mover:)
						(gEgo setMotion: 0)
					else
						(gEgo setMotion: PolyPath 129 100)
					)
				)
				(JOY_UPRIGHT
					(if (gEgo mover:)
						(gEgo setMotion: 0)
					else
						(gEgo setMotion: PolyPath 129 100)
					)
				)
				(JOY_DOWNRIGHT
					(if (gEgo mover:)
						(gEgo setMotion: 0)
					else
						(gEgo setMotion: PolyPath 94 165)
					)
				)
				(JOY_DOWN
					(if (gEgo mover:)
						(gEgo setMotion: 0)
					else
						(gEgo setMotion: PolyPath 94 165)
					)
				)
				(JOY_DOWNLEFT
					(if (gEgo mover:)
						(gEgo setMotion: 0)
					else
						(gEgo setMotion: PolyPath 94 165)
					)
				)
				(JOY_UPLEFT
					(if (gEgo mover:)
						(gEgo setMotion: 0)
					else
						(gEgo setMotion: PolyPath 129 100)
					)
				)
			)
			(event claimed: 1)
			(return 1)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance turbtop of View
	(properties
		x 143
		y 80
		view 670
		loop 11
	)
)

(instance turboDoors of Feature
	(properties
		x 160
		y 120
		noun 3
		onMeCheck 16384
	)
)

(instance ladder of Feature
	(properties
		x 220
		y 130
		noun 4
		onMeCheck 64
	)
)

(instance theMusic3 of Sound
	(properties
		flags 1
	)
)

