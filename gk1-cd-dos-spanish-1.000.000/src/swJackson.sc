;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use n013)
(use ExitFeature)
(use GKTeller)
(use PFollow)
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
	swJackson 0
)

(local
	local0 = 1
	local1 = 1
	local2 = 1
)

(instance swJackson of Room
	(properties
		modNum 401
		noun 8
		picture 440
		style 14
		exitStyle 13
		horizon 30
		north 420
		east 430
		south 200
		vanishingY 35536
	)

	(method (init)
		(super init:)
		(if (!= gPrevRoomNum 400)
			(gGkMusic1
				number: 440
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic2 musicVolume:) 5 10 0
			)
		)
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
			(430 ; seJackson
				(if (and (IsFlag 328) (== ((ScriptID 401 7) room:) gCurRoomNum)) ; xCrash
					((ScriptID 401 7) ; xCrash
						init:
						posn: 162 70
						destX: 160
						destY: 20
						destRoom: 420
					)
				)
				(if (< (gEgo y:) 60)
					(gEgo y: 60)
				)
				(gEgo
					posn: 315 (gEgo y:)
					setMotion: PolyPath 300 (gEgo y:)
				)
				(if (IsFlag 102)
					((ScriptID 401 1) posn: 319 (gEgo y:)) ; xMime
				)
			)
			(420 ; nwJackson
				(if (and (IsFlag 328) (== ((ScriptID 401 7) room:) gCurRoomNum)) ; xCrash
					((ScriptID 401 7) ; xCrash
						init:
						posn: 200 120
						destX: 340
						destY: 100
						destRoom: 430
					)
				)
				(if (< (gEgo x:) 20)
					(gEgo x: 20)
				)
				(gEgo
					posn: (gEgo x:) 31
					setMotion: PolyPath (gEgo x:) 40
				)
				(if (IsFlag 102)
					((ScriptID 401 1) posn: (gEgo x:) 31) ; xMime
				)
			)
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
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 94 58 112 58 112 49 133 49 133 57 160 57 160 82 134 82 134 75 94 75
					yourself:
				)
		)
		(bush init:)
		(tree init:)
		(trash init:)
		(lamps init:)
		(sidewalk init:)
		(fence init:)
		(northExit init:)
		(southExit init:)
		(eastExit init:)
		(if (and (not global181) (< 1 gDay 4))
			(luckyDogCart init:)
			(luckyDogVendor
				init:
				ignoreActors: 1
				approachVerbs: 11 10 5 ; Talk, Ask, giftCert
				setScript: sVendorStuff
			)
			(if (not (IsFlag 238))
				(board setPri: 1 init:)
				(tapper
					init:
					approachVerbs: 11 33 ; Talk, luckyDog_
					setCycle: Fwd
					setScript: sTapDance
				)
			)
		)
		(if (and (< 3 gDay 7) (not (IsFlag 298)))
			(beignetCart init:)
			(beignetMan init: approachVerbs: 11) ; Talk
		)
		(trumpet init: setCycle: RandCycle)
		(banjo init: setCycle: Fwd)
		(bass init: setCycle: RandCycle)
		(trombone init: setCycle: RandCycle)
		(if
			(or
				(gCast contains: luckyDogCart)
				(gCast contains: beignetCart)
			)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 319 46 298 56 264 55 246 36 237 32 230 26 231 1 14 1 14 47 18 63 47 93 86 125 118 140 291 140 295 144 319 144
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 319 46 295 46 271 43 252 38 237 32 230 26 231 1 14 1 14 47 18 63 47 93 86 125 118 140 291 140 295 144 319 144
						yourself:
					)
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

	(method (dispose)
		(if (and (== (gEgo edgeHit:) EDGE_BOTTOM) (IsFlag 102))
			(ClearFlag 102)
		)
		(if (!= gPrevRoomNum 400)
			(gGkSound1 stop:)
			(gGkSound1 flags: 1 stop:)
			(gGkMusic1 fade:)
		)
		(mimeTimer3 client: 0 dispose: delete:)
		(super dispose:)
	)

	(method (reflectPosn param1 param2 &tmp temp0)
		(switch param2
			(1
				(param1 y: 136)
			)
			(2
				(param1 x: (+ 0 (param1 xStep:)))
			)
		)
	)
)

(instance sVendorStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(luckyDogVendor setCel: 0 setLoop: 0 setCycle: 0)
				(= seconds 10)
			)
			(1
				(luckyDogVendor setCel: 4 setCycle: Beg self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sTapDance of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(Load 140 412) ; WAVE
				)
				(= cycles 1)
			)
			(1
				(if (!= gPrevRoomNum 400)
					(gGkSound1 setLoop: -1 flags: 5 number: 412 play:)
				)
				(= cycles 1)
			)
			(2
				(cond
					((< (= temp0 (Random 0 100)) 30)
						(tapper loop: 0)
					)
					((< 31 temp0 60)
						(tapper loop: 1)
					)
					((< 61 temp0 90)
						(tapper loop: 2)
					)
					(else
						(-- state)
					)
				)
				(= cycles 1)
			)
			(3
				(tapper setCycle: Fwd)
				(= seconds (Random 1 3))
			)
			(4
				(self changeState: 2)
			)
		)
	)
)

(instance sGiveHotDog of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 33 0 1 self) ; "You wouldn't like a Lucky Dog, by any chance?"
			)
			(1
				(gGkSound1 stop:)
				(gEgo
					looper: 0
					view: 441
					setSpeed: 12
					setCel: 0
					setLoop: 5
					setCycle: 0
				)
				(tapper hide:)
				(UpdateScreenItem gEgo)
				(gMessager say: 3 33 0 2 self) ; "Would I!"
			)
			(2
				(gEgo setCycle: CT 6 1 self)
			)
			(3
				(gEgo setCycle: End)
				(gGkSound1 setLoop: 1 number: 413 play: self)
			)
			(4
				(gEgo getPoints: -999 1)
				(= cycles 1)
			)
			(5
				(gMessager say: 3 33 0 3 self) ; "Thanks, Mister! Ya got any special requests, lemme know."
			)
			(6
				(gGkSound1 setLoop: -1 number: 412 play:)
				(tapper show:)
				(gEgo normalize: 1 902)
				(gEgo setLooper: (ScriptID 401 2) setStep: 2 1) ; xSmallStopGroop
				(SetFlag 112)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetTapper of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gGkSound1 stop:)
				(tapper
					view: 442
					setCel: 0
					setScript: 0
					setLoop: 4 1
					setCycle: 0
				)
				(gMessager say: 7 25 21 0 self) ; "Can you fit through the bars around the statue?"
			)
			(2
				(SetFlag 229)
				(gEgo setMotion: MoveTo 226 20 self)
				(tapper
					view: 442
					setCel: 0
					setLoop: 3 1
					ignoreActors: 1
					setStep: 2 1
					setCycle: Fwd
					setMotion: MoveTo 216 20
				)
			)
			(3
				(gGame handsOn:)
				(gCurRoom newRoom: 420) ; nwJackson
				(self dispose:)
			)
		)
	)
)

(instance sDoSaints of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
				(gGkSound1 setLoop: -1 number: 412 play:)
			)
			(1
				(gGame setCursor: gWaitCursor 1)
				(if register
					(gMessager say: 7 25 24 1 self) ; "How about 'When the Saints Go Marching In'?"
				else
					(gMessager say: 7 25 22 1 self) ; "Could you do 'Saints' again?"
				)
			)
			(2
				(if register
					(gMessager say: 7 25 24 2 self) ; "Sure."
				else
					(gMessager say: 7 25 22 2 self) ; "Yeah, okay. Guys?"
				)
			)
			(3
				(gGkSound1 stop:)
				(tapper
					view: 442
					setCel: 1
					setLoop: 4 1
					setCycle: 0
					setScript: 0
				)
				(if register
					(gMessager say: 7 25 24 3 self) ; "Hey, guys! Saints!"
				else
					(gMessager say: 7 25 22 3 self) ; "Hit it."
				)
			)
			(4
				(if register
					(gMessager say: 7 25 24 4 self) ; "You got it, kid."
				else
					(= cycles 1)
				)
			)
			(5
				(= seconds 30)
				(tapper
					view: 441
					setLoop: 1 1
					setCycle: Fwd
					setScript: sTapDance
				)
				(gGkSound1 setLoop: -1 number: 412 play:)
				(gGkMusic1
					number: 441
					setLoop: -1
					stop:
					play:
					setVol: 0
					fade: (gGkMusic2 musicVolume:) 5 10 0
				)
			)
			(6
				(gGkMusic1
					number: 440
					setLoop: -1
					stop:
					play:
					setVol: 0
					fade: (gGkMusic2 musicVolume:) 5 10 0
				)
				(= cycles 3)
			)
			(7
				(if register
					(gMessager say: 7 25 24 5 self) ; "That was great. Thanks."
				else
					(gMessager say: 7 25 22 4 self) ; "That was great. Thanks."
				)
			)
			(8
				(if register
					(gMessager say: 7 25 24 6 self) ; "No problem, Mister."
				else
					(gMessager say: 7 25 22 5 self) ; "Yup."
				)
			)
			(9
				(gGame handsOn:)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToTapper of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gMessager say: 3 11 2 0 self) ; "You mentioned something about special requests?"
			)
			(1
				(gGkSound1 stop:)
				(tapTeller init: tapper doVerb: 11)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sTalkToMan of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (IsFlag 461)
					(gMessager say: 2 11 36 0 self) ; "(POLITE)Excuse me?"
				else
					(SetFlag 461)
					(gMessager say: 2 11 35 0 self) ; "Hello."
				)
			)
			(1
				(manTeller init: beignetMan doVerb: 11)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sGetHotDog of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 4 5 0 0 self) ; "I have this gift certificate...."
			)
			(1
				(luckyDogVendor
					setScript: 0
					setCel: 0
					setLoop: 1
					setCycle: End self
				)
			)
			(2
				(luckyDogVendor setCel: 0 setLoop: 3 setCycle: End self)
			)
			(3
				(gEgo view: 440 setCel: 9 setLoop: 5 setCycle: Beg self)
				(luckyDogVendor setCel: 0 setLoop: 2 setCycle: End self)
			)
			(4 0)
			(5
				(gEgo
					view: 902
					setCel: 0
					setLoop: 0
					setLooper: (ScriptID 401 2) ; xSmallStopGroop
					setStep: 2 1
					setCycle: StopWalk -1
					init:
					state: 2
				)
				(luckyDogVendor setCel: 6 setLoop: 1 setCycle: Beg self)
			)
			(6
				(gEgo getPoints: -999 1)
				(gGame handsOn:)
				(luckyDogVendor setScript: sVendorStuff)
				(self dispose:)
			)
		)
	)
)

(instance sAnnoyJazz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mimeTimer3 setReal: mimeTimer3 20)
				((ScriptID 401 1) ; xMime
					view: 422
					setSpeed: 6
					setCycle: StopWalk 422
					setPri: -1
					setMotion: PolyPath 129 86 self
				)
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
					setLoop: 3
					setCycle: End self
				)
			)
			(2
				((ScriptID 401 1) ; xMime
					view: 422
					posn: 145 86
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

(instance luckyDogVendor of Actor
	(properties
		noun 4
		approachX 255
		approachY 57
		x 269
		y 53
		view 440
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; giftCert
				(gEgo get: 36) ; luckyDog
				(gEgo put: 5) ; giftCert
				(gCurRoom setScript: sGetHotDog)
			)
			(11 ; Talk
				(cond
					((and (or (IsFlag 112) (gEgo has: 36)) (== local2 1)) ; luckyDog
						(gMessager say: noun 11 6) ; "You seem to be quite a reader."
						(++ local2)
					)
					((and (or (IsFlag 112) (gEgo has: 36)) (> local2 1)) ; luckyDog
						(gMessager say: noun 11 7) ; "The vendor is clearly not interested in further conversation."
					)
					(
						(and
							(not (IsFlag 112))
							(not (gEgo has: 36)) ; luckyDog
							(== local1 1)
						)
						(gMessager say: noun 11 8) ; "Could I get a Lucky Dog, please?"
						(++ local1)
					)
					(
						(and
							(not (IsFlag 112))
							(not (gEgo has: 36)) ; luckyDog
							(>= local1 1)
						)
						(gMessager say: noun 11 9) ; "Hello? Are you selling Lucky Dogs or not?"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tapper of Actor
	(properties
		noun 3
		approachX 249
		approachY 57
		x 233
		y 58
		view 441
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 112)
					(gMessager say: noun 7 2) ; "The little boy's dancing has slowed down a little since he ate the hot dog."
				else
					(gMessager say: noun 7 3) ; "(RRCC)A small boy is tap dancing enthusiastically for a Lucky Dog vendor. The vendor ignores him."
				)
			)
			(33 ; luckyDog_
				(gEgo put: 36) ; luckyDog
				(gCurRoom setScript: sGiveHotDog)
			)
			(11 ; Talk
				(cond
					((and (IsFlag 112) (not (gEgo has: 36))) ; luckyDog
						(self setScript: sTalkToTapper)
					)
					((== local0 1)
						(gMessager say: noun 11 4) ; "You dance pretty well, for a kid."
						(++ local0)
					)
					(else
						(gMessager say: noun 11 5) ; "Do you do requests?"
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

(instance beignetMan of Actor
	(properties
		noun 2
		approachX 269
		approachY 59
		x 290
		y 55
		view 446
		loop 3
		cel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Talk
				(if (IsFlag 298)
					(gMessager say: 7 57 11) ; "So you're definitely going back to Royal and Conti?"
				else
					(gCurRoom setScript: sTalkToMan)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trumpet of Prop
	(properties
		noun 1
		x 132
		y 71
		view 445
		cel 5
		signal 16417
		cycleSpeed 24
	)
)

(instance banjo of Prop
	(properties
		noun 1
		x 118
		y 67
		view 445
		loop 2
		cel 1
		signal 16417
		cycleSpeed 12
	)
)

(instance bass of Prop
	(properties
		noun 1
		x 110
		y 73
		view 445
		loop 4
		cel 5
		signal 16417
		cycleSpeed 12
	)
)

(instance trombone of Prop
	(properties
		noun 1
		x 146
		y 78
		view 445
		loop 6
		cel 1
		signal 16417
		cycleSpeed 24
	)
)

(instance beignetCart of View
	(properties
		x 271
		y 51
		view 446
	)

	(method (doVerb theVerb)
		(beignetMan doVerb: theVerb)
	)
)

(instance luckyDogCart of View
	(properties
		noun 10
		x 255
		y 29
		view 440
		loop 4
	)
)

(instance board of View
	(properties
		x 219
		y 60
		view 441
		loop 7
	)
)

(instance tree of View
	(properties
		noun 11
		x 109
		y 115
		priority 15
		fixPriority 1
		view 409
		loop 3
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bush of View
	(properties
		noun 11
		x 269
		y 81
		priority 6
		fixPriority 1
		view 409
		loop 3
		cel 1
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lamps of Feature
	(properties
		noun 4
		modNum 401
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 22 29 22 64 13 64 13 29 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 189 100 189 140 175 140 175 100
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 302 109 302 141 291 141 291 109
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
					init: 319 21 319 37 269 33 240 22
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
					init: 234 24 264 35 314 39 315 61 275 60 228 51 200 32 200 23
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 53 29 69 62 108 89 163 110 226 122 300 125 289 140 235 141 173 133 84 101 24 54 24 30
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
		nsLeft 13
		nsTop 40
		nsRight 25
		nsBottom 53
		sightAngle 40
		approachX 29
		approachY 48
		approachDist 37
		x 19
		y 46
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "Gabriel doesn't want to throw that away."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance northExit of ExitFeature
	(properties
		nsTop 21
		nsLeft 9
		nsBottom 30
		nsRight 234
		cursor 961
		exitDir 1
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 135
		nsLeft 301
		nsBottom 145
		nsRight 319
		cursor 964
		exitDir 3
	)
)

(instance eastExit of ExitFeature
	(properties
		nsTop 40
		nsLeft 313
		nsBottom 136
		nsRight 319
		cursor 963
		exitDir 2
	)
)

(instance manTeller of GKTeller
	(properties
		curNoun 5
		sayNoun 7
		verb 57
	)

	(method (doVerb theVerb)
		(if (IsFlag 298)
			(return 0)
		else
			(super doVerb: theVerb)
		)
	)

	(method (showCases)
		(super
			showCases:
				10 ; What the heck are "beignets" anyway?
				(and (not (IsFlag 291)) (not (IsFlag 298)))
				12 ; What happened to the guy who used to be here?
				(and (not (IsFlag 292)) (not (IsFlag 298)))
				13 ; Say, haven't I seen you before?
				(and (not (IsFlag 293)) (== gDay 6))
				14 ; You say you used to be at Royal and Conti?
				(IsFlag 293)
				11 ; You say you're going back to Royal and Conti?
				(IsFlag 298)
				15 ; Nice place.
				(not (IsFlag 295))
				18 ; Why don't you go back there?
				(and (not (IsFlag 296)) (== gDay 6))
				19 ; I definitely think you should go back to Royal and Conti.
				(and (IsFlag 296) (not (IsFlag 298)))
				17 ; Why did you leave Royal and Conti?
				(not (IsFlag 297))
		)
	)

	(method (cue)
		(switch iconValue
			(20 ; Oh, nothing.
				(self newNoun: 5)
				(self dispose:)
			)
			(16 ; Oh, nothing.
				(self newNoun: 5)
				(self dispose:)
			)
			(10 ; What the heck are "beignets" anyway?
				(SetFlag 291)
				(if (not (IsFlag 292))
					(self doVerb: 11)
				)
			)
			(12 ; What happened to the guy who used to be here?
				(SetFlag 292)
				(if (not (IsFlag 291))
					(self doVerb: 11)
				)
			)
			(13 ; Say, haven't I seen you before?
				(SetFlag 293)
				(self doVerb: 11)
			)
			(14 ; You say you used to be at Royal and Conti?
				(SetFlag 294)
				(self doVerb: 11)
			)
			(15 ; Nice place.
				(SetFlag 295)
				(self doVerb: 11)
			)
			(18 ; Why don't you go back there?
				(SetFlag 296)
				(self doVerb: 11)
			)
			(17 ; Why did you leave Royal and Conti?
				(SetFlag 297)
				(self doVerb: 11)
			)
			(19 ; I definitely think you should go back to Royal and Conti.
				(SetFlag 298)
				(gEgo getPoints: -999 2)
				(self doVerb: 11)
			)
			(else
				(self doVerb: 11)
			)
		)
	)
)

(instance tapTeller of GKTeller
	(properties
		curNoun 8
		sayNoun 7
		verb 25
	)

	(method (showCases)
		(super
			showCases:
				21 ; Can you fit through the bars around the statue?
				(IsFlag 228)
				23 ; Can you do the Nutcracker Suite in D Minor?
				(not (IsFlag 300))
				24 ; How about "When the Saints Go Marching In"?
				(not (IsFlag 301))
				22 ; Could you do "Saints" again?
				(IsFlag 301)
		)
	)

	(method (sayMessage)
		(switch iconValue
			(21 ; Can you fit through the bars around the statue?
				(gCurRoom setScript: sGetTapper)
			)
			(24 ; How about "When the Saints Go Marching In"?
				(SetFlag 301)
				(gCurRoom setScript: sDoSaints 0 1)
			)
			(22 ; Could you do "Saints" again?
				(gCurRoom setScript: sDoSaints 0 0)
			)
			(else
				(super sayMessage:)
			)
		)
	)

	(method (cue)
		(switch iconValue
			(21 0) ; Can you fit through the bars around the statue?
			(25 ; Can't think of anything at the moment.
				(self dispose:)
			)
			(23 ; Can you do the Nutcracker Suite in D Minor?
				(SetFlag 300)
				(self doVerb: 11)
			)
			(24 ; How about "When the Saints Go Marching In"?
				(SetFlag 301)
				(self dispose:)
			)
			(22 ; Could you do "Saints" again?
				(SetFlag 301)
				(self dispose:)
			)
			(else
				(self doVerb: 11)
			)
		)
	)
)

(instance specialMimeCode of Code
	(properties)

	(method (doit)
		(cond
			((and (IsFlag 102) ((ScriptID 401 1) inRect: 85 64 163 84)) ; xMime
				(ClearFlag 102)
				((ScriptID 401 1) setScript: sAnnoyJazz) ; xMime
			)
			(
				(and
					(not (IsFlag 102))
					(== ((ScriptID 401 1) script:) sAnnoyJazz) ; xMime
					(gEgo inRect: 115 86 145 90)
				)
				(SetFlag 102)
				(mimeTimer3 dispose:)
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

(instance mimeTimer3 of Timer
	(properties)

	(method (cue)
		(gMessager say: 1 13 1 1) ; "Ya'll gonna get it if ya'll keep at that."
		((ScriptID 401 1) setScript: sMimeLeaves) ; xMime
	)
)

