;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use GKIconbar)
(use n013)
(use ExitFeature)
(use PFollow)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Timer)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	neJackson 0
)

(local
	[local0 2]
	local2 = 1
	local3 = 2
)

(instance neJackson of Room
	(properties
		modNum 401
		noun 8
		picture 410
		style 14
		exitStyle 13
		horizon 25
		north 450
		south 430
		west 420
		vanishingY 35536
	)

	(method (init)
		(super init:)
		(self setRegions: 401) ; JacksonSq
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 108 50 109 84 122 88 132 118 132 118 141 89 141 89 146 310 148 305 130 281 94 249 72 198 50 127 31 50 27 17 27 8 21 0 21
					yourself:
				)
		)
		(tom
			init:
			approachVerbs:
				11 ; Talk
				10 ; Ask
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
			cycleSpeed: 12
			ignoreActors: 1
			setCycle: RandCycle
		)
		(cond
			((!= gPrevRoomNum 400)
				(gGkMusic1
					number:
						(cond
							((== gDay 6) 1811)
							((== gDay 7) 1812)
							(else 1810)
						)
					loop: -1
					stop:
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(gEgo
					normalize: 2 902
					setCel: 0
					setLoop: 4
					setLooper: (ScriptID 401 2) ; xSmallStopGroop
					setStep: 2 1
					setCycle: StopWalk -1
					init:
					state: 2
				)
			)
			((and (not (IsFlag 314)) (== gDay 4))
				(SetFlag 318)
				(gCurRoom setScript: (ScriptID 402 0) 0 1) ; sBinoc
				(tom setScript: sCrashTalkToDrummer (ScriptID 402 0)) ; sBinoc
			)
			(else
				(gCurRoom setScript: (ScriptID 402 0) 0 0) ; sBinoc
			)
		)
		(switch gPrevRoomNum
			(450
				(self setScript: sGabeEntersFromNorth)
			)
			(420 ; nwJackson
				(if (and (IsFlag 328) (== ((ScriptID 401 7) room:) gCurRoomNum)) ; xCrash
					((ScriptID 401 7) ; xCrash
						posn: 110 129
						destX: 135
						destY: 190
						destRoom: 430
						init:
					)
				)
				(Face (ScriptID 401 7) tom) ; xCrash
				(cond
					((< (gEgo y:) 35)
						(gEgo y: 35)
					)
					((> (gEgo y:) 102)
						(gEgo y: 102)
					)
				)
				(gEgo
					posn: 5 (gEgo y:)
					setMotion: PolyPath 15 (gEgo y:)
				)
				(if (IsFlag 102)
					((ScriptID 401 1) posn: 5 (gEgo y:)) ; xMime
				)
			)
			(430 ; seJackson
				(if (and (IsFlag 328) (== ((ScriptID 401 7) room:) gCurRoomNum)) ; xCrash
					((ScriptID 401 7) ; xCrash
						posn: 110 129
						destX: -30
						destY: 50
						destRoom: 420
						init:
					)
				)
				(Face (ScriptID 401 7) tom) ; xCrash
				(cond
					((< (gEgo x:) 136)
						(gEgo x: 136)
					)
					((> (gEgo x:) 304)
						(gEgo x: 300)
					)
				)
				(gEgo
					posn: (gEgo x:) 140
					setMotion: PolyPath (gEgo x:) 130
				)
				(if (IsFlag 102)
					((ScriptID 401 1) posn: (gEgo x:) 140) ; xMime
				)
			)
			(400 0)
			(else
				(gEgo posn: 160 100)
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
		(statue init:)
		(tree init:)
		(if (not global181)
			(if (< 1 gDay 4)
				(juggler init: cycleSpeed: 6 setCycle: Fwd)
				(easel init:)
				(if (and (IsFlag 237) (!= gPrevRoomNum 400))
					(artist
						init:
						approachVerbs:
							11 ; Talk
							10 ; Ask
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
						cycleSpeed: 12
					)
					(self setScript: sDrawingBlows)
					(ClearFlag 237)
				else
					(artist
						init:
						approachVerbs:
							11 ; Talk
							10 ; Ask
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
						cycleSpeed: 40
						setScript: sArtistStuff
					)
				)
			)
			(if (and (not (IsFlag 236)) (== gDay 2) (!= gPrevRoomNum 400))
				(SetFlag 237)
			)
		)
		(trashCan init:)
		(lamp init:)
		(fence1 init:)
		(fence2 init:)
		(bench init:)
		(northPath init:)
		(sidewalk init:)
		(northExit init:)
		(southExit init:)
		(westExit init:)
	)

	(method (dispose)
		(if (!= gPrevRoomNum 400)
			(gGkMusic1 fade:)
			(gGkSound1 stop:)
		)
		(if (and (== (gEgo edgeHit:) 1) (IsFlag 102))
			(ClearFlag 102)
		)
		(if (and (== (gEgo edgeHit:) 1) (IsFlag 239))
			(ClearFlag 239)
		)
		(mimeTimer1 client: 0 dispose: delete:)
		(super dispose:)
	)

	(method (doit)
		(if (and global181 (not script) (gEgo inRect: 0 21 15 30))
			(self setScript: sGabeExits)
		)
		(super doit:)
	)

	(method (reflectPosn param1 param2 &tmp temp0)
		(switch param2
			(1
				(= temp0 (param1 x:))
				(param1 y: 136)
			)
			(4
				(param1 x: (- 319 (param1 xStep:)))
			)
		)
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
)

(instance sGabeEntersFromNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 328)
					((ScriptID 401 7) ; xCrash
						posn: 110 129
						destX: 135
						destY: 170
						destRoom: 430
						init:
					)
				)
				(Face (ScriptID 401 7) tom) ; xCrash
				(gGame handsOff:)
				(gEgo
					posn: 10 31
					ignoreHorizon: 1
					setMotion: MoveTo 10 40 self
				)
			)
			(1
				(gEgo ignoreHorizon: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sArtistStuff of Script
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
					((< 91 temp0 95)
						(self changeState: 5)
					)
					((< 91 temp0 95)
						(self changeState: 9)
					)
					(else
						(self changeState: 11)
					)
				)
			)
			(1
				(artist x: 66 setCel: 0 setLoop: 4 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(self changeState: 0)
			)
			(3
				(artist setCel: 0 setLoop: 4 setCycle: End self)
			)
			(4
				(self changeState: 0)
			)
			(5
				(artist setCel: 0 setLoop: 5 setCycle: End self)
			)
			(6
				(= seconds 3)
			)
			(7
				(artist setCycle: Beg self)
			)
			(8
				(artist setCel: 0 setLoop: 2 setCycle: End self)
			)
			(9
				(self changeState: 0)
			)
			(10
				(artist setCel: 0 setLoop: 1 setCycle: End self)
			)
			(11
				(self changeState: 0)
			)
		)
	)
)

(instance sCrashTalkToDrummer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 314)
				(crash2
					init:
					ignoreActors: 1
					setLooper: Grooper
					setCycle: Walk
					posn: 200 75
					setMotion: MoveTo 105 135 self
				)
			)
			(1
				(crash2
					view: 414
					setCel: 0
					setLoop: 0
					setSpeed: 12
					setCycle: End self
				)
			)
			(2
				(= seconds 4)
			)
			(3
				(tom setCycle: End self)
			)
			(4
				(gMessager say: 2 0 10 0 self) ; "(RRCC. SUSPICIOUS, INTRIGUED)That's Crash. What the hell is he up to with that drummer?"
			)
			(5
				(tom setCycle: Fwd)
				(= seconds 2)
			)
			(6
				(crash2 setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(7
				(gEgo getPoints: -999 3)
				(crash2
					view: 444
					setLooper: Grooper
					setCel: 0
					setLoop: 6 0
					setCycle: Walk
					setMotion: MoveTo 25 30 self
				)
			)
			(8
				(ClearFlag 328)
				(ClearFlag 318)
				(self dispose:)
			)
		)
	)
)

(instance sGiveArtistCrap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(artist
					view: 413
					setCel: 0
					setLoop: 5
					setSpeed: 12
					setCycle: End self
				)
				(UpdateScreenItem artist)
				(gEgo hide:)
			)
			(1
				(if (gTalkers size:)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(if register
					(gEgo getPoints: 159 3)
				)
				(gEgo posn: 50 61 show:)
				(gGame handsOn:)
				(artist view: 412 setSpeed: 40 setScript: sArtistStuff)
				(UpdateScreenItem artist)
			)
		)
	)
)

(instance sGiveBackDrawing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 34 0 1 self) ; "This belongs to you, doesn't it?"
				(artist
					view: 413
					setCel: 0
					setLoop: 1
					setSpeed: 12
					setCycle: End self
				)
				(UpdateScreenItem artist)
				(gEgo hide:)
			)
			(1 0)
			(2
				(gMessager say: 3 34 0 2 self) ; "My drawing! How'd you get it?"
			)
			(3
				(gMessager say: 3 34 0 3 self) ; "Oh, it was a bit of a squeeze, but I hate to see you lose your work. I lost my only copy of a manuscript once."
				(artist setCel: 0 setLoop: 2 setCycle: End self)
			)
			(4 0)
			(5
				(gMessager say: 3 34 0 4 self) ; "Well, you saved my butt. Let me know if I can ever do the same for you, hey?"
				(artist setCel: 0 setLoop: 3 setCycle: Fwd)
			)
			(6
				(artist setCel: 0 setLoop: 4 setCycle: End self)
			)
			(7
				(gEgo posn: 50 61 show:)
				(gEgo getPoints: -999 1)
				(gGame handsOn:)
				(ClearFlag 234)
				(SetFlag 230)
				(artist view: 412 setSpeed: 40 setScript: sArtistStuff)
				(self dispose:)
			)
		)
	)
)

(instance sGetReconVeve of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 11 21 1 self) ; "How's it going today?"
			)
			(1
				(gMessager say: 3 11 21 2 self) ; "What? Oh, it's only you."
			)
			(2
				(gMessager say: 3 11 21 3 self) ; "Man, I have been jumpy all day. That...that pattern of yours really freaked me out for some reason. There's just something...creepy."
			)
			(3
				(gMessager say: 3 11 21 4 self) ; "(EXCITED)You finished it?"
			)
			(4
				(gMessager say: 3 11 21 5 self) ; "Yeah, and you're welcome to it. Here."
				(artist
					view: 415
					setCel: 0
					setLoop: 0
					setScript: 0
					setSpeed: 12
					setCycle: End self
				)
				(UpdateScreenItem artist)
				(gEgo hide:)
			)
			(5 0)
			(6
				(gMessager say: 3 11 21 6 self) ; "Wow, this is great!"
			)
			(7
				(gMessager say: 3 11 21 7 self) ; "Uh-huh. Just don't, like, blow up the planet with it or something, okay?"
			)
			(8
				(gMessager say: 3 11 21 8 self) ; "I didn't mean to upset you."
			)
			(9
				(gMessager say: 3 11 21 9 self) ; "Ah, forget it. I'm probably just being stupid. Do your thing with it, and good luck."
			)
			(10
				(gEgo posn: 48 61 show:)
				(gGame handsOn:)
				(ClearFlag 234)
				(SetFlag 230)
				(gEgo getPoints: -999 1)
				(artist view: 412 setSpeed: 40 setScript: sArtistStuff)
				(UpdateScreenItem artist)
			)
		)
	)
)

(instance sGoToDrum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 18 0 0 self) ; "Gabriel listens carefully to the drum and opens his Rada book to translate...."
			)
			(1
				(gGkMusic1 stop:)
				(= cycles 1)
			)
			(2
				(gCurRoom setInset: (ScriptID 815 0) self gCurRoom) ; drumInset
			)
			(3
				(= cycles 2)
			)
			(4
				(gTheIconBar dispose:)
				(= gTheIconBar GKIconbar)
				(if (gGame keepBar:)
					(gTheIconBar draw:)
				)
				(gGkMusic1
					number:
						(cond
							((== gDay 6) 1811)
							((== gDay 7) 1812)
							(else 1810)
						)
					loop: -1
					stop:
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(DisposeScript 815)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDrawingBlows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 237)
				(SetFlag 234)
				(SetFlag 228)
				(SetFlag 236)
				(gGame handsOff:)
				(gGkSound1 setLoop: 1 number: 411 play:)
				(artist
					view: 412
					setCel: 0
					setLoop: 6
					setSpeed: 12
					setCycle: End self
				)
			)
			(1
				(gMessager say: 2 0 12 0 self) ; "(HIS DRAWING IS BLOWING AWAY)Hey, come back here. HEY!"
				(artist setCel: 0 setLoop: 7 setCycle: End self)
			)
			(2
				(SetFlag 239)
				0
			)
			(3
				(artist dispose:)
				(gGame handsOn:)
				(easel noun: 6)
				(= seconds 60)
			)
			(4
				(gGame handsOff:)
				(easel noun: 0)
				(ClearFlag 239)
				(artist
					init:
					posn: -20 60
					setSpeed: 6
					setCel:
					setLoop: 9 1
					setCycle: Fwd
					setMotion: MoveTo 63 63 self
				)
			)
			(5
				(gMessager say: 2 0 13 0) ; "(GIVING UP CHASING DRAWING)Stupid wind! Now I have to start over!"
				(gGame handsOn:)
				(artist
					y: 61
					approachVerbs:
						11 ; Talk
						10 ; Ask
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
					cycleSpeed: 40
					setScript: sArtistStuff
				)
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
				(gEgo
					ignoreHorizon: 1
					setMotion: MoveTo (gEgo x:) 20 self
				)
			)
			(1
				(gMessager say: 13 13 8 0 0 401) ; "The path north leads to St. Louis Cathedral. The cathedral is not available for the day 1 demo."
				(gEgo setMotion: MoveTo (gEgo x:) 35 self)
			)
			(2
				(gEgo ignoreHorizon: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAnnoyDrummer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScript: 0)
				(mimeTimer1 setReal: mimeTimer1 20)
				((ScriptID 401 1) ; xMime
					view: 422
					setSpeed: 6
					setCycle: StopWalk 422
					setPri: -1
					setMotion: PolyPath 122 136 self
				)
			)
			(1
				((ScriptID 401 1) ; xMime
					setSpeed: 12
					view: 410
					setCel: 0
					setLoop: 1
					setCycle: End self
				)
			)
			(2
				((ScriptID 401 1) setCel: 0 setLoop: 2 setCycle: Fwd) ; xMime
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
				((ScriptID 401 1) setCel: 13 setLoop: 1 setCycle: Beg self) ; xMime
			)
			(1
				((ScriptID 401 1) ; xMime
					view: 422
					ignoreHorizon: 1
					setSpeed: 6
					setCycle: StopWalk 422
					setPri: -1
					setMotion: PolyPath 5 35 self
				)
			)
			(2
				((ScriptID 401 1) setMotion: MoveTo -20 35 self) ; xMime
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tom of Prop
	(properties
		noun 1
		approachX 100
		approachY 127
		x 95
		y 138
		view 410
	)

	(method (doVerb theVerb)
		(switch theVerb
			(18 ; drumBook
				(gCurRoom setScript: sGoToDrum)
				(return 1)
			)
			(11 ; Talk
				(if (IsFlag 51)
					(gMessager say: noun theVerb 1) ; "You know--I know who you are."
				else
					(gMessager say: noun theVerb 2) ; "The drummer is busy."
				)
				(return 1)
			)
			(10 ; Ask
				(if (IsFlag 51)
					(gMessager say: noun theVerb 1) ; "Can I ask you a few questions?"
				else
					(gMessager say: noun theVerb 2) ; "The drummer is busy."
				)
				(return 1)
			)
			(7 ; Look
				(if (IsFlag 51)
					(gMessager say: noun theVerb 1) ; "It's one of the Rada drummers--they transmit coded messages through the French Quarter for the Voodoo cartel."
				else
					(gMessager say: noun theVerb 2) ; "A lone drummer beats out a haunting rhythm on a large African drum."
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance juggler of Prop
	(properties
		noun 5
		x 243
		y 120
		view 411
		cel 15
	)
)

(instance crash2 of Actor
	(properties
		noun 2
		x 105
		y 138
		view 444
	)
)

(instance artist of Actor
	(properties
		noun 3
		approachX 50
		approachY 61
		x 65
		y 61
		z 1
		view 412
		loop 3
		signal 16417
	)

	(method (doVerb theVerb)
		(switch theVerb
			(34 ; lostDrawing
				(gEgo put: 35) ; lostDrawing
				(self setScript: sGiveBackDrawing)
			)
			(11 ; Talk
				(cond
					((IsFlag 234)
						(ClearFlag 234)
						(gMessager say: noun theVerb 23) ; "How's it going?"
					)
					((and (not (IsFlag 235)) (not (IsFlag 236)))
						(SetFlag 235)
						(gMessager say: noun theVerb 24) ; "Nice drawing of the cathedral."
					)
					((and (IsFlag 235) (not (IsFlag 236)) (== local3 2))
						(++ local3)
						(gMessager say: noun theVerb 26) ; "Those drawing tools are amazing."
					)
					((and (IsFlag 235) (not (IsFlag 236)) (== local3 3))
						(++ local3)
						(gMessager say: noun theVerb 27) ; "Can you draw anything with those tools?"
					)
					((and (IsFlag 235) (not (IsFlag 236)) (== local3 4))
						(gMessager say: noun theVerb 29) ; "Do you mind if I watch you?"
					)
					(
						(and
							(== gDay 2)
							(or
								(and (IsFlag 231) (not (IsFlag 232)))
								(and (not (IsFlag 231)) (IsFlag 232))
							)
						)
						(gMessager say: noun theVerb 25) ; "What else do you need to do that reconstruction?"
					)
					(
						(and
							(== gDay 2)
							(IsFlag 231)
							(IsFlag 232)
							(not (IsFlag 233))
						)
						(gMessager say: noun theVerb 28) ; "Is there anything else you need to do that reconstruction."
					)
					(
						(and
							(== gDay 3)
							(IsFlag 231)
							(IsFlag 232)
							(not (IsFlag 233))
						)
						(SetFlag 233)
						(gEgo get: 38) ; reconVeve
						(gCurRoom setScript: sGetReconVeve)
					)
					(
						(and
							(== gDay 3)
							(IsFlag 231)
							(IsFlag 232)
							(IsFlag 233)
						)
						(gMessager say: noun theVerb 22) ; "Thanks again for that pattern."
					)
					(else
						(gMessager say: noun theVerb 29) ; "Do you mind if I watch you?"
					)
				)
				(return 1)
			)
			(10 ; Ask
				(if (and local2 (!= gDay 3))
					(= local2 0)
					(gMessager say: noun theVerb 14) ; "Could I ask you some questions?"
				else
					(gMessager say: noun theVerb 15) ; "The artist is an able draftsman, but interrogating him wouldn't lend much to Gabriel's investigations."
				)
			)
			(48 ; policeVeve_
				(if (IsFlag 230)
					(cond
						((IsFlag 231)
							(if (IsFlag 232)
								(gMessager say: noun 48 30) ; "Gabriel's already given the artist the photocopy of that file. The original wouldn't help."
							else
								(gMessager say: noun 48 19) ; "I have some more of those patterns."
								(self setScript: sGiveArtistCrap 0 1)
								(SetFlag 232)
								(gEgo put: 16) ; policeVeve
							)
						)
						((IsFlag 232)
							(gMessager say: noun 48 30) ; "Gabriel's already given the artist the photocopy of that file. The original wouldn't help."
						)
						(else
							(SetFlag 232)
							(self setScript: sGiveArtistCrap 0 0)
							(gEgo put: 16) ; policeVeve
							(gMessager say: noun 48 20) ; "Say, do you think there's anything you can do with these patterns?"
						)
					)
				else
					(gMessager say: noun 48 18) ; "Say, do you think there's anything you can do with these patterns?"
				)
			)
			(24 ; veveCopy
				(if (IsFlag 230)
					(cond
						((IsFlag 231)
							(if (IsFlag 232)
								(gMessager say: noun 48 31) ; MISSING MESSAGE
							else
								(self setScript: sGiveArtistCrap 0 1)
								(SetFlag 232)
								(gEgo put: 15) ; veveCopy
								(gMessager say: noun 48 19) ; "I have some more of those patterns."
							)
						)
						((IsFlag 232)
							(gMessager say: noun 24 31) ; "Gabriel's already given the artist the original police file. The photocopy wouldn't help."
						)
						(else
							(SetFlag 232)
							(self setScript: sGiveArtistCrap 0 0)
							(gEgo put: 15) ; veveCopy
							(gMessager say: noun 48 20) ; "Say, do you think there's anything you can do with these patterns?"
						)
					)
				else
					(gMessager say: noun 48 18) ; "Say, do you think there's anything you can do with these patterns?"
				)
			)
			(23 ; sLakePatter
				(if (IsFlag 230)
					(SetFlag 231)
					(gEgo put: 31) ; sLakePatter
					(self setScript: sGiveArtistCrap 0 1)
					(if (IsFlag 232)
						(gMessager say: noun 23 17) ; "I have another one of those patterns."
					else
						(gMessager say: noun 23 16) ; "Say, do you think there's anything you can do with this pattern?"
					)
				else
					(gMessager say: noun 23 18) ; "Say, do you think there's anything you can do with this pattern?"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance statue of View
	(properties
		noun 14
		modNum 401
		x 2
		y 84
		priority 190
		fixPriority 1
		view 409
		signal 20513
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "Gabriel can't do that with the Jackson statue."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance tree of View
	(properties
		noun 11
		modNum 401
		x 159
		y 128
		priority 170
		fixPriority 1
		view 409
		cel 2
		signal 20513
	)
)

(instance easel of View
	(properties
		x 65
		y 60
		priority 55
		fixPriority 1
		view 412
		cel 1
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 50 56 59 48 80 56 80 66 54 66
					yourself:
				)
		)
		(super init:)
	)
)

(instance trashCan of Feature
	(properties
		noun 12
		modNum 401
		nsLeft 290
		nsTop 90
		nsRight 307
		nsBottom 105
		sightAngle 40
		approachX 287
		approachY 103
		approachDist 57
		x 298
		y 97
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "Gabriel doesn't want to throw that away."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lamp of Feature
	(properties
		noun 4
		modNum 401
		nsLeft 292
		nsTop 40
		nsRight 308
		nsBottom 85
		sightAngle 40
		approachX 262
		approachY 85
		approachDist 125
		x 300
		y 62
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "There's no reason to do that to the lampposts."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fence1 of Feature
	(properties
		noun 3
		modNum 401
		nsLeft 28
		nsTop 97
		nsRight 65
		nsBottom 115
		sightAngle 40
		approachX 99
		approachY 108
		approachDist 104
		x 46
		y 106
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "Using that on the fence would be pointless."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fence2 of Feature
	(properties
		noun 3
		modNum 401
		nsLeft 66
		nsTop 101
		nsRight 87
		nsBottom 143
		sightAngle 40
		approachX 99
		approachY 108
		approachDist 89
		x 76
		y 122
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "Using that on the fence would be pointless."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bench of Feature
	(properties
		noun 1
		modNum 401
		nsLeft 308
		nsTop 130
		nsRight 319
		nsBottom 145
		sightAngle 40
		approachX 286
		approachY 131
		approachDist 104
		x 313
		y 137
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "The bench doesn't work that way."
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
					init: 13 23 127 24 222 50 275 80 312 130 311 141 184 141 186 132 262 132 258 114 232 89 189 68 134 51 75 43 15 42
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

(instance northPath of Feature
	(properties
		noun 13
		modNum 401
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 21 22 21 37 1 37 1 22 yourself:)
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

(instance northExit of ExitFeature
	(properties
		nsTop 21
		nsBottom 30
		nsRight 15
		cursor 961
		exitDir 1
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 31
		nsBottom 107
		nsRight 4
		cursor 962
		exitDir 4
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 142
		nsLeft 88
		nsBottom 145
		nsRight 314
		cursor 964
		exitDir 3
	)
)

(instance specialMimeCode of Code
	(properties)

	(method (doit)
		(cond
			((and (IsFlag 102) ((ScriptID 401 1) inRect: 87 125 120 140)) ; xMime
				(ClearFlag 102)
				((ScriptID 401 1) setScript: sAnnoyDrummer) ; xMime
			)
			(
				(and
					(not (IsFlag 102))
					(== ((ScriptID 401 1) script:) sAnnoyDrummer) ; xMime
					(gEgo inRect: 122 120 140 140)
				)
				(SetFlag 102)
				(mimeTimer1 dispose:)
				((ScriptID 401 1) ; xMime
					view: 422
					setSpeed: (gEgo moveSpeed:)
					setScript: 0
					setCycle: StopWalk 422
					setMotion: PFollow gEgo 15
					setPri: -1
				)
			)
		)
	)
)

(instance mimeTimer1 of Timer
	(properties)

	(method (cue)
		(gMessager say: 1 13 3 1) ; "The drummer ignores the mime."
		((ScriptID 401 1) setScript: sMimeLeaves) ; xMime
	)
)

