;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Main)
(use Teller)
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
	rm720 0
)

(local
	local0
	local1
	[local2 5] = [0 9 -8 10 999]
	[local7 2]
	[local9 7] = [0 4 1 2 3 -5 999]
	[local16 3] = [0 -6 999]
	[local19 3] = [0 -7 999]
	[local22 3] = [0 -8 999]
	[local25 5] = [0 -5 -6 -7 999]
	[local30 5]
)

(instance rm720 of Rm
	(properties
		picture 720
	)

	(method (init)
		(super init:)
		(gLongSong number: 720 setLoop: -1 play: 127)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 128 237 127 211 111 171 111 156 127 192 147 187 157 91 160 112 135 85 133 79 150 58 150 46 140 0 143
					yourself:
				)
		)
		(= [local7 0] @local2)
		(= [local30 0] @local9)
		(= [local30 1] @local16)
		(= [local30 2] @local19)
		(= [local30 3] @local22)
		(manuTell init: funkyMonkey @local9 @local30 @local25)
		(egoTell init: gEgo @local2 @local7)
		(gEgo x: -10 y: 160 setScale: 189 normalize: noun: 2 init:)
		((ScriptID 41 1) x: -10 y: 170 setScale: 189 noun: 12 init:) ; Manu
		(tree init:)
		(treeTop init: approachVerbs: 4) ; Do
		(tree init:)
		(leaves init:)
		(otherTree init:)
		(notherTree init:)
		(threeTree init:)
		(fourTree init:)
		(fern init:)
		(roots init:)
		(rocks init:)
		(funkyMonkey init:)
		(gCurRoom setScript: enterRoom)
	)

	(method (doit)
		(if (and (> (gEgo z:) 80) (== script (ScriptID 31 1))) ; sLevitate
			(= gUseObstacles 1)
			(gEgo solvePuzzle: 321 8)
			(gCurRoom newRoom: 730)
		)
		(cond
			(script 0)
			((> (gEgo x:) 10) 0)
			((IsFlag 14)
				(gCurRoom setScript: blockEgo)
			)
			((not (IsFlag 14))
				(gCurRoom newRoom: 180)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; levitateSpell
				(if local1
					(gCurRoom setScript: byeByeLance)
				else
					((ScriptID 31 0) init: 187 131) ; leviCode
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(funkyMonkey dispose:)
		(LoadMany 0 41 31)
		(super dispose:)
	)
)

(instance byeByeLance of Script
	(properties)

	(method (doit)
		(if (< (gEgo y:) 5)
			(gEgo priority: -1)
			(gEgo solvePuzzle: 321 8)
			(gCurRoom newRoom: 730)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 160 137 self)
			)
			(1
				(gMessager say: 3 6 13 0 self) ; "This advertisement brought to you by Lance Is Sad Productions."
			)
			(2
				(sFx number: 945 play:)
				(gEgo
					view: 731
					setPri: 10
					setCycle: Fwd
					setMotion: MoveTo 160 0 self
				)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setScale: 0 setMotion: PolyPath 50 160 self)
			)
			(1
				((ScriptID 41 1) stopUpd:) ; Manu
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoClimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 95 137 self)
			)
			(1
				(gEgo setPri: 10 view: 7 loop: 2 cel: 1)
				(= cycles 1)
			)
			(2
				(sFx number: 928 play:)
				(gEgo
					loop: 3
					cel: 0
					yStep: 3
					setCycle: Fwd
					setMotion: MoveTo 95 49 self
				)
			)
			(3
				(gEgo yStep: 2 setPri: -1 normalize: 111)
				(= cycles 1)
			)
			(4
				(gEgo solvePuzzle: 321 8)
				(gCurRoom newRoom: 730)
			)
		)
	)
)

(instance egoTryClimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 95 137 self)
			)
			(1
				(gEgo setPri: 10 view: 7 loop: 2 cel: 1)
				(= cycles 1)
			)
			(2
				(sFx number: 928 play:)
				(gEgo loop: 3 cel: 0 setCycle: Fwd cycleSpeed: 3)
				(= ticks 120)
			)
			(3
				(gEgo view: 0 y: 137 setPri: -1 normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dropRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ladder init: setCycle: End self)
			)
			(1
				(sFx number: 920 play:)
				(gEgo setMotion: PolyPath 187 131 self)
			)
			(2
				(gEgo view: 7 loop: 2 cel: 1 y: 86)
				(= cycles 1)
			)
			(3
				(gEgo solvePuzzle: 321 8)
				(gCurRoom newRoom: 730)
			)
		)
	)
)

(instance climbRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 215 155 self ignoreActors: 1)
			)
			(1
				(gEgo view: 8 loop: 1 cel: 0 setCycle: CT 6 1 self)
			)
			(2
				(gEgo setCycle: End)
				(rope setPri: 0 setCycle: End self init:)
				(sFx number: 721 play:)
			)
			(3
				(gEgo
					view: 0
					setCycle: Walk
					setMotion: PolyPath 190 145 self
				)
			)
			(4
				(gEgo view: 7 setLoop: 1 cel: 0 setCycle: End self)
			)
			(5
				(sFx number: 928 play:)
				(gEgo
					cel: 1
					setPri: 2
					y: 100
					yStep: 3
					setCycle: Fwd
					setMotion: MoveTo 193 0 self
				)
			)
			(6
				(gEgo normalize: dispose:)
				(= cycles 1)
			)
			(7
				(gEgo solvePuzzle: 321 8)
				(gCurRoom newRoom: 730)
			)
		)
	)
)

(instance blockEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 1 6 10) ; "No, no. Not see village. No go before see village. Come, you see village, then go."
				(gEgo setMotion: PolyPath 50 160 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance funkyMonkey of Prop
	(properties
		x 40
		y 69
		noun 1
		view 988
		loop 3
		signal 16384
		cycleSpeed 10
		detailLevel 3
	)

	(method (doit)
		(if (and (not (self cycler:)) (== (Random 1 120) 5))
			(self loop: (Random 0 3) cel: 0 setCycle: End)
			(sFx number: 929 play:)
		)
		(super doit:)
	)
)

(instance rope of Prop
	(properties
		x 190
		y 103
		view 50
		signal 16384
	)
)

(instance ladder of Prop
	(properties
		x 188
		y 27
		view 720
		signal 16384
	)
)

(instance treeTop of Feature
	(properties
		x 144
		y 16
		nsTop 5
		nsLeft 56
		nsBottom 35
		nsRight 233
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; theGrapnel
				(if (not (gCurRoom script:))
					(gCurRoom setScript: climbRope)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leaves of Feature
	(properties
		x 137
		y 13
		noun 9
		nsTop 1
		nsLeft 33
		nsBottom 26
		nsRight 241
		sightAngle 180
	)
)

(instance otherTree of Feature
	(properties
		x 274
		y 40
		noun 5
		nsTop 9
		nsLeft 254
		nsBottom 72
		nsRight 295
		sightAngle 180
	)
)

(instance notherTree of Feature
	(properties
		x 179
		y 53
		noun 6
		nsTop 27
		nsLeft 168
		nsBottom 80
		nsRight 191
		sightAngle 180
	)
)

(instance threeTree of Feature
	(properties
		x 139
		y 55
		noun 7
		nsTop 27
		nsLeft 130
		nsBottom 83
		nsRight 149
		sightAngle 180
	)
)

(instance fourTree of Feature
	(properties
		x 24
		y 48
		noun 8
		nsLeft 4
		nsBottom 97
		nsRight 44
		sightAngle 180
	)
)

(instance fern of Feature
	(properties
		x 64
		y 172
		noun 10
		nsTop 159
		nsLeft 31
		nsBottom 186
		nsRight 98
		sightAngle 180
	)
)

(instance roots of Feature
	(properties
		x 140
		y 139
		noun 11
		nsTop 126
		nsLeft 108
		nsBottom 153
		nsRight 173
		sightAngle 180
	)
)

(instance rocks of Feature
	(properties
		x 203
		y 95
		noun 13
		nsTop 88
		nsLeft 176
		nsBottom 103
		nsRight 231
		sightAngle 180
	)
)

(instance tree of Feature
	(properties
		x 95
		y 67
		noun 4
		nsTop 11
		nsLeft 56
		nsBottom 123
		nsRight 134
		sightAngle 40
		approachX 95
		approachY 137
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(if [gEgoStats 11] ; climb
						(gCurRoom setScript: egoClimb)
					else
						(gCurRoom setScript: egoTryClimb)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sFx of Sound
	(properties)
)

(instance egoTell of Teller
	(properties)

	(method (showDialog)
		(super showDialog: -8 (== local0 1)) ; "Talk about Swingline"
	)

	(method (doChild)
		(switch query
			(-8 ; "Talk about Swingline"
				(gCurRoom setScript: dropRope)
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
		(super
			showDialog:
				-5 ; "Help"
				(and (not (> [gEgoStats 28] 0)) (not (> [gEgoStats 11] 0))) ; levitateSpell, climb
		)
	)

	(method (doChild)
		(switch query
			(-8 ; "Swingline"
				(= local0 1)
				(return query)
			)
			(-5 ; "Help"
				(super doChild: query)
			)
			(-6 ; "Rope"
				(super doChild: query)
			)
			(-7 ; "Vines"
				(super doChild: query)
			)
			(else
				(return query)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41 ; theFeather
				(= local1 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

