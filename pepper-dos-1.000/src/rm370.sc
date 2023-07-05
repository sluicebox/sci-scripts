;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 370)
(include sci.sh)
(use Main)
(use ExitFeature)
(use CycleBet)
(use BalloonTalker)
(use ADRoom)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm370 0
	offSrnT 1
	butlerT 2
	pughT 13
	percyY 14
)

(local
	local0
	local1 = 1
	local2
	local3
	local4
	local5
	local6
	local7
)

(instance rm370 of ADRoom
	(properties
		noun 29
		picture 370
		north 360
		east 420
		west 380
		vanishingY -60
		autoLoad 1
	)

	(method (cue)
		((ScriptID 895 0) normalize:) ; pepper
	)

	(method (init)
		(LoadMany rsVIEW 375 370 800 907)
		(gEgo init:)
		(gEgo state: (| (gEgo state:) $0002))
		(gNarrator x: 30 y: 30)
		(switch gPrevRoomNum
			(360
				(gLongSong number: 370 loop: -1 play:)
				(gEgo
					setScale: Scaler 116 71 180 84
					x: 136
					y: 89
					normalize: 790 2
				)
				(gCurRoom setScript: sInThruWindow)
			)
			(610
				(gLongSong number: 370 loop: -1 play:)
				(if (or (== global199 8) (== global199 9))
					(gEgo
						setScale: Scaler 116 71 180 84
						x: 136
						y: 89
						normalize: 790 2
					)
					(gCurRoom setScript: sInThruWindow)
				else
					(gGame setEgo: (ScriptID 895 1)) ; lockjaw
					(gEgo
						x: 114
						y: 121
						normalize: 807 1
						normal: 0
						setScript: 0
					)
					(if (not (or (IsFlag 356) (IsFlag 358) (IsFlag 357)))
						(general
							init:
							view: 370
							loop: 3
							cel: 0
							x: 107
							y: 85
							setPri: 8
						)
						(gEgo state: (& (gEgo state:) $fffd))
						(gWalkHandler addToFront: gCurRoom)
						(gMouseDownHandler addToFront: gCurRoom)
						(gKeyDownHandler addToFront: gCurRoom)
						(gDirectionHandler addToFront: gCurRoom)
						(distractTimer setReal: distractTimer 30)
					else
						(gWalkHandler addToFront: gCurRoom)
						(gMouseDownHandler addToFront: gCurRoom)
						(gKeyDownHandler addToFront: gCurRoom)
						(gDirectionHandler addToFront: gCurRoom)
						(getOutTimer setReal: getOutTimer 30)
					)
					(gEgo state: (& (gEgo state:) $fffd))
					(if (not (gEgo has: 28)) ; King_s_Letter
						(letter init:)
					else
						(= local5 1)
						(gEgo state: (& (gEgo state:) $fffd))
						(gWalkHandler addToFront: gCurRoom)
						(gMouseDownHandler addToFront: gCurRoom)
						(gKeyDownHandler addToFront: gCurRoom)
						(gDirectionHandler addToFront: gCurRoom)
					)
					(if 355
						(= local1 0)
					else
						(= local1 1)
					)
					(SetCursor 100 0)
					(gGame handsOn:)
				)
			)
			(west
				(gEgo normalize: x: -4 y: 110)
				(gCurRoom setScript: sEnterFromStairs)
			)
			(371
				(gEgo
					x: 70
					y: 88
					setScale: Scaler 116 71 180 84
					normalize: 790 1
				)
				(smallSafe init:)
				(gLongSong number: 370 loop: -1 play:)
			)
			(else
				(gLongSong number: 372 loop: -1 play:)
				((ScriptID 895 1) normal: 0) ; lockjaw
				(gGame setEgo: (ScriptID 895 1)) ; lockjaw
				(gEgo x: 122 y: 75 normalize: 807 1 normal: 0 setScript: 0)
				(if
					(and
						(not (gEgo has: 28)) ; King_s_Letter
						(or (IsFlag 356) (IsFlag 358) (IsFlag 357))
					)
					(letter init:)
				)
				(if (and (== gAct 4) (not (IsFlag 355)))
					(slipperTimer setReal: slipperTimer 300)
				)
				(gEgo loop: 1 x: 227 y: 93)
				(gCurRoom setScript: sLockJawEnters)
			)
		)
		(if (== gEgo (ScriptID 895 0)) ; pepper
			(LoadMany rsPIC 371 372 373)
		)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 0 189 0 176 0 114 12 114 12 180 299 184 291 131 208 99 249 95 243 91 202 96 179 86 66 91 47 109 0 107
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 152 97 216 115 213 125 182 135 164 124 75 138 47 127 63 109 85 92 121 92
					yourself:
				)
		)
		(fireplace init:)
		(if local1
			(slipper init:)
		)
		(if (== gEgo (ScriptID 895 0)) ; pepper
			(if (not (gEgo has: 37)) ; Notepad
				(notePad init:)
			)
			(if (not (gEgo has: 38)) ; Pencil
				(pencil init:)
				(pencilFea init:)
			)
		)
		(if (IsFlag 154)
			(imaPicture view: 375 loop: 0 cel: 0 posn: 69 88 ignoreActors: 1)
			(smallSafe init:)
		)
		(imaPicture init: stopUpd:)
		(if (IsFlag 153)
			(openSafe init:)
		)
		(glasses init:)
		(westExitFeature init:)
		(if (== gEgo (ScriptID 895 1)) ; lockjaw
			(eastExitFeature init:)
		)
		(bench init: setOnMeCheck: 1 4096)
		(book1 init:)
		(book2 init: setOnMeCheck: 1 2048)
		(book3 init: setOnMeCheck: 1 1024)
		(book4 init: setOnMeCheck: 1 512)
		(book5 init: setOnMeCheck: 1 256)
		(book6 init: setOnMeCheck: 1 128)
		(candles init:)
		(chair init: setOnMeCheck: 1 64)
		(chandelier init: setOnMeCheck: 1 8192)
		(desk init: setOnMeCheck: 1 32)
		(doorway init:)
		(if (== gEgo (ScriptID 895 0)) ; pepper
			(fireGoing init: setCycle: Fwd)
		)
		(inkwell init:)
		(panelsA init:)
		(panelsB init:)
		(pictureA init:)
		(pictureB init:)
		(if (not (IsFlag 358))
			(powderJarFea init:)
			(powderJar init: stopUpd:)
		)
		(vase init: setOnMeCheck: 1 16384)
		(wigstand init: setOnMeCheck: 1 8)
		(window370 init:)
	)

	(method (dispose)
		(gWalkHandler delete: gCurRoom)
		(gMouseDownHandler delete: gCurRoom)
		(gKeyDownHandler delete: gCurRoom)
		(gDirectionHandler delete: gCurRoom)
		(distractTimer dispose: delete:)
		(getOutTimer dispose: delete:)
		(slipperTimer dispose: delete:)
		(gLongSong fade:)
		(super dispose:)
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
			)
			(cond
				((== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(cond
						(
							(and
								(not (gUser controls:))
								(not (gUser input:))
							)
							(event claimed: 1)
						)
						((and (not local0) (> (distractTimer seconds:) 0))
							(= local3 1)
							(distractTimer seconds: 1)
						)
						(
							(and
								(or
									(fireplace onMe: event)
									(eastExitFeature onMe: event)
								)
								((ScriptID 895 1) has: 28) ; lockjaw, King_s_Letter
							)
							(self setScript: sLeaveWithLetter 0 2)
							(event claimed: 1)
						)
						((and (gEgo has: 28) local5) ; King_s_Letter
							(self setScript: sPercyGotYou)
							(event claimed: 1)
						)
					)
				)
				((and (not (gUser controls:)) (not (gUser input:)))
					(event claimed: 1)
				)
				((and ((ScriptID 895 1) has: 28) local5) ; lockjaw, King_s_Letter
					(self setScript: sPercyGotYou)
					(event claimed: 1)
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script)
			((& temp0 $0002)
				(cond
					((and (== gEgo (ScriptID 895 1)) (gEgo has: 28)) ; lockjaw, King_s_Letter
						(gCurRoom newRoom: 410)
					)
					(
						(and
							(== gEgo (ScriptID 895 1)) ; lockjaw
							(not (gEgo has: 28)) ; King_s_Letter
							(or (IsFlag 356) (IsFlag 358) (IsFlag 357))
						)
						(gCurRoom newRoom: 420)
					)
					((and (== gEgo (ScriptID 895 1)) (not (gEgo has: 28))) ; lockjaw, King_s_Letter
						(gCurRoom setScript: sStillScoping)
					)
					((== gEgo (ScriptID 895 0)) ; pepper
						(gCurRoom setScript: sOops)
					)
					(else
						(gCurRoom newRoom: 420)
					)
				)
			)
			((& temp0 $0004)
				(if (== gEgo (ScriptID 895 1)) ; lockjaw
					(gCurRoom setScript: sNotYet)
				else
					(gCurRoom newRoom: west)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		((ScriptID 895 1) setScript: (ScriptID 838 0) 0 0) ; lockjaw, LockjawStuff
		(super newRoom: newRoomNumber)
	)
)

(instance sInThruWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 174 101 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 32 118 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLockJawEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setHeading: 270 setMotion: MoveFwd 30 self)
			)
			(2
				(gEgo normalize: 807 1)
				(if (or (IsFlag 356) (IsFlag 358) (IsFlag 357))
					(slipperTimer dispose: delete:)
					(client setScript: sPercyGotYou)
				else
					(= cycles 1)
				)
			)
			(3
				(gGame handsOn:)
				(SetCursor 100 0)
				(self dispose:)
			)
		)
	)
)

(instance sNotYet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 33 0 19 0 self) ; "Lockjaw smells the butler out there! He decides to stay in the study for now."
			)
			(2
				(gEgo setHeading: 90 setMotion: MoveFwd 20 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sChewSlippersFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(slipper dispose:)
				(sFX number: 949 play:)
				(gEgo setMotion: MoveTo 124 123 self)
				(= local7 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
			)
			(1
				(gEgo setHeading: 135)
				(= cycles 3)
			)
			(2
				(gEgo
					view: 378
					setSpeed: 8
					loop: 4
					cel: 0
					setCycle: End self
				)
			)
			(3
				(sFX number: 905 play: self)
				(gEgo setCycle: CycleBet 5 13)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gEgo view: 370 loop: 1 cel: 0 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sGoUnderDesk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 33 0 11 0 self) ; "Lockjaw hears a noise outside the door. He decides to hide."
			)
			(1
				(gEgo setMotion: MoveTo 124 123 self)
			)
			(2
				(gEgo setHeading: 135)
				(= cycles 3)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sPercyCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(slipperTimer dispose:)
				(= cycles 1)
			)
			(2
				(gEgo setMotion: PolyPath 114 121 self)
			)
			(3
				(if local4
					(self setScript: sGoUnderDesk self)
				else
					(self setScript: sChewSlippersFirst self)
				)
			)
			(4
				(general init: setCycle: Walk)
				(= cycles 1)
			)
			(5
				(general setMotion: PolyPath 56 96 self)
			)
			(6
				(general setHeading: 270)
				(= seconds 1)
			)
			(7
				(general
					view: 371
					loop: 0
					cel: 0
					x: 57
					y: 107
					setCycle: End self
				)
				(sFX number: 3702 play:)
				(imaPicture hide:)
			)
			(8
				(imaPicture
					view: 370
					loop: 2
					cel: 0
					posn: 57 112
					show:
					stopUpd:
				)
				(= cycles 1)
			)
			(9
				(general loop: 1 cel: 0 posn: 57 99 setCycle: End self)
			)
			(10
				(openSafe init: stopUpd:)
				(sFX number: 3703 play:)
				(= seconds 2)
			)
			(11
				(general loop: 2 cel: 0 posn: 69 100 setCycle: End self)
			)
			(12
				(sFX number: 3715 play:)
				(= seconds 2)
			)
			(13
				(general
					view: 365
					loop: 3
					cel: 0
					posn: 107 104
					setCycle: End self
				)
			)
			(14
				(= seconds 2)
			)
			(15
				(general
					loop: 4
					cel: 0
					setPri: (+ (general priority:) 1)
					posn: 107 85
					setCycle: CT 5 1 self
				)
			)
			(16
				(sFX number: 3715 play:)
				(general setCycle: End self)
			)
			(17
				(general setCycle: CT 5 1 self)
			)
			(18
				(sFX play:)
				(general setCycle: End self)
			)
			(19
				(general setCycle: CT 5 1 self)
			)
			(20
				(sFX play:)
				(general setCycle: End self)
			)
			(21
				(general stopUpd:)
				(percy init: setCycle: Walk setMotion: PolyPath 44 120 self)
			)
			(22
				(general stopUpd:)
				(percy setMotion: PolyPath 65 110 self)
			)
			(23
				(percy stopUpd:)
				(gMessager say: 33 0 12 1 3 self) ; "Good day, sir."
			)
			(24
				(percy setMotion: MoveTo 73 111 self)
			)
			(25
				(percy stopUpd:)
				(gMessager say: 33 0 12 4 self) ; "Oh, bother. The King is probably complaining about my spending again."
			)
			(26
				(percy view: 372 loop: 0 cel: 0 posn: 78 106 setCycle: End self)
			)
			(27
				(percy stopUpd:)
				(general
					view: 372
					loop: 1
					cel: 0
					posn: 106 84
					setPri: 6
					setCycle: End self
				)
			)
			(28
				(general stopUpd:)
				(gMessager say: 33 0 12 5 10 self) ; "No, sir. His Majesty has merely stated that the Stamp Act has not yet been passed, but probably will be in the future."
			)
			(29
				(percy view: 368 loop: 0 cel: 0)
				(general
					view: 368
					loop: 1
					cel: 0
					posn: 115 85
					setPri: 11
					setCycle: End self
				)
			)
			(30
				(general stopUpd:)
				(gMessager say: 33 0 12 11 self) ; "That's a stupid password, but I would expect nothing better from a tiny-brained idiot like you. There, I've written it down so I won't forget it."
			)
			(31
				(letter init: stopUpd:)
				(= cycles 1)
			)
			(32
				(gMessager say: 33 0 12 12 13 self) ; "Percy, you worm, you're excused! Take your mangy carcass out of my study, man!"
			)
			(33
				(percy view: 819 setCycle: Walk setMotion: MoveTo 44 120 self)
				(general
					view: 365
					loop: 3
					cel: 10
					setPri: -1
					posn: 107 104
					setCycle: Beg self
				)
			)
			(34 0)
			(35
				(percy setMotion: MoveTo -15 111 self)
				(sFX number: 3715 play:)
				(general
					view: 371
					loop: 2
					cel: 10
					posn: 69 100
					setPri: -1
					setCycle: Beg self
				)
			)
			(36 0)
			(37
				(percy dispose:)
				(= seconds 1)
			)
			(38
				(openSafe dispose:)
				(= cycles 1)
			)
			(39
				(imaPicture hide:)
				(general
					loop: 0
					cel: (general lastCel:)
					posn: 57 107
					setCycle: Beg self
				)
			)
			(40
				(sFX number: 3702 play: self)
				(imaPicture show: view: 370 loop: 0 cel: 1 posn: 59 95 stopUpd:)
			)
			(41
				(general
					view: 365
					loop: 3
					cel: 0
					posn: 107 104
					setCycle: End self
				)
			)
			(42
				(= seconds 2)
			)
			(43
				(general
					view: 367
					loop: 0
					cel: 0
					posn: 108 82
					setPri: 7
					setCycle: End self
				)
			)
			(44
				(general setCycle: Beg self)
			)
			(45
				(general view: 370 loop: 3 cel: 0 stopUpd:)
				(gMessager say: 33 0 12 14 self) ; "Pugh, you handsome devil, you're simply brilliant! Who else would have thought of imposing a false stamp tax? Ha ha! Ha ha ha! HA HA HA HA!"
			)
			(46
				(gWalkHandler addToFront: gCurRoom)
				(gMouseDownHandler addToFront: gCurRoom)
				(gKeyDownHandler addToFront: gCurRoom)
				(gDirectionHandler addToFront: gCurRoom)
				(gEgo setSpeed: local7 normalize: 807 4)
				(distractTimer setReal: distractTimer 30)
				(= cycles 1)
			)
			(47
				(gEgo state: (& (gEgo state:) $fffd))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBiteGeneral of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 356 2)
				(= local7 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= local0 1)
				(distractTimer dispose: delete:)
				(= cycles 1)
			)
			(1
				(Face gEgo imaPicture self)
			)
			(2
				(gEgo
					view: 362
					setLoop: 3
					cel: 1
					setCycle: 0
					setSpeed: 8
					stopUpd:
				)
				(sFX number: 902 play: self)
			)
			(3
				(general
					view: 362
					loop: 4
					cel: 0
					posn: 104 85
					setCycle: CT 2 1 self
				)
			)
			(4
				(gEgo normalize: 807 7 setSpeed: local7 cel: 0 stopUpd:)
				(general setCycle: CT 5 1 self)
				(sFX number: 2105 play:)
			)
			(5
				(general stopUpd:)
				(= ticks 20)
			)
			(6
				(gMessager say: 28 89 0 0 self) ; "AAAAAAAH! OW! OW! OW!"
			)
			(7
				(general setCycle: End self)
			)
			(8
				(general
					view: 362
					setLoop: 2
					cel: 4
					setCycle: Fwd
					setMotion: MoveTo -20 110 self
				)
			)
			(9
				(getOutTimer setReal: getOutTimer 30)
				(general dispose:)
				(gEgo state: (| (gEgo state:) $0002))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (and (== state 8) (== (general cel:) 0) (== (sFX prevSignal:) -1))
			(sFX number: 4114 loop: 1 play:)
		)
		(super doit:)
	)
)

(instance sPowderGeneral of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 358 4)
				(= local0 1)
				(distractTimer dispose: delete:)
				(= local7 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(if (distractTimer seconds:)
					(= cycles 1)
				else
					(gMessager say: 26 30 6 0 self) ; "Ooh, that would make an AWESOME cloud of powder if Lockjaw knocked it over! He decides to wait for a good reason to dump the wig powder."
					(self dispose:)
				)
			)
			(2
				(gEgo setMotion: MoveTo 125 131 self)
			)
			(3
				(gEgo setMotion: PolyPath 51 128 self)
			)
			(4
				(gEgo stopUpd:)
				(general stopUpd:)
				(gMessager say: 26 30 5 1 2 self) ; "Aaah! It's that horrible beast! How did YOU get in here! Get OUT!"
			)
			(5
				(gEgo
					view: 361
					loop: 0
					setSpeed: 8
					cel: 0
					posn: 71 129
					setCycle: CT 6 1 self
				)
				(sFX number: 3709 play:)
			)
			(6
				(powderJar dispose:)
				(powderJarFea dispose:)
				(gEgo setCycle: CT 7 1 self)
			)
			(7
				(sFX number: 3710 loop: -1 play:)
				(general
					view: 361
					loop: 2
					cel: 0
					posn: 87 101
					setCycle: End self
				)
				(gEgo setCycle: End self)
			)
			(8 0)
			(9
				(pughT winX: 59 winY: 76 tailPosn: 3)
				(general stopUpd:)
				(gEgo stopUpd:)
				(gMessager say: 26 30 5 3 4 self) ; "<Choke! Ack! Gasp! Wheeze!> Aaah! Percy! <Choke!> I've been poisoned!"
			)
			(10
				(gEgo
					setSpeed: local7
					normalize: 807 7
					posn: 63 128
					stopUpd:
				)
				(general
					view: 361
					setLoop: 1
					posn: 64 107
					setCycle: Walk
					setMotion: MoveTo -10 113 self
				)
			)
			(11
				(sFX stop:)
				(general dispose:)
				(gEgo state: (| (gEgo state:) $0002))
				(getOutTimer setReal: getOutTimer 30)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFleaGeneral of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 357 3)
				(= local0 1)
				(distractTimer dispose: delete:)
				(= local7 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(gLongSong fade:)
				(= cycles 1)
			)
			(1
				(gMessager say: 28 34 0 1 2 self) ; "YOU! How did YOU get in here! You wretched mutt!"
			)
			(2
				(sFX number: 910 loop: -1 play:)
				(gEgo
					view: 363
					loop: 5
					setSpeed: 8
					cel: 0
					posn: 122 123
					setCycle: End self
				)
			)
			(3
				(gEgo stopUpd:)
				(sFX number: 3711 loop: -1 play:)
				(general
					view: 363
					loop: 6
					cel: 0
					posn: 109 85
					setSpeed: 3
					setCycle: End self
				)
			)
			(4
				(general setCycle: Beg self)
			)
			(5
				(general setCycle: End self)
			)
			(6
				(general stopUpd:)
				(gMessager say: 28 34 0 3 4 self) ; "Aa! Oo! Ee! Ow! You dreadful, rotten, disease-ridden creature! You've INFESTED me! Ow! Ee!"
			)
			(7
				(general
					view: 818
					setSpeed: 6
					setCycle: Walk
					setMotion: MoveTo -10 113 self
				)
			)
			(8
				(sFX stop:)
				(gEgo setSpeed: local7 normalize: 807 4 stopUpd:)
				(general dispose:)
				(gEgo state: (| (gEgo state:) $0002))
				(gLongSong play:)
				(getOutTimer setReal: getOutTimer 30)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPercyGotYou of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local7 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= ticks 3)
			)
			(1
				(if local3
					(gEgo setPri: -1 setMotion: PolyPath 133 134 self)
				else
					(= ticks 3)
				)
			)
			(2
				(gEgo stopUpd:)
				(if local3
					(gMessager say: 33 0 17 1 self) ; "Wha--? AAAH! It's that hideous hound! PERCY! PERCY!"
				else
					(= ticks 3)
				)
				(gEgo setPri: 11)
			)
			(3
				(gLongSong stop:)
				(sFX number: 373 loop: 1 play:)
				(percy
					init:
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo 89 141 self
				)
				(gEgo setMotion: PolyPath 100 152 self)
			)
			(4 0)
			(5
				(gEgo stopUpd:)
				(if local3
					((ScriptID 2004 0) ; LockjawTalker
						winX: 98
						winY: 137
						talkWidth: 100
						tailPosn: 0
						forceWidth: 1
					)
					(gMessager say: 33 0 17 2 self) ; "YIPE!"
				else
					(= cycles 1)
				)
			)
			(6
				(percy
					view: 374
					loop: 2
					cel: 0
					posn: 83 155
					setSpeed: 8
					setCycle: CT 4 1 self
				)
			)
			(7
				((ScriptID 895 1) hide: stopUpd:) ; lockjaw
				(percy setCycle: CT 12 1 self)
			)
			(8
				(sFX number: 3719 loop: 1 play:)
				(percy setCycle: End self)
			)
			(9
				(gEgo stopUpd:)
				(cond
					(local3
						(= global199 3)
						(= cycles 1)
					)
					(local6
						(percyY winX: 87 winY: 102 talkWidth: 75 tailPosn: 0)
						(gMessager say: 33 0 13 0 self) ; "GOTCHA!"
						(= global199 4)
					)
					((or (IsFlag 356) (IsFlag 358) (IsFlag 357))
						(percyY winX: 71 winY: 104 tailPosn: 0)
						((ScriptID 2004 0) ; LockjawTalker
							winX: 79
							winY: 127
							talkWidth: 100
							tailPosn: 0
							forceWidth: 1
						)
						(gMessager say: 33 0 18 0 self) ; "HA! There you are, you hairy villain! I HAVE YOU!"
						(if (gEgo has: 28) ; King_s_Letter
							(= global199 4)
						else
							(= global199 5)
						)
					)
					(else
						(percyY winX: 87 winY: 102 talkWidth: 75 tailPosn: 0)
						(gMessager say: 33 0 13 0 self) ; "GOTCHA!"
						(= global199 3)
					)
				)
			)
			(10
				(gMessager say: 1 0 19 0 self 610) ; "Due to the terribly gruesome nature of this fight scene, we have decided not to show it. We will return to Pepper's Adventures in Time as soon as the village blacksmith manages to pry Lockjaw's teeth out of Percy's backside."
			)
			(11
				(gEgo setSpeed: local7)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance sLJTakeLetter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 359 2)
				(= local7 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(gEgo
					view: 374
					loop: 0
					cel: 0
					setPri: 13
					setSpeed: 6
					posn: (+ (gEgo x:) 29) (gEgo y:)
					setCycle: CT 3 1 self
				)
			)
			(2
				((ScriptID 895 1) get: 28) ; lockjaw, King_s_Letter
				(letter dispose:)
				(sFX number: 3712 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo stopUpd:)
				(gMessager say: 18 89 0 0 self) ; "Lockjaw takes the letter."
			)
			(4
				(gGame handsOn:)
				(= local5 1)
				(gEgo
					normalize: 807 5
					setPri: 9
					posn: (- (gEgo x:) 29) (gEgo y:)
					setSpeed: local7
				)
				(self dispose:)
			)
		)
	)
)

(instance sLeaveWithLetter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(switch register
					(1
						(gMessager say: 16 30 20 0 self) ; "Lockjaw decides it's time to get out of here!"
					)
					(2
						(gMessager say: 16 3 20 0 self) ; "Lockjaw decides to get the heck out of here!"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gEgo
					view: 379
					loop: 0
					cel: 0
					posn: 179 107
					setPri: 9
					setCycle: CT 4 1 self
				)
			)
			(3
				(gEgo setCycle: End self)
				(sFX number: 953 play: self)
			)
			(4 0)
			(5
				(gCurRoom newRoom: 410)
			)
		)
	)
)

(instance sPawWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local7 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 145 94 self)
			)
			(2
				(gEgo
					view: 374
					loop: 0
					cel: 5
					posn: 144 93
					setSpeed: 6
					setCycle: CT 2 -1 self
				)
			)
			(3
				(gEgo stopUpd:)
				(gMessager say: 36 30 0 0 self) ; "Lockjaw tries, but he can't push the window open."
			)
			(4
				(gEgo normalize: 807 5 setSpeed: local7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sStillScoping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 16 3 21 0 self) ; "Lockjaw doesn't want to leave yet. He's still casing the joint!"
			)
			(2
				(gEgo setHeading: 270 setMotion: MoveFwd 20 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLJSmells of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local7 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(if (OneOf (gEgo cel:) 0 2 3 4 6)
					(= temp0 4)
				else
					(= temp0 3)
				)
				(gEgo
					view: 808
					loop: temp0
					cel: 0
					setSpeed: 5
					setCycle: CT 4 1 self
				)
			)
			(2
				(sFX number: 911 play: self)
				(gEgo setCycle: CycleBet 4 5 -1)
			)
			(3
				(gEgo setCycle: 0 stopUpd:)
				(switch register
					(1
						(gMessager say: 28 86 0 0 self) ; "General Pugh smells like wig powder and too much lilac cologne."
					)
					(2
						(gMessager say: 16 86 0 0 self) ; "The fireplace smells like ashes and wood."
					)
					(3
						(gMessager say: 32 86 0 0 self) ; "MMMMM! Lockjaw can just TASTE the slippers!"
					)
					(4
						(gMessager say: 1 86 0 0 self) ; "The instrument smells like Ima."
					)
					(6
						(gMessager say: 21 86 0 0 self) ; "The paneling smells like wood and glue."
					)
					(7
						(if (gCast contains: general)
							(gMessager say: 26 86 5 0 self) ; "Lockjaw can smell the wig powder from here. It's NASTY! It could probably choke a horse!"
						else
							(gMessager say: 26 86 6 0 self) ; "The jar smells like baby powder and dead flowers. YECH!"
						)
					)
					(8
						(gMessager say: 36 86 0 0 self) ; "The window smells like glass."
					)
					(9
						(gMessager say: 2 86 0 0 self) ; "The bench smells like General Pugh."
					)
					(10
						(gMessager say: 5 86 0 0 self) ; "The book smells like old steak-and-kidney pie. Yum!"
					)
					(11
						(gMessager say: 8 86 0 0 self) ; "The book smells like lots and lots of Pughs."
					)
					(12
						(gMessager say: 7 86 0 0 self) ; "The book smells like silver and gold. The General must have been counting his money on it."
					)
					(13
						(gMessager say: 4 86 0 0 self) ; "The book smells like wig powder and bookworms."
					)
					(14
						(gMessager say: 3 86 0 0 self) ; "It smells like glue, bookworms, and General Pugh."
					)
					(15
						(gMessager say: 6 86 0 0 self) ; "The book smells like stale tobacco. YECH!"
					)
					(16
						(gMessager say: 9 86 0 0 self) ; "The candles smell like faintly rancid tallow. Yummy!"
					)
					(17
						(gMessager say: 10 86 0 0 self) ; "The chair smells like fine Corinthian leather, Percy, and General Pugh."
					)
					(18
						(gMessager say: 13 86 0 0 self) ; "The desk smells like wood polish."
					)
					(19
						(gMessager say: 15 86 0 0 self) ; "Lockjaw can smell the butler out there!"
					)
					(20
						(gMessager say: 35 86 0 0 self) ; "The wig stand smells like wood and General Pugh."
					)
				)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gGame handsOn:)
				(if (== (gEgo loop:) 3)
					(gEgo normalize: 807 1 setSpeed: local7)
				else
					(gEgo normalize: 807 0 setSpeed: local7)
				)
				(self dispose:)
			)
		)
	)
)

(instance sLJPaws of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local7 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 134 135 self)
			)
			(2
				(if (OneOf (gEgo cel:) 0 2 3 4 6)
					(gEgo loop: 1)
				else
					(gEgo loop: 0)
				)
				(gEgo view: 801 setSpeed: 6 setCycle: End self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo stopUpd:)
				(switch register
					(1
						(gMessager say: 32 30 0 0 self) ; "The slippers feel tender and tasty."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(5
				(if (== (gEgo loop:) 0)
					(gEgo normalize: 807 1 setSpeed: local7)
				else
					(gEgo normalize: 807 0 setSpeed: local7)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseSafe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 366 1)
				(ClearFlag 153)
				(= cycles 1)
			)
			(1
				(sFX number: 3706 play:)
				(= cycles 1)
			)
			(2
				(gMessager say: 31 7 10 0 self) ; "I'll just close this puppy back up."
			)
			(3
				(openSafe dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenSafe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 31 7 9 0 self) ; "Now, let's see..."
			)
			(1
				(gGame points: 363 1)
				(= cycles 1)
			)
			(2
				(gCurRoom newRoom: 371)
			)
		)
	)
)

(instance sOops of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 16 3 0 0 self) ; "The fire is lit. Unless she wants to be a roasted chili Pepper, our heroine had better stay out of there."
			)
			(2
				(gEgo setHeading: 270 setMotion: MoveFwd 20 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPlayArmonica of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong fade:)
				(if (or (IsFlag 154) (IsFlag 153))
					(= local2 16)
				else
					(= local2 15)
				)
				(= local7 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(sFX number: 3717 play:)
				(gEgo
					view: 376
					loop: 0
					cel: 0
					posn: 259 117
					setScale: Scaler 116 71 180 84
					setSpeed: 6
					setCycle: Fwd
				)
				(butler init: stopUpd:)
				(= cycles 1)
			)
			(2
				((ScriptID 2000 3) winX: 107 winY: 87 tailPosn: 1) ; PepperTalker
				(gMessager say: 1 7 local2 1 2 self)
			)
			(3
				(sDogHowl play:)
				(= cycles 1)
			)
			(4
				(gEgo setCycle: 0)
				(gMessager say: 1 7 local2 3 self)
			)
			(5
				(gEgo setCycle: Fwd)
				(sFX number: 373 loop: 1 play:)
				(butler
					setCycle: Walk
					setSpeed: 3
					setMotion: PolyPath 187 139 self
				)
			)
			(6
				(butler setMotion: MoveTo 223 122 self)
			)
			(7
				(gEgo setCycle: 0 stopUpd:)
				(gMessager say: 1 7 local2 4 6 self)
			)
			(8
				(butler hide:)
				(gEgo
					view: 376
					loop: 2
					cel: 0
					setScale: 0
					posn: 238 119
					setCycle: End self
				)
			)
			(9
				((ScriptID 2000 3) winX: 91 winY: 127 tailPosn: 4) ; PepperTalker
				(gEgo stopUpd:)
				(gMessager say: 1 7 local2 7 8 self)
			)
			(10
				(gEgo loop: 3 cel: 0 posn: 223 130 setCycle: End self)
			)
			(11
				((ScriptID 2000 3) winX: 61 winY: 127 tailPosn: 4) ; PepperTalker
				(gEgo stopUpd:)
				(gMessager say: 1 7 local2 9 self)
			)
			(12
				((ScriptID 2000 3) winX: 0 winY: 0) ; PepperTalker
				(if (or (IsFlag 154) (IsFlag 153))
					(= global199 8)
					(gCurRoom newRoom: 610)
				else
					(gCurRoom newRoom: 390)
				)
			)
		)
	)
)

(instance sTakePictureOffWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(gGame handsOff: points: 362 1)
				(SetFlag 154)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 70 88 self)
			)
			(2
				(gEgo setHeading: 270)
				(= cycles 2)
			)
			(3
				(gEgo stopUpd:)
				((ScriptID 2000 3) forceWidth: 1 talkWidth: 200) ; PepperTalker
				(gMessager say: 25 7 4 0 self) ; "YECH! I hate to touch this thing. It's COVERED with ugly!"
			)
			(4
				(gEgo
					view: 375
					loop: 2
					cel: 0
					x: 70
					y: 88
					setSpeed: 7
					setCycle: End self
				)
				((ScriptID 2000 3) forceWidth: 0) ; PepperTalker
				(imaPicture hide:)
				(smallSafe init:)
				(sFX number: 3702 play:)
			)
			(5
				(imaPicture
					view: 375
					loop: 0
					cel: 0
					posn: 69 88
					ignoreActors: 1
					show:
					stopUpd:
				)
				(= cycles 1)
			)
			(6
				(gEgo normalize: setSpeed: local7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPutPictureBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 367 1)
				(= local7 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(ClearFlag 154)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 70 88 self)
			)
			(2
				(gEgo setHeading: 270)
				(= cycles 2)
			)
			(3
				(gEgo stopUpd:)
				(gMessager say: 25 7 3 0 self) ; "I'd better cover my tracks..."
			)
			(4
				(gEgo
					view: 375
					loop: 2
					cel: 9
					x: 70
					y: 88
					setSpeed: 7
					setCycle: Beg self
				)
				(imaPicture hide:)
			)
			(5
				(sFX number: 3702 play:)
				(imaPicture
					view: 370
					loop: 0
					cel: 1
					posn: 57 87
					ignoreActors: 1
					show:
					stopUpd:
				)
				(= cycles 1)
			)
			(6
				(gEgo normalize: setSpeed: local7)
				(if (IsFlag 153)
					(ClearFlag 153)
				)
				(smallSafe dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLookSlippers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 354 1)
				(= cycles 1)
			)
			(1
				(if (== gEgo (ScriptID 895 0)) ; pepper
					(gMessager say: 32 6 2 0 self) ; "Yech! Ratty old slippers!"
				else
					(gMessager say: 32 6 1 0 self) ; "Lockjaw thinks the slippers look mighty tasty."
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetNotePad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 360 1)
				(= cycles 1)
			)
			(1
				(gEgo get: 37 view: 803 loop: 1 cel: 0 setCycle: End self) ; Notepad
			)
			(2
				(gEgo normalize:)
				(notePad dispose:)
				(nameplate init:)
				(gMessager say: 20 7 0 0 self) ; "Hmm, I wonder what that creep writes about."
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sGetPencil of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 361 1)
				(= cycles 1)
			)
			(1
				(gEgo get: 38 view: 803 loop: 0 cel: 0 setCycle: End self) ; Pencil
			)
			(2
				(gEgo normalize:)
				(pencil dispose:)
				(pencilFea dispose:)
				(gMessager say: 22 7 0 0 self) ; "Totally cool, colonial pencils!"
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance general of Actor
	(properties
		x -10
		y 106
		noun 28
		view 818
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; Teeth
				(gCurRoom setScript: sBiteGeneral)
			)
			(34 ; Fleas
				(gCurRoom setScript: sFleaGeneral)
			)
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance percy of Actor
	(properties
		x -15
		y 111
		view 819
	)
)

(instance butler of Actor
	(properties
		x -10
		y 113
		view 820
		loop 2
	)
)

(instance fireplace of Feature
	(properties
		x 214
		y 77
		noun 16
		nsTop 53
		nsLeft 196
		nsBottom 102
		nsRight 232
		sightAngle 40
		approachX 202
		approachY 96
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(if (== gEgo (ScriptID 895 0)) ; pepper
					(gMessager say: 16 6 2) ; "The fire is merrily roaring away in the grate."
				else
					(gMessager say: 16 6 1) ; "That's the way Lockjaw came in."
				)
			)
			(3 ; Walk
				(gCurRoom setScript: sLeaveWithLetter 0 2)
			)
			(30 ; Paw
				(if (not (gEgo has: 28)) ; King_s_Letter
					(gMessager say: 16 3 21) ; "Lockjaw doesn't want to leave yet. He's still casing the joint!"
				else
					(gCurRoom setScript: sLeaveWithLetter 0 1)
				)
			)
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 2)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance letter of View
	(properties
		x 101
		y 87
		noun 18
		sightAngle 40
		approachX 120
		approachY 127
		_approachVerbs 113
		view 370
		cel 5
		priority 10
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; Teeth
				(cond
					((> (getOutTimer seconds:) 0)
						(gCurRoom setScript: sLJTakeLetter)
					)
					((> (distractTimer seconds:) 0)
						(gCurRoom setScript: sPercyGotYou)
					)
					(else
						(gCurRoom setScript: sLJTakeLetter)
					)
				)
			)
			(84 ; Trivia
				(= global215 71)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance slipper of View
	(properties
		x 156
		y 134
		noun 32
		sightAngle 40
		approachX 114
		approachY 121
		_approachVerbs 122
		view 370
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gCurRoom setScript: sLookSlippers)
			)
			(89 ; Teeth
				(gGame points: 355 2)
				(gCurRoom setScript: sPercyCartoon)
			)
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 3)
			)
			(30 ; Paw
				(gCurRoom setScript: sLJPaws 0 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance notePad of View
	(properties
		x 121
		y 83
		noun 20
		approachX 150
		approachY 90
		_approachVerbs 122
		view 370
		cel 2
		priority 10
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: sGetNotePad)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pencilFea of Feature
	(properties
		x 99
		y 86
		noun 22
		nsTop 81
		nsLeft 91
		nsBottom 91
		nsRight 108
		sightAngle 40
		approachX 57
		approachY 124
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(pencil doVerb: theVerb &rest)
	)
)

(instance pencil of View
	(properties
		x 89
		y 86
		noun 22
		approachX 57
		approachY 124
		_approachVerbs 122
		view 370
		cel 3
		priority 10
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: sGetPencil)
			)
			(84 ; Trivia
				(= global215 45)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance glasses of Feature
	(properties
		x 278
		y 102
		noun 1
		nsTop 81
		nsLeft 245
		nsBottom 124
		nsRight 312
		sightAngle 40
		approachX 261
		approachY 119
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gGame points: 368 2)
				(gCurRoom setScript: sPlayArmonica)
			)
			(84 ; Trivia
				(gMessager say: 1 84) ; "|c1|TRUE. Ben Franklin invented this musical instrument, called the Glass Armonica. To play it, you would turn the crank, and gently run your finger along the sides of the glasses to produce high, bell-like tones.|c|"
				(sFX number: 927 play:)
			)
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 4)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance imaPicture of View
	(properties
		x 59
		y 95
		noun 25
		approachX 70
		approachY 88
		_approachVerbs 122
		view 370
		cel 1
		priority 4
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (IsFlag 154)
					(gCurRoom setScript: sPutPictureBack)
				else
					(gCurRoom setScript: sTakePictureOffWall)
				)
			)
			(86 ; Nose
				(gMessager say: 25 86) ; "Lockjaw doesn't want to smell the portrait. It's too realistic."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance smallSafe of Feature
	(properties
		x 43
		y 161
		noun 31
		nsTop 54
		nsLeft 36
		nsBottom 69
		nsRight 50
		sightAngle 40
		approachX 70
		approachY 88
		_approachVerbs 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (IsFlag 153)
					(gCurRoom setScript: sCloseSafe)
				else
					(gCurRoom setScript: sOpenSafe)
				)
			)
			(6 ; Look
				(if (IsFlag 153)
					(gMessager say: 31 6) ; "Oh, wow! A hidden safe!"
				else
					(gCurRoom setScript: sOpenSafe)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance openSafe of Prop
	(properties
		x 39
		y 60
		noun 31
		approachX 70
		approachY 88
		_approachVerbs 9
		view 370
		cel 4
	)

	(method (doVerb theVerb)
		(smallSafe doVerb: theVerb)
	)
)

(instance bench of Feature
	(properties
		y 150
		noun 2
		approachX 210
		approachY 126
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 9)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance book1 of Feature
	(properties
		x 46
		y 168
		noun 5
		nsTop 147
		nsBottom 189
		nsRight 92
		sightAngle 40
		approachX 35
		approachY 149
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 10)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance book2 of Feature
	(properties
		x 116
		y 180
		noun 8
		sightAngle 40
		approachX 116
		approachY 170
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 11)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance book3 of Feature
	(properties
		x 150
		y 180
		noun 7
		sightAngle 40
		approachX 150
		approachY 167
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 12)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance book4 of Feature
	(properties
		x 188
		y 180
		noun 4
		sightAngle 40
		approachX 188
		approachY 166
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 13)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance book5 of Feature
	(properties
		x 233
		y 180
		noun 3
		sightAngle 40
		approachX 233
		approachY 167
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 14)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance book6 of Feature
	(properties
		x 250
		y 180
		noun 6
		sightAngle 40
		approachX 279
		approachY 152
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 15)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance candles of Feature
	(properties
		x 215
		y 42
		noun 9
		nsTop 33
		nsLeft 207
		nsBottom 52
		nsRight 223
		sightAngle 40
		approachX 192
		approachY 99
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 16)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 200
		y 70
		noun 10
		sightAngle 40
		approachX 57
		approachY 124
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 17)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chandelier of Feature
	(properties
		y 10
		noun 11
	)
)

(instance desk of Feature
	(properties
		x 200
		y 50
		noun 13
		sightAngle 60
		approachX 57
		approachY 124
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 18)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorway of Feature
	(properties
		x 16
		y 74
		noun 15
		nsTop 36
		nsBottom 112
		nsRight 32
		sightAngle 40
		approachX 37
		approachY 115
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 19)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fireGoing of Prop
	(properties
		x 220
		y 5
		z -90
		noun 16
		approachX 202
		approachY 96
		_approachVerbs 122
		view 369
	)

	(method (doVerb theVerb)
		(fireplace doVerb: theVerb)
	)
)

(instance inkwell of Feature
	(properties
		x 144
		y 72
		noun 17
		nsTop 69
		nsLeft 134
		nsBottom 84
		nsRight 155
		sightAngle 40
		approachX 157
		approachY 98
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				((ScriptID 895 0) view: 1800) ; pepper
				(gMessager say: 17 7 0 0 gCurRoom) ; "Hey, I could write a letter to my parents... Nah. It would take a LONG time to get there."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance nameplate of Feature
	(properties
		x 121
		y 72
		noun 19
		nsTop 82
		nsLeft 108
		nsBottom 86
		nsRight 135
		sightAngle 40
		approachX 157
		approachY 98
		_approachVerbs 122
	)
)

(instance panelsA of Feature
	(properties
		x 283
		y 40
		noun 21
		nsLeft 258
		nsBottom 80
		nsRight 309
		sightAngle 40
		approachX 215
		approachY 107
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(= global215 68)
				(super doVerb: theVerb &rest)
			)
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 6)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance panelsB of Feature
	(properties
		x 226
		y 25
		noun 21
		nsTop 2
		nsLeft 201
		nsBottom 49
		nsRight 252
		sightAngle 40
		approachX 139
		approachY 88
		_approachVerbs 123
	)

	(method (doVerb theVerb)
		(panelsA doVerb: theVerb)
	)
)

(instance pictureA of Feature
	(properties
		x 161
		y 40
		noun 23
		nsTop 30
		nsLeft 150
		nsBottom 50
		nsRight 173
		sightAngle 40
		approachX 139
		approachY 88
		_approachVerbs 123
	)
)

(instance pictureB of Feature
	(properties
		x 161
		y 63
		noun 24
		nsTop 54
		nsLeft 150
		nsBottom 73
		nsRight 172
		sightAngle 40
		approachX 139
		approachY 88
		_approachVerbs 123
	)
)

(instance powderJar of View
	(properties
		x 82
		y 87
		noun 26
		approachX 59
		approachY 113
		_approachVerbs 123
		view 370
		cel 6
		priority 8
		signal 16400
	)

	(method (doVerb theVerb)
		(powderJarFea doVerb: theVerb)
	)
)

(instance powderJarFea of Feature
	(properties
		x 84
		y 82
		noun 26
		nsTop 73
		nsLeft 72
		nsBottom 91
		nsRight 93
		sightAngle 40
		approachX 59
		approachY 113
		_approachVerbs 123
	)

	(method (doVerb theVerb)
		(switch theVerb
			(30 ; Paw
				(if (gCast contains: general)
					(gCurRoom setScript: sPowderGeneral)
				else
					(gMessager say: 26 30 6) ; "Ooh, that would make an AWESOME cloud of powder if Lockjaw knocked it over! He decides to wait for a good reason to dump the wig powder."
				)
			)
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 7)
			)
			(89 ; Teeth
				(gMessager say: 26 89 5) ; "The LAST thing Lockjaw wants is a mouthful of powder!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vase of Feature
	(properties
		x 330
		y 100
		noun 34
		approachX 213
		approachY 113
		_approachVerbs 122
	)
)

(instance wigstand of Feature
	(properties
		x 268
		y 95
		noun 35
		sightAngle 40
		approachX 162
		approachY 88
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 20)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance window370 of Feature
	(properties
		x 120
		y 49
		noun 36
		nsTop 22
		nsLeft 101
		nsBottom 76
		nsRight 140
		sightAngle 40
		approachX 145
		approachY 94
		_approachVerbs 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(30 ; Paw
				(gCurRoom setScript: sPawWindow)
			)
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 8)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance westExitFeature of ExitFeature
	(properties
		nsTop 49
		nsBottom 126
		nsRight 27
		cursor 911
		exitDir 4
		noun 15
	)
)

(instance eastExitFeature of ExitFeature
	(properties
		nsTop 63
		nsLeft 203
		nsBottom 97
		nsRight 223
		cursor 913
		exitDir 2
		noun 16
	)

	(method (doVerb theVerb)
		(fireplace doVerb: theVerb)
	)

	(method (handleEvent event)
		(cond
			((not (gUser input:)))
			((not (self onMe: gMouseX (- gMouseY 10))))
			(
				(or
					(and (== (event type:) evKEYBOARD) (!= (event message:) KEY_RETURN))
					(and (== (event type:) evMOUSEBUTTON) (event modifiers:))
					(not (OneOf (event type:) evMOUSEBUTTON evKEYBOARD))
				)
				(= lastCursor -1)
			)
			(
				(and
					(== gTheCursor ((gTheIconBar at: 1) cursor:))
					(== gTheIconBar (ScriptID 883 2)) ; pepperIconBar
				)
				(event claimed: 1)
				(gMessager say: noun 6 2) ; "The fire is merrily roaring away in the grate."
			)
			(
				(and
					(== gTheCursor ((gTheIconBar at: 1) cursor:))
					(not (== gTheIconBar (ScriptID 883 2))) ; pepperIconBar
				)
				(event claimed: 1)
				(gMessager say: noun 6 1) ; "That's the way Lockjaw came in."
			)
			((!= gTheCursor cursor))
			(else
				(event claimed: 1)
				(gEgo setMotion: PolyPath 206 96)
			)
		)
	)
)

(instance distractTimer of Timer
	(properties)

	(method (cue)
		(cond
			((and (not local0) (== gEgo (ScriptID 895 1))) ; lockjaw
				(if (gCurRoom script:)
					((gCurRoom script:) next: sPercyGotYou)
				else
					(gCurRoom setScript: sPercyGotYou)
				)
			)
			((and (== gEgo (ScriptID 895 1)) local0) ; lockjaw
				(if (gCurRoom script:)
					((gCurRoom script:) next: sPercyGotYou)
				else
					(gCurRoom setScript: sPercyGotYou)
				)
			)
			(else
				(gEgo state: (| (gEgo state:) $0002))
				(gWalkHandler delete: gCurRoom)
				(gMouseDownHandler delete: gCurRoom)
				(gKeyDownHandler delete: gCurRoom)
				(gDirectionHandler delete: gCurRoom)
			)
		)
	)
)

(instance getOutTimer of Timer
	(properties)

	(method (cue)
		(= local6 1)
		(if (gCurRoom script:)
			((gCurRoom script:) next: sPercyGotYou)
		else
			(gCurRoom setScript: sPercyGotYou)
		)
	)
)

(instance slipperTimer of Timer
	(properties)

	(method (cue)
		(= local4 1)
		(if (gCurRoom script:)
			((gCurRoom script:) next: sPercyCartoon)
		else
			(gCurRoom setScript: sPercyCartoon)
		)
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

(instance sDogHowl of Sound
	(properties
		flags 1
		number 3718
	)
)

(instance pughT of BalloonTalker
	(properties
		x 114
		y 82
		talkWidth 190
		tailPosn 3
	)
)

(instance percyY of BalloonTalker
	(properties
		x 60
		y 88
		talkWidth 180
		tailPosn 3
	)
)

(instance offSrnT of BalloonTalker
	(properties
		x 163
		y 21
		talkWidth 100
		tailPosn 4
	)
)

(instance butlerT of BalloonTalker
	(properties
		x 30
		y 78
		talkWidth 180
		tailPosn 1
	)
)

