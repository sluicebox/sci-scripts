;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use Print)
(use Feature)
(use Window)
(use System)

(public
	debugRm 0
)

(instance debugRm of Feature
	(properties)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event &tmp temp0 [temp1 205] temp206 temp207 temp208 temp209 temp210 temp211 temp212 temp213 temp214 temp215 temp216)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_QUESTION
						(Print
							window: SysWindow
							width: 200
							font: 0
							addText:
								{Key commands:\nALT-C - show Control screen\nALT-M - show Memory\nALT-P - show Priority screen\nALT-V - show Visual screen\nALT-Y - show pallete}
								0
								0
							init:
						)
						(Print window: gSystemWindow)
					)
					(KEY_ALT_c
						(Show 4)
					)
					(KEY_ALT_p
						(Show 2)
					)
					(KEY_ALT_v
						(Show 1)
					)
					(KEY_ALT_y
						(= temp206 (GetPort))
						(SetPort 0)
						(= temp214 5)
						(= temp215 16)
						(= temp210 15)
						(= temp211 80)
						(= temp213 (+ temp210 (* 34 temp214)))
						(= temp212 (+ temp211 (* 10 temp215)))
						(= temp208 (Graph grSAVE_BOX temp210 temp211 temp213 temp212 1))
						(Graph grFILL_BOX temp210 temp211 temp213 temp212 1 255)
						(for ((= temp209 0)) (< temp209 256) ((++ temp209))
							(Graph
								grFILL_BOX
								(+ temp210 temp214 (* temp214 (/ temp209 8)))
								(+ temp211 temp215 (* 16 (mod temp209 8)))
								(+
									temp210
									temp214
									temp214
									(* temp214 (/ temp209 8))
								)
								(+
									temp211
									temp215
									temp215
									(* temp215 (mod temp209 8))
								)
								1
								temp209
							)
						)
						(Graph grUPDATE_BOX temp210 temp211 temp213 temp212 1)
						(repeat
							(= temp0 (Event new:))
							(if (or (== (temp0 type:) evMOUSEBUTTON) (== (temp0 type:) evKEYBOARD))
								(break)
							)
							(temp0 dispose:)
						)
						(temp0 dispose:)
						(Graph grRESTORE_BOX temp208)
						(Graph grUPDATE_BOX temp210 temp211 temp213 temp212 1)
						(SetPort temp206)
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

