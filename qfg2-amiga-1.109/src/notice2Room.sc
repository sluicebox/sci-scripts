;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 765)
(include sci.sh)
(use Main)
(use n001)
(use Interface)
(use Feature)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	notice2Room 0
)

(local
	hilitOption
	prevOption
)

(procedure (changeHilite)
	(prevOption setCycle: 0 setCel: 0 forceUpd:)
	(hilitOption setCel: 2)
	(= prevOption hilitOption)
	(RedrawCast)
)

(procedure (goThere &tmp nr)
	(hilitOption setCel: 1 forceUpd:)
	(RedrawCast)
	(switch hilitOption
		(intro
			(= nr 750)
		)
		(startGame
			(= nr 800)
		)
		(import
			(= nr 805)
		)
		(continueGame
			(gGame restore:)
			(return)
		)
	)
	(MenuBar state: 1)
	(gCurRoom newRoom: nr)
)

(procedure (MoveBackward)
	(if (!= hilitOption intro)
		(= hilitOption (buttonList at: (- (buttonList indexOf: prevOption) 1)))
	else
		(= hilitOption continueGame)
	)
)

(procedure (MoveForward)
	(if (!= hilitOption continueGame)
		(= hilitOption (buttonList at: (+ (buttonList indexOf: prevOption) 1)))
	else
		(= hilitOption intro)
	)
)

(instance candle of Prop
	(properties
		x 280
		y 68
		description {the candlestick}
		lookStr {Is this your "Trial by Fire?"\n\nNah.  Too small.}
		view 765
		cel 2
	)
)

(instance quill of PicView
	(properties
		x 27
		y 92
		description {a quill}
		lookStr {An old-fashioned word processor.}
		view 765
		loop 5
	)
)

(instance intro of Prop
	(properties
		x 152
		y 126
		shiftClick 0
		view 765
		loop 1
		signal 1
		cycleSpeed 1
	)

	(method (handleEvent event)
		(if (MousedOn self event)
			(= hilitOption intro)
			(changeHilite)
			(goThere)
		)
		(super handleEvent: event)
	)
)

(instance startGame of Prop
	(properties
		x 170
		y 143
		shiftClick 0
		view 765
		loop 2
		signal 1
		cycleSpeed 1
	)

	(method (handleEvent event)
		(if (MousedOn self event)
			(= hilitOption startGame)
			(changeHilite)
			(goThere)
		)
		(super handleEvent: event)
	)
)

(instance import of Prop
	(properties
		x 176
		y 161
		shiftClick 0
		view 765
		loop 3
		signal 1
		cycleSpeed 1
	)

	(method (handleEvent event)
		(if (MousedOn self event)
			(= hilitOption import)
			(changeHilite)
			(goThere)
		)
		(super handleEvent: event)
	)
)

(instance continueGame of Prop
	(properties
		x 176
		y 180
		shiftClick 0
		view 765
		loop 4
		signal 1
		cycleSpeed 1
	)

	(method (handleEvent event)
		(if (MousedOn self event)
			(= hilitOption continueGame)
			(changeHilite)
			(goThere)
		)
		(super handleEvent: event)
	)
)

(instance inkwell of Feature
	(properties
		x 30
		y 111
		nsTop 92
		nsBottom 131
		nsRight 59
		description {the inkwell}
		lookStr {Koko the Clown lived here many years ago.}
	)
)

(instance candlestick of Feature
	(properties
		x 287
		y 98
		nsTop 70
		nsLeft 260
		nsBottom 126
		nsRight 314
		description {the candlestick}
		lookStr {This belongs to Nimble Jack.}
	)
)

(instance scroll of Feature
	(properties
		x 30
		y 111
		nsTop 75
		nsLeft 58
		nsBottom 190
		nsRight 320
		description {the scroll}
		lookStr {Even in early word processing, they used scrolling techniques.}
	)
)

(instance buttonList of List
	(properties)
)

(instance notice2Room of Rm
	(properties
		picture 765
		style 1
	)

	(method (init)
		(Load rsVIEW 765)
		(if (!= (gCSound prevSignal:) -1)
			(gCSound fade:)
		)
		(gCSound number: 770 loop: -1 priority: 0 playBed:)
		(super init: &rest)
		(MenuBar state: 0)
		(buttonList
			add: intro startGame import continueGame
			eachElementDo: #init
			doit:
		)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(gDirectionHandler add: self)
		(candle init: setCycle: Fwd)
		(InitFeatures inkwell candlestick scroll)
		(InitAddToPics quill)
		(= hilitOption intro)
		(= prevOption intro)
		(changeHilite)
		(Animate (buttonList elements:) 1)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(DontMove 0)
		(buttonList dispose:)
		(gCSound fade:)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(switch (event type:)
			($0040 ; direction
				(switch (event message:)
					(JOY_UP
						(MoveBackward)
					)
					(JOY_DOWN
						(MoveForward)
					)
				)
				(event claimed: 1)
			)
			(evKEYBOARD
				(switch (event message:)
					(KEY_RETURN
						(goThere)
					)
					(KEY_SHIFTTAB
						(MoveBackward)
					)
					(KEY_TAB
						(MoveForward)
					)
					(KEY_CONTROL
						(gCSound pause:)
						(PromptQuit)
						(gCSound pause: 0)
						(return)
					)
				)
				(event claimed: 1)
			)
		)
		(changeHilite)
		(RedrawCast)
		(super handleEvent: event)
	)
)

