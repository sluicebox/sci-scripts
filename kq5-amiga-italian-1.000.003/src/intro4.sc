;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 103)
(include sci.sh)
(use Main)
(use DLetter)
(use Language)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	intro4 0
)

(instance intro4 of Rm
	(properties
		picture 70
	)

	(method (init)
		(super init:)
		(HandsOff)
		(gGame setCursor: gNarrator 1)
		(owlFace init:)
		(owlEyes init:)
		(egoEyes init:)
		(egoMouth init:)
		(gAddToPics add: egoBody doit:)
		(egoLArm init: setPri: (+ (egoEyes priority:) 1))
		(egoRArm init: setPri: (+ (egoEyes priority:) 1))
		(self setRegions: 769) ; introtoonRegion
		(if (== gPrevRoomNum 105) ; intro6
			(self setScript: sceneSevenScript)
		else
			(self setScript: sceneFourScript)
		)
	)
)

(instance sceneFourScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(owlFace setCycle: Fwd)
				(PrintDC 103 0 #at 10 10 #dispose) ; "I know what happened to your castle. I saw it all. Yes, I did."
				(= seconds (LangSwitch 7 8))
			)
			(2
				(owlFace setCycle: 0)
				(cls)
				(egoMouth setCycle: Fwd)
				(= global380 1)
				(PrintDC 103 1 #at 80 20 #dispose) ; "You did?! Well, then...what happened?!"
				(= seconds (LangSwitch 5 8))
			)
			(3
				(gCurRoom newRoom: 104) ; intro5
			)
		)
	)
)

(instance sceneSevenScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(egoMouth setCycle: Fwd)
				(PrintDC 103 2 #at 10 130 #dispose) ; "Why? Why would this wizard... Mordack... want my castle? What could he have against me and my family?"
				(= seconds (LangSwitch 9 14))
			)
			(2
				(cls)
				(egoMouth setCycle: 0)
				(owlFace setCycle: Fwd)
				(= global380 1)
				(PrintDC 103 3 #at 10 10 #dispose) ; "That I don't know. I only know that it was Mordack who took your castle...and your family."
				(= seconds (LangSwitch 6 9))
			)
			(3
				(SetFlag 30)
				(gCurRoom newRoom: 114) ; intro5B
			)
		)
	)
)

(instance owlFace of Prop
	(properties
		x 177
		y 79
		view 761
		priority 4
		signal 16400
		cycleSpeed 1
	)
)

(instance owlEyes of Prop
	(properties
		x 175
		y 66
		view 761
		loop 1
		priority 7
		signal 16400
	)

	(method (doit)
		(super doit:)
		(switch (Random 1 20)
			(1
				(if (not script)
					(self setScript: (moveArmScript new:))
				)
			)
		)
	)
)

(instance egoLArm of Prop
	(properties
		x 128
		y 75
		view 761
		loop 5
		signal 16400
		cycleSpeed 2
	)

	(method (doit)
		(super doit:)
		(switch (Random 1 50)
			(1
				(if (and (not script) (egoMouth cycler:))
					(self setScript: (moveArmScript new:))
				)
			)
		)
	)
)

(instance egoRArm of Prop
	(properties
		x 102
		y 84
		view 761
		loop 6
		priority 6
		signal 16400
		cycleSpeed 2
	)

	(method (doit)
		(super doit:)
		(switch (Random 1 50)
			(1
				(if (and (not script) (egoMouth cycler:))
					(self setScript: (moveArmScript new:))
				)
			)
		)
	)
)

(instance egoBody of RPicView
	(properties
		x 132
		y 128
		view 761
		loop 4
		priority 4
		signal 16400
	)
)

(instance egoMouth of Prop
	(properties
		x 121
		y 78
		view 761
		loop 3
		priority 6
		signal 16400
		cycleSpeed 1
	)
)

(instance egoEyes of Prop
	(properties
		x 121
		y 78
		view 761
		loop 2
		priority 10
		signal 16400
	)

	(method (doit)
		(super doit:)
		(switch (Random 1 20)
			(1
				(if (not script)
					(self setScript: (moveArmScript new:))
				)
			)
		)
	)
)

(instance moveArmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= cycles 15)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

