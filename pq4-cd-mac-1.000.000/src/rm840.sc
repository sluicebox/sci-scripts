;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 840)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm840 0
)

(local
	local0
	local1 = 1
	local2 = 1
	local3
)

(instance rm840 of Room
	(properties
		picture 840
	)

	(method (init)
		(girlie init:)
		(super init:)
		(gGame handsOn:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 81 121 136 139 146 124 88 117
					yourself:
				)
		)
		(gEgo stopView: -1)
		(gEgo
			setHeading: 70
			normalize: 9830
			scaleSignal: 1
			scaleX: 118
			scaleY: 118
			init:
			x: 2
			y: 140
		)
		(yo init:)
		(girlie setScript: smoke)
		(gGlobalSound1 number: 840 setLoop: -1 play:)
		(ashtray init: approachVerbs: 4) ; Do
		(gGlobalSound0 fade: 0 4 1 1)
		(self setScript: walkIn)
		(gWalkHandler addToFront: self)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOVE) (< (event x:) 15))
			(if local2
				(self setScript: sExit)
				(event claimed: 1)
				(return)
			else
				(gMessager say: 0 0 1) ; MISSING MESSAGE
				(event claimed: 0)
				(return)
			)
		else
			(super handleEvent: event)
			(return)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance yo of Prop
	(properties
		noun 3
		x 62
		y 131
		priority 11
		view 8408
		signal 16384
		cycleSpeed 8
	)
)

(instance ashtray of Feature
	(properties
		noun 2
		nsLeft 144
		nsTop 121
		nsRight 153
		nsBottom 128
		sightAngle 40
		approachX 136
		approachY 132
		approachDist 0
		x 148
		y 140
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(or
						(gEgo has: 19) ; cigarette
						(not (== (girlie script:) doPhone))
						local1
					)
					(super doVerb: theVerb)
				else
					(gEgo setScript: getButt)
				)
			)
			(1 ; Look
				(if local3
					(gMessager say: 2 1 6 0) ; MISSING MESSAGE
				else
					(gMessager say: 2 1 5 0) ; MISSING MESSAGE
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance girlie of Prop
	(properties
		noun 1
		x 134
		y 121
		view 840
		signal 16384
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(if (and (== (walkIn state:) 4) (not (gEgo has: 19))) ; cigarette
				(walkIn register: 1 ticks: 0)
				(gMessager say: 1 2 2 0 walkIn) ; MISSING MESSAGE
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance getButt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					view: 9840
					setLoop: 0
					cycleSpeed: 0
					cel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo setLoop: 1 cycleSpeed: 2 cel: 0 setCycle: End self)
			)
			(5
				(gGame points: 4 93)
				(gEgo
					get: 19 ; cigarette
					setLoop: 0
					cycleSpeed: 0
					cel: 0
					setCycle: End self
				)
				(= local3 0)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo normalize: 9830)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if local1
			(doPhone register: 1)
		)
		(super doit:)
	)
)

(instance yoWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 300)
			)
			(1
				(yo setCycle: End self)
			)
			(2
				(yo setLoop: 1 cel: 0 setCycle: End self)
				(= local1 0)
			)
			(3
				(yo priority: 6)
				(= ticks 400)
			)
			(4
				(yo setLoop: 2 cel: 0 setCycle: End self)
				(= local1 1)
			)
			(5
				(= local2 1)
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 81 121 35 158 94 128 106 137 114 127 88 117
							yourself:
						)
				)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 20 150 self)
			)
			(2
				(gCurRoom newRoom: 830)
			)
		)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 93 125 self)
			)
			(1
				(gEgo setHeading: 108 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (gPqFlags test: 37)
					(gMessager say: 1 2 7 0 self) ; MISSING MESSAGE
				else
					(gPqFlags set: 37)
					(gMessager say: 1 2 3 0 self) ; MISSING MESSAGE
				)
			)
			(4
				(gGame handsOn:)
				(= ticks 540)
			)
			(5
				(if (not (gEgo has: 19)) ; cigarette
					(if register
						(smoke register: doPhone)
					else
						(smoke register: yell)
					)
				else
					(self dispose:)
				)
			)
			(6
				(smoke register: doPhone)
				(self dispose:)
			)
		)
	)
)

(instance smoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(girlie view: 840 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(= ticks 15)
			)
			(2
				(girlie setCycle: Beg self)
			)
			(3
				(if register
					(client setScript: register)
					(= register 0)
				else
					(= ticks (Random 100 400))
				)
			)
			(4
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance yell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 35)
			)
			(1
				(girlie view: 842 cel: 0 setCycle: End self)
			)
			(2
				(girlie view: 843 cel: 0 setCycle: End self)
			)
			(3
				(girlie view: 844 cel: 0 setCycle: End self)
			)
			(4
				(girlie view: 845 cel: 0 setCycle: End self)
			)
			(5
				(client setScript: doPhone)
			)
		)
	)
)

(instance ringer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFx1 number: 937 setLoop: 1 play: self)
			)
			(1
				(= state -1)
				(= ticks 200)
			)
		)
	)

	(method (dispose)
		(sFx1 stop:)
		(super dispose:)
	)
)

(instance doPhone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 0)
				(self setScript: ringer)
				(= ticks 1)
			)
			(1
				1
				(girlie view: 841 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				2
				(= seconds 3)
			)
			(3
				3
				(= ticks 1)
			)
			(4
				4
				(girlie view: 846 cel: 0 setCycle: End self)
			)
			(5
				5
				(self setScript: 0)
				(girlie view: 847 cel: 0 setCycle: End self)
			)
			(6
				6
				(yo setScript: yoWalk)
				(girlie view: 848 x: 78 y: 123 cel: 0 setCycle: End self)
				(= local3 1)
			)
			(7
				7
				(girlie view: 849 cel: 0 x: 49 y: 104 setCycle: End self)
			)
			(8
				8
				(girlie view: 8400 cel: 0 setCycle: End self)
			)
			(9
				9
				(cond
					((not (yo script:))
						(= local1 1)
						(girlie view: 8400 loop: 1 cel: 0 setCycle: End self)
					)
					((and (not local1) (not (Random 0 10)))
						(girlie view: 8401 loop: 0 cel: 0 setCycle: End self)
					)
					(else
						(= local1 0)
						(girlie view: 8400 loop: 1 cel: 0 setCycle: End self)
					)
				)
			)
			(10
				(if (not (girlie loop:))
					(= local1 1)
				)
				(girlie setCycle: Beg self)
			)
			(11
				(if register
					(self cue:)
				else
					(= local1 0)
					(= ticks (Random 10 60))
					(= state 8)
				)
			)
			(12
				(girlie view: 8401 loop: 0 cel: 0 setCycle: End self)
			)
			(13
				(gMessager say: 1 0 4 1 self) ; MISSING MESSAGE
			)
			(14
				(girlie loop: 1 cel: 0 setCycle: End self)
			)
			(15
				(gMessager say: 1 0 4 2 self) ; MISSING MESSAGE
			)
			(16
				(girlie loop: 2 cel: 0 setCycle: End self)
			)
			(17
				(gGlobalSound0
					number: 801
					setLoop: -1
					setVol: 0
					play:
					fade: 127 4 1 0
				)
				(gGlobalSound1 stop:)
				(gPqFlags set: 28)
				(gCurRoom newRoom: 860)
			)
		)
	)
)

(instance sFx1 of Sound
	(properties)
)

