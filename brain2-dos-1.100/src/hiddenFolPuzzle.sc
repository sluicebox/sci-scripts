;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use dummyClient)
(use PuzzleIcon)
(use Print)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	hiddenFolPuzzle 0
)

(local
	[local0 21] = [0 9 19 29 40 50 57 64 70 77 84 91 102 109 117 125 136 142 152 161 170]
	[local21 20] = [708 507 608 507 509 606 304 405 606 506 506 709 606 707 406 608 505 709 708 407]
	[local41 170] = [38 0 22 0 0 17 5 38 28 104 89 86 111 120 95 85 82 92 108 169 147 133 162 174 173 132 127 145 168 199 202 215 196 222 234 218 201 212 191 205 263 263 269 254 268 278 259 273 275 270 48 53 0 26 21 51 6 69 64 89 100 66 87 68 139 159 143 156 128 131 214 198 190 227 250 223 211 296 263 271 267 271 262 295 48 26 19 16 2 18 2 64 98 83 86 92 86 81 87 82 97 85 145 158 177 119 156 150 173 210 210 215 188 208 209 207 220 303 261 296 276 291 285 306 300 0 45 52 8 37 4 0 0 1 3 1 75 107 70 66 80 103 149 142 158 143 130 172 138 165 138 143 213 248 235 240 192 198 198 208 224 287 289 285 292 285 300 276 304 277]
	[local211 170] = [31 0 28 4 -4 34 29 11 18 1 17 4 23 32 37 -1 7 4 40 28 6 -4 2 -2 20 25 -4 3 -3 25 5 31 5 3 12 15 7 13 16 -2 14 15 29 22 38 32 29 25 39 33 64 59 76 48 41 73 56 87 54 58 57 73 45 57 46 60 51 51 57 62 93 59 44 85 82 62 55 70 58 74 47 69 62 89 122 92 115 123 128 111 98 100 126 111 112 107 125 138 128 118 131 123 110 97 125 118 110 129 107 96 99 107 100 133 105 110 111 102 128 119 115 125 108 100 96 150 181 176 178 140 151 148 149 142 133 151 172 167 166 150 133 147 143 156 172 162 167 169 160 172 163 164 153 179 166 139 173 161 154 169 175 148 142 150 144 148 138 144 153 143]
	[local381 170] = [401 402 607 201 808 1005 1 3 1010 410 202 1005 602 3 809 206 204 1201 801 401 209 1000 201 1008 1004 202 1013 804 208 607 807 204 609 604 1012 406 400 200 613 802 901 807 601 609 604 0 406 200 613 400 209 1000 204 409 3 402 202 804 208 810 810 402 1008 208 607 412 409 3 204 1203 1011 804 409 2 804 600 809 811 201 600 408 610 207 1008 403 1001 411 804 804 206 208 901 606 811 209 1000 1002 800 810 207 804 1008 607 403 410 412 1004 1 1201 1009 203 1202 409 405 608 2 611 810 203 206 602 1000 805 804 813 209 1204 612 205 407 207 1008 800 813 1001 1201 403 1204 205 405 1200 810 401 200 201 807 609 602 0 402 601 1201 805 805 203 1202 600 1008 603 804 603 201 408 610 1002 207 811 411 804 1013]
	[local551 170] = [500 503 705 301 902 1101 101 103 1103 510 302 1101 702 103 903 306 304 1300 900 500 309 1100 301 1102 1101 302 1104 901 308 705 902 304 708 702 1104 508 500 300 711 900 805 902 700 708 702 100 508 300 711 500 309 1100 304 510 103 503 302 901 308 903 903 503 1102 308 705 513 510 103 304 1301 1104 901 510 102 901 700 903 904 301 700 510 708 307 1102 503 1100 513 901 901 306 308 805 705 904 309 1100 1101 900 903 307 901 1102 705 503 510 513 1101 101 1300 1103 303 1301 510 506 708 102 711 903 303 306 702 1100 901 901 904 309 1302 711 305 508 307 1102 900 904 1100 1300 503 1302 305 506 1300 903 500 300 301 902 708 702 100 503 700 1300 901 901 303 1301 700 1102 702 901 702 301 510 708 1101 307 904 513 901 1104]
	[local721 7] = [7 6 5 4 8 9 10]
	[local728 2]
	local730
	[local731 4]
	[local735 4]
	local739
	local740
	local741
	local742
	local743
	local744
	local745
	local746
	local747
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(if (> argc 2)
		(= temp0 param1)
		(= temp1 param2)
		(= temp2 param3)
		(= temp3 param4)
	else
		(= temp0 [local731 1])
		(= temp1 [local731 0])
		(= temp2 [local731 3])
		(= temp3 [local731 2])
	)
	(Graph grUPDATE_BOX (- temp0 1) temp1 (+ temp0 1) temp3 1)
	(Graph grUPDATE_BOX (- temp2 1) temp1 (+ temp2 1) temp3 1)
	(Graph grUPDATE_BOX temp0 (- temp1 1) temp2 (+ temp1 1) 1)
	(Graph grUPDATE_BOX temp0 (- temp3 1) temp2 (+ temp3 1) 1)
)

(procedure (localproc_1 &tmp temp0)
	(if [local735 0]
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(Graph grRESTORE_BOX [local735 temp0])
		)
		(localproc_0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(= [local735 temp0] 0)
		)
	)
)

(procedure (localproc_2 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3)
	(if (> argc 2)
		(= temp0 param3)
		(= temp1 param4)
		(= temp2 param5)
		(= temp3 param6)
	else
		(= temp0 [local731 1])
		(= temp1 [local731 0])
		(= temp2 [local731 3])
		(= temp3 [local731 2])
	)
	(if param2
		(= [local735 0]
			(Graph grSAVE_BOX (- temp0 1) (- temp1 1) (+ temp0 1) (+ temp3 1) 1)
		)
		(= [local735 1]
			(Graph grSAVE_BOX (- temp0 1) (- temp1 1) (+ temp2 1) (+ temp1 1) 1)
		)
		(= [local735 2]
			(Graph grSAVE_BOX (- temp2 1) (- temp1 1) (+ temp2 1) (+ temp3 1) 1)
		)
		(= [local735 3]
			(Graph grSAVE_BOX (- temp0 1) (- temp3 1) (+ temp2 1) (+ temp3 1) 1)
		)
	)
	(Graph grDRAW_LINE temp0 temp1 temp0 temp3 param1 -1 -1)
	(Graph grDRAW_LINE temp0 temp1 temp2 temp1 param1 -1 -1)
	(Graph grDRAW_LINE temp2 temp1 temp2 temp3 param1 -1 -1)
	(Graph grDRAW_LINE temp0 temp3 temp2 temp3 param1 -1 -1)
	(localproc_0 temp0 temp1 temp2 temp3)
)

(procedure (localproc_3 &tmp temp0 [temp1 2] temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
	(= [temp1 0] (- [local731 2] local739))
	(= [temp1 1] (- [local731 3] local739))
	(= temp0 (animalCast firstTrue: #onMe [temp1 0] [temp1 1]))
	(if (IsObject temp0)
		(if (< (= temp3 (temp0 nsTop:)) 0)
			(= temp3 0)
		)
		(if (< (= temp4 (temp0 nsLeft:)) 0)
			(= temp4 0)
		)
		(if (> (= temp5 (temp0 nsBottom:)) 189)
			(= temp5 189)
		)
		(if (> (= temp6 (temp0 nsRight:)) 319)
			(= temp6 319)
		)
		(if
			(and
				(< (Abs (- temp4 [local731 0])) local739)
				(< (Abs (- temp3 [local731 1])) local739)
				(< (Abs (- temp6 [local731 2])) local739)
				(< (Abs (- temp5 [local731 3])) local739)
			)
			(= temp10
				(CelWide
					220
					(/ [local551 (temp0 maxScale:)] 100)
					(mod [local551 (temp0 maxScale:)] 100)
				)
			)
			(= temp11
				(CelHigh
					220
					(/ [local551 (temp0 maxScale:)] 100)
					(mod [local551 (temp0 maxScale:)] 100)
				)
			)
			(if (== (temp0 loop:) (/ [local381 (temp0 maxScale:)] 100))
				(hiddenFolPuzzle pHandsOff: 1)
				(= local741 (gGame setCursor: 996))
				(temp0
					loop: (/ [local551 (temp0 maxScale:)] 100)
					cel: (mod [local551 (temp0 maxScale:)] 100)
				)
				(DrawPic 220 9 1)
				(localproc_1)
				(gCSoundFX number: 154 setLoop: 0 play: 127)
				(Animate (animalCast elements:) 0)
				(for ((= temp7 0)) (< temp7 4) ((++ temp7))
					(= [local735 temp7] 0)
				)
				(hiddenFolPuzzle pHandsOff: 0)
				(if (mod (temp0 loop:) 2)
					(Print
						addIcon:
							220
							(/ [local551 (temp0 maxScale:)] 100)
							(mod [local551 (temp0 maxScale:)] 100)
							2
							8
						addText:
							6
							1
							[local721 (/ (- (temp0 loop:) 1) 2)]
							(+ (temp0 cel:) 1)
							(+ 6 temp10)
							2
							220
						init:
					)
				else
					(Print
						addIcon:
							220
							(/ [local551 (temp0 maxScale:)] 100)
							(mod [local551 (temp0 maxScale:)] 100)
							2
							8
						addText:
							6
							1
							[local721
								(/ (- (/ [local381 (temp0 maxScale:)] 100) 1) 2)
							]
							(+ (mod [local381 (temp0 maxScale:)] 100) 1)
							(+ 6 temp10)
							2
							220
						init:
					)
				)
				(if (== (++ local740) local730)
					(gGame setCursor: local741)
					(hiddenFolPuzzle solvePuzzle:)
				else
					(= temp8 (Message msgSIZE (hiddenFolPuzzle msgModule:) 7 9 0 1))
					(= temp9 (Memory memALLOC_CRIT temp8))
					(Message msgGET (hiddenFolPuzzle msgModule:) 7 9 0 1 temp9)
					(proc15_4 hiddenFolPuzzle 99 temp9 (- local730 local740))
					(gGame setCursor: local741)
					(if temp9
						(Memory memFREE temp9)
					)
				)
			else
				(= local741 (gGame setCursor: 996))
				(if (mod (temp0 loop:) 2)
					(Print
						addIcon:
							220
							(/ [local551 (temp0 maxScale:)] 100)
							(mod [local551 (temp0 maxScale:)] 100)
							2
							8
						addText:
							6
							1
							[local721 (/ (- (temp0 loop:) 1) 2)]
							(+ (temp0 cel:) 1)
							(+ 6 temp10)
							2
							220
						init:
					)
				else
					(Print
						addIcon:
							220
							(/ [local551 (temp0 maxScale:)] 100)
							(mod [local551 (temp0 maxScale:)] 100)
							2
							8
						addText:
							6
							1
							[local721
								(/ (- (/ [local381 (temp0 maxScale:)] 100) 1) 2)
							]
							(+ (mod [local381 (temp0 maxScale:)] 100) 1)
							(+ 6 temp10)
							2
							220
						init:
					)
				)
				(gGame setCursor: local741)
				(localproc_1)
			)
		else
			(localproc_2 12 0)
			(= local742 (+ (GetTime) 60))
			(gMessager say: (hiddenFolPuzzle noun:) 4 12 0 0 220)
		)
	else
		(localproc_2 12 0)
		(= local742 (+ (GetTime) 60))
	)
)

(instance hiddenFolPuzzle of PuzzleBar
	(properties
		hintFlag 21
		solvedFlag 17
		noun 3
		msgModule 220
		personalID 19
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= local741 (gGame setCursor: gWaitCursor 1))
		(self resetPuzzle:)
		(LoadMany rsSOUND 9 10 102 106 144 154 245)
		(Load rsVIEW 220)
		(Load rsPIC 220)
		(self add: puzzleCoin2 puzzleOK2 puzzleHelp2)
		(switch global114
			(0
				(= local730 8)
				(= local739 8)
			)
			(1
				(= local730 12)
				(= local739 6)
			)
			(2
				(= local730 16)
				(= local739 5)
			)
		)
		(while (!= (animalCast size:) local730)
			(= temp6 0)
			(for ((= temp0 0)) (< temp0 local730) ((++ temp0))
				(repeat
					(if (and (== temp6 20) (!= (animalCast size:) local730))
						(animalCast
							eachElementDo: #dispose
							eachElementDo: #delete
							release:
							dispose:
						)
						(= [local728 0] 0)
						(= [local728 1] 0)
						(break 2)
					)
					(if
						(not
							(&
								[local728 (/ (= temp1 (Random 0 19)) 16)]
								(<< $0001 (mod temp1 16))
							)
						)
						(= [local728 (/ temp1 16)]
							(|
								[local728 (/ temp1 16)]
								(<< $0001 (mod temp1 16))
							)
						)
						(switch global114
							(0
								(= temp3
									(+
										[local0 temp1]
										(- (/ [local21 temp1] 100) 1)
									)
								)
							)
							(1
								(= temp3
									(+
										[local0 temp1]
										(- (mod [local21 temp1] 100) 1)
									)
								)
							)
							(2
								(= temp3 (- [local0 (+ temp1 1)] 1))
							)
						)
						(= temp4 0)
						(= temp5 0)
						(repeat
							(if (> (++ temp4) 50)
								(= temp5 0)
								(++ temp6)
								(break)
							)
							(= temp2 (Random [local0 temp1] temp3))
							(animal
								x: [local41 temp2]
								y: [local211 temp2]
								loop: (/ [local381 temp2] 100)
								cel: (mod [local381 temp2] 100)
							)
							(SetNowSeen animal)
							(animal
								nsRight:
									(+
										(animal nsLeft:)
										(CelWide
											(animal view:)
											(animal loop:)
											(animal cel:)
										)
									)
								nsBottom:
									(+
										(animal nsTop:)
										(CelHigh
											(animal view:)
											(animal loop:)
											(animal cel:)
										)
									)
							)
							(= temp7
								(animalCast
									firstTrue:
										#onMe
										(animal nsLeft:)
										(animal nsTop:)
								)
							)
							(if (IsObject temp7)
							else
								(= temp7
									(animalCast
										firstTrue:
											#onMe
											(animal nsRight:)
											(animal nsTop:)
									)
								)
								(if (IsObject temp7)
								else
									(= temp7
										(animalCast
											firstTrue:
												#onMe
												(animal nsRight:)
												(animal nsBottom:)
										)
									)
									(if (IsObject temp7)
									else
										(= temp7
											(animalCast
												firstTrue:
													#onMe
													(animal nsLeft:)
													(animal nsBottom:)
											)
										)
										(if (IsObject temp7)
										else
											(= temp7
												(animalCast
													firstTrue:
														#onMe
														(+
															(/
																(-
																	(animal
																		nsRight:
																	)
																	(animal
																		nsLeft:
																	)
																)
																2
															)
															(animal nsLeft:)
														)
														(+
															(/
																(-
																	(animal
																		nsBottom:
																	)
																	(animal
																		nsTop:
																	)
																)
																2
															)
															(animal nsTop:)
														)
												)
											)
											(if (IsObject temp7)
											else
												(= temp7
													(animalCast
														firstTrue:
															#onMe
															(+
																(/
																	(-
																		(animal
																			nsRight:
																		)
																		(animal
																			nsLeft:
																		)
																	)
																	2
																)
																(animal nsLeft:)
															)
															(animal nsTop:)
													)
												)
												(if (IsObject temp7)
												else
													(= temp7
														(animalCast
															firstTrue:
																#onMe
																(animal
																	nsRight:
																)
																(+
																	(/
																		(-
																			(animal
																				nsBottom:
																			)
																			(animal
																				nsTop:
																			)
																		)
																		2
																	)
																	(animal
																		nsTop:
																	)
																)
														)
													)
													(if (IsObject temp7)
													else
														(= temp7
															(animalCast
																firstTrue:
																	#onMe
																	(+
																		(/
																			(-
																				(animal
																					nsRight:
																				)
																				(animal
																					nsLeft:
																				)
																			)
																			2
																		)
																		(animal
																			nsLeft:
																		)
																	)
																	(animal
																		nsBottom:
																	)
															)
														)
														(if (IsObject temp7)
														else
															(= temp7
																(animalCast
																	firstTrue:
																		#onMe
																		(animal
																			nsLeft:
																		)
																		(+
																			(/
																				(-
																					(animal
																						nsBottom:
																					)
																					(animal
																						nsTop:
																					)
																				)
																				2
																			)
																			(animal
																				nsTop:
																			)
																		)
																)
															)
															(if
																(not
																	(IsObject
																		temp7
																	)
																)
																(= temp5 1)
																(break)
															)
														)
													)
												)
											)
										)
									)
								)
							)
						)
						(if temp5
							(animalCast
								add:
									((= temp7 (animal new:))
										x: [local41 temp2]
										y: [local211 temp2]
										loop: (/ [local381 temp2] 100)
										cel: (mod [local381 temp2] 100)
										maxScale: temp2
									)
							)
							(++ temp6)
							(break)
						)
					)
				)
			)
		)
		(super init: &rest)
	)

	(method (show)
		(if (!= gTheCursor gWaitCursor)
			(= local741 (gGame setCursor: gWaitCursor 1))
		)
		(DrawPic 220 9 1)
		(animalCast eachElementDo: #show eachElementDo: #stopUpd)
		(Animate (animalCast elements:) 0)
		(gCMusic number: 10 play: setVol: 127 setLoop: -1 fade: 127 5 5 0)
		(self setScript: animalCall)
		(gGame setCursor: local741 1)
		(= local747 0)
		(= local746 gGameTime)
		(super show: &rest)
		(gCMusic fade: 0 5 5 1 self)
		(Wait 60)
		(gCMusic number: 9 play: setVol: 127)
		(DrawPic 200 9 1)
		(animalCast eachElementDo: #hide)
		(gGame setCursor: local741)
		(return puzzleStatus)
	)

	(method (hide)
		(animalCast eachElementDo: #startUpd)
		(Animate (animalCast elements:) 0)
		(super hide: &rest)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 [temp19 41] temp60 temp61)
		(Palette palANIMATE 229 236 9)
		(= gGameTime (+ gTickOffset (GetTime)))
		(if gFastCast
			(while gFastCast
				(gFastCast eachElementDo: #doit)
				(if (and ((= temp0 (Event new:)) type:) gFastCast)
					(gFastCast firstTrue: #handleEvent temp0)
				)
				(temp0 dispose:)
				(= gGameTime (+ gTickOffset (GetTime)))
				(gSounds eachElementDo: #check)
			)
			(SetPort thisPort)
			(= gGameTime (+ gTickOffset (GetTime)))
		)
		(gTheDoits doit:)
		(if script
			(script doit:)
		)
		(if gSet
			(gSet eachElementDo: #doit)
		)
		(if (event type:)
			(= local746 gGameTime)
			(= local747 0)
		else
			(if (> (Abs local746) (Abs gGameTime))
				(= temp61 (- gGameTime local746))
			else
				(= temp61 (- (Abs gGameTime) (Abs local746)))
			)
			(if (>= temp61 60)
				(= local746 gGameTime)
				(if (> (++ local747) idleTime)
					(if (not puzzleStatus)
						(proc15_0 self 1 9 0 (Random 1 16) 0 20)
					)
					(= local747 0)
				)
			)
		)
		(if gPrints
			(gPrints eachElementDo: #doit)
			(if (not gModelessDialog)
				(if (and ((= temp0 (Event new:)) type:) gPrints)
					(gPrints firstTrue: #handleEvent temp0)
				)
				(temp0 dispose:)
				(return (= gGameTime (+ gTickOffset (GetTime))))
			)
			(SetPort thisPort)
		)
		(gSounds eachElementDo: #check)
		(self animateOnce:)
		(= eventX (event x:))
		(= eventY (event y:))
		(= temp1
			(if pHandsOff
				0
			else
				(event type:)
			)
		)
		(= temp2 (event message:))
		(= temp60 (event modifiers:))
		(= temp4 (event claimed:))
		(= temp3 (self firstTrue: #onMe event))
		(if (!= highlightedIcon temp3)
			(self highlight: temp3)
		)
		(event dispose:)
		(switch temp1
			(0
				(= temp4 0)
			)
			(1
				(= temp16 1)
				(= local742 0)
				(if temp3
					(self select: temp3 1)
				else
					(= temp8 eventX)
					(= temp9 (if (< eventY 0) 0 else eventY))
					(= temp10 -1)
					(= temp11 -1)
					(gCSoundFX number: 144 setLoop: 0 play: 127)
					(while (!= ((= event (Event new:)) type:) evMOUSERELEASE)
						(= temp16 0)
						(for ((= temp6 0)) (< temp6 3) ((++ temp6))
							(= temp7 (hiddenFolPuzzle at: temp6))
							(temp7 signal: (| (temp7 signal:) $0004))
						)
						(event localize:)
						(= temp13
							(if (< (event y:) 0)
								0
							else
								(event y:)
							)
						)
						(if
							(not
								(and (== (event x:) temp10) (== temp13 temp11))
							)
							(= temp10 (event x:))
							(= temp11 temp13)
							(localproc_1)
							(if (< temp8 temp10)
								(= [local731 0] temp8)
								(= [local731 2] temp10)
							else
								(= [local731 0] temp10)
								(= [local731 2] temp8)
							)
							(if (< temp9 temp11)
								(= [local731 1] temp9)
								(= [local731 3] temp11)
							else
								(= [local731 1] temp11)
								(= [local731 3] temp9)
							)
							(localproc_2 0 1)
						)
						(event dispose:)
					)
					(event dispose:)
					(gCSoundFX number: 145 setLoop: 0 play: 127)
					(cond
						(temp16
							(localproc_1)
							(animalCast eachElementDo: #onMe temp8 temp9)
						)
						(
							(and
								(< (- [local731 3] [local731 1]) local739)
								(< (- [local731 2] [local731 0]) local739)
							)
							(localproc_1)
							(animalCast eachElementDo: #onMe temp8 temp9)
						)
						(else
							(localproc_3)
						)
					)
					(if (== local730 local740)
						(puzzleOK2 signal: (& (puzzleOK2 signal:) $fffb))
					else
						(for ((= temp6 0)) (< temp6 3) ((++ temp6))
							(= temp7 (hiddenFolPuzzle at: temp6))
							(temp7 signal: (& (temp7 signal:) $fffb))
						)
					)
				)
			)
			(4
				(switch temp2
					(KEY_ESCAPE
						(= temp4 1)
					)
					(KEY_RETURN
						(= temp16 1)
						(= local742 0)
						(cond
							((IsObject temp3)
								(self select: temp3)
							)
							((not (HaveMouse))
								(for ((= temp6 0)) (< temp6 3) ((++ temp6))
									(= temp7 (hiddenFolPuzzle at: temp6))
									(temp7 signal: (| (temp7 signal:) $0004))
								)
								(= temp8 eventX)
								(= temp9 (if (< eventY 0) 0 else eventY))
								(= temp10 -1)
								(= temp11 -1)
								(= temp14 eventX)
								(= temp15 eventY)
								(gCSoundFX number: 144 setLoop: 0 play: 127)
								(while
									(not
										(or
											(and
												(==
													((= event (Event new:))
														type:
													)
													evKEYBOARD
												)
												(== (event message:) KEY_RETURN)
											)
											(== (event type:) evJOYDOWN)
										)
									)
									(event localize:)
									(MapKeyToDir event)
									(if (& (event type:) $0040) ; direction
										(= temp16 0)
										(= local743
											(if (& (event modifiers:) emSHIFT)
												1
											else
												4
											)
										)
										(switch (event message:)
											(JOY_UP
												(-= temp15 local743)
											)
											(JOY_RIGHT
												(+= temp14 local743)
											)
											(JOY_DOWN
												(+= temp15 local743)
											)
											(JOY_LEFT
												(-= temp14 local743)
											)
										)
										(= temp10
											(cond
												((< temp14 0) 0)
												((> temp14 319) 319)
												(else temp14)
											)
										)
										(= temp11
											(cond
												((< temp15 0) 0)
												((> temp15 198) 198)
												(else temp15)
											)
										)
										(gGame setCursor: 900 1 temp10 temp11)
										(localproc_1)
										(if (< temp8 temp10)
											(= [local731 0] temp8)
											(= [local731 2] temp10)
										else
											(= [local731 0] temp10)
											(= [local731 2] temp8)
										)
										(if (< temp9 temp11)
											(= [local731 1] temp9)
											(= [local731 3] temp11)
										else
											(= [local731 1] temp11)
											(= [local731 3] temp9)
										)
										(localproc_2 0 1)
									)
									(event dispose:)
								)
								(event dispose:)
								(gCSoundFX number: 145 setLoop: 0 play: 127)
								(cond
									(temp16
										(localproc_1)
										(animalCast
											eachElementDo: #onMe temp8 temp9
										)
									)
									(
										(and
											(<
												(- [local731 3] [local731 1])
												local739
											)
											(<
												(- [local731 2] [local731 0])
												local739
											)
										)
										(localproc_1)
										(animalCast
											eachElementDo: #onMe temp8 temp9
										)
									)
									(else
										(localproc_3)
									)
								)
								(if (== local730 local740)
									(puzzleOK2
										signal: (& (puzzleOK2 signal:) $fffb)
									)
								else
									(for ((= temp6 0)) (< temp6 3) ((++ temp6))
										(= temp7 (hiddenFolPuzzle at: temp6))
										(temp7
											signal: (& (temp7 signal:) $fffb)
										)
									)
								)
							)
						)
					)
					(KEY_SHIFTTAB
						(self retreat:)
					)
					(KEY_TAB
						(self advance:)
					)
					(KEY_QUESTION
						(self showHelp: 1)
					)
					(KEY_k
						(proc15_0 self 33 46 0 0 0 1)
						(if (Message msgSIZE msgModule noun 46 0 1)
							(proc15_0 self noun 46 0 0 0 msgModule)
						)
					)
					(KEY_K
						(proc15_0 self 33 46 0 0 0 1)
						(if (Message msgSIZE msgModule noun 46 0 1)
							(proc15_0 self noun 46 0 0 0 msgModule)
						)
					)
					(KEY_F2
						(cond
							((gGame masterVolume:)
								(gGame masterVolume: 0)
							)
							((> global106 1)
								(gGame masterVolume: 15)
							)
							(else
								(gGame masterVolume: 15)
							)
						)
					)
				)
			)
			(else
				(if (& temp1 $0040)
					(= temp17 eventX)
					(= temp18 eventY)
					(= local743 (if (& temp60 emSHIFT) 1 else 4))
					(switch temp2
						(JOY_UP
							(-= temp18 local743)
						)
						(JOY_UPRIGHT
							(+= temp17 local743)
							(-= temp18 local743)
						)
						(JOY_RIGHT
							(+= temp17 local743)
						)
						(JOY_DOWNRIGHT
							(+= temp17 local743)
							(+= temp18 local743)
						)
						(JOY_DOWN
							(+= temp18 local743)
						)
						(JOY_DOWNLEFT
							(-= temp17 local743)
							(+= temp18 local743)
						)
						(JOY_LEFT
							(-= temp17 local743)
						)
						(JOY_UPLEFT
							(-= temp17 local743)
							(-= temp18 local743)
						)
					)
					(= temp17
						(cond
							((< temp17 0) 0)
							((> temp17 319) 319)
							(else temp17)
						)
					)
					(= temp18
						(cond
							((< temp18 0) 0)
							((> temp18 198) 198)
							(else temp18)
						)
					)
					(gGame setCursor: gTheCursor 1 temp17 temp18)
				)
			)
		)
		(return temp4)
	)

	(method (animateOnce &tmp temp0)
		(if (and local742 (> (GetTime) local742))
			(localproc_1)
			(= local742 0)
		)
		(super animateOnce: &rest)
	)

	(method (solvePuzzle &tmp temp0 temp1 temp2)
		(self pHandsOff: 1)
		(= local741 (gGame setCursor: 996 1))
		(gCSoundFX number: 106 setLoop: 0 play: 127)
		(Wait 0)
		(for ((= temp1 0)) (< temp1 4) ((++ temp1))
			(for ((= temp0 0)) (< temp0 local730) ((++ temp0))
				(= temp2 (animalCast at: temp0))
				(temp2
					loop: (/ [local381 (temp2 maxScale:)] 100)
					cel: (mod [local381 (temp2 maxScale:)] 100)
				)
			)
			(Wait 20)
			(DrawPic 220 100 1)
			(Animate (animalCast elements:) 0)
			(for ((= temp0 0)) (< temp0 local730) ((++ temp0))
				(= temp2 (animalCast at: temp0))
				(temp2
					loop: (/ [local551 (temp2 maxScale:)] 100)
					cel: (mod [local551 (temp2 maxScale:)] 100)
				)
			)
			(Wait 20)
			(DrawPic 220 100 1)
			(Animate (animalCast elements:) 0)
		)
		(self pHandsOff: 0)
		(super solvePuzzle: &rest)
		(puzzleCoin2 signal: (| (puzzleCoin2 signal:) $0004))
		(puzzleHelp2 signal: (| (puzzleHelp2 signal:) $0004))
		(gGame setCursor: local741 1)
	)

	(method (buyClue &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(for ((= temp0 0)) (< temp0 local730) ((++ temp0))
			(= temp1 (animalCast at: temp0))
			(if (== (temp1 loop:) (/ [local381 (temp1 maxScale:)] 100))
				(break)
			)
		)
		(if (and (IsObject temp1) (IsObject local745) (!= temp1 local745))
			(ClearFlag hintFlag)
		)
		(= local745 temp1)
		(if (and (IsObject temp1) (super buyClue: &rest))
			(self pHandsOff: 1)
			(= local741 (gGame setCursor: 996))
			(localproc_1)
			((hiddenFolPuzzle at: 0) show: 2)
			(temp1
				loop: (/ [local551 (temp1 maxScale:)] 100)
				cel: (mod [local551 (temp1 maxScale:)] 100)
			)
			(if (< (= temp2 (temp1 nsTop:)) 0)
				(= temp2 0)
			)
			(if (< (= temp3 (temp1 nsLeft:)) 0)
				(= temp3 0)
			)
			(if (> (= temp4 (temp1 nsBottom:)) 189)
				(= temp4 189)
			)
			(if (> (= temp5 (temp1 nsRight:)) 319)
				(= temp5 319)
			)
			(DrawPic 220 9 1)
			(Animate (animalCast elements:) 0)
			(localproc_2 28 1 temp2 temp3 temp4 temp5)
			(if (== global114 0)
				(gCSoundFX number: 154 setLoop: 0 play: 127)
			)
			(Wait 0)
			(Wait 60)
			(if [local735 0]
				(for ((= temp0 0)) (< temp0 4) ((++ temp0))
					(Graph grRESTORE_BOX [local735 temp0])
				)
				(localproc_0 temp2 temp3 temp4 temp5)
				(for ((= temp0 0)) (< temp0 4) ((++ temp0))
					(= [local735 temp0] 0)
				)
			)
			(if (not (== global114 0))
				(Wait 0)
				(Wait 30)
				(if temp1
					(temp1
						loop: (/ [local381 (temp1 maxScale:)] 100)
						cel: (mod [local381 (temp1 maxScale:)] 100)
					)
					(DrawPic 220 9 1)
					(Animate (animalCast elements:) 0)
				)
				(self pHandsOff: 0)
				(gGame setCursor: local741)
			else
				(self pHandsOff: 0)
				(= temp8
					(CelWide
						220
						(/ [local551 (temp1 maxScale:)] 100)
						(mod [local551 (temp1 maxScale:)] 100)
					)
				)
				(= temp9
					(CelHigh
						220
						(/ [local551 (temp1 maxScale:)] 100)
						(mod [local551 (temp1 maxScale:)] 100)
					)
				)
				(if (mod (temp1 loop:) 2)
					(Print
						addIcon:
							220
							(/ [local551 (temp1 maxScale:)] 100)
							(mod [local551 (temp1 maxScale:)] 100)
							2
							8
						addText:
							6
							1
							[local721 (/ (- (temp1 loop:) 1) 2)]
							(+ (temp1 cel:) 1)
							(+ 6 temp8)
							2
							220
						init:
					)
				else
					(Print
						addIcon:
							220
							(/ [local551 (temp1 maxScale:)] 100)
							(mod [local551 (temp1 maxScale:)] 100)
							2
							8
						addText:
							6
							1
							[local721
								(/ (- (/ [local381 (temp1 maxScale:)] 100) 1) 2)
							]
							(+ (mod [local381 (temp1 maxScale:)] 100) 1)
							(+ 6 temp8)
							2
							220
						init:
					)
				)
				(if (== (++ local740) local730)
					(gGame setCursor: local741)
					(self solvePuzzle:)
				else
					(= temp6 (Message msgSIZE (hiddenFolPuzzle msgModule:) 7 9 0 1))
					(= temp7 (Memory memALLOC_CRIT temp6))
					(Message msgGET (hiddenFolPuzzle msgModule:) 7 9 0 1 temp7)
					(proc15_4 hiddenFolPuzzle 99 temp7 (- local730 local740))
					(gGame setCursor: local741)
					(if temp7
						(Memory memFREE temp7)
					)
				)
			)
		)
	)

	(method (resetPuzzle &tmp temp0)
		(= local740 0)
		(= local745 0)
		(= [local728 0] 0)
		(= [local728 1] 0)
		(= local730 0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(= [local731 temp0] 0)
			(= [local735 temp0] 0)
		)
		(= local739 0)
		(puzzleCoin2 signal: (& (puzzleCoin2 signal:) $fffb))
		(puzzleHelp2 signal: (& (puzzleHelp2 signal:) $fffb))
	)

	(method (dispose)
		(animalSound dispose:)
		(animalCast
			eachElementDo: #dispose
			eachElementDo: #delete
			release:
			dispose:
		)
		(super dispose: &rest)
	)
)

(instance puzzleCoin2 of PuzzleIcon
	(properties
		view 222
		loop 0
		nsLeft 83
		nsTop 88
		signal 385
		maskView 222
		maskCel 2
	)

	(method (highlight)
		(localproc_1)
		(super highlight: &rest)
	)

	(method (select)
		(if (super select: &rest)
			(client buyClue:)
		)
	)
)

(instance puzzleOK2 of PuzzleIcon
	(properties
		view 222
		loop 1
		nsLeft 95
		nsTop 72
		signal 193
		maskView 222
		maskLoop 1
		maskCel 2
	)

	(method (highlight)
		(localproc_1)
		(super highlight: &rest)
	)

	(method (select)
		(if (super select: &rest)
			(= local741 (gGame setCursor: gWaitCursor 1))
			(client goAway:)
		)
	)
)

(instance puzzleHelp2 of PuzzleIcon
	(properties
		view 222
		loop 2
		nsLeft 116
		nsTop 88
		cursor 70
		signal 385
		maskView 222
		maskLoop 2
		maskCel 2
	)

	(method (highlight)
		(localproc_1)
		(super highlight: &rest)
	)

	(method (select)
		(if (super select: &rest)
			(client showHelp: 1)
		)
	)
)

(instance animalCast of Set
	(properties)
)

(instance animal of Prop
	(properties
		x 50
		y 50
		view 220
	)

	(method (onMe &tmp temp0)
		(if
			(and
				(= temp0 (super onMe: &rest))
				(== local730 (animalCast size:))
				(== x 262)
				(== y 62)
				(== loop 3)
				(== cel 7)
			)
			(cond
				((< local744 13)
					(++ local744)
				)
				((== local744 13)
					(= local744 15)
					(hiddenFolPuzzle pHandsOff: 1)
					(= local741 (gGame setCursor: 996 1))
					(self loop: 15 cel: 0)
					(DrawPic 220 9 1)
					(Animate (animalCast elements:) 0)
					(if (not (IsObject (hiddenFolPuzzle puzzleCast:)))
						(hiddenFolPuzzle puzzleCast: (Set new:))
					)
					((hiddenFolPuzzle puzzleCast:)
						add:
							((animal new:)
								loop: 14
								cel: 0
								x: 268
								y: 69
								setScript: doAnimal self
								yourself:
							)
					)
				)
				(else 0)
			)
		)
		(return temp0)
	)

	(method (cue)
		(if
			(and
				(== local730 (animalCast size:))
				(== x 262)
				(== y 62)
				(== loop 15)
				(== cel 0)
			)
			(self loop: 3 cel: 7)
			(DrawPic 220 9 1)
			(Animate (animalCast elements:) 0)
			(hiddenFolPuzzle pHandsOff: 0)
			(gGame setCursor: local741 1)
		)
		(super cue: &rest)
	)
)

(instance animalCall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 1 3)
					(1
						(animalSound number: 102)
					)
					(2
						(animalSound number: 253)
					)
					(3
						(animalSound number: 254)
					)
				)
				(animalSound setLoop: 0 play: 127 self)
			)
			(1
				(= ticks (* 60 (Random 5 8)))
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance doAnimal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hiddenFolPuzzle showCast: 1)
				(gCSoundFX number: 130 setLoop: 1 play: 127)
				(client setCycle: End self)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client setCycle: End self)
			)
			(3
				(hiddenFolPuzzle showCast: 0)
				(self dispose:)
			)
		)
	)
)

(instance animalSound of Sound
	(properties)
)

