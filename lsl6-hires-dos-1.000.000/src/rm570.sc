;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 570)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryRoom)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use System)

(public
	rm570 0
)

(local
	local0
)

(instance rm570 of LarryRoom
	(properties
		noun 1
		horizon 0
		autoLoad 0
	)

	(method (init)
		(if (== gPrevRoomNum 700)
			(= picture 572)
		)
		(super init: &rest)
		(if (!= gPrevRoomNum 700)
			(gEgo
				normalize: 570 0
				setCycle: 0
				cel: 0
				setSpeed: 8
				posn: 166 109
				init:
			)
			(gEgo loop: 0)
			(greenButton init:)
			(redButton init:)
			((ScriptID 0 11) init: self) ; iconExit
			(gGame handsOn:)
			(self setScript: messageScr)
		else
			(SetFlag 104)
			(self setScript: downShaftScr)
		)
	)

	(method (doVerb theVerb)
		(if (gCurRoom script:)
			((gCurRoom script:) dispose:)
		)
		(super doVerb: theVerb)
	)

	(method (cue)
		(gCurRoom newRoom: 560)
	)

	(method (dispose)
		(if (gTheIconBar contains: (ScriptID 0 11)) ; iconExit
			((ScriptID 0 11) dispose:) ; iconExit
		)
		(super dispose:)
	)
)

(instance greenButton of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(= y 200)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 204 80 217 79 215 88 205 87
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: buttonScr)
		else
			(if (gCurRoom script:)
				((gCurRoom script:) dispose:)
			)
			(super doVerb: theVerb)
		)
	)
)

(instance redButton of Feature
	(properties
		noun 4
	)

	(method (init)
		(super init: &rest)
		(= y 200)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 215 88 215 98 204 96 205 87
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: closeScr)
		else
			(if (gCurRoom script:)
				((gCurRoom script:) dispose:)
			)
			(super doVerb: theVerb)
		)
	)
)

(instance buttonScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(gGlobalSound2 number: 572 loop: 1 play:)
				(= ticks 20)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo loop: 0 cel: 0)
				(= cycles 2)
			)
			(4
				(gMessager say: 3 4 0 0 self) ; "It doesn't do anything now, of course. The dumbwaiter doors are already open. But if they were closed, you could just reach out here and press..."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance messageScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= ticks 360)
			)
			(2
				(gMessager say: 0 0 0 0 self) ; "Yep. You fit."
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance closeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(gGlobalSound2 number: 572 loop: 1 play:)
				(= ticks 20)
			)
			(3
				(sfx number: 575 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo view: 571 loop: 0 cel: 0 setCycle: End self)
			)
			(5
				(gEgo cel: 0 setCycle: End self)
			)
			(6
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(7
				(gGlobalSound2 play:)
				(= ticks 20)
			)
			(8
				(gEgo view: 573 loop: 0 cel: 0 setCycle: End self)
				(= ticks 10)
			)
			(9
				(sfx number: 573 loop: 1 play:)
			)
			(10
				(= ticks 90)
			)
			(11
				(gEgo view: 575 loop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(12
				(gGlobalSound2 play:)
				(= ticks 20)
			)
			(13
				(gEgo setCycle: End self)
			)
			(14
				(if (Random 0 1)
					(self setScript: noseScr self)
				else
					(sfx number: 574 loop: 1 play:)
					(gEgo loop: 1 cel: 0 setCycle: End self)
				)
			)
			(15
				(= ticks 120)
			)
			(16
				(gCurRoom drawPic: 572)
				(gEgo
					view: 572
					setLoop: 0
					cel: 0
					posn: 56 85
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					setScaler: Scaler 100 1 85 3
					setSpeed: 0
				)
				(= cycles 2)
			)
			(17
				(gGlobalSound1 number: 571 loop: -1 play:)
				(gTheDoits add: volumeCode)
				(gEgo
					scaleSignal: (& (gEgo scaleSignal:) $fffb)
					setMotion: MoveTo 318 3 self
				)
			)
			(18
				(gTheDoits delete: volumeCode)
				(gCurRoom newRoom: 700)
			)
		)
	)
)

(instance noseScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sfx number: 574 loop: 1 play:)
				(= cycles 2)
			)
			(1
				(gEgo view: 576 loop: 0 cel: 0 setCycle: CT 5 1 self)
			)
			(2
				(gGlobalSound2 number: 576 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(= ticks 120)
			)
			(4
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(gGlobalSound2 number: 710 loop: 1 play:)
				(= cycles 1)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance downShaftScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					init:
					view: 572
					setLoop: 0
					cel: 0
					posn: 318 3
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					setScaler: Scaler 100 1 85 3
					setSpeed: 0
				)
				(= cycles 2)
			)
			(1
				(gGlobalSound1 number: 571 loop: -1 play: 1)
				(gTheDoits add: volumeCode)
				(gEgo
					scaleSignal: (& (gEgo scaleSignal:) $fffb)
					setMotion: MoveTo 56 85 self
				)
			)
			(2
				(gTheDoits delete: volumeCode)
				(gCurRoom newRoom: 560)
			)
		)
	)
)

(instance volumeCode of Obj
	(properties)

	(method (doit &tmp temp0 [temp1 50] temp51)
		(if (and (<= (gEgo y:) 50) (!= local0 (= temp0 (- (gEgo y:) 3))))
			(gGlobalSound1 setVol: (= temp51 (/ (* temp0 272) 100)))
			(= local0 temp0)
		)
	)
)

(instance sfx of Sound
	(properties)
)

