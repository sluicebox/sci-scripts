;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 923)
(include sci.sh)
(use Main)
(use n951)
(use Plane)
(use Game)
(use Actor)
(use System)

(public
	endGame 0
)

(local
	local0
	local1
)

(instance buttonCast of Cast
	(properties)
)

(instance endGame of Room
	(properties)

	(method (init &tmp [temp0 2])
		(gGame handsOn:)
		(= local0
			((Plane new:)
				picture: 923
				priority: 40
				init: 0 0 320 200
				addCast: buttonCast
				yourself:
			)
		)
		(buttonCast plane: local0)
		(okBtn init:)
		(exploreBtn init:)
		(quitBtn init:)
		(super init:)
		(switch (Random 0 1)
			(0
				(proc951_9 35101)
				(gSounds play: 35101 0 92 0)
			)
			(1
				(proc951_9 35102)
				(gSounds play: 35102 0 92 0)
			)
		)
	)

	(method (dispose)
		(local0 dispose:)
		(super dispose:)
	)
)

(instance okBtn of Prop
	(properties
		x 30
		y 175
		view 923
	)

	(method (init)
		(super init: buttonCast &rest)
		(gMouseDownHandler add: self)
	)

	(method (handleEvent event &tmp [temp0 2])
		(event localize: local0)
		(if
			(and
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				(gUser canControl:)
			)
			(event claimed: 1)
			(self setScript: sButton)
		)
	)

	(method (dispose)
		(buttonCast delete: self)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance exploreBtn of Prop
	(properties
		x 95
		y 175
		view 923
		loop 1
	)

	(method (init)
		(super init: buttonCast &rest)
		(gMouseDownHandler add: self)
	)

	(method (handleEvent event &tmp [temp0 2])
		(event localize: local0)
		(if
			(and
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				(gUser canControl:)
			)
			(event claimed: 1)
			(self setScript: sButton)
		)
	)

	(method (dispose)
		(buttonCast delete: self)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance quitBtn of Prop
	(properties
		x 240
		y 175
		view 923
		loop 2
	)

	(method (init)
		(super init: buttonCast &rest)
		(gMouseDownHandler add: self)
	)

	(method (handleEvent event &tmp [temp0 2])
		(event localize: local0)
		(if
			(and
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				(gUser canControl:)
			)
			(event claimed: 1)
			(self setScript: sButton)
		)
	)

	(method (dispose)
		(buttonCast delete: self)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance sButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSounds stop: 35101)
				(gSounds stop: 35102)
				(client cel: 1)
				(UpdateScreenItem client)
				(gSounds play: 15026 0 90 self)
			)
			(1
				(client cel: 0)
				(UpdateScreenItem client)
				(gGame handsOn:)
				(switch (client loop:)
					(0
						(gCurRoom newRoom: 910) ; shiversLogo
					)
					(1
						(proc951_17)
						(gCurRoom newRoom: 39260) ; rm39v260
					)
					(2
						(= gQuit 1)
					)
				)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

