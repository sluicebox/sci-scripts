;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 675)
(include sci.sh)
(use Main)
(use eRS)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm675 0
)

(instance rm675 of FPRoom
	(properties
		noun 12
		picture 675
		style 10
	)

	(method (init)
		(gGameMusic1 number: 675 flags: 1 loop: -1 play:)
		(proc0_8 1)
		(= gCurPuzzle 20)
		(gEgo wearingGuns: 1 get: -1 44) ; Pistols
		(super init:)
		(aces init: setOnMeCheck: 1 2)
		(acesMoney init: setOnMeCheck: 1 4)
		(gambler4Money init: setOnMeCheck: 1 8)
		(pot init: setOnMeCheck: 1 16)
		(gambler1 init: setOnMeCheck: 1 256)
		(gambler2 init: setOnMeCheck: 1 32)
		(gambler3 init: setOnMeCheck: 1 64)
		(gambler4 init: setOnMeCheck: 1 128)
		(sceneFrame init: setOnMeCheck: 1 512)
		(pokerTable init: setOnMeCheck: 1 1024)
		(cardFan init:)
		(thirdHand init: setScript: sRandomHand)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; icon10
				(proc0_8 0)
				(gCurRoom newRoom: 670)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sRandomHand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 480 660))
			)
			(1
				(armSound play:)
				(thirdHand setLoop: 1 setMotion: MoveTo 165 98 self)
			)
			(2
				(armSound play:)
				(thirdHand setLoop: 1 setMotion: MoveTo 165 130 self)
			)
			(3
				(thirdHand stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance sCaughtCheating of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGameMusic1 number: 677 flags: 1 loop: -1 play:)
				(thirdHand
					setScript: 0
					setLoop: 1
					setMotion: MoveTo 165 130 self
				)
			)
			(1
				(gGame points: 10 141 self)
			)
			(2
				(gMessager say: 14 0 0 1 2 self) ; "You're cheating! That's a fake left hand! Your real hand is hidden under the table! You've been feeding good cards into your hand and taking away the bad ones!"
			)
			(3
				(thirdHand
					setLoop: 3
					setCel: 0
					posn: 162 117
					setPri: 6
					cycleSpeed: 9
					moveSpeed: 9
					yStep: 1
					setMotion: MoveTo 162 98 self
				)
			)
			(4
				(gMessager say: 15) ; "Now turn around, silver-ear! I think I'd rather shoot you in the back, so I don't have see that ugly face of yours!"
				(= cycles 1)
			)
			(5
				(= gCurPuzzle 21)
				(gGame handsOn:)
				(proc0_8 0)
				(gCurRoom newRoom: 671)
				(self dispose:)
			)
		)
	)
)

(instance thirdHand of Actor
	(properties
		x 165
		y 130
		noun 2
		yStep 5
		view 675
		loop 1
		priority 5
		signal 16401
		moveSpeed 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sCaughtCheating)
			)
			(8 ; icon10
				(proc0_8 0)
				(gCurRoom newRoom: 670)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cardFan of View
	(properties
		x 174
		y 92
		noun 1
		view 675
		priority 6
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; icon10
				(proc0_8 0)
				(gCurRoom newRoom: 670)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aces of Feature
	(properties
		x 164
		y 63
		noun 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; icon10
				(proc0_8 0)
				(gCurRoom newRoom: 670)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gambler1 of Feature
	(properties
		x 77
		y 106
		noun 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; icon10
				(proc0_8 0)
				(gCurRoom newRoom: 670)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gambler2 of Feature
	(properties
		x 273
		y 65
		noun 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; icon10
				(proc0_8 0)
				(gCurRoom newRoom: 670)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gambler3 of Feature
	(properties
		x 263
		y 151
		noun 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; icon10
				(proc0_8 0)
				(gCurRoom newRoom: 670)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gambler4 of Feature
	(properties
		x 70
		y 150
		noun 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; icon10
				(proc0_8 0)
				(gCurRoom newRoom: 670)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sceneFrame of Feature
	(properties
		x 166
		y 19
		noun 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; icon10
				(proc0_8 0)
				(gCurRoom newRoom: 670)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pokerTable of Feature
	(properties
		x 160
		y 140
		noun 13
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; icon10
				(proc0_8 0)
				(gCurRoom newRoom: 670)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gambler4Money of Feature
	(properties
		x 119
		y 108
		noun 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; icon10
				(proc0_8 0)
				(gCurRoom newRoom: 670)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pot of Feature
	(properties
		x 160
		y 140
		noun 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; icon10
				(proc0_8 0)
				(gCurRoom newRoom: 670)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance acesMoney of Feature
	(properties
		x 207
		y 104
		noun 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; icon10
				(proc0_8 0)
				(gCurRoom newRoom: 670)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance armSound of FPSound
	(properties
		flags 1
		number 2125
	)
)

