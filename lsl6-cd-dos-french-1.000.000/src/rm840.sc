;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 840)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm840 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm840 of LarryRoom
	(properties
		noun 1
		picture 840
		horizon 0
		west 820
	)

	(method (init)
		(gCurRoom
			addObstacle:
				(= local0
					((Polygon new:)
						type: PContainedAccess
						init: 0 133 48 127 63 121 287 123 319 130 319 89 135 89 135 75 55 86 0 83
						yourself:
					)
				)
				((Polygon new:)
					type: PBarredAccess
					init: 213 100 214 106 187 104 193 99
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 74 96 72 90 154 93 140 101 74 97
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 89 100 103 101 101 104 90 104
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 293 116 299 105 315 106 316 120
					yourself:
				)
		)
		(super init: &rest)
		(tent init:)
		(table1 init:)
		(table2 init:)
		(razorWire init:)
		(dancer1 init: cycleSpeed: 10 setScript: boogie)
		(guyChugger init: ignoreActors: 1)
		(girlChugger init: ignoreActors: 1 setScript: guzzleBeer)
		(tub init: stopUpd:)
		(gWalkHandler addToFront: tent)
		(gGlobalSound1 number: 840 loop: -1 play: 50 fade: 127 10 10 0)
		(gEgo init: normalize: posn: -8 101)
		(fence init:)
		(trees init:)
		(self setScript: enterRoom)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if local2
					(gMessager say: 1 2 1) ; "Excuse me, everybody? Is it okay if I hang out here for a while?"
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gGlobalSound1 fade:)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(gWalkHandler delete: tent)
		(super dispose:)
	)
)

(instance boogie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client loop: (Random 0 2) setCel: 0 setCycle: Fwd)
				(= seconds (Random 1 5))
			)
			(1
				(self init:)
			)
		)
	)
)

(instance guzzleBeer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(girlChugger setCel: 0 stopUpd:)
				(guyChugger setCycle: CT 3 1 self)
			)
			(1
				(= ticks 180)
			)
			(2
				(guyChugger setCycle: Beg self)
			)
			(3
				(guyChugger stopUpd:)
				(= ticks 30)
			)
			(4
				(girlChugger setCycle: End self)
			)
			(5
				(sFx number: 843 loop: 1 play:)
				(girlChugger loop: 1 setCel: 0 setCycle: End self)
			)
			(6
				(= ticks 180)
			)
			(7
				(girlChugger setCycle: Beg self)
			)
			(8
				(girlChugger loop: 0 setCycle: End self)
			)
			(9
				(sFx number: 843 loop: 1 play:)
				(= ticks 20)
			)
			(10
				(self init:)
			)
		)
	)
)

(instance exitTent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local5 (- gMouseX 10))
				(= local6 (- gMouseY 10))
				(= local2 0)
				((gCurRoom obstacles:) delete: local1)
				(local1 dispose:)
				(gCurRoom
					addObstacle:
						(= local0
							((Polygon new:)
								type: PContainedAccess
								init: 0 133 48 127 63 121 287 123 319 130 319 89 135 89 135 75 55 86 0 83
								yourself:
							)
						)
				)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 154 82 self)
			)
			(2
				(gEgo
					view: 840
					setLoop: 3
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 139 83 self
				)
			)
			(3
				(gEgo normalize: 900 1 setMotion: MoveTo 127 81 self)
			)
			(4
				(gWalkHandler delete: outSide addToFront: tent)
				(gEgo setMotion: PolyPath local5 local6)
				(outSide dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 12 101 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterTent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 1)
				(outSide init:)
				(gWalkHandler delete: tent addToFront: outSide)
				((gCurRoom obstacles:) delete: local0)
				(local0 dispose:)
				(gCurRoom
					addObstacle:
						(= local1
							((Polygon new:)
								type: PContainedAccess
								init: 319 84 319 82 153 82 153 85 319 85
								yourself:
							)
						)
				)
				(gEgo setMotion: PolyPath 136 82 self)
			)
			(1
				(gEgo
					view: 840
					loop: 0
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 151 82 self
				)
			)
			(2
				(gEgo normalize: 843 setMotion: MoveTo 153 83 self)
			)
			(3
				(if (== local4 3)
					(= local4 (= register 0))
					(gEgo setMotion: PolyPath local5 local6)
					(gGame handsOn:)
					(self dispose:)
				)
				(if (self register:)
					(local3 doVerb: register)
					(= register 0)
				)
				(if (!= local3 tub)
					(= register 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance getBeer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 212 83 self)
			)
			(1
				(cond
					((== (self register:) 4)
						(gMessager say: 7 4 0 0 self) ; "Wow, is that water cold!"
					)
					((== (self register:) 35)
						(= global185 0)
						((gInventory at: 39) cue:) ; washcloth
						(gMessager say: 7 35 0 0 self) ; "You dip the washcloth into the tub of dissolved labels, glue, and icy water."
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(if (OneOf (self register:) 4 35)
					(gGame handsOn:)
					(self dispose:)
				else
					(self cue:)
				)
			)
			(3
				(gEgo
					setSpeed: 12
					view: 844
					loop: 0
					setCel: 0
					setSpeed: 12
					setCycle: CT 5 1 self
				)
			)
			(4
				(sFx number: 843 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(5
				(= ticks 60)
			)
			(6
				(if (IsFlag 271)
					(gGame changeScore: 6 272)
				else
					(gGame changeScore: 6 271)
				)
				(gEgo normalize: 843 get: 3) ; beer
				(= register 0)
				(enterTent register: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tub of View
	(properties
		x 225
		y 86
		noun 7
		view 840
		loop 1
	)

	(method (doVerb theVerb)
		(= local3 tub)
		(switch theVerb
			(5 ; Take
				(cond
					((not local2)
						(gCurRoom setScript: enterTent 0 theVerb)
					)
					((gEgo has: 3) ; beer
						(gMessager say: 7 5 3) ; "Six is about all the beer you can carry at one time!"
						(gGame handsOn:)
						(return 1)
					)
					((IsFlag 215)
						(gMessager say: 7 5 2) ; "The tub is finally empty."
						(gGame handsOn:)
						(return 1)
					)
					(else
						(gCurRoom setScript: getBeer 0 5)
					)
				)
			)
			(35 ; washcloth
				(if (not local2)
					(gCurRoom setScript: enterTent 0 theVerb)
				else
					(gCurRoom setScript: getBeer 0 35)
				)
			)
			(4 ; Do
				(if (not local2)
					(gCurRoom setScript: enterTent 0 theVerb)
				else
					(gCurRoom setScript: getBeer 0 4)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dancer1 of Prop
	(properties
		x 282
		y 85
		noun 8
		view 841
		loop 2
	)
)

(instance guyChugger of Prop
	(properties
		x 204
		y 86
		noun 11
		view 845
		loop 3
	)
)

(instance girlChugger of Prop
	(properties
		x 236
		y 86
		noun 12
		view 845
	)
)

(instance tent of Feature
	(properties
		noun 2
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 147 85 145 33 135 33 153 15 164 0 319 0 319 85
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(= local4 3)
			(= local5 (- gMouseX 10))
			(= local6 (- gMouseY 10))
			(gCurRoom setScript: enterTent)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance table1 of Feature
	(properties
		noun 3
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 14 76 13 66 24 67 26 60 69 58 76 75 15 76
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance table2 of Feature
	(properties
		noun 4
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 84 92 92 77 108 71 136 71 154 88 137 92 85 92
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance razorWire of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 139 0 116 59 103 88 101 130 114 199 113 208 103 261 106 302 117 291 58 319 55 319 139
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fence of Feature
	(properties
		noun 6
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 79 0 34 138 36 134 44 142 47 142 73 79 77 72 64 23 65 12 79
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance trees of Feature
	(properties
		noun 9
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 25 0 0 319 0 319 10 160 11 139 35 90 34 79 14 65 14 62 30
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance outSide of Feature
	(properties
		y 100
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 79 143 73 143 90 319 89 319 139 0 138 0 80
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (== (gEgo view:) 843) (== theVerb 3)) ; Walk
			(gCurRoom setScript: exitTent)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sFx of Sound
	(properties
		flags 1
	)
)

