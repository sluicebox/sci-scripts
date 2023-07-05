;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Interface)
(use trunk)
(use rmnScript)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm045 0
)

(local
	local0 = 1
)

(procedure (localproc_0)
	(if
		(or
			(== ((gInventory at: 7) owner:) gEgo) ; camera
			(== ((gInventory at: 39) owner:) gEgo) ; scraper
			(== ((gInventory at: 40) owner:) gEgo) ; toothpick
			(== ((gInventory at: 42) owner:) gEgo) ; sampleEnv
		)
		(return 1)
	)
)

(instance rm045 of PQRoom
	(properties
		lookStr {Your normal, everyday scum-filled alley.}
		picture 45
	)

	(method (init)
		(LoadMany rsVIEW 485 20 497 487 492 209)
		(gLongSong number: 913 loop: -1 flags: 1 play:)
		(carfront init: stopUpd:)
		(if (not (IsFlag 29))
			(= global105 18)
		)
		(if (!= gPrevRoomNum 46)
			(HandsOff)
			(gEgo
				normal: 0
				cycleSpeed: 10
				view: 420
				x: (+ (carfront x:) 32)
				y: (+ (carfront y:) 10)
				cel: 0
				init:
			)
			(if (not (IsFlag 80))
				(= global114 -1)
				(cat init:)
				(pat
					cycleSpeed: 6
					moveSpeed: 6
					setCycle: Walk
					setStep: 3 2
					loop: 5
					init:
				)
				(uniform cycleSpeed: 8 setCycle: Walk setStep: 3 2 init:)
				(rubberneck1 init:)
				(rubberneck2 init:)
				(rubberneck3 init:)
				(rubberneck4 init:)
			)
			(proc0_17 15)
			(gCurRoom setScript: enterRoom)
		else
			(gEgo posn: 220 117 init:)
			(if (== global114 86)
				(HandsOff)
				(coroner setScript: coronerArrives init:)
			else
				(coroner init:)
			)
			(cardoor setPri: 8 stopUpd:)
		)
		(super init:)
		(if (not (IsFlag 80))
			(body init:)
			(gAddToPics add: body doit:)
		)
		(windshield init:)
		(dumpster init:)
		(ribbon init:)
		(yellowTape init:)
		(abandoncar init:)
		(lamp init:)
		(garage init:)
		(street init:)
		(backwall init:)
		(buildings init:)
		(trash init:)
		(ribbon setScript: playAndFade)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 146 90 180 111 185 118 170 126 132 103
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 32 76 42 48 91 37 99 31 108 41 153 48 142 89 106 93 112 104 81 109 51 96 43 78
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 241 64 224 61 203 69 165 49 179 32 143 14 136 19 95 3 51 3 49 13 47 33 35 56 0 50 0 189 113 189 165 159 171 159 167 165 177 168 196 168 196 171 158 189 282 189 210 161 253 140 319 158 319 133 276 127 241 141 196 165 183 158 239 120 177 91
					yourself:
				)
		)
	)

	(method (dispose)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(super dispose:)
		(DisposeScript 881)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((and (& temp0 $0020) (== (gEgo script:) 0))
				(self setScript: ribbonRight)
			)
			((and (& temp0 $2000) (== (gEgo script:) 0))
				(self setScript: ribbonLeft)
			)
		)
		(super doit:)
	)
)

(instance playAndFade of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mMurder play: self)
			)
			(1
				(mMurder fade:)
				(= seconds 10)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 5)
			)
			(1
				(= seconds 3)
				(ShowClock 1)
			)
			(2
				(cardoor setCycle: End self)
				(doorOpenSound play:)
			)
			(3
				(gEgo cycleSpeed: 12 ignoreActors: 1 setCycle: End self)
			)
			(4
				(NormalEgo 5 3)
				(gEgo setMotion: MoveTo (gEgo x:) 194 self)
			)
			(5
				(gEgo loop: 3)
				(cardoor setCycle: Beg self)
			)
			(6
				(doorCloseSound play:)
				(cardoor setPri: 8 stopUpd:)
				(gEgo setMotion: MoveTo 240 183 self)
				(if (IsFlag 80)
					(+= state 6)
				else
					(rubberneck1 setMotion: MoveTo 205 189)
					(rubberneck4 setMotion: MoveTo 275 189)
				)
			)
			(7
				(ShowClock 0)
				(= save1 1)
				(Say uniform 45 0) ; "The victim's over there in the dumpster."
				(= seconds 5)
			)
			(8
				(= save1 1)
				(rubberneck1 setCel: 1)
				(rubberneck3 setMotion: MoveTo 221 189)
				(Say uniform 45 1) ; "I called the coroner. He's on his way."
				(= seconds 6)
			)
			(9
				(= save1 1)
				(rubberneck3 setCel: 1)
				(rubberneck1 setCel: 0)
				(rubberneck2 setMotion: MoveTo 243 189)
				(Say uniform 45 2) ; "I'll be posted at the entrance of the alley waiting for the meat wagon if ya need me."
				(= seconds 5)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(uniform setLoop: 6 setCycle: Fwd)
				(= cycles 1)
			)
			(11
				(uniform moveSpeed: 1 setMotion: MoveTo 220 239 self)
				(rubberneck1 moveSpeed: 1 setMotion: MoveTo 205 245)
				(rubberneck2 moveSpeed: 1 setMotion: MoveTo 221 245)
				(rubberneck3 moveSpeed: 1 setMotion: MoveTo 243 245)
				(rubberneck4 moveSpeed: 1 setMotion: MoveTo 266 245)
			)
			(12
				(uniform dispose:)
				(rubberneck1 dispose:)
				(rubberneck2 dispose:)
				(rubberneck3 dispose:)
				(rubberneck4 dispose:)
				(client setScript: patScript)
			)
		)
	)
)

(instance exitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(if
					(or
						(& (gEgo onControl: 1) $0100)
						(& (gEgo onControl: 1) $2000)
						(& (gEgo onControl: 1) $4000)
					)
					(= cycles 1)
					(pat init: posn: 9 113 setScript: patEnterCar self)
				else
					(self setScript: ribbonRight self)
				)
			)
			(2
				(HandsOff)
				(pat init: posn: 9 113 setScript: patEnterCar self)
				(gEgo setMotion: MoveTo (+ (carfront x:) 32) 194 self)
			)
			(3
				(gEgo loop: 3)
				(doorOpenSound play:)
				(cardoor setCycle: End self)
			)
			(4
				(gEgo
					setMotion:
						PolyPath
						(+ (carfront x:) 32)
						(+ (carfront y:) 10)
						self
				)
			)
			(5
				(gEgo
					normal: 0
					view: 420
					cel: 9
					loop: 0
					cycleSpeed: 14
					ignoreActors: 1
					setCycle: Beg self
				)
			)
			(6
				(cardoor setPri: 15 setCycle: Beg self)
			)
			(7
				(doorCloseSound play:)
				(= cycles 1)
			)
			(8)
			(9
				(SetFlag 80)
				(gLongSong fade:)
				(gCurRoom newRoom: 25)
			)
		)
	)
)

(instance patScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= save1 1)
				(Say pat 45 3) ; "I'll do the camera bit, Bonds."
				(pat setPri: 6)
				(= seconds 4)
				(proc0_17 60)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pat setMotion: PolyPath 205 189 self)
			)
			(3
				(ribbon hide:)
				(pat
					view: 492
					loop: 3
					x: 222
					y: 142
					cel: 0
					setPri: -1
					cycleSpeed: 13
					moveSpeed: 13
					setCycle: CT 8 1 self
				)
			)
			(4
				(ribbon show:)
				(pat
					view: 20
					loop: 3
					x: 188
					y: 166
					setPri: 5
					cycleSpeed: 6
					moveSpeed: 6
					setCycle: SyncWalk
					setMotion: MoveTo 166 155 self
				)
			)
			(5
				(pat setMotion: PolyPath 229 119 self)
			)
			(6
				(pat view: 488 loop: 1 setCycle: CT 4 1 self)
			)
			(7
				(sCameraClick play:)
				(= cycles 1)
			)
			(8
				(pat setCycle: End self)
			)
			(9
				(cat
					cycleSpeed: 2
					moveSpeed: 2
					setCycle: Walk
					setMotion: MoveTo 340 94 self
				)
				(= save1 1)
				(Say pat 45 4) ; "Ay, Chihuahua!"
				(= seconds 3)
			)
			(10 0)
			(11
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pat setCycle: CT 4 1 self)
			)
			(12
				(sCameraClick play:)
				(= cycles 1)
			)
			(13
				(pat setCycle: End self)
			)
			(14
				(pat
					view: 20
					setCycle: SyncWalk
					setMotion: PolyPath 175 75 self
				)
			)
			(15
				(pat view: 488 loop: 2 setCycle: CT 5 1 self)
			)
			(16
				(sCameraClick play:)
				(= cycles 1)
			)
			(17
				(pat setCycle: End self)
			)
			(18
				(pat setCycle: CT 5 1 self)
			)
			(19
				(sCameraClick play:)
				(= cycles 1)
			)
			(20
				(pat setCycle: End self)
			)
			(21
				(= save1 1)
				(Say pat 45 5) ; "Ok Sonny, I got them."
				(= seconds 4)
			)
			(22
				(pat view: 20 setCycle: SyncWalk setMotion: PolyPath 9 113 self)
			)
			(23
				(pat dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance patEnterCar of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pat
					view: 20
					setCycle: SyncWalk
					setMotion: PolyPath 178 167 self
					init:
				)
			)
			(1
				(ribbon hide:)
				(pat
					view: 492
					posn: 217 144
					cycleSpeed: 13
					moveSpeed: 13
					setLoop: 2
				)
				(= cycles 1)
			)
			(2
				(pat setCycle: CT 8 1 self)
			)
			(3
				(ribbon show:)
				(pat
					view: 20
					x: 202
					y: 181
					setCycle: Walk
					cycleSpeed: 6
					moveSpeed: 6
					setPri: -1
					setLoop: -1
				)
				(= cycles 1)
			)
			(4
				(pat setMotion: PolyPath 258 147 self)
			)
			(5
				(pat setPri: 6 setMotion: MoveTo 310 162 self)
			)
			(6
				(pat setLoop: 5 posn: (+ (pat x:) 3) (pat y:))
				(= cycles 1)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance coronerArrives of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global114 96)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= cycles 1)
			)
			(1
				(Face gEgo coroner)
				(= save1 1)
				(Say coroner 45 6) ; "Hey Bonds. Nice day, eh? How's the stiff?"
				(= seconds 4)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(Say gEgo 45 7) ; "He's hangin' in there, Leon."
				(= seconds 3)
			)
			(3
				(if
					(and
						(gEgo has: 23) ; license
						(!= ((gInventory at: 23) owner:) gCurRoomNum) ; license
					)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(self setScript: giveLicenseBack self)
				else
					(+= state 2)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(coroner cycleSpeed: 10 setCycle: CT 9 1 self)
					(gEgo get: 23) ; license
					((gInventory at: 23) state: 5) ; license
				)
			)
			(4
				(= save1 1)
				(Say coroner 45 8) ; "I'll take care of him now, Bonds. You can go catch some bad guys."
				(= seconds 7)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
			(6
				(= save1 1)
				(Say coroner 45 9) ; "Hey, looks like he has something in his pocket!"
				(= seconds 6)
			)
			(7
				(coroner setCycle: End self)
			)
			(8
				(= save1 1)
				(Print 45 10) ; "The coroner hands you the license to record in your notebook."
				(= cycles 1)
			)
			(9
				(= save1 1)
				(Say coroner 45 8) ; "I'll take care of him now, Bonds. You can go catch some bad guys."
				(= seconds 7)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveLicenseBack of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(& (gEgo onControl: 1) $0100)
						(& (gEgo onControl: 1) $2000)
						(& (gEgo onControl: 1) $4000)
					)
					(self setScript: ribbonLeft self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 220 117 self)
			)
			(2
				(if (IsFlag 82)
					(Print 45 11) ; "You hand the victim's I.D. to the coroner."
				else
					(Print 45 12) ; "You log the victim's information in your notebook before handing the I.D. to the coroner."
					(SetFlag 82)
				)
				(= cycles 1)
			)
			(3
				(= save1 1)
				(Say coroner 45 13) ; "Ah, not a pretty picture eh? Let me guess - his name isn't 'Lucky'."
				(= seconds 8)
			)
			(4
				(gEgo put: 23 45) ; license
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance ribbonLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 199 188 self)
			)
			(2
				(ribbon hide:)
				(gEgo
					normal: 0
					view: 492
					cycleSpeed: 8
					cel: 0
					setLoop: 1
					posn: 217 145
					setCycle: CT 8 1 self
				)
			)
			(3
				(ribbon show:)
				(gEgo
					view: 5
					loop: 3
					posn: 180 171
					setPri: 5
					cycleSpeed: (gGame egoMoveSpeed:)
					setCycle: SyncWalk
					setMotion: PolyPath 166 143 self
				)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(NormalEgo 5 3)
				(self dispose:)
			)
		)
	)
)

(instance ribbonRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 177 169 self)
			)
			(2
				(ribbon hide:)
				(gEgo
					normal: 0
					view: 492
					cycleSpeed: 8
					cel: 0
					setLoop: 0
					posn: 217 145
					setCycle: CT 8 1 self
				)
			)
			(3
				(ribbon show:)
				(gEgo
					view: 5
					loop: 4
					posn: 201 184
					cycleSpeed: (gGame egoMoveSpeed:)
					setCycle: SyncWalk
					setMotion: PolyPath 226 187 self
				)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(NormalEgo 5 4)
				(self dispose:)
			)
		)
	)
)

(instance doBodyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(not
						(or
							(& (gEgo onControl: 1) $0100)
							(& (gEgo onControl: 1) $2000)
							(& (gEgo onControl: 1) $4000)
						)
					)
					(= cycles 1)
				else
					(self setScript: ribbonLeft self)
				)
			)
			(1
				(gEgo setMotion: PolyPath 220 117 self)
			)
			(2
				(gCurRoom newRoom: 46)
			)
		)
	)
)

(instance doWreckScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(not
						(or
							(& (gEgo onControl: 1) $0100)
							(& (gEgo onControl: 1) $2000)
							(& (gEgo onControl: 1) $4000)
						)
					)
					(= cycles 1)
				else
					(self setScript: ribbonLeft self)
				)
			)
			(1
				(gEgo setMotion: PolyPath 106 93 self)
			)
			(2
				(if (IsFlag 2)
					(Print 45 14) ; "You notice a fresh dent marked with gold paint on this side of the car."
				else
					(Print 45 15) ; "You notice a fresh dent marked with light red paint on this side of the car."
				)
				(carinset init:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance randomTalkCoroner of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(not
						(or
							(& (gEgo onControl: 1) $0100)
							(& (gEgo onControl: 1) $2000)
							(& (gEgo onControl: 1) $4000)
						)
					)
					(= cycles 1)
				else
					(self setScript: ribbonLeft self)
				)
			)
			(1
				(gEgo setMotion: PolyPath 220 117 self)
			)
			(2
				(Face gEgo coroner self)
			)
			(3
				(= save1 1)
				(switch (Random 0 3)
					(0
						(Say coroner 45 16) ; "Did you hear the one about the Orthodox Jewish Coroner and the hotdog salesman?"
						(= seconds 5)
					)
					(1
						(Say coroner 45 17) ; "So I says to her, Aunt Sophie, could we just this once NOT turn this into a funeral already?"
						(= seconds 6)
					)
					(2
						(Say coroner 45 18) ; "So yesterday, I'm eatin' one of my wife's bagels (no lox, 'cause she forgot ta go to the deli), and I'm usin' this napkin. I THINK it's clean, right?..."
						(= seconds 8)
					)
					(3
						(Say coroner 45 19) ; "Your bettin' on WHO in the super bowl?  Are you CRAZY? Are you INSANE? Ya wanna kill yourself, let me do it. It'll be quicker."
						(= seconds 8)
					)
				)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance uniform of Actor
	(properties
		x 215
		y 170
		view 485
		loop 5
		signal 2048
	)
)

(instance pat of Actor
	(properties
		x 290
		y 145
		sightAngle 90
		view 20
	)
)

(instance coroner of Actor
	(properties
		x 238
		y 108
		sightAngle 90
		view 497
		signal 2048
		cycleSpeed 10
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 45 20) ; "That's Leon. He's a great Coroner, but the guy has a sick sense of humor."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 45 21) ; "One murder's enough for this dark alley, don't you think?"
					)
					(19 ; wallet
						(Print 45 22) ; "You really like to flash those credentials, don't you?"
					)
					(23 ; license
						(cond
							((IsFlag 82)
								(gCurRoom setScript: giveLicenseBack)
							)
							(local0
								(Print 45 23) ; "Don't you want to log the information about Andrew Dent in your notebook first?"
								(= local0 0)
							)
							(else
								(gCurRoom setScript: giveLicenseBack)
							)
						)
					)
					(33 ; skinHair
						(Print 45 24) ; "That's nice, Bonds, but I only care for that stuff when it's still on the body. Save it for L.P.D evidence."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(5 ; Talk
				(if (not (trunk showing:))
					(HandsOff)
					(gCurRoom setScript: randomTalkCoroner)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rubberneck1 of Actor
	(properties
		x 205
		y 240
		sightAngle 90
		view 485
		signal 2048
		cycleSpeed 8
	)
)

(instance rubberneck2 of Actor
	(properties
		x 221
		y 240
		sightAngle 90
		view 485
		loop 1
		signal 2048
		cycleSpeed 9
	)
)

(instance rubberneck3 of Actor
	(properties
		x 243
		y 240
		sightAngle 90
		view 485
		loop 3
		signal 2048
		cycleSpeed 9
	)
)

(instance rubberneck4 of Actor
	(properties
		x 266
		y 240
		sightAngle 90
		view 485
		loop 2
		cel 1
		signal 2048
		cycleSpeed 9
	)
)

(instance cat of Actor
	(properties
		x 260
		y 94
		sightAngle 90
		view 487
		signal 2048
	)
)

(instance dumpster of Feature
	(properties
		x 243
		y 85
		sightAngle 90
		onMeCheck 512
		approachX 220
		approachY 117
		_approachVerbs 2
		lookStr {The rusty dumpster contains the corpse of a murdered man. You pray to God that when YOUR time comes you end up someplace more dignified than the trash.}
	)
)

(instance body of PicView
	(properties
		x 251
		y 85
		view 487
		loop 1
		priority 4
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (not (trunk showing:))
					(HandsOff)
					(gCurRoom setScript: doBodyScript)
				)
			)
			(3 ; Do
				(if (not (trunk showing:))
					(HandsOff)
					(gCurRoom setScript: doBodyScript)
				)
			)
			(5 ; Talk
				(Print 45 25) ; "Ah! Would that the dead COULD speak!"
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 45 26) ; "You think about shooting the murder victim, but he's ALREADY DEAD!"
					)
					(19 ; wallet
						(Print 45 27) ; "You identify yourself to the stiff, then contemplate a long vacation."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance windshield of Feature
	(properties
		x 70
		y 56
		nsTop 46
		nsLeft 69
		nsBottom 60
		nsRight 77
		approachX 60
		approachY 90
		_approachVerbs 2
		lookStr {The windshield is marked with the Vehicle Identification Number. It's 127633}
	)
)

(instance abandoncar of Feature
	(properties
		x 113
		y 63
		nsTop 45
		nsBottom 200
		nsRight 200
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 45 28) ; "The car's been abandoned for some time. There's nothing of interest in there."
			)
			(2 ; Look
				(if (not (trunk showing:))
					(HandsOff)
					(gCurRoom setScript: doWreckScript)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance carinset of View
	(properties
		x 86
		y 93
		sightAngle 90
		view 486
		priority 15
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 2)
					(Print 45 29) ; "It's the abandoned white car. The dent contains gold paint."
				else
					(Print 45 30) ; "It's the abandoned white car. The dent contains light red paint."
				)
			)
			(4 ; Inventory
				(cond
					((gEgo has: 31) ; goldPaint
						(Print 45 31) ; "You don't need another sample."
					)
					((and (== invItem 39) (gEgo has: 42)) ; scraper, sampleEnv
						(sScraper play:)
						(if (IsFlag 2)
							(Print 45 32) ; "You carefully scrape some of the gold paint transfer from the side of the white car along with a little white paint into the envelope."
						else
							(Print 45 33) ; "You carefully scrape some of the light red paint transfer from the side of the white car along with a little white paint into the envelope."
						)
						(gEgo get: 31) ; goldPaint
						(SetScore 153 5)
					)
					((and (gEgo has: 39) (gEgo has: 42)) ; scraper, sampleEnv
						(Print 45 34) ; "You need to use the proper field equipment to take a clean paint sample."
					)
					(else
						(Print 45 35) ; "You don't have the field equipment necessary to take a clean paint sample."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(if
			(and
				(!= (gEgo x:) 106)
				(!= (gEgo y:) 93)
				(gCast contains: carinset)
			)
			(carinset dispose:)
		)
	)
)

(instance backwall of Feature
	(properties
		onMeCheck 2
		lookStr {The alley is a dead end - appropriate in this case.}
	)
)

(instance street of Feature
	(properties
		onMeCheck 28708
		lookStr {The back alley asphalt is cracked and filthy. Weeds have struggled through in several places.}
	)
)

(instance buildings of Feature
	(properties
		x 119
		y 182
		onMeCheck 1024
		lookStr {This part of town is full of typical American brick tenements.}
	)
)

(instance trash of Feature
	(properties
		x 170
		y 75
		onMeCheck 8
		lookStr {An alley is a lousy place to die.}
	)
)

(instance lamp of Feature
	(properties
		onMeCheck 16512
		lookStr {It's a street lamp.}
	)
)

(instance garage of Feature
	(properties
		nsLeft 135
		nsBottom 39
		nsRight 186
		onMeCheck 256
		lookStr {The garage door is closed and locked.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 45 36) ; "You don't need to worry about the garage."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance yellowTape of Feature
	(properties
		x 216
		y 145
		onMeCheck 16
		lookStr {The yellow tape marks off the crime scene and prevents curiosity-seekers from getting too close.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 45 37) ; "The uniformed officer will remove the tape when the body has been removed and the crime lab is finished with the area."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ribbon of Prop
	(properties
		x 215
		y 145
		sightAngle 90
		lookStr {The yellow tape marks off the crime scene and prevents curiosity-seekers from getting too close.}
		view 492
		cel 9
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 45 37) ; "The uniformed officer will remove the tape when the body has been removed and the crime lab is finished with the area."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance carfront of View
	(properties
		x 235
		y 169
		lookStr {You look fondly at your car.}
		view 209
		loop 2
		priority 8
		signal 16657
	)

	(method (init)
		(trunk x: 225 y: 187 marked: 0 init: close:)
		(cardoor posn: (+ x 14) (+ y 23) 30 loop: 3 cel: 0 init:)
		(carmiddle posn: (+ x 33) (+ y 20) loop: 2 cel: 1 init:)
		(carback approachVerbs: 3 posn: (+ x 80) (+ y 20) init:) ; Do
		(super init:)
	)
)

(instance carmiddle of View
	(properties
		lookStr {You look fondly at your car.}
		view 209
		loop 2
		cel 1
		priority 8
		signal 16657
	)
)

(instance carback of View
	(properties
		approachX 283
		approachY 187
		lookStr {It's the trunk of your car.}
		view 209
		loop 2
		cel 2
		priority 8
		signal 16657
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(trunk open:)
			)
			(else
				(carfront doVerb: theVerb)
			)
		)
	)
)

(instance cardoor of Prop
	(properties
		view 209
		loop 3
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cond
					((gEgo has: 23) ; license
						(Print 45 38) ; "You need to give the license to the coroner first."
					)
					((localproc_0)
						(Print 45 39) ; "You need to put the field equipment back into the trunk first."
					)
					((!= ((gInventory at: 23) owner:) 45) ; license
						(Print 45 40) ; "You're not finished with your investigation."
					)
					(else
						(ClearFlag 63)
						(gCurRoom setScript: exitRoom)
					)
				)
			)
		)
	)
)

(instance mMurder of Sound
	(properties
		flags 1
		number 450
		loop -1
	)
)

(instance sCameraClick of Sound
	(properties
		flags 1
		number 451
	)
)

(instance sStreetFX of Sound ; UNUSED
	(properties
		flags 1
		number 913
		loop -1
	)
)

(instance sScraper of Sound
	(properties
		flags 1
		number 938
	)
)

(instance doorOpenSound of Sound
	(properties
		flags 1
		number 900
	)
)

(instance doorCloseSound of Sound
	(properties
		flags 1
		number 901
	)
)

