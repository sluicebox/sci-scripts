;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31200)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Scaler)
(use Actor)
(use System)

(public
	rm31200 0
)

(instance rm31200 of ScaryRoom
	(properties
		picture 31200
		north 31100
		stepSound 4
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(gEgo init: setScaler: Scaler 251 59 157 86 normalize: setPri: 100)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(31100
				(gEgo view: 5 posn: 100 120)
			)
			(else
				(gEgo view: 6 posn: 55 135)
			)
		)
		(northExit init: 1)
		(southExit init: 3)
		(door31200 init:)
		(super init: &rest)
		(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
	)
)

(instance sTo31100 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setHeading: 45 self)
				)
				(1
					(gCurRoom newRoom: 31100)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gCurRoom newRoom: 31100)
				)
			)
		)
	)
)

(instance door31200 of View
	(properties
		x 147
		y 83
		view 31200
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 126
		nsTop 64
		nsRight 192
		nsBottom 108
		x 85
		y 80
		nextRoom 31100
		appYOffset -10
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sTo31100)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 37
		nsRight 233
		x 20
		y 180
		nextRoom 31300
		appYOffset 20
	)
)

