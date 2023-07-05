;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 715)
(include sci.sh)
(use Main)
(use LightRoom)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm715 0
)

(instance rm715 of LightRoom
	(properties)

	(method (init)
		(super init: &rest)
		(gGame handsOff:)
		(gBackMusic setVol: 127)
		(gBackMusic2 number: 750 loop: -1 play:)
		(cond
			((== gPrevRoomNum 260)
				(self changeScene: 252 10)
			)
			((IsFlag 306)
				(self changeScene: 716 12)
			)
			(else
				(self changeScene: 717 12)
			)
		)
	)

	(method (changeScene param1)
		(super changeScene: param1 &rest)
		(cockpit716 dispose:)
		(leftLever dispose:)
		(leftDashLever dispose:)
		(rightDashLever dispose:)
		(rightLever dispose:)
		(pLid dispose:)
		(switch param1
			(252
				(leftLever init:)
				(leftDashLever init:)
				(rightDashLever init:)
				(rightLever init:)
				(pLid cel: 6 init: setCycle: Beg pLid)
				(lidCloseSFX play:)
				((ScriptID 1 4) ; exitRight
					newPic: 716 12
					arrowStyle: 7
					nsLeft: 260
					nsTop: 0
					nsRight: 500
					nsBottom: 140
					exitCode: openLidCode
				)
			)
			(715
				((ScriptID 1 5) ; exitDown
					newRoom: 750
					nsLeft: 106
					nsTop: 64
					nsRight: 280
					nsBottom: 275
				)
				(if (IsFlag 306)
					((ScriptID 1 2) newPic: 716 12) ; exitBack
				else
					((ScriptID 1 2) newPic: 717 12) ; exitBack
				)
			)
			(716
				(cockpit716 init:)
				((ScriptID 1 2) newPic: 715 16) ; exitBack
			)
			(717
				((ScriptID 1 2) newPic: 715 16) ; exitBack
			)
		)
		(if (not (gCast contains: pLid))
			(gGame handsOn:)
		)
	)

	(method (newRoom newRoomNumber)
		(gBackMusic2 fade: 0 10 7 1)
		(super newRoom: newRoomNumber)
	)
)

(instance openLidCode of Code
	(properties)

	(method (doit)
		(gGame handsOff:)
		(pLid setScript: sOpenLid)
	)
)

(instance sOpenLid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pLid setCycle: End self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom changeScene: 716 12)
				(self dispose:)
			)
		)
	)
)

(instance lidCloseSFX of Sound
	(properties
		number 45011
		flags 1
	)
)

(instance leftLever of Prop
	(properties
		x 55
		y 252
		view 254
	)
)

(instance leftDashLever of Prop
	(properties
		x 151
		y 222
		loop 1
		view 254
	)
)

(instance rightDashLever of Prop
	(properties
		x 352
		y 186
		loop 2
		view 254
	)
)

(instance rightLever of Prop
	(properties
		x 399
		y 294
		loop 3
		view 254
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sLaunchOrnithopter)
		)
	)
)

(instance sLaunchOrnithopter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_8 3679)
				(ClearFlag 306)
				(gGame handsOn:)
				(self dispose:)
				(= global224 2)
				(gGame getDisc: 2)
				(gCurRoom newRoom: 260)
			)
		)
	)
)

(instance cockpit716 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 274 180 313 171 375 188 417 222 417 272 233 261 233 231
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom changeScene: 252 10)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pLid of Prop
	(properties
		y 2
		view 252
	)

	(method (cue)
		(gGame handsOn:)
	)
)

