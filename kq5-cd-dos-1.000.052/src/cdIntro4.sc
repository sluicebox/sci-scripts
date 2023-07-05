;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 653)
(include sci.sh)
(use Main)
(use AudioScript)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	cdIntro4 0
)

(local
	local0
)

(instance cdIntro4 of Rm
	(properties
		picture 70
	)

	(method (init)
		(Load rsPIC 70)
		(super init:)
		(if (== gPrevRoomNum 655) ; cdIntro6
			(UnLoad 129 72)
			(Load rsSYNC 10107)
		else
			(UnLoad 129 68)
			(Load rsSYNC 10104)
		)
		(Load rsVIEW 761)
		(Load rsSCRIPT 929)
		(HandsOff)
		(gGame setCursor: gNarrator 1)
		(owlFace init:)
		(theMouth init: hide:)
		(owlEyes init:)
		(egoEyes init:)
		(egoMouth init:)
		(gAddToPics add: egoBody doit:)
		(= local0 0)
		(egoLArm init: setPri: (+ (egoEyes priority:) 1))
		(egoRArm init: setPri: (+ (egoEyes priority:) 1))
		(self setRegions: 769) ; introtoonRegion
		(if (== gPrevRoomNum 655) ; cdIntro6
			(self setScript: sceneSevenScript)
		else
			(self setScript: sceneFourScript)
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (== gPrevRoomNum 655) ; cdIntro6
			(SetFlag 30)
		)
	)
)

(instance sceneFourScript of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMouth play: 10104 654)
				(= waitForCue 4096)
			)
			(1
				(theMouth show:)
				(= waitForCue 4356)
				(owlFace hide:)
			)
			(2
				(cls)
				(= local0 1)
				(owlFace show:)
				(theMouth changeMouth: 0)
				(egoMouth hide:)
				(= waitForCue 4608)
			)
			(3
				(= local0 0)
				(if (> (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(gCurRoom newRoom: 654) ; cdIntro5
			)
		)
	)
)

(instance sceneSevenScript of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(owlFace show:)
				(theMouth changeMouth: 0 show: play: 10107 664)
				(= local0 1)
				(egoMouth hide:)
				(= waitForCue 6404)
			)
			(2
				(cls)
				(= local0 0)
				(egoMouth show:)
				(theMouth changeMouth: 1)
				(owlFace hide:)
				(= cycles 1)
			)
			(3
				(if (> (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(gCurRoom newRoom: 664) ; cdIntro5B
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
				(if (and (not script) local0)
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
				(if (and (not script) local0)
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

(instance theMouth of MonoAudioProp
	(properties
		x 177
		y 79
		view 761
		priority 4
		signal 16400
		cycleSpeed 1
	)

	(method (changeMouth param1)
		(switch param1
			(0
				(theMouth
					view: 761
					loop: 3
					x: 121
					y: 78
					setPri: 6
					cycleSpeed: 1
				)
			)
			(1
				(theMouth
					view: 761
					loop: 0
					x: 177
					y: 79
					setPri: 4
					cycleSpeed: 1
				)
			)
		)
	)
)

