;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm27100 0
)

(local
	local0
	local1
	local2
)

(instance rm27100 of ScaryRoom
	(properties
		picture 27110
		stepSound 4
	)

	(method (drawPic param1)
		(if (gCast contains: mist)
			(switch param1
				(27100
					(mist
						posn: 91 87
						setPri: 1
						setScaler: Scaler 30 30 128 0
						show:
					)
				)
				(27110
					(mist
						posn: 143 73
						setPri: 1
						setScaler: Scaler 40 40 128 0
						show:
					)
				)
				(else
					(mist hide:)
				)
			)
		)
		(super drawPic: param1 &rest)
	)

	(method (init)
		(KillRobot)
		((ScriptID 30) init:) ; FidgetCode
		(if (and (not (IsFlag 308)) (== gChapter 6))
			(mist init:)
		)
		(SetFlag 116)
		(gEgo init: setScaler: Scaler 147 77 132 86 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 274 126 normalize: 7)
				(= global125 1)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(if (not (IsFlag 218))
			(armoire init: setHotspot: 4 3) ; Do, Move
		)
		(if (and (not (IsFlag 308)) (== gChapter 6))
			(mist init:)
		)
		(if (== gChapter 7)
			(coat init:)
		)
		(chair init:)
		(if (and (not (IsFlag 308)) (!= gChapter 7))
			(mirror init: setHotspot: 4 3) ; Do, Move
		)
		(poster init: setHotspot: 4 3) ; Do, Move
		(southExit init: 11 approachVerbs: 0)
		(super init: &rest)
	)

	(method (notify)
		((ScriptID 0 14) dispose:) ; exitButt
		(gGame handsOff:)
		(gCurRoom setScript: sArmoireClose)
	)
)

(instance sArmoireOpen of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 315 self)
						)
						(2
							(gEgo setHeading: 315 self 15)
						)
						(3
							(gEgo setHeading: 45 self)
						)
						(4
							(gEgo setHeading: 90 self)
						)
						(5
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(chair view: 27100 posn: 109 115)
					(if (gCast contains: coat)
						(coat posn: 172 102 view: 27100)
					)
					(clothes init:)
					(DoRobot 5340 79 25)
					(gCurRoom drawPic: 27100)
				)
				(2
					(proc1111_8)
					(clothes view: 27210 loop: 0 posn: 60 130)
					(gGame handsOn: 0)
					(photo init: setHotspot: 4 3) ; Do, Move
					((ScriptID 0 14) init:) ; exitButt
					(SetFlag 248)
					(gCurRoom drawPic: 27210)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(proc1111_8)
			(clothes view: 27210 loop: 0 posn: 60 130 init:)
			(gGame handsOn: 0)
			(photo init: setHotspot: 4 3) ; Do, Move
			((ScriptID 0 14) init:) ; exitButt
			(SetFlag 248)
			(gCurRoom drawPic: 27210)
			(self dispose:)
		)
	)
)

(instance sArmoireClose of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(if (gFeatures contains: photo)
						(photo dispose:)
					)
					(proc1111_9)
					(chair view: 27100 posn: 109 115)
					(clothes view: 27100 loop: 2 cel: 1 posn: 131 59)
					(DoRobot 5342 107 27)
					(gCurRoom drawPic: 27100)
				)
				(1
					(ClearFlag 248)
					(clothes dispose:)
					(chair view: 27110 posn: 177 107)
					(if (gCast contains: coat)
						(coat posn: 222 89 view: 27110)
					)
					(if (IsFlag 218)
						(armoire dispose:)
					)
					(gEgo show: posn: 212 96 normalize: 4)
					(= global125 2)
					(gCurRoom drawPic: 27110)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(ClearFlag 248)
			(if (gCast contains: clothes)
				(clothes dispose:)
			)
			(if (gCast contains: coat)
				(coat posn: 222 89 view: 27110)
			)
			(if (IsFlag 218)
				(armoire dispose:)
			)
			(gEgo show: posn: 212 96 normalize: 4)
			(= global125 2)
			(chair view: 27110 posn: 177 107)
			(gCurRoom drawPic: 27110)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sPickUpPhoto of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo hide:)
					(clothes view: 27160 posn: -1 137 loop: 0 cel: 0)
					(gCurRoom drawPic: 27160)
					(DoRobot 5370 19 -47)
				)
				(1
					(clothes hide:)
					(thePhoto init:)
					(= seconds 5)
				)
				(2
					(clothes show:)
					(thePhoto dispose:)
					(DoRobot 5371 19 -47)
				)
				(3
					(thePhoto
						view: 5373
						loop: 1
						posn: 118 105
						setPri: 190
						init:
					)
					(= seconds 1)
					(Load 140 8052) ; WAVE
				)
				(4
					(gGDacSound
						number: 8052
						init:
						setVol: 127
						setLoop: 1
						play: self
					)
					(global114 pause:)
					(theEyes init: setPri: 200 cycleSpeed: 12 setCycle: End)
				)
				(5
					(theEyes hide:)
					(thePhoto hide:)
					(DoRobot 5372 19 -47)
				)
				(6
					(theEyes show:)
					(thePhoto show:)
					(gGDacSound
						number: 8052
						init:
						setVol: 127
						setLoop: 1
						play: self
					)
					(theEyes setCycle: Beg)
				)
				(7
					(= seconds 1)
				)
				(8
					(theEyes setCycle: 0 cel: 0)
					(= seconds 2)
				)
				(9
					(thePhoto dispose:)
					(theEyes dispose:)
					(global114 endPause:)
					(DoRobot 5373 19 -47)
				)
				(10
					(gEgo get: 11) ; invPhoto
					(SetFlag 218)
					(gCurRoom setScript: sArmoireClose)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(global114 endPause: 1)
			(gGDacSound stop:)
			(SetFlag 218)
			(thePhoto dispose:)
			(theEyes dispose:)
			(gEgo get: 11) ; invPhoto
			(gCurRoom setScript: sArmoireClose)
		)
	)
)

(instance sLookAtPoster of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 270 self)
						)
						(2
							(gEgo setHeading: 180 self)
						)
						(4
							(self changeState: 1)
						)
						(else
							(gEgo setHeading: 225 self)
						)
					)
				)
				(1
					(global114 pause:)
					(chair hide:)
					(if (gCast contains: coat)
						(coat hide:)
					)
					(DoRobot 5350 0 -43)
					(gCurRoom drawPic: 27170)
				)
				(2
					(global114 endPause:)
					(if (gCast contains: coat)
						(coat posn: 222 89 view: 27110 show:)
					)
					(SetFlag 307)
					(chair show:)
					(gEgo show: posn: 145 125 normalize: 1)
					(= global125 4)
					(gCurRoom drawPic: 27110)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(global114 endPause: 1)
					(SetFlag 307)
					(if (gCast contains: coat)
						(coat posn: 222 89 view: 27110 show:)
					)
					(chair show:)
					(gEgo show: posn: 145 125 normalize: 1)
					(= global125 4)
					(gCurRoom drawPic: 27110)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance changePri of Code
	(properties)

	(method (doit param1 param2)
		(param1 priority: (+ (param1 priority:) param2))
	)
)

(instance sLookMirrorVision of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 315 self 15)
						)
						(2
							(gEgo setHeading: 180 self)
						)
						(3
							(gEgo setHeading: 315 self 15)
						)
						(4
							(gEgo setHeading: 45 self 15)
						)
						(5
							(gEgo setHeading: 225 self)
						)
					)
				)
				(1
					(if (gCast contains: coat)
						(coat posn: 172 102 view: 27100)
					)
					(chair hide:)
					(DoRobot 5310 27 33)
					(gCurRoom drawPic: 27100)
				)
				(2
					(if (gCast contains: coat)
						(coat hide:)
					)
					(RemapColors 2 244 75) ; ByPercent
					(RemapColors 2 243 80) ; ByPercent
					(RemapColors 2 242 85) ; ByPercent
					(RemapColors 2 241 90) ; ByPercent
					(RemapColors 2 240 100) ; ByPercent
					(RemapColors 2 239 110) ; ByPercent
					(RemapColors 2 238 115) ; ByPercent
					(RemapColors 2 237 120) ; ByPercent
					(RemapColors 2 236 125) ; ByPercent
					(= local1 -1)
					(gGame handsOff:)
					(mist priority: 155 loop: 0 posn: 149 130 show:)
					(= local0 (List new:))
					(local0 add: mist)
					(for ((= temp0 1)) (< temp0 3) ((++ temp0))
						(= scratch (Prop new:))
						(scratch
							view: (mist view:)
							loop: (mist loop:)
							x: (mist x:)
							y: (mist y:)
							init:
							setPri: (- (mist priority:) temp0)
							cycleSpeed: (- (mist cycleSpeed:) temp0)
							setCycle: Fwd
						)
						(local0 add: scratch)
					)
					(gEgo hide:)
					(global114 pause:)
					(DoRobot 5473 75 11)
					(gCurRoom drawPic: 27130)
				)
				(3
					(= local1 0)
					(for ((= temp0 0)) (< temp0 (local0 size:)) ((++ temp0))
						(= scratch (local0 at: temp0))
						(scratch hide:)
					)
					(DoRobot 5474 -27 -42)
					(gCurRoom drawPic: 27140)
				)
				(4
					(= local1 1)
					(for ((= temp0 0)) (< temp0 (local0 size:)) ((++ temp0))
						(= scratch (local0 at: temp0))
						(scratch show:)
					)
					(DoRobot 5477 75 11)
					(gCurRoom drawPic: 27130)
				)
				(5
					(global114 endPause:)
					(= local1 0)
					(gEgo hide:)
					(for ((= temp0 0)) (< temp0 (local0 size:)) ((++ temp0))
						(= scratch (local0 at: temp0))
						(scratch loop: 1 cel: 0 setCycle: End)
					)
				)
				(6
					(if local0
						(local0
							delete: mist
							eachElementDo: #dispose
							release:
							dispose:
						)
						(= local0 0)
					)
					(mist dispose:)
					(mirror dispose:)
					(SetFlag 308)
					(chair show:)
					(if (gCast contains: coat)
						(coat posn: 222 89 view: 27110 show:)
					)
					(gEgo
						posn: 183 117
						normalize: 7
						setScaler: Scaler 147 77 132 86
						show:
					)
					(= global125 3)
					(gCurRoom drawPic: 27110)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(global114 endPause: 1)
					(if local0
						(local0
							delete: mist
							eachElementDo: #dispose
							release:
							dispose:
						)
						(= local0 0)
					)
					(mist dispose:)
					(mirror dispose:)
					(SetFlag 308)
					(chair show:)
					(if (gCast contains: coat)
						(coat posn: 222 89 view: 27110 show:)
					)
					(gEgo
						posn: 183 117
						normalize: 7
						setScaler: Scaler 147 77 132 86
						show:
					)
					(= global125 3)
					(gCurRoom drawPic: 27110)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sGetOrn of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 0 self)
						)
						(2
							(gEgo setHeading: 45 self 10)
						)
						(3
							(gEgo setHeading: 45 self 15)
						)
						(4
							(gEgo setHeading: 45 self 15)
						)
					)
				)
				(1
					(coat hide:)
					(chair hide:)
					(DoRobot 5920 -2 -43)
					(gCurRoom drawPic: 27260)
				)
				(2
					(chair show:)
					(coat show: setHotspot: 0)
					(gEgo get: 17 posn: 212 96 normalize: 3) ; invXmasOrn
					(= global125 2)
					(gCurRoom drawPic: 27110)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(chair show:)
			(coat show: setHotspot: 0)
			(gEgo get: 17 posn: 212 96 normalize: 3) ; invXmasOrn
			(= global125 2)
			(gCurRoom drawPic: 27110)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sLookMirror of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 315 self 15)
						)
						(2
							(gEgo setHeading: 180 self)
						)
						(3
							(gEgo setHeading: 315 self 15)
						)
						(4
							(gEgo setHeading: 45 self 15)
						)
						(5
							(gEgo setHeading: 225 self)
						)
					)
				)
				(1
					(chair hide:)
					(gEgo hide:)
					(if (gCast contains: coat)
						(coat posn: 172 102 view: 27100)
					)
					(DoRobot 5310 27 33)
					(gCurRoom drawPic: 27100)
				)
				(2
					(if (gCast contains: coat)
						(coat hide:)
					)
					(DoRobot 5330 58 -25 gEgo 200)
					(gCurRoom drawPic: 27130)
				)
				(3
					(if (gCast contains: coat)
						(coat posn: 172 102 view: 27100 show:)
					)
					(DoRobot 5320 86 58)
					(gCurRoom drawPic: 27100)
				)
				(4
					(if (gCast contains: coat)
						(coat posn: 222 89 view: 27110)
					)
					(chair show:)
					(gEgo
						posn: 183 117
						normalize: 4
						setScaler: Scaler 147 77 132 86
						show:
					)
					(= global125 3)
					(gCurRoom drawPic: 27110)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(if (gCast contains: coat)
				(coat posn: 222 89 view: 27110 show:)
			)
			(chair show:)
			(gEgo
				posn: 183 117
				normalize: 4
				setScaler: Scaler 147 77 132 86
				show:
			)
			(= global125 3)
			(gCurRoom drawPic: 27110)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setHeading: 135 self)
				)
				(1
					(gCurRoom newRoom: 8100)
					(self dispose:)
				)
			)
		else
			(gCurRoom newRoom: 8100)
			(self dispose:)
		)
	)
)

(instance mist of Prop
	(properties
		x 140
		y 130
		priority 150
		fixPriority 1
		view 27161
		scaleSignal 1
	)

	(method (init)
		(RemapColors 2 244 75) ; ByPercent
		(RemapColors 2 243 80) ; ByPercent
		(RemapColors 2 242 85) ; ByPercent
		(RemapColors 2 241 90) ; ByPercent
		(RemapColors 2 240 100) ; ByPercent
		(RemapColors 2 239 110) ; ByPercent
		(RemapColors 2 238 115) ; ByPercent
		(RemapColors 2 237 120) ; ByPercent
		(RemapColors 2 236 125) ; ByPercent
		(super init: &rest)
		(= cycleSpeed 7)
		(self setCycle: Fwd)
	)

	(method (doit &tmp temp0)
		(= temp0 cel)
		(super doit:)
		(if local1
			(cond
				((and (< local1 0) (> priority 110))
					(local0 eachElementDo: #perform changePri local1)
				)
				((<= priority 155)
					(local0 eachElementDo: #perform changePri local1)
				)
			)
		)
	)

	(method (dispose)
		(RemapColors 0) ; Off
		(super dispose:)
	)
)

(instance clothes of View
	(properties
		x 131
		y 59
		view 27100
		loop 2
	)
)

(instance photo of Feature
	(properties
		nsLeft 168
		nsRight 210
		nsBottom 17
		x 181
		y 13
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			((ScriptID 0 14) dispose:) ; exitButt
			(gCurRoom setScript: sPickUpPhoto)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance thePhoto of View
	(properties
		x -1
		y 132
		view 5371
	)
)

(instance theEyes of Prop
	(properties
		x 69
		y 110
		view 5373
	)
)

(instance coat of View
	(properties
		approachX 280
		approachY 107
		x 222
		y 89
		view 27110
		loop 1
	)

	(method (init)
		(if (not (gEgo has: 17)) ; invXmasOrn
			(coat cel: 0 setHotspot: 4 3) ; Do, Move
		else
			(coat cel: 1)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sGetOrn)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance poster of Feature
	(properties
		nsLeft 71
		nsRight 106
		nsBottom 52
		approachX 187
		approachY 127
		x 88
		y 26
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sLookAtPoster)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance armoire of Feature
	(properties
		nsLeft 165
		nsTop 25
		nsRight 201
		nsBottom 69
		x 183
		y 56
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sArmoireOpen)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance chair of View
	(properties
		x 177
		y 107
		view 27110
	)
)

(instance mirror of Feature
	(properties
		nsLeft 137
		nsTop 22
		nsRight 149
		nsBottom 69
		x 143
		y 45
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(if (and (not (IsFlag 308)) (== gChapter 6))
				(gCurRoom setScript: sLookMirrorVision)
			else
				(gCurRoom setScript: sLookMirror)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 150
		nsTop 122
		nsRight 291
		nsBottom 129
		x 145
		y 125
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouth)
		else
			(super doVerb: theVerb)
		)
	)
)

