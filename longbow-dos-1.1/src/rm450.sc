;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 450)
(include sci.sh)
(use Main)
(use n013)
(use IconBar)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Inventory)
(use System)

(public
	rm450 0
)

(local
	local0
	[local1 5] = [440 470 455 460 480]
	[local6 5] = [160 217 143 122 157]
	[local11 5] = [145 147 144 147 65]
	[local16 5] = [160 225 139 113 159]
	[local21 5] = [157 147 134 148 61]
	[local26 5] = [0 8 16 2 4]
	local31
	[local32 4] = [52 52 25 25]
	[local36 4] = [0 4 8 18]
	[local40 4] = [100 115 197 208]
	local44 = 2
	local45 = 9
	local46 = 20
)

(procedure (localproc_0 param1)
	(if (and (== ((IconBar curIcon:) message:) 2) (& local0 param1))
		(&= local0 (~ param1))
	)
)

(instance rm450 of Rm
	(properties
		picture 450
	)

	(method (init &tmp temp0)
		(if (== gDisguiseNum 5) ; abbey monk
			(NormalEgo -1 50 51)
		else
			(NormalEgo -1 67)
			(gEgo setCycle: Walk)
		)
		(HandsOff)
		(gEgo setStep: 2 1 init:)
		(= script arrived)
		(arrived client: self)
		(= local0
			[local26
				(= temp0
					(switch gPrevRoomNum
						(440 0)
						(470 1)
						(455 2)
						(460 3)
						(480 4)
					)
				)
			]
		)
		(gEgo
			edgeHit: EDGE_NONE
			x: [local16 temp0]
			y: [local21 temp0]
			setMotion: MoveTo [local6 temp0] [local11 temp0] arrived
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 128 99 110 99 110 59 107 59 107 99 95 99 95 102 128 102 128 120 149 120 153 140 142 142 143 126 126 126 126 136 139 135 139 146 121 146 121 126 116 126 116 121 111 126 0 126 0 0 128 -2
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 137 148 137 189 0 189 0 148
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 118 129 118 146 104 146 103 129
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 132 83 132 76 140 70 136 64 132 62 149 64 154 69 150 75 155 80 150 84
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 179 64 170 68 179 75 179 83 168 83 162 85 157 80 161 74 156 69 161 63
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 141 92 141 101 132 101 132 92
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 170 92 180 92 180 101 170 101
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 141 109 141 118 132 118 132 109
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 170 110 180 110 180 119 170 119
					yourself:
				)
		)
		(if (== ((Inv at: 12) owner:) 470) ; puzzleBox
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 173 146 160 139 160 133 174 133 174 121 183 121 183 -2 319 -1 319 128 221 128 221 146 184 146 184 139 205 139 205 33 202 33 202 128 184 125 184 132 202 130 202 137 182 137 182 146
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 174 148 319 148 319 189 174 189
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 173 146 160 139 160 133 174 133 174 121 183 121 183 -2 319 -1 319 189 174 189 174 148 219 148 219 146 184 146 184 139 205 139 205 33 202 33 202 128 184 125 184 132 202 130 202 137 182 137 182 146
						yourself:
					)
			)
			(if (== gPrevRoomNum 470)
				(= local0 0)
			)
		)
		(= local44 (- (Random 2 9) 7))
		(= local45 (Random 9 10))
		(= local46 (Random 20 25))
		(wash init: approachVerbs: 2) ; Look
		(bedRm init: approachVerbs: 2) ; Look
		(ref init: approachVerbs: 2) ; Look
		(chap init: approachVerbs: 2) ; Look
		(front init: approachVerbs: 2) ; Look
		(kitchen init: approachVerbs: 2) ; Look
		(flag init: approachVerbs: 2) ; Look
		(cells init: approachVerbs: 2) ; Look
		(outside init:)
		(gEgo actions: (ScriptID 452 3)) ; noBlow
		(if
			(or
				(!= (gRgnMusic number:) 455)
				(and (== (gRgnMusic number:) 455) (== (gRgnMusic vol:) 0))
			)
			(gEgo setScript: changeMusic)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((u>= (= temp0 (& $7f7e (gEgo onControl: 1))) 1024)
				(self setScript: takeOff 0 temp0)
			)
			((and temp0 (not (& local0 temp0)))
				(cond
					((& temp0 $0002)
						(if (== gDay 10)
							(Say 1450 1) ; "Good, the Refectory is still empty."
						else
							(Say 1450 0) ; "I see the Refectory and the Abbot is within at the far end of the room."
						)
						(gEgo setMotion: 0)
						(= local0 2)
					)
					((& temp0 $0004)
						(Say 1450 6) ; "In front of me lies the Chapel, behind me, the unfinished nave."
						(= local0 4)
					)
					((& temp0 $0008)
						(cond
							((== gDisguiseNum 0) ; outlaw
								(Say 1450 4) ; "Why am I not surprised to find the door locked?"
							)
							((== ((Inv at: 12) owner:) 470) ; puzzleBox
								(Say 1450 2) ; "Ah, the door is unlocked and swings open easily. And inside I see what can only be the Abbot's room."
							)
							((== ((Inv at: 12) owner:) gEgo) ; puzzleBox
								(Say 1450 3) ; "The door's locked now."
							)
							(else
								(Say 1450 5) ; "This door is locked."
							)
						)
						(gEgo setMotion: 0)
						(= local0 8)
					)
					((& temp0 $0010)
						(Say 1450 7) ; "I see a laundry room within."
						(gEgo setMotion: 0)
						(= local0 16)
					)
					((& temp0 $0020)
						(if (== gDay 10)
							(Say 1450 13) ; "Even the kitchen is empty, but I've no time to waste here."
						else
							(Say 1450 12) ; "The kitchen is filled with Monks. I believe I'll avoid this room."
						)
						(= local0 34)
					)
					((& temp0 $0040)
						(Say 1450 14) ; "This barren and blood-spattered room has been set aside for the unpleasant practice of self-flagellation."
						(gEgo setMotion: 0)
						(= local0 64)
					)
					((& temp0 $0100)
						(Say 1450 15) ; "The exit is blocked."
						(= local0 256)
					)
				)
			)
		)
	)
)

(instance arrived of Script
	(properties)

	(method (cue)
		(HandsOn)
		(gTheIconBar disable: 5)
		(self dispose:)
	)
)

(instance takeOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register
					(cond
						((& register $0800) 0)
						((& register $4000) 1)
						((& register $2000) 2)
						((& register $1000) 3)
						((& register $0400) 4)
					)
				)
				(if (< register 3)
					(gEgo
						setMotion:
							MoveTo
							[local16 register]
							[local21 register]
							self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(gCurRoom newRoom: [local1 register])
			)
		)
	)
)

(instance bedRm of Feature
	(properties
		nsTop 125
		nsLeft 210
		nsBottom 150
		nsRight 244
		approachX 218
		approachY 146
	)

	(method (handleEvent event)
		(localproc_0 8)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (!= theVerb 2) ; Look
			(super doVerb: theVerb &rest)
		)
	)
)

(instance ref of Feature
	(properties
		nsTop 124
		nsLeft 71
		nsBottom 149
		nsRight 122
		approachX 125
		approachY 147
	)

	(method (handleEvent event)
		(localproc_0 2)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (!= theVerb 2) ; Look
			(super doVerb: theVerb &rest)
		)
	)
)

(instance chap of Feature
	(properties
		nsTop 32
		nsLeft 127
		nsBottom 121
		nsRight 185
		approachX 157
		approachY 93
	)

	(method (handleEvent event)
		(localproc_0 4)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (!= theVerb 2) ; Look
			(super doVerb: theVerb &rest)
		)
	)
)

(instance front of Feature
	(properties
		nsTop 141
		nsLeft 137
		nsBottom 155
		nsRight 175
		approachX 155
		approachY 147
		lookStr {'Tis the entrance to the Abbey.}
	)
)

(instance wash of Feature
	(properties
		nsTop 125
		nsLeft 126
		nsBottom 139
		nsRight 145
		approachX 140
		approachY 139
	)

	(method (handleEvent event)
		(localproc_0 16)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (!= theVerb 2) ; Look
			(super doVerb: theVerb &rest)
		)
	)
)

(instance kitchen of Feature
	(properties
		nsTop 105
		nsLeft 92
		nsBottom 121
		nsRight 122
		approachX 115
		approachY 124
	)

	(method (handleEvent event)
		(localproc_0 32)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (!= theVerb 2) ; Look
			(super doVerb: theVerb &rest)
		)
	)
)

(instance flag of Feature
	(properties
		nsTop 125
		nsLeft 184
		nsBottom 132
		nsRight 197
		approachX 199
		approachY 129
	)

	(method (handleEvent event)
		(localproc_0 64)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (!= theVerb 2) ; Look
			(super doVerb: theVerb &rest)
		)
	)
)

(instance cells of Feature
	(properties
		onMeCheck 128
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp1
			(cond
				((< (= temp0 (event x:)) 108) 0)
				((< temp0 156) 1)
				((< temp0 203) 2)
				(1 3)
			)
		)
		(= local31 (/ (- (event y:) [local32 temp1]) 9))
		(= approachX [local40 temp1])
		(= approachY (+ [local32 temp1] (* local31 9) 4))
		(+= local31 [local36 temp1])
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(switch local31
				(local44
					(Say 1450 17 1) ; "Oh, pardon me, Brothers! I didn't mean to interrupt such a tender scene of..ahem...brotherly love."
				)
				(local45
					(Say 1450 18 1) ; "Larry? Patty? What are YOU doing here?! No, this ISN'T the Nottingham Swinging Singles Health Spa."
				)
				(local46
					(Say 1450 19 1) ; "Ah, in this cell a monk is counting the number of angels dancing upon the head of a pin."
				)
				(else
					(Say 1450 20 1 82 450 0 0) ; "These Monks don't lead such a hard life with quarters like these. But they've nothing I want."
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance outside of Feature
	(properties
		onMeCheck 512
		lookStr 16 ; "I cannot see through stone walls."
	)
)

(instance changeMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(gRgnMusic number: 455 loop: -1 play:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

