;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 430)
(include sci.sh)
(use Main)
(use n013)
(use ExitFeature)
(use PFollow)
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
	seJackson 0
)

(local
	local0
)

(instance seJackson of Room
	(properties
		modNum 401
		noun 8
		picture 430
		style 14
		exitStyle 13
		horizon 30
		north 410
		south 200
		west 440
		vanishingY 35536
	)

	(method (init)
		(super init:)
		(if (!= gPrevRoomNum 400)
			(gGkMusic1
				number: 430
				loop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 5 10 0
			)
		)
		(self setRegions: 401) ; JacksonSq
		(if (!= gPrevRoomNum 400)
			(gEgo
				view: 902
				setLooper: (ScriptID 401 2) ; xSmallStopGroop
				setStep: 2 1
				setCycle: StopWalk -1
				init:
				state: 2
			)
		else
			(gCurRoom setScript: (ScriptID 402 0) 0 0) ; sBinoc
		)
		(switch gPrevRoomNum
			(440 ; swJackson
				(if (and (IsFlag 328) (== ((ScriptID 401 7) room:) gCurRoomNum)) ; xCrash
					((ScriptID 401 7) ; xCrash
						posn: 142 90
						destX: 135
						destY: 20
						destRoom: 410
						init:
					)
				)
				(gEgo
					posn: 5 (gEgo y:)
					setMotion: PolyPath 20 (gEgo y:)
				)
				(if (IsFlag 102)
					((ScriptID 401 1) posn: 5 (gEgo y:)) ; xMime
				)
			)
			(410 ; neJackson
				(if (and (IsFlag 328) (== ((ScriptID 401 7) room:) gCurRoomNum)) ; xCrash
					((ScriptID 401 7) ; xCrash
						posn: 120 110
						destX: -20
						destY: 100
						destRoom: 440
						init:
					)
				)
				(if (> (gEgo x:) 304)
					(gEgo x: 300)
				)
				(gEgo
					posn: (gEgo x:) 31
					setMotion: PolyPath (gEgo x:) 40
				)
				(if (IsFlag 102)
					((ScriptID 401 1) posn: (gEgo x:) 31) ; xMime
				)
			)
			(200
				(if (IsFlag 328)
					((ScriptID 401 7) ; xCrash
						posn: 142 70
						destX: 145
						destY: 20
						destRoom: 410
						init:
					)
				)
				(gEgo posn: 13 140 setMotion: PolyPath 13 130)
			)
			(else
				(gEgo posn: 13 140)
			)
		)
		(if (and (IsFlag 102) (== gDay 1))
			((ScriptID 401 1) ; xMime
				code: specialMimeCode
				setCycle: StopWalk 422
				setMotion: PFollow gEgo 15
				setPri: -1
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 90 1 90 25 82 31 72 36 43 44 27 47 0 47 0 147 23 146 24 140 123 140 154 139 189 129 227 116 259 99 283 76 299 52 306 30 306 1
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 156 48 179 40 180 37 202 38 207 43 216 46 221 57 148 57
					yourself:
				)
		)
		(bush init:)
		(guitar setCycle: RandCycle init:)
		(harmonica setCycle: RandCycle init:)
		(spoons setCycle: Fwd init:)
		(ClearFlag 239)
		(switch gDay
			(1
				(if (IsFlag 66)
					(radio init: approachVerbs: 8) ; Operate
					(cop
						init:
						approachVerbs:
							10 ; Ask
							11 ; Talk
							79 ; badge
							116 ; BoarMask
							125 ; bones
							130 ; records or bookTribe
							43 ; braceMold_
							42 ; braceRep_
							66 ; brick
							32 ; hundred
							104 ; chamPot
							28 ; clay
							1 ; ???
							31 ; crocMask
							15 ; sketchBook
							34 ; lostDrawing
							18 ; drumBook
							129 ; lit_flash
							22 ; fortScale_
							46 ; oil
							105 ; scroll
							5 ; giftCert
							50 ; gradPhoto
							37 ; guntJournal
							72 ; hair_gel
							19 ; hartNotes
							87 ; ???
							123 ; hounfourKey
							20 ; lakeScale
							23 ; sLakePatter
							115 ; lotsCash
							33 ; luckyDog_
							4 ; magGlass
							121 ; BoarGuise
							120 ; WolfGuise
							21 ; snakeSkin_
							86 ; master_card
							56 ; keyEnvelope
							44 ; mosKey
							17 ; murderPhoto
							26 ; musScale
							41 ; news1810
							61 ; mosLetter
							49 ; phonePage
							67 ; phoEnvelope
							48 ; policeVeve_
							24 ; veveCopy
							64 ; collar_
							58 ; invRead
							101 ; knife
							14 ; ritLetter
							39 ; ritPhoto_
							122 ; BoarRobe or WolfRobe
							106 ; salt
							107 ; scissors
							73 ; disguise
							74 ; shirt
							60 ; signalDev_ or signalDev2_
							108 ; wolfKey
							84 ; bookSnkMnd
							76 ; rod
							88 ; tile
							124 ; talisman
							30 ; tatooTrace
							80 ; ???
							81 ; ???
							98 ; tile10
							99 ; tile11
							89 ; tile1
							90 ; tile2
							91 ; tile3
							92 ; tile4
							93 ; tile5
							94 ; tile6
							95 ; ???
							96 ; tile8
							97 ; tile9
							70 ; ???
							45 ; tracker
							3 ; tweezers
							51 ; twoScales
							16 ; reconVeve_
							40 ; VoodooCode1
							59 ; sVoodooCode
							36 ; wolfLetter
							114 ; WolfMask
							38 ; wolfPhone
						setScript: sCopStuff
					)
					(copHead
						init:
						approachVerbs:
							10 ; Ask
							11 ; Talk
							79 ; badge
							116 ; BoarMask
							125 ; bones
							130 ; records or bookTribe
							43 ; braceMold_
							42 ; braceRep_
							66 ; brick
							32 ; hundred
							104 ; chamPot
							28 ; clay
							1 ; ???
							31 ; crocMask
							15 ; sketchBook
							34 ; lostDrawing
							18 ; drumBook
							129 ; lit_flash
							22 ; fortScale_
							46 ; oil
							105 ; scroll
							5 ; giftCert
							50 ; gradPhoto
							37 ; guntJournal
							72 ; hair_gel
							19 ; hartNotes
							87 ; ???
							123 ; hounfourKey
							20 ; lakeScale
							23 ; sLakePatter
							115 ; lotsCash
							33 ; luckyDog_
							4 ; magGlass
							121 ; BoarGuise
							120 ; WolfGuise
							21 ; snakeSkin_
							86 ; master_card
							56 ; keyEnvelope
							44 ; mosKey
							17 ; murderPhoto
							26 ; musScale
							41 ; news1810
							61 ; mosLetter
							49 ; phonePage
							67 ; phoEnvelope
							48 ; policeVeve_
							24 ; veveCopy
							64 ; collar_
							58 ; invRead
							101 ; knife
							14 ; ritLetter
							39 ; ritPhoto_
							122 ; BoarRobe or WolfRobe
							106 ; salt
							107 ; scissors
							73 ; disguise
							74 ; shirt
							60 ; signalDev_ or signalDev2_
							108 ; wolfKey
							84 ; bookSnkMnd
							76 ; rod
							88 ; tile
							124 ; talisman
							30 ; tatooTrace
							80 ; ???
							81 ; ???
							98 ; tile10
							99 ; tile11
							89 ; tile1
							90 ; tile2
							91 ; tile3
							92 ; tile4
							93 ; tile5
							94 ; tile6
							95 ; ???
							96 ; tile8
							97 ; tile9
							70 ; ???
							45 ; tracker
							3 ; tweezers
							51 ; twoScales
							16 ; reconVeve_
							40 ; VoodooCode1
							59 ; sVoodooCode
							36 ; wolfLetter
							114 ; WolfMask
							38 ; wolfPhone
						setPri: (cop priority:)
					)
					(bike init: setScript: sRadio)
					(gWalkHandler add: cop radio bike)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 28 126 77 126 78 133 26 133
								yourself:
							)
					)
				)
			)
		)
		(lamp init:)
		(tree init:)
		(trash init:)
		(sidewalk init:)
		(fence init:)
		(westExit init:)
		(northExit init:)
		(southExit init:)
	)

	(method (doit)
		(if
			(and
				(== gDay 1)
				(IsFlag 66)
				(not local0)
				(not script)
				(or (gEgo inRect: 0 41 3 135) (gEgo inRect: 87 21 312 35))
			)
			(self setScript: sGabeExits)
		)
		(super doit:)
	)

	(method (dispose)
		(if (IsFlag 66)
			(gWalkHandler delete: cop radio bike)
		)
		(if (and (== (gEgo edgeHit:) EDGE_BOTTOM) (IsFlag 102))
			(ClearFlag 102)
		)
		(if (!= gPrevRoomNum 400)
			(gGkMusic1 fade:)
		)
		(mimeTimer4 client: 0 dispose: delete:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (== gPrevRoomNum 400)
			(cond
				((event claimed:) 0)
				((== (event type:) evMOUSEBUTTON)
					((ScriptID 402 0) cue:) ; sBinoc
					(event claimed: 1)
				)
				((== (event type:) evMOUSERELEASE)
					(event claimed: 1)
				)
				((== (event type:) evKEYBOARD)
					(event claimed: 1)
				)
				(else
					(event claimed: 1)
				)
			)
			(super handleEvent: event &rest)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (reflectPosn param1 param2 &tmp temp0)
		(switch param2
			(1
				(param1 y: 136)
			)
			(4
				(param1 x: (- 319 (param1 xStep:)))
			)
		)
	)
)

(instance sGabeExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(cop setScript: sCopReturns self 0)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAnnoyBlues of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mimeTimer4 setReal: mimeTimer4 20)
				((ScriptID 401 1) ; xMime
					view: 422
					setSpeed: 6
					setCycle: StopWalk 422
					setPri: -1
					setMotion: PolyPath 175 65 self
				)
				(gEgo setMotion: PolyPath 200 65)
			)
			(1
				((ScriptID 401 1) ; xMime
					setSpeed: 12
					view: 436
					setCel: 0
					setLoop: 0
					setCycle: End self
				)
			)
			(2
				((ScriptID 401 1) setCel: 0 setLoop: 1 setCycle: Fwd) ; xMime
				(= seconds 4)
			)
			(3
				((ScriptID 401 1) setCel: 0 setLoop: 2 setCycle: End self) ; xMime
			)
			(4
				((ScriptID 401 1) setCel: 0 setLoop: 3 setCycle: Osc) ; xMime
				(= seconds 4)
			)
			(5
				((ScriptID 401 1) setCel: 6 setLoop: 2 setCycle: End self) ; xMime
			)
			(6
				(self changeState: (Random 2 3))
			)
		)
	)
)

(instance sCopStuff of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(cond
					((< (= temp0 (Random 1 100)) 75)
						(self changeState: 1)
					)
					((< 76 temp0 90)
						(self changeState: 3)
					)
					((< 91 temp0 99)
						(self changeState: 5)
					)
					(else
						(self changeState: 7)
					)
				)
			)
			(1
				(copHead setCycle: Fwd show:)
				(cop setCel: 0 setLoop: 5)
				(UpdateScreenItem cop)
				(= seconds 3)
			)
			(2
				(self changeState: 0)
			)
			(3
				(cop setCel: 0 setLoop: 1 setCycle: End self)
				(UpdateScreenItem cop)
				(copHead hide:)
			)
			(4
				(self changeState: 0)
			)
			(5
				(copHead hide:)
				(cop setCel: 0 setLoop: 2 setCycle: End self)
				(UpdateScreenItem cop)
			)
			(6
				(self changeState: 0)
			)
			(7
				(copHead hide:)
				(cop setCel: 0 setLoop: 4 setCycle: End self)
				(UpdateScreenItem cop)
			)
			(8
				(= seconds 3)
			)
			(9
				(copHead hide:)
				(cop setCycle: Beg self)
				(UpdateScreenItem cop)
			)
			(10
				(self changeState: 0)
			)
		)
	)
)

(instance sAnnoyCop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(gEgo setMotion: PolyPath 100 140 self)
				((ScriptID 401 1) ; xMime
					view: 422
					setCycle: StopWalk 422
					setPri: -1
					setSpeed: 6
					setMotion: PolyPath 89 115 self
				)
			)
			(1 0)
			(2
				(Face gEgo cop)
				(cop setCel: 0 setLoop: 1 setCycle: Fwd)
				((ScriptID 401 1) ; xMime
					view: 433
					setCel: 0
					setLoop: 0
					setSpeed: 12
					setCycle: End self
				)
			)
			(3
				((ScriptID 401 1) setCel: 0 setLoop: 1 setCycle: End self) ; xMime
			)
			(4
				(copHead hide:)
				(cop view: 434 setCel: 0 setLoop: 0 setCycle: End)
				((ScriptID 401 1) setCel: 0 setLoop: 2 setCycle: End self) ; xMime
			)
			(5
				(cop setCycle: ROsc 5 7)
				((ScriptID 401 1) setCel: 0 setLoop: 3 setCycle: Osc) ; xMime
				(if (not (IsFlag 109))
					(gMessager say: 4 13 3 1 self) ; "(YELLING AT MIME WHOSE MAKING FUN OF HIM--THESE SHOULD ESCALATE)Hey, cut that out!"
				else
					(gMessager say: 4 13 4 1) ; "(READY TO CHASE MIME)Why, you little....!"
					(self changeState: 9)
				)
			)
			(6
				((ScriptID 401 1) setCel: 0 setCycle: Beg self) ; xMime
			)
			(7
				(gMessager say: 4 13 3 2 self) ; "(TO MIME)I told you to stop that!"
				((ScriptID 401 1) setCel: 0 setLoop: 1 setCycle: Osc) ; xMime
			)
			(8
				((ScriptID 401 1) setCel: 0 setLoop: 2 setCycle: End self) ; xMime
			)
			(9
				((ScriptID 401 1) setCel: 0 setLoop: 4 setCycle: End self) ; xMime
			)
			(10
				((ScriptID 401 1) setCel: 0 setLoop: 5 setCycle: End) ; xMime
				(= ticks 120)
			)
			(11
				(cop view: 434 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(12
				(if (not (IsFlag 109))
					(gEgo getPoints: 125 5)
					(gMessager say: 4 13 3 3) ; "(TO MIME--THREATENING)All right, Mister. You want some of this?"
					(SetFlag 109)
				)
				(cop
					view: 434
					setCel: 0
					setLoop: 3 1
					setCycle: Fwd
					cycleSpeed: 6
					setMotion: MoveTo -30 (cop y:) self
				)
			)
			(13
				(radio approachVerbs: 0)
				(= local0 0)
				(gGame handsOn:)
				(= seconds 20)
			)
			(14
				(if (!= (gEgo script:) sOperateRadio)
					(cop setScript: sCopReturns 0 0)
				)
				(radio approachVerbs: 8) ; Operate
			)
		)
	)
)

(instance sCopReturns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 1)
				(gMessager say: 5 0 14 0 self) ; "Stupid mime!"
			)
			(1
				(if register
					(gMessager say: 3 8 6 10 self) ; "Hey, you! Get away from that bike!"
				else
					(= cycles 1)
				)
			)
			(2
				(if register
					(gMessager say: 3 8 6 11) ; "Sorry."
				)
				(cop
					setCel: 0
					setLoop: 4 1
					setCycle: Fwd
					setSpeed: 6
					ignoreActors: 1
					setMotion: MoveTo 59 132 self
				)
			)
			(3
				(gGame handsOn:)
				(cop view: 432 setScript: sCopStuff)
				((ScriptID 401 1) setScript: 0) ; xMime
			)
		)
	)
)

(instance sRadio of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 400)
					0
				else
					(= seconds 15)
				)
			)
			(1
				(if
					(or
						(gTalkers size:)
						(== ((ScriptID 401 1) script:) sAnnoyCop) ; xMime
					)
					(-- state)
				else
					0
				)
				(= cycles 1)
			)
			(2
				(gMessager say: 5 0 13 (Random 1 4))
				(= seconds 5)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance sOperateRadio of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 64))
					(gEgo getPoints: 126 2)
					(SetFlag 64)
				)
				(bike setScript: 0)
				(gEgo setMotion: PolyPath 42 133 self)
			)
			(1
				(gEgo
					view: 435
					setCel: 0
					setLoop: 0
					setSpeed: 12
					setCycle: End self
				)
			)
			(2
				(gMessager say: 3 8 6 1 self) ; "Gabriel picks up the headset and listens...."
			)
			(3
				(gMessager say: 3 8 6 2 self) ; "Ambulance 91, have you located the crime scene? They've radioed for you three times."
			)
			(4
				(gMessager say: 3 8 6 3 self) ; "Damn! Did you say it was NORTH of the Lake Retreat Country Club?"
			)
			(5
				(gMessager say: 3 8 6 4 self) ; "<sigh>SOUTH. Lakeside Drive, NORTH of the Piedmont Pier, SOUTH of the country club."
			)
			(6
				(gMessager say: 3 8 6 5 self) ; "Man, I don't know if it's the clouds out here today or what! Good thing this guy's already dead!"
			)
			(7
				(gMessager say: 3 8 6 6 self) ; "Everyone's having trouble. Must have been hallucinogens in the coffee this morning!"
			)
			(8
				(gMessager say: 3 8 6 7 self) ; "It's just so misty out here or something, I...hey, I see a squad car! Got it, Molly."
			)
			(9
				(gMessager say: 3 8 6 8 self) ; "Thank God. Have a good one, 91. <pOp>"
			)
			(10
				(gEgo setCycle: Beg self)
				(gMessager say: 3 8 6 9) ; "Interesting."
			)
			(11
				(= ticks 140)
				(cop setScript: sCopReturns 0 1)
			)
			(12
				(gEgo
					normalize: 1 902
					setLooper: (ScriptID 401 2) ; xSmallStopGroop
					setStep: 2 1
				)
				(= seconds 2)
			)
			(13
				(bike setScript: sRadio)
				((ScriptID 401 1) setScript: 0) ; xMime
				(self dispose:)
			)
		)
	)
)

(instance sMimeLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				((ScriptID 401 1) ; xMime
					view: 4201
					setCel: 0
					setLoop: 2
					setCycle: End self
				)
			)
			(2
				((ScriptID 401 1) ; xMime
					view: 422
					posn: 159 65
					ignoreHorizon: 1
					setSpeed: 6
					setCycle: StopWalk 422
					setPri: -1
					setMotion: PolyPath 160 10 self
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cop of Actor
	(properties
		noun 4
		approachX 48
		approachY 142
		x 59
		y 132
		view 432
		loop 1
		signal 16417
		cycleSpeed 12
	)

	(method (init)
		(= local0 1)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 13) ; Walk
			(if (and (== theVerb 13) (IsFlag 102) (IsFlag 64)) ; Walk
				(gMessager say: 4 13 2) ; "The mime doesn't look anxious to get near that cop again."
			else
				(gEgo setMotion: PolyPath gMouseX (- gMouseY 10))
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance guitar of Prop
	(properties
		noun 1
		x 191
		y 44
		view 430
		cel 6
		signal 16417
		cycleSpeed 12
	)
)

(instance spoons of Prop
	(properties
		noun 1
		x 177
		y 54
		view 430
		loop 5
		cel 14
		signal 16417
	)
)

(instance harmonica of Prop
	(properties
		noun 1
		x 213
		y 56
		view 430
		loop 3
		cel 4
		signal 16417
		cycleSpeed 12
	)
)

(instance copHead of Prop
	(properties
		noun 4
		approachX 48
		approachY 142
		x 58
		y 109
		priority 10
		fixPriority 1
		view 432
		cel 5
		signal 16417
		cycleSpeed 120
	)

	(method (doVerb theVerb)
		(if (== theVerb 13) ; Walk
			(if (and (== theVerb 13) (IsFlag 102) (IsFlag 64)) ; Walk
				(gMessager say: 4 13 2) ; "The mime doesn't look anxious to get near that cop again."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bush of View
	(properties
		noun 11
		modNum 401
		x 40
		y 88
		priority 6
		fixPriority 1
		view 409
		loop 2
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; MISSING MESSAGE
		else
			(super doVerb: theVerb)
		)
	)
)

(instance tree of View
	(properties
		noun 11
		modNum 401
		x 158
		y 39
		priority 55
		fixPriority 1
		view 409
		loop 2
		cel 1
	)
)

(instance bike of Prop
	(properties
		noun 2
		x 53
		y 130
		view 432
		loop 3
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(if (== ((ScriptID 401 1) script:) sAnnoyCop) ; xMime
					(gEgo setScript: sOperateRadio)
				else
					(super doVerb: theVerb)
				)
			)
			(13 ; Walk
				(if (and (== theVerb 13) (IsFlag 102) (IsFlag 64)) ; Walk
					(gMessager say: 4 13 2) ; "The mime doesn't look anxious to get near that cop again."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance radio of Feature
	(properties
		noun 3
		nsLeft 36
		nsTop 105
		nsRight 44
		nsBottom 115
		sightAngle 40
		approachX 48
		approachY 142
		x 52
		y 133
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(if (and (IsFlag 102) (IsFlag 64))
					(gMessager say: 4 13 2) ; "The mime doesn't look anxious to get near that cop again."
				)
			)
			(8 ; Operate
				(if local0
					(gMessager say: 3 8 5) ; "Mind if I use your radio?"
				else
					(gEgo setScript: sOperateRadio)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lamp of Feature
	(properties
		noun 4
		modNum 401
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 27 108 28 143 19 143 19 108
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 144 98 146 140 131 140 131 99
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 296 27 310 27 310 64 296 64
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "There's no reason to do that to the lampposts."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fence of Feature
	(properties
		noun 3
		modNum 401
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 22 79 22 73 28 37 38 0 38
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "Using that on the fence would be pointless."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sidewalk of Feature
	(properties
		noun 9
		modNum 401
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 36 40 68 30 124 30 115 38 92 52 55 60 11 60 11 40
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 116 121 198 96 255 56 267 29 300 29 297 52 273 79 220 109 149 132 114 136 82 142 59 141 59 124
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "Using that on the sidewalk would be pointless."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance trash of Feature
	(properties
		noun 12
		modNum 401
		nsLeft 293
		nsTop 40
		nsRight 307
		nsBottom 51
		sightAngle 40
		approachX 289
		approachY 44
		approachDist 46
		x 300
		y 45
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "Gabriel doesn't want to throw that away."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 135
		nsBottom 145
		nsRight 20
		cursor 964
		exitDir 3
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 41
		nsBottom 135
		nsRight 3
		cursor 962
		exitDir 4
	)
)

(instance northExit of ExitFeature
	(properties
		nsTop 21
		nsLeft 87
		nsBottom 30
		nsRight 312
		cursor 961
		exitDir 1
	)
)

(instance specialMimeCode of Code
	(properties)

	(method (doit)
		(cond
			((and (IsFlag 102) ((ScriptID 401 1) inRect: 164 45 231 60)) ; xMime
				(ClearFlag 102)
				((ScriptID 401 1) setScript: sAnnoyBlues) ; xMime
			)
			(
				(and
					(not (IsFlag 102))
					(== ((ScriptID 401 1) script:) sAnnoyBlues) ; xMime
					(gEgo inRect: 164 65 184 80)
				)
				(SetFlag 102)
				(mimeTimer4 dispose:)
				((ScriptID 401 1) ; xMime
					view: 422
					setSpeed: (gEgo moveSpeed:)
					setScript: 0
					setCycle: StopWalk 422
					setMotion: PFollow gEgo 15
					setPri: -1
				)
			)
			(
				(and
					(IsFlag 102)
					local0
					((ScriptID 401 1) inRect: 57 111 90 150) ; xMime
					(not (IsFlag 64))
				)
				(ClearFlag 102)
				(cop setScript: 0)
				((ScriptID 401 1) setScript: sAnnoyCop) ; xMime
			)
		)
	)
)

(instance mimeTimer4 of Timer
	(properties)

	(method (cue)
		(gMessager say: 1 13 1 1) ; "Aw, man! Go bother somebody else, Dude!"
		((ScriptID 401 1) setScript: sMimeLeaves) ; xMime
	)
)

