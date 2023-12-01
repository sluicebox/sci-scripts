;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10701)
(include sci.sh)
(use Main)
(use Trigger)
(use n1111)
(use n10700)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm10701 0
)

(local
	local0
	local1
	local2
	local3 = 1
	local4
	local5
	local6
)

(instance rm10701 of ScaryRoom
	(properties
		picture 10705
	)

	(method (init &tmp temp0)
		(KillRobot)
		(= temp0 0)
		(if (and (IsFlag 372) (IsFlag 373) (IsFlag 374))
			(= local5 1)
		)
		(gEgo init: normalize: setScaler: Scaler 192 71 162 98)
		(if (not global172)
			(= global172 1)
		)
		(if (== gPrevRoomNum 900)
			(= global115 1)
		)
		(cond
			((and (not (IsFlag 372)) (== global172 1))
				(= temp0 sScene101)
			)
			((and (IsFlag 53) (>= global172 3))
				(= temp0 sEnterAlone)
			)
			((not (IsFlag 343))
				(= temp0 sTickleDon)
			)
			(else
				(= temp0 sScene111)
			)
		)
		(= local6 0)
		(super init:)
		(= local6 1)
		(proc10700_0 -1)
		(if temp0
			(self setScript: temp0)
		else
			(gGame handsOn:)
		)
	)

	(method (drawPic)
		(if (and (== gPrevRoomNum 900) (not local6))
			(return)
		else
			(super drawPic: &rest)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 13400)
			(SetFlag 345)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance don of Actor
	(properties
		approachX 205
		approachY 105
		z 1000
		view 1011
		signal 26657
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 10)
	)

	(method (doVerb)
		(cond
			((and (not (IsFlag 343)) (> global172 3))
				(donFeat dispose:)
				(gCurRoom setScript: sTickleDon)
			)
			(local1
				(donFeat dispose:)
				(gCurRoom setScript: sScene103 0 self)
			)
			(else
				(= local1 1)
				(gCurRoom setScript: sScene102 0 self)
			)
		)
	)
)

(instance southExit of Trigger
	(properties
		approachX 158
		approachY 189
		exitDir 3
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 118 125 108 141 135 142 135 135 160 135 159 143 224 137 218 125
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sExitScr 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance donFeat of Feature
	(properties
		sightAngle 360
		approachX 205
		approachY 105
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 169 98 194 90 199 95 207 92 215 107 178 104
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(don doVerb: theVerb)
	)
)

(instance lamp of Feature
	(properties
		sightAngle 360
		approachX 195
		approachY 111
		x 188
		y 51
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 166 1 179 33 191 1 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sScene106)
		(self dispose:)
	)
)

(instance sink of Feature
	(properties
		sightAngle 360
		approachX 205
		approachY 105
		x 217
		y 78
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 203 76 203 85 235 104 235 72
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sScene104 0 self)
		(self dispose:)
	)
)

(instance sScene102 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(don dispose:)
					(gEgo hide:)
					(DoRobot 1021 22 -31 gEgo 20)
					(proc10700_0 10685)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(proc1111_0 0)
		(= global115 0)
		(SetFlag 373)
		(sCleanUp register: self)
		(= next sCleanUp)
		(super dispose: &rest)
	)
)

(instance sScene106 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(don dispose:)
					(gEgo hide:)
					(DoRobot 1061 45 -21 gEgo 10)
					(proc10700_0 10725)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(proc1111_0 0)
		(= global115 0)
		(SetFlag 364)
		(sCleanUp register: self)
		(= next sCleanUp)
		(super dispose: &rest)
	)
)

(instance toilet of Feature ; UNUSED
	(properties
		sightAngle 360
		approachX 153
		approachY 111
		x 152
		y 66
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 149 46 166 46 166 79 160 87 160 94 152 94 146 81 153 77 153 56 149 56
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sScene105)
		(self dispose:)
	)
)

(instance sScene105 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= local0 1)
					(don dispose:)
					(gEgo hide:)
					(DoRobot 1050 46 23)
					(proc10700_0 10695)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(proc1111_0 0)
		(= global115 0)
		(sCleanUp register: self)
		(= next sCleanUp)
		(super dispose: &rest)
	)
)

(instance sScene111 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(DoRobot 1110 50 21 gEgo 40)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(proc1111_0 0)
		(= global115 0)
		(sCleanUp register: self)
		(= next sCleanUp)
		(super dispose: &rest)
	)
)

(instance sDonWorks of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(don cycleSpeed: (Random 4 8))
					(switch (Random 1 4)
						(1
							(don
								cel: (Random 0 (- (don lastCel:) 1))
								setCycle: End self
							)
						)
						(2
							(don
								cel: (Random 1 (don lastCel:))
								setCycle: Beg self
							)
						)
						(3
							(don cel: 0 setCycle: End self)
						)
						(4
							(don cel: (don lastCel:) setCycle: Beg self)
						)
					)
					(self setScript: workSounds)
				)
				(1
					(if (not (Random 0 1))
						(self init:)
					else
						(= ticks (Random 30 90))
					)
				)
				(2
					(self init:)
				)
			)
		)
	)

	(method (dispose)
		(gGDacSound client: 0 stop:)
		(super dispose: &rest)
	)
)

(instance workSounds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(switch (Random 0 4)
					(0
						(gGDacSound number: 10614)
					)
					(1
						(gGDacSound number: 10613)
					)
					(2
						(gGDacSound number: 10614)
					)
					(3
						(gGDacSound number: 10613)
					)
					(else
						(gGDacSound number: 10614)
					)
				)
				(gGDacSound setLoop: 1 setVol: 50 play: self)
			)
			(2
				(if (Random 0 1)
					(= ticks (Random 5 20))
				else
					(self dispose:)
				)
			)
			(3
				(if (don cycler:)
					(self init:)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance wrench of View
	(properties
		x 245
		y 73
		view 10685
	)
)

(instance sScene101 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(wrench init: view: 10707 x: 132 y: 81 setPri: 30)
					(gEgo hide:)
					(DoRobot 1015 36 1 gEgo 100)
				)
				(1
					(DoRobot 1014 61 7)
					(proc10700_0 10665)
					(wrench
						view: 10665
						setLoop: 0 1
						cel: 0
						x: 233
						y: 93
						setPri: 30
					)
				)
				(2
					(wrench
						view: 10685
						setLoop: 0 1
						cel: 0
						x: 245
						y: 73
						setPri: -1
					)
					(DoRobot 1011 13 -32 gEgo -1 1)
					(proc10700_0 10685)
				)
				(3
					(wrench dispose:)
				)
				(4
					(DoRobot 10120 64 46 gEgo 40 1)
					(proc10700_0 10705)
				)
				(5
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(= global115 0)
		(if (gCast contains: wrench)
			(wrench dispose:)
		)
		(SetFlag 372)
		(sCleanUp register: self)
		(= next sCleanUp)
		(super dispose: &rest)
	)
)

(instance sScene103 of Script
	(properties)

	(method (dispose)
		(proc1111_0 0)
		(= global115 0)
		(= local5 1)
		(SetFlag 374)
		(sCleanUp register: self)
		(= next sCleanUp)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(don dispose:)
					(gEgo hide:)
					(DoRobot 1030 38 -16 gEgo 20)
					(proc10700_0 10725)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)
)

(instance sCleanUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(KillRobot)
				(if (== register sScene105)
					(gEgo
						view: 0
						normalize: 0
						heading: 90
						x: 145
						y: 120
						z: 0
						show:
						setScaler: Scaler 192 71 162 98
					)
				else
					(gEgo
						view: 10702
						heading: 360
						x: 197
						y: 121
						z: 0
						setPri: 200
						setScaler: Scaler 65 31 130 99
						cel: (gEgo lastCel:)
						show:
					)
				)
				(if (not local5)
					(donFeat approachVerbs: 4 1 3 2 21 init: setHotspot: 4 3) ; Do, ???, Move, ???, Exit, Do, Move
				)
				(don
					view: 1010
					x: 170
					y: 105
					z: 0
					setPri: 4
					setCycle: 0
					approachVerbs: 0
					setHotspot: 0
					init:
					setScript: sDonWorks
				)
				(if (not (IsFlag 364))
					(lamp setHotspot: 4 1 3 2 21 init: approachVerbs: 0) ; Do, ???, Move, ???, Exit
				)
				(if (not (IsFlag 363))
					(sink setHotspot: 4 1 3 2 21 init: approachVerbs: 0) ; Do, ???, Move, ???, Exit
				)
				(southExit init:)
				(if (not (gCast contains: gEgo))
					(gEgo init:)
				)
				(proc10700_0 10700)
				(= cycles 2)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTickleDon of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(don dispose:)
					(gEgo hide:)
					(DoRobot 1111 20 5 gEgo 40)
					(proc10700_0 10705)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(proc1111_0 0)
		(= global115 0)
		(SetFlag 343)
		(if (IsFlag 373)
			(= local5 1)
		)
		(sCleanUp register: self)
		(= next sCleanUp)
		(super dispose: &rest)
	)
)

(instance sScene104 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(don dispose:)
					(gEgo hide:)
					(DoRobot 1040 -15 -41)
					(proc10700_0 10715)
				)
				(1
					(DoRobot 1041 11 7 gEgo 100)
					(proc10700_0 10705)
				)
				(2
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(proc1111_0 0)
		(= global115 0)
		(SetFlag 363)
		(sCleanUp register: self)
		(= next sCleanUp)
		(super dispose: &rest)
	)
)

(instance sExitScr of Script
	(properties)

	(method (dispose)
		(gCurRoom newRoom: 13400)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not local3)
						(gEgo z: 1000)
						(DoRobot 1121 101 20 gEgo -1 1)
						(proc10700_0 10705)
					else
						(gEgo view: 10703 cel: 0 setCycle: End self)
					)
				)
				(1
					(self dispose:)
				)
			)
		)
	)
)

(instance sEnterAlone of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(if (IsFlag 350)
						(DoRobot 1561 164 20)
					else
						(SetFlag 350)
						(DoRobot 1120 139 29)
					)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(proc1111_0 0)
		(if global115
			(KillRobot)
			(= global115 0)
		)
		(southExit init:)
		(gEgo
			view: 10702
			heading: 360
			x: 193
			y: 132
			z: 0
			setScaler: Scaler 65 31 130 99
			cel: (gEgo lastCel:)
			show:
		)
		(SetFlag 341)
		(proc10700_0 10700)
		(= local3 0)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

