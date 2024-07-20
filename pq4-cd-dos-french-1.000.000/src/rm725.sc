;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 725)
(include sci.sh)
(use Main)
(use Print)
(use Inset)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm725 0
)

(instance rm725 of Room
	(properties
		noun 3
		picture 725
	)

	(method (doRemap)
		(gGame doRemap: 2 253 85)
		(gGame doRemap: 2 254 75)
	)

	(method (init)
		(if (== gPrevRoomNum 715)
			(gGlobalSound0 fade:)
			(gGame intensity: 0)
			(self setScript: enterRoom)
		)
		(super init: &rest)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 72 105 72 118 140 118 161 126 157 138 134 162 267 162 258 138 192 138 178 128 179 122 180 115 260 114 260 112 178 113 167 113 167 105 151 105
					yourself:
				)
		)
		(gEgo
			view: 9120
			origStep: 2052
			stopView: 9125
			setHeading: 180
			normalize: 9120
			x:
				(cond
					((== gPrevRoomNum 745) 88)
					((gPqFlags test: 110) 158)
					(else 138)
				)
			y: 111
			setScaler: Scaler 119 79 162 106
			init:
		)
		(fridge init: approachVerbs: 4) ; Do
		(door init: approachVerbs: 4) ; Do
		(table init:)
		(chair init:)
		(bigCabinet init:)
		(topLeftShelf init:)
		(topRightShelf init:)
		(bottomRightShelf init:)
		(bottomLeftShelf init:)
		(bowls init:)
		(stove init:)
		(rightCounter init:)
		(twoHotMitts init:)
		(hotMitt init:)
		(light init:)
		(floorMat init:)
		(farRightCabinet init:)
		(stoveCabinet init:)
		(if (== gPrevRoomNum 745)
			(self setScript: walkIn)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script 0)
			((< (gEgo x:) 87)
				(self newRoom: 745)
			)
		)
	)

	(method (dispose)
		(gGlobalSound0 client: 0)
		(gGlobalSound1 client: 0)
		(super dispose:)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 138 111 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				(gGlobalSound1 number: 979 loop: 1 play:)
				(= seconds 2)
			)
			(2
				(gGame intensity: 100 fade: 0 100 (gGame fadeSpeed:))
				(= ticks 60)
			)
			(3
				(if (or (gPqFlags test: 110) (== gPrevRoomNum 745))
					(gGlobalSound0 number: 725 setLoop: -1 play:)
					(gGame handsOn:)
					(self dispose:)
				else
					(gGlobalSound0
						number: 991
						loop: 1
						setVol: 0
						play:
						fade: 127 10 10 0
					)
					(polly init:)
					(gCurRoom setScript: dogGetsYou)
				)
			)
		)
	)
)

(instance dogGetsYou of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 747)
				(gEgo setHeading: 135 self)
			)
			(1
				(= ticks 180)
			)
			(2
				(gEgo
					view: 747
					loop: 1
					cel: 0
					x: 160
					y: 118
					scaleSignal: 1
					scaleX: 110
					scaleY: 110
					setCycle: End
				)
				(polly
					setSpeed: 0
					fixPriority: 1
					priority: 150
					setCycle: End self
				)
				(gGlobalSound0 number: 1011 setLoop: 1 play:)
				(gGlobalSound1 number: 1001 setLoop: 1 play:)
				(= ticks 30)
			)
			(3
				(PalVary 0 726 2 100 2) ; PalVaryStart
			)
			(4
				(sFx number: 1000 setLoop: 1 play:)
				(gGlobalSound1 number: 972 setLoop: 1 play:)
				(gTheCursor view: 999)
				(gGame setCursor: gTheCursor 1)
				(while 1
					(switch
						(Print
							font: (if (IsHiRes) 999 else 1999)
							y: 20
							addBitmap: 64994 3 0
							width: 180
							mode: 1
							addText: 14 0 1 1 15 10 725 ; "Think tactics, Detective! Think survival!"
							addButtonBM: 64994 2 0 1 1 0 2 1 6 59 30 ; "Restore"
							addButtonBM: 64994 2 0 2 1 0 3 1 69 59 30 ; "Restart"
							addButtonBM: 64994 2 0 3 1 0 4 1 129 59 30 ; "Quit"
							init:
						)
						(1
							(gGame restore:)
							(break)
						)
						(2
							(= register 1)
							(break)
						)
						(3
							(= gQuit 1)
							(break)
						)
					)
				)
				(if register
					(gGame restart:)
				)
			)
		)
	)
)

(instance sFx of Sound
	(properties)
)

(instance polly of Actor
	(properties
		x 215
		y 149
		fixPriority 1
		view 747
		signal 16385
		cycleSpeed 2
		moveSpeed 2
	)
)

(instance door of Feature
	(properties
		noun 2
		approachX 138
		approachY 111
		x 138
		y 111
		z 32
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 116 5 160 5 160 100 126 100 126 13 120 7 116 7
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 4) (not (gPqFlags test: 125))) ; Do
				(gCurRoom newRoom: 715)
			)
			((and (== theVerb 42) (not (gPqFlags test: 125))) ; hairspray
				(gMessager say: noun theVerb 2 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance table of Feature
	(properties
		noun 4
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 201 77 214 76 256 76 267 77 270 78 270 87 243 88 240 119 266 129 265 132 254 129 244 125 239 124 216 130 212 128 237 119 237 89 210 86 199 83 199 79
				yourself:
			)
		)
	)
)

(instance chair of Feature
	(properties
		noun 5
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 191 75 195 75 197 93 198 100 201 97 209 96 225 96 232 101 230 106 217 106 216 119 230 120 225 122 216 121 218 125 211 122 195 125 192 122 210 119 212 107 197 107 191 81
				yourself:
			)
		)
	)
)

(instance bigCabinet of Feature
	(properties
		noun 6
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 175 2 287 2 286 108 176 107 yourself:)
		)
	)
)

(instance topLeftShelf of Feature
	(properties
		noun 7
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 179 33 228 33 228 44 179 44 yourself:)
		)
	)
)

(instance topRightShelf of Feature
	(properties
		noun 7
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 233 33 283 34 283 44 233 44 yourself:)
		)
	)
)

(instance bottomRightShelf of Feature
	(properties
		noun 7
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 233 47 283 48 284 66 233 65 yourself:)
		)
	)
)

(instance bottomLeftShelf of Feature
	(properties
		noun 7
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 179 48 227 48 227 65 179 65 yourself:)
		)
	)
)

(instance bowls of Feature
	(properties
		noun 8
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 0 125 15 125 20 118 45 125 47 128 52 129 56 134 57 138 67 134 79 132 91 131 111 131 125 133 136 137 141 142 134 149 119 153 0 154
				yourself:
			)
		)
	)
)

(instance stove of Feature
	(properties
		noun 9
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 33 80 86 80 85 131 66 133 59 135 56 130 49 127 33 118
				yourself:
			)
		)
	)
)

(instance rightCounter of Feature
	(properties
		noun 10
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 277 77 319 77 319 152 280 152 275 145
				yourself:
			)
		)
	)
)

(instance twoHotMitts of Feature
	(properties
		noun 11
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 43 17 51 24 58 16 61 16 69 25 70 28 62 34 58 35 51 29 45 35 41 35 33 27
				yourself:
			)
		)
	)
)

(instance hotMitt of Feature
	(properties
		noun 11
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 82 42 91 50 91 53 84 60 79 60 71 54 73 49 79 42
				yourself:
			)
		)
	)
)

(instance light of Feature
	(properties
		noun 12
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 228 1 228 5 243 8 243 10 230 10 230 12 231 18 224 22 218 19 219 10 206 10 206 7 209 7 223 5 223 1
				yourself:
			)
		)
	)
)

(instance floorMat of Feature
	(properties
		noun 13
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 126 101 158 101 154 107 125 107
				yourself:
			)
		)
	)
)

(instance farRightCabinet of Feature
	(properties
		noun 6
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 319 0 319 46 314 44 316 0 yourself:)
		)
	)
)

(instance stoveCabinet of Feature
	(properties
		noun 6
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 0 0 30 0 29 28 0 27 yourself:)
		)
	)
)

(instance fridge of Feature
	(properties
		noun 1
		approachX 153
		approachY 143
		x 116
		y 143
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 102 8 115 8 125 12 125 132 108 130 102 130
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame points: 2 84)
				(gCurRoom setScript: openFridge)
			)
			(52 ; notebook
				(cond
					((gPqPointFlags test: 35)
						(gMessager say: noun theVerb 5 0) ; "The gruesome details have already been recorded, Detective."
					)
					((gPqFlags test: 153)
						(gGame points: 2 35)
						(gMessager say: noun theVerb 3 0) ; MISSING MESSAGE
					)
					(else
						(gMessager say: noun theVerb 4 0) ; "There's nothing noteworthy to record, Carey. Wait on the paperwork."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance openFridge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScaler: 0
					view: 9130
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(1
				(gCurRoom setInset: fridgeInset self)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo
					view: 9120
					setScaler: Scaler 119 79 162 106
					heading: 270
					normalize: 9120
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fridgeInset of Inset
	(properties
		picture 730
		style 9
		disposeNotOnMe 1
		noun 18
	)

	(method (init)
		(gGame fade: 100 0 10)
		(gTheIconBar disable: 3 7 show: 0)
		(super init: &rest)
		(if
			(and
				(not (gEgo has: 28)) ; lighter
				(not (gEgo has: 34)) ; torch
				(gPqFlags test: 123)
			)
			(lighter init:)
		)
		(daveHead init:)
		(FrameOut (gCast elements:) 0)
		(gGame fade: 0 100 10)
		(if (== (gGlobalSound0 number:) 725)
			(gGlobalSound0 number: 730 setLoop: 1 play:)
		else
			(gGlobalSound0 number: 104 setLoop: 1 play:)
		)
		(gPqFlags set: 153)
		(gGame handsOn:)
	)

	(method (onMe param1)
		(return (and (<= 49 (param1 x:) 272) (<= 0 (param1 y:) 148)))
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(= temp0 (if gDoVerbCode gDoVerbCode else dftDoVerb))
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun theVerb 0 1))
			(gMessager say: noun theVerb 0 0 0 modNum)
		else
			(temp0 doit: theVerb self)
		)
	)

	(method (dispose)
		(gGame fade: 100 0 10)
		(daveHead dispose:)
		(gTheIconBar enable: 3 7)
		(gGame handsOff:)
		(super dispose:)
		(FrameOut (gCast elements:) 0)
		(gGame fade: 0 100 10)
		(gGlobalSound0 number: 731 setLoop: -1 play:)
	)
)

(instance daveHead of Feature
	(properties
		noun 15
		x 111
		y 25
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 107 17 119 18 128 28 130 28 132 35 135 42 144 49 143 53 140 53 138 51 135 50 132 53 129 51 126 52 123 54 120 58 120 60 111 57 105 53 103 50 90 50 88 48 85 47 85 44 90 44 90 36 90 29 96 24 97 19
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; notebook
				(if (gPqPointFlags test: 35)
					(gMessager say: 1 theVerb 5 0) ; "The gruesome details have already been recorded, Detective."
				else
					(gPqFlags set: 153)
					(gGame points: 2 35)
					(gMessager say: noun theVerb 0 0) ; "The gruesome details of this job is sometimes overwhelming. Eh, Detective?"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lighter of View
	(properties
		noun 16
		x 110
		y 28
		view 730
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame points: 4)
			(gEgo get: 28) ; lighter
			(super doVerb: theVerb)
			(self dispose:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance dftDoVerb of Code
	(properties)

	(method (doit)
		(return 1)
	)
)

