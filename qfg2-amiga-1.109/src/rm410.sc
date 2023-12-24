;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Talker)
(use n065)
(use TargActor)
(use VerbMessager)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm410 0
)

(local
	check1
	check2
	check3
	check4
	check5
	[checkX 5] = [222 175 135 95 210]
	noises
	moveCnt
	calmed
	spellDeath
	hitKhaveen
	hingesOiled
	doorLocked = 1
	hidden
	heardWaitMsg
	heardBoardMsg
	luckFactor
)

(procedure (MadeNoise)
	(gEgo setMotion: 0)
	(cond
		((not heardBoardMsg)
			(HighPrint 410 20) ; "Screeack"
			(HighPrint 410 21) ; "This room's thin carpet does little to muffle the noise made by the loose floor boards beneath it."
			(= heardBoardMsg 1)
		)
		((gCurRoom script:))
		(else
			(HighPrint 410 20) ; "Screeack"
		)
	)
	(if calmed
		(= calmed 0)
	else
		(gCurRoom
			setScript:
				(switch (++ noises)
					(1 rollBackS)
					(2 rollFrontS)
					(3 sitUpS)
					(4 sitAndSpeakS)
					(5 getUpS)
				)
		)
	)
)

(procedure (NoiZdoor)
	(door cel: 1 setCycle: End)
	(RedrawCast)
	(HighPrint 410 37) ; "Creeeak!"
	(HighPrint 410 38) ; "The cabinet door's hinges make a loud noise."
	(gCurRoom setScript: sitAndSpeakS)
)

(procedure (CheckMove)
	(cond
		((and (gEgo mover:) (not heardWaitMsg) (gCurRoom script:))
			(HighPrint 410 39) ; "The sleeper appears to be stirring. Perhaps you should not move until after he has gone back to sleep."
			(= moveCnt 2)
			(= heardWaitMsg 1)
			(return 1)
		)
		((and moveCnt (gEgo mover:) (not (-- moveCnt)))
			(= moveCnt 4)
			(MadeNoise)
			(return 1)
		)
		(else
			(return 0)
		)
	)
)

(instance rm410 of Rm
	(properties
		picture 410
		style 9
	)

	(method (init)
		(LoadMany rsVIEW 2 47 410 7)
		(LoadMany rsSOUND 410 20)
		(User verbMessager: myVerbs)
		(SolvePuzzle 710 3 2)
		(super init:)
		(InitAddToPics cabinet sofa)
		(= luckFactor (/ [gEgoStats 4] 5)) ; luck
		(bird init: stopUpd:)
		(door init: stopUpd:)
		(guard init: stopUpd:)
		(khav init: stopUpd: setScript: snoreS)
		(= moveCnt 6)
		(win init:)
		(bed init:)
		(tassle init:)
		(curtains init:)
		(weap1 init:)
		(gCSound number: 410 loop: -1 priority: 0 playBed:)
		(= gSpellChecker gAllChecker)
		(self setScript: inWinS)
	)

	(method (dispose)
		(gCSound fade:)
		(super dispose: &rest)
	)

	(method (doit &tmp stealthNeeded)
		(super doit:)
		(cond
			((and (not check1) (< (gEgo x:) [checkX 0]))
				(= check1 1)
				(if (not (TrySkill 8 0 (+ 15 luckFactor))) ; sneak
					(MadeNoise)
				)
			)
			((and (not check2) (< (gEgo x:) [checkX 1]))
				(= check2 1)
				(if (not (TrySkill 8 0 (+ 8 luckFactor))) ; sneak
					(MadeNoise)
				)
			)
			((and (not check3) (< (gEgo x:) [checkX 2]))
				(= check3 1)
				(MadeNoise)
			)
			((and (not check4) (< (gEgo x:) [checkX 3]))
				(= check4 1)
				(if (not (TrySkill 8 0 (+ 5 luckFactor))) ; sneak
					(MadeNoise)
				)
			)
			((and (not check5) (> (gEgo x:) [checkX 4]) [gInvNum 47]) ; Bird
				(= check5 1)
				(if (not (TrySkill 8 0 (+ 12 luckFactor))) ; sneak
					(MadeNoise)
				)
			)
			((& (gEgo onControl: 1) $0002)
				(EgoDead 1 410 0 #title {Fatal Distractions}) ; "Sneaking up on a Raseirian guard is never a good idea.  Especially when he has been hand-picked by Khaveen."
			)
			((and moveCnt (gEgo mover:) (!= gEgoGait 2) (not (-- moveCnt))) ; sneaking
				(MadeNoise)
				(= moveCnt 4)
			)
			(
				(and
					[gInvNum 47] ; Bird
					(gEgo inRect: 207 126 288 137)
					(not gCantMove)
				)
				(self setScript: outWinS)
			)
			((== spellDeath -1)
				(= spellDeath (IsFlag 87)) ; fCastingSpell
			)
			((and spellDeath (not (IsFlag 87))) ; fCastingSpell
				(if hitKhaveen
					(EgoDead 1 410 1 #title {Aggression was the death of you}) ; "Khaveen cries out in pain and the guard summons other guards who quickly subdue you. Khaveen makes certain that you will never bother him again."
				else
					(EgoDead 1 410 2 #title {Aggression was the death of you}) ; "Your attack awakens Khaveen who alerts the guards in the other room. You are quickly overwhelmed. It would be best if you don't announce your presence when attempting to be a burglar."
				)
			)
		)
	)

	(method (cue)
		(gCurRoom setScript: sitAndSpeakS)
	)

	(method (handleEvent event &tmp aSpell)
		(cond
			((super handleEvent: event))
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(HighPrint 410 3) ; "Someone is asleep nearby, surrounded by thin curtains. The occupant of this bedchamber must collect weapons, for there are many attached to the walls."
			)
			((Said 'look,look/floor')
				(HighPrint 410 4) ; "The floor is made of loosely joined hardwood boards."
			)
			((Said 'look,look/woman')
				(HighPrint 410 5) ; "What looked at first like a woman sleeping is actually a man with a beard."
			)
			((Said 'look,look/hinge')
				(gEgo setMotion: 0)
				(cond
					((not (and (< (gEgo x:) 76) (< (gEgo y:) 151)))
						(HighPrint 410 6) ; "Get closer to the cabinet."
					)
					(hingesOiled
						(gEgo loop: 3)
						(RedrawCast)
						(HighPrint 410 7) ; "The hinges look well oiled."
					)
					(else
						(gEgo loop: 3)
						(RedrawCast)
						(HighPrint 410 8) ; "The hinges look very rusty. Someone should oil them."
					)
				)
			)
			((or (Said 'grease/hinge,door,armoire') (Said 'use/grease'))
				(cond
					((not (and (< (gEgo x:) 76) (< (gEgo y:) 151)))
						(NotClose)
					)
					(hingesOiled
						(AlreadyDone)
					)
					((not [gInvNum 42]) ; Oil
						(HighPrint 410 9) ; "Pity. You don't have any oil."
					)
					(else
						(SolvePuzzle 712 3 2)
						(gEgo setScript: oilHingesS)
					)
				)
			)
			((Said 'lockpick/lock')
				(cond
					((not (CanPickLocks 1)))
					((not (and (< (gEgo x:) 76) (< (gEgo y:) 151)))
						(NotClose)
					)
					((not doorLocked)
						(AlreadyDone)
					)
					(else
						(gEgo setScript: pickLockS)
					)
				)
			)
			((Said 'break/cup,door')
				(EgoDead 1 410 10 #title {The Unsubtle Approach}) ; "The noise of the breaking glass did not go unnoticed. Khaveen called his guards who quickly overcame you. Your end was not a happy one."
			)
			((Said 'kill,attack>')
				(if
					(or
						(Said '/guard')
						(and (< (gEgo x:) 60) (not (Said '/khaveen')))
					)
					(EgoDead 1 410 11 #title {The Direct Approach}) ; "The guard was not asleep, and he didn't get his job by being slow to anger. Your movements triggered his highly-honed killer instinct. At least your end was a quick one."
				else
					(EgoDead 1 410 12 #title {Killing can be Fatal}) ; "As you move towards Khaveen, a board squeaks and Khaveen turns to look at you. Your weapon can't stop him from starting to shout. You are quickly overwhelmed and dragged off to the dungeon, but at least you have some satisfaction knowing Khaveen will no longer trouble Raseir."
				)
				(event claimed: 1)
			)
			((Said 'hide,duck,(get,get<down)')
				(if hidden
					(HighPrint 410 13) ; "You are already hiding as well as you can."
				else
					(gEgo setScript: hideS)
				)
			)
			((Said 'stand,(get,get<up)')
				(if hidden
					(hideS cue:)
				else
					(HighPrint 410 14) ; "You're already standing up."
				)
			)
			((Said 'climb,climb')
				(if (> (gEgo x:) 200)
					(gCurRoom setScript: outWinS)
				else
					(NotClose)
				)
			)
			((Said 'cast,drop,use,throw,climb,climb/rope[<magic]')
				(if (not gRopeUses)
					(HighPrint 410 15) ; "I'm a frayed knot."
				else
					(ThrowObj 6 gEgo self 0 0)
				)
			)
			((Said 'throw/dagger,boulder,powder,dust')
				(= spellDeath -1)
				(event claimed: 0)
			)
			((Said 'cast>')
				(if (OneOf (= aSpell (SaidSpell event)) 25 27 22)
					(= spellDeath -1)
				)
				(event claimed: 0)
			)
		)
	)
)

(instance inWinS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 410
					x: 247
					y: 134
					setLoop: 0
					cel: 0
					init:
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(= gEgoGait 0) ; walking
				(NormalEgo)
				(gEgo view: 4 posn: 241 136 loop: 5 setHeading: 225)
				(= cycles 14)
			)
			(2
				(gEgo view: 0)
				(HighPrint 410 16) ; "As your eyes adjust, you find yourself in a bedroom. Someone is asleep nearby, surrounded by thin curtains. The occupant of this bedchamber must collect weapons, for there are many attached to the walls."
				(self dispose:)
			)
		)
	)
)

(instance getBirdS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 64 141 self)
			)
			(1
				(gEgo setHeading: 0)
				(= cycles 5)
			)
			(2
				(SolvePuzzle 711 5 2)
				(gEgo get: 47) ; Bird
				(bird dispose:)
				(= cycles 2)
			)
			(3
				(HighPrint 410 17) ; "As you hold the bird in your hand, for a moment you wonder, "Is this the stuff dreams are made of?" You decide: "Nah," and put it away."
				(self dispose:)
			)
		)
	)
)

(instance oilHingesS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 40 141 self)
			)
			(1
				(gEgo
					view: 47
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: CT 2 1 self
				)
			)
			(2
				(= cycles 14)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(NormalEgo)
				(gEgo loop: 6 setHeading: 45)
				(= hingesOiled 1)
				(HighPrint 410 18) ; "The hinges have been oiled."
				(self dispose:)
			)
		)
	)
)

(instance pickLockS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 64 141 self)
			)
			(1
				(gEgo setHeading: 0)
				(= cycles 10)
			)
			(2
				(if (PickLock 100 1 1)
					(HighPrint 410 19) ; "The lock yields to your skill."
					(= doorLocked 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance openDoorS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 64 141 self)
			)
			(1
				(gEgo setHeading: 0)
				(door setCycle: End self)
				(if (not hingesOiled)
					(MadeNoise)
				)
			)
			(2
				(door stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance closeDoorS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 64 141 self)
			)
			(1
				(gEgo setHeading: 0)
				(door setCycle: Beg self)
				(if (not hingesOiled)
					(MadeNoise)
				)
			)
			(2
				(door stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance outWinS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 244 133 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo
					posn: 238 122
					view: 7
					setLoop: 1
					cel: 1
					cycleSpeed: 2
					setCycle: CT 5 1 self
				)
			)
			(3
				(gEgo
					view: 410
					setLoop: 0
					cel: 8
					posn: 247 134
					setCycle: Beg self
				)
			)
			(4
				(gCurRoom newRoom: 390)
			)
		)
	)
)

(instance rollBackS of Script
	(properties)

	(method (doit)
		(super doit:)
		(CheckMove)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(khav
					setScript: 0
					setLoop: 1
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(= seconds 4)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance rollFrontS of Script
	(properties)

	(method (doit)
		(super doit:)
		(CheckMove)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(khav setCycle: Beg self)
			)
			(1
				(khav setLoop: 2 cel: 0 cycleSpeed: 1 setCycle: End)
				(= seconds 4)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sitUpS of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((CheckMove))
			((and calmed (== state 3))
				(= calmed 0)
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(khav cycleSpeed: 2 setCycle: Beg self)
			)
			(1
				(= cycles 6)
			)
			(2
				(khav setLoop: 4 cel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(3
				(if
					(and
						(not hidden)
						(gEgo inRect: 123 147 210 180)
						(not calmed)
					)
					(EgoDead 1 410 22 #title {A man who enjoys his work}) ; "As you and the man look at each other, you realize just whose house this is.  Khaveen calls for his guards, and you are quickly overwhelmed. Khaveen then takes a sword and personally makes certain you'll never steal again."
				else
					(= seconds 5)
				)
			)
			(4
				(khav cycleSpeed: 1 setCycle: Beg self)
			)
			(5
				(khav setScript: snoreS)
				(self dispose:)
			)
		)
	)
)

(instance sitAndSpeakS of Script
	(properties)

	(method (doit)
		(super doit:)
		(CheckMove)
	)

	(method (handleEvent event)
		(if (Said 'hide,duck,(get,get<down)')
			(if hidden
				(HighPrint 410 13) ; "You are already hiding as well as you can."
			else
				(gEgo setScript: hideS)
			)
		else
			(event claimed: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(khav setScript: 0 cycleSpeed: 2 setCycle: Beg self)
			)
			(1
				(= cycles 6)
			)
			(2
				(khav setLoop: 4 cel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(3
				(if (and (not hidden) (gEgo inRect: 123 147 210 180))
					(EgoDead 1 410 22 #title {A man who enjoys his work}) ; "As you and the man look at each other, you realize just whose house this is.  Khaveen calls for his guards, and you are quickly overwhelmed. Khaveen then takes a sword and personally makes certain you'll never steal again."
				else
					(Say khav self 410 23) ; "What was that noise?"
				)
			)
			(4
				(guard
					view: 410
					posn: 17 126
					setMotion: MoveTo 9 140
					setLoop: 4
					setCycle: End self
				)
			)
			(5
				(= cycles 10)
			)
			(6
				(cond
					(hidden
						(Say guard self 410 24) ; "What noise, Sir?"
					)
					(calmed
						(EgoDead 1 410 25) ; "The Guards from the other room calmly arrest you and place you in prison for a short, but unpleasant time. Khaveen is not kind to those that break into his house and use magic against him, but you do not live to tell about it."
					)
					(else
						(EgoDead 1 410 26 #title {A man who enjoys his work}) ; "The guard quickly calls in other guards, and you are overwhelmed. Khaveen then takes a sword and personally makes certain you'll never steal again. The last thing you see is the smile on Khaveen's face."
					)
				)
			)
			(7
				(Say khav self 410 27) ; "Never mind, go back to your post."
			)
			(8
				(= cycles 8)
			)
			(9
				(khav cycleSpeed: 1 setCycle: Beg self)
				(guard setCycle: Beg setMotion: MoveTo 26 123)
			)
			(10
				(hideS cue:)
				(guard stopUpd:)
				(khav setScript: snoreS)
				(self dispose:)
			)
		)
	)
)

(instance getUpS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(khav setScript: 0 setLoop: 3 setCycle: CT 2 1 self)
			)
			(1
				(= cycles 8)
			)
			(2
				(khav setPri: 4 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(guard
					view: 410
					setLoop: 4
					setCycle: End self
					posn: 17 126
					setMotion: MoveTo 9 140
				)
			)
			(4
				(EgoDead 1 410 26 #title {A man who enjoys his work}) ; "The guard quickly calls in other guards, and you are overwhelmed. Khaveen then takes a sword and personally makes certain you'll never steal again. The last thing you see is the smile on Khaveen's face."
			)
		)
	)
)

(instance snoreS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(khav setLoop: 0 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(= cycles 4)
			)
			(2
				(khav setCycle: Beg self)
			)
			(3
				(= cycles (Random 30 40))
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance hideS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= hidden 1)
				(gEgo view: 47 setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				(DontTalk 0)
			)
			(2
				(= hidden 0)
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo)
				(HandsOn 1)
				(self dispose:)
			)
		)
	)
)

(instance guard of Talker
	(properties
		x 26
		y 123
		description {the guard}
		lookStr {The guard, hidden by the shadows, appears alert despite the late hour.}
		yStep 3
		view 410
		loop 4
		illegalBits 0
		xStep 4
		tLoop -1
		myName '//guard,man'
		title {Guard:}
		color 15
		back 8
	)
)

(instance khav of Talker
	(properties
		x 145
		y 138
		noun '/khaveen'
		description {the sleeping man}
		lookStr {The man asleep within the bed looks vaguely familiar.}
		view 415
		loop 1
		cycleSpeed 1
		illegalBits 0
		tLoop -1
		myName '//man,khaveen,nap'
		title {Khaveen:}
		color 7
		back 0
	)

	(method (calmMe)
		(= calmed 1)
	)

	(method (hurtMe)
		(= hitKhaveen 1)
		(return 1)
	)
)

(instance cabinet of PicView
	(properties
		x 64
		y 139
		noun '/armoire'
		description {the antique cabinet}
		lookStr {The cabinet is old, but well built.}
		view 410
		loop 1
		priority 2
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(cond
					((not (and (< (gEgo x:) 76) (< (gEgo y:) 151)))
						(NotClose)
					)
					((door cel:)
						(AlreadyDone)
					)
					(doorLocked
						(HighPrint 410 28) ; "The cabinet door is locked."
					)
					((not hingesOiled)
						(NoiZdoor)
					)
					(else
						(gEgo setScript: openDoorS)
					)
				)
			)
			(3
				(cond
					((not (and (< (gEgo x:) 76) (< (gEgo y:) 151)))
						(NotClose)
					)
					((not (door cel:))
						(HighPrint 410 29) ; "The cabinet door is closed."
					)
					(else
						(gEgo setScript: closeDoorS)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bird of TargActor
	(properties
		x 67
		y 102
		noun '/bird,statue,falcon'
		description {the bird statue}
		lookStr {The statue of a bird is intricately carved from some sort of dark crystal.}
		view 410
		loop 2
		priority 3
		signal 6160
		cycleSpeed 1
	)

	(method (fetchMe)
		(cond
			((and (> (gEgo x:) 168) (< (gEgo y:) 178))
				(HighPrint 410 30) ; "Your spell has no effect after passing through the bed's veils."
			)
			((not (door cel:))
				(HighPrint 410 31) ; "You can't Fetch the cabinet."
			)
			(else
				(HighPrint 410 32) ; "The black bird is too heavy to Fetch. You wonder what it could be made of that would make it so heavy."
			)
		)
		(return 0)
	)

	(method (openMe)
		(cond
			((door cel:)
				(HighPrint 410 33) ; "The door is already open."
			)
			((and (> (gEgo x:) 168) (< (gEgo y:) 178))
				(HighPrint 410 30) ; "Your spell has no effect after passing through the bed's veils."
			)
			(else
				(door setCycle: End)
				(if (not hingesOiled)
					(NoiZdoor)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(cond
				([gInvNum 47] ; Bird
					(HighPrint 410 34) ; "You already have the statue of the bird."
				)
				((not (and (< (gEgo x:) 76) (< (gEgo y:) 151)))
					(NotClose)
				)
				((not (door cel:))
					(HighPrint 410 35) ; "The door to the cabinet is not open."
				)
				(else
					(door setScript: getBirdS)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance door of TargActor
	(properties
		x 51
		y 120
		noun '/door'
		description {the door to the cabinet}
		lookStr {There is nothing special about the cabinet door.}
		view 410
		loop 3
		priority 4
		signal 16400
		cycleSpeed 1
		illegalBits 0
	)

	(method (openMe)
		(cond
			(cel
				(HighPrint 410 33) ; "The door is already open."
			)
			((and (> (gEgo x:) 168) (< (gEgo y:) 178))
				(HighPrint 410 30) ; "Your spell has no effect after passing through the bed's veils."
			)
			(else
				(door setCycle: End)
				(if (not hingesOiled)
					(NoiZdoor)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(cond
					((not (and (< (gEgo x:) 76) (< (gEgo y:) 151)))
						(NotClose)
					)
					((door cel:)
						(AlreadyDone)
					)
					(doorLocked
						(HighPrint 410 28) ; "The cabinet door is locked."
					)
					((not hingesOiled)
						(NoiZdoor)
					)
					(else
						(gEgo setScript: openDoorS)
					)
				)
			)
			(3
				(cond
					((not (and (< (gEgo x:) 76) (< (gEgo y:) 151)))
						(NotClose)
					)
					((not (door cel:))
						(HighPrint 410 29) ; "The cabinet door is closed."
					)
					(else
						(gEgo setScript: closeDoorS)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance win of Feature
	(properties
		x 232
		y 123
		z 62
		noun '/window'
		nsTop 38
		nsLeft 211
		nsBottom 85
		nsRight 253
		description {the window}
		lookStr {The window you came through looks out onto the plaza.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(HighPrint 410 36) ; "The window is always open. The climate here is always hot."
			)
			(3
				(HighPrint 410 36) ; "The window is always open. The climate here is always hot."
			)
			(8
				(if (> (gEgo x:) 200)
					(gCurRoom setScript: outWinS)
				else
					(NotClose)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sofa of PicView
	(properties
		x 230
		y 130
		noun '/couch'
		description {the divan}
		lookStr {The divan looks very stylish and uncomfortable.}
		view 410
		loop 5
		priority 3
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(if (> (gEgo x:) 200)
					(gCurRoom setScript: outWinS)
				else
					(NotClose)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bed of Feature
	(properties
		x 149
		y 135
		noun '/bed'
		nsTop 122
		nsLeft 91
		nsBottom 148
		nsRight 208
		description {the bed}
		lookStr {The bed is covered with pillows of various colors.}
	)
)

(instance curtains of Feature
	(properties
		x 149
		y 102
		noun '/curtain'
		nsTop 57
		nsLeft 86
		nsBottom 148
		nsRight 202
		description {the bed curtains}
		lookStr {The bed curtains make it difficult to see the sleeping figure.}
	)
)

(instance weap1 of Feature
	(properties
		x 41
		y 157
		noun '/weapon,wall'
		nsTop 125
		nsBottom 189
		nsRight 83
		description {the weapons on the wall}
		lookStr {Well-worn weapons line the walls, suggesting that their owner enjoys their use.}
	)

	(method (onMe theObjOrX theY &tmp oX oY)
		(if (IsObject theObjOrX)
			(= oX (theObjOrX x:))
			(= oY (theObjOrX y:))
		else
			(= oX theObjOrX)
			(= oY theY)
		)
		(return
			(or
				(and (<= nsLeft oX nsRight) (<= nsTop oY nsBottom))
				(and (<= 243 oX 320) (<= 141 oY 190))
				(and (<= 283 oX 299) (<= 98 oY 143))
			)
		)
	)
)

(instance tassle of Feature
	(properties
		x 142
		y 135
		z 53
		noun '/tassel'
		nsTop 74
		nsLeft 136
		nsBottom 91
		nsRight 148
		description {the decorative tassel}
		lookStr {It is just a decorative tassel.}
	)
)

(instance myVerbs of VerbMessager
	(properties
		ssLook 'look,look>'
		ssOpen 'open,open>'
		ssClose 'close,close>'
		ssSmell 'smell>'
		ssMove 'move>'
		ssEat 'eat,eat>'
		ssGet 'get,get,grab,(lockpick<up)>'
		ssClimb 'climb,climb>'
		ssTalk 'talk,talk,talk>'
	)
)

