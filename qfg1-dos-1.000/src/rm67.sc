;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 67)
(include sci.sh)
(use Main)
(use n101)
(use n102)
(use n105)
(use TargActor)
(use LoadMany)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm67 0
)

(local
	[local0 10] = [205 180 243 73 103 67 74 72 54 25]
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
)

(instance rm67 of Rm
	(properties
		picture 67
		style 8
		horizon 90
		north 57
		east 68
		west 66
	)

	(method (dispose)
		(SetFlag 57)
		(= global106 (gEgo y:))
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 700 240 510)
		(super init:)
		(self setLocales: 804)
		(SL enable:)
		(southBush setPri: 15 init: addToPic:)
		(if (and (IsFlag 176) (IsFlag 177) (not (IsFlag 207)))
			(= local12 1)
			(SetFlag 207)
			(Load rsVIEW 67)
			(Load rsVIEW 68)
			(fox init: setScript: foxCallForHelp)
			(Load rsVIEW 522)
			(Load rsVIEW 518)
			(HighPrint 67 0) ; "There seems to be a fox north of the road."
		)
		(if (not local12)
			(eyes1 setPri: 5 init: stopUpd: setScript: peekABooScript1)
			(eyes2 setPri: 5 init: stopUpd: setScript: peekABooScript2)
		)
		(if (IsFlag 176)
			(SetFlag 177)
		)
		(SetFlag 176)
		(NormalEgo)
		(gEgo init:)
		(switch gPrevRoomNum
			(57
				(gEgo posn: 140 92 setMotion: MoveTo 140 190)
			)
			(66
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(68
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
		)
	)

	(method (doit)
		(if
			(and
				(< (= local18 (gEgo distanceTo: fox)) 75)
				(not local16)
				(not (fox script:))
				(not (gEgo script:))
				local12
			)
			(= local16 1)
			(fox setScript: foxExplains)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look>')
						(cond
							((Said '<at,around[/!*,road]')
								(HighPrint 67 1) ; "The forest deepens north and south of you. To the east, the road twists it's way up the mountain. To the west, the road is hidden by trees."
							)
							((Said '/eye')
								(HighPrint 67 2) ; "For a moment there, you thought you saw something. You can't see anything now."
							)
							(
								(or
									(Said '/trap,hasp,chain')
									(and
										(Said '<down')
										(gEgo inRect: 55 111 120 120)
									)
								)
								(cond
									(local12
										(HighPrint 67 3) ; "It seems to be a simple spring trap and you can easily open it."
									)
									(local15
										(HighPrint 67 4) ; "The trap seems to be caught on something."
									)
									((not (gEgo inRect: 55 111 120 120))
										(event claimed: 0)
									)
									(else
										(HighPrint 67 5) ; "You can see no sign of a trap here."
									)
								)
							)
							((Said '/fox')
								(if local12
									(HighPrint 67 6) ; "The fox seems to have a foot caught in a trap."
								else
									(HighPrint 67 7) ; "The fox is gone."
								)
							)
						)
					)
					((Said 'get>')
						(if (Said '/trap,hasp,chain')
							(cond
								(local12
									(HighPrint 67 8) ; "You must free the fox first."
								)
								(local15
									(if (gEgo inRect: 55 111 120 120)
										(gEgo setScript: getTrap)
									else
										(HighPrint 67 9) ; "Walk over to the trap."
									)
								)
								(else
									(HighPrint 67 10) ; "You don't see the trap now. It seems to have vanished."
								)
							)
						)
					)
					((Said 'ask>')
						(if (Said '/help,trap')
							(if (not local16)
								(HighPrint 67 11) ; "My foot is caught in this cruel trap and I am in great pain. Surely you could take a minute and set me free."
								(= local16 1)
							else
								(HighPrint 67 12) ; "I am in such pain and agony I cannot think.  Help me, good adventurer, please."
							)
						else
							(HighPrint 67 12) ; "I am in such pain and agony I cannot think.  Help me, good adventurer, please."
							(event claimed: 1)
						)
					)
					((or (Said 'free,free/fox,animal') (Said 'open,get/trap'))
						(if local12
							(if
								(and
									(< (gEgo y:) 112)
									(< 60 (gEgo x:) 112)
								)
								(HighPrint 67 13) ; "Walk around to the other side of the fox, where the trap is."
							else
								(SolvePuzzle 686 10)
								(gEgo setScript: foxFreed)
							)
						else
							(HighPrint 67 7) ; "The fox is gone."
						)
					)
					((Said 'fight/fox,animal')
						(if local12
							(fox setScript: foxWillNotFight)
						else
							(HighPrint 67 14) ; "There's no one here to fight."
						)
					)
					((Said 'kill,attack,fight/fox,animal')
						(if local12
							(cond
								((not (gEgo has: 6)) ; blade
									(HighPrint 67 15) ; "You would need a sword."
								)
								((gEgo inRect: 55 111 120 120)
									(fox setScript: foxDies)
								)
								(else
									(NotClose)
								)
							)
						else
							(HighPrint 67 14) ; "There's no one here to fight."
						)
					)
					((Said 'cast>')
						(switch (= temp0 (SaidSpell event))
							(18
								(if (CastSpell temp0)
									(if local12
										(HighPrint 67 16) ; "There is an aura of magic around the fox."
									else
										(HighPrint 67 17) ; "There is no magic present."
									)
								)
							)
							(20
								(if local12
									(HighPrint 67 18) ; "The fox is in such pain that it's already dazzled."
								else
									(HighPrint 67 19) ; "There is no point to that."
								)
							)
							(23
								(if (CastSpell temp0)
									(if local12
										(if local17
											(dart init: setScript: flameDartFox)
										else
											(HighPrint 67 20) ; "You don't have to put me out of my misery, you just have to get me out of this trap."
											(= local17 1)
										)
									else
										(HighPrint 67 19) ; "There is no point to that."
									)
								)
							)
							(22
								(if local12
									(HighPrint 67 21) ; "You realize, of course, I really find it hard to relax with this thing on my leg."
								else
									(HighPrint 67 19) ; "There is no point to that."
								)
							)
							(17
								(if local12
									(if (TrySkill 17 25) ; openSpell
										(= local13 1)
										(SolvePuzzle 686 10)
									else
										(= local14 1)
									)
									(gEgo setScript: foxFreed)
								else
									(HighPrint 67 19) ; "There is no point to that."
								)
							)
							(else
								(event claimed: 0)
							)
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance foxCallForHelp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(HandsOff)
				(fox setCycle: End self)
			)
			(2
				(clr)
				(TimePrint 6 67 22) ; "Help me, Brave and Kind Hero."
				(fox loop: 1 cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(3
				(fox setCycle: End)
				(HandsOn)
				(= seconds 8)
			)
			(4
				(fox loop: 1 cel: 0 setCycle: Fwd)
				(clr)
				(TimePrint 6 67 23) ; "Please help me, Brave and Kind Hero."
				(= seconds 2)
			)
			(5
				(fox setCycle: End self)
			)
			(6
				(fox setScript: thrashAndWait)
			)
		)
	)
)

(instance foxWillNotFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clr)
				(TimePrint 7 67 24) ; "Please have mercy on a creature who is in great pain."
				(fox loop: 1 cel: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(1
				(fox setCycle: End)
				(= cycles 5)
			)
			(2
				(HighPrint 67 25) ; "The fox does not seem to want to fight."
			)
		)
	)
)

(instance foxExplains of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(clr)
				(TimePrint 9 67 11) ; "My foot is caught in this cruel trap and I am in great pain. Surely you could take a minute and set me free."
				(fox loop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(1
				(fox setCycle: End)
				(= cycles 5)
			)
			(2
				(HandsOn)
				(client setScript: thrashAndWait)
			)
		)
	)
)

(instance distantFoxDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local15 1)
				(= local12 0)
				(fox loop: 2 cel: 0 cycleSpeed: 2 setCycle: End)
				(= seconds 7)
			)
			(1
				(SolvePuzzle 604 -10)
				(= global272 0)
				(HandsOn)
				(HighPrint 67 26) ; "That was strange, no sooner did you kill the fox than it vanishes."
				(client dispose:)
			)
		)
	)
)

(instance foxDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local15 1)
				(= local12 0)
				(if (gEgo inRect: 41 109 111 138)
					(self cue:)
				else
					(gEgo
						ignoreActors:
						illegalBits: 0
						setMotion: MoveTo 120 130 self
					)
				)
			)
			(1
				(gEgo
					ignoreActors:
					setMotion: MoveTo (+ (fox x:) 20) (+ (fox y:) 2) self
				)
			)
			(2
				(gEgo view: 518 setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(NormalEgo)
				(fox loop: 2 cel: 0 cycleSpeed: 2 setCycle: End)
				(= seconds 7)
			)
			(6
				(SolvePuzzle 604 -10)
				(HandsOn)
				(= global272 0)
				(HighPrint 67 26) ; "That was strange, no sooner did you kill the fox than it vanishes."
				(client dispose:)
			)
		)
	)
)

(instance foxFreed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (or local13 local14)
					(CastOpen rm67 self)
				else
					(self cue:)
				)
			)
			(1
				(fox setScript: thrashAndWait)
				(gEgo ignoreActors: illegalBits: 0)
				(if (gEgo inRect: 41 109 111 138)
					(self cue:)
				else
					(gEgo setMotion: MoveTo 112 130 self)
				)
			)
			(2
				(gEgo setMotion: MoveTo (- (fox x:) 29) (+ (fox y:) 3) self)
			)
			(3
				(gEgo view: 510 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(cond
					(local14
						(HighPrint 67 27) ; "Hmmm. Perhaps it needed a stronger spell."
					)
					(local13
						(HighPrint 67 28) ; "Yep. It's open, all right."
					)
					(else
						(HighPrint 67 29) ; "You spring the trap."
					)
				)
				(self cue:)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(if local14
					(= local14 0)
					(NormalEgo)
					(HandsOn)
					(fox setScript: foxExplains)
				else
					(= local15 1)
					(= local12 0)
					(= cycles 8)
				)
			)
			(7
				(fox setScript: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(8
				(LowPrint 67 30) ; "In exchange for your kindness, I will give you some advice and a bit of information. First of all, it sometimes pays off to be polite, even to rude people."
				(self cue:)
			)
			(9
				(LowPrint 67 31) ; "As for the amusing tidbit - Baba Yaga put an enchantment on the Baron's Daughter some years back. To break the spell you need to talk to the Dryad. Au Revoir, Ta-ta, see you sometime."
				(self cue:)
			)
			(10
				(fox
					setLoop: 3
					setCel: 0
					cycleSpeed: 1
					setStep: 6 6
					moveSpeed: 1
					setCycle: CT 4 1 self
				)
			)
			(11
				(trap init: stopUpd:)
				(fox
					setMotion: MoveTo (+ (fox x:) 18) (+ (fox y:) 0)
					setCycle: End self
				)
			)
			(12
				(fox
					setLoop: 4
					setCel: 0
					cycleSpeed: 0
					setStep: 6 6
					moveSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo (+ (fox x:) 250) (+ (fox y:) 5)
				)
				(gEgo view: 68 loop: 0 cel: 0 setCycle: End)
				(= cycles 35)
			)
			(13
				(NormalEgo)
				(HandsOn)
				(fox dispose:)
			)
		)
	)
)

(instance flameDartFox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local15 1)
				(= local12 0)
				(fox setScript: 0)
				(gEgo
					view: 522
					setLoop: (if (< (gEgo x:) (fox x:)) 0 else 1)
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(gEgo setCycle: End)
				(dart
					setLoop: 2
					setStep: 18 12
					setPri: 12
					ignoreActors: 1
					posn: (gEgo x:) (gEgo y:)
					show:
					setCycle: Fwd
					startUpd:
				)
				(dart setMotion: MoveTo (+ (fox x:) 3) (fox y:) self)
			)
			(2
				(dart setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(fox loop: 2 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(4
				(HandsOn)
				(NormalEgo)
				(HighPrint 67 26) ; "That was strange, no sooner did you kill the fox than it vanishes."
				(= seconds 2)
			)
		)
	)
)

(instance getTrap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: illegalBits: 0)
				(if (gEgo inRect: 41 109 111 138)
					(self cue:)
				else
					(gEgo setMotion: MoveTo 112 130 self)
				)
			)
			(1
				(gEgo setMotion: MoveTo 58 113 self)
			)
			(2
				(gEgo view: 510 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(HighPrint 67 32) ; "The trap seems to be caught on something. You can't pull it loose."
				(self cue:)
			)
			(4
				(= cycles 8)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(NormalEgo)
				(HandsOn)
			)
		)
	)
)

(instance thrashAndWait of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fox setLoop: 0 setCycle: End self)
			)
			(1
				(fox cel: 0)
				(= seconds (Random 3 8))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance peekABooScript1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 12 30))
			)
			(1
				(while (== (= local10 (Random 0 4)) local11)
				)
				(self cue:)
			)
			(2
				(client
					x: [local0 local10]
					y: [local0 (+ local10 5)]
					setCycle: End self
				)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance peekABooScript2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 12 30))
			)
			(1
				(while (== (= local10 (Random 0 4)) local11)
				)
				(self cue:)
			)
			(2
				(client
					x: [local0 local11]
					y: [local0 (+ local11 5)]
					setCycle: End self
				)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance eyes1 of Prop
	(properties
		y 67
		x 205
		view 240
		cycleSpeed 1
	)
)

(instance eyes2 of Prop
	(properties
		y 74
		x 180
		view 240
		loop 1
		cycleSpeed 1
	)
)

(instance southBush of View
	(properties
		y 207
		x 162
		view 700
		loop 2
		cel 1
	)
)

(instance fox of TargActor
	(properties
		y 110
		x 90
		view 67
		cycleSpeed 3
		targDeltaY 10
	)

	(method (getHurt)
		(self setScript: distantFoxDies)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'pat/fox')
						(HighPrint 67 33) ; "That's not worth any game points, and will not make the fox feel any better."
					)
					((Said 'throw/dagger,dagger')
						(ThrowKnife self)
					)
					((Said 'throw/boulder')
						(ThrowRock self)
					)
					((Said 'look,ask/feet')
						(HighPrint 67 34) ; "My foot is caught in this trap. If I had hands like you, instead of paws, I could free myself."
					)
				)
			)
		)
	)
)

(instance dart of Act
	(properties
		y 500
		x 1000
		z 12
		view 522
		illegalBits 0
	)
)

(instance trap of View
	(properties
		y 110
		x 92
		view 67
		loop 2
		cel 14
		priority 7
	)
)

