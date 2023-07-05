;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 570)
(include sci.sh)
(use Main)
(use eRS)
(use Feature)
(use LoadMany)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm570 0
)

(local
	local0
)

(instance rm570 of FPRoom
	(properties
		noun 9
		picture 570
		style 10
	)

	(method (init)
		(super init:)
		(gGameMusic1 number: 570 loop: -1 play:)
		(LoadMany rsSCRIPT 1815)
		(if (IsFlag 60)
			(bleedingEar init: setCycle: Fwd cycleSpeed: 11)
			(gCurRoom setScript: sFreddyShotKenny)
		else
			(kennyGun init: setCycle: Fwd)
			(gCurRoom setScript: sFreddyDead)
		)
		(kennyBody view: (if (IsFlag 60) 573 else 572) init: stopUpd:)
		(freddyEyes init: stopUpd:)
		(freddyMouth init: stopUpd:)
		(redNeckerchief init: stopUpd:)
		(body init: setOnMeCheck: 1 4)
		(hat init: setOnMeCheck: 1 32)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance sFreddyShotKenny of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tNeckerchiefTimer setReal: tNeckerchiefTimer 30 0)
				(= cycles 1)
			)
			(1
				(gMessager say: 2 0 0 0 self) ; "Welp, ya knocked the gun outta my hand, Hero, but it warn't good enuf to keep me from hittin' YOU first!"
			)
			(2
				(kennySmiles init: setCycle: CT 2 1 self)
			)
			(3
				(kennySmiles cycleSpeed: 12 setCycle: End self)
			)
			(4
				(kennySmiles dispose:)
				(kennyBody setCycle: End self)
			)
			(5
				(kennyBody dispose:)
				(gGame handsOn:)
				(gTheIconBar disable: 0 3)
				(self dispose:)
			)
		)
	)
)

(instance sFreddyMendsEar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTimers delete: tNeckerchiefTimer)
				(gEgo put: 38) ; Neckerchief
				(gInventory curIcon: 0)
				(gTheIconBar disable: 5)
				(gGame points: 10)
				(gGame setCursor: 996 1)
				(= cycles 1)
			)
			(1
				(gMessager say: 5 59 0 0 self) ; "You place your lucky neckerchief on your ear and press on it to staunch the flow of blood."
			)
			(2
				(= gCurPuzzle 25)
				(gCurRoom newRoom: 260)
				(self dispose:)
			)
		)
	)
)

(instance sFreddyDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gAct 4)
				(gTimers delete: tNeckerchiefTimer)
				(= seconds 4)
			)
			(1
				(gMessager say: 13 0 0 0 self) ; "Kenny looks down at you with pure, undisguised malice and disgust."
			)
			(2
				(kennySmiles init: setCycle: CT 2 1 self)
			)
			(3
				(kennySmiles cycleSpeed: 12 setCycle: End self)
			)
			(4
				(kennySmiles dispose:)
				(kennyGun dispose:)
				(kennyBody setCycle: End self)
			)
			(5
				(kennyBody dispose:)
				(= seconds 3)
			)
			(6
				(freddyEyes cycleSpeed: 12 setCycle: End self)
			)
			(7
				(freddyMouth cycleSpeed: 12 setCycle: End self)
			)
			(8
				(freddyEyes stopUpd:)
				(freddyMouth stopUpd:)
				(= seconds 2)
			)
			(9
				(= global122 6)
				(gCurRoom newRoom: 99) ; deathRoom
				(gGame setCursor: 0 1)
				(self dispose:)
			)
		)
	)
)

(instance sFreddyDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable:)
				(gGame setCursor: 996 1)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 0 0 0 self) ; "And as the blood runs from your body, so do your hopes of saving Coarsegold and achieving legendary Western Hero status."
			)
			(2
				(bleedingEar cycleSpeed: 10 setCycle: End)
				(freddyEyes cycleSpeed: 10 setCycle: End self)
			)
			(3
				(freddyMouth cycleSpeed: 10 setCycle: End)
				(= seconds 3)
			)
			(4
				(freddyEyes stopUpd:)
				(freddyMouth stopUpd:)
				(= cycles 1)
			)
			(5
				(= global122 13)
				(gGame setCursor: 0 1)
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance bleedingEar of Prop
	(properties
		x 173
		y 145
		noun 11
		view 570
		loop 3
		cel 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(59 ; Neckerchief
				(gCurRoom setScript: sFreddyMendsEar)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance freddyEyes of Prop
	(properties
		x 185
		y 107
		noun 14
		view 570
	)
)

(instance freddyMouth of Prop
	(properties
		x 145
		y 112
		noun 15
		view 570
		loop 1
	)
)

(instance kennySmiles of Prop
	(properties
		x 151
		y 33
		noun 9
		view 571
		loop 2
	)
)

(instance kennyGun of Prop
	(properties
		x 107
		y 64
		noun 9
		view 571
		loop 3
	)
)

(instance kennyBody of Prop
	(properties
		x 146
		y 17
		noun 8
	)
)

(instance redNeckerchief of Prop
	(properties
		x 108
		y 136
		noun 3
		view 570
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self hide:)
				(gEgo get: 38 redNeckerchief) ; Neckerchief
				(gGame points: 5 149)
				(gTheIconBar
					curIcon: (gTheIconBar useIconItem:)
					curInvIcon: ((gInventory at: 38) cursor: 92 yourself:) ; Neckerchief
					enable: (gTheIconBar at: 5)
				)
				((gTheIconBar curIcon:) cursor: 92)
				(gGame setCursor: ((gTheIconBar at: 5) cursor:))
				(gTheIconBar select: (gTheIconBar at: 5))
				(bleedingEar setCycle: End)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance body of Feature
	(properties
		x 152
		y 130
		noun 4
	)
)

(instance hat of Feature
	(properties
		x 256
		y 98
		noun 7
	)
)

(instance tNeckerchiefTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: sFreddyDies)
	)
)

