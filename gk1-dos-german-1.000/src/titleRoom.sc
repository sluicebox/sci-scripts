;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 375)
(include sci.sh)
(use Main)
(use HRView)
(use n013)
(use Cursor)
(use Game)
(use Actor)
(use System)

(public
	titleRoom 0
)

(local
	local0
	local1
)

(instance titleRoom of Room
	(properties
		picture 100
		style 14
		exitStyle 13
	)

	(method (init)
		(gTheIconBar disable:)
		(if (IsHiRes)
			(= picture 99)
			(hiResTitle init:)
		)
		(super init:)
		(introButt init:)
		(playButt init:)
		(restoreButt init:)
		(tutButt init:)
		((ScriptID 0 1) view: 996) ; globeCursor
		(gMouseDownHandler add: gCurRoom introButt playButt restoreButt tutButt)
		(gKeyDownHandler add: gCurRoom introButt playButt restoreButt tutButt)
		(gDirectionHandler add: gCurRoom)
		(gGkMusic1
			number: (if (IsFlag 470) 370 else 5)
			setLoop: -1
			play:
			setVol: (gGkMusic1 musicVolume:)
		)
		(self setScript: delay)
	)

	(method (dispose)
		(gGkMusic1 fade:)
		(SetCursor 0 0 319 155)
		(gGame handsOff:)
		(gMouseDownHandler delete: gCurRoom introButt playButt restoreButt tutButt)
		(gKeyDownHandler delete: gCurRoom introButt playButt restoreButt tutButt)
		(gDirectionHandler delete: gCurRoom)
		(SetFlag 220)
		(gTheIconBar enable:)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (& (event type:) $0010) ; direction
			(event claimed: 1)
			(= local0
				(switch local0
					(restoreButt
						(if (OneOf (event message:) JOY_LEFT JOY_UPLEFT JOY_UP JOY_UPRIGHT)
							tutButt
						else
							playButt
						)
					)
					(playButt
						(if (OneOf (event message:) JOY_LEFT JOY_UPLEFT JOY_UP JOY_UPRIGHT)
							restoreButt
						else
							introButt
						)
					)
					(introButt
						(if (OneOf (event message:) JOY_LEFT JOY_UPLEFT JOY_UP JOY_UPRIGHT)
							playButt
						else
							tutButt
						)
					)
					(tutButt
						(if (OneOf (event message:) JOY_LEFT JOY_UPLEFT JOY_UP JOY_UPRIGHT)
							introButt
						else
							restoreButt
						)
					)
					(else playButt)
				)
			)
			(gGame setCursor: titleCursor 1 101 (- (local0 nsBottom:) 1))
		)
		(event claimed:)
	)

	(method (doit &tmp temp0)
		(if
			(!=
				(= temp0
					(cond
						((introButt onMe: gMouseX (- gMouseY 10)) introButt)
						((playButt onMe: gMouseX (- gMouseY 10)) playButt)
						((tutButt onMe: gMouseX (- gMouseY 10)) tutButt)
						((restoreButt onMe: gMouseX (- gMouseY 10)) restoreButt)
						(else 0)
					)
				)
				local0
			)
			(if local0
				(local0 hide:)
			)
			(= local0 temp0)
			(if temp0
				(temp0 show:)
			)
		)
		(super doit:)
	)
)

(instance delay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= cycles 2)
			)
			(2
				(gGame handsOn:)
				(SetCursor -2)
				(ClearFlag 220)
				(SetCursor 1)
				(gGame setCursor: titleCursor)
				(if (not (HaveMouse))
					(= local0 playButt)
					(gGame setCursor: 101 (- (playButt nsBottom:) 1))
				)
			)
		)
	)
)

(instance restoreButt of HRView
	(properties
		x 83
		y 139
		view 100
	)

	(method (hide)
		(self setCel: 0)
	)

	(method (show)
		(self setCel: 1)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(gGame restore:)
			(SetCursor -2)
		)
	)
)

(instance playButt of HRView
	(properties
		x 83
		y 149
		view 100
		loop 1
	)

	(method (hide)
		(self setCel: 0)
	)

	(method (show)
		(self setCel: 1)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(gCurRoom newRoom: 370)
		)
	)
)

(instance introButt of HRView
	(properties
		x 83
		y 159
		view 100
		loop 2
	)

	(method (hide)
		(self setCel: 0)
	)

	(method (show)
		(self setCel: 1)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(ClearFlag 220)
			(gGame setCursor: (ScriptID 0 1)) ; globeCursor
			(SetFlag 220)
			(gCurRoom newRoom: 190) ; openingCartoon
		)
	)
)

(instance tutButt of HRView
	(properties
		x 83
		y 169
		view 100
		loop 3
	)

	(method (hide)
		(self setCel: 0)
	)

	(method (show)
		(self setCel: 1)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(= gQuit 1)
		)
	)
)

(instance titleCursor of Cursor
	(properties
		view 100
		loop 4
	)
)

(instance hiResTitle of View
	(properties
		x 160
		y 170
		priority 1
		fixPriority 1
		view 11000
	)
)

