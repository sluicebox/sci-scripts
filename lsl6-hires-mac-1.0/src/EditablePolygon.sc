;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 202)
(include sci.sh)
(use Main)
(use Str)
(use Array)
(use Print)
(use Polygon)
(use User)
(use System)

(local
	local0
)

(class EditablePolygon of Polygon
	(properties
		currentX 0
		currentY 0
		shortestDistance 0
		lines 0
	)

	(method (setPoint param1 param2 param3 &tmp temp0)
		(points at: (= temp0 (* param1 2)) param2)
		(points at: (+ temp0 1) param3)
	)

	(method (indexToCoor param1 &tmp temp0)
		(= currentX (points at: (= temp0 (* param1 2))))
		(= currentY (points at: (+ temp0 1)))
		(if 0
			(Printf
				{indexToCoor - index : %d x : %d y: %d}
				param1
				currentX
				currentY
			)
		)
	)

	(method (addPoint)
		(self insertPoint: size &rest)
	)

	(method (findClosestPoint param1 param2 &tmp temp0 temp1 temp2)
		(if (not size)
			(return)
		)
		(= shortestDistance 32767)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(self indexToCoor: temp0)
			(if
				(<
					(= temp1 (GetDistance currentX currentY param1 param2))
					shortestDistance
				)
				(if 0
					(Printf
						{Finding closest point for %d,%d. New shortest : %d}
						param1
						param2
						temp1
					)
				)
				(= temp2 temp0)
				(= shortestDistance temp1)
			)
		)
		(if 0
			(Printf {Returning nearest index : %d} temp2)
		)
		(return temp2)
	)

	(method (distanceTo param1 param2 param3)
		(self indexToCoor: param1)
		(GetDistance currentX currentY param2 param3)
	)

	(method (insertPoint param1 param2 param3 param4 &tmp temp0)
		(= temp0 (IntArray copy: points))
		(*= param1 2)
		(temp0 copyToFrom: (+ param1 2) points param1 (- (points size:) param1))
		(temp0 at: param1 param2 param3)
		(points copy: temp0)
		(++ size)
		(temp0 dispose:)
		(if (and lines (> argc 3) param4)
			(self hide: show:)
		)
	)

	(method (deletePoint param1 param2 &tmp temp0)
		(= temp0 (IntArray new:))
		(*= param1 2)
		(temp0
			copyToFrom: 0 points 0 (Max 0 (- param1 1))
			copyToFrom:
				param1
				points
				(+ param1 2)
				(- (points size:) (+ param1 2))
		)
		(points copy: temp0)
		(-- size)
		(temp0 dispose:)
		(if (and lines (> argc 1) param2)
			(self hide: show:)
		)
	)

	(method (findPoint param1 param2 &tmp temp0 temp1)
		(= temp0 -1)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(self indexToCoor: temp1)
			(if (and (== currentX param1) (== currentY param2))
				(= temp0 temp1)
			)
		)
		(return temp0)
	)

	(method (show param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if lines
			(self hide:)
		)
		(= lines (Set new:))
		(self indexToCoor: (= temp5 0))
		(= temp3 (= temp1 currentX))
		(for
			((= temp4 (= temp2 currentY)))
			(< (++ temp5) size)
			((= temp4 currentY))
			
			(self indexToCoor: temp5)
			(lines
				add:
					(AddLine
						(local0 plane:)
						temp3
						temp4
						currentX
						currentY
						200
						(local0 lineColor:)
						0
						0
						1
					)
			)
			(= temp3 currentX)
		)
		(lines
			add:
				(AddLine
					(local0 plane:)
					temp1
					temp2
					temp3
					temp4
					200
					(local0 lineColor:)
					0
					0
					1
				)
		)
		(if (or (not argc) (not param1))
			(FrameOut)
		)
	)

	(method (hide param1 &tmp temp0 temp1)
		(if (not lines)
			(return)
		)
		(while (lines size:)
			(DeleteLine (= temp1 (lines at: 0)) (local0 plane:))
			(lines delete: temp1)
		)
		(if (or (not argc) (not param1))
			(FrameOut)
		)
	)

	(method (dragPoint param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(if (== param1 0)
			(= temp7 (- (lines size:) 1))
			(= temp1 (lines at: temp7))
			(self indexToCoor: temp7)
			(= temp3 currentX)
			(= temp4 currentY)
		else
			(= temp7 (- param1 1))
			(= temp1 (lines at: temp7))
			(self indexToCoor: temp7)
			(= temp3 currentX)
			(= temp4 currentY)
		)
		(= temp2 (lines at: param1))
		(if (== param1 (- (lines size:) 1))
			(= temp7 0)
		else
			(= temp7 (+ param1 1))
		)
		(self indexToCoor: temp7)
		(= temp5 currentX)
		(= temp6 currentY)
		(= temp8 0)
		(= temp9 0)
		(= temp10 (local0 plane:))
		(= temp13 (local0 editColor:))
		(while (not (& ((= temp0 ((User curEvent:) new:)) type:) $0002))
			(temp0 localize: temp10)
			(= temp11 (temp0 x:))
			(= temp12 (temp0 y:))
			(if (or (!= temp8 temp11) (!= temp9 temp12))
				(UpdateLine
					temp1
					temp10
					temp3
					temp4
					temp11
					temp12
					200
					temp13
					0
					0
					1
				)
				(UpdateLine
					temp2
					temp10
					temp5
					temp6
					temp11
					temp12
					200
					temp13
					0
					0
					1
				)
				(= temp8 temp11)
				(= temp9 temp12)
				(FrameOut)
			)
		)
		(temp0 localize: temp10)
		(UpdateLine
			temp1
			temp10
			temp3
			temp4
			(temp0 x:)
			(temp0 y:)
			200
			(local0 lineColor:)
			0
			0
			1
		)
		(UpdateLine
			temp2
			temp10
			temp5
			temp6
			(temp0 x:)
			(temp0 y:)
			200
			(local0 lineColor:)
			0
			0
			1
		)
		(self setPoint: param1 (temp0 x:) (temp0 y:))
		(FrameOut)
	)

	(method (addLine param1)
		(if (not lines)
			(= lines (Set new:))
		)
		(lines add: param1)
	)

	(method (writeToFile param1 param2 &tmp temp0 temp1 temp2)
		(if (and (> argc 1) param2)
			(param1
				writeString: {\0d\n}
				writeString: (self name:)
				writeString: {\0d\n}
			)
		)
		(param1 writeString: {\t\t\t((Polygon new:)\0d\n\t\t\t\ttype: })
		(= temp0
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
		(temp0 cat: {Access,\0d\n\t\t\t\tinit: })
		(param1 writeString: temp0)
		(temp0 with: {})
		(= temp2 0)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(self indexToCoor: temp1)
			(temp0 format: {%d %d } currentX currentY)
			(+= temp2 (temp0 size:))
			(param1 writeString: temp0)
			(if (> temp2 48)
				(= temp2 0)
				(param1 writeString: {\0d\n\t\t\t\t\t})
			)
		)
		(param1 writeString: {\0d\n\t\t\t)\0d\n})
		(temp0 dispose:)
	)

	(method (dispose)
		(if lines
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
		editColor 50
		lineColor 255
		mode 0
		finished 0
		plane 0
	)

	(method (init)
		(super init: &rest)
		(= plane (gCast plane:))
		(= local0 self)
		(= finished 0)
		(= mode 1)
	)

	(method (show)
		(if (self size:)
			(self eachElementDo: #show &rest)
		)
	)

	(method (hide)
		(if (self size:)
			(self eachElementDo: #hide &rest)
		)
	)

	(method (dropAnchor param1 param2 &tmp temp0 temp1)
		(= temp1
			(AddLine plane param1 param2 param1 param2 200 editColor 0 0 1)
		)
		(FrameOut)
		(= currentX param1)
		(= currentY param2)
		(while (!= ((= temp0 ((User curEvent:) new:)) type:) 1)
			(temp0 localize: plane)
			(if (or (!= (temp0 x:) currentX) (!= (temp0 y:) currentY))
				(UpdateLine
					temp1
					plane
					param1
					param2
					(temp0 x:)
					(temp0 y:)
					200
					editColor
					0
					0
					1
				)
			)
			(= currentX (temp0 x:))
			(= currentY (temp0 y:))
			(FrameOut)
		)
		(if (= depressType (temp0 modifiers:))
			(DeleteLine temp1 plane)
			(= temp1 0)
		else
			(temp0 localize: plane)
			(UpdateLine
				temp1
				plane
				param1
				param2
				currentX
				currentY
				200
				lineColor
				0
				0
				1
			)
		)
		(return temp1)
	)

	(method (addPolygon param1)
		(cond
			((> argc 1)
				(self
					add: ((EditablePolygon new:) init: param1 &rest yourself:)
				)
			)
			((param1 isKindOf: EditablePolygon)
				(self add: param1)
			)
			(else
				(self
					add:
						((EditablePolygon new:)
							size: (param1 size:)
							type: (param1 type:)
							points: (IntArray copy: (param1 points:))
							dynamic: 1
							yourself:
						)
				)
			)
		)
	)

	(method (readPolygonsFromList param1 &tmp temp0 temp1)
		(= temp1 gTheCursor)
		(gGame setCursor: gWaitCursor)
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(self addPolygon: (param1 at: temp0))
		)
		(self show: 1)
		(FrameOut)
		(gGame setCursor: temp1)
	)

	(method (findClosestPoint param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(= currentPolygon (= currentIndex 0))
		(if (not (self size:))
			(return)
		)
		(= temp3 32767)
		(for ((= temp4 (FirstNode elements))) temp4 ((= temp4 nextNode))
			(= nextNode (NextNode temp4))
			(= temp1 (NodeValue temp4))
			(= temp0 (temp1 findClosestPoint: param1 param2))
			(if (< (= temp2 (temp1 shortestDistance:)) temp3)
				(= currentPolygon temp1)
				(= currentIndex temp0)
				(= temp3 temp2)
			)
		)
	)

	(method (constructPolygon param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 0)
		(= currentX param1)
		(= currentY param2)
		(= depressType 0)
		(= currentPolygon ((EditablePolygon new:) init: yourself:))
		(currentPolygon addPoint: param1 param2)
		(while (not depressType)
			(= temp2 currentX)
			(= temp3 currentY)
			(if (= temp4 (self dropAnchor: currentX currentY))
				(currentPolygon addPoint: currentX currentY addLine: temp4)
			)
		)
		(if (> (currentPolygon size:) 2)
			(currentPolygon
				addLine:
					(AddLine
						plane
						param1
						param2
						temp2
						temp3
						200
						lineColor
						0
						0
						1
					)
				addPoint: temp2 temp3
			)
			(self add: currentPolygon)
		else
			(currentPolygon dispose:)
			(= currentPolygon 0)
		)
		(FrameOut)
	)

	(method (doit &tmp temp0 temp1)
		(= temp1 gTheCursor)
		(gGame setCursor: gNormalCursor)
		(while (not finished)
			(= temp0 ((User curEvent:) new:))
			(self handleEvent: temp0)
		)
		(gGame setCursor: temp1)
	)

	(method (handleEvent event)
		(if (& (event type:) evKEYBOARD)
			(switch (event message:)
				(KEY_SPACE
					(if (and (== mode 0) (self size:))
						(= mode 1)
					else
						(= mode 0)
					)
				)
				(KEY_ESCAPE
					(= finished 1)
				)
			)
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
							(if (<= (currentPolygon size:) 1)
								(self delete: currentPolygon)
								(currentPolygon dispose:)
							)
						)
						((& (event modifiers:) emCTRL)
							(event localize: plane)
							(self findClosestPoint: (event x:) (event y:))
							(currentPolygon
								insertPoint:
									currentIndex
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

	(method (dispose &tmp temp0)
		(= temp0 gTheCursor)
		(gGame setCursor: gWaitCursor)
		(self hide: 1)
		(FrameOut)
		(gGame setCursor: temp0)
		(super dispose:)
	)
)

