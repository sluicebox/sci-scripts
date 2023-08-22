;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 230)
(include sci.sh)
(use Main)
(use Swing)
(use eRS)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Door)
(use ForwardCounter)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm230 0
)

(local
	local0
	local1
	local2 = 1
	local3 = 1
)

(instance rm230 of FPRoom
	(properties
		noun 15
		picture 230
		style 10
		east 240
		west 220
	)

	(method (init)
		(if (IsFlag 59)
			(self setRegions: 90) ; streetRgn
		)
		(gEgo init: setScale: Scaler 100 50 175 95 normalize:)
		(switch gPrevRoomNum
			(west
				(= style 12)
				(gGame handsOn:)
			)
			(east
				(= style 11)
				(if (and (not (Random 0 5)) (not (IsFlag 26)))
					(stuntMan init: setCel: 0 setScript: sStuntMan)
				else
					(gGame handsOn:)
				)
			)
			(500
				(gEgo posn: 200 47 setScale: Scaler 58 49 55 47)
				(gCurRoom setScript: sEnterFrom500)
			)
			(660
				(gEgo edgeHit: EDGE_NONE)
			)
			(670
				(gEgo edgeHit: EDGE_NONE)
			)
			(680
				(gGame handsOn:)
			)
			(26 ; actBreak
				(if (IsFlag 80)
					(gGameMusic1 fade: 63 5 1 0)
					(ClearFlag 80)
					(manBoarding
						init:
						approachVerbs: 4 2 ; Do, Talk
						setScript: sCloseHotel
					)
					(gEgo x: 140 y: 150 setHeading: 180)
					(gGame handsOn:)
					(PalVary pvUNINIT)
				else
					(SetFlag 113)
					(LoadMany rsSCRIPT 1814)
					(gCurRoom setScript: sSepiaStart)
				)
			)
			(else
				(gEgo x: 160 y: 160)
				(gGame handsOn:)
			)
		)
		(super init:)
		(cond
			((== gCurPuzzle 14) 0)
			((== gPrevRoomNum 670)
				(gGameMusic1 fade: 63 30 8 0)
			)
			((and (!= gCurPuzzle 22) (!= gPrevRoomNum 26)) ; actBreak
				(switch (Random 2 9)
					(2
						(= global135 673)
					)
					(3
						(= global135 673)
					)
					(4
						(= global135 665)
					)
					(5
						(= global135 665)
					)
					(6
						(= global135 666)
					)
					(7
						(= global135 666)
					)
					(8
						(= global135 670)
					)
					(9
						(= global135 670)
					)
				)
				(gGameMusic1 number: global135 loop: -1 play: setVol: 63)
			)
		)
		(if (or (== gPrevRoomNum 500) (== gPrevRoomNum 680))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 218 51 213 40 201 40 206 54 318 54 318 51
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					(if (== gPrevRoomNum 26) ; actBreak
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 124 281 124 281 110 205 110 168 113 151 74 147 74 147 114 134 114 129 105 51 105 51 78 37 78 37 105 0 105
							yourself:
						)
					else
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 109 304 109 301 102 279 102 276 110 205 110 168 113 151 74 147 74 147 114 134 114 129 105 51 105 51 78 37 78 37 105 0 105
							yourself:
						)
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 174 319 174 319 189 0 189
						yourself:
					)
					(beforePol
						type: PBarredAccess
						init: 131 114 137 125 111 125 105 123 64 123 64 108 75 108 76 114
						name: {beforePol}
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 8 107 23 107 23 118 8 118
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 302 109 302 122 283 122 283 109
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 200 112 215 112 215 120 200 120
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 243 111 258 111 258 120 243 120
						yourself:
					)
			)
		)
		(cond
			((IsFlag 26)
				(fixGlass setScript: sFixGlass)
			)
			((not (gCast contains: stuntMan))
				(glass init: addToPic:)
			)
		)
		(if (and (not (IsFlag 53)) (== global141 gCurRoomNum) (== gAct 3))
			(gCurRoom
				addObstacle:
					(= local1
						((Polygon new:)
							type: PBarredAccess
							init: 107 126 107 135 77 135 77 126
							yourself:
						)
					)
			)
			(horsePlop init: approachVerbs: 4) ; Do
		)
		(cond
			((>= gCurPuzzle 19)
				(momsDoor
					view: 252
					loop: 1
					cel: 0
					x: 140
					y: 91
					locked: 1
					init:
					addToPic:
				)
			)
			((or (IsFlag 1) (== gPrevRoomNum 500))
				(momsDoor locked: 1 init:)
			)
			(else
				(momsDoor init:)
			)
		)
		(if (== gPrevRoomNum 500)
			(saloonDoor locked: 1 init: approachVerbs: 0)
		else
			(saloonDoor init:)
		)
		(bunting init: setOnMeCheck: 1 256)
		(if (< (gEgo y:) 75)
			(bunting approachVerbs: 40) ; Nitrous_Oxide
		)
		(if (IsFlag 33)
			(cannister init:)
		)
		(saloonWindow init:)
		(saloonWindow2 init:)
		(saloon init:)
		(cafe init:)
		(momsWindow init:)
		(barrel init:)
		(hotelWindow init:)
		(hotelWindow2 init:)
		(hotelWindow3 init:)
		(hotelWindow4 init:)
		(hotelWindow5 init:)
		(if (< (gEgo y:) 75)
			(hotelWindow approachVerbs: 4) ; Do
			(hotelWindow2 approachVerbs: 4) ; Do
			(hotelWindow3 approachVerbs: 4) ; Do
		else
			(hotelWindow4 approachVerbs: 4) ; Do
			(hotelWindow5 approachVerbs: 4) ; Do
		)
		(hotelDoor init:)
		(clutter init: setOnMeCheck: 1 4)
		(post init: setOnMeCheck: 1 8)
		(hotelBalcony init: setOnMeCheck: 1 32)
		(momsPorch init: setOnMeCheck: 1 64)
		(saloonPorch init: setOnMeCheck: 1 128)
		(hotelPorch init: setOnMeCheck: 1 16)
		(if (not (< (gEgo y:) 75))
			(hotelDoor approachVerbs: 4) ; Do
		)
		(if (not (< (gEgo y:) 75))
			(hotelDoor approachVerbs: 4) ; Do
		)
		(if (and (IsFlag 52) (!= gPrevRoomNum 26)) ; actBreak
			(dummyCredits init: setScript: (ScriptID 32 0)) ; sOpeningCredits
		)
	)

	(method (cue)
		(= local3 1)
	)

	(method (doit)
		(super doit:)
		(cond
			((and local0 (== (PalVary pvGET_CURRENT_STEP) 0))
				(sSepiaStart cue:)
				(= local0 0)
			)
			(script)
			(
				(and
					(< (gEgo y:) 108)
					(< 30 (gEgo x:) 55)
					(or (< (gEgo heading:) 46) (> (gEgo heading:) 314))
					local2
				)
				(= local2 0)
				(saloonDoor doVerb: 4)
			)
			((= local2 0)
				(saloonDoor doVerb: 4)
			)
			((proc0_1 gEgo 2)
				(gCurRoom newRoom: 500)
			)
		)
	)

	(method (dispose)
		(if (and (!= gNewRoomNum 670) (!= gCurPuzzle 14))
			(gGameMusic1 fade:)
		)
		(if (fixGlass script:)
			(sFixGlass dispose:)
		)
		(ClearFlag 113)
		(LoadMany 0 12)
		(DisposeScript 32)
		(super dispose:)
	)
)

(instance sSepiaStart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable:)
				(gGame setCursor: 996)
				(manBoarding init: approachVerbs: 4 2) ; Do, Talk
				(gEgo x: -10 y: 150)
				(= local0 1)
				(= seconds 3)
			)
			(1
				(manBoarding setScript: sCloseHotel)
				((ScriptID 1814 57) modeless: 1) ; Willy
				(PalVary pvREVERSE 8 0 1)
			)
			(2
				(gMessager say: 28 0 0 0 self) ; "Freddy Pharkas? You wuz askin' about Freddy Pharkas? The man whut saved Coarsegold, only nobody knowed it wuz him?"
			)
			(3
				((ScriptID 1814 57) modeless: 0) ; Willy
				(gEgo setMotion: MoveTo 140 150 self)
			)
			(4
				(gEgo setMotion: 0 setHeading: 180 setSpeed: 4)
				(UnLoad 128 ((ScriptID 1814 57) view:)) ; Willy
				(gTheIconBar enable:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseHotel of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (client loop:) 0) (== (client cel:) 0) local3)
			(= local3 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(manBoarding setLoop: 2 setCel: 0 setCycle: End self)
			)
			(1
				(gGameMusic2 number: 2105 setLoop: 1 play:)
				(manBoarding
					setLoop: 0
					setCel: 0
					setCycle: ForwardCounter 1 self
				)
			)
			(2
				(gGameMusic2 number: 2105 setLoop: 1 play:)
				(manBoarding
					setLoop: 0
					setCel: 0
					setCycle: ForwardCounter 1 self
				)
			)
			(3
				(gGameMusic2 number: 2105 setLoop: 1 play:)
				(manBoarding
					setLoop: 0
					setCel: 0
					setCycle: ForwardCounter 1 self
				)
			)
			(4
				(manBoarding
					setLoop: 2
					setCel: (manBoarding lastCel:)
					setCycle: Beg self
				)
			)
			(5
				(= ticks 120)
			)
			(6
				(self changeState: 0)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance sStuntMan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(SetFlag 26)
				(stuntMan cycleSpeed: 9 setCycle: End self)
				(gGameMusic2 number: 2231 loop: 1 flags: 1 play:)
			)
			(2
				((gCurRoom obstacles:) delete: beforePol)
				(beforePol dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 131 114 137 125 130 136 123 136 107 130 91 137 83 137 64 132 64 123 64 108 75 108 76 114
							yourself:
						)
				)
				(stuntMan
					ignoreActors: 1
					setLoop: 1
					posn: 107 135 0
					noun: 21
					addToPic:
				)
				(stuntGuy init:)
				(gGameMusic2
					number: (if (<= gAct 2) 2925 else 2935)
					loop: 1
					flags: 1
					play:
				)
				(saloonWindow2 noun: 22)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFixGlass of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fixGlass init: approachVerbs: 4 2) ; Do, Talk
				(= seconds 3)
			)
			(1
				(ClearFlag 26)
				(fixGlass cycleSpeed: 12 setCycle: End self)
			)
			(2
				(= seconds 4)
			)
			(3
				(glass init:)
				(fixGlass setLoop: 4 setCel: 1 setPri: -1 posn: 106 106)
				(= cycles 2)
			)
			(4
				(fixGlass
					setLoop: 1
					posn: 103 106
					cycleSpeed: 6
					setCycle: Walk
					setMotion: PolyPath 152 119 self
				)
			)
			(5
				(fixGlass setLoop: 2 setMotion: PolyPath 134 137 self)
			)
			(6
				(fixGlass setMotion: PolyPath -15 137 self)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance sEnterFrom500 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 212 54 self)
			)
			(1
				(if (== gCurPuzzle 22)
					(gMessager say: 25 0 0 0 self) ; MISSING MESSAGE
				else
					(= cycles 1)
				)
			)
			(2
				(if (== gCurPuzzle 22)
					(gMessager say: 25 0 7) ; MISSING MESSAGE
					(gGameMusic2 number: 236 loop: 1 flags: 1 play:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseSaloonDoors of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(saloonDoor setPri: 6 setCel: 3 setCycle: CT 6 1 self)
			)
			(1
				(gEgo
					posn: (saloonDoor moveToX:) (saloonDoor moveToY:)
					setMotion:
						PolyPath
						(saloonDoor approachX:)
						(saloonDoor approachY:)
						self
				)
			)
			(2
				(doorSound number: (saloonDoor openSnd:) play:)
				(saloonDoor setPri: 5 setCycle: Swing 1 1 0 1 self)
			)
			(3
				(saloonDoor doorState: 3 cue:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenSaloonDoors of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						PolyPath
						(saloonDoor moveToX:)
						(saloonDoor moveToY:)
						self
				)
			)
			(1
				(gEgo setHeading: 0)
				(saloonDoor setPri: 7 setCycle: Swing 1 1 0 1 self)
			)
			(2
				(saloonDoor cue:)
				(self dispose:)
			)
		)
	)
)

(instance fixGlass of Actor
	(properties
		x 106
		y 109
		noun 23
		view 232
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb 2) ; "Poor Sam Andreas! It's a good thing he waters down his whisky so much, or else all of his profits would be consumed by glaziers."
			)
			(2 ; Talk
				(gMessager say: noun theVerb 2) ; "Don't you find it frustrating to keep replacing that plate glass, Billy?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance manBoarding of Prop
	(properties
		x 309
		y 112
		noun 23
		approachX 283
		approachY 129
		view 110
		loop 2
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb 3) ; "You are surprised to see Billy, the town handyman, boarding up The Dirty Sheet Hotel."
			)
			(2 ; Talk
				(gMessager say: noun theVerb 3) ; "Billy, the town handyman and jack-of-all-trades, is boarding up yet another Coarsegold business, the "Dirty Sheets Hotel," the finest hostelry in all of Eastern Madera County."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cannister of Prop
	(properties
		x 273
		y 90
		z 50
		noun 27
		view 230
		loop 2
		priority 7
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (< (gEgo y:) 75)
					(gEgo get: 39 self 2 self) ; Nitrous_Oxide
					(ClearFlag 33)
				else
					(gMessager say: noun 4 8) ; "Just fly there."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stuntMan of Prop
	(properties
		x 103
		y 1
		z -89
		view 231
		priority 8
		signal 16401
	)
)

(instance momsDoor of Door
	(properties
		x 140
		y 93
		noun 6
		approachX 147
		approachY 106
		view 230
		loop 1
		entranceTo 660
		lockedCase 12
		openSnd 2146
		closeSnd 2147
		openVerb 4
		moveToX 147
		moveToY 89
		enterType 0
		exitType 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (> gCurPuzzle 17)
					(gMessager say: 6 1 6) ; "A crudely-lettered sign reads, "Mom's's Cafe's dun bin closed by order of the sheriff. Health Code violations is all the reason he needs!""
				else
					(gMessager say: 6 1) ; "Mom's Cafe awaits the hearty traveler who has a thing for good food-- but isn't afraid to eat here anyway!"
				)
			)
			(4 ; Do
				(if (> gCurPuzzle 17)
					(gMessager say: 6 4 6) ; "It's locked! Mom's is closed!"
				else
					(gCurRoom north: 660)
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(super init:)
		(if (== gPrevRoomNum 500)
			(= lockedCase 13)
		else
			(= lockedCase 12)
		)
	)
)

(instance saloonDoor of Door
	(properties
		x 40
		y 94
		noun 7
		approachX 42
		approachY 115
		view 230
		cel 3
		priority 5
		signal 16
		entranceTo 670
		lockedCase 13
		openSnd 2911
		closeSnd 2911
		openVerb 4
		moveToX 40
		moveToY 101
		enterType 0
		exitType 0
	)

	(method (init)
		(= openScript sOpenSaloonDoors)
		(= closeScript sCloseSaloonDoors)
		(super init:)
		(= cel 3)
	)

	(method (createPoly)
		(super createPoly: 28 103 28 100 57 100 57 103)
	)

	(method (open)
		(if locked
			(super open:)
		else
			(if (gUser controls:)
				(gGame handsOff:)
			)
			(= doorState 1)
			(self setCycle: CT 0 -1 self)
			(if (self openSnd:)
				(doorSound number: (self openSnd:) play:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local2 0)
				(gEgo edgeHit: EDGE_TOP)
				(gCurRoom north: 670)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance horsePlop of Prop
	(properties
		x 92
		y 130
		noun 24
		approachX 84
		approachY 138
		view 129
		loop 2
		signal 16384
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo get: 23 horsePlop) ; Horse_Plop
				(SetFlag 53)
				(gGame points: 1 128)
				((gCurRoom obstacles:) delete: local1)
				(local1 dispose:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance dummyCredits of Prop
	(properties
		x -10
		y -10
		view 996
	)
)

(instance glass of View
	(properties
		x 103
		y 90
		noun 19
		view 231
		loop 2
		signal 16385
	)
)

(instance beforePol of Polygon
	(properties)
)

(instance stuntGuy of Feature
	(properties
		x 91
		y 129
		noun 21
		nsTop 124
		nsLeft 67
		nsBottom 135
		nsRight 129
	)
)

(instance saloonWindow of Feature
	(properties
		x 76
		y 78
		noun 19
		nsTop 67
		nsLeft 63
		nsBottom 91
		nsRight 89
	)
)

(instance saloonWindow2 of Feature
	(properties
		x 103
		y 79
		noun 19
		nsTop 67
		nsLeft 90
		nsBottom 91
		nsRight 116
	)
)

(instance saloon of Feature
	(properties
		x 65
		y 22
		noun 1
		nsTop -1
		nsLeft 34
		nsBottom 46
		nsRight 97
	)
)

(instance cafe of Feature
	(properties
		x 163
		y 25
		noun 2
		nsTop 5
		nsLeft 128
		nsBottom 46
		nsRight 198
	)
)

(instance momsWindow of Feature
	(properties
		x 181
		y 74
		noun 3
		nsTop 65
		nsLeft 170
		nsBottom 84
		nsRight 193
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (> gCurPuzzle 17)
					(gMessager say: 3 1 6) ; "You feel a twinge of guilt, knowing you were at least partially responsible for Mom's closing. You vow to make it up to her, somehow."
				else
					(gMessager say: 3 1) ; "Peering through Mom's greasy glass, you can see she's open for business. You've always been fond of Mom's cooking..."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance barrel of Feature
	(properties
		x 119
		y 114
		noun 4
		nsTop 104
		nsLeft 110
		nsBottom 124
		nsRight 129
	)
)

(instance hotelWindow of Feature
	(properties
		x 236
		y 30
		noun 5
		nsTop 17
		nsLeft 229
		nsBottom 43
		nsRight 244
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (< (gEgo y:) 75))
					(gMessager say: noun theVerb 10) ; "You really can't reach that window from here. But hey, a Pharmacist's reach should exceed his grasp!"
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hotelWindow2 of Feature
	(properties
		x 271
		y 29
		noun 5
		nsTop 15
		nsLeft 263
		nsBottom 43
		nsRight 280
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (< (gEgo y:) 75))
					(gMessager say: noun theVerb 10) ; "You really can't reach that window from here. But hey, a Pharmacist's reach should exceed his grasp!"
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hotelWindow3 of Feature
	(properties
		x 311
		y 30
		noun 5
		nsTop 17
		nsLeft 304
		nsBottom 43
		nsRight 319
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (< (gEgo y:) 75))
					(gMessager say: noun theVerb 10) ; "You really can't reach that window from here. But hey, a Pharmacist's reach should exceed his grasp!"
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hotelWindow4 of Feature
	(properties
		x 241
		y 79
		noun 5
		nsTop 65
		nsLeft 212
		nsBottom 93
		nsRight 270
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (< (gEgo y:) 75)
					(gMessager say: noun theVerb 10) ; "You really can't reach that window from here. But hey, a Pharmacist's reach should exceed his grasp!"
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hotelWindow5 of Feature
	(properties
		x 316
		y 79
		noun 5
		nsTop 65
		nsLeft 313
		nsBottom 93
		nsRight 319
		approachX 310
		approachY 114
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (< (gEgo y:) 75)
					(gMessager say: noun theVerb 10) ; "You really can't reach that window from here. But hey, a Pharmacist's reach should exceed his grasp!"
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hotelDoor of Feature
	(properties
		x 291
		y 82
		noun 14
		nsTop 66
		nsLeft 276
		nsBottom 99
		nsRight 306
		approachX 289
		approachY 105
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (< (gEgo y:) 75)
					(gMessager say: noun theVerb 10) ; "That would be quite a trick...opening the Hotel door from the balcony."
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance clutter of Feature
	(properties
		x 160
		y 180
		noun 8
		onMeCheck 4
	)
)

(instance post of Feature
	(properties
		x 100
		y 90
		noun 9
		onMeCheck 8
	)
)

(instance hotelPorch of Feature
	(properties
		x 190
		y 80
		noun 10
		onMeCheck 16
		approachX 235
		approachY 129
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (< (gEgo y:) 75)
					(gMessager say: noun theVerb 10) ; "You can't reach the porch from here."
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hotelBalcony of Feature
	(properties
		x 190
		y 60
		noun 11
		onMeCheck 32
	)
)

(instance bunting of Feature
	(properties
		x 271
		y 75
		noun 26
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 1)
					(gMessager say: 26 1 11) ; "It's too dark to make out what's written on that bunting."
				else
					(gMessager say: 26 1) ; "It reads, "Coming soon -- Open Megaphone Night. Take your best shot! You'll die laughing!""
				)
			)
			(40 ; Nitrous_Oxide
				(if (< (gEgo y:) 75)
					(if (== gCurPuzzle 22)
						(gEgo put: 39) ; Nitrous_Oxide
						(cannister init: approachVerbs: 4) ; Do
						(SetFlag 33)
						(gGame points: 5 145)
					else
						(gMessager say: 26 40 9) ; "You've got no reason to put the canister on the railing."
					)
				else
					(gMessager say: 26 40 8) ; "Not from down here, you can't!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance momsPorch of Feature
	(properties
		x 160
		y 80
		noun 12
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (> gCurPuzzle 17)
					(gMessager say: 12 1 6) ; "Poor Mom. You almost wish you hadn't dumped that horse patty inside her eating area. But-- you vow to make it up to her somehow!"
				else
					(gMessager say: 12 1) ; "Mom's front porch is almost as large as her rear entry."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance saloonPorch of Feature
	(properties
		x 80
		y 80
		noun 13
		onMeCheck 128
	)
)

(instance doorSound of FPSound
	(properties)
)

