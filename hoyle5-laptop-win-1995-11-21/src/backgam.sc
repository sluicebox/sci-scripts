;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1300)
(include sci.sh)
(use Main)
(use KeyMouse)
(use TrackingView)
(use h5Messager)
(use BGPlayer)
(use dummyPublic0)
(use Str)
(use IconBar)
(use File)
(use Actor)
(use System)

(public
	backgam 0
	proc1300_1 1
	off2 2
	proc1300_3 3
)

(local
	local0
	local1
)

(procedure (proc1300_1)
	(IconBarF darken:)
	((ScriptID 1380 0) init:) ; scoreBackgammon
	(DisposeScript 1380)
	(IconBarF lighten:)
)

(procedure (proc1300_3 param1)
	(if argc
		(= local0 param1)
	else
		(return local0)
	)
)

(instance backgam of HoyleRoom
	(properties
		style 0
	)

	(method (init &tmp [temp0 2])
		(= local1 0)
		(= gCardGameScriptNumber 1300)
		(= global189 0)
		(= global773 0)
		(= global876 1)
		(= local0 0)
		((= gBackgam_opt backgam_opt) doit:)
		(if global878
			(PlaySong play: (+ 50 global878))
		else
			(PlaySong play: 51)
		)
		(if (not local0)
			(gSong setLoop: 1)
		)
		(= picture (+ global877 global385))
		(gChar1 posn: 60 60 show: init:)
		(Characters init:)
		((gChar1 face:) view: (gChar1 view:))
		(super init: &rest)
		(backgammonBoard init:)
		(Load rsVIEW 1300)
		(Load rsVIEW 1301)
		(Load rsVIEW 1302)
		(Load rsVIEW 1371)
		(Load rsVIEW 1370)
		(Load rsVIEW 1380)
		(if (not global921)
			(Load 140 809) ; WAVE
			(Load 140 810) ; WAVE
		)
		(= gACast aCast)
		((= gTheBar1 theBar1)
			add:
				stone1
				stone2
				stone3
				stone4
				stone5
				stone6
				stone7
				stone8
				stone9
				stone10
				stone11
				stone12
				stone13
				stone14
				stone15
		)
		((= gTheBar2 theBar2)
			add:
				stone16
				stone17
				stone18
				stone19
				stone20
				stone21
				stone22
				stone23
				stone24
				stone25
				stone26
				stone27
				stone28
				stone29
				stone30
		)
		(= global753 theBGPlayer1)
		(= global754 theBGPlayer2)
		(if (and (== (global753 type:) 1) (== global876 1))
			(= global753 theBGPlayer2)
			(= global754 theBGPlayer1)
		)
		(global753 skill: global195 type: 0 playerName: {You})
		(global754 skill: gSkill type: 1 playerName: {Computer})
		(= global782 (if (== (global753 type:) 0) global753 else global754))
		(= gGamePlayScript gamePlayScript)
		(= gTheArrow theArrow)
		(if (!= global876 2)
			(= global765 0)
		)
		(= gAllStonesObj allStonesObj)
		(= gAssocPoint assocPoint)
		(= global769 0)
		((= gTheDice3 theDice3) hide:)
		((= gTheDice4 theDice4) hide:)
		(global753
			add:
				off1
				(ScriptID 1303 4) ; point1
				(ScriptID 1303 5) ; point2
				(ScriptID 1303 6) ; point3
				(ScriptID 1303 7) ; point4
				(ScriptID 1303 8) ; point5
				(ScriptID 1303 9) ; point6
				(ScriptID 1303 10) ; point7
				(ScriptID 1303 11) ; point8
				(ScriptID 1303 12) ; point9
				(ScriptID 1303 13) ; point10
				(ScriptID 1303 14) ; point11
				(ScriptID 1303 15) ; point12
				(ScriptID 1303 16) ; point13
				(ScriptID 1303 17) ; point14
				(ScriptID 1303 18) ; point15
				(ScriptID 1303 19) ; point16
				(ScriptID 1303 20) ; point17
				(ScriptID 1303 21) ; point18
				(ScriptID 1303 22) ; point19
				(ScriptID 1303 23) ; point20
				(ScriptID 1303 24) ; point21
				(ScriptID 1303 25) ; point22
				(ScriptID 1303 26) ; point23
				(ScriptID 1303 27) ; point24
				gTheBar1
			init:
		)
		(global754
			add:
				off2
				(ScriptID 1303 27) ; point24
				(ScriptID 1303 26) ; point23
				(ScriptID 1303 25) ; point22
				(ScriptID 1303 24) ; point21
				(ScriptID 1303 23) ; point20
				(ScriptID 1303 22) ; point19
				(ScriptID 1303 21) ; point18
				(ScriptID 1303 20) ; point17
				(ScriptID 1303 19) ; point16
				(ScriptID 1303 18) ; point15
				(ScriptID 1303 17) ; point14
				(ScriptID 1303 16) ; point13
				(ScriptID 1303 15) ; point12
				(ScriptID 1303 14) ; point11
				(ScriptID 1303 13) ; point10
				(ScriptID 1303 12) ; point9
				(ScriptID 1303 11) ; point8
				(ScriptID 1303 10) ; point7
				(ScriptID 1303 9) ; point6
				(ScriptID 1303 8) ; point5
				(ScriptID 1303 7) ; point4
				(ScriptID 1303 6) ; point3
				(ScriptID 1303 5) ; point2
				(ScriptID 1303 4) ; point1
				gTheBar2
			init:
		)
		((= gThePoints thePoints)
			add:
				off1
				off2
				(ScriptID 1303 4) ; point1
				(ScriptID 1303 5) ; point2
				(ScriptID 1303 6) ; point3
				(ScriptID 1303 7) ; point4
				(ScriptID 1303 8) ; point5
				(ScriptID 1303 9) ; point6
				(ScriptID 1303 10) ; point7
				(ScriptID 1303 11) ; point8
				(ScriptID 1303 12) ; point9
				(ScriptID 1303 13) ; point10
				(ScriptID 1303 14) ; point11
				(ScriptID 1303 15) ; point12
				(ScriptID 1303 16) ; point13
				(ScriptID 1303 17) ; point14
				(ScriptID 1303 18) ; point15
				(ScriptID 1303 19) ; point16
				(ScriptID 1303 20) ; point17
				(ScriptID 1303 21) ; point18
				(ScriptID 1303 22) ; point19
				(ScriptID 1303 23) ; point20
				(ScriptID 1303 24) ; point21
				(ScriptID 1303 25) ; point22
				(ScriptID 1303 26) ; point23
				(ScriptID 1303 27) ; point24
				gTheBar1
				gTheBar2
		)
		((= gTheDiceList theDiceList) init:)
		((= gTheDoubleCube theDoubleCube) init:)
		((= gTheDiceCup theDiceCup) init:)
		(proc1303_3)
		(IconBarF init:)
		(IconBar show:)
		(gTheDiceList
			add:
				(= gTheDice1 theDice1)
				(= gTheDice2 theDice2)
				gTheDice3
				gTheDice4
			whoFirst:
		)
		(if (not global787)
			(self setScript: gGamePlayScript)
		)
	)

	(method (handleEvent event)
		(if
			(or
				(& (event type:) evMOUSERELEASE)
				(and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			)
			(return)
		)
		(if (not (event claimed:))
			(global800 handleEvent: event)
			(gTheDiceCup handleEvent: event)
			(gTheDoubleCube handleEvent: event)
		)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(Random 0 99)
		(if (!= (gTheDoubleCube present:) global774)
			(gTheDoubleCube changeCubeState:)
		)
	)

	(method (dispose)
		(= global189 0)
		((global753 whichPoints:) dispose:)
		(if (global753 size:)
			(global753 release: dispose:)
		else
			(global753 dispose:)
		)
		((global754 whichPoints:) dispose:)
		(if (global754 size:)
			(global754 release: dispose:)
		else
			(global754 dispose:)
		)
		(gAllStonesObj dispose:)
		(gThePoints dispose:)
		(gAssocPoint dispose:)
		(gTheDiceList eachElementDo: #dispose dispose:)
		(KeyMouse release:)
		(gTheDice3 dispose:)
		(gTheDice4 dispose:)
		(gTheDiceCup dispose:)
		(gSound setLoop: 1 flags: 1)
		(aCast release: dispose:)
		(DisposeScript 1301)
		(DisposeScript 1303)
		(DisposeScript 1302)
		(DisposeScript 1310)
		(DisposeScript 64941)
		(DisposeScript 64983)
		(DisposeScript 9)
		(IconBarF dispose:)
		(super dispose:)
	)
)

(class Stone of DragableActor
	(properties
		view 1300
		yStep 10
		illegalBits 0
		xStep 15
		hiView 1300
		hiLoop 0
		hiCel 1
		color 2
	)

	(method (init)
		(super init: &rest)
		(= hiLoop color)
		(= draggingCode associatedCode)
		(self
			setLoop: color 1
			cel: 0
			moveSpeed: global898
			ignoreHorizon:
			ignoreActors:
		)
	)

	(method (movePos param1 param2 &tmp temp0)
		(if (and (!= param1 off1) (!= param1 off2))
			(= temp0 (/ param2 5))
			(self
				signal: (| signal $0001)
				setPri: 10
				setLoop: color
				moveSpeed: global898
			)
			(= global756 (+ (param1 nsLeft:) 14))
			(= global757
				(if (< (param1 dir:) 0)
					(-
						(- (- (param1 nsBottom:) 36) (* (mod param2 5) 31))
						(* temp0 3)
					)
				else
					(- (+ (param1 nsTop:) (* (mod param2 5) 31) 38) (* temp0 3))
				)
			)
		else
			(= global756 (- (param1 nsRight:) 25))
			(= global757 (+ (param1 nsTop:) (* param2 7) 26))
			(self setLoop: (+ color 3))
			(self setPri: 12 moveSpeed: global898)
		)
	)
)

(instance backgammonBoard of View
	(properties)

	(method (init)
		(self view: 1303 setLoop: 0 cel: 0 posn: 116 15 setPri: 8 show:)
		(super init:)
	)
)

(instance gamePlayScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 4])
		(switch (= state newState)
			(0
				(if (and (not (HaveMouse)) (== (global800 type:) 0))
					(KeyMouse setCursor: gTheDiceCup)
				)
				(global800 numberPoints:)
				(if (global800 readPoints: 0)
					(RedrawCast)
					(if (== global876 1)
						(DisableCursor)
					)
					(global800 changePlayer:)
					(= state -1)
				else
					(proc0_6)
					(if (and (== (global800 type:) 1) global769)
						(gTheDoubleCube make:)
					)
					(global800 adjustWeights:)
				)
				(= cycles 1)
			)
			(1
				(if
					(or
						global787
						register
						(and global769 (== (global800 type:) 1))
						(and local1 (== (global800 type:) 1))
					)
					(gTheDiceCup flash:)
					(if local1
						(= local1 0)
					)
					(if register
						(gTheDiceList rollDice: self register)
					else
						(gTheDiceList rollDice: self)
					)
				else
					(= global769 1)
					(= cycles 1)
				)
			)
			(2
				(if (== (global800 type:) 1)
					(DisableCursor)
					(if (and (not global786) global775)
						(global800 makeFirstMove:)
					else
						(global800 generateBoards:)
					)
					(= ticks (proc0_14))
				else
					(EnableCursor)
					(if global775
						(= global775 0)
					)
				)
			)
			(3
				(cond
					(global755
						(-- state)
						(cond
							((== (global800 type:) 0)
								(if (Random 0 5)
									(gChar1 frown:)
								else
									(gChar1
										sayReg:
											1300
											(+ (gChar1 view:) 1)
											94
											0
											(Random 1 2)
											0
											0
									)
								)
							)
							((Random 0 5)
								(gChar1 smile:)
							)
							(else
								(gChar1
									sayReg:
										1300
										(+ (gChar1 view:) 1)
										95
										0
										(Random 1 2)
										0
										0
								)
							)
						)
						((global800 otherBar:) moveToPoint:)
					)
					((== (gTheDiceList numberUsed:) (gTheDiceList size:))
						(if (global800 count:)
							(if (not register)
								(if
									(or
										(not global786)
										(!= (gTheDice1 pipValue:) 2)
										(!= (gTheDice2 pipValue:) 1)
									)
									(global800 changePlayer:)
								else
									(repeat
										(if (<= 1 register 6)
											(break)
										)
									)
								)
							else
								(= register 0)
							)
							(= state -1)
							(= ticks (proc0_14))
						else
							(global800 winGame:)
						)
					)
					(else
						(-- state)
						(cond
							((== (global800 type:) 1)
								(global800 think:)
							)
							((global800 count:)
								(if (not (global800 adjustLevel:))
									(not (gTheDiceList numberUsed:))
									(RedrawCast)
									(gChar1
										sayReg: 1000 2 60 0 (Random 1 2) 0 0
									)
									(gTheDiceList pickupAll:)
									(= cycles 1)
								)
							)
							(else
								(gTheDiceList numberUsed: (gTheDiceList size:))
								(= cycles 1)
							)
						)
					)
				)
			)
			(4
				(proc0_9 (gCast elements:) 1)
				(= cycles 1)
			)
			(5
				(IconBarF darken:)
				(proc1300_1)
				(= global773 1)
				(= global748 0)
				(IconBarF darken:)
				((ScriptID 930 0) init: 1370) ; yesNo
				(DisposeScript 930)
				(IconBarF lighten:)
				(cond
					(global748
						(= state 1)
						(EnableCursor)
						(proc1303_3)
						(global800 changePlayer:)
						(if (== (global800 type:) 1)
							(= local1 1)
							(gTheDiceList numberUsed: 0)
						)
						(gSong fade:)
						(= state -1)
					)
					(global924
						(gGame quitGame:)
						(proc0_8 0)
					)
				)
				(= ticks 1)
			)
			(6
				(= gNewRoomNum 975) ; chooseGame
			)
		)
	)
)

(instance theDice1 of Dies
	(properties
		x 82
		y 264
		startTop 260
		startLeft 20
		startBottom 290
		startRight 50
	)
)

(instance theDice2 of Dies
	(properties
		x 82
		y 307
		startTop 290
		startLeft 80
		startBottom 300
		startRight 110
	)
)

(instance theDice3 of Dies
	(properties)
)

(instance theDice4 of Dies
	(properties)
)

(instance theDiceList of DieList
	(properties)
)

(instance off1 of Point
	(properties
		nsTop 225
		nsLeft 555
		nsBottom 400
		nsRight 585
		dir 1
	)
)

(instance off2 of Point
	(properties
		nsTop 15
		nsLeft 555
		nsBottom 185
		nsRight 585
		dir 1
	)
)

(instance theBar1 of Point
	(properties
		nsTop 240
		nsLeft 312
		nsBottom 451
		nsRight 330
		dir 1
	)
)

(instance theBar2 of Point
	(properties
		nsTop 12
		nsLeft 312
		nsBottom 211
		nsRight 330
		dir -1
	)
)

(instance allStonesObj of Point
	(properties)
)

(instance assocPoint of Point
	(properties)
)

(instance stone1 of Stone
	(properties)
)

(instance stone2 of Stone
	(properties)
)

(instance stone3 of Stone
	(properties)
)

(instance stone4 of Stone
	(properties)
)

(instance stone5 of Stone
	(properties)
)

(instance stone6 of Stone
	(properties)
)

(instance stone7 of Stone
	(properties)
)

(instance stone8 of Stone
	(properties)
)

(instance stone9 of Stone
	(properties)
)

(instance stone10 of Stone
	(properties)
)

(instance stone11 of Stone
	(properties)
)

(instance stone12 of Stone
	(properties)
)

(instance stone13 of Stone
	(properties)
)

(instance stone14 of Stone
	(properties)
)

(instance stone15 of Stone
	(properties)
)

(instance stone16 of Stone
	(properties)
)

(instance stone17 of Stone
	(properties)
)

(instance stone18 of Stone
	(properties)
)

(instance stone19 of Stone
	(properties)
)

(instance stone20 of Stone
	(properties)
)

(instance stone21 of Stone
	(properties)
)

(instance stone22 of Stone
	(properties)
)

(instance stone23 of Stone
	(properties)
)

(instance stone24 of Stone
	(properties)
)

(instance stone25 of Stone
	(properties)
)

(instance stone26 of Stone
	(properties)
)

(instance stone27 of Stone
	(properties)
)

(instance stone28 of Stone
	(properties)
)

(instance stone29 of Stone
	(properties)
)

(instance stone30 of Stone
	(properties)
)

(instance theBGPlayer1 of BGPlayer
	(properties
		myColor 0
	)
)

(instance theBGPlayer2 of BGPlayer
	(properties)
)

(instance thePoints of BGPlayer
	(properties)
)

(instance associatedCode of Code
	(properties)

	(method (init)
		(global189 associatedObj: gAssocPoint)
	)
)

(instance theDoubleCube of DoubleCube
	(properties)
)

(instance theDiceCup of DiceCup
	(properties)
)

(instance theArrow of Actor
	(properties
		y 365
		view 215
	)

	(method (init)
		(self ignoreActors: cue:)
		(super init: &rest)
	)

	(method (cue)
		(self setLoop: (if (== global800 global782) 3 else 1))
	)
)

(instance aCast of Set
	(properties)
)

(instance backgam_opt of File
	(properties
		name {backgam.opt}
	)

	(method (doit param1 &tmp temp0 temp1)
		(= temp0 (Str new:))
		(= temp1 (Str new:))
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString:
							(temp0
								format:
									{%d%d%d%d%d}
									global774
									global385
									global878
									local0
							)
						close:
					)
					(temp0 dispose:)
					(temp1 dispose:)
					(return 1)
				else
					(temp0 dispose:)
					(temp1 dispose:)
					(return 0)
				)
			)
			((self open: 1)
				(self readString: temp1 2)
				(= global774 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global385 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global878 (temp1 asInteger:))
				(self readString: temp1 2)
				(= local0 (temp1 asInteger:))
				(self close:)
				(temp0 dispose:)
				(temp1 dispose:)
				(return 0)
			)
			(else
				(= local0 0)
				(= global765 0)
				(= global774 0)
				(= global385 7)
				(= global878 0)
				(temp0 dispose:)
				(temp1 dispose:)
				(return 0)
			)
		)
	)
)

