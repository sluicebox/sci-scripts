;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 518)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	regUnicorn 0
)

(synonyms
	(kiss kiss embrace)
	(unicorn horse)
)

(local
	local0
	local1
)

(instance uniTheme of Sound
	(properties
		number 32
		priority 15
	)
)

(instance regUnicorn of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (== 0 gUnicornRoom)
			(switch (Random 1 3)
				(1
					(= gUnicornRoom 20)
				)
				(2
					(= gUnicornRoom 26)
				)
				(3
					(= gUnicornRoom 27)
				)
			)
		)
		(if (== gCurRoomNum gUnicornRoom)
			(Load rsVIEW 388)
			(if (gEgo has: 21) ; Golden_Bridle
				(Load rsVIEW 389)
				(Load rsVIEW 381)
			)
			(if (or (== gUnicornState 0) (== gUnicornState 999))
				(Load rsVIEW 382)
				(Load rsVIEW 383)
				(Load rsVIEW 380)
			)
			(if (gEgo has: 14) ; Cupid_s_Bow
				(Load rsVIEW 31)
				(Load rsVIEW 681)
			)
			(= gUnicornActor (Act new:))
			(gUnicornActor
				view: 388
				xStep: 4
				yStep: 1
				setCycle: Fwd
				cycleSpeed: 2
				setAvoider: Avoid 1
				init:
			)
			(switch gCurRoomNum
				(20
					(gUnicornActor x: 145 y: 110)
				)
				(26
					(gUnicornActor loop: 0 posn: 226 97)
				)
				(27
					(gUnicornActor
						x: 177
						y: 139
						loop: (if (< (gEgo x:) (gUnicornActor x:)) 0 else 1)
					)
				)
			)
			(if (< (gEgo x:) (gUnicornActor x:))
				(gUnicornActor loop: 0)
			else
				(gUnicornActor loop: 1)
			)
			(gUnicornActor setScript: uniActions)
		)
	)

	(method (dispose)
		(gTimers eachElementDo: #dispose)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if
			(and
				(== (event type:) evSAID)
				(!= (uniActions state:) 3)
				(gCast contains: gUnicornActor)
				(!= (gUnicornActor script:) 0)
			)
			(cond
				((and (== gUnicornState 999) (Said '/unicorn'))
					(Print 518 0) ; "The unicorn doesn't trust you now."
				)
				((Said 'launch/arrow,unicorn,arrow')
					(if (and (gEgo has: 14) (< ((Inv at: 14) loop:) 2)) ; Cupid_s_Bow, Cupid_s_Bow
						(if (!= gUnicornState 0)
							(Print 518 1) ; "There is no more need for that."
							(return)
						)
						(cond
							((!= (gEgo view:) 2)
								(Print 518 2) ; "Not while you're in the water."
							)
							((gUnicornActor inRect: 0 0 319 189)
								(LookAt gEgo gUnicornActor)
								(uniActions changeState: 10)
								(if (not global191)
									(= global191 1)
									(gGame changeScore: 4)
								)
								((Inv at: 14) loop: (+ ((Inv at: 14) loop:) 1)) ; Cupid_s_Bow, Cupid_s_Bow
							)
							(else
								(Print 518 3) ; "At what?"
							)
						)
					else
						(Print 518 4) ; "How are you going to do that?"
					)
				)
				((or (Said 'talk[/!*]') (Said 'talk/unicorn'))
					(if (gCast contains: gUnicornActor)
						(switch gUnicornState
							(0
								(Print 518 5) ; "You call to the wild unicorn, but it trots away at your arrival."
							)
							(1
								(Print 518 6) ; "You speak gently to the splendid unicorn. It whinnies softly in response."
							)
							(2
								(Print 518 7) ; "You talk lovingly to the beautiful dapple-grey unicorn. At your words, the unicorn bobs its head and paws the ground."
							)
						)
					else
						(Print 518 8) ; "To whom?"
					)
				)
				((Said 'look/horn')
					(if (gCast contains: gUnicornActor)
						(Print 518 9) ; "The unicorn's horn has a golden shine."
					else
						(event claimed: 0)
					)
				)
				((or (Said 'bit/unicorn') (Said 'place/bit'))
					(switch gUnicornState
						(0
							(Print 518 10) ; "You have to catch the unicorn first."
						)
						(1
							(if (gEgo has: 21) ; Golden_Bridle
								(if
									(or
										(and
											(== (gUnicornActor loop:) 0)
											(gEgo
												inRect:
													(+ (gUnicornActor x:) 20)
													(- (gUnicornActor y:) 5)
													(+ (gUnicornActor x:) 40)
													(+ (gUnicornActor y:) 5)
											)
										)
										(gEgo
											inRect:
												(- (gUnicornActor x:) 40)
												(- (gUnicornActor y:) 5)
												(- (gUnicornActor x:) 20)
												(+ (gUnicornActor y:) 5)
										)
									)
									(Print 518 11) ; "As the beautiful unicorn offers no resistance, you gently place the golden bit into its mouth, and fit the bridle and reins over its majestic head. The unicorn looks at you with curiosity."
									(gGame changeScore: 3)
									((Inv at: 21) moveTo: 205) ; Golden_Bridle
									(uniActions changeState: 20)
								else
									(Print 800 1) ; "You're not close enough."
								)
							else
								(Print 518 12) ; "You don't have the bridle."
							)
						)
						(2
							(Print 518 13) ; "The unicorn is already bridled."
						)
					)
				)
				((or (Said 'kiss[/!*]') (Said 'kiss/unicorn'))
					(if (gCast contains: gUnicornActor)
						(cond
							((== gUnicornState 0)
								(Print 518 14) ; "The unicorn runs away from you!"
							)
							(
								(or
									(and
										(== (gUnicornActor loop:) 0)
										(gEgo
											inRect:
												(+ (gUnicornActor x:) 20)
												(- (gUnicornActor y:) 5)
												(+ (gUnicornActor x:) 40)
												(+ (gUnicornActor y:) 5)
										)
									)
									(gEgo
										inRect:
											(- (gUnicornActor x:) 40)
											(- (gUnicornActor y:) 5)
											(- (gUnicornActor x:) 20)
											(+ (gUnicornActor y:) 5)
									)
								)
								(Print 518 15) ; "You plant a big kiss on the velvety nose of the beautiful unicorn."
							)
							(else
								(Print 800 1) ; "You're not close enough."
							)
						)
					else
						(event claimed: 0)
					)
				)
				((Said '/unicorn>')
					(if (gCast contains: gUnicornActor)
						(cond
							((Said 'look')
								(switch gUnicornState
									(0
										(Print 518 16) ; "You see a beautiful, wild unicorn in the meadow. Its coat is dapple-grey, and its wonderful horn shines like gold. The unicorn shies at your approach and trots away."
									)
									(1
										(Print 518 17) ; "The magnificent unicorn seems unafraid of you now. It nickers softly as you approach."
									)
									(2
										(Print 518 18) ; "The beautiful, dapple-grey unicorn is bridled up and ready to go. It nuzzles you gently as you near it."
									)
								)
							)
							(
								(or
									(Said 'mount')
									(Said 'get<on')
									(Said 'climb<on')
								)
								(switch gUnicornState
									(0
										(Print 518 19) ; "The unicorn just runs away from you!"
									)
									(1
										(Print 518 20) ; "It would not do you any good, as you could mount the unicorn but could not guide it."
									)
									(2
										(if
											(<
												(gEgo distanceTo: gUnicornActor)
												10
											)
											(if (> (gEgo y:) (gUnicornActor y:))
												(gEgo
													view: 389
													setAvoider: (Avoid new:)
													ignoreActors:
													setMotion: 0
													posn:
														(gUnicornActor x:)
														(gUnicornActor y:)
													cel: 0 71
												)
												(if (== (gUnicornActor loop:) 0)
													(gEgo loop: 0)
												else
													(gEgo loop: 1)
												)
												(= gUnicornState 3)
												(= gUnicornRoom 333)
												(= gNewRoomNum 333)
											else
												(Print 518 21) ; "Try the other side."
											)
										else
											(Print 800 1) ; "You're not close enough."
										)
									)
								)
							)
							((Said 'get,capture')
								(switch gUnicornState
									(0
										(Print 518 19) ; "The unicorn just runs away from you!"
									)
									(1
										(Print 518 22) ; "The unicorn is now unafraid of you, but how can you GET a unicorn?"
									)
									(2
										(Print 518 23) ; "Why don't you just ride the unicorn?"
									)
								)
							)
							((Said 'pat')
								(cond
									((== gUnicornState 0)
										(Print 518 19) ; "The unicorn just runs away from you!"
									)
									(
										(or
											(and
												(== (gUnicornActor loop:) 0)
												(gEgo
													inRect:
														(+ (gUnicornActor x:) 20)
														(- (gUnicornActor y:) 5)
														(+ (gUnicornActor x:) 40)
														(+ (gUnicornActor y:) 5)
												)
											)
											(gEgo
												inRect:
													(- (gUnicornActor x:) 40)
													(- (gUnicornActor y:) 5)
													(- (gUnicornActor x:) 20)
													(+ (gUnicornActor y:) 5)
											)
										)
										(Print 518 24) ; "You gently stroke the velvety, soft nose of the unicorn. It seems as if you have made a friend, Rosella!"
									)
									(else
										(Print 800 1) ; "You're not close enough."
									)
								)
							)
							((Said 'feed')
								(Print 518 25) ; "You are carrying nothing that the unicorn would want to eat."
							)
							((Said 'guide')
								(switch gUnicornState
									(0
										(Print 518 14) ; "The unicorn runs away from you!"
									)
									(1
										(Print 518 26) ; "How can you lead the unicorn with no bridle?"
									)
									(2
										(Print 518 23) ; "Why don't you just ride the unicorn?"
									)
								)
							)
						)
					else
						(Print 518 27) ; "You don't see one here."
					)
				)
				((Said 'give>')
					(if (= temp0 (gInventory saidMe:))
						(if (gEgo has: (gInventory indexOf: temp0))
							(Print 518 28) ; "You're not carrying anything the unicorn would want."
						else
							(Print 800 2) ; "You don't have it."
						)
					else
						(Print 518 29) ; "You can't give that."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance uniActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(uniTheme init: play:)
				(= seconds 4)
			)
			(1
				(switch gUnicornState
					(0
						(gUnicornActor
							view: 382
							cel: 0
							cycleSpeed: 1
							setCycle: End self
						)
					)
					(1
						(self changeState: 13)
					)
					(2
						(gUnicornActor view: 381 cycleSpeed: 1 setCycle: Fwd)
					)
					(999
						(gUnicornActor
							view: 382
							cel: 0
							cycleSpeed: 1
							setCycle: End self
						)
					)
				)
			)
			(2
				(switch gCurRoomNum
					(20
						(gUnicornActor view: 383 cycleSpeed: 0 setCycle: Walk)
						(if (< (gEgo x:) (gUnicornActor x:))
							(gUnicornActor setMotion: MoveTo 350 95 self)
						else
							(gUnicornActor setMotion: MoveTo -50 91 self)
						)
					)
					(26
						(gUnicornActor view: 383 cycleSpeed: 0 setCycle: Walk)
						(gUnicornActor setMotion: MoveTo 350 94 self)
					)
					(27
						(gUnicornActor view: 383 cycleSpeed: 0 setCycle: Walk)
						(if (< (gEgo x:) (gUnicornActor x:))
							(gUnicornActor setMotion: MoveTo 350 139 self)
						else
							(gUnicornActor setMotion: MoveTo -50 139 self)
						)
					)
				)
			)
			(3
				(uniTheme dispose:)
				(gUnicornActor dispose:)
				(switch gCurRoomNum
					(20
						(= gUnicornRoom 27)
					)
					(26
						(= gUnicornRoom 27)
					)
					(27
						(if (< (gUnicornActor x:) 0)
							(= gUnicornRoom 26)
						else
							(= gUnicornRoom 20)
						)
					)
				)
			)
			(10
				(HandsOff)
				(LookAt gEgo gUnicornActor)
				(gEgo view: 31 cel: 0 setCycle: End self)
			)
			(11
				(gEgo setCycle: Beg)
				(= gUnicornState 1)
				(= local0 (Prop new:))
				(gUnicornActor setMotion: 0 setCycle: 0)
				(local0
					view: 681
					cel: 0
					loop: 0
					setPri: 15
					posn: (gUnicornActor x:) (- (gUnicornActor y:) 15)
					setCycle: End self
					init:
				)
			)
			(12
				(local0 dispose:)
				(Print 518 30 #at -1 10) ; "You aim one of Cupid's golden arrows toward the beautiful unicorn. You let go of the bow string. ZING! Bull's-eye!"
				(gUnicornActor view: 383 cycleSpeed: 0 setCycle: Walk)
				(gEgo view: 2 setCycle: Walk)
				(HandsOn)
				(Print 518 31 #at -1 10) ; "The magnificent unicorn is no longer afraid of you. It's now your friend."
				(switch gCurRoomNum
					(20
						(gUnicornActor setMotion: MoveTo 160 110 self)
					)
					(21
						(gUnicornActor setMotion: MoveTo 142 91 self)
					)
					(26
						(gUnicornActor setMotion: MoveTo 226 99 self)
					)
					(27
						(gUnicornActor setMotion: MoveTo 177 139 self)
					)
				)
			)
			(13
				(switch (++ local1)
					(1
						(gUnicornActor view: 380 cycleSpeed: 2 setCycle: Fwd)
						((ScriptID 0 4) setReal: self 3) ; timer1
					)
					(2
						(gUnicornActor view: 388 cycleSpeed: 2 setCycle: Fwd)
						((ScriptID 0 4) setReal: self 5) ; timer1
					)
					(3
						(gUnicornActor view: 388 cel: 0 setCycle: 0)
						((ScriptID 0 4) setReal: self 7) ; timer1
					)
				)
			)
			(14
				(if (== local1 3)
					(= local1 0)
				)
				(self changeState: 13)
			)
			(20
				(gUnicornActor view: 381 setCycle: Fwd)
				((Inv at: 21) moveTo: 205) ; Golden_Bridle
				(= gUnicornState 2)
			)
		)
	)
)

