;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 990)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use Actor)
(use System)

(public
	chooseBowler 0
)

(local
	local0
	local1 = 980
	local2
	local3
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(iconOne mainView: 980)
	(iconTwo mainView: 980)
	(iconThree mainView: 980)
	(iconFour mainView: 980)
	((= gGameControls playersControls)
		plane: playersWindow
		helpIconItem: 0
		okIconItem: 0
		curIcon: 0
		add:
			(iconOne theObj: iconOne selector: #doit x: -27 y: 50 yourself:)
			(iconTwo theObj: iconTwo selector: #doit x: -17 y: 50 yourself:)
			(iconThree theObj: iconThree selector: #doit x: -7 y: 50 yourself:)
			(iconFour theObj: iconFour selector: #doit x: 3 y: 50 yourself:)
	)
	(gGameControls show:)
)

(instance chooseBowler of Code
	(properties)

	(method (init param1 param2 param3)
		(= local1 param1)
		(= local2 (if (>= argc 2) param2 else -1))
		(= local3 (if (>= argc 2) param3 else -1))
		(iconOne mainLoop: 6)
		(iconTwo mainLoop: 7)
		(iconThree mainLoop: 8)
		(iconFour mainLoop: 9)
		(localproc_0)
	)
)

(instance playersWindow of InvisibleWindow
	(properties)

	(method (init)
		(= top (/ (- gScreenHeight 160) 2))
		(= left (/ (- gScreenWidth 240) 2))
		(= bottom (+ (/ (- gScreenHeight 160) 2) 160))
		(= right (+ (/ (- gScreenWidth 240) 2) 240))
		(= priority 16)
		(= inTop top)
		(= inLeft left)
		(= inBottom bottom)
		(= inRight right)
		(super init:)
		(bowlerSelect init: show:)
	)
)

(instance playersControls of HoyleGameControls
	(properties)
)

(instance bowlerSelect of View
	(properties
		x 192
		y 208
		priority 1
		view 980
		loop 5
	)
)

(instance iconOne of ControlIcon
	(properties
		nsLeft -27
		nsTop 50
		x -27
		y 50
		signal 387
		mainLoop 6
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(self mainView: 980)
		(gGameControls hide:)
		(= gGameControls local0)
		(bowlerSelect hide: dispose:)
		(= global876 1)
	)
)

(instance iconTwo of ControlIcon
	(properties
		nsLeft -17
		nsTop 50
		x -17
		y 50
		signal 387
		mainLoop 7
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(self mainView: 980)
		(gGameControls hide:)
		(= gGameControls local0)
		(bowlerSelect hide: dispose:)
		(= global876 2)
	)
)

(instance iconThree of ControlIcon
	(properties
		nsLeft -7
		nsTop 50
		x -7
		y 50
		signal 387
		mainLoop 8
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(self mainView: 980)
		(gGameControls hide:)
		(= gGameControls local0)
		(bowlerSelect hide: dispose:)
		(= global876 3)
	)
)

(instance iconFour of ControlIcon
	(properties
		nsLeft 3
		nsTop 50
		x 3
		y 50
		signal 387
		mainLoop 9
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(self mainView: 980)
		(gGameControls hide:)
		(= gGameControls local0)
		(bowlerSelect hide: dispose:)
		(= global876 4)
	)
)

