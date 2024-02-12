;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use n101)
(use n104)
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
	rm14 0
	bear 1
	bearUp 2
)

(local
	local0
	local1
	local2
	local3
	local4
	local5 = 6
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	[local17 11] = [253 295 149 226 284 319 93 152 223 29 65]
	[local28 11] = [101 64 19 164 152 103 91 61 58 130 54]
	[local39 5] = [144 249 283 88 165]
	[local44 5] = [184 221 219 201 168]
	local49
	[local50 4] = [146 124 319 189]
)

(procedure (localproc_0)
	(if (< (gEgo x:) (bear x:))
		(= local1 110)
		(= local2 40)
	else
		(= local1 20)
		(= local2 12)
	)
)

(procedure (localproc_1)
	(= local11 (- (bear x:) (gEgo x:)))
	(= local12 (- (bear y:) (gEgo y:)))
	(= local13 (+ (gEgo x:) (* local11 30)))
	(= local14 (+ (gEgo y:) (* local12 30)))
)

(instance magicHit of Sound
	(properties
		number 45
		priority 1
	)
)

(instance egoShoots of Sound
	(properties
		number 33
		priority 2
	)
)

(instance rm14 of Rm
	(properties
		picture 14
		style 3
		east 15
		south 13
	)

	(method (dispose)
		(SetFlag 4)
		(super dispose:)
	)

	(method (init)
		(if (not (IsFlag 161))
			(LoadMany rsVIEW 420 516 15 510)
			(= global333 133)
			(= global332 420)
		)
		(Load rsSOUND 20)
		(super init:)
		(if (== gEgoGait 1) ; running
			(EgoGait 0 0) ; walking
		)
		(if (or (!= gPrevRoomNum 15) (== (gContMusic state:) 0))
			(gContMusic priority: 1 number: 20 loop: -1 play:)
		)
		(if (not (IsFlag 161))
			(if (gEgo knows: 23) ; flameDartSpell
				(egoShoots number: (SoundFX 33) init:)
				(magicHit number: (SoundFX 45) init:)
			)
			(dart init: stopUpd:)
			(puff init: stopUpd:)
			(bear ignoreActors: init: setPri: 11 stopUpd:)
		)
		(drip init: setScript: dripScript)
		(= local49 (Random 0 4))
		(SL enable:)
		(NormalEgo)
		(gEgo init:)
		(if (not (IsFlag 161))
			(gEgo illegalBits: -16384)
		)
		(switch gPrevRoomNum
			(15
				(gEgo posn: 318 145 setMotion: MoveTo 308 151)
				(= local1 20)
				(= local2 12)
			)
			(else
				(gEgo setScript: entranceMsg)
				(= local1 110)
				(= local2 40)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evSAID
				(clr)
				(cond
					((Said 'look,look>')
						(cond
							((Said '/stalactite')
								(HighPrint 14 0) ; "They're like stalagmites, but they go the other way."
							)
							((Said '/stalagmite')
								(HighPrint 14 1) ; "They're like stalactites, but they go the other way."
							)
							((Said '[<at,around][/!*,cave,room]')
								(HighPrint 14 2) ; "The cavern contains some impressive formations and is rather beautiful, as caves go."
							)
							((Said '/wall,fungus,north,west,formation')
								(HighPrint 14 3) ; "The stalactites, stalagmites, and cave walls glow from a phosphorescent fungus growing there."
							)
							((or (Said '<up') (Said '/ceiling'))
								(HighPrint 14 4) ; "The stalactites grow slowly."
								(HighPrint 14 5) ; "...or are they stalagmites?"
							)
							((or (Said '<down') (Said '/floor'))
								(HighPrint 14 6) ; "The stalagmites grow slowly."
								(HighPrint 14 7) ; "...or are they stalactites?"
							)
							((Said '/south,entrance,open,open,open')
								(HighPrint 14 8) ; "The light from outside illuminates the cave opening."
							)
							((Said '/east')
								(HighPrint 14 9) ; "Beyond the bear, the cave seems to continue. The bear blocks the way."
							)
							((Said '/baron')
								(HighPrint 14 10) ; "The baron's in his castle."
							)
							((Said '/barnard,man')
								(if (IsFlag 161)
									(HighPrint 14 11) ; "There is no sign of the Baronet or the bear."
								else
									(HighPrint 14 12) ; "You don't see any people -- just that bear."
								)
							)
							((Said '/bear,animal,creature,monster')
								(cond
									((IsFlag 161)
										(HighPrint 14 11) ; "There is no sign of the Baronet or the bear."
									)
									((or local9 (IsFlag 160))
										(HighPrint 14 13) ; "The bear appears docile for the time being."
									)
									(local8
										(HighPrint 14 14) ; "Stunned, the bear is temporarily frozen."
									)
									(local6
										(HighPrint 14 15) ; "Although looking somewhat scorched, the bear is still very dangerous."
									)
									((or (== local0 0) (== local0 2))
										(HighPrint 14 16) ; "On one side of this cavern is a creature which looks like a large bear."
									)
									(else
										(HighPrint 14 17) ; "The bear looks menacing and angry. There is something attached to its leg."
									)
								)
							)
							((Said '/leg,chain,manacle,feet,hasp,hasp,lock')
								(= local4 (gEgo distanceTo: bear))
								(cond
									((IsFlag 161)
										(HighPrint 14 18) ; "There is no sign of the bear or his chains."
									)
									((>= local4 local1)
										(HighPrint 14 19) ; "You can't see very well."
									)
									(else
										(HighPrint 14 20) ; "There is a manacle and chain attached to the bear's leg."
									)
								)
							)
							(else
								(HighPrint 14 21) ; "I just don't know what to tell you."
							)
						)
					)
					((Said 'get,get>')
						(cond
							((Said '/fungus')
								(HighPrint 14 22) ; "The fungus is slimy and stuck tight to the cave walls."
							)
							((Said '/bear,stalactite,stalagmite')
								(HighPrint 14 23) ; "You're kidding, right?"
							)
							((and (not (IsFlag 161)) (Said '/dagger,dagger'))
								(HighPrint 14 24) ; "Better not. You might make the bear angry."
							)
						)
					)
					((Said 'throw/dagger,dagger')
						(++ local7)
						(ThrowKnife (if (IsFlag 161) 0 else bear))
						(ClearFlag 160)
						(= local9 0)
					)
					((Said 'throw/boulder')
						(HighPrint 14 25) ; "That won't help you."
					)
					((Said 'japaneseclimbup,climb,climb')
						(HighPrint 14 26) ; "The walls are too slimy to climb."
					)
					((Said 'cast>')
						(= temp0 (SaidSpell event))
						(if (CastSpell temp0)
							(switch temp0
								(18
									(if (IsFlag 161)
										(HighPrint 14 27) ; "There is no magic in the cave."
									else
										(HighPrint 14 28) ; "There is an aura of magic throughout the cavern. It seems to center on the bear."
									)
								)
								(20
									(cond
										((IsFlag 161)
											(HighPrint 14 29) ; "There is no point to that."
										)
										((CastDazzle)
											(= local8 1)
										)
									)
								)
								(23
									(if (IsFlag 161)
										(HighPrint 14 29) ; "There is no point to that."
									else
										(ClearFlag 160)
										(= local9 0)
										(dart setScript: flameDart)
									)
								)
								(22
									(cond
										((IsFlag 161)
											(HighPrint 14 29) ; "There is no point to that."
										)
										((CastCalm)
											(= local9 1)
											(SolvePuzzle 646 5)
										)
									)
								)
								(17
									(if (IsFlag 161)
										(HighPrint 14 29) ; "There is no point to that."
									else
										(HighPrint 14 30) ; "The magic about the bear's manacle is too great for your Open spell."
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
		)
		(super handleEvent: event)
	)
)

(instance dart of Act
	(properties
		z 25
		view 522
		illegalBits 0
	)
)

(instance puff of Prop
	(properties
		z 25
		view 522
		loop 3
	)
)

(instance bear of TargActor
	(properties
		y 144
		x 273
		view 420
		targDeltaY -5
	)

	(method (getHurt param1)
		(cond
			((<= (-= global333 param1) 0)
				(SetFlag 169)
				(gCurRoom newRoom: 171) ; rmBear
			)
			((or (== local0 0) (== local0 2))
				(bear setScript: bearUp)
			)
			(else
				(bear setLoop: 1 cel: 0 setCycle: End)
			)
		)
	)

	(method (doit)
		(= local4 (gEgo distanceTo: self))
		(if (and local7 (== gPrevRoomNum 15))
			(localproc_0)
		)
		(cond
			((or local3 (== local0 4) (== local0 5)))
			(local8
				(if (== (-- local8) 0)
					(bear startUpd:)
				else
					(localproc_0)
				)
			)
			((or (IsFlag 160) local9)
				(localproc_0)
				(if (or (== local0 3) (== local0 1))
					(bear setScript: bearDrop)
				)
			)
			((> local4 local1)
				(if (not local7)
					(switch local0
						(1
							(bear setScript: bearDrop)
						)
						(3
							(bear setScript: bearDrop)
						)
					)
				)
			)
			((>= local1 local4 local2)
				(if (and (not local7) (== local0 0))
					(bear setScript: bearUp)
				)
			)
			((> (+ (gEgo y:) 15) (bear y:))
				(cond
					((< (gEgo x:) (- (bear x:) 15))
						(if (not local3)
							(++ local3)
							(bear setScript: bearKills)
						)
					)
					((not local3)
						(++ local3)
						(bear setScript: bearKillsRm15)
					)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'pat/bear,animal')
						(HighPrint 14 31) ; "You'd better not. The bear isn't wearing a flea collar."
					)
					((Said 'talk,talk/bear,animal')
						(if (IsFlag 312)
							(HighPrint 14 32) ; "Hi there! I represent Ditto Realty. We have some LOVELY properties that are PROVEN bargains. We know that's true, because we've sold them so many times."
						else
							(SetFlag 312)
							(HighPrint 14 33) ; "You know that bears can't talk!"
						)
					)
					(
						(or
							(Said 'feed/bear')
							(Said 'give,throw/food,ration[/bear,creature]')
						)
						(cond
							(local7
								(HighPrint 14 34) ; "The Flame Dart has spoiled the bear's appetite."
							)
							((gEgo has: 3) ; food
								(if
									(not
										(and
											(> (gEgo x:) 180)
											(> (gEgo y:) 132)
										)
									)
									(NotClose)
								else
									(gEgo use: 3) ; food
									(HighPrint 14 35) ; "Its hunger diminished, the bear takes a new attitude toward you."
									(SetFlag 160)
									(SolvePuzzle 646 5)
								)
							)
							(else
								(DontHave)
							)
						)
					)
					((Said 'kill,cut,hit,attack')
						(gCurRoom newRoom: 420) ; bearArena
					)
					(
						(or
							(Said
								'free,free,unlock,open,open,open/bear,animal,creature,hasp,hasp,lock,chain,manacle'
							)
							(Said 'use/key')
							(Said
								'put,fill<in/key/hasp,hasp,lock,chain,manacle'
							)
						)
						(cond
							((not (gEgo has: 5)) ; key
								(HighPrint 14 36) ; "You need to find the key."
							)
							(
								(not
									(gEgo
										inRect:
											[local50 0]
											[local50 1]
											[local50 2]
											[local50 3]
									)
								)
								(NotClose)
							)
							((or local8 local9 (IsFlag 160))
								(SolvePuzzle 647 25)
								(self setScript: useKey)
							)
							(else
								(HighPrint 14 37) ; "The bear won't let you near the lock."
							)
						)
					)
					((Said 'pick,lockpick/hasp,hasp,lock,manacle,chain')
						(HighPrint 14 38) ; "Sorry, this lock is enchanted. You'll need a magical key."
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance drip of Prop
	(properties
		y 204
		x 79
		view 15
	)
)

(instance entranceMsg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 57 189 setMotion: MoveTo 60 178)
				(= cycles 15)
			)
			(1
				(gEgo loop: 0)
				(= cycles 5)
			)
			(2
				(if (and (not (IsFlag 161)) (not (IsFlag 149)))
					(HighPrint 14 39) ; "As your eyes adjust from sunlight to darkness, you examine the interior of this eerie cavern. You sense something moving off to your right."
					(SetFlag 149)
				)
				(HandsOn)
			)
		)
	)
)

(instance bearUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(= local0 1)
				(bear setCycle: End self)
			)
			(1
				(if (and (not local7) (not (IsFlag 167)))
					(HighPrint 14 40) ; "A very large bear rears up as you approach. It looks hungry and dangerous."
					(SetFlag 167)
				)
				(= local0 3)
			)
		)
	)
)

(instance bearDrop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local0 1)
					(= local0 2)
					(bear setCycle: Beg self)
				else
					(= local0 2)
					(bear setLoop: 0 cel: local5 setCycle: Beg self)
				)
			)
			(1
				(= local0 0)
			)
		)
	)
)

(instance flameDart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ local7)
				(TrySkill 16 0 5) ; mana
				(TrySkill 23 0 5) ; flameDartSpell
				(gEgo
					view: 522
					setLoop: (if (< (gEgo x:) (bear x:)) 0 else 1)
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(egoShoots play:)
				(gEgo setCycle: End)
				(= local10 (Random 0 300))
				(= local4 (gEgo distanceTo: bear))
				(if (or (< local10 local4) (== local0 1) (== local0 2))
					(dart setScript: bouncer)
					(self changeState: 3)
				else
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
					(++ local6)
					(dart
						setMotion:
							MoveTo
							(+ (bear x:) (- (Random 0 10) 10))
							(+ (bear y:) (- (Random 0 17) 19))
							self
					)
					(bear getHurt: (+ 5 (/ [gEgoStats 0] 10))) ; strength
				)
			)
			(2
				(magicHit play:)
				(dart setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(NormalEgo)
				(gEgo illegalBits: -16384)
				(LookAt gEgo bear)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bouncer of Script
	(properties)

	(method (doit)
		(if (and local15 (not (dart inRect: 10 35 310 205)))
			(= local15 0)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local16 (Random 3 5))
				(dart posn: (gEgo x:) (gEgo y:))
				(self cue:)
			)
			(1
				(= local15 1)
				(localproc_1)
				(dart
					show:
					setLoop: 2
					setStep: 18 12
					setPri: 12
					ignoreActors:
					setCycle: Fwd
					startUpd:
					setMotion: MoveTo local13 local14
				)
			)
			(2
				(puff
					ignoreActors:
					cel: 0
					setPri: 12
					posn: (dart x:) (dart y:)
					setCycle: End
				)
				(+= local16 (Random 1 3))
				(dart
					setMotion: MoveTo [local17 local16] [local28 local16] self
				)
			)
			(3
				(if (< local16 10)
					(self changeState: 2)
				else
					(self cue:)
				)
			)
			(4
				(dart setLoop: 3 cel: 0 setMotion: 0 setCycle: End self)
			)
			(5
				(dart setScript: 0)
			)
		)
	)
)

(instance bearKills of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 3)
			)
			(1
				(bear loop: 2 cel: 0 setCycle: End)
				(= cycles 1)
			)
			(2
				(bear loop: 3 cel: 0 setCycle: End)
				(gEgo
					view: 516
					loop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(= cycles 12)
			)
			(4
				(EgoDead ; "Boy, that smarts! Your last thoughts, although trivial, gently nudge you toward infinity. "I wonder if the bear's paws were clean..........""
					14
					41
					80
					{OH NOOOOOOO!}
					82
					800
					0
					0
				)
			)
		)
	)
)

(instance bearKillsRm15 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors: 1
					setMotion: MoveTo 235 (gEgo y:) self
				)
			)
			(1
				(bear loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(bear loop: 3 cel: 0 setCycle: End)
				(gEgo
					view: 516
					loop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(= cycles 15)
			)
			(4
				(EgoDead ; "Boy, that smarts! Your last thoughts, although trivial, gently loft you toward infinity. "I wonder if the bear's paws were clean..........""
					14
					42
					80
					{OH NOOOOOOO!}
					82
					800
					0
					0
				)
			)
		)
	)
)

(instance useKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo use: 5) ; key
				(HandsOff)
				(= local0 5)
				(bear setCycle: End self)
			)
			(1
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 209 149 self
				)
			)
			(2
				(bear stopUpd:)
				(gEgo setMotion: MoveTo (- (bear x:) 22) (bear y:) self)
			)
			(3
				(gEgo view: 510 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(HighPrint 14 43) ; "The Kobold's key disappears as you turn it in the lock."
				(gContMusic stop:)
				(NormalEgo)
				(SetFlag 170)
				(gCurRoom newRoom: 171) ; rmBear
			)
		)
	)
)

(instance dripScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(drip posn: [local39 local49] [local44 local49] setCycle: End)
				(= cycles (Random 20 40))
			)
			(1
				(= local49 (Random 0 4))
				(self changeState: 0)
			)
		)
	)
)

