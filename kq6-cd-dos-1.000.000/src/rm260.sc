;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Scaler)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use TimedCue)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm260 0
)

(local
	local0 = 1
	local1
	local2
	[local3 122] = [0 0 0 30 0 1 4 34 0 2 8 38 0 3 13 41 0 4 18 44 0 5 24 47 0 6 30 50 0 0 37 52 0 1 44 53 0 2 52 53 0 3 60 53 0 4 68 52 0 5 75 51 0 6 82 50 0 0 89 49 0 1 97 47 0 2 104 45 2 0 108 42 2 0 114 40 2 0 119 38 2 0 124 35 2 0 129 32 2 0 134 29 2 0 139 26 2 0 145 22 2 0 151 18 2 0 157 14 2 0 163 10 2 0 169 6 2 0 176 2 -32768 -32768]
	[local125 94] = [6 0 130 1 6 1 131 3 6 2 133 6 6 3 136 9 6 4 139 13 6 5 142 17 6 6 146 21 6 0 150 24 6 1 154 27 6 2 158 30 6 3 163 33 6 4 169 35 6 5 175 36 6 6 181 35 6 0 186 33 6 1 190 30 6 2 194 27 6 3 197 23 6 4 200 19 6 5 203 15 6 6 206 11 6 0 208 6 6 1 210 2 -32768 -32768]
	[local219 106] = [6 0 177 2 6 1 176 5 6 2 174 9 6 3 172 13 6 4 169 17 6 5 166 21 6 6 163 25 6 0 159 29 6 0 155 33 6 0 151 37 6 0 146 41 6 0 141 44 7 0 136 46 7 0 132 45 7 0 128 43 7 0 124 41 7 0 120 38 7 0 116 35 7 0 112 32 7 0 109 29 7 0 105 26 7 0 101 23 7 0 97 20 7 0 92 17 7 0 86 14 7 0 80 11 -32768 -32768]
	[local325 142] = [0 0 27 3 0 1 30 7 0 2 33 12 0 3 37 16 0 4 41 20 0 5 46 24 0 6 52 28 0 0 57 32 0 1 62 35 0 2 68 37 0 3 73 38 0 4 77 38 0 5 77 38 0 6 77 38 0 0 77 38 0 1 77 38 0 2 77 38 0 3 77 38 0 4 77 38 1 0 80 37 1 0 75 36 1 0 70 35 1 0 65 34 1 0 60 32 1 0 56 30 1 0 51 28 1 0 46 26 1 0 41 24 1 0 35 22 1 0 30 20 1 0 25 19 1 0 20 18 1 0 14 17 1 0 9 16 1 0 4 15 -32768 -32768]
	[local467 94] = [0 0 264 1 0 1 260 3 0 2 255 5 0 3 249 8 0 4 243 11 0 5 237 14 0 6 231 17 0 0 226 20 0 1 221 23 0 2 216 26 0 3 209 29 0 4 202 31 0 5 195 33 0 6 187 34 0 0 180 34 0 1 174 32 0 2 169 28 0 3 165 24 0 4 162 20 0 5 158 15 0 6 155 10 0 0 153 5 0 1 152 1 -32768 -32768]
	local561
)

(procedure (localproc_0)
	(= local1 1)
	(gEgo observeControl: -32768 setMotion: MoveTo gMouseX (- gMouseY 11))
)

(class GenieCycler of Fwd
	(properties
		waitCounter 3
	)

	(method (doit &tmp temp0)
		(cond
			((> (= temp0 (self nextCel:)) (client lastCel:))
				(self cycleDone:)
			)
			((OneOf (client loop:) 1 5)
				(if
					(and
						(== temp0 4)
						(-- waitCounter)
						(= waitCounter 3)
						(Random 0 1)
					)
					(self cycleDone:)
				else
					(client cel: temp0)
				)
			)
			(else
				(client cel: temp0)
			)
		)
	)
)

(instance rm260 of KQ6Room
	(properties
		noun 4
		picture 260
		horizon 0
		walkOffEdge 1
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 186 76 199 89 199 95 190 95 188 102 179 108 84 87 50 97 3 88 3 103 36 110 90 93 171 111 158 115 157 123 139 123 133 126 134 189 0 189 0 -10 274 -10 274 36 259 53 226 60 197 71
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 232 93 199 74 210 69 227 63 267 55 290 38 290 -10 319 -10 319 105 260 105
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 260 107 318 107 317 189 137 189 136 127 218 127 218 120 232 120 232 109 220 109 220 102 231 102 230 94
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 220 125 220 122 239 122 239 125
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 222 104 236 104 236 107 222 107
					yourself:
				)
		)
		(super init: &rest)
		(genericFeatures init:)
		(gEgo
			setScale: Scaler 97 20 150 30
			init:
			reset: 2
			actions: egoDoVerb
		)
		((ScriptID 10 4) onMeCheck: 128 setOnMeCheck: 1 128 init:) ; rocks
		(hatch init:)
		(sail1 init:)
		(sail2 init:)
		(sail3 init:)
		(sail4 init:)
		(if (> (gGame _detailLevel:) 0)
			(BeachBird init:)
			(if (>= (gGame _detailLevel:) 2)
				(sail1 setScript: (Clone sailScr))
				(sail2 setScript: (Clone sailScr))
				(sail3 setScript: sailScr)
			)
		)
		(switch gPrevRoomNum
			(290
				(gGame handsOn:)
				(gEgo posn: 18 105)
			)
			(else
				(gCurRoom setScript: enterVillage2Scr)
			)
		)
		(if
			(and
				(IsFlag 16)
				(not ((ScriptID 10 0) isSet: 32)) ; rgCrown
				(== gAct 1)
			)
			((ScriptID 10 0) setIt: 32) ; rgCrown
			(genieBoy init: setScript: genieScr)
			(gGlobalSound number: 260 loop: -1 play:)
		else
			(gGlobalSound number: 915 loop: -1 play:)
			(gGlobalSound2 number: 916 loop: -1 play:)
		)
		(ocean init:)
		(boatDoor init:)
		(holeInBoat init:)
		(reflect1 init: setCycle: Fwd)
		(reflect2 init: setCycle: Fwd)
		(reflect3 init: setCycle: Fwd)
		(reflect4 init: setCycle: Fwd)
		(reflect5 init: setCycle: Fwd)
		(if
			(and
				(not (Random 0 2))
				(== gPrevRoomNum 250)
				(not (gCast contains: genieBoy))
			)
			(smFerryman init: setScript: ferrymanScr)
		)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if
			(and
				(not (gCurRoom script:))
				(!= (event type:) evVERB)
				(& (event type:) evMOUSEKEYBOARD)
				(not (event modifiers:))
				(> (event y:) 56)
				(or
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
						(OneOf
							(OnControl CONTROL (event x:) (event y:))
							4
							32
							512
						)
						(gCast contains: genieBoy)
					)
					(and
						(== (OnControl CONTROL (event x:) (event y:)) 4)
						(== (gTheIconBar curIcon:) (gTheIconBar at: 1))
					)
				)
			)
			(self setScript: diveIntoWaterScr)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((and (& (= temp0 (gEgo onControl: 1)) $2000) (not local561))
				(gEgo setPri: 5)
				(= local561 1)
			)
			((and local561 (not (& temp0 $2000)))
				(gEgo setPri: -1)
				(= local561 0)
			)
			(script 0)
			((gEgo inRect: 242 46 288 55)
				(gCurRoom setScript: bailScr)
			)
			((& temp0 $0224)
				(gEgo setMotion: 0)
				(= local1 0)
				(if (> (gEgo y:) 124)
					(self setScript: egoFallForwardScr)
				else
					(self setScript: egoFallRightScr)
				)
			)
			((and (== temp0 8192) (gCast contains: genieBoy))
				(gCurRoom setScript: genieBailScr)
			)
		)
		(super doit: &rest)
	)

	(method (scriptCheck)
		(if (== (boatDoor script:) knockOnDoorScr)
			(gMessager say: 7 0 16 0 0 0) ; "Alexander is a little busy for that right now. Perhaps he should try it again later."
			(return 0)
		)
		(return 1)
	)

	(method (dispose)
		(gGlobalSound fade:)
		(if (not (gCast contains: genieBoy))
			(gGlobalSound2 fade:)
		)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
		(DisposeScript 964)
		(DisposeScript 231)
		(DisposeScript 960)
		(DisposeScript 942)
		(DisposeScript 951)
	)
)

(instance myMoveCycle of MCyc ; UNUSED
	(properties)

	(method (nextCel &tmp temp0)
		(cond
			((== (= temp0 (WordAt points value)) -4095)
				(client setPri: (WordAt points (+ value 1)))
				(+= value (* cycleDir 2))
				(= temp0 (WordAt points value))
			)
			((== temp0 -4094)
				(client setPri: -1)
				(+= value cycleDir)
				(= temp0 (WordAt points value))
			)
		)
		(client
			loop: (WordAt points value)
			cel: (WordAt points (+ value 1))
			x: (WordAt points (+ value 2))
			y: (WordAt points (+ value 3))
		)
		(+= value (* cycleDir 4))
		(if
			(or
				(and (== cycleDir 1) (>= value size))
				(and (== cycleDir -1) (< value 0))
			)
			(self cycleDone:)
		)
	)
)

(instance birdTimedCue of TimedCue
	(properties
		register 1
	)
)

(instance bailScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gCurRoom newRoom: 250)
			)
		)
	)
)

(instance sailScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cycleSpeed: (Random 10 19) setCycle: End self)
			)
			(1
				(= cycles 2)
			)
			(2
				(client cycleSpeed: (Random 10 19) setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance ferrymanScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client loop: 1 cel: 0 posn: 117 77 setCycle: End self)
			)
			(1
				(= ticks (Random 45 90))
			)
			(2
				(client setCycle: End self)
			)
			(3
				(= ticks 30)
			)
			(4
				(client loop: 2 cel: 0 posn: 104 77 setCycle: End self)
			)
			(5
				(= cycles 2)
			)
			(6
				(gGame handsOn:)
				(client dispose:)
			)
		)
	)
)

(instance snakeScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 5))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(= cycles 2)
			)
			(3
				(client dispose:)
			)
		)
	)
)

(instance snake of Prop ; UNUSED
	(properties
		x 313
		y 64
		view 264
		loop 2
		scaleSignal 1
		scaleX 64
		scaleY 64
	)
)

(instance smFerryman of Actor
	(properties
		x 117
		y 77
		view 263
		loop 1
		signal 16384
	)
)

(class BeachBird of Prop
	(properties
		view 267
		signal 16384
		previous 0
	)

	(method (init)
		(super init: &rest)
		(self fly:)
	)

	(method (fly &tmp temp0)
		(while (== previous (= temp0 (Random 0 3)))
		)
		(switch (= previous temp0)
			(0
				(self setPri: 2 cycleSpeed: 5 setCycle: MCyc @local3 self)
			)
			(1
				(self setPri: 1 cycleSpeed: 10 setCycle: MCyc @local125 self)
			)
			(2
				(self setPri: 1 cycleSpeed: 9 setCycle: MCyc @local219 self)
			)
			(3
				(self setPri: 1 cycleSpeed: 7 setCycle: MCyc @local325 self)
			)
			(4
				(self setPri: 2 cycleSpeed: 6 setCycle: MCyc @local467 self)
			)
		)
	)

	(method (cue param1)
		(cond
			((== param1 1)
				(BeachBird show:)
				(self fly:)
			)
			((== param1 4660)
				(self setScript: birdTimedCue (Random 4 12))
			)
			(else
				(BeachBird hide:)
				(if (not gSet)
					(= gSet (Set new:))
				)
				(gSet
					add:
						((Cue new:)
							cuee: self
							cuer: self
							register: 4660
							yourself:
						)
				)
			)
		)
	)
)

(instance toWaterNotFromPierScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (& (gEgo onControl: 1) $2000)
					(gEgo setMotion: PolyPath 196 73 self)
				else
					(gEgo setMotion: PolyPath 181 109 self)
				)
			)
			(1
				(gGame handsOn:)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance egoFallRightScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(LoadMany rsVIEW 296 269)
				(gEgo
					normal: 0
					setSpeed: 6
					view: 296
					loop: 2
					cel: 0
					setScale:
				)
				(= cycles 2)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(= ticks 45)
			)
			(3
				(gEgo loop: 3 cel: 0)
				(= ticks 15)
			)
			(4
				(gGlobalSound4 number: 923 loop: 1 play:)
				(gEgo setPri: 1 setCycle: End self)
			)
			(5
				(gGlobalSound stop:)
				(gGlobalSound3 number: 921 loop: 1 play:)
				(gEgo
					view: 269
					posn: (+ (gEgo x:) 21) (+ (gEgo y:) 48)
					setLoop: 0
					setSpeed: 5
					setStep: 5 5
					cel: 0
					setScale:
						Scaler
						100
						(/ (* (gEgo scaleX:) 100) 128)
						190
						(gEgo y:)
					setMotion: MoveTo 320 210 self
				)
				(self setScript: egoDrowningScr)
			)
			(6
				(gCurRoom newRoom: 135)
			)
		)
	)
)

(instance egoFallForwardScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(LoadMany rsVIEW 296 269)
				(gEgo
					setSpeed: 6
					normal: 0
					view: 296
					setPri: 15
					posn: (- (gEgo x:) 5) (+ (gEgo y:) 4)
					loop: 0
					cel: 0
					scaleX: 109
					scaleY: 109
					setScale:
				)
				(= cycles 2)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(= ticks 10)
			)
			(3
				(gEgo loop: 1 cel: 0)
				(= ticks 30)
			)
			(4
				(gGlobalSound4 number: 923 loop: 1 play:)
				(gEgo
					cel: 1
					posn: (+ (gEgo x:) 3) (+ (gEgo y:) 4)
					setCycle: End self
				)
			)
			(5
				(gGlobalSound stop:)
				(gGlobalSound3 number: 921 loop: 1 play:)
				(gEgo
					view: 269
					setLoop: 0
					cel: 3
					posn: (gEgo x:) 186
					setScale:
						Scaler
						100
						(/ (* (gEgo scaleX:) 100) 128)
						190
						(gEgo y:)
					setMotion: MoveTo (gEgo x:) 210 self
				)
				(self setScript: egoDrowningScr)
			)
			(6
				(gCurRoom newRoom: 135)
			)
		)
	)
)

(instance egoDrowningScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: CT 7 1 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo setCycle: CT 3 -1 self)
			)
			(3
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance enterVillage2Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 266 53 setMotion: MoveTo 226 61 self)
			)
			(1
				(gEgo setMotion: MoveTo 197 74 self)
			)
			(2
				(gEgo loop: 2)
				(if
					(and
						(not (gCast contains: genieBoy))
						(not (gCast contains: smFerryman))
					)
					(gGame handsOn:)
				)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance genieBailScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= cycles 2)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(if (< (genieScr state:) 25)
					(genieScr state: 26 seconds: 0 ticks: 0)
					(if (not (genieScr cycles:))
						(genieScr cycles: 1)
					)
				)
				((genieBoy script:) caller: self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance changeMusicScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound number: 915 loop: -1 play: 0 fade: 127 10 25 0)
				(gGlobalSound2 number: 916 loop: -1 play:)
				(= state -1)
				(= client 0)
			)
		)
	)
)

(instance eye of Prop
	(properties
		x 234
		y 90
		view 902
		priority 15
		signal 16
	)
)

(instance genieScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 12)
			)
			(1
				(eye init: setCycle: End self)
			)
			(2
				(= ticks 30)
			)
			(3
				(eye setCycle: Beg self)
			)
			(4
				(eye dispose:)
				(genieBoy setCycle: CT 7 1 self)
			)
			(5
				(= cycles 2)
			)
			(6
				(gGlobalSound4 number: 923 loop: 1 play:)
				(genieBoy cel: 8 posn: 233 118)
				(= cycles 2)
			)
			(7
				(genieBoy setCycle: End self)
			)
			(8
				(= ticks 48)
			)
			(9
				(genieBoy
					view: 262
					loop: 7
					cel: 0
					posn: 267 145
					setCycle: GenieCycler
				)
				(= ticks 12)
			)
			(10
				(genieBoy setMotion: MoveTo 267 131 self)
			)
			(11
				(genieBoy cycleSpeed: 9 loop: 9 cel: 0 setCycle: End self)
			)
			(12
				(genieBoy cel: 0 setCycle: End self)
			)
			(13
				(genieBoy cycleSpeed: 6 setCycle: GenieCycler loop: 7)
				(= cycles 2)
			)
			(14
				(gMessager say: 1 0 2 0 self) ; "(TO ALEXANDER) Hey! Stranger! Come join me! The water is wonderful, and I can show you the way to the next island!"
			)
			(15
				(= local2 1)
				(if (gCurRoom script:)
					((gCurRoom script:) caller: self)
				else
					(= cycles 2)
				)
			)
			(16
				(gEgo setMotion: MoveTo 221 97 self)
			)
			(17
				(gEgo setHeading: 90 self)
			)
			(18
				(gGame handsOn:)
				(= seconds 6)
			)
			(19
				(= local2 0)
				(genieBoy
					setLoop: (if (== (genieBoy loop:) 1) 10 else 9)
					cel: 0
				)
				(= ticks 72)
			)
			(20
				(= local2 1)
				(= ticks 12)
			)
			(21
				(gMessager say: 1 0 3 0 self) ; "Come on! Jump in! A little water won't hurt you."
			)
			(22
				(= seconds 6)
			)
			(23
				(= local2 0)
				(genieBoy
					setLoop: (if (== (genieBoy loop:) 1) 10 else 9)
					cel: 0
				)
				(= ticks 72)
			)
			(24
				(= local2 1)
				(= cycles 2)
			)
			(25
				(gMessager say: 1 0 4 0 self) ; "What are you waiting for? I said I'd show how to get to the next island, didn't I?"
			)
			(26
				(= seconds 7)
			)
			(27
				(gMessager say: 1 0 5 1 self) ; "All right, be that way! Don't come in the water! You'll be sorry!"
			)
			(28
				(= local2 0)
				(genieBoy view: 262 loop: 11 cel: 0 noun: 7 setCycle: End self)
				(gGlobalSound4 number: 943 loop: 1 play:)
			)
			(29
				(= cycles 2)
			)
			(30
				(changeMusicScr client: self)
				(gGlobalSound client: changeMusicScr fade:)
				(gMessager say: 1 0 5 2 self) ; "That's strange. The young boy in the water just disappeared. Oh, well. Perhaps he just dove under the water."
			)
			(31
				(= local2 0)
				(client dispose:)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((not local2) 0)
			((and (< (gEgo y:) 87) (!= (genieBoy loop:) 7))
				(genieBoy loop: 7)
			)
			(
				(and
					(>= (gEgo y:) 87)
					(<= (gEgo y:) 111)
					(!= (genieBoy loop:) 1)
				)
				(genieBoy loop: 1)
			)
			((and (>= (gEgo y:) 111) (!= (genieBoy loop:) 5))
				(genieBoy loop: 5)
			)
		)
	)
)

(instance genieBoy of Actor
	(properties
		x 229
		y 110
		noun 6
		approachX 221
		approachY 97
		view 266
		loop 1
	)

	(method (doVerb theVerb)
		(if (== noun 7)
			(super doVerb: theVerb &rest)
		else
			(switch theVerb
				(2 ; Talk
					(if (not (gCast contains: self))
						(return)
					)
					(if local0
						(= local0 0)
						(gMessager say: noun theVerb 11) ; "Good day. I'm Alexander. What are you doing in the sea?"
					else
						(gMessager say: noun theVerb 12) ; "Come join me, if you're brave enough!"
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2) ; Talk
	)
)

(instance eyeGlint1 of Prop ; UNUSED
	(properties
		x 275
		y 142
		view 262
		loop 3
		priority 15
		signal 16
	)

	(method (init)
		(super init: &rest)
		(self setCycle: End genieScr)
	)
)

(instance diveIntoWaterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (gCast contains: genieBoy))
				(if register
					(SetFlag 79)
					(genieBoy setScript: 0)
				)
				(= cycles 1)
			)
			(1
				(gMessager say: 7 3 13 1 self) ; "Considering the poor condition of the shore, it looks like the easiest way to get into the water is to just jump off the pier."
			)
			(2
				(gEgo setMotion: PolyPath 232 114 self)
			)
			(3
				(gEgo
					normal: 0
					setPri: 8
					setSpeed: 6
					view: 265
					loop: 0
					cel: 0
					posn: 227 115
					setScale: 0
					scaleX: 98
					scaleY: 98
					scaleSignal: 1
					setCycle: CT 7 1 self
				)
				(if register
					(genieBoy loop: 5)
				)
			)
			(4
				(gGlobalSound4 number: 923 loop: 1 play:)
				(gEgo posn: 229 124 setCycle: End self)
				(if register
					(genieBoy loop: 2)
				)
			)
			(5
				(if register
					(gMessager say: 7 3 13 2 self) ; "Glad you could join me! Ha, ha, ha!"
				else
					(self cue:)
				)
			)
			(6
				(gMessager say: 7 3 13 3 self) ; "The powerful currents grab Alexander. Struggle as he might, he feels himself being pulled out to sea."
			)
			(7
				(gGlobalSound stop:)
				(gGlobalSound3 number: 921 loop: 1 play:)
				(if register
					(genieBoy setHeading: 180 setMotion: MoveFwd 100)
				)
				(gEgo
					view: 269
					moveSpeed: 3
					setLoop: 0
					cel: 3
					posn: 282 168
					setScale:
						Scaler
						100
						(/ (* (gEgo scaleX:) 100) 128)
						190
						(gEgo y:)
					setMotion: MoveTo 305 210 self
				)
				(self setScript: egoDrowningScr)
			)
			(8
				(gCurRoom newRoom: 135)
			)
		)
	)
)

(instance ocean of Feature
	(properties
		noun 7
		sightAngle 40
		onMeCheck 4
		approachX 228
		approachY 110
	)

	(method (onMe param1 &tmp temp0)
		(ocean x: (param1 x:) y: (param1 y:))
		(if (= temp0 (super onMe: param1 &rest))
			(if (> (param1 y:) 56)
				(= x 320)
				(= y 91)
				(= noun 7)
			else
				(= x 61)
				(= y 54)
				(= noun 29)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 5 1) ; Do, Look
			(super doVerb: theVerb &rest)
		else
			(= noun 7)
			(super doVerb: theVerb &rest)
		)
	)
)

(instance knockOnDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 908)
				(Load rsVIEW 261)
				(gEgo setHeading: 45 self)
			)
			(1
				(if (gCast contains: genieBoy)
					(if (< (genieScr state:) 25)
						(genieScr state: 26 seconds: 0 ticks: 0 cycles: 0)
						(if (not (genieScr cycles:))
							(genieScr cycles: 1)
						)
					)
					((genieBoy script:) caller: self)
				else
					(= ticks 20)
				)
			)
			(2
				(gEgo
					normal: 0
					view: 261
					posn: 20 108
					loop: 2
					cel: 0
					scaleX: 128
					scaleY: 128
					setScale:
					setMotion: 0
					setSpeed: 6
				)
				(= cycles 2)
			)
			(3
				(gEgo setCycle: End self)
				(= register 5)
			)
			(4
				(-- register)
				(gEgo cel: 0 loop: 3 setCycle: End self)
			)
			(5
				(gGlobalSound4 number: 908 loop: 1 play:)
				(if register
					(-= state 2)
					(= ticks 25)
				else
					(self cue:)
				)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(= cycles 2)
			)
			(8
				(gEgo
					posn: (boatDoor approachX:) (boatDoor approachY:)
					reset: 6
					setScale: Scaler 97 20 150 30
				)
				(= cycles 2)
			)
			(9
				(UnLoad 128 261)
				(= ticks 60)
			)
			(10
				(ferryMan view: 263 loop: 2 cel: 8 posn: 23 96 init:)
				(gGlobalSound4 number: 901 loop: 1 play:)
				(boatDoor setCycle: End self)
			)
			(11
				(= ticks 60)
			)
			(12
				(if (IsFlag 17)
					(+= state 4)
					(gMessager say: 2 5 8 0 self) ; "Oh, it's you! Come on in."
				else
					(gMessager say: 2 5 (if (SetFlag 106) 18 else 7) 0 self)
				)
			)
			(13
				(gGame handsOn:)
				(= seconds 10)
			)
			(14
				(gGame handsOff:)
				(gMessager say: 1 0 6 1 self) ; "Go away! The ferry's out of business!"
			)
			(15
				(boatDoor setCycle: Beg self)
			)
			(16
				(ferryMan dispose:)
				(gGlobalSound4 number: 902 loop: 1 play:)
				(boatDoor stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
			(17
				(gCurRoom newRoom: 290)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and seconds (not (gEgo inRect: 5 94 33 109)))
			(= seconds 0)
			(self cue:)
		)
	)

	(method (dispose &tmp temp0)
		(= seconds 0)
		(if
			(and
				(= temp0 (gCurRoom script:))
				(not (OneOf temp0 talkReferenceScr talkOrItemScr))
			)
			(temp0 dispose:)
		)
		(super dispose:)
	)
)

(instance boatDoor of Prop
	(properties
		x 22
		y 80
		noun 2
		approachX 12
		approachY 107
		view 260
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(self setScript: knockOnDoorScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self sightAngle: 26505 approachVerbs: 5 stopUpd:) ; Do
	)
)

(instance talkReferenceScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(boatDoor setScript: 0)
				(gMessager say: 5 2 10 0 self) ; "Excuse me. My name is Alexander. The owner of the book shop in the village told me you might be able to help me. I hear you used to run this ferry for the islands. I'd like to talk to you, if you have a moment."
			)
			(1
				(gCurRoom newRoom: 290)
			)
		)
	)
)

(instance talkOrItemScr of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(boatDoor setScript: 0)
				(if (== register 2)
					(if (SetFlag 105)
						(= temp0 17)
					else
						(= temp0 9)
					)
				else
					(= temp0 0)
				)
				(gMessager say: 5 register temp0 0 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(boatDoor setCycle: Beg self)
			)
			(3
				(ferryMan dispose:)
				(gGlobalSound4 number: 902 loop: 1 play:)
				(boatDoor stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(= register 0)
		(super dispose:)
	)
)

(instance ferryMan of View
	(properties
		x 23
		y 96
		noun 5
		view 263
		loop 2
		cel 8
		priority 3
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (IsFlag 16)
					(gCurRoom setScript: talkReferenceScr)
				else
					(gCurRoom setScript: talkOrItemScr 0 theVerb)
				)
			)
			(70 ; royalRing
				(if (SetFlag 104)
					(gMessager say: noun theVerb 16) ; "Are you sure I can't interest you in this ring?"
				else
					(gMessager say: noun theVerb 15) ; "I have this ring. You see, my name is Alexander and I'm from Daventry."
				)
			)
			(40 ; coin
				(gCurRoom setScript: talkOrItemScr 0 theVerb)
			)
			(else
				(if (== (gKq6ApproachCode doit: theVerb) -32768)
					(gCurRoom setScript: talkOrItemScr 0 0)
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance hatch of Feature
	(properties
		x 100
		y 78
		noun 24
		nsTop 74
		nsLeft 91
		nsBottom 81
		nsRight 109
		sightAngle 45
	)
)

(instance genericFeatures of Feature
	(properties
		sightAngle 45
	)

	(method (onMe param1 &tmp temp0)
		(= temp0 (OnControl CONTROL (param1 x:) (param1 y:)))
		(genericFeatures x: (param1 x:) y: (param1 y:))
		(return
			(= noun
				(switch temp0
					(1024 10)
					(2048 15)
					(8 14)
					(16
						(if (< (param1 x:) 170) 17 else 0)
					)
					(512 23)
					(256 19)
					(2 8)
					(4096 13)
					(64
						(if (> (param1 y:) 74) 16 else 22)
					)
					(else
						(if (OneOf temp0 16384 8192) 18 else 0)
					)
				)
			)
		)
	)
)

(instance sail1 of Prop
	(properties
		x 80
		y 83
		z 83
		noun 14
		view 260
		loop 2
		priority 15
		signal 20496
	)

	(method (cue)
		(self
			cycleSpeed: (- (sailScr register:) 1)
			setCycle: (ScriptID 231) (- (self lastCel:) 1) ; ForwardFrom
		)
	)
)

(instance sail2 of Prop
	(properties
		x 54
		y 83
		z 75
		noun 14
		view 260
		loop 3
		priority 15
		signal 20496
	)
)

(instance sail3 of Prop
	(properties
		x 21
		y 83
		z 57
		noun 14
		view 260
		loop 4
		cel 3
		priority 15
		signal 4112
	)
)

(instance sail4 of View
	(properties
		x 9
		y 83
		z 52
		noun 14
		view 260
		loop 5
		priority 15
		signal 4112
	)
)

(instance egoDoVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; map
				(gCurRoom setScript: 130) ; pullOutMapScr
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance reflect1 of Prop
	(properties
		x 65
		y 176
		noun 7
		view 268
		cel 2
		signal 16384
		cycleSpeed 10
		detailLevel 3
	)
)

(instance reflect2 of Prop
	(properties
		x 146
		y 178
		noun 7
		view 268
		loop 1
		cel 1
		priority 15
		signal 16400
		cycleSpeed 10
		detailLevel 3
	)
)

(instance reflect3 of Prop
	(properties
		x 210
		y 186
		noun 7
		view 268
		loop 2
		cel 2
		priority 15
		signal 16400
		cycleSpeed 10
		detailLevel 3
	)
)

(instance reflect4 of Prop
	(properties
		x 178
		y 136
		noun 7
		view 268
		loop 3
		signal 16384
		cycleSpeed 10
		detailLevel 3
	)
)

(instance reflect5 of Prop
	(properties
		x 277
		y 113
		noun 7
		view 268
		loop 4
		cel 1
		priority 1
		signal 16400
		cycleSpeed 20
		detailLevel 3
	)
)

(instance holeInBoat of Feature
	(properties
		x 91
		y 100
		noun 11
		nsTop 112
		nsLeft 83
		nsBottom 123
		nsRight 100
		sightAngle 45
	)
)

