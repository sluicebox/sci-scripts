;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 202)
(include sci.sh)
(use Main)
(use DText)
(use Str)
(use Array)
(use Print)
(use Polygon)
(use User)
(use System)

(local
	local0
	local1
	local2
)

(class EditablePolygon of Polygon
	(properties
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		priority 500
	)

	(method (BAD_SELECTOR param1 param2 param3 &tmp temp0)
		(points at: (= temp0 (* param1 2)) param2)
		(points at: (+ temp0 1) param3)
	)

	(method (BAD_SELECTOR param1 &tmp temp0)
		(= BAD_SELECTOR (points at: (= temp0 (* param1 2))))
		(= BAD_SELECTOR (points at: (+ temp0 1)))
		(if 0
			(Printf
				{indexToCoor - index : %d x : %d y: %d}
				param1
				BAD_SELECTOR
				BAD_SELECTOR
			)
		)
	)

	(method (BAD_SELECTOR)
		(self sel_791: size &rest)
	)

	(method (BAD_SELECTOR param1 param2 &tmp temp0 temp1 temp2)
		(if (not size)
			(return)
		)
		(= BAD_SELECTOR 32767)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(self sel_793: temp0)
			(if
				(<
					(= temp1
						(GetDistance BAD_SELECTOR BAD_SELECTOR param1 param2)
					)
					BAD_SELECTOR
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
				(= BAD_SELECTOR temp1)
			)
		)
		(if 0
			(Printf {Returning nearest index : %d} temp2)
		)
		(return temp2)
	)

	(method (distanceTo param1 param2 param3)
		(self sel_793: param1)
		(GetDistance BAD_SELECTOR BAD_SELECTOR param2 param3)
	)

	(method (BAD_SELECTOR param1 param2 param3 param4 &tmp temp0)
		(= temp0 (IntArray copy: points))
		(*= param1 2)
		(temp0 copyToFrom: (+ param1 2) points param1 (- (points size:) param1))
		(temp0 at: param1 param2 param3)
		(points copy: temp0)
		(++ size)
		(temp0 dispose:)
		(if (and BAD_SELECTOR (> argc 3) param4)
			(self hide: 1 show:)
		)
	)

	(method (BAD_SELECTOR param1 param2 &tmp temp0)
		(= temp0 (IntArray new:))
		(*= param1 2)
		(temp0
			copyToFrom: 0 points 0 (Max 0 param1)
			copyToFrom:
				param1
				points
				(+ param1 2)
				(- (points size:) (+ param1 2))
		)
		(points copy: temp0)
		(-- size)
		(temp0 dispose:)
		(if (and BAD_SELECTOR (> argc 1) param2)
			(self hide: 1 show:)
		)
	)

	(method (showSelf &tmp temp0 temp1 temp2)
		(= temp1 (Str new:))
		(= temp2 (Str new:))
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(self sel_793: temp0)
			(temp2 format: {%d } BAD_SELECTOR)
			(temp1 cat: temp2)
			(temp2 format: {%d } BAD_SELECTOR)
			(temp1 cat: temp2)
		)
		(Printf {%s} (temp1 data:))
		(temp1 dispose:)
		(temp2 dispose:)
	)

	(method (BAD_SELECTOR param1 param2 &tmp temp0 temp1)
		(= temp0 -1)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(self sel_793: temp1)
			(if (and (== BAD_SELECTOR param1) (== BAD_SELECTOR param2))
				(= temp0 temp1)
			)
		)
		(return temp0)
	)

	(method (show param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if BAD_SELECTOR
			(self hide:)
		)
		(= BAD_SELECTOR (Set new:))
		(self sel_793: (= temp5 0))
		(= temp3 (= temp1 BAD_SELECTOR))
		(for
			((= temp4 (= temp2 BAD_SELECTOR)))
			(< (++ temp5) size)
			((= temp4 BAD_SELECTOR))
			
			(self sel_793: temp5)
			(BAD_SELECTOR
				add:
					(AddLine
						(local0 plane:)
						temp3
						temp4
						BAD_SELECTOR
						BAD_SELECTOR
						200
						(local0 sel_800:)
						0
						0
						1
					)
			)
			(= temp3 BAD_SELECTOR)
		)
		(BAD_SELECTOR
			add:
				(AddLine
					(local0 plane:)
					temp1
					temp2
					temp3
					temp4
					200
					(local0 sel_800:)
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
		(if (not BAD_SELECTOR)
			(return)
		)
		(while (BAD_SELECTOR size:)
			(DeleteLine (= temp1 (BAD_SELECTOR at: 0)) (local0 plane:))
			(BAD_SELECTOR delete: temp1)
		)
		(if (or (not argc) (not param1))
			(FrameOut)
		)
	)

	(method (BAD_SELECTOR param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(if (== param1 0)
			(= temp7 (- (BAD_SELECTOR size:) 1))
			(= temp1 (BAD_SELECTOR at: temp7))
			(self sel_793: temp7)
			(= temp3 BAD_SELECTOR)
			(= temp4 BAD_SELECTOR)
		else
			(= temp7 (- param1 1))
			(= temp1 (BAD_SELECTOR at: temp7))
			(self sel_793: temp7)
			(= temp3 BAD_SELECTOR)
			(= temp4 BAD_SELECTOR)
		)
		(= temp2 (BAD_SELECTOR at: param1))
		(if (== param1 (- (BAD_SELECTOR size:) 1))
			(= temp7 0)
		else
			(= temp7 (+ param1 1))
		)
		(self sel_793: temp7)
		(= temp5 BAD_SELECTOR)
		(= temp6 BAD_SELECTOR)
		(= temp8 0)
		(= temp9 0)
		(= temp10 (local0 plane:))
		(= temp13 (local0 sel_801:))
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
			(local0 sel_800:)
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
			(local0 sel_800:)
			0
			0
			1
		)
		(self sel_798: param1 (temp0 x:) (temp0 y:))
		(FrameOut)
	)

	(method (BAD_SELECTOR param1)
		(if (not BAD_SELECTOR)
			(= BAD_SELECTOR (Set new:))
		)
		(BAD_SELECTOR add: param1)
	)

	(method (BAD_SELECTOR param1 param2 &tmp temp0 temp1 temp2)
		(if (and (> argc 1) param2)
			(param1
				writeString: {\r\n\t\t\t; *** }
				writeString: (self name:)
				writeString: { ***\r\n}
			)
		)
		(param1 writeString: {\t\t\t((Polygon new:)\r\n\t\t\t\ttype: })
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
		(temp0 cat: {Access,\r\n\t\t\t\tinit: })
		(param1 writeString: temp0)
		(temp0 with: {})
		(= temp2 0)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(self sel_793: temp1)
			(temp0 format: {%d %d} BAD_SELECTOR BAD_SELECTOR)
			(+= temp2 (temp0 size:))
			(param1 writeString: temp0)
			(cond
				((> temp2 49)
					(= temp2 0)
					(param1 writeString: {\r\n\t\t\t\t\t\t})
				)
				((< (+ temp1 1) size)
					(param1 writeString: { })
				)
			)
		)
		(param1 writeString: {,\r\n\t\t\t\tyourself:\r\n\t\t\t)\r\n})
		(temp0 dispose:)
	)

	(method (dispose)
		(if BAD_SELECTOR
			(self hide:)
		)
		(super dispose:)
	)
)

(class PEditor of Set
	(properties
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 255
		BAD_SELECTOR 255
		mode 0
		BAD_SELECTOR 0
		plane 0
	)

	(method (init)
		(= mode 1)
		(= local1 (Str format: {Edit Mode}))
		((= local2 (DText new:))
			text: (KString 8 (local1 data:)) ; StrDup
			fore: 255
			posn:
				(+ (Abs ((gCurRoom plane:) left:)) 1)
				(+ (Abs ((gCurRoom plane:) top:)) 1)
			setSize: 240
			setPri: 500
			init:
		)
		(super init: &rest)
		(= plane (gCast plane:))
		(= local0 self)
		(= BAD_SELECTOR 0)
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

	(method (BAD_SELECTOR param1 param2 &tmp temp0 temp1)
		(= temp1
			(AddLine plane param1 param2 param1 param2 200 BAD_SELECTOR 0 0 1)
		)
		(FrameOut)
		(= BAD_SELECTOR param1)
		(= BAD_SELECTOR param2)
		(while (!= ((= temp0 ((User curEvent:) new:)) type:) 1)
			(temp0 localize: plane)
			(if (or (!= (temp0 x:) BAD_SELECTOR) (!= (temp0 y:) BAD_SELECTOR))
				(UpdateLine
					temp1
					plane
					param1
					param2
					(temp0 x:)
					(temp0 y:)
					200
					BAD_SELECTOR
					0
					0
					1
				)
			)
			(= BAD_SELECTOR (temp0 x:))
			(= BAD_SELECTOR (temp0 y:))
			(FrameOut)
		)
		(if (= BAD_SELECTOR (temp0 modifiers:))
			(DeleteLine temp1 plane)
			(= temp1 0)
		else
			(temp0 localize: plane)
			(UpdateLine
				temp1
				plane
				param1
				param2
				BAD_SELECTOR
				BAD_SELECTOR
				200
				BAD_SELECTOR
				0
				0
				1
			)
		)
		(return temp1)
	)

	(method (BAD_SELECTOR param1)
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

	(method (BAD_SELECTOR param1 &tmp temp0 temp1)
		(= temp1 gTheCursor)
		(gGame setCursor: gWaitCursor)
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(self sel_808: (param1 at: temp0))
		)
		(self show: 1)
		(FrameOut)
		(gGame setCursor: temp1)
	)

	(method (BAD_SELECTOR param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(= BAD_SELECTOR (= BAD_SELECTOR 0))
		(if (not (self size:))
			(return)
		)
		(= temp3 32767)
		(for ((= temp4 (KList 3 elements))) temp4 ((= temp4 nextNode)) ; FirstNode
			(= nextNode (KList 6 temp4)) ; NextNode
			(= temp1 (KList 8 temp4)) ; NodeValue
			(= temp0 (temp1 sel_790: param1 param2))
			(if (< (= temp2 (temp1 sel_788:)) temp3)
				(= BAD_SELECTOR temp1)
				(= BAD_SELECTOR temp0)
				(= temp3 temp2)
			)
		)
	)

	(method (BAD_SELECTOR param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 0)
		(= BAD_SELECTOR param1)
		(= BAD_SELECTOR param2)
		(= BAD_SELECTOR 0)
		(= BAD_SELECTOR ((EditablePolygon new:) init: yourself:))
		(if scratch
			(= temp6 (Str new: 13))
			(= temp7 (Str newWith: 13 {default}))
			(Print addTitle: {Feature Name:} addEdit: temp6 12 0 0 temp7 init:)
			(FrameOut)
			(BAD_SELECTOR name: (temp6 data:) type: 0)
			(temp7 dispose:)
		)
		(BAD_SELECTOR sel_796: param1 param2)
		(while (not BAD_SELECTOR)
			(= temp2 BAD_SELECTOR)
			(= temp3 BAD_SELECTOR)
			(if (= temp4 (self sel_816: BAD_SELECTOR BAD_SELECTOR))
				(BAD_SELECTOR sel_796: BAD_SELECTOR BAD_SELECTOR sel_795: temp4)
			)
		)
		(if (> (BAD_SELECTOR size:) 2)
			(BAD_SELECTOR
				sel_795:
					(AddLine
						plane
						param1
						param2
						temp2
						temp3
						200
						BAD_SELECTOR
						0
						0
						1
					)
			)
			(self add: BAD_SELECTOR)
			(FrameOut)
			(if
				(and
					(not scratch)
					(= temp5
						(Print
							addTitle: {Polygon access type}
							addButton: 1 {Total} 0 0
							addButton: 2 { Near } 120 0
							addButton: 3 { Barred } 240 0
							addButton: 4 { Container } 390 0
							init:
						)
					)
				)
				(BAD_SELECTOR type: (- temp5 1))
			)
		else
			(BAD_SELECTOR dispose:)
			(= BAD_SELECTOR 0)
		)
		(FrameOut)
	)

	(method (doit &tmp temp0 temp1)
		(= temp1 gTheCursor)
		(gGame setCursor: gNormalCursor)
		(while (not BAD_SELECTOR)
			(= temp0 ((User curEvent:) new:))
			(self handleEvent: temp0)
		)
		(gGame setCursor: temp1)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (& (event type:) evKEYBOARD)
			(switch (event message:)
				(KEY_SPACE
					(if (and (== mode 0) (self size:))
						(= local1 (Str format: {Edit Mode}))
						(= mode 1)
					else
						(= local1 (Str format: {Create Mode}))
						(= mode 0)
					)
				)
				(KEY_ESCAPE
					(= BAD_SELECTOR 1)
				)
			)
			(local2 dispose:)
			((= local2 (DText new:))
				text: (KString 8 (local1 data:)) ; StrDup
				fore: 255
				posn:
					(+ (Abs ((gCurRoom plane:) left:)) 2)
					(+ (Abs ((gCurRoom plane:) top:)) 2)
				setSize: 240
				setPri: 500
				init:
			)
			(FrameOut)
		)
		(switch mode
			(0
				(if (and (& (event type:) evMOUSEBUTTON) (not (event modifiers:)))
					(event localize: plane)
					(self sel_815: (event x:) (event y:))
				)
			)
			(1
				(if (and (& (event type:) evMOUSEBUTTON) (self size:))
					(cond
						((not (event modifiers:))
							(event localize: plane)
							(self sel_790: (event x:) (event y:))
							(BAD_SELECTOR sel_797: BAD_SELECTOR)
						)
						((& (event modifiers:) emSHIFT)
							(event localize: plane)
							(self sel_790: (event x:) (event y:))
							(BAD_SELECTOR sel_792: BAD_SELECTOR 1)
							(if (<= (BAD_SELECTOR size:) 2)
								(self delete: BAD_SELECTOR)
								(BAD_SELECTOR dispose:)
							)
						)
						((& (event modifiers:) emCTRL)
							(event localize: plane)
							(self sel_790: (event x:) (event y:))
							(= temp0 BAD_SELECTOR)
							(if (< (= temp1 (- BAD_SELECTOR 1)) 0)
								(= temp1 (- (BAD_SELECTOR size:) 1))
							)
							(if
								(>=
									(= temp2 (+ BAD_SELECTOR 1))
									(BAD_SELECTOR size:)
								)
								(= temp2 0)
							)
							(= temp3
								(BAD_SELECTOR
									distanceTo: temp1 (event x:) (event y:)
								)
							)
							(= temp4
								(BAD_SELECTOR
									distanceTo: temp2 (event x:) (event y:)
								)
							)
							(BAD_SELECTOR
								sel_791:
									(if (> temp3 temp4) temp1 else BAD_SELECTOR)
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
		(local2 dispose:)
		(local1 dispose:)
		(= temp0 gTheCursor)
		(gGame setCursor: gWaitCursor)
		(self hide: 1)
		(FrameOut)
		(gGame setCursor: temp0)
		(super dispose:)
	)
)

