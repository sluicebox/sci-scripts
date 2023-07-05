;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 883)
(include sci.sh)
(use Main)
(use Print)
(use IconBar)
(use System)

(public
	proc883_0 0
	pepIcon5 1
	pepperIconBar 2
	dogIconBar 3
	dogIcon6 4
	proc883_5 5
	proc883_6 6
	iconBarCursor 7
)

(procedure (proc883_0)
	(pepperIconBar init:)
	(dogIconBar init:)
	(proc883_5)
)

(procedure (proc883_5)
	(if
		(==
			(= gTheIconBar
				(if (== gEgo (ScriptID 895 0)) pepperIconBar else dogIconBar) ; pepper
			)
			pepperIconBar
		)
		(= global192 pepIcon5)
		(gTheIconBar curIcon: pepIcon0)
	else
		(= global192 dogIcon6)
		(gTheIconBar curIcon: dogIcon0)
	)
	(iconBarCursor init:)
)

(procedure (proc883_6 param1)
	(if param1
		(gTheIconBar delete: pepIcon0 addToFront: (pepIcon10 init: yourself:))
		(gTheIconBar
			curIcon: pepIcon10
			walkIconItem: pepIcon10
			enable: 0
			disable: 6 4
		)
		(SetFlag 2)
		(gGame setCursor: (pepIcon10 cursor:))
		(pepIcon10 signal: 65)
	else
		(gTheIconBar delete: pepIcon10 addToFront: (pepIcon0 init: yourself:))
		(gTheIconBar curIcon: pepIcon0 walkIconItem: pepIcon0 enable: 6 4)
		(ClearFlag 2)
		(gGame setCursor: iconBarCursor)
	)
)

(class TwistyIconItem of IconI
	(properties
		cel 0
		cursor 0
		maskCel 3
		ulXoff 0
		ulYoff 0
		brXoff 0
		brYoff 0
		lowlightColor2 0
		cursorCel 0
	)

	(method (init)
		(if (not cursor)
			(= cursor iconBarCursor)
		)
		(super init: &rest)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (or (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
		(= temp0 (+ nsTop ulYoff))
		(= temp1 (+ nsLeft ulXoff))
		(= temp2 (+ nsTop brYoff))
		(= temp3 (+ nsLeft brXoff))
		(if (and argc param1)
			(Graph grDRAW_LINE temp0 temp1 temp0 temp3 highlightColor -1 -1)
			(Graph grDRAW_LINE temp0 temp3 temp2 temp3 highlightColor -1 -1)
			(Graph grDRAW_LINE temp2 temp3 temp2 temp1 highlightColor -1 -1)
			(Graph grDRAW_LINE temp2 temp1 temp0 temp1 highlightColor -1 -1)
		else
			(Graph grDRAW_LINE temp0 temp1 temp0 temp3 lowlightColor -1 -1)
			(Graph grDRAW_LINE temp0 temp3 temp2 temp3 lowlightColor -1 -1)
			(Graph grDRAW_LINE temp2 temp3 temp2 temp1 lowlightColor2 -1 -1)
			(Graph grDRAW_LINE temp2 temp1 temp0 temp1 lowlightColor2 -1 -1)
		)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) nsBottom (+ nsRight 3) 1)
	)
)

(instance iconBarCursor of Cursor
	(properties
		view 903
	)

	(method (init)
		(= loop (if (== gTheIconBar pepperIconBar) 0 else 1))
		(if (IsObject (gTheIconBar curIcon:))
			(= cel ((gTheIconBar curIcon:) cursorCel:))
		)
		(super init: &rest)
	)
)

(instance pepperIconBar of IconBar
	(properties)

	(method (init)
		(self
			add:
				pepIcon0
				pepIcon1
				pepIcon2
				pepIcon3
				pepIcon4
				pepIcon5
				pepIcon6
				pepIcon7
				pepIcon8
				pepIcon9
			eachElementDo: #init
			eachElementDo: #highlightColor global126
			eachElementDo: #lowlightColor 45
			eachElementDo: #lowlightColor2 47
			eachElementDo: #view 900
			eachElementDo: #maskView 900
			curIcon: pepIcon0
			useIconItem: pepIcon5
			helpIconItem: pepIcon7
			walkIconItem: pepIcon0
			disable: 5
			activateHeight: -1
			state: 3072
			y: 5
		)
		(pepIcon4 message: (if (HaveMouse) 3840 else 9))
	)
)

(instance pepIcon0 of TwistyIconItem
	(properties
		loop 0
		type 20480
		message 3
		signal 65
		noun 34
		helpVerb 83
		ulXoff 11
		ulYoff 11
		brXoff 38
		brYoff 32
	)
)

(instance pepIcon1 of TwistyIconItem
	(properties
		loop 1
		message 6
		signal 65
		maskLoop 1
		noun 30
		helpVerb 83
		ulXoff 2
		ulYoff 11
		brXoff 29
		brYoff 32
		cursorCel 1
	)
)

(instance pepIcon2 of TwistyIconItem
	(properties
		loop 2
		message 7
		signal 65
		maskLoop 2
		noun 26
		helpVerb 83
		ulXoff 2
		ulYoff 11
		brXoff 29
		brYoff 32
		cursorCel 2
	)
)

(instance pepIcon3 of TwistyIconItem
	(properties
		loop 3
		message 85
		signal 65
		maskLoop 3
		noun 32
		helpVerb 83
		ulXoff 2
		ulYoff 11
		brXoff 29
		brYoff 32
		cursorCel 3
	)
)

(instance pepIcon4 of TwistyIconItem
	(properties
		loop 4
		cursor 999
		type 0
		message 0
		signal 67
		maskLoop 4
		noun 28
		helpVerb 83
		ulXoff 2
		ulYoff 11
		brXoff 29
		brYoff 32
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(gInventory showSelf: gEgo)
		)
		(return 1)
	)
)

(instance pepIcon5 of TwistyIconItem
	(properties
		loop 5
		cursor 992
		signal 65
		maskLoop 5
		noun 29
		helpVerb 83
		ulXoff 2
		ulYoff 11
		brXoff 34
		brYoff 32
	)

	(method (select param1 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 30])
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(if (= temp2 (gTheIconBar curInvIcon:))
						(= temp3
							(+
								(/
									(-
										(- nsRight nsLeft)
										(CelWide
											(temp2 view:)
											(temp2 loop:)
											(temp2 cel:)
										)
									)
									2
								)
								nsLeft
							)
						)
						(= temp4
							(+
								(gTheIconBar y:)
								(/
									(-
										(- nsBottom nsTop)
										(CelHigh
											(temp2 view:)
											(temp2 loop:)
											(temp2 cel:)
										)
									)
									2
								)
								nsTop
							)
						)
					)
					(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
					(if (= temp2 (gTheIconBar curInvIcon:))
						(DrawCel
							(temp2 view:)
							(temp2 loop:)
							(temp2 cel:)
							temp3
							temp4
							-1
						)
					)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 localize:)
						(cond
							((self onMe: temp0)
								(if (not temp1)
									(DrawCel
										view
										loop
										(= temp1 1)
										nsLeft
										nsTop
										-1
									)
									(if (= temp2 (gTheIconBar curInvIcon:))
										(DrawCel
											(temp2 view:)
											(temp2 loop:)
											(temp2 cel:)
											temp3
											temp4
											-1
										)
									)
									(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
								)
							)
							(temp1
								(DrawCel view loop (= temp1 0) nsLeft nsTop -1)
								(if (= temp2 (gTheIconBar curInvIcon:))
									(DrawCel
										(temp2 view:)
										(temp2 loop:)
										(temp2 cel:)
										temp3
										temp4
										-1
									)
								)
								(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
							)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(if (== temp1 1)
						(DrawCel view loop 0 nsLeft nsTop -1)
						(if (= temp2 (gTheIconBar curInvIcon:))
							(DrawCel
								(temp2 view:)
								(temp2 loop:)
								(temp2 cel:)
								temp3
								temp4
								-1
							)
						)
						(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					)
					temp1
				)
				(else 1)
			)
		)
	)
)

(instance pepIcon6 of TwistyIconItem
	(properties
		loop 6
		cursor 999
		message 98
		signal 67
		maskLoop 6
		noun 24
		helpVerb 83
		ulXoff 2
		ulYoff 11
		brXoff 29
		brYoff 32
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			((ScriptID 888 0) show:) ; theControls
		)
		(return 1)
	)
)

(instance pepIcon7 of TwistyIconItem
	(properties
		loop 7
		cursor 990
		message 83
		signal 3
		maskLoop 7
		noun 27
		helpVerb 83
		ulXoff 2
		ulYoff 11
		brXoff 29
		brYoff 32
	)
)

(instance pepIcon8 of TwistyIconItem
	(properties
		loop 8
		message 84
		signal 65
		maskLoop 8
		noun 20
		helpVerb 83
		ulXoff 2
		ulYoff 11
		brXoff 29
		brYoff 32
		cursorCel 5
	)
)

(instance pepIcon9 of TwistyIconItem
	(properties
		loop 9
		cursor 999
		message 84
		signal 67
		maskLoop 9
		noun 33
		helpVerb 83
		ulXoff 2
		ulYoff 11
		brXoff 34
		brYoff 32
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gEgo setMotion: 0)
			(gTheIconBar hide:)
			(= temp0 7)
			(gNarrator keepWindow: 1)
			(if (== gAct 0)
				(Prints {Setting your act to 1, cause you teleported!!})
				(= gAct 1)
			)
			(gMessager say: temp0 0 gAct 2 0 110)
		)
		(return 1)
	)
)

(instance pepIcon10 of TwistyIconItem
	(properties
		view 900
		loop 10
		message 128
		signal 67
		maskView 900
		maskLoop 10
		highlightColor 126
		lowlightColor 45
		noun 25
		helpVerb 83
		ulXoff 11
		ulYoff 11
		brXoff 38
		brYoff 32
		lowlightColor2 47
		cursorCel 6
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(return 1)
		else
			(return 0)
		)
	)

	(method (doit &tmp temp0)
		((= temp0 ((gUser curEvent:) new:)) type: type message: message)
		(gUser handleEvent: temp0)
	)
)

(instance dogIconBar of IconBar
	(properties)

	(method (init)
		(self
			add:
				dogIcon0
				dogIcon1
				dogIcon2
				dogIcon3
				dogIcon4
				dogIcon5
				dogIcon6
				dogIcon7
				dogIcon8
				dogIcon9
				dogIcon10
			eachElementDo: #init
			eachElementDo: #highlightColor global126
			eachElementDo: #view 902
			eachElementDo: #maskView 902
			curIcon: dogIcon0
			useIconItem: dogIcon6
			helpIconItem: dogIcon8
			walkIconItem: dogIcon0
			disable: 6
			activateHeight: -1
			state: 3072
			y: 10
		)
		(dogIcon5 message: (if (HaveMouse) 3840 else 9))
	)
)

(instance dogIcon0 of TwistyIconItem
	(properties
		loop 0
		type 20480
		message 3
		signal 65
		lowlightColor 46
		noun 22
		helpVerb 83
		ulXoff 13
		ulYoff 8
		brXoff 36
		brYoff 27
		lowlightColor2 22
	)
)

(instance dogIcon1 of TwistyIconItem
	(properties
		loop 1
		message 6
		signal 65
		maskLoop 1
		lowlightColor 46
		noun 16
		helpVerb 83
		ulXoff 2
		ulYoff 8
		brXoff 25
		brYoff 27
		lowlightColor2 22
		cursorCel 1
	)
)

(instance dogIcon2 of TwistyIconItem
	(properties
		loop 2
		message 30
		signal 65
		maskLoop 2
		lowlightColor 46
		noun 18
		helpVerb 83
		ulXoff 2
		ulYoff 8
		brXoff 21
		brYoff 27
		lowlightColor2 22
		cursorCel 2
	)
)

(instance dogIcon3 of TwistyIconItem
	(properties
		loop 3
		message 86
		signal 65
		maskLoop 3
		lowlightColor 46
		noun 17
		helpVerb 83
		ulXoff 2
		ulYoff 8
		brXoff 26
		brYoff 27
		lowlightColor2 22
		cursorCel 3
	)
)

(instance dogIcon4 of TwistyIconItem
	(properties
		loop 4
		message 89
		signal 65
		maskLoop 4
		lowlightColor 46
		noun 11
		helpVerb 83
		ulXoff 2
		ulYoff 8
		brXoff 24
		brYoff 27
		lowlightColor2 22
		cursorCel 4
	)
)

(instance dogIcon5 of TwistyIconItem
	(properties
		loop 5
		cursor 999
		type 0
		message 0
		signal 67
		maskLoop 5
		lowlightColor 46
		noun 14
		helpVerb 83
		ulXoff 2
		ulYoff 8
		brXoff 25
		brYoff 27
		lowlightColor2 22
	)

	(method (init)
		(= lowlightColor global122)
		(super init:)
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(gInventory showSelf: gEgo)
		)
		(return 1)
	)
)

(instance dogIcon6 of TwistyIconItem
	(properties
		loop 6
		cursor 999
		signal 65
		maskLoop 6
		lowlightColor 46
		noun 15
		helpVerb 83
		ulXoff 2
		ulYoff 8
		brXoff 32
		brYoff 27
		lowlightColor2 22
	)

	(method (select param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(if (= temp2 (gTheIconBar curInvIcon:))
						(= temp3
							(+
								(/
									(-
										(- nsRight nsLeft)
										(CelWide
											(temp2 view:)
											(temp2 loop:)
											(temp2 cel:)
										)
									)
									2
								)
								nsLeft
							)
						)
						(= temp4
							(+
								(gTheIconBar y:)
								(/
									(-
										(- nsBottom nsTop)
										(CelHigh
											(temp2 view:)
											(temp2 loop:)
											(temp2 cel:)
										)
									)
									2
								)
								nsTop
							)
						)
					)
					(-= temp4 7)
					(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
					(if (= temp2 (gTheIconBar curInvIcon:))
						(DrawCel
							(temp2 view:)
							(temp2 loop:)
							(temp2 cel:)
							temp3
							temp4
							-1
						)
					)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 localize:)
						(cond
							((self onMe: temp0)
								(if (not temp1)
									(DrawCel
										view
										loop
										(= temp1 1)
										nsLeft
										nsTop
										-1
									)
									(if (= temp2 (gTheIconBar curInvIcon:))
										(DrawCel
											(temp2 view:)
											(temp2 loop:)
											(temp2 cel:)
											temp3
											temp4
											-1
										)
									)
									(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
								)
							)
							(temp1
								(DrawCel view loop (= temp1 0) nsLeft nsTop -1)
								(if (= temp2 (gTheIconBar curInvIcon:))
									(DrawCel
										(temp2 view:)
										(temp2 loop:)
										(temp2 cel:)
										temp3
										temp4
										-1
									)
								)
								(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
							)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(if (== temp1 1)
						(DrawCel view loop 0 nsLeft nsTop -1)
						(if (= temp2 (gTheIconBar curInvIcon:))
							(DrawCel
								(temp2 view:)
								(temp2 loop:)
								(temp2 cel:)
								temp3
								temp4
								-1
							)
						)
						(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					)
					temp1
				)
				(else 1)
			)
		)
	)
)

(instance dogIcon7 of TwistyIconItem
	(properties
		loop 7
		cursor 999
		message 98
		signal 67
		maskLoop 7
		lowlightColor 7
		noun 12
		helpVerb 83
		ulXoff 2
		ulYoff 8
		brXoff 22
		brYoff 27
		lowlightColor2 21
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			((ScriptID 888 0) show:) ; theControls
		)
		(return 1)
	)
)

(instance dogIcon8 of TwistyIconItem
	(properties
		loop 8
		cursor 990
		message 83
		signal 3
		maskLoop 8
		lowlightColor 7
		noun 13
		helpVerb 83
		ulXoff 2
		ulYoff 8
		brXoff 19
		brYoff 27
		lowlightColor2 21
	)
)

(instance dogIcon9 of TwistyIconItem
	(properties
		loop 9
		message 84
		signal 65
		maskLoop 9
		lowlightColor 7
		noun 19
		helpVerb 83
		ulXoff 2
		ulYoff 8
		brXoff 24
		brYoff 27
		lowlightColor2 21
		cursorCel 6
	)
)

(instance dogIcon10 of TwistyIconItem
	(properties
		loop 10
		cursor 999
		message 84
		signal 67
		maskLoop 10
		lowlightColor 7
		noun 21
		helpVerb 83
		ulXoff 2
		ulYoff 8
		brXoff 32
		brYoff 27
		lowlightColor2 21
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gEgo setMotion: 0)
			(gTheIconBar hide:)
			(= temp0 7)
			(gNarrator keepWindow: 1)
			(if (== gAct 0)
				(Prints {Setting your act to 1, cause you teleported!!})
				(= gAct 1)
			)
			(gMessager say: temp0 0 gAct 2 0 110)
		)
		(return 1)
	)
)

