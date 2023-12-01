;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19000)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm19000 0
)

(instance rm19000 of ScaryRoom
	(properties
		picture 19100
		stepSound 4
	)

	(method (drawPic param1)
		(if (and (ResCheck rsPIC (+ param1 1)) (== gChapter 5))
			(= picture (+ param1 1))
			(super drawPic: (+ param1 1) &rest)
		else
			(= picture param1)
			(super drawPic: picture &rest)
		)
		(switch picture
			(19100
				(twister view: 19123 posn: 26 107 show:)
				(if (IsFlag 31)
					(trunkLid view: 19101 posn: 71 87 show:)
				else
					(trunkLid view: 19100 posn: 45 89 show:)
				)
			)
			(19101
				(twister view: 19124 posn: 26 107 show:)
				(if (IsFlag 31)
					(trunkLid view: 19104 posn: 71 87 show:)
				else
					(trunkLid view: 19103 posn: 52 90 show:)
				)
			)
			(19200
				(twister view: 19200 posn: 81 111 show:)
				(if (IsFlag 31)
					(trunkLid view: 19108 posn: 185 95 show:)
				else
					(trunkLid view: 19107 posn: 158 95 show:)
				)
			)
			(19201
				(twister view: 19201 posn: 81 111 show:)
				(if (IsFlag 31)
					(trunkLid view: 19110 posn: 185 95 show:)
				else
					(trunkLid view: 19109 posn: 158 95 show:)
				)
			)
			(19210
				(twister view: 19210 posn: -8 124 show:)
				(if (IsFlag 31)
					(trunkLid view: 19112 posn: 207 127 show:)
				else
					(trunkLid view: 19111 posn: 145 130 show:)
				)
			)
			(19211
				(twister view: 19211 posn: -8 124 show:)
				(if (IsFlag 31)
					(trunkLid view: 19114 posn: 207 127 show:)
				else
					(trunkLid view: 19113 posn: 145 130 show:)
				)
			)
			(19230
				(twister view: 19230 posn: 87 142 show:)
				(if (IsFlag 31)
					(trunkLid view: 19116 posn: 234 130 show:)
				else
					(trunkLid view: 19115 posn: 192 130 show:)
				)
			)
			(19231
				(twister view: 19231 posn: 87 142 show:)
				(if (IsFlag 31)
					(trunkLid view: 19118 posn: 234 130 show:)
				else
					(trunkLid view: 19117 posn: 192 130 show:)
				)
			)
			(19300
				(twister view: 19300 posn: -16 104 show:)
				(if (IsFlag 31)
					(trunkLid view: 19120 posn: 63 81 show:)
				else
					(trunkLid view: 19119 posn: 37 83 show:)
				)
			)
			(19301
				(twister view: 19301 posn: -16 104 show:)
				(if (IsFlag 31)
					(trunkLid view: 19122 posn: 63 81 show:)
				else
					(trunkLid view: 19121 posn: 37 83 show:)
				)
			)
			(else
				(trunkLid hide:)
			)
		)
	)

	(method (init)
		(gEgo init: setScaler: Scaler 139 62 138 98 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(19100
				(gEgo normalize: 3 posn: 111 105)
				(= global163 trunk)
				(gGame handsOn:)
			)
			(else
				(gEgo normalize: 3 posn: 130 120)
				(SetFlag 193)
				(self setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			)
		)
		(if (and (== gChapter 5) (not (IsFlag 229)))
			(mirrorCloud init: setCycle: Fwd cycleSpeed: 10)
		)
		(KillRobot)
		(southExit init: 3)
		(if (not (IsFlag 229))
			(mirror init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		)
		(portraits init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(trunk init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(trunkLid init:)
		(twister init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(if
			(and
				(== gChapter 7)
				(gEgo has: 19) ; invCutter
				(not (gEgo has: 10)) ; invBrooch
				(not (IsFlag 274))
				(!= gPrevRoomNum 19100)
			)
			(ClearFlag 31)
		)
		(super init: &rest)
	)
)

(instance trunkLid of View
	(properties
		view 0
	)
)

(instance twister of View
	(properties
		view 19123
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: machineScr)
		else
			(super doVerb: &rest)
		)
	)
)

(instance mirrorCloud of Prop
	(properties
		x 251
		y 109
		view 19102
	)
)

(instance machineScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					(
						(or
							(and (== (gEgo x:) 219) (== (gEgo y:) 120))
							(and (== (gEgo x:) 192) (== (gEgo y:) 109))
						)
						(gEgo setHeading: 270 self)
					)
					((and (== (gEgo x:) 130) (== (gEgo y:) 120))
						(gEgo setHeading: 315 self 20)
					)
					((and (== (gEgo x:) 125) (== (gEgo y:) 116))
						(gEgo setHeading: 315 self)
					)
					(else
						(gEgo setHeading: 270 self 20)
					)
				)
			)
			(1
				(if (IsFlag 228)
					(gCurRoom setScript: lookMachine)
				else
					(SetFlag 228)
					(gCurRoom setScript: sTouchMachine)
				)
			)
		)
	)
)

(instance sTouchMachine of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(global114 pause:)
					(DoRobot 4740 12 -8)
					(if (gCast contains: mirrorCloud)
						(mirrorCloud hide:)
					)
					(gCurRoom drawPic: 19200)
					(twister hide:)
				)
				(1
					(global114 endPause:)
					(gEgo normalize: 8 posn: 125 116)
					(if (gCast contains: mirrorCloud)
						(mirrorCloud show:)
					)
					(twister show:)
					(gCurRoom drawPic: 19100)
					(= global163 0)
					(self setScript: (ScriptID 0 5) 0 self) ; takeLastStep
				)
				(2
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(KillRobot)
					(global114 endPause:)
					(gEgo normalize: 8 posn: 125 116)
					(if (gCast contains: mirrorCloud)
						(mirrorCloud show:)
					)
					(twister show:)
					(gCurRoom drawPic: 19100)
					(= global163 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookMachine of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 4750 12 16)
					(if (gCast contains: mirrorCloud)
						(mirrorCloud hide:)
					)
					(gCurRoom drawPic: 19200)
				)
				(1
					(gEgo normalize: 8 posn: 125 116)
					(if (gCast contains: mirrorCloud)
						(mirrorCloud show:)
					)
					(gCurRoom drawPic: 19100)
					(self setScript: (ScriptID 0 5) 0 self) ; takeLastStep
				)
				(2
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(KillRobot)
					(gEgo normalize: 8 posn: 125 116)
					(if (gCast contains: mirrorCloud)
						(mirrorCloud show:)
					)
					(gCurRoom drawPic: 19100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance mirrorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((and (== (gEgo x:) 192) (== (gEgo y:) 109))
						(gEgo setHeading: 135 self)
					)
					((and (== (gEgo x:) 219) (== (gEgo y:) 120))
						(= cycles 2)
					)
					(else
						(gEgo setHeading: 90 self)
					)
				)
			)
			(1
				(if (and (== gChapter 5) (not (IsFlag 229)))
					(gCurRoom setScript: sNeckTwisted)
				else
					(global114 pause:)
					(gCurRoom setScript: sAdriennePrimps)
				)
			)
		)
	)
)

(instance sAdriennePrimps of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 4760 -8 0 gEgo 200)
					(mirrorMachine init: setScript: mirrorMachineScr 0 0)
					(gCurRoom drawPic: 19220)
				)
				(1
					(mirrorMachine dispose:)
					(gCurRoom drawPic: 19100)
					(gEgo normalize: 0 posn: 219 120)
					(global114 endPause:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(KillRobot)
					(gEgo normalize: 0 posn: 219 120)
					(mirrorMachine dispose:)
					(gCurRoom drawPic: 19100)
					(global114 endPause:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance mirrorMachine of Prop
	(properties
		x 143
		y 120
		view 19220
	)
)

(instance mirrorMachineScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
				(if (> (++ register) 2)
					(self dispose:)
				)
			)
			(1
				(mirrorMachine cel: 0 setCycle: End self)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance sNeckTwisted of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame fade: (gGame intensity:) 0 1)
					(global114 pause:)
					(= seconds 2)
				)
				(1
					(gCurRoom drawPic: -1)
					(gCast eachElementDo: #dispose)
					(= cycles 2)
				)
				(2
					(PlayVMD 0 {4860.vmd} 0) ; Open
					(proc26_0 4860 self)
					(gGame setIntensity: (gGame intensity:))
				)
				(3
					(gGame setIntensity: 0)
					(SetFlag 229)
					(= global125 52)
					(gCurRoom newRoom: 15500)
				)
			)
		else
			(switch (= state newState)
				(0
					(SetFlag 229)
					(= global115 0)
					(= global125 52)
					(gCurRoom newRoom: 15500)
				)
			)
		)
	)
)

(instance sPortraits of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(global114 pause:)
					(cond
						((and (== (gEgo x:) 219) (== (gEgo y:) 120))
							(gEgo setHeading: 315 self)
						)
						((and (== (gEgo x:) 125) (== (gEgo y:) 116))
							(gEgo setHeading: 45 self)
						)
						((and (== (gEgo x:) 130) (== (gEgo y:) 120))
							(gEgo setHeading: 45 self)
						)
						((and (== (gEgo x:) 192) (== (gEgo y:) 109))
							(= cycles 2)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(DoRobot 4771 30 6)
					(if (gCast contains: mirrorCloud)
						(mirrorCloud hide:)
					)
					(gCurRoom drawPic: 19300)
				)
				(2
					(gEgo normalize: 3 posn: 192 109)
					(if (gCast contains: mirrorCloud)
						(mirrorCloud show:)
					)
					(global114 endPause:)
					(gCurRoom drawPic: 19100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 3 posn: 192 109)
					(if (gCast contains: mirrorCloud)
						(mirrorCloud show:)
					)
					(global114 endPause:)
					(gCurRoom drawPic: 19100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sDoTrunk of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(cond
						((and (== (gEgo x:) 219) (== (gEgo y:) 120))
							(gEgo setHeading: 270 self)
						)
						((and (== (gEgo x:) 125) (== (gEgo y:) 116))
							(gEgo setHeading: 315 self)
						)
						((and (== (gEgo x:) 130) (== (gEgo y:) 120))
							(gEgo setHeading: 315 self 21)
						)
						((and (== (gEgo x:) 192) (== (gEgo y:) 109))
							(gEgo setHeading: 270 self)
						)
						(else
							(= cycles 2)
						)
					)
				)
				(1
					(gEgo hide:)
					(if (IsFlag 31)
						(gCurRoom newRoom: 19100)
					else
						(if (gCast contains: mirrorCloud)
							(mirrorCloud hide:)
						)
						(DoRobot 4781 112 40)
						(gCurRoom drawPic: 19200)
					)
				)
				(2
					(if (gCast contains: mirrorCloud)
						(mirrorCloud show:)
					)
					(DoRobot 4780 60 39 gEgo -1 1)
					(gCurRoom drawPic: 19100)
				)
				(3
					(gCurRoom newRoom: 19100)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gCurRoom newRoom: 19100)
				)
			)
		)
	)
)

(instance sChapter7Trunk of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(cond
						((and (== (gEgo x:) 219) (== (gEgo y:) 120))
							(gEgo setHeading: 270 self)
						)
						((and (== (gEgo x:) 125) (== (gEgo y:) 116))
							(gEgo setHeading: 315 self)
						)
						((and (== (gEgo x:) 130) (== (gEgo y:) 120))
							(gEgo setHeading: 315 self 21)
						)
						((and (== (gEgo x:) 192) (== (gEgo y:) 109))
							(gEgo setHeading: 270 self)
						)
						(else
							(= cycles 2)
						)
					)
				)
				(1
					(DoRobot 5900 65 20)
					(gCurRoom drawPic: 19200)
				)
				(2
					(gCurRoom drawPic: 19100)
					(gEgo normalize: 3 posn: 111 105)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 3 posn: 111 105)
					(gCurRoom drawPic: 19100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 93
		nsTop 118
		nsRight 215
		y 189
		nextRoom 15500
	)
)

(instance trunk of Feature
	(properties
		nsLeft 94
		nsTop 76
		nsRight 130
		nsBottom 97
		sightAngle 40
		approachX 111
		approachY 105
		x 101
		y 96
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(if
				(and
					(== gChapter 7)
					(gEgo has: 19) ; invCutter
					(not (gEgo has: 10)) ; invBrooch
					(not (IsFlag 274))
					(!= gPrevRoomNum 19100)
				)
				(gCurRoom setScript: sChapter7Trunk)
			else
				(gCurRoom setScript: sDoTrunk)
			)
		else
			(super doVerb: &rest)
		)
	)
)

(instance mirror of Feature
	(properties
		nsLeft 238
		nsTop 24
		nsRight 272
		nsBottom 122
		sightAngle 40
		approachX 237
		approachY 122
		x 248
		y 124
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: mirrorScr)
		else
			(super doVerb: &rest)
		)
	)
)

(instance portraits of Feature
	(properties
		nsLeft 143
		nsTop 51
		nsRight 214
		nsBottom 98
		sightAngle 40
		approachX 157
		approachY 100
		x 179
		y 83
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sPortraits)
		else
			(super doVerb: &rest)
		)
	)
)

