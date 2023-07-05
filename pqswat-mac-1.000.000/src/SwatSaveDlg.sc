;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use DButton)
(use DIcon)
(use Save)
(use System)

(class SwatSaveDlg of SRDialog
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
		(saveView dispose:)
		(super dispose: &rest)
	)

	(method (initStrs))

	(method (initItems &tmp temp0)
		(plane picture: -2)
		(selectorObj width: 229 length: 13 setSize: 0)
		(self moveItems: 2)
		(self moveItems: 3)
		(self add: saveView)
		(super initItems:)
	)

	(method (moveItems param1)
		(if (and editObj (OneOf param1 0 1))
			(editObj moveTo: 35 92)
		)
		(if (and selectorObj (OneOf param1 0 2))
			(selectorObj moveTo: 32 139)
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
		(= textObj (= changeDirObj 0))
		(selectorObj upButton: selectUp downButton: selectDown)
		(okObj view: 304 loop: 1)
		(deleteObj view: 304 loop: 2)
		(cancelObj view: 304 loop: 3)
	)

	(method (setupOkButn param1)
		(switch param1
			(1
				(okObj loop: 1)
			)
			(else
				(okObj loop: 8)
			)
		)
	)

	(method (getDefaultItem)
		(return editObj)
	)

	(method (displayReplaceMsg)
		(return 1)
	)

	(method (displayDeleteMsg)
		(return 1)
	)
)

(instance saveView of DIcon
	(properties
		view 304
	)
)

(instance selectUp of DButton
	(properties
		x 141
		y 46
		view 304
		loop 4
	)

	(method (moveTo)
		(super moveTo: 264 137)
	)
)

(instance selectDown of DButton
	(properties
		x 141
		y 110
		view 304
		loop 5
	)

	(method (moveTo)
		(super moveTo: 264 266)
	)
)

