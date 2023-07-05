;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
(use n013)
(use theMapPrint)
(use Print)
(use Polygon)
(use Game)
(use System)

(public
	rm205 0
	greaterMap 1
	tmp2Code 2
	delay 3
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm205 of Room
	(properties
		picture 205
		style 14
		exitStyle 13
	)

	(method (init)
		(= local4 0)
		(SetFlag 220)
		(Load rsSCRIPT 20)
		(greaterMap add: frenchQ)
		(if (IsFlag 224)
			(SetFlag 32)
		)
		(if (IsFlag 101)
			(greaterMap add: grandma)
		)
		(if (IsFlag 64)
			(greaterMap add: lake)
		)
		(if (IsFlag 268)
			(greaterMap add: bayou)
		)
		(if (IsFlag 269)
			(greaterMap add: airport)
		)
		(if (IsFlag 24)
			(greaterMap add: gedde)
		)
		(if (IsFlag 14)
			(greaterMap add: tulane)
		)
		(= local1
			((Polygon new:)
				type: PTotalAccess
				init: 38 62 58 74 74 109 127 81 142 88 142 121 157 127 188 124 205 115 206 97 217 86 285 115 279 125 248 107 219 95 217 122 162 135 134 125 134 93 89 119 62 113 41 76 16 74 17 64
				yourself:
			)
		)
		(switch gPrevRoomNum
			(380
				(grandma cel: 1)
				(= local3 grandma)
			)
			(470
				(lake cel: 1)
				(= local3 lake)
			)
			(490 ; bayouMaze
				(bayou cel: 1)
				(= local3 bayou)
			)
			(750
				(airport cel: 1)
				(= local3 airport)
			)
			(350
				(gedde cel: 1)
				(= local3 gedde)
			)
			(330
				(tulane cel: 1)
				(= local3 tulane)
			)
			(else
				(frenchQ cel: 1)
				(= local3 frenchQ)
			)
		)
		(super init:)
		(if (and (IsFlag 470) (!= gPrevRoomNum 200))
			(gGkMusic1
				number: 11
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 25 10 0
			)
		)
		(self setScript: delay)
		(= curPic 205)
	)

	(method (doit)
		(super doit:)
		(if (not script)
			(greaterMap doit:)
		)
	)

	(method (cue param1)
		(if (not script)
			(self setScript: chgRoom 0 param1)
		)
	)

	(method (dispose &tmp temp0)
		(local3 setCel: 0)
		(greaterMap release: dispose:)
		(local1 dispose:)
		(if ((ScriptID 20 0) dialog:) ; theMapPrint
			(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
		)
		(DisposeScript 20)
		(super dispose:)
	)
)

(instance chgRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(!= register 200)
						(!= register gPrevRoomNum)
						(IsFlag 449)
						(!= register 750)
					)
					(gGkSound2 stop: setLoop: 1 number: 202 play: self)
				else
					(self cue:)
				)
			)
			(1
				(= global175 register)
				(if
					(and
						(not (IsFlag 449))
						(!= register 200)
						(!= register gPrevRoomNum)
						(!= gPrevRoomNum 750)
						(not (IsFlag 470))
						(!= gDay 10)
					)
					(SetFlag 449)
					(gGkSound1 stop:)
					(if (== (Platform) 1)
						(gCurRoom newRoom: 372)
					else
						(gGkMusic1 stop:)
						(gCurRoom newRoom: 372)
					)
				else
					(if (!= register 200)
						(gGkSound1 stop:)
						(gGkMusic1 fade:)
					)
					(gCurRoom newRoom: register)
				)
			)
		)
	)
)

(instance movieTime of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gTheIconBar disable:)
				(= cycles 1)
			)
			(1
				(for ((= temp0 0)) (<= temp0 100) ((+= temp0 5))
					(Palette 2 0 255 temp0) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(2
				(ShowMovie
					{205.SEQ}
					8
					(if (IsHiRes) 150 else 0)
					(if (IsHiRes) 135 else 0)
				)
				(= cycles 1)
			)
			(3
				(gCurRoom drawPic: 205 0)
				(= cycles 15)
			)
			(4
				(SetCursor 1)
				(gTheIconBar enable:)
				(greaterMap show:)
				(greaterMap setOldCurs:)
				(gMessager say: 1 0 3 0 self) ; "It's getting late. Gabriel decides to return home for the day."
			)
			(5
				(self cue:)
			)
			(6
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance delay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if
					(and
						(!= gPrevRoomNum 200)
						(DoSound sndGET_AUDIO_CAPABILITY)
						(== (gGame detailLevel:) 3)
					)
					(gGkSound1 stop: number: 201 setLoop: -1 play:)
				)
				(greaterMap show:)
				(if (not (greaterMap endDay:))
					(self dispose:)
				else
					(greaterMap setOldCurs:)
					(gMessager say: 1 0 3 0 self) ; "It's getting late. Gabriel decides to return home for the day."
				)
			)
			(2
				(gGkSound1 stop: setLoop: 1 number: 202 play: self)
			)
			(3
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance greaterMap of IconMap
	(properties)

	(method (noDest)
		(if ((ScriptID 20 0) dialog:) ; theMapPrint
			(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
		)
		(gMessager say: 1 0 1 0 0 205) ; "Please select a destination icon."
	)
)

(instance grandma of IconI
	(properties
		noun 2
		nsLeft 167
		nsTop 47
		x 167
		y 47
		view 205
		loop 1
		cel 0
	)

	(method (select)
		(if global181
			((ScriptID 20 0) ; theMapPrint
				fore: 7
				y: 150
				font: gUserFont
				modeless: 0
				width: 300
				addText: 5 0 0 0 0 0 205 ; "Grandmother Knight's house is unavailable from the day 1 demo."
				init:
			)
			(return 0)
		else
			(return 1)
		)
	)

	(method (cue)
		(if (<= 7 gDay 10)
			(gMessager say: 1 0 7 0) ; "(RRCC)No one answers Gran's front door, but a note sticking from the mail slot bears Gabriel's name."
			(return)
		)
		(greaterMap setOldCurs:)
		(gCurRoom cue: 380)
	)
)

(instance frenchQ of IconI
	(properties
		noun 3
		nsLeft 191
		nsTop 64
		x 191
		y 64
		view 205
		loop 6
		cel 0
	)

	(method (cue)
		(greaterMap setOldCurs:)
		(gCurRoom cue: 200)
	)
)

(instance lake of IconI
	(properties
		noun 4
		nsLeft 145
		nsTop 40
		x 145
		y 40
		view 205
		loop 0
		cel 0
	)

	(method (cue)
		(greaterMap setOldCurs:)
		(gCurRoom cue: 470)
	)
)

(instance bayou of IconI
	(properties
		noun 6
		nsLeft 199
		nsTop 46
		x 199
		y 46
		view 205
		loop 2
		cel 0
	)

	(method (cue)
		(greaterMap setOldCurs:)
		(gCurRoom cue: 490)
	)
)

(instance airport of IconI
	(properties
		noun 7
		nsLeft 38
		nsTop 44
		x 38
		y 44
		view 205
		loop 3
		cel 0
	)

	(method (select)
		(if (!= gDay 7)
			(if ((ScriptID 20 0) dialog:) ; theMapPrint
				(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
			)
			(gMessager say: 1 0 6 0 0 205) ; "It's time to stay in New Orleans and face the music."
			(return 0)
		else
			(if ((ScriptID 20 0) dialog:) ; theMapPrint
				(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
			)
			(gMessager say: 1 0 4 0 self 205) ; "Gabriel picks up his tickets at the airport and boards a plane for Munich."
			(return 0)
		)
	)

	(method (cue)
		(greaterMap setOldCurs:)
		(gCurRoom cue: 750)
	)
)

(instance gedde of IconI
	(properties
		noun 8
		nsLeft 175
		nsTop 107
		x 175
		y 107
		view 205
		loop 4
		cel 0
	)

	(method (cue)
		(greaterMap setOldCurs:)
		(gCurRoom cue: 350)
	)
)

(instance tulane of IconI
	(properties
		noun 9
		nsLeft 158
		nsTop 86
		x 158
		y 86
		view 205
		loop 5
		cel 0
	)

	(method (cue)
		(greaterMap setOldCurs:)
		(gCurRoom cue: 330)
	)
)

(instance destPrint of Print ; UNUSED
	(properties)

	(method (init)
		(= local2 1)
		(super init:)
	)

	(method (dispose)
		(= local2 0)
		(super dispose:)
	)
)

(instance tmp2Code of Code
	(properties)

	(method (doit param1 param2)
		(if (not (gTalkers size:))
			(cond
				((InRect 146 99 164 121 param1 param2)
					(if (!= local0 2)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 2)
						((ScriptID 20 0) ; theMapPrint
							back: 0
							x: 0
							y: 160
							font: 0
							fore: 55
							modeless: 2
							width: 300
							addText: 14 0 0 0 0 0 205 ; "Audubon Park"
							init:
						)
					)
				)
				((InRect 180 77 197 97 param1 param2)
					(if (!= local0 4)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 4)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 12 0 0 0 0 0 205 ; "Central Business District"
							init:
						)
					)
				)
				((InRect 182 37 192 57 param1 param2)
					(if (!= local0 5)
						(= local0 5)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 15 0 0 0 0 0 205 ; "City Park"
							init:
						)
					)
				)
				((InRect 171 101 189 122 param1 param2)
					(if (!= local0 6)
						(= local0 6)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 13 0 0 0 0 0 205 ; "Garden District"
							init:
						)
					)
				)
				((InRect 94 22 276 34 param1 param2)
					(if (!= local0 7)
						(= local0 7)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						((ScriptID 20 0) ; theMapPrint
							back: 0
							x: 0
							y: 160
							font: 0
							fore: 55
							modeless: 2
							width: 300
							addText: 11 0 0 0 0 0 205 ; "Lake Pontchartrain"
							init:
						)
					)
				)
				((local1 onMe: param1 param2)
					(if (!= local0 8)
						(= local0 8)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						((ScriptID 20 0) ; theMapPrint
							back: 0
							x: 0
							y: 160
							font: 0
							fore: 55
							modeless: 2
							width: 300
							addText: 10 0 0 0 0 0 205 ; "Mississippi River"
							init:
						)
					)
				)
				(else
					(= local0 0)
					(if (and (not local2) ((ScriptID 20 0) dialog:)) ; theMapPrint
						(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
					)
				)
			)
		)
	)
)

