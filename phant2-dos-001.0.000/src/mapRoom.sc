;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 900)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use DItem)
(use PolyEdit)
(use Polygon)
(use Feature)
(use System)

(public
	mapRoom 0
)

(local
	local0
)

(instance mapRoom of P2Room
	(properties
		picture 4000
	)

	(method (init)
		(= local0 0)
		(if (IsFlag 1002)
			(= picture global237)
			(abortBtn init:)
		else
			(= picture -2)
			(easterEgg init:)
		)
		(super init: &rest)
		(if (not (IsFlag 1002))
			(if (OneOf (/ gPrevRoomNum 1000) 3 4)
				(if (gRoboGary isPlaying:)
					(gRoboGary stop: 1)
				else
					(gP2SongPlyr fadeOut: 0)
				)
			else
				(gP2SongPlyr fadeOut: 0)
			)
			(gP2SongPlyr start: 910)
		)
		(theMap init: setPri: 5)
		(aptBtn init:)
		(wtBtn init:)
		(dtBtn init:)
		(if (or (IsFlag 209) (> gChapter 2))
			(drBtn init:)
		)
		(if (or (IsFlag 221) (> gChapter 2))
			(blBtn init:)
		)
		(if (IsFlag 1002)
			(Palette 2 3 31 99) ; PalIntensity
		)
		(gPlanes plane: gThePlane)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(gPlanes plane: 0)
		(= global243 0)
		(ClearFlag 1002)
		(SetFlag 1001)
		((ScriptID 0 2) scratch: 0) ; topInterfacePlane
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (and (IsFlag 1002) (!= gNewRoomNum gPrevRoomNum))
			(= global241 100)
			(if (OneOf (/ gPrevRoomNum 1000) 3 4)
				(if (gRoboGary isPlaying:)
					(gRoboGary stop: 1)
				else
					(gP2SongPlyr fadeOut: 0)
				)
			else
				(gP2SongPlyr fadeOut: 0)
			)
		)
		(if
			(and
				(== gChapter 4)
				(IsFlag 508)
				(not (IsFlag 509))
				(!= (/ gNewRoomNum 1000) 2)
			)
			(SetFlag 579)
		)
		(if (not (IsFlag 1002))
			(= global241 100)
			(gP2SongPlyr fadeOut: 0)
		)
		(if (and local0 (ResCheck 140 local0)) ; WAVE
			(if (== (/ newRoomNumber 1000) 2)
				(gP2SongPlyr start: local0 70)
			else
				(gP2SongPlyr fadeIn: local0)
			)
		)
	)
)

(instance theMap of View
	(properties
		view 4000
		loop 4
	)

	(method (init)
		(if (IsFlag 1002)
			(= view 4000)
		else
			(= view 4001)
			(= priority 20000)
		)
		(super init: &rest)
	)
)

(class MapButton of DItem
	(properties
		exitDir -1
	)

	(method (seesVerb param1)
		(if (== param1 4)
			(return 1)
		else
			(return 0)
		)
	)

	(method (update)
		(if (not (not (& state $0001)))
			(= cel 0)
			(if (not (not (& state $0002)))
				(= cel 0)
			)
			(if (not (not (& state $0020)))
				(= cel 1)
			)
		else
			(= cel 0)
		)
		(super update: &rest)
	)

	(method (isOn)
		(self isHot: 1)
		(|= state $0200)
	)

	(method (isOff)
		(self isHot: 0)
		(&= state $fdff)
	)

	(method (init)
		(if (IsFlag 1002)
			(= view 4000)
		else
			(= view 4001)
		)
		(super init: &rest)
		(self setPri: 600)
	)

	(method (handleEvent event)
		(if responder
			(responder handleEvent: event)
		else
			(cond
				((not (not (& state $0020)))
					(event localize: plane)
					(self track: event)
					(if (& evMOUSERELEASE (event type:))
						(self press: 0)
						((gUser hogs:) pop:)
						(FrameOut)
						(if (not (not (& state $0002)))
							(self action:)
						)
					)
					(FrameOut)
				)
				((& evMOUSEBUTTON (event type:))
					(self press: 1)
					((gUser hogs:) push: self 1)
				)
			)
			(event claimed: self)
		)
		(event claimed:)
	)
)

(instance abortBtn of MapButton
	(properties
		x 515
		y 14
		view 4000
		loop 5
	)

	(method (init)
		(self isHot: 1)
		(super init: &rest)
	)

	(method (action)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

(instance aptBtn of MapButton
	(properties
		x 117
		y 124
		view 4000
	)

	(method (init)
		(self isOn:)
		(super init:)
		(self addTarget: (aptPoly init:))
	)

	(method (action)
		(gGame handsOff:)
		(aptCode doit:)
	)
)

(instance aptCode of Code
	(properties)

	(method (doit &tmp temp0)
		(if (and (IsFlag 1002) (== (/ gPrevRoomNum 1000) 2))
			(gCurRoom newRoom: gPrevRoomNum)
			(return 0)
		else
			(= global209 1561)
			(= temp0 (- (+ 2221 gChapter) 1))
		)
		(switch gChapter
			(1
				(= local0 2910)
			)
			(2
				(= local0 2920)
			)
			(3
				(if (not (IsFlag 339))
					(if (and (gEgo has: 14) (not (gEgo has: 11))) ; hammerI, dadLetterI
						(= local0 2931)
					else
						(= local0 2930)
					)
				else
					(= local0 0)
					(= temp0 2123)
					(SetFlag 385)
					(= global209 2110)
				)
			)
			(4
				(= local0 2940)
			)
			(5
				(= local0 2950)
			)
		)
		(return (gCurRoom newRoom: temp0))
	)
)

(instance wtBtn of MapButton
	(properties
		x 266
		y 162
		view 4000
		loop 6
	)

	(method (init)
		(if (IsFlag 319)
			(self isOff:)
			(super init:)
		else
			(self isOn:)
			(super init:)
			(self addTarget: (wyntechPoly init:))
		)
	)

	(method (action)
		(gGame handsOff:)
		(wtCode doit:)
	)
)

(instance wtCode of Code
	(properties)

	(method (doit &tmp temp0)
		(if (and (IsFlag 1002) (OneOf (/ gPrevRoomNum 1000) 3 4))
			(= temp0 gPrevRoomNum)
		else
			(= temp0 (- (+ 3011 gChapter) 1))
		)
		(gCurRoom newRoom: temp0)
	)
)

(instance dtBtn of MapButton
	(properties
		x 379
		y 88
		view 4000
		loop 3
	)

	(method (init)
		(self isOn:)
		(super init:)
		(self addTarget: (dreamTreePoly init:))
	)

	(method (action)
		(gGame handsOff:)
		(dtCode doit:)
	)
)

(instance dtCode of Code
	(properties)

	(method (doit &tmp temp0)
		(if (and (IsFlag 1002) (== (/ gPrevRoomNum 1000) 7))
			(= temp0 gPrevRoomNum)
		else
			(= temp0 (- (+ 7001 gChapter) 1))
		)
		(gCurRoom newRoom: temp0)
	)
)

(instance drBtn of MapButton
	(properties
		x 206
		y 66
		view 4000
		loop 2
	)

	(method (init)
		(switch gChapter
			(1
				(return 0)
			)
			(2
				(if (IsFlag 222)
					(self isOff:)
					(super init: &rest)
					(return 0)
				)
				(if (IsFlag 209)
					(self isOn:)
					(super init: &rest)
					(self addTarget: (harburgPoly init:))
				else
					(return 0)
				)
			)
			(3
				(if (IsFlag 339)
					(self isOff:)
					(super init: &rest)
					(return 0)
				else
					(self isOn:)
					(super init: &rest)
					(self addTarget: (harburgPoly init:))
				)
			)
			(4
				(if (IsFlag 535)
					(self isOff:)
					(super init: &rest)
					(return 0)
				)
				(if (IsFlag 556)
					(self isOn:)
					(super init: &rest)
					(self addTarget: (harburgPoly init:))
				else
					(self isOff:)
					(super init: &rest)
					(return 0)
				)
			)
			(5
				(self isOff:)
				(super init: &rest)
				(return 0)
			)
		)
	)

	(method (action)
		(gGame handsOff:)
		(drCode doit:)
	)
)

(instance drCode of Code
	(properties)

	(method (doit)
		(switch gChapter
			(2
				(if
					(and
						(gEgo has: 4) ; parentPhotoI
						(gEgo has: 5) ; xmasPhotoI
						(gEgo has: 7) ; bondageCardI
						(gEgo has: 23) ; anagramI
						(IsFlag 221)
						(gEgo has: 13) ; paulKeyI
						(IsFlag 95)
						(gEgo has: 0) ; buttonI
						(gEgo has: 22) ; laceI
						(gEgo has: 15) ; folderI
					)
					(= global209 6980)
					(SetFlag 266)
					(gCurRoom newRoom: 5012) ; harburgCH2SR1
				else
					(proc63002_11 900 1 0 3 1)
				)
			)
			(3
				(if (and (gEgo has: 11) (IsFlag 382) (IsFlag 371)) ; dadLetterI
					(= global209 7260)
					(SetFlag 340)
					(gCurRoom newRoom: 5013) ; harburgCH3SR1
				else
					(proc63002_11 900 1 0 3 1)
				)
			)
			(4
				(if (and (gEgo has: 24) (IsFlag 573) (IsFlag 570)) ; thereseNoteI
					(= global209 7520)
					(SetFlag 565)
					(gCurRoom newRoom: 5014) ; harburgCH4SR1
				else
					(proc63002_11 900 1 0 3 1)
				)
			)
		)
	)
)

(instance blBtn of MapButton
	(properties
		x 239
		y 233
		view 4000
		loop 1
	)

	(method (init)
		(if
			(or
				(== gChapter 3)
				(== gChapter 4)
				(== gChapter 5)
				(IsFlag 221)
			)
			(if (== gChapter 5)
				(self isOff:)
				(super init: &rest)
			else
				(self isOn:)
				(super init: &rest)
				(self addTarget: (borderlinePoly init:))
			)
		else
			(return 0)
		)
	)

	(method (action)
		(gGame handsOff:)
		(blCode doit:)
	)
)

(instance blCode of Code
	(properties)

	(method (doit)
		(if (and (IsFlag 1002) (== (/ gPrevRoomNum 1000) 6))
			(gCurRoom newRoom: gPrevRoomNum)
			(return 0)
		)
		(return
			(switch gChapter
				(2
					(if (IsFlag 209)
						(if (not (IsFlag 222))
							(proc63002_11 900 1 0 1 1)
						else
							(gCurRoom newRoom: 6012) ; blEntranceCH2SR1
						)
					else
						(proc63002_11 900 1 0 2 1)
					)
				)
				(3
					(if (IsFlag 339)
						(if (IsFlag 341)
							(gCurRoom newRoom: 6013) ; blEntranceCH3SR1
						else
							(= global209 7961)
							(SetFlag 341)
							(gCurRoom newRoom: 6213) ; blDanceCH3SR1
						)
					else
						(proc63002_11 900 1 0 2 1)
					)
				)
				(4
					(if (IsFlag 512)
						(if (and (IsFlag 574) (not (IsFlag 540)))
							(= global209 8020)
							(SetFlag 540)
							(gCurRoom newRoom: 6214) ; blDanceCH4SR1
						else
							(gCurRoom newRoom: 6014) ; blEntranceCH4SR1
						)
					else
						(proc63002_11 900 1 0 2 1)
					)
				)
			)
		)
	)
)

(instance easterEgg of Feature
	(properties)

	(method (init)
		(= scratch 0)
		(super init: gThePlane 200 268 313 280 327)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOUSEBUTTON)
			(self scratch: (+ (self scratch:) 1))
			(if (== (self scratch:) 10)
				(gCurRoom newRoom: 909) ; easterEgg
			)
			(event claimed: 1)
		)
		(event claimed:)
	)
)

(instance aptPoly of Polygon
	(properties)

	(method (init)
		(super
			init:
				118
				136
				134
				124
				139
				147
				184
				139
				190
				156
				169
				163
				177
				196
				144
				203
				139
				175
				122
				176
		)
		(return self)
	)
)

(instance harburgPoly of Polygon
	(properties)

	(method (init)
		(super
			init:
				225
				99
				225
				77
				279
				66
				286
				85
				342
				66
				348
				82
				241
				126
				213
				149
				203
				106
		)
		(return self)
	)
)

(instance dreamTreePoly of Polygon
	(properties)

	(method (init)
		(super
			init:
				383
				85
				490
				90
				490
				106
				467
				109
				469
				129
				411
				134
				424
				151
				391
				165
				380
				131
		)
		(return self)
	)
)

(instance wyntechPoly of Polygon
	(properties)

	(method (init)
		(super init: 382 176 379 207 282 201 255 209 255 179 281 183 276 165)
		(return self)
	)
)

(instance borderlinePoly of Polygon
	(properties)

	(method (init)
		(super init: 241 239 394 236 392 262 268 263 273 290 244 292 244 266)
		(return self)
	)
)

