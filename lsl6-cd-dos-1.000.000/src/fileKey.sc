;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 77)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use System)

(public
	fileKey 0
	strikeMatch 1
	stripTWire 2
)

(instance fileKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(1
				(gEgo
					view: 87
					loop: 0
					setSpeed: 12
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo loop: 1 setCycle: Fwd)
				(sFx number: 37 play: setLoop: 1)
				(= ticks 100)
			)
			(3
				(gGame changeScore: 10 173 changeScore: 20 150)
				(gEgo put: 34 put: 12) ; soap, bastardfile
				((gInventory at: 21) noun: 55 message: 52) ; randomKey
				(Message msgGET 85 6 0 14 1 global186) ; "Random Room Key"
				(gMessager say: 6 63 1 0 0 85) ; "YES! You carefully file this key with your bastard file, using the "Impressed Soap" for a pattern."
				(gEgo normalize: 900 3 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance strikeMatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 86
					loop: 0
					setCel: 0
					setSpeed: 12
					setCycle: End self
				)
				(sFx number: 332 setLoop: 1 play: 127)
			)
			(1
				(gGame changeScore: 12 157)
				(Message msgGET 85 22 0 14 1 global186) ; "Match"
				(gMessager say: 22 6 0 1 self 85) ; "(SOUND FX FIRST OF MATCH LIGHTING) You did it!"
			)
			(2
				(gEgo normalize: 900 2 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stripTWire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 89
					loop: 0
					setCel: 0
					setSpeed: 12
					setCycle: End self
				)
			)
			(1
				(gEgo loop: 1 setCycle: Fwd)
				(= ticks 30)
			)
			(2
				(gEgo loop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(gGame changeScore: 12 151)
				(gEgo normalize: 900 2 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFx of Sound
	(properties)
)

