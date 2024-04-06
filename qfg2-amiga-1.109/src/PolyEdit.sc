;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 943)
(include sci.sh)
(use Main)
(use Interface)
(use Polygon)
(use Save)
(use File)
(use User)
(use System)

(local
	local0
	local1
	local2
	local3
	local4
	local5 = -1
	local6
	local7
	[local8 15]
	[local23 50]
	[local73 500]
	[local573 80]
	local653
	local654
	local655
	local656
	local657
	local658
	local659
	local660
	local661
	local662
	[local663 3] = [{PTotalAccess} {PNearestAccess} {PBarredAccess}]
)

(procedure (SetVars v1 v2 v3 v4)
	(if (> v1 v3)
		(= local654 v3)
		(= local656 v1)
	else
		(= local654 v1)
		(= local656 v3)
	)
	(if (> v2 v4)
		(= local653 v4)
		(= local655 v2)
	else
		(= local653 v2)
		(= local655 v4)
	)
	(-- local653)
	(-- local654)
	(++ local655)
	(++ local656)
)

(procedure (Logit what)
	(File name: @local8 writeString: what close:)
	(DisposeScript 993)
)

(class MakePath
	(properties)

	(method (doit &tmp event cBits i finished)
		(gFeatures add: self)
		(= finished 0)
		(= local660 (= local657 1))
		(= local661 (& (gEgo signal:) $0080))
		(gEgo show:)
		(if
			(not
				(= local0
					(Print ; "What type of path?"
						943
						0
						#title
						{Path Maker v1.2}
						#button
						{PolyPath}
						1
						#button
						{Freeway}
						2
					)
				)
			)
			(return)
		)
		(Format @local8 943 1 (gCurRoom picture:)) ; "PATH.%d"
		(GetInput @local8 30 {Enter path and filename})
		(DrawPic (gCurRoom curPic:) 100 1 global61)
		(if (!= global57 -1)
			(DrawPic global57 100 0 global61)
		)
		(gAddToPics doit:)
		(Show (= local7 1))
		(= local4 (= local3 0))
		(if
			(and
				(gCurRoom obstacles:)
				(== local0 1)
				(Print 943 2 #title {Path Maker v1.2} #button {YES} 1 #button {NO} 0) ; "Use path currently in memory?"
			)
			(if (== local0 2)
				(self getFreeway:)
			else
				(self getPoly:)
			)
		)
		(= local658 (gEgo illegalBits:))
		(gEgo setLoop: 2 setCel: 0 illegalBits: 0)
		(= [local73 local3] -1)
		(while (not finished)
			(SetPort 0)
			(= event (Event new:))
			(event y: (- (event y:) 10))
			(if (< (event y:) 0)
				(event y: 0)
			)
			(if
				(= local662
					(or
						(!= (gEgo x:) (event x:))
						(!= (gEgo y:) (event y:))
						(event type:)
					)
				)
				(gEgo posn: (event x:) (event y:))
				(Animate (gCast elements:) 0)
				(= cBits (gEgo onControl:))
				(Display 943 3 dsCOORD 3 1 dsWIDTH 0 dsBACKGROUND 3) ; "On"
				(>>= cBits $0001)
				(for ((= i 1)) (< i 16) ((++ i))
					(if (& cBits $0001)
						(Display 943 4 dsWIDTH 6 dsBACKGROUND i)
					else
						(Display 943 4 dsWIDTH 6 dsBACKGROUND 0)
					)
					(>>= cBits $0001)
				)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if local1
					(Graph grRESTORE_BOX local1)
					(Graph grRESTORE_BOX local2)
					(Graph grUPDATE_BOX local654 local653 local656 local655 local7)
				)
				(SetVars (gEgo y:) (gEgo x:) local6 local5)
			)
			(cond
				(
					(and
						(== (event type:) evMOUSEBUTTON)
						(& (event modifiers:) emCTRL)
						(> local3 local4)
					)
					(if (== local0 1)
						(= [local73 local3] (& [local73 local4] $03ff))
						(= [local73 (++ local3)]
							(| [local73 (+ local4 1)] $8000)
						)
						(Graph
							grDRAW_LINE
							(& [local73 (- local3 2)] $03ff)
							(& [local73 (- local3 3)] $03ff)
							(& [local73 local3] $03ff)
							(& [local73 (- local3 1)] $03ff)
							0
							-1
							10
						)
						(SetVars
							(& [local73 (- local3 2)] $03ff)
							(& [local73 (- local3 3)] $03ff)
							(& [local73 local3] $03ff)
							(& [local73 (- local3 1)] $03ff)
						)
						(Format @local573 943 5) ; "0"
						(Graph grUPDATE_BOX local654 local653 local656 local655 local7)
						(= [local23 (++ local659)]
							(Print ; "Polygon access type?"
								943
								6
								#title
								{Path Maker v1.2}
								#button
								{Total}
								0
								#button
								{Near}
								1
								#button
								{Barred}
								2
							)
						)
					else
						(= [local73 local3] (| [local73 (-- local3)] $8000))
					)
					(= [local73 (++ local3)] -1)
					(= local4 local3)
					(= local5 -1)
					(= local1 0)
				)
				((== (event type:) evMOUSEBUTTON)
					(if (== local5 -1)
						(= [local73 local3] (| (= local5 (gEgo x:)) $c800))
					else
						(Graph
							grDRAW_LINE
							(gEgo y:)
							(gEgo x:)
							local6
							local5
							0
							-1
							10
						)
						(Graph grUPDATE_BOX local654 local653 local656 local655 local7)
						(= [local73 local3] (= local5 (gEgo x:)))
					)
					(= [local73 (++ local3)] (= local6 (gEgo y:)))
					(++ local3)
				)
				((== (event type:) evKEYBOARD)
					(switch (event message:)
						(KEY_PAUSE
							(= finished 1)
							(= [local73 local3] -1)
						)
						(KEY_ALT_m
							(if local1
								(Graph grRESTORE_BOX local1)
								(Graph grRESTORE_BOX local2)
								(Graph
									grUPDATE_BOX
									local654
									local653
									local656
									local655
									local7
								)
							)
							(self modifyPath:)
						)
						(KEY_F4
							(Show (= local7 4))
						)
						(KEY_ALT_c
							(Show (= local7 4))
						)
						(KEY_F2
							(Show (= local7 1))
						)
						(KEY_ALT_v
							(Show (= local7 1))
						)
						(KEY_ESCAPE
							(= finished 1)
							(= local657 0)
						)
						(KEY_p
							(if local660
								(= local660 0)
							else
								(= local660 1)
							)
						)
						(KEY_e
							(if (& (gEgo signal:) $0080)
								(gEgo show:)
							else
								(gEgo hide:)
							)
						)
						(KEY_QUESTION
							(Print 943 7 #font 999) ; "Defining polygons (or paths): Move cursor to point and click button to define point. Ctrl click marks path end. Other useful keys: F4 or <alt-C>: Show control screen. F2 or <alt-V>: Show visual. E: toggle ego showing or hidden. P: toggle position info on/off. <alt-M>: Modify path. <ctrl-S>: Quit and save all path data ESC: Quit without saving."
						)
						(JOY_UP
							(Print 943 8) ; "Path maker and polygon editor Written by Chad Bye"
						)
					)
				)
			)
			(if (and local662 (!= local5 -1) (not finished))
				(= local1 (Graph grSAVE_BOX local654 local653 local656 local655 1))
				(= local2 (Graph grSAVE_BOX local654 local653 local656 local655 4))
				(Graph grDRAW_LINE (gEgo y:) (gEgo x:) local6 local5 0 -1 10)
				(Graph grUPDATE_BOX local654 local653 local656 local655 local7)
			)
			(event dispose:)
			(if (and local660 local662)
				(pathDialog new: (gEgo x:) (gEgo y:))
			)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if local657
			(self savePoints:)
		)
		(DrawPic (gCurRoom curPic:) 100 1 global61)
		(if (!= global57 -1)
			(DrawPic global57 100 0 global61)
		)
		(gAddToPics doit:)
		(self drawPath: 0)
		(if (== local0 1)
			(self polyTest:)
		else
			(self freewayTest:)
		)
		(gEgo setLoop: -1 setCel: -1 illegalBits: local658)
		(if local661
			(gEgo hide:)
		else
			(gEgo show:)
		)
	)

	(method (handleEvent))

	(method (modifyPath &tmp event cBits i finished curIndex curX curY modifing)
		(= modifing (= finished 0))
		(= curX [local73 0])
		(= curY [local73 1])
		(= local4 (= curIndex 0))
		(= local5 -1)
		(gGame
			setCursor: gNormalCursor (HaveMouse) (& curX $03ff) (& curY $03ff)
		)
		(DrawPic (gCurRoom curPic:) 100 1 global61)
		(if (!= global57 -1)
			(DrawPic global57 100 0 global61)
		)
		(gAddToPics doit:)
		(Animate (gCast elements:) 0)
		(while (not finished)
			(SetPort 0)
			(= event (Event new:))
			(event y: (- (event y:) 10))
			(if
				(= local662
					(or
						(!= (gEgo x:) (event x:))
						(!= (gEgo y:) (event y:))
						(event type:)
					)
				)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if modifing
					(gEgo posn: (event x:) (event y:))
					(Animate (gCast elements:) 0)
					(= cBits ((User alterEgo:) onControl:))
					(Display 943 3 dsCOORD 3 1 dsWIDTH 0 dsBACKGROUND 3) ; "On"
					(>>= cBits $0001)
					(for ((= i 1)) (< i 16) ((++ i))
						(if (& cBits $0001)
							(Display 943 4 dsWIDTH 6 dsBACKGROUND i)
						else
							(Display 943 4 dsWIDTH 6 dsBACKGROUND 0)
						)
						(>>= cBits $0001)
					)
					(if local1
						(Graph grRESTORE_BOX local1)
						(Graph grRESTORE_BOX local2)
						(Graph grUPDATE_BOX local654 local653 local656 local655 local7)
						(= local1 0)
						(SetVars (gEgo y:) (gEgo x:) local6 local5)
					)
				else
					(Display 943 9 dsCOORD 3 1 dsWIDTH 0 dsBACKGROUND 3) ; "Off"
				)
			)
			(switch (event type:)
				(evMOUSEBUTTON
					(if modifing
						(= curX
							(= [local73 curIndex] (| (gEgo x:) (& curX $c800)))
						)
						(= curY
							(= [local73 (+ curIndex 1)]
								(| (gEgo y:) (& curY $8000))
							)
						)
						(if (!= local5 -1)
							(SetVars
								local6
								local5
								(& curY $03ff)
								(& curX $03ff)
							)
							(= local1
								(Graph grSAVE_BOX local654 local653 local656 local655 1)
							)
							(= local2
								(Graph grSAVE_BOX local654 local653 local656 local655 4)
							)
							(Graph
								grDRAW_LINE
								local6
								local5
								(& curY $03ff)
								(& curX $03ff)
								0
								-1
								10
							)
							(Graph
								grUPDATE_BOX
								local654
								local653
								local656
								local655
								local7
							)
						)
						(= modifing 0)
					)
				)
				(evKEYBOARD
					(switch (event message:)
						(KEY_ESCAPE
							(= finished 1)
							(gEgo posn: (event x:) (event y:))
							(Animate (gCast elements:) 0)
						)
						(KEY_SPACE
							(if (not modifing)
								(cond
									((== curIndex (- local3 2))
										(= finished 1)
										(gEgo posn: (event x:) (event y:))
										(Animate (gCast elements:) 0)
									)
									((not (& [local73 (+= curIndex 2)] $c800))
										(if (!= local5 -1)
											(if local1
												(Graph grRESTORE_BOX local1)
												(Graph grRESTORE_BOX local2)
												(= local1 0)
											)
											(Graph
												grDRAW_LINE
												local6
												local5
												(& curY $03ff)
												(& curX $03ff)
												0
												-1
												10
											)
											(Graph
												grUPDATE_BOX
												local654
												local653
												local656
												local655
												local7
											)
										)
										(if
											(and
												(& [local73 (+ curIndex 1)] $8000)
												(== local0 1)
											)
											(= [local73 curIndex]
												(& [local73 local4] $03ff)
											)
											(= [local73 (+ curIndex 1)]
												(| [local73 (+ local4 1)] $8000)
											)
											(if (== curIndex (- local3 2))
												(= finished 1)
												(gEgo
													posn: (event x:) (event y:)
												)
												(Animate (gCast elements:) 0)
											else
												(= local5 -1)
												(= local1 0)
												(= local4 9999)
											)
										else
											(= local5 (& curX $03ff))
											(= local6 (& curY $03ff))
										)
										(SetVars
											(& curY $03ff)
											(& curX $03ff)
											(& [local73 (+ curIndex 1)] $03ff)
											(& [local73 curIndex] $03ff)
										)
										(= local1
											(Graph
												grSAVE_BOX
												local654
												local653
												local656
												local655
												1
											)
										)
										(= local2
											(Graph
												grSAVE_BOX
												local654
												local653
												local656
												local655
												4
											)
										)
										(Graph
											grDRAW_LINE
											(& curY $03ff)
											(& curX $03ff)
											(& [local73 (+ curIndex 1)] $03ff)
											(& [local73 curIndex] $03ff)
											0
											-1
											10
										)
										(Graph
											grUPDATE_BOX
											local654
											local653
											local656
											local655
											local7
										)
										(if (== local4 9999)
											(= local4 (+= curIndex 2))
										)
									)
									(else
										(= local5 -1)
										(= local1 0)
										(= local4 curIndex)
									)
								)
								(= curX [local73 curIndex])
								(= curY [local73 (+ curIndex 1)])
								(gGame
									setCursor:
										gNormalCursor
										(HaveMouse)
										(& curX $03ff)
										(& curY $03ff)
								)
							)
						)
						(KEY_RETURN
							(= modifing 1)
							(if (!= local5 -1)
								(Graph grRESTORE_BOX local1)
								(Graph grRESTORE_BOX local2)
								(Graph
									grUPDATE_BOX
									local654
									local653
									local656
									local655
									local7
								)
								(gEgo posn: (event x:) (event y:))
								(Animate (gCast elements:) 0)
								(SetVars
									(gEgo y:)
									(gEgo x:)
									local6
									local5
								)
							)
						)
						(KEY_c
							(if local1
								(Graph grRESTORE_BOX local1)
								(Graph grRESTORE_BOX local2)
								(Graph
									grUPDATE_BOX
									local654
									local653
									local656
									local655
									local7
								)
							)
							(if (& [local73 curIndex] $c800)
								(if (and local1 (> curIndex 4))
									(Graph
										grDRAW_LINE
										(& [local73 (- curIndex 3)] $03ff)
										(& [local73 (- curIndex 4)] $03ff)
										(& [local73 (- curIndex 1)] $03ff)
										(& [local73 (- curIndex 2)] $03ff)
										0
										-1
										10
									)
									(Graph
										grUPDATE_BOX
										local654
										local653
										local656
										local655
										local7
									)
								)
								(|= [local73 (+ curIndex 2)] $c800)
							)
							(= local1 0)
							(if (& [local73 (+ curIndex 1)] $8000)
								(|= [local73 (- curIndex 1)] $8000)
								(= local4 curIndex)
							)
							(-= local3 2)
							(for
								((= i curIndex))
								(< i local3)
								((+= i 2))
								
								(= [local73 i] [local73 (+ i 2)])
								(= [local73 (+ i 1)] [local73 (+ i 3)])
							)
							(if (& [local73 curIndex] $c800)
								(= local5 -1)
							)
							(= curX [local73 curIndex])
							(= curY [local73 (+ curIndex 1)])
							(gGame
								setCursor:
									gNormalCursor
									(HaveMouse)
									(& curX $03ff)
									(& curY $03ff)
							)
							(if (!= local5 -1)
								(SetVars
									local6
									local5
									(& curY $03ff)
									(& curX $03ff)
								)
								(= local1
									(Graph
										grSAVE_BOX
										local654
										local653
										local656
										local655
										1
									)
								)
								(= local2
									(Graph
										grSAVE_BOX
										local654
										local653
										local656
										local655
										4
									)
								)
								(Graph
									grDRAW_LINE
									local6
									local5
									(& curY $03ff)
									(& curX $03ff)
									0
									-1
									10
								)
								(Graph
									grUPDATE_BOX
									local654
									local653
									local656
									local655
									local7
								)
							)
							(cond
								((== curIndex (- local3 2))
									(= finished 1)
								)
								(
									(and
										(& [local73 (+ curIndex 1)] $8000)
										(== local0 1)
										(not (& [local73 curIndex] $c800))
									)
									(= local4 (+= curIndex 2))
									(= local5 -1)
									(= curX [local73 curIndex])
									(= curY [local73 (+ curIndex 1)])
									(gGame
										setCursor:
											gNormalCursor
											(HaveMouse)
											(& curX $03ff)
											(& curY $03ff)
									)
								)
							)
						)
						(KEY_i
							(if (!= local5 -1)
								(if local1
									(Graph grRESTORE_BOX local1)
									(Graph grRESTORE_BOX local2)
									(= local1 0)
								)
								(Graph
									grDRAW_LINE
									local6
									local5
									(& curY $03ff)
									(& curX $03ff)
									0
									-1
									10
								)
								(Graph
									grUPDATE_BOX
									local654
									local653
									local656
									local655
									local7
								)
							)
							(= modifing 1)
							(+= curIndex 2)
							(for
								((= i local3))
								(> i curIndex)
								((-= i 2))
								
								(= [local73 i] [local73 (- i 2)])
								(= [local73 (+ i 1)] [local73 (- i 1)])
							)
							(+= local3 2)
							(if (& [local73 (- curIndex 1)] $8000)
								(= [local73 curIndex] [local73 (- curIndex 2)])
								(= [local73 (+ curIndex 1)] [local73 (- curIndex 1)])
								(&= [local73 (- curIndex 1)] $03ff)
							else
								(&= [local73 curIndex] $03ff)
								(&= [local73 (+ curIndex 1)] $03ff)
							)
							(= local5 (& curX $03ff))
							(= local6 (& curY $03ff))
							(= curX [local73 curIndex])
							(= curY [local73 (+ curIndex 1)])
							(gEgo posn: (event x:) (event y:))
							(Animate (gCast elements:) 0)
							(SetVars
								(gEgo y:)
								(gEgo x:)
								local6
								local5
							)
						)
						(KEY_F4
							(Show (= local7 4))
						)
						(KEY_ALT_c
							(Show (= local7 4))
						)
						(KEY_F2
							(Show (= local7 1))
						)
						(KEY_ALT_v
							(Show (= local7 1))
						)
						(KEY_p
							(if local660
								(= local660 0)
							else
								(= local660 1)
							)
						)
						(KEY_e
							(if (& (gEgo signal:) $0080)
								(gEgo show:)
							else
								(gEgo hide:)
							)
						)
						(KEY_QUESTION
							(Print 943 10 #font 999) ; "Modifying defined polygons: <space>: Move to next defined point. <enter>: Select and edit point. C: Cut point. I: Insert point after current point. ESC: Return to creating new points. F4 or <alt-C>: Show control screen. F2 or <alt-V>: Show visual. E: toggle ego showing or hidden. P: toggle position info on/off. Editing point: Move cursor to new point and click mouse button."
						)
						(JOY_UP
							(Print 943 8) ; "Path maker and polygon editor Written by Chad Bye"
						)
					)
				)
			)
			(if (and modifing local662)
				(if (!= local5 -1)
					(= local1 (Graph grSAVE_BOX local654 local653 local656 local655 1))
					(= local2 (Graph grSAVE_BOX local654 local653 local656 local655 4))
					(Graph grDRAW_LINE (gEgo y:) (gEgo x:) local6 local5 0 -1 10)
					(Graph grUPDATE_BOX local654 local653 local656 local655 local7)
				)
				(if local660
					(pathDialog new: (gEgo x:) (gEgo y:))
				)
			)
			(event dispose:)
		)
		(if local1
			(Graph grRESTORE_BOX local1)
			(Graph grRESTORE_BOX local2)
			(Graph grUPDATE_BOX local654 local653 local656 local655 local7)
			(= local1 0)
		)
		(self drawPath: 1)
		(if (& [local73 (- local3 1)] $8000)
			(= local5 -1)
		else
			(= local5 (& [local73 (- local3 2)] $03ff))
			(= local6 (& [local73 (- local3 1)] $03ff))
			(SetVars (gEgo y:) (gEgo x:) local6 local5)
		)
	)

	(method (savePoints &tmp str loop numPaths pathSize)
		(Logit (Format @local573 943 11 (gCurRoom picture:))) ; ";** Path points for picture #%d  (local"
		(if (== local0 2)
			(= loop 0)
			(Print 943 12 #dispose) ; "Saving Freeway path"
			(Logit (Format @local573 943 13)) ; "ePData = ["
			(for ((= str 1)) (< str local3) ((+= str 2))
				(if (& [local73 str] $8000)
					(++ loop)
				)
			)
			(Logit (Format @local573 943 14 loop)) ; "%d"
			(for ((= str 0)) (< str loop) ((++ str))
				(Logit {0 })
			)
			(Logit (Format @local573 943 15)) ; "0"
			(= loop 0)
			(for ((= str 0)) (< str local3) ((+= str 2))
				(cond
					((& [local73 str] $c800)
						(Logit
							(Format ; "(| PATHSTART SLICK ACTIVE %d) %d ;** path#%d"
								@local573
								943
								16
								(& [local73 str] $03ff)
								[local73 (+ str 1)]
								loop
							)
						)
					)
					((& [local73 (+ str 1)] $8000)
						(Logit
							(Format ; "%d (| PATHEND %d)"
								@local573
								943
								17
								[local73 str]
								(& [local73 (+ str 1)] $03ff)
							)
						)
						(++ loop)
					)
					(else
						(Logit
							(Format ; "%d %d"
								@local573
								943
								18
								[local73 str]
								[local73 (+ str 1)]
							)
						)
					)
				)
			)
			(Logit (Format @local573 943 19)) ; "0   ] )"
		else
			(Print 943 20 #dispose) ; "Saving PolyPath"
			(= loop 1)
			(= pathSize 0)
			(for ((= str 0)) (< str local3) ((+= str 2))
				(cond
					((& [local73 str] $c800)
						(Logit
							(Format ; "pts%d = [%d %d"
								@local573
								943
								21
								loop
								(& [local73 str] $03ff)
								[local73 (+ str 1)]
							)
						)
						(= pathSize 0)
					)
					((& [local73 (+ str 1)] $8000)
						(Logit (Format @local573 943 22)) ; "]"
						(++ loop)
					)
					((< pathSize 10)
						(Logit
							(Format ; "%d %d"
								@local573
								943
								23
								[local73 str]
								[local73 (+ str 1)]
							)
						)
						(++ pathSize)
					)
					(else
						(Logit
							(Format ; "%d %d"
								@local573
								943
								24
								[local73 str]
								[local73 (+ str 1)]
							)
						)
						(= pathSize 0)
					)
				)
			)
			(Logit (Format @local573 943 25)) ; ")  ;** The following belongs in the room's init:"
			(= loop 1)
			(= numPaths 1)
			(for ((= str 0)) (< str local3) ((+= str 2))
				(if (& [local73 (+ str 1)] $8000)
					(Logit
						(Format @local573 943 26 loop loop (- numPaths 1)) ; "(poly%d points: @pts%d, size: %d)"
					)
					(++ loop)
					(= numPaths 1)
				else
					(++ numPaths)
				)
			)
			(Logit (Format @local573 943 27)) ; "(self   addObstacle:"
			(for ((= str 1)) (< str loop) ((++ str))
				(Logit (Format @local573 943 28 str)) ; "poly%d"
			)
			(Logit (Format @local573 943 29)) ; ")  ;** Necessary objects:"
			(for ((= str 1)) (< str loop) ((++ str))
				(Logit
					(Format @local573 943 30 str [local663 [local23 str]]) ; "(instance poly%d of Polygon  (properties  type: %s  ) )"
				)
			)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
	)

	(method (getFreeway &tmp [temp0 4]))

	(method (getPoly)
		(if (gCurRoom obstacles:)
			(= local659 0)
			((gCurRoom obstacles:) eachElementDo: #perform addSelfToPath)
		)
		(self drawPath: 1)
	)

	(method (drawPath param1 &tmp temp0)
		(if (!= 0 param1 1)
			(= param1 1)
		)
		(self fixPoints:)
		(= local4 (= temp0 0))
		(while (< temp0 local3)
			(if (not (& [local73 temp0] $c800))
				(if (> temp0 1)
					(if (and (& [local73 (+ temp0 1)] $8000) (== local0 1))
						(= [local73 temp0] (& [local73 local4] $03ff))
						(= [local73 (+ temp0 1)]
							(| [local73 (+ local4 1)] $8000)
						)
					)
					(SetVars
						(& [local73 (- temp0 1)] $03ff)
						(& [local73 (- temp0 2)] $03ff)
						(& [local73 (+ temp0 1)] $03ff)
						(& [local73 temp0] $03ff)
					)
					(Graph
						grDRAW_LINE
						(& [local73 (- temp0 1)] $03ff)
						(& [local73 (- temp0 2)] $03ff)
						(& [local73 (+ temp0 1)] $03ff)
						(& [local73 temp0] $03ff)
						0
						-1
						(- (* 11 param1) 1)
					)
					(Graph grUPDATE_BOX local654 local653 local656 local655 local7)
				)
				(if (& [local73 (+ temp0 1)] $8000)
					(= local4 (+ temp0 2))
				)
			)
			(+= temp0 2)
		)
	)

	(method (fixPoints &tmp temp0)
		(for ((= temp0 0)) (< temp0 local3) ((+= temp0 2))
			(cond
				((>= (& [local73 temp0] $03ff) 640)
					(= [local73 temp0] (| $0000 (& [local73 temp0] $c800)))
				)
				((>= (& [local73 temp0] $03ff) 320)
					(= [local73 temp0] (| $013f (& [local73 temp0] $c800)))
				)
			)
			(cond
				((>= (& [local73 (+ temp0 1)] $03ff) 400)
					(= [local73 (+ temp0 1)]
						(| $0000 (& [local73 (+ temp0 1)] $8000))
					)
				)
				((>= (& [local73 (+ temp0 1)] $03ff) 190)
					(= [local73 (+ temp0 1)]
						(| $00bd (& [local73 (+ temp0 1)] $8000))
					)
				)
			)
		)
	)

	(method (polyTest &tmp gotPath i)
		(if (gCurRoom obstacles:)
			((gCurRoom obstacles:) eachElementDo: #dispose release:)
		)
		(= local4 (= gotPath 0))
		(= local659 0)
		(for ((= i 0)) (< i local3) ((+= i 2))
			(if gotPath
				(if (& [local73 (+ i 1)] $8000)
					(&= [local73 i] $03ff)
					(&= [local73 (+ i 1)] $03ff)
					(gCurRoom
						addObstacle:
							((Clone Polygon)
								points: @[local73 local4]
								size: (- (/ (+ (- i local4) 2) 2) 1)
								type: [local23 (++ local659)]
								yourself:
							)
					)
					(= gotPath 0)
				)
			else
				(if (& [local73 i] $c800)
					(= local4 i)
					(= gotPath 1)
				)
				(&= [local73 i] $03ff)
				(&= [local73 (+ i 1)] $03ff)
			)
		)
	)

	(method (freewayTest &tmp [temp0 2]))

	(method (dispose)
		(gFeatures delete: self)
		(DisposeScript 943)
	)
)

(instance addSelfToPath of Code
	(properties)

	(method (doit thePoly &tmp temp0)
		(if (== (thePoly superClass:) Polygon)
			(StrCpy @[local73 local3] (thePoly points:) (- (* (thePoly size:) 4)))
			(|= [local73 local3] $c800)
			(for
				((= temp0 (+ local3 2)))
				(< temp0 (+ local3 (* (thePoly size:) 2)))
				((+= temp0 2))
				
				(&= [local73 temp0] $03ff)
				(&= [local73 (+ temp0 1)] $03ff)
			)
			(+= local3 (* (thePoly size:) 2))
			(StrCpy @[local73 local3] (thePoly points:) -4)
			(= local4 (+= local3 2))
			(&= [local73 (- local3 2)] $03ff)
			(|= [local73 (- local3 1)] $8000)
			(= [local23 (++ local659)] (thePoly type:))
		)
	)
)

(instance pathDialog of Dialog
	(properties)

	(method (new param1 param2 &tmp temp0 temp1 temp2 [temp3 100])
		((= temp0 (super new:)) window: SysWindow name: {X/Y})
		(= temp1 (DText new:))
		(Format @temp3 943 31 param1 param2) ; "%d/%d"
		(temp1 text: @temp3 moveTo: 0 0 font: 999 setSize:)
		(temp0
			add: temp1
			setSize:
			moveTo:
				(if (== -1 param1)
					(temp0 nsLeft:)
				else
					param1
				)
				(if (== -1 param2)
					(temp0 nsTop:)
				else
					(- param2 8)
				)
		)
		(= temp2 (GetPort))
		(temp0 open: 0 15)
		(= global62 (GetPort))
		(SetPort temp2)
		(= gModelessDialog temp0)
	)

	(method (setSize)
		(super setSize: &rest)
		(-= nsRight 4)
		(-= nsBottom 4)
	)
)

