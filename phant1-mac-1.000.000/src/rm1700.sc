;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1700)
(include sci.sh)
(use Main)
(use scaryInvInit)
(use ExitFeature)
(use n1111)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1700 0
)

(instance rm1700 of ScaryRoom
	(properties)

	(method (init &tmp temp0)
		(= temp0 0)
		(gGame setIntensity: 100)
		(if (IsFlag 4)
			(= picture 1701)
		else
			(= picture 1702)
		)
		(if global184
			(global114 endPause:)
		)
		(rug setPri: 30 init:)
		(light init: setHotspot: 4 3) ; Do, Move
		(door init: 3)
		(gEgo init:)
		(switch gPrevRoomNum
			(900
				(if (IsFlag 226)
					(ClearFlag 226)
					(proc28_2)
				)
				(gEgo setCel: (gEgo lastCel:))
				(gGame handsOn:)
			)
			(1800
				(cond
					((== global125 59)
						(= temp0 sPullRug)
					)
					((IsFlag 4)
						(gEgo
							view: 191
							setLoop: 0
							cel: 0
							setScale: 0
							x: 134
							y: 132
						)
						(= temp0 sTurnOffLight)
					)
					(else
						(gEgo view: 60 cel: 0 x: 160 y: 129 setScale: 0)
						(= temp0 sWalkOut)
					)
				)
			)
			(else
				(gEgo view: 50 cel: 0 x: 163 y: 131 setScale: 0)
				(= temp0 sWalkIn)
			)
		)
		(super init:)
		(if temp0
			(self setScript: temp0)
		)
	)

	(method (dispose)
		(Load rsVIEW 199 0)
		(Load rsVIEW 1702 0)
		(super dispose:)
	)
)

(instance rug of View
	(properties
		priority 30
		fixPriority 1
		view 199
	)

	(method (init)
		(if (not (IsFlag 4))
			(= view 1702)
		)
		(if (IsFlag 6)
			(= loop 1)
			(= x 63)
			(= y 117)
		else
			(= loop 0)
			(= x 109)
			(= y 85)
		)
		(super init: &rest)
	)
)

(instance light of Feature
	(properties
		nsLeft 194
		nsTop 45
		nsRight 245
		nsBottom 95
		sightAngle 360
		x 219
		y 70
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sTurnOnLight)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 86
		nsTop 107
		nsRight 211
		sightAngle 360
		x 148
		y 118
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(if (IsFlag 4)
				(gCurRoom setScript: sTurnOffLight)
			else
				(gCurRoom setScript: sWalkOut)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sWalkIn of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 2)
				)
				(1
					(gEgo setCycle: End self)
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
		(KillRobot)
		(if global115
			(= global115 0)
		)
		(gEgo cel: (gEgo lastCel:))
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sWalkOut of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 60
						loop: 0
						cel: 0
						setScale: 0
						x: 160
						y: 129
						setCycle: End self
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
		(if global184
			(global114 endPause:)
			(global114 pause: 3020 0 -1)
			(global114 setVol: (= global184 31) 1)
		)
		(ClearFlag 4)
		(= global115 0)
		(= gNewRoomNum 1100)
		(super dispose: &rest)
	)
)

(instance sTurnOnLight of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsVIEW 199 1)
					(SetFlag 4)
					(gEgo
						view: 190
						loop: 0
						cel: 0
						setScale: 0
						x: 133
						y: 133
						setCycle: End self
					)
				)
				(1
					(rug view: 199)
					(gCurRoom drawPic: 1701)
					(lightSnd play:)
					(gEgo setCycle: Beg self)
				)
				(2
					(lightSnd stop:)
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(lightSnd stop:)
		(KillRobot)
		(if global115
			(= global115 0)
		)
		(gCurRoom drawPic: 1701)
		(SetFlag 4)
		(= gNewRoomNum 1800)
		(super dispose: &rest)
	)
)

(instance sPullRug of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 6)
					(gEgo view: 50 cel: 13 setPri: 1 init: hide:)
					(DoRobot 212 30 7 gEgo 1 1)
					(rug z: 1000)
					(UpdateScreenItem rug)
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
		(KillRobot)
		(if global115
			(= global115 0)
		)
		(= global125 0)
		(gGame handsOff:)
		(= gNewRoomNum 1800)
		(super dispose: &rest)
	)
)

(instance sTurnOffLight of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsVIEW 1702 1)
					(= ticks 120)
				)
				(1
					(ClearFlag 4)
					(gCurRoom drawPic: 1702)
					(lightSnd play:)
					(rug view: 1702)
					(if (!= (gEgo view:) 191)
						(gEgo
							view: 191
							setLoop: 0
							cel: 0
							setScale: 0
							x: 134
							y: 132
						)
					)
					(gEgo setCycle: End self)
				)
				(2
					(lightSnd stop:)
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(KillRobot)
		(lightSnd stop:)
		(if global115
			(gCurRoom drawPic: 1702)
			(= global115 0)
		)
		(ClearFlag 4)
		(= next sWalkOut)
		(super dispose: &rest)
	)
)

(instance lightSnd of Sound
	(properties
		number 1019
	)
)

