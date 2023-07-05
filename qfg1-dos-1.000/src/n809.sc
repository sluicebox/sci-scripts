;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 809)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Inventory)
(use User)

(public
	proc809_0 0
	proc809_1 1
	proc809_2 2
)

(procedure (proc809_2 param1 param2)
	(param1 type: 128 claimed: 0)
	(Parse param2 param1)
	(User said: param1)
)

(procedure (proc809_0 param1)
	(cond
		((or (== gEgoGait 2) ((ScriptID 15 0) script:))) ; sneaking, rm15
		((< global315 1)
			(gEgo setMotion: 0)
			(= global315 1)
			(SetFlag 296)
			(param1 claimed: 1)
		)
		((and (< global315 2) (not ((ScriptID 15 1) script:))) ; kobold
			(= global315 2)
			(SetFlag 297)
		)
	)
)

(procedure (proc809_1 param1 &tmp temp0)
	(cond
		((Said 'cast>')
			(switch (= temp0 (SaidSpell param1))
				(17
					(if (and (not (gEgo script:)) (!= global319 3))
						(EgoGait 0 0) ; walking
						(SetFlag 166)
						(if (and (== global322 0) (CastSpell temp0))
							(SetFlag 291)
						else
							(LowPrint 809 0) ; "You've already opened all that can be opened in here."
						)
					else
						(LowPrint 809 1) ; "You're too busy right now!"
					)
				)
				(18
					(if (and (!= global315 2) (CastSpell temp0))
						(SetFlag 166)
						(SetFlag 299)
					else
						(LowPrint 809 2) ; "Now??"
					)
				)
				(19
					(if (and (not (gEgo script:)) (!= global319 3))
						(EgoGait 0 0) ; walking
						(SetFlag 166)
						(if (< global315 2)
							(SetFlag 297)
						)
						(if (and (== global322 0) (CastSpell temp0))
							(SetFlag 291)
						else
							(LowPrint 809 3) ; "There are no spells left to trigger."
						)
					else
						(LowPrint 809 2) ; "Now??"
					)
				)
				(20
					(if (< global319 2)
						(= global319 2)
					)
					(cond
						((IsFlag 216)
							(LowPrint 809 4) ; "The Kobold is still blind from your last Dazzle spell. Act quickly!"
						)
						((== global319 3)
							(LowPrint 809 2) ; "Now??"
						)
						(else
							(EgoGait 0 0) ; walking
							(if (< global315 4)
								(if (CastSpell temp0)
									(SetFlag 293)
								)
							else
								(LowPrint 809 5) ; "Ding, dong, the Kobold's dead. Why bother?"
							)
						)
					)
				)
				(22
					(if (== global319 3)
						(LowPrint 809 2) ; "Now??"
					else
						(EgoGait 0 0) ; walking
						(if (CastSpell temp0)
							(SetFlag 349)
							(SetFlag 307)
						else
							(param1 claimed: 0)
						)
					)
				)
				(21
					(param1 claimed: 0)
				)
				(23
					(if (< global319 2)
						(= global319 2)
					)
					(cond
						((== global319 3)
							(LowPrint 809 1) ; "You're too busy right now!"
							(param1 claimed: 1)
						)
						((== global315 4)
							(LowPrint 809 5) ; "Ding, dong, the Kobold's dead. Why bother?"
						)
						(else
							(if
								(and
									(!= global315 2)
									(not ((ScriptID 15 1) script:)) ; kobold
								)
								(EgoGait 0 0) ; walking
								(SetFlag 157)
							)
							(if (not (gEgo script:))
								(if (CastSpell temp0)
									(SetFlag 286)
								)
							else
								(LowPrint 809 6) ; "One thing at a time, hero!"
							)
						)
					)
				)
				(24
					(if (not (IsFlag 165))
						(switch global315
							(0
								(if (CastSpell temp0)
									(SetFlag 295)
									(EgoGait 0 0) ; walking
								)
							)
							(4
								(if (== global321 2)
									(param1 claimed: 0)
								else
									(LowPrint 809 7) ; "Just walk over and get what you want."
								)
							)
							(else
								(if (CastSpell temp0)
									(LowPrint 809 8) ; "The Kobold's magic blocks your spell."
								)
							)
						)
					else
						(param1 claimed: 0)
					)
				)
			)
		)
		((Said 'throw>')
			(cond
				((Said '/boulder')
					(if (not (gEgo has: 21)) ; boulder
						(DontHave)
						(return)
					)
					(switch global315
						(0
							(LowPrint 809 9) ; "Shhhh! You'll probably just wake up the Kobold."
						)
						(1
							(LowPrint 809 10) ; "It'd just make the Kobold madder."
						)
						(2
							(LowPrint 809 11) ; "Perhaps something more potent than a rock is in order."
						)
						(4
							(LowPrint 809 12) ; "What for?"
						)
					)
				)
				((Said '/dagger')
					(cond
						((not (gEgo has: 7)) ; dagger
							(DontHave)
						)
						((== global315 4)
							(LowPrint 809 12) ; "What for?"
						)
						((< (gEgo distanceTo: (ScriptID 15 1)) 50) ; kobold
							(LowPrint 809 13) ; "You're too close."
						)
						((not (gEgo script:))
							(SetFlag 324)
						)
						(else
							(LowPrint 809 1) ; "You're too busy right now!"
							(param1 claimed: 1)
						)
					)
				)
				(else
					(LowPrint 809 14) ; "It would serve no purpose."
					(param1 claimed: 1)
				)
			)
		)
		((Said 'kill,cut,fight')
			(if (and (not (gEgo has: 7)) (not (gEgo has: 6))) ; dagger, blade
				(LowPrint 809 15) ; "You have no weapon."
				(return)
			)
			(switch global319
				(4
					(LowPrint 809 16) ; "There is no one to fight here anymore."
				)
				(3
					(LowPrint 809 17) ; "You're already fighting!"
				)
				(else
					(EgoGait 0 0) ; walking
					(= global319 3)
				)
			)
			(if (< global315 3)
				(SetFlag 147)
				(switch global315
					(0
						(= global315 1)
						(SetFlag 296)
					)
					(1
						(= global315 2)
						(SetFlag 297)
						(SetFlag 289)
					)
					(2
						(SetFlag 289)
					)
				)
			)
		)
		((Said 'ask,talk,awaken')
			(EgoGait 0 0) ; walking
			(cond
				((< global315 1)
					(= global315 1)
					(SetFlag 296)
				)
				((< global315 2)
					(SetFlag 298)
				)
				((< global315 4)
					(LowPrint 809 18) ; "Now's not a good time to attempt to communicate."
				)
				(else
					(LowPrint 809 19) ; "Who are you talking to?"
				)
			)
		)
		((or (Said '[use]/stealth') (Said 'sneak'))
			(cond
				((== global315 4)
					(LowPrint 809 20) ; "Why bother?"
				)
				((>= global315 1)
					(LowPrint 809 21) ; "Too late for that now!"
				)
				((!= gEgoGait 2) ; sneaking
					(if (TrySkill 8 40 0) ; stealth
						(EgoGait 2 0) ; sneaking
					else
						(LowPrint 809 22) ; "Your footsteps echo loudly in this cave. You'd better practice some more before you'll be able to sneak in here."
					)
				)
			)
		)
		((Said 'look>')
			(cond
				((Said '/stalactite')
					(LowPrint 809 23) ; "They're like stalagmites, but they go the other way."
				)
				((Said '/stalagmite')
					(LowPrint 809 24) ; "They're like stalactites, but they go the other way."
				)
				((Said '[<at,around][/!*,cave,room,east]')
					(LowPrint 809 25) ; "This part of the cavern is spacious and multi-leveled."
					(switch global315
						(0
							(LowPrint 809 26) ; "Resting on a rocky platform above the cave floor is a Kobold, one of the race of ugly, miserly magicians."
							(LowPrint 809 27) ; "There seems to be a crude table at the base of the platform."
						)
						(2
							(LowPrint 809 28) ; "There is a lot of activity at present."
						)
						(1
							(LowPrint 809 29) ; "The Kobold seems agitated."
						)
					)
				)
				((or (Said '<up') (Said '/ceiling,roof'))
					(LowPrint 809 30) ; "The stalactites grow slowly."
					(LowPrint 809 31) ; "...or are they stalagmites?"
				)
				((or (Said '<down') (Said '/floor,ground'))
					(LowPrint 809 32) ; "The stalagmites grow slowly."
					(LowPrint 809 33) ; "...or are they stalactites?"
				)
				((Said '/wall,fungus,north,south,formation')
					(LowPrint 809 34) ; "The stalactites, stalagmites, and cave walls glow from a phosphorescent fungus growing there."
				)
				((Said '/west,open,entrance')
					(LowPrint 809 35) ; "Looking back the way you came, you see a faint reflection of the distant sunlight from the cave entrance."
				)
				((Said '/table')
					(LowPrint 809 36) ; "Something is lying in a pile on the table. Mushrooms? Toadstools??"
				)
				((Said 'look/mushroom,toadstool')
					(LowPrint 809 37) ; "They look almost edible... if you're a Kobold."
				)
				((Said '/gold,silver,alm,loot,chest,box')
					(cond
						((== global322 1)
							(if (< (gEgo distanceTo: (ScriptID 15 8)) 20) ; chest
								(HighPrint 809 38) ; "There are numerous gold and silver pieces in the chest."
							else
								(NotClose)
							)
						)
						((== global322 3)
							(HighPrint 809 39) ; "Where the chest was, you see many pieces of silver and gold."
						)
						((IsFlag 166)
							(Print 809 40) ; "The chest is invisible."
						)
						(else
							(Print 809 41) ; "You don't see anything like that."
						)
					)
				)
				((Said '/key')
					(cond
						((gEgo has: 5) ; key
							(param1 claimed: 0)
						)
						((IsFlag 165)
							(LowPrint 809 42) ; "You once had a key."
						)
						((== global321 0)
							(LowPrint 809 43) ; "The key around the creature's neck seems to emit light. You strongly suspect that it is magical in nature."
							((ScriptID 15 9) ; keySparkle
								posn:
									((ScriptID 15 1) x:) ; kobold
									(- ((ScriptID 15 1) y:) 22) ; kobold
								setCycle: End
							)
						)
						((== global321 1)
							(LowPrint 809 44) ; "The key lies on the stone where you last saw the Kobold."
						)
						((== global321 2)
							(LowPrint 809 45) ; "The key is no longer there!  Perhaps you should have gotten it while you had the chance."
						)
					)
				)
				((Said '/kobold,man,creature,wizard')
					(switch global315
						(0
							(LowPrint 809 46) ; "The strange creature is wearing ragged clothes."
							(if (not (gEgo has: 5)) ; key
								(LowPrint 809 47) ; "There is what looks like a key hanging around its neck."
							)
							((ScriptID 15 9) setCycle: End) ; keySparkle
						)
						(1
							(LowPrint 809 48) ; "The creature does not seem pleased to see you."
						)
						(2
							(LowPrint 809 49) ; "This creature is DANGEROUS!"
						)
						(else
							(LowPrint 809 50) ; "He's gone."
						)
					)
				)
			)
		)
		((Said 'use/key')
			(if (IsFlag 166)
				(HighPrint 809 51) ; "The key doesn't open the chest. It must be for something else."
			else
				(HighPrint 809 52) ; "What is the purpose?"
			)
		)
		((Said 'open/box,chest')
			(if (< (gEgo distanceTo: (ScriptID 15 8)) 20) ; chest
				(HighPrint 809 53) ; "How?"
			else
				(NotClose)
			)
		)
		((Said 'break,pry,force/box,chest,hasp,lid')
			(cond
				((not (IsFlag 166))
					(HighPrint 809 54) ; "Huh?"
				)
				((> global322 0)
					(HighPrint 809 52) ; "What is the purpose?"
				)
				((< (gEgo distanceTo: (ScriptID 15 8)) 20) ; chest
					(HighPrint 809 55) ; "You attempt to smash your way into the invisible chest!"
					(SetFlag 342)
					(SetFlag 292)
				)
				(else
					(NotClose)
				)
			)
		)
		((Said 'unlock,lockpick/box,chest,hasp')
			(cond
				((not (IsFlag 166))
					(HighPrint 809 56) ; "You can see no lock to pick."
				)
				((> global322 0)
					(HighPrint 809 52) ; "What is the purpose?"
				)
				((not (CanPickLocks))
					(HighPrint 809 57) ; "You have no way of doing that."
				)
				((< (gEgo distanceTo: (ScriptID 15 8)) 20) ; chest
					(HighPrint 809 58) ; "You attempt to pick the lock on the invisible chest. This'll be tricky!"
					(ClearFlag 342)
					(SetFlag 292)
				)
				(else
					(NotClose)
				)
			)
		)
		((Said 'get,lockpick[<up]>')
			(cond
				((Said '/key')
					(cond
						((gEgo pickUp: 5)
							(HighPrint 809 59) ; "You retrieve the key you dropped."
						)
						((IsFlag 165)
							(AlreadyDone)
						)
						((== global321 2)
							(LowPrint 809 60) ; "The key is no longer here."
						)
						((== gEgoGait 2) ; sneaking
							(if (< (gEgo distanceTo: (ScriptID 15 1)) 50) ; kobold
								(LowPrint 809 61) ; "VERY carefully, you remove the key from around the Kobold's neck."
								((ScriptID 15 9) setCycle: End) ; keySparkle
								(gEgo get: 5) ; key
								(= global321 2)
								(SetFlag 165)
								(SolvePuzzle 649 7)
								((ScriptID 15 7) hide:) ; koboldKey
							else
								(NotClose)
							)
						)
						((or (== global315 0) (== global315 1))
							(LowPrint 809 62) ; "You'll have to be careful if you want to get the key!"
						)
						((== global315 2)
							(LowPrint 809 63) ; "You'll have to kill the Kobold first."
						)
						((== global315 4)
							(if (< (gEgo distanceTo: (ScriptID 15 7)) 40) ; koboldKey
								(LowPrint 809 64) ; "You take the key."
								(gEgo get: 5) ; key
								(= global321 2)
								(SetFlag 165)
								(SolvePuzzle 649 7)
								((ScriptID 15 7) hide:) ; koboldKey
							else
								(NotClose)
							)
						)
					)
				)
				((Said '/fungus')
					(LowPrint 809 65) ; "The fungus is slimy and stuck tight to the cave walls."
				)
				((Said '/kobold,creature,stalactite,stalagmite')
					(LowPrint 809 66) ; "You're kidding, right?"
				)
				((Said '/mushroom,toadstool')
					(if (gEgo inRect: 178 113 250 143)
						(LowPrint 809 67) ; "You pick up several of them and put them away."
						(gEgo get: 30 3) ; magic mushroom
						(SetFlag 174)
					else
						(NotClose)
					)
				)
				((Said '/box,chest')
					(cond
						((not (IsFlag 166))
							(HighPrint 809 54) ; "Huh?"
						)
						((< global322 2)
							(if (< (gEgo distanceTo: (ScriptID 15 8)) 20) ; chest
								(HighPrint 809 68) ; "It's too heavy."
							else
								(NotClose)
							)
						)
						(else
							(HighPrint 809 69) ; "It's gone."
						)
					)
				)
				((Said '/alm,gold,silver,loot')
					(cond
						((== global322 0)
							(HighPrint 809 70) ; "How are you going to do that?"
						)
						((or (== global322 1) (== global322 3))
							(if (< (gEgo distanceTo: (ScriptID 15 8)) 20) ; chest
								(HighPrint 809 71) ; "You add ten gold and sixty silver pieces to your money pouch."
								(gEgo get: 1 60) ; silver
								(gEgo get: 2 10) ; gold
								(SolvePuzzle 650 5)
								(= global322 4)
								((ScriptID 15 8) setCel: 0) ; chest
							else
								(NotClose)
							)
						)
						((== global322 4)
							(AlreadyDone)
						)
						((== global322 5)
							(HighPrint 809 72) ; "There is no treasure to take."
						)
					)
				)
			)
		)
	)
)

