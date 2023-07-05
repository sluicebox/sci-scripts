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

(class _EditablePolygon of List
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

	(method (getAccessType &tmp rc)
		(if
			(= rc
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
			(= type (- rc 1))
		)
	)

	(method (writeFile file whichList &tmp lineLen len pt node [str 10] frst)
		(if (== whichList srcList)
			(file
				writeString:
					{\t\t\t((Polygon new:)\r\n}
					{\t\t\t\ttype:\t\t}
					(switch type
						(0 {PTotalAccess})
						(1 {PNearestAccess})
						(2 {PBarredAccess})
						(3 {PContainedAccess})
					)
					{,\r\n}
			)
			(file writeString: {\t\t\t\tinit:\t\t})
			(= frst 1)
			(= lineLen 17)
			(for
				((= node (FirstNode elements)))
				node
				((= node (NextNode node)))
				
				(= pt (NodeValue node))
				(Format @str 943 0 (pt x:) (pt y:)) ; "%d %d"
				(if (>= (+= lineLen (= len (+ (StrLen @str) 1))) 80)
					(file writeString: {\r\n\t\t\t\t\t\t})
					(= frst 1)
					(= lineLen (+ 17 len))
				)
				(if (not frst)
					(file writeString: { })
				)
				(file writeString: @str)
				(= frst 0)
			)
			(file writeString: {,\r\n})
			(file writeString: {\t\t\t\tyourself:\r\n} {\t\t\t)\r\n})
		)
	)

	(method (check &tmp node nextNode point nextPoint angle delta firstNode totAngle firstTime lastAngle backNode backPoint savX savY lastNode cmpNode cmpPoint [buffer 40])
		(for ((= node (self first:))) node ((= node (NextNode node)))
			(= point (NodeValue node))
			(for
				((= cmpNode (NextNode node)))
				cmpNode
				((= cmpNode (NextNode cmpNode)))
				
				(= cmpPoint (NodeValue cmpNode))
				(if
					(and
						(== (point x:) (cmpPoint x:))
						(== (point y:) (cmpPoint y:))
					)
					(= cmpNode (PrevNode cmpNode))
					(self delete: cmpPoint)
					(cmpPoint dispose:)
				)
			)
		)
		(= angle 0)
		(= lastAngle 0)
		(= totAngle 0)
		(= firstTime 1)
		(for ((= node (= firstNode (self first:)))) 1 ((= node nextNode))
			(= point (NodeValue node))
			(= nextNode (self next: node))
			(= nextPoint (NodeValue nextNode))
			(= angle (ATan (point x:) (point y:) (nextPoint x:) (nextPoint y:)))
			(if (not firstTime)
				(cond
					((> (= delta (- angle lastAngle)) 180)
						(-= delta 360)
					)
					((< delta -180)
						(+= delta 360)
					)
				)
				(+= totAngle delta)
			)
			(= lastAngle angle)
			(breakif (and (== node firstNode) (not firstTime)))
			(= firstTime 0)
		)
		(if (== type 3)
			(= totAngle (- totAngle))
		)
		(cond
			((== totAngle -360)
				(= node (self first:))
				(for
					((= backNode (self last:)))
					(and (!= node backNode) (!= node (NextNode backNode)))
					((= backNode (PrevNode backNode)))
					
					(= point (NodeValue node))
					(= backPoint (NodeValue backNode))
					(= savX (point x:))
					(= savY (point y:))
					(point x: (backPoint x:))
					(point y: (backPoint y:))
					(backPoint x: savX)
					(backPoint y: savY)
					(= node (NextNode node))
				)
			)
			((!= totAngle 360)
				(Format @buffer 943 1 name totAngle) ; "Error in (%s check:) totAngle [%d] != +-360"
				(Prints @buffer)
			)
		)
	)

	(method (writeObstacle &tmp cp buf node pt newPoly)
		(= buf (Memory memALLOC_NONCRIT (* size 4)))
		(= node (FirstNode elements))
		(for ((= cp buf)) node ((+= cp 4))
			(= pt (NodeValue node))
			(Memory memPOKE cp (pt x:))
			(Memory memPOKE (+ cp 2) (pt y:))
			(= node (NextNode node))
		)
		(if (== srcList 1)
			(global95
				add:
					((Polygon new:)
						type: type
						points: buf
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
						points: buf
						size: size
						dynamic: 1
						yourself:
					)
			)
		)
	)

	(method (movePt aX aY)
		(curPt x: aX y: aY)
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

	(method (add aX aY displayCursor)
		(super
			add: (= curPt ((_EditablePoint new:) x: aX y: aY yourself:))
		)
		(self setCur: (FindKey elements curPt) displayCursor)
	)

	(method (advance &tmp node)
		(self setCur: (self next: curNode))
	)

	(method (retreat &tmp node)
		(self setCur: (self prev: curNode))
	)

	(method (setCur node displayCursor)
		(if (= curNode node)
			(= curPt (NodeValue curNode))
			(if (or (< argc 2) displayCursor)
				(gGame setCursor: 999 1 (curPt x:) (curPt y:))
			)
		)
	)

	(method (setCurClosest showCsr)
		(self setCur: (FindKey elements closestPt) showCsr)
	)

	(method (startRedraw &tmp nextNode prevNode lastNode nextPt prevPt)
		(if (= nextNode (self next: curNode))
			(= nextPt (NodeValue nextNode))
		else
			(= nextPt curPt)
		)
		(if (= prevNode (self prev: curNode))
			(= prevPt (NodeValue prevNode))
		else
			(= prevPt curPt)
		)
		(FindBoundingRect
			(prevPt x:)
			(prevPt y:)
			(curPt x:)
			(curPt y:)
			(nextPt x:)
			(nextPt y:)
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

	(method (getDistToPt aX aY &tmp lastNode node pt dist closestDist)
		(= closestDist 32767)
		(= node (self first:))
		(= lastNode (self last:))
		(while 1
			(= pt (NodeValue node))
			(if
				(<
					(= dist (GetDistance aX aY (pt x:) (pt y:)))
					closestDist
				)
				(= closestDist dist)
				(= closestPt pt)
			)
			(breakif (== node lastNode))
			(= node (self next: node))
		)
		(return closestDist)
	)

	(method (getDistToLine aX aY &tmp lastNode node pt dist closestDist nextPt nextNode)
		(if (< size 2)
			(return (self getDistToPt: aX aY &rest))
		)
		(= closestDist 32767)
		(= node (self first:))
		(= lastNode (self last:))
		(while 1
			(= pt (NodeValue node))
			(= nextNode (self next: node))
			(= nextPt (NodeValue nextNode))
			(if
				(<
					(= dist
						(LineDist
							(pt x:)
							(pt y:)
							(nextPt x:)
							(nextPt y:)
							aX
							aY
						)
					)
					closestDist
				)
				(= closestDist dist)
				(= closestPt pt)
			)
			(breakif (== node lastNode))
			(= node nextNode)
		)
		(return closestDist)
	)

	(method (insertPt aX aY &tmp newPt)
		(= newPt ((_EditablePoint new:) x: aX y: aY yourself:))
		(self addAfter: closestPt newPt)
		(self setCur: (FindKey elements newPt))
	)

	(method (eachLineDo doWhat &tmp node nextNode obj nextObj lastNode)
		(= node (self first:))
		(= lastNode (self last:))
		(while (or (!= node lastNode) closed)
			(= nextNode (self next: node))
			(= obj (NodeValue node))
			(= nextObj (NodeValue nextNode))
			(obj doWhat: nextObj &rest)
			(breakif (== node lastNode))
			(= node nextNode)
		)
	)

	(method (deletePt &tmp newCur)
		(if (== curNode (= newCur (self prev: curNode)))
			(= newCur 0)
		)
		(self delete: curPt)
		(curPt dispose:)
		(self setCur: newCur)
	)

	(method (next node &tmp retNode)
		(= retNode (super next: node))
		(if (and closed (not retNode))
			(return (super first:))
		)
		(return retNode)
	)

	(method (prev node &tmp retNode)
		(= retNode (super prev: node))
		(if (and closed (not retNode))
			(return (super last:))
		)
		(return retNode)
	)

	(method (saveForUndo &tmp undoBuffer cp node pt)
		(= cp (= undoBuffer (Memory memALLOC_NONCRIT (* 2 (+ (* 2 size) 3)))))
		(Memory memPOKE cp closed)
		(+= cp 2)
		(Memory memPOKE cp size)
		(+= cp 2)
		(Memory memPOKE cp (self indexOf: curPt))
		(+= cp 2)
		(= node (self first:))
		(while node
			(= pt (NodeValue node))
			(Memory memPOKE cp (pt x:))
			(Memory memPOKE (+= cp 2) (pt y:))
			(= node (NextNode node))
			(+= cp 2)
		)
		(return undoBuffer)
	)

	(method (undo undoBuffer &tmp lastUndoBuffer aSize i curPtNum)
		(self eachElementDo: #dispose release:)
		(= closed (Memory memPEEK undoBuffer))
		(+= undoBuffer 2)
		(= aSize (Memory memPEEK undoBuffer))
		(+= undoBuffer 2)
		(= curPtNum (Memory memPEEK undoBuffer))
		(+= undoBuffer 2)
		(= i 0)
		(while (< i aSize)
			(self add: (Memory memPEEK undoBuffer) (Memory memPEEK (+= undoBuffer 2)) 0)
			(++ i)
			(+= undoBuffer 2)
		)
		(self setCur: (FindKey elements (self at: curPtNum)) 0)
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
							(self advanceRetreat: 65 126)
						)
					)
					(KEY_SHIFTTAB
						(if (and (== state 1) curPolygon)
							(self advanceRetreat: 130 129)
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
									{           CREATING POLYGON\r\n\r\nClick to create each corner of the polygon, then choose Done from the menu to finish.  You can also press Esc or Ctrl-click to finish.\r\n\r\nTo UNDO a corner, choose Undo.\r\n\r\nTo change MAP displayed (visual or control), choose Map.\r\n\r\nTo EXIT the Polygon Editor, choose eXit or press Ctrl-S.}
									0
								)
							)
							(1
								(DoPrint
									{             EDITING POLYGON\r\n\r\nTo MOVE a corner, click on it and drag it to the new position.\r\nTo INSERT a new corner, Ctrl-click to create it, then drag it to the correct position.\r\nTo DELETE a corner, Shift-click on it.\r\nTo UNDO an action, choose Undo from the menu.\r\nTo CREATE a new polygon, choose Create.\r\nTo change a polygon's TYPE (Total, Near or Barred), choose Type.\r\nTo change MAP displayed (visual or control), choose Map.\r\nTo EXIT the Polygon Editor, choose eXit or press Ctrl-S.\r\n\r\nIn addition to using the mouse, you can use Space and BackSpace to select corners and Tab and BackTab to select polygons. }
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
							{ by\r\n\r\nMark Wilden\r\n\r\nOriginal program by Chad Bye }
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
		(super add: (= curPolygon (_EditablePolygon new:)))
		(return curPolygon)
	)

	(method (draw)
		(self eachElementDo: #restore)
		(self eachElementDo: #save)
		(self eachElementDo: #draw)
		(Graph grUPDATE_BOX 0 0 190 320 curMap)
	)

	(method (selectPt &tmp event)
		(self select: 486 1)
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
		(self select: 485 0)
		(self saveForUndo:)
		(curPolygon insertPt: x y)
		(self changeState: 3)
		(self eachElementDo: #save)
		(self eachElementDo: #draw)
		(Graph grUPDATE_BOX 0 0 190 320 curMap)
	)

	(method (delete &tmp saveCur)
		(= saveCur curPolygon)
		(self advanceRetreat: 130 65)
		(if (== curPolygon saveCur)
			(= curPolygon 0)
		)
		(super delete: saveCur &rest)
		(saveCur dispose:)
	)

	(method (deletePt &tmp nextPoly)
		(self eachElementDo: #restore)
		(self select: 486 0)
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
		(file writeString: {\t\t(curRoom addObstacle:\r\n})
		(self eachElementDo: #writeFile file 0)
		(file writeString: {\t\t)\r\n\r\n})
		(file writeString: {\t\t(altPolyList add:\r\n})
		(self eachElementDo: #writeFile file 1)
		(file writeString: {\t\t)\r\n})
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

