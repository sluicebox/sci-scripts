;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 391)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Language)
(use IconBar)
(use LoadMany)
(use Window)

(public
	cipher 0
)

(local
	local0
	[local1 7] = [{                } {1               } {2               } {3               } {4               } {5               } {6               }]
	[local8 7] = [{a               } {b               } {c               } {d               } {e               } {f               } {g               }]
	local15 = {h               }
	[local16 10] = [36 12 44 52 7 7 9 5 52 43]
	[local26 10] = [10 4 3 9 31 31 4 7 9 7]
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	local44
	local45
	local46 = 1
	local47
	local48 = {CONGRATULATIONS! YOU HAVE SOLVED THE    CODEROOM. GOOD LUCK!}
	local49 = {GRATULATION! DU HAST DEN CODERAUM AUFGELOEST. VIEL GLUECK! }
	[local50 3] = [{YOUR MIND IS THE KEY TO EVERY DOOR. SET YOUR MIND FREE, AND NO LOCK CAN HOLD YOU, NO BARS RESTRAIN YOU. } {FREE FROM EVERY EARTHEN TIDE, PAST STARS AND PLANETS YOU MUST RIDE, UNTIL YOU REACH THE FARTHER SIDE. } {THE ELEVATORS OF THE MIND ONLY OPERATE FOR THOSE WHO KEEP THEIR MINDS OPEN TO NEW POSSIBILITIES .}]
	[local53 29] = [{DEIN GEIST IST DER SCHLUESSEL ZU JEDER TUERE. LASS IHM FREIEN LAUF UND KEIN SCHLOSS KANN DICH AUFHALTEN.} {FREI VON DEN GEZEITEN DER ERDE MUSST DU ZU DEN PLANETEN UND STERNEN REISEN, BIS ZUM ANDEREN ENDE.} {DIE GEDANKEN\nDES GEISTES FUNKTIONIEREN BEI DEN LEUTEN, DIE IHREN GEIST FUER NEUE IDEEN OFFENHALTEN.} {A} {B} {C} {D} {E} {F} {G} {H} {I} {J} {K} {L} {M} {N} {O} {P} {Q} {R} {S} {T} {U} {V} {W} {X} {Y} {Z}]
)

(procedure (localproc_0 &tmp temp0)
	(= temp0 0)
	(= local39 1)
	(while (and local39 (< temp0 local0))
		(= local39 (not (StrCmp [local1 temp0] [local8 temp0])))
		(++ temp0)
	)
	(if local39
		(cipher goAway:)
		(localproc_9)
		(Wait 0)
		(Wait 120)
	)
)

(procedure (localproc_1 param1)
	(if (<= 65 param1 90)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 26] temp33 temp34)
	(for ((= temp3 0)) (< temp3 26) ((++ temp3))
		(= [temp7 temp3] 0)
	)
	(= temp5 (StrLen local36))
	(= temp0 (= temp1 (= temp34 0)))
	(= temp6 1)
	(while (and temp6 (< temp0 7))
		(StrCpy [local1 temp0] local15)
		(StrCpy [local8 temp0] local15)
		(if (> temp5 (+ temp1 16))
			(= temp4 16)
		else
			(= temp4 (- temp5 temp1))
			(= temp6 0)
		)
		(while (localproc_1 (StrAt local36 (+ temp1 temp4)))
			(-- temp4)
		)
		(= temp3 0)
		(while (< temp3 temp4)
			(StrAt [local1 temp0] temp3 (= temp33 (StrAt local36 temp1)))
			(if (and (localproc_1 temp33) (not [temp7 (- temp33 65)]))
				(= [temp7 (- temp33 65)] 1)
				(++ temp34)
			)
			(++ temp3)
			(++ temp1)
		)
		(++ temp0)
		(while (not (localproc_1 (StrAt local36 temp1)))
			(++ temp1)
		)
	)
	(= local0 temp0)
	(for ((= temp3 0)) (< temp3 local0) ((++ temp3))
		(StrCpy [local8 temp3] [local1 temp3])
	)
	(for ((= temp3 0)) (< temp3 temp34) ((+= temp3 2))
		(while (not [temp7 (= local37 (Random 0 25))])
			0
		)
		(= [temp7 local37] 0)
		(while (not [temp7 (= local38 (Random 0 25))])
			0
		)
		(if (and (not temp3) (mod temp34 2))
			0
		else
			(= [temp7 local38] 0)
		)
		(+= local37 65)
		(+= local38 65)
		(localproc_5 0)
	)
)

(procedure (localproc_3 param1)
	(return (/ (- param1 35) 10))
)

(procedure (localproc_4 param1 param2 param3 &tmp temp0 temp1)
	(letter_GBuchstabe highlight: 0)
	(letter_GBuchstabe
		nsLeft: (+ 22 (* param2 10))
		nsRight: (+ 32 (* param2 10))
		nsTop: (+ 35 (* param1 10))
		nsBottom: (+ 44 (* param1 10))
		value: (+ (* param1 16) param2)
		highlight: 1
	)
	(if param3
		(= temp0 (+ 27 (* param2 10)))
		(= temp1 (+ 43 (* param1 10)))
		(gGame setCursor: gTheCursor 1 temp0 temp1)
	)
)

(procedure (localproc_5 param1 &tmp temp0 temp1 temp2)
	(for ((= temp0 0)) (< temp0 local0) ((++ temp0))
		(for ((= temp1 0)) (< temp1 16) ((++ temp1))
			(cond
				((== (= temp2 (StrAt [local1 temp0] temp1)) local37)
					(StrAt [local1 temp0] temp1 local38)
					(if param1
						(if
							(and
								(== global114 0)
								(== local38 (StrAt [local8 temp0] temp1))
							)
							(localproc_6 temp0 temp1 0)
						else
							(gCMusic2 number: 61 setLoop: 1 play:)
							(localproc_6 temp0 temp1 [local16 2])
						)
					)
				)
				((== temp2 local38)
					(StrAt [local1 temp0] temp1 local37)
					(if param1
						(if
							(and
								(== global114 0)
								(== local37 (StrAt [local8 temp0] temp1))
							)
							(localproc_6 temp0 temp1 0)
						else
							(gCMusic2 number: 61 setLoop: 1 play:)
							(localproc_6 temp0 temp1 [local16 2])
						)
					)
				)
			)
		)
	)
)

(procedure (localproc_6 param1 param2 param3 &tmp temp0 temp1 temp2 [temp3 2])
	(= temp0 (+ 22 (* param2 10)))
	(= temp1 (+ 35 (* param1 10)))
	(= temp2 (StrAt [local1 param1] param2))
	(Graph grFILL_BOX temp1 temp0 (+ temp1 10) (+ temp0 10) 1 [local16 0] -1 -1)
	(proc5_8 (Format @temp3 {%c} temp2) param3 temp0 temp1)
	(Graph grUPDATE_BOX temp1 temp0 (+ temp1 10) (+ temp0 10) 1)
	(if (== param3 [local16 2])
		(Graph grFILL_BOX temp1 temp0 (+ temp1 10) (+ temp0 10) 1 [local16 0] -1 -1)
		(proc5_8 @temp3 [local16 1] temp0 temp1)
		(Graph grUPDATE_BOX temp1 temp0 (+ temp1 10) (+ temp0 10) 1)
	)
)

(procedure (localproc_7 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(= temp0 (StrAt [local1 param1] param2))
	(for ((= temp1 0)) (< temp1 local0) ((++ temp1))
		(for ((= temp2 0)) (< temp2 16) ((++ temp2))
			(if (== temp0 (StrAt [local1 temp1] temp2))
				(++ temp3)
			)
		)
	)
	(return temp3)
)

(procedure (localproc_8 param1 param2 &tmp [temp0 6])
	(Graph grFILL_BOX 132 45 142 79 1 [local16 0] -1 -1)
	(Graph grUPDATE_BOX 132 45 142 79 1)
	(proc5_8
		(Format @temp0 391 4 param1 param2) ; "%c : %d"
		[local16 6]
		47
		134
		[local16 0]
		999
	)
)

(procedure (localproc_9 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 2])
	(LoadMany rsSOUND 945)
	(Graph grFILL_BOX 120 0 155 204 1 0 -1 -1)
	(Graph grUPDATE_BOX 120 0 155 204 1)
	(if (== (gGame printLang:) 1)
		(= local47 local48)
	else
		(= local47 local49)
	)
	(if (> (= temp3 (StrLen local47)) 63)
		(= temp3 63)
	)
	(= temp2 (= temp0 (= temp1 0)))
	(while (< temp2 temp3)
		(= temp4 (StrAt local47 temp2))
		(if (localproc_1 temp4)
			(gCMusic2 number: 945 setLoop: 1 play:)
		else
			(gCMusic2 stop:)
		)
		(= temp5 (+ (* temp1 (LangSwitch 10 8)) 2))
		(= temp6 (+ (* temp0 10) 122))
		(proc5_8 (Format @temp7 {%c} temp4) [local16 4] temp5 temp6)
		(if (>= (++ temp1) (proc0_3 25 20 20 20 20))
			(++ temp0)
			(= temp1 0)
		)
		(++ temp2)
		(Wait 0)
		(if (== temp4 95)
			(Wait 50)
		)
		(Wait 5)
	)
	(gCMusic2 stop:)
)

(instance cipher of PuzzleBar
	(properties
		puzzleHeight 77
		bottomHeight 35
		solvedFlag 3
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(if (not (IsFlag 0))
			(for ((= temp3 0)) (< temp3 10) ((++ temp3))
				(= [local16 temp3] [local26 temp3])
			)
		)
		(LoadMany rsSOUND 58 61 945)
		(= local45 iconHeight)
		(= temp2 (+ iconHeight puzzleHeight 2))
		(if (not local46)
			(for ((= temp3 0)) (< temp3 7) ((++ temp3))
				(StrCpy [local1 temp3] local15)
				(StrCpy [local8 temp3] local15)
			)
		)
		(if (== (gGame printLang:) 1)
			(= local36 [local50 global114])
		else
			(= local36 [local53 global114])
		)
		(localproc_2)
		(ciphWindow back: [local16 9])
		(= window ciphWindow)
		(self add: letter_GBuchstabe)
		(for ((= temp1 0)) (< temp1 local0) ((++ temp1))
			(self
				add:
					((row_GReihe new:)
						nsLeft: 22
						nsTop: (+ 35 (* temp1 10))
						nsBottom: (+ 44 (* temp1 10))
						nsRight: 182
						value: temp1
						yourself:
					)
			)
		)
		(eyeChartIcon highlightColor: [local16 7] lowlightColor: [local16 8])
		(self add: eyeChartIcon)
		(= local46 0)
		(super init: &rest)
	)

	(method (show)
		(= local37 (= local38 0))
		(= local41 (= local42 0))
		(= local43 (= local44 -1))
		(= highlightedIcon 0)
		(= curIcon letter_GBuchstabe)
		(gTheIconBar select: (gTheIconBar at: 1) curIcon: (gTheIconBar at: 1))
		(gGame setCursor: 8)
		(if (== (gGame printLang:) 1)
			(= local36 [local50 global114])
		else
			(= local36 [local53 global114])
		)
		(localproc_2)
		(ciphWindow)
		(super show: &rest)
		(if local39
			(Wait 0)
			(Wait 30)
			(proc5_11 391 0)
			(self solvePuzzle:)
		)
		(return local39)
	)

	(method (buyClue &tmp temp0 temp1 temp2 temp3 temp4)
		(if (super buyClue: &rest)
			(for ((= temp0 0)) (< temp0 local0) ((++ temp0))
				(for ((= temp1 0)) (< temp1 16) ((++ temp1))
					(if (localproc_1 (= temp2 (StrAt [local1 temp0] temp1)))
						(= temp3 (StrAt [local8 temp0] temp1))
						(cond
							(local37
								(if (== temp2 local37)
									(= temp4 temp3)
									(break 2)
								)
							)
							((!= temp2 temp3)
								(= local37 temp2)
								(= temp4 temp3)
								(localproc_6 temp0 temp1 [local16 3])
								(break 2)
							)
						)
					)
				)
			)
			(for ((= temp0 0)) (< temp0 local0) ((++ temp0))
				(for ((= temp1 0)) (< temp1 16) ((++ temp1))
					(= temp2 (StrAt [local1 temp0] temp1))
					(if (== temp4 temp2)
						(= local38 (StrAt [local1 temp0] temp1))
						(localproc_6 temp0 temp1 [local16 3])
						(break 2)
					)
				)
			)
			(Wait 0)
			(Wait 20)
			(localproc_5 1)
			(= local37 (= local38 0))
			(= local43 (= local44 -1))
			(localproc_0)
		)
	)

	(method (showHelp)
		(proc5_9 391 1)
		(proc5_9 391 2)
		(proc5_9 391 3)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 (event type:))
		(= temp7 1)
		(cond
			((& temp0 $0040) ; direction
				(if (IsObject highlightedIcon)
					(switch (= temp6 (event message:))
						(JOY_RIGHT
							(cond
								(
									(==
										((self highlightedIcon:) name:)
										{letter}
									)
									(= temp4 (/ (highlightedIcon value:) 16))
									(= temp5 (mod (highlightedIcon value:) 16))
									(if (>= (++ temp5) 16)
										(= temp5 0)
										(++ temp4)
									)
									(if (>= temp4 local0)
										(self highlight: eyeChartIcon)
										(proc5_20 eyeChartIcon)
									else
										(localproc_4 temp4 temp5 1)
										(event dispose:)
										(= temp7 0)
									)
								)
								((== highlightedIcon (self at: (- size 2)))
									(highlightedIcon highlight: 0)
									(localproc_4 0 0 1)
									(event dispose:)
									(= temp7 0)
								)
							)
						)
						(JOY_LEFT
							(cond
								(
									(==
										((self highlightedIcon:) name:)
										{letter}
									)
									(= temp4 (/ (highlightedIcon value:) 16))
									(= temp5 (mod (highlightedIcon value:) 16))
									(if (< (-- temp5) 0)
										(= temp5 15)
										(-- temp4)
									)
									(if (< temp4 0)
										(= temp3 (self at: (- size 2)))
										(self highlight: temp3)
										(proc5_20 temp3)
									else
										(localproc_4 temp4 temp5 1)
										(event dispose:)
										(= temp7 0)
									)
								)
								((== highlightedIcon eyeChartIcon)
									(highlightedIcon highlight: 0)
									(localproc_4 (- local0 1) 15 1)
									(event dispose:)
									(= temp7 0)
								)
							)
						)
						(JOY_UP
							(cond
								(
									(==
										((self highlightedIcon:) name:)
										{letter}
									)
									(= temp4 (/ (highlightedIcon value:) 16))
									(= temp5 (mod (highlightedIcon value:) 16))
									(if (< (-- temp4) 0)
										(= temp3 (self at: (- size 3)))
										(self highlight: temp3)
										(proc5_20 temp3)
									else
										(localproc_4 temp4 temp5 1)
										(event dispose:)
										(= temp7 0)
									)
								)
								((== highlightedIcon eyeChartIcon)
									(highlightedIcon highlight: 0)
									(localproc_4 (- local0 1) 8 1)
									(event dispose:)
									(= temp7 0)
								)
							)
						)
						(JOY_DOWN
							(cond
								(
									(==
										((self highlightedIcon:) name:)
										{letter}
									)
									(= temp4 (/ (highlightedIcon value:) 16))
									(= temp5 (mod (highlightedIcon value:) 16))
									(if (>= (++ temp4) local0)
										(self highlight: eyeChartIcon)
										(proc5_20 eyeChartIcon)
									else
										(localproc_4 temp4 temp5 1)
										(event dispose:)
										(= temp7 0)
									)
								)
								(
									(>
										(self at: (self highlightedIcon:))
										(self at: (- size 5))
									)
									(highlightedIcon highlight: 0)
									(localproc_4 0 0 1)
									(event dispose:)
									(= temp7 0)
								)
							)
						)
					)
				)
			)
			(
				(and
					(== temp0 evKEYBOARD)
					(or
						(and (>= (= temp1 (event message:)) KEY_a) (<= temp1 KEY_z))
						(and (>= temp1 KEY_A) (<= temp1 KEY_Z))
					)
				)
				(if (and (>= temp1 KEY_a) (<= temp1 KEY_z))
					(= temp1 (+ (- temp1 97) 65))
				)
				(for ((= temp4 0)) (< temp4 local0) ((++ temp4))
					(for ((= temp5 0)) (< temp5 16) ((++ temp5))
						(if
							(and
								(== temp1 (StrAt [local1 temp4] temp5))
								(not
									(and
										(== global114 0)
										(==
											(StrAt [local1 temp4] temp5)
											(StrAt [local8 temp4] temp5)
										)
									)
								)
							)
							(localproc_4 temp4 temp5 0)
							(cipher select: letter_GBuchstabe 0)
							(break 2)
						)
					)
				)
			)
		)
		(if temp7
			(super dispatchEvent: event)
		)
	)

	(method (highlight param1)
		(if
			(and
				(== (param1 name:) {row})
				(IsObject highlightedIcon)
				(== (highlightedIcon name:) {letter})
			)
			(param1 highlight: 1)
		else
			(super highlight: param1 &rest)
		)
	)
)

(instance ciphWindow of SysWindow
	(properties
		top 2
		left 45
		bottom 157
		right 249
		back 43
		priority 14
	)

	(method (open)
		(super open:)
		(DrawCel 381 0 0 0 local45 15)
		(DrawCel 381 1 0 40 123 15)
	)
)

(instance row_GReihe of CodeIcon
	(properties
		name {row}
		view 381
		loop 3
		cel 0
		signal 385
	)

	(method (show &tmp temp0 temp1)
		(= temp0 (localproc_3 nsTop))
		(for ((= temp1 0)) (< temp1 16) ((++ temp1))
			(if
				(and
					(== global114 0)
					(==
						(StrAt [local1 temp0] temp1)
						(StrAt [local8 temp0] temp1)
					)
				)
				(localproc_6 temp0 temp1 0)
			else
				(localproc_6 temp0 temp1 [local16 1])
			)
		)
	)

	(method (highlight &tmp temp0 temp1)
		(= temp0 (localproc_3 nsTop))
		(if (>= (= temp1 (/ (- (cipher eventX:) 22) 10)) 16)
			(= temp1 15)
		)
		(if
			(not
				(and
					(== global114 0)
					(==
						(StrAt [local1 temp0] temp1)
						(StrAt [local8 temp0] temp1)
					)
				)
			)
			(localproc_4 value temp1 0)
		)
	)
)

(instance eyeChartIcon of IconI
	(properties
		view 381
		loop 2
		cel 0
		nsLeft 127
		nsTop 125
		signal 129
	)

	(method (select)
		(super select: &rest)
		(gCMusic2 number: 58 setLoop: 1 play:)
		(proc5_9 391 5 82 383 0 0)
	)

	(method (highlight param1 &tmp temp0)
		(= temp0 (if (and argc param1) 1 else 0))
		(DrawCel view loop temp0 nsLeft nsTop 15)
	)
)

(instance letter_GBuchstabe of CodeIcon
	(properties
		name {letter}
		view 381
		loop 3
		cel 0
		nsLeft 22
		nsTop 35
		nsRight 32
		nsBottom 45
	)

	(method (select &tmp temp0 temp1)
		(= temp0 (localproc_3 nsTop))
		(= temp1 (/ (- (- nsRight 22) 5) 10))
		(if
			(not
				(and
					(== global114 0)
					(==
						(StrAt [local1 temp0] temp1)
						(StrAt [local8 temp0] temp1)
					)
				)
			)
			(if (localproc_1 (StrAt [local1 temp0] temp1))
				(localproc_6 temp0 temp1 [local16 3])
				(if (not local37)
					(gCMusic2 number: 58 setLoop: 1 play:)
					(= local37 (StrAt [local1 temp0] temp1))
					(= local43 temp0)
					(= local44 temp1)
				else
					(if (!= local37 (= local38 (StrAt [local1 temp0] temp1)))
						(Wait 0)
						(Wait 20)
						(localproc_5 1)
						(localproc_8 local37 (localproc_7 temp0 temp1))
					else
						(localproc_6 local43 local44 [local16 1])
					)
					(= local37 (= local38 0))
					(= local43 (= local44 -1))
				)
			)
			(localproc_0)
		)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0 (localproc_3 nsTop))
		(= temp1 (/ (- (- nsRight 22) 5) 10))
		(if
			(not
				(and
					(== global114 0)
					(==
						(StrAt [local1 temp0] temp1)
						(StrAt [local8 temp0] temp1)
					)
				)
			)
			(if (localproc_1 (= temp2 (StrAt [local1 temp0] temp1)))
				(= temp3 (localproc_7 temp0 temp1))
				(localproc_8 temp2 temp3)
			)
			(cipher highlightedIcon: self)
			(if (not (and (== temp0 local43) (== temp1 local44)))
				(localproc_6
					temp0
					temp1
					(if param1 [local16 4] else [local16 1])
				)
			)
		)
	)
)

