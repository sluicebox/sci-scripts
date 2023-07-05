;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54)
(include sci.sh)
(use Main)
(use n100)
(use n102)
(use n106)
(use Door)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm54 0
	rock 1
	nest 2
	bird 3
	nestDown 4
	flyAway 5
	treeFall 6
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(instance fireDart of Act
	(properties
		view 522
		illegalBits 0
	)
)

(instance magicLasso of Act
	(properties
		view 520
		illegalBits 0
	)
)

(instance rock of Act
	(properties
		view 510
		illegalBits 0
	)
)

(instance healerSign of PV
	(properties
		y 72
		x 212
		view 55
		loop 2
		priority 10
	)
)

(instance ring of Prop
	(properties
		y 64
		x 79
		view 55
		loop 6
	)

	(method (handleEvent event)
		(cond
			((Said 'look/glimmer,reflection,chandelier')
				(if (not (IsFlag 210))
					(if (and (== global330 0) (not (IsFlag 278)))
						(HighPrint 54 0) ; "You can't tell what it is from down on the ground."
					else
						(HighPrint 54 1) ; "It looks like a golden ring, flashing in the sunlight."
						(SetFlag 209)
					)
				else
					(event claimed: 0)
				)
			)
			((Said 'look/ring')
				(if (IsFlag 209)
					(HighPrint 54 2) ; "The ring appears to be made of fine gold."
				else
					(event claimed: 0)
				)
			)
			((Said 'get/ring')
				(cond
					((gEgo pickUp: 19)
						(HighPrint 54 3) ; "You retrieve the ring you dropped."
					)
					((IsFlag 210)
						(AlreadyDone)
					)
					((== global330 0)
						(if (not (IsFlag 278))
							(HighPrint 54 4) ; "You'll think of something."
						else
							(gEgo setScript: (ScriptID 237 0)) ; outOnALimb
						)
					)
					(
						(and
							(== global330 2)
							(not
								(or
									(== (gEgo onControl: 1) 8192)
									(== (gEgo onControl: 1) 16384)
								)
							)
						)
						(HighPrint 54 5) ; "Go check out the nest."
					)
					((not (IsFlag 209))
						(HighPrint 54 6) ; "How can you get something you can't see?."
					)
				)
			)
			((Said 'climb/branch')
				(cond
					((IsFlag 210)
						(AlreadyDone)
					)
					((== global330 0)
						(if (not (IsFlag 278))
							(HighPrint 54 7) ; "Climb the tree first."
						else
							(gEgo setScript: (ScriptID 237 0)) ; outOnALimb
						)
					)
					((or (== global330 2) (== global330 1))
						(HighPrint 54 8) ; "There's nothing out on the limb to risk your neck over."
					)
				)
			)
		)
	)
)

(instance healerDoor of Door
	(properties
		y 127
		x 209
		view 55
		loop 1
		entranceTo 55
		locked 1
		doorControl 4096
	)
)

(instance bird of Act
	(properties
		y 66
		x 71
		view 55
		loop 5
		illegalBits 0
	)

	(method (init)
		(super init:)
		(gMouseHandler add: self)
	)

	(method (handleEvent event)
		(cond
			((or (Said 'look/bird,creature,lizard') (MouseClaimed bird event 3))
				(HighPrint 54 9) ; "The creature looks more like a small flying lizard than a bird."
			)
			((Said 'eat,get,kill,fight,cut,hit/bird')
				(HighPrint 54 10) ; "It'll be tough."
			)
		)
	)
)

(instance nest of Act
	(properties
		y 69
		x 73
		view 55
	)

	(method (handleEvent event)
		(cond
			((or (Said 'look/nest') (MouseClaimed nest event 3))
				(cond
					((not (IsFlag 212))
						(HighPrint 54 11) ; "It is made of twigs, leaves, and herbs, probably stolen from the healer's garden."
						(HighPrint 54 12) ; "There is a birdlike creature sitting in the nest."
					)
					((== global330 0)
						(HighPrint 54 13) ; "The nest sits on the branch."
						(if (IsFlag 278)
							(if (not (IsFlag 210))
								(HighPrint 54 14) ; "In the nest is an object which appears to be a ring, glinting in the sunlight."
								(SetFlag 209)
							else
								(HighPrint 54 15) ; "It is empty now."
							)
						)
					)
					((== global330 1)
						(HighPrint 54 16) ; "The remnants of the nest are scattered on the ground."
					)
					((== global330 2)
						(HighPrint 54 17) ; "What's left of the nest is charred beyond recognition."
					)
				)
			)
			((Said 'get/nest')
				(switch global330
					(0
						(if (IsFlag 278)
							(HighPrint 54 18) ; "It would be too messy to stow in your pack, and it doesn't appear to be good for anything."
						else
							(HighPrint 54 19) ; "Perhaps you can do that."
						)
					)
					(1
						(HighPrint 54 20) ; "It's a mess, and you don't need it, anyway."
					)
					(2
						(HighPrint 54 21) ; "There's not enough left to bother with."
					)
				)
			)
		)
	)
)

(instance whoosh of Sound
	(properties)
)

(instance rm54 of Rm
	(properties
		picture 54
		style 8
		east 56
		south 65
		west 53
	)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 55 510)
		(if (gEgo knows: 23)
			(Load rsVIEW 522)
			(Load rsSOUND (SoundFX 33))
		)
		(if (gEgo knows: 24)
			(Load rsVIEW 520)
		)
		(if (gEgo knows: 20)
			(Load rsVIEW 521)
		)
		(LoadMany rsSCRIPT 103 235 236 237)
		(super init:)
		(gContMusic fade:)
		(SL enable:)
		(NormalEgo)
		(gEgo init:)
		(HandsOn)
		(gAddToPics add: healerSign eachElementDo: #init doit:)
		(healerDoor setPri: 8 init: stopUpd:)
		(if (not (IsFlag 210))
			(ring init: setPri: 15)
		)
		(if (not (IsFlag 211))
			(if (== global330 0)
				(nest
					illegalBits: 0
					ignoreActors:
					setPri: 13
					cycleSpeed: 1
					init:
					stopUpd:
				)
			else
				(nest init: hide: stopUpd:)
			)
			(if (not (IsFlag 212))
				(bird
					ignoreActors:
					init:
					cycleSpeed: 1
					stopUpd:
					setScript: flutter
				)
			)
		)
		(switch gPrevRoomNum
			(37
				(gEgo setLoop: 2 setPri: 4 posn: 130 100)
				(= local0 1)
				(SetFlag 44)
			)
			(53
				(gEgo posn: 10 135 setMotion: MoveTo 72 135)
			)
			(55
				(gCurRoom setScript: outOfHouse)
			)
			(56
				(gEgo posn: 318 153 setMotion: MoveTo 295 153)
			)
			(else
				(gEgo posn: 160 188 setMotion: MoveTo 160 170)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(local0
				(= local0 0)
				(gEgo setScript: (ScriptID 235 0)) ; climbIn
			)
			((not (IsFlag 44))
				(SetFlag 44)
				(gCurRoom setScript: (ScriptID 235 1)) ; intro54
			)
		)
		(cond
			(
				(and
					(not local1)
					(!= global330 1)
					(not (IsFlag 210))
					(== (gEgo onControl: 1) 16384)
				)
				(= local1 1)
				(ring cel: 0 setCycle: End)
			)
			((and local1 (!= (gEgo onControl: 1) 16384))
				(= local1 0)
			)
		)
		(if
			(and
				(== global330 2)
				(not (IsFlag 210))
				(not (IsFlag 211))
				(not local5)
				(or
					(== (gEgo onControl: 1) 8192)
					(== (gEgo onControl: 1) 16384)
				)
			)
			(= local5 1)
			(gEgo setScript: pickItUp)
		)
		(if
			(and
				(<= (gEgo y:) 87)
				(not (IsFlag 277))
				(not (gEgo script:))
			)
			(HandsOff)
			(gEgo setScript: overTheHill)
		)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((and (IsFlag 278) (Said 'throw,run,walk,sneak'))
						(TimePrint 4 54 22) ; "Ooooops!"
						(gEgo setScript: treeFall)
					)
					(
						(or
							(Said 'wear/ring')
							(Said 'put[<on]/ring,finger')
							(Said 'put/ring/finger')
						)
						(if (gEgo has: 19) ; healer's ring
							(HighPrint 54 23) ; "You think about it, but you decide to keep it in your pack."
						else
							(DontHave)
						)
					)
					((Said 'cast>')
						(if (IsFlag 278)
							(HighPrint 54 24) ; "As you try to cast a spell from your high perch on the tree, you lose your concentration, and..."
							(gEgo setScript: treeFall)
							(event claimed: 1)
						else
							(= temp0 (SaidSpell event))
							(if (CastSpell temp0)
								(switch temp0
									(20
										(CastDazzle gEgo)
										(if (not (IsFlag 212))
											(bird setScript: flyAway)
										)
									)
									(23
										(cond
											((== global330 0)
												(gEgo setScript: nestBurn)
											)
											((gEgo inRect: 182 0 319 106)
												(HighPrint 54 25) ; "You don't have a clear shot."
											)
											(else
												(CastDart 0)
											)
										)
									)
									(24
										(if
											(and
												(== global330 0)
												(not (IsFlag 210))
											)
											(if
												(or
													(==
														(gEgo onControl: 1)
														8192
													)
													(==
														(gEgo onControl: 1)
														16384
													)
												)
												(= local4 1)
												(gEgo setScript: throwIt)
											else
												(HighPrint 54 26) ; "Move to a better position."
											)
										else
											(HighPrint 54 27) ; "That spell is no longer useful here."
										)
									)
									(else
										(event claimed: 0)
									)
								)
							)
						)
					)
					((Said 'open/door')
						(if (== (gEgo onControl: 1) 4096)
							(HighPrint 54 28) ; "The door seems to be barred on the inside. Perhaps you should knock."
						else
							(NotClose)
						)
					)
					((Said 'lockpick,unlock/hasp,door')
						(if (TrySkill 9 10 0) ; pick locks
							(HighPrint 54 29) ; "Your lock-picking skill will do you no good here. The door is barred from the inside."
						else
							(HighPrint 54 30) ; "The door appears to be barred on the inside."
							(HighPrint 54 31) ; "Your skill in lock picking is insufficient to open a sardine can -- with a key!"
						)
					)
					((Said 'knock[/door]')
						(cond
							((not (== (gEgo onControl: 1) 4096))
								(NotClose)
							)
							(gNight
								(HighPrint 54 32) ; "There is no answer."
							)
							((IsFlag 226)
								(if (!= gPrevRoomNum 55)
									(HighPrint 54 33) ; "You hear the voice of the healer saying: "The last time you were here, I found I was missing some potions.""
									(HighPrint 54 34) ; "I don't like thievery. Go away!"
								else
									(gEgo setLoop: 3)
									(HighPrint 54 35) ; "You hear the inside bolt slide open."
									(HighPrint 54 36) ; "Come on in."
									(HandsOff)
									(healerDoor
										facingLoop:
											(if (== (gEgo loop:) 3) 3 else 0)
										locked: 0
									)
								)
							)
							(else
								(gEgo setLoop: 3)
								(HighPrint 54 35) ; "You hear the inside bolt slide open."
								(HighPrint 54 36) ; "Come on in."
								(HandsOff)
								(gEgo setPri: 9)
								(healerDoor
									facingLoop:
										(if (== (gEgo loop:) 3) 3 else 0)
									locked: 0
								)
							)
						)
					)
					((Said 'throw>')
						(if (Said '/boulder[/nest]')
							(cond
								((not (gEgo has: 21)) ; boulder
									(HighPrint 54 37) ; "You don't have a rock to throw."
								)
								(
									(or
										(!= global330 0)
										(not
											(or
												(== (gEgo onControl: 1) 8192)
												(==
													(gEgo onControl: 1)
													16384
												)
											)
										)
									)
									(HighPrint 54 38) ; "You throw a rock into the air..."
									(ThrowRock 0)
								)
								((rock script:)
									(HighPrint 54 39) ; "Wait to see if you hit something."
								)
								(else
									(gEgo setScript: throwIt)
								)
							)
						else
							(HighPrint 54 40) ; "That won't accomplish anything."
							(event claimed: 1)
						)
					)
					((Said 'climb>')
						(cond
							((or (Said '/tree,oak') (Said '<up'))
								(cond
									((gEgo inRect: 0 103 78 147)
										(HighPrint 54 41) ; "You don't see any good hand or foot holds on this side of the tree. Maybe it's better on the other side."
									)
									((gEgo inRect: 0 167 112 189)
										(if (TrySkill 11 30 0) ; climbing
											(gEgo
												setScript: (ScriptID 236 0) ; climbTree
											)
										else
											(gEgo
												setScript: (ScriptID 236 1) ; cantClimbTree
											)
										)
									)
									((IsFlag 278)
										(HighPrint 54 42) ; "You're already up the tree."
									)
									(else
										(NotClose)
									)
								)
							)
							((Said '<down')
								(if (IsFlag 278)
									(gEgo setScript: (ScriptID 237 1)) ; climbDown
								else
									(HighPrint 54 43) ; "You're not in a position to climb down."
								)
							)
							((Said '/branch')
								(HighPrint 54 8) ; "There's nothing out on the limb to risk your neck over."
							)
							((Said '[/!*]')
								(HighPrint 54 44) ; "Climb what?"
							)
							(else
								(HighPrint 54 45) ; "You don't want to climb that."
								(event claimed: 1)
							)
						)
					)
					((Said 'grab,get,lockpick/herb,flower,plant')
						(HighPrint 54 46) ; "The healer might be able to use them, but you can't."
					)
					((Said 'get>')
						(cond
							((Said '/boulder')
								(gEgo setScript: (ScriptID 103 0)) ; getRock
							)
							((Said '/bird,lizard,creature')
								(HighPrint 54 47) ; "It's gone."
							)
							((Said '/nest')
								(HighPrint 54 47) ; "It's gone."
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '/bird,creature,lizard')
								(HighPrint 54 47) ; "It's gone."
							)
							((Said '/nest')
								(HighPrint 54 48) ; "It's been destroyed."
							)
							((Said '[<at,around][/road]')
								(HighPrint 54 49) ; "On either side of the road are a large oak and a hut."
								(HighPrint 54 50) ; "The road itself leads north to a castle in the distance and south to the crossroads."
							)
							((Said '/house,hut')
								(HighPrint 54 51) ; "The house looks cheery and well-kept. It has the sign of the Healer above the entrance."
							)
							((Said '/sign')
								(HighPrint 54 52) ; "The apothecary bottle indicates that the occupant is skilled with potions."
							)
							((Said '/tree,oak')
								(HighPrint 54 53) ; "The tree is a large oak."
								(if (== global330 0)
									(HighPrint 54 54) ; "There is a nest on a single limb that seems to reach out toward the hut."
								)
							)
							((Said 'branch')
								(HighPrint 54 55) ; "The oak tree has one dead limb."
							)
							((Said '/roof')
								(HighPrint 54 56) ; "The hut's roof is made of thatched straw."
							)
							((Said '/garden,flower,plant,herb')
								(HighPrint 54 57) ; "In front of the hut is a small garden in which grow the kinds of plants and herbs that are used for making potions."
							)
							((Said '/window,bottle,pan,curtain')
								(if
									(or
										(gEgo inRect: 182 0 319 112)
										(and
											(gEgo inRect: 287 0 319 150)
											(== (gEgo loop:) 3)
										)
									)
									(if gNight
										(HighPrint 54 58) ; "You can see nothing in the dark."
									else
										(HighPrint 54 59) ; "The curtains obscure your vision. You can only make out a clutter of bottles, jars, and pots on the sill."
									)
								else
									(NotClose)
								)
							)
							((Said '/east,forest')
								(HighPrint 54 60) ; "There is a forest to the east."
							)
							((Said '/west,field')
								(HighPrint 54 61) ; "There is a plowed field to the west."
							)
							((Said '/north,castle')
								(HighPrint 54 62) ; "The road winds northward toward a walled castle."
							)
							((Said '/south,crossroad')
								(HighPrint 54 63) ; "To the south is the crossroads in front of the town gate."
							)
						)
					)
				)
			)
		)
	)
)

(instance overTheHill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setPri: 4
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) 100 self
				)
			)
			(1
				(gCurRoom newRoom: 37)
			)
		)
	)
)

(instance flyAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bird setLoop: 3 cel: 0 posn: 73 64)
				(= cycles 1)
			)
			(1
				(bird setCycle: End self)
			)
			(2
				(bird
					setPri: 10
					setCycle: 0
					setStep: 5 3
					setMotion: MoveTo 31 77 self
				)
			)
			(3
				(SetFlag 212)
				(bird dispose:)
			)
		)
	)
)

(instance nestBurn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 212))
					(bird setScript: flyAway)
				)
				(gEgo
					view: 522
					setLoop: (if (< (gEgo x:) 73) 0 else 1)
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(whoosh number: (SoundFX 33) loop: 1 priority: 3 init: play:)
				(gEgo setCycle: End)
				(fireDart
					posn: (gEgo x:) (- (gEgo y:) 25)
					init:
					setLoop: 2
					setStep: 24 10
					ignoreActors:
					setCycle: Fwd
					setMotion: MoveTo (nest x:) (nest y:) self
				)
			)
			(2
				(whoosh dispose:)
				(nest setScript: burnUp)
				(fireDart setLoop: 3 setPri: 13 setCycle: End self)
			)
			(3
				(fireDart dispose:)
				(NormalEgo)
				(client setScript: 0)
			)
		)
	)
)

(instance burnUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(nest setPri: 12 setCycle: CT 3 1 self)
			)
			(1
				(++ local3)
				(nest
					posn: (nest x:) (+ (nest y:) 6)
					cel: (if (== (nest cel:) 3) 4 else 3)
				)
				(= cycles 1)
			)
			(2
				(if (< local3 15)
					(self changeState: 1)
				else
					(self cue:)
				)
			)
			(3
				(nest
					posn: (nest x:) (+ (nest y:) 3)
					cel: (if (== (nest cel:) 3) 4 else 3)
				)
				(= cycles 1)
			)
			(4
				(nest setCycle: End self)
			)
			(5
				(if (IsFlag 210)
					(HandsOn)
					(nest hide: setScript: 0)
					(ring hide:)
				else
					(= seconds 3)
				)
			)
			(6
				(ring posn: (nest x:) (nest y:) setPri: 12 setCycle: End self)
			)
			(7
				(= global330 2)
				(HandsOn)
				(nest stopUpd: setScript: 0)
			)
		)
	)
)

(instance throwIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 235 170 self)
			)
			(1
				(gEgo
					view: (if local4 520 else 510)
					cycleSpeed: 1
					setLoop: (if local4 0 else 2)
					cel: 0
				)
				(= cycles 2)
			)
			(2
				(if local4
					(gEgo setCycle: End self)
				else
					(gEgo setCycle: CT 4 1 self)
				)
				(if (not (IsFlag 212))
					(bird setScript: flyAway)
				)
			)
			(3
				(if local4
					(magicLasso
						ignoreActors:
						posn: (+ (gEgo x:) 2) (- (gEgo y:) 36)
						setLoop: 5
						setStep: 20 10
						setCycle: Fwd
						init:
						setScript: lassoNest
					)
					(client setScript: 0)
				else
					(rock
						setLoop: 4
						setPri: 15
						setStep: 25 10
						ignoreActors:
						ignoreHorizon:
						illegalBits: 0
						setCycle: Fwd
						posn: (- (gEgo x:) 13) (- (gEgo y:) 34)
						init:
						forceUpd:
					)
					(gEgo setCycle: End self)
					(if (TrySkill 10 25 0) ; throwing
						(rock setScript: (ScriptID 235 2)) ; rockHitsIt
					else
						(HandsOn)
						(rock setScript: (ScriptID 235 3)) ; youMissed
					)
				)
			)
			(4
				(NormalEgo)
				(gEgo use: 21 1 loop: 1) ; boulder
				(client setScript: 0)
			)
		)
	)
)

(instance pickItUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local5
					(HandsOff)
					(if (not (IsFlag 210))
						(HighPrint 54 64) ; "You see the glinting object in the remains of the nest."
					else
						(HighPrint 54 65) ; "You see nothing in the remains of the nest."
					)
					(gEgo illegalBits: 0 setMotion: MoveTo 115 170 self)
				else
					(self cue:)
				)
			)
			(1
				(NormalEgo)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (+ (nest x:) 15) 164 self
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
				(if (not (IsFlag 210))
					(HighPrint 54 66) ; "You pick up a shiny gold ring."
					(ring hide:)
				)
				(if (== (nest loop:) 7)
					(nest setCel: 1)
				else
					(nest hide:)
				)
				(gEgo setCycle: Beg self)
			)
			(4
				(NormalEgo)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(5
				(gEgo illegalBits: -32768)
				(if (not (IsFlag 210))
					(gEgo get: 19) ; healer's ring
					(SetFlag 210)
					(SolvePuzzle 667 3)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance lassoNest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(magicLasso setMotion: MoveTo (nest x:) (nest y:) self)
			)
			(1
				(magicLasso
					setPri: 11
					setStep: 6 4
					setMotion:
						MoveTo
						(+ (gEgo x:) 2)
						(- (gEgo y:) 36)
						self
				)
				(nest
					setPri: 11
					setStep: 6 4
					setMotion: MoveTo (+ (gEgo x:) 2) (- (gEgo y:) 38)
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(magicLasso hide:)
				(nest hide:)
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				(if (IsFlag 210)
					(HighPrint 54 67) ; "You place the nest on the ground. It is of no use to you."
				else
					(HighPrint 54 68) ; "You take a lovely gold ring from the nest."
					(HighPrint 54 69) ; "You place the ring into your pack and the nest on the ground."
					(SetFlag 210)
					(gEgo get: 19) ; healer's ring
					(ring hide:)
					(SolvePuzzle 667 3)
				)
				(gEgo loop: 1)
				(= global330 1)
				(nest setLoop: 7 setCel: 0 posn: 242 163 setPri: -1 show:)
				(NormalEgo)
				(HandsOn)
				(= cycles 2)
			)
			(5
				(magicLasso dispose:)
			)
		)
	)
)

(instance nestDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(nest
					setLoop: 4
					setStep: 15 7
					cel: 0
					setCycle: End
					setMotion: MoveTo (nest x:) (+ (nest y:) 42) self
				)
			)
			(1
				(if (< (nest y:) 150)
					(self changeState: 0)
				else
					(self cue:)
				)
			)
			(2
				(nest
					setLoop: 7
					setCel: 0
					setPri: -1
					posn: (nest x:) (+ (nest y:) 9)
					stopUpd:
				)
				(= global330 1)
				(= seconds 1)
			)
			(3
				(if (IsFlag 210)
					(self cue:)
				else
					(ring
						posn: (- (nest x:) 1) (nest y:)
						setPri: 12
						setCycle: End self
					)
				)
			)
			(4
				(if (not (IsFlag 210))
					(HighPrint 54 64) ; "You see the glinting object in the remains of the nest."
					(gEgo setScript: pickItUp)
				else
					(HighPrint 54 70) ; "You see nothing in the nest."
					(gEgo setScript: 0)
					(HandsOn)
				)
				(nest setScript: 0)
			)
		)
	)
)

(instance treeFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 517
					setLoop: 2
					cel: 0
					x: (- (gEgo x:) 12)
					setStep: 0 5
					cycleSpeed: 3
					moveSpeed: 0
					setCycle: End
					setMotion: MoveTo (gEgo x:) 170 self
				)
			)
			(1
				(if (not (TakeDamage 8))
					(EgoDead ; "Had you been healthier, you probably could have survived that fall. In your weakened condition, however, you succumbed to your injuries."
						54
						71
						82
						517
						2
						5
						80
						{Your figure remains still and silent.}
					)
				else
					(gEgo
						view: 503
						setLoop: 4
						cel: 0
						x: (+ (gEgo x:) 11)
						y: (+ (gEgo y:) 18)
						setPri: 13
						illegalBits: -32768
					)
					(switch (= local6 (Random 1 5))
						(0
							(HighPrint 54 72) ; "Experience is the best teacher."
						)
						(1
							(HighPrint 54 73) ; "Practice makes perfect."
						)
						(2
							(HighPrint 54 74) ; "Try, try again etc..."
						)
						(3
							(HighPrint 54 75) ; "Take a break. It's Mueller time."
						)
						(else
							(HighPrint 54 76) ; "Remember what happened to Humpty Dumpty."
						)
					)
					(++ local6)
					(self cue:)
				)
			)
			(2
				(gEgo cycleSpeed: 1 setCycle: End self)
			)
			(3
				(if (not local8)
					(= local8 1)
					(HighPrint 54 77) ; "That's what happens sometimes when you go out on a limb."
				)
				(ClearFlag 278)
				(HandsOn)
				(NormalEgo)
				(client setScript: 0)
			)
		)
	)
)

(instance flutter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 25))
			)
			(1
				(bird setCycle: End self)
			)
			(2
				(bird setCycle: Beg self)
			)
			(3
				(bird stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance outOfHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 207 132 setMotion: MoveTo 189 132 self)
			)
			(1
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

