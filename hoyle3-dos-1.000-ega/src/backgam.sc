;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Interface)
(use BGPlayer)
(use LeapTo)
(use dummyPublic0)
(use IconBar)
(use RandCycle)
(use Path)
(use File)
(use Game)
(use Actor)
(use System)

(public
	backgam 0
	off1 1
	off2 2
)

(instance backgam of Rm
	(properties
		style 10
	)

	(method (init &tmp temp0)
		((= gBackgam_opt backgam_opt) doit:)
		(= picture global317)
		(if (gChar1 active:)
			(gChar1 posn: 29 36 show: init:)
			(Load rsTEXT (+ (* (+ (gChar1 view:) 1) 1000) global187))
		else
			(Load rsTEXT 19300)
		)
		(Characters init:)
		(super init: &rest)
		(gSong fade:)
		(Load rsVIEW 300)
		(Load rsVIEW 310)
		(Load rsSOUND 906)
		(Load rsSOUND 504)
		(Load rsSOUND 303)
		(Load rsSOUND 300)
		(Load rsSOUND 301)
		(Load rsSOUND 302)
		(Load rsSOUND 905)
		(Load rsSOUND 909)
		(Load rsSOUND 914)
		(Load rsSOUND 915)
		(Load rsSOUND 904)
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(Load rsCURSOR (+ 100 temp0))
		)
		(ScriptID 310) ; thebgCode
		LeapTo
		RandCycle
		Path
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
		(= global303 theBGPlayer1)
		(= global304 theBGPlayer2)
		(if (and (== (global303 type:) 2) (== global179 1))
			(= global303 theBGPlayer2)
			(= global304 theBGPlayer1)
		)
		(global303 skill: global190 type: global194 playerName: @global150)
		(global304 skill: global191 type: global195 playerName: @global157)
		(= global332 (if (== (global303 type:) 1) global303 else global304))
		(= gGamePlayScript gamePlayScript)
		(= gTheArrow theArrow)
		(if (!= global179 2)
			(= global315 0)
		)
		(= gAllStonesObj allStonesObj)
		((= gAssocPoint assocPoint))
		(= global319 0)
		((= gTheDice3 theDice3) hide:)
		((= gTheDice4 theDice4) hide:)
		(global303
			add:
				off1
				(ScriptID 303 4) ; point1
				(ScriptID 303 5) ; point2
				(ScriptID 303 6) ; point3
				(ScriptID 303 7) ; point4
				(ScriptID 303 8) ; point5
				(ScriptID 303 9) ; point6
				(ScriptID 303 10) ; point7
				(ScriptID 303 11) ; point8
				(ScriptID 303 12) ; point9
				(ScriptID 303 13) ; point10
				(ScriptID 303 14) ; point11
				(ScriptID 303 15) ; point12
				(ScriptID 303 16) ; point13
				(ScriptID 303 17) ; point14
				(ScriptID 303 18) ; point15
				(ScriptID 303 19) ; point16
				(ScriptID 303 20) ; point17
				(ScriptID 303 21) ; point18
				(ScriptID 303 22) ; point19
				(ScriptID 303 23) ; point20
				(ScriptID 303 24) ; point21
				(ScriptID 303 25) ; point22
				(ScriptID 303 26) ; point23
				(ScriptID 303 27) ; point24
				gTheBar1
			init:
		)
		(global304
			add:
				off2
				(ScriptID 303 27) ; point24
				(ScriptID 303 26) ; point23
				(ScriptID 303 25) ; point22
				(ScriptID 303 24) ; point21
				(ScriptID 303 23) ; point20
				(ScriptID 303 22) ; point19
				(ScriptID 303 21) ; point18
				(ScriptID 303 20) ; point17
				(ScriptID 303 19) ; point16
				(ScriptID 303 18) ; point15
				(ScriptID 303 17) ; point14
				(ScriptID 303 16) ; point13
				(ScriptID 303 15) ; point12
				(ScriptID 303 14) ; point11
				(ScriptID 303 13) ; point10
				(ScriptID 303 12) ; point9
				(ScriptID 303 11) ; point8
				(ScriptID 303 10) ; point7
				(ScriptID 303 9) ; point6
				(ScriptID 303 8) ; point5
				(ScriptID 303 7) ; point4
				(ScriptID 303 6) ; point3
				(ScriptID 303 5) ; point2
				(ScriptID 303 4) ; point1
				gTheBar2
			init:
		)
		((= gThePoints thePoints)
			add:
				off1
				off2
				(ScriptID 303 4) ; point1
				(ScriptID 303 5) ; point2
				(ScriptID 303 6) ; point3
				(ScriptID 303 7) ; point4
				(ScriptID 303 8) ; point5
				(ScriptID 303 9) ; point6
				(ScriptID 303 10) ; point7
				(ScriptID 303 11) ; point8
				(ScriptID 303 12) ; point9
				(ScriptID 303 13) ; point10
				(ScriptID 303 14) ; point11
				(ScriptID 303 15) ; point12
				(ScriptID 303 16) ; point13
				(ScriptID 303 17) ; point14
				(ScriptID 303 18) ; point15
				(ScriptID 303 19) ; point16
				(ScriptID 303 20) ; point17
				(ScriptID 303 21) ; point18
				(ScriptID 303 22) ; point19
				(ScriptID 303 23) ; point20
				(ScriptID 303 24) ; point21
				(ScriptID 303 25) ; point22
				(ScriptID 303 26) ; point23
				(ScriptID 303 27) ; point24
				gTheBar1
				gTheBar2
		)
		((= gTheDiceList theDiceList) init:)
		((= gTheDoubleCube theDoubleCube) init:)
		((= gTheDiceCup theDiceCup) init:)
		(proc303_3)
		(gTheDiceList
			add:
				(= gTheDice1 theDice1)
				(= gTheDice2 theDice2)
				gTheDice3
				gTheDice4
			whoFirst:
		)
		(if (not global337)
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
			(global178 handleEvent: event)
			(gTheDiceCup handleEvent: event)
			(gTheDoubleCube handleEvent: event)
		)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(Random 0 99)
		(if (!= global317 picture)
			(IconBar disable:)
			(= picture global317)
			(gGame setCursor: 20 1)
			(for ((= temp0 0)) (< temp0 (gCast size:)) ((++ temp0))
				(UnLoad 133 ((gCast at: temp0) underBits:))
			)
			(DrawPic picture 10)
			(gGame setCursor: 999 1)
			(proc0_1)
			(IconBar enable:)
		)
		(if (!= (gTheDoubleCube present:) global324)
			(gTheDoubleCube changeCubeState:)
		)
	)

	(method (dispose)
		(= global181 0)
		((global303 whichPoints:) eachElementDo: #release dispose:)
		(global303 eachElementDo: #release dispose:)
		((global304 whichPoints:) eachElementDo: #release dispose:)
		(global304 eachElementDo: #release dispose:)
		(gAllStonesObj dispose:)
		(gThePoints dispose:)
		(gAssocPoint dispose:)
		(gTheDiceList eachElementDo: #dispose eachElementDo: #delete dispose:)
		(KeyMouse release:)
		(gTheDice3 dispose:)
		(gTheDice4 dispose:)
		(gTheDiceCup dispose:)
		(gSound setLoop: 1 flags: 1)
		(aCast release: dispose:)
		(DisposeScript 301)
		(DisposeScript 303)
		(DisposeScript 302)
		(DisposeScript 310)
		(DisposeScript 941)
		(DisposeScript 983)
		(DisposeScript 9)
		(super dispose:)
	)
)

(class Stone of DragableActor
	(properties
		yStep 6
		view 300
		illegalBits 0
		xStep 9
		hiView 300
		hiLoop 0
		hiCel 1
		color 2
	)

	(method (init)
		(super init: &rest)
		(= hiLoop color)
		(= draggingCode associatedCode)
		(self setLoop: color stopUpd: setCel: ignoreHorizon: ignoreActors:)
	)

	(method (movePos param1 param2 &tmp temp0)
		(if (and (!= param1 off1) (!= param1 off2))
			(self
				signal: (| signal $0010)
				priority: (+ 12 (= temp0 (/ param2 5)))
				loop: color
			)
			(= global306 (+ (param1 nsLeft:) 7))
			(= global307
				(if (< (param1 dir:) 0)
					(-
						(- (- (param1 nsBottom:) 15) (* (mod param2 5) 13))
						(* temp0 3)
					)
				else
					(- (+ (param1 nsTop:) (* (mod param2 5) 13) 16) (* temp0 3))
				)
			)
		else
			(= global306 (- (param1 nsRight:) 13))
			(= global307 (+ (param1 nsTop:) (* param2 4) 10))
			(self setPri: 12)
		)
	)
)

(instance gamePlayScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 4])
		(switch (= state newState)
			(0
				(if (and (not (HaveMouse)) (== (global178 type:) 1))
					(KeyMouse setCursor: gTheDiceCup)
				)
				(global178 numberPoints:)
				(if (global178 readPoints: 0)
					(proc0_1)
					(if (== global179 1)
						(proc0_4)
					)
					(gSound play: 909)
					(cond
						((== (global178 type:) 2)
							(gChar1
								say: (Format @global550 300 0) 0 443 -32768 ; "I have no possible moves and must pass."
							)
						)
						((== global179 2)
							(gChar1
								say:
									(Format ; "%s has no possible moves and must pass."
										@global550
										300
										1
										(global178 playerName:)
									)
									-32768
							)
						)
						(else
							(gChar1
								say:
									(Format ; "%s, you have no possible moves and must pass."
										@global550
										300
										2
										(global178 playerName:)
									)
									0
									442
									2
							)
						)
					)
					(global178 changePlayer:)
					(= state -1)
				else
					(proc0_6)
					(if (== (global178 type:) 2)
						(gTheDoubleCube make:)
					)
					(global178 adjustWeights:)
				)
				(= cycles 1)
			)
			(1
				(if
					(or
						global337
						register
						(and global319 (== (global178 type:) 2))
					)
					(gTheDiceCup flash:)
					(if register
						(gTheDiceList rollDice: self register)
					else
						(gTheDiceList rollDice: self)
					)
				else
					(= global319 1)
					(= cycles 1)
				)
			)
			(2
				(cond
					((== (global178 type:) 2)
						(proc0_4 30)
						(if (and (not global336) global325)
							(global178 makeFirstMove:)
						else
							(global178 generateBoards:)
						)
						(= cycles 1)
					)
					(global325
						(= global325 0)
					)
				)
			)
			(3
				(cond
					(global305
						(-- state)
						(proc0_4)
						(if (== (global178 type:) 1)
							(gSound play: 914)
							(if (Random 0 5)
								(gChar1 frown:)
							else
								(gChar1 say: (Random 51 53))
							)
						else
							(gSound play: 915)
							(if (Random 0 5)
								(gChar1 smile:)
							else
								(gChar1 say: (Random 54 56))
							)
						)
						((global178 otherBar:) moveToPoint:)
					)
					((== (gTheDiceList numberUsed:) (gTheDiceList size:))
						(if (global178 count:)
							(if (not register)
								(if
									(or
										(not global336)
										(!= (gTheDice1 pipValue:) 2)
										(!= (gTheDice2 pipValue:) 1)
									)
									(global178 changePlayer:)
								else
									(repeat
										(StrCpy @temp0 {})
										(Print 300 3 #edit @temp0 2) ; "Which doubles do you want?"
										(= register (ReadNumber @temp0))
										(if (<= 1 register 6)
											(break)
										)
									)
								)
							else
								(if (> register 0)
									(gChar1 say: (Random 60 62) -32768)
								else
									(global178 changePlayer:)
								)
								(= register 0)
							)
							(= state -1)
							(= cycles 1)
						else
							(global178 winGame:)
						)
					)
					(else
						(-- state)
						(cond
							((== (global178 type:) 2)
								(global178 think:)
							)
							((global178 count:)
								(if (not (global178 adjustLevel:))
									(if (not (gTheDiceList numberUsed:))
										(Wait 50)
									)
									(proc0_1)
									(gSound play: 909)
									(gChar1 say: (Random 48 50) -32768 442 1)
									(gTheDiceList pickupAll:)
									(if global336
										(= register -1)
									)
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
				(Animate (gCast elements:) 1)
				(= cycles 1)
			)
			(5
				(proc303_2)
				(= global323 1)
				(proc303_3)
				(global178 changePlayer:)
				(gSong fade:)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance theDice1 of Dies
	(properties
		x 19
		y 110
		startTop 128
		startLeft 33
		startBottom 136
		startRight 45
	)
)

(instance theDice2 of Dies
	(properties
		x 19
		y 128
		startTop 133
		startLeft 63
		startBottom 141
		startRight 75
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
		nsTop 118
		nsLeft 286
		nsBottom 194
		nsRight 315
		dir 1
	)
)

(instance off2 of Point
	(properties
		nsTop 7
		nsLeft 285
		nsBottom 83
		nsRight 314
		dir 1
	)
)

(instance theBar1 of Point
	(properties
		nsTop 105
		nsLeft 158
		nsBottom 188
		nsRight 175
		dir 1
	)
)

(instance theBar2 of Point
	(properties
		nsTop 5
		nsLeft 158
		nsBottom 88
		nsRight 175
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
		(global181 associatedObj: gAssocPoint)
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
		x 20
		y 182
		view 850
		cel 1
	)

	(method (init)
		(self ignoreActors: stopUpd: cue:)
		(super init: &rest)
	)

	(method (cue)
		(self setLoop: (if (== global178 global332) 2 else 3))
	)
)

(instance aCast of Set
	(properties)
)

(instance backgam_opt of File
	(properties
		name {backgam.opt}
	)

	(method (doit param1 &tmp [temp0 20] [temp20 8])
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString:
							(Format @temp0 300 4 global317 global315 global324) ; "%3d%d%d"
						close:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(if
					(or
						(!=
							(= global317
								(ReadNumber (self readString: @temp20 4))
							)
							300
						)
						(!= global317 350)
					)
					(= global317 300)
				)
				(= global315 (ReadNumber (self readString: @temp20 2)))
				(= global324 (ReadNumber (self readString: @temp20 2)))
				(self close:)
				(return 0)
			)
			(else
				(= global317 300)
				(= global315 0)
				(= global324 0)
				(return 0)
			)
		)
	)
)

