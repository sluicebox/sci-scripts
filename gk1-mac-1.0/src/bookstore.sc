;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use n013)
(use GKNarrator)
(use sHRoom8)
(use Inset)
(use Talker)
(use ROsc)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	bookstore 0
	graceProp 1
	gabsMug 2
	coffeePot 3
	graceDoStuff 4
	gabsCoat 5
	graceActor 6
	newsPaper 7
	chair 8
	bookStoreNarrator 9
	painting 10
	entranceTimer 11
	hangUpCoat 12
	envelope 13
	maliasNote 14
	exitToGabsRoom 15
	openTheRegister 16
	drawer 17
	readMaliasNote 18
	getReferenceBooks 19
	artSupplies 20
	shopDoor 21
)

(local
	local0 = 1
	local1
	local2
	local3
	local4
	local5 = 5
	local6
	local7
)

(instance bookstore of Room
	(properties
		noun 10
		picture 210
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 100 91 90 103 51 118 20 132 61 142 68 143 101 130 170 144 225 144 209 155 212 174 224 174 247 144 319 144 319 105 273 105 281 114 275 123 242 122 228 131 194 128 182 119 202 103 117 87 109 92
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 124 103 106 95 121 89 143 95 125 103
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 57 122 70 126 54 138 31 130 41 124 50 124
					yourself:
				)
		)
		(SetFlag 361)
		(Load rsMESSAGE 210)
		(Load rsMESSAGE 211)
		(Load rsVIEW 211)
		(Load rsVIEW 2111)
		(gEgo
			view: 901
			cel: 0
			setLoop: 0
			signal: (| $1000 (gEgo signal:))
			init:
			setCycle: StopWalk -1
			state: 2
		)
		((ScriptID 215 0) init:) ; xcoatRack
		((ScriptID 215 1) init:) ; xcoffeeStuff
		((ScriptID 215 2) init:) ; xbooksBehindLadder
		((ScriptID 215 3) init:) ; xbooksLeftOfLadder
		((ScriptID 215 4) init:) ; xcurtainDoor
		((ScriptID 215 5) init:) ; xdrawers
		((ScriptID 215 6) init:) ; xgargoyle
		((ScriptID 215 7) init:) ; xgermanBooks
		((ScriptID 215 8) init:) ; xladder
		((ScriptID 215 9) init:) ; xbalcony
		((ScriptID 215 10) init:) ; xcashRegister
		((ScriptID 215 11) init:) ; xcoffeeTable
		((ScriptID 215 12) init:) ; xbooksBottomRight
		((ScriptID 215 13) init:) ; xbooksBottomLeft
		((ScriptID 215 14) init:) ; xcoffeeBooks
		((ScriptID 215 15) init:) ; xbookRack
		((ScriptID 215 16) init:) ; xwindowBooks
		((ScriptID 215 17) init:) ; xchandelier
		((ScriptID 215 18) init:) ; xrightWindow
		((ScriptID 215 19) init:) ; xdesk
		((ScriptID 215 20) init:) ; xdoorMat
		((ScriptID 215 21) init:) ; xdeskLamp
		((ScriptID 215 22) init:) ; xsnakeBooks
		((ScriptID 215 23) init:) ; xdeskTop
		((ScriptID 215 24) init:) ; xphone
		((ScriptID 215 28) init:) ; xdeskBooks
		(coffeePot init:)
		(gracesCoat init:)
		(if (or (not (IsFlag 289)) (== gDay 10))
			(painting init:)
		else
			((ScriptID 215 27) init:) ; xbehindPic
		)
		(newsPaper init: setPri: 148)
		(if (not (gEgo has: 4)) ; magGlass
			(magnifyingGlass init:)
		)
		(if (not (gEgo has: 3)) ; tweezers
			(tweezers init:)
		)
		(gabsCoat init:)
		(gabsMug init:)
		(chair init:)
		(ashTray init:)
		(artSupplies init:)
		(shopDoor init:)
		(if (== gDay 10)
			(maliasNote init:)
			(Load rsVIEW 2161)
		)
		(if (and (IsFlag 306) (not (gEgo has: 27)) (not (gEgo has: 28))) ; keyEnvelope, mosKey
			(envelope init: cel: 12)
		)
		(if (or (== gDay 4) (== gDay 5))
			(theWatcher init:)
		)
		(gWalkHandler add: (ScriptID 215 9)) ; xbalcony
		(gWalkHandler add: (ScriptID 215 4)) ; xcurtainDoor
		(= gNarrator bookStoreNarrator)
		(cond
			((== gPrevRoomNum 50) ; interrogation
				(gEgo posn: 245 133 setCel: 6 ignoreActors: 1)
				(graceProp init:)
				(cond
					((== gDay 5)
						(if (and (IsFlag 73) (IsFlag 16))
							(SetFlag 15)
						)
					)
					((== gDay 4)
						(if
							(and
								(IsFlag 447)
								(IsFlag 248)
								(IsFlag 36)
								(IsFlag 227)
								(gEgo has: 26) ; tatooTrace
								(gEgo has: 41) ; braceRep
							)
							(SetFlag 15)
						)
					)
					(
						(and
							(== gDay 2)
							(IsFlag 72)
							(IsFlag 107)
							(IsFlag 231)
							(IsFlag 232)
						)
						(SetFlag 15)
					)
				)
				(cond
					((IsFlag 15)
						(gCurRoom setScript: timeToGoHome)
					)
					((IsFlag 55)
						(gEgo setScript: (ScriptID 212 6)) ; getNumFromGrace
					)
					(else
						(graceProp setScript: graceDoStuff)
					)
				)
			)
			((== gPrevRoomNum 370)
				(cond
					((not (IsFlag 10))
						(ClearFlag 449)
						(SetFlag 6)
						(switch gDay
							(1
								(gCurRoom setScript: (ScriptID 211 1)) ; startingCartoon
								(SetFlag 8)
								(SetFlag 367)
							)
							(2
								(ClearFlag 254)
								(gCurRoom setScript: (ScriptID 211 2)) ; startOfDay2
								(SetFlag 367)
							)
							(3
								(gCurRoom setScript: (ScriptID 212 3)) ; startOfDay3
								(SetFlag 367)
							)
							(4
								(SetFlag 328)
								(gCurRoom setScript: (ScriptID 214 1)) ; startOfDay4
								(SetFlag 367)
							)
							(5
								(gCurRoom setScript: (ScriptID 212 1)) ; startOfDay5
								(SetFlag 367)
							)
							(6
								(ClearFlag 294)
								(gEgo hide:)
								(gCurRoom setScript: (ScriptID 214 2)) ; startOfDay6
							)
							(7
								(ClearFlag 263)
								(gEgo setScript: comeFromStudio)
							)
							(10
								(SetFlag 10)
								(ClearFlag 6)
							)
						)
					)
					((IsFlag 15)
						(gCurRoom setScript: egoAndMalia)
					)
					(else
						(SetFlag 6)
						(graceProp init: setScript: graceDoStuff)
						(gEgo setScript: hangUpCoat)
					)
				)
			)
			((== gPrevRoomNum 200)
				(if (and (== gDay 5) (IsFlag 96))
					(gCurRoom setScript: (ScriptID 212 9)) ; graceGetsScale
					(SetFlag 6)
				else
					(if (== gDay 10)
						(ClearFlag 6)
					else
						(SetFlag 6)
						(if (!= gDay 10)
							(graceProp init: setScript: graceDoStuff)
						)
					)
					(if
						(and
							(== gDay 7)
							(IsFlag 357)
							(not (IsFlag 356))
						)
						((ScriptID 210 1) init: setCel: 4 setLoop: 2) ; graceProp
					)
					(gEgo setScript: hangUpCoat)
				)
			)
			((== gPrevRoomNum 220)
				(if (and (== gDay 7) (IsFlag 269) (not (IsFlag 262)))
					(SetFlag 6)
					(graceProp init: setScript: graceDoStuff)
					(gEgo setScript: comeFromStudio)
				else
					(if (== gDay 10)
						(ClearFlag 6)
					else
						(SetFlag 6)
						(graceProp init: setScript: graceDoStuff)
					)
					(gEgo setScript: comeFromStudio)
				)
			)
			(else
				(SetFlag 8)
				(gEgo posn: 150 110 ignoreActors: 1)
				(if (== gDay 5)
					(gabsCoat init:)
				)
				(if (!= gDay 10)
					(graceProp init: setScript: graceDoStuff)
					(SetFlag 6)
				)
			)
		)
		(if (and (== gDay 1) (IsFlag 254) (not (IsFlag 240)))
			(entranceTimer setReal: self 20)
		)
		(if (and (>= gDay 3) (IsFlag 35) (not (IsFlag 289)))
			(entranceTimer setReal: self 20)
		)
		(if
			(and
				(== gDay 6)
				(not (IsFlag 306))
				(not (gEgo has: 27)) ; keyEnvelope
				(not (gEgo has: 28)) ; mosKey
			)
			(envelopeTimer setReal: self 20)
		)
		(if
			(and
				(>= gDay 5)
				(IsFlag 96)
				(not (gEgo has: 23)) ; musScale
				(not (gEgo has: 25)) ; twoScales
			)
			(SetFlag 321)
			(ClearFlag 96)
		)
		(cond
			((and (IsFlag 15) (== gDay 3) (== gPrevRoomNum 370))
				(gGkMusic1
					number: 209
					setLoop: -1
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 25 10 0
				)
			)
			((!= gPrevRoomNum 50) ; interrogation
				(gGkMusic1
					number: 210
					setLoop: -1
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 25 10 0
				)
			)
		)
	)

	(method (dispose)
		(= gNarrator GKNarrator)
		(if (!= gNewRoomNum 50) ; interrogation
			(gGkMusic1 fade:)
		)
		(gWalkHandler delete: (ScriptID 215 9)) ; xbalcony
		(gWalkHandler delete: (ScriptID 215 4)) ; xcurtainDoor
		(entranceTimer client: 0)
		(entranceTimer dispose: delete:)
		(envelopeTimer client: 0)
		(envelopeTimer dispose: delete:)
		(ClearFlag 367)
		(DisposeScript 64939)
		(DisposeScript 64956)
		(DisposeScript 920)
		(DisposeScript 51)
		(DisposeScript 64938)
		(DisposeScript 215)
		(DisposeScript 211)
		(DisposeScript 212)
		(DisposeScript 214)
		(DisposeScript 213)
		(super dispose:)
	)

	(method (cue)
		(if
			(and
				(not (IsFlag 289))
				(not (gEgo script:))
				(not (self script:))
				(not (CueObj state:))
			)
			(gGame handsOff:)
			(self setScript: (ScriptID 211 5)) ; enterFlorist
		else
			(entranceTimer setReal: self 15)
		)
		(cond
			(
				(and
					(== gDay 6)
					(not (IsFlag 306))
					(not (gEgo script:))
					(not (self script:))
					(not (CueObj state:))
				)
				(gGame handsOff:)
				(self setScript: dropTheEnvelope)
			)
			((and (== gDay 6) (not (IsFlag 306)))
				(envelopeTimer setReal: self 15)
			)
		)
	)
)

(instance entranceTimer of Timer
	(properties)
)

(instance envelopeTimer of Timer
	(properties)
)

(instance bookStoreNarrator of Narrator
	(properties
		x 0
		y 157
		talkWidth 314
		modeless 2
	)

	(method (init)
		(self fore: global220 back: global214 font: gUserFont)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0 temp1)
		(= fore
			(switch global180
				(1 54)
				(99 7)
				(2 21)
				(4 26)
				(5 19)
				(8 30)
				(else global220)
			)
		)
		(switch global180
			(1
				(cond
					(
						(and
							(> (param1 size:) 12)
							(IsFlag 311)
							(== (gEgo view:) 215)
						)
						(= temp0 215)
						(= local7 (gEgo cycleSpeed:))
						(= temp1 (gEgo cel:))
						(gEgo
							talking: 1
							oldView: (gEgo view:)
							oldLoop: (gEgo loop:)
							oldCel: (gEgo cel:)
							setCel: 0
							view: temp0
							setLoop: temp1
							ignoreActors:
							cycleSpeed: 14
							setCycle: Fwd
						)
					)
					(
						(and
							(or
								(== (gEgo view:) 901)
								(== (gEgo view:) 900)
							)
							(== (gEgo loop:) 8)
							(or
								(== (gEgo view:) 901)
								(== (gEgo view:) 900)
							)
						)
						(if (or (== (gEgo cel:) 4) (== (gEgo cel:) 5))
							(= temp0 (+ (gEgo view:) 1000))
						else
							(if (== (gEgo view:) 900)
								(= temp0
									(+ (gEgo view:) 1010 (gEgo cel:))
								)
							else
								(= temp0
									(+ (gEgo view:) 1039 (gEgo cel:))
								)
							)
							(switch (Random 0 2)
								(0 1)
								(1
									(+= temp0 10)
								)
								(2
									(= temp0 (+ (gEgo view:) 1000))
								)
							)
						)
						(= local7 (gEgo cycleSpeed:))
						(= temp1 (gEgo cel:))
						(gEgo
							talking: 1
							oldView: (gEgo view:)
							oldLoop: (gEgo loop:)
							oldCel: (gEgo cel:)
							view: temp0
							setCel: 0
							setLoop: temp1
							ignoreActors:
							cycleSpeed: 14
						)
						(if (or (< 1919 temp0 1930) (< 1949 temp0 1960))
							(gEgo setCycle: ForRepeat)
						else
							(gEgo setCycle: Fwd)
						)
					)
				)
			)
			(2
				(if (IsFlag 361)
					(= local2 1)
					(if (graceProp script:)
						(graceDoStuff dispose:)
					)
					(if (IsFlag 311)
						(graceProp
							view: 211
							setCel: 0
							setLoop: 3
							setCycle: RandCycle (* (param1 size:) 3) 0 1
						)
					else
						(graceProp
							view: 2111
							setCel: 0
							setLoop: 1
							setCycle: RandCycle (* (param1 size:) 3) 0 1
						)
					)
				)
			)
			(4
				(= local3 1)
				((ScriptID 211 6) ; florist
					view: 2173
					setCel: 0
					setLoop: 1
					setCycle: RandCycle (* (param1 size:) 3) 0 1
				)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(if (gEgo talking:)
			(gEgo
				view: (gEgo oldView:)
				setLoop: (gEgo oldLoop:)
				setCel: (gEgo oldCel:)
				cycleSpeed: local7
				talking: 0
			)
			(if (IsFlag 311)
				(gEgo setCycle: 0)
			else
				(gEgo setCycle: StopWalk -1)
			)
		)
		(if local2
			(graceProp setCycle: 0 setCel: 0)
			(= local2 0)
			(if (and (not (gEgo script:)) (not (gCurRoom script:)))
				(graceProp setScript: graceDoStuff)
			)
		)
		(if local3
			((ScriptID 211 6) setCycle: 0 setCel: 0) ; florist
			(= local3 0)
		)
		(super dispose:)
	)
)

(instance getTheNewsPaper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 137) (!= (gEgo y:) 138))
					(gEgo setMotion: PolyPath 137 138 self)
				else
					(self cue:)
				)
			)
			(1
				(newsPaper hide:)
				(gEgo
					posn: 136 120
					view: 214
					setCel: 0
					setLoop: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(gGkSound1 number: 213 setLoop: 1 play:)
				(gEgo setCel: 3 setLoop: 0 posn: 136 120 setCycle: End self)
			)
			(3
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(4
				(switch gDay
					(1
						(gMessager sayRange: 35 12 16 1 3 self 211) ; "Times Picayune, dated June 18, 1993. The front page has an article about the Voodoo Murders."
					)
					(3
						(gMessager say: 35 12 18 1 self 211) ; "Times Picayune, dated June 20, 1993. Gabriel scans over an uninteresting front page."
						(SetFlag 14)
					)
					(5
						(gMessager say: 35 12 20 1 self 211) ; "Times Picayune, dated June 22, 1993. Disgusted with the state of the Voodoo murder case, Gabriel turns right to his horoscope."
					)
					(6
						(gMessager sayRange: 35 12 21 1 4 self 211) ; "Times Picayune, dated June 23, 1993."
					)
					(7
						(gMessager sayRange: 35 12 22 1 4 self 211) ; "Times Picayune, dated June 24, 1993. There's nothing about the Voodoo Murders case in the paper today."
					)
					(10
						(gMessager sayRange: 35 12 11 1 4 self 211) ; "(NRCC)Times Picayune, dated June 28, 1993. The weather service is baffled by the series of bizarre storms that rocked the South yesterday."
					)
				)
			)
			(5
				(gGkSound1 number: 213 setLoop: 1 play:)
				(gEgo setCel: 0 setLoop: 1 setCycle: Osc 1 self)
			)
			(6
				(switch gDay
					(1
						(gMessager sayRange: 35 12 16 4 6 self 211) ; "Gabriel also scans the Aquarius horoscope for the day...."
					)
					(3
						(gMessager say: 35 12 18 2 self 211) ; "Under the Cultural Events section there's a notice about a lecture on "African Religions." The lecture is at Tulane University."
						(gEgo getPoints: 419 1)
					)
					(5
						(gMessager sayRange: 35 12 20 2 3 self 211) ; "The shadow upon you is no longer reversible."
					)
					(6
						(if (IsFlag 430)
							(gMessager sayRange: 35 12 21 5 6 self 211) ; "Despite his better judgment, Gabriel reads his horoscope."
						else
							(SetFlag 430)
							(gMessager sayRange: 35 12 21 5 8 self 211) ; "Despite his better judgment, Gabriel reads his horoscope."
						)
					)
					(7
						(gMessager sayRange: 35 12 22 6 8 self 211) ; "Gabriel's horoscope today reads...."
					)
					(10
						(gMessager sayRange: 35 12 11 5 7 self 211) ; "Warily, Gabriel reads his horoscope for the day...."
					)
				)
			)
			(7
				(switch gDay
					(1
						(Load rsVIEW 901)
						(gGkSound1 number: 213 setLoop: 1 play:)
						(gEgo setCel: 0 setLoop: 2 setCycle: End self)
					)
					(3
						(gGkSound1 number: 213 setLoop: 1 play:)
						(gEgo setCel: 0 setLoop: 1 setCycle: Osc 1 self)
					)
					(5
						(gEgo setCel: 0 setLoop: 2 setCycle: End self)
					)
					(6
						(Load rsVIEW 901)
						(gGkSound1 number: 213 setLoop: 1 play:)
						(gEgo setCel: 0 setLoop: 2 setCycle: End self)
					)
					(7
						(Load rsVIEW 901)
						(gGkSound1 number: 213 setLoop: 1 play:)
						(gEgo setCel: 0 setLoop: 2 setCycle: End self)
					)
					(10
						(Load rsVIEW 901)
						(gGkSound1 number: 213 setLoop: 1 play:)
						(gEgo setCel: 0 setLoop: 2 setCycle: End self)
					)
				)
			)
			(8
				(switch gDay
					(1
						(newsPaper show:)
						(gEgo
							normalize: 2 901
							ignoreActors: 1
							posn: 137 138
							getPoints: 119 1
						)
						(gGame handsOn:)
						(self dispose:)
					)
					(3
						(gMessager say: 35 12 18 3 self 211) ; "Gabriel's horoscope for the day: An evil eye is upon you. Change course before it's too late."
					)
					(5
						(newsPaper show:)
						(gEgo
							normalize: 2 901
							ignoreActors: 1
							posn: 137 138
							getPoints: 145 1
						)
						(gGame handsOn:)
						(self dispose:)
					)
					(6
						(newsPaper show:)
						(gEgo
							normalize: 2 901
							ignoreActors: 1
							posn: 137 138
							getPoints: 146 1
						)
						(gGame handsOn:)
						(self dispose:)
					)
					(7
						(newsPaper show:)
						(gEgo
							normalize: 2 901
							ignoreActors: 1
							posn: 137 138
							getPoints: 147 1
						)
						(gGame handsOn:)
						(self dispose:)
					)
					(10
						(newsPaper show:)
						(gEgo
							normalize: 2 901
							ignoreActors: 1
							posn: 137 138
							getPoints: 148 1
						)
						(gGame handsOn:)
						(self dispose:)
					)
				)
			)
			(9
				(switch gDay
					(3
						(gMessager say: 35 12 18 4 self 211) ; "Lighten up!"
					)
				)
			)
			(10
				(switch gDay
					(3
						(gEgo setCel: 0 setLoop: 2 setCycle: End self)
					)
				)
			)
			(11
				(newsPaper show:)
				(gEgo
					normalize: 2 901
					ignoreActors: 1
					posn: 137 138
					getPoints: 143 1
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance timeToGoHome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= gNarrator GKNarrator)
				(if (graceProp script:)
					(graceProp setScript: 0)
				)
				(graceProp dispose:)
				(graceActor
					setCel: 0
					setLoop: 0
					init:
					setSpeed: 10
					setCycle: End self
				)
				(ClearFlag 10)
			)
			(1
				(if (== gDay 1)
					(gMessager sayRange: 11 0 50 1 2 self) ; "Well <yawn>, it's about closing time."
				else
					(gMessager sayRange: 11 0 49 1 2 self) ; "It's time to close shop."
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(graceActor
					setCel: 0
					setLoop: 1
					setSpeed: 8
					setPri: 132
					setCycle: End self
				)
			)
			(4
				(if (== gDay 1)
					(gMessager say: 11 0 50 3 self) ; "Good night, Gabriel. And try not to dream, okay?"
				else
					(= cycles 1)
				)
			)
			(5
				(graceActor setCel: 0 setLoop: 2 setCycle: End self)
			)
			(6
				(Face gEgo shopDoor)
				(graceActor
					view: 209
					setCel: 3
					setLoop: 3 1
					ignoreActors: 1
					setSpeed: 8
					setStep: 3 2
					posn: 203 127
					setCycle: Fwd
					setMotion: PolyPath 97 97 self
				)
				(if (!= gDay 1)
					(gMessager say: 11 0 49 3) ; "You, too. See you tomorrow."
				)
			)
			(7
				(gracesCoat dispose:)
				(graceActor
					view: 2091
					setCel: 0
					setLoop: 0
					posn: 101 95
					setSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(8
				(gGkSound1 number: 217 setLoop: 1 play:)
				(graceActor setCel: 4 setLoop: 0 setCycle: End self)
			)
			(9
				(graceActor setCel: 0 setLoop: 1 setCycle: End self)
			)
			(10
				(shopDoor dispose:)
				(gGkSound1 number: 373 setLoop: 1 play:)
				(graceActor
					setCel: 0
					setLoop: 2
					posn: 111 98
					setCycle: End self
				)
			)
			(11
				(gGkSound1 number: 374 setLoop: 1 play: self)
			)
			(12
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance graceDoStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(graceProp
					view: 208
					setCel: 0
					setLoop: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(1
				(graceProp
					view: 208
					setCel: 0
					setLoop: 1
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(2
				(= seconds 8)
			)
			(3
				(graceProp setCel: 0 setLoop: 2 setCycle: End self)
			)
			(4
				(= seconds 8)
			)
			(5
				(self changeState: 1)
			)
		)
	)
)

(instance talkToGrace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 235) (!= (gEgo y:) 127))
					(gEgo setMotion: PolyPath 235 127 self)
				else
					(self changeState: 2)
				)
			)
			(1
				(Face gEgo graceProp self)
			)
			(2
				(graceDoStuff dispose:)
				(graceProp
					view: 2111
					setCel: 8
					setLoop: 0
					cycleSpeed: 8
					setCycle: CT 5 -1 self
				)
			)
			(3
				(cond
					((== local5 10)
						(= local5 5)
					)
					((== (++ local5) 7)
						(++ local5)
					)
				)
				(switch gDay
					(2
						(if (IsFlag 383)
							(gMessager say: 1 11 local5 0 self)
						else
							(SetFlag 383)
							(gMessager say: 1 11 7 0 self) ; "Seen any good movies?"
						)
					)
					(6
						(if local0
							(= local0 0)
							(gMessager say: 1 11 3 0 self) ; "Are you okay?"
						else
							(gMessager say: 1 11 76 0 self) ; "(GK-AM2. SERIOUSLY CONTRITE.)I'm sorry I got you involved in this, Grace."
						)
					)
					(7
						(cond
							((and (not (IsFlag 385)) (not (IsFlag 357)))
								(SetFlag 385)
								(gMessager say: 1 11 4 0 self) ; "Grace, about last night...."
							)
							((and (not (IsFlag 423)) (not (IsFlag 269)))
								(gMessager say: 1 11 60 0 self) ; "Got any ideas, Grace?"
							)
							(else
								(SetFlag 423)
								(gMessager say: 1 11 62 0 self) ; "(TALKING ABOUT LEAVING FOR GERMANY)I'm really going, Grace."
							)
						)
					)
					(else
						(if local0
							(gMessager say: 1 11 2 0 self) ; "(BORED, CHATTY)So. What's new, Grace?"
						else
							(gMessager say: 1 11 local5 0 self)
						)
					)
				)
			)
			(4
				(= local0 0)
				(gGame handsOn:)
				(graceProp setScript: graceDoStuff)
				(self dispose:)
			)
		)
	)
)

(instance interrogateGrace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 235) (!= (gEgo y:) 127))
					(gEgo setMotion: PolyPath 235 127 self)
				else
					(self changeState: 2)
				)
			)
			(1
				(Face gEgo graceProp self)
			)
			(2
				(graceDoStuff dispose:)
				(graceProp
					view: 2111
					setCel: 8
					setLoop: 0
					cycleSpeed: 8
					setCycle: CT 5 -1 self
				)
			)
			(3
				(gMessager say: 1 10 0 0 self) ; "Gotta minute, Grace?"
			)
			(4
				(= global178 2)
				(gGame handsOn:)
				(gCurRoom newRoom: 50) ; interrogation
			)
		)
	)
)

(instance showGraceItem of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 220) (!= (gEgo y:) 130))
					(gEgo setMotion: PolyPath 220 130 self)
				else
					(self cue:)
				)
			)
			(1
				(Face gEgo graceProp self)
			)
			(2
				(gEgo view: 905 setCel: 0 setLoop: 4 setCycle: End self)
			)
			(3
				(graceDoStuff dispose:)
				(graceProp
					view: 2111
					setCel: 8
					setLoop: 0
					cycleSpeed: 8
					setCycle: CT 5 -1 self
				)
			)
			(4
				(cond
					((== local6 16)
						(if (IsFlag 36)
							(gMessager say: 1 16 66 0 self) ; "Do you know anything about this?"
						else
							(gMessager say: 1 16 65 0 self) ; "Do you know anything about this?"
						)
					)
					((== local6 79)
						(gMessager say: 1 79 67 0 self) ; "Like my badge?"
					)
					(
						(OneOf
							local6
							32
							18
							129
							5
							50
							37
							72
							4
							41
							86
							56
							3
							49
							64
							74
							73
							44
							61
							38
							17
						)
						(gMessager say: 1 local6 0 0 self)
					)
					(else
						(gMessager say: 1 0 0 0 self) ; "Do you know anything about this?"
					)
				)
			)
			(5
				(graceProp setScript: graceDoStuff)
				(gEgo normalize: 6 901 ignoreActors: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getTheObject of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 218 165 self)
			)
			(1
				(graceDoStuff dispose:)
				(Face gEgo graceProp self)
			)
			(2
				(graceProp
					view: 2111
					setCel: 8
					setLoop: 0
					cycleSpeed: 8
					setCycle: CT 5 -1 self
				)
			)
			(3
				(if (== local6 tweezers)
					(gMessager say: 39 12 0 0 self 211) ; "I'm going to take the tweezers for a bit."
				else
					(gMessager say: 32 12 0 0 self 211) ; "Mind if I borrow the magnifying glass?"
				)
			)
			(4
				(Face gEgo local6 self)
			)
			(5
				(gEgo view: 2152 setCel: 0 setLoop: 0 setCycle: CT 2 1 self)
			)
			(6
				(graceProp setScript: graceDoStuff)
				(local6 dispose:)
				(gEgo view: 2152 setCel: 3 setLoop: 0 setCycle: End self)
			)
			(7
				(if (== local6 tweezers)
					(gEgo get: 3 getPoints: 117 1) ; tweezers
				else
					(gEgo get: 4 getPoints: 118 1) ; magGlass
				)
				(gGame handsOn:)
				(gEgo normalize: 1 901 ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance exitToGabsRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 288 105 self)
			)
			(1
				(gEgo
					view: 220
					setCel: 0
					setLoop: 0
					posn: 289 108
					setCycle: End self
				)
				(gGkSound1 number: 215 setLoop: 1 play:)
			)
			(2
				(gCurRoom newRoom: 220)
			)
		)
	)
)

(instance openTheRegister of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gEgo inRect: 62 117 114 141)
					(gEgo setMotion: PolyPath 148 127 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath 241 123 self)
			)
			(2
				(Face gEgo (ScriptID 215 10) self) ; xcashRegister
			)
			(3
				(if (not (IsFlag 53))
					(SetFlag 53)
					(gMessager say: 13 6 9 0 self 211) ; "(RRCC. SARCASTIC)Gabriel opens the cash register to examine the take. Or, in the case of St. George's Books, the MIStake."
				else
					(gMessager say: 13 6 10 0 self 211) ; "Gabriel checks the drawer again, just in case life as we know it changed significantly since he last looked."
				)
			)
			(4
				(gEgo view: 216 setLoop: 1 setCel: 0 setCycle: CT 6 1 self)
			)
			(5
				(gGkSound1 number: 211 setLoop: 1 play:)
				(gEgo view: 216 setLoop: 1 setCel: 7 setCycle: End self)
			)
			(6
				(gGame handsOn:)
				(drawer init: self bookstore 1)
			)
			(7
				(gGame handsOff:)
				(cond
					(local1
						(gMessager say: 23 12 0 0 self 211) ; "I trust you can live without this old gift certificate?"
						(gEgo get: 5 getPoints: 122 1) ; giftCert
						(= local1 0)
					)
					((IsFlag 368)
						(if (IsFlag 6)
							(gMessager say: 21 12 8 0 self 211) ; ""(ARCC)Gabriel, that's all the change money I have. Touch it, and you can kiss your hand good-bye!"
						else
							(gMessager say: 21 12 12 0 self 211) ; "If I need any legal tender where I'm going, it will more likely be my soul."
						)
					)
					((IsFlag 369)
						(gMessager say: 22 6 0 0 self 211) ; "!!!Comment msg"
						(ClearFlag 369)
					)
					(else
						(self cue:)
					)
				)
			)
			(8
				(if (IsFlag 368)
					(self changeState: 6)
					(ClearFlag 368)
				else
					(self cue:)
				)
			)
			(9
				(gEgo setLoop: 2 setCel: 0 setCycle: CT 1 1 self)
			)
			(10
				(gGkSound1 number: 212 setLoop: 1 play:)
				(gEgo setLoop: 2 setCel: 2 setCycle: End self)
			)
			(11
				(if (IsFlag 6)
					(graceProp setScript: graceDoStuff)
				)
				(gGame handsOn:)
				(gEgo normalize: 1 901 ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance takeTheCertificate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(giftCertificate hide:)
				(= local1 1)
				(= cycles 10)
			)
			(1
				(gGame handsOff:)
				(drawer dispose:)
				(self dispose:)
			)
		)
	)
)

(instance comeFromStudio of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 10)
				(gEgo normalize: 2 901 ignoreActors: 1 posn: 296 113)
				(gGame handsOn:)
				(if (and (IsFlag 269) (not (IsFlag 262)))
					(gCurRoom setScript: (ScriptID 213 1)) ; tellAboutGermany
				)
				(self dispose:)
			)
		)
	)
)

(instance egoAndMalia of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= gNarrator GKNarrator)
				(windows init:)
				(behindDoor init:)
				(gEgo setScript: (ScriptID 212 4) self) ; endOfDay3
			)
			(1
				(= cycles 2)
			)
			(2
				(DisposeScript 212)
				(SetFlag 305)
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance hangUpCoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(shopDoor dispose:)
				(gabsCoat hide:)
				(gEgo
					view: 219
					setCel: 0
					setLoop: 2 1
					posn: 101 93
					setCycle: End self
				)
				(gGkSound1 number: 373 setLoop: 1 play:)
			)
			(1
				(shopDoor init:)
				(gGkSound1 number: 374 setLoop: 1 play:)
				(gEgo setCel: 0 setLoop: 3 posn: 88 97 setCycle: End self)
			)
			(2
				(gabsCoat show:)
				(gEgo
					normalize: 0 901
					ignoreActors: 1
					setMotion: MoveTo 98 97 self
				)
			)
			(3
				(cond
					((and (== gDay 7) (IsFlag 357) (not (IsFlag 356)))
						(gCurRoom setScript: (ScriptID 213 2)) ; afterTheBody
						(self dispose:)
					)
					((== gDay 10)
						(if (not (IsFlag 473))
							(gEgo
								view: 2100
								setLoop: 2
								setCel: 0
								cycleSpeed: 10
								setCycle: Osc 1 self
							)
							(gMessager say: 11 0 46 0) ; "(RRCC. WARM, THEN CONCEREND.)Grace, I'm home!"
						else
							(= cycles 1)
						)
					)
					(else
						(= cycles 3)
						(if (and (== gDay 5) (not (IsFlag 10)))
							(graceDoStuff dispose:)
							(graceProp
								view: 208
								setCel: 4
								setLoop: 0
								cycleSpeed: 8
								setCycle: Beg
							)
						)
					)
				)
			)
			(4
				(if (== gDay 10)
					(gEgo normalize: 4 901 ignoreActors: 1)
					(SetFlag 473)
					(gGame handsOn:)
					(self dispose:)
				else
					(gMessager say: 11 0 47 (Random 1 5) self)
				)
			)
			(5
				(gMessager say: 11 0 48 (Random 1 5) self)
				(if (and (== gDay 5) (not (IsFlag 10)))
					(graceProp
						view: 2111
						setCel: 0
						setLoop: 0
						setCycle: ROsc -1 0 4
					)
				)
			)
			(6
				(if (and (== gDay 5) (not (IsFlag 10)))
					(graceProp setCel: 0 setCycle: 0)
				else
					(self cue:)
				)
			)
			(7
				(gEgo normalize: 0 901 ignoreActors: 1)
				(graceProp setScript: graceDoStuff)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance putTheCoatOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(== gDay 6)
						(not (IsFlag 306))
						(not (gEgo has: 27)) ; keyEnvelope
						(not (gEgo has: 28)) ; mosKey
					)
					(envelopeTimer client: 0)
					(envelopeTimer dispose: delete:)
					(gCurRoom setScript: dropTheEnvelope)
					(self dispose:)
				else
					(gGame handsOff:)
					(gEgo setMotion: PolyPath 93 96 self)
					(Load rsVIEW 219)
				)
			)
			(1
				(Load rsVIEW 900)
				(Face gEgo gabsCoat self)
			)
			(2
				(gabsCoat hide:)
				(gEgo view: 219 setCel: 0 setLoop: 0 setCycle: CT 3 1 self)
			)
			(3
				(gEgo setCel: 4 setLoop: 0 setCycle: End self)
				(gGkSound1 number: 217 setLoop: 1 play:)
			)
			(4
				(gEgo normalize: 1 900 ignoreActors: 1)
				(= cycles 1)
			)
			(5
				(if (== gDay 10)
					(self changeState: 9)
				else
					(Face gEgo graceProp self)
				)
			)
			(6
				(= cycles 2)
			)
			(7
				(cond
					((== gDay 7)
						(if (IsFlag 269)
							(gMessager say: 11 0 70 0 self) ; "Good-bye, Gracie."
						else
							(gMessager say: 11 0 69 0 self) ; "I'm going out for a bit."
						)
					)
					((and (== gDay 6) (not (IsFlag 254)))
						(gMessager say: 38 6 23 0 self 211) ; "Are you going to be okay here by yourself?"
					)
					(else
						(gMessager say: 38 6 24 (Random 1 5) self 211)
					)
				)
			)
			(8
				(cond
					((and (== gDay 6) (not (IsFlag 254)))
						(self cue:)
					)
					((!= gDay 7)
						(gMessager say: 38 6 25 (Random 1 5) self 211)
					)
					(else
						(self cue:)
					)
				)
			)
			(9
				(Face gEgo shopDoor self)
			)
			(10
				(shopDoor dispose:)
				(gEgo
					view: 219
					setCel: 0
					setLoop: 1
					cycleSpeed: 6
					setCycle: CT 1 1 self
				)
			)
			(11
				(gGkSound1 number: 373 setLoop: 1 play:)
				(gEgo
					setCel: 2
					setLoop: 1
					cycleSpeed: 6
					setCycle: CT 8 1 self
				)
			)
			(12
				(gEgo
					view: 219
					setCel: 9
					setLoop: 1
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(13
				(gGkSound1 number: 374 setLoop: 1 play: self)
				(gEgo hide:)
				(shopDoor init:)
			)
			(14
				(gEgo normalize:)
				(gEgo hide:)
				(= cycles 1)
			)
			(15
				(if (or (== gDay 1) (== gDay 6))
					(SetFlag 254)
				)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance doTheTattoo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScript: (ScriptID 213 0) self) ; theTatooStuff
			)
			(1
				(= cycles 2)
			)
			(2
				(DisposeScript 213)
				(if (IsFlag 335)
					(self dispose:)
					(graceProp setScript: graceDoStuff)
				else
					(gCurRoom newRoom: 220)
				)
			)
		)
	)
)

(instance readMaliasNote of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: (ScriptID 212 2) self) ; getNote
			)
			(1
				(if (not (IsFlag 389))
					(gCurRoom newRoom: 220)
				)
				(SetFlag 389)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getTheEnvelope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 118 100 self)
			)
			(1
				(gEgo view: 2192 setCel: 0 setLoop: 0 setCycle: CT 4 1 self)
			)
			(2
				(gMessager say: 34 12 0 0 self 211) ; "It's just an envelope."
				(envelope dispose:)
				(gEgo setCel: 5 setCycle: End self)
			)
			(3)
			(4
				(graceProp setScript: graceDoStuff)
				(gEgo
					normalize: 1 901
					ignoreActors: 1
					get: 27 ; keyEnvelope
					getPoints: -999
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dropTheEnvelope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theShadow init: setCycle: End self)
			)
			(1
				(theShadow dispose:)
				(envelope init: setCycle: End self)
			)
			(2
				(Face gEgo envelope self)
			)
			(3
				(gMessager say: 11 0 56 0 self 210) ; "(SCARED)Gabriel!"
			)
			(4
				(SetFlag 306)
				(envelopeTimer client: 0)
				(envelopeTimer dispose: delete:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getReferenceBooks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 74 106 self)
			)
			(1
				(gEgo view: 521 setLoop: 3 setCel: 0 setCycle: CT 2 1 self)
			)
			(2
				(gGkSound1 number: 218 setLoop: 1 play:)
				(gEgo view: 521 setLoop: 3 setCel: 3 setCycle: End self)
			)
			(3
				(if (== global177 8)
					(= global177 2)
				)
				(gMessager say: 7 12 0 1 self 211) ; "(GK-AM2)Gabriel leafs through a German-English dictionary...."
			)
			(4
				(gMessager say: 7 12 0 global177 self 211)
			)
			(5
				(gEgo view: 521 setLoop: 3 setCel: 7 setCycle: CT 4 -1 self)
			)
			(6
				(gEgo view: 521 setLoop: 3 setCel: 3 setCycle: Beg self)
				(gGkSound1 number: 218 setLoop: 1 play:)
			)
			(7
				(gEgo normalize: 1 901 ignoreActors: 1)
				(++ global177)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance drawer of Inset
	(properties
		view 216
		x 141
		y 27
		disposeNotOnMe 1
		modNum 211
	)

	(method (init)
		(self priority: 12)
		(super init: &rest)
		(if (not (IsFlag 122))
			(giftCertificate init:)
		)
		(UpdatePlane plane)
		(FrameOut)
		((ScriptID 215 25) init:) ; xmoney
		((ScriptID 215 26) init:) ; xallElse
	)

	(method (dispose)
		(if (gCast contains: giftCertificate)
			(giftCertificate dispose:)
		)
		((ScriptID 215 25) dispose:) ; xmoney
		((ScriptID 215 26) dispose:) ; xallElse
		(super dispose:)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
	)
)

(instance graceActor of Actor
	(properties
		x 251
		y 115
		view 209
	)
)

(instance graceProp of Prop
	(properties
		noun 1
		sightAngle 50
		x 251
		y 115
		view 211
		signal 4129
	)

	(method (doVerb theVerb)
		(if
			(or
				(== theVerb 7) ; Look
				(== theVerb 8) ; Operate
				(== theVerb 9) ; Move
				(== theVerb 12) ; Pickup
				(== theVerb 6) ; Open
			)
			(super doVerb: theVerb)
		else
			(= local6 theVerb)
			(switch theVerb
				(11 ; Talk
					(gEgo setScript: talkToGrace)
				)
				(10 ; Ask
					(gEgo setScript: interrogateGrace)
				)
				(30 ; tatooTrace
					(cond
						((IsFlag 299)
							(gMessager say: noun theVerb 74 0) ; "(GK-AM2)Grace would probably start screaming if Gabriel mentioned that tattoo again."
						)
						((not (== gDay 6))
							(gMessager say: noun theVerb 13 0) ; "(RRCC. RERECORD. EMPHASIZE 'COULD')Hmmm. Gabriel could ask Grace to use her paints and put the tattoo on his chest, but he should wait until he's ready to use it. It would probably wash off in the shower."
						)
						(else
							(ClearFlag 335)
							(gCurRoom setScript: doTheTattoo)
						)
					)
				)
				(79 ; badge
					(if (IsFlag 337)
						(gMessager say: noun theVerb 64 0) ; "Grace wasn't amused the first time around."
					else
						(SetFlag 337)
						(gEgo setScript: showGraceItem)
					)
				)
				(else
					(gEgo setScript: showGraceItem)
				)
			)
		)
	)
)

(instance shopDoor of Prop
	(properties
		noun 38
		modNum 211
		sightAngle 20
		x 93
		y 88
		loop 1
	)

	(method (init)
		(self view: (if (IsHiRes) 10210 else 210))
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(gEgo setScript: putTheCoatOn)
			)
			(8 ; Operate
				(gEgo setScript: putTheCoatOn)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance envelope of Prop
	(properties
		noun 34
		modNum 211
		x 78
		y 89
		z 25
		view 2192
		loop 1
		signal 20513
	)

	(method (init)
		(super init:)
		(self setPri: 90)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(gEgo setScript: getTheEnvelope)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theShadow of Prop
	(properties
		x 73
		y 42
		view 2192
		loop 2
		signal 16417
	)

	(method (init)
		(super init:)
		(self setPri: 89)
	)
)

(instance windows of Prop
	(properties
		y 77
		view 2103
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 13)
	)
)

(instance behindDoor of Prop
	(properties
		x 71
		y 48
		view 2103
		loop 1
		cel 1
	)

	(method (init)
		(super init:)
		(self setPri: 6)
	)
)

(instance gabsCoat of View
	(properties
		noun 16
		modNum 211
		sightAngle 20
		x 104
		y 63
		cel 1
	)

	(method (init)
		(self view: (if (IsHiRes) 10210 else 210))
		(super init:)
	)
)

(instance gracesCoat of View
	(properties
		noun 17
		modNum 211
		sightAngle 20
		approachX 140
		approachY 88
		x 111
		y 60
	)

	(method (init)
		(self view: (if (IsHiRes) 10210 else 210))
		(super init:)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 11 10) ; Talk, Ask
			(super doVerb: theVerb)
		else
			(switch theVerb
				(7 ; Look
					(if (IsFlag 6)
						(gMessager say: noun theVerb 8 0 0 211) ; "Grace's coat is a simple, but classic, trench coat. Gabriel hates people with good taste."
					else
						(gMessager say: noun theVerb 12 0 0 211) ; "Wherever Grace is, she's not wearing her coat."
					)
				)
				(8 ; Operate
					(if (not (IsFlag 6))
						(gMessager say: noun theVerb 12 0 0 211) ; "Messing with Grace's coat would not solve anything."
					else
						(gMessager say: noun theVerb 8 0 0 211) ; "Leave my coat alone, Gabriel."
					)
				)
				(12 ; Pickup
					(if (not (IsFlag 6))
						(gMessager say: noun theVerb 12 0 0 211) ; "Gabriel considers taking Grace's coat with him, but he decides against it."
					else
						(gMessager say: noun theVerb 8 0 0 211) ; "Leave my coat alone, Gabriel."
					)
				)
				(else
					(cond
						((OneOf theVerb 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
							(if (not (IsFlag 6))
								(gMessager say: noun theVerb 12 0 0 211)
							else
								(gMessager say: noun theVerb 8 0 0 211)
							)
						)
						((not (IsFlag 6))
							(gMessager say: noun 0 12 0 0 211) ; "Messing with Grace's coat would not solve anything."
						)
						(else
							(gMessager say: noun 0 8 0 0 211) ; "Leave my coat alone, Gabriel."
						)
					)
				)
			)
		)
	)
)

(instance newsPaper of View
	(properties
		noun 35
		modNum 211
		sightAngle 20
		x 136
		y 154
		z 31
		cel 2
	)

	(method (init)
		(self view: (if (IsHiRes) 10210 else 210))
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(switch gDay
					(2
						(gEgo setScript: (ScriptID 211 3)) ; readIt2
					)
					(4
						(gEgo setScript: (ScriptID 214 3)) ; readIt4
					)
					(else
						(gGame handsOff:)
						(gEgo setScript: getTheNewsPaper)
					)
				)
			)
			(7 ; Look
				(if (== gDay 10)
					(gMessager say: noun theVerb 15 0 0 211) ; "It's today's. I wonder who brought it in?"
				else
					(gMessager say: noun theVerb 0 0 0 211) ; "Today's newspaper is on the counter."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance magnifyingGlass of View
	(properties
		noun 32
		modNum 211
		sightAngle 20
		x 195
		y 137
		cel 4
	)

	(method (init)
		(self view: (if (IsHiRes) 10210 else 210))
		(self setPri: 155)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb 0 0 0 211) ; "The magnifying glass is a handy item for reading old manuscripts or the fine print on Gabriel's lease."
			)
			(12 ; Pickup
				(= local6 self)
				(gEgo setScript: getTheObject)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tweezers of View
	(properties
		noun 39
		modNum 211
		sightAngle 20
		x 202
		y 132
		cel 5
	)

	(method (init)
		(self view: (if (IsHiRes) 10210 else 210))
		(self setPri: 155)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(= local6 self)
				(gEgo setScript: getTheObject)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance coffeePot of View
	(properties
		noun 19
		modNum 211
		sightAngle 10
		x 94
		y 117
		cel 6
	)

	(method (init)
		(self view: (if (IsHiRes) 10210 else 210))
		(super init: &rest)
		(self setPri: 148)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(if (not (IsFlag 367))
					(SetFlag 367)
					(gCurRoom setScript: (ScriptID 211 4)) ; getSomeCoffee
				else
					(gMessager say: noun 12 14 1 0 211) ; "My kidneys are already floating, thanks."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chair of View
	(properties
		noun 14
		modNum 211
		x 258
		y 101
		cel 9
		signal 4129
	)

	(method (init)
		(self view: (if (IsHiRes) 10210 else 210))
		(super init:)
		(if (== gDay 10)
			(self posn: 260 114 setPri: 8 cel: 10)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (== gDay 10)
					(gMessager say: noun theVerb 11 0 0 211) ; "Grace's chair looks hastily abandoned."
				else
					(gMessager say: noun theVerb 0 0 0 211) ; "Grace's chair. Gabriel's had occasion to envy it."
				)
			)
			(12 ; Pickup
				(if (== gDay 10)
					(gMessager say: noun theVerb 11 0 0 211) ; "There's no point in moving the chair now."
				else
					(gMessager say: noun theVerb 0 0 0 211) ; "Real funny, Knight."
				)
			)
			(9 ; Move
				(if (== gDay 10)
					(gMessager say: noun theVerb 11 0 0 211) ; "There's no point in moving the chair now."
				else
					(gMessager say: noun theVerb 0 0 0 211) ; "Real funny, Knight."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gabsMug of View
	(properties
		modNum 211
		x 118
		y 115
		cel 7
	)

	(method (init)
		(self view: (if (IsHiRes) 10210 else 210))
		(self
			setPri: 148
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 113 112 125 113 125 119 114 119
					yourself:
				)
		)
		(super init:)
	)
)

(instance painting of View
	(properties
		noun 36
		modNum 211
		sightAngle 20
		approachX 271
		approachY 120
		x 269
		y 48
		cel 8
		signal 4129
	)

	(method (init)
		(self view: (if (IsHiRes) 10210 else 210))
		(self approachVerbs: 9 6 12 11) ; Move, Open, Pickup, Talk
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (== gDay 10)
					(gMessager say: noun theVerb 33 0 0 211) ; "(RRCC. WARM)Daddy's painting. I bet Grace bought it back from Bruno herself."
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

(instance ashTray of View
	(properties
		noun 2
		modNum 211
		sightAngle 20
		x 227
		y 81
		cel 3
	)

	(method (init)
		(self view: (if (IsHiRes) 10210 else 210))
		(super init:)
		(self setPri: 120)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 321)
					(gMessager say: noun theVerb 2 0 0 211) ; "There's something in the ashtray."
				else
					(gMessager say: noun theVerb 1 0 0 211) ; "It's an ashtray."
				)
			)
			(4 ; magGlass
				(if (IsFlag 321)
					(gEgo setScript: (ScriptID 212 8)) ; lookAtScale
				else
					(gMessager say: noun theVerb 1 0 0 211) ; "There's no point in magnifying the empty ashtray."
				)
			)
			(12 ; Pickup
				(if (IsFlag 321)
					(gMessager say: noun theVerb 2 0 0 211) ; "The item in the ashtray is too small to pick up by hand."
				else
					(gMessager say: noun theVerb 1 0 0 211) ; "Gabriel doesn't need the ashtray."
				)
			)
			(3 ; tweezers
				(if (IsFlag 321)
					(gEgo setScript: (ScriptID 212 7)) ; getScale
				else
					(gMessager say: noun theVerb 1 0 0 211) ; "Why use the tweezers on the empty ashtray?"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance artSupplies of View
	(properties
		noun 1
		modNum 211
		sightAngle 20
		x 279
		y 103
		cel 11
	)

	(method (init)
		(self view: (if (IsHiRes) 10210 else 210))
		(super init:)
	)
)

(instance giftCertificate of View
	(properties
		noun 23
		modNum 211
		x 35
		y 52
		view 216
		cel 1
		signal 4129
	)

	(method (init)
		(self setPri: 13)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(drawer setScript: takeTheCertificate)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance maliasNote of View
	(properties
		noun 33
		modNum 211
		sightAngle 20
		x 225
		y 100
		z 6
		cel 12
	)

	(method (init)
		(self view: (if (IsHiRes) 10210 else 210))
		(super init:)
		(self setPri: 120)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(gCurRoom setScript: readMaliasNote)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theWatcher of View
	(properties
		noun 40
		modNum 211
		sightAngle 20
		approachX 60
		approachY 116
		x 32
		y 119
		view 2101
		loop 3
	)

	(method (init)
		(super init:)
		(self setPri: 6 approachVerbs: 11 10) ; Talk, Ask
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					((== gDay 5)
						(if (IsFlag 263)
							(gMessager say: noun theVerb 32 0 0 211) ; "Gabriel watches the man watching the shop."
						else
							(gMessager say: noun theVerb 31 0 0 211) ; "This guy is really starting to bug me."
						)
					)
					((IsFlag 360)
						(gMessager say: noun theVerb 30 0 0 211) ; "Gabriel watches the man watching the shop."
					)
					((IsFlag 263)
						(gMessager say: noun theVerb 29 0 0 211) ; "He's still there. I wish he'd move or something."
						(SetFlag 360)
					)
					(else
						(SetFlag 263)
						(gMessager say: noun theVerb 28 0 0 211) ; "Have you noticed this guy outside the shop?"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

