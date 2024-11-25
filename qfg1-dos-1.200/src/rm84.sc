;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 84)
(include sci.sh)
(use Main)
(use n100)
(use n101)
(use n102)
(use n106)
(use TargActor)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm84 0
)

(local
	local0
	local1 = 90
	local2 = 40
	local3 = 20
	local4
	local5
	local6 = 114
	local7 = 96
	local8 = 1
	local9 = 6
	local10
	local11
)

(instance rm84 of Rm
	(properties
		picture 84
		style 8
		north 78
		east 85
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 74)
		(if (!= gNewRoomNum 89)
			(ClearFlag 247)
			(if (not (or (IsFlag 250) (IsFlag 251)))
				(ClearFlag 253)
				(ClearFlag 252)
			)
		)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(gMouseHandler add: self)
		(SL enable:)
		(gContMusic fade:)
		(self setLocales: 804)
		(if (or (== gPrevRoomNum 97) (== gPrevRoomNum 89))
			(SetFlag 253)
		)
		(if (SetFlag 84)
			(SetFlag 348)
		)
		(NormalEgo)
		(gEgo init:)
		(if (not (IsFlag 253))
			(gEgo illegalBits: $8040)
			(rock init: stopUpd:)
		)
		(if (= local0 (not (or (IsFlag 206) (IsFlag 204))))
			(antwerp init: loop: 3 setScript: bounceAndLook)
			(LoadMany rsVIEW 590 513 502 503 510 84)
			(LoadMany rsSOUND (SoundFX 4) (SoundFX 5) (SoundFX 6) (SoundFX 9) 54)
			(gContMusic stop:)
			(antSound number: (SoundFX 4) init:)
			(antHits init:)
			(cond
				((= local11 (gEgo has: 6)) ; blade
					(Load rsVIEW 501)
				)
				((gEgo has: 7) ; dagger
					(Load rsVIEW 512)
				)
			)
		)
		(switch gPrevRoomNum
			(89
				(gEgo posn: 25 90 setMotion: MoveTo 36 90)
			)
			(97
				(gEgo posn: 25 90 setMotion: MoveTo 36 90)
			)
			(78
				(gEgo posn: 160 30 setMotion: MoveTo 198 75)
			)
			(85
				(gEgo posn: 319 100 setMotion: MoveTo 295 100)
			)
		)
	)

	(method (doit)
		(cond
			((and (== (gEgo onControl: 1) 4096) (== (gEgo loop:) 3))
				(gCurRoom newRoom: 78)
			)
			((<= (gEgo x:) 25)
				(gCurRoom newRoom: 89)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp [temp0 30] temp30 temp31)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((super handleEvent: event))
					((MouseClaimed gEgo event 3)
						(HighPrint (Format @temp0 84 0 @global401)) ; "By golly, It's %s!"
					)
				)
			)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look,search>')
						(cond
							((Said '[<at,around][/place,area]')
								(cond
									((IsFlag 206)
										(HighPrint 84 1) ; "Now that the big Antwerp has split, this corner of the forest seems strangely quiet."
									)
									((IsFlag 204)
										(HighPrint 84 2) ; "You look around and see rocks and grass, but no Antwerp."
									)
									(else
										(HighPrint 84 3) ; "You see rocks, grass and an Antwerp."
									)
								)
							)
							(
								(Said
									'[<at,around][/antwerp,monster,creature,beast,animal,bouncer]'
								)
								(cond
									((IsFlag 206)
										(HighPrint 84 4) ; "The only Antwerp known in these parts has split... into parts."
									)
									((IsFlag 204)
										(HighPrint 84 5) ; "The Antwerp seems to have flown the coop."
									)
									(else
										(HighPrint 84 6) ; "Antwerps are on the endangered species list. They are rarely seen."
									)
								)
							)
							((Said '[<at][/boulder,boulder]')
								(cond
									((not (gEgo inRect: 0 72 66 102))
										(HighPrint 84 7) ; "The rocks were left here by some receding glacier."
									)
									((IsFlag 253)
										(HighPrint 84 8) ; "There is a narrow cave entrance among the rocks."
									)
									(else
										(HighPrint 84 9) ; "You find a keyhole concealed in a crack in the rock."
									)
								)
							)
							((or (Said '/cave,entrance') (Said '<in'))
								(if (IsFlag 253)
									(HighPrint 84 10) ; "There is a narrow cave entrance among the rocks. Inside, you see a dark passage through the hillside."
								else
									(HighPrint 84 11) ; "You see nothing like that here."
								)
							)
							((Said '/door,keyhole,hasp')
								(if (gEgo inRect: 0 72 66 102)
									(HighPrint 84 9) ; "You find a keyhole concealed in a crack in the rock."
								else
									(HighPrint 84 12) ; "You do not find anything nearby."
								)
							)
							((or (Said '<up') (Said '/sky'))
								(HighPrint 84 13) ; "The sky is clear."
							)
							((or (Said '<down') (Said '/ground,grass'))
								(HighPrint 84 14) ; "The grass is luscious, just the thing for hungry herbivores."
							)
							((Said '/south,west')
								(HighPrint 84 15) ; "The way is impassable. Sheer rock cliffs rise to serious heights."
							)
							((Said '/east,north')
								(HighPrint 84 16) ; "The forest extends to the east and north."
							)
						)
					)
					((Said 'cast>')
						(switch (= temp30 (SaidSpell event))
							(18
								(if (CastSpell temp30)
									(HighPrint 84 17) ; "You detect no magic here."
								)
							)
							(20
								(if (CastSpell temp30)
									(CastDazzle)
									(if local0
										(HighPrint 84 18) ; "Antwerps aren't dazzled easily."
									)
								)
							)
							(23
								(if (CastSpell temp30)
									(if (gCast contains: antwerp)
										(LookAt gEgo antwerp)
										(RedrawCast)
									)
									(if local0
										(CastDart antwerp)
										(antwerp setScript: antwerpAway)
									else
										(CastDart 0)
									)
								)
							)
							(17
								(cond
									((not (gEgo inRect: 0 72 66 102))
										(HighPrint 84 19) ; "You aren't close enough to a lock."
									)
									((CastSpell temp30)
										(if (IsFlag 252)
											(HighPrint 84 20) ; "It's already unlocked."
										else
											(self setScript: sMagicRock)
										)
									)
								)
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'throw/dagger,dagger')
						(= temp31
							(if (gCast contains: antwerp) antwerp else 0)
						)
						(if (ThrowKnife temp31)
							(if (gCast contains: antwerp)
								(+= global271 global272)
								(= global272 0)
								(LookAt gEgo antwerp)
								(RedrawCast)
							)
							(if local0
								(antwerp setScript: antwerpAway)
							)
						)
					)
					((Said 'throw/boulder')
						(= temp31
							(if (gCast contains: antwerp) antwerp else 0)
						)
						(if (ThrowRock temp31)
							(if (gCast contains: antwerp)
								(LookAt gEgo antwerp)
								(RedrawCast)
							)
							(if local0
								(antwerp setScript: antwerpAway)
							)
						)
					)
					(
						(Said
							'fight,kill[/bouncer,antwerp,animal,beast,monster,creature]'
						)
						(cond
							((IsFlag 206)
								(HighPrint 84 4) ; "The only Antwerp known in these parts has split... into parts."
							)
							((IsFlag 204)
								(HighPrint 84 5) ; "The Antwerp seems to have flown the coop."
							)
							((or local11 (gEgo has: 7)) ; dagger
								(antwerp setScript: fightAntwerp)
							)
							(else
								(HighPrint 84 21) ; "You have no weapon with which to fight the Antwerp."
								(HighPrint 84 22) ; "However, you bravely attack the bouncing beast with your bare hands."
								(gEgo setScript: bareHandAttack)
							)
						)
					)
					(
						(Said
							'feed[/antwerp,creature,monster,bouncer,animal,beast]'
						)
						(cond
							((IsFlag 206)
								(HighPrint 84 23) ; "The only Antwerp known to these parts, split ...into parts."
							)
							((IsFlag 204)
								(HighPrint 84 5) ; "The Antwerp seems to have flown the coop."
							)
							(else
								(HighPrint 84 24) ; "He's on a diet."
							)
						)
					)
					(
						(or
							(Said 'unlock,lockpick/door,boulder,hasp,keyhole')
							(Said 'use/key,lockpick')
							(Said 'open/hasp,keyhole')
							(Said 'put,fill<in/key/hasp')
						)
						(cond
							((not (gEgo inRect: 0 72 66 102))
								(HighPrint 84 25) ; "You don't see any locks nearby."
							)
							((IsFlag 252)
								(HighPrint 84 20) ; "It's already unlocked."
							)
							((and (gEgo has: 5) (IsFlag 245)) ; key
								(HighPrint 84 26) ; "The lock in the rock clicks open."
								(SetFlag 252)
							)
							((not (CanPickLocks))
								(HighPrint 84 27) ; "You'd have a much easier time of this if you had the key."
							)
							((TrySkill 9 85 global189) ; pick locks
								(HighPrint 84 28) ; "Ah, got it! The lock in the rock clicks open."
								(SetFlag 252)
							)
							(else
								(HighPrint 84 29) ; "The lock is beyond your present skill. It might help if you had the key."
								(if (not (gEgo has: 24)) ; thief kit
									(HighPrint 84 30) ; "... Or at least a better set of tools."
								)
							)
						)
					)
					((Said 'shove,move,force,get,open/boulder,door')
						(if (not (IsFlag 253))
							(if (IsFlag 252)
								(if (TrySkill 0 40 0) ; strength
									(rock setScript: sMoveRock)
								else
									(HighPrint 84 31) ; "You are not strong enough yet to open the rock door."
								)
							else
								(HighPrint 84 32) ; "Despite your mightiest efforts, the rock does not move."
							)
						else
							(HighPrint 84 33) ; "The rock door has already been opened."
						)
					)
					((or (Said 'say,yell<hiden/goseke') (Said 'hiden/goseke'))
						(if
							(and
								(IsFlag 235)
								(gEgo inRect: 0 72 66 102)
								(IsFlag 253)
								(not (IsFlag 247))
								(not (IsFlag 250))
							)
							(SetFlag 247)
							(SolvePuzzle 702 5)
							(HighPrint 84 34) ; "You hear the sound of someone...or something...moving deeper into the cave to let you pass."
						else
							(HighPrint 84 35) ; "Ok, you say Hiden Goseke."
						)
					)
					((Said 'enter/cave,entrance')
						(HighPrint 84 36) ; "Go ahead. If you dare."
					)
				)
			)
		)
	)
)

(instance antwerp of TargActor
	(properties
		y 96
		x 114
		yStep 4
		view 590
		loop 2
		cycleSpeed 1
		xStep 4
		moveSpeed 1
	)

	(method (getHurt)
		(HighPrint 84 37) ; "That's funny. It bounced right off."
	)

	(method (doit)
		(if
			(and
				(== (self loop:) 0)
				(== (antSound loop:) 0)
				(== (self cel:) 0)
				(!= (self script:) fightAntwerp)
			)
			(antSound loop: 1 play:)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (MouseClaimed antwerp event 3)
					(HighPrint 84 38) ; "By golly, it's an Antwerp!"
				)
			)
			(evSAID
				(cond
					((super handleEvent: event))
					(
						(Said
							'play/[antwerp,monster,creature,bouncer,animal,beast]'
						)
						(HighPrint 84 39) ; "The Antwerp plays rough."
					)
				)
			)
		)
	)
)

(instance bounceAndLook of Script
	(properties)

	(method (doit)
		(cond
			(
				(and
					(<
						(- (antwerp x:) local1)
						(gEgo x:)
						(+ (antwerp x:) local1)
					)
					(<
						(- (antwerp y:) local2)
						(gEgo y:)
						(+ (antwerp y:) local2)
					)
				)
				(antwerp cycleSpeed: 0 moveSpeed: 0)
				(client setScript: antwerpFollow)
			)
			(
				(or
					(and (< (antwerp x:) (gEgo x:)) (!= (antwerp loop:) 0))
					(and (> (antwerp x:) (gEgo x:)) (!= (antwerp loop:) 1))
				)
				(self changeState: 0)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(antSound number: (SoundFX 4) play:)
				(if (< (antwerp x:) (gEgo x:))
					(antwerp
						loop: 0
						cycleSpeed: 1
						moveSpeed: 1
						setCycle: End self
					)
				else
					(antwerp
						loop: 1
						cycleSpeed: 1
						moveSpeed: 1
						setCycle: End self
					)
				)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance antwerpFollow of Script
	(properties)

	(method (doit)
		(= local4 (- (gEgo x:) (antwerp x:)))
		(= local5 (- (gEgo y:) (antwerp y:)))
		(if (and (< -45 local4 45) (< -8 local5 8))
			(antwerp cycleSpeed: 1 moveSpeed: 1)
			(client setScript: antwerpPushes)
		)
		(cond
			((-- local8))
			(
				(or
					(not (< (- local1) local4 local1))
					(not (< (- local2) local5 local2))
				)
				(self changeState: 7)
			)
			(
				(and
					(< (- (* local4 local2) (* local5 local3)) 0)
					(< (+ (* local5 local3) (* local4 local2)) 0)
				)
				(self changeState: 1)
			)
			((and (> (- (* local4 local2) (* local5 local3)) 0) (< local4 0))
				(self changeState: 2)
			)
			((< (+ (* local5 local3) (* local4 local2)) 0)
				(self changeState: 3)
			)
			((> (- (* local4 local2) (* local5 local3)) 0)
				(self changeState: 4)
			)
			((and (< (- (* local4 local2) (* local5 local3)) 0) (> local4 0))
				(self changeState: 5)
			)
			(else
				(self changeState: 6)
			)
		)
		(if (not local8)
			(= local8 local9)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(if
					(and
						(< (- local6 local1) (gEgo x:) (+ local6 local1))
						(< (- local7 local2) (gEgo y:) (+ local7 local2))
					)
					(cond
						((<= (antwerp x:) local6)
							(antwerp
								setLoop: 1
								setCycle: Fwd
								setMotion: MoveTo local6 (gEgo y:)
							)
						)
						((<= (/ (+ (antwerp x:) (gEgo x:)) 2) local6)
							(antwerp
								setLoop: 1
								setCycle: Fwd
								setMotion: MoveTo local6 (gEgo y:)
							)
						)
						(else
							(antwerp
								setLoop: 1
								setCycle: Fwd
								setMotion:
									MoveTo
									(+ (antwerp x:) (gEgo x:))
									(gEgo y:)
							)
						)
					)
				else
					(antwerp
						setLoop: 1
						setCycle: Fwd
						setMotion: MoveTo local6 local7
					)
				)
			)
			(2
				(antwerp
					setLoop: 1
					setCycle: Fwd
					setMotion:
						MoveTo
						(+ (antwerp x:) (/ local5 2))
						(- (antwerp y:) (/ local5 2))
				)
			)
			(3
				(antwerp
					setLoop: 0
					setCycle: Fwd
					setMotion:
						MoveTo
						(- (antwerp x:) (/ local5 2))
						(- (antwerp y:) (/ local5 2))
				)
			)
			(4
				(if
					(and
						(< (- local6 local1) (gEgo x:) (+ local6 local1))
						(< (- local7 local2) (gEgo y:) (+ local7 local2))
					)
					(cond
						((>= (antwerp x:) local6)
							(antwerp
								setLoop: 0
								setCycle: Fwd
								setMotion: MoveTo local6 (gEgo y:)
							)
						)
						((>= (/ (+ (antwerp x:) (gEgo x:)) 2) local6)
							(antwerp
								setLoop: 0
								setCycle: Fwd
								setMotion: MoveTo local6 (gEgo y:)
							)
						)
						(else
							(antwerp
								setLoop: 0
								setCycle: Fwd
								setMotion:
									MoveTo
									(+ (antwerp x:) (gEgo x:))
									(gEgo y:)
							)
						)
					)
				else
					(antwerp
						setLoop: 0
						setCycle: Fwd
						setMotion: MoveTo local6 local7
					)
				)
			)
			(5
				(antwerp
					setLoop: 0
					setCycle: Fwd
					setMotion:
						MoveTo
						(- (antwerp x:) (/ local5 2))
						(+ (antwerp y:) (/ local5 2))
				)
			)
			(6
				(antwerp
					setLoop: 1
					setCycle: Fwd
					setMotion:
						MoveTo
						(+ (antwerp x:) (/ local5 2))
						(+ (antwerp y:) (/ local5 2))
				)
			)
			(7
				(antwerp
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo local6 local7 self
				)
			)
			(8
				(client setScript: bounceAndLook)
			)
		)
	)
)

(instance antwerpPushes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (gEgo x:) (antwerp x:))
					(gEgo
						ignoreActors:
						setMotion: MoveTo (- (antwerp x:) 30) (antwerp y:) self
					)
				else
					(gEgo
						ignoreActors:
						setMotion: MoveTo (+ (antwerp x:) 30) (antwerp y:) self
					)
				)
			)
			(1
				(if (< (gEgo x:) (antwerp x:))
					(antwerp
						setLoop: 1
						cel: 0
						setCycle: Fwd
						setMotion: MoveTo (+ (gEgo x:) 21) (antwerp y:) self
					)
					(gEgo
						view: 513
						setLoop: 2
						cycleSpeed: 1
						setCycle: End
						setMotion: MoveTo (- (gEgo x:) 10) (gEgo y:)
					)
				else
					(antwerp
						setLoop: 0
						cel: 0
						setCycle: Fwd
						setMotion: MoveTo (- (gEgo x:) 21) (antwerp y:) self
					)
					(gEgo
						view: 513
						setLoop: 3
						cycleSpeed: 1
						setCycle: End
						setMotion: MoveTo (+ (gEgo x:) 10) (gEgo y:)
					)
				)
				(antHits play:)
			)
			(2
				(if (not (TakeDamage 10))
					(self changeState: 5)
				else
					(NormalEgo)
					(if (not (IsFlag 253))
						(gEgo illegalBits: $8040)
					)
					(= local4 45)
					(if (< (gEgo x:) (antwerp x:))
						(if (> 226 (+ (antwerp x:) local4))
							(= local4 (- 226 (antwerp x:)))
						)
						(antwerp
							setLoop: 1
							cel: 0
							setCycle: Fwd
							setMotion:
								MoveTo
								(+ (antwerp x:) local4)
								(antwerp y:)
								self
						)
						(gEgo loop: 0)
					else
						(if (> 82 (- (antwerp x:) local4))
							(= local4 (- (antwerp x:) 82))
						)
						(antwerp
							setLoop: 0
							cel: 0
							setCycle: Fwd
							setMotion:
								MoveTo
								(- (antwerp x:) local4)
								(antwerp y:)
								self
						)
						(gEgo loop: 1)
					)
					(HandsOn)
				)
			)
			(3
				(= seconds 3)
			)
			(4
				(antwerp cycleSpeed: 0 moveSpeed: 0)
				(client setScript: antwerpFollow)
			)
			(5
				(= local4 25)
				(if (< (gEgo x:) (antwerp x:))
					(if (> 226 (+ (antwerp x:) local4))
						(= local4 (- 226 (antwerp x:)))
					)
					(antwerp
						setLoop: 1
						cel: 0
						setCycle: Fwd
						setMotion: MoveTo (+ (antwerp x:) local4) (antwerp y:)
					)
					(gEgo loop: 2)
				else
					(if (> 82 (- (antwerp x:) local4))
						(= local4 (- (antwerp x:) 82))
					)
					(antwerp
						setLoop: 0
						cel: 0
						setCycle: Fwd
						setMotion: MoveTo (- (antwerp x:) local4) (antwerp y:)
					)
					(gEgo loop: 1)
				)
				(gEgo
					view: 503
					setLoop: 0
					cel: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(6
				(EgoDead ; "The old ticker just couldn't keep going. Maybe you shouldn't have missed the annual visit with your local Healer."
					84
					40
					82
					517
					2
					5
					80
					{Your figure remains still and silent.}
				)
			)
		)
	)
)

(instance fightAntwerp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(TimePrint 5 84 41) ; "Cockily, you loosen up to fight."
				(antwerp setMotion: MoveTo 114 96)
				(gEgo ignoreActors: setMotion: MoveTo 250 100 self)
			)
			(1
				(gEgo
					view: 502
					setLoop: (if local11 0 else 2)
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(if local11
					(gEgo view: 501 setLoop: 2)
				else
					(gEgo view: 512 setLoop: 5)
				)
				(gEgo cel: 0 setCycle: End self)
			)
			(3
				(gEgo
					cel: 0
					setLoop: (if local11 6 else 1)
					setCycle: End self
				)
			)
			(4
				(gEgo
					cel: 0
					setLoop: (if local11 3 else 0)
					setCycle: End self
				)
			)
			(5
				(gEgo
					cel: 0
					setLoop: (if local11 7 else 0)
					setCycle: End self
				)
			)
			(6
				(if local10
					(-- local10)
					(self changeState: 2)
				else
					(= local10 4)
					(= cycles 4)
				)
			)
			(7
				(gEgo
					cel: 0
					setLoop: (if local11 4 else 3)
					setCycle: End self
				)
			)
			(8
				(if local10
					(-- local10)
					(self changeState: 7)
				else
					(gEgo
						view: 502
						setLoop: (if local11 0 else 3)
						cel: 5
						setCycle: Beg self
					)
				)
			)
			(9
				(TimePrint 4 84 42) ; "Confident and loose, you approach the Antwerp."
				(NormalEgo)
				(gEgo
					setLoop: 1
					moveSpeed: 1
					cycleSpeed: 1
					ignoreActors:
					setMotion: MoveTo 158 96 self
				)
			)
			(10
				(gEgo
					view: 502
					setLoop: (if local11 0 else 2)
					cel: 0
					moveSpeed: 0
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(11
				(antwerp
					setLoop: 0
					setCycle: CT 2 1
					setStep: 1 5
					setMotion: MoveTo 114 0
				)
				(antSound number: (SoundFX 4) play:)
				(= cycles 13)
			)
			(12
				(antSound stop:)
				(if local11
					(gEgo view: 501 setLoop: 3)
				else
					(gEgo view: 512 setLoop: 5)
				)
				(gEgo cel: 0 setCycle: End self)
			)
			(13
				(gEgo loop: (if local11 1 else 8) cel: 0)
				(antwerp setCycle: End setMotion: MoveTo 114 96 self)
			)
			(14
				(antwerp setCycle: Fwd)
				(= cycles 10)
			)
			(15
				(antwerp
					yStep: 7
					setCycle: CT 2 1
					ignoreActors: 1
					ignoreHorizon:
					illegalBits: 0
					setMotion: MoveTo 114 0
				)
				(antSound number: (SoundFX 5) play:)
				(= cycles 10)
			)
			(16
				(antSound stop:)
				(if local11
					(gEgo view: 501 setLoop: 3)
				else
					(gEgo view: 512 setLoop: 5)
				)
				(gEgo cel: 0 setCycle: End self)
			)
			(17
				(= cycles 16)
			)
			(18
				(antwerp setMotion: MoveTo 114 96 self)
				(gEgo loop: (if local11 1 else 8) cel: 0)
			)
			(18
				(antSound number: (SoundFX 9) play:)
				(antwerp setCycle: CT 2 1 setMotion: MoveTo 114 92 self)
			)
			(19
				(antSound stop:)
				(antwerp setCycle: Beg self)
			)
			(20
				(antSound number: (SoundFX 6) play:)
				(antwerp yStep: 10 setMotion: MoveTo 114 -10)
				(= cycles 10)
			)
			(21
				(antSound stop:)
				(if local11
					(gEgo view: 501 setLoop: 5 cel: 0)
				else
					(gEgo view: 512 setLoop: 5)
				)
				(gEgo cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(22
				(gEgo
					view: 502
					setLoop: (if local11 0 else 3)
					cel: (if local11 5 else 2)
					setCycle: Beg self
				)
			)
			(23
				(NormalEgo)
				(if (not (IsFlag 253))
					(gEgo illegalBits: $8040)
				)
				(SetFlag 204)
				(HandsOn)
				(TimePrint 3 84 43) ; "Holy Mackerel!"
			)
		)
	)
)

(instance antSound of Sound
	(properties
		priority 5
	)
)

(instance antHits of Sound
	(properties
		number 54
		priority 6
	)
)

(instance rock of Act
	(properties
		y 89
		x 18
		yStep 1
		view 84
		xStep 1
	)
)

(instance sMoveRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 510
					setLoop: 1
					cel: 0
					cycleSpeed: 2
					setCycle: CT 2 1 self
				)
			)
			(1
				(rock
					setCycle: 0
					startUpd:
					illegalBits: 0
					xStep: 3
					setMotion: MoveTo -18 89 self
				)
				(gEgo setCycle: Beg)
			)
			(2
				(EgoGait 0 0) ; walking
				(gEgo illegalBits: $8000)
				(HandsOn)
				(SolvePuzzle 701 10)
				(SetFlag 253)
				(rock dispose:)
			)
		)
	)
)

(instance sMagicRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 521
					illegalBits: 0
					setLoop: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(SetFlag 252)
				(EgoGait 0 0) ; walking
				(if (< [gEgoStats 17] 50) ; openSpell
					(HighPrint 84 44) ; "Your spell has unlocked the lock on the rock, but it is not yet powerful enough to open the rock door."
					(HandsOn)
					(NormalEgo)
					(gEgo illegalBits: $8040)
					(client setScript: 0)
				else
					(rock
						setCycle: 0
						startUpd:
						illegalBits: 0
						setMotion: MoveTo -18 89 self
					)
				)
			)
			(2
				(SolvePuzzle 701 10)
				(SetFlag 253)
				(rock dispose:)
				(NormalEgo)
				(HandsOn)
			)
		)
	)
)

(instance bareHandAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (antwerp x:) (antwerp y:) self)
			)
			(1
				(client setScript: 0)
			)
		)
	)
)

(instance antwerpAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(SetFlag 204)
				(antwerp setCycle: End self)
			)
			(1
				(antwerp
					setLoop: 2
					cel: 0
					ignoreHorizon:
					illegalBits: 0
					setPri: (antwerp priority:)
					setStep: 4 18
					setCycle: Beg
					setMotion: MoveTo 200 -10 self
				)
			)
			(2
				(HighPrint 84 45) ; "You seem to have scared the Antwerp with your behavior."
			)
		)
	)
)

