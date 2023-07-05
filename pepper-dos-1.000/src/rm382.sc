;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 382)
(include sci.sh)
(use Main)
(use ExitFeature)
(use BalloonTalker)
(use ADRoom)
(use Print)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm382 0
	offSrnT 1
	butlerT 2
	postal2T 3
	nellieT 4
	gluttonT 7
	vicarT 10
	sentry1 11
	sentry2 12
	pughT 13
	percyT 14
	benT 16
	debbieT 17
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
	local8
	local9
	local10 = 1
	local11 = 1
	local12
)

(procedure (localproc_0)
	(frontdoors approachVerbs: 0)
	(doorknob approachVerbs: 0)
	(closetDoor approachVerbs: 0)
)

(procedure (localproc_1)
	(frontdoors approachVerbs: 7 6) ; Do, Look
	(doorknob approachVerbs: 7 6) ; Do, Look
	(closetDoor approachVerbs: 30 7 6 86) ; Paw, Do, Look, Nose
)

(class ClosetScript of Script
	(properties)

	(method (closetSystem param1 param2 param3)
		(cond
			(param3
				(if local7
					(closetDoorCycler view: 441 loop: 1 posn: 149 51)
				else
					(closetDoorCycler posn: 149 51 cycleSpeed: 10 setCycle: End)
				)
			)
			(local7
				(closetDoorCycler dispose:)
			)
			(else
				(closetDoorCycler setCycle: CT 1 -1)
			)
		)
		(if argc
			(= caller param1)
			(if (and (IsObject caller) param2)
				(caller cue:)
			)
		)
	)
)

(instance rm382 of ADRoom
	(properties
		modNum 380
		noun 1
		picture 380
		north 400
		east 370
		west 390
		vanishingY 54
	)

	(method (init)
		((ScriptID 895 0) ; pepper
			init:
			normalize: 790 2
			posn: 239 54
			setScale: Scaler 102 75 79 52
		)
		(= local6 1)
		(= local5 1)
		(localproc_1)
		(switch gPrevRoomNum
			(north
				(gCurRoom setScript: sExitMaze)
			)
			(610
				(switch global199
					(14
						(gGame setEgo: (ScriptID 895 1)) ; lockjaw
						((ScriptID 895 0) ; pepper
							view: 3971
							loop: 0
							x: 239
							y: 54
							init:
							stopUpd:
						)
						((ScriptID 895 1) ; lockjaw
							normalize: 807 2
							x: 260
							y: 52
							init:
							normal: 0
							setScript: 0
							stopUpd:
						)
						(comeInTimer setReal: comeInTimer 30)
						(SetCursor 150 -5)
						(gGame handsOn:)
					)
					(15
						(gGame setEgo: (ScriptID 895 0)) ; pepper
						(song number: 387 loop: -1 play:)
						((ScriptID 895 0) ; pepper
							view: 397
							loop: 0
							cel: 0
							x: 174
							y: 54
							cel: 5
							init:
							hide:
							stopUpd:
						)
						((ScriptID 895 1) ; lockjaw
							init:
							view: 442
							loop: 7
							cel: 0
							x: 281
							y: 115
							normal: 0
							setScript: 0
							stopUpd:
						)
						(ima view: 832 loop: 0 x: 255 y: 150 init: stopUpd:)
						((ScriptID 2018 1) x: 89 y: (- (ima y:) 40) tailPosn: 1) ; imaText
						(closetDoorCycler
							view: 441
							loop: 1
							posn: 149 51
							init:
							stopUpd:
						)
						(dyePot init: stopUpd:)
						(dyePotTimer setReal: dyePotTimer 30)
						(SetCursor 150 -5)
						(= local8 1)
						(gWalkHandler addToFront: gCurRoom)
						(gMouseDownHandler addToFront: gCurRoom)
						(gKeyDownHandler addToFront: gCurRoom)
						(gDirectionHandler addToFront: gCurRoom)
						(gGame handsOn:)
					)
					(17
						(gGame setEgo: (ScriptID 895 1)) ; lockjaw
						(song number: 382 loop: -1 flags: 1 play:)
						((ScriptID 895 0) ; pepper
							normalize: 790 5
							x: 302
							y: 114
							init:
							view: 397
							loop: 7
							setScale: 0
							stopUpd:
						)
						(ima
							view: 397
							loop: 1
							cel: 0
							x: 146
							y: 187
							setPri: 14
							init:
							stopUpd:
						)
						(pugh
							view: 398
							loop: 0
							cel: 3
							x: 118
							y: 165
							init:
							stopUpd:
						)
						(percy
							view: 384
							setLoop: 1
							cel: 6
							x: 236
							y: 158
							sightAngle: 360
							init:
							stopUpd:
						)
						(percyT x: 68 y: 117 tailPosn: 1)
						(localproc_0)
						(percyTimer setReal: percyTimer 30)
						(gWalkHandler addToFront: gCurRoom)
						(gMouseDownHandler addToFront: gCurRoom)
						(gKeyDownHandler addToFront: gCurRoom)
						(gDirectionHandler addToFront: gCurRoom)
						((ScriptID 895 1) ; lockjaw
							x: 281
							y: 115
							init:
							normal: 0
							setScript: 0
							view: 397
							loop: 4
							setCycle: 0
							stopUpd:
						)
						(SetCursor 150 -5)
						(gGame handsOn:)
					)
					(18
						(gGame setEgo: (ScriptID 895 0)) ; pepper
						(song number: 383 loop: -1 flags: 1 play:)
						((ScriptID 895 0) ; pepper
							normalize: 790 1
							x: 282
							y: 141
							init:
							stopUpd:
						)
						((ScriptID 895 1) ; lockjaw
							x: 299
							y: 157
							init:
							view: 397
							loop: 4
							normal: 0
							setScript: 0
							setCycle: 0
							ignoreActors: 0
							stopUpd:
						)
						(ima
							view: 397
							loop: 1
							cel: 0
							x: 146
							y: 187
							setPri: 14
							init:
							stopUpd:
						)
						(percy
							view: 397
							loop: 2
							cel: 0
							x: 50
							y: 185
							setPri: 14
							init:
							stopUpd:
						)
						(pugh
							view: 818
							loop: 0
							cel: 5
							x: 237
							y: 153
							init:
							stopUpd:
						)
						(pughT x: 81 y: 107 tailPosn: 1)
						(localproc_0)
						(pughTimer setReal: pughTimer 30)
						(gWalkHandler addToFront: gCurRoom)
						(gMouseDownHandler addToFront: gCurRoom)
						(gKeyDownHandler addToFront: gCurRoom)
						(gDirectionHandler addToFront: gCurRoom)
						(SetCursor 150 -5)
						(gGame handsOn:)
					)
					(else
						(gCurRoom setScript: sExitMaze)
					)
				)
			)
			(else
				(gCurRoom setScript: sDEBUG1)
				(pailInKitchen init: stopUpd:)
				(gGame handsOn:)
				(gEgo posn: 105 160)
			)
		)
		(super init: &rest)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 316 51 252 51 243 44 265 39 235 39 214 38 233 51 107 51 102 54 233 54 260 66 276 107 261 140 219 161 154 174 143 161 147 151 235 131 229 127 181 127 174 107 126 97 125 101 162 111 162 128 107 128 69 131 24 163 32 168 127 172 184 185 241 189 276 169 284 147 309 138 315 123 298 81 260 54 312 54
					yourself:
				)
		)
		(chandelier init: setOnMeCheck: 1 16384)
		(closetDoor init:)
		(doorknob init:)
		(frontdoors init: stopUpd:)
		(lamp init:)
		(pailInKitchen init: stopUpd:)
		(pic1 init:)
		(pic2 init:)
		(pic3 init:)
		(pic4 init:)
		(bannister init: setOnMeCheck: 1 8192)
		(columns init: setOnMeCheck: 1 2048)
		(stairs init: setOnMeCheck: 1 4096)
		(northKitEFeature init:)
		(upstairsEFeature init:)
		(eastEFeature init:)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script)
			((& temp0 $0002)
				(cond
					((> (dyePotTimer seconds:) 0)
						(gCurRoom setScript: sDyePotExpires)
					)
					((IsFlag 372)
						(gCurRoom setScript: sGetDoor)
					)
					((IsFlag 90)
						(gCurRoom setScript: sDontLeave)
					)
					(else
						(gCurRoom newRoom: 400 10) ; Maze
					)
				)
			)
			((& temp0 $0004)
				(cond
					((> (moneyTimer seconds:) 0)
						(gCurRoom setScript: sGiveMoneyBag)
					)
					((IsFlag 372)
						(gCurRoom setScript: sGetDoor)
					)
					((> (moneyTimer seconds:) 0)
						(gCurRoom setScript: sGiveMoneyBag)
					)
				)
			)
			((& temp0 $0008)
				(cond
					((> (moneyTimer seconds:) 0)
						(gCurRoom setScript: sGiveMoneyBag)
					)
					((IsFlag 372)
						(gCurRoom setScript: sGetDoorL)
					)
					((> (moneyTimer seconds:) 0)
						(gCurRoom setScript: sGiveMoneyBag)
					)
					(else
						(gCurRoom newRoom: east)
					)
				)
			)
			((and (& temp0 $1000) (> (dyePotTimer seconds:) 0))
				(gCurRoom setScript: sDyePotExpires)
			)
			((and (& temp0 $1000) (> (moneyTimer seconds:) 0))
				(gCurRoom setScript: sGiveMoneyBag)
			)
			((and (& temp0 $1000) (< (gEgo y:) 82) (not local10))
				(= local10 1)
				(gCurRoom vanishingY: 81)
				(gEgo setScale: Scaler 102 75 79 52)
			)
			(
				(and
					(& temp0 $1000)
					(< (gEgo y:) 167)
					(> (gEgo y:) 82)
					local10
				)
				(= local10 0)
				(gEgo setScale: 0)
			)
			((and (& temp0 $1000) (> (gEgo y:) 167) (not local10))
				(gCurRoom vanishingY: 54)
				(= local10 1)
				(gEgo setScale: 160)
			)
			(
				(and
					local6
					(InRect
						266
						76
						304
						97
						((ScriptID 895 1) x:) ; lockjaw
						((ScriptID 895 1) y:) ; lockjaw
					)
					(not (gCast contains: pugh))
				)
				(gCurRoom setScript: sImaNoticesLockjawOnStairs)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(= temp1 (event type:))
		(= temp0 (event message:))
		(if
			(or
				(and (== temp1 evMOUSEBUTTON) (not (event modifiers:)))
				(and (== temp1 evKEYBOARD) (== temp0 KEY_RETURN))
				(== temp1 evVERB)
			)
			(cond
				((and (not (gUser controls:)) (not (gUser input:)))
					(event claimed: 1)
				)
				(
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
						(== gEgo (ScriptID 895 1)) ; lockjaw
						(> (percyTimer seconds:) 0)
					)
					((ScriptID 895 1) setMotion: 0) ; lockjaw
					(percyTimer cycleCnt: 3)
					(event claimed: 1)
				)
				(
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
						(== gEgo (ScriptID 895 0)) ; pepper
					)
					(cond
						((> (pughTimer seconds:) 0)
							((ScriptID 895 0) setMotion: 0) ; pepper
							(pughTimer cycleCnt: 3)
							(event claimed: 1)
						)
						((> (dyePotTimer seconds:) 0)
							((ScriptID 895 0) setMotion: 0) ; pepper
							(dyePotTimer cycleCnt: 3)
							(event claimed: 1)
						)
						((> (moneyTimer seconds:) 0)
							((ScriptID 895 0) setMotion: 0) ; pepper
							(gMessager say: 20 0 34 0 0 380) ; "Pepper doesn't have time to go wandering around! She has to come up with some evidence against General Pugh!"
							(event claimed: 1)
						)
					)
				)
				(
					(and
						(not (== (gTheIconBar curIcon:) (gTheIconBar at: 1)))
						local8
						(== gEgo (ScriptID 895 0)) ; pepper
						(> (dyePotTimer seconds:) 0)
					)
					(if (dyePot onMe: event)
						(gCurRoom setScript: sDumpDiePotIma)
					else
						(gCurRoom setScript: sWrongTimeDyePot)
					)
					(event claimed: 1)
				)
				(else
					(event claimed: 0)
					(super handleEvent: event)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(= global215 8)
				(super doVerb: theVerb &rest)
			)
			(6 ; Look
				(gMessager say: 1 6 0 0 0 380) ; "This is the Penn Mansion Foyer. Fancy, isn't it?"
			)
			(7 ; Do
				(gMessager say: 1 7 0 0 0 380) ; "There's nothing Pepper wants to do there."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(song play:)
	)

	(method (dispose)
		(gWalkHandler delete: gCurRoom)
		(gMouseDownHandler delete: gCurRoom)
		(gKeyDownHandler delete: gCurRoom)
		(gDirectionHandler delete: gCurRoom)
		(comeInTimer dispose: delete:)
		(dyePotTimer dispose: delete:)
		(percyTimer dispose: delete:)
		(pughTimer dispose: delete:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		((ScriptID 895 1) setScript: (ScriptID 838 0) 0 0) ; lockjaw, LockjawStuff
		(super newRoom: newRoomNumber)
	)
)

(instance sDEBUG1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ima
					view: 397
					loop: 1
					cel: 0
					posn: 146 187
					setPri: 14
					init:
					stopUpd:
				)
				(percy
					view: 397
					loop: 2
					cel: 0
					posn: 50 185
					setPri: 14
					init:
					stopUpd:
				)
				(pugh
					view: 397
					loop: 3
					cel: 0
					posn: 58 186
					setPri: 14
					init:
					stopUpd:
				)
				((ScriptID 895 1) ; lockjaw
					view: 807
					loop: 8
					cel: 7
					posn: 139 193
					setPri: 15
					init:
					addToPic:
					normal: 0
					setScript: 0
				)
				(pughT x: 34 y: 152 tailPosn: 0)
				((ScriptID 2018 1) ; imaText
					x: (- (ima x:) 1)
					y: (- (ima y:) 37)
					tailPosn: 0
				)
				(butlerT x: 38 y: 93 tailPosn: 0)
				((ScriptID 895 0) normalize: 790 5 posn: 283 128) ; pepper
				(= cycles 1)
			)
			(1
				(Prints {*** there is a knock on the door.})
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAtClosetDoor of ClosetScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) ; pepper
					normalize: 790 1
					ignoreActors: 1
					setMotion: MoveTo 189 55 self
				)
				(closetDoorCycler init: stopUpd:)
			)
			(2
				(if register
					(= temp0 12)
				else
					(= temp0 11)
				)
				((ScriptID 2004 0) winX: 70 winY: 63 tailPosn: 4) ; LockjawTalker
				((ScriptID 2000 3) winX: 11 winY: 47 tailPosn: 4) ; PepperTalker
				(gMessager say: 22 30 temp0 0 self 380)
			)
			(3
				(if (not register)
					(gGame handsOn:)
					(= next 0)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(4
				(sFX number: 922 play:)
				(self closetSystem: self 1 1)
			)
			(5
				(= seconds 1)
			)
			(6
				((ScriptID 895 0) hide: view: 397 loop: 0 cel: 0) ; pepper
				((ScriptID 895 1) hide: view: 397 loop: 0 cel: 0) ; lockjaw
				(= seconds 2)
			)
			(7
				(self closetSystem: self 1 0)
			)
			(8
				(closetDoorCycler view: 441 loop: 0)
				(gGame points: 372 2)
				(= cycles 1)
			)
			(9
				(ima stopUpd:)
				(self dispose:)
			)
		)
	)

	(method (init)
		(= next sLookForLockjaw)
		(super init: &rest)
	)
)

(instance sStompFoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ima setCycle: CT 5 1 self)
			)
			(1
				(sFX2 number: 3803 loop: 1 play:)
				(= cycles 1)
			)
			(2
				(ima setCycle: End self)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance sLookForLockjaw of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(song number: 387 loop: -1 play:)
				(= local12 1)
				(butler
					view: 381
					loop: 2
					cel: 0
					posn: 169 127
					setScale: 160
					init:
					setCycle: Walk
					setMotion: PolyPath 170 176 self
				)
			)
			(2
				(closetDoorCycler stopUpd:)
				(butler loop: 4 cel: 1 stopUpd:)
				(ima
					init:
					view: 832
					loop: 2
					cel: 0
					posn: 169 124
					setCycle: Walk
					setMotion: MoveTo 99 172 self
				)
			)
			(3
				(Face ima butler self)
			)
			(4
				(ima loop: 4 cel: 0 stopUpd:)
				((ScriptID 2018 1) x: 108 y: 126) ; imaText
				(gMessager say: 20 0 13 1 self 380) ; "Come on, come on! Hurry up, Rigormort! I can't wait to dye my doggie! HURRY!"
			)
			(5
				(butler
					view: 381
					setCycle: Walk
					setMotion: PolyPath 218 55 self
				)
			)
			(6
				(gMessager say: 20 0 13 2 self 380) ; "WAIT!!!"
			)
			(7
				(Face butler ima self)
			)
			(8
				(gMessager say: 20 0 13 3 5 self 380) ; "Yes, Miss?"
			)
			(9
				(ima view: 382 loop: 0 cel: 3 setScript: sStompFoot)
				(butler
					view: 382
					loop: 1
					cel: 0
					posn: 218 55
					cycleSpeed: 10
					setCycle: CT 3 1 self
				)
			)
			(10
				(dyePot init: stopUpd:)
				(= cycles 1)
			)
			(11
				(butler setCycle: End self)
			)
			(12
				(butler
					view: 820
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 330 51 self
				)
			)
			(13
				(butler dispose:)
				((ScriptID 895 0) hide: stopUpd:) ; pepper
				((ScriptID 895 1) stopUpd:) ; lockjaw
				(= cycles 1)
			)
			(14
				(self dispose:)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(
				(and
					(& (= temp0 (butler onControl: 1)) $1000)
					(< (butler y:) 82)
					(not local11)
				)
				(= local11 1)
				(gCurRoom vanishingY: 81)
				(butler setScale: Scaler 102 75 79 52)
			)
			(
				(and
					(& temp0 $1000)
					(< (butler y:) 167)
					(> (butler y:) 82)
					local11
				)
				(= local11 0)
				(butler setScale: 0)
			)
			((and (& temp0 $1000) (> (butler y:) 167) (not local11))
				(gCurRoom vanishingY: 54)
				(= local11 1)
				(butler setScale: 160)
			)
		)
		(super doit:)
	)

	(method (init)
		(= next sLockjawActingSilly)
		(super init: &rest)
	)
)

(instance sLockjawActingSilly of ClosetScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 20 0 13 6 7 self 380) ; "(WHISPER) I'd like to dye HER, the goose-necked little creep!"
			)
			(1
				(ima view: 832 loop: 4 cel: 2 setCycle: 0 setScript: 0)
				(= cycles 1)
			)
			(2
				(ima stopUpd: cel: 3)
				(= cycles 1)
			)
			(3
				(butler
					view: 820
					setLoop: 1
					cel: 0
					posn: 330 51
					init:
					setCycle: Walk
					setMotion: MoveTo 292 54 self
				)
			)
			(4
				(gMessager say: 20 0 13 8 9 self 380) ; "Miss Ima! I don't know how to tell you this, but..."
			)
			(5
				(butler view: 820 setLoop: 2 stopUpd:)
				(= cycles 1)
			)
			(6
				(ima
					view: 382
					loop: 3
					cel: 0
					posn: (+ (ima x:) 13) (- (ima y:) 4)
					setCycle: Fwd
				)
				(= cycles 3)
			)
			(7
				(gMessager say: 20 0 13 10 self 380) ; "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH!!! (BLOODCURDLING SHRIEK!)"
			)
			(8
				(ima stopUpd:)
				(butler
					view: 382
					loop: 4
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(9
				(= seconds 2)
			)
			(10
				(butler view: 820 loop: 2 setCycle: 0)
				(ima
					view: 832
					loop: 4
					cel: 3
					posn: (- (ima x:) 13) (+ (ima y:) 4)
					setCycle: 0
					stopUpd:
				)
				(= cycles 1)
			)
			(11
				(gMessager say: 20 0 13 11 12 self 380) ; "Oh, FLUFFUMS! This is all your fault, Rigormort! Go find him, you idiot, or I'll dye YOU blue and throw you off the roof!"
			)
			(12
				(butler
					view: 820
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 330 51 self
				)
			)
			(13
				(gMessager say: 20 0 13 13 15 self 380) ; "Fluffy! Fluffy wuffums! Where are you? SOB! Come to mommy, you bad boy! SNIVEL! Don't you WUV your mommy? Fluffums! FLUFFUMS! WAAAH!"
			)
			(14
				(butler dispose:)
				(= local7 1)
				((ScriptID 895 1) ; lockjaw
					normalize: 807 4
					init:
					show:
					normal: 0
					setScript: 0
				)
				(self closetSystem: self 1 1)
			)
			(15
				(self closetSystem: self 1 1)
			)
			(16
				((ScriptID 895 1) setMotion: PolyPath 260 60 self) ; lockjaw
			)
			(17
				(sFX number: 3816 loop: 1 play:)
				((ScriptID 895 1) ; lockjaw
					view: 398
					loop: 2
					cel: 0
					posn:
						(+ ((ScriptID 895 1) x:) 7) ; lockjaw
						(+ ((ScriptID 895 1) y:) 21) ; lockjaw
					setSpeed: 12
					setCycle: End self
				)
			)
			(18
				((ScriptID 895 1) ; lockjaw
					view: 442
					loop: 7
					cel: 0
					posn:
						(+ ((ScriptID 895 1) x:) 14) ; lockjaw
						(+ ((ScriptID 895 1) y:) 34) ; lockjaw
					setCycle: End self
				)
				((ScriptID 2004 0) ; LockjawTalker
					winX: 172
					winY: 108
					talkWidth: 90
					tailPosn: 1
				)
			)
			(19
				(self dispose:)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(= next sImaKissingUpToLockjaw)
	)
)

(instance sImaKissingUpToLockjaw of ClosetScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 895 1) ; lockjaw
					view: 442
					loop: 7
					cel: 0
					cycleSpeed: 10
					setCycle: Fwd
				)
				(= cycles 1)
			)
			(1
				(= seconds 1)
			)
			(2
				(ima startUpd:)
				((ScriptID 2004 0) ; LockjawTalker
					winX: 158
					winY: 95
					tailPosn: 1
					talkWidth: 100
				)
				(gMessager say: 20 0 13 16 self 380) ; "Whiiine! Whine whine whine!"
			)
			(3
				(Face ima (ScriptID 895 1) self) ; lockjaw
			)
			(4
				(gMessager say: 20 0 13 17 self 380) ; "AAAAAAAAAAAAAAAAAAAAAAAAAH! It's my Fluffy-wuffums!"
			)
			(5
				(ima view: 832 setCycle: Walk setMotion: PolyPath 255 150 self)
			)
			(6
				(ima loop: 4 cel: 0 stopUpd:)
				((ScriptID 2018 1) x: 88 y: 102 tailPosn: 1 talkWidth: 150) ; imaText
				(gMessager say: 20 0 13 18 self 380) ; "AAAAAAAAAAAAAAAAAAAAH!!! HIM'S HURT! Oh, my poor baby-kins. Come to Mommy. She'll fix you up all better, yes her will! Stay there, kissy boy!"
			)
			(7
				(= local8 1)
				(= cycles 1)
			)
			(8
				(gGame setEgo: (ScriptID 895 0) handsOn:) ; pepper
				(localproc_0)
				(gWalkHandler addToFront: gCurRoom)
				(gMouseDownHandler addToFront: gCurRoom)
				(gKeyDownHandler addToFront: gCurRoom)
				(gDirectionHandler addToFront: gCurRoom)
				(= cycles 1)
			)
			(9
				(SetCursor 150 -5)
				(= cycles 1)
			)
			(10
				((ScriptID 895 1) ; lockjaw
					view: 397
					loop: 4
					setCycle: 0
					cycleSpeed: -1
					stopUpd:
				)
				(dyePotTimer setReal: dyePotTimer 30)
				(self dispose:)
			)
		)
	)
)

(instance sDumpDiePotIma of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 373 4)
				(gWalkHandler delete: gCurRoom)
				(gMouseDownHandler delete: gCurRoom)
				(gKeyDownHandler delete: gCurRoom)
				(gDirectionHandler delete: gCurRoom)
				(dyePotTimer dispose: seconds: 0 delete:)
				(= cycles 1)
			)
			(1
				(closetDoorCycler dispose:)
				(= local8 0)
				((ScriptID 895 0) normalize: 790 2 posn: 174 54 cel: 5 show:) ; pepper
				(= cycles 1)
			)
			(2
				(gEgo setMotion: MoveTo 195 53 self)
			)
			(3
				(gEgo setHeading: 180)
				(= cycles 1)
			)
			(4
				(dyePot posn: 204 22 0 hide:)
				(sFX number: 3805 play:)
				(gEgo
					view: 383
					loop: 0
					cel: 0
					posn: 204 50
					setCycle: End self
				)
			)
			(5
				(gEgo view: 397 loop: 7 stopUpd:)
				(dyePot
					view: 383
					setLoop: 1
					setCycle: Fwd
					setPri: 14
					setStep: 1 8
					posn: 231 43 0
					show:
					setMotion: MoveTo (ima x:) (- (ima y:) 45) self
				)
			)
			(6
				(= local1 1)
				(dyePot cel: 6 setCycle: 0 stopUpd:)
				(percy stopUpd:)
				(= cycles 1)
			)
			(7
				(ShakeScreen 3 (Random 1 3))
				(= cycles 2)
			)
			(8
				(client setScript: sImaTumblesDown)
			)
		)
	)
)

(instance sImaTumblesDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dyePot dispose:)
				(ima view: 383 loop: 2 cel: 0 posn: 252 144 setPri: 11)
				(song number: 381 loop: -1 pause:)
				(gMessager say: 19 7 1 1 self 380) ; "EEEEEEEEE!!!  DADDEEEEEEEEE!!!"
				(sFX number: 3806 play: self)
			)
			(1 0)
			(2
				(sFX number: 3810 play: gCurRoom)
				(ima setCycle: End self)
			)
			(3
				(ima
					setLoop: 3
					cel: 0
					posn: 191 169
					setSpeed: 7
					setStep: 12 10
					setCycle: Fwd
					setMotion: MoveTo 160 175 self
				)
			)
			(4
				(ima
					loop: 4
					cel: 0
					posn: 146 187
					setPri: 12
					ignoreActors: 1
					setCycle: End self
				)
				(pugh
					init:
					ignoreActors: 1
					setStep: 5 4
					setSpeed: 9
					setScale: Scaler 100 56 165 114
					setCycle: Walk
					setMotion: PolyPath 118 165 self
				)
			)
			(5
				((ScriptID 2000 3) winX: 41 winY: 43 tailPosn: 4) ; PepperTalker
				(gMessager say: 19 7 1 2 self 380) ; "WHAT A SHOT! THE CROWD GOES WILD! YAAAAAAAY!"
				0
			)
			(6 0)
			(7
				(ima view: 397 loop: 1 setPri: 14 stopUpd:)
				((ScriptID 895 0) stopUpd:) ; pepper
				(pugh view: 398 loop: 0 stopUpd:)
				(pughT x: 137 y: 112)
				((ScriptID 2018 1) ; imaText
					x: (- (ima x:) 1)
					y: (- (ima y:) 37)
					tailPosn: 0
				)
				(gMessager say: 20 0 14 1 3 self 380) ; "What in blazes is going on here? IMA! OH, NO! Darling, are you hurt?!?"
			)
			(8
				(self dispose:)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(= next sPercyGoesAfterLJ)
	)
)

(instance sPercyGoesAfterLJ of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(percy
					init:
					setScale: Scaler 100 56 165 114
					setSpeed: 9
					setStep: 5 4
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 100 175 self
				)
			)
			(1
				(percy setHeading: 90 stopUpd:)
				(percyT x: 97 y: 123 tailPosn: 0)
				(= cycles 1)
			)
			(2
				(gMessager say: 20 0 14 4 self 380) ; "Rrrrrrrrrrrrrrrrrrrrrr!"
				(sFX number: 905 play: self)
			)
			(3)
			(4
				(sFX number: 3817 loop: 1 play:)
				(= ticks 30)
			)
			(5
				(sFX play:)
				(= ticks 30)
			)
			(6
				(sFX play: self)
			)
			(7
				((ScriptID 2000 3) winX: 41 winY: 43 tailPosn: 4) ; PepperTalker
				(gMessager say: 20 0 14 5 10 self 380) ; "Open this door, General Pugh! Let the people be heard!"
			)
			(8
				((ScriptID 895 0) stopUpd:) ; pepper
				(song number: 382 loop: -1 play:)
				(pugh view: 398 loop: 0 cel: 0 setCycle: End self)
			)
			(9
				(pugh stopUpd:)
				((ScriptID 895 0) ; pepper
					normalize: 790 2
					setMotion: PolyPath 302 114 self
				)
				(percy
					view: 384
					setLoop: 1
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 236 158 self
				)
			)
			(10 0)
			(11
				((ScriptID 895 0) view: 397 loop: 7 stopUpd:) ; pepper
				(percyT x: 44 y: 111 tailPosn: 1)
				((ScriptID 2000 3) winX: 132 winY: 79 tailPosn: 1) ; PepperTalker
				(percy stopUpd:)
				(gGame setEgo: (ScriptID 895 1)) ; lockjaw
				(gMessager say: 20 0 14 11 self 380) ; "Nice doggie! Good boy! (SOUNDS TERRIFIED)"
			)
			(12
				(percyT x: 89 y: 89 tailPosn: 1)
				(gMessager say: 20 0 14 12 self 380) ; "Sic 'em, Lockjaw! Sic 'em!"
			)
			(13
				(= cycles 1)
			)
			(14
				(localproc_0)
				(percyTimer setReal: percyTimer 30)
				(gWalkHandler addToFront: gCurRoom)
				(gMouseDownHandler addToFront: gCurRoom)
				(gKeyDownHandler addToFront: gCurRoom)
				(gDirectionHandler addToFront: gCurRoom)
				(gEgo normalize: 807 5)
				(gGame handsOn:)
				(SetCursor 100 -5)
				(self dispose:)
			)
		)
	)
)

(instance sTeethOnPercy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 374 2)
				(localproc_1)
				(percyTimer dispose: seconds: 0 delete:)
				(gWalkHandler delete: gCurRoom)
				(gMouseDownHandler delete: gCurRoom)
				(gKeyDownHandler delete: gCurRoom)
				(gDirectionHandler delete: gCurRoom)
				(= cycles 1)
			)
			(1
				(self setScript: sPercyFalls self)
			)
			(2
				((ScriptID 895 0) ; pepper
					normalize: 790 5
					setMotion: PolyPath 282 141 self
				)
			)
			(3
				((ScriptID 895 0) view: 397 loop: 7 stopUpd:) ; pepper
				((ScriptID 895 1) setSpeed: 3 setMotion: PolyPath 299 157 self) ; lockjaw
			)
			(4
				((ScriptID 895 1) ; lockjaw
					view: 397
					loop: 4
					setCycle: 0
					setSpeed: local9
					stopUpd:
				)
				((ScriptID 2000 3) winX: 0 winY: 0) ; PepperTalker
				(pughT x: 137 y: 112 tailPosn: 0)
				(gMessager say: 20 0 16 0 self 380) ; "Blasted fool! I'll just catch the little rotters myself!"
			)
			(5
				(percyT x: (- (percy x:) 2) y: (- (percy y:) 41) tailPosn: 0)
				(pugh
					view: 818
					loop: 0
					cel: 0
					illegalBits: 0
					ignoreActors: 1
					setCycle: Walk
					setMotion: PolyPath 237 153 self
				)
			)
			(6
				(gGame setEgo: (ScriptID 895 0) handsOn:) ; pepper
				(pughT x: 81 y: 107 tailPosn: 1)
				(localproc_0)
				(pughTimer setReal: pughTimer 30)
				(gWalkHandler addToFront: gCurRoom)
				(gMouseDownHandler addToFront: gCurRoom)
				(gKeyDownHandler addToFront: gCurRoom)
				(gDirectionHandler addToFront: gCurRoom)
				(pugh stopUpd:)
				(= local2 1)
				((ScriptID 895 0) stopUpd:) ; pepper
				(SetCursor 100 -5)
				(self dispose:)
			)
		)
	)
)

(instance sPercyFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 895 1) hide:) ; lockjaw
				(percy
					view: 384
					loop: 3
					cel: 0
					posn: 236 158
					setPri: 14
					setScale: 0
				)
				(= cycles 10)
			)
			(1
				(percy setCycle: End self)
			)
			(2
				(song number: 383 loop: -1 pause:)
				(sFX number: 902 play: self)
			)
			(3
				(sFX number: 2105 play:)
				(self setScript: sLockjawFalls)
				(percy
					setLoop: 4
					cel: 0
					posn: 205 135
					setPri: 13
					setSpeed: 9
					setStep: 12 10
					setCycle: Fwd
					setMotion: MoveTo 91 163 self
				)
				(sFX2 number: 3818 play: gCurRoom)
			)
			(4
				(percy setLoop: 6 cel: 0 setCycle: 0 posn: 86 185)
				(= cycles 1)
			)
			(5
				(percy posn: 68 183)
				(= cycles 1)
			)
			(6
				(percy posn: 50 185 setCycle: End self)
			)
			(7 0)
			(8
				(percy view: 397 loop: 2 setPri: 14 stopUpd:)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (and (== (self state:) 7) (not (self script:)))
			(self cue:)
		)
		(super doit:)
	)
)

(instance sLockjawFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
				(= local9 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
			)
			(1
				((ScriptID 895 1) ; lockjaw
					view: 384
					loop: 5
					cel: 0
					posn: 233 171
					show:
					setSpeed: 4
					setCycle: End self
				)
			)
			(2
				((ScriptID 895 1) cel: 3 posn: 203 200 setCycle: CT 4 1 self) ; lockjaw
			)
			(3
				((ScriptID 895 1) normalize: 807 0 posn: 161 189 stopUpd:) ; lockjaw
				(= cycles 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sPughFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame handsOff: points: 375 3)
				(= local3 1)
				(localproc_1)
				(gWalkHandler delete: gCurRoom)
				(gMouseDownHandler delete: gCurRoom)
				(gKeyDownHandler delete: gCurRoom)
				(gDirectionHandler delete: gCurRoom)
				(pughTimer dispose: seconds: 0 delete:)
				(ima stopUpd:)
				(percy stopUpd:)
				((ScriptID 895 0) stopUpd:) ; pepper
				(= cycles 1)
			)
			(2
				((ScriptID 895 0) ; pepper
					normalize: 790 1
					setMotion: MoveTo 267 135 self
				)
			)
			(3
				(gMessager say: 24 7 22 1 self 380) ; "Gimme that wig, poodle head!"
			)
			(4
				((ScriptID 895 0) ; pepper
					view: 385
					loop: 0
					cel: 0
					posn: 254 135
					setCycle: CT 1 1 self
				)
				(pugh view: 389 loop: 0 cel: 0 forceUpd:)
			)
			(5
				(pughT x: 54 y: 100 tailPosn: 1)
				(gMessager say: 24 7 22 2 self 380) ; "My WIG! NOOOOO!"
			)
			(6
				(song pause:)
				(sFX number: 3712 play:)
				((ScriptID 895 0) setCycle: End self) ; pepper
			)
			(7
				(pughT x: 50 y: 108 tailPosn: 1)
				(pugh stopUpd:)
				(gMessager say: 24 7 22 3 self 380) ; "AAAAAAAAAH!"
			)
			(8
				(sFX number: 3812 play: self)
				(pugh posn: 251 156 setScale: 0 setCycle: End self)
			)
			(9 0)
			(10
				((ScriptID 895 0) view: 397 loop: 7 posn: 267 135 stopUpd:) ; pepper
				(sFX number: 3819 play:)
				(client setScript: sPughFallsCont)
			)
		)
	)
)

(instance sPughFallsCont of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wig init:)
				(= cycles 1)
			)
			(1
				(pugh
					loop: 2
					cel: 0
					posn: 101 98
					ignoreActors: 1
					setStep: 12 10
					setSpeed: 9
					setPri: 12
					setCycle: Fwd
					setMotion: MoveTo 87 147 self
				)
				(wig
					ignoreActors: 1
					setLoop: 1
					setSpeed: 9
					setStep: 12 10
					setCycle: Fwd
					setMotion: MoveTo 98 152 self
				)
			)
			(2 0)
			(3
				(wig setCycle: 0 stopUpd: dispose:)
				(pugh
					view: 397
					loop: 3
					cel: 0
					posn: 58 186
					setCycle: 0
					setPri: 14
					stopUpd:
				)
				(song number: 384 loop: 1 play: self)
				((ScriptID 895 1) stopUpd:) ; lockjaw
			)
			(4
				(sFX number: 3817 loop: 1 play: self)
			)
			(5
				(= ticks 8)
			)
			(6
				(sFX play: self)
			)
			(7
				(= ticks 8)
			)
			(8
				(sFX play: self)
			)
			(9
				(= ticks 8)
			)
			(10
				(sFX play: self)
			)
			(11
				(gMessager say: 20 0 19 0 self 380) ; "What's going on in there! In the name of the King, I demand you let me in!"
			)
			(12
				(pughT x: 41 y: 143 tailPosn: 0)
				((ScriptID 2018 1) ; imaText
					x: (- (ima x:) 1)
					y: (- (ima y:) 37)
					tailPosn: 0
				)
				(percyT x: 80 y: 160 tailPosn: 0)
				(butlerT x: 38 y: 93 tailPosn: 0)
				(= local0 1)
				((ScriptID 895 1) ignoreActors: 0 addToPic:) ; lockjaw
				((ScriptID 895 0) normalize: 790 1) ; pepper
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sJarOnPugh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame handsOff: points: 376 4)
				(= local4 1)
				(localproc_1)
				(gWalkHandler delete: gCurRoom)
				(gMouseDownHandler delete: gCurRoom)
				(gKeyDownHandler delete: gCurRoom)
				(gDirectionHandler delete: gCurRoom)
				(pughTimer dispose: seconds: 0 delete:)
				((ScriptID 895 0) stopUpd:) ; pepper
				(= cycles 1)
			)
			(2
				(gMessager say: 24 54 0 1 self 380) ; "I hope you get a charge out of this, Pugh-face!"
			)
			(3
				((ScriptID 895 0) ; pepper
					normalize: 790 1
					setMotion: MoveTo 266 142 self
				)
			)
			(4
				((ScriptID 895 0) ; pepper
					view: 385
					loop: 1
					cel: 0
					posn: 263 143
					setScale: 0
					setCycle: CT 5 1 self
				)
			)
			(5
				(song pause:)
				(sFX number: 3813 play:)
				(= cycles 1)
			)
			(6
				(pugh view: 385 loop: 2 cel: 0 posn: 233 154 setCycle: End self)
			)
			(7
				((ScriptID 895 0) setCycle: End self) ; pepper
			)
			(8
				(pughT x: 64 y: 106 talkWidth: 150 tailPosn: 1)
				(gMessager say: 24 54 0 2 self 380) ; "Yadayadayadayada!"
			)
			(9
				(sFX number: 3812 play: self)
				(pugh
					view: 389
					loop: 0
					cel: 3
					posn: 223 171
					setScale: 0
					setCycle: End self
				)
			)
			(10
				(gEgo view: 397 loop: 7 put: 18) ; Glass_Jar
				(sFX number: 3819 play:)
				(client setScript: sPughFallsCont)
			)
		)
	)
)

(instance sGetDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 27 0 31 0 self 380) ; "Pepper needs to answer the door before it's too late!"
			)
			(2
				(gEgo setHeading: 180 setMotion: MoveFwd 10 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetDoorL of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 27 0 31 0 self 380) ; "Pepper needs to answer the door before it's too late!"
			)
			(2
				(gEgo setHeading: 270 setMotion: MoveFwd 10 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveMoneyBag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 20 0 34 0 self 380) ; "Pepper doesn't have time to go wandering around! She has to come up with some evidence against General Pugh!"
			)
			(2
				(gEgo
					setHeading: (+ (gEgo heading:) 180)
					setMotion: MoveFwd 10 self
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLetBenIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 377 2)
				(= cycles 1)
			)
			(1
				(gMessager say: 3 7 18 0 self 380) ; "Okay, Ben, here ya go!"
			)
			(2
				((ScriptID 895 0) setMotion: MoveTo 146 162 self) ; pepper
			)
			(3
				(sFX number: 922 loop: 1 play:)
				(frontdoors
					view: 392
					loop: 0
					cel: 0
					posn: 37 154
					setPri: 4
					approachVerbs: 0
					setCycle: CT 4 1 self
				)
			)
			(4
				(ben init:)
				(frontdoors setCycle: End self)
			)
			(5
				((ScriptID 895 0) view: 397 loop: 7 stopUpd:) ; pepper
				(song number: 385 loop: -1 play:)
				(ben setCycle: Walk setMotion: MoveTo 121 131 self)
			)
			(6
				(deb
					init:
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 86 138 self
				)
			)
			(7
				(deb loop: 8 cel: 2 posn: 97 129 addToPic:)
				(frontdoors ignoreActors: 1 addToPic:)
				((ScriptID 895 0) stopUpd:) ; pepper
				(ben setHeading: 180)
				(pughT x: 48 y: 140 tailPosn: 0)
				(gMessager say: 20 0 20 1 4 self 380) ; "You, sir, are guilty of imposing false taxes on the good people of Philadelphia!"
			)
			(8
				(ben stopUpd:)
				(pugh view: 399 loop: 0 setCycle: End self)
			)
			(9
				(percyT x: 95 y: 146 tailPosn: 0)
				(percy view: 439 loop: 1 posn: 92 189 setCycle: End self)
				(pugh
					view: 818
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 95 162 self
				)
			)
			(10 0)
			(11
				(pughT x: 78 y: 115 tailPosn: 0)
				(pugh view: 397 loop: 6 stopUpd:)
				(percy view: 397 loop: 5 stopUpd:)
				(pughT x: 105 y: 111 tailPosn: 0)
				(gMessager say: 20 0 20 5 6 self 380) ; "Enough is enough! You, sir, are WRONG! I would never do such a thing. If you and your rabble don't leave now, I shall have to resort to force!"
			)
			(12
				(ben view: 386 loop: 3 cel: 0 setCycle: End self)
			)
			(13
				(ben stopUpd:)
				(gMessager say: 20 0 20 7 9 self 380) ; "But I do, you fatwit! It's right here! A letter from the King himself, saying the Stamp Tax was NOT passed! You, sir, are a liar and an embezzler!"
			)
			(14
				(gMessager say: 20 0 20 10 self 380) ; "|c1|You beast! You stole our money! It's taxation without representation! You tax us silly, but you don't represent our rights to Parliament!|c|"
				(sFX number: 927 play:)
			)
			(15
				(ben setCycle: Beg self)
			)
			(16
				(ben addToPic:)
				(gWalkHandler addToFront: gCurRoom)
				(gMouseDownHandler addToFront: gCurRoom)
				(gKeyDownHandler addToFront: gCurRoom)
				(gDirectionHandler addToFront: gCurRoom)
				(pughT x: 105 y: 111 tailPosn: 0)
				(= register 10)
				(= cycles 2)
			)
			(17
				(if (< (++ register) 17)
					(-- state)
					(gMessager say: 20 0 20 register self 380)
				else
					(= cycles 2)
				)
			)
			(18
				(gEgo normalize: 790 1)
				(gEgo state: (& (gEgo state:) $fffd))
				(moneyTimer setReal: moneyTimer 30)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sVicarShowsMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(wig
					view: 394
					setLoop: 3
					cel: 0
					posn: 235 127
					init:
					setCycle: Walk
					setMotion: MoveTo 169 141 self
				)
			)
			(2
				(wig addToPic:)
				(gMessager say: 20 0 21 0 self 380) ; "I found plenty of "evidence"! Money from our own pockets! The blasted thief had it in his safe!"
			)
			(3
				(self setScript: sDragOut self)
			)
			(4
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance sShowMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== register 1)
					(gGame points: 378 3)
				)
				(gEgo put: 39) ; Bag_Of_Money
				(moneyTimer dispose: seconds: 0 delete:)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 394
					setLoop: 0
					cel: 0
					setSpeed: 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gMessager say: 26 79 0 1 self 380) ; "I've got your proof right here!"
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(self setScript: sDragOut self)
			)
			(5
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance sDragOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(!= ((ScriptID 895 0) x:) 146) ; pepper
						(!= ((ScriptID 895 0) y:) 162) ; pepper
					)
					((ScriptID 895 0) setMotion: PolyPath 146 162 self) ; pepper
				else
					(= cycles 1)
				)
			)
			(1
				(pughT x: 68 y: 105 tailPosn: 0)
				(gMessager say: 26 79 0 2 4 self 380) ; "Look! It's our money!"
			)
			(2
				(snatcher init: setCycle: CT 4 1 self)
			)
			(3
				(pugh dispose:)
				(snatcher setCycle: CT 7 1 self)
			)
			(4
				(gMessager say: 26 79 0 5 self 380) ; "Put me down, you stinkard!"
			)
			(5
				(snatcher setCycle: End self)
			)
			(6
				(snatcher hide:)
				(percy
					view: 819
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 93 150 self
				)
			)
			(7
				(snatcher
					view: 387
					loop: 0
					cel: 0
					posn: 60 152
					init:
					show:
					setCycle: CT 3 1 self
				)
			)
			(8
				(percyT x: 78 y: 115 tailPosn: 0)
				(gMessager say: 26 79 0 6 self 380) ; "Heeeelp! I'm innocent! General Pugh made me do it all!"
			)
			(9
				(percy dispose:)
				(snatcher setCycle: End self)
			)
			(10
				(sFX number: 3820 loop: 1 play:)
				(snatcher
					view: 387
					loop: 2
					cel: 0
					posn: 78 162
					init:
					setCycle: CT 5 1 self
				)
			)
			(11
				(ima dispose:)
				(snatcher setCycle: CT 8 1 self)
			)
			(12
				(gMessager say: 26 79 0 7 self 380) ; "Daddeeeeeeeeeee! HEEEEELP!"
			)
			(13
				(sFX number: 3821 play:)
				(snatcher setCycle: End self)
			)
			(14
				(snatcher dispose:)
				(= register 10)
				(= cycles 2)
			)
			(15
				(if (< (++ register) 17)
					(-- state)
					(gMessager say: 26 79 0 register self 380)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sImaNoticesLockjawOnStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) stopUpd:) ; pepper
				((ScriptID 895 1) view: 3971 loop: 1 stopUpd:) ; lockjaw
				(= cycles 1)
			)
			(1
				(butler
					posn: 169 127
					view: 820
					init:
					loop: 2
					cel: 0
					setCycle: Walk
					setMotion: PolyPath 170 176 self
				)
			)
			(2
				(butler stopUpd:)
				(ima view: 832 posn: 169 124 init:)
				(= cycles 1)
			)
			(3
				(ima
					loop: 0
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 99 172 self
				)
			)
			(4
				(Face ima butler self)
			)
			(5
				((ScriptID 2018 1) x: (- (ima x:) 1) y: (- (ima y:) 37)) ; imaText
				(gMessager say: 20 0 10 0 self 380) ; "You! What are you doing with my doggie! Get away from him!"
			)
			(6
				(= global199 14)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance sWrongTimeDyePot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 19 7 2 1 self 380) ; "BRING ME MY DOGGIE LEASH!"
			)
			(2
				(gCurRoom vanishingY: 81)
				(butler
					view: 820
					posn: 330 51
					setLoop: 1
					init:
					setScale: Scaler 102 75 79 52
					setCycle: Walk
					setMotion: MoveTo 292 54 self
				)
			)
			(3
				(gMessager say: 19 7 2 2 5 self 380) ; "Uh, where is it, Miss?"
			)
			(4
				(= global199 15)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance sNotGetPercy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= cycles 1)
			)
			(1
				(percy
					setScale: 0
					setCycle: Walk
					setMotion: MoveTo 258 135 self
				)
			)
			(2
				((ScriptID 895 1) hide:) ; lockjaw
				(percy
					view: 384
					loop: 8
					cel: 0
					posn: 281 134
					setCycle: CT 1 1 self
				)
			)
			(3
				((ScriptID 895 0) hide:) ; pepper
				(percy setCycle: CT 2 1 self)
			)
			(4
				(percy setCycle: End self)
			)
			(5
				((ScriptID 2004 0) ; LockjawTalker
					winX: 134
					winY: 103
					talkWidth: 100
					tailPosn: 1
				)
				(gMessager say: 20 0 15 0 self 380) ; "GOT YOU! You wretched little nippers!"
			)
			(6
				(= global199 17)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance sNotGetPugh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= cycles 1)
			)
			(1
				(pugh setScale: 0 setMotion: MoveTo 251 145 self)
			)
			(2
				(pugh
					view: 395
					loop: 0
					cel: 0
					posn: 238 141
					setCycle: CT 3 1 self
				)
			)
			(3
				(gEgo hide:)
				(pugh setCycle: End self)
			)
			(4
				(pughT x: 71 y: 92 tailPosn: 1)
				(gMessager say: 20 0 32 0 self 380) ; "GOT YOU, you little rodent!"
			)
			(5
				(= global199 18)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance sDyePotExpires of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 180 53 self)
			)
			(2
				(gEgo setHeading: 90)
				(dyePotTimer seconds: 1)
				(self dispose:)
			)
		)
	)
)

(instance sDontLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 20 0 33 0 self 380) ; "Lockjaw just got out of the hallways. He doesn't want to go back in there and get lost again!"
			)
			(2
				(gEgo setHeading: 180 setMotion: MoveFwd 10 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitMaze of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) ; pepper
					view: 3971
					loop: 0
					setCycle: 0
					setPri: 2
					stopUpd:
				)
				(= cycles 1)
			)
			(1
				(gGame setEgo: (ScriptID 895 1)) ; lockjaw
				(gEgo
					view: 807
					loop: 8
					cel: 2
					posn: 260 52
					setScale: Scaler 102 75 79 52
					ignoreActors: 1
				)
				(= cycles 1)
			)
			(2
				(gMessager say: 20 0 9 0 self 380) ; "Rigormort, you idiot! Hurry up, or the dye will get cold!"
			)
			(3
				(comeInTimer setReal: comeInTimer 30)
				(gGame handsOn:)
				(SetCursor 100 0)
				(self dispose:)
			)
		)
	)
)

(instance percy of Actor
	(properties
		x 169
		y 125
		noun 23
		modNum 380
		view 819
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(if local2
					(gMessager say: 23 6 27 0 0 380) ; "Percy doesn't look so hot. Maybe he's suffering from Post-Traumatic Chomp Syndrome."
				else
					(gMessager say: 23 6 24 0 0 380) ; "Percy's mother must have thought he was a beautiful baby, anyway. Maybe. Well, probably not."
				)
			)
			(89 ; Teeth
				(gCurRoom setScript: sTeethOnPercy)
			)
			(34 ; Fleas
				(gMessager say: 23 34 0 0 0 380) ; "Lockjaw gives Percy a little gift: several dozen fleas!"
			)
			(84 ; Trivia
				(gMessager say: 23 84 0 0 0 380) ; "FALSE. There was no real Percy Throttlebottle. However, there HAVE been sleazy little suck-ups like him all through history!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ima of Actor
	(properties
		noun 28
		modNum 380
		view 832
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(if local1
					(gMessager say: 28 6 28 0 0 380) ; "She's really blue! Gee, I think it's an improvement!"
				else
					(gMessager say: 28 6 24 0 0 380) ; "Prissy little snot!"
				)
			)
			(34 ; Fleas
				(gMessager say: 28 34 24 0 0 380) ; "Lockjaw sends a horde of fleas Ima's way. They leap into her petticoats with cries of joy!"
			)
			(84 ; Trivia
				(gMessager say: 28 84 24 0 0 380) ; "FALSE. There was no real Ima Pugh. There have ALWAYS been totally spoiled little snot-nosed brats just like her, though!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance butler of Actor
	(properties
		x 123
		y 118
		noun 21
		modNum 380
		view 380
		loop 4
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gMessager say: 21 84) ; MISSING MESSAGE
				(sFX number: 927 play:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ben of Actor
	(properties
		x 33
		y 156
		noun 26
		modNum 380
		view 817
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(79 ; Bag_Of_Money
				(if (> (moneyTimer seconds:) 0)
					(gCurRoom setScript: sShowMoney 0 1)
				)
			)
			((OneOf theVerb 85 7 6 86 30 89 84) ; Talk, Do, Look, Nose, Paw, Teeth, Trivia
				(super doVerb: theVerb &rest)
			)
			(else
				(gMessager say: 26 19 0 0 0 380) ; "That won't help us, lad. We need proof of the General's wrongdoing!"
			)
		)
	)
)

(instance deb of Actor
	(properties
		x 5
		y 159
		view 841
		signal 16384
	)
)

(instance pugh of Actor
	(properties
		x 168
		y 130
		noun 24
		modNum 380
		view 818
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(cond
					(local3
						(gMessager say: 24 6 26 0 0 380) ; "It's an egg! It's a marble! No wait, it's General Pugh's head!"
					)
					(local4
						(gMessager say: 24 6 25 0 0 380) ; "Hey, it's Extra-Crispy Pugh with Percy on the side!"
					)
					(else
						(gMessager say: 24 6 24 0 0 380) ; "Shoot, that Pugh dude looks like a hyperactive zombie poodle!"
					)
				)
			)
			(7 ; Do
				(if local5
					(= local5 0)
					(gCurRoom setScript: sPughFalls)
				else
					(gMessager say: 24 7 23 0 0 380) ; "Pepper doesn't want to touch General Pugh. She might get wig powder on her hand!"
				)
			)
			(55 ; Glass_Jar [Leyden]
				(if local5
					(= local5 0)
					(gCurRoom setScript: sJarOnPugh)
				else
					(gMessager say: 24 7 23 0 0 380) ; "Pepper doesn't want to touch General Pugh. She might get wig powder on her hand!"
				)
			)
			(79 ; Bag_Of_Money
				(if (> (moneyTimer seconds:) 0)
					(gCurRoom setScript: sShowMoney 0 1)
				)
			)
			(34 ; Fleas
				(gMessager say: 24 34 0 0 0 380) ; "Lockjaw quietly slips General Pugh a healthy infestation of fleas."
			)
			(84 ; Trivia
				(gMessager say: 24 84 0 0 0 380) ; "FALSE. There was no real General Hugh Pugh II. There WERE people just as creepy and greedy as he is, though!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dyePot of Actor
	(properties
		x 204
		y 122
		z 100
		noun 19
		modNum 380
		view 381
		loop 4
		priority 10
		signal 16
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(7 ; Do
				(gGame setScript: sDumpDiePotIma)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wig of Actor
	(properties
		x 171
		y 73
		modNum 380
		view 389
		loop 1
		cel 1
	)
)

(instance pailInKitchen of View
	(properties
		x 178
		y 81
		noun 9
		modNum 380
		view 397
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 9 6 0 0 0 380) ; "It's the kitchen doorway."
			)
			(84 ; Trivia
				(= global215 8)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance snatcher of Prop
	(properties
		x 51
		y 141
		view 387
		loop 1
		signal 16384
	)
)

(instance chandelier of Feature
	(properties
		y 2
		noun 5
		modNum 380
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(if (== gEgo (ScriptID 895 1)) ; lockjaw
					(gMessager say: 5 6 33 0 0 380) ; "Wow, fancy chandelier."
				else
					(gMessager say: 5 6 0 0 0 380) ; "Wow, fancy chandelier. If I were Errol Flynn, I'd swing from it."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance closetDoor of Feature
	(properties
		x 173
		y 26
		noun 22
		modNum 380
		nsTop 1
		nsLeft 146
		nsBottom 51
		nsRight 201
		approachX 197
		approachY 53
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(30 ; Paw
				(if (> (percyTimer seconds:) 0)
					(gMessager say: 22 30 11 0 0 380) ; "Lockjaw wishes he could get into the closet, but the door won't open."
				else
					(if (IsObject comeInTimer)
						(= temp0 1)
					else
						(= temp0 0)
					)
					(comeInTimer dispose: seconds: 0 delete:)
					(gCurRoom setScript: sAtClosetDoor 0 temp0)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorknob of Feature
	(properties
		x 34
		y 149
		noun 3
		modNum 380
		nsTop 116
		nsLeft 28
		nsBottom 122
		nsRight 41
		approachX 45
		approachY 144
		_approachVerbs 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if local0
					(gCurRoom setScript: sLetBenIn)
				else
					(gMessager say: 3 7 17 0 0 380) ; "The door is locked and bolted."
				)
			)
			(84 ; Trivia
				(= global215 8)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance frontdoors of Prop
	(properties
		x 17
		y 147
		noun 2
		modNum 380
		approachX 45
		approachY 144
		_approachVerbs 9
		view 397
		cel 2
		priority 4
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(cond
					(
						(or
							(> (pughTimer seconds:) 0)
							(> (dyePotTimer seconds:) 0)
						)
						(gMessager say: 2 85 17 0 0 380) ; "Hey! Is there anybody out there? Lemme out!"
					)
					((== (self view:) 392)
						(gMessager say: 2 7 35 0 0 380) ; "Pepper doesn't want to touch the colonists. They all look pretty angry."
					)
					(else
						(gCurRoom setScript: sLetBenIn)
					)
				)
			)
			(6 ; Look
				(if (== (self view:) 392)
					(gMessager say: 2 6 35 0 0 380) ; "The colonists look ready to cook up a Pugh stew! Pepper's impressed."
				else
					(gMessager say: 2 6 0 0 0 380) ; "The front doors are made of solid hardwood. They probably weigh a ton."
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
		x 136
		y 84
		noun 6
		modNum 380
		nsTop 75
		nsLeft 130
		nsBottom 93
		nsRight 142
	)
)

(instance pic1 of Feature
	(properties
		x 131
		y 12
		noun 14
		modNum 380
		nsTop 3
		nsLeft 122
		nsBottom 21
		nsRight 141
	)
)

(instance pic2 of Feature
	(properties
		x 288
		y 18
		noun 15
		modNum 380
		nsTop 4
		nsLeft 279
		nsBottom 32
		nsRight 298
	)
)

(instance pic3 of Feature
	(properties
		x 315
		y 16
		noun 16
		modNum 380
		nsTop 4
		nsLeft 312
		nsBottom 29
		nsRight 319
	)
)

(instance pic4 of Feature
	(properties
		x 230
		y 87
		noun 17
		modNum 380
		nsTop 75
		nsLeft 204
		nsBottom 100
		nsRight 256
	)
)

(instance bannister of Feature
	(properties
		noun 8
		modNum 380
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(= global215 61)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance columns of Feature
	(properties
		noun 4
		modNum 380
	)
)

(instance stairs of Feature
	(properties
		noun 7
		modNum 380
	)
)

(instance northKitEFeature of ExitFeature
	(properties
		nsTop 70
		nsLeft 155
		nsBottom 122
		nsRight 188
		cursor 912
		exitDir 1
		modNum 380
		noun 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 9 6 0 0 0 380) ; "It's the kitchen doorway."
			)
			(84 ; Trivia
				(= global215 8)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance upstairsEFeature of ExitFeature
	(properties
		nsLeft 221
		nsBottom 51
		nsRight 262
		cursor 912
		exitDir 1
		modNum 380
		noun 1
	)
)

(instance eastEFeature of ExitFeature
	(properties
		nsTop 68
		nsLeft 308
		nsBottom 189
		nsRight 319
		cursor 913
		exitDir 2
		modNum 380
		noun 1
	)
)

(instance butlerT of BalloonTalker
	(properties
		x 133
		y 95
		talkWidth 160
	)

	(method (init)
		(cond
			((and (gCast contains: butler) (< (butler y:) 65))
				(if (> (butler x:) 290)
					(= x 112)
					(= y 38)
				else
					(= x 42)
					(= y 38)
				)
				(= tailPosn 4)
			)
			((gCast contains: butler)
				(= x (- (butler x:) 8))
				(= y (- (butler y:) 47))
			)
			(else
				(= x 38)
				(= y 93)
			)
		)
		(super init: &rest)
	)
)

(instance pughT of BalloonTalker
	(properties
		talkWidth 160
	)
)

(instance benT of BalloonTalker
	(properties
		x 137
		y 86
		talkWidth 170
	)
)

(instance postal2T of BalloonTalker
	(properties
		x 10
		y 84
		talkWidth 180
	)
)

(instance nellieT of BalloonTalker
	(properties
		x 10
		y 94
		talkWidth 180
	)
)

(instance gluttonT of BalloonTalker
	(properties
		x 10
		y 104
		talkWidth 180
	)
)

(instance percyT of BalloonTalker
	(properties
		x 67
		y 152
		talkWidth 180
	)
)

(instance debbieT of BalloonTalker
	(properties
		x 100
		y 80
		talkWidth 170
	)
)

(instance vicarT of BalloonTalker
	(properties
		x 140
		y 108
		talkWidth 150
	)
)

(instance sentry1 of BalloonTalker
	(properties
		x 5
		y 74
		talkWidth 180
	)
)

(instance sentry2 of BalloonTalker
	(properties
		x 5
		y 84
		talkWidth 180
	)
)

(instance offSrnT of BalloonTalker
	(properties
		x 5
		y 84
		talkWidth 180
	)
)

(instance comeInTimer of Timer
	(properties)

	(method (cue)
		(if (gCurRoom script:)
			((gCurRoom script:) next: sImaNoticesLockjawOnStairs)
		else
			(gCurRoom setScript: sImaNoticesLockjawOnStairs)
		)
	)
)

(instance dyePotTimer of Timer
	(properties)

	(method (cue)
		(if (gCurRoom script:)
			((gCurRoom script:) next: sWrongTimeDyePot)
		else
			(gCurRoom setScript: sWrongTimeDyePot)
		)
	)
)

(instance percyTimer of Timer
	(properties)

	(method (cue)
		((ScriptID 895 1) setMotion: 0) ; lockjaw
		(localproc_1)
		(gWalkHandler delete: gCurRoom)
		(gMouseDownHandler delete: gCurRoom)
		(gKeyDownHandler delete: gCurRoom)
		(gDirectionHandler delete: gCurRoom)
		(if (gCurRoom script:)
			((gCurRoom script:) next: sNotGetPercy)
		else
			(gCurRoom setScript: sNotGetPercy)
		)
	)
)

(instance pughTimer of Timer
	(properties)

	(method (cue)
		((ScriptID 895 0) setMotion: 0) ; pepper
		(localproc_1)
		(gWalkHandler delete: gCurRoom)
		(gMouseDownHandler delete: gCurRoom)
		(gKeyDownHandler delete: gCurRoom)
		(gDirectionHandler delete: gCurRoom)
		(if (gCurRoom script:)
			((gCurRoom script:) next: sNotGetPugh)
		else
			(gCurRoom setScript: sNotGetPugh)
		)
	)
)

(instance moneyTimer of Timer
	(properties)

	(method (cue)
		(cond
			((gCurRoom script:)
				(if (gEgo has: 39) ; Bag_Of_Money
					((gCurRoom script:) next: sShowMoney 0 0)
				else
					((gCurRoom script:) next: sVicarShowsMoney)
				)
			)
			((gEgo has: 39) ; Bag_Of_Money
				(gCurRoom setScript: sShowMoney 0 0)
			)
			(else
				(gCurRoom setScript: sVicarShowsMoney)
			)
		)
	)
)

(instance sFX of Sound
	(properties)
)

(instance sFX2 of Sound
	(properties)
)

(instance song of Sound
	(properties
		flags 1
	)
)

(instance closetDoorCycler of Prop
	(properties
		x 149
		y 51
		modNum 380
		view 440
		loop 5
	)
)

