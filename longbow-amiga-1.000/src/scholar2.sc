;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 313)
(include sci.sh)
(use Main)
(use n013)
(use Fair)
(use RTEyeCycle)
(use PPath)
(use PAvoider)
(use PChase)
(use PolyPath)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	scholar2 0
)

(local
	local0 = 1
	local1
	local2
	[local3 9] = [323 0 2 4 26 35 21 24 23]
	[local12 3] = [-1 {Giles} 19]
	[local15 3] = [-1 {Roger} 19]
	[local18 11] = [1313 0 1 2 1 2 0 1313 4 1 0]
	[local29 4] = [1313 5 2 0]
	[local33 4] = [1313 6 1 0]
	[local37 4] = [1313 7 1 0]
	[local41 5] = [1313 8 1 2 0]
	[local46 6] = [1313 10 2 1 2 0]
	[local52 4] = [1313 13 1 0]
	[local56 4] = [1313 14 1 0]
	[local60 6] = [1313 15 1 2 1 0]
	[local66 4] = [1313 18 1 0]
	[local70 4] = [1313 19 1 0]
	local74
	local75
	local76
	local77
	local78
	local79
	local80
	[local81 5]
	local86
	local87
	local88
	local89
	local90
	local91
	local92
	local93
	[local94 16] = [53 252 61 264 102 252 73 246 75 219 68 223 50 212 94 268]
	[local110 16] = [75 79 176 173 66 63 179 167 61 72 167 174 77 65 169 150]
	[local126 16] = [53 250 61 264 108 250 73 244 79 220 68 223 50 212 94 268]
	[local142 16] = [57 51 162 157 46 42 158 143 44 52 146 156 64 51 151 137]
	[local158 16] = [245 67 294 35 240 34 287 38 255 53 293 38 257 29 293 38]
	[local174 16] = [49 42 157 158 40 75 142 152 48 40 149 147 52 75 75 159]
	[local190 16] = [286 34 280 68 272 38 284 60 279 42 281 24 293 39 283 45]
	[local206 16] = [58 61 178 129 47 58 154 171 45 49 166 170 75 47 113 178]
)

(instance roger of Actor
	(properties
		view 753
	)
)

(instance giles of Actor
	(properties
		view 753
	)
)

(instance scholar2 of Actor
	(properties
		cycleSpeed 10
		moveSpeed 10
	)

	(method (init param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2)
		(= local2 param2)
		(= local1 param1)
		(Load rsSCRIPT 927)
		(Load rsSCRIPT 930)
		(if param5
			(if (> local1 0)
				(= param5 (- 801 param5))
			)
			(= temp0 (+ (/ (* param5 (- param4 1)) 801) 1))
		else
			(= temp0 (if (> local1 0) 0 else param4))
		)
		(if (> local1 0)
			(= temp1 (+ temp0 1))
			(= temp2 param4)
		else
			(= temp1 (- temp0 1))
			(= temp2 0)
		)
		(super init:)
		(self
			view: 322
			setCycle: SyncWalk
			posn: (WordAt param3 (*= temp0 2)) (WordAt param3 (+ temp0 1))
			setMotion: PPath param3 temp1 temp2 leave
		)
		(= local75 (scholar2 mover:))
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(= temp2
			(cond
				((scholar2 inRect: 0 0 160 96) 0)
				((scholar2 inRect: 160 0 319 96) 1)
				((scholar2 inRect: 0 96 160 189) 2)
				((scholar2 inRect: 160 96 319 189) 3)
			)
		)
		(= temp1 0)
		(for ((= temp0 280)) (<= temp0 gCurRoomNum) ((+= temp0 10))
			(= local86 [local158 (+ temp2 (* temp1 4))])
			(= local87 [local174 (+ temp2 (* temp1 4))])
			(= local88 [local190 (+ temp2 (* temp1 4))])
			(= local89 [local206 (+ temp2 (* temp1 4))])
			(= local90 [local94 (+ temp2 (* temp1 4))])
			(= local91 [local110 (+ temp2 (* temp1 4))])
			(= local92 [local126 (+ temp2 (* temp1 4))])
			(= local93 [local142 (+ temp2 (* temp1 4))])
			(++ temp1)
		)
		(switch theVerb
			(5 ; Talk
				(cond
					((gCurRoom script:)
						(super doVerb: theVerb &rest)
					)
					(
						(or
							(> (gEgo distanceTo: scholar2) 50)
							(> (scholar2 x:) 312)
							(< (scholar2 x:) 5)
						)
						(Say 1311 0) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
					)
					(else
						(gCurRoom
							setScript:
								(switch global196
									(0 converse)
									(1 converse)
									(2 youBlewIt)
								)
						)
					)
				)
			)
			(2 ; Look
				(if local0
					(Say 1311 2) ; "Ah, a Scholar!"
					(= local0 0)
				else
					(Say 1311 3) ; "The Scholar looks the same as he did before."
				)
			)
			(4 ; Inventory
				(if
					(or
						(> (gEgo distanceTo: scholar2) 50)
						(> (scholar2 x:) 312)
						(< (scholar2 x:) 5)
					)
					(Say 1311 1) ; "I must get closer to do that."
				else
					(switch invItem
						(17 ; handScroll
							(gCurRoom setScript: rottingRichard)
						)
						(0 ; bucks
							(gCurRoom setScript: offerBucks)
						)
						(else
							(super doVerb: theVerb &rest)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (delete)
		(super delete:)
		(DisposeScript 313)
	)
)

(instance showIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(scholar2 setCycle: End self)
			)
			(1
				(if (not (gCast contains: roger))
					(self setScript: hereTheyCome self)
				else
					(= cycles 2)
				)
			)
			(2
				(= local77 (+ 12 (CelHigh 71 12 0)))
				(= local78 (+ 245 (CelWide 71 12 0)))
				(= local79 (Graph grSAVE_BOX 12 245 local77 local78 3))
				(DrawCel 71 12 0 245 12 15 1)
				(DrawCel 71 [local81 local80] 0 256 14 15 1)
				(= cycles 2)
			)
			(3
				(if (!= local80 0)
					(Converse 1 @local33 @local3 3 self 1) ; "Is this it?"
				else
					(= cycles 2)
				)
			)
			(4
				(= local74 (AyeOrNay))
				(= cycles 2)
			)
			(5
				(Graph grRESTORE_BOX local79)
				(Graph grUPDATE_BOX 12 245 local77 local78 1)
				(= cycles 2)
			)
			(6
				(scholar2 setCycle: Beg self)
			)
			(7
				(++ local80)
				(self dispose:)
			)
		)
	)
)

(instance youBlewIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(scholar2 loop: (> (scholar2 x:) (gEgo x:)) mover: 0)
				(Converse 1 @local56 @local3 3 self 1) ; "I believe you're the man we want after all! Seize him!"
			)
			(1
				(self setScript: hereTheyCome self)
			)
			(2
				(gCurRoom setScript: sDieNow)
			)
		)
	)
)

(instance menLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (scholar2 x:) 160)
					(= register 340)
				else
					(= register -20)
				)
				(roger
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath register (gEgo y:) self
				)
				(giles
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath register (gEgo y:) self
				)
				(= ticks 1000)
			)
			(1
				(if (and (gCast contains: giles) (== (giles x:) register))
					(giles dispose: delete:)
				)
				(if (and (gCast contains: roger) (== (roger x:) register))
					(roger dispose: delete:)
				)
			)
			(2
				(= ticks 0)
				(if (and (gCast contains: giles) (== (giles x:) register))
					(giles dispose: delete:)
				)
				(if (and (gCast contains: roger) (== (roger x:) register))
					(roger dispose: delete:)
				)
				(= cycles 2)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance offerBucks of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (> (gEgo x:) (scholar2 x:))
					(= temp0 1)
				else
					(= temp0 0)
				)
				(scholar2 loop: (> (scholar2 x:) (gEgo x:)) mover: 0)
				(Face gEgo scholar2)
				(= ticks 10)
			)
			(1
				(Converse 1 @local70 @local3 3 self 1) ; "I can sell you nothing unless I know what you want."
			)
			(2
				(scholar2
					setCycle: Walk
					mover: local75
					loop: (< (local75 x:) (scholar2 x:))
				)
				(= cycles 2)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance leave of CueObj
	(properties)

	(method (cue &tmp temp0)
		(proc311_1 local2 local1 scholar2)
	)
)

(instance rottingRichard of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (> (gEgo x:) (scholar2 x:))
					(= temp0 1)
				else
					(= temp0 0)
				)
				(scholar2 loop: (> (scholar2 x:) (gEgo x:)) mover: 0)
				(Face gEgo scholar2 self)
				(Face scholar2 gEgo self)
			)
			(1)
			(2
				(= cycles 2)
			)
			(3
				(Converse 1 @local66 @local3 3 self 1) ; "What a fool you are. Now Richard shall rot in Austria. Kill him!"
			)
			(4
				(giles
					x: (if (< (scholar2 x:) 160) 350 else -30)
					y: (gEgo y:)
					init:
					setCycle: Walk
					setAvoider: PAvoider
					setMotion: PolyPath local88 local89 self
				)
			)
			(5
				(Face giles gEgo)
				(roger
					x: (if (< (scholar2 x:) 160) 330 else -10)
					y: (gEgo y:)
					init:
					setCycle: Walk
					setAvoider: PAvoider
					setMotion: PolyPath local86 local87 self
				)
			)
			(6
				(Face roger gEgo)
				(= cycles 2)
			)
			(7
				(gEgo setAvoider: 0 setMotion: 0)
				(giles setAvoider: 0 setMotion: 0 dispose: delete:)
				(roger setAvoider: 0 setMotion: 0 dispose: delete:)
				(scholar2 setAvoider: 0 mover: local75)
				(= gDeathNum 36)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 [temp2 70])
		(switch (= state newState)
			(0
				(HandsOff)
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					(= register (Random 1 11))
					(if (<= register global123)
						(-- register)
					)
					(= [local81 temp0] register)
					(for ((= temp1 0)) (< temp1 temp0) ((++ temp1))
						(if (== [local81 temp1] [local81 temp0])
							(-- temp0)
						)
					)
				)
				(= local80 0)
				(scholar2 loop: (> (scholar2 x:) (gEgo x:)) mover: 0)
				(Face gEgo scholar2 self)
			)
			(1
				(scholar2 loop: (+ (scholar2 loop:) 2) cel: 0)
				(= cycles 2)
			)
			(2
				(if (< global196 1)
					(Converse @local18 999 @local3 self 0) ; "Top of the day, literatus."
				else
					(++ state)
					(= cycles 1)
				)
			)
			(3
				(GetFarText 1313 4 @temp2) ; "Forsooth, I am, as you've rightly guessed. Have you a book with the coat-of-arms of"
				(GetFarText 1317 global123 (+ @temp2 (StrLen @temp2)))
				((ScriptID 851 2) show: say: @temp2 0 0 0 self) ; talker1
			)
			(4
				(HandsOff)
				(if (< global196 1)
					(Converse @local29 999 @local3 self 1) ; "I can indeed help you with that. Is this it?"
				else
					(Converse @local41 999 @local3 self 1) ; "Are you sure you don't have that coat-of-arms?"
				)
			)
			(5
				(self setScript: showIt self)
			)
			(6
				(= cycles 2)
			)
			(7
				(cond
					(local74
						(Converse 1 @local52 @local3 3 0 1) ; "It is? Ah, aye, of course it is."
						(++ global196)
						(++ state)
						(self setScript: menLeave self)
					)
					((<= local80 4)
						(= state 4)
						(= cycles 2)
					)
					(else
						(= cycles 2)
					)
				)
			)
			(8
				(if (< global196 1)
					(Converse 1 @local37 @local3 3 0 1) ; "You aren't doing so well, my friend."
					(= global196 1)
					(self setScript: menLeave self)
				else
					(Converse @local46 999 @local3 0 1) ; "There's something odd about you, Master 'Puck'."
					(gCurRoom setScript: sDieNow)
				)
			)
			(9
				(scholar2
					setCycle: Walk
					mover: local75
					loop: (< (local75 x:) (scholar2 x:))
				)
				(= cycles 2)
			)
			(10
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sDieNow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setAvoider: PAvoider
					ignoreActors: 1
					setMotion: PolyPath local90 local91 self
				)
				(giles
					setAvoider: 0
					ignoreActors: 1
					setMotion: PChase gEgo 80 self
				)
				(scholar2
					setCycle: Walk
					ignoreActors: 1
					setMotion: PolyPath local92 local93 self
				)
				(roger
					setAvoider: 0
					ignoreActors: 1
					setMotion: PChase gEgo 40 self
				)
			)
			(1)
			(2)
			(3)
			(4
				(Face gEgo scholar2)
				(Face scholar2 gEgo)
				(= ticks 10)
			)
			(5
				(Converse @local60 @local15 @local12 self 1) ; "Look, he's got a good eye under this patch!"
			)
			(6
				(gEgo setAvoider: 0 setMotion: 0)
				(giles setAvoider: 0 setMotion: 0 dispose: delete:)
				(roger setAvoider: 0 setMotion: 0 dispose: delete:)
				(scholar2 setAvoider: 0 mover: local75)
				(= gDeathNum 36)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance hereTheyCome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roger
					x: (if (< (scholar2 x:) 160) 330 else -10)
					y: (gEgo y:)
					init:
					ignoreActors: 0
					setCycle: Walk
					setAvoider: PAvoider
					setMotion: PolyPath local86 local87 self
				)
			)
			(1
				(roger
					loop: (if (< (gEgo x:) (roger x:)) 1 else 0)
					ignoreActors: 1
				)
				(= ticks 5)
			)
			(2
				(giles
					x: (if (< (scholar2 x:) 160) 350 else -10)
					y: (gEgo y:)
					init:
					ignoreActors: 0
					setCycle: Walk
					setAvoider: PAvoider
					setMotion: PolyPath local88 local89 self
				)
			)
			(3
				(giles loop: (if (< (gEgo x:) (roger x:)) 1 else 0))
				(= ticks 5)
			)
			(4
				(self dispose:)
			)
		)
	)
)

