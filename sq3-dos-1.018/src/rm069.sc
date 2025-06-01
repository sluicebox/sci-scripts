;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 69)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	rm069 0
)

(local
	local0
	local1
	local2
)

(instance rm069 of Rm
	(properties
		picture 69
		horizon 82
		north 66
		east 70
	)

	(method (init &tmp [temp0 50])
		(HandsOn)
		(self setRegions: 600) ; ortega
		(Load rsVIEW 92)
		(if (not (gEgo has: 9)) ; Metal_Pole
			(anemo init:)
			(pole init:)
		)
		(if (not global253)
			(Load rsVIEW 93)
			(Load rsSOUND 38)
			(Load rsSOUND 44)
			(pirate1 init:)
			(pirate2 init:)
			(= local0 30)
		)
		(super init:)
		(switch gPrevRoomNum
			(66
				(gEgo posn: 81 84 init:)
			)
			(70
				(gEgo
					posn:
						317
						(if (< (gEgo y:) 80)
							83
						else
							(gEgo y:)
						)
					init:
				)
			)
			(690
				(gEgo view: 0 loop: 0 cel: 0 posn: 70 155 init:)
				(gEgo setLoop: -1)
			)
		)
		(TheMenuBar draw:)
		(SL enable:)
	)

	(method (newRoom newRoomNumber)
		(if (not script)
			(gTimers eachElementDo: #dispose)
			(if global256
				(++ global593)
			)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit &tmp temp0 [temp1 50])
		(super doit:)
		(if local1
			(gCurRoom newRoom: 690)
		)
		(if global219
			(-- local0)
		)
		(if (and (== local0 1) (not script))
			(= local0 0)
			(gCurRoom setScript: LeaveScript)
		)
		(if (not (gCurRoom script:))
			(cond
				((== (= temp0 (gEgo onControl:)) 3)
					(gEgo setPri: 3 illegalBits: 0)
					(= global180 1)
				)
				((and (== temp0 5) (not global253))
					(gCurRoom setScript: shootScript)
				)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look>')
				(cond
					((Said '/gun')
						(if global253
							(Print 69 0) ; "There aren't any weapons here."
						else
							(Print 69 1) ; "The pirates are packing jello pistols."
						)
					)
					((Said '/[around,area]')
						(if global253
							(Print 69 2) ; "The planet Ortega is truly a lava-lovers paradise.  Volcanic activity constantly reshapes its surface, so if you have any maps older than last week, throw 'em out. A few pieces of research equipment are laying around."
						else
							(Print 69 3) ; "Two ScumSoft lackeys are working at a make-shift research station. They appear to be monitoring the seismic activity of this area."
						)
					)
					((Said '/craft')
						(if local2
							(Print 69 4) ; "The speeding ship is only a blur."
						else
							(event claimed: 0)
						)
					)
					(
						(Said
							'/station,device,device,equipment[<seismic,research]'
						)
						(if (gEgo has: 9) ; Metal_Pole
							(Print 69 5) ; "There's a telescope, some seismic equipment, and a crate of some sort."
						else
							(Print 69 6) ; "There's a telescope, an anemometer on a pole, some seismic equipment, and a crate of some sort."
						)
					)
					((Said '/pole')
						(if (IsItemAt 9) ; Metal_Pole
							(Print 69 7) ; "A handy metal pole with a thousand and one uses."
						else
							(event claimed: 0)
						)
					)
					((Said '/anemometer')
						(Print 69 8) ; "It looks like a couple of tennis balls cut in half, and spins when the wind blows."
					)
					((Said '/antenna')
						(Print 69 9) ; "It's used for sending and receiving data."
					)
					((Said '/box')
						(if (gEgo inRect: 220 141 254 155)
							(Print 69 10) ; "It's full of thermal detonators."
						else
							(Print 69 11) ; "From here it just looks like an old crate."
						)
					)
					((Said '<in,in,through/scope')
						(if (gEgo inRect: 56 139 76 159)
							(gCurRoom setScript: ScopeScript)
						else
							(Print 69 12) ; "You need to get real close and look in the little hole first."
						)
					)
					((Said '/scope')
						(Print 69 13) ; "It looks like it's probably used for surveying and stuff like that."
					)
					((Said '/rock,boulder')
						(Print 69 14) ; "Piles of large volcanic rocks have accumulated here at the base of this volcano."
					)
				)
			)
			((Said 'get>')
				(cond
					(
						(Said
							'/antenna,station,device,equipment[<seismic,research]'
						)
						(Print 69 15) ; "Most of this stuff is too heavy for one person to carry."
					)
					((or (Said '/scope') (Said '/box'))
						(Print 69 16) ; "Nah, it wouldn't do you any good."
					)
					((Said '/anemometer')
						(cond
							((gEgo has: 9) ; Metal_Pole
								(Print 69 17) ; "It's attached to your pole."
							)
							((gEgo inRect: 230 129 260 143)
								(Print 69 18) ; "It's attached firmly to the pole; it won't budge."
							)
							(else
								(NotClose) ; "It's not quite within reach."
							)
						)
					)
					((Said '/pole')
						(cond
							((gEgo has: 9) ; Metal_Pole
								(Print 69 19) ; "Only one per customer please."
							)
							((gEgo inRect: 230 129 260 143)
								(Print 69 20) ; "It's all yours!"
								(gEgo get: 9) ; Metal_Pole
								(pole dispose:)
								(gGame changeScore: 10)
								(anemo dispose:)
							)
							(else
								(NotClose) ; "It's not quite within reach."
							)
						)
					)
					((Said '/detonator')
						(cond
							((gEgo has: 10) ; Thermal_Detonator
								(Print 69 19) ; "Only one per customer please."
							)
							((gEgo inRect: 220 141 254 155)
								(Print 69 21) ; "You pick up one of the detonators. Be careful, you could blow your fingers off with that thing."
								(gGame changeScore: 10)
								(gEgo get: 10) ; Thermal_Detonator
							)
							(else
								(NotClose) ; "It's not quite within reach."
							)
						)
					)
				)
			)
			((Said 'hide')
				(Print 69 22) ; "The pirates are hard at work, they won't notice you if you stay where you are."
			)
			((Said 'use/scope')
				(if (gEgo inRect: 56 139 76 159)
					(gCurRoom setScript: ScopeScript)
				else
					(Print 69 12) ; "You need to get real close and look in the little hole first."
				)
			)
			((Said 'kill/man,flunky')
				(if global253
					(Print 69 23) ; "Quite the swashbuckler, aren't we? Too bad there's nobody here."
				else
					(Print 69 24) ; "With what, your breath?"
				)
			)
			((Said 'talk[/man,flunky]')
				(if global253
					(Print 69 25) ; "Quite the talker, aren't we? Too bad there's nobody here."
				else
					(Print 69 26) ; "Get a little closer."
				)
			)
			((Said 'open/box')
				(Print 69 27) ; "The crate is already open."
			)
		)
	)
)

(instance ScopeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(if (gEgo inRect: 67 139 76 149)
					(gEgo setMotion: MoveTo 63 155 self)
				else
					(= cycles 2)
				)
			)
			(1
				(gEgo setMotion: MoveTo 70 155 self)
			)
			(2
				(gEgo
					view: 92
					setLoop: 4
					cel: 0
					illegalBits: $8000
					setCycle: End self
				)
			)
			(3
				(= local1 1)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance shootScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 108 123 self)
				(pirate1 setScript: 0 setLoop: 3 setCycle: End)
			)
			(1
				(gEgo setCycle: 0)
				(jello play:)
				(pirate1 setLoop: 4 setCycle: End self)
			)
			(2
				(blast init: setCycle: End self)
				(pirate1 setLoop: 3 setCel: 5 setCycle: Beg)
			)
			(3
				(pirate1 stopUpd:)
				(blast dispose:)
				(gEgo view: 92 setLoop: 2 setCycle: Fwd)
				(= seconds 5)
			)
			(4
				(Print 69 28) ; "Way to go, ace! You blundered your way to within range of the pirates' jello gun. You suffocate in an impenetrable block of jello."
				(EgoDead 0 0 7 15) ; "As your life sputters to a close, you decide to cut down on desserts."
			)
		)
	)
)

(instance LeaveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 1)
				(gEgo setCycle: 0 setMotion: 0)
				(pirate2
					setScript: 0
					setLoop: 0
					setCycle: Walk
					ignoreControl: 1
					setMotion: MoveTo 71 158 self
				)
				(pirate1
					setScript: 0
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 329 (pirate1 y:)
				)
			)
			(1
				(pirate2 setMotion: MoveTo 329 (pirate2 y:) self)
			)
			(2
				(pirate1 dispose:)
				(pirate2 dispose:)
				(Print 69 29) ; "You hear the roar of the pirates' scout ship taking off.  The ship streaks across the sky to an unknown destination."
				(zoom play:)
				(= global253 1)
				(= seconds 3)
			)
			(3
				(= local2 1)
				(ship init: setMotion: MoveTo 290 25 self)
			)
			(4
				(ship setCel: 1 setMotion: MoveTo 241 25 self)
			)
			(5
				(ship setCel: 2 setMotion: MoveTo 228 24 self)
			)
			(6
				(ship setCel: 3 setMotion: MoveTo 230 17 self)
			)
			(7
				(ship setCel: 4 setMotion: MoveTo 238 13 self)
			)
			(8
				(ship setCel: 5 setMotion: MoveTo 245 10 self)
			)
			(9
				(ship setCel: 6 setMotion: MoveTo 255 0 self)
			)
			(10
				(= local2 0)
				(ship dispose:)
				(gEgo setCycle: Walk)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance p1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance p2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance pirate1 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 93
			setLoop: 2
			setCel: 0
			setPri: -1
			posn: 215 126
			ignoreActors: 1
			setScript: p1Script
		)
	)
)

(instance pirate2 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 93
			setLoop: 6
			setCel: 0
			setPri: -1
			posn: 75 154
			ignoreActors: 1
			setScript: p2Script
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look/flunky,man,clerk')
			(Print 69 30) ; "Obviously loyal company men, the ScumSoft employees are happily performing their duties. But looking at their weapons, you probably don't want to get too close."
		)
	)
)

(instance ship of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 92
			setLoop: 3
			setCel: 0
			setStep: 10 5
			setPri: 15
			x: 332
			y: 25
			ignoreActors: 1
			ignoreHorizon: 1
			ignoreControl: 1
		)
	)
)

(instance blast of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 93
			setLoop: 5
			setCel: 0
			setPri: 8
			posn: 153 110
			ignoreActors: 1
		)
	)
)

(instance pole of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 92
			posn: 248 134
			setLoop: 1
			setCel: 0
			setPri: 10
			ignoreActors: 1
		)
	)
)

(instance anemo of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 92
			setLoop: 0
			setCel: 0
			setPri: 11
			posn: 247 99
			ignoreActors: 1
			setCycle: Fwd
			cycleSpeed: 0
		)
	)
)

(instance jello of Sound
	(properties
		number 44
		priority 1
	)
)

(instance zoom of Sound
	(properties
		number 38
		priority 1
	)
)

