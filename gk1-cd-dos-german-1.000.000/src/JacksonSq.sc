;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 401)
(include sci.sh)
(use Main)
(use n013)
(use PFollow)
(use PolyPath)
(use StopWalk)
(use Grooper)
(use RegionPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	JacksonSq 0
	xMime 1
	xSmallStopGroop 2
	xWoman 3
	xMan 4
	xGranny 5
	xBoy 6
	xCrash 7
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	[local8 49] = [32767 420 319 81 236 78 198 122 199 176 199 176 32767 440 163 15 181 56 181 94 318 94 318 94 32767 430 0 93 82 93 129 65 129 10 129 10 32767 410 190 171 190 110 139 66 0 66 0 66 32768]
	[local57 53] = [32767 410 0 68 116 68 208 98 208 177 208 177 208 177 32767 430 236 9 236 62 217 73 0 73 0 73 32767 440 319 82 212 92 185 63 185 6 185 6 32767 420 151 175 151 117 186 117 217 72 319 70 319 70 32768]
	[local110 49] = [32767 430 0 93 82 93 129 65 129 10 129 10 32767 410 190 171 190 110 139 66 0 66 0 66 32767 420 319 79 236 78 198 122 199 176 199 176 32767 440 163 15 181 56 181 94 319 94 319 94 32768]
	[local159 51] = [32767 440 319 72 212 72 175 63 175 6 175 6 32767 420 151 175 151 117 186 117 217 72 319 72 319 72 32767 410 0 68 116 68 208 98 208 177 208 177 32767 430 236 9 236 62 217 73 0 73 0 73 32768]
)

(class JacksonSq of Rgn
	(properties)

	(method (newRoom newRoomNumber)
		(= initialized 0)
		(if (xWoman mover:)
			(xWoman setMotion: 0)
		)
		(if (xMan mover:)
			(xMan setMotion: 0)
		)
		(if (xBoy mover:)
			(xBoy setMotion: 0)
		)
		(if (xGranny mover:)
			(xGranny setMotion: 0)
		)
		(= keep (OneOf newRoomNumber 410 420 430 440 400)) ; neJackson, nwJackson, seJackson, swJackson
		(if (gGk1Exits size:)
			(gGk1Exits eachElementDo: #dispose)
			(gGk1Exits dispose:)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(if
			(or
				(and (== gCurRoomNum 420) (not (IsFlag 223)) (<= 3 gDay 4)) ; nwJackson
				(and (== gCurRoomNum 420) (not (IsFlag 399)) (IsFlag 397)) ; nwJackson
			)
			(SetFlag 390)
		else
			(ClearFlag 390)
		)
		(= local4 0)
		((= gGk1Exits gk1Exits) add:)
		(super init:)
		(if (IsFlag 102)
			((ScriptID 401 1) init:) ; xMime
		)
		(if (and (== gPrevRoomNum 200) (> gDay 1))
			(xBoy view: (if (Random 0 1) 4181 else 418))
			(xGranny view: (if (Random 0 1) 4191 else 419))
			(xMan view: (if (Random 0 1) 4161 else 416))
			(xWoman view: (if (Random 0 1) 4171 else 417))
		)
		(if (not (IsFlag 390))
			(if (and (== (GK detailLevel:) 3) (<= gDay 2))
				(xBoy init:)
			)
			(if (and (>= (GK detailLevel:) 2) (<= gDay 4))
				(xGranny init:)
			)
			(if (and (>= (GK detailLevel:) 1) (<= gDay 6))
				(xWoman init:)
			)
			(xMan init:)
		)
		(= local5 0)
		(if (or (!= gDay 1) (and (not (IsFlag 102)) (!= gCurRoom 420)))
			(xMime x: 1000)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(cond
			((Message msgGET modNum noun theVerb 0 1)
				(gMessager say: noun theVerb 0 0 0 modNum)
				(return 1)
			)
			((Message msgGET modNum noun 0 0 1)
				(gMessager say: noun 0 0 0 0 modNum)
				(return 1)
			)
			((OneOf theVerb 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
				(gMessager say: 0 theVerb 0 (Random 1 3) 0 0)
				(return 1)
			)
			(else
				(gMessager say: 0 theVerb 0 0 0 0)
				(return 1)
			)
		)
	)

	(method (doit)
		(if
			(and
				(gGk1Exits size:)
				(== (gTheIconBar curIcon:) (gTheIconBar walkIconItem:))
			)
			(gGk1Exits eachElementDo: #doit)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 64984)
		(super dispose:)
	)
)

(instance pedBaseSetter of Code
	(properties)

	(method (doit param1)
		(param1
			brLeft: (- (param1 x:) 2)
			brRight: (+ (param1 x:) 2)
			brTop: (- (param1 y:) 2)
			brBottom: (+ (param1 y:) 2)
		)
	)
)

(class PedActor of Actor
	(properties
		noun 6
		modNum 401
		mimeAttached 0
		beenAttached 0
		room 0
		lastRoom 0
		path 0
	)

	(method (mimeAttach param1)
		(return
			(and
				(<= (- x 20) (param1 x:))
				(>= (+ x 20) (param1 x:))
				(<= (- y 15) (param1 y:))
				(>= (+ y 15) (param1 y:))
			)
		)
	)

	(method (init)
		(super init:)
		(= baseSetter pedBaseSetter)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and (self isBlocked:) (not local5))
				(= local5 1)
				(self setScript: sAvoid)
			)
			(
				(or
					(and
						(== room gCurRoomNum)
						(self mimeAttach: xMime)
						(IsFlag 102)
						(not (gEgo inRect: 229 50 270 65))
						(not (xMime script:))
						(not mimeAttached)
					)
					(and
						(== room gCurRoomNum)
						(== gDay 1)
						(self mimeAttach: xMime)
						(xMime script:)
						(not mimeAttached)
						(not beenAttached)
						(<= local6 2)
					)
				)
				(++ local6)
				(= beenAttached 1)
				(ClearFlag 102)
				(= mimeAttached 1)
				(self setScript: sMimeFollowsPed)
			)
		)
		(cond
			(script)
			((not mover)
				(self setMotion: path)
			)
		)
	)
)

(instance gk1Exits of EventHandler
	(properties)
)

(instance sAvoid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (= register (GK isHandsOn:))
					(gGame handsOff:)
				)
				(client ignoreActors: 1)
				(switch (client loop:)
					(0
						(= local0 2)
						(= local1 8)
						(= local2 20)
						(= local3 -8)
					)
					(1
						(= local0 -2)
						(= local1 -8)
						(= local2 -20)
						(= local3 8)
					)
					(3
						(if (< (client x:) (gEgo x:))
							(= local0 -8)
							(= local1 0)
							(= local2 8)
							(= local3 -8)
						else
							(= local0 8)
							(= local1 0)
							(= local2 -8)
							(= local3 -8)
						)
					)
					(else
						(if (< (client x:) (gEgo x:))
							(= local0 -8)
							(= local1 0)
							(= local2 8)
							(= local3 8)
						else
							(= local0 8)
							(= local1 0)
							(= local2 -8)
							(= local3 8)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(client
					setMotion:
						MoveTo
						(+ (client x:) local0)
						(+ (client y:) local1)
						self
				)
			)
			(2
				(client
					setMotion:
						MoveTo
						(+ (client x:) local2)
						(+ (client y:) local3)
						self
				)
			)
			(3
				(if register
					(gGame handsOn:)
				)
				(= local5 0)
				((client path:) moveDone:)
				(client ignoreActors: 0)
				(self dispose:)
			)
		)
	)
)

(instance sMimeFollowsPed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setScript: 0)
				(xMime setScript: 0)
				(client setMotion: 0)
				(switch (client view:)
					(416
						(= local0 (+ (client x:) 15))
						(= local2 (- (client x:) 45))
						(= local3 (- (client x:) 30))
						(= local7 1)
						(= register 1)
					)
					(417
						(= local0 (- (client x:) 15))
						(= local2 (+ (client x:) 45))
						(= local3 (+ (client x:) 30))
						(= local7 0)
						(= register 0)
					)
					(418
						(= local0 (+ (client x:) 15))
						(= local2 (- (client x:) 45))
						(= local3 (- (client x:) 30))
						(= local7 1)
						(= register 2)
					)
					(else
						(= local0 (- (client x:) 15))
						(= local2 (+ (client x:) 45))
						(= local3 (+ (client x:) 30))
						(= local7 0)
						(= register 3)
					)
				)
				(= cycles 1)
			)
			(1
				(client ignoreActors: 1)
				(xMime
					view: 422
					ignoreHorizon: 1
					setSpeed: 6
					setCycle: StopWalk 422
					setCel: 0
					setPri: -1
					setMotion: PolyPath local0 (client y:) self
				)
			)
			(2
				(client setMotion: MoveTo local2 (client y:) self)
				((ScriptID 401 1) ; xMime
					view: 4201
					setStep: 2 1
					setCel: 0
					setLoop: local7
					setMotion: MoveTo local3 (client y:)
				)
			)
			(3
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(= cycles 1)
			)
			(4
				(if (not (== gPrevRoomNum 400))
					(switch register
						(1
							(gMessager say: 10 0 12 0 0 401) ; "You white-faced geek! You wanna eat my fist?"
						)
						(0
							(gMessager say: 10 0 10 0 0 401) ; "Well, I never! Leave me alone you, you, you...MAN!"
						)
						(2
							(gMessager say: 10 0 11 0 0 401) ; "Hey, stop picking on me! I'll tell my dad!"
						)
						(3
							(gMessager say: 10 0 9 0 0 401) ; "Why, you nasty thing, you! I'll call the police! I will!"
						)
					)
				)
				(Face client xMime)
				(xMime setCycle: 0)
				(= ticks 120)
			)
			(5
				((ScriptID 401 1) ; xMime
					setCel: 0
					setLoop: (+ (xMime loop:) 2)
					setCycle: End self
				)
			)
			(6
				(client ignoreActors: 0)
				(xMime
					view: 422
					ignoreHorizon: 1
					setSpeed: 6
					setStep: 3 2
					setCycle: StopWalk 422
					setPri: -1
				)
				(switch register
					(1
						(= local0 (+ (xMime x:) 16))
					)
					(0
						(= local0 (- (xMime x:) 16))
					)
					(2
						(= local0 (+ (xMime x:) 16))
					)
					(3
						(= local0 (- (xMime x:) 16))
					)
				)
				(switch gCurRoomNum
					(410 ; neJackson
						(self changeState: 7)
					)
					(420 ; nwJackson
						(self changeState: 10)
					)
					(430 ; seJackson
						(self changeState: 12)
					)
					(else
						(self changeState: 15)
					)
				)
			)
			(7
				(if (> (xMime x:) 5)
					(xMime x: local0 setMotion: PolyPath 5 63 self)
				else
					(= cycles 1)
				)
			)
			(8
				(xMime setMotion: MoveTo -20 63 self)
			)
			(9
				(gGame handsOn:)
				(client mimeAttached: 0)
				(self dispose:)
			)
			(10
				(xMime x: local0 setMotion: PolyPath 245 63 self)
			)
			(11
				(gGame handsOn:)
				(xMime setScript: (ScriptID 420 1)) ; sMimeStuff
				(client mimeAttached: 0)
				(self dispose:)
			)
			(12
				(if (> (xMime x:) 5)
					(xMime x: local0 setMotion: PolyPath 5 70 self)
				else
					(= cycles 1)
				)
			)
			(13
				(xMime setMotion: MoveTo -20 70 self)
			)
			(14
				(gGame handsOn:)
				(client mimeAttached: 0)
				(self dispose:)
			)
			(15
				(if (< (xMime x:) 280)
					(xMime x: local0 setMotion: PolyPath 158 30 self)
				else
					(xMime setMotion: MoveTo 340 45 self)
				)
			)
			(16
				(if (< (xMime x:) 280)
					(xMime setMotion: MoveTo 158 5 self)
				else
					(= cycles 1)
				)
			)
			(17
				(gGame handsOn:)
				(client mimeAttached: 0)
				(self dispose:)
			)
		)
	)
)

(instance sMimeStop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(xMime
					setMotion: 0
					view: 422
					setCel: 0
					setLoop:
						(switch (gEgo cel:)
							((OneOf 0 2 4 6) 9)
							(else 10)
						)
					setCycle: End self
				)
			)
			(1
				(if
					(or
						(not (gEgo mover:))
						(and (gEgo mover:) (& (gEgo signal:) $0400))
					)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(xMime
					view: 422
					setScript: 0
					setCycle: StopWalk 422
					setCel: 0
					setLoop: -1
					setPri: -1
				)
				(= cycles 1)
			)
			(3
				(xMime setMotion: PFollow gEgo 15)
				(self dispose:)
			)
		)
	)
)

(instance sPunchMime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 102)
				(xMime
					view: 422
					setCycle: StopWalk 422
					setCel: 0
					setLoop: -1
					setPri: -1
					setMotion:
						MoveTo
						(- (gEgo x:) 26)
						(+ (gEgo y:) 1)
						self
				)
			)
			(1
				(xMime z: 1000)
				(gEgo script: 0 view: 4101 setCel: 0 setLoop: 0 setCycle: 0)
				(= seconds 4)
			)
			(2
				(gEgo setSpeed: 12 setCycle: End self)
			)
			(3
				(= ticks 120)
			)
			(4
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(5
				(xMime
					z: 0
					view: 4101
					setCel: 0
					loop: 2
					setCycle: 0
					posn: (- (gEgo x:) 26) (+ (gEgo y:) 1)
				)
				(gEgo
					normalize: 1 902
					setLooper: (ScriptID 401 2) ; xSmallStopGroop
					setStep: 2 1
					setSpeed: (gGame currentSpeed:)
				)
				(= ticks 180)
			)
			(6
				(xMime setCycle: End self)
			)
			(7
				(xMime view: 422 setCycle: StopWalk 422 setCel: 0 setPri: -1)
				(= cycles 1)
			)
			(8
				(= local4 0)
				(gGame handsOn:)
				(SetFlag 102)
				(xMime setMotion: PFollow gEgo 15)
				(self dispose:)
			)
		)
	)
)

(instance womanPath of RegionPath
	(properties
		theRegion 401
	)

	(method (at param1)
		(client room: currentRoom)
		(return [local57 param1])
	)
)

(instance manPath of RegionPath
	(properties
		theRegion 401
	)

	(method (at param1)
		(client room: currentRoom)
		(return [local8 param1])
	)
)

(instance grannyPath of RegionPath
	(properties
		theRegion 401
	)

	(method (at param1)
		(client room: currentRoom)
		(return [local159 param1])
	)
)

(instance boyPath of RegionPath
	(properties
		theRegion 401
	)

	(method (at param1)
		(client room: currentRoom)
		(return [local110 param1])
	)
)

(instance xMime of Actor
	(properties
		noun 5
		modNum 401
		view 422
		loop 1
		signal 16417
	)

	(method (doit)
		(if (and (IsFlag 102) (!= (xMime moveSpeed:) (gEgo moveSpeed:)))
			(self setSpeed: (gEgo moveSpeed:))
		)
		(if
			(and
				(IsFlag 102)
				(not (gEgo script:))
				(not (gEgo mover:))
				(not (xMime script:))
				(< (xMime distanceTo: gEgo) 20)
			)
			(gEgo setScript: sMimeStop)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if
			(OneOf
				theVerb
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
			)
			(gMessager say: noun 0 0 0 0 modNum) ; "Gabriel doesn't want to encourage the mime by showing him anything."
		else
			(switch theVerb
				(7 ; Look
					(Face gEgo xMime)
					(cond
						((== (xMime view:) 420)
							(gMessager say: 5 7 6 0 0 401) ; "It's one of those mimes. Oh, boy."
						)
						((not (IsFlag 102))
							(gMessager say: 5 7 7 0 0 401) ; "Better them than me."
						)
						((IsFlag 102)
							(gMessager say: 5 7 5 0 0 401) ; "Wasn't that mime somewhere else a minute ago?"
						)
					)
					(return 1)
				)
				(12 ; Pickup
					(cond
						((== (xMime view:) 420)
							(gMessager say: 5 12 6 0 0 401) ; "Gabriel probably COULD pick up the mime. The question is, would he want to?"
						)
						((not (IsFlag 102))
							(gMessager say: 5 12 7 0 0 401) ; "Gabriel probably COULD pick up the mime. The question is, would he want to?"
						)
						((IsFlag 102)
							(gMessager say: 5 12 5 0 0 401) ; "It seems that Gabriel has already done that."
						)
					)
					(return 1)
				)
				(11 ; Talk
					(Face gEgo xMime)
					(cond
						((== (xMime view:) 420)
							(gMessager say: 5 11 6 0 0 401) ; "Since Gabriel can't read lips, he's disinclined to start a conversation."
						)
						((not (IsFlag 102))
							(gMessager say: 5 11 7 0 0 401) ; "Since Gabriel can't read lips, he's disinclined to start a conversation."
						)
						((IsFlag 102)
							(if (== local4 10)
								(gCurRoom setScript: sPunchMime)
							else
								(++ local4)
							)
							(gMessager say: 5 11 5 0 0 401) ; "Stop following me!"
						)
					)
					(return 1)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(class xCrash of Actor
	(properties
		noun 2
		modNum 401
		view 444
		signal 24609
		room 410
		destRoom 0
		destX 0
		destY 0
		stopCount 0
		runAway 0
		oldCel 0
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not (Random 0 400))
				(!= gCurRoomNum 420) ; nwJackson
				(xCrash inRect: 0 30 319 150)
				(not (gTalkers size:))
			)
			(gMessager say: 10 0 13 0 0 401) ; "(RRCC. HE'S VERY SICK, WALKING AROUND PARK COUGHING)<cough, cough, cough>"
		)
		(cond
			((not runAway)
				(if (< (self distanceTo: gEgo) 40)
					(= runAway 1)
					(= stopCount gGameTime)
					(self setMotion: MoveTo destX destY self)
					(gGame handsOff:)
				)
			)
			(
				(and
					(self mover:)
					(not (self script:))
					(> (Abs (- gGameTime stopCount)) 200)
				)
				(self setScript: sCrashStop)
			)
		)
	)

	(method (cue)
		(= room destRoom)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (init)
		(super init:)
		(= stopCount gGameTime)
		(self runAway: 0 setStep: 2 1 ignoreActors: 1 setCycle: StopWalk -1)
	)

	(method (doVerb theVerb)
		(if (== theVerb 6) ; Open
			(gMessager say: noun 8 0 0 0 401) ; "(RRCC)Crash is too far away for that."
			(return 1)
		else
			(super doVerb: theVerb)
		)
		(= runAway 1)
		(= stopCount gGameTime)
		(xCrash stopCount: gGameTime setMotion: MoveTo destX destY self)
		(return (gGame handsOff:))
	)
)

(instance sCrashStop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(xCrash oldCel: (xCrash loop:) setMotion: 0)
				(= cycles 4)
			)
			(1
				(xCrash
					view: 447
					setCel: 0
					setLoop:
						(switch (xCrash oldCel:)
							(0 0)
							(1 1)
							(2 2)
							(3 3)
							(4 0)
							(5 1)
							(6 3)
							(else 3)
						)
					setCycle: End self
				)
			)
			(2
				(= seconds (Random 1 3))
			)
			(3
				(xCrash setCycle: Beg self)
			)
			(4
				(xCrash
					view: 444
					stopCount: gGameTime
					setCel: (xCrash oldCel:)
					setCycle: StopWalk -1
					setMotion: MoveTo (xCrash destX:) (xCrash destY:) xCrash
				)
				(self dispose:)
			)
		)
	)
)

(instance xWoman of PedActor
	(properties
		view 417
		signal 8225
	)

	(method (init)
		(self setStep: 2 1 setSpeed: 6 setCycle: Walk)
		(= path womanPath)
		(if path
			(self setMotion: path)
		)
		(super init: &rest)
	)
)

(instance xGranny of PedActor
	(properties
		view 419
		signal 8225
	)

	(method (init)
		(self setStep: 2 1 setSpeed: 6 setCycle: Walk)
		(= path grannyPath)
		(if path
			(self setMotion: path)
		)
		(super init: &rest)
	)
)

(instance xBoy of PedActor
	(properties
		view 418
		signal 8225
	)

	(method (init)
		(self setStep: 2 1 setSpeed: 6 setCycle: Walk)
		(= path boyPath)
		(if path
			(self setMotion: path)
		)
		(super init: &rest)
	)
)

(instance xMan of PedActor
	(properties
		view 416
		signal 8225
	)

	(method (init)
		(self setStep: 2 1 setSpeed: 6 setCycle: Walk)
		(= path manPath)
		(if path
			(self setMotion: path)
		)
		(super init: &rest)
	)
)

(instance xSmallStopGroop of Grooper
	(properties)

	(method (cue &tmp temp0)
		(super cue:)
	)
)

