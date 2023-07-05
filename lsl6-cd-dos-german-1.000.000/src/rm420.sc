;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use n079)
(use n082)
(use OccCyc)
(use LarryRoom)
(use CycleBet)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm420 0
)

(local
	local0
)

(instance rm420 of LarryRoom
	(properties
		noun 1
		picture 420
		style 15
		horizon 0
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 123 92 74 92 60 103 132 103 131 116 64 116 52 113 31 127 92 127 111 138 294 139 268 124 243 124 222 109 275 108 257 102 173 105 155 91
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 227 115 239 128 152 128 142 115
					yourself:
				)
		)
		(super init: &rest)
		(if (and (== gPrevRoomNum 430) (IsFlag 208))
			(= local0 1)
		)
		(gEgo
			init:
			view: 900
			normalize:
			setScale: Scaler 100 84 108 87
			heading: 180
			loop: 8
			cel: 2
		)
		(if (and (not (IsFlag 17)) (not local0))
			(gGlobalSound1 number: 420 play: 127 setLoop: -1)
		)
		(stairs init: setPri: 2 ignoreActors: 1 stopUpd:)
		(cond
			((IsFlag 17)
				(gGlobalSound1 stop:)
			)
			(local0)
			((Random 0 1)
				(stairGirl
					init:
					moveSpeed: 9
					setLoop: 0
					approachVerbs: 2 ; Talk
					setScript: climbStairs
				)
			)
			((Random 0 1)
				(liftingDude init: setCycle: OccCyc self -1 35 35)
			)
		)
		(if (and (not local0) (not (IsFlag 17)) (Random 0 1))
			(benchPresser init: cycleSpeed: 8 setPri: 14 setScript: benchPress)
		else
			(weightView init: setPri: 14 addToPic:)
		)
		(if
			(and
				(not local0)
				(not (IsFlag 17))
				(not (and (not (IsFlag 15)) (IsFlag 16)))
			)
			(shakerDude init: approachVerbs: 4 setCycle: Fwd) ; Do
		else
			(if (not (IsFlag 206))
				(theBelt init: approachVerbs: 4 5 stopUpd:) ; Do, Take
			)
			(shaker init: approachVerbs: 4 5) ; Do, Take
		)
		(cond
			((== gPrevRoomNum 430) 0)
			((and (not (IsFlag 15)) (not (IsFlag 16)))
				(SetFlag 15)
			)
			((and (IsFlag 15) (not (IsFlag 16)))
				(SetFlag 16)
			)
			((and (IsFlag 15) (IsFlag 16))
				(ClearFlag 15)
			)
		)
		(if (and (not (IsFlag 17)) (not (IsFlag 254)))
			(thunder
				init:
				setPri: 8
				cycleSpeed: 8
				ignoreActors: 1
				setCycle: OccCyc self 1 30 30
			)
		else
			(legSpreader init: ignoreActors: 1 addToPic:)
		)
		(switch gPrevRoomNum
			(440
				(gEgo posn: 270 103)
				(gGlobalSound2 stop:)
				(self setScript: enterThruDoor)
			)
			(430
				(gEgo posn: 190 132 view: 423 setLoop: 1 setCel: 9)
				(gCurRoom setScript: getOffBench)
			)
			(else
				(gGlobalSound2 stop:)
				(gEgo posn: 26 115)
				(self setScript: enterFromBath)
			)
		)
		(door init: setPri: 7 approachVerbs: 4) ; Do
		(door2 init: ignoreActors: 1 approachVerbs: 4) ; Do
		(bench init:)
		(weights init:)
		(weightBench init:)
		(rubbingBench init:)
	)

	(method (dispose)
		(gGlobalSound1 stop:)
		(super dispose:)
	)
)

(instance benchPress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 15))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(= seconds (Random 1 3))
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance toAerobics of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 901
					loop: 0
					setSpeed: 6
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(sFx number: 32 loop: 1 play: 127)
				(door2 view: 428 setCycle: End self)
			)
			(2
				(door2 setPri: 7)
				(thunder setPri: 9 stopUpd:)
				(gEgo
					view: 900
					setCycle: Walk
					setPri: 6
					setMotion: MoveTo 270 103 self
				)
			)
			(3
				(gGlobalSound1 fade:)
				(gCurRoom newRoom: 440)
			)
		)
	)
)

(instance toMudBath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 46 118 self)
			)
			(1
				(gEgo
					view: 901
					setSpeed: 6
					loop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(sFx number: 32 loop: 1 play: 127)
				(door view: 428 setCycle: End self)
			)
			(3
				(door setPri: -1)
				(gEgo view: 900 setCycle: Walk setMotion: MoveTo 26 113 self)
			)
			(4
				(door setCycle: Beg self)
			)
			(5
				(sFx number: 33 loop: 1 play: 127)
				(= cycles 4)
			)
			(6
				(gGlobalSound1 fade:)
				(gCurRoom newRoom: 400)
			)
		)
	)
)

(instance enterFromBath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo normalize: 900 0 1)
				(sFx number: 32 loop: 1 play: 127)
				(door view: 428 setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 46 118 self)
			)
			(2
				(door setPri: 7 setCycle: Beg self)
			)
			(3
				(sFx number: 33 loop: 1 play: 127)
				(door view: 420 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance climbStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(stairGirl
					setLoop: 0
					setCycle: Fwd
					moveSpeed: 9
					setMotion: MoveTo 185 70 self
				)
			)
			(1
				(stairGirl setLoop: 1 setCycle: 0 setCel: 0)
				(= seconds 3)
			)
			(2
				(stairs setCel: 1 stopUpd:)
				(stairGirl setCel: 1 moveSpeed: 4 setMotion: MoveTo 163 88 self)
			)
			(3
				(= seconds 1)
			)
			(4
				(stairs setCel: 0 stopUpd:)
				(self init:)
			)
		)
	)
)

(instance thunderLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(door setPri: 7)
				(thunder view: 422 setLoop: 2 setCel: 0 setCycle: End self)
				(legSpreader init: ignoreActors: 1 addToPic:)
			)
			(1
				(thunder
					setLoop: 3
					posn: 251 117
					setCycle: Walk
					cycleSpeed: 6
					moveSpeed: 6
					setStep: 3 2
					setMotion: MoveTo 200 118 self
				)
			)
			(2
				(Face gEgo thunder)
				(thunder setMotion: MoveTo 150 118 self)
			)
			(3
				(Face gEgo thunder)
				(thunder setMotion: MoveTo 40 118 self)
			)
			(4
				(thunder setLoop: 4 setCel: 0 setCycle: End self)
			)
			(5
				(sFx number: 32 loop: 1 play: 127)
				(door view: 428 setCycle: End self)
			)
			(6
				(door setPri: 8)
				(thunder
					setLoop: 3
					setCycle: Walk
					setPri: 6
					setMotion: MoveTo 20 118 self
				)
			)
			(7
				(gMessager say: 15 0 2 0 self) ; "(FORCEFULLY) And don't be late!"
			)
			(8
				(door setCycle: Beg self)
			)
			(9
				(sFx number: 33 loop: 1 play: 127)
				(door view: 420 setPri: 7 stopUpd:)
				(gGlobalSound2 fade:)
				(SetFlag 17)
				(thunder dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance liftWeights of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 105 92 self)
			)
			(1
				(gEgo
					view: 423
					setSpeed: 6
					setLoop: 0
					setCel: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: CycleBet 12 15 -1)
				(= seconds 3)
			)
			(3
				(EgoDead 4 self)
			)
			(4
				(gEgo posn: 105 92 normalize: 900 1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doLegBench of Script
	(properties)

	(method (handleEvent event)
		(if (and (< (event y:) 140) (== state 2))
			(self cue:)
			(super handleEvent: event)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar enable: (ScriptID 0 3) curIcon: (ScriptID 0 3)) ; icon0, icon0
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(gMouseDownHandler addToFront: self)
				(gKeyDownHandler addToFront: self)
				(gEgo setMotion: PolyPath 190 132 self)
			)
			(1
				(gEgo
					view: 423
					setSpeed: 6
					cel: 0
					setLoop: 1
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 2 setCycle: Fwd)
			)
			(3
				(gTheIconBar enable:)
				(gMouseDownHandler delete: self)
				(gKeyDownHandler delete: self)
				(gCurRoom setScript: getOffBench)
			)
		)
	)
)

(instance getOffBench of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setSpeed: 6 setLoop: 1 setCel: 9 setCycle: Beg self)
			)
			(1
				(gEgo normalize: 900 0 1)
				(if local0
					(gCurRoom setScript: thunderLeaves)
				else
					(gGlobalSound2 stop:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookAtThunder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 190 132 self)
			)
			(1
				(Face gEgo thunder self)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (IsFlag 103)
					(self cue:)
				else
					(gMessager say: 5 1 4 0 self) ; "Hi ya, Cutie! How ya doin'?"
				)
			)
			(4
				(gEgo
					view: 423
					setSpeed: 6
					cel: 0
					setLoop: 1
					setCycle: End self
				)
			)
			(5
				(gEgo setLoop: 2 setCycle: Fwd)
				(= ticks 180)
			)
			(6
				(gGlobalSound1 fade: 0 10 10 0)
				(= ticks 90)
			)
			(7
				(gCurRoom newRoom: 430)
			)
		)
	)
)

(instance enterThruDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(thunder setPri: 9)
				(door2 view: 428 setPri: 7 setCel: 6)
				(gEgo setPri: 6 setMotion: MoveTo 246 106 self)
			)
			(1
				(door2 setPri: -1 setCycle: Beg self)
			)
			(2
				(sFx number: 33 loop: 1 play: 127)
				(door2 view: 420 stopUpd:)
				(thunder setPri: 8 stopUpd:)
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance liftingDude of Prop
	(properties
		x 82
		y 136
		noun 2
		view 425
		cel 8
	)
)

(instance stairGirl of Actor
	(properties
		x 163
		y 88
		noun 3
		approachX 150
		approachY 102
		view 421
		loop 1
		cel 6
	)
)

(instance shakerDude of Prop
	(properties
		x 295
		y 127
		noun 4
		approachX 270
		approachY 130
		view 426
		cycleSpeed 3
	)
)

(instance thunder of Actor
	(properties
		x 266
		y 76
		noun 5
		view 420
		loop 6
		cycleSpeed 10
	)

	(method (doit)
		(if (and (not (gCurRoom script:)) (not local0) (== (self cel:) 1))
			(sFx number: 421 loop: 1 play:)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 1 2) ; Look, Talk
				(gCurRoom setScript: lookAtThunder)
			)
			(12 ; handcuffs
				(gGame changeScore: 15 208)
				(gCurRoom setScript: lookAtThunder)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door2 of Prop
	(properties
		x 286
		y 53
		noun 16
		approachX 254
		approachY 109
		view 420
		loop 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: toAerobics)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance door of Prop
	(properties
		x 22
		y 122
		noun 9
		approachX 46
		approachY 118
		view 420
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: toMudBath)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance benchPresser of Prop
	(properties
		x 85
		y 139
		noun 12
		view 427
	)
)

(instance stairs of View
	(properties
		x 173
		y 95
		view 420
		loop 3
	)
)

(instance theBelt of View
	(properties
		x 307
		y 123
		approachX 263
		approachY 130
		view 420
		loop 4
	)

	(method (doVerb theVerb)
		(shaker doVerb: theVerb)
	)
)

(instance legSpreader of View
	(properties
		x 293
		y 94
		noun 11
		view 420
		loop 5
	)
)

(instance weightView of View
	(properties
		x 60
		y 122
		view 420
		loop 2
	)
)

(instance shaker of Feature
	(properties
		x 270
		y 130
		noun 6
		approachX 263
		approachY 130
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 278 127 319 78 319 129 293 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Take
				(if (not (IsFlag 206))
					(gGame changeScore: 8 206)
					(gEgo get: 4) ; belt
					(theBelt dispose:)
					(super doVerb: theVerb)
				else
					(gMessager say: 6 5 1) ; "You already took that poor machine's belt; must it give you its all?"
				)
			)
			(1 ; Look
				(if (IsFlag 206)
					(gMessager say: 6 1 1) ; "The bun shaker hasn't been used much since you stole its only belt!"
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(if (IsFlag 206)
					(gMessager say: 6 4 1) ; "There's nothing to do with this machine since some jerk stole its belt!"
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

(instance bench of Feature
	(properties
		x 180
		y 131
		noun 7
		nsTop 108
		nsLeft 153
		nsBottom 131
		nsRight 225
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (gCast contains: thunder)) ; Do
			(gCurRoom setScript: doLegBench)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance weights of Feature
	(properties
		noun 8
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 82 87 84 73 127 73 127 89
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 5) ; Do, Take
			(gCurRoom setScript: liftWeights)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance barBell of Feature ; UNUSED
	(properties
		noun 12
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 22 130 66 105 72 128 69 139 17 138 24 129
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance weightBench of Feature
	(properties
		noun 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 179 78 198 59 237 59 243 67 222 98 176 101
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rubbingBench of Feature
	(properties
		noun 13
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 83 100 86 96 121 95 115 102 83 101
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sFx of Sound
	(properties)
)

