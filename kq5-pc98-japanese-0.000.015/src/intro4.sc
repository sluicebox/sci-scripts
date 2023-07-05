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
		(gGame setCursor: 5 1)
		(owlFace init:)
		(owlEyes init:)
		(egoEyes init:)
		(egoMouth init:)
		(gAddToPics add: egoBody doit:)
		(egoLArm init: setPri: (+ (egoEyes priority:) 1))
		(egoRArm init: setPri: (+ (egoEyes priority:) 1))
		(self setRegions: 763) ; cartoonRegion
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
				(PrintDC 103 0 #at 10 10 #dispose) ; "\81u\82\a8\8f\e9\82\aa\82\c7\82\a4\82\c8\82\c1\82\bd\82\a9\92m\82\c1\82\c4\82\dc\82\b7\82\e6\81B\88\ea\95\94\8en\8fI\82\f0\8c\a9\82\bd\82\f1\82\c5\82\b7\82\a9\82\e7\81A\8a\d4\88\e1\82\a2\82\c8\82\a2\82\c5\82\b7\82\e6\81B\81v"
				(= seconds (LangSwitch 5 8))
			)
			(2
				(owlFace setCycle: 0)
				(cls)
				(egoMouth setCycle: Fwd)
				(= global380 1)
				(PrintDC 103 1 #at 80 20 #dispose) ; "\81u\82\bb\82\a4\82\a9\82\a2\81H\81@\82\bb\82\ea\82\c5\82\cd\81A\82\a2\82\c1\82\bd\82\a2\82\c8\82\c9\82\aa\8bN\82\b1\82\c1\82\bd\82\f1\82\be\82\a2\81I\81H\81v"
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
				(PrintDC 103 2 #at 10 130 #dispose) ; "\81u\82\c8\82\ba\81H\81@\82\c7\82\a4\82\b5\82\c4\81A\82\bb\82\cc\83E\83B\83U\81[\83h\81c\81c\83\82\81[\83_\83b\83N\82\aa\81c\81c\8e\84\82\cc\82\a8\8f\e9\82\f0\8e\e6\82\e9\82\cc\82\be\81H\81@\8e\84\82\c6\8e\84\82\cc\89\c6\91\b0\82\c9\82\a2\82\c1\82\bd\82\a2\82\c8\82\f1\82\cc\82\a4\82\e7\82\dd\82\aa\82\a0\82\e9\82\cc\82\be\81H\81v"
				(= seconds (LangSwitch 9 14))
			)
			(2
				(cls)
				(egoMouth setCycle: 0)
				(owlFace setCycle: Fwd)
				(= global380 1)
				(PrintDC 103 3 #at 10 10 #width (LangSwitch 200 285) #dispose) ; "\81u\82\bb\82\ea\82\c9\82\c2\82\a2\82\c4\82\cd\81A\82\e6\82\ad\82\ed\82\a9\82\e8\82\dc\82\b9\82\f1\81B\82\a8\8f\e9\82\c6\81c\81c\82\a0\82\c8\82\bd\82\cc\89\c6\91\b0\82\f0\82\b3\82\e7\82\c1\82\c4\82\a2\82\c1\82\bd\82\cc\82\cd\81A\83\82\81[\83_\83b\83N\82\be\82\c6\82\a2\82\a4\82\b1\82\c6\82\b5\82\a9\92m\82\e8\82\dc\82\b9\82\f1\81B\81v"
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
				(if (not (self script:))
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
				(if (and (not (self script:)) (egoMouth cycler:))
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
				(if (and (not (self script:)) (egoMouth cycler:))
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

