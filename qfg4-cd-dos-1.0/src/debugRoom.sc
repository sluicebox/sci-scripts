;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use Interface)
(use Str)
(use Print)
(use Feature)
(use Sound)
(use File)
(use User)
(use System)

(public
	debugRoom 0
)

(local
	[local0 4]
)

(instance debugRoom of Feature
	(properties)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event &tmp temp0 temp1 [temp2 2] temp4 temp5 temp6 temp7 temp8 temp9 temp10 [temp11 6] temp17)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_QUESTION
						(Prints
							{Key commands:\nALT-A show cAst\nALT-O create Obstacles\nALT-F Show Features\nALT-W Write features\nALT-Y show pallete\nALT-R show Room\nALT-E show Ego\nALT-M show Memory\nALT-T Teleport\nALT-V Visual\nALT-P Priority\nALT-C Learn a new Spell\n}
						)
						(Prints
							{ALT-I get InvItem\nALT-G Set/Clear flag\nALT-B set ego's Bucks\nALT-D toggle debugging\nALT-H set Hour of day\nALT-K set one of ego's sKills\nALT-X make ego eXtra special\nALT-U return User control and input\nALT-S Shift user alterego CTRL L note Logger}
						)
					)
					(KEY_ALT_e
						(= temp17
							(if global444
								global444
							else
								(User alterEgo:)
							)
						)
						(= temp6 (Str new:))
						(temp6
							format:
								{name: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: %d\n\n\n\n\n\n\n}
								(temp17 name:)
								(temp17 view:)
								(temp17 loop:)
								(temp17 cel:)
								(temp17 x:)
								(temp17 y:)
								(temp17 z:)
								(temp17 heading:)
								(temp17 priority:)
								(temp17 signal:)
						)
						(Print
							width: 300
							addIcon:
								(temp17 view:)
								(temp17 loop:)
								(temp17 cel:)
								120
								80
							addText: temp6 0 0
							init:
						)
						(temp6 dispose:)
					)
					(KEY_ALT_i
						(= temp4 (GetNumber {Inventory item #:}))
						(gEgo get: temp4)
					)
					(JOY_UP
						(for ((= temp4 1)) (< temp4 57) ((++ temp4))
							((gInventory at: temp4)
								amount: (+ ((gInventory at: temp4) amount:) 1)
								owner: gEgo
							)
						)
					)
					(KEY_ALT_t
						(if (> (= temp8 (GetNumber {Which room number?})) 0)
							(gCurRoom newRoom: temp8)
						)
					)
					(KEY_ALT_z
						(Prints
							{Debug: CLEAR THE CURRENT PALETTE. Note: This is a one way trip.}
						)
						(PalVary 1 0) ; PalVaryReverse
					)
					(KEY_ALT_h
						((ScriptID 7 4) init: (GetNumber {Hour: (1 - 24)}) 0) ; fixTime
					)
					(KEY_ALT_v)
					(KEY_ALT_p)
					(KEY_ALT_d
						(if gDebugging
							(= gDebugging 0)
							(Prints {debugging off})
						else
							(= gDebugging 1)
							(Prints {debugging on})
						)
					)
					(KEY_ALT_m
						(gGlory showMem:)
					)
					(KEY_ALT_s
						(= temp4 (GetNumber {cast member #?}))
						(= global444 (gCast at: temp4))
					)
					(KEY_ALT_n 0)
					(KEY_ALT_a
						(= temp6 (Str new: 200))
						(for
							((= temp8 (gCast first:)))
							temp8
							((= temp8 (gCast next: temp8)))
							
							(= temp1 (NodeValue temp8))
							(temp6
								format:
									{name: %s\nclass: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\n\n\n\n\n\n\n\n\n\n\n}
									(temp1 name:)
									((temp1 -super-:) name:)
									(temp1 view:)
									(temp1 loop:)
									(temp1 cel:)
									(temp1 x:)
									(temp1 y:)
									(temp1 z:)
									(temp1 heading:)
									(temp1 priority:)
									(temp1 signal:)
							)
							(Print
								width: 300
								addIcon:
									(temp1 view:)
									(temp1 loop:)
									(temp1 cel:)
									120
									80
								addText: temp6 0 0
								init:
							)
							(FrameOut)
						)
						(temp6 dispose:)
					)
					(KEY_ALT_o
						(Unknown_Class_170 init:)
						(if (gCurRoom obstacles:)
							(Unknown_Class_170
								readPolygonsFromList: (gCurRoom obstacles:)
							)
						)
						(Unknown_Class_170 doit:)
						(= temp1 (Str new: 13))
						(= temp10 (Str new: 13))
						(temp10 format: {%d.pol} gCurRoomNum)
						(Print
							font: 300
							fore: 0
							back: 255
							skip: 255
							largeAlp: 0
							addText: {Output File Name:} 0 0
							addEdit: temp1 12 0 12 temp10
							init:
						)
						(FrameOut)
						(poly_pol name: (temp1 data:) open: 0)
						(poly_pol writeString: {\t\t;********************\0d\n})
						(poly_pol writeString: {\t\t(curRoom addObstacle:\0d\n})
						(if (Unknown_Class_170 size:)
							(Unknown_Class_170
								eachElementDo: #writeToFile poly_pol
							)
						)
						(poly_pol writeString: {\t\t)\0d\n})
						(poly_pol close:)
						(temp1 dispose:)
						(Unknown_Class_170 dispose:)
					)
					(KEY_ALT_f)
					(KEY_ALT_g
						(= temp4 (GetNumber {Flag Number:}))
						(if (IsFlag temp4)
							(Prints {clearing flag})
							(ClearFlag temp4)
						else
							(Prints {setting flag})
							(SetFlag temp4)
						)
					)
					(KEY_ALT_w)
					(KEY_ALT_y)
					(KEY_ALT_r
						(= temp6 (Str new: 100))
						(temp6
							format:
								{name: %s\nnumber: %d\ncurrent pic: %d\nstyle: %d\nhorizon: %d\nnorth: %d\nsouth: %d\neast: %d\nwest: %d\nscript: %s }
								(gCurRoom name:)
								gCurRoomNum
								(gCurRoom curPic:)
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
						)
						(Prints temp6)
						(temp6 dispose:)
						(gGlory showMem:)
					)
					(KEY_ALT_u
						(User canInput: 1 canControl: 1)
						(gTheIconBar enable: 0 1 2 3 4 5 6 7)
					)
					(KEY_ALT_b
						(Printf
							{You have %d Crowns and %d Kopeks.}
							((gInventory at: 0) amount:) ; thePurse
							global395
						)
						((gInventory at: 0) amount: (GetNumber {Enter Crowns:})) ; thePurse
						(if
							(or
								(= global395 (GetNumber {Enter Kopeks:}))
								((gInventory at: 0) amount:) ; thePurse
							)
							((gInventory at: 0) message: 15) ; thePurse
						)
					)
					(KEY_ALT_k
						(= temp5 (GetNumber {Change which Stat/Skill?}))
						(= [gEgoStats temp5]
							(GetNumber {Enter new value:} [gEgoStats temp5])
						)
					)
					(KEY_ALT_x
						(= temp8 (GetNumber {Set stats to what?}))
						(for ((= temp5 0)) (< temp5 20) ((++ temp5))
							(= [gEgoStats temp5] temp8)
						)
						(= [gEgoStats 16] 1900) ; experience
						(= [gEgoStats 17] (gEgo maxHealth:)) ; health
						(= [gEgoStats 18] (gEgo maxStamina:)) ; stamina
						(= [gEgoStats 19] (gEgo maxMana:)) ; mana
						(for ((= temp4 0)) (< temp4 22) ((++ temp4))
							(= [gEgoStats (+ 20 temp4)] temp8)
						)
						(= global394 1)
						(SetFlag 20)
						((gInventory at: 18) state: 1) ; theShield
						((gInventory at: 19) state: 1) ; theSword
						((ScriptID 0 21) doit: gCurRoomNum) ; statusCode
					)
					(KEY_ALT_l)
					(KEY_ALT_c
						(for ((= temp4 20)) (< temp4 42) ((++ temp4))
							(if (not [gEgoStats temp4])
								(= [gEgoStats temp4] 10)
								(= temp4 999)
								(Printf
									{[egoStats i] is %d}
									[gEgoStats temp4]
								)
							)
						)
					)
					(KEY_CLEAR
						((ScriptID 64952) doit: gSysLogPath 0) ; sysLogger
					)
					(KEY_PAUSE
						(= temp5 (GetNumber {which sound number?}))
						(gLongSong number: temp5 setLoop: 0 play:)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(evMOUSEBUTTON
				(switch (event modifiers:)
					($000d 0) ; emALT | emCTRL | emRIGHT_SHIFT
					($000e 0) ; emALT | emCTRL | emLEFT_SHIFT
					($000c ; emALT | emCTRL
						(event claimed: 1)
						(= temp6 (Str new:))
						(temp6 format: {%d/%d} (event x:) (event y:))
						(= temp7
							(Print
								addText: (temp6 data:)
								posn: 160 10
								font: 999
								init:
							)
						)
						(while (!= evMOUSERELEASE ((= temp0 (Event new:)) type:))
							(temp0 dispose:)
						)
						(temp0 dispose:)
						(temp6 dispose:)
					)
					($0005 ; emCTRL | emRIGHT_SHIFT
						(event type: evKEYBOARD message: KEY_ALT_r)
						(self handleEvent: event)
					)
					($0006 ; emCTRL | emLEFT_SHIFT
						(event type: evKEYBOARD message: KEY_ALT_e)
						(self handleEvent: event)
					)
					($0009 0) ; emALT | emRIGHT_SHIFT
					($000a 0) ; emALT | emLEFT_SHIFT
					(emRIGHT_SHIFT 0)
					(emLEFT_SHIFT 0)
					(emCTRL 0)
					(emALT
						(event claimed: 1)
						(= temp17
							(if global444
								global444
							else
								(User alterEgo:)
							)
						)
						(gEgo setMotion: 0)
						(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
							(temp17 x: (temp0 x:) y: (- (temp0 y:) 10))
							(UpdateScreenItem temp17)
							(FrameOut)
							(temp0 dispose:)
						)
						(temp0 dispose:)
					)
				)
			)
		)
	)
)

(instance soundTest of Sound ; UNUSED
	(properties)
)

(instance poly_pol of File
	(properties
		name {poly.pol}
	)

	(method (open param1)
		(= handle
			(switch argc
				(0
					(FileIO fiOPEN name 0)
				)
				(1
					(FileIO fiOPEN name param1)
				)
				(else 0)
			)
		)
		(if (== handle -1)
			(= handle 0)
		)
		(return (if handle self else 0))
	)

	(method (writeString param1 &tmp temp0)
		(if (not handle)
			(self open:)
		)
		(if handle
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(if (not (FileIO fiWRITE_STRING handle (KString 9 [param1 temp0]))) ; StrGetData
					(return 0)
				)
			)
		)
		(return 1)
	)

	(method (close)
		(if handle
			(FileIO fiCLOSE handle)
			(= handle 0)
		)
	)

	(method (dispose)
		(self close:)
		(super dispose:)
	)
)

