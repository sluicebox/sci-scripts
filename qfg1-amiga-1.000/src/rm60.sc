;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use n100)
(use n101)
(use n102)
(use n106)
(use Interface)
(use LoadMany)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm60 0
)

(local
	local0
	local1
	[local2 8]
	[local10 8]
	[local18 8]
	local26
	local27
	local28
	local29
	local30
	local31
	local32 = -1
	local33
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	local44
	local45
	local46
	local47 = 25
	[local48 8] = [11 8 10 6 9 7 11 6]
	[local56 16] = [41 167 65 135 104 157 130 114 180 146 212 125 243 167 269 114]
	[local72 8] = [3 0 2 4 6 7 5 1]
	[local80 16] = [160 105 71 158 134 148 209 137 273 159 299 105 242 117 95 127]
	[local96 4] = [{some fruit} {a baby meep} {some green fur} {a magic spell scroll}]
	[local100 200]
	local300
	local301
)

(procedure (localproc_0 param1)
	(Print &rest #at -1 2 #width 0 #mode 1 #window meepWin #dispose #time param1)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(= [local2 temp0] (Clone aMeep))
		(= [local18 temp0] (Clone anEye))
		(= [local10 temp0] (Clone aMeepScript))
		([local2 temp0]
			setLoop: 5
			cel: 0
			setPri: (+ 1 [local48 temp0])
			posn: [local56 (* temp0 2)] (- [local56 (+ (* temp0 2) 1)] 4)
			init:
			stopUpd:
			setScript: [local10 temp0] 0 temp0
		)
		([local18 temp0]
			setLoop: 3
			cel: 0
			setPri: (+ 1 [local48 temp0])
			z: 1
			posn: [local56 (* temp0 2)] (- [local56 (+ (* temp0 2) 1)] 17)
			init:
			stopUpd:
			hide:
		)
	)
)

(instance bossBlock of Blk
	(properties
		top 104
		left 117
		bottom 120
		right 144
	)
)

(instance aMeep of Act
	(properties
		view 60
		loop 5
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) evMOUSEBUTTON) (MouseClaimed self event 3))
				(cond
					((not (script state:))
						(HighPrint 60 0) ; "This large rock covers a Meep hole."
					)
					((== loop 0)
						(HighPrint 60 1) ; "A furry blue Meep"
					)
					((== loop 1)
						(HighPrint 60 2) ; "A furry purple Meep"
					)
					((== loop 2)
						(HighPrint 60 3) ; "A furry green Meep"
					)
				)
			)
		)
	)
)

(instance anEye of Prop
	(properties
		view 60
		loop 3
		cycleSpeed 1
	)
)

(instance meepHead of Prop
	(properties
		view 61
		loop 3
	)
)

(instance bossRock of Act
	(properties
		yStep 5
		view 60
		loop 5
		illegalBits 0
		xStep 5
	)
)

(instance babyMeep of Act
	(properties
		z 2
		view 61
		loop 7
		illegalBits 0
	)
)

(instance greenFur of Act
	(properties
		z 2
		view 61
		loop 8
		illegalBits 0
	)
)

(instance spellScroll of Act
	(properties
		z 2
		view 61
		loop 5
		illegalBits 0
	)
)

(instance meepSound of Sound
	(properties
		number 55
		priority 1
	)
)

(instance babySound of Sound
	(properties
		number 74
		priority 2
	)
)

(instance thudSound of Sound
	(properties
		number 58
		priority 3
	)
)

(instance throwSound of Sound
	(properties
		number 31
		priority 3
	)
)

(instance meepWin of SysWindow
	(properties
		color 2
	)
)

(instance rm60 of Rm
	(properties
		picture 60
		style 0
		east 61
	)

	(method (dispose)
		(SetFlag 50)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 60 61 518 510 62)
		(LoadMany
			rsSOUND
			(SoundFX 55)
			(SoundFX 56)
			(SoundFX 57)
			(SoundFX 74)
			(SoundFX 58)
			(SoundFX 75)
			54
			(SoundFX 31)
		)
		(if (gEgo knows: 23) ; flameDartSpell
			(Load rsVIEW 522)
			(Load rsSCRIPT 100)
		)
		(super init:)
		(gContMusic fade:)
		(SL enable:)
		(NormalEgo)
		(gEgo
			posn: 318 176
			init:
			illegalBits: -32640
			observeBlocks: bossBlock
			setMotion: MoveTo 306 176
		)
		(= local0
			(switch gHowFast
				(0 2)
				(1 3)
				(2 4)
			)
		)
		(meepSound number: (SoundFX 55) init:)
		(babySound number: (SoundFX 74) init:)
		(thudSound number: (SoundFX 58) init:)
		(throwSound number: (SoundFX 31) init:)
		(localproc_1)
		(gDirHandler addToFront: self)
		(gMouseHandler addToFront: self)
	)

	(method (doit &tmp temp0)
		(= temp0 (GetTime 1)) ; SysTime12
		(if (!= local36 temp0)
			(= local36 temp0)
			(if (and local28 (not local29) (not (-- local43)))
				([local2 3] setScript: bossMad 0 0)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 local27)
		(= local27 1)
		(switch (event type:)
			(evSAID
				(cond
					(
						(or
							(Said
								'cut,hit,fight,kill,damage[/meep,creature,boulder]'
							)
							(Said 'use,draw/blade')
						)
						(cond
							(local35
								(HighPrint 60 4) ; "No way! Those Meeps are too fast and the rocks too hard for you to want to try that again!"
							)
							(
								(or
									(< (gEgo y:) 102)
									(and
										(< (gEgo y:) 119)
										(< (gEgo x:) 110)
									)
								)
								(HighPrint 60 5) ; "Try going over to where the Meeps are if you really want to hack them into little furry bits."
							)
							(else
								(= local35 1)
								(= local27 0)
								(= local300 1)
								(HandsOff)
								(gEgo setScript: killMeeps)
								(if local28
									([local2 3] setScript: bossMad killMeeps)
								else
									(killMeeps cue:)
								)
							)
						)
					)
					((Said 'cast>')
						(switch (= temp1 (SaidSpell event))
							(18
								(if (CastSpell temp1)
									(HighPrint 60 6) ; "You detect no other magic here."
								)
							)
							(20
								(if (CastSpell temp1)
									(= local35 1)
									(CastDazzle)
									(if local28
										([local2 3] setScript: bossMad)
									)
								)
							)
							(23
								(if (CastSpell temp1)
									(= local35 1)
									(if local28
										([local2 3] setScript: bossMad)
									)
									(CastDart 0)
								)
							)
							(17
								(if (CastSpell temp1)
									(HighPrint 60 7) ; "The Open spell only works on locks and small closed things."
								)
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'throw/dagger,dagger')
						(if (ThrowKnife 0)
							(= local35 1)
							(if local28
								([local2 3] setScript: bossMad)
							)
						)
					)
					((Said 'throw/boulder')
						(if (gEgo has: 21) ; boulder
							(= local35 1)
							(if local28
								([local2 3] setScript: bossMad)
							)
							(ThrowRock 0)
						else
							(HighPrint 60 8) ; "You don't have a rock"
						)
					)
					((Said 'lift,(lockpick<up),get,capture/boulder,meep')
						(gEgo setScript: liftRock)
					)
					((Said 'get>')
						(cond
							((Said '/fur[<green]')
								(if local46
									(if (== (gEgo onControl: 1) 16384)
										(gEgo setScript: getThing 0 2)
									else
										(HighPrint 60 9) ; "You can't get that from where you're standing."
									)
								else
									(HighPrint 60 10) ; "The Meeps would not appreciate it if you tried to take their fur -- the weather here is still very cold."
								)
							)
							((Said '/scroll,spell[<magic,spell,about]')
								(if local45
									(if (== (gEgo onControl: 1) 16384)
										(gEgo setScript: getThing 0 3)
									else
										(HighPrint 60 9) ; "You can't get that from where you're standing."
									)
								else
									(HighPrint 60 11) ; "You don't see a Spell Scroll here."
								)
							)
							((Said '/baby,(meep<baby)')
								(if local44
									(if (== (bouncyBaby state:) 0)
										(bouncyBaby seconds: 0 cue:)
									)
									(TimePrint 4 60 12) ; "The baby Meep is just too quick for you. Besides, they eat too much."
								else
									(HighPrint 60 13) ; "You don't see any baby Meeps at the moment."
								)
							)
							((Said '/apple,apple,core')
								(HighPrint 60 14) ; "You look at the apple cores, and quickly decide they are of no use to you. Besides, they look disgusting."
							)
						)
					)
					((Said 'look>')
						(= local27 temp0)
						(cond
							((Said '[<at,around][/!*,area,area,clearing]')
								(HighPrint 60 15) ; "You are in the Meeps' Peep. The colorful, furry Meeps timidly pop out of their holes from time to time."
							)
							((Said '/baby,(meep<baby)')
								(HighPrint 60 16) ; "The baby Meep sure is cute."
							)
							((Said '/(meep,creature,animal)<green')
								(if local35
									(HighPrint 60 17) ; "All of the Meeps are hiding deep within their holes. Your vicious attack has them terrified."
								else
									(HighPrint 60 18) ; "You realize that you have never seen more than one green Meep at a time. Perhaps there is only one."
								)
							)
							((Said '/(meep,creature,animal)<(magenta,blue)')
								(if local35
									(HighPrint 60 17) ; "All of the Meeps are hiding deep within their holes. Your vicious attack has them terrified."
								else
									(HighPrint 60 19) ; "There seems to be an abundant supply of blue and purple Meeps. If only they'd stay still for a moment, perhaps you could count them."
								)
							)
							((Said '/meep,creature,animal')
								(if local35
									(HighPrint 60 17) ; "All of the Meeps are hiding deep within their holes. Your vicious attack has them terrified."
								else
									(HighPrint 60 20) ; "You see blue Meeps, purple Meeps, and occasionally a green Meep. They seem to be very shy; whenever you approach one, it hides under its rock."
								)
							)
							((Said '/boulder,boulder')
								(HighPrint 60 21) ; "Large, heavy-looking rocks cover the many holes. The Meeps must be stronger than they look to lift these rocks so easily."
							)
							((Said '/chasm')
								(if local35
									(HighPrint 60 17) ; "All of the Meeps are hiding deep within their holes. Your vicious attack has them terrified."
								else
									(HighPrint 60 22) ; "You keep seeing differently-colored Meeps come out of each hole. They either lead to large underground caverns, or they are all connected under the earth."
								)
							)
							((Said '/bush,tree')
								(HighPrint 60 23) ; "The trees and bushes look much like those you've seen elsewhere in the valley."
							)
							((Said '/hill,hill')
								(HighPrint 60 24) ; "The mountains are very steep here."
							)
							((Said '/ground,down,grass')
								(HighPrint 60 25) ; "The meadow is covered with a light carpet of grass, broken up by the Meep holes."
							)
							((Said '/fur')
								(if local46
									(HighPrint 60 26) ; "There is a wad of bright green fur on the ground."
								else
									(HighPrint 60 27) ; "The Meeps have brightly-colored, soft-looking fur."
									(if (gEgo has: 27) ; green fur
										(event claimed: 0)
									)
								)
							)
							((Said '/scroll,spell')
								(cond
									(local45
										(HighPrint 60 28) ; "It looks like a Spell Scroll."
									)
									((IsFlag 228)
										(HighPrint 60 29) ; "The scroll is blank now, but once contained the Detect Magic spell."
									)
									(else
										(event claimed: 0)
									)
								)
							)
						)
					)
					((Said 'talk>')
						(= local43 30)
						(cond
							(local35
								(event claimed: 1)
								(HighPrint 60 30) ; "You can't talk to any of the Meeps. They are all hiding deep within their holes, terrified after your vicious attack."
							)
							(local28
								(event claimed: 1)
								(localproc_0 5 60 31) ; "Hey, just ask me about anything you want to know."
							)
							((== local1 0)
								(event claimed: 1)
								(HighPrint 60 32) ; "You don't see any Meeps to talk to at the moment."
							)
							(local33
								(event claimed: 1)
								([local2 3] setScript: bossRises)
							)
							(else
								(event claimed: 1)
								(self setScript: prepAsk)
							)
						)
					)
					((Said 'ask>')
						(= local30 1)
						(= local43 30)
						(cond
							((and local26 (not local28) (Said '/meep<green'))
								(= local30 0)
								([local2 3] setScript: bossRises)
							)
							((not local28)
								(= local30 0)
								(event claimed: 1)
								(cond
									(local33
										([local2 3] setScript: bossRises)
									)
									((== local1 0)
										(event claimed: 1)
										(HighPrint 60 32) ; "You don't see any Meeps to talk to at the moment."
									)
									(else
										(self setScript: prepAsk)
									)
								)
							)
							((Said '/boulder')
								(localproc_0 5 60 33) ; "We use rocks for doors. They keep us dry and warm."
							)
							((Said '/meep,creature,animal')
								(localproc_0 5 60 34) ; "We are happy Meeps, living in our happy holes. Don't worry. Be happy!"
							)
							((Said '/apple,apple,stuff,junk')
								([local2 3] setScript: throwThings 0 0)
							)
							((Said '/fur<green')
								(if local46
									(localproc_0 5 60 35) ; "Hey, go ahead, take it. It's yours."
								else
									([local2 3] setScript: throwThings 0 2)
								)
							)
							((Said '/fur')
								(localproc_0 7 60 36) ; "Hey, like fur is good stuff, keeps us warm. Mine's the best -- it's like green, you know?"
							)
							((Said '/scroll,spell,magic,detect')
								(if local45
									(localproc_0 5 60 35) ; "Hey, go ahead, take it. It's yours."
								else
									([local2 3] setScript: throwThings 0 3)
								)
							)
							(else
								(= local30 0)
								(event claimed: 1)
								(localproc_0 5 60 37) ; "Gee, boss, I really don't know much about that at all. Hey, sorry."
							)
						)
						(if local30
							(SolvePuzzle 680 1)
						)
					)
				)
			)
			(evKEYBOARD
				(= local27 temp0)
			)
			(evMOUSEBUTTON
				(if (& (event modifiers:) emSHIFT)
					(= local27 temp0)
					(if (MouseClaimed gEgo event 3)
						(HighPrint 60 38) ; "Why, that's me!"
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance aMeepScript of Script
	(properties)

	(method (doit)
		(if (and (== state 2) local27 (<= (gEgo distanceTo: client) 80))
			(= cycles 1)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles (Random 20 150))
			)
			(1
				(cond
					((and local28 (== gHowFast 0))
						(self changeState: 0)
					)
					((>= local1 local0)
						(self changeState: 0)
					)
					(local35
						(self changeState: 0)
					)
					((and local27 (<= (gEgo distanceTo: client) 80))
						(self changeState: 0)
					)
					(else
						(++ local1)
						(if (== register 3)
							(= local26 1)
							(= temp0 2)
						else
							(= temp0 (Random 0 1))
						)
						(client
							posn: (client x:) (+ (client y:) 4)
							setPri: [local48 register]
							setLoop: temp0
							setCel: -1
							cel: 0
							setCycle: End
						)
						(= cycles 2)
					)
				)
			)
			(2
				([local18 register]
					setLoop: (+ 3 (Random 0 1))
					show:
					setCycle: Fwd
				)
				(if (!= register local32)
					(= cycles (Random 5 20))
				)
				(meepSound number: (SoundFX (+ (Random 0 2) 55)) play:)
			)
			(3
				([local18 register] setCycle: 0 stopUpd: hide:)
				(client setCycle: Beg self)
			)
			(4
				(meepSound stop:)
				(client
					posn: (client x:) (- (client y:) 4)
					setPri: (+ 1 [local48 register])
					setLoop: 5
					setCel: 0
					stopUpd:
				)
				(if (== register 3)
					(= local26 0)
				)
				(-- local1)
				(self changeState: 0)
			)
		)
	)
)

(instance killMeeps of Script
	(properties)

	(method (init)
		(super init: &rest)
		(self setScript: hackMeep)
		(EgoGait 1 0) ; running
		(= local31 0)
		(= local34
			(switch gHowFast
				(0 4)
				(1 8)
				(2 16)
			)
		)
		(HandsOff)
		(gEgo ignoreBlocks: bossBlock)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= cycles 2)
			)
			(2
				(HandsOff)
				(= local35 0)
				(++ local0)
				(= local32 [local72 (/ local31 2)])
				([local10 local32] changeState: 1)
				(-- local0)
				(= local35 1)
				(= cycles 2)
			)
			(3
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion:
						MoveTo
						[local80 local31]
						[local80 (+ local31 1)]
						self
				)
			)
			(4
				(script cue:)
			)
			(5
				(if (>= (+= local31 2) local34)
					(self cue:)
				else
					(self changeState: 2)
				)
			)
			(6
				(= local32 -1)
				(EgoGait 0 0) ; walking
				(gEgo ignoreActors: 0 illegalBits: -32640 loop: 2)
				(= seconds 2)
			)
			(7
				(gEgo observeBlocks: bossBlock)
				(= local300 0)
				(HandsOn)
				(HighPrint 60 39) ; "Man, those rocks are tough!"
				(client setScript: 0)
			)
		)
	)
)

(instance hackMeep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo view: 518 setLoop: 2 cel: 0 setCycle: End self)
			)
			(2
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
				([local10 local32] changeState: 2 seconds: 0 cycles: 3)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(NormalEgo)
				(= state 0)
				(client cue:)
			)
		)
	)
)

(instance prepAsk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local35 1)
				(= seconds 2)
			)
			(1
				(meepSound number: (SoundFX 75) loop: -1 play:)
				(TimePrint 7 60 40) ; "You hear squeaky muttering from beneath the ground. It seems the Meeps are having quite a discussion about you."
				(= seconds 7)
			)
			(2
				(meepSound stop: loop: 1)
				([local2 3] setScript: bossRises)
				(client setScript: 0)
			)
		)
	)
)

(instance bossRises of Script
	(properties)

	(method (init)
		(= local28 1)
		(super init: &rest)
	)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(= temp0 (client x:))
		(= temp1 (client y:))
		(= temp2 (client priority:))
		(switch (= state newState)
			(0
				(HandsOff)
				(= local43 30)
				(= local35 1)
				([local18 3] setCycle: 0 stopUpd: hide:)
				(client
					view: 61
					setLoop: 2
					cel: 0
					setPri: -1
					setCycle: End
					setMotion: MoveTo 130 119 self
				)
				(if (not local39)
					(bossRock init:)
					(= local39 1)
				)
				(thudSound number: 54 play:)
				(bossRock
					ignoreActors: 1
					setLoop: 5
					cel: 0
					posn: 130 94
					setCycle: Fwd
					setPri: 8
					setMotion: MoveTo 140 54 self
				)
			)
			(2
				(client setLoop: 1 cel: 0 setPri: 8 cycleSpeed: 2 setCycle: Fwd)
				(bossRock setMotion: MoveTo 145 114 self)
				(if (or local33 (IsFlag 305))
					(localproc_0 4 60 41) ; "Hiya, hiya. Nice to seeya 'gain."
				else
					(localproc_0 4 60 42) ; "Hiya, hiya. Really pleased to meetcha."
					(SetFlag 305)
					(= local33 1)
				)
			)
			(3
				(thudSound number: (SoundFX 58) play:)
				(bossRock setCycle: 0 setCel: 0 setPri: -1 stopUpd:)
				(= cycles 6)
			)
			(4
				(client setCycle: 0 cel: 3 stopUpd:)
				(if (not local40)
					(meepHead init:)
					(= local40 1)
				)
				(meepHead posn: 130 110 z: 1 setPri: 8 setCycle: Fwd)
				(= seconds 2)
			)
			(5
				(meepHead setCycle: 0 stopUpd:)
				(= local43 30)
				(= local35 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance bossHides of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local40
					(= local40 0)
					(meepHead dispose:)
				)
				([local2 3]
					setLoop: 2
					cel: 0
					setPri: -1
					setCycle: CT 2 1
					setMotion: MoveTo 130 114 self
				)
			)
			(1
				([local2 3] setPri: [local48 3])
				(= seconds 3)
			)
			(2
				([local2 3] setLoop: 0 cel: 0 posn: 130 127)
				(client setScript: 0)
			)
		)
	)
)

(instance bossReturns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				([local2 3]
					posn: 130 114
					setLoop: 2
					cel: 2
					setPri: -1
					setCycle: CT 0 -1
					setMotion: MoveTo 130 119 self
				)
			)
			(1
				(if (not local40)
					(meepHead init:)
					(= local40 1)
				)
				(meepHead posn: 130 110 z: 1 setPri: 8 setCycle: Fwd)
				([local2 3] setPri: 8 setLoop: 1 cel: 0 stopUpd:)
				(if local301
					(localproc_0 4 60 43) ; "Hey, there ya go. Hope it helps ya."
					(= local301 0)
				else
					(localproc_0 4 60 44) ; "Hey, sorry I couldn't help ya."
				)
				(= seconds 4)
			)
			(2
				(meepHead setCycle: 0 stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance throwObj of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 [temp3 2])
		(switch (= state newState)
			(0
				(throwSound play:)
				(= temp2 (Random 85 235))
				(= temp0 (+ 130 (SinMult temp2 local47)))
				(= temp1 (- 120 (CosMult temp2 local47)))
				(switch register
					(0
						((= local38 (Act new:)) view: 61 setLoop: 6)
					)
					(1
						(= local44 1)
						(= local38 babyMeep)
					)
					(2
						(= local301 (= local46 1))
						(= local38 greenFur)
					)
					(3
						(= local301 (= local45 1))
						(= local38 spellScroll)
					)
				)
				([local2 3] setCel: 1)
				(local38
					setLoop: (local38 loop:)
					cel: 0
					setPri: 7
					ignoreActors:
					illegalBits: 0
					posn: 133 110
					init:
					setCycle: 0
					setMotion: MoveTo temp0 temp1 self
				)
				(if (!= register 2)
					(local38 setCycle: Fwd)
				)
			)
			(1
				(local38 setCycle: 0 stopUpd:)
				(switch register
					(0
						(local38 addToPic:)
					)
					(1
						(babyMeep setScript: bouncyBaby)
					)
				)
				([local2 3] setCel: 0)
				(client setScript: 0)
			)
		)
	)
)

(instance throwThings of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local29 1)
				(localproc_0
					6
					(Format ; "Oh, you want %s? I think I have %s somewhere around here."
						@local100
						60
						45
						[local96 register]
						[local96 register]
					)
				)
				(= seconds 2)
			)
			(1
				(self setScript: bossHides self)
			)
			(2
				(if (gEgo inRect: 100 122 160 136)
					(gEgo setMotion: MoveTo 165 123)
				)
				(= seconds 2)
			)
			(3
				(gEgo loop: 1)
				(if
					(or
						(> local42 20)
						(and (== register 2) (or local46 (IsFlag 227)))
						(and
							(== register 3)
							(or local45 (IsFlag 228) (not [gEgoStats 12])) ; magic
						)
					)
					(localproc_0 5 60 46) ; "Gosh, I don't seem to have anything like that left. Really sorry 'bout that."
					(= state 6)
					(= seconds 5)
				else
					(= local41 (Random 2 4))
					(if (== register 0)
						(= local41 0)
					)
					(= cycles 10)
				)
			)
			(4
				(= temp0
					(switch (Random 0 4)
						(1
							(if local44 0 else 1)
						)
						(3
							(if
								(or
									local45
									(== register 3)
									(IsFlag 228)
									(not [gEgoStats 12]) ; magic
								)
								0
							else
								3
							)
						)
						(else 0)
					)
				)
				(if local41
					(self setScript: throwObj self temp0)
				else
					(self changeState: 6)
				)
			)
			(5
				(-- local41)
				(++ local42)
				(= state 3)
				(= cycles 5)
			)
			(6
				(-- local47)
				(self setScript: throwObj self register)
			)
			(7
				(self setScript: bossReturns self)
			)
			(8
				(= local29 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance bossMad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local28 0)
				(meepHead setCycle: Fwd)
				(client setLoop: 4 cel: 0 cycleSpeed: 0 setCycle: CT 3 1 self)
			)
			(1
				(if local40
					(= local40 0)
					(meepHead dispose:)
				)
				(thudSound play:)
				(bossRock
					setCel: -1
					setCycle: Fwd
					setPri: 8
					setMotion: MoveTo 140 54 self
				)
				(client setCycle: End)
			)
			(2
				(meepHead dispose:)
				(client
					setLoop: 2
					cel: -1
					setCycle: Beg
					setMotion: MoveTo 130 114 self
				)
				(bossRock setCycle: Fwd setMotion: MoveTo 140 94)
			)
			(3
				(thudSound play:)
				(bossRock dispose:)
				(= local39 0)
				(client view: 60 setLoop: 2 cel: 2 setCycle: Beg self)
				([local18 3] setLoop: (+ 3 (Random 0 1)) show: setCycle: Fwd)
				(= cycles 2)
			)
			(4
				([local18 3] setCycle: 0 stopUpd: hide:)
				(client setCycle: Beg self)
			)
			(5
				(if (not local300)
					(HandsOn)
				)
				(= [local10 3] (Clone aMeepScript))
				(client
					setLoop: 5
					cel: 0
					setPri: (+ 1 [local48 3])
					posn: [local56 6] (- [local56 7] 4)
					forceUpd:
					setScript: [local10 3] 0 3
				)
			)
		)
	)
)

(instance bouncyBaby of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Fwd)
				(self setScript: babySqueak)
				(= seconds 8)
			)
			(1
				(client setMotion: MoveTo 129 107 self)
			)
			(2
				(= cycles 5)
			)
			(3
				(= local44 0)
				(client dispose:)
			)
		)
	)
)

(instance babySqueak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 3 8))
				(babySound play:)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance getThing of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local300 1)
				(HandsOff)
				(gEgo ignoreBlocks: bossBlock)
				(if local28
					([local2 3] setScript: bossMad self)
				else
					(self cue:)
				)
			)
			(1
				(= temp0
					(switch register
						(2 greenFur)
						(3 spellScroll)
					)
				)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo (+ (temp0 x:) 12) (temp0 y:) self
				)
			)
			(2
				(gEgo
					view: 510
					setLoop: 1
					cel: 0
					cycleSpeed: 1
					setCycle: End
				)
				(= cycles 8)
			)
			(3
				(switch register
					(2
						(greenFur dispose:)
						(gEgo get: 27) ; green fur
						(= local46 0)
						(SetFlag 227)
					)
					(3
						(spellScroll dispose:)
						(gEgo get: 10) ; note
						(= local45 0)
						(SetFlag 228)
					)
				)
				(gEgo setCycle: Beg self)
			)
			(4
				(NormalEgo)
				(gEgo illegalBits: -32640)
				(LookAt gEgo [local2 3])
				(switch register
					(2
						(TimePrint 5 60 47) ; "You pick up the pile of soft green fur and carefully place it in your pack."
						(SolvePuzzle 681 5)
					)
					(3
						(if [gEgoStats 12] ; magic
							(TimePrint 8 60 48) ; "You pick up the Spell Scroll. As the magical runes fade, you find you now know how to cast the "Detect Magic" spell."
							(gEgo learn: 18 10) ; detectSpell
							(SolvePuzzle 618 4 1)
						else
							(TimePrint 5 60 49) ; "The magical runes fade from the paper before your eye can focus on them."
						)
					)
				)
				(gEgo observeBlocks: bossBlock)
				(HandsOn)
				(= local300 0)
				(self dispose:)
			)
		)
	)
)

(instance liftRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local300 1)
				(HandsOff)
				(= local35 1)
				(if local28
					([local2 3] setScript: bossMad self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					ignoreBlocks: bossBlock
					setMotion: MoveTo 130 106 self
				)
			)
			(2
				([local2 3] hide:)
				(gEgo
					view: 62
					setPri: 4
					setLoop: 0
					setCel: -1
					cel: 0
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(3
				(gEgo setCycle: CT 1 -1 self cycleSpeed: 5)
			)
			(4
				(gEgo setCycle: End self cycleSpeed: 2)
			)
			(5
				(gEgo cel: 0)
				(= cycles 2)
			)
			(6
				(thudSound play:)
				(gEgo setLoop: 1 cel: 0 cycleSpeed: 3 setCycle: End self)
				(gEgo posn: 130 103)
				([local2 3] show: view: 60 setLoop: 5 setCel: 0)
			)
			(7
				(NormalEgo)
				(LookAt gEgo [local2 3])
				([local2 3] setLoop: -1 setCel: -1)
				(= local35 0)
				(gEgo observeBlocks: bossBlock)
				(HandsOn)
				(= local300 0)
				(self dispose:)
			)
		)
	)
)

