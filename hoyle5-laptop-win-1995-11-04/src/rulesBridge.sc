;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use RulesPrint)
(use Print)
(use GameControls)
(use System)

(public
	rulesBridge 0
)

(local
	local0
	[local1 3]
)

(procedure (localproc_0)
	(= global461
		(Print
			margin: 13
			font: gUserFont
			fore: 0
			addBitmap: 770 3 0
			addButtonBM: 770 4 0 1 {Conventions} 5 58
			addButtonBM: 770 5 0 2 {Rules} 128 58
			init:
		)
	)
)

(instance rulesBridge of Code
	(properties)

	(method (init &tmp temp0 temp1)
		(localproc_0)
		(cond
			((== global461 2)
				(for ((= temp0 1)) (<= temp0 7) ((++ temp0))
					(if
						(not
							(= temp1
								(RulesPrint
									back: -1
									margin: 13
									fore: 0
									addBitmap: 917 6 0
									addText: 1 18 0 temp0 0 0 720
									addButtonBM: 917 1 0 1 {Back} 5 214
									addButtonBM: 917 2 0 2 {Forward} 78 214
									addButtonBM: 917 3 0 3 {Cancel} 158 214
									addTextF: 247 215 {%d of %d} temp0 7
									init:
								)
							)
						)
						(break)
					else
						(if (== temp1 1)
							(if (== temp0 1)
								(= temp0 8)
							)
							(-= temp0 2)
						)
						(if (== temp1 3)
							(= temp0 7)
						)
					)
				)
			)
			((== global461 1)
				(for ((= temp0 1)) (<= temp0 19) ((++ temp0))
					(if
						(not
							(= temp1
								(RulesPrint
									back: -1
									margin: 13
									fore: 0
									addBitmap: 917 6 0
									addText: 1 79 0 temp0 0 0 720
									addButtonBM: 917 1 0 1 {Back} 5 214
									addButtonBM: 917 2 0 2 {Forward} 78 214
									addButtonBM: 917 3 0 3 {Cancel} 158 214
									addTextF: 247 215 {%d of %d} temp0 19
									init:
								)
							)
						)
						(break)
					else
						(if (== temp1 1)
							(if (== temp0 1)
								(= temp0 20)
							)
							(-= temp0 2)
						)
						(if (== temp1 3)
							(= temp0 19)
						)
					)
				)
			)
		)
		(DisposeScript 720)
	)
)

(instance readWhcihWindow of InvisibleWindow ; UNUSED
	(properties)

	(method (init)
		(= top (/ (- gScreenHeight 126) 2))
		(= left (/ (- gScreenWidth 269) 2))
		(= bottom (+ (/ (- gScreenHeight 126) 2) 126))
		(= right (+ (/ (- gScreenWidth 269) 2) 269))
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 770 3 0 0 0 15 self)
	)
)

(instance readWhichControls of HoyleGameControls ; UNUSED
	(properties)
)

(instance iconConventions of ControlIcon ; UNUSED
	(properties
		nsLeft 5
		nsTop 58
		x 5
		y 58
		signal 387
		mainView 770
		mainLoop 4
		highlightColor -1
	)

	(method (doit)
		(gGameControls hide:)
		(= gGameControls local0)
		(= global461 0)
	)
)

(instance iconRules of ControlIcon ; UNUSED
	(properties
		nsLeft 128
		nsTop 58
		x 128
		y 58
		signal 387
		mainView 770
		mainLoop 5
		highlightColor -1
	)

	(method (doit)
		(gGameControls hide:)
		(= gGameControls local0)
		(= global461 1)
	)
)

