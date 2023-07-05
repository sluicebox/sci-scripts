;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 81)
(include sci.sh)
(use Main)
(use Interface)
(use tunisia)
(use n821)
(use Approach)
(use n954)
(use LoadMany)
(use Grooper)
(use RFeature)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	outsideCompoundRm 0
)

(local
	local0
	local1
	local2
	local3
)

(instance outsideCompoundRm of Rm
	(properties
		picture 81
		north 86
		east 82
	)

	(method (init)
		(super init:)
		(self
			setRegions: 310 ; tunisia
			setFeatures:
				windo
				((Clone windo)
					x: 266
					y: 26
					z: 0
					nsLeft: 247
					nsTop: 12
					nsRight: 285
					nsBottom: 40
					yourself:
				)
				doorFeat
				building
		)
		(Load rsVIEW 787)
		(Load rsVIEW 285)
		(switch gPrevRoomNum
			(east
				(gEgo posn: 314 (gEgo y:) loop: 1 init:)
				(guardRight
					view: 787
					setLoop: Grooper
					loop: 2
					cel: 0
					posn: 223 78
					init:
				)
				(self setScript: offLimitsScript)
			)
			(80 ; agentsBuildingRm
				(LoadMany rsVIEW 85 684 185 687 287)
				(guardRight
					view: 787
					setLoop: Grooper
					loop: 2
					cel: 0
					posn: 223 78
					init:
				)
				(van init:)
				(vanDoor view: 185 loop: 2 cel: 0 init:)
				(self setScript: vanInScript)
			)
			(else
				(LoadMany rsVIEW 181 185 281 376 684 287)
				(LoadMany rsSOUND 82 18 218)
				(stacy view: 181 loop: 0 cel: 0 posn: 262 90)
				(van view: 185 loop: 0 cel: 0 posn: 256 97 init:)
				(vanDoor
					view: 185
					loop: 3
					cel: 0
					x: (- (van x:) 2)
					y: (+ (van y:) 1)
					z: 11
					init:
				)
				(self setScript: shootOutScript)
			)
		)
		(gAddToPics add: arch doit:)
		(door init: ignoreActors: 1)
		(guardLeft
			view: 285
			loop: 1
			cel: 0
			illegalBits: 0
			ignoreActors: 1
			posn: 154 78
			init:
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,town,scene]')
				(Print 81 0) ; "This is the only entrance to the compound where the Ambassador is being held."
			)
			((Said 'load/gun')
				(Print 81 1) ; "It's already loaded."
			)
		)
	)

	(method (newRoom newRoomNumber)
		(cond
			((== (gEgo script:) stayHereScript)
				(return)
			)
			((and (not (OneOf newRoomNumber 86 88)) (!= gPrevRoomNum 82)) ; compoundHallwayRm, townRm3
				(gEgo setScript: stayHereScript)
			)
			(else
				(super newRoom: newRoomNumber &rest)
			)
		)
	)
)

(instance stayHereScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 81 2) ; "If you leave now, the Ambassador is dead meat for sure."
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance offLimitsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(Print 81 3) ; "As you near the compound, one of the guards begins walking towards you."
				(guardRight
					setAvoider: Avoid
					setCycle: Walk
					setMotion: Approach gEgo 20 self
				)
			)
			(2
				(guardRight
					heading:
						(GetAngle
							(guardRight x:)
							(guardRight y:)
							(gEgo x:)
							(gEgo y:)
						)
				)
				((guardRight looper:) doit: guardRight (guardRight heading:))
				(= cycles 5)
			)
			(3
				(self setScript: arabicScript)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== (gEgo onControl: 1) 2) (== state 0))
			(self cue:)
		)
	)
)

(instance vanInScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(van setLoop: 0 setStep: 8 8 setMotion: MoveTo 256 97)
				(= cycles 8)
			)
			(1
				(van setStep: 6 6)
				(= cycles 5)
			)
			(2
				(van setStep: 4 4)
				(= cycles 8)
			)
			(3
				(van setStep: 2 2 setMotion: MoveTo 256 97 self)
			)
			(4
				(van stopUpd:)
				(User canInput: 1)
				(= local2 200)
			)
			(5
				(Print 81 4) ; "You open the door of the van and step out."
				(vanDoor setCycle: End self)
			)
			(6
				(vanDoor setLoop: 3 stopUpd:)
				(gEgo
					view: (if (gEgo has: 13) 85 else 684) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
					posn: (- (van x:) 10) (+ (van y:) 3)
					loop: 2
					setLoop: Grooper
					setCycle: Walk
					init:
				)
				(HandsOn)
				(= local3 1)
				(= local1 200)
				(client setScript: outOfVanScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'exit,exit[/truck]')
					(Said 'open/truck,door[<truck]')
					(Said 'get[<out][/truck]')
					(Said 'stand')
				)
				(self cue:)
			)
			((Said 'open/tray,food')
				(proc0_39) ; "You don't need to do that."
			)
			((Said 'get,(pick<up)/food,platter,tray')
				(cond
					((gEgo has: 13) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
						(Print 81 5) ; "You already have it."
					)
					((== local0 1)
						(Print 81 6) ; "You pick up the food with the hidden weapon."
						(gEgo get: 13) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
					)
					(else
						(Print 81 7) ; "You pick up the food."
						(gEgo get: 13) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
					)
				)
			)
			((or (Said 'hide/gun') (Said 'adjust,hide<in/gun/food,platter'))
				(if (== local0 0)
					(Print 81 8) ; "You hide the weapon in the food."
					(= local0 1)
					(gGame changeScore: 2)
				else
					(Print 81 9) ; "You already hid the weapon."
				)
			)
			((Said 'look[<at]/compound')
				(Print 81 10) ; "Looking through the van's window, you see two guards standing by the door."
			)
			((Said 'talk/guard')
				(Print 81 11) ; "You can't do that from the van."
			)
			((Said 'shoot,fire[/guard,gun]')
				(Print 81 12) ; "You don't have a clear shot from within the van."
			)
		)
	)

	(method (doit)
		(super doit:)
		(-- local2)
		(cond
			((!= state 4))
			((== local2 1)
				(= local2 0)
				(client setScript: orderedOutScript)
			)
		)
	)
)

(instance orderedOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(guardRight
					setAvoider: Avoid
					setCycle: Walk
					setMotion: MoveTo 177 84 self
				)
			)
			(1
				(guardRight setMotion: MoveTo 177 100 self)
			)
			(2
				(guardRight setMotion: MoveTo 185 100 self)
			)
			(3
				(Print 81 13) ; "Sitting in the van so long has made the guard uneasy. He orders you out."
				(Print 81 14) ; "Nervously you open the door of the van and step out."
				(vanDoor setCycle: End self)
			)
			(4
				(vanDoor setLoop: 3 stopUpd:)
				(gEgo
					view: (if (gEgo has: 13) 85 else 684) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
					posn: (- (van x:) 10) (+ (van y:) 3)
					loop: 2
					setLoop: -1
					setLoop: Grooper
					setCycle: Walk
					init:
				)
				(= cycles 1)
			)
			(5
				(gEgo heading: 270)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 3)
			)
			(6
				(self setScript: arabicScript)
			)
		)
	)
)

(instance outOfVanScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(Print 81 15) ; "Your behavior has made the guard suspicious. He begins walking towards you."
				(guardRight
					setCycle: Walk
					setAvoider: Avoid
					setMotion: Approach gEgo 20 self
				)
			)
			(2
				(guardRight
					heading:
						(GetAngle
							(guardRight x:)
							(guardRight y:)
							(gEgo x:)
							(gEgo y:)
						)
				)
				((guardRight looper:) doit: guardRight (guardRight heading:))
				(gEgo
					heading:
						(GetAngle
							(gEgo x:)
							(gEgo y:)
							(guardRight x:)
							(guardRight y:)
						)
				)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 5)
			)
			(3
				(self setScript: arabicScript)
			)
		)
	)

	(method (doit)
		(super doit:)
		(-- local1)
		(cond
			((!= state 0))
			((and (== (gEgo onControl: 1) 8) (gEgo has: 13)) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
				(client setScript: friskScript)
			)
			((or (== (gEgo onControl: 1) 4) (== local1 1))
				(= local1 0)
				(self cue:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'shoot,fire[/guard,gun]')
				(client setScript: egoShootScript)
			)
			((Said 'open/tray,food')
				(proc0_39) ; "You don't need to do that."
			)
			((Said 'get,(pick<up)/food,platter,tray')
				(if (gEgo has: 13) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
					(proc0_35) ; "You already took that."
				else
					(client setScript: goGetFoodScript)
				)
			)
			((or (Said 'hide/gun') (Said 'adjust,hide<in/gun/platter,food'))
				(if (== local0 0)
					(client setScript: goHideGunScript)
				else
					(Print 81 9) ; "You already hid the weapon."
				)
			)
			((Said 'close/door,truck[<truck]')
				(proc0_39) ; "You don't need to do that."
			)
		)
	)
)

(instance friskScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 175 78 self
				)
			)
			(1
				(if (not (tunisia madeCall:))
					(Print 81 16) ; "The guard looks at you suspiciously and says, "You are not the regular caterer. Something is not right here. What is your name?""
				else
					(Print 81 17) ; "The guard speaks to you and insists, "Your name!""
				)
				(Print 81 18) ; ""Shlinka Abdul," you reply."
				(= cycles 1)
			)
			(2
				(guardRight
					ignoreActors: 1
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 7) self
				)
			)
			(3
				(guardRight view: 485 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(guardRight setCycle: Beg self)
			)
			(5
				(cond
					((== local0 0)
						(Print 81 19) ; "AH HA!" he exclaims, "What does Abdul the Caterer need with a weapon of this sort?"
						(Print 81 20) ; ""Get going PIG!" he says."
					)
					((not (tunisia madeCall:))
						(Print 81 21) ; "Because the guard doesn't recognize you, he does a more thorough search than usual."
						(Print 81 22) ; "He grabs the platter out of your hand and opens it."
						(Print 81 19) ; "AH HA!" he exclaims, "What does Abdul the Caterer need with a weapon of this sort?"
						(Print 81 20) ; ""Get going PIG!" he says."
					)
					(else
						(Print 81 23) ; ""Ok, Abdul," He says, "Bring the food inside."
					)
				)
				(= cycles 1)
			)
			(6
				(door setCycle: End self)
			)
			(7
				(gEgo setMotion: MoveTo 175 68 self)
				(guardRight
					ignoreActors: 1
					illegalBits: 0
					view: 787
					setCycle: Walk
					setMotion: MoveTo 175 68 self
				)
			)
			(8
				(gEgo dispose:)
			)
			(9
				(guardRight dispose:)
				(door setCycle: Beg self)
			)
			(10
				(if (or (== local0 0) (not (tunisia madeCall:)))
					(EgoDead 970 0 0 81 24) ; "You have just joined the Ambassador as another hostage."
				else
					(gCurRoom newRoom: 86) ; compoundHallwayRm
				)
			)
		)
	)
)

(instance goGetFoodScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (gEgo y:) 98)
					(gEgo setAvoider: Avoid setMotion: MoveTo 194 104 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: MoveTo (- (van x:) 10) (+ (van y:) 3) self)
			)
			(2
				(gEgo heading: 0)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 4)
			)
			(3
				(Print 81 25) ; "You take the platter out of the van."
				(gEgo setAvoider: 0 view: 85 get: 13) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
				(= cycles 5)
			)
			(4
				(gEgo heading: 180)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 6)
			)
			(5
				(HandsOn)
				(= local1 200)
				(client setScript: outOfVanScript)
			)
		)
	)
)

(instance goHideGunScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (gEgo y:) 98)
					(gEgo setAvoider: Avoid setMotion: MoveTo 194 104 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: MoveTo (- (van x:) 10) (+ (van y:) 3) self)
			)
			(2
				(gEgo heading: 0)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 4)
			)
			(3
				(Print 81 26) ; "Beyond the guard's field of vision, you hide the weapon in the food."
				(= local0 1)
				(gGame changeScore: 2)
				(= cycles 5)
			)
			(4
				(gEgo setAvoider: 0 heading: 180)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 6)
			)
			(5
				(HandsOn)
				(= local1 200)
				(client setScript: outOfVanScript)
			)
		)
	)
)

(instance egoShootScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: Avoid)
				(if (gEgo inRect: 270 130 319 189)
					(gEgo setMotion: MoveTo 279 123 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: MoveTo 200 100 self)
				(Print 81 27) ; "You move into position to fire."
			)
			(2
				(gEgo view: 687 loop: 0 cel: 0 setCycle: End self)
				(Print 81 28) ; "You quickly draw the weapon and shoot both guards with animal tranquilizer."
			)
			(3
				(guardLeft view: 287 loop: 1 setCycle: End)
				(gEgo loop: 1)
				(= cycles 7)
			)
			(4
				(gEgo setCycle: Beg)
				(guardRight view: 287 loop: 0 setCycle: End self)
			)
			(5
				(Print 81 29) ; "All of a sudden, as both guards lie on the ground, the hair stands up on the back of your neck as you see..."
				(Print 81 30) ; "Another guard!"
				(guardNew
					view: 787
					loop: 2
					cel: 0
					illegalBits: 0
					ignoreActors: 1
					setCycle: Walk
					posn: 176 70
					init:
				)
				(door setCycle: End self)
			)
			(6
				(gEgo loop: 0 setCycle: End)
				(guardNew
					setMotion: MoveTo (guardNew x:) (+ (guardNew y:) 5) self
				)
			)
			(7
				(Print 81 31) ; "Just as you turn to shoot the third guard...."
				(Print 81 32) ; "He beats you to the trigger and opens fire."
				(guardNew view: 187 loop: 0 cel: 0 setCycle: CT 4 1 self)
			)
			(8
				(gEgo
					view: 687
					loop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(guardNew setCycle: End)
			)
			(9
				(= cycles 10)
			)
			(10
				(EgoDead 970 1 0 81 33) ; "After being hit numerous times, you fall motionless to the ground."
			)
		)
	)
)

(instance shootOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 684
					loop: 2
					setCycle: Walk
					illegalBits: 0
					ignoreActors: 1
					posn: 175 58
					setPri: -1
					init:
				)
				(ambass
					view: 887
					loop: 2
					setCycle: Walk
					illegalBits: 0
					ignoreActors: 1
					posn: 180 65
					init:
				)
				(door setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 175 68)
				(ambass setMotion: MoveTo 185 75 self)
			)
			(2
				(guardLeft loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(Print 81 34) ; ""HALT!" the guard screams."
				(gEgo view: 281 loop: 1 setCycle: End)
				(ambass view: 281 loop: 0 setCycle: End)
				(= cycles 10)
			)
			(4
				(Print 81 35) ; ""I shall now kill you both!" the guard shouts."
				(stacy
					init:
					setStep: 8 2
					setCel: 0
					setMotion: MoveTo 205 90 self
				)
			)
			(5
				(shot number: (proc0_5 18) play:)
				(stacy setCycle: End self)
			)
			(6
				(guardLeft loop: 2 cel: 0)
				(stacy view: 250 loop: 3 setLoop: -1 setStep: 3 2)
				(= cycles 1)
			)
			(7
				(gIceGlobalSound number: 82 play:)
				(guardLeft posn: 149 77 cel: 1)
				(splat
					view: 285
					loop: 3
					cel: 0
					x: 146
					y: 78
					z: 34
					init:
					cycleSpeed: 2
					setCycle: End
				)
				(= cycles 1)
			)
			(8
				(gEgo setCycle: Beg)
				(ambass setCycle: Beg)
				(guardLeft cycleSpeed: 1 setCycle: End self)
			)
			(9
				(Print 81 36) ; "The agent reacts just in time, saving the lives of both you and the Ambassador."
				(Print 81 37) ; "STACY!" you shout, "WHAT DID I EVER DO WITHOUT YOU!"
				(stacy setMotion: MoveTo (van x:) (- (van y:) 10))
				(ambass
					view: 887
					loop: 2
					setCycle: Walk
					setMotion: MoveTo (van x:) (- (van y:) 5)
				)
				(gEgo
					view: 684
					loop: 2
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo 176 86 self
				)
			)
			(10
				(gEgo setMotion: MoveTo 200 98 self)
			)
			(11
				(gEgo setMotion: MoveTo (- (van x:) 10) (+ (van y:) 3) self)
			)
			(12
				(gEgo heading: 0)
				((gEgo looper:) doit: gEgo (gEgo heading:) self)
			)
			(13
				(gEgo dispose:)
				(ambass dispose:)
				(stacy dispose:)
				(vanDoor loop: 4 setCycle: End self)
			)
			(14
				(van
					illegalBits: 0
					ignoreActors: 1
					setLoop: 0
					setCel: 0
					setStep: 2 2
					setMotion: MoveTo -100 (van y:)
				)
				(= cycles 8)
			)
			(15
				(van setStep: 4 4)
				(= cycles 8)
			)
			(16
				(van setStep: 6 6)
				(= cycles 8)
			)
			(17
				(van setStep: 8 8)
				(= cycles 8)
			)
			(18
				(van setStep: 10 10 setMotion: MoveTo -100 (van y:) self)
			)
			(19
				(gInventory eachElementDo: #owner 0)
				(gCurRoom newRoom: 88)
			)
		)
	)
)

(instance arabicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc310_1 guardRight)
				(= seconds 2)
			)
			(1
				(proc310_2)
				(= cycles 2)
			)
			(2
				(proc310_1 gEgo)
				(= seconds 2)
			)
			(3
				(proc310_2)
				(= cycles 2)
			)
			(4
				(proc310_1 guardRight)
				(= seconds 2)
			)
			(5
				(proc310_2)
				(= cycles 2)
			)
			(6
				(if (== client offLimitsScript)
					(Print 81 38) ; "After questioning, you are unable to explain your presence in this area."
				else
					(Print 81 39) ; "After questioning, you are unable to explain your behavior."
				)
				(EgoDead 970 0 0 81 40) ; "The guard places you under arrest and takes you away."
			)
		)
	)
)

(instance guardLeft of Act
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/guard,man]>')
				(cond
					((Said 'talk')
						(Print 81 41) ; "That's probably not a good idea. Try not to draw attention to yourself."
					)
					((Said 'look[<at]')
						(Print 81 42) ; "The guard looks a little sleepy. But one false move on your part will probably bring a quick response."
					)
				)
			)
		)
	)
)

(instance guardRight of Act
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/guard,man]>')
				(cond
					((Said 'talk')
						(Print 81 41) ; "That's probably not a good idea. Try not to draw attention to yourself."
					)
					((Said 'look[<at]')
						(Print 81 42) ; "The guard looks a little sleepy. But one false move on your part will probably bring a quick response."
					)
				)
			)
		)
	)
)

(instance guardNew of Act
	(properties)
)

(instance van of Act
	(properties
		y 97
		x 390
		view 185
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/truck]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 81 43) ; "The van belonging to Bagdad's Fast Food catering."
					)
					((Said 'enter,(look<in)')
						(if (== local3 0)
							(Print 81 44) ; "You're already in the van."
						else
							(Print 81 45) ; "You've committed yourself. There's no backing out now."
						)
					)
				)
			)
		)
	)
)

(instance stacy of Act
	(properties)
)

(instance ambass of Act
	(properties)
)

(instance splat of Prop
	(properties)
)

(instance door of Prop
	(properties
		y 71
		x 155
		view 81
	)
)

(instance vanDoor of Prop
	(properties)

	(method (doit)
		(self x: (- (van x:) 2) y: (+ (van y:) 1) z: 11)
		(super doit:)
	)
)

(instance arch of PV
	(properties
		y 71
		x 187
		view 81
		loop 1
		signal 16384
	)
)

(instance shot of Sound
	(properties
		number 18
		priority 2
	)
)

(instance building of RFeature
	(properties
		y 35
		x 159
		nsBottom 71
		nsRight 319
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/building]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 81 46) ; "A typical example of Tunisian architecture."
					)
				)
			)
		)
	)
)

(instance windo of RFeature
	(properties
		y 23
		x 89
		nsTop 14
		nsLeft 79
		nsBottom 32
		nsRight 99
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/shutter]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 81 47) ; "A window."
					)
					((Said 'open,(look,climb<(in,through))')
						(proc0_41) ; "That is not a good idea."
					)
				)
			)
		)
	)
)

(instance doorFeat of RFeature
	(properties
		y 37
		x 186
		nsTop 3
		nsLeft 154
		nsBottom 71
		nsRight 219
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 81 48) ; "The door to the compound. Beyond it, the Ambassador awaits."
					)
					((Said 'knock')
						(proc0_41) ; "That is not a good idea."
					)
				)
			)
		)
	)
)

