;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 197)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	searchIt 0
)

(local
	local0
	local1
	local2
	[local3 80]
	local83
)

(procedure (localproc_0)
	(switch local2
		(0
			(HighPrint 197 0) ; "What a waste! No treasure!"
		)
		(1
			(HighPrint 197 1) ; "You find a single silver coin, carefully polish it, and place it in your pouch. What a way to make a living!"
			(gEgo get: 1 1) ; silver
		)
		(else
			(HighPrint (Format @local3 197 2 local2)) ; "You find %d silver coins, and carefully place them in your pouch."
			(gEgo get: 1 local2) ; silver
		)
	)
	(if (== global332 450)
		(HighPrint 197 3) ; "You thought that the Troll concealed some of its treasure in that thick beard, but you didn't find any there."
	)
	(if (and (== gCurRoomNum global273) (or global271 global272 [gInvDropped 7])) ; dagger
		(gEgo get: 7 (+ global271 global272 [gInvDropped 7])) ; dagger, dagger
		(HighPrint 197 4) ; "You retrieve your daggers."
	)
	(= [gInvDropped 7] (= global272 (= global271 (= global273 0)))) ; dagger
)

(instance searchIt of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 197)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local83 register)
				(local83 ignoreActors:)
				(= local0
					(switch global332
						(430 10)
						(440 12)
						(460 18)
						(445 23)
						(435 12)
						(465 0)
						(else 20)
					)
				)
				(= local1
					(switch global332
						(430 4)
						(440 -3)
						(460 4)
						(445 1)
						(435 4)
						(465 2)
						(else 20)
					)
				)
				(HandsOff)
				(if (> (gEgo y:) (local83 y:))
					(gEgo
						illegalBits: 0
						ignoreActors:
						setPri: (+ (local83 priority:) 1)
						setMotion:
							MoveTo
							(+ (local83 x:) local0)
							(+ (local83 y:) local1)
							self
					)
				else
					(gEgo
						illegalBits: 0
						ignoreActors:
						setPri: (- (local83 priority:) 1)
						setMotion:
							MoveTo
							(-
								(local83 x:)
								(cond
									((== global332 435) 19)
									((== global332 465) 36)
									(else 11)
								)
							)
							(- (local83 y:) 5)
							self
					)
				)
			)
			(1
				(gEgo
					view: 510
					setLoop: (if (> (gEgo y:) (local83 y:)) 1 else 0)
					setCycle: End self
				)
			)
			(2
				(HighPrint 197 5) ; "You search your opponent."
				(gEgo setCycle: Beg self)
			)
			(3
				(cond
					(
						(or
							(== global332 430)
							(== global332 460)
							(== global332 440)
							(== global332 435)
						)
						(= local2 0)
					)
					((== global332 445)
						(= local2 (Random 0 10))
					)
					((== global332 465)
						(= local2 (Random 5 25))
					)
					((== global332 450)
						(= local2 (Random 20 50))
					)
					((== global332 425)
						(= local2 50)
					)
				)
				(localproc_0)
				(gEgo
					view: 0
					setLoop: -1
					setCycle: Walk
					setMotion:
						MoveTo
						185
						(if (< (gEgo x:) (local83 x:)) 140 else 160)
						self
				)
			)
			(4
				(gEgo setLoop: 1)
				(local83 ignoreActors: 0)
				(NormalEgo)
				(gEgo illegalBits: (gCurRoom illBits:))
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

