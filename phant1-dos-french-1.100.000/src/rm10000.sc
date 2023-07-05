;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10000)
(include sci.sh)
(use Main)
(use Scaler)
(use Polygon)
(use Motion)
(use System)

(public
	rm10000 0
)

(local
	local0
)

(instance rm10000 of ScaryRoom
	(properties
		picture 10000
		stepSound 4
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 133 122 116 90 122 90 146 97 190 88 156 82 87 87 103 107 106 122
					yourself:
				)
		)
		(gEgo
			init:
			setScaler: Scaler 87 57 145 87
			setIntensity: (- (gGame intensity:) 20) 1
			normalize:
		)
		((ScriptID 30) init:) ; FidgetCode
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(10200
				(gEgo view: 732 loop: 0 setScale: 0 posn: 111 111)
				(gCurRoom setScript: sToDoor)
			)
			(else
				(gEgo view: 731 posn: 139 89 setScale: 0)
				(gCurRoom setScript: sEnterTheRoom)
			)
		)
		(super init:)
	)
)

(instance sEnterTheRoom of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= local0 (gEgo cycleSpeed:))
					(= seconds 2)
				)
				(1
					(gEgo cycleSpeed: 8 setCycle: CT 33 1 self)
				)
				(2
					(gEgo cycleSpeed: 12 setCycle: End self)
				)
				(3
					(if (not (IsFlag 56))
						(SetFlag 56)
						(gEgo
							view: 8
							cycleSpeed: local0
							posn: 107 102
							normalize: 8
						)
					else
						(gEgo
							view: 2
							cycleSpeed: local0
							posn: 103 110
							normalize: 2
						)
					)
					(gCurRoom newRoom: 10100)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(if (not (IsFlag 56))
						(SetFlag 56)
						(gEgo
							view: 8
							cycleSpeed: local0
							posn: 107 102
							normalize: 8
						)
					else
						(gEgo
							view: 2
							cycleSpeed: local0
							posn: 103 110
							normalize: 2
						)
					)
					(gCurRoom newRoom: 10100)
				)
			)
		)
	)
)

(instance sToDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= local0 (gEgo cycleSpeed:))
					(= cycles 2)
				)
				(1
					(gEgo cycleSpeed: 6 setCycle: End self)
				)
				(2
					(gEgo
						view: 0
						cycleSpeed: local0
						posn: 107 102
						normalize: 0
						setIntensity: 100 1
					)
					(gCurRoom newRoom: 13100)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gEgo
						view: 0
						cycleSpeed: local0
						posn: 107 102
						normalize: 0
					)
					(gCurRoom newRoom: 13100)
				)
			)
		)
	)
)

