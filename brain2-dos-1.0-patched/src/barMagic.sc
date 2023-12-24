;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 245)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Window)
(use System)

(public
	barMagic 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 16]
	[local21 16]
	[local37 16]
	[local53 10]
	[local63 10]
	[local73 10]
	local83
	local84
	local85
	[local86 16]
	local102
	local103
	local104
	local105
	[local106 4] = [8 32 56 80]
	[local110 4] = [46 63 80 97]
	[local114 9] = [{1} {2} {3} {4} {5} {6} {7} {8} {9}]
	[local123 8] = [0 3 6 0 1 2 2 0]
	[local131 8] = [1 1 1 3 3 3 2 4]
	[local139 10] = [0 4 8 12 0 1 2 3 3 0]
	[local149 10] = [1 1 1 1 4 4 4 4 3 5]
	[local159 16]
	[local175 16]
	[local191 10] = [112 112 112 112 10 34 58 82 112 112]
	[local201 10] = [50 67 84 101 120 120 120 120 32 119]
	[local211 8] = [88 88 88 10 34 58 88 88]
	[local219 8] = [50 67 84 103 103 103 32 102]
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(for ((= temp0 0)) (< temp0 (+ (* local102 2) 2)) ((++ temp0))
		(= temp1 0)
		(= temp5 0)
		(= temp2 [local159 temp0])
		(for ((= temp3 0)) (< temp3 local102) ((++ temp3))
			(if (!= (= temp4 (WordAt param1 temp2)) 0)
				(+= temp1 temp4)
			else
				(+= temp1 temp4)
				(= temp5 1)
			)
			(+= temp2 [local175 temp0])
		)
		(if temp5
			(= [local63 temp0] (* temp1 -1))
		else
			(= [local63 temp0] temp1)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 2])
	(= temp3 1)
	(if (== local105 1)
		(for ((= temp0 0)) (< temp0 (+ (* local102 2) 2)) ((++ temp0))
			(if (>= [local63 temp0] 0)
				(= [local73 temp0] (- [local53 temp0] [local63 temp0]))
			else
				(= [local73 temp0] (+ [local53 temp0] [local63 temp0]))
			)
		)
	)
	(for ((= temp0 0)) (< temp0 (+ (* local102 2) 2)) ((++ temp0))
		(if (or (!= [local63 temp0] [local53 temp0]) (<= [local63 temp0] 0))
			(= temp5 7)
			(= temp4 12)
			(= temp3 0)
		else
			(= temp5 6)
			(= temp4 36)
		)
		(= temp1 [local5 temp0])
		(= temp2 [local21 temp0])
		(if (and (>= temp0 local102) (<= temp0 (- (* local102 2) 1)))
			(Graph grFILL_BOX (- temp2 3) temp1 (+ temp2 11) (+ temp1 17) 1 temp5 -1 -1)
			(Graph grUPDATE_BOX (- temp2 3) temp1 (+ temp2 11) (+ temp1 17) 1)
			(if (== local105 0)
				(proc5_8
					(Format @temp6 245 0 [local53 temp0]) ; "%2d"
					temp4
					(+ temp1 2)
					temp2
					-1
					3
				)
			else
				(proc5_8
					(Format @temp6 245 0 [local73 temp0]) ; "%2d"
					temp4
					(+ temp1 2)
					temp2
					-1
					3
				)
			)
		else
			(Graph grFILL_BOX (- temp2 2) temp1 (+ temp2 9) (+ temp1 23) 1 temp5 -1 -1)
			(Graph grUPDATE_BOX (- temp2 2) temp1 (+ temp2 9) (+ temp1 23) 1)
			(if (== local105 0)
				(proc5_8
					(Format @temp6 245 0 [local53 temp0]) ; "%2d"
					temp4
					(+ temp1 5)
					temp2
					-1
					3
				)
			else
				(proc5_8
					(Format @temp6 245 0 [local73 temp0]) ; "%2d"
					temp4
					(+ temp1 5)
					temp2
					-1
					3
				)
			)
		)
	)
	(return temp3)
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp1 (/ param1 local102))
	(= temp2 (mod param1 local102))
	(= temp3 (+ local102 1))
	(= temp4 (- local102 1))
	(for ((= temp0 0)) (< temp0 local102) ((++ temp0))
		(if (== [local37 (+ (* temp0 local102) temp2)] param2)
			(return 0)
		)
		(if (== [local37 (+ (* temp1 local102) temp0)] param2)
			(return 0)
		)
	)
	(if (== (mod param1 temp3) 0)
		(for ((= temp0 0)) (< temp0 local2) ((+= temp0 temp3))
			(if (== [local37 temp0] param2)
				(return 0)
			)
		)
	)
	(if (and (== (mod param1 temp4) 0) (!= param1 0) (!= param1 (- local2 1)))
		(for ((= temp0 0)) (< temp0 local2) ((+= temp0 temp4))
			(if (== [local37 temp0] param2)
				(return 0)
			)
		)
	)
	(return 1)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 4] [temp9 2] temp11 temp12 temp13 temp14)
	(for ((= temp0 0)) (< temp0 local102) ((++ temp0))
		(= [temp5 temp0] -1)
	)
	(= [temp9 0] -1)
	(= [temp9 1] -1)
	(= temp11 (+ local102 1))
	(= temp12 (- local102 1))
	(for ((= temp0 0)) (< temp0 local102) ((++ temp0))
		(= temp4 0)
		(while (== temp4 0)
			(if (and (!= local4 0) (== temp0 3))
				(= temp13 temp1)
				(for ((= temp14 0)) (< temp14 4) ((++ temp14))
					(if (== [temp5 temp14] -1)
						(= temp1 temp14)
					)
				)
			else
				(= temp1 (Random 0 (- local102 1)))
			)
			(if
				(and
					(== (mod (= temp2 (+ (* temp0 local102) temp1)) temp11) 0)
					(!= [temp9 0] -1)
				)
				(if (!= local4 0)
					(if (== temp0 3)
						(= temp0 2)
						(= [temp5 temp13] -1)
						(if (== [temp9 0] 2)
							(= [temp9 0] -1)
						)
						(= temp2 (+ (* temp0 local102) temp1))
					else
						(continue)
					)
				else
					(continue)
				)
			)
			(if
				(and
					(!= temp2 0)
					(!= temp2 (- local2 1))
					(== (mod temp2 temp12) 0)
					(!= [temp9 1] -1)
				)
				(if (!= local4 0)
					(if (== temp0 3)
						(= temp0 2)
						(= [temp5 temp13] -1)
						(if (== [temp9 1] 2)
							(= [temp9 1] -1)
						)
						(= temp2 (+ (* temp0 local102) temp1))
					else
						(continue)
					)
				else
					(continue)
				)
			)
			(if (== [temp5 temp1] -1)
				(= [temp5 temp1] temp0)
				(if (== (mod temp2 temp11) 0)
					(= [temp9 0] temp0)
				)
				(if (and (== (mod temp2 temp12) 0) (!= temp2 0))
					(= [temp9 1] temp0)
				)
				(= temp4 1)
			)
		)
	)
	(for ((= temp14 0)) (< temp14 local102) ((++ temp14))
		(= temp2 (+ (* [temp5 temp14] local102) temp14))
		(= temp3 (barMagic at: (+ temp2 2)))
		(temp3
			signal: (| (temp3 signal:) $0004)
			value: [local37 temp2]
			text: [local114 (- [local37 temp2] 1)]
			textColor: 12
		)
		(= [local86 temp2] (temp3 value:))
	)
)

(instance barMagic of PuzzleBar
	(properties
		solvedFlag 1
		noun 14
		msgModule 240
		personalID 20
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(Load rsVIEW 241 242)
		(Load rsSOUND 104 106 144 207 236)
		(= local4 gDifficulty)
		(= local3 iconHeight)
		(= window puz2Window)
		(= local85 0)
		(= local104 0)
		(= local105 0)
		(if (== local4 0)
			(= local102 3)
			(= local2 9)
			(= local0 9)
			(= local1 100)
			(for ((= temp0 0)) (< temp0 local2) ((++ temp0))
				(= [local5 temp0] [local211 temp0])
				(= [local21 temp0] [local219 temp0])
				(= [local159 temp0] [local123 temp0])
				(= [local175 temp0] [local131 temp0])
			)
			(= local103 241)
			(puz2Window bottom: 153 right: 226)
			(= local83 5)
			(= local84 126)
		else
			(= local102 4)
			(= local2 16)
			(= local0 9)
			(= local1 117)
			(for ((= temp0 0)) (< temp0 local2) ((++ temp0))
				(= [local5 temp0] [local191 temp0])
				(= [local21 temp0] [local201 temp0])
				(= [local159 temp0] [local139 temp0])
				(= [local175 temp0] [local149 temp0])
			)
			(= local103 242)
			(puz2Window bottom: 170 right: 244)
			(= local83 15)
			(= local84 143)
		)
		(for ((= temp0 0)) (< temp0 16) ((++ temp0))
			(= [local86 temp0] 0)
			(= [local37 temp0] 0)
		)
		(for ((= temp0 0)) (< temp0 local2) ((++ temp0))
			(if (!= local4 2)
				(= temp4 (mod (+ temp0 2) local2))
				(repeat
					(= temp3 (Random 1 local0))
					(if (== (localproc_2 temp4 temp3) 1)
						(= [local37 temp4] temp3)
						(break)
					)
				)
			else
				(= [local37 temp0] (Random 1 local0))
			)
		)
		(self
			add:
				(clearIcon
					init:
					nsLeft: [local106 0]
					nsTop: (+ local3 6)
					nsRight: (+ (clearIcon nsLeft:) 31)
					nsBottom: (+ (clearIcon nsTop:) 8)
					view: local103
					yourself:
				)
		)
		(self
			add:
				(solveModeIcon
					init:
					nsLeft: (+ [local106 1] 15)
					nsTop: (+ local3 6)
					view: local103
					loop: 6
					yourself:
				)
		)
		(for ((= temp1 0)) (< temp1 local102) ((++ temp1))
			(for ((= temp2 0)) (< temp2 local102) ((++ temp2))
				(self
					add:
						((iconMagic new:)
							view: local103
							maskView: local103
							nsLeft: [local106 temp2]
							nsTop: [local110 temp1]
							value: 0
							text: {}
							yourself:
						)
				)
			)
		)
		(localproc_0 @local37)
		(for ((= temp0 0)) (< temp0 (+ (* local102 2) 2)) ((++ temp0))
			(= [local53 temp0] [local63 temp0])
			(= [local63 temp0] 0)
		)
		(self
			add:
				(dummyIcon
					init:
					nsLeft: local83
					nsTop: local84
					view: local103
					textColor: 12
					text: {1}
					value: 1
					maskView: local103
					yourself:
				)
				(if (== local4 0)
					(theSquares
						init:
						nsLeft: 5
						nsTop: 124
						nsRight: 122
						nsBottom: 133
						yourself:
					)
				else
					(theSquares
						init:
						nsLeft: 15
						nsTop: 141
						nsRight: 132
						nsBottom: 150
						yourself:
					)
				)
		)
		(localproc_3)
		(localproc_0 @local86)
		(super init: &rest)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(cond
			((& (event type:) $0040) ; direction
				(if (IsObject highlightedIcon)
					(= local104 (self indexOf: highlightedIcon))
					(= temp1 (if gDifficulty 4 else 3))
					(switch (event message:)
						(JOY_DOWN
							(cond
								((not local104)
									(+= local104 2)
									(if (& ((self at: local104) signal:) $0004)
										(while
											(&
												((self at: (++ local104))
													signal:
												)
												$0004
											)
										)
									)
								)
								((== local104 1)
									(+= local104 2)
									(if (& ((self at: local104) signal:) $0004)
										(if
											(not
												(&
													((self at: (- local104 1))
														signal:
													)
													$0004
												)
											)
											(-- local104)
										else
											(while
												(&
													((self at: (++ local104))
														signal:
													)
													$0004
												)
											)
										)
									)
								)
								((<= local104 (- (+ local2 1) temp1))
									(= temp2 0)
									(+= local104 temp1)
									(if (& ((self at: local104) signal:) $0004)
										(= temp5
											(-
												local104
												(mod (- local104 2) temp1)
											)
										)
										(if (> local104 temp5)
											(for
												((= temp3 (- local104 1)))
												(>= temp3 temp5)
												((-- temp3))
												
												(if
													(not
														(&
															((self at: temp3)
																signal:
															)
															$0004
														)
													)
													(= local104 temp3)
													(= temp2 1)
													(break)
												)
											)
											(if (not temp2)
												(while
													(&
														((self
																at:
																	(++
																		local104
																	)
															)
															signal:
														)
														$0004
													)
												)
											)
										else
											(while
												(&
													((self at: (++ local104))
														signal:
													)
													$0004
												)
											)
										)
									)
								)
								((<= local104 (+ local2 1))
									(= local104 (+ local2 2))
								)
								((< local104 (- size 3))
									(= local104 (- size 2))
								)
								(else
									(= local104 0)
								)
							)
						)
						(JOY_UP
							(cond
								((<= local104 1)
									(= local104 (- size 2))
								)
								((<= local104 temp1)
									(= local104 0)
								)
								((<= local104 (+ local2 1))
									(= temp2 0)
									(-= local104 temp1)
									(if (& ((self at: local104) signal:) $0004)
										(= temp4
											(+
												(-
													local104
													(mod (- local104 2) temp1)
												)
												(- temp1 1)
											)
										)
										(if (< local104 temp4)
											(for
												((= temp3 (+ local104 1)))
												(<= temp3 temp4)
												((++ temp3))
												
												(if
													(not
														(&
															((self at: temp3)
																signal:
															)
															$0004
														)
													)
													(= local104 temp3)
													(= temp2 1)
													(break)
												)
											)
											(if (not temp2)
												(while
													(&
														((self
																at:
																	(--
																		local104
																	)
															)
															signal:
														)
														$0004
													)
												)
											)
										else
											(while
												(&
													((self at: (-- local104))
														signal:
													)
													$0004
												)
											)
										)
									)
								)
								((< local104 (- size 3))
									(= local104 local2)
									(if (& ((self at: local104) signal:) $0004)
										(if
											(not
												(&
													((self at: (+ local104 1))
														signal:
													)
													$0004
												)
											)
											(++ local104)
										else
											(while
												(&
													((self at: (-- local104))
														signal:
													)
													$0004
												)
											)
										)
									)
								)
								(else
									(= local104 (- size 5))
								)
							)
						)
						(JOY_RIGHT
							(cond
								((<= local104 1)
									(while
										(&
											((self at: (++ local104)) signal:)
											$0004
										)
									)
								)
								((<= local104 (+ local2 1))
									(while
										(&
											((self at: (++ local104)) signal:)
											$0004
										)
									)
								)
								((< local104 (- size 3))
									(if
										(>
											(= eventX
												(+ (dummyIcon nsRight:) 3)
											)
											(theSquares nsRight:)
										)
										(= eventX (+ (theSquares nsLeft:) 3))
									)
									(self highlight: theSquares)
								)
								((>= (++ local104) size)
									(= local104 (- size 3))
								)
							)
						)
						(JOY_LEFT
							(cond
								((not local104)
									(= local104 (- size 2))
								)
								((<= local104 (+ local2 1))
									(while
										(&
											((self at: (-- local104)) signal:)
											$0004
										)
									)
								)
								((< local104 (- size 3))
									(if
										(<
											(= eventX (- (dummyIcon nsLeft:) 3))
											(theSquares nsLeft:)
										)
										(= eventX (- (theSquares nsRight:) 3))
									)
									(self highlight: theSquares)
								)
								((< (-- local104) (- size 3))
									(= local104 (- size 1))
								)
							)
						)
					)
				else
					(= local104 0)
				)
				(= temp0 (self at: local104))
				(proc5_9 temp0)
				(self highlight: temp0)
				(event type: evNULL)
			)
			((& (event type:) evKEYBOARD)
				(cond
					((or (== (event message:) KEY_c) (== (event message:) KEY_C))
						(clearIcon select:)
					)
					((or (== (event message:) KEY_n) (== (event message:) KEY_N))
						(= local105 0)
						(solveModeIcon select:)
					)
					((or (== (event message:) KEY_g) (== (event message:) KEY_G))
						(= local105 1)
						(solveModeIcon select:)
					)
					((<= KEY_1 (event message:) KEY_9)
						(if
							(and
								highlightedIcon
								(<=
									2
									(self indexOf: highlightedIcon)
									(+ local2 1)
								)
							)
							(= temp7 local85)
							(= local85 (- (event message:) 48))
							(highlightedIcon select:)
							(= local85 temp7)
						else
							(= temp6 (- (- (event message:) 48) 1))
							(dummyIcon
								nsTop: local84
								nsLeft: (+ local83 (* temp6 13))
								nsBottom: (+ local84 12)
								nsRight: (+ local83 (* temp6 13) 14)
								value: (+ temp6 1)
								textColor:
									(if (!= temp6 (- local85 1)) 12 else 50)
								text: [local114 temp6]
								highlight: 1
							)
							(self highlightedIcon: dummyIcon)
							(dummyIcon select:)
						)
					)
				)
			)
		)
		(super dispatchEvent: event &rest)
	)

	(method (solvePuzzle &tmp temp0 temp1 temp2)
		(Wait 0)
		(gCSoundFX number: 106 setLoop: 0 play: 127)
		(Wait 60)
		(= temp1 (gGame setCursor: 996))
		(for ((= temp2 2)) (< temp2 (+ local2 2)) ((++ temp2))
			(= temp0 (barMagic at: temp2))
			(temp0 textColor: 0)
			(if (& (temp0 signal:) $0004)
				(temp0 signal: (& (temp0 signal:) $fffb))
			)
			(Wait 10)
			(gCSoundFX number: 144 setLoop: 0 play: 127)
			(temp0 mask:)
			(Wait 20)
			(gCSoundFX number: 207 setLoop: 0 play: 127)
			(temp0 show:)
		)
		(Wait 60)
		(gGame setCursor: temp1)
		(super solvePuzzle: &rest)
		(self goAway:)
	)

	(method (buyClue &tmp temp0 temp1 [temp2 2])
		(if (super buyClue: &rest)
			(repeat
				(= temp0 (Random 0 (- local2 1)))
				(= temp1 (barMagic at: (+ temp0 2)))
				(if
					(and
						(not (& (temp1 signal:) $0004))
						(or
							(== (temp1 value:) 0)
							(!= (temp1 value:) [local37 temp0])
						)
					)
					(temp1
						signal: (| (temp1 signal:) $0004)
						value: [local37 temp0]
						text: [local114 (- [local37 temp0] 1)]
						textColor: 12
					)
					(= [local86 temp0] (temp1 value:))
					(break)
				)
			)
			(if (temp1 downClick:)
				(gCSoundFX number: (temp1 downClick:) play:)
			)
			(Wait 0)
			(Wait 10)
			(if (temp1 upClick:)
				(gCSoundFX number: (temp1 upClick:) play:)
			)
			(temp1 show:)
			(localproc_0 @local86)
			(if (localproc_1)
				(self solvePuzzle:)
			)
		)
	)

	(method (hide)
		(Animate (gCast elements:) 0)
		(super hide: &rest)
	)
)

(instance puz2Window of SysWindow
	(properties
		top 10
		left 100
	)

	(method (open)
		(super open:)
		(DrawCel local103 0 0 0 (- local3 1) -1)
		(DrawCel local103 0 1 0 (- (+ local3 local1) 1) -1)
		(localproc_1)
	)
)

(instance theSquares of TextIcon
	(properties
		text {}
	)

	(method (show &tmp temp0 temp1 temp2)
		(= temp2 (+ nsTop 4))
		(= temp0 0)
		(= temp1 (+ nsLeft 3))
		(while (< temp0 local0)
			(if (!= temp0 (- local85 1))
				(proc5_8 [local114 temp0] 12 temp1 temp2 -1 999)
			else
				(proc5_8 [local114 temp0] 50 temp1 temp2 -1 999)
			)
			(+= temp1 13)
			(++ temp0)
		)
	)

	(method (highlight &tmp temp0)
		(cond
			((>= (= temp0 (/ (- (barMagic eventX:) nsLeft) 13)) local0)
				(= temp0 (- local0 1))
			)
			((< temp0 0)
				(= temp0 0)
			)
		)
		(dummyIcon
			nsTop: local84
			nsLeft: (+ local83 (* temp0 13))
			nsBottom: (+ local84 12)
			nsRight: (+ local83 (* temp0 13) 14)
			value: (+ temp0 1)
			textColor: (if (!= temp0 (- local85 1)) 12 else 50)
			text: [local114 temp0]
			highlight: 1
		)
		(barMagic highlightedIcon: dummyIcon)
	)

	(method (select))
)

(instance dummyIcon of TextIcon
	(properties
		loop 1
		lowlightColor 0
		text {1}
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(if (!= local85 0)
				(= temp0 (+ (theSquares nsLeft:) 3 (* (- local85 1) 13)))
				(proc5_8 [local114 (- local85 1)] 12 temp0 (+ nsTop 2) -1 999)
			)
			(if (== local85 value)
				(self textColor: 12 show:)
				(= local85 0)
			else
				(= local85 value)
				(= textColor 50)
			)
			(self highlight: 1)
		)
	)

	(method (showText param1)
		(proc5_8 text param1 (+ nsLeft 3) (+ nsTop 2) -1 999)
	)
)

(instance iconMagic of TextIcon
	(properties
		loop 2
		maskLoop 3
		noun 18
		text {}
	)

	(method (select &tmp [temp0 2] temp2)
		(if local85
			(if (super select: &rest)
				(if (== (self value:) local85)
					(self value: 0 text: {} show:)
				else
					(self value: local85 text: [local114 (- local85 1)] show:)
				)
				(= temp2 (- (barMagic indexOf: self) 2))
				(= [local86 temp2] value)
				(localproc_0 @local86)
				(if (localproc_1)
					(super highlight: 0)
					(barMagic solvePuzzle:)
				)
			)
		else
			(gMessager say: noun 4 0 0) ; "You need to select a number first."
		)
	)

	(method (mask)
		(super mask: &rest)
		(self showText: 12)
	)

	(method (showText param1)
		(proc5_8 text param1 (+ nsLeft 7) (+ nsTop 4) -1 3)
	)
)

(instance clearIcon of CodeIcon
	(properties
		loop 4
		signal 385
	)

	(method (select &tmp temp0 temp1)
		(if (super select: &rest)
			(for ((= temp0 2)) (< temp0 (+ local2 2)) ((++ temp0))
				(= temp1 (barMagic at: temp0))
				(if (not (& (temp1 signal:) $0004))
					(temp1 value: 0 text: {} show:)
					(= [local86 (- temp0 2)] 0)
				)
			)
			(localproc_0 @local86)
			(localproc_1)
		)
	)
)

(instance solveModeIcon of CodeIcon
	(properties
		loop 6
		signal 385
	)

	(method (select)
		(if (super select: &rest)
			(if (== local105 0)
				(self loop: 5)
				(= local105 1)
			else
				(self loop: 6)
				(= local105 0)
			)
			(self highlight: 0)
			(localproc_1)
		)
	)
)

