;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22200)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	rm22200 0
)

(procedure (localproc_0)
	(if (gCast contains: rosaryBeads)
		(rosaryBeads view: 22202 x: 152 y: 103 setPri: 116 setCycle: Blink 120)
	)
	(if (not (gCast contains: carnoLid22200))
		(carnoLid22200 init:)
	)
	(if (not (gCast contains: marieLid22200))
		(marieLid22200 init:)
	)
	(gCurRoom drawPic: 22200)
)

(procedure (localproc_1)
	(if (gCast contains: rosaryBeads)
		(rosaryBeads
			view: 22330
			x: 110
			y: 86
			setPri: 160
			setCycle: Blink 120
			show:
		)
	)
	(if (gEgo fixPriority:)
		(doorExit approachX: 227 approachY: 80)
		(carnoText approachX: 98 approachY: 182)
		(marieText approachX: 98 approachY: 182)
		(carnoLid approachX: 98 approachY: 182)
		(marieLid approachX: 98 approachY: 182)
		(rosaryBeads approachX: 98 approachY: 182)
		(northExit approachX: 98 approachY: 182)
	else
		(doorExit approachX: 175 approachY: 83)
		(northExit approachX: 30 approachY: 62)
		(rosaryBeads approachX: 100 approachY: 126)
		(carnoText approachX: 52 approachY: 142)
		(marieText approachX: 52 approachY: 142)
		(carnoLid approachX: 52 approachY: 142)
		(marieLid approachX: 52 approachY: 142)
	)
	(if (gCast contains: carnoLid22200)
		(carnoLid22200 dispose:)
	)
	(if (gCast contains: marieLid22200)
		(marieLid22200 dispose:)
	)
	(gCurRoom drawPic: 22330)
)

(instance rm22200 of ScaryRoom
	(properties
		picture 22330
		stepSound 7
		baseView 6000
	)

	(method (drawPic param1)
		(if (and (ResCheck rsPIC (+ param1 1)) (== gChapter 5))
			(super drawPic: (+ param1 1) &rest)
		else
			(super drawPic: param1 &rest)
		)
	)

	(method (init &tmp temp0)
		(global114 play: 22050)
		(gEgo init: setScaler: Scaler 105 40 150 83 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
				(= temp0 0)
				(if
					(or
						(and (== (gEgo x:) 164) (== (gEgo y:) 116))
						(and (== (gEgo x:) 130) (== (gEgo y:) 130))
					)
					(gEgo setPri: (if (== gChapter 5) 130 else 170))
				)
			)
			(35110
				(gEgo normalize: 615 posn: 120 106)
				(if (not (IsFlag 254))
					(= picture 22210)
					(= temp0 1)
					(gCurRoom setScript: sLookInAwe)
				else
					(= temp0 0)
					(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
				)
			)
			(22100
				(gEgo normalize: 614 posn: 45 100)
				(self setScript: (ScriptID 0 5) 0 5) ; takeLastStep
				(= temp0 0)
			)
			(else
				(gEgo normalize: 615 posn: 120 106)
				(= temp0 0)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(super init: &rest)
		(if (not (gEgo has: 15)) ; invBeads
			(if (== gChapter 7)
				(if (not (gEgo has: 14)) ; invCrucifix
					(rosaryBeads
						init:
						setCycle: Blink 120
						approachVerbs: 4 ; Do
						setHotspot: 4 3 ; Do, Move
					)
					(if temp0
						(rosaryBeads hide:)
					)
				)
			else
				(carnoLid init: approachVerbs: 4 10 setHotspot: 4 3 10) ; Do, invPoker, Do, Move, invPoker
				(marieLid init: approachVerbs: 4 10 setHotspot: 4 3 10) ; Do, invPoker, Do, Move, invPoker
			)
		)
		(carnoText init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(marieText init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(doorExit init: 2)
		(northExit init: 13)
		(if (gEgo fixPriority:)
			(localproc_1)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 35110)
			(global114 play: 4050)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance sLookInAwe of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 254)
					(DoRobot 5130 -4 -5)
				)
				(1
					(localproc_1)
					(self setScript: (ScriptID 0 5) self) ; takeLastStep
				)
				(2
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(SetFlag 254)
					(localproc_1)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance readCarnoTextScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 5150 -6 -14)
					(if (gCast contains: rosaryBeads)
						(rosaryBeads hide:)
					)
					(gCurRoom drawPic: 22220)
				)
				(1
					(gEgo hide:)
					(gCurRoom drawPic: 22225)
					(if (not (or (IsFlag 330) (IsFlag 206)))
						(FrameOut)
						(global114 pause: 22053 self)
					else
						(= seconds 5)
					)
				)
				(2
					(if (or (IsFlag 330) (IsFlag 206))
						(= cycles 1)
					else
						(gEgo show:)
						(DoRobot 5152 -8 -5)
						(gCurRoom drawPic: 22240)
					)
				)
				(3
					(gEgo show:)
					(if (IsFlag 330)
						(gEgo
							normalize: 614
							posn: 130 130
							setPri: (if (== gChapter 5) 130 else 170)
						)
					else
						(SetFlag 330)
						(gEgo
							normalize: 614
							posn: 164 116
							setPri: (if (== gChapter 5) 130 else 170)
						)
					)
					(localproc_1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(if (global114 script:)
						(global114 endPause:)
					)
					(gEgo show:)
					(if (IsFlag 330)
						(gEgo
							normalize: 614
							posn: 130 130
							setPri: (if (== gChapter 5) 130 else 170)
						)
					else
						(SetFlag 330)
						(gEgo
							normalize: 614
							posn: 164 116
							setPri: (if (== gChapter 5) 130 else 170)
						)
					)
					(localproc_1)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance tryCarnoLidScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 332)
					(DoRobot 5160 -9 -10)
					(gCurRoom drawPic: 22220)
					(if (gCast contains: rosaryBeads)
						(rosaryBeads hide:)
					)
				)
				(1
					(gEgo
						normalize: 614
						posn: 130 130
						setPri: (if (== gChapter 5) 130 else 170)
					)
					(localproc_1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(gEgo
						normalize: 614
						posn: 130 130
						setPri: (if (== gChapter 5) 130 else 170)
					)
					(localproc_1)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookCarnoLidScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(localproc_0)
					(DoRobot 5170 138 39)
				)
				(1
					(gEgo
						normalize: 614
						posn: 130 130
						setPri: (if (== gChapter 5) 130 else 170)
					)
					(localproc_1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(gEgo
						normalize: 614
						posn: 130 130
						setPri: (if (== gChapter 5) 130 else 170)
					)
					(localproc_1)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance removeCarnoLidScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(localproc_0)
					(SetFlag 256)
					(carnoLid22200 hide:)
					(if (== gChapter 5)
						(DoRobot 5184 79 24 gEgo 200)
					else
						(DoRobot 5181 157 47 gEgo 200)
					)
				)
				(1
					(DoRobot 5180 -84 -43 gEgo 200)
					(if (gCast contains: rosaryBeads)
						(rosaryBeads hide:)
					)
					(gCurRoom drawPic: 22230)
					(marieLid22200 hide:)
				)
				(2
					(DoRobot 5183 89 1)
					(gCurRoom drawPic: 22240)
				)
				(3
					(DoRobot 5189 -14 -22 gEgo 200 1)
					(gCurRoom drawPic: 22230)
				)
				(4
					(if (== gChapter 5)
						(DoRobot 5185 56 16 gEgo 200)
					else
						(DoRobot 5182 110 17 gEgo 200)
					)
					(marieLid22200 show:)
					(localproc_0)
					(if (gCast contains: rosaryBeads)
						(rosaryBeads show:)
					)
				)
				(5
					(gEgo
						normalize: 614
						posn: 130 130
						setPri: (if (== gChapter 5) 130 else 170)
					)
					(localproc_1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo
						normalize: 614
						setPri: (if (== gChapter 5) 130 else 170)
						posn: 130 130
					)
					(localproc_1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance readMarieTextScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 5190 61 38)
					(localproc_0)
				)
				(1
					(gEgo hide:)
					(marieLid22200 hide:)
					(carnoLid22200 hide:)
					(if (gCast contains: rosaryBeads)
						(rosaryBeads hide:)
					)
					(gCurRoom drawPic: 22265)
					(= seconds 5)
				)
				(2
					(DoRobot 5191 61 38)
					(marieLid22200 show:)
					(carnoLid22200 show:)
					(if (gCast contains: rosaryBeads)
						(rosaryBeads show:)
					)
					(localproc_0)
				)
				(3
					(gEgo show:)
					(gEgo normalize: 614 posn: 40 112)
					(localproc_1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(gEgo show:)
					(gEgo normalize: 614 posn: 40 112)
					(localproc_1)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance tryMarieLidScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 5200 77 35)
					(SetFlag 333)
					(localproc_0)
				)
				(1
					(gGame handsOn:)
					(gEgo normalize: 614 posn: 40 112)
					(localproc_1)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 614 posn: 40 112)
					(localproc_1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookMarieLidScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 5171 69 44)
					(localproc_0)
				)
				(1
					(gGame handsOn:)
					(gEgo normalize: 614 posn: 40 112)
					(localproc_1)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 614 posn: 40 112)
					(localproc_1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance openMarieLidScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(SetFlag 331)
					(gGame handsOff:)
					(if (== gChapter 5)
						(DoRobot 5214 -3 12 gEgo 200)
					else
						(DoRobot 5211 64 22 gEgo 200)
					)
					(localproc_0)
					(marieLid22200 hide:)
				)
				(1
					(carnoLid22200 hide:)
					(DoRobot 5210 46 -12)
					(gCurRoom drawPic: 22280)
				)
				(2
					(if (== gChapter 5)
						(DoRobot 5215 12 20 gEgo 200)
					else
						(DoRobot 5212 71 32 gEgo 200)
					)
					(carnoLid22200 show:)
					(localproc_0)
				)
				(3
					(gGame handsOn:)
					(gEgo normalize: 614 posn: 40 112)
					(localproc_1)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(gEgo normalize: 614 posn: 40 112)
					(localproc_1)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sGetBeads of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(localproc_0)
					(DoRobot 5910 104 44 gEgo 120)
				)
				(1
					(gEgo get: 15) ; invBeads
					(rosaryBeads dispose:)
				)
				(2
					(gEgo normalize: 614 posn: 40 112)
					(localproc_1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(gEgo get: 15) ; invBeads
					(rosaryBeads dispose:)
					(gEgo show:)
					(gEgo normalize: 614 posn: 40 112)
					(localproc_1)
					(gEgo get: 15) ; invBeads
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance carnoLid22200 of View
	(properties
		x 191
		y 108
		priority 125
		fixPriority 1
		view 22200
	)

	(method (init)
		(if (== gChapter 5)
			(= view 22204)
		)
		(super init:)
	)
)

(instance marieLid22200 of View
	(properties
		x 121
		y 95
		priority 115
		fixPriority 1
		view 22201
	)

	(method (init)
		(if (== gChapter 5)
			(= view 22205)
		)
		(super init:)
	)
)

(instance rosaryBeads of Prop
	(properties
		approachX 100
		approachY 126
		x 110
		y 86
		priority 160
		fixPriority 1
		view 22330
	)

	(method (handleEvent event)
		(if (and (== global163 marieText) (self onMe: event))
			(= global163 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetBeads)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carnoText of Feature
	(properties
		sightAngle 40
		approachX 52
		approachY 142
		x 135
		y 135
	)

	(method (handleEvent event)
		(if (and (== global163 carnoLid) (self onMe: event))
			(= global163 self)
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 143 93 233 100 233 130 143 130
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: readCarnoTextScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance carnoLid of Feature
	(properties
		nsLeft 199
		nsTop 81
		nsRight 280
		nsBottom 96
		sightAngle 40
		approachX 52
		approachY 142
		x 236
		y 139
	)

	(method (handleEvent event)
		(if (and (== global163 carnoText) (self onMe: event))
			(= global163 self)
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 142 88 235 95 280 79 275 76 209 75 145 81
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 332)
					(gCurRoom setScript: lookCarnoLidScr)
				else
					(gCurRoom setScript: tryCarnoLidScr)
				)
			)
			(10 ; invPoker
				(gGame handsOff:)
				(gCurRoom setScript: removeCarnoLidScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance marieText of Feature
	(properties
		sightAngle 40
		approachX 52
		approachY 142
		x 50
		y 145
	)

	(method (handleEvent event)
		(if
			(and
				(or (== global163 marieLid) (== global163 rosaryBeads))
				(self onMe: event)
			)
			(= global163 self)
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 59 85 92 90 92 129 86 129 59 122
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: readMarieTextScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance marieLid of Feature
	(properties
		nsLeft 124
		nsTop 78
		nsRight 202
		nsBottom 85
		sightAngle 40
		approachX 52
		approachY 142
		x 110
		y 125
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 57 79 91 82 179 75 176 70 139 70 62 74
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(if (and (== global163 marieText) (self onMe: event))
			(= global163 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(if (IsFlag 333)
					(gCurRoom setScript: lookMarieLidScr)
				else
					(gCurRoom setScript: tryMarieLidScr)
				)
			)
			(10 ; invPoker
				(gCurRoom setScript: openMarieLidScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leonoraText of Feature ; UNUSED
	(properties
		nsLeft 78
		nsTop 70
		nsRight 108
		nsBottom 87
		sightAngle 40
		approachX 82
		approachY 86
		x 103
		y 65
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 45 67 75 67 75 74 65 74 57 75 57 82 44 80
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(= global125 43)
			(gCurRoom newRoom: 22100)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance reginaText of Feature ; UNUSED
	(properties
		nsLeft 112
		nsTop 74
		nsRight 153
		nsBottom 79
		sightAngle 40
		approachX 100
		approachY 75
		x 146
		y 75
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 84 67 126 66 126 71 84 74
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(= global125 45)
			(gCurRoom newRoom: 22100)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance doorExit of ExitFeature
	(properties
		nsLeft 180
		nsTop 30
		nsRight 209
		nsBottom 86
		approachX 175
		approachY 83
		x 292
		y 83
		nextRoom 35110
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 159 71 160 35 165 22 172 15 183 21 186 25 175 30 174 35 174 44 186 45 186 75 180 75 178 71
					yourself:
				)
		)
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 0
		nsRight 40
		nsBottom 100
		approachX 30
		approachY 70
		nextRoom 22100
	)
)

