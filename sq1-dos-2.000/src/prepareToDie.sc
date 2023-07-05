;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 303)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	prepareToDie 0
	slotGuy 1
	slotGuyBody 2
)

(instance prepareToDie of Script
	(properties)

	(method (init)
		(= register (Random 7 14))
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 30 60))
			)
			(1
				(if
					(and
						(<= (-- register) 0)
						(or
							(== (gEgo view:) 30)
							(not (& (gEgo onControl:) $4002))
						)
					)
					(HandsOff)
					(if (not (== (gEgo view:) 30))
						(Face gEgo slotGuy)
					)
					(self changeState: 6)
				else
					(slotGuy setLoop: 1 cycleSpeed: 8 setCycle: End self)
				)
			)
			(2
				((ScriptID 43 2) setCycle: Fwd) ; slot
				(= cycles (Random 15 60))
			)
			(3
				((ScriptID 43 2) setCycle: 0) ; slot
				(slotGuy setLoop: 2 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(4
				(= state 0)
				(slotGuy setLoop: 2 cel: 2 cycleSpeed: 1 setCycle: Beg self)
			)
			(5
				(if (== client gEgo)
					(= seconds 2)
				else
					(= cycles 3)
				)
			)
			(6
				(self setScript: (ScriptID 43 1) self (ScriptID 303 1)) ; someoneDied, slotGuy
			)
			(7
				(cond
					((== client gEgo)
						(gCurRoom newRoom: 42)
					)
					((not global188)
						(HandsOn)
						(if (== (gEgo view:) 30)
							(User canControl: 0)
						)
					)
				)
				(gLongSong2 stop:)
				(self dispose:)
			)
		)
	)
)

(instance slotGuy of Prop
	(properties
		x 265
		y 82
		description {slot guy}
		lookStr {Some strange, blue dude currently monopolizes the Slots-O-Death machine.}
		view 443
		loop 1
		priority 7
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(11 ; Taste
				(Print 303 0) ; "Most extraterrestrials won't do that on the first date. Maybe you should just listen to them."
			)
			(5 ; Talk
				(Print 303 1) ; "He doesn't have the time to talk to you."
			)
			(12 ; Smell
				(Print 303 2) ; "Sniffing others is a ritual best left to dogs and other four-legged creatures."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 303 3) ; "From the way he keeps feeding the slot machine, it would seem he has plenty of money."
					)
					(0 ; Cartridge
						(Print 303 4) ; "All he really cares about is playing the slot machine."
					)
					(15 ; Widget
						(Print 303 5) ; "He doesn't care about your widget. Did you expect him to?"
					)
					(2 ; Gadget
						(Print 303 6) ; "He's far too engrossed in his present activity to pay attention to your gadget."
					)
					(4 ; Knife
						(Print 303 7) ; "He only has eyes for the slot machine."
					)
					(5 ; Dehydrated_Water
						(Print 303 8) ; "He's much too busy winning to take a drink."
					)
					(11 ; Jetpack
						(Print 303 9) ; "You show the little blue alien your terrific new jet pack. He's not particulary impressed."
					)
					(17 ; Bar_Coupon
						(Print 303 10) ; "If he can't use it in the slot machine, he doesn't want it."
					)
					(18 ; Droids-B-Us_coupon
						(Print 303 10) ; "If he can't use it in the slot machine, he doesn't want it."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (dispose)
		(self setScript: 0 setCycle: 0)
		(slotGuyBody dispose:)
		(super dispose:)
		(self delete:)
		(UnLoad 443)
		(DisposeScript 303)
	)
)

(instance slotGuyBody of Prop
	(properties
		x 263
		y 104
		view 443
		cycleSpeed 4
	)

	(method (doVerb theVerb)
		(slotGuy doVerb: theVerb &rest)
	)

	(method (dispose)
		(self setCycle: 0)
		(super dispose:)
		(self delete:)
	)
)

