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
	local4
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(iconYes mainView: local1)
	(iconNo mainView: local1)
	(iconSaveHoyle mainView: 913)
	(cond
		((and (== local1 913) (not global459))
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
						y: 66
						mainCel: 0
						yourself:
					)
					(iconNo
						theObj: iconNo
						selector: #doit
						x: 100
						y: 66
						mainCel: 0
						yourself:
					)
					(iconQuitHoyle
						theObj: iconQuitHoyle
						selector: #doit
						x: 17
						y: 126
						mainCel: 0
						yourself:
					)
					(iconSaveHoyle
						theObj: iconSaveHoyle
						selector: #doit
						x: 17
						y: 96
						yourself:
					)
			)
		)
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
						x: 100
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
						x: 16
						y: 81
						yourself:
					)
					(iconNo
						theObj: iconNo
						selector: #doit
						x: 96
						y: 81
						yourself:
					)
			)
		)
	)
	(gGameControls show:)
)

(instance yesNo of Code
	(properties)

	(method (init param1 param2 param3 param4)
		(= local1 param1)
		(= local2 (if (>= argc 2) param2 else -1))
		(= local3 (if (>= argc 2) param3 else -1))
		(if (== argc 4)
			(= local4 param4)
		)
		(if (>= local3 6001)
			(= local3 600)
		)
		(iconYes mainLoop: 1)
		(iconNo mainLoop: 2)
		(if (== local1 913)
			(iconQuitHoyle mainLoop: 3)
			(iconSaveHoyle mainLoop: 4)
		)
		(if (== local2 4)
			(= local1 975)
		)
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
		(= priority 50)
		(= inTop top)
		(= inLeft left)
		(= inBottom bottom)
		(= inRight right)
		(super init:)
		(cond
			((== local2 4)
				(proc0_10 975 0 0 0 0 0 self)
				(proc0_10 975 (+ 2 local4) 0 0 0 1 self)
			)
			((and (== local2 2) (== local1 913) (not global459))
				(proc0_10 local1 0 0 0 0 0 self)
			)
			(else
				(proc0_10 local1 0 0 0 0 0 self)
			)
		)
		(if (>= local2 0)
			(cond
				((<= local2 2)
					(if (!= local3 600)
						(proc0_10 local1 3 local2 8 -8 3 self)
					)
					(if (< local3 1100)
						(if (== local3 600)
							(if (== local2 1)
								(proc0_10 local1 12 3 8 -8 3 self)
							else
								(proc0_10 local1 5 0 64 22 3 self)
							)
						else
							(proc0_10 local1 4 0 8 15 1 self)
						)
					else
						(proc0_10 local1 (/ (+ local3 300) 100) 0 8 28 1 self)
					)
				)
				((!= local2 4)
					(proc0_10 local1 3 1 8 8 0 self)
				)
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
		mainLoop 5
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

(instance iconSaveHoyle of ControlIcon
	(properties
		nsLeft 17
		nsTop 60
		x 17
		y 60
		signal 387
		mainView 913
		mainLoop 4
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(self mainView: 913)
		(self hide:)
		(iconQuitHoyle hide:)
		(iconNo hide:)
		(iconYes hide:)
		(gGameControls hide:)
		(= gGameControls local0)
		(= global748 4)
	)
)

