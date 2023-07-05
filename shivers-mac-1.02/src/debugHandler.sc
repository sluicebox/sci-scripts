;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 940)
(include sci.sh)
(use Main)
(use n951)
(use soundRoom)
(use Interface)
(use DText)
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
	proc940_1 1
	proc940_2 2
	proc940_3 3
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 6]
)

(procedure (proc940_1 &tmp temp0 temp1 temp2 [temp3 2] temp5 [temp6 2])
	(= temp2 (Str newWith: 10 {}))
	((= temp5 (Print new:))
		font: gSmallFont
		fore: 255
		back: 0
		addText: {Where to?}
		addEdit: temp2 5 50 0
	)
	(= temp1 (temp5 init:))
	(= temp1 (temp2 asInteger:))
	(gCurRoom newRoom: temp1)
	(gGame handsOn:)
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(= temp0 (Str newWith: 75 {}))
	(= temp1
		(Print
			font: gSmallFont
			y: 20
			addText: {Which entity?}
			addButton: 0 { water } 0 10
			addButton: 1 {wax} 0 20
			addButton: 2 {ash} 0 30
			addButton: 3 {tar} 0 40
			addButton: 4 {fabric} 0 50
			addButton: 5 {wood} 0 60
			addButton: 6 {crystal} 0 70
			addButton: 7 {electric} 0 80
			addButton: 8 {sand} 0 90
			addButton: 9 {metal} 0 100
			addButton: -1 {cancel} 0 110
			init:
		)
	)
	(= temp2 -1)
	(if (>= temp1 0)
		(= temp2 [global164 (* 2 temp1)])
	)
	(switch temp1
		(0
			(= temp2
				(Print
					font: gSmallFont
					y: 60
					addTextF: {water is in %d} temp2
					addButton: 3000 { lake } 0 10
					addButton: 9000 {main hall} 0 20
					addButton: 25000 {closet} 0 30
					addButton: 0 {none} 0 40
					addButton: -1 {cancel} 0 50
					init:
				)
			)
		)
		(1
			(= temp2
				(Print
					font: gSmallFont
					y: 60
					addTextF: {wax is in %d} temp2
					addButton: 8000 { library } 0 10
					addButton: 22000 {shaman} 0 20
					addButton: 24000 {myths} 0 30
					addButton: 0 {none} 0 40
					addButton: -1 {cancel} 0 50
					init:
				)
			)
		)
		(2
			(= temp2
				(Print
					font: gSmallFont
					y: 60
					addTextF: {ash is in %d} temp2
					addButton: 6000 { office } 0 10
					addButton: 21000 {funeral} 0 20
					addButton: 0 {none} 0 30
					addButton: -1 {cancel} 0 40
					init:
				)
			)
		)
		(3
			(= temp2
				(Print
					font: gSmallFont
					y: 60
					addTextF: {tar is in %d} temp2
					addButton: 11000 { strange beasts } 0 10
					addButton: 14000 {subterranean} 0 20
					addButton: 0 {none} 0 30
					addButton: -1 {cancel} 0 40
					init:
				)
			)
		)
		(4
			(= temp2
				(Print
					font: gSmallFont
					y: 60
					addTextF: {fabric is in %d} temp2
					addButton: 20000 { tombs } 0 10
					addButton: 21000 {funeral} 0 20
					addButton: 25000 {closet} 0 30
					addButton: 0 {none} 0 40
					addButton: -1 {cancel} 0 50
					init:
				)
			)
		)
		(5
			(= temp2
				(Print
					font: gSmallFont
					y: 60
					addTextF: {wood is in %d} temp2
					addButton: 7000 { workshop } 0 10
					addButton: 23000 {gods} 0 20
					addButton: 24000 {myths} 0 30
					addButton: 36000 {2nd flr. pass.} 0 40
					addButton: 0 {none} 0 50
					addButton: -1 {cancel} 0 60
					init:
				)
			)
		)
		(6
			(= temp2
				(Print
					font: gSmallFont
					y: 60
					addTextF: {crystal is in %d} temp2
					addButton: 9000 { main hall } 0 10
					addButton: 12000 {mysteries of the deep} 0 20
					addButton: 0 {none} 0 30
					addButton: -1 {cancel} 0 40
					init:
				)
			)
		)
		(7
			(= temp2
				(Print
					font: gSmallFont
					y: 60
					addTextF: {electric is in %d} temp2
					addButton: 29000 { planetarium } 0 10
					addButton: 32000 {man's inhumanity} 0 20
					addButton: 39000 {mechanical} 0 30
					addButton: 0 {none} 0 40
					addButton: -1 {cancel} 0 50
					init:
				)
			)
		)
		(8
			(= temp2
				(Print
					font: gSmallFont
					y: 60
					addTextF: {sand is in %d} temp2
					addButton: 19000 { plants } 0 10
					addButton: 12000 {mysteries of the deep} 0 20
					addButton: 0 {none} 0 30
					addButton: -1 {cancel} 0 40
					init:
				)
			)
		)
		(9
			(= temp2
				(Print
					font: gSmallFont
					y: 60
					addTextF: {metal is in %d} temp2
					addButton: 11000 { strange beasts } 0 10
					addButton: 17000 {projection} 0 20
					addButton: 37000 {bedroom} 0 30
					addButton: 0 {none} 0 40
					addButton: -1 {cancel} 0 50
					init:
				)
			)
		)
	)
	(if (!= temp2 -1)
		(= [global164 (* 2 temp1)] temp2)
	)
)

(procedure (proc940_3)
	(gCast eachElementDo: #perform showApproach)
	(gFeatures eachElementDo: #perform showApproach)
)

(procedure (localproc_1 param1)
	(DeletePolygon param1 gThePlane)
)

(procedure (proc940_2 &tmp temp0 temp1)
	(for ((= temp0 1)) (<= temp0 15) ((++ temp0))
		(if [global304 temp0]
			(while ([global304 temp0] size:)
				(DeleteLine
					(= temp1 ([global304 temp0] at: 0))
					(gCast plane:)
				)
				([global304 temp0] delete: temp1)
			)
			(= [global304 temp0] 0)
		)
	)
	(UpdatePlane (gCast plane:))
	(FrameOut)
	(= global321 -1)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2 temp3)
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
		(= local1 0)
		(= global342 0)
		(= local2 0)
		(= local0 0)
		(= local3 0)
		(= local4 0)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 [temp5 5] temp10 temp11 temp12 [temp13 2] temp15 [temp16 13] temp29 temp30 [temp31 7] temp38)
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
							{ ALT-C - show Cursor coordinates\nCTRL-F - show Features\nALT-F - Flag set/clear\nALT-G - set Global variables\nALT-H - Help\nALT-I - show Inventory items\nALT-M - show Memory\nALT-P - show Palette\nCTRL-P - load Picture\nALT-R - show Room info\nCTRL-R - force purge, show memory\nALT-S - test Sound\nCTRL-S - stop all sounds\nALT-T - Teleport\nCTRL-T - show priority Map\nALT-W - show polygons\nALT-X - Quit\nCTRL-D - Toggle Entity Debugging\nCTRL-E - Place Entity }
						)
					)
					(JOY_UP
						(proc951_2 10)
					)
					(KEY_U
						(= [local5 0] 0)
						(= [local5 1] 0)
						(= [local5 2] 0)
						(= [local5 3] 0)
						(= [local5 4] 0)
						(= [local5 5] 0)
						(= temp12 (SoundManager first:))
						(for ((= temp15 0)) temp12 ((++ temp15))
							(= temp38 (KList 8 temp12)) ; NodeValue
							(= [local5 temp15] (temp38 number:))
							(= temp12 (SoundManager next: temp12))
						)
						(Print
							font: gSmallFont
							addTextF:
								{Channel1#%d\nChannel2#%d\nChannel3#%d\nChannel4#%d\nChannel5#%d\nChannel6#%d}
								[local5 0]
								[local5 1]
								[local5 2]
								[local5 3]
								[local5 4]
								[local5 5]
							init:
						)
					)
					(KEY_ADD
						(PrintDebug {+score})
						(proc951_15 (Random 1 1000))
					)
					(KEY_SUBTRACT
						(PrintDebug {-score})
						(proc951_15 (Random -1000 -1))
					)
					($001a
						(proc951_2 -10)
					)
					(KEY_A)
					(KEY_C
						(Print
							font: gSmallFont
							addTextF: {Cur X: %d,Y: %d} (event x:) (event y:)
							init:
						)
					)
					(KEY_D
						(if (== global186 1)
							(= global186 0)
						else
							(= global186 1)
						)
					)
					(JOY_DOWNRIGHT
						(if (IsFlag 44)
							(ClearFlag 44)
						else
							(SetFlag 44)
						)
					)
					(JOY_DOWN
						(localproc_0)
					)
					(JOY_DOWNLEFT
						(if (!= global321 -1)
							(if local0
								(local0 dispose:)
								(= local0 0)
								(= local4 0)
							)
							(localproc_1 global342)
							(= global342 0)
							(= local2 0)
							(proc940_2)
						else
							(if (gFeatures size:)
								(if local2
									(local2 dispose:)
								)
								(= local2 (List new:))
								(= global342 (localproc_2 local2))
								(= global321 1)
							)
							(proc940_3)
						)
					)
					(KEY_F
						(= temp0 (Str newWith: 75 {}))
						(Print
							font: gUserFont
							y: 60
							addText: {Flag num?}
							addEdit: temp0 5 60
							init:
						)
						(= temp15 (temp0 asInteger:))
						(switch
							(Print
								font: gUserFont
								y: 60
								addTextF:
									(if (IsFlag temp15)
										{flag %d is SET}
									else
										{flag %d is CLEARED}
									)
									temp15
								addButton: 1 { set } 0 15
								addButton: 2 {clear} 0 35
								addButton: -1 {cancel} 0 55
								init:
							)
							(1
								(SetFlag temp15)
							)
							(2
								(ClearFlag temp15)
							)
						)
					)
					(KEY_G
						(GetInput temp0 5 {Variable No.})
						(if (not (= temp4 (temp0 asInteger:)))
							(return)
						)
						(GetInput temp0 5 {Value})
						(= [gEgo temp4] (temp0 asInteger:))
					)
					(KEY_H
						(Print
							font: gSmallFont
							addText:
								{ ALT-C - show Cursor coordinates\nCTRL-F - show Features\nALT-F - Flag set/clear\nALT-G - set Global variables\nALT-H - Help\nALT-I - get Inventory item\nALT-M - show Memory\nALT-P - show Palette\nCTRL-P - load Picture\nALT-R - show Room info\nCTRL-R - force purge, show memory\nALT-S - test Sound\nCTRL-S - stop all sounds\nALT-T - Teleport\nCTRL-T - show priority Map\nALT-W - show polygons\nALT-X - Quit\nCTRL-D - Toggle Entity Debugging\nCTRL-E - Place Entity }
							init:
						)
					)
					(KEY_I
						(temp0
							format:
								{%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d -> %d\n%d ->%d\n}
								[global118 0]
								[global118 1]
								[global118 2]
								[global118 3]
								[global118 4]
								[global118 5]
								[global118 6]
								[global118 7]
								[global118 8]
								[global118 9]
								[global118 10]
								[global118 11]
								[global118 12]
								[global118 13]
								[global118 14]
								[global118 15]
								[global118 16]
								[global118 17]
								[global118 18]
								[global118 19]
								[global118 20]
								[global118 21]
								[global118 22]
								[global118 23]
								[global118 24]
								[global118 25]
								[global118 26]
								[global118 27]
								[global118 28]
								[global118 29]
								[global118 30]
								[global118 31]
								[global118 32]
								[global118 33]
								[global118 34]
								[global118 35]
								[global118 36]
								[global118 37]
								[global118 38]
								[global118 39]
								[global118 40]
								[global118 41]
								[global118 42]
								[global118 43]
								[global118 44]
								[global118 45]
						)
						(Print
							addText:
								{Vessels=200-209, Talismans=210-219, Pots=220-229\n}
								0
								0
							addText:
								{Water=2#0, Wax=2#1, Ash=2#2, Tar=2#3, Fabric=2#4, Wood=2#5, Crystal=2#6, Electric=2#7, Sand=2#8, Metal=2#9\n}
								0
								10
							addText: temp0 0 30
							init:
						)
					)
					(KEY_TAB
						(GetInput temp0 5 {Intensify number?})
						(= temp4 (temp0 asInteger:))
						(Palette 2 95 235 temp4) ; PalIntensity
					)
					(KEY_M
						(gGame showMem:)
					)
					(KEY_CAPITAL
						(= temp29 (GetNumber {x:} (gEgo x:)))
						(= temp30 (GetNumber {y:} (gEgo y:)))
						(gEgo posn: temp29 temp30)
					)
					(KEY_P)
					(KEY_SHIFT
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
					(KEY_R
						(temp0
							format:
								{Current Room\nname: %s\nscript: %s\nhorizon: %d\nvanishingX: %d\nvanishingY: %d\npicAngle: %d\nnorth: %d\nsouth: %d\neast: %d\nwest: %d\nstyle: %d\ncurPic: %d\nrobot: %d}
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
								(if gAutoRobot
									(gAutoRobot robot:)
								else
									0
								)
						)
						(Print font: gSmallFont addText: temp0 0 0 init:)
					)
					(KEY_MENU
						(Purge 20000)
						(gGame showMem:)
					)
					(KEY_W
						(= temp10 (GetNumber {which sound number?}))
						(= temp15 (GetNumber {setLoop?}))
						(gSounds play: temp10 temp15 122 0)
					)
					(KEY_PAUSE
						(gSounds stopAll:)
					)
					(KEY_T
						(proc940_1)
					)
					(KEY_X
						(= gQuit 1)
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
		(if local1
			(DeletePolygon local1 gThePlane)
			(= local1 0)
		)
		(if global342
			(DeletePolygon global342 gThePlane)
			(= global342 0)
		)
		(if local0
			(local0 dispose:)
			(= local0 0)
			(= local4 0)
		)
		(if local2
			(local2 dispose:)
			(= local2 0)
		)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)
)

(instance poly_pol of File ; UNUSED
	(properties
		name {poly.pol}
	)
)

(instance ourPlane of Plane ; UNUSED
	(properties)
)

(instance PalDisplay of Code ; UNUSED
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

(instance showApproach of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if [global304 (++ global321)]
			(proc940_2)
		)
		(if
			(or
				(not
					(InRect
						27
						7
						289
						148
						(param1 approachX:)
						(param1 approachY:)
					)
				)
				(not global321)
				(== param1 gEgo)
			)
			(return 0)
		else
			(= temp7 1)
			(= [global304 global321] (Set new:))
			(= temp0 (- (param1 approachX:) 1))
			(= temp1 (param1 approachY:))
			(= temp2 (+ (param1 approachX:) 1))
			(= temp3 (- (param1 approachY:) 1))
			(= temp4 (param1 approachX:))
			(= temp5 (+ (param1 approachY:) 1))
			([global304 global321]
				add:
					(AddLine
						(gCast plane:)
						temp0
						temp1
						temp2
						temp1
						255
						temp7
						0
						0
						1
					)
			)
			([global304 global321]
				add:
					(AddLine
						(gCast plane:)
						temp4
						temp3
						temp4
						temp5
						255
						temp7
						0
						0
						1
					)
			)
		)
		(UpdatePlane (gCast plane:))
		(return (FrameOut))
	)
)

(instance featureCheck of Code ; UNUSED
	(properties)

	(method (doit &tmp temp0 temp1)
		((gUser curEvent:) localize: (gCast plane:))
		(= temp0 ((gUser curEvent:) x:))
		(= temp1 ((gUser curEvent:) y:))
		(cond
			((= local3 (gFeatures firstTrue: #onMe temp0 temp1))
				(if (!= local4 local3)
					(if local0
						(local0 dispose:)
						(= local0 0)
					)
					((= local0 (DText new:))
						text: (KString 8 (local3 name:)) ; StrDup
						fore: 255
						back: 0
						setSize: 240
						setPri: 255
					)
					(if (< temp0 145)
						(local0 posn: 188 30 init:)
					else
						(local0 posn: 65 30 init:)
					)
					(= local4 local3)
					(= local3 0)
				)
			)
			(local0
				(local0 dispose:)
				(= local0 0)
				(= local4 0)
			)
		)
	)
)

