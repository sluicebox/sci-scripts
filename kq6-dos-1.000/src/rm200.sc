;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use StopWalk)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	rm200 0
)

(local
	local0
	local1
	local2
	[local3 10] = [176 147 238 130 250 130 250 135 189 151]
	[local13 16] = [235 133 243 133 243 139 227 139 189 151 177 146 222 129 235 129]
	local29
	local30
	local31
)

(procedure (localproc_0)
	(if (IsFlag 11)
		(ClearFlag 11)
	else
		(SetFlag 11)
	)
	((gCurRoom obstacles:) delete: plankPoly)
	(gCurRoom
		addObstacle:
			(if (IsFlag 11)
				(chest setPri: -1)
				(plankPoly type: PBarredAccess points: @local13 size: 8 yourself:)
			else
				(chest setPri: 1)
				(plankPoly type: PBarredAccess points: @local3 size: 5 yourself:)
			)
	)
)

(instance rm200 of KQ6Room
	(properties
		noun 3
		picture 200
		horizon 10
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 150 108 114 115 102 134 62 152 -50 189 -50 -200 319 -200 319 189 215 189 263 143 271 117 222 107 210 99 205 87 211 70 235 60 267 54 250 51 192 67 187 80 191 102
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 214 117 232 117 243 120 243 125 193 125 193 123
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 144 183 144 179 181 169 179 183
					yourself:
				)
		)
		(gTheIconBar enable:)
		(if (== gPrevRoomNum 155)
			(= style 6)
		)
		(super init: &rest)
		(gEgo ignoreActors: actions: egoDoVerb)
		(genericFeatures init:)
		((ScriptID 10 4) onMeCheck: 32 init:) ; rocks
		(if (gCurRoom script:)
			((gCurRoom script:) caller: self)
		)
		(if (OneOf gPrevRoomNum 105 106 99) ; egaToon, speedRoom
			(gEgo init:)
			(Palette palSET_INTENSITY 0 256 100)
			(self setScript: (ScriptID 201)) ; startupScr
			(= gAct 1)
		else
			(switch gPrevRoomNum
				(210
					(gEgo init:)
					(gCurRoom setScript: enterRoomScr)
				)
				(155
					(gEgo init: view: 203)
					(gGame setCursor: gTheCursor)
					(self setScript: (ScriptID 202)) ; nightmareCartoon
				)
				(100
					(gEgo
						init:
						posn: 175 130
						loop: 2
						setScale: Scaler 100 50 112 57
					)
					(gGame handsOn:)
					(gTheIconBar curIcon: (gTheIconBar at: 0))
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				)
			)
		)
		(bush1 init:)
		(bush2 init:)
		(bush3 init:)
		(shipsails init:)
		(wave init:)
		(if (> (gGame _detailLevel:) 1)
			(wave setScript: waveScr)
			(if (> (gGame _detailLevel:) 2)
				(bush1 setScript: (Clone (ScriptID 13 0))) ; windScr
				(bush2 setScript: (Clone (ScriptID 13 0))) ; windScr
				(shipsails setScript: (Clone (ScriptID 13 0))) ; windScr
				(bush3 setScript: (ScriptID 13 0)) ; windScr
			)
		)
		(if (== gAct 0)
			(= gAct 1)
		)
		(if (== ((gInventory at: 39) owner:) 200) ; royalRing
			(royalRing init:)
		)
		(plank init:)
		(shipWheel init:)
		(= local0 0)
		(if (== gPrevRoomNum 155)
			(gGlobalSound fade:)
		else
			(gGlobalSound number: 915 loop: -1 play:)
		)
		(gGlobalSound2 number: 916 loop: -1 play:)
		(gWalkHandler addToFront: self)
		(gDirectionHandler addToFront: self)
	)

	(method (cue)
		(gEgo setScale: Scaler 100 50 112 57)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			((and (& (= temp0 (gEgo onControl: 1)) $0100) (not local29))
				(= local29 1)
				(plank setPri: 15)
			)
			((and (not (& temp0 $0100)) local29)
				(= local29 0)
				(plank setPri: 3)
			)
		)
		(cond
			(script 0)
			((& temp0 $4000)
				(gCurRoom setScript: exitRoomScr)
			)
			((& temp0 $0004)
				(cond
					((!= local0 1)
						(gGlobalSound3 number: 922 loop: -1 play:)
						(gEgo view: 308)
						(if (not ((gEgo cycler:) isKindOf: StopWalk))
							(gEgo setCycle: StopWalk -1)
						)
						(if (== local0 0)
							(cond
								((< (gEgo heading:) 135)
									(gEgo loop: 0)
								)
								((> (gEgo heading:) 225)
									(gEgo loop: 1)
								)
								(else
									(gEgo loop: 2)
								)
							)
						)
						(= local0 1)
					)
					((and (gEgo isStopped:) (not local2) local1)
						(gMessager say: 10 3 12 1) ; "The ocean is not as calm as it appears. Underwater currents tug at Alexander's legs."
						(= local2 1)
					)
				)
			)
			((& temp0 $0200)
				(cond
					((!= local0 2)
						(if (== local0 0)
							(gGlobalSound3 number: 922 loop: -1 play:)
						)
						(gEgo view: 3081)
						(if
							(and
								(not ((gEgo cycler:) isKindOf: StopWalk))
								(not ((gEgo cycler:) isKindOf: Rev))
							)
							(gEgo setCycle: StopWalk -1)
						)
						(= local0 2)
					)
					((and (gEgo isStopped:) (not local2) local1)
						(if local31
							(self setScript: egoStruggleScr)
							(= local2 1)
							(= local31 0)
						else
							(gMessager say: 10 3 12 1) ; "The ocean is not as calm as it appears. Underwater currents tug at Alexander's legs."
							(= local2 1)
						)
					)
				)
			)
			((& temp0 $0008)
				(if (!= local0 3)
					(if local1
						(gGame handsOff:)
						(gEgo
							setLoop: (gEgo loop:)
							setMotion: 0
							normal: 0
							setSpeed: 8
							setCycle: Rev
						)
						(repeat
							(gEgo y: (- (gEgo y:) 1))
							(breakif (not (& (gEgo onControl: 1) $0008)))
						)
						(= local31 1)
					else
						(self setScript: deathByWaterScr)
					)
					(= local0 3)
				)
			)
			((!= local0 0)
				(gGlobalSound3 fade: 0 10 15 1)
				(gEgo view: 900 setCycle: Walk)
				(= local0 0)
			)
		)
	)

	(method (handleEvent event)
		(if (& (event type:) $1040) ; evMOVE | direction
			(if (and (== (gTheIconBar at: 0) (gTheIconBar curIcon:)) (== local0 0))
				(= local1 1)
				(= local2 0)
			else
				(= local1 0)
			)
		else
			(super handleEvent: event)
		)
		(event claimed:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gMessager say: noun theVerb (if (< gPrevRoomNum 130) 4 else 5))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gGlobalSound fade:)
		(gGlobalSound2 fade:)
		(gWalkHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose:)
		(DisposeScript 951)
		(DisposeScript 969)
		(DisposeScript 923)
		(DisposeScript 13)
	)
)

(instance sand of Feature
	(properties
		y 190
		noun 14
	)

	(method (init)
		(= onMeCheck
			(= local30
				((Polygon new:)
					type: PContainedAccess
					init: 93 58 93 143 237 143 237 132 219 141 190 141 169 131 139 132 96 113 96 92 157 64 153 58
					yourself:
				)
			)
		)
		(super init: &rest)
		(= sightAngle 26505)
	)
)

(instance chestInset of Inset
	(properties
		view 202
		x 170
		y 98
		priority 15
		disposeNotOnMe 1
		noun 8
	)

	(method (init)
		(super init: &rest)
		(if (== ((gInventory at: 9) owner:) gCurRoomNum) ; coin
			(coin init:)
		)
		(sand init:)
		(gGame handsOn:)
		(gTheIconBar disable: 0 3 4 5 6)
	)

	(method (onMe param1 &tmp temp0)
		(if
			(InRect
				(+ (insetView nsLeft:) 5)
				(+ (insetView nsTop:) 5)
				(- (insetView nsRight:) 5)
				(- (insetView nsBottom:) 5)
				param1
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (dispose)
		(if (gCast contains: 9)
			(coin dispose:)
		)
		(sand dispose:)
		(super dispose:)
		(gTheIconBar enable: 0 3 6)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== ((gInventory at: 9) owner:) 200) ; coin
					(gMessager say: noun theVerb 10) ; "The box must have opened in the sea, spilling its treasure. Everything has been washed away except for one coin of Daventry."
				else
					(gMessager say: noun theVerb 11) ; "The box is now empty."
				)
			)
			(5 ; Do
				(if (== ((gInventory at: 9) owner:) 200) ; coin
					(gMessager say: noun theVerb 10) ; "There's nothing of interest in that part of the box."
				else
					(gMessager say: noun theVerb 11) ; "There's nothing left in the box, and the box itself is ruined."
				)
			)
			(40 ; coin
				(gMessager say: 5 theVerb) ; "Alexander might need the coin. He decides not to put it back in the box."
			)
			(else
				(if (!= theVerb 2) ; Talk
					(= theVerb 0)
				)
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plankPoly of Polygon
	(properties)
)

(instance egoDoVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; map
				(gCurRoom setScript: 130) ; pullOutMapScr
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance exitRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 252 58 self)
			)
			(1
				(gEgo
					ignoreActors:
					setPri: 1
					setLoop: 3
					setScale:
					illegalBits: 0
					setMotion: MoveTo 261 86 self
				)
			)
			(2
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance enterRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setPri: 1
					setLoop: 2
					posn: 261 86
					scaleX: 64
					scaleY: 64
					scaleSignal: 1
					show:
					setMotion: MoveTo 252 58 self
				)
			)
			(1
				(gEgo
					setPri: -1
					setLoop: -1
					setScale: Scaler 100 50 112 57
					setMotion: PolyPath 204 103 self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getCoinScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar enable: 6)
				(gGame handsOff:)
				(gEgo get: 9) ; coin
				(gGame givePoints: 1)
				(coin dispose:)
				(= cycles 2)
			)
			(1
				(gMessager say: 7 5) ; "Alexander takes the coin and leaves the ruined box where it is."
				(= cycles 2)
			)
			(2
				(chestInset dispose:)
				(self dispose:)
			)
		)
	)
)

(instance egoStruggleScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (Random 2 4))
				(= ticks 30)
			)
			(1
				(if (== (gEgo loop:) 2)
					(gEgo setLoop: 1)
				else
					(gEgo setLoop: 2)
				)
				(if (not (-- register))
					(-- state)
				)
				(= ticks 30)
			)
			(2
				(gEgo normal: 1 setCycle: StopWalk -1 setLoop: -1)
				(= cycles 2)
			)
			(3
				(gMessager say: 10 3 12 1 self) ; "The ocean is not as calm as it appears. Underwater currents tug at Alexander's legs."
			)
			(4
				(gEgo setSpeed: (gEgo currentSpeed:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoIntoSafeWater of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 view: 308)
				(gMessager say: 10 3 12 1 self) ; "The ocean is not as calm as it appears. Underwater currents tug at Alexander's legs."
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance deathByWaterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 10 3 15 0 self) ; "The underwater tow is amazingly strong here. It pulls ferociously at Alexander's legs."
			)
			(1
				(gGlobalSound3 stop: number: 921 loop: 1 play:)
				(gEgo
					view: 269
					setLoop: 0
					cel: 0
					normal: 0
					cycleSpeed: 6
					setCycle: End self
					heading: 200
					setMotion: MoveFwd 200
				)
			)
			(2
				(gCurRoom newRoom: 135)
			)
		)
	)
)

(instance replacePlankScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_0)
				(gEgo
					normal: 0
					posn: 242 139
					setSpeed: 6
					view: 201
					loop: 1
					cel: 8
					setScale: 0
					setCycle: CT 5 -1 self
				)
			)
			(1
				(plank cel: 0 hide:)
				(gEgo loop: 2 cel: 5 setCycle: CT 3 -1 self)
				(gGlobalSound4 number: 200 loop: 1 play:)
			)
			(2
				(plank show: stopUpd:)
				(= cycles 1)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(chest dispose:)
				(gEgo
					posn: (plank approachX:) (plank approachY:)
					reset: 2
					setScale: Scaler 100 50 112 57
				)
				(= cycles 2)
			)
			(5
				(gMessager say: 4 5 7 0 self) ; "Alexander moves the plank back to its original position."
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance displacePlankScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setSpeed: 6
					posn: 242 139
					view: 201
					normal: 0
					loop: 2
					cel: 0
					setScale: 0
					setCycle: CT 3 1 self
				)
			)
			(1
				(chest init:)
				(gGlobalSound4 number: 200 loop: 1 play:)
				(= cycles 2)
			)
			(2
				(plank cel: 1 hide:)
				(= cycles 1)
			)
			(3
				(gEgo setCycle: CT 4 1 self)
			)
			(4
				(plank show: stopUpd:)
				(gEgo setCycle: End self)
			)
			(5
				(= cycles 2)
			)
			(6
				(gEgo loop: 1 cel: 5 setCycle: End self)
			)
			(7
				(gEgo
					reset: 5
					posn: (plank approachX:) (plank approachY:)
					setScale: Scaler 100 50 112 57
				)
				(localproc_0)
				(= cycles 2)
			)
			(8
				(gMessager say: 4 5 6 0 self) ; "Alexander pushes the plank to one side."
			)
			(9
				(if (not (SetFlag 92))
					(gGame givePoints: 1)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance objectGlitter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 7))
			)
			(1
				(= state -1)
				(client cel: 0 setCycle: End self)
			)
		)
	)
)

(instance openChestScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 5 5 9 1 self) ; "Alexander opens the box."
			)
			(1
				(gEgo
					setSpeed: 6
					normal: 0
					posn: (chest x:) (chest y:)
					view: 201
					loop: 3
					cel: 0
					setScale: 0
					setCycle: End self
				)
			)
			(2
				(= ticks 12)
			)
			(3
				(gGlobalSound4 number: 904 loop: 1 play: self)
			)
			(4
				(= ticks 12)
			)
			(5
				(chestInset init: self gCurRoom)
			)
			(6
				(= cycles 2)
			)
			(7
				(gGame handsOff:)
				(= ticks 1)
			)
			(8
				(gMessager say: 5 5 8 1 self) ; "Alexander closes the box."
			)
			(9
				(gGlobalSound4 number: 905 loop: 1 play: self)
			)
			(10
				(= ticks 12)
			)
			(11
				(gEgo setCycle: Beg self)
			)
			(12
				(gEgo posn: 240 132 reset: 2 setScale: Scaler 100 50 112 57)
				(= cycles 2)
			)
			(13
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance chest of Prop
	(properties
		x 237
		y 137
		noun 5
		sightAngle 45
		approachX 235
		approachY 132
		view 200
		loop 4
		cel 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(self setScript: openChestScr)
			)
			(1 ; Look
				(gMessager say: noun theVerb 9) ; "Alexander's treasure box lies partially buried in the sand. It must have washed ashore with the other ship debris."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)
)

(instance takeRingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= (gEgo loop:) 1)
					(gEgo setHeading: 315 self)
				else
					(self cue:)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					normal: 0
					setSpeed: 8
					view: 201
					loop: 4
					cel: 0
					setCycle: End self
				)
				(royalRing dispose:)
			)
			(3
				(gGame givePoints: 1)
				(gEgo reset: 7 get: 39) ; royalRing
				(= cycles 2)
			)
			(4
				(gMessager say: 9 5 0 0 self) ; "Alexander picks up his royal insignia ring from the beach."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance royalRing of Prop
	(properties
		x 104
		y 134
		noun 9
		sightAngle 45
		approachX 134
		approachY 136
		view 202
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: takeRingScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(self
			cel: 0
			setCycle: End
			setScript: (Clone objectGlitter)
			approachVerbs: 5 ; Do
		)
		(if (not (IsFlag 48))
			(= loop 3)
		)
		(super init: &rest)
	)
)

(instance coin of Prop
	(properties
		x 188
		y 121
		noun 7
		sightAngle 360
		view 202
		loop 1
		cel 8
	)

	(method (init)
		(self
			cel: 0
			setCycle: End
			setScript: (Clone objectGlitter)
			sightAngle: 360
			setPri: 15
		)
		(super init: &rest)
		(= sightAngle 26505)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: getCoinScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shipsails of Prop
	(properties
		x 56
		y 46
		noun 11
		view 200
		cel 2
		signal 4097
		cycleSpeed 2
	)
)

(instance bush1 of Prop
	(properties
		x 98
		y 99
		noun 15
		view 200
		loop 1
		cel 4
		signal 4097
		cycleSpeed 2
	)
)

(instance bush2 of Prop
	(properties
		x 291
		y 85
		noun 15
		view 200
		loop 2
		cel 2
		signal 4097
		cycleSpeed 3
	)
)

(instance bush3 of Prop
	(properties
		x 162
		y 20
		noun 15
		view 200
		loop 3
		cel 2
		signal 4097
		cycleSpeed 3
	)
)

(instance plank of View
	(properties
		x 242
		y 139
		noun 4
		sightAngle 45
		approachX 244
		approachY 132
		view 200
		loop 4
		signal 20481
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 11)
					(gCurRoom setScript: replacePlankScr)
				else
					(gCurRoom setScript: displacePlankScr)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 5 ; Do
			cel:
				(if (IsFlag 11)
					(chest init:)
					1
				else
					0
				)
		)
		(gCurRoom
			addObstacle:
				(if (IsFlag 11)
					(chest setPri: -1)
					(plankPoly type: PBarredAccess points: @local13 size: 8 yourself:)
				else
					(chest setPri: 1)
					(plankPoly type: PBarredAccess points: @local3 size: 5 yourself:)
				)
		)
	)
)

(instance genericFeatures of Feature
	(properties)

	(method (onMe param1 &tmp temp0)
		(return
			(= noun
				(cond
					((== (= temp0 (OnControl CONTROL (param1 x:) (param1 y:))) 128) 15)
					(
						(or
							(== temp0 256)
							(and (== temp0 2048) (> (param1 y:) 91))
						)
						14
					)
					((== temp0 64) 12)
					((== temp0 16) 11)
					((and (== temp0 512) (< (param1 y:) 130)) 16)
					((== temp0 2048) 17)
					((== temp0 16) 11)
					((OneOf temp0 8 4 512) 10)
					((OneOf temp0 1024 16384) 19)
					(else 0)
				)
			)
		)
	)
)

(instance waveScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wave cel: 0 setCycle: End self)
			)
			(1
				(wave setCycle: Beg self)
			)
			(2
				(wave hide:)
				(= seconds (Random 3 8))
			)
			(3
				(wave show:)
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance wave of Prop
	(properties
		x 129
		y 158
		noun 10
		view 204
		priority 1
		signal 20496
	)
)

(instance shipWheel of Feature
	(properties
		x 160
		y 176
		noun 18
	)

	(method (onMe param1)
		(return
			(or
				(InRect 145 175 160 181 (param1 x:) (param1 y:))
				(InRect 162 169 175 177 (param1 x:) (param1 y:))
				(InRect 171 164 177 169 (param1 x:) (param1 y:))
				(InRect 156 170 162 175 (param1 x:) (param1 y:))
			)
		)
	)
)

