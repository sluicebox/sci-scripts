;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	chooseSuit 0
)

(local
	local0
)

(procedure (localproc_0)
	(= local0 gGameControls)
	((= gGameControls chooseSuitControls)
		plane: chooseWindow
		okIconItem: iconSpades
		curIcon: (if (not (HaveMouse)) iconSpades else 0)
		add:
			(iconSpades theObj: iconSpades selector: #doit yourself:)
			(iconClubs theObj: iconClubs selector: #doit yourself:)
			(iconDiamonds theObj: iconDiamonds selector: #doit yourself:)
			(iconHearts theObj: iconHearts selector: #doit yourself:)
	)
	(gGameControls show:)
)

(instance chooseSuit of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance chooseWindow of InvisibleWindow
	(properties
		left 91
		top 100
		right 228
		bottom 143
	)

	(method (init &tmp temp0)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 100 0 0 0 0 0 self)
	)
)

(instance chooseSuitControls of HoyleGameControls
	(properties)
)

(instance iconSpades of ControlIcon
	(properties
		nsLeft 6
		nsTop 6
		x 6
		y 6
		signal 387
		mainView 100
		mainLoop 1
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(= global420 0)
		(= gGameControls local0)
		(gSound2 play: 909)
	)
)

(instance iconClubs of ControlIcon
	(properties
		nsLeft 26
		nsTop 6
		x 26
		y 6
		signal 387
		mainView 100
		mainLoop 3
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(= global420 1)
		(= gGameControls local0)
		(gSound2 play: 910)
	)
)

(instance iconDiamonds of ControlIcon
	(properties
		nsLeft 46
		nsTop 6
		x 46
		y 6
		signal 387
		mainView 100
		mainLoop 4
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(= global420 2)
		(= gGameControls local0)
		(gSound2 play: 911)
	)
)

(instance iconHearts of ControlIcon
	(properties
		nsLeft 66
		nsTop 6
		x 66
		y 6
		signal 387
		mainView 100
		mainLoop 2
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(= global420 3)
		(= gGameControls local0)
		(gSound2 play: 912)
	)
)

