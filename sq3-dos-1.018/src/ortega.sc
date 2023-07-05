;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	ortega 0
)

(local
	local0
)

(instance ortega of Rgn
	(properties)

	(method (init)
		(self keep: 0)
		(super init:)
		(Load rsVIEW 94)
		(Load rsVIEW 89)
		(Load rsSOUND 45)
		(Load rsSOUND 78)
	)

	(method (doit)
		(super doit:)
		(if global180
			(= global180 0)
			(gCurRoom setScript: FallDown)
		)
		(if (and global219 (> global171 1))
			(-- global171)
		)
		(if
			(and
				(== global171 1)
				(!= gCurRoomNum 62)
				(== (NearControl gEgo 15) 1)
				(== (gCurRoom script:) 0)
			)
			(gCurRoom setScript: FryToDeath)
		)
		(if (and global256 (not (-- global257)))
			(boom play:)
			(ShakeScreen 20 ssFULL_SHAKE)
			(= global257 (Random 10 600))
			(if (not global184)
				(Print 600 0) ; "Uh Oh! That detonator has apparently set off a chain reaction of earthquakes. You'd better get off this rock A.S.A.P."
				(= global184 1)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(cond
			((Said 'look>')
				(cond
					((Said '[/area,around,moon,dirt,ortega]')
						(if (== gCurRoomNum 70)
							(if global253
								(Print 600 1) ; "You find yourself at the base of a seemingly extinct volcano."
							else
								(Print 600 2) ; "You find yourself at the base of a seemingly extinct volcano. There is a short range scout ship parked here. But where is the pilot?"
							)
						else
							(Print 600 3) ; "The planet Ortega is truly a lava-lovers paradise.  Volcanic activity constantly reshapes it's surface, so if you have any maps older than last week, throw 'em out."
						)
					)
					((Said '/volcano')
						(Print 600 4) ; "In the distance, volcanoes spew magma from deep within the molten interior."
					)
					((Said '/lava')
						(Print 600 5) ; "Like a river of orange sludge, searing lava flows through the crevasses below you. Pleasure boating is not recommended."
					)
					((Said '/rock,boulder')
						(Print 600 6) ; "Throughout the years, many rocks have been deposited in the vicinity by the volcanic activity."
					)
					((Said '/lake')
						(Print 600 7) ; "Like a lake of orange sludge, searing lava flows through the crevasses below you. Pleasure boating is not recommended."
					)
					((Said '/air')
						(Print 600 8) ; "The atmosphere has a definite red tint to it from the belching volcanoes and glowing lava."
					)
					((Said '/ledge,cliff,edge')
						(Print 600 9) ; "The sheer cliffs lead straight down to the searing lava below. Watch your step."
					)
					((Said '/crack')
						(Print 600 10) ; "The ground is cracked by the constant heating and cooling of this unstable planet."
					)
					((Said '/cavity,canyon')
						(Print 600 11) ; "The molten lava casts a mysterious glow on the sides of the deep fissures. Watch your step."
					)
					((Said '/partition')
						(if
							(or
								(== gCurRoomNum 73)
								(== gCurRoomNum 74)
								(== gCurRoomNum 75)
							)
							(Print 600 12) ; "The smooth walls of the machine have no climbing surfaces."
						else
							(Print 600 13) ; "The smooth walls of the crevices have no climbing surfaces."
						)
					)
					((Said '/craft')
						(switch gCurRoomNum
							(62
								(Print 600 14) ; "Your faithful ship waits patiently for you to return and embark on your interplanetary wanderings."
							)
							(67
								(Print 600 15) ; "In the distance, your faithful ship waits patiently for you to return and embark on your interplanetary wanderings."
							)
							(70
								(if global253
									(Print 600 16) ; "I don't know about you, but I don't see any ships here."
								else
									(Print 600 17) ; "It's a speedy little short-range skull fighter, fully armed with the latest in offensive weaponry. You probably wouldn't want to tangle with one of these babies."
								)
							)
							(else
								(Print 600 16) ; "I don't know about you, but I don't see any ships here."
							)
						)
					)
				)
			)
			((Said 'open/door')
				(Print 600 18) ; "There are no doors on this planet."
			)
			((Said 'jump<off/cliff')
				(Print 600 19) ; "Jumping into boiling lava is not recommended."
			)
			((Said 'get/ladder')
				(if (or (== gCurRoomNum 74) (== gCurRoomNum 75))
					(Print 600 20) ; "The ladder is firmly attached to the machine."
				else
					(Print 600 21) ; "There's no ladder around here."
				)
			)
			((Said 'get/rock')
				(Print 600 22) ; "Come on, you've got better things to do than lug rocks around."
			)
			((Said 'get/dirt')
				(Print 600 23) ; "Don't bother; you'll just get dirty."
			)
			((Said 'use/pole')
				(if (!= gCurRoomNum 66)
					(CantDo) ; "That's not possible now."
				)
			)
			((Said '(turn<on),press,use/detonator')
				(if (gEgo has: 10) ; Thermal_Detonator
					(Print 600 24) ; "It has an impact switch, just drop it to set it off."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said 'wear/panties')
				(if (gEgo has: 5) ; ThermoWeave_Underwear
					(if global182
						(Print 600 25) ; "They're so comfortable, you forget that you're already wearing them."
					else
						(Print 600 26) ; "It would be a little embarassing to disrobe out here on the planets' surface. Why not go back to your ship?"
					)
				else
					(Print 600 27) ; "You don't have any."
				)
			)
			((Said 'remove/panties')
				(if global182
					(Print 600 28) ; "Nah, just leave 'em on."
				else
					(Print 600 29) ; "You're not wearing any shorts."
				)
			)
			((and (Said 'climb') (< gCurRoomNum 73))
				(Print 600 30) ; "The sharp edges of the cooled lava would slice you to ribbons. You decide against it."
			)
		)
	)
)

(instance FryToDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global159 1)
				(= global171 0)
				(Print 600 31) ; "Too late you realize that walking around unprotected on this planet is hazardous to your health. You feel your blood begin to boil."
				(gEgo
					view: 89
					setLoop: 0
					setCel: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(= cycles 10)
			)
			(4
				(Print 600 32) ; "You sizzle into oblivion. This planet wouldn't be so bad if you could keep cool somehow."
				(EgoDead 0 0 8 11)
				(= global159 0)
				(HandsOn)
			)
		)
	)
)

(instance FallDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(fallSound play:)
				(gEgo setLoop: setCel: 0 setStep: 6 12 setCycle: 0)
				(RedrawCast)
				(gEgo setMotion: MoveTo (gEgo x:) 229)
				(ohnoScript changeState: 0)
			)
			(1
				(EgoDead 0 0 1 2)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (fallSound prevSignal:) -1)
			(= local0 1)
		)
		(if (or local0 (== (fallSound state:) 0))
			(= local0 0)
			(self changeState: 1)
		)
	)
)

(instance ohnoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ohno init: setCycle: End self)
			)
			(1
				(ohno dispose:)
			)
		)
	)
)

(instance ohno of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 94
			setLoop: 0
			setCel: 0
			cycleSpeed: 1
			setPri: (gEgo priority:)
			posn: (gEgo x:) (- (gEgo y:) 40)
			ignoreActors: 1
		)
	)
)

(instance fallSound of Sound
	(properties
		number 45
		priority 3
	)
)

(instance boom of Sound
	(properties
		number 78
		priority 1
	)
)

