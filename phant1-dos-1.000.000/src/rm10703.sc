;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10703)
(include sci.sh)
(use Main)
(use Trigger)
(use n1111)
(use n10700)
(use Scaler)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm10703 0
)

(local
	local0
)

(instance rm10703 of ScaryRoom
	(properties
		picture 10700
	)

	(method (init &tmp temp0)
		(proc1111_6)
		(if (== gPrevRoomNum 900)
			(gEgo init: normalize: setScaler: Scaler 192 71 162 98)
			(gGame handsOn:)
		else
			(gEgo
				view: 6
				normalize: 6
				x: 162
				y: 129
				z: 0
				heading: 45
				init:
				setScaler: Scaler 192 71 162 98
			)
		)
		(don view: 1011 cycleSpeed: 10 x: 196 y: 102 init: setCycle: Fwd)
		(if (not (IsFlag 322))
			(= picture 10705)
			(= temp0 sDoScene155)
		else
			(= temp0 sScene155Done)
		)
		(if (== gPrevRoomNum 900)
			(= global115 1)
		)
		(= local0 0)
		(super init:)
		(= local0 1)
		(proc10700_0 -1)
		(self setScript: temp0)
	)

	(method (drawPic)
		(if (and (== gPrevRoomNum 900) (not local0))
			(return)
		else
			(super drawPic: &rest)
		)
	)
)

(instance sScene155Done of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(don dispose:)
					(proc1111_7 1010 22 11 gEgo -1 1)
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
		(if global115
			(proc1111_6)
			(= global115 0)
		)
		(proc1111_0 0)
		(sCleanUp register: self)
		(= next sCleanUp)
		(super dispose: &rest)
	)
)

(instance don of Actor
	(properties
		signal 26657
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 10)
	)

	(method (doVerb)
		(gCurRoom setScript: sScene155Done 0 0)
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
			(gCurRoom setScript: sExitSouth 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sCleanUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc1111_6)
				(gEgo
					view: 10702
					heading: 360
					x: 197
					y: 121
					z: 0
					setScaler: Scaler 65 31 130 99
					cel: (gEgo lastCel:)
					show:
				)
				(don
					view: 1011
					cycleSpeed: 10
					x: 196
					y: 102
					approachVerbs: 0
					setHotspot: 0
				)
				(southExit init:)
				(if (not (gCast contains: gEgo))
					(gEgo init:)
				)
				(if (not (gCast contains: don))
					(don init:)
				)
				(proc10700_0 10700)
				(UpdatePlane (gCast plane:))
				(= cycles 2)
			)
			(1
				(gGame handsOn:)
				(don setScript: sDonWorks)
				(self dispose:)
			)
		)
	)
)

(instance sDonWorks of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(don cycleSpeed: (Random 6 10))
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
						(gGDacSound number: 10611)
					)
					(1
						(gGDacSound number: 10612)
					)
					(2
						(gGDacSound number: 10611)
					)
					(3
						(gGDacSound number: 10612)
					)
					(else
						(gGDacSound number: 10611)
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

(instance sExitSouth of Script
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
					(gEgo view: 10703 cel: 0 setCycle: End self)
				)
				(1
					(self dispose:)
				)
			)
		)
	)
)

(instance sDoScene155 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(don dispose:)
					(proc1111_7 1551 31 5 gEgo 120 1)
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
		(if global115
			(proc1111_6)
			(= global115 0)
		)
		(proc1111_0 0)
		(sCleanUp register: self)
		(= next sCleanUp)
		(super dispose: &rest)
	)
)

