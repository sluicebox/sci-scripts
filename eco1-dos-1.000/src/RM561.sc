;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 561)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use eRS)
(use n819)
(use Talker)
(use Polygon)
(use Feature)
(use StopWalk)
(use Grooper)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	RM561 0
)

(local
	local0
)

(instance RM561 of EcoRoom
	(properties
		lookStr 3
		picture 561
		style -32759
		south 540
		picAngle 80
		vanishingX 180
		vanishingY -24
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 32) ; "The level of chemicals here make it unsafe to touch anything."
			)
			(10 ; Recycle
				(Narrator init: 43) ; "Garbage bagging this is way beyond Adam's skill."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(= local0 (gGame egoMoveSpeed:))
		(gGame egoMoveSpeed: 12)
		(SetFlag 143)
		(self
			setScript: fromAlgaeCaveScript
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 201 189 235 168 208 153 155 157 110 189 0 189
					yourself:
				)
		)
		(gFeatures
			add:
				deadFish
				deadPlant
				spiderWeb
				moss
				stalagmite
				caveOpening
				waste
				skullXbones
				barrels
				algae
			eachElementDo: #init
		)
		(gEgo
			setLoop: -1
			setPri: -1
			setLoop: toxicGroop
			setCycle: StopWalk 564
		)
		(cond
			((not (IsFlag 332)) 0)
			((IsFlag 331)
				(cable setLoop: 2 cel: 11 init: stopUpd:)
			)
			(else
				(cable setLoop: 6 cel: 4 init: stopUpd:)
			)
		)
		(gLongSong
			number: (if (not (SetFlag 110)) 560 else 563)
			loop: -1
			play:
		)
		(super init:)
	)

	(method (newRoom newRoomNumber)
		(if (OneOf (gLongSong number:) 560 563)
			(gLongSong fade:)
		)
		(gGame egoMoveSpeed: local0)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance fromAlgaeCaveScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 563
					ignoreHorizon: 1
					init:
					posn: 154 220
					z: 0
					setMotion: MoveTo 174 180 self
				)
			)
			(1
				(Narrator store: 36 init: 1 self) ; "A group of metal drums lies rusting in this hidden spot! A familiar greenish glow seeps from rusting patches in the metal."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance doCableStuff of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (IsFlag 330) (IsFlag 331))
					(beeper play:)
				)
				(gEgo put: 26 setMotion: MoveTo 175 125 self) ; steelCable
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gEgo
					view: 561
					setLoop: 1
					cel: 0
					posn: 204 110
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(3
				(gEgo setLoop: 2 cel: 0 posn: 180 110 setCycle: End self)
				(cable init: loop: 6 cel: 0 stopUpd:)
			)
			(4
				(client
					setScript:
						(cond
							((and (IsFlag 330) (IsFlag 331))
								(SetScore 10 333)
								attachCableAndXmitter
							)
							((IsFlag 331) attachCableAndFloat)
							(else attachCable)
						)
				)
			)
		)
	)
)

(instance attachCable of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cable loop: 6 cel: 0 setCycle: End self)
			)
			(1
				(Narrator init: 8 self) ; "Adam attaches the cable to the barrel. It drifts aimlessly in the current."
			)
			(2
				(gEgo view: 563 setLoop: -1 posn: 192 125 setCycle: Walk)
				(self dispose:)
			)
		)
	)
)

(instance attachCableAndFloat of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cable loop: 7 cel: 0 setCycle: End self)
			)
			(1
				(Narrator init: 9 self) ; "Adam attaches the cable to the barrel. The float rises silently to the surface."
			)
			(2
				(= seconds 1)
			)
			(3
				(Narrator init: 10 self) ; "The float is bobbing on the surface of the water. However, it's unlikely to summon help on its own."
			)
			(4
				(gEgo view: 563 setLoop: -1 posn: 179 140 setCycle: Walk)
				(self dispose:)
			)
		)
	)
)

(instance bringCableBack of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 192 125 self)
			)
			(1
				(gEgo setHeading: 360 self)
			)
			(2
				(if (IsFlag 331)
					(= register 1)
					(Narrator init: 11 self) ; "Adam retrieves the cable and float."
				else
					(= register 0)
					(Narrator init: 12 self) ; "Adam retrieves the cable."
				)
			)
			(3
				(gEgo
					view: 562
					setLoop: register
					cel: 0
					posn: 216 110
					cycleSpeed: 28
					setCycle: End self
				)
				(cable dispose:)
			)
			(4
				(gEgo
					get: 26 ; steelCable
					view: 563
					setLoop: -1
					posn: 179 140
					setCycle: Walk
					setMotion: MoveTo 150 160 self
				)
				(self dispose:)
			)
		)
	)
)

(instance attachCableAndXmitter of HandsOffScript
	(properties)

	(method (dispose)
		(if script
			(script dispose:)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cable loop: 2 setCycle: End self)
			)
			(1
				(Narrator init: 20 self) ; "Adam turns on the transmitter and attaches his improvised satellite buoy to the barrel! The float rises toward the surface. The transmitter is emitting a constant, powerful signal."
			)
			(2
				(= seconds 2)
			)
			(3
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 320)
				(gLongSong number: 923 loop: -1 play:)
				(ship init: setCycle: 0 setMotion: MoveTo 298 79 self)
				(wake init: setCycle: Fwd)
				(bouy init: setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(ship setMotion: 0 stopUpd:)
				(wake
					posn: 205 104
					loop: 2
					cel: 6
					cycleSpeed: 26
					setCycle: End self
				)
			)
			(5
				(wake stopUpd:)
				(= seconds 2)
			)
			(6
				(frog1 init: setCycle: CT 3 1 self)
				(frog2 init: stopUpd:)
				(wake dispose:)
			)
			(7
				(gSoundEffects number: 398 loop: 1 play:)
				(frog1 setCycle: End self)
			)
			(8
				(frog2 setCycle: CT 5 1 self)
			)
			(9
				(gSoundEffects number: 398 loop: 1 play:)
				(frog2 setCycle: End self)
			)
			(10
				(= seconds 2)
			)
			(11
				(beeper stop:)
				(gLongSong number: 420 loop: -1 play:)
				(gCurRoom drawPic: 901 9)
				(gCast eachElementDo: #hide)
				(= seconds 1)
			)
			(12
				(Narrator init: 35 self) ; "Adam watches from a distance as the divers carefully collect the drums. Grimly, they bear them to the surface and stow them on the boat for safe disposal on land. Adam gives the metal box and suit as evidence of illegal dumping. He returns to the reef to find Delphineus and continue the search for Cetus."
			)
			(13
				(gCurRoom newRoom: 560)
			)
		)
	)
)

(instance beeper of Sound
	(properties
		number 561
		loop -1
	)
)

(instance cable of Prop
	(properties
		x 216
		y 110
		approachX 210
		approachY 140
		view 560
		loop 2
		priority 6
		signal 18448
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: (if (IsFlag 331) 10 else 21))
			)
			(3 ; Do
				(gCurRoom setScript: bringCableBack)
			)
			(4 ; Inventory
				(switch invItem
					(32 ; transmitter
						(if (not (IsFlag 331))
							(Narrator init: 13) ; "Adam needs to retrieve the cable first."
						else
							(Narrator init: 16) ; "Adam needs to retrieve the float first."
						)
					)
					(27 ; float
						(Narrator init: 14) ; "Adam needs to retrieve the cable first."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance deadFish of Feature
	(properties
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Narrator init: (if (Random 0 1) 6 else 29))
			)
			(3 ; Do
				(Narrator init: (if (Random 0 1) 7 else 30))
			)
			(10 ; Recycle
				(gCurRoom doVerb: 10)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadPlant of Feature
	(properties
		onMeCheck 32
		lookStr 28
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 31) ; "The plants have absorbed a high level of toxin. It would be unwise to touch them."
			)
			(10 ; Recycle
				(gCurRoom doVerb: 10)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spiderWeb of Feature
	(properties
		onMeCheck 64
		lookStr 26
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 32) ; "The level of chemicals here make it unsafe to touch anything."
			)
			(10 ; Recycle
				(gCurRoom doVerb: 10)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stalagmite of Feature
	(properties
		onMeCheck 128
		lookStr 37
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Narrator init: lookStr 0 560)
			)
			(10 ; Recycle
				(gCurRoom doVerb: 10)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance waste of Feature
	(properties
		onMeCheck 16384
		lookStr 2
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(if (== theVerb 10) ; Recycle
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: &rest)
		)
	)
)

(instance skullXbones of Feature
	(properties
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(barrels doVerb: theVerb &rest)
	)
)

(instance barrels of Feature
	(properties
		onMeCheck 4096
		lookStr 2
	)

	(method (doVerb theVerb invItem)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 5) ; "The barrels are rusting. It would be unsafe to touch them."
			)
			(10 ; Recycle
				(gCurRoom doVerb: 10)
			)
			(4 ; Inventory
				(switch invItem
					(26 ; steelCable
						(SetScore 5 332)
						(gCurRoom setScript: doCableStuff)
					)
					(32 ; transmitter
						(Narrator init: 37) ; "These barrels don't need any more leaks!"
					)
					(13 ; sharpShell
						(Narrator init: 37) ; "These barrels don't need any more leaks!"
					)
					(17 ; spine
						(Narrator init: 38) ; "The spine carries a natural poison - but it won't cancel out the chemical poisons found here."
					)
					(21 ; healingPotion
						(Narrator init: 39) ; "Demeter's healing potion is powerless against such strong toxins."
					)
					(27 ; float
						(Narrator init: 40) ; "That's a good idea, but Adam would need to attach it to something first."
					)
					(30 ; hackSaw
						(Narrator init: 41) ; "Liberating all those chemicals into the water wouldn't be helpful."
					)
					(12 ; trident
						(Narrator init: 37) ; "These barrels don't need any more leaks!"
					)
					(else
						(Narrator init: 42) ; "The barrels are hopelessly contaminated. That won't help."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance algae of Feature
	(properties
		onMeCheck 1024
		lookStr 38
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(if (== theVerb 10) ; Recycle
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance moss of Feature
	(properties
		onMeCheck 512
		lookStr 27
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(if (== theVerb 10) ; Recycle
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance caveOpening of Feature
	(properties
		onMeCheck 256
		lookStr 4
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance ship of Actor
	(properties
		x 270
		y 86
		view 324
		loop 1
		signal 18432
		cycleSpeed 28
	)
)

(instance wake of Prop
	(properties
		x 286
		y 114
		view 324
		cycleSpeed 18
	)

	(method (doit)
		(if (ship mover:)
			(= x (- (ship x:) 12))
			(= y (+ (ship y:) 35))
		)
		(super doit: &rest)
	)
)

(instance frog1 of Prop
	(properties
		x 170
		y 114
		view 324
		loop 3
		priority 11
		signal 16400
		cycleSpeed 22
	)
)

(instance frog2 of Prop
	(properties
		x 226
		y 112
		view 324
		loop 4
		priority 11
		signal 16400
		cycleSpeed 22
	)
)

(instance bouy of Prop
	(properties
		x 124
		y 164
		view 560
		loop 3
		cel 2
		signal 16384
		cycleSpeed 14
	)
)

(instance toxicGroop of Grooper
	(properties)

	(method (doit &tmp temp0)
		(super doit: &rest)
	)
)

