;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 770)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use TrackingProp)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm770 0
)

(local
	local0
)

(instance rm770 of LightRoom
	(properties)

	(method (init)
		(gGame handsOff:)
		(super init: &rest)
		(gBackMusic setVol: 64)
		(switch gPrevRoomNum
			(720
				(gBackMusic2 number: 750 loop: -1 play:)
				(self changeScene: 2772 2)
			)
			(else
				(self changeScene: 2777 13)
			)
		)
	)

	(method (changeScene param1)
		(super changeScene: param1 &rest)
		(doorFeat2772 dispose:)
		(leftChime2774 dispose:)
		(rightChime2774 dispose:)
		(closedPod2774 dispose:)
		(leftEye2774 dispose:)
		(rightEye2774 dispose:)
		(armOne2774 dispose:)
		(armTwo2774 dispose:)
		(armThreeFour2774 dispose:)
		(armThree2774Feat dispose:)
		(armFour2774Feat dispose:)
		(cd2774 dispose:)
		(switch param1
			(2772
				(doorFeat2772 init:)
				((ScriptID 1 1) newPic: 2774 3) ; exitForward
				((ScriptID 1 2) newPic: 2773 6) ; exitBack
				((ScriptID 1 4) ; exitRight
					newPic: 2776 9
					nsLeft: 348
					nsTop: 59
					nsRight: 441
					nsBottom: 190
					arrowStyle: 3
				)
			)
			(2773
				((ScriptID 1 1) newRoom: 720) ; exitForward
				((ScriptID 1 2) newPic: 2772 2) ; exitBack
			)
			(2774
				(leftChime2774 init:)
				(rightChime2774 init:)
				(leftEye2774 init:)
				(rightEye2774 init:)
				((ScriptID 1 4) ; exitRight
					newPic: 2776 9
					arrowStyle: 7
					exitCode: cExitRight2774
				)
				((ScriptID 1 7) newPic: 2772 2 exitCode: cExitBack2774) ; exitBackUp
				(closedPod2774 init:)
			)
			(2776
				((ScriptID 1 1) newRoom: 730) ; exitForward
				((ScriptID 1 2) newPic: 2777 13) ; exitBack
			)
			(2777
				((ScriptID 1 4) newPic: 2772 2) ; exitRight
				((ScriptID 1 1) newPic: 2773 6) ; exitForward
				((ScriptID 1 2) newPic: 2776 9) ; exitBack
			)
		)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 730)
			(gBackMusic2 fade: 0 10 7 1)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance roomSfx of Sound
	(properties)
)

(instance doorFeat2772 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				37
				33
				98
				39
				131
				83
				140
				112
				141
				145
				122
				188
				21
				207
				-1
				194
				2
				46
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(roomSfx number: 776 play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cExitRight2774 of Code
	(properties)

	(method (doit)
		(if (gCast contains: closedPod2774)
			(gCurRoom changeScene: 2776 9)
		else
			(gGame handsOff:)
			(gCurRoom setScript: sClosePod 0 2776)
		)
	)
)

(instance cExitBack2774 of Code
	(properties)

	(method (doit)
		(if (not (leftEye2774 cel:))
			(gCurRoom changeScene: 2772 2)
		else
			(gGame handsOff:)
			(gCurRoom setScript: sClosePod 0 2772)
		)
	)
)

(instance rReverseOnion of RobotPlayer
	(properties)
)

(instance sClosePod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= scratch 0)
				(if (gCast contains: cd2774)
					(cd2774 setCycle: Beg self)
				else
					(= cycles 2)
				)
			)
			(1
				(cd2774 dispose:)
				(if
					(and
						(== (armThreeFour2774 loop:) 1)
						(armThreeFour2774 cel:)
					)
					(roomSfx number: 733 play:)
					(armThreeFour2774 setCycle: Beg self)
					(= scratch 1)
				else
					(= cycles 2)
				)
			)
			(2
				(if (IsFlag 194)
					(roomSfx number: 774 play:)
					(armThreeFour2774 loop: 0)
					(armThreeFour2774
						cel: (armThreeFour2774 lastCel:)
						setCycle: Beg self
					)
					(= scratch 1)
				else
					(= cycles 2)
				)
			)
			(3
				(armThreeFour2774 dispose:)
				(if (armTwo2774 cel:)
					(armOne2774 show:)
					(roomSfx number: 730 play:)
					(ClearFlag 194)
					(armTwo2774 show: setCycle: Beg self)
					(= scratch 1)
				else
					(= cycles 2)
				)
			)
			(4
				(if (armOne2774 cel:)
					(roomSfx number: 730 play:)
					(armOne2774 setCycle: Beg self)
					(= scratch 1)
				else
					(= cycles 2)
				)
			)
			(5
				(if (IsFlag 191)
					(armOne2774 dispose:)
					(armTwo2774 dispose:)
					(Load rsAUDIO 773)
					(roomSfx number: 773 play:)
					(rReverseOnion init: 2774 40 0 0 caller: self start: 2 10)
				else
					(= cycles 2)
				)
			)
			(6
				(if (IsFlag 191)
					(rReverseOnion dispose:)
					(closedPod2774 init:)
				)
				(if (IsFlag 197)
					(roomSfx number: 772 play:)
					(leftEye2774 setCycle: Beg self)
					(rightEye2774 setCycle: Beg self)
				else
					(= cycles 2)
				)
			)
			(7
				(if (IsFlag 197)
					0
				else
					(= cycles 2)
				)
			)
			(8
				(ClearFlag 197)
				(ClearFlag 192)
				(ClearFlag 193)
				(ClearFlag 194)
				(ClearFlag 195)
				(ClearFlag 191)
				(if (and (IsFlag 196) (not (IsFlag 198)))
					(ClearFlag 196)
				)
				(self dispose:)
				(gCurRoom changeScene: register (if (== register 2773) 6 else 9))
			)
		)
	)
)

(instance closedPod2774 of View
	(properties
		x 144
		y 224
		view 2770
	)
)

(instance leftChime2774 of Prop
	(properties
		x 91
		y 240
		loop 1
		view 2770
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(self setScript: sLeftChime)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightChime2774 of Prop
	(properties
		x 333
		y 237
		loop 2
		view 2770
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(self setScript: sRightChime)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftEye2774 of Prop
	(properties
		x 210
		y 268
		loop 3
		view 2772
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 3)
		(if (IsFlag 197)
			(self cel: (self lastCel:))
		)
	)
)

(instance rightEye2774 of Prop
	(properties
		x 264
		y 268
		loop 5
		view 2772
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 3)
		(if (IsFlag 197)
			(self cel: (self lastCel:))
		)
	)
)

(instance armOne2774 of TrackingProp
	(properties
		x 256
		y 179
		loop 1
		view 2772
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 3)
		(self
			setPoints:
				50
				0
				51
				1
				51
				2
				50
				4
				48
				6
				44
				7
				38
				8
				30
				10
				22
				10
				13
				10
				4
				10
				-6
				11
				-16
				10
				-24
				10
				-33
				9
				-40
				8
				-46
				6
				-50
				5
				-52
				3
				-53
				2
				-53
				0
				-55
				0
		)
		(if (IsFlag 192)
			(self cel: (self lastCel:))
		)
		(approachX hotVerbs: 5)
	)

	(method (doit)
		(if (and (not (IsFlag 194)) (not (armThreeFour2774 cycler:)))
			(super doit:)
		)
	)

	(method (doMouseUp)
		(if (== cel (self lastCel:))
			(SetFlag 192)
			(if (IsFlag 193)
				(armThree2774Feat approachX: (Hiliter new:))
				((armThree2774Feat approachX:)
					client: armThree2774Feat
					hotVerbs: 5
				)
				(global105 add: (armThree2774Feat approachX:))
			)
		else
			(ClearFlag 192)
			(if (armThree2774Feat approachX:)
				((armThree2774Feat approachX:) hotVerbs: 0)
			)
		)
	)
)

(instance armTwo2774 of TrackingProp
	(properties
		x 256
		y 184
		view 2772
		z 20
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 3)
		(self
			setPoints:
				-39
				0
				-39
				1
				-38
				2
				-37
				2
				-34
				3
				-30
				4
				-25
				4
				-18
				5
				-12
				5
				-5
				5
				3
				5
				11
				5
				16
				5
				22
				4
				27
				4
				31
				3
				34
				2
				35
				1
				36
				1
				36
				0
				36
				-1
				38
				-1
		)
		(if (IsFlag 193)
			(self cel: (self lastCel:))
		)
		(approachX hotVerbs: 5)
	)

	(method (doit)
		(if (and (not (IsFlag 194)) (not (armThreeFour2774 cycler:)))
			(super doit:)
		)
	)

	(method (doMouseUp)
		(if (== cel (self lastCel:))
			(SetFlag 193)
			(if (IsFlag 192)
				(armThree2774Feat approachX: (Hiliter new:))
				((armThree2774Feat approachX:)
					client: armThree2774Feat
					hotVerbs: 5
				)
				(global105 add: (armThree2774Feat approachX:))
			)
		else
			(ClearFlag 193)
			(if (armThree2774Feat approachX:)
				((armThree2774Feat approachX:) hotVerbs: 0)
			)
		)
	)
)

(instance armThreeFour2774 of Prop
	(properties
		x 188
		y 187
		view 2771
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 0)
		(= cycleSpeed 3)
		(if (IsFlag 194)
			(if (IsFlag 195)
				(= loop 1)
			)
			(self cel: (self lastCel:))
			(armOne2774 hide:)
			(armTwo2774 hide:)
		)
	)
)

(instance armThree2774Feat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 194))
			(self
				createPoly:
					244
					44
					264
					46
					268
					83
					260
					90
					260
					149
					265
					158
					264
					160
					244
					160
					244
					153
					249
					147
					249
					85
					240
					73
			)
		else
			(self
				createPoly:
					264
					81
					280
					90
					288
					104
					276
					125
					266
					128
					261
					147
					264
					159
					244
					160
					244
					155
					253
					146
					259
					124
					248
					107
					249
					98
					256
					91
			)
		)
		(if (and (IsFlag 192) (IsFlag 193))
			(approachX hotVerbs: 5)
		else
			(approachX hotVerbs: 0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if
					(and
						(IsFlag 192)
						(IsFlag 193)
						(not (IsFlag 195))
						(not (armThreeFour2774 cycler:))
					)
					(armThreeFour2774 setScript: sMoveArm3)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance armFour2774Feat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 195))
			(self
				createPoly:
					285
					65
					300
					73
					313
					110
					287
					160
					269
					168
					265
					157
					275
					142
					262
					120
					279
					95
					275
					69
			)
		else
			(self
				createPoly:
					229
					46
					244
					49
					253
					68
					276
					83
					252
					92
					251
					116
					257
					124
					275
					130
					278
					141
					266
					160
					258
					149
					263
					130
					257
					128
					249
					130
					233
					122
					232
					115
					244
					108
					243
					89
					247
					81
					229
					96
					222
					77
			)
		)
		(if (IsFlag 194)
			(approachX hotVerbs: 5)
		else
			(approachX hotVerbs: 0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (IsFlag 194) (not (armThreeFour2774 cycler:)))
					(armThreeFour2774 setScript: sMoveArm4)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cd2774 of Prop
	(properties
		x 233
		y 221
		loop 2
		view 2772
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 196)
			(self cel: (self lastCel:))
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 198)
				(self dispose:)
				(gInventory addItem: (ScriptID 9 51)) ; invCD
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sMoveArm3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 194)
					(roomSfx number: 774 play:)
					(armThreeFour2774 setCycle: Beg self)
					(armThree2774Feat
						createPoly:
							244
							44
							264
							46
							268
							83
							260
							90
							260
							149
							265
							158
							264
							160
							244
							160
							244
							153
							249
							147
							249
							85
							240
							73
					)
					(ClearFlag 194)
				else
					(roomSfx number: 731 play:)
					(armThreeFour2774 setCycle: End self)
					(armThree2774Feat
						createPoly:
							264
							81
							280
							90
							288
							104
							276
							125
							266
							128
							261
							147
							264
							159
							244
							160
							244
							155
							253
							146
							259
							124
							248
							107
							249
							98
							256
							91
					)
					(SetFlag 194)
					(armOne2774 hide:)
					(armTwo2774 hide:)
				)
			)
			(1
				(if (not (IsFlag 194))
					(armOne2774 show:)
					(armTwo2774 show:)
					((armFour2774Feat approachX:) hotVerbs: 0)
				else
					(armFour2774Feat approachX: (Hiliter new:))
					((armFour2774Feat approachX:)
						client: armFour2774Feat
						hotVerbs: 5
					)
					(global105 add: (armFour2774Feat approachX:))
				)
				(self dispose:)
			)
		)
	)
)

(instance sMoveArm4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 732 play:)
				(armThreeFour2774 loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(if local0
					(= local0 0)
					(gGame handsOff:)
					(gCurRoom setScript: sReleaseCD)
				)
				(roomSfx number: 733 play:)
				(armThreeFour2774 setCycle: Beg self)
			)
			(2
				(armThreeFour2774 loop: 0)
				(armThreeFour2774 cel: (armThreeFour2774 lastCel:))
				(self dispose:)
			)
		)
	)
)

(instance sReleaseCD of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cd2774 init: setCycle: End self)
			)
			(1
				(SetFlag 196)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leftChimeSfx of Sound
	(properties
		number 713
	)
)

(instance rightChimeSfx of Sound
	(properties
		number 714
	)
)

(instance sLeftChime of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register 0)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((not (rightChime2774 script:)) 0)
			(register 0)
			((gCurRoom script:) 0)
			((not (IsFlag 197))
				(gGame handsOff:)
				(gCurRoom setScript: sOpenEyes)
				(= register 1)
				(sRightChime register: 1)
			)
			((not (IsFlag 191))
				(gGame handsOff:)
				(gCurRoom setScript: sOpenPod)
				(= register 1)
				(sRightChime register: 1)
			)
			(
				(and
					(not (IsFlag 196))
					(== (armThreeFour2774 loop:) 1)
					(armThreeFour2774 cycler:)
					((armThreeFour2774 cycler:) isKindOf: End)
				)
				(= local0 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leftChimeSfx play:)
				(leftChime2774 setCycle: End self)
			)
			(1
				(leftChime2774 cel: 0)
				(if (and (not register) (not (IsFlag 191)) (IsFlag 197))
					(gGame handsOff:)
					(gCurRoom setScript: sCloseEyes)
				)
				(self dispose:)
			)
		)
	)
)

(instance sRightChime of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register 0)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((not (leftChime2774 script:)) 0)
			(register 0)
			((gCurRoom script:) 0)
			((not (IsFlag 197))
				(gGame handsOff:)
				(gCurRoom setScript: sOpenEyes)
				(= register 1)
				(sLeftChime register: 1)
			)
			((not (IsFlag 191))
				(gGame handsOff:)
				(gCurRoom setScript: sOpenPod)
				(= register 1)
				(sLeftChime register: 1)
			)
			(
				(and
					(not (IsFlag 196))
					(== (armThreeFour2774 loop:) 1)
					(armThreeFour2774 cycler:)
					((armThreeFour2774 cycler:) isKindOf: End)
				)
				(= local0 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rightChimeSfx play:)
				(rightChime2774 setCycle: End self)
			)
			(1
				(rightChime2774 cel: 0)
				(if (and (not register) (not (IsFlag 191)) (IsFlag 197))
					(gGame handsOff:)
					(gCurRoom setScript: sCloseEyes)
				)
				(self dispose:)
			)
		)
	)
)

(instance sOpenEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 772 play:)
				(SetFlag 197)
				(leftEye2774 setCycle: End self)
				(rightEye2774 setCycle: End self)
			)
			(1 0)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 772 play:)
				(ClearFlag 197)
				(leftEye2774 setCycle: Beg self)
				(rightEye2774 setCycle: Beg self)
			)
			(1 0)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenPod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(closedPod2774 dispose:)
				(Load rsAUDIO 728)
				(roomSfx number: 728 play:)
				(KillRobot 2774 0 0)
				(SetFlag 191)
			)
			(1
				(armOne2774 init:)
				(armTwo2774 init:)
				(armThree2774Feat init:)
				(armFour2774Feat init:)
				(armThreeFour2774 init:)
				(armOne2774 setPri: (+ (armThreeFour2774 priority:) 1))
				(armTwo2774 setPri: (+ (armThreeFour2774 priority:) 1))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

