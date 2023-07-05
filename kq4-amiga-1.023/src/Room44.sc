;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	Room44 0
)

(local
	local0
	local1
	local2
	local3
)

(instance tickleSound of Sound
	(properties
		number 60
		priority 15
	)
)

(instance sneezeSound of Sound
	(properties
		number 605
		priority 15
	)
)

(instance fallSound of Sound
	(properties
		number 51
		priority 15
	)
)

(instance bottleCage of Cage
	(properties
		top 144
		left 130
		bottom 175
		right 218
	)
)

(instance Room44 of Rm
	(properties
		picture 44
		style 8
	)

	(method (init)
		(= gIndoors 1)
		(super init:)
		(Load rsVIEW 52)
		(Load rsVIEW 17)
		(Load rsVIEW 19)
		(Load rsVIEW 7)
		(Load rsVIEW 6)
		(Load rsVIEW 53)
		(Load rsVIEW 49)
		(Load rsVIEW 21)
		(Load rsVIEW 73)
		(sneezeSound init:)
		(Load rsSOUND 51)
		(if (gEgo has: 8) ; Peacock_Feather
			(Load rsSOUND 60)
			(Load rsVIEW 51)
		)
		(= global189 1)
		(gEgo view: 8 posn: 39 160 viewer: inWhale init:)
		(= local0 (Prop new:))
		(local0 view: 0 posn: 161 75 init: hide:)
		(if ((Inv at: 31) ownedBy: 44) ; Glass_Bottle
			(= local1 (Act new:))
			(local1
				view: 531
				posn: 201 166
				xStep: 1
				yStep: 1
				setLoop: 0
				ignoreActors: 0
				illegalBits: -32768
				observeControl: 4 1
				setCycle: Fwd
				setMotion: Wander 4
				moveSpeed: 8
				cycleSpeed: 2
				observeBlocks: bottleCage
				init:
			)
		)
		(gCurRoom setScript: deadTimer)
		(Print 44 0) ; "Horrors! You have been swallowed by a huge whale!"
		(Print 44 1) ; "PHEW!! This place stinks!"
		(= global183 1)
		(= local3 0)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(& (gEgo onControl: 0) $0004)
				(== (gEgo script:) 0)
				(== (deadTimer state:) 0)
				(<= (inWhale state:) 0)
			)
			(gEgo setScript: slide)
			(fallSound init: play:)
			(if (== (gEgo view:) 2)
				(slide changeState: 10)
			else
				(slide changeState: 1)
			)
		)
	)

	(method (dispose)
		(gTimers eachElementDo: #dispose 84)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'get,(look<in)/skeleton,man,person,james')
					(Print 44 2) ; "There is nothing of importance with the skeleton."
				)
				((or (Said 'get,capture/fish') (Said 'fish'))
					(Print 44 3) ; "Not here."
				)
				((Said 'get,drink[/drink,water]')
					(Print 44 4) ; "NO!!"
				)
				((Said 'get/boat')
					(Print 44 5) ; "This old boat won't help you."
				)
				((Said 'get/bottle')
					(cond
						(((Inv at: 31) ownedBy: 44) ; Glass_Bottle
							(if (< (gEgo distanceTo: local1) 15)
								(Print 44 6) ; "Ok."
								(local1 dispose:)
								(= global182 1)
								(gEgo get: 31) ; Glass_Bottle
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
						((gEgo has: 31) ; Glass_Bottle
							(Print 44 7) ; "You already have it."
						)
						(else
							(Print 44 8) ; "What bottle?"
						)
					)
				)
				((Said 'light,ignite,make,start/fire')
					(Print 44 9) ; "You couldn't start a fire in here as it's too wet."
				)
				((Said 'look>')
					(cond
						((Said '/fish')
							(Print 44 10) ; "Bits and pieces of fish are everywhere."
						)
						((Said '/boat')
							(Print 44 11) ; "There's nothing in the old boat. It didn't help "James" and it won't help you."
						)
						((Said '<under/water')
							(Print 44 12) ; "There is nothing of interest under the seawater."
						)
						((Said '/belly')
							(Print 44 13) ; "This is a disgusting place to be! Seawater, dead fish, junk...you name it...float around in here. Hopefully, your fate will not be the same as poor "James" lying over there."
						)
						((Said '/tongue')
							(Print 44 14) ; "This is the biggest tongue you have ever seen! It's also extremely slippery, slimy, and bumpy. Ugh!"
						)
						((Said '/esophagus,lips,molar')
							(Print 44 15) ; "The whale's throat and mouth are enormous! Huge teeth, a great tongue, and yes...even a large uvula. What's that?, you say. Well, suffice it to say, it looks like a big punching bag and hangs down from the top of the throat. See, you learn something new every day!"
						)
						((Said '/uvula')
							(Print 44 16) ; "Yes, that's a big uvula, all right!"
						)
						((Said '/skeleton,james,man,person')
							(Print 44 17) ; "The skeleton of an unlucky man (let's call him James), rests atop the wreckage of a small boat."
						)
						((Said '/water')
							(if ((Inv at: 31) ownedBy: 44) ; Glass_Bottle
								(Print 44 18) ; "You notice a bottle floating in the seawater of the whale's stomach."
							else
								(Print 44 19) ; "Seawater floats in the whale's stomach."
							)
						)
						((Said '[<up,around,at][/room,whale]')
							(Print 44 0) ; "Horrors! You have been swallowed by a huge whale!"
							(Print 44 1) ; "PHEW!! This place stinks!"
						)
					)
				)
				((Said 'hit/molar')
					(if (< (gEgo y:) 82)
						(Print 44 20) ; "You strike the whale's teeth...but nothing happens."
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'hit/tongue')
					(Print 44 21) ; "You strike the whale's tongue...but nothing happens."
				)
				((Said 'hit/uvula,esophagus')
					(if (gEgo inRect: 140 71 178 86)
						(Print 44 22) ; "You strike the large uvula (punching bag-looking thing)...but nothing happens."
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'climb')
					(Print 44 23) ; "Go ahead. Try it."
				)
				((or (Said 'yell,help') (Said 'save/me'))
					(Print 44 24) ; "You scream, holler, and shout for help until your throat is hoarse; but to no avail."
				)
				((Said 'escape')
					(Print 44 25) ; "How could you open the whale's mouth?"
				)
				((Said 'bathe')
					(Print 44 26) ; "You really want to swim here?!"
				)
				((Said 'open,force/lips')
					(Print 44 27) ; "You're not strong enough to do that."
				)
				((Said 'light/fire')
					(Print 44 9) ; "You couldn't start a fire in here as it's too wet."
				)
				((Said 'tickle')
					(if (gEgo has: 8) ; Peacock_Feather
						(if (gEgo inRect: 140 71 178 86)
							(gEgo setScript: tickle)
							(tickle changeState: 1)
							(gGame changeScore: 5)
						else
							(Print 44 28) ; "Not here!"
						)
					else
						(Print 44 29) ; "With what?"
					)
				)
			)
		)
	)
)

(instance slide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(cond
					((< (gEgo x:) 50)
						(= local2 (+ (gEgo x:) 20))
					)
					((> (gEgo x:) 270)
						(= local2 (- (gEgo x:) 20))
					)
					(else
						(= local2 (gEgo x:))
					)
				)
				(gEgo
					view: 52
					illegalBits: 0
					setLoop: 2
					setCycle: Fwd
					yStep: 5
					xStep: 3
					setMotion: MoveTo local2 145 self
				)
			)
			(2
				(gEgo view: 19 setLoop: 0 cel: 2 setCycle: End self)
			)
			(3
				(fallSound dispose:)
				(gEgo viewer: inWhale)
				(gEgo
					illegalBits: -32768
					setLoop: -1
					xStep: 2
					yStep: 1
					setScript: 0
				)
				(HandsOn)
			)
			(10
				(HandsOff)
				(gEgo view: 17 setLoop: (& (gEgo loop:) $0001))
				(gEgo illegalBits: 0 cel: 255 setCycle: End self)
			)
			(11
				(self changeState: 1)
			)
		)
	)
)

(instance inWhale of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (gEgo script:) 0)
			(cond
				((& (gEgo onControl: 1) $0200)
					(gEgo view: 8 xStep: 2 yStep: 1 setCycle: Fwd)
				)
				((& (gEgo onControl: 1) $0008)
					(gEgo view: 7 xStep: 2 yStep: 1 setCycle: Walk)
				)
				((& (gEgo onControl: 1) $0800)
					(gEgo view: 6 xStep: 2 yStep: 1 setCycle: Walk)
				)
				((& (gEgo onControl: 1) $0001)
					(if (== (gEgo view:) 2)
						(slide changeState: 1)
					else
						(gEgo view: 53 setCycle: Walk setStep: 1 1)
					)
				)
				(
					(and
						(!= (gEgo view:) 2)
						(& (gEgo onControl: 1) $0010)
						(== (gEgo script:) 0)
						(<= state 0)
						(<= (deadTimer state:) 0)
					)
					(self changeState: 1)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(if (!= (gEgo view:) 2)
					(HandsOff)
					(gEgo
						viewer: 0
						view: 49
						setMotion: 0
						loop: (& (gEgo loop:) $0001)
						cel: 4
						setCycle: Beg self
					)
				else
					(self changeState: 0)
				)
			)
			(2
				(gEgo view: 21 cel: 6 setCycle: Beg self)
			)
			(3
				(gEgo view: 2 setStep: 2 1 setCycle: Walk viewer: inWhale)
				(= state 0)
				(HandsOn)
			)
		)
	)
)

(instance tickle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gTimers eachElementDo: #dispose 84)
				(gCurRoom script: 0)
				(tickleSound init: play: self)
				(gEgo setMotion: 0 viewer: 0)
				(LookAt gEgo local0)
				(gEgo loop: (& (gEgo loop:) $0001))
				(gEgo view: 51 loop: (& (gEgo loop:) $0001) setCycle: Fwd)
			)
			(2
				(sneezeSound play:)
				(Print 44 30) ; "You frantically tickle the throat of the whale with the big peacock feather. You begin to feel a quiver under your feet, which quickly turns into a mighty tremble. Suddenly, you hear a thunderous AAAAACCCCHHHHOOOOOOOO!, and you are swept out of the whale's mouth, in a tremendous wave of ocean water!"
				(gEgo setLoop: -1 setCel: -1)
				(HandsOn)
				(= global189 0)
				(gCurRoom newRoom: 31)
			)
		)
	)
)

(instance deadTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo has: 8) ; Peacock_Feather
					((ScriptID 0 5) setReal: self 1 4) ; timer2
				else
					((ScriptID 0 5) setReal: self 2 1) ; timer2
				)
			)
			(1
				(gEgo viewer: 0)
				(++ local3)
				(if (and (> (inWhale state:) 0) (< local3 4))
					(-- state)
					(= seconds 2)
				else
					(self cue:)
				)
			)
			(2
				(HandsOff)
				(gSounds eachElementDo: #stop 0)
				(cond
					((< (gEgo x:) 50)
						(= local2 (+ (gEgo x:) 20))
					)
					((> (gEgo x:) 270)
						(= local2 (- (gEgo x:) 20))
					)
					(else
						(= local2 (gEgo x:))
					)
				)
				(cond
					((== (gEgo view:) 2)
						(self changeState: 10)
					)
					((== (gEgo view:) 53)
						(fallSound play:)
						(gEgo
							view: 52
							setLoop: 2
							setCycle: Fwd (gEgo yStep: 5)
							setMotion: MoveTo local2 145 self
						)
					)
					(else
						(self changeState: 4)
					)
				)
			)
			(3
				(gEgo view: 19 setLoop: 0 cel: 2 setCycle: End self)
			)
			(4
				(self changeState: 20)
			)
			(10
				(fallSound play:)
				(gEgo
					setLoop: (& (gEgo loop:) $0001)
					view: 17
					cel: 255
					setCycle: End self
				)
			)
			(11
				(gEgo
					view: 52
					setLoop: 2
					setCycle: Fwd
					yStep: 5
					xStep: 3
					illegalBits: 0
					setMotion: MoveTo local2 145 self
				)
			)
			(12
				(self changeState: 3)
			)
			(20
				(gEgo view: 73 setLoop: 0 cel: 6 setCycle: End self)
			)
			(21
				(gEgo hide:)
				(Print 44 31) ; "It looks like the noxious fumes have finally gotten to you, Rosella."
				((ScriptID 0 5) setReal: self 5) ; timer2
			)
			(22
				(= gDeathFlag 1)
			)
		)
	)
)

