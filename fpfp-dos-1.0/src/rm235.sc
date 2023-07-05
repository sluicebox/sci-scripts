;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 235)
(include sci.sh)
(use Main)
(use Swing)
(use OccasionalCycle)
(use eRS)
(use PAvoider)
(use Scaler)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use Door)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm235 0
)

(local
	local0
	local1 = 1
	local2 = 1
	local3 = 1
	local4 = 1
	local5 = 1
	local6 = 1
	local7 = 1
	local8 = 1
	local9 = 1
	local10
	local11
)

(instance rm235 of FPRoom
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
		(if (== gCurPuzzle 22)
			(self setRegions: 91) ; rowdyRgn
		)
		(gEgo init: setScale: Scaler 100 50 175 95 normalize:)
		(switch gPrevRoomNum
			(west
				(= style 12)
				(gGame handsOn:)
				(if (== gCurPuzzle 22)
					(cowboy1 setScript: sRowdysKill)
				)
			)
			(east
				(= style 11)
				(gGame handsOn:)
			)
			(400
				(gEgo hide:)
				(= style 9)
				(cannister setLoop: 3 setCycle: Fwd)
			)
			(500
				(gEgo posn: 200 47 setScale: Scaler 58 49 55 47)
				(gCurRoom setScript: sEnterFrom500)
			)
			(660
				(gEgo edgeHit: 0)
			)
			(670
				(gEgo edgeHit: 0)
			)
			(680
				(gGame handsOn:)
			)
			(else
				(gEgo x: 160 y: 160)
				(gGame handsOn:)
			)
		)
		(super init:)
		(switch gCurPuzzle
			(20
				(gEgo setAvoider: PAvoider)
				(chester init: approachVerbs: 4 2 setScript: sChesterPaces) ; Do, Talk
				(if (not (IsFlag 72))
					(SetFlag 72)
					((ScriptID 0 13) setReal: (ScriptID 0 13) 0 7) ; deathTimer, deathTimer
				)
			)
			(22
				(gNarrator modeless: 1)
				(cowboy1
					setLoop: (Random 0 1)
					cel: (Random 0 3)
					setScale: Scaler 100 50 175 95
					init:
				)
				(cowboy2
					setLoop: (Random 2 3)
					cel: (Random 0 3)
					setScale: -1 cowboy1
					init:
				)
				(if (and (> gHowFast 6) (> (gGame detailLevel:) 3))
					(cowboy3
						setLoop: (Random 4 5)
						cel: (Random 0 3)
						setScale: -1 cowboy1
						init:
					)
					(cowboy4
						setLoop: (Random 6 7)
						cel: (Random 0 3)
						setScale: -1 cowboy1
						init:
					)
				)
				(if (and (> gHowFast 13) (> (gGame detailLevel:) 1))
					(cowboy5
						setLoop: (Random 8 9)
						cel: (Random 0 3)
						setScale: -1 cowboy1
						init:
					)
					(cowboy6
						setLoop: (Random 10 11)
						cel: (Random 0 3)
						setScale: -1 cowboy1
						init:
					)
				)
			)
		)
		(if (== gPrevRoomNum 400)
			(gGameMusic2 number: 2145 loop: 1 flags: 1 play:)
			(gCurRoom setScript: sROFL)
		)
		(cond
			((== gPrevRoomNum 670)
				(gGameMusic1 fade: 63 30 8 0)
			)
			((and (!= gCurPuzzle 22) (!= gPrevRoomNum 26)) ; actBreak
				(switch (Random 0 3)
					(0
						(= global135 673)
					)
					(1
						(= global135 665)
					)
					(2
						(= global135 666)
					)
					(3
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
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 109 304 109 301 102 279 102 276 110 205 110 168 113 151 74 147 74 147 114 134 114 129 105 51 105 51 78 37 78 37 105 0 105
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 174 319 174 319 189 0 189
						yourself:
					)
					(if (or (== gCurPuzzle 8) (== gCurPuzzle 9))
						(beforePol
							type: PBarredAccess
							init: 131 114 137 125 125 129 121 142 61 142 60 108 75 108 76 114
							name: {beforePol}
							yourself:
						)
					else
						(beforePol
							type: PBarredAccess
							init: 131 114 137 125 111 125 105 123 64 123 64 108 75 108 76 114
							name: {beforePol}
							yourself:
						)
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
		(if (and (>= gCurPuzzle 8) (<= gCurPuzzle 9))
			(horse1
				init:
				cycleSpeed: 10
				setCycle: Fwd
				setScript: sHorseStuff
				approachVerbs: 65 ; Paper_Sack
			)
			(horse2
				init:
				cycleSpeed: 12
				setCycle: Fwd
				setScript: (sHorseStuff new:)
				approachVerbs: 65 ; Paper_Sack
			)
			(LoadMany rsSOUND 2116)
		)
		(if (== gPrevRoomNum 500)
			(saloonDoor locked: 1 init: approachVerbs: 0)
		else
			(saloonDoor init:)
		)
		(glass init: addToPic:)
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
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			(
				(and
					(< (gEgo y:) 113)
					(< 30 (gEgo x:) 55)
					(or (< (gEgo heading:) 46) (> (gEgo heading:) 314))
					local1
				)
				(= local1 0)
				(saloonDoor doVerb: 4)
			)
			((proc0_1 gEgo 2)
				(gCurRoom newRoom: 500)
			)
		)
	)

	(method (dispose)
		(if (!= gNewRoomNum 670)
			(gGameMusic1 fade:)
		)
		(if (and (== gCurPuzzle 22) (== gPrevRoomNum 500))
			(gGameMusic2 mute: 1 6)
		)
		(if (== gCurPuzzle 22)
			(gNarrator modeless: 0)
		)
		(LoadMany 0 927 12)
		(super dispose:)
	)
)

(instance sChesterPaces of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (if (not (Random 0 2)) 106 else 136))
				(chester
					setLoop: 0
					setCycle: Walk
					xStep: 3
					setMotion: MoveTo local0 (chester y:) self
				)
			)
			(1
				(cond
					((== (chester loop:) 2)
						(chester
							setLoop: 0
							y: 135
							setMotion: MoveTo 136 (chester y:) self
						)
						(-- state)
					)
					((== (chester x:) 106)
						(chester setLoop: 2 setCel: 0 y: 133)
						(-- state)
						(= seconds (Random 3 5))
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(chester setLoop: 1 setMotion: MoveTo 75 (chester y:) self)
			)
			(3
				(self changeState: 0)
			)
			(4
				(self dispose:)
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
				(gMessager say: 25 0 0 0 self) ; "You encounter dozens of rowdy cowhands from that cattle drive outside of town who are carelessly firing their guns everywhere and frightening (not to mention killing) the locals."
			)
			(2
				(gEgo setMotion: MoveFwd 20 self)
			)
			(3
				(gEgo
					view: 142
					setLoop: (if (< (gEgo heading:) 180) 0 else 1)
					setCel: 0
					setSpeed: 7
					setCycle: End self
				)
			)
			(4
				(= global122 6)
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sKillOnBalcony of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 142
					setLoop: (if (< (gEgo heading:) 180) 0 else 1)
					setCel: 0
					setSpeed: 7
					setCycle: End self
				)
			)
			(1
				(= global122 6)
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sROFL of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameMusic1 number: 2237 loop: -1 play:)
				0
			)
			(1 0)
			(2
				(if (or (<= gHowFast 6) (<= (gGame detailLevel:) 3))
					(= cycles 2)
				else
					0
				)
			)
			(3
				(if (or (<= gHowFast 6) (<= (gGame detailLevel:) 3))
					(= cycles 2)
				else
					0
				)
			)
			(4
				(if (or (<= gHowFast 13) (== (gGame detailLevel:) 1))
					(= cycles 2)
				else
					0
				)
			)
			(5
				(if (or (<= gHowFast 13) (== (gGame detailLevel:) 1))
					(= cycles 2)
				else
					0
				)
				(gGameMusic1 stop:)
			)
			(6
				(gGameMusic2 number: 2701 flags: 1 loop: 1 play: self)
			)
			(7
				(ClearFlag 33)
				(= seconds 3)
			)
			(8
				(gCurRoom newRoom: 400)
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
				(gGameMusic2 mute: 0 6)
				(gEgo setMotion: MoveTo 212 54 self)
			)
			(1
				(if (== gCurPuzzle 22)
					(gMessager say: 25 0 0 0 self) ; "You encounter dozens of rowdy cowhands from that cattle drive outside of town who are carelessly firing their guns everywhere and frightening (not to mention killing) the locals."
				else
					(= cycles 1)
				)
			)
			(2
				(if (== gCurPuzzle 22)
					(gMessager say: 25 0 7 0 self) ; "Luckily, the rowdy cowboys don't notice you from down below."
					(gGameMusic1 number: 236 loop: 1 flags: 1 play:)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(3
				(gNarrator modeless: 0)
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

(instance sHorseStuff of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local8 (== (horse1 loop:) 3) (== (horse1 cel:) 4))
			(= local8 0)
			(horseSound number: 2116 play: horse1)
		)
		(if (and local9 (== (horse2 loop:) 3) (== (horse2 cel:) 4))
			(= local9 0)
			(horseSound2 number: 2939 play: horse2)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 0 3)
					(0
						(client setLoop: 0)
					)
					(1
						(client setLoop: 1)
					)
					(2
						(client setLoop: 3)
					)
					(3
						(client setLoop: 2)
					)
				)
				(client setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(if (and (== (Random 5 10) 8) (!= (client loop:) 3))
					(switch client
						(horse1
							(horseSound number: 2114 play: horse1)
						)
						(horse2
							(horseSound2 number: 2115 play: horse2)
						)
					)
				)
				(= seconds (Random 3 10))
			)
			(2
				(client setCycle: End self)
				(self changeState: 0)
			)
		)
	)
)

(instance sEndPuz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(gTimers delete: (ScriptID 0 13) (ScriptID 0 14)) ; deathTimer, gasMaskTimer
				(= cycles 1)
			)
			(1
				(gCast eachElementDo: #dispose)
				(gCurRoom style: 100 drawPic: 780)
				(gEgo put: 21 put: 13 put: 20) ; Gas_Mask, Deflatulizer, Filled_Sack
				(gGame points: 20 152)
				(= cycles 1)
			)
			(2
				(gMessager say: 1 29 0 0 self 18) ; "You carefully pour the Deflatulizer into the horse's water trough."
			)
			(3
				(= gCurPuzzle 10)
				(gCurRoom newRoom: 250)
				((ScriptID 0 13) setReal: (ScriptID 0 13) 0 15) ; deathTimer, deathTimer
				(self dispose:)
			)
		)
	)
)

(instance manBoarding of Prop ; UNUSED
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
				(gMessager say: noun theVerb 3) ; MISSING MESSAGE
			)
			(2 ; Talk
				(gMessager say: noun theVerb 3) ; MISSING MESSAGE
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

(instance chester of Actor
	(properties
		x 75
		y 135
		noun 18
		view 233
		cycleSpeed 12
		moveSpeed 12
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
		approachY 112
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

	(method (cue)
		(super cue:)
		(if (and (== doorState 0) (== gCurPuzzle 22))
			(gCurRoom setScript: sRowdysKill)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo edgeHit: 1)
				(gCurRoom north: 670)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance horse1 of Prop
	(properties
		x 97
		y 127
		noun 1
		approachX 106
		approachY 142
		view 116
		loop 2
		priority 8
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; Paper_Sack
				(cond
					((== gCurPuzzle 8)
						(gMessager say: noun 0 4 0 0 18) ; "The aroma is simply too overpowering. You daren't touch the horse until you have some way to protect yourself from the stench."
					)
					((and (== (self loop:) 3) (not (gEgo has: 20))) ; Filled_Sack
						(gEgo put: 41) ; Paper_Sack
						(gEgo get: -1 20) ; Filled_Sack
						(gGame points: 6 151)
						(gMessager say: noun 65 0 0 0 18) ; "Yes, it's very possibly the most revolting thing you've ever done, but hey, a pharmacist's gotta do what a pharmacist's gotta do."
					)
					(else
						(gMessager say: noun 65 2 0 0 18) ; "A really terrifically disgusting idea! Unfortunately, the horse's tail is momentarily blocked."
					)
				)
			)
			(64 ; Filled_Sack
				(gMessager say: noun 64 0 0 0 18) ; "She can't take any more, Captain! Any more and she'll BLOW!"
			)
			(1 ; Look
				(if (== (self loop:) 3)
					(gMessager say: noun 1 1 0 0 18) ; "The horse's tail is fluttering in the breeze! (And what a breeze!)"
				else
					(gMessager say: noun 1 0 0 0 18) ; "It's somebody's poor horse."
				)
			)
			(4 ; Do
				(gMessager say: noun 4 0 0 0 18) ; "Nice horsey!"
			)
			(29 ; Deflatulizer
				(gCurRoom setScript: sEndPuz)
			)
			(else
				(gMessager say: noun theVerb 0 0 0 18)
			)
		)
	)

	(method (cue)
		(super cue:)
		(= local8 1)
	)
)

(instance horse2 of Prop
	(properties
		x 74
		y 127
		noun 1
		approachX 78
		approachY 142
		view 114
		loop 3
		priority 8
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; Paper_Sack
				(cond
					((== gCurPuzzle 8)
						(gMessager say: noun 0 4 0 0 18) ; "The aroma is simply too overpowering. You daren't touch the horse until you have some way to protect yourself from the stench."
					)
					((and (== (self loop:) 3) (not (gEgo has: 20))) ; Filled_Sack
						(gEgo put: 41) ; Paper_Sack
						(gEgo get: -1 20) ; Filled_Sack
						(gGame points: 6 151)
						(gMessager say: noun 65 0 0 0 18) ; "Yes, it's very possibly the most revolting thing you've ever done, but hey, a pharmacist's gotta do what a pharmacist's gotta do."
					)
					(else
						(gMessager say: noun 65 2 0 0 18) ; "A really terrifically disgusting idea! Unfortunately, the horse's tail is momentarily blocked."
					)
				)
			)
			(64 ; Filled_Sack
				(gMessager say: noun 64 0 0 0 18) ; "She can't take any more, Captain! Any more and she'll BLOW!"
			)
			(1 ; Look
				(if (== (self loop:) 3)
					(gMessager say: noun 1 1 0 0 18) ; "The horse's tail is fluttering in the breeze! (And what a breeze!)"
				else
					(gMessager say: noun 1 0 0 0 18) ; "It's somebody's poor horse."
				)
			)
			(4 ; Do
				(gMessager say: noun 4 0 0 0 18) ; "Nice horsey!"
			)
			(29 ; Deflatulizer
				(gCurRoom setScript: sEndPuz)
			)
			(else
				(gMessager say: noun theVerb 0 0 0 18)
			)
		)
	)

	(method (cue)
		(super cue:)
		(= local9 1)
	)
)

(class Cowboy of Prop
	(properties
		noun 29
	)

	(method (init &tmp temp0)
		(super init:)
		(= temp0 (Random 5 10))
		(if (== gPrevRoomNum 400)
			(= view 103)
			(if (>= loop 6)
				(= view 104)
				(-= loop 6)
			)
			(self setCycle: ROsc temp0 0 2 self)
		else
			(= view 101)
			(self setCycle: OccasionalCycle 1 10 30 2 6)
		)
	)

	(method (cue)
		(if (== gPrevRoomNum 400)
			(self setCycle: End sROFL)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Pistols
				(gCurRoom setScript: sKillOnBalcony)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cowboy1 of Cowboy
	(properties
		x 228
		y 139
		view 101
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and local2 (== view 101) (== cel 4) (not local10))
				(= local2 0)
				(if (not (mod (++ local11) 3))
					(= local10 1)
					(yeeHawSound play: self)
					(if (== (yeeHawSound number:) 2954)
						(yeeHawSound number: 2953)
					else
						(yeeHawSound number: 2954)
					)
				else
					(shot1 play: self)
				)
			)
		)
	)

	(method (cue)
		(= local10 0)
		(= local2 1)
		(super cue:)
	)
)

(instance cowboy2 of Cowboy
	(properties
		x 68
		y 133
		view 101
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and local3 (== view 101) (== cel 4) (not local10))
				(= local3 0)
				(shot2 play: self)
			)
		)
	)

	(method (cue)
		(= local3 1)
		(super cue:)
	)
)

(instance cowboy3 of Cowboy
	(properties
		x 119
		y 162
		view 101
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and local4 (== view 101) (== cel 4) (not local10))
				(= local4 0)
				(shot3 play: self)
			)
		)
	)

	(method (cue)
		(= local4 1)
		(super cue:)
	)
)

(instance cowboy4 of Cowboy
	(properties
		x 179
		y 118
		view 101
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and local5 (== view 101) (== cel 4) (not local10))
				(= local5 0)
				(shot4 play: self)
			)
		)
	)

	(method (cue)
		(= local5 1)
		(super cue:)
	)
)

(instance cowboy5 of Cowboy
	(properties
		x 285
		y 169
		view 101
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and local6 (== view 101) (== cel 4) (not local10))
				(= local6 0)
				(shot5 play: self)
			)
		)
	)

	(method (cue)
		(= local6 1)
		(super cue:)
	)
)

(instance cowboy6 of Cowboy
	(properties
		x 150
		y 130
		view 101
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and local7 (== view 101) (== cel 4) (not local10))
				(= local7 0)
				(shot6 play: self)
			)
		)
	)

	(method (cue)
		(= local7 1)
		(super cue:)
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

(instance horseSound of FPSound
	(properties
		flags 1
		number 2116
	)
)

(instance horseSound2 of FPSound
	(properties
		flags 1
		number 2939
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

(instance shot3 of FPSound
	(properties
		flags 1
		number 2944
	)
)

(instance shot4 of FPSound
	(properties
		flags 1
		number 2944
	)
)

(instance shot5 of FPSound
	(properties
		flags 1
		number 2944
	)
)

(instance shot6 of FPSound
	(properties
		flags 1
		number 2944
	)
)

(instance yeeHawSound of FPSound
	(properties
		flags 1
		number 2954
	)
)

(instance doorSound of FPSound
	(properties)
)

