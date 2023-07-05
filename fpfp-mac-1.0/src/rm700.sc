;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Actor)
(use System)

(public
	rm700 0
)

(instance rm700 of FPRoom
	(properties
		noun 3
		picture 700
	)

	(method (init)
		(LoadMany rsSOUND 2701 2700 703)
		(LoadMany rsVIEW 700)
		(gGame handsOn:)
		(proc0_8 1)
		(super init:)
		(gNarrator x: 15 y: 140 talkWidth: 280)
		(lid init: setPri: 9)
		(if (not (gEgo has: 38)) ; Neckerchief
			(scarf init: setPri: 6)
		)
		(if (not (gEgo has: 44)) ; Pistols
			(pistols init: setPri: 5)
		)
		(gTheIconBar disable: 0 6 7)
		(gTheIconBar curIcon: (gTheIconBar at: 2))
		(gGame setCursor: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; icon10
				(proc0_8 0)
				(if (gCast contains: lid)
					(self cue:)
				else
					(gCurRoom setScript: sDoBox self 0)
				)
			)
			(4 ; Do
				(gCurRoom setScript: sDoBox 0 (gCast contains: lid))
			)
			(59 ; Neckerchief
				(gEgo put: 38) ; Neckerchief
				(scarf x: 166 setLoop: 3 setPri: 4 init:)
			)
			(47 ; Pistols
				(gEgo put: 44) ; Pistols
				(pistols init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gCurRoom newRoom: 690)
	)
)

(instance sDoBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lidSound play: self)
				(gGame handsOff:)
				(if register
					(lid dispose:)
				else
					(lid init:)
					(if (== (scarf loop:) 3)
						(scarf x: 167 setLoop: 1 setPri: 6)
						(pistols y: 126)
					)
				)
			)
			(1
				(gGame handsOn:)
				(gTheIconBar disable: 0 6 7)
				(self dispose:)
			)
		)
	)
)

(instance scarf of View
	(properties
		x 167
		y 127
		noun 1
		view 700
		loop 1
		signal 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== loop 1)
						(self x: 166 setLoop: 3 setPri: 4)
						(if (gCast contains: pistols)
							(pistolSound play:)
							(pistols y: 128)
						)
					)
					((gEgo has: 44) ; Pistols
						(gMessager say: noun theVerb) ; "You take your lucky neckerchief out of the safe deposit box. Now you're REALLY beginning to feel lucky!"
						(gEgo get: -1 38) ; Neckerchief
						(if
							(and
								(gEgo has: 2) ; Boots
								(gEgo has: 10) ; Clothes
								(gEgo has: 52) ; Silver_Ear
								(gEgo has: 44) ; Pistols
							)
							(SetFlag 58)
						)
						(gGame points: 3 144)
						(self dispose:)
					)
					(else
						(self x: 167 setLoop: 1 setPri: 6)
						(pistols y: 126)
					)
				)
			)
			(47 ; Pistols
				(gEgo put: 44) ; Pistols
				(pistols y: 126 init:)
			)
			(8 ; icon10
				(gCurRoom doVerb: 8)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pistols of View
	(properties
		x 167
		y 126
		z 6
		noun 2
		view 700
		loop 2
		signal 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "You lovingly lift your pistols from the box where they've spent the past decade."
				(gEgo get: -1 44) ; Pistols
				(gGame points: 1 143)
				(if (gEgo has: 3) ; Bullets
					(= gCurPuzzle 17)
				)
				(self dispose:)
			)
			(8 ; icon10
				(gCurRoom doVerb: 8)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lid of View
	(properties
		x 179
		y 132
		noun 3
		view 700
		signal 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sDoBox 0 1)
			)
			(8 ; icon10
				(gCurRoom doVerb: 8)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lidSound of FPSound
	(properties
		flags 1
		number 2700
	)
)

(instance pistolSound of FPSound
	(properties
		flags 1
		number 2701
	)
)

