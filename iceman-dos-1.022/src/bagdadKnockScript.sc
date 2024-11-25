;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 365)
(include sci.sh)
(use Main)
(use Interface)
(use tunisia)
(use n954)
(use Avoid)
(use Motion)
(use User)
(use System)

(public
	bagdadKnockScript 0
	handsUpScript 1
)

(local
	local0
)

(instance bagdadKnockScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 365 0) ; "After anxiously awaiting the caterer, you hear footsteps outside the apartment door."
				(Print 365 1) ; "You then hear a loud knock at the door."
				(= seconds 10)
			)
			(1
				(Print 365 2) ; "From the apartment door comes a second loud knock."
				(= seconds 10)
			)
			(2
				(Print 365 3) ; "The caller outside the apartment door seems to have given up as you hear fading footsteps in the hallway."
				(= seconds 5)
			)
			(3
				(tunisia flags: (| (tunisia flags:) $0004))
				(self dispose:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (> state 1) (or (Said 'answer,open/door') (Said 'answer')))
				(Print 365 4) ; "Too late. They've already left."
			)
			((GoToIfSaid self event 93 156 'answer,open/door')
				(= seconds 0)
			)
			((Said 'answer,open/door')
				((ScriptID 310 4) init: posn: 126 200) ; bagdad
				(= caller 0)
				(client setScript: bagdadInScript)
			)
		)
	)
)

(instance bagdadInScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(tunisia flags: (| (tunisia flags:) $0002))
				(gEgo setAvoider: Avoid setMotion: MoveTo 95 159 self)
			)
			(1
				(Print 365 5) ; "You open the door and let the caterer inside."
				((ScriptID 310 4) setCycle: Walk setMotion: MoveTo 126 150 self) ; bagdad
			)
			(2
				(Print 365 6) ; "Here is your order," he says, "Hot and ready to eat."
				((ScriptID 310 4) illegalBits: 0 setMotion: MoveTo 210 112 self) ; bagdad
				(gEgo setAvoider: 0 setMotion: MoveTo 131 112)
			)
			(3
				((ScriptID 310 4) ; bagdad
					view: 584
					setLoop: 3
					cel: 0
					cycleSpeed: 2
					setCycle: CT 1 1 self
				)
			)
			(4
				((ScriptID 310 4) cycleSpeed: 0 setCycle: CT 4 1 self) ; bagdad
				((ScriptID 310 5) init: setPri: 9 stopUpd:) ; plate
			)
			(5
				((ScriptID 310 4) ; bagdad
					setCycle: Walk
					setMotion:
						MoveTo
						(- ((ScriptID 310 4) x:) 15) ; bagdad
						((ScriptID 310 4) y:) ; bagdad
						self
				)
			)
			(6
				(= seconds 2)
			)
			(7
				(Print 365 7) ; "After putting the food on the counter, the caterer says, "That will be $15.00, please.""
				(= cycles 1)
			)
			(8
				(gEgo heading: 90 cycleSpeed: 1)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 3)
			)
			(9
				(gEgo cycleSpeed: 0)
				(tunisia flags: (| (tunisia flags:) $0001))
				(HandsOn)
				(= seconds 10)
			)
			(10
				(Print 365 8) ; "The caterer says to you again, "That will be $15.00, please.""
				(= seconds 8)
			)
			(11
				(Print 365 9) ; "Impatiently, the caterer says, "Sir, I must be going, please pay me!""
				(= seconds 6)
			)
			(12
				(HandsOff)
				(Print 365 10) ; "Disgusted, the caterer decides he has more important things to do than wait for you."
				(client setScript: bagdadOutScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(Said
					'shoot,draw,use/man,bagdad,gun,tranquilizer,(gun<tranquilizer)'
				)
				(cond
					((not (gEgo has: 8)) ; Sub: Device | Tunisia: Tranquilizer_Gun
						(proc0_38) ; "You don't have that."
					)
					((== (gEgo view:) 584)
						(Print 365 11) ; "You almost use the weapon to subdue the caterer but decide to save your limited ammo for the compound guards."
					)
					(else
						(client setScript: getInPosnScript)
					)
				)
			)
			(
				(or
					(Said 'change,detach<tell<bagdad,man[/clothes]')
					(Said 'change,detach,(get<off)/clothes')
					(Said 'undress')
				)
				(HandsOff)
				(Print 365 12) ; ""You must be crazy!" he says to you in disgust."
				(client setScript: bagdadOutScript)
			)
			(
				(or
					(Said 'pay,give/man,bagdad,money')
					(Said 'give/money<to/man,bagdad')
					(Said 'give/money<man,bagdad')
				)
				(Print 365 13) ; "You don't have any money."
			)
			((Said 'hit/man,bagdad[/gun<with]')
				(Print 365 14) ; "That wouldn't help the mission."
			)
			((Said 'heist,get/man,money[/man<from]')
				(Print 365 15) ; "This is not a robbery, Johnny!"
			)
		)
	)
)

(instance getInPosnScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((gEgo inRect: 223 94 271 124)
						(gEgo illegalBits: 0 setMotion: MoveTo 235 91 self)
					)
					((gEgo inRect: 209 83 254 93)
						(gEgo setMotion: MoveTo 206 93 self)
					)
					((gEgo inRect: 218 132 317 153)
						(gEgo setMotion: MoveTo 214 136 self)
					)
					((and (== (gEgo x:) 131) (== (gEgo y:) 112))
						(= cycles (= register 1))
					)
					(else
						(gEgo setMotion: MoveTo 131 112 self)
						(= register 1)
					)
				)
			)
			(1
				(if register
					(= cycles 1)
				else
					(self init:)
				)
			)
			(2
				(gEgo setMotion: MoveTo (+ (gEgo x:) 5) (gEgo y:) self)
			)
			(3
				(gEgo
					view: 584
					illegalBits: $8000
					cel: 0
					loop: 2
					setCycle: End
				)
				(Print 365 16) ; ""FREEZE," you command."
				(client setScript: handsUpScript)
				(User canInput: 1)
			)
		)
	)
)

(instance bagdadOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo inRect: 84 142 142 160)
					(gEgo setMotion: MoveTo 80 140)
				)
				((ScriptID 310 4) loop: 9 cel: 0 setCycle: CT 1 1 self) ; bagdad
			)
			(1
				((ScriptID 310 4) ; bagdad
					setAvoider: Avoid
					setCycle: Walk
					setMotion:
						MoveTo
						(+ ((ScriptID 310 4) x:) 15) ; bagdad
						((ScriptID 310 4) y:) ; bagdad
						self
				)
			)
			(2
				((ScriptID 310 4) setCycle: End self) ; bagdad
				((ScriptID 310 5) dispose:) ; plate
			)
			(3
				((ScriptID 310 4) ; bagdad
					view: 184
					setCel: -1
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 126 150 self
				)
			)
			(4
				((ScriptID 310 4) ; bagdad
					setMotion: MoveTo ((ScriptID 310 4) x:) 210 self ; bagdad
				)
				(gEgo heading: 180 cycleSpeed: 1)
				((gEgo looper:) doit: gEgo (gEgo heading:))
			)
			(5
				(tunisia flags: (| (tunisia flags:) $0004))
				(client cue:)
			)
		)
	)
)

(instance handsUpScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gIceKeyDownHandler add: self)
	)

	(method (dispose)
		(gIceKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 310 4) ; bagdad
					view: 584
					setLoop: 4
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(Print 365 17) ; "Nervously, the caterer puts his hands over his head and says, "Please show mercy! I only have $50.00.""
				(= register 100)
			)
			(3
				(= register 0)
				(HandsOff)
				((ScriptID 310 4) ; bagdad
					setCel: 0
					setLoop: 5
					ignoreActors: 1
					setCycle: CT 14 1 self
				)
			)
			(4
				((ScriptID 310 7) ; bClothes
					init:
					posn: ((ScriptID 310 4) x:) (+ ((ScriptID 310 4) y:) 1) ; bagdad, bagdad
					stopUpd:
					ignoreActors: 1
				)
				((ScriptID 310 4) cel: 15) ; bagdad
				(= cycles 2)
			)
			(5
				(= register 100)
				(Print 365 18) ; ""What now," he asks."
				(User canInput: 1)
			)
			(6
				(HandsOff)
				(= register 0)
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo
					view: 84
					setCycle: Walk
					setMotion:
						MoveTo
						(- ((ScriptID 310 4) x:) 7) ; bagdad
						(+ ((ScriptID 310 4) y:) 1) ; bagdad
						self
				)
			)
			(8
				(gEgo heading: 0 cycleSpeed: 1)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 1)
			)
			(9
				((ScriptID 310 4) loop: 8 cel: (+ 0 (* 3 local0))) ; bagdad
				(gEgo loop: 7 cel: 0)
				(= cycles 2)
			)
			(10
				(gEgo cel: 1)
				(= cycles 2)
			)
			(11
				(gEgo cel: 2)
				(= cycles 2)
				((ScriptID 310 4) cel: (+ 1 (* 3 local0))) ; bagdad
			)
			(12
				(gEgo cel: 1)
				(= cycles 2)
			)
			(13
				(gEgo cel: 2)
				(= cycles 2)
				((ScriptID 310 4) cel: (+ 2 (* 3 local0))) ; bagdad
			)
			(14
				((ScriptID 310 4) ignoreActors: 0) ; bagdad
				(gEgo cel: 1)
				(= cycles 2)
			)
			(15
				(gEgo cel: 2)
				(= cycles 2)
			)
			(16
				(gEgo view: 84)
				(= seconds 2)
			)
			(17
				(Print 365 19) ; "You securely bind the hands and feet of the caterer. You then tape his mouth to prevent his yelling for help."
				(gGame changeScore: 3)
				(if local0
					(HandsOn)
					(= register 2)
				else
					(= cycles 1)
				)
			)
			(18
				(gEgo heading: 270 cycleSpeed: 1)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 1)
			)
			(19
				(gEgo
					view: 584
					cel: 0
					loop: 0
					cycleSpeed: 1
					setCycle: CT 14 1 self
				)
			)
			(20
				((ScriptID 310 6) ; eClothes
					init:
					posn: (gEgo x:) (+ (gEgo y:) 1)
					stopUpd:
					ignoreActors: 1
				)
				(gEgo cel: 15)
				(= cycles 2)
			)
			(21
				(gEgo cel: 0 loop: 6 setCycle: CT 13 1 self)
			)
			(22
				((ScriptID 310 7) dispose:) ; bClothes
				(gEgo cel: 14)
				(= cycles 1)
			)
			(23
				(gEgo cel: 15)
				(= cycles 2)
			)
			(24
				(Print 365 20) ; "You don the caterer's clothes as a disguise."
				(tunisia bagBound: 1)
				(tunisia flags: (| (tunisia flags:) $0001))
				((ScriptID 310 4) stopUpd:) ; bagdad
				(HandsOn)
				(gEgo
					view: 684
					setCycle: Walk
					loop: 1
					setLoop: -1
					cycleSpeed: 0
				)
				(= cycles 2)
			)
			(25
				(client cue:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and register (== (-- register) 1))
			(tunisia flags: (| (tunisia flags:) $0004))
			(client cue:)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_F10))
					(Said 'shoot,fire,kill[/man,bagdad,gun]')
				)
				(Print 365 11) ; "You almost use the weapon to subdue the caterer but decide to save your limited ammo for the compound guards."
			)
			(
				(or
					(Said 'change<tell<bagdad,man[/clothes]')
					(Said 'change,detach,(get<off)/clothes')
					(Said 'get/clothes[/man,bagdad]')
					(Said 'undress')
				)
				(cond
					((and (> state 4) (not local0))
						(Print 365 21) ; ""I am already undressed," he says to you with a puzzled look."
					)
					((and (> state 4) local0)
						(Print 365 22) ; "He can't comply."
					)
					(else
						(Print 365 23) ; "This is not a robbery," you say, "What I need is your caterer's uniform."
						(Print 365 24) ; ""I must ask you to remove the uniform," you continues."
						(self cue:)
					)
				)
			)
			(
				(or
					(Said 'bind,bind[<up]/man,bagdad[<up]')
					(Said 'use/tape')
					(Said '/man,bagdad<tape')
					(Said '//clothes<for')
				)
				(cond
					((not (gEgo has: 7)) ; Sub: Flare | Tunisia: Duct_Tape
						(Print 365 25) ; "You need something to tie him up."
						(tunisia flags: (| (tunisia flags:) $0004))
						(client cue:)
					)
					((< state 3)
						(= local0 1)
						(= start 6)
						((ScriptID 310 4) ignoreActors: 1) ; bagdad
						(self init:)
					)
					(else
						(self cue:)
					)
				)
			)
			(
				(or
					(Said 'pay,give/man,bagdad,money')
					(Said 'give/money<to/man,bagdad')
					(Said 'give/money<man,bagdad')
				)
				(Print 365 13) ; "You don't have any money."
			)
			((Said 'hit/man,bagdad[/gun<with]')
				(Print 365 14) ; "That wouldn't help the mission."
			)
			((Said 'heist,get/man,money[/man<from]')
				(Print 365 15) ; "This is not a robbery, Johnny!"
			)
		)
	)
)

