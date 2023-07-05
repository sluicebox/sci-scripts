;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use SQRoom)
(use ForwardCounter)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	rm600 0
)

(local
	local0
	local1
)

(instance rm600 of SQRoom
	(properties
		noun 1
		picture 600
	)

	(method (init)
		(gGame handsOff:)
		(super init: &rest)
		(drBlow init:)
		(drBlowsArm init:)
		(Load 140 606) ; WAVE
		(self setScript: shuttleArrives)
	)

	(method (doit)
		(cond
			((not local0))
			((not gAutoRobot))
			((not (= local1 (Robot 11)))) ; FrameNum
			((> local1 100)
				(= local0 0)
				(drBlowsArm setScript: scratchChin)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gGSound2 stop:)
		(super dispose: &rest)
	)
)

(instance shuttleArrives of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gGame handsOff:)
				(= ticks 90)
			)
			(2
				(= local0 1)
				(= gAutoRobot
					((WalkieTalkie new:)
						x: 107
						y: 8
						init: 0 600 self
						start:
						yourself:
					)
				)
			)
			(3
				(gGSound2 number: 606 loop: -1 play: setVol: 127)
				(gGSound1 number: 608 loop: -1 play: setVol: 127)
				(flashLights init: setCycle: ForwardCounter 3 self)
			)
			(4
				(= ticks (flashLights cycleSpeed:))
			)
			(5
				(flashLights cel: 0)
				(= ticks 90)
			)
			(6
				(flashLights init: setCycle: ForwardCounter 3 self)
			)
			(7
				(= ticks (flashLights cycleSpeed:))
			)
			(8
				(flashLights cel: 0)
				(= ticks 30)
			)
			(9
				(gCurRoom newRoom: 540)
			)
		)
	)
)

(instance scratchChin of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(client loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(client loop: 2 cel: 0 setCycle: Fwd)
				(= ticks 150)
			)
			(2
				(client loop: 1)
				(client cel: (client lastCel:) setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance drBlowsArm of Prop
	(properties
		x 126
		y 38
		view 601
		loop 1
	)
)

(instance flashLights of Prop
	(properties
		x 213
		y 87
		view 602
		cycleSpeed 20
	)
)

(instance drBlow of View
	(properties
		x 126
		y 38
		view 601
	)
)

