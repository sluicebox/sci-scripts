;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use System)

(local
	[local0 9] = [180 0 45 90 135 180 225 270 315]
	local9
)

(class KeyMouse of Obj
	(properties
		objList 0
		-oldPort- 0
		offsetX 0
		offsetY 5
		prevX -1
		prevY -1
		scope 80
		keyMouseCode 0
		keyMouseObj 0
	)

	(method (init)
		(gDirectionHandler add: self)
	)

	(method (setPort))

	(method (resetPort))

	(method (setList param1)
		(= objList param1)
	)

	(method (setCursor param1 &tmp temp0 temp1)
		(= temp0 0)
		(if
			(and
				(== gCardGameScriptNumber 600)
				(param1 respondsTo: #owner)
				(param1 owner:)
				((param1 owner:) isKindOf: List)
			)
			(if (or (!= local9 1) (> gMouseY 148))
				(= param1 ((param1 owner:) at: (- ((param1 owner:) size:) 1)))
			else
				(for
					((= temp1 0))
					(< temp1 ((param1 owner:) size:))
					((++ temp1))
					
					(if (((param1 owner:) at: temp1) faceUp:)
						(= param1 ((param1 owner:) at: temp1))
						(break)
					)
				)
			)
		)
		(if (param1 isClass:)
			(SetCursor
				(if (= prevX (self placementX: param1)) prevX else 319)
				(if (= prevY (self placementY: param1)) prevY else 199)
			)
			(= global191 prevX)
			(= global192 prevY)
			(= temp0 1)
			(= keyMouseObj param1)
		)
		(if (and temp0 keyMouseCode)
			(keyMouseCode doit: param1)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(if
			(and
				(not (event claimed:))
				objList
				(objList size:)
				(<= JOY_UP (event message:) JOY_UPLEFT)
			)
			(= temp6 [local0 (event message:)])
			(= temp3 400)
			(= temp9 scope)
			(for ((= temp4 (= temp2 0))) (< temp4 (objList size:)) ((++ temp4))
				(= temp1 (objList at: temp4))
				(= temp10 (self placementX: temp1))
				(= temp11 (self placementY: temp1))
				(if
					(or
						(!= gMouseX prevX)
						(!= gMouseY prevY)
						(!= temp10 gMouseX)
						(!= temp11 gMouseY)
					)
					(= local9 (event message:))
					(if
						(or
							(!= gCardGameScriptNumber 600)
							(and
								(!= (event message:) JOY_RIGHT)
								(!= (event message:) JOY_LEFT)
							)
						)
						(= temp7 (GetAngle gMouseX gMouseY temp10 temp11))
						(= temp0 (GetDistance gMouseX gMouseY temp10 temp11))
					else
						(= temp7 (GetAngle gMouseX gMouseY temp10 temp11))
						(= temp0 (Abs (- gMouseX temp10)))
					)
					(if (> (= temp8 (Abs (- temp6 temp7))) 180)
						(= temp8 (- 360 temp8))
					)
					(if (< temp8 scope)
						(cond
							(
								(or
									(!= gCardGameScriptNumber 600)
									(and
										(!= (event message:) JOY_RIGHT)
										(!= (event message:) JOY_LEFT)
									)
								)
								(= temp5 (+ (/ temp0 3) temp8))
							)
							(
								(or
									(and (< gMouseY 148) (< temp11 148))
									(and (>= gMouseY 148) (>= temp11 148))
								)
								(= temp5 temp0)
							)
							(else
								(= temp5 1000)
							)
						)
						(if (> (= temp8 (Abs (- temp6 temp7))) 180)
							(= temp8 (- 360 temp8))
						)
						(cond
							((< temp5 temp3)
								(= temp3 temp5)
								(= temp9 temp7)
								(= temp2 temp1)
							)
							((and (== temp5 temp3) (< temp7 temp9))
								(= temp3 temp5)
								(= temp9 temp7)
								(= temp2 temp1)
							)
						)
					)
				)
			)
			(if temp2
				(event claimed: 1)
				(self setCursor: temp2)
			)
		)
		(event claimed:)
	)

	(method (placementX param1 &tmp temp0 temp1)
		(= temp1
			(if
				(= temp0
					(if (param1 respondsTo: #scaleSignal)
						(& (param1 scaleSignal:) $0004)
					)
				)
				(/ (param1 nsRight:) 2)
			else
				(/ (- (param1 nsRight:) (param1 nsLeft:)) 2)
			)
		)
		(if (and (param1 respondsTo: #offsetX) (param1 offsetX:))
			(return
				(+
					(if temp0
						(param1 x:)
					else
						(param1 nsLeft:)
					)
					(param1 offsetX:)
				)
			)
		else
			(return
				(+
					(if temp0
						(param1 x:)
					else
						(param1 nsLeft:)
					)
					offsetX
					temp1
				)
			)
		)
	)

	(method (placementY param1 &tmp temp0)
		(= temp0
			(if (param1 respondsTo: #scaleSignal)
				(& (param1 scaleSignal:) $0004)
			)
		)
		(cond
			((and (param1 respondsTo: #offsetY) (param1 offsetY:))
				(return
					(+
						(if temp0
							(param1 y:)
						else
							(param1 nsTop:)
						)
						(param1 offsetY:)
					)
				)
			)
			(temp0
				(return (- (+ (param1 y:) (param1 nsBottom:)) offsetY))
			)
			(else
				(return (- (param1 nsBottom:) offsetY))
			)
		)
	)

	(method (release)
		(objList release:)
	)
)

