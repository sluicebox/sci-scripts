;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use Print)
(use Feature)
(use Cursor)
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
				hButton
				fileButton
				gButton
				ffIcon
				lScroller
				rScroller
				egoFace
				otherFace
				textWindow
				textDownButton
				textUpButton
				textSlider
		)
		(if (gTheIconBar contains: (ScriptID 0 11)) ; iconExit
			(wIcon noun: 25)
		)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp2 gTheCursor)
		(gGame setCursor: helpCursor)
		(while (!= ((= temp1 (Event new:)) type:) evMOUSEBUTTON)
			(temp1 y: (- (temp1 y:) 10))
			(= temp0 (self firstTrue: #onMe temp1))
			(if (and (gTalkers size:) (!= local0 temp0))
				(gMessager cue:)
			)
			(if (and temp0 (!= temp0 local0))
				(Print font: gUserFont width: 250 modeless: 2)
				(gMessager
					say: (temp0 noun:) (temp0 case:) 0 1 0 (temp0 modNum:)
				)
			)
			(= local0 temp0)
			(temp1 dispose:)
		)
		(temp1 dispose:)
		(if (gTalkers size:)
			(gMessager cue:)
		)
		(gGame setCursor: temp2)
	)

	(method (dispose)
		(super dispose:)
		(Print modeless: 0)
		(DisposeScript 75)
	)
)

(instance gameWindow of Feature
	(properties
		noun 15
		case 14
		modNum 94
		nsTop 5
		nsRight 319
		nsBottom 145
	)
)

(instance inventoryWindow of Feature
	(properties
		noun 17
		case 14
		modNum 94
		nsLeft 205
		nsTop -11
		nsRight 307
		nsBottom 4
	)
)

(instance scoreGuage of Feature
	(properties
		noun 27
		case 14
		modNum 94
		nsLeft 175
		nsTop -11
		nsRight 194
		nsBottom 4
	)
)

(instance lScroller of Feature
	(properties
		noun 26
		case 14
		modNum 94
		nsLeft 195
		nsTop -11
		nsRight 204
		nsBottom 4
	)
)

(instance rScroller of Feature
	(properties
		noun 26
		case 14
		modNum 94
		nsLeft 310
		nsTop -11
		nsRight 319
		nsBottom 4
	)
)

(instance wIcon of Feature
	(properties
		noun 18
		case 14
		modNum 94
		nsLeft 72
		nsTop -11
		nsRight 86
		nsBottom 4
	)
)

(instance lIcon of Feature
	(properties
		noun 19
		case 14
		modNum 94
		nsLeft 87
		nsTop -11
		nsRight 101
		nsBottom 4
	)
)

(instance hIcon of Feature
	(properties
		noun 21
		case 14
		modNum 94
		nsLeft 102
		nsTop -11
		nsRight 116
		nsBottom 4
	)
)

(instance tIcon of Feature
	(properties
		noun 22
		case 14
		modNum 94
		nsLeft 117
		nsTop -11
		nsRight 130
		nsBottom 4
	)
)

(instance tlkIcon of Feature
	(properties
		noun 20
		case 14
		modNum 94
		nsLeft 131
		nsTop -11
		nsRight 144
		nsBottom 4
	)
)

(instance zIcon of Feature
	(properties
		noun 23
		case 14
		modNum 94
		nsLeft 145
		nsTop -11
		nsRight 159
		nsBottom 4
	)
)

(instance ffIcon of Feature
	(properties
		noun 24
		case 14
		modNum 94
		nsLeft 160
		nsTop -11
		nsRight 174
		nsBottom 4
	)
)

(instance hButton of Feature
	(properties
		noun 4
		case 14
		modNum 94
		nsLeft 50
		nsTop -11
		nsRight 71
		nsBottom 4
	)
)

(instance gButton of Feature
	(properties
		noun 3
		case 14
		modNum 94
		nsLeft 27
		nsTop -11
		nsRight 49
		nsBottom 4
	)
)

(instance fileButton of Feature
	(properties
		noun 2
		case 14
		modNum 94
		nsLeft 3
		nsTop -11
		nsRight 25
		nsBottom 4
	)
)

(instance egoFace of Feature
	(properties
		noun 6
		case 14
		modNum 94
		nsLeft 2
		nsTop 147
		nsRight 38
		nsBottom 187
	)
)

(instance otherFace of Feature
	(properties
		noun 14
		case 14
		modNum 94
		nsLeft 282
		nsTop 148
		nsRight 318
		nsBottom 187
	)
)

(instance textWindow of Feature
	(properties
		noun 33
		case 14
		modNum 94
		nsLeft 40
		nsTop 147
		nsRight 269
		nsBottom 187
	)
)

(instance textDownButton of Feature
	(properties
		noun 32
		case 14
		modNum 94
		nsLeft 272
		nsTop 182
		nsRight 277
		nsBottom 186
	)
)

(instance textUpButton of Feature
	(properties
		noun 28
		case 14
		modNum 94
		nsLeft 272
		nsTop 148
		nsRight 278
		nsBottom 152
	)
)

(instance textSlider of Feature
	(properties
		noun 16
		case 14
		modNum 94
		nsLeft 272
		nsTop 153
		nsRight 278
		nsBottom 181
	)
)

(instance helpCursor of Cursor
	(properties
		view 998
		cel 6
	)
)

