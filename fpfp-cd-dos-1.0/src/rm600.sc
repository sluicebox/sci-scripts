;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use eRS)
(use PAvoider)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm600 0
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
	local8 = 600
	local9
	local10
	local11
	local12
	local13
)

(instance rm600 of FPRoom
	(properties
		noun 1
		picture 600
		style 10
	)

	(method (init)
		(gEgo init: setScale: Scaler 150 70 189 128 normalize:)
		(switch gPrevRoomNum
			(250
				(gCurRoom setScript: sEnterFrom250)
			)
			(610
				(gEgo x: 141 y: 126)
				(gCurRoom setScript: sEnterFrom610)
			)
			(680
				(if (< (gEgo y:) 133)
					(= local9 1)
					(= gPrevRoomNum 610)
					(backDoor approachX: 127 approachY: 127)
				)
				(gGame handsOn:)
			)
			(else
				(gEgo x: 160 y: 180 setHeading: 0)
				(gGame handsOn:)
			)
		)
		(super init:)
		(cond
			((== gCurPuzzle 13)
				(srini
					view: 607
					x: 292
					y: 98
					setSpeed: 11
					setCycle: Fwd
					approachVerbs: 2 4 9 ; Talk, Do, Door_Key
					init:
				)
				(= local13 1)
				(stackCans addToPic:)
			)
			((and (>= gCurPuzzle 14) (!= gCurPuzzle 17))
				(switch (Random 0 1)
					(0
						(= local12 1)
						(srini
							view: 609
							x: 152
							y: 157
							approachX: 90
							approachY: 163
							setSpeed: 11
							setPri: 11
							setCycle: Fwd
							approachVerbs: 2 4 9 ; Talk, Do, Door_Key
							init:
						)
					)
					(1
						(srini
							view: 608
							x: 234
							y: 127
							approachX: 200
							approachY: 130
							setPri: 8
							setSpeed: 11
							setCycle: Fwd
							approachVerbs: 2 4 9 ; Talk, Do, Door_Key
							init:
						)
					)
				)
				(stackCans addToPic:)
			)
		)
		(if (== gPrevRoomNum 610)
			(gCurRoom
				addObstacle:
					(= local1
						((Polygon new:)
							type: PContainedAccess
							init: 104 127 104 130 261 130 261 127
							yourself:
						)
					)
			)
		else
			(gCurRoom
				addObstacle:
					(if (and (>= gCurPuzzle 2) (<= gCurPuzzle 7))
						(= local0
							((Polygon new:)
								type: PBarredAccess
								init: 260 189 275 144 306 144 306 134 258 134 258 139 217 139 217 134 95 134 36 143 35 170 14 182 0 189 0 0 319 0 319 189
								yourself:
							)
						)
					else
						(= local0
							((Polygon new:)
								type: PBarredAccess
								init: 260 189 275 144 306 144 306 134 95 134 36 143 35 170 14 182 0 189 0 0 319 0 319 189
								yourself:
							)
						)
					)
					(if local12
						(= local3
							((Polygon new:)
								type: PBarredAccess
								init: 65 159 60 153 112 141 235 141 188 166
								yourself:
							)
						)
					else
						(= local3
							((Polygon new:)
								type: PBarredAccess
								init: 168 142 237 142 195 166 132 166 123 160
								yourself:
							)
						)
					)
					(if local12
						(= local2
							((Polygon new:)
								type: PBarredAccess
								init: 0 1 319 1 319 26 0 25
								yourself:
							)
						)
					else
						(= local2
							((Polygon new:)
								type: PBarredAccess
								init: 105 163 65 161 65 151 104 142 162 142
								yourself:
							)
						)
					)
			)
		)
		(backDoor init: approachVerbs: 4 stopUpd:) ; Do
		(gate init: approachVerbs: 4 stopUpd:) ; Do
		(desk init: setOnMeCheck: 1 64)
		(rFrontShelf1 init: setOnMeCheck: 1 4)
		(rFrontShelf2 init: setOnMeCheck: 1 8)
		(lFrontShelf1 init: setOnMeCheck: 1 32)
		(lFrontShelf2 init: setOnMeCheck: 1 16)
		(leftShelf1 init: setOnMeCheck: 1 2)
		(leftShelf2 init: setOnMeCheck: 1 4)
		(leftShelf3 init: setOnMeCheck: 1 8)
		(leftShelf4 init: setOnMeCheck: 1 16)
		(handSign init: setOnMeCheck: 1 32)
		(lamp init: setOnMeCheck: 1 64)
		(cabinet init: setOnMeCheck: 1 128)
		(bottles1 init: setOnMeCheck: 1 256)
		(bottles2 init: setOnMeCheck: 1 512)
		(lFrontShelf init: setOnMeCheck: 1 1024)
		(rFrontShelf init: setOnMeCheck: 1 2048)
		(photo init: setOnMeCheck: 1 4096)
		(statue init: setOnMeCheck: 1 8192)
		(jar init: setOnMeCheck: 1 16384)
		(column init: setOnMeCheck: 1 -32768)
		(exitLine init: setOnMeCheck: 1 8192)
		(backCounter init: setOnMeCheck: 26505)
		(iceCream init: setOnMeCheck: 26505)
		(iceCream init: setOnMeCheck: 26505)
		(diploma init: setOnMeCheck: 26505)
		(backShelf1 init: setOnMeCheck: 26505)
		(backShelf2 init: setOnMeCheck: 26505)
		(bigPicture init: setOnMeCheck: 26505)
		(rearShelf1 init: setOnMeCheck: 26505)
		(rearShelf2 init: setOnMeCheck: 26505)
		(rearShelf3 init: setOnMeCheck: 26505)
		(if (and (not (gEgo has: 46)) (< gCurPuzzle 7)) ; Prep_G
			(preparationG init: approachVerbs: 4) ; Do
		)
		(if (and (not (gEgo has: 33)) (not (IsFlag 63)) (>= gCurPuzzle 19)) ; Medallion
			(medallion init: approachVerbs: 4) ; Do
		)
		(switch gCurPuzzle
			(2
				(penelope
					x: 242
					y: 136
					setScale: Scaler 150 70 189 128
					approachVerbs: 4 2 ; Do, Talk
					stopUpd:
					init:
				)
				(= local8 260)
				(= local10 802)
				(= local11 601)
			)
			(3
				(helen
					x: 242
					y: 136
					setScale: Scaler 150 70 189 128
					approachVerbs: 4 2 ; Do, Talk
					stopUpd:
					init:
				)
				(= local10 812)
				(= local8 660)
				(= local11 602)
			)
			(4
				(madame
					x: 242
					y: 136
					setScale: Scaler 150 70 189 128
					approachVerbs: 4 2 ; Do, Talk
					stopUpd:
					init:
				)
				(= local8 410)
				(= local10 803)
				(= local11 603)
			)
			(5
				(madame
					x: 242
					y: 136
					setScale: Scaler 150 70 189 128
					approachVerbs: 4 2 ; Do, Talk
					stopUpd:
					init:
				)
				(= local8 410)
				(= local10 803)
				(= local11 603)
			)
			(6
				(smithie
					x: 242
					y: 136
					setScale: Scaler 150 70 189 128
					approachVerbs: 4 2 ; Do, Talk
					stopUpd:
					init:
				)
				(= local8 223)
				(= local10 805)
				(= local11 604)
			)
			(7
				(gEgo x: 123 y: 128 stopUpd:)
				(= local8 710)
				(sheriff setScript: sSheriffShutdown)
			)
		)
		(cond
			((and (>= gCurPuzzle 2) (<= gCurPuzzle 6))
				(gGameMusic2 number: local8 flags: 1 loop: -1 play:)
			)
			((== gCurPuzzle 14) 0)
			((== gPrevRoomNum 250) 0)
			(else
				(gGameMusic2 number: local8 flags: 1 loop: -1 play:)
			)
		)
		(if (gEgo has: 51) ; Shovel
			(swallow init:)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((and local5 (== (PalVary pvGET_CURRENT_STEP) 64))
				(sEndAct cue:)
				(= local5 0)
			)
			(script)
			((proc0_1 gEgo 8192)
				(gCurRoom setScript: sExitTo250)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(cond
			((== gCurPuzzle 14) 0)
			((== gNewRoomNum 250)
				(gGameMusic2 fade: 80 10 16 0)
			)
			(else
				(gGameMusic2 fade:)
			)
		)
	)
)

(instance sEnterFrom250 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 160 y: 280 setMotion: PolyPath 160 180 self)
				(localSound number: 2606 play:)
			)
			(1
				(= cycles 10)
			)
			(2
				(cond
					((gCast contains: srini)
						(gMessager say: 46 0 32) ; "You return!"
						(cond
							(local13
								(srini
									approachX: 253
									approachY: 176
									approachVerbs: 2 4 9 ; Talk, Do, Door_Key
								)
							)
							(local12
								(srini
									approachX: 90
									approachY: 163
									approachVerbs: 2 4 9 ; Talk, Do, Door_Key
								)
							)
							(else
								(srini approachVerbs: 0)
							)
						)
					)
					((== gCurPuzzle 2)
						(gMessager say: 46 0 11) ; "I'm back, Penelope!"
					)
					((== gCurPuzzle 3)
						(gMessager say: 46 0 12) ; "Sorry, I just had an errand to run."
					)
					((== gCurPuzzle 4)
						(gMessager say: 46 0 1) ; "I'm back, Sadie. Sorry for the delay, I just had to check a few things out."
					)
					((== gCurPuzzle 5)
						(gMessager say: 46 0 1) ; "I'm back, Sadie. Sorry for the delay, I just had to check a few things out."
					)
					((== gCurPuzzle 6)
						(gMessager say: 46 0 13) ; "Hiya, Smithie! I'm back! Everything okay?"
					)
				)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFrom610 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(backDoor approachX: 127 approachY: 127)
				(= local9 1)
				(localSound number: 2146 play:)
				(backDoor cycleSpeed: 10 setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 125 126 self)
			)
			(3
				(gEgo setMotion: MoveTo 125 127 self)
			)
			(4
				(gEgo setMotion: MoveTo 135 127 self)
			)
			(5
				(localSound number: 2147 play:)
				(gEgo setHeading: 180)
				(backDoor cycleSpeed: 10 setCycle: Beg self)
			)
			(6
				(backDoor stopUpd:)
				(medallion approachVerbs: 0)
				(preparationG approachVerbs: 0)
				(if (gCast contains: srini)
					(if (or local12 local13)
						(srini approachVerbs: 0)
					else
						(srini
							approachX: 200
							approachY: 130
							approachVerbs: 2 4 9 ; Talk, Do, Door_Key
						)
					)
				)
				(if (IsFlag 105)
					(gMessager say: 44) ; "Srini! Who let you in?"
					(ClearFlag 105)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitTo250 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable:)
				(cond
					((gCast contains: srini)
						(proc0_5 gEgo srini)
					)
					((> gAct 1) 0)
					((gCast contains: penelope)
						(penelope startUpd: setHeading: 180)
						(proc0_5 gEgo diploma)
						(proc0_5 penelope gEgo)
					)
					((gCast contains: helen)
						(helen startUpd: setHeading: 180)
						(proc0_5 gEgo diploma)
						(proc0_5 helen gEgo)
					)
					((gCast contains: madame)
						(madame startUpd: setHeading: 180)
						(proc0_5 gEgo diploma)
						(proc0_5 madame gEgo)
					)
					((gCast contains: smithie)
						(smithie startUpd: setHeading: 180)
						(proc0_5 gEgo diploma)
						(proc0_5 smithie gEgo)
					)
				)
				(= cycles 10)
			)
			(1
				(cond
					((> gAct 1) 0)
					((gCast contains: penelope)
						(penelope stopUpd:)
					)
					((gCast contains: helen)
						(helen stopUpd:)
					)
					((gCast contains: madame)
						(madame stopUpd:)
					)
					((gCast contains: smithie)
						(smithie stopUpd:)
					)
				)
				(= cycles 3)
			)
			(2
				(cond
					((gCast contains: srini)
						(gMessager say: 42 0 32) ; "Mind the store, won't you, Srini? I'm off to uphold justice and stuff."
					)
					((== gCurPuzzle 2)
						(gMessager say: 42 0 11) ; "Penelope, I have to run out for just a minute or two. You'll wait for me, won't you?"
					)
					((== gCurPuzzle 3)
						(gMessager say: 42 0 12) ; "Helen, I've got to run out for a minute. I'll be right back, okay?"
					)
					((== gCurPuzzle 4)
						(gMessager say: 42 0 1) ; "Excuse me, Sadie, I've got to run out for a bit. Hang on, I'll be right back."
					)
					((== gCurPuzzle 5)
						(gMessager say: 42 0 1) ; "Excuse me, Sadie, I've got to run out for a bit. Hang on, I'll be right back."
					)
					((== gCurPuzzle 6)
						(gMessager say: 42 0 13) ; "I'll be back in a minute, Smithie. Hang in there."
					)
					(else 0)
				)
				(= cycles 1)
			)
			(3
				(gEgo setMotion: MoveTo (gEgo x:) 320 self)
			)
			(4
				(localSound number: 2606 play: self)
			)
			(5
				(gCurRoom newRoom: 250)
				(self dispose:)
			)
		)
	)
)

(instance sExitTo610 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable:)
				(localSound number: 2146 play:)
				(backDoor cycleSpeed: 10 setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 141 126 self)
			)
			(2
				(localSound number: 2147 play:)
				(backDoor cycleSpeed: 10 setCycle: Beg self)
			)
			(3
				(gCurRoom newRoom: 610)
				(self dispose:)
			)
		)
	)
)

(instance sEnterCustomer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localSound number: 2606 play:)
				(= local7 (gEgo moveSpeed:))
				(gGameMusic2 number: local8 play:)
				(client
					view: local10
					setSpeed: 4
					setCycle: StopWalk -1
					setScale: Scaler 150 70 189 128
					setMotion: PolyPath 241 136 self
					approachVerbs: 4 2 ; Do, Talk
					init:
				)
			)
			(1
				(UnLoad 128 local10)
				(client
					view: local11
					setLoop: (if local9 0 else 1)
					cel: 0
					setSpeed: 7
					setCycle: 0
					setMotion: 0
					stopUpd:
				)
				(= cycles 3)
			)
			(2
				(gMessager say: (client noun:) 0 2 0 self)
			)
			(3
				(if local9
					(gEgo setMotion: PolyPath 228 127 self)
				else
					(gEgo setMotion: PolyPath 210 134 self)
				)
			)
			(4
				(gEgo
					view: 606
					setLoop: (if local9 0 else 1)
					cel: 0
					setSpeed: 7
					setCycle: 0
					setMotion: 0
					stopUpd:
				)
				(= cycles 3)
			)
			(5
				(gMessager say: (client noun:) 0 9 0 self)
			)
			(6
				(if (== client smithie)
					(self changeState: 8)
				else
					(gEgo setCycle: Osc 1 self)
					(client setCycle: Osc 1 self)
				)
			)
			(7)
			(8
				(UnLoad 128 606)
				(gEgo
					normalize:
					setCel: (if (< (gEgo y:) 133) 2 else 0)
					setCycle: StopWalk -1
					setSpeed: local7
					stopUpd:
				)
				(= cycles 3)
			)
			(9
				(switch client
					(penelope
						(gEgo get: -1 42) ; Penelope_s_Rx
					)
					(helen
						(gEgo get: -1 22) ; Helen_s_Rx
					)
					(madame
						(gEgo get: -1 32) ; Madame_s_Rx
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitCustomer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local7 (gEgo moveSpeed:))
				(if (< (gEgo y:) 133)
					(gEgo setMotion: PolyPath 228 127 self)
				else
					(gEgo setMotion: PolyPath 210 134 self)
				)
			)
			(1
				(client
					view: local11
					setLoop: (if local9 0 else 1)
					cel: 0
					setSpeed: 7
					setCycle: Osc 1 self
				)
				(gEgo
					view: 606
					setLoop: (if local9 0 else 1)
					cel: 0
					setSpeed: 7
					setCycle: Osc 1 self
				)
			)
			(2)
			(3
				(UnLoad 128 local11)
				(client
					setLoop: -1
					view: local10
					loop: (if local9 3 else 1)
					setCycle: StopWalk -1
					stopUpd:
				)
				(gEgo
					normalize:
					setCel: (if local9 2 else 0)
					setCycle: StopWalk -1
					stopUpd:
				)
				(= cycles 3)
			)
			(4
				(switch client
					(penelope
						(gEgo put: 42 put: 34) ; Penelope_s_Rx, Med_1
						(gGame points: 10 0 self)
					)
					(helen
						(gEgo put: 22 put: 35) ; Helen_s_Rx, Med_2
						(gGame points: 10 0 self)
					)
					(madame
						(gEgo put: 32 put: 12 put: 58 put: 36) ; Madame_s_Rx, Correct_Rx, Under_Glass, Med_3
						(gGame points: 10 0 self)
					)
					(smithie
						(gEgo put: 46 get: -1 37) ; Prep_G, Money
						(gGame points: 3 0 self)
					)
				)
			)
			(5
				(= cycles 10)
			)
			(6
				(if (== client smithie)
					(gMessager say: 38 0 0 0 self) ; "That's be 15 cents, Smithie. But I don't suppose you can pay me."
				else
					(gMessager say: (client noun:) 0 3 0 self)
				)
			)
			(7
				(gEgo setHeading: 180)
				(client
					cycleSpeed: 4
					moveSpeed: 4
					setMotion: PolyPath 160 300 self
				)
			)
			(8
				(gEgo setSpeed: local7 stopUpd:)
				(= cycles 3)
			)
			(9
				(localSound number: 2606 play:)
				(if (== client penelope)
					(gMessager say: (client noun:) 0 30 0 self)
				else
					(= cycles 1)
				)
			)
			(10
				(gGame handsOn:)
				(switch client
					(penelope
						(= gCurPuzzle 3)
						(penelope dispose:)
						(= local8 660)
						(= local10 812)
						(= local11 602)
						(helen setScript: sEnterCustomer)
					)
					(helen
						(= gCurPuzzle 4)
						(helen dispose:)
						(= local8 410)
						(= local10 803)
						(= local11 603)
						(madame setScript: sEnterCustomer)
					)
					(madame
						(= gCurPuzzle 6)
						(madame dispose:)
						(= local8 223)
						(= local10 805)
						(= local11 604)
						(smithie setScript: sEnterCustomer)
					)
					(smithie
						(= gCurPuzzle 7)
						(smithie dispose:)
						(sheriff setScript: sSheriffShutdown)
					)
				)
				(UnLoad 128 local11)
				(self dispose:)
			)
		)
	)
)

(instance sWrongPrescription of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local7 (gEgo moveSpeed:))
				(= local6 1)
				(if (< (gEgo y:) 133)
					(gEgo setMotion: PolyPath 228 127 self)
				else
					(gEgo setMotion: PolyPath 210 134 self)
				)
			)
			(1
				(client
					view: local11
					setLoop: (if local9 0 else 1)
					cel: 0
					setSpeed: 7
					setCycle: Osc 1 self
				)
				(gEgo
					view: 606
					setLoop: (if local9 0 else 1)
					cel: 0
					setSpeed: 7
					setCycle: Osc 1 self
				)
			)
			(2)
			(3
				(UnLoad 128 local11)
				(client
					setLoop: -1
					view: local10
					loop: (if local9 3 else 1)
					setCycle: StopWalk -1
					stopUpd:
				)
				(gEgo
					normalize:
					setCel: (if local9 2 else 0)
					setCycle: StopWalk -1
					stopUpd:
				)
				(= cycles 3)
			)
			(4
				(gMessager say: (client noun:) 0 3 0 self)
			)
			(5
				(gEgo setHeading: 180)
				(client
					cycleSpeed: 4
					moveSpeed: 4
					setMotion: PolyPath 160 300 self
				)
			)
			(6
				(gEgo setSpeed: local7 stopUpd:)
				(localSound number: 2606 play:)
				(= cycles 3)
			)
			(7
				(localSound number: 2606 play:)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 780)
				(= cycles 10)
			)
			(8
				(gMessager say: 43 0 0 0 self) ; "A short while later..."
			)
			(9
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 600)
				(= cycles 10)
			)
			(10
				(client setMotion: PolyPath 241 136 self)
				(localSound number: 2606 play:)
			)
			(11
				(client setHeading: (if local9 0 else 270) stopUpd:)
				(gEgo setHeading: (if local9 180 else 90) stopUpd:)
				(= cycles 10)
			)
			(12
				(client stopUpd:)
				(gEgo stopUpd:)
				(= cycles 3)
			)
			(13
				(cond
					((and (== client penelope) (IsFlag 104))
						(gMessager say: (client noun:) 0 33 0 self)
					)
					((and (== client helen) (IsFlag 104))
						(gMessager say: (client noun:) 0 33 0 self)
					)
					((and (== client madame) (IsFlag 95))
						(gMessager say: (client noun:) 0 31 0 self)
					)
					(else
						(gMessager say: (client noun:) 0 14 0 self)
					)
				)
			)
			(14
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenGateFront of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((gCurRoom obstacles:) delete: local0)
				((gCurRoom obstacles:) delete: local3)
				((gCurRoom obstacles:) delete: local2)
				(local0 dispose:)
				(local3 dispose:)
				(local2 dispose:)
				(gate setCycle: End self)
				(localSound number: 2700 play:)
			)
			(1
				(gEgo setMotion: PolyPath 104 127 self)
			)
			(2
				(gCurRoom
					addObstacle:
						(= local1
							((Polygon new:)
								type: PContainedAccess
								init: 104 127 104 130 261 130 261 127
								yourself:
							)
						)
				)
				(gEgo setHeading: 180)
				(= cycles 3)
			)
			(3
				(gate setCycle: Beg self)
				(localSound number: 2700 play:)
			)
			(4
				(gate stopUpd:)
				(= local9 1)
				(if (and (== local4 1) (not (== gCurPuzzle 1)))
					(gEgo setMotion: PolyPath 123 128 self)
				else
					(= cycles 1)
				)
			)
			(5
				(if (and (== local4 1) (not (== gCurPuzzle 1)))
					(gEgo setHeading: 0)
				)
				(= cycles 3)
			)
			(6
				(backDoor approachX: 127 approachY: 127)
				(gate approachX: 100 approachY: 126)
				(cond
					((> gAct 1) 0)
					((gCast contains: penelope)
						(penelope approachX: 228 approachY: 127)
					)
					((gCast contains: helen)
						(helen approachX: 228 approachY: 127)
					)
					((gCast contains: madame)
						(madame approachX: 228 approachY: 127)
					)
					((gCast contains: smithie)
						(smithie approachX: 228 approachY: 127)
					)
				)
				(if (gCast contains: medallion)
					(medallion approachVerbs: 0)
				)
				(if (gCast contains: preparationG)
					(preparationG approachVerbs: 0)
				)
				(if (gCast contains: srini)
					(if (or local12 local13)
						(srini approachVerbs: 0)
					else
						(srini
							approachX: 200
							approachY: 130
							approachVerbs: 2 4 9 ; Talk, Do, Door_Key
						)
					)
				)
				(= cycles 3)
			)
			(7
				(gGame handsOn:)
				(cond
					((== gCurPuzzle 1)
						(= gCurPuzzle 2)
						(= local8 260)
						(= local10 802)
						(= local11 601)
						(penelope setScript: sEnterCustomer)
					)
					((== local4 1)
						(= local4 0)
						(gCurRoom setScript: sExitTo610)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sOpenGateBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((gCurRoom obstacles:) delete: local1)
				(local1 dispose:)
				(gate setCycle: End self)
				(localSound number: 2700 play:)
			)
			(1
				(gEgo setMotion: MoveTo 100 134 self)
			)
			(2
				(gCurRoom
					addObstacle:
						(if (and (>= gCurPuzzle 2) (<= gCurPuzzle 7))
							(= local0
								((Polygon new:)
									type: PBarredAccess
									init: 260 189 275 144 306 144 306 134 258 134 258 139 217 139 217 134 95 134 36 143 35 170 14 182 0 189 0 0 319 0 319 189
									yourself:
								)
							)
						else
							(= local0
								((Polygon new:)
									type: PBarredAccess
									init: 260 189 275 144 306 144 306 134 95 134 36 143 35 170 14 182 0 189 0 0 319 0 319 189
									yourself:
								)
							)
						)
						(if local12
							(= local3
								(= local3
									((Polygon new:)
										type: PBarredAccess
										init: 65 159 60 153 112 141 235 141 188 166
										yourself:
									)
								)
							)
						else
							(= local3
								((Polygon new:)
									type: PBarredAccess
									init: 118 160 50 160 110 142 161 142
									yourself:
								)
							)
						)
						(if local12
							(= local2
								((Polygon new:)
									type: PBarredAccess
									init: 0 1 319 1 319 26 0 25
									yourself:
								)
							)
						else
							(= local2
								((Polygon new:)
									type: PBarredAccess
									init: 168 142 237 142 195 166 109 166
									yourself:
								)
							)
						)
				)
				(gEgo setHeading: 0 self)
			)
			(3
				(gate setCycle: Beg self)
				(localSound number: 2700 play:)
			)
			(4
				(gate stopUpd:)
				(= local9 0)
				(if (gCast contains: srini)
					(cond
						(local13
							(srini
								approachX: 253
								approachY: 176
								approachVerbs: 2 4 9 ; Talk, Do, Door_Key
							)
						)
						(local12
							(srini
								approachX: 90
								approachY: 163
								approachVerbs: 2 4 9 ; Talk, Do, Door_Key
							)
						)
						(else
							(srini approachVerbs: 0)
						)
					)
				)
				(if (gCast contains: medallion)
					(medallion approachVerbs: 4) ; Do
				)
				(if (gCast contains: preparationG)
					(preparationG approachVerbs: 4) ; Do
				)
				(backDoor approachX: 100 approachY: 134)
				(gate approachX: 100 approachY: 134)
				(cond
					((> gAct 1) 0)
					((gCast contains: penelope)
						(penelope approachX: 210 approachY: 134)
					)
					((gCast contains: helen)
						(helen approachX: 210 approachY: 134)
					)
					((gCast contains: madame)
						(madame approachX: 210 approachY: 134)
					)
					((gCast contains: smithie)
						(smithie approachX: 210 approachY: 134)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEndAct of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: setCursor: 996)
				(gTheIconBar disable:)
				(= local5 1)
				(gEgo stopUpd:)
				(= seconds 1)
			)
			(1
				(PalVary pvINIT 250 5)
			)
			(2
				(proc0_15 1 3 self)
			)
			(3
				(PalVary pvUNINIT)
				(gCast eachElementDo: #dispose)
				(Palette palSET_INTENSITY 0 256 0)
				(gCurRoom drawPic: 780)
				(= cycles 1)
			)
			(4
				(gCurRoom newRoom: 26) ; actBreak
				(self dispose:)
			)
		)
	)
)

(instance sSheriffShutdown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(UnLoad 128 805)
				(gGameMusic2 number: 710 flags: 1 loop: -1 play:)
				(sheriff
					init:
					setAvoider: PAvoider
					setCycle: StopWalk -1
					setScale: Scaler 150 70 189 128
					setMotion: PolyPath 242 134 self
				)
				(= gAct 2)
				(localSound number: 2606 play:)
				(proc0_9 26)
			)
			(1
				(if local9
					(gEgo setMotion: PolyPath 228 127 self)
				else
					(gEgo setMotion: PolyPath 210 134 self)
				)
			)
			(2
				(gEgo setHeading: (if local9 180 else 90) stopUpd:)
				(client setHeading: (if local9 0 else 270) stopUpd:)
				(= cycles 3)
			)
			(3
				(= gAct 1)
				(gMessager say: 39 0 0) ; "Fire inspection! I'm here to check out chur fire safety, per the new town regulations. Whoa! Lookee here! It'sa good thing I came. Pharkas, I'ma gonna havta shut this place up tighter than a pissant's scrotum."
				(= cycles 1)
			)
			(4
				(= gAct 2)
				(gEgo setHeading: 180)
				(sheriff setMotion: PolyPath 160 300 self)
			)
			(5
				(localSound number: 2606 play:)
				(gCurRoom setScript: sEndAct)
				(self dispose:)
			)
		)
	)
)

(instance srini of Actor
	(properties
		x 162
		y 163
		noun 37
		approachX 185
		approachY 175
		priority 12
		signal 20496
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(71 ; Incorrect_Med
				(gMessager say: noun 29) ; "Do not give that to me, Freddy Pharkas! You are the dispensing pharmacist in these parts!"
			)
			(83 ; Incorrect_Med2
				(gMessager say: noun 29) ; "Do not give that to me, Freddy Pharkas! You are the dispensing pharmacist in these parts!"
			)
			(39 ; Pure_Solution
				(gMessager say: noun 29) ; "Do not give that to me, Freddy Pharkas! You are the dispensing pharmacist in these parts!"
			)
			(46 ; Deposit_Key
				(gMessager say: noun 35) ; "You are a most fortunate individual to be holding keys. I struggle much of my life to find keys."
			)
			(45 ; Desk_Key
				(gMessager say: noun 35) ; "You are a most fortunate individual to be holding keys. I struggle much of my life to find keys."
			)
			(9 ; Door_Key
				(gMessager say: noun 35) ; "You are a most fortunate individual to be holding keys. I struggle much of my life to find keys."
			)
			(23 ; Tower_H20
				(gMessager say: noun 49) ; "I prefer Golden Shower\04 Herbal Tea. I like mine tepid... with a twist!"
			)
			(2 ; Talk
				(cond
					(
						(or
							(and local9 local13)
							(and local9 local12)
							(and (not local12) (not local9) (not local13))
						)
						(gMessager say: 37 2 29) ; "Don't shout at Srini from behind the counter. Walk over and talk to him like a human being! Were you born in a barn?"
					)
					((== gCurPuzzle 13)
						(gMessager say: 37 2 15) ; "Srini!"
					)
					((== gCurPuzzle 14)
						(gMessager say: 37 2 16) ; "Srini, are you going to help me put out the fire, or what?"
					)
					((== gCurPuzzle 15)
						(gMessager say: 37 2 17) ; "The fire's out, but I don't feel like sleeping."
					)
					((or (== gCurPuzzle 16) (== gCurPuzzle 17))
						(cond
							((IsFlag 54)
								(gMessager say: noun 2 5) ; "Shall we go do some target practice, Srini? I'm all set, I think."
							)
							((and (gEgo has: 44) (gEgo has: 3)) ; Pistols, Bullets
								(gMessager say: noun 2 5) ; "Shall we go do some target practice, Srini? I'm all set, I think."
							)
							((not (gEgo has: 44)) ; Pistols
								(gMessager say: noun 2 27) ; "Srini, let's go practice target-shooting."
							)
							((not (gEgo has: 3)) ; Bullets
								(gMessager say: noun 2 28) ; "Srini, let's go practice my target shooting."
							)
						)
					)
					((== gCurPuzzle 19)
						(cond
							((not (gEgo has: 2)) ; Boots
								(gMessager say: 37 2 19) ; "Srini, I'd like to get into my cowboy outfit now."
							)
							((not (gEgo has: 44)) ; Pistols
								(gMessager say: 37 2 20) ; "Srini! Hey, I've got my complete disguise!"
							)
							((not (gEgo has: 10)) ; Clothes
								(gMessager say: 37 2 23) ; "Srini! Let's get me into outfit, I'm ready to start blowing away some varmint butt!"
							)
							((not (gEgo has: 52)) ; Silver_Ear
								(gMessager say: 37 2 22) ; "Hey, Srini! Let's get me dressed up, I'm ready to get into disguise."
							)
							((not (gEgo has: 38)) ; Neckerchief
								(gMessager say: 37 2 24) ; "Srini, I've got everything I need... silver ear, pistols, clothes, and boots. Let's get me dressed!"
							)
							(else
								(gMessager say: 37 2 18) ; "Srini, I think I'm ready to get dressed."
							)
						)
					)
					((== gCurPuzzle 20)
						(gMessager say: 37 2 25) ; "Srini, there's trouble down at the Saloon. The whole town's losing their deeds and cash to some slick riverboat gambler-type. He MUST be cheating, but danged if I can figure out how!"
					)
					((== gCurPuzzle 22)
						(gMessager say: 37 2 26) ; "It's crazy out there, Srini! A whole buncha rowdy cowhands are busting up Main Street. I almost didn't make it back alive!"
					)
				)
			)
			(else
				(if
					(or
						(and local13 local9)
						(and local9 local12)
						(and (not local12) (not local9) (not local13))
					)
					(gMessager say: 37 0 29) ; "Srini's on the other side of the counter. So be polite if you want to do that, and join him."
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance penelope of Actor
	(properties
		x 160
		y 300
		noun 34
		approachX 228
		approachY 127
		view 601
		signal 20480
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Med_1
				(self setScript: sExitCustomer)
			)
			(71 ; Incorrect_Med
				(if local6
					(gMessager say: 45 0 0) ; "You were just informed that your prescription-fillin' work was SHODDY. You're not going to hand back the same bad prescription, are you? No, you're not."
				else
					(self setScript: sWrongPrescription)
				)
			)
			(2 ; Talk
				(cond
					((not (IsFlag 67))
						(SetFlag 67)
						(gMessager say: noun theVerb 6) ; "I sure have been having a swell time with you these past few weeks, Penelope!"
					)
					((not (IsFlag 68))
						(SetFlag 68)
						(gMessager say: noun theVerb 7) ; "How's school, Penelope?"
					)
					((not (IsFlag 109))
						(SetFlag 109)
						(gMessager say: noun theVerb 8) ; "I was wondering if you were going to go to the Rotary Club luncheon next week, and if so, if you had anybody else to go with."
					)
					(else
						(gMessager say: noun theVerb 34) ; "I really can't wait to get my ha..."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(helen setScript: sEnterCustomer)
	)
)

(instance helen of Actor
	(properties
		x 160
		y 300
		noun 35
		approachX 228
		approachY 127
		view 602
		signal 20480
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Med_2
				(self setScript: sExitCustomer)
			)
			(71 ; Incorrect_Med
				(if local6
					(gMessager say: 45 0 0) ; "You were just informed that your prescription-fillin' work was SHODDY. You're not going to hand back the same bad prescription, are you? No, you're not."
				else
					(self setScript: sWrongPrescription)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(madame setScript: sEnterCustomer)
	)
)

(instance madame of Actor
	(properties
		x 160
		y 300
		noun 36
		approachX 228
		approachY 127
		view 603
		signal 20480
	)

	(method (doVerb theVerb)
		(switch theVerb
			(18 ; Med_3
				(self setScript: sExitCustomer)
			)
			(71 ; Incorrect_Med
				(if local6
					(gMessager say: 45 0 0) ; "You were just informed that your prescription-fillin' work was SHODDY. You're not going to hand back the same bad prescription, are you? No, you're not."
				else
					(self setScript: sWrongPrescription)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance smithie of Actor
	(properties
		x 160
		y 300
		noun 33
		approachX 228
		approachY 127
		view 604
		signal 20480
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; Prep_G
				(self setScript: sExitCustomer)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sheriff of Actor
	(properties
		x 160
		y 300
		view 806
		signal 16384
	)
)

(instance backDoor of Prop
	(properties
		x 119
		y 80
		noun 2
		approachX 100
		approachY 134
		view 600
		loop 2
		priority 9
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local9
					(gCurRoom setScript: sExitTo610)
				else
					(= local4 1)
					(gCurRoom setScript: sOpenGateFront)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gate of Prop
	(properties
		x 100
		y 132
		z 29
		noun 16
		approachX 100
		approachY 136
		view 600
		loop 3
		priority 10
		signal 20497
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local9
					(gCurRoom setScript: sOpenGateBack)
				else
					(gCurRoom setScript: sOpenGateFront)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (initialize))
)

(instance getMedallion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo stopUpd:)
				(medallion stopUpd:)
				(= cycles 5)
			)
			(1
				(gGame points: 1 0 self)
			)
			(2
				(medallion hide:)
				(= cycles 5)
			)
			(3
				(SetFlag 63)
				(gEgo get: 33 medallion) ; Medallion
				(= cycles 5)
			)
			(4
				(medallion dispose:)
				(self dispose:)
			)
		)
	)
)

(instance medallion of Prop
	(properties
		x 286
		y 86
		noun 40
		approachX 295
		approachY 141
		view 600
		signal 20481
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local9
					(gMessager say: noun theVerb 4) ; "You can't reach the medallion from here. Perhaps you should set up some sort of pincers and mount it on a pivoting armature and get it that way. Or you might try walking over there before taking it."
				else
					(self setScript: getMedallion)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance preparationG of Prop
	(properties
		x 103
		y 158
		z 40
		noun 41
		approachX 101
		approachY 160
		view 600
		loop 1
		priority 12
		signal 20497
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local9
					(gMessager say: noun theVerb 4) ; "You can't reach the Preparation G from back here."
				else
					(gGame points: 1 0 self)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(gEgo get: 46 preparationG) ; Prep_G
		(self dispose:)
	)
)

(instance stackCans of View
	(properties
		x 299
		y 100
		noun 47
		view 600
		loop 4
		priority 12
		signal 20496
	)
)

(instance backCounter of Feature
	(properties
		x 187
		y 133
		noun 12
		nsTop 104
		nsLeft 110
		nsBottom 131
		nsRight 265
	)
)

(instance iceCream of Feature
	(properties
		x 48
		y 88
		noun 3
		nsTop 38
		nsBottom 138
		nsRight 97
	)
)

(instance diploma of Feature
	(properties
		x 298
		y 73
		noun 4
		nsTop 68
		nsLeft 291
		nsBottom 79
		nsRight 306
	)
)

(instance backShelf1 of Feature
	(properties
		x 238
		y 88
		noun 5
		nsTop 84
		nsLeft 215
		nsBottom 92
		nsRight 261
	)
)

(instance backShelf2 of Feature
	(properties
		x 237
		y 98
		noun 6
		nsTop 94
		nsLeft 215
		nsBottom 102
		nsRight 260
	)
)

(instance bigPicture of Feature
	(properties
		x 215
		y 16
		noun 11
		nsLeft 166
		nsBottom 32
		nsRight 265
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gMessager say: 28 2) ; "You can't talk to the sign! (It only knows sign language!)"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rearShelf1 of Feature
	(properties
		x 159
		y 80
		noun 10
		nsTop 77
		nsLeft 143
		nsBottom 83
		nsRight 175
	)
)

(instance rearShelf2 of Feature
	(properties
		x 159
		y 89
		noun 9
		nsTop 85
		nsLeft 143
		nsBottom 93
		nsRight 175
	)
)

(instance rearShelf3 of Feature
	(properties
		x 148
		y 99
		noun 8
		nsTop 95
		nsLeft 143
		nsBottom 103
		nsRight 154
	)
)

(instance desk of Feature
	(properties
		x 305
		y 189
		noun 18
		nsTop 135
		nsLeft 267
		nsBottom 189
		nsRight 311
	)
)

(instance rFrontShelf1 of Feature
	(properties
		x 201
		y 146
		noun 31
		nsTop 115
		nsLeft 183
		nsBottom 134
		nsRight 220
	)
)

(instance rFrontShelf2 of Feature
	(properties
		x 200
		y 146
		noun 32
		nsTop 131
		nsLeft 183
		nsBottom 156
		nsRight 218
	)
)

(instance lFrontShelf1 of Feature
	(properties
		x 126
		y 146
		noun 22
		nsTop 121
		nsLeft 109
		nsBottom 136
		nsRight 144
	)
)

(instance lFrontShelf2 of Feature
	(properties
		x 126
		y 146
		noun 23
		nsTop 133
		nsLeft 108
		nsBottom 154
		nsRight 144
	)
)

(instance exitLine of Feature
	(properties
		x 159
		y 187
		noun 1
		nsTop 183
		nsBottom 189
		nsRight 319
	)
)

(instance swallow of Feature
	(properties
		x 41
		y 169
		noun 1
		nsTop 160
		nsLeft 31
		nsBottom 179
		nsRight 51
	)

	(method (doVerb theVerb)
		(switch theVerb
			(63 ; Shovel
				(gCurRoom setScript: sMovieGag)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leftShelf1 of Feature
	(properties
		x 80
		y 89
		noun 7
	)
)

(instance leftShelf2 of Feature
	(properties
		x 92
		y 89
		noun 13
	)
)

(instance leftShelf3 of Feature
	(properties
		x 103
		y 89
		noun 14
	)
)

(instance leftShelf4 of Feature
	(properties
		x 112
		y 89
		noun 15
	)
)

(instance handSign of Feature
	(properties
		x 55
		y 39
		noun 28
	)
)

(instance lamp of Feature
	(properties
		x 91
		y 24
		noun 17
	)
)

(instance cabinet of Feature
	(properties
		x 29
		y 189
		noun 19
	)
)

(instance bottles1 of Feature
	(properties
		x 118
		y 146
		noun 20
	)
)

(instance bottles2 of Feature
	(properties
		x 189
		y 146
		noun 21
	)
)

(instance lFrontShelf of Feature
	(properties
		x 95
		y 117
		noun 30
	)
)

(instance rFrontShelf of Feature
	(properties
		x 157
		y 146
		noun 29
	)
)

(instance photo of Feature
	(properties
		x 165
		y 146
		noun 24
	)
)

(instance statue of Feature
	(properties
		x 179
		y 133
		noun 25
	)
)

(instance jar of Feature
	(properties
		x 293
		y 189
		noun 26
	)
)

(instance column of Feature
	(properties
		x 315
		y 189
		noun 27
	)
)

(instance sMovieGag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(ghoul loop: 0 cel: 0 cycleSpeed: 10 setCycle: CT 10 1 init:)
				(localSound number: 2948 play: self)
			)
			(2
				(gMessager say: 48 0 0 0 self) ; "Groovy!"
			)
			(3
				(ghoul setCycle: End self)
			)
			(4
				(ghoul dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ghoul of Prop
	(properties
		x 28
		y 162
		view 612
	)
)

(instance localSound of FPSound
	(properties
		flags 1
	)
)

