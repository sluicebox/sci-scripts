;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use OccasionalCycle)
(use eRS)
(use Scaler)
(use Polygon)
(use Feature)
(use Door)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm240 0
)

(local
	local0
	local1 = 1
	local2 = 1
	local3 = 1
	local4
)

(instance rm240 of FPRoom
	(properties
		noun 1
		picture 240
		style 100
		horizon 40
		north 310
		east 250
		west 230
	)

	(method (init)
		(if (IsFlag 59)
			(self setRegions: 90) ; streetRgn
		)
		(if (== gCurPuzzle 22)
			(self setRegions: 91) ; rowdyRgn
		)
		(gEgo init: setScale: Scaler 100 50 175 95 normalize:)
		(switch gPrevRoomNum
			(west
				(= style 12)
				(gGame handsOn:)
			)
			(235
				(= style 12)
				(gGame handsOn:)
			)
			(east
				(= style 11)
				(gGame handsOn:)
			)
			(north
				(gEgo x: 50 y: 160)
				(gGame handsOn:)
			)
			(150
				(gEgo x: 160 y: 160)
				(gGame handsOn:)
			)
			(650
				(= local3 1)
			)
			(640
				(= local3 1)
			)
			(680
				(gGame handsOn:)
			)
			(26 ; actBreak
				(if (IsFlag 80)
					(= gAct 4)
					(= gCurPuzzle 20)
					(gEgo posn: 242 142 setHeading: 180)
					(ClearFlag 80)
					(gGame handsOn:)
				else
					(= local3 0)
					(LoadMany rsSCRIPT 1814)
					(gCurRoom setScript: sSepiaStart)
				)
			)
			(else
				(gEgo x: 160 y: 160)
				(gGame handsOn:)
			)
		)
		(cond
			((== local3 0) 0)
			((== gCurPuzzle 14) 0)
			((OneOf gPrevRoomNum 650)
				(gGameMusic2 number: 640 flags: 1 loop: -1 play: setVol: 0)
			)
			((OneOf gPrevRoomNum 640 26) ; actBreak
				(gGameMusic1 number: 652 flags: 1 loop: -1 play: setVol: 0)
			)
			(else
				(gGameMusic1
					number: 652
					flags: 1
					loop: -1
					play:
					setVol: (if (OneOf gPrevRoomNum 230 310) 80 else 0)
				)
				(gGameMusic2
					number: 640
					flags: 1
					loop: -1
					play:
					setVol: (if (== gPrevRoomNum 250) 80 else 0)
				)
			)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 102 316 102 316 81 311 81 311 102 274 102 272 109 263 109 257 104 217 104 217 106 143 106 135 94 135 79 129 79 129 94 115 107 99 107 95 98 59 98 48 56 58 50 49 29 25 29 23 109 0 111 0 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 176 319 176 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 27 110 27 122 6 122 7 113
					yourself:
				)
		)
		(if (IsFlag 1)
			(barberDoor init: locked: 1)
			(storeDoor init: locked: 1)
		else
			(barberDoor init:)
			(if (and (!= gCurPuzzle 22) (>= (gGame detailLevel:) 2))
				(shrub1 init: hide: setScript: sBreezeShrubs)
				(shrub2 init: hide:)
				(bucket init: hide: setScript: sWaterBucket)
				(barberpole init: cycleSpeed: 14 setCycle: Fwd)
			)
			(if (>= gCurPuzzle 20)
				(storeDoorClosed init: approachVerbs: 4) ; Do
			else
				(storeDoor init:)
			)
		)
		(if (== gCurPuzzle 22)
			(gNarrator modeless: 1)
			(cowboy1
				setLoop: (Random 0 1)
				setScale: Scaler 100 50 175 95
				setCycle: OccasionalCycle 1 10 30 2 6
				setScript: sRowdysKill
				init:
			)
			(cowboy2
				setLoop: (Random 2 3)
				setScale: -1 cowboy1
				setCycle: OccasionalCycle 1 10 30 2 6
				init:
			)
			(if (and (> gHowFast 6) (> (gGame detailLevel:) 3))
				(cowboy3
					setLoop: (Random 4 5)
					setScale: -1 cowboy1
					setCycle: OccasionalCycle 1 10 30 2 6
					init:
				)
			)
			(if (and (> gHowFast 13) (> (gGame detailLevel:) 1))
				(cowboy4
					setLoop: (Random 6 7)
					setScale: -1 cowboy1
					setCycle: OccasionalCycle 1 10 30 2 6
					init:
				)
			)
		)
		(store init: setOnMeCheck: 1 128)
		(postOffice init: setOnMeCheck: 1 256)
		(barberShop init: setOnMeCheck: 1 512)
		(clutter init: setOnMeCheck: 1 1024)
		(storeWindow init: setOnMeCheck: 26505)
		(postWindow init: setOnMeCheck: 26505)
		(barberWindow init: setOnMeCheck: 26505)
		(storeSign init: setOnMeCheck: 26505)
		(postSign init: setOnMeCheck: 26505)
		(barberSign init: setOnMeCheck: 26505)
		(hotel init: setOnMeCheck: 26505)
		(wagon init: setOnMeCheck: 26505)
		(postDoor init: setOnMeCheck: 26505 approachVerbs: 4 9) ; Do, Door_Key
		(if (IsFlag 52)
			(dummyCredits init: setScript: (ScriptID 32 0)) ; sOpeningCredits
		)
	)

	(method (doit &tmp temp0 temp1 [temp2 2])
		(super doit:)
		(cond
			((and local0 (== (PalVary pvGET_CURRENT_STEP) 0))
				(sSepiaStart cue:)
				(= local0 0)
			)
			((== gCurPuzzle 14) 0)
			((and local3 (<= (gEgo x:) 219))
				(if (> (gGameMusic2 vol:) 0)
					(gGameMusic2 setVol: 0)
				)
				(cond
					(
						(<
							(= temp0
								(GetDistance
									(gEgo x:)
									(gEgo y:)
									219
									(gEgo y:)
								)
							)
							20
						)
						(= temp0 20)
					)
					((> temp0 80)
						(= temp0 80)
					)
				)
				(gGameMusic1 setVol: temp0)
			)
			((and local3 (>= (gEgo x:) 220))
				(if (> (gGameMusic1 vol:) 0)
					(gGameMusic1 setVol: 0)
				)
				(cond
					(
						(<
							(= temp1
								(GetDistance
									(gEgo x:)
									(gEgo y:)
									220
									(gEgo y:)
								)
							)
							20
						)
						(= temp1 20)
					)
					((> temp1 80)
						(= temp1 80)
					)
				)
				(gGameMusic2 setVol: temp1)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 32)
		(if (== gCurPuzzle 22)
			(gNarrator modeless: 0)
		)
		(if (and (not (IsFlag 69)) (== gAct 2) (== gCurPuzzle 13))
			(not (SetFlag 69))
		)
		(cond
			((== gCurPuzzle 14) 0)
			((== gNewRoomNum 650)
				(gGameMusic1 fade: 127 10 16 0)
				(gGameMusic2 stop:)
			)
			((== gNewRoomNum 640)
				(gGameMusic2 fade: 127 10 16 0)
				(gGameMusic1 stop:)
			)
			(else
				(gGameMusic1 fade:)
				(gGameMusic2 fade:)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 230) (OneOf gCurPuzzle 8 9 20 22))
			(= newRoomNumber 235)
		)
		(if (and (== newRoomNumber 310) (or (== gCurPuzzle 14) (== gCurPuzzle 15)))
			(proc0_15 1 16)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sSepiaStart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gAct 4)
				(= local0 1)
				(gTheIconBar disable:)
				(PalVary pvINIT 240 0)
				(gGame setCursor: 996)
				(= gCurPuzzle 20)
				(= local4 (gEgo moveSpeed:))
				(gEgo posn: 330 150 setSpeed: 7 wearingGuns: 1)
				(= seconds 3)
			)
			(1
				(PalVary pvREVERSE 5 0 1)
			)
			(2
				(gGameMusic1 number: 653 loop: -1 flags: 1 play:)
				(gMessager say: 18 0 0 0 self) ; "The stage wuz set fer Freddy's showdown."
			)
			(3
				(gGameMusic1 fade: 0 3 1 0)
				(gEgo setMotion: MoveTo 140 150 self)
			)
			(4
				(gGameMusic1 number: 652 flags: 1 loop: -1 play: setVol: 0)
				(gGameMusic2 number: 640 flags: 1 loop: -1 play: setVol: 0)
				(gEgo
					normalize:
					setSpeed: local4
					setMotion: 0
					setHeading: 180
				)
				(= local3 1)
				(gTheIconBar enable:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWaterBucket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCel: 0)
				(= seconds (Random 15 25))
			)
			(1
				(client show:)
				(client setCycle: End self cycleSpeed: 5)
				(slopSound play:)
			)
			(2
				(client hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance sRowdysKill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 4)
			)
			(1
				(gMessager say: 20 0 0 0 self) ; "You encounter dozens of those silly ol' rowdy cowhands from that cattle drive outside of town who are carelessly firing their guns everywhere and frightening (not to mention killing) the locals."
			)
			(2
				(gEgo
					view: 142
					setLoop: 0
					setCel: 0
					setPri: 1
					setSpeed: 10
					setCycle: End self
				)
			)
			(3
				(= global122 6)
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sBreezeShrubs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 7 15))
			)
			(1
				(shrub1 show: setCycle: Fwd)
				(shrub2 show: setCycle: Fwd)
				(= seconds (Random 1 4))
			)
			(2
				(shrub1 hide:)
				(shrub2 hide:)
				(UnLoad 128 242)
				(self changeState: 0)
			)
		)
	)
)

(instance bucket of Prop
	(properties
		x 92
		y 31
		z 20
		noun 19
		view 241
		priority 8
		signal 16
	)
)

(instance storeDoor of Door
	(properties
		x 123
		y 93
		noun 16
		approachX 132
		approachY 100
		view 240
		entranceTo 650
		lockedCase 1
		openSnd 2146
		closeSnd 2147
		openVerb 4
		moveToX 132
		moveToY 91
		enterType 0
		exitType 0
	)
)

(instance storeDoorClosed of View
	(properties
		x 123
		y 93
		noun 17
		view 252
		loop 3
	)
)

(instance barberDoor of Door
	(properties
		x 305
		y 93
		noun 15
		approachX 313
		approachY 100
		view 240
		loop 1
		entranceTo 640
		lockedCase 1
		openSnd 2146
		closeSnd 2147
		openVerb 4
		moveToX 313
		moveToY 92
		enterType 0
		exitType 0
	)
)

(instance cowboy1 of Prop
	(properties
		x 190
		y 110
		view 101
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and local1 (== view 101) (== cel 4))
				(= local1 0)
				(shot1 play: self)
			)
		)
	)

	(method (cue)
		(= local1 1)
	)
)

(instance cowboy2 of Prop
	(properties
		x 130
		y 158
		view 101
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and local2 (== view 101) (== cel 4))
				(= local2 0)
				(shot2 play: self)
			)
		)
	)

	(method (cue)
		(= local2 1)
	)
)

(instance cowboy3 of Prop
	(properties
		x 68
		y 133
		view 101
	)
)

(instance cowboy4 of Prop
	(properties
		x 251
		y 157
		view 101
	)
)

(instance barberpole of Prop
	(properties
		x 266
		y 101
		noun 13
		view 240
		loop 2
	)
)

(instance shrub1 of Prop
	(properties
		y 189
		noun 21
		view 242
		priority 15
		signal 16
	)
)

(instance shrub2 of Prop
	(properties
		x 118
		y 189
		noun 21
		view 242
		loop 1
		priority 15
		signal 16
	)
)

(instance dummyCredits of Prop
	(properties
		x -10
		y -10
		view 996
	)
)

(instance store of Feature
	(properties
		x 158
		y 22
		noun 5
	)
)

(instance postOffice of Feature
	(properties
		x 238
		y 34
		noun 6
	)
)

(instance barberShop of Feature
	(properties
		x 292
		y 32
		noun 14
	)
)

(instance clutter of Feature
	(properties
		x 169
		y 167
		noun 9
	)
)

(instance storeWindow of Feature
	(properties
		x 177
		y 73
		noun 2
		nsTop 58
		nsLeft 153
		nsBottom 89
		nsRight 202
	)
)

(instance postWindow of Feature
	(properties
		x 254
		y 74
		noun 4
		nsTop 63
		nsLeft 246
		nsBottom 86
		nsRight 262
	)
)

(instance barberWindow of Feature
	(properties
		x 286
		y 79
		noun 3
		nsTop 67
		nsLeft 273
		nsBottom 91
		nsRight 300
	)
)

(instance storeSign of Feature
	(properties
		x 158
		y 22
		noun 11
		nsTop 7
		nsLeft 106
		nsBottom 37
		nsRight 210
	)
)

(instance postSign of Feature
	(properties
		x 238
		y 34
		noun 12
		nsTop 19
		nsLeft 213
		nsBottom 50
		nsRight 264
	)
)

(instance barberSign of Feature
	(properties
		x 292
		y 32
		noun 10
		nsTop 17
		nsLeft 265
		nsBottom 48
		nsRight 319
	)
)

(instance hotel of Feature
	(properties
		x 12
		y 60
		noun 7
		nsBottom 121
		nsRight 24
	)
)

(instance wagon of Feature
	(properties
		x 79
		y 73
		noun 8
		nsTop 56
		nsLeft 60
		nsBottom 91
		nsRight 98
	)
)

(instance postDoor of Feature
	(properties
		x 230
		y 81
		noun 22
		nsTop 63
		nsLeft 221
		nsBottom 100
		nsRight 240
		approachX 230
		approachY 104
	)
)

(instance slopSound of FPSound
	(properties
		flags 1
		number 2241
	)
)

(instance shot1 of FPSound
	(properties
		flags 1
		number 2944
	)
)

(instance shot2 of FPSound
	(properties
		flags 1
		number 2944
	)
)

