;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use Interface)
(use n316)
(use n824)
(use n954)
(use ForwardCounter)
(use Grooper)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	galleyRm 0
)

(instance galleyRm of Rm
	(properties
		picture 32
		horizon 12
		north 25
		south 34
		west 41
		vanishingX 315
		vanishingY 58
	)

	(method (init)
		(super init:)
		(gEgo init: setPri: -1)
		(if (proc316_1 gCurRoomNum 4)
			(rumBottle init: setPri: 8 ignoreActors: 1)
		)
		(switch gPrevRoomNum
			(25 ; controlRm
				(gEgo
					ignoreControl: -32768
					posn: 93 21
					view: 32
					setLoop: 3
					setScript: decendStairsScript
				)
			)
			(39 ; diceRm
				(egoChair hide:)
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo
					view: 32
					setLoop: 7
					ignoreControl: -32768
					posn: (egoChair x:) (egoChair y:)
					setCel: 16
					cycleSpeed: 2
					setPri: -1
					setScript: egoStandsScript
				)
				(oldSalt
					init:
					ignoreControl: -32768
					posn: (oldSaltChair x:) (oldSaltChair y:)
					view: 32
					cycleSpeed: 2
					setLoop: 6
					setCel: 16
					setScript: oldSaltStandScript
				)
				(rumBottle dispose:)
			)
			(west
				(gEgo posn: 59 108)
			)
			(south
				(gEgo posn: 109 141 heading: 45 loop: 6)
			)
			(else
				(HandsOn)
				(gEgo posn: 116 122 view: 232)
			)
		)
		(oldSaltChair init: ignoreActors: 1)
		(egoChair init:)
		(chef init: stopUpd: setScript: chefScript)
		(gAddToPics add: pipes skillet doit:)
		(proc824_0)
		(self setFeatures: stairsFeat setRegions: 314) ; subMarine
		(proc316_0 gCurRoomNum 4)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'stand')
				(if (== (gEgo view:) 32)
					(gEgo setScript: egoStandsScript)
				else
					(Print 32 0) ; "You already are."
				)
			)
			((Said 'look>')
				(cond
					((Said '[<at,around][/room]')
						(Print 32 1) ; "You look around the small cafeteria called a "galley"."
						(Print 32 2) ; "This is the place where the crewmen of the Blackhawk stuff themselves with tender morsels."
						(Print 32 3) ; "Through the serving window you can see the kitchen where the meals are prepared."
					)
					((Said '/table')
						(if
							(and
								(gCast contains: rumBottle)
								(not (& (rumBottle signal:) $0008))
							)
							(Print 32 4) ; "There is a bottle on the table."
						else
							(Print 32 5) ; "You see nothing of interest on or about the table."
						)
					)
					((Said '/kitchen')
						(Print 32 6) ; "Looking into the kitchen, you can't see a thing that will help you with the mission."
					)
					((Said '/menu')
						(Print 32 7) ; ""What you see is what you get," he quips."
					)
				)
			)
		)
	)

	(method (doit)
		(if (== (gEgo onControl: 1) 16384)
			(self newRoom: 34) ; machineRm
		else
			(super doit:)
		)
	)
)

(instance pipes of PV
	(properties
		y 185
		x 193
		view 32
		priority 15
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/pipe]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 32 8) ; "These pipes are in the machinery room."
					)
				)
			)
		)
	)
)

(instance skillet of PV
	(properties
		y 45
		x 164
		view 32
		cel 1
		priority 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((TurnIfSaid self event 'look[<at]/pan,pan'))
			((Said 'look[<at][/pan,pan]')
				(Print 32 9) ; "Just a skillet hanging on the wall."
			)
		)
	)
)

(instance chef of Prop
	(properties
		y 78
		x 142
		view 32
		loop 1
		priority 5
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/chef,man,cook]>')
				(cond
					((TurnIfSaid self event 'talk,(look[<at])/*'))
					((Said 'look[<at]')
						(Print 32 10) ; "He's flipping burgers right now."
					)
					((Said 'talk')
						(Print 32 11) ; "The chef says to you, "I'm blowing too much smoke right now to chew the fat, sir.""
					)
					((Said 'ask//key')
						(Print 32 12) ; "The chef says to you, "I don't have it anymore, I'm not sure who does, sir.""
					)
				)
			)
		)
	)
)

(instance serveItScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 32 13 #at 30 20 #time 8 #dispose) ; "The cook slides a burger out through the window."
				(chef setLoop: 5 cycleSpeed: 2 setCycle: End self)
			)
			(1
				(burger init:)
				(chef setLoop: 1 setCel: 0 cycleSpeed: 0 setScript: chefScript)
			)
		)
	)
)

(instance burger of View
	(properties
		view 32
		cel 5
	)

	(method (init)
		(super init:)
		(self posn: (+ (chef x:) 34) (- (chef y:) 1))
	)
)

(instance chefScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds (Random 5 20))
			)
			(1
				(client setLoop: 4 setCycle: ForwardCounter (Random 5 8) self)
			)
			(2
				(client setLoop: 1 setCycle: End self)
			)
			(3
				(client stopUpd:)
				(self init:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'get,order/food,sandwich,burger')
					(and (not register) (Said 'eat'))
				)
				(cond
					((!= (gEgo view:) 232)
						(proc0_33) ; "Not now!"
					)
					(register
						(Print 32 14) ; "One per customer, please."
					)
					(else
						(client setScript: serveItScript)
						(= register 1)
					)
				)
			)
			((Said 'eat[/food,sandwich,burger]')
				(cond
					((!= (gEgo view:) 232)
						(proc0_33) ; "Not now!"
					)
					((gCast contains: burger)
						(Print 32 15) ; "You consume the burger in record time."
						(burger dispose:)
					)
					(else
						(Print 32 16) ; "You already ate it."
					)
				)
			)
		)
	)
)

(instance egoStandsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					heading: 90
					yStep: 2
					setMotion: MoveTo (egoChair x:) (egoChair y:)
					setCycle: Beg self
				)
			)
			(1
				(egoChair show:)
				(gEgo
					posn: (- (egoChair x:) 23) (+ (egoChair y:) 1)
					cycleSpeed: 0
					heading: 270
					view: 232
					setLoop: -1
					setLoop: Grooper
					setCycle: Walk
					setMotion: MoveTo 229 106 self
				)
			)
			(2
				(gEgo heading: 270)
				((gEgo looper:) doit: gEgo (gEgo heading:) self)
			)
			(3
				(HandsOn)
				(gEgo observeControl: -32768)
				(self dispose:)
			)
		)
	)
)

(instance rumBottle of View
	(properties
		y 98
		x 239
		view 32
		cel 2
		priority 9
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((& signal $0008))
			((Said '[/bottle[<rum]]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 32 17) ; "You see a bottle of smooth Alonzo rum on the table."
					)
					((Said 'get,drink')
						(cond
							((>= (gEgo distanceTo: self) 40)
								(proc0_34) ; "You're not close enough."
							)
							((gCast contains: oldSalt)
								(event claimed: 0)
							)
							(else
								(oldSalt init: setScript: oldSaltScript)
							)
						)
					)
				)
			)
		)
	)
)

(instance oldSalt of Act
	(properties
		y 112
		x 46
		view 132
	)

	(method (init)
		(super init:)
		(self ignoreControl: -32768 setCycle: Walk)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((TurnIfSaid self event 'look[<at]/man[<old]'))
			((Said 'look[<at][/man[<old]]')
				(Print 32 18) ; "This crusty old salt has been on the sea for thirty-odd years."
			)
			((Said 'ask[/name]')
				(Print 32 19) ; "Allow me to introduce myself Sir," the Old Salt says, "My name is Flanagan, Sir, Jacob Flanagan."
				(Print 32 20) ; "He continues, "My title is Chief Petty Officer. I be the top sea dog of the torpedo room!""
				(Print 32 21) ; "Expanding on this, he reflects, "Fer thirty long yeers now I've been ramblin' the high seas!""
			)
		)
	)
)

(instance oldSaltScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 32 22 #at 30 20 #dispose) ; "Just as you reach for the bottle you see a man enter the galley."
				(oldSalt
					ignoreActors: 1
					setMotion:
						MoveTo
						(- (oldSaltChair x:) 13)
						(oldSaltChair y:)
						self
				)
				(if (InRect 210 115 257 124 gEgo)
					(gEgo setMotion: MoveTo 209 120)
				)
			)
			(1
				(if (and (== (gEgo x:) 209) (== (gEgo y:) 120))
					(gEgo loop: 0)
				)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(oldSaltChair hide:)
				(oldSalt
					x: (+ (oldSalt x:) 13)
					view: 32
					cycleSpeed: 2
					setLoop: 6
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(Print 32 23 #at 30 20) ; "Aye, Commander Westland," interjects the old seaman, "You appear to be eye-ballin' me bottle of rum?"
				(= cycles 2)
			)
			(3
				(Print 32 24 #at 30 20) ; ""Would ye be interested in wagering a ten dollar bill for this fine bottle, Sir," he asks with a sly wink."
				(User canInput: 1)
				(= seconds 10)
			)
			(4
				(Print 32 25 #at 30 20) ; "Being yer not a wagerin' man, Commander," he says firmly, "I'll be taking me bottle of rum to me bunk!"
				((gInventory at: 4) moveTo: -1) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
				(rumBottle hide:)
				(client setScript: oldSaltStandScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((!= state 3))
			((or (Said 'yes') (Said 'play[/game]'))
				(gEgo setScript: diceGameScript)
				(self dispose:)
			)
			((Said 'no')
				(self cue:)
			)
		)
	)
)

(instance oldSaltStandScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oldSalt ignoreActors: 1 heading: 90 setCycle: Beg self)
			)
			(1
				(oldSaltChair show:)
				(oldSalt
					view: 132
					setCycle: Walk
					setLoop: -1
					setLoop: Grooper
					heading: 270
				)
				((oldSalt looper:) doit: oldSalt (oldSalt heading:))
				(= cycles 10)
			)
			(2
				(oldSalt
					cycleSpeed: 0
					setPri: -1
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 46 112 self
				)
			)
			(3
				(if (not (gEgo mover:))
					(HandsOn)
				)
				(if (!= (gEgo view:) 232)
					(User canControl: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance oldSaltChair of View
	(properties
		y 121
		x 235
		view 32
		cel 3
	)
)

(instance diceGameScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (gEgo view:) 32)
					(self setScript: egoSitScript self)
				else
					(= cycles 1)
				)
			)
			(1
				(gCurRoom newRoom: 39) ; diceRm
			)
		)
	)
)

(instance egoSitScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (== (gEgo onControl: 1) 8192)
					(gEgo setMotion: MoveTo 179 120 self)
				else
					(= cycles 1)
				)
			)
			(1
				(HandsOff)
				(if
					(or
						(= temp0 (< (gEgo x:) (- (egoChair x:) 32)))
						(= temp1 (< (gEgo y:) (- (egoChair y:) 8)))
					)
					(gEgo
						setAvoider: Avoid
						observeControl: 8192
						setMotion:
							MoveTo
							(- (egoChair x:) 32)
							(- (egoChair y:) 8)
							self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo
					ignoreControl: -24576
					setAvoider: 0
					setMotion:
						MoveTo
						(- (egoChair x:) 23)
						(+ (egoChair y:) 1)
						self
				)
			)
			(3
				(egoChair hide:)
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo
					view: 32
					setLoop: 7
					posn: (egoChair x:) (egoChair y:)
					setCel: 0
					cycleSpeed: 1
					yStep: 1
					setCycle: CT 7 1 self
				)
			)
			(4
				(gEgo
					setMotion: MoveTo (egoChair x:) (+ (egoChair y:) 4)
					setCycle: End self
				)
			)
			(5
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'sit')
				(Print 32 0) ; "You already are."
			)
		)
	)
)

(instance egoChair of View
	(properties
		y 107
		x 256
		view 32
		cel 4
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'sit')
				(if (== (gEgo view:) 32)
					(Print 32 0) ; "You already are."
				else
					(gEgo setScript: egoSitScript)
				)
			)
		)
	)
)

(instance stairsFeat of Feature
	(properties
		y 126
		x 66
		heading 180
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/stair,ladder]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 32 26) ; "Stairs leading to the control room."
					)
					((GoToIfSaid self event 62 130 'climb' 32 27))
					((Said 'climb')
						(gEgo setScript: climbStairsScript)
					)
				)
			)
		)
	)
)

(instance climbStairsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 62 126 self)
			)
			(1
				(gEgo heading: 0)
				((gEgo looper:) doit: gEgo)
				(= cycles 4)
			)
			(2
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo
					view: 32
					setLoop: 2
					setPri: 9
					cycleSpeed: 1
					illegalBits: 0
					setCel: 0
				)
				(= cycles 2)
			)
			(3
				(= start state)
				(gEgo posn: (+ (gEgo x:) 2) (- (gEgo y:) 7) setCel: 1)
				(= cycles 2)
			)
			(4
				(gEgo setCycle: CT 3 1 self)
			)
			(5
				(gEgo posn: (+ (gEgo x:) 2) (- (gEgo y:) 7) setCel: 4)
				(= cycles 2)
			)
			(6
				(gEgo setCycle: CT 0 1 self)
			)
			(7
				(self init:)
			)
		)
	)
)

(instance decendStairsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo
					view: 32
					setLoop: 3
					setPri: 9
					cycleSpeed: 1
					illegalBits: 0
					setCel: 0
				)
				(= cycles 2)
			)
			(1
				(= start state)
				(gEgo posn: (- (gEgo x:) 2) (- (gEgo y:) -7) setCel: 1)
				(= cycles 2)
			)
			(2
				(gEgo setCycle: CT 3 1 self)
			)
			(3
				(gEgo posn: (- (gEgo x:) 2) (- (gEgo y:) -7) setCel: 4)
				(= cycles 2)
			)
			(4
				(gEgo setCycle: CT 0 1 self)
			)
			(5
				(if (< (gEgo y:) 125)
					(self init:)
				else
					(gEgo
						view: 232
						heading: 180
						loop: 2
						setCycle: Walk
						setLoop: -1
						setLoop: Grooper
						cycleSpeed: 0
						setPri: -1
						observeControl: -32768
					)
					(HandsOn)
				)
			)
		)
	)
)

