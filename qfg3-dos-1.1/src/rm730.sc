;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 730)
(include sci.sh)
(use Main)
(use Teller)
(use OccasionalCycle)
(use MCyc)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm730 0
)

(local
	local0
	[local1 33] = [2 0 106 133 2 1 119 130 2 2 130 127 2 3 139 129 2 4 140 142 2 5 141 148 2 6 144 143 2 7 142 143 -32768]
	[local34 33] = [2 0 142 143 2 1 144 143 2 2 141 148 2 3 140 142 2 4 139 129 2 5 130 127 2 6 119 130 2 7 106 133 -32768]
	[local67 33] = [2 0 142 143 2 1 142 143 2 2 156 137 2 3 164 134 2 4 176 150 2 5 184 160 2 6 193 161 2 7 192 161 -32768]
	[local100 33] = [2 0 192 161 2 1 193 161 2 2 184 160 2 3 176 150 2 4 164 134 2 5 156 137 2 6 142 143 2 7 142 143 -32768]
	[local133 25] = [2 0 223 126 2 0 224 126 2 0 223 126 2 0 224 126 2 0 223 126 2 0 192 161 -32768]
	[local158 8] = [0 18 -11 -20 -21 -22 -23 999]
	[local166 2]
	[local168 7] = [0 7 -8 -11 -10 12 999]
	[local175 6]
	[local181 6] = [0 -8 -10 -13 -28 999]
	[local187 3] = [0 9 999]
	[local190 3] = [0 -13 999]
	[local193 3] = [0 -28 999]
	[local196 4] = [0 -15 16 999]
	local200
	local201
)

(procedure (localproc_0)
	(if (and (== gHeroType 0) (not (gEgo has: 41))) ; Fighter, theBridge
		(rBridge init: stopUpd:)
	)
	(gEgo view: 42 loop: 1 cel: 0 x: 253 y: 174 z: 0 noun: 1 init:)
	(babyMonkey cycleSpeed: 8 init:)
	((ScriptID 41 1) ; Manu
		view: 735
		loop: 3
		x: 35
		y: 169
		noun: 2
		setScale: 0
		setCycle: OccasionalCycle 0 Fwd 5 70
		setScript: monkeyControls
		init:
	)
	(egoTell init: gEgo @local158 @local166)
	(manuTell init: (ScriptID 41 1) @local168 @local175 @local181) ; Manu
	(gTheIconBar disable: 6)
)

(instance rm730 of Rm
	(properties
		noun 11
		picture 730
		style 10
	)

	(method (init)
		(= [local166 0] @local158)
		(= [local175 0] @local168)
		(= [local175 1] @local187)
		(= [local175 2] @local190)
		(= [local175 3] @local193)
		(= [local175 4] @local196)
		(super init:)
		(gLongSong2 number: 915 setLoop: -1 play: 127)
		(leafBed init:)
		(ropeBridge init:)
		(nest init:)
		(notherBridge init:)
		(treeTops init:)
		(branch init:)
		(if (IsFlag 14)
			(gCurRoom setScript: firstTime)
		else
			(localproc_0)
		)
		(HandsOn)
		(gTheIconBar disable: 1 6)
		(User canControl: 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 0) ; theGrapnel
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(LoadMany 0 956 41 942)
		(super dispose:)
	)
)

(instance jumpOnArm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(babyMonkey setCycle: End self)
			)
			(1
				(gEgo loop: 0 setCycle: End self)
			)
			(2
				(babyMonkey setCycle: Beg self)
			)
			(3
				(babyMonkey setCycle: MCyc @local133 self)
				(sFx number: 929 play:)
			)
			(4
				(sFx number: 929 play:)
				(babyMonkey setCycle: MCyc @local100)
				(gEgo setCycle: Beg)
				(self dispose:)
			)
		)
	)
)

(instance monkeyControls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: monkeySwingLeft self)
			)
			(1
				(= seconds 5)
			)
			(2
				(self setScript: monkeyDown self)
			)
			(3
				(= seconds 3)
			)
			(4
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance monkeySwingLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(monkey1
					x: 237
					y: 56
					init:
					setCycle: Walk
					setMotion: MoveTo 141 93 self
				)
			)
			(1
				(sFx number: 929 play: 64)
				(monkey1 loop: 1 setCycle: ForwardCounter 3 self)
			)
			(2
				(sFx number: 929 play: 64)
				(monkey1 setCycle: Walk setMotion: MoveTo 237 56 self)
			)
			(3
				(monkey1 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance monkeyDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(monkey1
					x: 70
					y: 46
					init:
					setCycle: Fwd
					setMotion: MoveTo 73 99 self
				)
			)
			(1
				(sFx number: 929 play: 64)
				(monkey1 setCycle: ForwardCounter 4 self)
			)
			(2
				(sFx number: 929 play: 64)
				(monkey1 setCycle: Fwd setMotion: MoveTo 70 46 self)
			)
			(3
				(monkey1 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance theyLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 1)
			)
			(1
				(SetFlag 95)
				(SetFlag 88)
				(gEgo solvePuzzle: 323 3)
				(gCurRoom newRoom: 180)
			)
		)
	)
)

(instance firstTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 14)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance babyMonkey of Prop
	(properties
		x 106
		y 134
		view 735
	)

	(method (init)
		(self setCycle: MCyc @local1 setPri: 1)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 0) ; theGrapnel
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(if (and (== (Random 0 13) 7) (== (self cycler:) 0))
			(switch (Random 0 4)
				(0
					(self loop: 0 setCycle: End)
				)
				(1
					(self loop: 1 setCycle: End)
				)
				(2
					(if (or (== (self x:) 106) (== (self x:) 142))
						(self
							setCycle:
								MCyc
								(if (== (self x:) 106) @local1 else @local34)
						)
					)
				)
				(3
					(if (== (self x:) 142)
						(self
							setCycle:
								MCyc
								(if (Random 0 1) @local34 else @local67)
						)
					)
				)
				(4
					(switch (Random 0 1)
						(0
							(if (== (self x:) 192)
								(self setCycle: MCyc @local100)
							)
						)
						(1
							(if (== (self x:) 192)
								(self setScript: jumpOnArm)
							)
						)
					)
				)
			)
		)
		(super doit:)
	)
)

(instance rBridge of Prop
	(properties
		x 80
		y 119
		view 730
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 0) ; theGrapnel
			(4 ; Do
				(gEgo get: 41) ; theBridge
				(gEgo solvePuzzle: 322 5 9)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance monkey1 of Actor
	(properties
		x 141
		y 93
		view 988
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 0) ; theGrapnel
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leafBed of Feature
	(properties
		x 212
		y 163
		noun 4
		nsTop 139
		nsLeft 138
		nsBottom 188
		nsRight 287
		sightAngle 180
	)
)

(instance ropeBridge of Feature
	(properties
		x 31
		y 115
		noun 5
		nsTop 110
		nsBottom 120
		nsRight 62
		sightAngle 180
	)
)

(instance nest of Feature
	(properties
		x 208
		y 93
		noun 6
		nsTop 74
		nsLeft 190
		nsBottom 113
		nsRight 227
		sightAngle 180
	)
)

(instance notherBridge of Feature
	(properties
		x 138
		y 104
		noun 7
		nsTop 95
		nsLeft 93
		nsBottom 113
		nsRight 183
		sightAngle 180
	)
)

(instance treeTops of Feature
	(properties
		x 159
		y 29
		noun 8
		nsBottom 58
		nsRight 319
		sightAngle 180
	)
)

(instance branch of Feature
	(properties
		x 51
		y 165
		noun 9
		nsTop 141
		nsBottom 189
		nsRight 103
		sightAngle 180
	)
)

(instance sFx of Sound
	(properties)
)

(instance egoTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-20
				(and (== local201 1) (== local200 0))
				-21
				(== local200 1)
				-22
				(== local200 2)
				-23
				(== local200 3)
				-11 ; "Lost City"
				(== local201 1)
		)
	)

	(method (doChild)
		(switch query
			(-20
				(if (<= (gEgo trySkill: 13 250) 0) ; communication
					(++ local200)
				else
					(gCurRoom setScript: theyLeave)
				)
			)
			(-21
				(if (<= (gEgo trySkill: 13 200) 0) ; communication
					(++ local200)
				else
					(gCurRoom setScript: theyLeave)
				)
			)
			(-22
				(if (<= (gEgo trySkill: 13 150) 0) ; communication
					(++ local200)
				else
					(gCurRoom setScript: theyLeave)
				)
			)
			(-23
				(gCurRoom setScript: theyLeave)
			)
			(-2
				(return query)
			)
			(else
				(return query)
			)
		)
	)
)

(instance manuTell of Teller
	(properties)

	(method (showDialog)
		(super showDialog: -11 (= local201 1)) ; "Tell about Lost City"
	)

	(method (doChild)
		(switch query
			(-11 ; "Tell about Lost City"
				(return query)
			)
			(-8
				(super doChild: query)
			)
			(-10
				(super doChild: query)
			)
			(-13
				(super doChild: query)
			)
			(-28
				(super doChild: query)
			)
			(-15
				(= local201 1)
				(return query)
			)
			(else
				(return query)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 0) ; theGrapnel
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

