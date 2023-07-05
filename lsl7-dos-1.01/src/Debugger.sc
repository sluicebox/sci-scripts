;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64014)
(include sci.sh)
(use Main)
(use EditablePolygon)
(use TPSound)
(use oInvHandler)
(use L7TalkWindow)
(use Interface)
(use soFlashCyberSniff)
(use Str)
(use Array)
(use Print)
(use Polygon)
(use WalkieTalkie)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	Debugger 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1)
	(= temp0 (Str new:))
	(if (> argc 1)
		(temp0 format: {%hu} param2)
	)
	(= temp1
		(if (GetInput temp0 5 param1)
			(temp0 asInteger:)
		else
			-1
		)
	)
	(temp0 dispose:)
	(return temp1)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26)
	(if (or (not param1) (not (param1 isKindOf: View)) (== (param1 view:) -1))
		(return 1)
	)
	(= temp7 10)
	(= temp22 (Str newWith: 10 {}))
	(= temp8 (Str newWith: temp7 {}))
	(= temp10 (Str newWith: temp7 {}))
	(= temp12 (Str newWith: temp7 {}))
	(= temp14 (Str newWith: temp7 {}))
	(= temp16 (Str newWith: temp7 {}))
	(= temp20 (Str newWith: temp7 {}))
	(= temp18 (Str newWith: temp7 {}))
	(= temp23 (Str newWith: temp7 {}))
	(= temp26 (Str newWith: temp7 {}))
	(temp22
		format:
			{instance (%hu) %s of %s}
			param1
			((param1 Super:) name:)
			(param1 name:)
	)
	(temp8 format: {%hu} (param1 view:))
	(temp10 format: {%d} (param1 loop:))
	(temp12 format: {%d} (param1 cel:))
	(temp14 format: {%d} (param1 x:))
	(temp16 format: {%d} (param1 y:))
	(temp18 format: {%d} (param1 priority:))
	(= temp25 (/ (* 100 (param1 scaleY:)) 128))
	(temp23 format: {%d} temp25)
	(= temp5
		(+ (= temp3 (CelWide (param1 view:) (param1 loop:) (param1 cel:))) 50)
	)
	(= temp4 0)
	(= temp6 12)
	(= temp1 (CelInfo 0 (param1 view:) (param1 loop:) (param1 cel:))) ; GetOrigX
	(= temp2 (CelInfo 1 (param1 view:) (param1 loop:) (param1 cel:))) ; GetOrigY
	(Print
		y: 20
		fore: 87
		back: 0
		skip: 255
		font: gUserFont
		addTitle: temp22
		addIcon: (param1 view:) (param1 loop:) (param1 cel:) temp1 temp2
		addText: {view} temp3 temp4
		addEdit: temp8 temp7 temp5 temp4
		addText: {loop} temp3 (+= temp4 temp6)
		addEdit: temp10 temp7 temp5 temp4
		addText: {cel} temp3 (+= temp4 temp6)
		addEdit: temp12 temp7 temp5 temp4
		addText: {x} temp3 (+= temp4 temp6)
		addEdit: temp14 temp7 temp5 temp4
		addText: {y} temp3 (+= temp4 temp6)
		addEdit: temp16 temp7 temp5 temp4
		addText: {priority} temp3 (+= temp4 temp6)
		addEdit: temp18 temp7 temp5 temp4
		addText: {Scale %} temp3 (+= temp4 temp6)
		addEdit: temp23 temp7 temp5 temp4
	)
	(if (param1 isKindOf: Actor)
		(temp20 format: {%d} (param1 heading:))
		(Print
			addText: {heading} temp3 (+= temp4 temp6)
			addEdit: temp20 temp7 temp5 temp4
		)
		(if (param1 scaler:)
			(temp26
				format:
					{Scaler %d  %d  %d  %d}
					((param1 scaler:) frontSize:)
					((param1 scaler:) backSize:)
					((param1 scaler:) frontY:)
					((param1 scaler:) backY:)
			)
			(Print addText: temp26 temp3 (+= temp4 temp6))
		else
			(Print addText: {No scaler} temp3 (+= temp4 temp6))
		)
	)
	(if (= temp0 (Print init:))
		(= temp9 (temp8 asInteger:))
		(= temp11 (temp10 asInteger:))
		(= temp13 (temp12 asInteger:))
		(= temp15 (temp14 asInteger:))
		(= temp17 (temp16 asInteger:))
		(= temp19 (temp18 asInteger:))
		(= temp24 (temp23 asInteger:))
		(if (param1 isKindOf: Actor)
			(localproc_6 param1 (temp20 asInteger:))
		)
		(param1
			view: temp9
			setLoop: temp11
			setCel: temp13
			posn: temp15 temp17
			setPri: temp19
		)
		(if (!= temp24 temp25)
			(param1 setScalePercent: temp24)
		)
	)
	(temp22 dispose:)
	(temp8 dispose:)
	(temp10 dispose:)
	(temp12 dispose:)
	(temp14 dispose:)
	(temp16 dispose:)
	(temp20 dispose:)
	(temp18 dispose:)
	(temp23 dispose:)
	(temp26 dispose:)
	(return temp0)
)

(procedure (localproc_2 param1 &tmp temp0)
	(DeleteScreenItem param1)
	(FrameOut)
	(for ((= temp0 250)) temp0 ((-- temp0))
		(cond
			((== 50 temp0)
				(DeleteScreenItem param1)
			)
			((== 100 temp0)
				(AddScreenItem param1)
			)
			((== 150 temp0)
				(DeleteScreenItem param1)
			)
			((== 200 temp0)
				(AddScreenItem param1)
			)
		)
		(FrameOut)
	)
	(AddScreenItem param1)
	(FrameOut)
)

(procedure (localproc_3 param1 param2 param3 param4)
	(if
		(and
			(or (not local3) (not (local3 isKindOf: param2)))
			(= local3 (localproc_4 param1 param2 param3 param4))
		)
		(localproc_2 local3)
	)
	(return local3)
)

(procedure (localproc_4 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp2 32764)
	(= temp1 0)
	(for ((= temp4 (param1 first:))) temp4 ((= temp4 (param1 next: temp4)))
		(= temp0 (KList 8 temp4)) ; NodeValue
		(if
			(and
				(temp0 isKindOf: param2)
				(<
					(= temp3 (GetDistance param3 param4 (temp0 x:) (temp0 y:)))
					temp2
				)
			)
			(= temp1 temp0)
			(= temp2 temp3)
		)
	)
	(return temp1)
)

(procedure (localproc_5 param1 param2 &tmp temp0)
	(for ((= temp0 (+ param2 (param1 heading:)))) (> temp0 360) ((-= temp0 360))
	)
	(while (< temp0 0)
		(+= temp0 360)
	)
	(param1 setHeading: temp0)
)

(procedure (localproc_6 param1 param2 &tmp temp0)
	(for ((= temp0 param2)) (> temp0 360) ((-= temp0 360))
	)
	(while (< temp0 0)
		(+= temp0 360)
	)
	(param1 setHeading: temp0)
)

(procedure (localproc_7 param1 &tmp temp0 temp1 temp2)
	(FrameOut)
	(= temp2 gThePlane)
	(for
		((= temp0 (gPlanes next: (gPlanes first:))))
		temp0
		((= temp0 (gPlanes next: temp0)))
		
		(= temp1 (KList 8 temp0)) ; NodeValue
		(if (temp1 onMe: param1)
			(= temp2 temp1)
			(break)
		)
	)
	(param1 localize: temp2)
	(param1 claimed: 1)
	(return temp2)
)

(procedure (localproc_8 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
	(poly_pol name: {msgcheck.txt} open: 2)
	(= temp0 0)
	(= temp1 0)
	(PrintDebug {Checking for verb text})
	(poly_pol
		writeString:
			{Dump of L7 Message Problems\r\n\r\nAll Verb Text (1-254):\r\n}
	)
	(for ((= temp2 1)) (< temp2 255) ((++ temp2))
		(cond
			((= temp0 (MakeMessageText 0 temp2 0 1 13 1))
				(= temp1 (Str format: {%5d  Verbs  (13) %s\r\n} temp2 temp0))
				(poly_pol writeString: temp1)
			)
			((= temp0 (MakeMessageText 0 temp2 0 1 12 1))
				(= temp1 (Str format: {%5d  Topics (12) %s\r\n} temp2 temp0))
				(poly_pol writeString: temp1)
			)
			((= temp0 (MakeMessageText 0 temp2 0 1 11 1))
				(= temp1 (Str format: {%5d  Inv    (11) %s\r\n} temp2 temp0))
				(poly_pol writeString: temp1)
			)
			(else
				(= temp1 (Str format: {%5d  None\r\n} temp2))
				(poly_pol writeString: temp1)
			)
		)
		(if temp0
			(temp0 dispose:)
			(= temp0 0)
		)
		(if temp1
			(temp1 dispose:)
			(= temp1 0)
		)
	)
	(PrintDebug {Checking for unused verbs})
	(= temp6 (IntArray newWith: 255))
	(for ((= temp2 60)) (< temp2 600) ((++ temp2))
		(if (ResCheck rsMESSAGE temp2)
			(PrintDebug {Checking room: %d} temp2)
			(for ((= temp3 1)) (< temp3 40) ((++ temp3))
				(if
					(or
						(Message msgGET temp2 temp3 68 0 1)
						(Message msgGET temp2 temp3 1 0 1)
					)
					(if (not (Message msgGET temp2 temp3 68 0 1))
						(= temp1
							(Str
								format:
									{No NAME V: Noun %d, Room %d\r\n}
									temp3
									temp2
							)
						)
						(poly_pol writeString: temp1)
					)
					(if (not (Message msgGET temp2 temp3 1 0 1))
						(if (not (= temp7 (MakeMessageText temp3 68 0 1 temp2 1)))
							(= temp7 (Str format: {%d} temp3))
						)
						(= temp1
							(Str
								format:
									{No LOOK V: Noun %s, Room %d\r\n}
									(temp7 data:)
									temp2
							)
						)
						(poly_pol writeString: temp1)
						(proc64896_7 temp7)
					)
					(for ((= temp4 1)) (< temp4 255) ((++ temp4))
						(for ((= temp5 0)) (< temp5 10) ((++ temp5))
							(if (Message msgGET temp2 temp3 temp4 temp5 1)
								(if (!= temp5 0)
									(if (not (Message msgGET temp2 temp3 temp4 0 1))
										(if
											(not
												(= temp7
													(MakeMessageText
														temp3
														68
														0
														1
														temp2
														1
													)
												)
											)
											(= temp7 (Str format: {%d} temp3))
										)
										(cond
											((proc64040_1 temp4)
												(= temp8
													(MakeMessageText
														0
														temp4
														0
														1
														12
														1
													)
												)
											)
											((proc64037_3 temp4)
												(= temp8
													(MakeMessageText
														0
														temp4
														0
														1
														11
														1
													)
												)
											)
											(else
												(= temp8
													(MakeMessageText
														0
														temp4
														0
														1
														13
														1
													)
												)
											)
										)
										(if (not temp8)
											(= temp8 (Str format: {%d} temp4))
										)
										(= temp1
											(Str
												format:
													{No ALL case: Noun: %s, Verb %s, Room %d\r\n}
													(temp7 data:)
													(temp8 data:)
													temp2
											)
										)
										(poly_pol writeString: temp1)
										(proc64896_7 temp7)
										(proc64896_7 temp8)
									)
									(break)
								)
								(temp6 at: temp4 temp2)
							)
						)
					)
				)
			)
		)
	)
	(poly_pol
		writeString:
			{\r\n\r\n***\r\nVerb use info\r\n***\r\n\r\nVerb    Room used\r\n}
	)
	(for ((= temp2 1)) (< temp2 255) ((++ temp2))
		(if (temp6 at: temp2)
			(= temp1 (Str format: {%4d    %4d\r\n} temp2 (temp6 at: temp2)))
			(poly_pol writeString: temp1)
		else
			(= temp1 (Str format: {%4d    *** NONE ***\r\n} temp2))
			(poly_pol writeString: temp1)
		)
	)
	(poly_pol close:)
	(PrintDebug {Done})
)

(instance debugSound of TPSound
	(properties)
)

(class Debugger of Code
	(properties)

	(method (dispose)
		(if local1
			(DeletePolygon local1 local2)
			(= local1 0)
		)
		(gOEventHandler unregisterGlobalHandler: self)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(gOEventHandler registerGlobalHandler: self)
		(= local1 0)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(KEY_QUESTION
						(event claimed: 1)
						(Prints
							{ ALT-Drag - drag&scale cast member around screen\nCTRL-LShft-Click - make nearest cast member current\nCTRL-Click - mouse coordinates\nCTRL-Arrow - move current view 1 pixel\n ALT-A     - add animation/view\n ALT-B     - caputure BMP\n ALT-C     - show Cast info\n ALT-D     - show current view info\n ALT-E     - show Ego\n ALT-F     - edit Features\n ALT-G     - show/set/clear Flag\n ALT-H     - show features and obstacles\n ALT-I     - get Inventory Item\n ALT-J     - load a pic\n ALT-K     - blinK current view\n ALT-M     - duMp a L7 message debug log\n ALT-N     - New palette\n ALT-P     - edit Polygons\n ALT-R     - show Room info\n ALT-S     - scaler tool on current actor\n ALT-T     - teleport\n ALT-U     - handsOn\n ALT-X     - exit the Game\n ALT-Y     - show room polygons\nDELETE     - delete current object\n8          - Rotate current (actor) right\n2          - Rotate current (actor) left\n4          - Decrease current (prop) cel\n6          - Increase current (prop) cel\n1          - Decrease current (prop) loop\n3          - Increase current (prop) loop\nCTRL-C     - Check audio card\nCTRL-G     - Give ego necessary items for room\nCTRL-L     - error logging\nCTRL-R     - Play a robot\nCTRL-D     - test a sounD\n}
						)
					)
					(KEY_DELETE
						(= temp23 (localproc_7 event))
						(if
							(not
								(= temp21
									(localproc_3
										(temp23 getMainCast:)
										Actor
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(if (not (KString 7 (temp21 name:) {temp})) ; StrCmp
							(temp21 dispose:)
							(= local3 0)
						)
					)
					(KEY_2
						(= temp23 (localproc_7 event))
						(if
							(not
								(= temp21
									(localproc_3
										(temp23 getMainCast:)
										Actor
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(localproc_5 temp21 45)
						(UpdateScreenItem temp21)
					)
					(KEY_8
						(= temp23 (localproc_7 event))
						(if
							(not
								(= temp21
									(localproc_3
										(temp23 getMainCast:)
										Actor
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(localproc_5 temp21 -45)
						(UpdateScreenItem temp21)
					)
					(KEY_6
						(= temp23 (localproc_7 event))
						(if
							(not
								(= temp21
									(localproc_3
										(temp23 getMainCast:)
										Prop
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(= temp24 (temp21 cel:))
						(if (< (temp21 cel:) (temp21 lastCel:))
							(temp21 cel: (+ (temp21 cel:) 1))
						else
							(temp21 cel: 0)
						)
						(PrintDebug {Cur Cel: %d} (temp21 cel:))
						(UpdateScreenItem temp21)
					)
					(KEY_4
						(= temp23 (localproc_7 event))
						(if
							(not
								(= temp21
									(localproc_3
										(temp23 getMainCast:)
										Prop
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(= temp24 (temp21 cel:))
						(if (> (temp21 cel:) 0)
							(temp21 cel: (- (temp21 cel:) 1))
						else
							(temp21 cel: (temp21 lastCel:))
						)
						(PrintDebug {Cur Cel: %d} (temp21 cel:))
						(UpdateScreenItem temp21)
					)
					(KEY_3
						(= temp23 (localproc_7 event))
						(if
							(not
								(= temp21
									(localproc_3
										(temp23 getMainCast:)
										Prop
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(= temp25 (temp21 loop:))
						(if (< (temp21 loop:) (temp21 lastLoop:))
							(temp21 loop: (+ (temp21 loop:) 1))
						else
							(temp21 loop: 0)
						)
						(PrintDebug {Cur Loop: %d} (temp21 loop:))
						(UpdateScreenItem temp21)
					)
					(KEY_1
						(= temp23 (localproc_7 event))
						(if
							(not
								(= temp21
									(localproc_3
										(temp23 getMainCast:)
										Prop
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(= temp25 (temp21 loop:))
						(if (> (temp21 loop:) 0)
							(temp21 loop: (- (temp21 loop:) 1))
						else
							(temp21 loop: (temp21 lastLoop:))
						)
						(PrintDebug {Cur Loop: %d} (temp21 loop:))
						(UpdateScreenItem temp21)
					)
					(KEY_LEFT
						(if (!= (event modifiers:) emCTRL)
							(return)
						)
						(= temp23 (localproc_7 event))
						(if
							(not
								(= temp21
									(localproc_3
										(temp23 getMainCast:)
										View
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(temp21 posn: (- (temp21 x:) 1) (temp21 y:))
						(PrintDebug {CurPos: %d, %d} (temp21 x:) (temp21 y:))
						(UpdateScreenItem temp21)
					)
					(KEY_RIGHT
						(if (!= (event modifiers:) emCTRL)
							(return)
						)
						(= temp23 (localproc_7 event))
						(if
							(not
								(= temp21
									(localproc_3
										(temp23 getMainCast:)
										View
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(temp21 posn: (+ (temp21 x:) 1) (temp21 y:))
						(PrintDebug {CurPos: %d, %d} (temp21 x:) (temp21 y:))
						(UpdateScreenItem temp21)
					)
					(KEY_UP
						(if (!= (event modifiers:) emCTRL)
							(return)
						)
						(= temp23 (localproc_7 event))
						(if
							(not
								(= temp21
									(localproc_3
										(temp23 getMainCast:)
										View
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(temp21 posn: (temp21 x:) (- (temp21 y:) 1))
						(PrintDebug {CurPos: %d, %d} (temp21 x:) (temp21 y:))
						(UpdateScreenItem temp21)
					)
					(KEY_DOWN
						(if (!= (event modifiers:) emCTRL)
							(return)
						)
						(= temp23 (localproc_7 event))
						(if
							(not
								(= temp21
									(localproc_3
										(temp23 getMainCast:)
										View
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(temp21 posn: (temp21 x:) (+ (temp21 y:) 1))
						(PrintDebug {CurPos: %d, %d} (temp21 x:) (temp21 y:))
						(UpdateScreenItem temp21)
					)
					(KEY_ALT_a
						(= temp23 (localproc_7 event))
						(if
							(and
								(= temp7 (localproc_0 {View #?}))
								(!= temp7 -1)
								(ResCheck rsVIEW temp7)
							)
							((= temp22 (Actor new:))
								name: {temp}
								x: (event x:)
								y: (event y:)
								view: temp7
								setCel: 0
								setLoop: 0
								cycleSpeed: (gEgo cycleSpeed:)
								moveSpeed: (gEgo moveSpeed:)
								scaleX: 0
								scaleY: 0
								scaleSignal: 0
								setScale: 0
								priority: 110
								fixPriority: 0
								setCycle: Walk
								init: temp23
							)
							(= local3 temp22)
							(UpdateScreenItem temp22)
							(FrameOut)
						else
							(Prints {That is not a valid view.})
						)
					)
					(JOY_RIGHT
						(Printf
							{Num Channels: %d\nAudio Rate:       %d\nAudio Bits:         %d}
							(DoAudio 13) ; AudChannels
							(DoAudio audRATE)
							(DoAudio 10) ; AudBits
						)
					)
					(KEY_ALT_b
						(= temp23 (localproc_7 event))
						(while
							(and
								(< local0 999)
								(= temp5 (Str format: {TP%03d.BMP} local0))
								(FileIO fiEXISTS (temp5 data:))
							)
							(++ local0)
						)
						(if (< local0 999)
							(SaveScreen (temp5 data:))
							(Printf {Screen saved as\n   %s} (temp5 data:))
						else
							(Prints
								{Sorry, no can do. How did you get so many files?}
							)
						)
					)
					(KEY_ALT_c
						(= temp23 (localproc_7 event))
						(if ((temp23 getMainCast:) size:)
							(for
								((= temp4 ((temp23 getMainCast:) first:)))
								temp4
								((= temp4 ((temp23 getMainCast:) next: temp4)))
								
								(= temp3 (KList 8 temp4)) ; NodeValue
								(if (not (localproc_1 temp3))
									(break)
								)
							)
						else
							(Prints {No One Home!})
							(return)
						)
					)
					(KEY_ALT_d
						(= temp23 (localproc_7 event))
						(if
							(not
								(= temp21
									(localproc_3
										(temp23 getMainCast:)
										View
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(localproc_1 temp21)
					)
					(KEY_ALT_e
						(= temp23 (localproc_7 event))
						(if
							((temp23 getMainCast:)
								contains: (gUser alterEgo:)
							)
							(localproc_1 (gUser alterEgo:))
						else
							(Prints {no ego!})
							(return)
						)
					)
					(KEY_ALT_f
						(= temp23 (localproc_7 event))
						(if (not (gFeatures size:))
							(PEditor init: 1 temp23)
						else
							(PEditor init: 0 temp23)
						)
						(for
							((= temp4 0))
							(< temp4 (gFeatures size:))
							((++ temp4))
							
							(= temp3 (gFeatures at: temp4))
							(if (temp3 onMeCheck:)
								(if ((temp3 onMeCheck:) isKindOf: List)
									(for
										((= temp10 0))
										(< temp10 ((temp3 onMeCheck:) size:))
										((++ temp10))
										
										(= temp8
											((temp3 onMeCheck:) at: temp10)
										)
										(PEditor addPolygon: temp8)
									)
								else
									(PEditor addPolygon: (temp3 onMeCheck:))
								)
								((PEditor at: (- (PEditor size:) 1))
									name: (temp3 name:)
								)
							)
						)
						(PEditor show: 1 scratch: 1)
						(FrameOut)
						(PEditor doit:)
						(= temp3 (Str new: 33))
						(= temp11 (Str new: 33))
						(temp11 format: {%hu.fea} gCurRoomNum)
						(Print
							addTitle: {Output File Name:}
							addEdit: temp3 12 0 0 temp11
							init:
						)
						(FrameOut)
						(poly_pol name: (temp3 data:) open: 0)
						(poly_pol
							writeString: {;***************************\r\n}
						)
						(= temp6 0)
						(if (PEditor size:)
							(= temp6 (Str newWith: 5 {}))
							(for
								((= temp8 (KList 3 (PEditor elements:)))) ; FirstNode
								temp8
								((= temp8 temp9))
								
								(= temp9 (KList 6 temp8)) ; NextNode
								(= temp11 (KList 8 temp8)) ; NodeValue
								(poly_pol writeString: {\r\n})
								(poly_pol writeString: {(instance })
								(poly_pol writeString: (temp11 name:))
								(poly_pol writeString: { of Feature\r\n})
								(poly_pol writeString: {\t(properties\r\n})
								(poly_pol writeString: {\t\tx})
								(= temp12 (= temp14 32767))
								(= temp13 (= temp15 0))
								(for
									((= temp4 0))
									(< temp4 (temp11 size:))
									((++ temp4))
									
									(temp11 indexToCoor: temp4)
									(if (< (temp11 currentX:) temp12)
										(= temp12 (temp11 currentX:))
									)
									(if (> (temp11 currentX:) temp13)
										(= temp13 (temp11 currentX:))
									)
									(if (< (temp11 currentY:) temp14)
										(= temp14 (temp11 currentY:))
									)
									(if (> (temp11 currentY:) temp15)
										(= temp15 (temp11 currentY:))
									)
								)
								(= temp0 (+ (/ (- temp13 temp12) 2) temp12))
								(= temp1 (+ (/ (- temp15 temp14) 2) temp14))
								(poly_pol writeString: {\t\t\t\t})
								(temp6 format: {%d} temp0)
								(poly_pol writeString: (temp6 data:))
								(poly_pol writeString: {\r\n})
								(poly_pol writeString: {\t\ty})
								(poly_pol writeString: {\t\t\t\t})
								(temp6 format: {%d} temp1)
								(poly_pol writeString: (temp6 data:))
								(poly_pol writeString: {\r\n})
								(poly_pol writeString: {\t)\r\n})
								(poly_pol writeString: {\t(method (init)\r\n})
								(poly_pol
									writeString: {\t\t(self setPolygon:\r\n}
								)
								(temp11 writeToFile: poly_pol)
								(poly_pol writeString: {\t\t)\r\n})
								(poly_pol
									writeString: {\t\t(super init: &rest)\r\n}
								)
								(poly_pol writeString: {\t)\r\n})
								(poly_pol writeString: {);})
								(poly_pol writeString: (temp11 name:))
								(poly_pol writeString: {\r\n})
							)
						)
						(poly_pol close:)
						(if temp6
							(temp6 dispose:)
						)
						(temp3 dispose:)
						(PEditor scratch: 0 dispose:)
					)
					(KEY_ALT_g
						(= temp23 (localproc_7 event))
						(= temp6 (Str newWith: 75 {}))
						(Print
							font: gUserFont
							y: 100
							addTextF: {Flag num (max %d)} 314
							addEdit: temp6 5 50
							init:
						)
						(if (>= (= temp4 (temp6 asInteger:)) 314)
							(Prints {Flag too large, ignoring})
							(return)
						)
						(temp6 dispose:)
						(switch
							(Print
								font: gUserFont
								y: 50
								addTextF:
									(if ((ScriptID 64017 0) test: temp4) ; oFlags
										{flag %d is SET}
									else
										{flag %d is CLEARED}
									)
									temp4
								addButton: 1 { set } 0 12
								addButton: 2 {clear} 0 26
								addButton: -1 {cancel} 0 40
								init:
							)
							(1
								((ScriptID 64017 0) set: temp4) ; oFlags
							)
							(2
								((ScriptID 64017 0) clear: temp4) ; oFlags
							)
						)
					)
					(JOY_LEFT
						(= temp23 (localproc_7 event))
						(if (and gCurRoom (gCurRoom respondsTo: #gimme))
							(gCurRoom gimme:)
						)
					)
					(KEY_ALT_h
						(= temp23 (localproc_7 event))
						(PEditor init: 1 temp23)
						(if (gCurRoom obstacles:)
							(PEditor readPolygonsFromList: (gCurRoom obstacles:))
						)
						(for
							((= temp4 0))
							(< temp4 (gFeatures size:))
							((++ temp4))
							
							(= temp3 (gFeatures at: temp4))
							(if (temp3 onMeCheck:)
								(if ((temp3 onMeCheck:) isKindOf: List)
									(for
										((= temp10 0))
										(< temp10 ((temp3 onMeCheck:) size:))
										((++ temp10))
										
										(= temp8
											((temp3 onMeCheck:) at: temp10)
										)
										(PEditor addPolygon: temp8)
									)
								else
									(PEditor addPolygon: (temp3 onMeCheck:))
								)
								((PEditor at: (- (PEditor size:) 1))
									name: (temp3 name:)
								)
							)
						)
						(PEditor show: dispose:)
					)
					(KEY_ALT_i
						(= temp23 (localproc_7 event))
						(gGame setCursor: (ScriptID 64006 0) 1) ; oSysCursor
						(repeat
							(= temp17 (= temp18 (= temp20 0)))
							(Print font: gSmallFont)
							(for
								((= temp19 0))
								(<
									temp19
									(((ScriptID 64037 0) oAllHandledItems:) ; oInvHandler
										size:
									)
								)
								((++ temp19))
								
								(if
									(not
										(= temp16
											(((ScriptID 64037 0) ; oInvHandler
													oAllHandledItems:
												)
												at: temp19
											)
										)
									)
								else
									(breakif (>= temp19 150))
									(Print
										addButton:
											temp19
											(temp16 name:)
											temp18
											temp17
									)
									((Print dialog:) setSize:)
									(if (> temp17 250)
										(= temp20 temp17)
										(= temp17 0)
										(= temp18
											(-
												((Print dialog:) nsRight:)
												((Print dialog:) nsLeft:)
											)
										)
									else
										(+= temp17 14)
									)
								)
							)
							(Print
								addButton:
									temp19
									{Exit}
									temp18
									(if temp20 temp20 else temp17)
							)
							(breakif (== (= temp21 (Print init:)) temp19))
							(gEgo
								get:
									(((ScriptID 64037 0) oAllHandledItems:) ; oInvHandler
										at: temp21
									)
							)
						)
						(Print font: gUserFont)
					)
					(KEY_ALT_j
						(= temp23 (localproc_7 event))
						(if
							(and
								(!=
									(= temp7
										(localproc_0
											{Pic #?}
											(gCurRoom picture:)
										)
									)
									-1
								)
								(!= temp7 -1)
								(ResCheck rsPIC temp7)
							)
							(gCurRoom picture: temp7)
							(gCurRoom drawPic: temp7)
							(FrameOut)
						else
							(Printf
								{Picture number %hu not available}
								temp7
							)
						)
					)
					(KEY_ALT_k
						(= temp23 (localproc_7 event))
						(if (not local3)
							(return)
						)
						(localproc_2 local3)
					)
					(KEY_CLEAR
						((ScriptID 64952 0) doit:) ; sysLogger
					)
					(KEY_ALT_m
						(localproc_8)
					)
					(KEY_ALT_n
						(if
							(and
								(= temp7 (localproc_0 {Palette #?}))
								(!= temp7 -1)
								(ResCheck rsPALETTE temp7)
							)
							(Palette 1 temp7) ; PalLoad
						)
					)
					(KEY_ALT_p
						(= temp23 (localproc_7 event))
						(if
							(or
								(not (gCurRoom obstacles:))
								(not ((gCurRoom obstacles:) size:))
							)
							(PEditor init: 1 temp23)
						else
							(PEditor init: 0 temp23)
						)
						(if (gCurRoom obstacles:)
							(PEditor readPolygonsFromList: (gCurRoom obstacles:))
						)
						(PEditor doit:)
						(= temp3 (Str new: 13))
						(= temp11 (Str new: 13))
						(temp11 format: {%hu.pol} gCurRoomNum)
						(Print
							addTitle: {Output File Name:}
							addEdit: temp3 12 0 0 temp11
							init:
						)
						(FrameOut)
						(poly_pol name: (temp3 data:) open: 0)
						(poly_pol writeString: {\t\t;********************\r\n})
						(poly_pol writeString: {\t\t(curRoom addObstacle:\r\n})
						(if (PEditor size:)
							(PEditor eachElementDo: #writeToFile poly_pol)
							(if (gCurRoom obstacles:)
								((gCurRoom obstacles:) dispose:)
								(gCurRoom obstacles: 0)
							)
							(for
								((= temp8 (KList 3 (PEditor elements:)))) ; FirstNode
								temp8
								((= temp8 temp9))
								
								(= temp9 (KList 6 temp8)) ; NextNode
								(= temp11 (KList 8 temp8)) ; NodeValue
								(gCurRoom
									addObstacle:
										((Polygon new:)
											type: (temp11 type:)
											size: (temp11 size:)
											dynamic: 1
											points:
												((IntArray new:)
													copy: (temp11 points:)
												)
											yourself:
										)
								)
							)
						)
						(poly_pol writeString: {\t\t)\r\n})
						(poly_pol close:)
						(temp3 dispose:)
						(PEditor dispose:)
					)
					(KEY_ALT_r
						(= temp23 (localproc_7 event))
						(Printf
							{name: %s\nnumber: %hu\npicture: %hu\nstyle: %d\nhorizon: %d\nnorth: %d\nsouth: %d\neast: %d\nwest: %d\nscript: %s }
							(gCurRoom name:)
							gCurRoomNum
							(gCurRoom picture:)
							(gCurRoom style:)
							(gCurRoom horizon:)
							(gCurRoom north:)
							(gCurRoom south:)
							(gCurRoom east:)
							(gCurRoom west:)
							(if (gCurRoom script:)
								((gCurRoom script:) name:)
							else
								{..none..}
							)
							506
							120
						)
					)
					(KEY_ALT_s
						(= temp23 (localproc_7 event))
						(if
							(not
								(= temp21
									(localproc_3
										(temp23 getMainCast:)
										Actor
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						((ScriptID 64012 0) init: temp21 temp23 doit: dispose:) ; scalerCode
					)
					(KEY_MENU
						(= temp23 (localproc_7 event))
						(if
							(and
								(> (= temp7 (localproc_0 {Robot #?} local4)) 0)
								(ResCheck 150 temp7) ; ROBOT
							)
							(= local4 temp7)
							(event localize: (gCurRoom plane:))
							(= gAutoRobot
								((WalkieTalkie new:)
									x: (event x:)
									y: (event y:)
									init: 0 temp7 0
									start:
									yourself:
								)
							)
						else
							(Printf {Robot number %hu not available} temp7)
						)
					)
					(JOY_DOWNRIGHT
						(= temp23 (localproc_7 event))
						(= temp3 (localproc_0 {Which sound number?}))
						(= temp4 (GetNumber {Loop?}))
						(if (and (!= temp3 0) (!= temp3 -1))
							(debugSound
								stop:
								setLoop: temp4
								number: temp3
								play:
							)
						)
					)
					(KEY_ALT_t
						(= global242 1)
						(if (> (= local5 (GetNumber {Teleport to})) 0)
							(gCurRoom newRoom: local5)
						)
					)
					(KEY_ALT_u
						(= temp23 (localproc_7 event))
						(gGame handsOn:)
					)
					(KEY_ALT_x
						(= temp23 (localproc_7 event))
						(= gQuit 1)
					)
					(KEY_ALT_y
						(= temp23 (localproc_7 event))
						(cond
							(local1 0)
							((gCurRoom obstacles:)
								(= local2 temp23)
								(= local1
									(AddPolygon local2 (gCurRoom obstacles:))
								)
							)
							(else
								(Prints
									{Sorry, this room has no polygons.}
								)
							)
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(evMOUSEBUTTON
				(switch (event modifiers:)
					(emCTRL
						(= temp23 (localproc_7 event))
						(PrintDebug { local: %d/%d} (event x:) (event y:))
						(event globalize:)
						(PrintDebug {global: %d/%d} (event x:) (event y:))
					)
					(emALT
						(= temp23 (localproc_7 event))
						(if
							(not
								(= temp21
									(localproc_4
										(temp23 getMainCast:)
										View
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(localproc_2 temp21)
						(= local3 temp21)
						(gEgo setMotion: 0)
						(while (!= ((= temp2 (Event new:)) type:) evMOUSERELEASE)
							(temp2 localize: temp23)
							(temp21 posn: (temp2 x:) (temp2 y:))
							(if
								(and
									(RespondsTo temp21 #scaler)
									(temp21 scaler:)
								)
								((temp21 scaler:) doit:)
							)
							(UpdateScreenItem temp21)
							(FrameOut)
							(temp2 dispose:)
						)
						(PrintDebug
							{; %s (#%d)\nposn: %d %d}
							(temp21 name:)
							temp21
							(temp21 x:)
							(temp21 y:)
						)
						(temp2 dispose:)
					)
					($0007 ; emCTRL | emSHIFT
						(= temp23 (localproc_7 event))
						(if
							(not
								(= temp21
									(localproc_4
										(temp23 getMainCast:)
										View
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(localproc_2 temp21)
						(= local3 temp21)
					)
				)
			)
		)
	)
)

(instance poly_pol of File
	(properties
		name {poly.pol}
	)
)

