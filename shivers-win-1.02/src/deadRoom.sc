;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 914)
(include sci.sh)
(use Main)
(use n951)
(use Plane)
(use Game)
(use Actor)
(use System)

(public
	deadRoom 0
)

(local
	local0
	local1
)

(instance buttonCast of Cast
	(properties)
)

(instance deadRoom of Room
	(properties)

	(method (init)
		(gGame handsOn:)
		(= local0
			((Plane new:)
				picture: 914
				priority: 40
				init: 0 0 320 200
				addCast: buttonCast
				yourself:
			)
		)
		(buttonCast plane: local0)
		(gSounds stopAll:)
		(aOkButton init:)
		(super init:)
		(switch (Random 0 18)
			(0
				(= local1 35071)
			)
			(1
				(= local1 35074)
			)
			(2
				(= local1 35075)
			)
			(3
				(= local1 35076)
			)
			(4
				(= local1 35077)
			)
			(5
				(= local1 35078)
			)
			(6
				(= local1 35079)
			)
			(7
				(= local1 35082)
			)
			(8
				(= local1 35084)
			)
			(9
				(= local1 35085)
			)
			(10
				(= local1 35086)
			)
			(11
				(= local1 35087)
			)
			(12
				(= local1 35088)
			)
			(13
				(= local1 35089)
			)
			(14
				(= local1 35090)
			)
			(15
				(= local1 35092)
			)
			(16
				(= local1 35093)
			)
			(17
				(= local1 35094)
			)
			(18
				(= local1 35073)
			)
		)
		(proc951_7 local1)
		(proc951_9 local1)
		(gSounds play: local1 0 75 0)
	)

	(method (dispose)
		(gSounds stop: local1)
		(local0 dispose:)
		(super dispose:)
	)
)

(instance aOkButton of Prop
	(properties
		x 150
		y 97
		view 914
	)

	(method (init)
		(super init: buttonCast)
		(gMouseDownHandler add: self)
	)

	(method (handleEvent event &tmp [temp0 2])
		(event localize: local0)
		(if (and (self onMe: event) (& (event type:) evMOUSEBUTTON))
			(event claimed: 1)
			(gCurRoom setScript: sOk)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(buttonCast delete: self)
		(super dispose: &rest)
	)
)

(instance sOk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 15037 0 106 0)
				(aOkButton cel: 1)
				(UpdateScreenItem aOkButton)
				(= cycles 1)
			)
			(1
				(aOkButton cel: 0)
				(UpdateScreenItem aOkButton)
				(if gShiversInvItem
					(= global105 0)
					(gShiversInvItem dispose:)
					(= gShiversInvItem 0)
				)
				((ScriptID 950 0) dispose:) ; vInterfaceView
				(gGame handsOn:)
				(gCurRoom newRoom: 910) ; shiversLogo
				(self dispose:)
			)
		)
	)
)

