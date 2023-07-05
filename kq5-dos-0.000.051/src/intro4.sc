;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 103)
(include sci.sh)
(use Main)
(use Interface)
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
		(owlFace init:)
		(owlEyes init:)
		(egoEyes init:)
		(egoMouth init:)
		(gAddToPics add: egoBody doit:)
		(egoLArm init: setPri: (+ (egoEyes priority:) 1))
		(egoRArm init: setPri: (+ (egoEyes priority:) 1))
		(if (== gPrevRoomNum 105) ; intro6
			(self setScript: sceneSevenScript)
		else
			(self setScript: sceneFourScript)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (not global327)
			(= temp0 (Event new:))
			(if (or (== (temp0 type:) evKEYBOARD) (== (temp0 type:) evMOUSEBUTTON))
				(temp0 dispose:)
				(gGlobalSound stop:)
				(gGame restart:)
			)
			(temp0 dispose:)
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
				(= seconds 5)
			)
			(2
				(owlFace setCycle: 0)
				(egoMouth setCycle: Fwd)
				(cls)
				(PrintDC 103 1 67 80 20 351 103) ; "You did?! Well, then...what happened?!"
				(= seconds 5)
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
				(PrintDC 103 2 #at 10 130 #dispose) ; "Why? Why would this wizard...Mordack...want my castle? What could he have against me and my family?"
				(= seconds 9)
			)
			(2
				(cls)
				(owlFace setCycle: Fwd)
				(egoMouth setCycle: 0)
				(PrintDC 103 3 67 10 10 351 103) ; "That I don't know. I only know that it was Mordack who took your castle...and your family."
				(= seconds 6)
			)
			(3
				(SetFlag 31)
				(gCurRoom newRoom: 104) ; intro5
			)
		)
	)
)

(instance owlFace of Prop
	(properties
		y 79
		x 177
		view 761
		priority 4
		signal 16400
		cycleSpeed 1
	)
)

(instance owlEyes of Prop
	(properties
		y 66
		x 175
		view 761
		loop 1
		priority 7
		signal 16400
	)

	(method (doit)
		(super doit:)
		(switch (Random 1 20)
			(1
				(if (not (self script:))
					(self setScript: (moveArmScript new:))
				)
			)
		)
	)
)

(instance egoLArm of Prop
	(properties
		y 75
		x 128
		view 761
		loop 5
		signal 16400
		cycleSpeed 2
	)

	(method (doit)
		(super doit:)
		(switch (Random 1 50)
			(1
				(if (and (not (self script:)) (egoMouth cycler:))
					(self setScript: (moveArmScript new:))
				)
			)
		)
	)
)

(instance egoRArm of Prop
	(properties
		y 84
		x 102
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
				(if (and (not (self script:)) (egoMouth cycler:))
					(self setScript: (moveArmScript new:))
				)
			)
		)
	)
)

(instance egoBody of RPicView
	(properties
		y 128
		x 132
		view 761
		loop 4
		priority 4
		signal 16400
	)
)

(instance egoMouth of Prop
	(properties
		y 78
		x 121
		view 761
		loop 3
		priority 6
		signal 16400
		cycleSpeed 1
	)
)

(instance egoEyes of Prop
	(properties
		y 78
		x 121
		view 761
		loop 2
		priority 10
		signal 16400
	)

	(method (doit)
		(super doit:)
		(switch (Random 1 20)
			(1
				(if (not (self script:))
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

