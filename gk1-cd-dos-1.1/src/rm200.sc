;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use n013)
(use theMapPrint)
(use Game)
(use System)

(public
	rm200 0
	cityMap 1
	tmpCode 2
)

(local
	local0
	local1
	local2
	local3
)

(instance rm200 of Room
	(properties
		picture 200
		style 14
		exitStyle 13
	)

	(method (init &tmp temp0)
		(SetFlag 220)
		(SetFlag 382)
		(Load rsSCRIPT 20)
		(cityMap
			add:
				bookStore
				jackSquare
				jackOver
				louisCath
				napHouse
				greatNO1
				greatNO2
				voodooShop
				voodooMus
		)
		(if (IsFlag 223)
			(SetFlag 397)
		)
		(if (IsFlag 307)
			(SetFlag 392)
		)
		(if (IsFlag 77)
			(cityMap add: cemetery)
		)
		(if (IsFlag 63)
			(cityMap add: policeLobby)
		)
		(if (IsFlag 266)
			(cityMap add: cazaunoux)
		)
		(if (IsFlag 267)
			(cityMap add: moonBeam)
		)
		(switch gPrevRoomNum
			(430 ; seJackson
				(jackSquare cel: 1)
				(= local2 jackSquare)
			)
			(440 ; swJackson
				(jackSquare cel: 1)
				(= local2 jackSquare)
			)
			(400
				(jackOver cel: 1)
				(= local2 jackOver)
			)
			(450
				(louisCath cel: 1)
				(= local2 louisCath)
			)
			(460 ; napoleon
				(napHouse cel: 1)
				(= local2 napHouse)
			)
			(250
				(voodooShop cel: 1)
				(= local2 voodooShop)
			)
			(205
				(greatNO2 cel: 1)
				(greatNO1 cel: 1)
				(= local2 greatNO1)
			)
			(260
				(voodooMus cel: 1)
				(= local2 voodooMus)
			)
			(230
				(policeLobby cel: 1)
				(= local2 policeLobby)
			)
			(300
				(cemetery cel: 1)
				(= local2 cemetery)
			)
			(270
				(cazaunoux cel: 1)
				(= local2 cazaunoux)
			)
			(290
				(moonBeam cel: 1)
				(= local2 moonBeam)
			)
			(else
				(bookStore cel: 1)
				(= local2 bookStore)
			)
		)
		(super init:)
		(if (!= gPrevRoomNum 205)
			(gGkMusic1
				number: 11
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 25 10 0
			)
		)
		(= curPic 200)
		(self setScript: delay)
	)

	(method (doit)
		(super doit:)
		(if (not script)
			(cityMap doit:)
		)
	)

	(method (cue param1)
		(if (not script)
			(self setScript: chgRoom 0 param1)
		)
	)

	(method (dispose &tmp temp0)
		(local2 setCel: 0)
		(if (== local2 greatNO1)
			(greatNO2 setCel: 0)
		)
		(cityMap release: dispose:)
		(if ((ScriptID 20 0) dialog:) ; theMapPrint
			(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
		)
		(DisposeScript 20)
		(super dispose:)
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
				(ShowMovie {MAP.SEQ} 8)
				(= cycles 1)
			)
			(3
				(gCurRoom drawPic: 200 0)
				(= cycles 15)
			)
			(4
				(SetCursor 1)
				(cityMap show:)
				(if (not (cityMap endDay:))
					(gTheIconBar enable:)
					(if local3
						(gTheIconBar draw:)
						(gGame keepBar: 1)
					)
					(self dispose:)
				else
					(cityMap setOldCurs:)
					(gMessager say: 1 0 3 0 self) ; "It's getting late. Gabriel decides to go home for the day."
				)
			)
			(5
				(gGkSound1 stop: setLoop: 1 number: 202 play: self)
			)
			(6
				(gCurRoom newRoom: 350)
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
						(!= gPrevRoomNum 205)
						(DoSound sndGET_AUDIO_CAPABILITY)
						(== (gGame detailLevel:) 3)
					)
					(gGkSound1 stop: number: 201 setLoop: -1 play:)
				)
				(cityMap show:)
				(if (not (cityMap endDay:))
					(self dispose:)
				else
					(cityMap setOldCurs:)
					(gMessager say: 1 0 3 0 self) ; "It's getting late. Gabriel decides to go home for the day."
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

(instance chgRoom of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(and
						(!= register 205)
						(!= register gPrevRoomNum)
						(IsFlag 449)
					)
					(gGkSound2 stop: setLoop: 1 number: 202 play: self)
				else
					(= cycles 2)
				)
			)
			(1
				(= global175 register)
				(if
					(and
						(not (IsFlag 449))
						(!= register 205)
						(!= register gPrevRoomNum)
						(!= register 210)
						(not (IsFlag 470))
						(!= gDay 10)
					)
					(SetFlag 449)
					(gGkSound1 stop:)
					(gCurRoom newRoom: 372)
				else
					(if (!= register 205)
						(gGkSound1 stop:)
						(gGkMusic1 fade:)
					)
					(gCurRoom newRoom: register)
				)
			)
		)
	)
)

(instance cityMap of IconMap
	(properties)

	(method (noDest)
		(if ((ScriptID 20 0) dialog:) ; theMapPrint
			(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
		)
		(gMessager say: 1 0 30 0 0 200) ; "Please select a destination icon."
	)
)

(instance bookStore of IconI
	(properties
		noun 2
		nsLeft 181
		nsTop 67
		x 181
		y 67
		view 200
		loop 0
		cel 0
	)

	(method (cue)
		(cityMap setOldCurs:)
		(gCurRoom cue: 210)
	)
)

(instance jackSquare of IconI
	(properties
		noun 3
		nsLeft 154
		nsTop 122
		x 154
		y 122
		view 200
		loop 2
		cel 0
	)

	(method (cue)
		(cityMap setOldCurs:)
		(gCurRoom cue: 430)
	)
)

(instance louisCath of IconI
	(properties
		noun 4
		nsLeft 152
		nsTop 96
		x 152
		y 96
		view 200
		loop 1
		cel 0
	)

	(method (cue)
		(cityMap setOldCurs:)
		(gCurRoom cue: 450)
	)
)

(instance policeLobby of IconI
	(properties
		noun 5
		nsLeft 85
		nsTop 107
		x 85
		y 107
		view 200
		loop 4
		cel 0
	)

	(method (cue)
		(cityMap setOldCurs:)
		(gCurRoom cue: 230)
	)
)

(instance napHouse of IconI
	(properties
		noun 9
		nsLeft 104
		nsTop 122
		x 104
		y 122
		view 200
		loop 10
		cel 0
	)

	(method (cue)
		(cityMap setOldCurs:)
		(gCurRoom cue: 460)
	)
)

(instance cemetery of IconI
	(properties
		noun 15
		nsLeft 102
		nsTop 30
		x 102
		y 30
		view 200
		loop 9
		cel 0
	)

	(method (cue)
		(cityMap setOldCurs:)
		(gCurRoom cue: 300)
	)
)

(instance greatNO1 of IconI
	(properties
		noun 6
		x 6
		y 80
		view 200
		loop 11
		cel 0
	)

	(method (cue)
		(cityMap setOldCurs:)
		(gCurRoom cue: 205)
	)
)

(instance greatNO2 of IconI
	(properties
		noun 6
		x 284
		y 80
		view 200
		loop 11
		cel 0
	)

	(method (cue)
		(cityMap setOldCurs:)
		(gCurRoom cue: 205)
	)
)

(instance voodooShop of IconI
	(properties
		noun 13
		nsLeft 262
		nsTop 56
		x 262
		y 56
		view 200
		loop 5
		cel 0
	)

	(method (select)
		(if (> gDay 6)
			(if ((ScriptID 20 0) dialog:) ; theMapPrint
				(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
			)
			(gMessager say: 1 0 32 0 0 200) ; "The Dixieland Drug Store is locked and barred tight."
			(return 0)
		else
			(return 1)
		)
	)

	(method (cue)
		(if (not global181)
			(cityMap setOldCurs:)
			(gCurRoom cue: 250)
		)
	)
)

(instance voodooMus of IconI
	(properties
		noun 14
		nsLeft 224
		nsTop 119
		x 224
		y 119
		view 200
		loop 6
		cel 0
	)

	(method (select)
		(cond
			((and (IsFlag 465) (== gDay 5))
				(if ((ScriptID 20 0) dialog:) ; theMapPrint
					(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
				)
				(gMessager say: 1 0 34 0 0 200) ; "(GK-AM2)Posted on the door of the museum is a sign saying "Closed today only." This time, the door is actually locked!"
				(return 0)
			)
			((and (IsFlag 114) (== gDay 6))
				(if ((ScriptID 20 0) dialog:) ; theMapPrint
					(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
				)
				(gMessager say: 1 0 35 0 0 200) ; "(GK-AM2)Posted on the door of the museum is a sign saying "Closed for St. John's Eve.""
				(return 0)
			)
			((> gDay 6)
				(if ((ScriptID 20 0) dialog:) ; theMapPrint
					(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
				)
				(gMessager say: 1 0 31 0 0 200) ; "Posted on the door of the museum is a sign saying "Closed until further notice.""
				(return 0)
			)
			(else
				(return 1)
			)
		)
	)

	(method (cue)
		(cityMap setOldCurs:)
		(gCurRoom cue: 260)
	)
)

(instance jackOver of IconI
	(properties
		noun 10
		nsLeft 140
		nsTop 132
		x 140
		y 132
		view 200
		loop 3
		cel 0
	)

	(method (cue)
		(cityMap setOldCurs:)
		(gCurRoom cue: 400)
	)
)

(instance cazaunoux of IconI
	(properties
		noun 12
		nsLeft 78
		nsTop 74
		x 78
		y 74
		view 200
		loop 7
		cel 0
	)

	(method (cue)
		(cityMap setOldCurs:)
		(gCurRoom cue: 270)
	)
)

(instance moonBeam of IconI
	(properties
		noun 11
		nsLeft 159
		nsTop 74
		x 159
		y 74
		view 200
		loop 8
		cel 0
	)

	(method (select)
		(if (>= gDay 5)
			(if ((ScriptID 20 0) dialog:) ; theMapPrint
				(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
			)
			(gMessager say: 1 0 33 0 0 200) ; "A sign on the front door of Magentia's home reads "Attending a Channeling seminar until August 1st.""
			(return 0)
		else
			(return 1)
		)
	)

	(method (cue)
		(cityMap setOldCurs:)
		(gCurRoom cue: 290)
	)
)

(instance tmpCode of Code
	(properties)

	(method (doit param1 param2)
		(if (not (gTalkers size:))
			(cond
				((InRect 35 28 138 36 param1 param2)
					(if (!= local0 1)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 1)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 28 0 0 0 200 ; "Basin Street"
							init:
						)
					)
				)
				((InRect 36 41 313 46 param1 param2)
					(if (!= local0 2)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 2)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 25 0 0 0 200 ; "N. Rampart Street"
							init:
						)
					)
				)
				((InRect 40 59 307 63 param1 param2)
					(if (!= local0 3)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 3)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 5 0 0 0 200 ; "Burgundy Street"
							init:
						)
					)
				)
				((InRect 40 75 296 79 param1 param2)
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
							addText: 8 0 24 0 0 0 200 ; "Dauphine Street"
							init:
						)
					)
				)
				((InRect 40 90 280 94 param1 param2)
					(if (!= local0 5)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 5)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 4 0 0 0 200 ; "Bourbon Street"
							init:
						)
					)
				)
				((InRect 39 104 307 108 param1 param2)
					(if (!= local0 6)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 6)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 23 0 0 0 200 ; "Royal Street"
							init:
						)
					)
				)
				((InRect 41 120 287 124 param1 param2)
					(if (!= local0 7)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 7)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 22 0 0 0 200 ; "Chartres Street"
							init:
						)
					)
				)
				((InRect 0 137 280 141 param1 param2)
					(if (!= local0 8)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 8)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 21 0 0 0 200 ; "Decatur Street"
							init:
						)
					)
				)
				((InRect 40 29 47 141 param1 param2)
					(if (!= local0 9)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 9)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 6 0 0 0 200 ; "Canal Street"
							init:
						)
					)
				)
				((InRect 63 29 67 141 param1 param2)
					(if (!= local0 10)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 10)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 7 0 0 0 200 ; "Iberville Street"
							init:
						)
					)
				)
				((InRect 79 29 84 141 param1 param2)
					(if (!= local0 11)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 11)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 8 0 0 0 200 ; "Bienville Street"
							init:
						)
					)
				)
				((InRect 98 29 102 141 param1 param2)
					(if (!= local0 12)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 12)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 9 0 0 0 200 ; "Conti Street"
							init:
						)
					)
				)
				((InRect 116 29 120 141 param1 param2)
					(if (!= local0 13)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 13)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 10 0 0 0 200 ; "St. Louis Street"
							init:
						)
					)
				)
				((InRect 134 36 149 141 param1 param2)
					(if (!= local0 14)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 14)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 11 0 0 0 200 ; "Toulouse Street"
							init:
						)
					)
				)
				((InRect 151 34 156 141 param1 param2)
					(if (!= local0 15)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 15)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 12 0 0 0 200 ; "St. Peter Street"
							init:
						)
					)
				)
				((InRect 162 47 165 141 param1 param2)
					(if (!= local0 16)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 16)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 13 0 0 0 200 ; "Orleans Street"
							init:
						)
					)
				)
				((InRect 170 47 175 141 param1 param2)
					(if (!= local0 17)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 17)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 14 0 0 0 200 ; "St. Ann Street"
							init:
						)
					)
				)
				((InRect 189 47 194 141 param1 param2)
					(if (!= local0 18)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 18)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 15 0 0 0 200 ; "Dumaine Street"
							init:
						)
					)
				)
				((InRect 207 30 212 141 param1 param2)
					(if (!= local0 19)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 19)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 16 0 0 0 200 ; "St. Philip Street"
							init:
						)
					)
				)
				((InRect 224 30 230 141 param1 param2)
					(if (!= local0 20)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 20)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 17 0 0 0 200 ; "Ursulines Street"
							init:
						)
					)
				)
				((InRect 243 30 247 141 param1 param2)
					(if (!= local0 21)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 21)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 18 0 0 0 200 ; "Governor Nicholls Street"
							init:
						)
					)
				)
				((InRect 261 30 266 141 param1 param2)
					(if (!= local0 22)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 22)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 19 0 0 0 200 ; "Barracks Street"
							init:
						)
					)
				)
				((InRect 273 30 280 141 param1 param2)
					(if (!= local0 23)
						(if ((ScriptID 20 0) dialog:) ; theMapPrint
							(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
						)
						(= local0 23)
						((ScriptID 20 0) ; theMapPrint
							x: 0
							y: 160
							font: 0
							fore: 55
							back: 0
							modeless: 2
							width: 300
							addText: 8 0 20 0 0 0 200 ; "Esplanade Avenue"
							init:
						)
					)
				)
				(else
					(= local0 0)
					(if (and (not local1) ((ScriptID 20 0) dialog:)) ; theMapPrint
						(((ScriptID 20 0) dialog:) dispose:) ; theMapPrint
					)
				)
			)
		)
	)
)

