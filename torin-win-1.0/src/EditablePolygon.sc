;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64013)
(include sci.sh)
(use Main)
(use DText)
(use Str)
(use Array)
(use Print)
(use Polygon)
(use System)

(local
	polyEditor
	tmpStr
	tmpDlg
	displayOnly
	polyCenterX
	polyCenterY
)

(class EditablePolygon of Polygon
	(properties
		currentX 0
		currentY 0
		shortestDistance 0
		lines 0
	)

	(method (setPoint index x y &tmp xIndex)
		(points at: (= xIndex (* index 2)) x)
		(points at: (+ xIndex 1) y)
	)

	(method (indexToCoor index &tmp xIndex)
		(= currentX (points at: (= xIndex (* index 2))))
		(= currentY (points at: (+ xIndex 1)))
		(if 0
			(Printf
				{indexToCoor - index : %d x : %d y: %d}
				index
				currentX
				currentY
			)
		)
	)

	(method (addPoint)
		(self insertPoint: size &rest)
	)

	(method (findClosestPoint xLoc yLoc &tmp index distance indexOfShortest)
		(if (not size)
			(return)
		)
		(= shortestDistance 32767)
		(for ((= index 0)) (< index size) ((++ index))
			(self indexToCoor: index)
			(if
				(<
					(= distance (GetDistance currentX currentY xLoc yLoc))
					shortestDistance
				)
				(if 0
					(Printf
						{Finding closest point for %d,%d. New shortest : %d}
						xLoc
						yLoc
						distance
					)
				)
				(= indexOfShortest index)
				(= shortestDistance distance)
			)
		)
		(if 0
			(Printf {Returning nearest index : %d} indexOfShortest)
		)
		(return indexOfShortest)
	)

	(method (distanceTo index xLoc yLoc)
		(self indexToCoor: index)
		(GetDistance currentX currentY xLoc yLoc)
	)

	(method (insertPoint index xLoc yLoc update &tmp newArray)
		(= newArray (IntArray copy: points))
		(*= index 2)
		(newArray copyToFrom: (+ index 2) points index (- (points size:) index))
		(newArray at: index xLoc yLoc)
		(points copy: newArray)
		(++ size)
		(newArray dispose:)
		(if (and lines (> argc 3) update)
			(self hide: 1 show: update &rest)
		)
	)

	(method (deletePoint index update &tmp newArray)
		(= newArray (IntArray new:))
		(*= index 2)
		(newArray
			copyToFrom: 0 points 0 (Max 0 index)
			copyToFrom:
				index
				points
				(+ index 2)
				(- (points size:) (+ index 2))
		)
		(points copy: newArray)
		(-- size)
		(newArray dispose:)
		(if (and lines (> argc 1) update)
			(self hide: 1)
			(self show: update &rest)
		)
	)

	(method (showSelf &tmp loopIt theStr strAdd1)
		(= theStr (Str new:))
		(= strAdd1 (Str new:))
		(for ((= loopIt 0)) (< loopIt size) ((++ loopIt))
			(self indexToCoor: loopIt)
			(strAdd1 format: {%d } currentX)
			(theStr cat: strAdd1)
			(strAdd1 format: {%d } currentY)
			(theStr cat: strAdd1)
		)
		(Printf {%s} (theStr data:))
		(theStr dispose:)
		(strAdd1 dispose:)
	)

	(method (findPoint xLoc yLoc &tmp theIndex loopInd)
		(= theIndex -1)
		(for ((= loopInd 0)) (< loopInd size) ((++ loopInd))
			(self indexToCoor: loopInd)
			(if (and (== currentX xLoc) (== currentY yLoc))
				(= theIndex loopInd)
			)
		)
		(return theIndex)
	)

	(method (show dontUpdate skipLast &tmp loopInd firstX firstY prevX prevY curInd)
		(if lines
			(self hide:)
		)
		(= lines (Set new:))
		(self indexToCoor: (= curInd 0))
		(= prevX (= firstX currentX))
		(for
			((= prevY (= firstY currentY)))
			(< (++ curInd) size)
			((= prevY currentY))
			
			(self indexToCoor: curInd)
			(lines
				add:
					(AddLine
						(polyEditor plane:)
						prevX
						prevY
						currentX
						currentY
						1000
						(+ 10 (polyEditor lineColor:))
						0
						0
						1
					)
			)
			(= prevX currentX)
		)
		(if (or (< argc 2) (not skipLast))
			(lines
				add:
					(AddLine
						(polyEditor plane:)
						firstX
						firstY
						prevX
						prevY
						1000
						(+ 10 (polyEditor lineColor:))
						0
						0
						1
					)
			)
		)
		(if (or (not argc) (not dontUpdate))
			(FrameOut)
		)
	)

	(method (hide dontUpdate &tmp curInd theLine)
		(if (not lines)
			(return)
		)
		(while (lines size:)
			(DeleteLine (= theLine (lines at: 0)) (polyEditor plane:))
			(lines delete: theLine)
		)
		(if (or (not argc) (not dontUpdate))
			(FrameOut)
		)
	)

	(method (dragPoint index &tmp event line1 line2 org1x org1y org2x org2y theInd dragX dragY pPlane ex ey eColor)
		(if (== index 0)
			(= theInd (- (lines size:) 1))
			(= line1 (lines at: theInd))
			(self indexToCoor: theInd)
			(= org1x currentX)
			(= org1y currentY)
		else
			(= theInd (- index 1))
			(= line1 (lines at: theInd))
			(self indexToCoor: theInd)
			(= org1x currentX)
			(= org1y currentY)
		)
		(= line2 (lines at: index))
		(if (== index (- (lines size:) 1))
			(= theInd 0)
		else
			(= theInd (+ index 1))
		)
		(self indexToCoor: theInd)
		(= org2x currentX)
		(= org2y currentY)
		(= dragX 0)
		(= dragY 0)
		(= pPlane (polyEditor plane:))
		(= eColor (polyEditor lineColor:))
		(while (not (& ((= event ((gUser curEvent:) new:)) type:) $0002))
			(event localize: pPlane)
			(= ex (event x:))
			(= ey (event y:))
			(if (or (!= dragX ex) (!= dragY ey))
				(UpdateLine
					line1
					pPlane
					org1x
					org1y
					ex
					ey
					1000
					eColor
					0
					0
					1
				)
				(UpdateLine
					line2
					pPlane
					org2x
					org2y
					ex
					ey
					1000
					eColor
					0
					0
					1
				)
				(= dragX ex)
				(= dragY ey)
				(FrameOut)
			)
		)
		(event localize: pPlane)
		(UpdateLine
			line1
			pPlane
			org1x
			org1y
			(event x:)
			(event y:)
			1000
			eColor
			0
			0
			1
		)
		(UpdateLine
			line2
			pPlane
			org2x
			org2y
			(event x:)
			(event y:)
			1000
			eColor
			0
			0
			1
		)
		(self setPoint: index (event x:) (event y:))
		(FrameOut)
	)

	(method (addLine theLine)
		(if (not lines)
			(= lines (Set new:))
		)
		(lines add: theLine)
	)

	(method (writeToFile theFile showName &tmp aStr index len)
		(if (and (> argc 1) showName)
			(theFile
				writeString: {\0d\n\t\t\t; *** }
				writeString: (self name:)
				writeString: { ***\0d\n}
			)
		)
		(theFile writeString: {\t\t\t((Polygon new:)\0d\n\t\t\t\ttype: })
		(= aStr
			(Str
				with:
					(switch type
						(0 {PTotal})
						(1 {PNearest})
						(3 {PContained})
						(2 {PBarred})
					)
			)
		)
		(aStr cat: {Access,\0d\n\t\t\t\tinit: })
		(theFile writeString: aStr)
		(aStr with: {})
		(= len 0)
		(for ((= index 0)) (< index size) ((++ index))
			(self indexToCoor: index)
			(aStr format: {%d %d} currentX currentY)
			(+= len (aStr size:))
			(theFile writeString: aStr)
			(cond
				((> len 49)
					(= len 0)
					(theFile writeString: {\0d\n\t\t\t\t\t\t})
				)
				((< (+ index 1) size)
					(theFile writeString: { })
				)
			)
		)
		(theFile writeString: {,\0d\n\t\t\t\tyourself:\0d\n\t\t\t)\0d\n})
		(aStr dispose:)
	)

	(method (dispose)
		(if (and (not displayOnly) lines)
			(self hide:)
		)
		(super dispose:)
	)
)

(class PEditor of Set
	(properties
		polygons 0
		focus 0
		currentPolygon 0
		currentIndex 0
		currentX 0
		currentY 0
		depressType 0
		lineColor 0
		mode 0
		finished 0
		plane 0
	)

	(method (init initMode aPlane &tmp evt)
		(= lineColor 210)
		(= displayOnly 1)
		(= plane aPlane)
		(= evt (Event new:))
		(evt x: 4)
		(evt y: 4)
		(evt localize: aPlane)
		(= polyCenterX (evt x:))
		(= polyCenterY (evt y:))
		(evt dispose:)
		(if (and argc initMode)
			(= mode 0)
			(= tmpStr (Str format: {Create Mode}))
		else
			(= mode 1)
			(= tmpStr (Str format: {Edit Mode}))
		)
		((= tmpDlg (DText new:))
			text: (KString 8 (tmpStr data:)) ; StrDup
			fore: 235
			back: 227
			skip: 0
			posn: polyCenterX polyCenterY
			setSize: 240
			setPri: 1000
			init: (plane getMainCast:)
		)
		(super init: (plane getMainCast:))
		(= polyEditor self)
		(= finished 0)
	)

	(method (show)
		(if (self size:)
			(self eachElementDo: #show &rest)
		)
		(FrameOut)
	)

	(method (hide)
		(if (self size:)
			(self eachElementDo: #hide &rest)
		)
	)

	(method (dropAnchor xLoc yLoc &tmp event theLine)
		(= theLine
			(AddLine plane xLoc yLoc xLoc yLoc 1000 lineColor 0 0 1)
		)
		(FrameOut)
		(= currentX xLoc)
		(= currentY yLoc)
		(while (!= ((= event ((gUser curEvent:) new:)) type:) 1)
			(event localize: plane)
			(if (or (!= (event x:) currentX) (!= (event y:) currentY))
				(UpdateLine
					theLine
					plane
					xLoc
					yLoc
					(event x:)
					(event y:)
					1000
					lineColor
					0
					0
					1
				)
			)
			(= currentX (event x:))
			(= currentY (event y:))
			(FrameOut)
		)
		(if (= depressType (event modifiers:))
			(DeleteLine theLine plane)
			(= theLine 0)
		else
			(event localize: plane)
			(UpdateLine
				theLine
				plane
				xLoc
				yLoc
				currentX
				currentY
				1000
				lineColor
				0
				0
				1
			)
		)
		(return theLine)
	)

	(method (addPolygon argOrP)
		(cond
			((> argc 1)
				(self
					add: ((EditablePolygon new:) init: argOrP &rest yourself:)
				)
			)
			((argOrP isKindOf: EditablePolygon)
				(self add: argOrP)
			)
			(else
				(self
					add:
						((EditablePolygon new:)
							size: (argOrP size:)
							type: (argOrP type:)
							points: (IntArray copy: (argOrP points:))
							dynamic: 1
							yourself:
						)
				)
			)
		)
	)

	(method (readPolygonsFromList theList &tmp loop saveCursor)
		(= saveCursor gTheCursor)
		(gGame setCursor: gWaitCursor)
		(for ((= loop 0)) (< loop (theList size:)) ((++ loop))
			(self addPolygon: (theList at: loop))
		)
		(self show: 1)
		(FrameOut)
		(gGame setCursor: saveCursor)
	)

	(method (findClosestPoint x y &tmp theIndex workingPoly distance closestDistance node)
		(= currentPolygon (= currentIndex 0))
		(if (not (self size:))
			(return)
		)
		(= closestDistance 32767)
		(for ((= node (KList 3 elements))) node ((= node nextNode)) ; FirstNode
			(= nextNode (KList 6 node)) ; NextNode
			(= workingPoly (KList 8 node)) ; NodeValue
			(= theIndex (workingPoly findClosestPoint: x y))
			(if (< (= distance (workingPoly shortestDistance:)) closestDistance)
				(= currentPolygon workingPoly)
				(= currentIndex theIndex)
				(= closestDistance distance)
			)
		)
	)

	(method (constructPolygon xLoc yLoc &tmp doneCreating event endX endY theLine theType obj dftObj nPoint)
		(= doneCreating 0)
		(= currentX xLoc)
		(= currentY yLoc)
		(= depressType 0)
		(= currentPolygon ((EditablePolygon new:) init: yourself:))
		(if scratch
			(= obj (Str new: 13))
			(= dftObj (Str newWith: 13 {default}))
			(Print addTitle: {Feature Name:} addEdit: obj 12 0 0 dftObj init:)
			(FrameOut)
			(currentPolygon name: (obj data:) type: 0)
			(dftObj dispose:)
		)
		(currentPolygon addPoint: xLoc yLoc)
		(while (not depressType)
			(= endX currentX)
			(= endY currentY)
			(if (= theLine (self dropAnchor: currentX currentY))
				(currentPolygon addPoint: currentX currentY addLine: theLine)
			)
			(if (and (== depressType 3) (> (currentPolygon size:) 0))
				(= nPoint (- (currentPolygon size:) 1))
				(currentPolygon deletePoint: nPoint 1 1)
				(currentPolygon indexToCoor: (- nPoint 1))
				(= currentX (currentPolygon currentX:))
				(= currentY (currentPolygon currentY:))
				(= endX currentX)
				(= endY currentY)
				(= depressType 0)
			)
		)
		(if (> (currentPolygon size:) 2)
			(currentPolygon
				addLine:
					(AddLine
						plane
						xLoc
						yLoc
						endX
						endY
						1000
						lineColor
						0
						0
						1
					)
			)
			(self add: currentPolygon)
			(FrameOut)
			(if
				(and
					(not scratch)
					(= theType
						(Print
							addTitle: {Polygon access type}
							addButton: 1 {Total} 0 0
							addButton: 2 { Near } 60 0
							addButton: 3 { Barred } 120 0
							addButton: 4 { Container } 195 0
							init:
						)
					)
				)
				(currentPolygon type: (- theType 1))
				(switch theType
					(4
						(if (!= -1 (TestPoly currentPolygon))
							(PrintDebug {Container polygon must be CCW})
						)
					)
					(else
						(if (!= 1 (TestPoly currentPolygon))
							(PrintDebug {Non container polygon must be CW})
						)
					)
				)
			)
		else
			(currentPolygon dispose:)
			(= currentPolygon 0)
		)
		(FrameOut)
	)

	(method (doit &tmp event saveCursor)
		(= saveCursor gTheCursor)
		(gGame setCursor: gNormalCursor)
		(while (not finished)
			(= event ((gUser curEvent:) new:))
			(self handleEvent: event)
		)
		(gGame setCursor: saveCursor)
	)

	(method (handleEvent event &tmp addIndex lInd gInd lDist gDist)
		(if (& (event type:) evKEYBOARD)
			(switch (event message:)
				(KEY_SPACE
					(= displayOnly 0)
					(if (and (== mode 0) (self size:))
						(= tmpStr (Str format: {Edit Mode}))
						(= mode 1)
					else
						(= tmpStr (Str format: {Create Mode}))
						(= mode 0)
					)
				)
				(KEY_ESCAPE
					(= finished 1)
				)
			)
			(tmpDlg dispose:)
			((= tmpDlg (DText new:))
				text: (KString 8 (tmpStr data:)) ; StrDup
				fore: 235
				back: 227
				skip: 0
				posn: polyCenterX polyCenterY
				setSize: 240
				setPri: 1000
				init: (plane getMainCast:)
			)
			(FrameOut)
		)
		(switch mode
			(0
				(if (and (& (event type:) evMOUSEBUTTON) (not (event modifiers:)))
					(event localize: plane)
					(self constructPolygon: (event x:) (event y:))
				)
			)
			(1
				(if (and (& (event type:) evMOUSEBUTTON) (self size:))
					(= displayOnly 0)
					(cond
						((not (event modifiers:))
							(event localize: plane)
							(self findClosestPoint: (event x:) (event y:))
							(currentPolygon dragPoint: currentIndex)
						)
						((& (event modifiers:) emSHIFT)
							(event localize: plane)
							(self findClosestPoint: (event x:) (event y:))
							(currentPolygon deletePoint: currentIndex 1)
							(if (<= (currentPolygon size:) 2)
								(self delete: currentPolygon)
								(currentPolygon dispose:)
							)
						)
						((& (event modifiers:) emCTRL)
							(event localize: plane)
							(self findClosestPoint: (event x:) (event y:))
							(= addIndex currentIndex)
							(if (< (= lInd (- currentIndex 1)) 0)
								(= lInd (- (currentPolygon size:) 1))
							)
							(if
								(>=
									(= gInd (+ currentIndex 1))
									(currentPolygon size:)
								)
								(= gInd 0)
							)
							(= lDist
								(currentPolygon
									distanceTo: lInd (event x:) (event y:)
								)
							)
							(= gDist
								(currentPolygon
									distanceTo: gInd (event x:) (event y:)
								)
							)
							(currentPolygon
								insertPoint:
									(if (> lDist gDist) lInd else currentIndex)
									(event x:)
									(event y:)
									1
							)
						)
					)
				)
			)
		)
	)

	(method (dispose &tmp saveCursor)
		(tmpDlg dispose:)
		(tmpStr dispose:)
		(= saveCursor gTheCursor)
		(gGame setCursor: gWaitCursor)
		(if (not displayOnly)
			(self hide: 1)
		)
		(FrameOut)
		(gGame setCursor: saveCursor)
		(super dispose:)
	)
)

