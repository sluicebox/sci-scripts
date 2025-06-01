;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 943)
(include sci.sh)
(use Main)
(use Print)
(use Polygon)
(use Window)
(use File)
(use System)

(local
	curMap
	saveSystemWindow
	[fileName 40]
	rTop
	rLft
	rBot
	rRgt
	[editMenuItems 25] = [{EDITING} 0 0 {About} 0 0 {Map} 0 0 {Create} 0 0 {Type} 0 0 {Undo} 0 0 {Help} 0 0 {eXit} 120 0 0]
	[addMenuItems 22] = [{CREATING} 0 0 {About} 0 0 {Map} 0 0 {Done} 0 0 {Undo} 0 0 {Help} 0 0 {eXit} 120 0 0]
)

(procedure (FindBoundingRect args &tmp i x y)
	(= rRgt (= rBot 0))
	(= rLft (= rTop 32767))
	(for ((= i 0)) (< i argc) ((+= i 2))
		(= x [args i])
		(if (< (= y [args (+ i 1)]) rTop)
			(= rTop y)
		)
		(if (> y rBot)
			(= rBot y)
		)
		(if (< x rLft)
			(= rLft x)
		)
		(if (> x rRgt)
			(= rRgt x)
		)
	)
	(-= rLft 2)
	(-= rTop 2)
	(+= rRgt 2)
	(+= rBot 2)
)

(procedure (Dot x1 y1 x2 y2)
	(return
		(+
			(* (+ (/ x1 2) 1) (+ (/ x2 2) 1))
			(* (+ (/ y1 2) 1) (+ (/ y2 2) 1))
		)
	)
)

(procedure (LineDist X1 Y1 X2 Y2 X3 Y3 &tmp xyDist)
	(if
		(and
			(<=
				0
				(Dot
					(- X2 X1)
					(- Y2 Y1)
					(- X3 X1)
					(- Y3 Y1)
				)
			)
			(<=
				0
				(Dot
					(- X1 X2)
					(- Y1 Y2)
					(- X3 X2)
					(- Y3 Y2)
				)
			)
		)
		(return
			(if (= xyDist (GetDistance X1 Y1 X2 Y2))
				(/
					(Abs
						(Dot
							(- Y2 Y1)
							(- X1 X2)
							(- X3 X1)
							(- Y3 Y1)
						)
					)
					xyDist
				)
			else
				0
			)
		)
	else
		(return
			(Min
				(GetDistance X3 Y3 X1 Y1)
				(GetDistance X3 Y3 X2 Y2)
			)
		)
	)
)

(procedure (DoPrint printBuf printMode)
	(Print
		width: 240
		font: 999
		mode: printMode
		addText: printBuf
		addTitle: {Polygon Editor 1.11}
		init:
	)
)

(class ClickMenu of Obj
	(properties
		text 0
		array 0
	)

	(method (init theArray &tmp itemNum base theText theWidth [r 4] [str 40] totWidth chr)
		(= text (Memory memALLOC_NONCRIT 81))
		(Memory memPOKE text 0)
		(= base (= array theArray))
		(= totWidth 0)
		(= itemNum 0)
		(while (= theText (Memory memPEEK base))
			(StrCpy @str theText)
			(if (not itemNum)
				(StrCat @str {: })
			)
			(StrCat @str { })
			(StrCat text @str)
			(TextSize @r @str 0 0)
			(+= totWidth [r 3])
			(Memory memPOKE (+ base 4) totWidth)
			(if (not (Memory memPEEK (+ base 2)))
				(= chr (StrAt theText 0))
				(if (<= 65 chr 90)
					(+= chr 32)
				)
				(Memory memPOKE (+ base 2) chr)
			)
			(++ itemNum)
			(+= base 6)
		)
		(DrawStatus text)
	)

	(method (handleEvent event &tmp base itemNum)
		(if (!= (event type:) evMOUSEBUTTON)
			(return 0)
		)
		(if (>= (event y:) 10)
			(return 0)
		)
		(= base array)
		(= itemNum 0)
		(while (Memory memPEEK base)
			(if (and (< (event x:) (Memory memPEEK (+ base 4))) itemNum)
				(event type: evKEYBOARD message: (Memory memPEEK (+ base 2)))
				(return 0)
			)
			(++ itemNum)
			(+= base 6)
		)
		(event claimed: 1)
	)

	(method (dispose)
		(Memory memFREE text)
		(super dispose:)
	)
)

(instance editMenu of ClickMenu
	(properties)

	(method (init)
		(super init: @editMenuItems)
	)
)

(instance addMenu of ClickMenu
	(properties)

	(method (init)
		(super init: @addMenuItems)
	)
)

(class _EditablePoint
	(properties
		x 0
		y 0
		underBits 0
	)

	(method (new)
		(Clone self)
	)

	(method (yourself)
		(return self)
	)

	(method (draw pt whichList &tmp visualColor ctrlColor)
		(if (== curMap 4)
			(= visualColor -1)
			(= ctrlColor (if (== whichList 1) 3 else 4))
		else
			(= visualColor 0)
			(= ctrlColor -1)
		)
		(Graph grDRAW_LINE y x (pt y:) (pt x:) visualColor -1 ctrlColor)
	)

	(method (save pt)
		(FindBoundingRect x y (pt x:) (pt y:))
		(if underBits
			(UnLoad 133 underBits)
		)
		(= underBits (Graph grSAVE_BOX rTop rLft rBot rRgt curMap))
	)

	(method (restore)
		(if underBits
			(Graph grRESTORE_BOX underBits)
			(= underBits 0)
		)
	)

	(method (dispose)
		(if underBits
			(UnLoad 133 underBits)
			(= underBits 0)
		)
		(DisposeClone self)
	)
)

(class Class_943_2 of List
	(properties
		curNode 0
		curPt 0
		closed 0
		type 2
		srcList 0
		closestPt 0
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
	)

	(method (getAccessType &tmp temp0)
		(if
			(= temp0
				(Print
					addTitle: {Polygon access type}
					addButton: 1 {Total} 0 0
					addButton: 2 { Near } 60 0
					addButton: 3 { Barred } 120 0
					addButton: 4 { Container } 195 0
					first: type
					init:
				)
			)
			(= type (- temp0 1))
		)
	)

	(method (writeFile param1 param2 &tmp temp0 temp1 temp2 temp3 [temp4 10] temp14)
		(if (== param2 srcList)
			(param1
				writeString:
					{\t\t\t((Polygon new:)\0d\n}
					{\t\t\t\ttype:\t\t}
					(switch type
						(0 {PTotalAccess})
						(1 {PNearestAccess})
						(2 {PBarredAccess})
						(3 {PContainedAccess})
					)
					{,\0d\n}
			)
			(param1 writeString: {\t\t\t\tinit:\t\t})
			(= temp14 1)
			(= temp0 17)
			(for
				((= temp3 (FirstNode elements)))
				temp3
				((= temp3 (NextNode temp3)))
				
				(= temp2 (NodeValue temp3))
				(Format @temp4 943 0 (temp2 x:) (temp2 y:)) ; "%d %d"
				(if (>= (+= temp0 (= temp1 (+ (StrLen @temp4) 1))) 80)
					(param1 writeString: {\0d\n\t\t\t\t\t\t})
					(= temp14 1)
					(= temp0 (+ 17 temp1))
				)
				(if (not temp14)
					(param1 writeString: { })
				)
				(param1 writeString: @temp4)
				(= temp14 0)
			)
			(param1 writeString: {,\0d\n})
			(param1 writeString: {\t\t\t\tyourself:\0d\n} {\t\t\t)\0d\n})
		)
	)

	(method (check &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 [temp17 40])
		(for ((= temp0 (self first:))) temp0 ((= temp0 (NextNode temp0)))
			(= temp2 (NodeValue temp0))
			(for
				((= temp15 (NextNode temp0)))
				temp15
				((= temp15 (NextNode temp15)))
				
				(= temp16 (NodeValue temp15))
				(if
					(and
						(== (temp2 x:) (temp16 x:))
						(== (temp2 y:) (temp16 y:))
					)
					(= temp15 (PrevNode temp15))
					(self delete: temp16)
					(temp16 dispose:)
				)
			)
		)
		(= temp4 0)
		(= temp9 0)
		(= temp7 0)
		(= temp8 1)
		(for ((= temp0 (= temp6 (self first:)))) 1 ((= temp0 temp1))
			(= temp2 (NodeValue temp0))
			(= temp1 (self next: temp0))
			(= temp3 (NodeValue temp1))
			(= temp4 (ATan (temp2 x:) (temp2 y:) (temp3 x:) (temp3 y:)))
			(if (not temp8)
				(cond
					((> (= temp5 (- temp4 temp9)) 180)
						(-= temp5 360)
					)
					((< temp5 -180)
						(+= temp5 360)
					)
				)
				(+= temp7 temp5)
			)
			(= temp9 temp4)
			(breakif (and (== temp0 temp6) (not temp8)))
			(= temp8 0)
		)
		(if (== type 3)
			(= temp7 (- temp7))
		)
		(cond
			((== temp7 -360)
				(= temp0 (self first:))
				(for
					((= temp10 (self last:)))
					(and (!= temp0 temp10) (!= temp0 (NextNode temp10)))
					((= temp10 (PrevNode temp10)))
					
					(= temp2 (NodeValue temp0))
					(= temp11 (NodeValue temp10))
					(= temp12 (temp2 x:))
					(= temp13 (temp2 y:))
					(temp2 x: (temp11 x:))
					(temp2 y: (temp11 y:))
					(temp11 x: temp12)
					(temp11 y: temp13)
					(= temp0 (NextNode temp0))
				)
			)
			((!= temp7 360)
				(Format @temp17 943 1 name temp7) ; "Error in (%s check:) totAngle [%d] != +-360"
				(Prints @temp17)
			)
		)
	)

	(method (writeObstacle &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (Memory memALLOC_NONCRIT (* size 4)))
		(= temp2 (FirstNode elements))
		(for ((= temp0 temp1)) temp2 ((+= temp0 4))
			(= temp3 (NodeValue temp2))
			(Memory memPOKE temp0 (temp3 x:))
			(Memory memPOKE (+ temp0 2) (temp3 y:))
			(= temp2 (NextNode temp2))
		)
		(if (== srcList 1)
			(global95
				add:
					((Polygon new:)
						type: type
						points: temp1
						size: size
						dynamic: 1
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: type
						points: temp1
						size: size
						dynamic: 1
						yourself:
					)
			)
		)
	)

	(method (movePt param1 param2)
		(curPt x: param1 y: param2)
	)

	(method (restore)
		(self eachLineDo: #restore)
	)

	(method (save)
		(self eachLineDo: #save)
	)

	(method (draw)
		(self eachLineDo: #draw srcList)
	)

	(method (add param1 param2 param3)
		(super
			add: (= curPt ((_EditablePoint new:) x: param1 y: param2 yourself:))
		)
		(self setCur: (FindKey elements curPt) param3)
	)

	(method (advance &tmp temp0)
		(self setCur: (self next: curNode))
	)

	(method (retreat &tmp temp0)
		(self setCur: (self prev: curNode))
	)

	(method (setCur param1 param2)
		(if (= curNode param1)
			(= curPt (NodeValue curNode))
			(if (or (< argc 2) param2)
				(gGame setCursor: 999 1 (curPt x:) (curPt y:))
			)
		)
	)

	(method (setCurClosest param1)
		(self setCur: (FindKey elements closestPt) param1)
	)

	(method (startRedraw &tmp temp0 temp1 temp2 temp3 temp4)
		(if (= temp0 (self next: curNode))
			(= temp3 (NodeValue temp0))
		else
			(= temp3 curPt)
		)
		(if (= temp1 (self prev: curNode))
			(= temp4 (NodeValue temp1))
		else
			(= temp4 curPt)
		)
		(FindBoundingRect
			(temp4 x:)
			(temp4 y:)
			(curPt x:)
			(curPt y:)
			(temp3 x:)
			(temp3 y:)
		)
		(= lsTop rTop)
		(= lsLeft rLft)
		(= lsBottom rBot)
		(= lsRight rRgt)
	)

	(method (endRedraw)
		(FindBoundingRect (curPt x:) (curPt y:) lsLeft lsTop lsRight lsBottom)
		(Graph grUPDATE_BOX rTop rLft rBot rRgt curMap)
	)

	(method (getDistToPt param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp4 32767)
		(= temp1 (self first:))
		(= temp0 (self last:))
		(while 1
			(= temp2 (NodeValue temp1))
			(if
				(<
					(= temp3 (GetDistance param1 param2 (temp2 x:) (temp2 y:)))
					temp4
				)
				(= temp4 temp3)
				(= closestPt temp2)
			)
			(breakif (== temp1 temp0))
			(= temp1 (self next: temp1))
		)
		(return temp4)
	)

	(method (getDistToLine param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (< size 2)
			(return (self getDistToPt: param1 param2 &rest))
		)
		(= temp4 32767)
		(= temp1 (self first:))
		(= temp0 (self last:))
		(while 1
			(= temp2 (NodeValue temp1))
			(= temp6 (self next: temp1))
			(= temp5 (NodeValue temp6))
			(if
				(<
					(= temp3
						(LineDist
							(temp2 x:)
							(temp2 y:)
							(temp5 x:)
							(temp5 y:)
							param1
							param2
						)
					)
					temp4
				)
				(= temp4 temp3)
				(= closestPt temp2)
			)
			(breakif (== temp1 temp0))
			(= temp1 temp6)
		)
		(return temp4)
	)

	(method (insertPt param1 param2 &tmp temp0)
		(= temp0 ((_EditablePoint new:) x: param1 y: param2 yourself:))
		(self addAfter: closestPt temp0)
		(self setCur: (FindKey elements temp0))
	)

	(method (eachLineDo param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 (self first:))
		(= temp4 (self last:))
		(while (or (!= temp0 temp4) closed)
			(= temp1 (self next: temp0))
			(= temp2 (NodeValue temp0))
			(= temp3 (NodeValue temp1))
			(temp2 param1: temp3 &rest)
			(breakif (== temp0 temp4))
			(= temp0 temp1)
		)
	)

	(method (deletePt &tmp temp0)
		(if (== curNode (= temp0 (self prev: curNode)))
			(= temp0 0)
		)
		(self delete: curPt)
		(curPt dispose:)
		(self setCur: temp0)
	)

	(method (next param1 &tmp temp0)
		(= temp0 (super next: param1))
		(if (and closed (not temp0))
			(return (super first:))
		)
		(return temp0)
	)

	(method (prev param1 &tmp temp0)
		(= temp0 (super prev: param1))
		(if (and closed (not temp0))
			(return (super last:))
		)
		(return temp0)
	)

	(method (saveForUndo &tmp temp0 temp1 temp2 temp3)
		(= temp1 (= temp0 (Memory memALLOC_NONCRIT (* 2 (+ (* 2 size) 3)))))
		(Memory memPOKE temp1 closed)
		(+= temp1 2)
		(Memory memPOKE temp1 size)
		(+= temp1 2)
		(Memory memPOKE temp1 (self indexOf: curPt))
		(+= temp1 2)
		(= temp2 (self first:))
		(while temp2
			(= temp3 (NodeValue temp2))
			(Memory memPOKE temp1 (temp3 x:))
			(Memory memPOKE (+= temp1 2) (temp3 y:))
			(= temp2 (NextNode temp2))
			(+= temp1 2)
		)
		(return temp0)
	)

	(method (undo param1 &tmp temp0 temp1 temp2 temp3)
		(self eachElementDo: #dispose release:)
		(= closed (Memory memPEEK param1))
		(+= param1 2)
		(= temp1 (Memory memPEEK param1))
		(+= param1 2)
		(= temp3 (Memory memPEEK param1))
		(+= param1 2)
		(= temp2 0)
		(while (< temp2 temp1)
			(self add: (Memory memPEEK param1) (Memory memPEEK (+= param1 2)) 0)
			(++ temp2)
			(+= param1 2)
		)
		(self setCur: (FindKey elements (self at: temp3)) 0)
	)
)

(instance readObstacle of Code
	(properties)

	(method (doit obstacle whichList &tmp i base curPoly)
		(= curPoly (PolyEdit add:))
		(= i 0)
		(for
			((= base (obstacle points:)))
			(< i (obstacle size:))
			((+= base 4))
			
			(curPoly
				add: (Memory memPEEK base) (Memory memPEEK (+ base 2)) 0
				type: (obstacle type:)
				srcList: whichList
			)
			(++ i)
		)
		(curPoly closed: 1)
	)
)

(class PolyEdit of List
	(properties
		curPolygon 0
		x 0
		y 0
		state 0
		isMouseDown 0
		curMenu 0
		undoPrvPoly 0
		undoPoly 0
		undoPolyBuf 0
		undoX 0
		undoY 0
		undoState 0
	)

	(method (handleEvent event &tmp mods lastX lastY [str 20])
		(= lastX x)
		(= lastY y)
		(= x (event x:))
		(= y (event y:))
		(switch (event type:)
			(evNULL
				(if curPolygon
					(if
						(and
							isMouseDown
							(not (OneOf state 0 2))
							(> (+ (Abs (- lastX x)) (Abs (- lastY y))) 1)
						)
						(if (!= state 3)
							(self saveForUndo:)
						)
						(self changeState: 2)
					)
					(if
						(and
							(OneOf state 2 0)
							(or (!= lastX x) (!= lastY y))
						)
						(self movePt: x y)
					)
					(if (== state 2)
						(DrawStatus (Format @str 943 2 x y)) ; "DRAGGING: %d, %d"
					)
				)
			)
			(evMOUSEBUTTON
				(= mods (event modifiers:))
				(= isMouseDown 1)
				(cond
					((& mods emCTRL)
						(if (== state 0)
							(self finishAdding:)
							(= isMouseDown 0)
						else
							(self insertPt:)
						)
					)
					((& mods emSHIFT)
						(if (!= state 0)
							(self deletePt:)
						)
						(= isMouseDown 0)
					)
					((== state 0)
						(self addPt:)
					)
					(else
						(self selectPt:)
					)
				)
			)
			(evMOUSERELEASE
				(= isMouseDown 0)
				(if (OneOf state 2 3)
					(self changeState: 1)
				)
			)
			(evKEYBOARD
				(switch (event message:)
					(KEY_QUESTION
						(event message: KEY_h)
					)
					(KEY_PAUSE
						(event message: KEY_x)
					)
					(KEY_F2
						(event message: KEY_ALT_v)
					)
					(KEY_F4
						(event message: KEY_ALT_c)
					)
				)
				(switch (event message:)
					(KEY_TAB
						(if (and (== state 1) curPolygon)
							(self advanceRetreat: 65 124)
						)
					)
					(KEY_SHIFTTAB
						(if (and (== state 1) curPolygon)
							(self advanceRetreat: 128 127)
						)
					)
					(KEY_SPACE
						(if (and (== state 1) curPolygon)
							(curPolygon advance:)
						)
					)
					(JOY_UPLEFT
						(if (and (== state 1) curPolygon)
							(curPolygon retreat:)
						)
					)
					(KEY_c
						(if (== state 1)
							(self changeState: 0)
							(= curPolygon 0)
						)
					)
					(KEY_t
						(if (and curPolygon (== state 1))
							(curPolygon getAccessType:)
						)
					)
					(KEY_d
						(cond
							((== state 1)
								(if curPolygon
									(self deletePt:)
								)
							)
							((== state 0)
								(self finishAdding:)
							)
						)
					)
					(KEY_h
						(switch state
							(0
								(DoPrint
									{___________CREATING POLYGON\0d\n\0d\nClick to create each corner of the polygon, then choose Done from the menu to finish.__You can also press Esc or Ctrl-click to finish.\0d\n\0d\nTo UNDO a corner, choose Undo.\0d\n\0d\nTo change MAP displayed (visual or control), choose Map.\0d\n\0d\nTo EXIT the Polygon Editor, choose eXit or press Ctrl-S.}
									0
								)
							)
							(1
								(DoPrint
									{_____________EDITING POLYGON\0d\n\0d\nTo MOVE a corner, click on it and drag it to the new position.\0d\nTo INSERT a new corner, Ctrl-click to create it, then drag it to the correct position.\0d\nTo DELETE a corner, Shift-click on it.\0d\nTo UNDO an action, choose Undo from the menu.\0d\nTo CREATE a new polygon, choose Create.\0d\nTo change a polygon's TYPE (Total, Near or Barred), choose Type.\0d\nTo change MAP displayed (visual or control), choose Map.\0d\nTo EXIT the Polygon Editor, choose eXit or press Ctrl-S.\0d\n\0d\nIn addition to using the mouse, you can use Space and BackSpace to select corners and Tab and BackTab to select polygons. }
									0
								)
							)
						)
					)
					(KEY_u
						(self undo:)
					)
					(KEY_m
						(self showMap: -1)
					)
					(KEY_ALT_v
						(self showMap: 1)
					)
					(KEY_ALT_c
						(self showMap: 4)
					)
					(KEY_a
						(DoPrint
							{ by\0d\n\0d\nMark Wilden\0d\n\0d\nOriginal program by Chad Bye }
							1
						)
					)
					(KEY_r
						(if (== state 1)
							(self draw:)
						)
					)
					(KEY_x
						(self exit:)
						(return)
					)
					(KEY_ESCAPE
						(if (== state 0)
							(self finishAdding:)
						)
					)
				)
			)
		)
		(return 0)
	)

	(method (changeState newState)
		(if curMenu
			(curMenu dispose:)
		)
		(= curMenu
			(switch (= state newState)
				(0 addMenu)
				(1 editMenu)
				(2 0)
				(else 0)
			)
		)
		(if curMenu
			(curMenu init:)
		)
	)

	(method (readObstacles)
		(if (gCurRoom obstacles:)
			((gCurRoom obstacles:) eachElementDo: #perform readObstacle 0)
		)
		(if global95
			(global95 eachElementDo: #perform readObstacle 1)
		)
	)

	(method (writeObstacles)
		(if (gCurRoom obstacles:)
			((gCurRoom obstacles:) eachElementDo: #dispose release:)
		)
		(self eachElementDo: #writeObstacle)
	)

	(method (add)
		(super add: (= curPolygon (Class_943_2 new:)))
		(return curPolygon)
	)

	(method (draw)
		(self eachElementDo: #restore)
		(self eachElementDo: #save)
		(self eachElementDo: #draw)
		(Graph grUPDATE_BOX 0 0 190 320 curMap)
	)

	(method (selectPt &tmp event)
		(self select: 487 1)
		(= event (Event new:))
		(GlobalToLocal event)
		(= x (event x:))
		(= y (event y:))
		(event dispose:)
	)

	(method (addPt)
		(self saveForUndo:)
		(if (not curPolygon)
			(self add:)
			(curPolygon add: x y 0)
		)
		(curPolygon add: x y)
	)

	(method (finishAdding &tmp node)
		(cond
			(curPolygon
				(curPolygon closed: 1)
				(if (> (curPolygon size:) 1)
					(curPolygon deletePt: (curPolygon last:) advance:)
				)
				(self draw:)
				(curPolygon getAccessType:)
			)
			((not (= node (self first:)))
				(= curPolygon 0)
			)
			(else
				(= curPolygon (NodeValue node))
				(self draw:)
			)
		)
		(if curPolygon
			(self changeState: 1)
		)
	)

	(method (movePt aX aY)
		(curPolygon startRedraw:)
		(self eachElementDo: #restore)
		(curPolygon movePt: aX aY)
		(self eachElementDo: #save)
		(self eachElementDo: #draw)
		(curPolygon endRedraw:)
	)

	(method (insertPt)
		(self eachElementDo: #restore)
		(self select: 486 0)
		(self saveForUndo:)
		(curPolygon insertPt: x y)
		(self changeState: 3)
		(self eachElementDo: #save)
		(self eachElementDo: #draw)
		(Graph grUPDATE_BOX 0 0 190 320 curMap)
	)

	(method (delete &tmp saveCur)
		(= saveCur curPolygon)
		(self advanceRetreat: 128 65)
		(if (== curPolygon saveCur)
			(= curPolygon 0)
		)
		(super delete: saveCur &rest)
		(saveCur dispose:)
	)

	(method (deletePt &tmp nextPoly)
		(self eachElementDo: #restore)
		(self select: 487 0)
		(self saveForUndo:)
		(curPolygon deletePt:)
		(if (not (curPolygon size:))
			(self delete: curPolygon)
			(if (not size)
				(self changeState: 0)
			)
		)
		(self eachElementDo: #save)
		(self eachElementDo: #draw)
		(Graph grUPDATE_BOX 0 0 190 320 curMap)
	)

	(method (select distCalc showCsr &tmp closestDist closestPoly dist poly node)
		(= closestDist 32767)
		(= closestPoly 0)
		(for ((= node (FirstNode elements))) node ((= node (NextNode node)))
			(= poly (NodeValue node))
			(if (< (= dist (poly distCalc: x y)) closestDist)
				(= closestDist dist)
				(= closestPoly poly)
			)
		)
		((= curPolygon closestPoly) setCurClosest: showCsr)
	)

	(method (advanceRetreat dir1 dir2 &tmp newNode curPolyNode)
		(= curPolyNode (FindKey elements curPolygon))
		(if
			(and
				(not (= newNode (self dir1: curPolyNode)))
				(not (= newNode (self dir2: curPolyNode)))
			)
			(= newNode curPolyNode)
		)
		(= curPolygon (NodeValue newNode))
		(curPolygon setCur: (curPolygon curNode:))
	)

	(method (saveForUndo throwAwayOld)
		(if (= undoPoly curPolygon)
			(= undoPrvPoly (self prev: undoPoly))
			(if (and (or (not argc) throwAwayOld) undoPolyBuf)
				(Memory memFREE undoPolyBuf)
			)
			(= undoPolyBuf (curPolygon saveForUndo:))
		)
		(= undoX x)
		(= undoY y)
		(= undoState state)
	)

	(method (undo &tmp event saveUndoPoly saveUndoPrvPoly saveUndoPolyBuf saveUndoX saveUndoY saveUndoState)
		(if (not undoPoly)
			(Prints {Nothing to undo})
			(return)
		)
		(= saveUndoPoly undoPoly)
		(= saveUndoPrvPoly undoPrvPoly)
		(= saveUndoPolyBuf undoPolyBuf)
		(= saveUndoX undoX)
		(= saveUndoY undoY)
		(= saveUndoState undoState)
		(self saveForUndo: 0)
		(self eachElementDo: #restore)
		(if (= curPolygon saveUndoPoly)
			(if (not (self contains: curPolygon))
				(= curPolygon (self add:))
				(if saveUndoPrvPoly
					(self addAfter: saveUndoPrvPoly curPolygon)
				else
					(self addToFront: curPolygon)
				)
			)
			(curPolygon undo: saveUndoPolyBuf)
		else
			(= curPolygon (self add:))
		)
		(Memory memFREE saveUndoPolyBuf)
		(= x saveUndoX)
		(= y saveUndoY)
		(self changeState: saveUndoState)
		(self eachElementDo: #save)
		(self eachElementDo: #draw)
		(Graph grUPDATE_BOX 0 0 190 320 curMap)
		(gGame setCursor: 999 1 x y)
	)

	(method (showMap whichMap)
		(if (== whichMap -1)
			(if (== curMap 1)
				(= whichMap 4)
			else
				(= whichMap 1)
			)
		)
		(if (!= curMap whichMap)
			(self eachElementDo: #restore)
			(= curMap whichMap)
			(self eachElementDo: #save)
			(self eachElementDo: #draw)
			(Graph grUPDATE_BOX 0 0 190 320 curMap)
		)
	)

	(method (init)
		(DrawPic (gCurRoom curPic:) 100 1)
		(if (!= gOverlays -1)
			(DrawPic gOverlays 100 0)
		)
		(gAddToPics doit:)
		(gCast eachElementDo: #stopUpd)
		(Animate (gCast elements:) 0)
		(= saveSystemWindow gSystemWindow)
		(= gSystemWindow SysWindow)
		(= curMap 1)
		(gGame setCursor: 999 1)
		(self readObstacles:)
		(self changeState: (if size 1 else 0))
		(self draw:)
	)

	(method (doit &tmp event [str 100])
		(self init:)
		(repeat
			(= event (Event new:))
			(if (not (and curMenu (curMenu handleEvent: event)))
				(GlobalToLocal event)
				(breakif (self handleEvent: event))
			)
			(event dispose:)
		)
		(event dispose:)
		(self dispose:)
	)

	(method (exit &tmp [str 100] rc file fileMode)
		(if (== state 0)
			(self finishAdding:)
		)
		(self showMap: 1)
		(if (not curPolygon)
			(return 1)
		)
		(self eachElementDo: #check)
		(if (not fileName)
			(Format @fileName 943 3 (gCurRoom curPic:)) ; "%d.pol"
		)
		(if
			(not
				(= rc
					(Print
						addTitle: {Save Polygons}
						addText: {File:}
						addEdit: @fileName 25 50 0 @fileName
						addButton: 1 { Save } 5 12
						addButton: 2 {Abandon} 70 12
						addButton: 0 {Cancel} 150 12
						init:
					)
				)
			)
			(return 0)
		)
		(if (== rc 2)
			(return 1)
		)
		(if (FileIO fiEXISTS @fileName)
			(Format @str 943 4 @fileName) ; "The file '%s' already exists"
			(if
				(not
					(= rc
						(Print
							width: 210
							addText: @str
							addButton: 1 {Replace} 5 12
							addButton: 2 {Append} 85 12
							addButton: 0 {Cancel} 150 12
							init:
						)
					)
				)
				(return 0)
			)
		)
		(= fileMode (if (== rc 1) 2 else 0))
		(if (not ((= file (File new:)) name: @fileName open: fileMode))
			(Format @str 943 5 (file name:)) ; "Error opening '%s'"
			(Prints @str)
			(file dispose:)
			(return 0)
		)
		(file writeString: (Format @str 943 6 {Polygon Editor 1.11})) ; "; %s"
		(file
			writeString:
				(Format @str 943 7 {Dynamic Obstacles} (gCurRoom curPic:)) ; "; %s : Picture %d"
		)
		(file writeString: {\t\t(curRoom addObstacle:\0d\n})
		(self eachElementDo: #writeFile file 0)
		(file writeString: {\t\t)\0d\n\0d\n})
		(file writeString: {\t\t(altPolyList add:\0d\n})
		(self eachElementDo: #writeFile file 1)
		(file writeString: {\t\t)\0d\n})
		(file dispose:)
		(return 1)
	)

	(method (dispose)
		(self writeObstacles:)
		(if curMenu
			(curMenu dispose:)
			(= curMenu 0)
		)
		(if undoPolyBuf
			(Memory memFREE undoPolyBuf)
			(= undoPolyBuf 0)
		)
		(DrawStatus { } 0 0)
		(DrawStatus 0)
		(gCast eachElementDo: #startUpd)
		(Animate (gCast elements:) 0)
		(self eachElementDo: #draw)
		(if
			(Print
				addText: {Erase polygon outlines?}
				addButton: 1 {Yes } 30 12
				addButton: 0 { No } 85 12
				init:
			)
			(DrawPic (gCurRoom curPic:) 100 1)
			(if (!= gOverlays -1)
				(DrawPic gOverlays 100 0)
			)
			(gAddToPics doit:)
		)
		(= gSystemWindow saveSystemWindow)
		(DisposeScript 993)
		(super dispose:)
		(DisposeScript 943)
	)
)

