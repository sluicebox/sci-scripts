;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 702)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm702 0
)

(local
	[local0 2]
	local2
	local3
	[local4 20]
	[local24 20] = [93 117 88 96 101 110 125 155 139 157 165 184 161 138 143 142 138 101 94 129]
	[local44 20] = [157 164 181 170 148 189 178 139 156 161 173 189 187 183 189 171 152 183 166 158]
	[local64 20] = [1 1 1 1 1 1 1 0 0 0 0 0 0 0 2 2 2 3 3 3]
	local84
	[local85 6] = [1702 6 1 1 2 0]
	[local91 5] = [1702 9 1 2 0]
)

(procedure (localproc_0)
	(for ((= local84 0)) (< local84 20) ((++ local84))
		(= [local4 local84] (clIvy new:))
		([local4 local84]
			x: [local24 local84]
			y: [local44 local84]
			setLoop: [local64 local84]
			setCel: 221
			setPri: 10
			signal: 16401
			init:
		)
	)
)

(instance rm702 of Rm
	(properties
		picture 702
		style 14
	)

	(method (init)
		(gRgnMusic stop:)
		(gSFX stop:)
		(gEgo setCycle: Walk cel: 0 y: 164 signal: 16384 init:)
		(super init:)
		(gTheIconBar disable: 0 4)
		((gTheIconBar at: 2) message: 1)
		(= local3 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(AddToFeatures theWindow theIvy topTower)
		(localproc_0)
		(= local2 1)
		(gCurRoom setScript: monksTalk)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 163 189 134 107 102 107 100 172 124 189
					yourself:
				)
		)
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 2) ; Look
			(Say 1702 13 1) ; "A perpetual gloom hangs over this fens."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (reflectPosn)
		(return 0)
	)

	(method (doit)
		(cond
			((gEgo script:) 0)
			((> (gEgo y:) 185)
				(gEgo setScript: S)
			)
			((<= (gEgo y:) 162)
				(SetScore 25)
				(gCurRoom newRoom: 705)
			)
			((< (gEgo x:) 90)
				(gEgo setScript: climbGoThere)
			)
			((> (gEgo x:) 170)
				(gEgo setScript: climbGoThere)
			)
			(else
				(super doit: &rest)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(= local3 gUseSortedFeatures)
		(gTheIconBar enable: 0)
		((gTheIconBar at: 2) message: 3)
		(super dispose:)
	)
)

(instance unusualDoVerb of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Inventory
			(Say 1702 12 1) ; "If I let go of these vines, I'm a dead man."
		)
	)
)

(instance topTower of Feature
	(properties
		x 89
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1702 1 1) ; "I've nearly reached the window."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 12 41 47 18 89 8 136 10 177 23 197 34 208 189 0 189 0 91 15 76
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance theWindow of Feature
	(properties
		x 154
		y 102
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1702 2 1) ; "I hear nothing from within, but I dare not so much as whisper from here."
			)
			(3 ; Do
				(gEgo setScript: climbInWindow)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 102 154 100 111 116 102 127 103 136 111 138 153
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance theIvy of Feature
	(properties
		x 148
		y 153
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1702 11 1) ; "The ivy remains strong even here by the power of the Green Man's blessing."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 134 153 148 165 142 188 131 188 129 179 113 170 105 155
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance rightSide of Feature ; UNUSED
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 140 135 156 117 169 124 160 137 199 189 186 189 153 141 156 131
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance leftSide of Feature ; UNUSED
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 96 189 70 171 75 138 99 122 100 135 86 143 82 166 112 188
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance clIvy of Prop
	(properties
		view 700
		priority 2
		signal 16401
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1702 11 1) ; "The ivy remains strong even here by the power of the Green Man's blessing."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance monk1 of Actor
	(properties
		view 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1702 4 1) ; "I hear the Monks treading quietly upon the the battlements. Blessed Lady, protect me from their sight!"
			)
			(3 ; Do
				(Say 1702 5 1) ; "He's beyond my reach."
			)
			(5 ; Talk
				(gEgo setScript: foooolishhhh)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance monk2 of Actor
	(properties
		view 16
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1702 4 1) ; "I hear the Monks treading quietly upon the the battlements. Blessed Lady, protect me from their sight!"
			)
			(3 ; Do
				(Say 1702 5 1) ; "He's beyond my reach."
			)
			(5 ; Talk
				(gEgo setScript: foooolishhhh)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance climbGoThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1702 0) ; "I cannot cling to bare stone."
				(cond
					((<= (gEgo x:) 95)
						(gEgo
							setMotion:
								PolyPath
								(+ (gEgo x:) 10)
								(gEgo y:)
								self
						)
					)
					((>= (gEgo x:) 165)
						(gEgo
							setMotion:
								PolyPath
								(- (gEgo x:) 10)
								(gEgo y:)
								self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(if (not (IsFlag 40))
					(gCurRoom setScript: monksTalk)
				else
					(= ticks 12)
				)
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 0 4)
				(self dispose:)
			)
		)
	)
)

(instance monksTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(monk1 posn: 149 39 illegalBits: 0 init:)
				(monk2 posn: 160 30 init: illegalBits: 0)
				(gEgo
					signal: 16384
					actions: unusualDoVerb
					setMotion: MoveTo 137 183 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 140 183)
				(if (not (IsFlag 40))
					(SetFlag 40)
					(Converse @local91 11 11 self) ; "Did you hear something, Brother?"
				else
					(= ticks 12)
				)
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 0 4)
				(= ticks 66)
			)
			(3
				(monk1 setMotion: MoveTo 40 39 self)
			)
			(4
				(monk2 setMotion: MoveTo 60 30 self)
			)
			(5
				(monk1 setMotion: MoveTo 149 39 self)
			)
			(6
				(monk2 setMotion: MoveTo 169 30 self)
			)
			(7
				(self changeState: 2)
			)
		)
	)
)

(instance climbInWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gTheIconBar at: 2) message: 3)
				(gEgo setMotion: MoveTo 155 162 self)
			)
			(1
				(gEgo setLoop: 2 setCel: 0 setPri: 12 signal: 16)
				(= ticks 12)
			)
			(2
				(SetScore 25)
				(self dispose:)
			)
		)
	)
)

(instance S of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 25) self
				)
			)
			(1
				(gCurRoom newRoom: 701)
			)
		)
	)
)

(instance foooolishhhh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse @local85 3 11 self) ; "Excuse me, could you lend me a hand?"
			)
			(1
				(gCurRoom newRoom: 710)
			)
		)
	)
)

