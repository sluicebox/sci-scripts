;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use DButton)
(use DIcon)
(use Save)
(use System)

(class SwatRestoreDlg of SRDialog
	(properties
		margin 0
		fore 28
		buttonMargin 5
		useMsgFile 0
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
	)

	(method (dispose)
		(if (gGame darkCast:)
			(gGame darkScreen: 0)
		)
		(restoreView dispose:)
		(super dispose: &rest)
	)

	(method (initStrs))

	(method (initItems &tmp temp0)
		(plane picture: -2)
		(selectorObj width: 224 length: 18 setSize:)
		(self moveItems: 2)
		(self moveItems: 3)
		(self add: restoreView)
		(super initItems:)
	)

	(method (moveItems param1)
		(if (and selectorObj (OneOf param1 0 2))
			(selectorObj moveTo: 34 88)
		)
		(if (and okObj (OneOf param1 0 3))
			(okObj moveTo: 312 84)
		)
		(if (and deleteObj (OneOf param1 0 5))
			(deleteObj moveTo: 312 172)
		)
		(if (and cancelObj (OneOf param1 0 4))
			(cancelObj moveTo: 312 260)
		)
	)

	(method (setupObjs)
		(super setupObjs:)
		(= editObj (= textObj (= changeDirObj 0)))
		(selectorObj upButton: selectUp downButton: selectDown)
		(okObj view: 300 loop: 1)
		(deleteObj view: 300 loop: 2)
		(cancelObj view: 300 loop: 3)
	)

	(method (setupOkButn)
		(okObj loop: 1)
	)

	(method (getDefaultItem param1 param2)
		(return (if param2 okObj else cancelObj))
	)

	(method (displayReplaceMsg)
		(return 1)
	)

	(method (displayDeleteMsg)
		(return 1)
	)

	(method (getStatus)
		(return 0)
	)
)

(instance restoreView of DIcon
	(properties
		view 300
	)
)

(instance selectUp of DButton
	(properties
		x 141
		y 46
		view 300
		loop 4
	)

	(method (moveTo)
		(super moveTo: 264 86)
	)
)

(instance selectDown of DButton
	(properties
		x 141
		y 110
		view 300
		loop 5
	)

	(method (moveTo)
		(super moveTo: 264 266)
	)
)

