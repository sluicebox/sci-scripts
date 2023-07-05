;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use Print)
(use Feature)
(use System)

(public
	nClickHelp 0
)

(local
	local0
)

(instance nClickHelp of Set
	(properties)

	(method (init)
		(super init: &rest)
		(self
			add:
				gameWindow
				inventoryWindow
				scoreGuage
				wIcon
				lIcon
				hIcon
				tIcon
				tlkIcon
				zIcon
				cpanelIcon
				ffIcon
				lScroller
				rScroller
		)
		(gGame setCursor: helpCursor)
		(if (gTheIconBar contains: (ScriptID 0 11)) ; iconExit
			(wIcon noun: 25)
		)
	)

	(method (doit &tmp temp0 temp1)
		(while (!= ((= temp1 (Event new:)) type:) evMOUSEBUTTON)
			(temp1 y: (- (temp1 y:) 10))
			(= temp0 (self firstTrue: #onMe temp1))
			(if (and gModelessDialog (!= local0 temp0))
				(gModelessDialog dispose:)
			)
			(if (and temp0 (!= temp0 local0))
				(Print font: gUserFont width: 250 modeless: 1)
				(gMessager
					say: (temp0 noun:) (temp0 case:) 0 1 0 (temp0 modNum:)
				)
			)
			(= local0 temp0)
			(temp1 dispose:)
		)
		(temp1 dispose:)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
	)

	(method (dispose)
		(DisposeScript 75)
		(super dispose: &rest)
	)
)

(instance menuBar of Feature ; UNUSED
	(properties
		noun 30
		case 14
		modNum 94
		nsTop -10
		nsBottom -1
		nsRight 319
	)
)

(instance gameWindow of Feature
	(properties
		noun 15
		case 14
		modNum 94
		nsBottom 138
		nsRight 319
	)
)

(instance inventoryWindow of Feature
	(properties
		noun 17
		case 14
		modNum 94
		nsTop 163
		nsLeft 22
		nsBottom 187
		nsRight 298
	)
)

(instance scoreGuage of Feature
	(properties
		noun 27
		case 14
		modNum 94
		nsTop 142
		nsLeft 245
		nsBottom 160
		nsRight 282
	)
)

(instance lScroller of Feature
	(properties
		noun 26
		case 14
		modNum 94
		nsTop 163
		nsLeft 2
		nsBottom 188
		nsRight 20
	)
)

(instance rScroller of Feature
	(properties
		noun 26
		case 14
		modNum 94
		nsTop 163
		nsLeft 300
		nsBottom 188
		nsRight 318
	)
)

(instance wIcon of Feature
	(properties
		noun 18
		case 14
		modNum 94
		nsTop 141
		nsLeft 35
		nsBottom 162
		nsRight 58
	)
)

(instance lIcon of Feature
	(properties
		noun 19
		case 14
		modNum 94
		nsTop 141
		nsLeft 59
		nsBottom 162
		nsRight 79
	)
)

(instance hIcon of Feature
	(properties
		noun 21
		case 14
		modNum 94
		nsTop 141
		nsLeft 80
		nsBottom 162
		nsRight 100
	)
)

(instance tIcon of Feature
	(properties
		noun 22
		case 14
		modNum 94
		nsTop 141
		nsLeft 101
		nsBottom 162
		nsRight 121
	)
)

(instance tlkIcon of Feature
	(properties
		noun 20
		case 14
		modNum 94
		nsTop 141
		nsLeft 122
		nsBottom 162
		nsRight 142
	)
)

(instance zIcon of Feature
	(properties
		noun 23
		case 14
		modNum 94
		nsTop 141
		nsLeft 143
		nsBottom 162
		nsRight 163
	)
)

(instance cpanelIcon of Feature
	(properties
		noun 29
		case 14
		modNum 94
		nsTop 141
		nsLeft 164
		nsBottom 162
		nsRight 184
	)
)

(instance ffIcon of Feature
	(properties
		noun 24
		case 14
		modNum 94
		nsTop 141
		nsLeft 185
		nsBottom 162
		nsRight 207
	)
)

(instance helpCursor of Cursor
	(properties
		view 1008
		cel 6
	)
)

