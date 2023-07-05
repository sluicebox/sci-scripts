;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 107)
(include sci.sh)
(use Main)
(use EditablePolygon)
(use Interface)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Polygon)
(use Feature)
(use Sound)
(use File)
(use Actor)
(use System)

(public
	debugHandler 0
	proc107_1 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 17] = [-1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
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

(procedure (localproc_2)
	(if (Print dialog:)
		((Print dialog:) dispose:)
		(Print dialog: 0)
		(FrameOut)
	)
)

(procedure (proc107_1 &tmp temp0 temp1 temp2 [temp3 2] temp5 [temp6 2])
	(= temp2 (Str newWith: 10 {}))
	((= temp5 (Print new:))
		font: gSmallFont
		fore: 255
		back: 0
		addText: {Where to?}
		addEdit: temp2 5 40 0
	)
	(= temp1 (temp5 init:))
	(= temp1 (temp2 asInteger:))
	(gCurRoom newRoom: temp1)
	(gGame handsOn:)
)

(instance debugSound of Sound
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

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 [temp5 5] temp10 temp11 temp12 [temp13 2] temp15 [temp16 10] temp26 [temp27 2] temp29 temp30 temp31 [temp32 4] temp36)
		(if (event claimed:)
			(return)
		)
		(= temp0 (Str new:))
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_QUESTION
						(Prints
							{ ALT-A - show cAst\nALT-B - polygon editor\nCTRL-B - save screen to Bitmap\nALT-D - toggle debug at room change\nALT-E - show Ego\nALT-F - Flag set/clear\nALT-G - show/set Global variable\nALT-H - help on commands\nALT-I - get Inventory Item\nALT-J - Load picture\nALT-K - show palette\nALT-L - Log file\nALT-M - show memory\nALT-O - Scaler tool\nALT-P - Position actor\nALT-Q - screen cursor coordinates\nALT-R - show Room info\nALT-S - show all non-stopupd actors\nCTRL-S - test a sound\nALT-T - Teleport\nALT-U - HandsOn\nALT-V - Show Room polys\nALT-W - feature Writer\nALT-Y - Vanishing point adj\nALT-X - exit the game\n}
						)
					)
					($001a
						(= temp36 (gGame masterVolume:))
						(gGame masterVolume: (/ (* temp36 2) 3))
						(DoAudio 12 0) ; AudMixCheck
					)
					(KEY_ALT_j
						(if
							(and
								(>
									(= temp4
										(GetNumber
											{Pic #?}
											(gCurRoom picture:)
										)
									)
									0
								)
								(ResCheck rsPIC temp4)
							)
							(gCurRoom picture: temp4)
							(gCurRoom drawPic: temp4)
							(FrameOut)
						else
							(Printf
								{Picture number %d not available}
								temp4
							)
						)
					)
					(KEY_ALT_a
						(for
							((= temp15 (gCast first:)))
							temp15
							((= temp15 (gCast next: temp15)))
							
							(= temp10 (KList 8 temp15)) ; NodeValue
							(temp0
								format:
									{class: %s\nname: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npriority: %d\nsignal: $%x\nscaleSignal: $%x\nscaleX: %d\nscaleY: %d\ncycleSpeed: %d\n}
									((temp10 -super-:) name:)
									(temp10 name:)
									(temp10 view:)
									(temp10 loop:)
									(temp10 cel:)
									(temp10 x:)
									(temp10 y:)
									(temp10 z:)
									(temp10 heading:)
									(temp10 priority:)
									(temp10 signal:)
									(temp10 scaleSignal:)
									(temp10 scaleX:)
									(temp10 scaleY:)
									(if (temp10 respondsTo: #cycler)
										(temp10 cycleSpeed:)
									else
										-1
									)
							)
							(localproc_2)
							(if (not (temp10 scaleSignal:))
								(Print
									x: -1
									y: -1
									font: gSmallFont
									fore: 0
									back: 255
									addText: (temp0 data:)
									addIcon:
										(temp10 view:)
										(temp10 loop:)
										(temp10 cel:)
										(+ (Print x:) 90)
										(+ (Print y:) 70)
									init:
								)
							else
								(Print
									x: -1
									y: -1
									font: gSmallFont
									fore: 0
									back: 255
									addText: (temp0 data:) 0 0
									init:
								)
							)
						)
					)
					(KEY_ALT_b
						(if (= local1 (gCast contains: gEgo))
							(gEgo hide:)
						)
						(PEditor init:)
						(if (gCurRoom obstacles:)
							(PEditor readPolygonsFromList: (gCurRoom obstacles:))
						)
						(PEditor doit:)
						(= temp10 (Str new: 13))
						(= temp26 (Str new: 13))
						(temp26 format: {%d.pol} gCurRoomNum)
						(Print
							addTitle: {Output File Name:}
							addEdit: temp10 12 0 0 temp26
							init:
						)
						(FrameOut)
						(poly_pol name: (temp10 data:) open: 2)
						(poly_pol writeString: {\t\t(curRoom addObstacle:\r\n})
						(if (PEditor size:)
							(PEditor eachElementDo: #writeToFile poly_pol)
							(if (gCurRoom obstacles:)
								((gCurRoom obstacles:) dispose:)
								(gCurRoom obstacles: 0)
							)
							(for
								((= temp12 (KList 3 (PEditor elements:)))) ; FirstNode
								temp12
								((= temp12 temp31))
								
								(= temp31 (KList 6 temp12)) ; NextNode
								(= temp26 (KList 8 temp12)) ; NodeValue
								(gCurRoom
									addObstacle:
										((Polygon new:)
											type: (temp26 type:)
											size: (temp26 size:)
											dynamic: 1
											points:
												((IntArray new:)
													copy: (temp26 points:)
												)
											yourself:
										)
								)
							)
						)
						(poly_pol writeString: {\t\t)\r\n})
						(poly_pol close:)
						(temp10 dispose:)
						(PEditor dispose:)
						(if local1
							(gEgo show:)
						)
					)
					(KEY_ALT_c)
					(KEY_ALT_d
						(if (= gDebugOn (not gDebugOn))
							(Prints {On})
						else
							(Prints {Off})
						)
					)
					(KEY_ALT_e
						(= temp10
							(cond
								(local9 local9)
								((gCast contains: (gUser alterEgo:))
									(gUser alterEgo:)
								)
								(else
									(Prints {no ego!})
									(return)
								)
							)
						)
						(= temp0 (Str newWith: 75 {}))
						(temp0
							format:
								{name: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nscript: %s\n}
								(temp10 name:)
								(temp10 view:)
								(temp10 loop:)
								(temp10 cel:)
								(temp10 x:)
								(temp10 y:)
								(temp10 z:)
								(temp10 heading:)
								(temp10 priority:)
								(temp10 signal:)
								(if (temp10 script:)
									((temp10 script:) name:)
								else
									{..none..}
								)
						)
						(Print
							addText: (temp0 data:)
							addIcon:
								(temp10 view:)
								(temp10 loop:)
								(temp10 cel:)
								(+ (Print x:) 80)
								(+ (Print y:) 80)
							init:
						)
					)
					(KEY_ALT_g
						(GetInput temp0 5 {Variable No.})
						(if (not (= temp4 (temp0 asInteger:)))
							(return)
						)
						(GetInput temp0 5 {Value})
						(= [gEgo temp4] (temp0 asInteger:))
					)
					(KEY_ALT_i)
					(KEY_ALT_k
						(PalDisplay doit: 90 90)
					)
					(KEY_ALT_m
						(gGame showMem:)
					)
					(KEY_SHIFT
						(Purge 20000)
						(gGame showMem:)
					)
					(KEY_ALT_l
						((ScriptID 64952) doit:) ; sysLogger
					)
					(KEY_ALT_o
						((ScriptID 109 0) doit:) ; scalerCode
					)
					(KEY_ALT_p
						(= temp29 (GetNumber {x:} (gEgo x:)))
						(= temp30 (GetNumber {y:} (gEgo y:)))
						(gEgo posn: temp29 temp30)
					)
					(KEY_ALT_q
						(Print
							font: gSmallFont
							addTextF: {Cur X: %d,Y: %d} (event x:) (event y:)
							init:
						)
					)
					(KEY_ALT_r
						(temp0
							format:
								{Current Room\nname: %s\nscript: %s\nhorizon: %d\nvanishingX: %d\nvanishingY: %d\npicAngle: %d\nnorth: %d\nsouth: %d\neast: %d\nwest: %d\nstyle: %d\ncurPic: %d}
								(gCurRoom name:)
								(if (gCurRoom script:)
									((gCurRoom script:) name:)
								else
									{none}
								)
								(gCurRoom horizon:)
								(gCurRoom vanishingX:)
								(gCurRoom vanishingY:)
								(gCurRoom picAngle:)
								(gCurRoom north:)
								(gCurRoom south:)
								(gCurRoom east:)
								(gCurRoom west:)
								(gCurRoom style:)
								(gCurRoom curPic:)
						)
						(Print font: gSmallFont addText: temp0 0 0 init:)
					)
					(KEY_ALT_t
						(proc107_1)
					)
					(KEY_PAUSE
						(= temp15 (GetNumber {setLoop?}))
						(= temp10 (GetNumber {which sound number?}))
						(debugSound setLoop: temp15 number: temp10 play:)
					)
					(KEY_ALT_u
						(gGame handsOn:)
					)
					(KEY_ALT_v
						(cond
							(local3 0)
							((gCurRoom obstacles:)
								(= local3
									(AddPolygon gThePlane (gCurRoom obstacles:))
								)
								(FrameOut)
							)
							(else
								(Prints
									{Sorry, this room has no polygons.}
								)
							)
						)
					)
					(KEY_ALT_x
						(= gQuit 1)
					)
					(KEY_ALT_z
						(= temp2 (Event new:))
						((gUser alterEgo:)
							posn: (temp2 x:) (- (temp2 y:) 10)
							setMotion: 0
						)
						(temp2 dispose:)
					)
					(KEY_ALT_h
						(Print
							font: gSmallFont
							addText:
								{ ALT-A - show cAst\nALT-B - polygon editor\nCTRL-B - save screen to Bitmap\nALT-D - toggle debug at room change\nALT-E - show Ego\nALT-F - Flag set/clear\nALT-G - show/set Global variable\nALT-H - help on commands\nALT-I - get Inventory Item\nALT-J - Load picture\nALT-K - show palette\nALT-L - Log file\nALT-M - show memory\nALT-O - Scaler tool\nALT-P - Position actor\nALT-Q - screen cursor coordinates\nALT-R - show Room info\nALT-S - show all non-stopupd actors\nCTRL-S - test a sound\nALT-T - Teleport\nALT-U - HandsOn\nALT-V - Show Room polys\nALT-W - feature Writer\nALT-Y - Vanishing point adj\nALT-X - exit the game\n}
							init:
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(evMOUSEBUTTON
				(if (== (event modifiers:) emALT)
					(event claimed: 1)
					(while (!= evMOUSERELEASE ((= temp2 (Event new:)) type:))
						((gUser alterEgo:)
							posn: (temp2 x:) (- (temp2 y:) 10)
							setMotion: 0
						)
						(temp2 dispose:)
					)
					(temp2 dispose:)
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

(instance poly_pol of File
	(properties
		name {poly.pol}
	)
)

(instance ourPlane of Plane ; UNUSED
	(properties)
)

(instance PalDisplay of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp0
			((Plane new:)
				priority: (+ 1 (GetHighPlanePri))
				init: param1 param2 (+ 64 param1) (+ 64 param2)
				addCast: (Cast new:)
				yourself:
			)
		)
		(= temp1 (View new:))
		(= temp2 (Bitmap 0 64 64 0 254 320 200)) ; Create
		(= temp4 (= temp3 0))
		(= temp5 (= temp6 3))
		(= temp4 0)
		(for ((= temp6 3)) (< temp6 64) ((+= temp6 4))
			(= temp3 0)
			(for ((= temp5 3)) (< temp5 64) ((+= temp5 4))
				(Bitmap
					5 ; AddRect
					temp2
					temp3
					temp4
					temp5
					temp6
					(+ (/ temp3 4) (* 16 (/ temp4 4)))
				)
				(+= temp3 4)
			)
			(+= temp4 4)
		)
		(temp1
			x: 0
			y: 0
			plane: temp0
			bitmap: temp2
			init: ((temp0 casts:) at: 0)
		)
	)
)

