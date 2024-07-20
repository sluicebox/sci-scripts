;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 930)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	yesNo 0
)

(local
	local0
	local1 = 913
	local2
	local3
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(iconYes mainView: local1)
	(iconNo mainView: local1)
	(cond
		((== local1 913)
			((= gGameControls yesNoControls)
				plane: yesNoWindow
				helpIconItem: 0
				okIconItem: iconNo
				curIcon: (if (not (HaveMouse)) iconYes else 0)
				add:
					(iconYes
						theObj: iconYes
						selector: #doit
						x: 17
						y: 88
						yourself:
					)
					(iconNo
						theObj: iconNo
						selector: #doit
						x: 97
						y: 88
						yourself:
					)
					(iconQuitHoyle
						theObj: iconQuitHoyle
						selector: #doit
						yourself:
					)
			)
		)
		((== local1 9131)
			((= gGameControls yesNoControls)
				plane: yesNoWindow
				helpIconItem: 0
				okIconItem: iconNo
				curIcon: (if (not (HaveMouse)) iconYes else 0)
			)
			(gGameControls
				add:
					(iconYes
						theObj: iconYes
						selector: #doit
						x: 17
						y: 97
						yourself:
					)
			)
			(gGameControls
				add:
					(iconNo
						theObj: iconNo
						selector: #doit
						x: 97
						y: 97
						yourself:
					)
			)
		)
		(else
			((= gGameControls yesNoControls)
				plane: yesNoWindow
				helpIconItem: 0
				okIconItem: iconNo
				curIcon: (if (not (HaveMouse)) iconYes else 0)
				add:
					(iconYes
						theObj: iconYes
						selector: #doit
						x: 15
						y: 95
						yourself:
					)
					(iconNo
						theObj: iconNo
						selector: #doit
						x: 95
						y: 95
						yourself:
					)
			)
		)
	)
	(gGameControls show:)
)

(instance yesNo of Code
	(properties)

	(method (init param1 param2 param3)
		(= local1 param1)
		(= local2 (if (>= argc 2) param2 else -1))
		(= local3 (if (>= argc 2) param3 else -1))
		(iconYes mainLoop: (if (>= argc 2) 10 else 1))
		(iconNo mainLoop: (if (>= argc 2) 11 else 2))
		(localproc_0)
	)
)

(instance yesNoWindow of InvisibleWindow
	(properties)

	(method (init)
		(= top (/ (- gScreenHeight 160) 2))
		(= left (/ (- gScreenWidth 190) 2))
		(= bottom (+ (/ (- gScreenHeight 160) 2) 160))
		(= right (+ (/ (- gScreenWidth 190) 2) 190))
		(= priority 16)
		(= inTop top)
		(= inLeft left)
		(= inBottom bottom)
		(= inRight right)
		(super init:)
		(proc0_10 local1 0 0 0 0 0 self)
		(if (>= local2 0)
			(if (<= local2 2)
				(proc0_10 local1 12 local2 8 0 3 self)
				(if (< local3 1100)
					(proc0_10 local1 (/ local3 100) 0 8 28 1 self)
				else
					(proc0_10 local1 (/ (+ local3 300) 100) 0 8 28 1 self)
				)
			else
				(proc0_10 local1 12 3 8 8 0 self)
			)
		)
	)
)

(instance yesNoControls of HoyleGameControls
	(properties)
)

(instance iconYes of ControlIcon
	(properties
		nsLeft 17
		nsTop 88
		x 17
		y 88
		signal 387
		mainLoop 1
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(self mainView: local1)
		(gGameControls hide:)
		(= gGameControls local0)
		(= global748 1)
	)
)

(instance iconNo of ControlIcon
	(properties
		nsLeft 97
		nsTop 88
		x 97
		y 88
		signal 387
		mainLoop 2
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(self mainView: local1)
		(iconYes doit:)
		(= global748 0)
	)
)

(instance iconQuitHoyle of ControlIcon
	(properties
		nsLeft 19
		nsTop 126
		x 19
		y 126
		signal 387
		mainView 913
		mainLoop 17
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(= gGameControls local0)
		(gGame quitGame:)
		(proc0_8 0)
		(= global748 3)
	)
)

(instance iconYESQuitHoyle of ControlIcon ; UNUSED
	(properties
		nsLeft 17
		nsTop 88
		x 17
		y 88
		signal 387
		mainView 9131
		mainLoop 10
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(= gGameControls local0)
		(gGame quitGame:)
		(proc0_8 0)
		(= global748 3)
	)
)

