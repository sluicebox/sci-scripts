;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 97)
(include sci.sh)
(use Main)
(use ExitButton)
(use DButton)
(use DText)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Dialog)
(use Polygon)
(use Feature)
(use Sound)
(use File)
(use Inventory)
(use System)

(public
	debugHandler 0
	proc97_1 1
)

(local
	local0
	[local1 2]
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)

(procedure (localproc_0 param1 param2 &tmp temp0) ; UNUSED
	(= temp0 (Str newWith: 80 {}))
	(if (> argc 1)
		(temp0 format: {%d} param2)
	)
	(return
		(if (GetInput (temp0 data:) 10 param1)
			(temp0 asInteger:)
		else
			-1
		)
	)
)

(procedure (localproc_1) ; UNUSED
	(Print
		addText: {Flag Object?} 0 0
		addButton: 1 {yes} 10 20
		addButton: 0 {no} 10 40
		init:
	)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2 temp3) ; UNUSED
	(for ((= temp0 0)) (<= temp0 (- (gFeatures size:) 1)) ((++ temp0))
		(if ((gFeatures at: temp0) onMeCheck:)
			(if (((gFeatures at: temp0) onMeCheck:) isKindOf: Polygon)
				(= temp2 (IntArray new:))
				(= temp3
					(- ((((gFeatures at: temp0) onMeCheck:) points:) size:) 1)
				)
				(for ((= temp1 0)) (<= temp1 temp3) ((++ temp1))
					(temp2
						at:
							temp1
							((((gFeatures at: temp0) onMeCheck:) points:)
								at: temp1
							)
					)
				)
				(param1
					add:
						((Polygon new:)
							size: (/ (+ temp3 1) 2)
							points: temp2
							dynamic: 1
							yourself:
						)
				)
			else
				(Prints
					{A feature in this room cannot be displayed due to it being a list of polygons (and that part in debug hasn't been coded yet).}
				)
			)
		else
			(param1
				add:
					((Polygon new:)
						init:
							((gFeatures at: temp0) nsLeft:)
							((gFeatures at: temp0) nsTop:)
							((gFeatures at: temp0) nsRight:)
							((gFeatures at: temp0) nsTop:)
							((gFeatures at: temp0) nsRight:)
							((gFeatures at: temp0) nsBottom:)
							((gFeatures at: temp0) nsLeft:)
							((gFeatures at: temp0) nsBottom:)
						yourself:
					)
			)
		)
	)
	(AddPolygon gThePlane param1 250 255 0 0 1 1)
)

(procedure (localproc_3 param1 param2) ; UNUSED
	(DeletePolygon param2 gThePlane)
	(if param1
		(param1 dispose:)
	)
)

(procedure (localproc_4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7) ; UNUSED
	(= temp6 0)
	(= temp1 (Str format: {%03d.BMP} gCurRoomNum))
	(= temp0 (Str new: 13))
	(= temp3 (Str new: 60))
	(= temp4 (Str format: {%d} gCurRoomNum))
	(Font 1 640 480) ; SetFontRes
	(if (Print addTitle: {Output File Name:} addEdit: temp0 12 0 0 temp1 init:)
		(if
			(Print
				addTitle: {Room #/Room Description}
				addEdit: temp3 60 30 0 temp4
				init:
			)
			(= temp6 1)
		)
		(if
			(= temp7
				(Print
					addText: {What do you want to discard\nfrom the bitmap?} 0 0
					addButton: 0 {Nothing} 10 20
					addButton: 1 {Interface} 60 20
					addButton: 2 {All but pic} 10 40
					init:
				)
			)
			(switch temp7
				(1
					((global108 plane:) priority: -1)
					(UpdatePlane (global108 plane:))
				)
				(2
					(gEgo hide:)
					((global108 plane:) priority: -1)
					(UpdatePlane (global108 plane:))
				)
				(else
					(= temp6 0)
				)
			)
			(if temp6
				(= temp2
					(Print
						addText: temp3
						posn: 11 155
						modeless: 2
						init:
						yourself:
					)
				)
			)
			(FrameOut)
			(SaveScreen (temp0 data:))
			(if temp2
				((temp2 dialog:) dispose:)
			)
			(if (FileIO fiEXISTS (temp0 data:))
				(Printf {%03d.BMP SUCCESSFULLY CREATED} gCurRoomNum)
			else
				(Printf {ERROR CREATING %03d.BMP} gCurRoomNum)
			)
		)
	)
	(FrameOut)
	(temp1 dispose:)
	(temp0 dispose:)
	(temp4 dispose:)
	(temp3 dispose:)
	(gEgo show:)
	((global108 plane:) priority: 3)
	(UpdatePlane (global108 plane:))
	(Font 1 320 200) ; SetFontRes
	(FrameOut)
)

(procedure (localproc_5) ; UNUSED
	(if (Print dialog:)
		((Print dialog:) dispose:)
		(Print dialog: 0)
		(FrameOut)
	)
)

(procedure (proc97_1 &tmp temp0 temp1 temp2 [temp3 2] temp5) ; UNUSED
	(= temp2 (Str newWith: 10 {}))
	((= temp5 (Print new:))
		font: gSmallFont
		fore: 255
		back: 0
		addText: {Where to?}
		addEdit: temp2 5 40 0
		addButton: 15 {<Intro >} 0 26
		addButton: 1111 {<Chap 1>} 0 40
		addButton: 2222 {<Chap 2>} 0 54
		addButton: 3333 {<Chap 3>} 0 68
		addButton: 4444 {<Chap 4>} 40 26
		addButton: 5555 {<Chap 5>} 40 40
		addButton: 6666 {<Chap 6>} 40 54
	)
	(if (FileIO fiEXISTS {kq7cdsg.cat})
		(temp5 addButton: 22 {<Restore>} 40 68)
	)
	(if (and (!= (= temp1 (temp5 init:)) 15) (!= temp1 22))
		(SetFlag 21)
	)
	(if (== gCurRoomNum 26)
		(SetFlag 8)
	)
	(if (temp2 size:)
		(= temp1 (temp2 asInteger:))
	)
	(if temp2
		(temp2 dispose:)
		(= temp2 0)
	)
	(switch temp1
		(1111
			(= temp1 0)
			(= gChapter 1)
		)
		(2222
			(= temp1 0)
			(= gChapter 2)
		)
		(3333
			(= temp1 0)
			(= gChapter 3)
		)
		(4444
			(= temp1 0)
			(= gChapter 4)
		)
		(5555
			(= temp1 0)
			(= gChapter 5)
		)
		(6666
			(= temp1 0)
			(= gChapter 6)
		)
		(22
			(gGame restore:)
		)
		(15
			(= temp1 15)
			(= gChapter 1)
		)
		(else
			(= gChapter
				(Print
					font: gSmallFont
					fore: 255
					back: 0
					addText: {Which chapter?}
					addButton: 1 {chap 1} 0 12
					addButton: 2 {chap 2} 0 26
					addButton: 3 {chap 3} 0 40
					addButton: 4 {chap 4} 0 54
					addButton: 5 {chap 5} 0 68
					addButton: 6 {chap 6} 0 82
					init:
				)
			)
		)
	)
	(if (== temp1 15)
		(gCurRoom newRoom: 15)
	else
		((ScriptID 28 0) doit: gChapter temp1) ; kqChapCode
	)
)

(instance debugSound of Sound ; UNUSED
	(properties)
)

(instance debugHandler of Feature
	(properties
		y -1
	)

	(method (init)
		(super init:)
		(self y: -1)
		(= local3 0)
		(= local4 0)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event &tmp temp0 [temp1 4] temp5 temp6 temp7 temp8 temp9 [temp10 18] temp28 [temp29 8])
		(if (event claimed:)
			(return)
		)
		(= temp0 (Str new:))
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_ALT_i
						(repeat
							(= temp5 (gInventory first:))
							(= temp6 (= temp7 (= temp8 (= temp28 0))))
							(Print font: gSmallFont)
							(repeat
								(breakif (not temp5))
								(Print
									addButton:
										temp8
										((KList 8 temp5) name:) ; NodeValue
										temp7
										temp6
								)
								((Print dialog:) setSize:)
								(if (> temp6 150)
									(= temp28 temp6)
									(= temp6 0)
									(= temp7
										(-
											((Print dialog:) nsRight:)
											((Print dialog:) nsLeft:)
										)
									)
								else
									(+= temp6 10)
								)
								(= temp5 (gInventory next: temp5))
								(++ temp8)
							)
							(Print
								addButton:
									temp8
									{Outta Here}
									temp7
									(if temp28 temp28 else temp6)
							)
							(breakif (== (= temp9 (Print init:)) temp8))
							(gEgo get: temp9)
						)
						(Print font: gUserFont)
					)
					(KEY_ALT_l
						((ScriptID 64952) doit:) ; sysLogger
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
		(temp0 dispose:)
	)

	(method (dispose &tmp temp0)
		(if local4
			(DeletePolygon local4 gThePlane)
			(= local4 0)
		)
		(if (gTheDoits contains: featureCheck)
			(gTheDoits delete: featureCheck)
		)
		(if local6
			(local6 dispose:)
			(= local6 0)
			(= local8 0)
		)
		(if local5
			(local5 dispose:)
			(= local5 0)
		)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)
)

(instance dInvD of Dialog ; UNUSED
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp2 (= temp0 (= temp1 4)))
		(= temp3 0)
		(for
			((= temp5 (gInventory first:)))
			temp5
			((= temp5 (gInventory next: temp5)))
			
			(= temp6 (KList 8 temp5)) ; NodeValue
			(++ temp3)
			(if (temp6 isKindOf: InvI)
				(self
					add:
						((= temp4 (DText new:))
							value: temp6
							text: (temp6 name:)
							nsLeft: temp0
							nsTop: temp1
							state: 3
							font: 30
							setSize:
							yourself:
						)
				)
			)
			(if (< temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
				(= temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
			)
			(if (> (+= temp1 (+ (- (temp4 nsBottom:) (temp4 nsTop:)) 1)) 140)
				(= temp1 4)
				(+= temp0 (+ temp2 10))
				(= temp2 0)
			)
		)
		(= plane ourPlane)
		(self setSize:)
		(= local0 (DButton new:))
		(local0
			text: {Outta here!}
			setSize:
			moveTo: (- nsRight (+ 4 (local0 nsRight:))) nsBottom
		)
		(local0 move: (- (local0 nsLeft:) (local0 nsRight:)) 0)
		(self add: local0 setSize: center:)
		(return temp3)
	)

	(method (doit &tmp temp0)
		(self init:)
		(self open: 4 15)
		(= temp0 local0)
		(repeat
			(if
				(or
					(not (= temp0 (super doit: temp0)))
					(== temp0 -1)
					(== temp0 local0)
				)
				(break)
			)
			(gEgo get: (gInventory indexOf: (temp0 value:)))
		)
		(self eachElementDo: #dispose 1 dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 (event message:))
		(switch (= temp1 (event type:))
			(evKEYBOARD
				(switch temp0
					(KEY_UP
						(= temp0 KEY_SHIFTTAB)
					)
					(KEY_DOWN
						(= temp0 KEY_TAB)
					)
				)
			)
			($0010 ; direction
				(switch temp0
					(JOY_UP
						(= temp0 KEY_SHIFTTAB)
						(= temp1 evKEYBOARD)
					)
					(JOY_DOWN
						(= temp0 KEY_TAB)
						(= temp1 evKEYBOARD)
					)
				)
			)
		)
		(event type: temp1 message: temp0)
		(super handleEvent: event)
	)
)

(instance featureCheck of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		((gUser curEvent:) localize: (gCast plane:))
		(= temp0 ((gUser curEvent:) x:))
		(= temp1 ((gUser curEvent:) y:))
		(cond
			((= local7 (gFeatures firstTrue: #onMe temp0 temp1))
				(if (!= local8 local7)
					(if local6
						(local6 dispose:)
						(= local6 0)
					)
					((= local6 (DText new:))
						text: (KString 8 (local7 name:)) ; StrDup
						fore: 0
						back: 255
						setSize: 240
						setPri: 255
					)
					(if (< temp0 145)
						(local6 posn: 188 30 init:)
					else
						(local6 posn: 65 30 init:)
					)
					(= local8 local7)
					(= local7 0)
				)
			)
			(local6
				(local6 dispose:)
				(= local6 0)
				(= local8 0)
			)
		)
	)
)

(instance poly_pol of File ; UNUSED
	(properties
		name {poly.pol}
	)
)

(instance ourPlane of Plane
	(properties)
)

